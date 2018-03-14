/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoralogica;

import static java.sql.DriverManager.println;
import java.util.StringTokenizer;

public class Validacao 
{
    
    public Validacao()
    {
    }
    
    public boolean validarExpressao(String exp)
    {
        StringTokenizer expQuebrada;
        String item = null;
        if(exp != null && exp.length() > 0)
        {
            String expWithoutSpace = exp.trim();
            if(expWithoutSpace.indexOf("->") >= 0 || expWithoutSpace.indexOf("<->") >= 0)
            {
                //TODO REMOVER ITENS DA STRING E COLOCAR NOVOS
            }
            
            expQuebrada = new StringTokenizer (expWithoutSpace, "~^v-<", true);

            do
            {
                item = expQuebrada.nextToken();

            }
            while(expQuebrada.hasMoreTokens());
                    
         
            
        }
        return false;
    }
}
