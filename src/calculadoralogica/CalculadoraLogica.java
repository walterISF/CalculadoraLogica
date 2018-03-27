<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package calculadoralogica;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CalculadoraLogica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String exp = "((T v F->T) ^ (T->F))->(~F<->T)";
        Validacao validacao = new Validacao();
        String[] expressao = validacao.validarExpressao(exp);
        if(expressao == null)
        {
            System.out.println("expressao Invalida");
        }
        ConversorPosFixa conversor = new ConversorPosFixa(expressao);
        try 
        {
            Fila filaDeSaida = new Fila();
            filaDeSaida = conversor.Converte();
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(CalculadoraLogica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}