package com.example.trabalhopaulinho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

import com.example.trabalho.models.Cliente;
import com.example.trabalho.models.Produto;

public class LancamentoPedidoActivity extends AppCompatActivity {

    private ArrayList<Cliente> listaClientes;
    private ArrayList<Produto> listaProdutos;
    private Spinner spCliente;
    private Spinner spProduto;
    private Button btSalvar;
    private int posicao = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancamento_produto);

        spCliente = findViewById(R.id.spCliente);
        spProduto = findViewById(R.id.spProduto);
        btSalvar = findViewById(R.id.btSalvar);

        spProduto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i>0){
                    posicao = i;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        carregarClientes();
        carregarProdutos();
    }

    private void carregarClientes() {
        listaClientes = Controller.getInstance().retornarClientes();

        String[] vetClientes = new String[listaClientes.size() + 1];

        vetClientes[0] = "Selecione o cliente";

        for (int i = 0; i < listaClientes.size(); i++) {
            Cliente cli = listaClientes.get(i);
            vetClientes[i + 1] = cli.getNome() + " - " + cli.getCpf();
        }

        ArrayAdapter adapter = new ArrayAdapter(LancamentoPedidoActivity.this,
                android.R.layout.simple_dropdown_item_1line, vetClientes);
        spCliente.setAdapter(adapter);
    }

    private void carregarProdutos() {
        listaProdutos = Controller.getInstance().retornaProdutos();

        String[] vetProdutos = new String[listaProdutos.size() + 1];

        vetProdutos[0] = "Selecione um produto";

        for (int i = 0; i < listaProdutos.size(); i++) {
            Produto pro = listaProdutos.get(i);
            vetProdutos[i + 1] = pro.getCodigo() + " - " + pro.getDescricao() + " - " + pro.getPreco() + "R$";
        }

        ArrayAdapter adapter = new ArrayAdapter(LancamentoPedidoActivity.this,
                android.R.layout.simple_dropdown_item_1line, vetProdutos);
        spProduto.setAdapter(adapter);
    }

}