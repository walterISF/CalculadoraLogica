/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoralogica;

import java.util.*;

public class Pilha {
    
    private int tamMax;
    private String[] pilha;
    private int topo;
    
    Pilha(int tam){
        tamMax = tam;
        pilha = new String[tamMax];
        topo = -1;
    }
    
    public void adcionar(String elem){
        pilha[++topo] = elem;
    }
    
    public String retirar(){
        return pilha[topo--];
    }
    
    public String acessar(){
        return pilha[topo];
    }
    
    public Boolean vazia(){
        return (topo == -1);
    }
    
    public Boolean cheia(){
        return (topo == tamMax -1);
    }
}
