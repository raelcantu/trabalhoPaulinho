package com.example.trabalhopaulinho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trabalho.models.Produto;

public class CadastroProdutoActivity extends AppCompatActivity {

    private EditText edCodigo;
    private EditText edValor;
    private EditText edDescricao;
    private Button btCadastrarProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);

        edCodigo = findViewById(R.id.edCodigo);
        edValor = findViewById(R.id.edValor);
        edDescricao = findViewById(R.id.edDescricao);
        btCadastrarProduto = findViewById(R.id.btCadastrarProduto);

        btCadastrarProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarProduto();
            }
        });

    }

    private void salvarProduto(){
        if(edCodigo.getText().toString().isEmpty()){
            edCodigo.setError("Informe o código do produto");
            return;
        }
        if(edDescricao.getText().toString().isEmpty()){
            edDescricao.setError("Informe a descrição do produto");
            return;
        }
        if(edValor.getText().toString().isEmpty()){
            edValor.setError("Informe o valor do produto");
            return;
        }

        Produto produto = new Produto();
        produto.setCodigo(edCodigo.getText().toString());
        produto.setDescricao(edDescricao.getText().toString());
        produto.setPreco(edValor.getText().toString());

        Controller.getInstance().salvarProduto(produto);

        Toast.makeText(CadastroProdutoActivity.this,
                "Produto Cadastrado!",
                Toast.LENGTH_LONG).show();

        this.finish();

    }


}