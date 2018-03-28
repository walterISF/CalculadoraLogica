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
    
    public Calculadora(Fila fila)
    {
        this.fila = fila;
    }
    
    public boolean Calcular()
    {
        while(!fila.filaVazia())
        {
            try 
            {
                item = (String)fila.jogueForaUmItem();
                if(Arrays.asList(listaDeOperadores).contains(item))
                {
                    op = item;
                    String stBool = (String)fila.jogueForaUmItem();
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
                        pilha.adcionar(!v2);
                    }
                    else
                    {
                        String stBoolCalc = (String)fila.jogueForaUmItem();
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
                                    pilha.adcionar(v1);
                                else
                                    pilha.adcionar(false);
                                break;
                            case "-":
                                if(v1 != v2 && v1 == true)
                                    pilha.adcionar(false);
                                else
                                    pilha.adcionar(true);
                                break;
                            case "<":
                                if(v1 == v2)
                                    pilha.adcionar(true);
                                else
                                    pilha.adcionar(false);
                                break;
                            case "v":
                                if(v1 == true || v2 == true)
                                    pilha.adcionar(true);
                                else
                                    pilha.adcionar(false);
                                break;
                        }
                    }
                }
                else if(Arrays.asList(valoresBooleanos).contains(item))
                {
                        pilha.adcionar(item);
                }
            } 
            catch (Exception ex) 
            {
                Logger.getLogger(Calculadora.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return false;
    }
    
}
