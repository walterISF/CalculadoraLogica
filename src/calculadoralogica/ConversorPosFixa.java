package calculadoralogica;

import java.io.*;
import calculadoralogica.Fila;
import calculadoralogica.Pilha;

public class ConversorPosFixa {
    
    private String[] expressao;
    private String[] partes;
    Fila fila;
    Pilha pilha;
        
ConversorPosFixa(String[] expressao) 
{
 this.expressao = expressao;
}

public void Converte() throws Exception
{  
    pilha = new Pilha(expressao.length, expressao);
    fila = new Fila(expressao.length, expressao);
   
    for(int i=0; i<expressao.length;i++)
    {
        
        if(expressao[i].equals("("))
        {
           pilha.adicionar(expressao[i]);
        }
        if(expressao[i].equals("T")||expressao[i].equals("F"))
        {
            fila.inserir(expressao[i], expressao);
        }
        switch(expressao[i]){
        
            case "~":
                                
            case "^":
                
            case "v":
                
            case "-":
            
            case "<":
            
        
        
        }
    
    
    
    
    
    
    }
    
    
     
} 
}


