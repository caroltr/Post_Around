package postaround.tcc.inatel.br.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.login.widget.ProfilePictureView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import postaround.tcc.inatel.br.Util.UserInformation;
import postaround.tcc.inatel.br.Utils.CircleImage;
import postaround.tcc.inatel.br.model.Post;
import postaround.tcc.inatel.br.model.PostAoRedor;
import postaround.tcc.inatel.br.postaround.R;



/**
 * Created by Daivid on 01/09/2015.
 */
public class MeuPostAdapter extends RecyclerView.Adapter<MeuPostAdapter.ViewHolder>{

    private Context context;
    private List<Post> meuPostArrayList;

    private TextView tituloDescricao;
    private TextView comentarioDescricao;
    private TextView nomeUsuario;
    private ImageView fotoProfile;
    private ImageView fotoPost;

    public  MeuPostAdapter(Context context, List<Post> listaMeuPost){
        this.context = context;
        this.meuPostArrayList = listaMeuPost;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTitulo;
        public TextView mDescricao;
        public TextView mUserName;
        public CardView cv;
        public ImageView fotoProfile;
        public ImageView mImagemPost;

        public ViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv_meu_post);
            mTitulo = (TextView) cv.findViewById(R.id.meu_post_titulo);
            mImagemPost = (ImageView) cv.findViewById(R.id.imageView_post_picture_meu_post);
            mDescricao = (TextView) cv.findViewById(R.id.post_nomeUsuario);
            mUserName = (TextView) cv.findViewById(R.id.meu_post_nomeUsuario);
            fotoProfile = (ImageView) cv.findViewById(R.id.imagemview_profile_picture_meu_post);
        }
    }

    @Override
    public MeuPostAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rows_meu_post, parent, false);


        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(MeuPostAdapter.ViewHolder holder, int position) {
        Post post = meuPostArrayList.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view =  inflater.inflate(R.layout.rows_meu_post, null);


        Picasso.with(context).load(post.getImage_url()).placeholder(R.drawable.tcc).fit().centerCrop().into(holder.mImagemPost);


        //ProfilePictureView profilePictureView = (ProfilePictureView) view.findViewById(R.id.imagemview_profile_picture_post_redor);
        // profilePictureView.setProfileId(post.getUser_id());

        Picasso.with(context).load(("https://graph.facebook.com/" + UserInformation.user_id + "/picture?type=large")).transform(new CircleImage()).into(holder.fotoProfile);


        holder.mDescricao.setText(post.getDescription());
        holder.mUserName.setText(UserInformation.user_name);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return meuPostArrayList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
