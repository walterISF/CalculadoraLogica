/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoralogica;

import java.util.Arrays;
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
        Integer abraParenteses=0, fechaParenteses=0;
        if(exp != null && exp.length() > 0)
        {
            String expWithoutSpace = exp.replace(" ", "");
            expWithoutSpace = expWithoutSpace.replace("<->", "<");
            expWithoutSpace = expWithoutSpace.replace("->", "-");
            
            expQuebrada = new StringTokenizer (expWithoutSpace, "~^v-<()", true);

            while (expQuebrada.hasMoreElements()) 
            {
                item = expQuebrada.nextElement().toString();
                System.out.println(item);                
                switch(item.toLowerCase())
                {
                    case "(":
                        abraParenteses++;
                        break;
                    case ")":
                        fechaParenteses++;
                        break;
                    case "~":
                        break;
                    case "^":
                        break;
                    case "v":
                        break;
                    case "t":
                        break;
                    case "f":
                        break;
                    case "-":
                        break;
                    case "<":
                        break;
                    default:
                        System.out.println("Invalid expression: " + item);
                        return false;
                        
                }
                
            }
            
            if((abraParenteses - fechaParenteses) == 0)
            {
                return true;
            }
        }
        return false;
    }
}
