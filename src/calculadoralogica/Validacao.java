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
    /**
     * Método para validar uma expressão identificando pontos inadequados
     * @param exp Expressão do tipo String para ser quebrada e validada
     * @return Retorna um array de string String[] para o método chamante
     * @throws Exception No caso de excessão deve-se tratar a mesma no método chamante
     */
    public String[] validarExpressao(String exp) throws Exception
    {
        Integer abraParenteses=0, fechaParenteses=0;
        String[] brokenExpression;
        
        if(exp != null && exp.length() > 0)
        {
            String expWithoutSpace = exp.replace(" ", "");
            expWithoutSpace = expWithoutSpace.replace("<->", "<");
            expWithoutSpace = expWithoutSpace.replace("->", "-");
            
            brokenExpression = expWithoutSpace.split("");
            
            for(int i=0; i< brokenExpression.length; i++)
            {
                //System.out.println(brokenExpression[i]);
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
                            throw new Exception("Caractere invalido");
                        case ")":
                            if(expressionTest(brokenExpression[i+1], parentFProx))
                            {
                                fechaParenteses++;
                                break;
                            }
                            throw new Exception("Caractere invalido");
                        case "~":
                            if(expressionTest(brokenExpression[i+1], oprProx))
                                break;
                            throw new Exception("Caractere invalido");
                        case "^":
                            if(expressionTest(brokenExpression[i+1], oprProx))
                                break;
                            throw new Exception("Caractere invalido");
                        case "v":
                            if(expressionTest(brokenExpression[i+1], oprProx))
                                break;
                            throw new Exception("Caractere invalido");
                        case "T":
                            if(expressionTest(brokenExpression[i+1], expProx))
                                break;
                            throw new Exception("Caractere invalido");
                        case "F":
                            if(expressionTest(brokenExpression[i+1], expProx))
                                break;
                            throw new Exception("Caractere invalido");
                        case "-":
                            if(expressionTest(brokenExpression[i+1], oprProx))
                                break;
                            throw new Exception("Caractere invalido");
                        case "<":
                            if(expressionTest(brokenExpression[i+1], oprProx))
                                break;
                            throw new Exception("Caractere invalido");
                        default:
                            System.out.println("Invalid expression in item: " + brokenExpression[i]);
                            throw new Exception("Caractere invalido");

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
        else
        {
            throw new Exception("Insira uma expressão válida");
        }
        return brokenExpression;
    }
    private boolean expressionTest(String x, String[] test)
    {
        if(Arrays.asList(test).contains(x))
            return true;
        return false;
    }
}
