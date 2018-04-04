/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoralogica;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vntwafi
 */
public class Calculadora {
    
    private Boolean v1, v2;
    private String op;
    private Fila fila;
    private Pilha pilha;
    private String item;
    private String[] listaDeOperadores = {"^", "-", "<", "~", "v"};
    private String[] valoresBooleanos = {"T" , "F"};
    private String[] x;
    private int capacidade = 40;
    
    public Calculadora(Fila fila)
    {
        this.fila = fila;
    }
    
    public String Calcular() throws Exception
    {
        try
        {
            pilha = new Pilha(capacidade);
            
            while(fila.vazia() == false)
            {
                item = (String)fila.getUmItem();
                fila.jogueForaUmItem();
                if(Arrays.asList(listaDeOperadores).contains(item))
                {
                    op = item;
                    String stBool = (String)pilha.getUmItem();
                    pilha.jogueForaUmItem();
                    
                    if(stBool.equals("T"))
                    {
                        v2 = true;
                    }
                    else
                    {
                        v2 = false;
                    }

                    if(op.equals("~"))
                    {
                        if(v2)
                        {
                            pilha.guarde("F");
                        }
                        else
                        {
                            pilha.guarde("T");
                        }
                    }
                    else
                    {
                        String stBoolCalc = (String)pilha.getUmItem();
                        pilha.jogueForaUmItem();
                        if(stBoolCalc.equals("T"))
                        {
                            v1 = true;
                        }
                        else
                        {
                            v1 = false;
                        }
                        switch(op)
                        {
                            case "^":
                                if(v1 == v2 && v1 == true)
                                    pilha.guarde("T");
                                else
                                    pilha.guarde("F");
                                break;
                            case "-":
                                if(v1 != v2 && v1 == true)
                                    pilha.guarde("F");
                                else
                                    pilha.guarde("T");
                                break;
                            case "<":
                                if(v1 == v2)
                                    pilha.guarde("T");
                                else
                                    pilha.guarde("F");
                                break;
                            case "v":
                                if(v1 == true || v2 == true)
                                    pilha.guarde("T");
                                else
                                    pilha.guarde("F");
                                break;
                        }
                    }
                }
                else if(Arrays.asList(valoresBooleanos).contains(item))
                {
                        pilha.guarde(item);
                }
            }
            return (String)pilha.getUmItem();
        }
        catch(Exception ex)
        {
            Logger.getLogger(Calculadora.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        throw new Exception("impossivel calcular");

    }
    
}
