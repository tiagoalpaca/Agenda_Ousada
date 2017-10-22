package com.example.tiagoavellar.agenda;

/**
 * Created by Tiago Avellar on 29/09/2017.
 */
import android.content.ContentValues;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.*;
import android.content.*;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class BancoDados extends SQLiteOpenHelper {

    //private static final int VERSAO_BANCO = 1 - 10;
    //private static final String BANCO_CLIENTE = "bd_reserva"-bd;
    private static final int VERSAO_BANCO = 121;
    private static final String BANCO_CLIENTE = "bd-agenda";

    //DADOS DOS clientes
    private static final String TABELA_CLIENTE = "td_cliente";
    private static final String COLUNA_IDCliente = "cliente";
    private static final String COLUNA_NOME = "nome";
    private static final String COLUNA_EMAIL = "email";
    private static final String COLUNA_ENDERECO = "endereco";
    private static final String COLUNA_TELEFONE = "telefone";
    private static final String COLUNA_OBSERVACAO = "observacao";

    //criar banco de dados
    private static final String QUERY_COLUNACLIENTE = "CREATE TABLE " + TABELA_CLIENTE + "(" + COLUNA_IDCliente + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUNA_NOME + " TEXT," + COLUNA_EMAIL + " TEXT" + COLUNA_ENDERECO + " TEXT" + COLUNA_TELEFONE + " TEXT" + COLUNA_OBSERVACAO + " TEXT)";

    public BancoDados(Context context) {
        super(context, BANCO_CLIENTE, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(QUERY_COLUNACLIENTE);


        try {

        } catch (Exception error) {
            Log.e(BANCO_CLIENTE, "downloadDatabase Error: ", error);

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP IF TABLE EXISTS" + TABELA_CLIENTE);
        onCreate(db);
    }

    //Cadastra o cliente no sistema usando a classe modelo
    public String CadastraCliente(Cliente cliente) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUNA_NOME, cliente.getNome());
        values.put(COLUNA_EMAIL, cliente.getEmail());
        values.put(COLUNA_ENDERECO, cliente.getEndereco());
        values.put(COLUNA_TELEFONE, cliente.getTelefone());
        values.put(COLUNA_OBSERVACAO, cliente.getObservacao());

        db.insert(BancoDados.TABELA_CLIENTE, null, values);
        db.close();

        String sucesso ="O Cadastro foi feito com Sucesso";
        return sucesso;
    }

    public String BuscaCliente(Cliente cliente) {
        SQLiteDatabase db = this.getReadableDatabase();

        String VerNome = "select nome from " + TABELA_CLIENTE;
        //String ExibeContato = "select * from " + TABELA_CLIENTE;
        Cursor cursor = db.rawQuery(VerNome, null);
        //Cursor cursor1 = db.rawQuery(ExibeContato,null);
        String username;
        username = "Nao encontrado";

        if (cursor.moveToFirst()) {
            do {
                username = cursor.getString(0);
                if (username.equals(cliente.getNome())) {
                    return username;
                }
            } while (cursor.moveToNext());
        }
        return username;
    }

    public String DeletaContato(Cliente cliente) {
        SQLiteDatabase db = this.getWritableDatabase();
        String mensagem="Contato deletado com sucesso";

        db.delete(TABELA_CLIENTE, COLUNA_NOME + " = ?", new String[]{cliente.getNome()});
        db.close();
        return mensagem;
    }

    public void atualizaContato(Cliente cliente){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUNA_NOME, cliente.getNome());
        values.put(COLUNA_EMAIL, cliente.getEmail());
        values.put(COLUNA_ENDERECO, cliente.getEndereco());
        values.put(COLUNA_TELEFONE, cliente.getTelefone());
        values.put(COLUNA_OBSERVACAO, cliente.getObservacao());

        db.update(TABELA_CLIENTE, values, COLUNA_NOME + " = ?", new String[] {cliente.getNome()});
    }

    public ArrayList MostraLista(){
        ArrayList<String> lista = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String VerNome = "select nome from " + TABELA_CLIENTE;
        Cursor cursor = db.rawQuery(VerNome, null);

        if (cursor.moveToFirst()) {
            do {
                lista.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        return lista;
    }

}
