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

public void Converte() throws Exception
{  
    pilha = new Pilha(expressao.length, expressao);
    fila = new Fila(expressao.length, expressao);
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
        
            case "(": pilha.adicionar(expressao[i], expressao);
                      break;
                      
            case "T": fila.inserir(expressao[i], expressao);
                      break;
                      
            case "F": fila.inserir(expressao[i], expressao);
                      break;
                      
            case "~": if(pilha.acessar(x).equals("^") || pilha.acessar(x).equals("v") || pilha.acessar(x).equals("-") || pilha.acessar(x).equals("<") || pilha.acessar(x).equals(")")) 
                      {
                          pilha.retirar(x);
                          fila.inserir(x.toString(), expressao);
                      } 
                      pilha.adicionar(expressao[i], expressao);
                      break;
                                
            case "^": if(pilha.acessar(x).equals("^") || pilha.acessar(x).equals("v") || pilha.acessar(x).equals("-") || pilha.acessar(x).equals("<") || pilha.acessar(x).equals(")")) 
                      {
                          pilha.retirar(x);
                          fila.inserir(x.toString(), expressao);
                      }
                      pilha.adicionar(expressao[i], expressao);
                      break;
                
            case "v": if(pilha.acessar(x).equals("v") || pilha.acessar(x).equals("-") || pilha.acessar(x).equals("<") || pilha.acessar(x).equals(")")) 
                      {
                          pilha.retirar(x);
                          fila.inserir(x.toString(), expressao);
                      }
                      pilha.adicionar(expressao[i], expressao);
                      break;
                
            case "-": if(pilha.acessar(x).equals("-") || pilha.acessar(x).equals("<") || pilha.acessar(x).equals(")")) 
                      {
                          pilha.retirar(x);
                          fila.inserir(x.toString(), expressao);
                      }
                      pilha.adicionar(expressao[i], expressao);
                      break;
            
            case "<": if(pilha.acessar(x).equals("-") || pilha.acessar(x).equals("<") || pilha.acessar(x).equals(")")) 
                      {
                          pilha.retirar(x);
                          fila.inserir(x.toString(), expressao);
                      }
                      pilha.adicionar(expressao[i], expressao);
                      break;
            case ")": if(expressao[i].equals(")"))
                      {
                          while(expressao[j] != "(")
                          {
                              pilha.retirar(x);
                              fila.inserir(x.toString(), expressao);
                              j++;
                          }
                      }
           
            default: 
        }
    }
}
    public void Calcula() throws Exception
    {
      String verif = (String) fila.removerElemento();
        
       while(!fila.vazia())
       {
          if(verif.equals("F") || verif.equals("T"))
              fila.inserir(verif);
          
          switch(verif.charAt(0)){
              
            case '~':
                break;
            case '^':
                break;
            case 'v':
                break;
            case '-':
                break;
            case '<': 
                break;
            case ')': 
                break;
          }
       
       }

    }    
} 



