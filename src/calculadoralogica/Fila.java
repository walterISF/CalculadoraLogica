/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoralogica;

/**
 *
 * @author Calebe Carvalho
 */
public class Fila {

    private int inicio=0;
    private int fim=-1;
    private int qtd=0;

    Fila (int capacidade, String[] item) throws Exception
    {

        if(capacidade<=0)
            throw new Exception("Valor invalido");

        item = new String[capacidade];
    }

    void inserir(String elemento, String[] item) throws Exception
    {
        if(elemento==null)
            throw new Exception("Insira umm valor");

        if(qtd==item.length)
            throw new Exception("Fila cheia");

        fim++;
        if(fim==item.length)
            fim=0;

        item[fim] = elemento;
        qtd++;

    }

    String retornarElemento()
    {
        //return item[fim];
        return null;
    }

    String removerElemento(String[] item) throws Exception
    {
        if(qtd==0)
        throw new Exception("Fila vazia");

        item[fim] = null;
        qtd--;

        if(fim==item.length)
            fim=0;
        qtd--;
        
        return null;

    }

}
