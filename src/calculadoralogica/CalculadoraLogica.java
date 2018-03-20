/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package calculadoralogica;

import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 *
 * @author vntwafi
 */
public class CalculadoraLogica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception
    {
        
        BufferedReader lerTeclado = new BufferedReader (new InputStreamReader (System.in)); //variavel que irá ler o que o usuario digitou e guardar
        
        
        String vetorExpressao = new String(); //string da expressão logica
        
        System.out.print("Digite uma expressão lógica: ");
        vetorExpressao = lerTeclado.readLine();
        
        Validacao validacao = new Validacao();
        validacao.validarExpressao(vetorExpressao);
        
    }
    
}