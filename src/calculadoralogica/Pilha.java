package calculadoralogica;

import java.util.*;

public class Pilha {
    
    private int tamMax;
    private String[] pilha;
    private int topo = 1;
    
    Pilha(int tam, String[] elem) throws Exception
    {
        if(tam <= 0)
            throw new Exception("Valor invalido");
        
        tamMax = tam;
        pilha = new String[tamMax];
    }
    
    public void adcionar(String elem, String[] pilha) throws Exception
    {   
        if(elem==null)
            throw new Exception("Insira um valor");
        
        if(this.cheia()==true)
          throw new Exception("Pilha Cheia");
              
        pilha[++topo] = elem;
    }
    
    public String retirar(String[] pilha) throws Exception
    {
        if(this.vazia()==true)
            throw new Exception("Pilha Vazia");
        
        return pilha[topo--];
    }
    
    public String acessar(String[] pilha) throws Exception
    {
        if(this.vazia()==true)
            throw new Exception("Pilha Vazia");
        return pilha[topo];
    }
    
    public Boolean vazia(){
        return (topo == -1);
    }
    
    public Boolean cheia(){
        return (topo == tamMax-1);
    }
}