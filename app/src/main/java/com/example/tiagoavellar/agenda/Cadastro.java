package com.example.tiagoavellar.agenda;

/**
 * Created by Tiago Avellar on 29/09/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.*;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.squareup.picasso.Picasso;


public class Cadastro extends AppCompatActivity implements CadastroView{

    @BindView(R.id.button6) Button button6;
    @BindView(R.id.button18) Button button18;
    //variaveis dos campos em branco
    @BindView(R.id.txt_nome) EditText txt_nome;
    @BindView(R.id.txt_endereco) EditText txt_endereco;
    @BindView(R.id.txt_email) EditText txt_email;
    @BindView(R.id.txt_telefone) EditText txt_telefone;
    @BindView(R.id.foto) public ImageView campoFoto;
    String teste;
    BancoDados db;

    private static final int CODIGO_CAMERA = 123;
    public String caminhoFoto;

    CadastroPresenter cadastroPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        ButterKnife.bind(this);
        this.db = new BancoDados(this);

        cadastroPresenter = new CadastroPresenter(this);
    }

    @OnClick(R.id.button18)
    public void CadastraUsuario(){
        cadastroPresenter.login(txt_nome.getText().toString(),txt_endereco.getText().toString(),txt_email.getText().toString(),
                txt_telefone.getText().toString());
        }

        @OnClick(R.id.button6)
        public void EntraLogin(){
            Intent it = new Intent(Cadastro.this, Menu.class);
            startActivity(it);
        }

    @Override
    public void sucessoCadastro(String nome,String endereco, String email,String telefone){
        //db.CadastraCliente(new Cliente(txt_nome.getText().toString(),txt_endereco.getText().toString(),txt_email.getText().toString(),
          //txt_telefone.getText().toString(),txt_obs.getText().toString()));
        this.db = new BancoDados(this);
      teste = db.CadastraCliente(new Cliente(nome,email,endereco,telefone));
        Toast.makeText(Cadastro.this, teste, Toast.LENGTH_LONG).show();
        Intent it = new Intent(Cadastro.this, Menu.class);
        startActivity(it);
    }
    @Override
    public void falhoCadastro(){
        Toast.makeText(Cadastro.this, "Falta dados para o Cadastro ", Toast.LENGTH_LONG).show();
        Intent it = new Intent(Cadastro.this, Cadastro.class);
        startActivity(it);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CODIGO_CAMERA && resultCode == Activity.RESULT_OK) {
            exibeFoto();
        }
    }

    @OnClick(R.id.button10)
    public void tiraFoto(){
        Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        caminhoFoto = getExternalFilesDir(null) + "/" + System.currentTimeMillis() + ".jpg";
        File arquivoFoto = new File(caminhoFoto);
        intentCamera.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(arquivoFoto));
        startActivityForResult(intentCamera, CODIGO_CAMERA);
    }

    private void exibeFoto(){
        Picasso.with(this)
                .load("file://"+caminhoFoto)
                .fit()
                .centerCrop()
                .into(campoFoto);
    }
}
    /*



    //Teste do Crud
        //adicionando
        db.addCliente(new Cliente("Tiago","551910", "tiagoalpaca@gmail.com"));
        db.addCliente(new Cliente("Alessandra", "552038", "alesouza.camargo@gmail.com"));
        db.addCliente(new Cliente("Muriel", "551111", "murielmauch@gmail.com"));
        db.addCliente(new Cliente("Benzelara", "551111", "benzelara@gmail.com"));

        //apagando
        Cliente cliente = new Cliente();
        cliente.setCodigo(3);
        db.apagarCliente(cliente);

        //selecionando
        Cliente cliente = new Cliente();
        cliente.setCodigo(4);
        db.selecionarCliente(cliente);

        Log.d("Cliente Selecionado", "Codigo" + cliente.getCodigo() + " Nome" + cliente.getNome() + "Identificacao" + cliente.getIdentificao()
        + " Email" + cliente.getEmail());

        //Atualizando
        Cliente cliente = new Cliente();
        cliente.setCodigo(4);
        cliente.setNome("Alexandra Lara");
        cliente.setIdentificao("551817");
        cliente.setEmail("alexandrelara@gmail.com");

        public void listar


        Toast.makeText(Cadastro.this,"Salvo com Sucesso",Toast.LENGTH_LONG).show();
        Toast.makeText(Cadastro.this,"Apagado com Sucesso",Toast.LENGTH_LONG).show();
        Toast.makeText(Cadastro.this,"Selecionado com Sucesso",Toast.LENGTH_LONG).show();
        Toast.makeText(Cadastro.this,"Alterado com Sucesso",Toast.LENGTH_LONG).show();

*/





