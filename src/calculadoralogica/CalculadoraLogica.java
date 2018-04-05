/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package calculadoralogica;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CalculadoraLogica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String exp;
        String[] expressao;
        String resultado;
        Validacao validacao = new Validacao();
        ConversorPosFixa conversor;
        Calculadora calculadora;
        int capacidade = 50;
        try
        {
            
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Digite uma expressão lógica: ");
            exp = in.readLine();
            expressao = validacao.validarExpressao(exp);
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