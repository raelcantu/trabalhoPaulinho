package com.example.trabalhopaulinho;

import java.util.ArrayList;
import com.example.trabalho.models.Cliente;
import com.example.trabalho.models.Produto;

public class Controller {

    private static Controller instancia;
    private final ArrayList<Cliente> listaClientes;
    private final ArrayList<Produto> listaProdutos;

    public static Controller getInstance(){
        if(instancia == null) {
            return instancia = new Controller();
        }else {
            return instancia;
        }
    }

    private Controller(){
        listaClientes = new ArrayList<>();
        listaProdutos = new ArrayList<>();
    }

    public void salvarCliente(Cliente cliente){
        listaClientes.add(cliente);
    }

    public ArrayList<Cliente> retornarClientes() {
        return listaClientes;
    }

    public void salvarProduto(Produto produto){
        listaProdutos.add(produto);
    }

    public ArrayList<Produto> retornaProdutos() {
        return listaProdutos;
    }
}
