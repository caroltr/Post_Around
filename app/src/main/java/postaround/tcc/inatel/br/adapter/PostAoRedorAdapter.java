package postaround.tcc.inatel.br.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.login.widget.ProfilePictureView;

import java.util.ArrayList;

import postaround.tcc.inatel.br.model.PostAoRedor;
import postaround.tcc.inatel.br.postaround.R;


/**
 * Created by Daivid on 30/08/2015.
 */
public class PostAoRedorAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<PostAoRedor> postAoRedorArrayList;

    private TextView tituloDescricao;
    private TextView comentarioDescricao;
    private TextView nomeUsuario;
    private ProfilePictureView fotoProfile;
    private ImageView fotoPost;

    public  PostAoRedorAdapter(Context context, ArrayList<PostAoRedor> listaPostAoRedor){
        this.context = context;
        this. postAoRedorArrayList = listaPostAoRedor;
    }

    @Override
    public int getCount() {
        return postAoRedorArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return postAoRedorArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        PostAoRedor post = postAoRedorArrayList.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view =  inflater.inflate(R.layout.rows_post_ao_redor, null);


        tituloDescricao = (TextView) view.findViewById(R.id.textView_descricao_post_post_redor);
        comentarioDescricao = (TextView) view.findViewById(R.id.textView_comentario_post_post_redor);
        nomeUsuario = (TextView) view.findViewById(R.id.textView_nome_usuario_post_redor);
        fotoProfile = (ProfilePictureView) view.findViewById(R.id.imagemview_profile_picture_post_redor);
        fotoPost = (ImageView) view.findViewById(R.id.imageView_post_picture_post_redor);

        tituloDescricao.setText(post.getTituloDescricao());
        comentarioDescricao.setText(post.getComentarioDescricao());
        fotoProfile.setProfileId(post.getIdUsuario());
        nomeUsuario.setText(post.getNomeUsuario());
        return view;
    }
}
