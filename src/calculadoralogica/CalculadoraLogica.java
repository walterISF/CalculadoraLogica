/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package calculadoralogica;

import java.io.*;

public class CalculadoraLogica {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception
    {
        
        BufferedReader lerTeclado = new BufferedReader (new InputStreamReader (System.in)); //variavel que irá ler o que o usuario digitou e guardar
        
        
        String vetorExpressao = new String(); //string da expressão logica
        
        System.out.print("Digite uma expressão lógica: ");
        vetorExpressao = lerTeclado.readLine();
        Validacao validar = new Validacao();
        String[] stringValidada = validar.validarExpressao(vetorExpressao);
        
        if(stringValidada == null)
        {
            System.out.println("Expressao Invalida");
        }
        else
        {
            System.out.println("Expressao Valida");
        }
    }
    
}