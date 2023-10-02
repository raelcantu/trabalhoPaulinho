package com.example.trabalhopaulinho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trabalho.models.Cliente;

public class CadastroClienteActivity extends AppCompatActivity {

    private EditText edNome;
    private EditText edCpf;
    private Button btCadastrarCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);

        edNome = findViewById(R.id.edNome);
        edCpf = findViewById(R.id.edCpf);
        btCadastrarCliente = findViewById(R.id.btCadastrarCliente);

        btCadastrarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SalvarCliente();
            }
        });

    }

    private void SalvarCliente(){
        if(edNome.getText().toString().isEmpty()){
            edNome.setError("Informe o nome do cliente!");
            return;
        }
        if(edCpf.getText().toString().isEmpty()){
            edCpf.setError("Informe o CPF!");
            return;
        }

        Cliente cliente = new Cliente();
        cliente.setCpf(edCpf.getText().toString());
        cliente.setNome(edNome.getText().toString());

        Controller.getInstance().salvarCliente(cliente);

        Toast.makeText(CadastroClienteActivity.this,
                "Cliente Cadastrado!",
                Toast.LENGTH_LONG).show();

        this.finish();

    }

}