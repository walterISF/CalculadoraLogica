package calculadoralogica;

import java.io.*;
import calculadoralogica.Fila;
import calculadoralogica.Pilha;

public class ConversorPosFixa {
    
    private String[] expressao;
    private String[] partes;
    private String[] x;
    Fila fila;
    Pilha pilha;
    Fila filaResult;
    Pilha pilhaResult;
    
    
ConversorPosFixa(String[] expressao) 
{
 this.expressao = expressao;
}

public Fila Converte() throws Exception
{  
    pilha = new Pilha();
    fila = new Fila();
    x = new String[1];
   
    for(int i=0; i<expressao.length;i++)
    {
        
        /*if(expressao[i].equals("("))
        {
           pilha.adicionar(expressao[i], expressao);
        }
        if(expressao[i].equals("T")||expressao[i].equals("F"))
        {
            fila.inserir(expressao[i], expressao);
        }*/
        
        int j = i;
        switch(expressao[i]){
        
            case "(": pilha.adcionar(expressao[i]);
                      break;
                      
            case "T": fila.guarde(expressao[i]);
                      break;
                      
            case "F": fila.guarde(expressao[i]);
                      break;
                      
            case "~": if(pilha.acessar(x).equals("^") || pilha.acessar(x).equals("v") || pilha.acessar(x).equals("-") || pilha.acessar(x).equals("<") || pilha.acessar(x).equals(")")) 
                      {
                          pilha.retirar(x);
                          fila.guarde(expressao[i]);
                      } 
                      pilha.adcionar(expressao[i]);
                      break;
                                
            case "^": if(pilha.acessar(x).equals("^") || pilha.acessar(x).equals("v") || pilha.acessar(x).equals("-") || pilha.acessar(x).equals("<") || pilha.acessar(x).equals(")")) 
                      {
                          pilha.retirar(x);
                          fila.guarde(expressao[i]);
                      }
                      pilha.adcionar(expressao[i]);
                      break;
                
            case "v": if(pilha.acessar(x).equals("v") || pilha.acessar(x).equals("-") || pilha.acessar(x).equals("<") || pilha.acessar(x).equals(")")) 
                      {
                          pilha.retirar(x);
                          fila.guarde(expressao[i]);
                      }
                      pilha.adcionar(expressao[i]);
                      break;
                
            case "-": if(pilha.acessar(x).equals("-") || pilha.acessar(x).equals("<") || pilha.acessar(x).equals(")")) 
                      {
                          pilha.retirar(x);
                          fila.guarde(expressao[i]);
                      }
                      pilha.adcionar(expressao[i]);
                      break;
            
            case "<": if(pilha.acessar(x).equals("-") || pilha.acessar(x).equals("<") || pilha.acessar(x).equals(")")) 
                      {
                          pilha.retirar(x);
                          fila.guarde(expressao[i]);
                      }
                      pilha.adcionar(expressao[i]);
                      break;
            case ")": if(expressao[i].equals(")"))
                      {
                          while(expressao[j].equals("("))
                          {
                              pilha.retirar(x);
                              fila.guarde(expressao[i]);
                              j++;
                          }
                      }
           
            default: 
        }
    }
    return fila;
}
    
} 



