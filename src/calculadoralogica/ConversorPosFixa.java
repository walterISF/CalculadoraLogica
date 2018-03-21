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
    String[] teste = new String[1];
    
    for(int i=0; i<expressao.length;i++)
    {
        
        if(expressao[i].equals("("))
        {
           pilha.adicionar(expressao[i], expressao);
        }
        if(expressao[i].equals("T")||expressao[i].equals("F"))
        {
            fila.inserir(expressao[i], expressao);
        }
        
        switch(expressao[i]){
        
            case "~":
            break;
            case "^": 
                if(pilha.acessar(teste).equals("~")) {
                    System.out.println("Teste");
                }
                
            case "v":
                
            case "-":
            
            case "<":
            
        
        
        }
    
    
    
    
    
    
    }
    
    
     
} 
}


