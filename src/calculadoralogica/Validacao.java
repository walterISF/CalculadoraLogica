/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoralogica;

import java.util.Arrays;

public class Validacao 
{
        //Possiveis tokens seguintes
        private final String[] parentAProx = {"(","~","F","T"};
        private final String[] parentFProx = {">","v","^","-",")"};
        private final String[] expProx = {"v","^","<","-",")"};
        private final String[] oprProx = {"T","F","~","("};
    
    public Validacao()
    {
    }
    
    public String[] validarExpressao(String exp)
    {
        Integer abraParenteses=0, fechaParenteses=0;
        
        if(exp != null && exp.length() > 0)
        {
            String expWithoutSpace = exp.replace(" ", "");
            expWithoutSpace = expWithoutSpace.replace("<->", "<");
            expWithoutSpace = expWithoutSpace.replace("->", "-");
            
            String[] brokenExpression = expWithoutSpace.split("");
            
            for(int i=0; i< brokenExpression.length; i++)
            {
                System.out.println(brokenExpression[i]);
                if(i+1 < brokenExpression.length)
                {
                    switch(brokenExpression[i])
                    {
                        case "(":
                            if(expressionTest(brokenExpression[i+1], parentAProx))
                            {
                                abraParenteses++;
                                break;
                            }
                            return null;
                        case ")":
                            if(expressionTest(brokenExpression[i+1], parentFProx))
                            {
                                fechaParenteses++;
                                break;
                            }
                            return null;
                        case "~":
                            if(expressionTest(brokenExpression[i+1], oprProx))
                                break;
                            return null;
                        case "^":
                            if(expressionTest(brokenExpression[i+1], oprProx))
                                break;
                            return null;
                        case "v":
                            if(expressionTest(brokenExpression[i+1], oprProx))
                                break;
                            return null;
                        case "T":
                            if(expressionTest(brokenExpression[i+1], expProx))
                                break;
                            return null;
                        case "F":
                            if(expressionTest(brokenExpression[i+1], expProx))
                                break;
                            return null;
                        case "-":
                            if(expressionTest(brokenExpression[i+1], oprProx))
                                break;
                            return null;
                        case "<":
                            if(expressionTest(brokenExpression[i+1], oprProx))
                                break;
                            return null;
                        default:
                            System.out.println("Invalid expression in item: " + brokenExpression[i]);
                            return null;

                    }                    
                }
                else
                {
                    if(brokenExpression[i].equals(")"))
                    {
                        fechaParenteses++;
                        if((abraParenteses - fechaParenteses) == 0)
                        {
                            return brokenExpression;
                        }                        
                    }
                
                }
                
            }
            
        }
        return null;
    }
    private boolean expressionTest(String x, String[] test)
    {
        if(Arrays.asList(test).contains(x))
            return true;
        return false;
    }
}
