/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoralogica;

public class CalculadoraLogica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String exp = "((T v F->T) ^ (T->F))->(~F<->T)";
        
        Validacao validacao = new Validacao();
        if(validacao.validarExpressao(exp) == null)
        {
            System.out.println("Expressao Valida");
        }
        else
        {
            System.out.println("Expressao Invalida");
        }
    }
    
}
