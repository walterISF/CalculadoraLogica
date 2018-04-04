/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package calculadoralogica;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CalculadoraLogica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String exp = "((T v F->T) ^ (T->F))->(~F<->T)";
        exp = "T v F";
        String[] expressao;
        String resultado;
        Validacao validacao = new Validacao();
        ConversorPosFixa conversor;
        Calculadora calculadora;
        int capacidade = 50;
        try
        {
            expressao = validacao.validarExpressao(exp);
//            Scanner s = new Scanner(System.in);
//            System.out.println("Digite uma expressão lógica: ");
//            s.next();
//            conversor = new ConversorPosFixa(expressao);
//            conversor.Converte();
            conversor = new ConversorPosFixa(expressao);
            Fila filaDeSaida = new Fila(capacidade);
            filaDeSaida = conversor.Converte();
            calculadora = new Calculadora(filaDeSaida);
            resultado = calculadora.Calcular();
            System.out.println(resultado);

        }
        catch(Exception e)
        {
            Logger.getLogger(CalculadoraLogica.class.getName()).log(Level.SEVERE, null, e);
        }


    }
    
}