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
    
    private Boolean         v1, v2;
    private String          op;
    private Fila            fila;
    private Pilha           pilhaResultado;
    private String          item, strItemPilha;
    private final String[]  listaDeOperadores = {"^", "-", "<", "~", "V"};
    private final String[]  valoresBooleanos = {"T" , "F"};
    private String[]        x;
    private final int       capacidade = 40;
    
    public Calculadora(Fila fila)
    {
        this.fila = fila;
    }
    /**
     * Metodo responsável em calcular uma notacao posfixa
     * @return Resultado do calculo da expressão
     * @throws Exception No caso de Excessão o método chamante deve tratar
     */
    public String Calcular() throws Exception
    {
        try
        {
            pilhaResultado = new Pilha(capacidade);
            
            while(!fila.vazia())
            {
                item = (String)fila.getUmItem();
                
                if(Arrays.asList(listaDeOperadores).contains(item))
                {
                    op = item;
                    strItemPilha = (String)pilhaResultado.getUmItem();
                    pilhaResultado.jogueForaUmItem();
                    
                    if(strItemPilha.equals("T"))
                    {
                        v2 = true;
                    }
                    else if(strItemPilha.equals("F"))
                    {
                        v2 = false;
                    }

                    if(op.equals("~"))
                    {
                        if(v2)
                        {
                            pilhaResultado.guarde("F");
                        }
                        else
                        {
                            pilhaResultado.guarde("T");
                        }
                    }
                    else
                    {
                        String strItemPilhaCalc = (String)pilhaResultado.getUmItem();
                        pilhaResultado.jogueForaUmItem();
                        if(strItemPilhaCalc.equals("T"))
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
                                    pilhaResultado.guarde("T");
                                else
                                    pilhaResultado.guarde("F");
                                break;
                            case "-":
                                if(v1 != v2 && v1 == true)
                                    pilhaResultado.guarde("F");
                                else
                                    pilhaResultado.guarde("T");
                                break;
                            case "<":
                                if(v1 == v2)
                                    pilhaResultado.guarde("T");
                                else
                                    pilhaResultado.guarde("F");
                                break;
                            case "V":
                                if(v1 == true || v2 == true)
                                    pilhaResultado.guarde("T");
                                else
                                    pilhaResultado.guarde("F");
                                break;
                        }
                    }
                }
                else if(Arrays.asList(valoresBooleanos).contains(item))
                {
                        pilhaResultado.guarde(item);
                }
                
                fila.jogueForaUmItem();
            }
            return (String)pilhaResultado.getUmItem();
        }
        catch(Exception ex)
        {
            Logger.getLogger(Calculadora.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        throw new Exception("impossivel calcular");

    }
    
}
