package calculadoralogica;

public class ConversorPosFixa {
    
    private final String[]    expressao;
    private final int         capacidade = 40;
    private Fila              fila;
    private Pilha             pilha;
    
    
ConversorPosFixa(String[] expressao) 
{
 this.expressao = expressao;
}
/**
 * Metodo de conversão de uma expressão infixa para pósfixa
 * @return Rtorna um elemento da classe fila
 * @throws Exception a excessão deve ser tratada no chamante
 */
public Fila Converte() throws Exception
{  
    pilha = new Pilha(capacidade);
    fila = new Fila(capacidade);
   
    for(int i=0; i<this.expressao.length;i++)
    {
        switch(this.expressao[i].toUpperCase())
        {
        
            case "(": pilha.guarde(this.expressao[i].toUpperCase());
                      break;
                      
            case "T": fila.guarde(this.expressao[i].toUpperCase());
                      break;
                      
            case "F": fila.guarde(this.expressao[i].toUpperCase());
                      break;
                      
            case "~": pilha.guarde(this.expressao[i].toUpperCase());
                      break;
                                
            case "^": 
                    if(!pilha.vazia() && (pilha.getUmItem().equals("~") || pilha.getUmItem().equals("^")))
                    {
                        while(!pilha.vazia() && (pilha.getUmItem().equals("~") || pilha.getUmItem().equals("^")))
                        {
                            fila.guarde(pilha.getUmItem());
                            pilha.jogueForaUmItem();
                        }
                        pilha.guarde(this.expressao[i].toUpperCase());
                    }
                    else
                    {
                        pilha.guarde(this.expressao[i].toUpperCase());
                    }
                    break;
                    
            case "V":
                    if(!pilha.vazia() && (pilha.getUmItem().equals("~") || pilha.getUmItem().equals("^") || pilha.getUmItem().equals("V")))
                    {
                        while(!pilha.vazia() && (pilha.getUmItem().equals("~") || pilha.getUmItem().equals("^") || pilha.getUmItem().equals("V")))
                        {
                            fila.guarde(pilha.getUmItem());
                            pilha.jogueForaUmItem();
                        }
                        pilha.guarde(this.expressao[i].toUpperCase());
                    }
                    else
                    {
                        pilha.guarde(this.expressao[i].toUpperCase());
                    }
                    break;
                
            case "-": 
                    if(!pilha.vazia() && (!pilha.getUmItem().equals("(") && !pilha.getUmItem().equals(")"))) 
                    {
                        while(!pilha.vazia() && (!pilha.getUmItem().equals("(") && !pilha.getUmItem().equals(")")))
                        {
                            fila.guarde(pilha.getUmItem());
                            pilha.jogueForaUmItem();                           
                        }
                        pilha.guarde(this.expressao[i].toUpperCase());
                    }
                    else
                    {
                        pilha.guarde(this.expressao[i].toUpperCase());
                    }
                    break;
            
            case "<":
                    if(!pilha.vazia() && (!pilha.getUmItem().equals("(") && !pilha.getUmItem().equals(")"))) 
                    {
                        while(!pilha.vazia() && (!pilha.getUmItem().equals("(") && !pilha.getUmItem().equals(")")))
                        {
                            fila.guarde(pilha.getUmItem());
                            pilha.jogueForaUmItem();                           
                        }
                        pilha.guarde(this.expressao[i].toUpperCase());
                    }
                    else
                    {
                        pilha.guarde(this.expressao[i].toUpperCase());
                    }
                    break;                
                    
            case ")":
                    if(!pilha.vazia() && !pilha.getUmItem().equals(")"))
                    {
                        while(!pilha.vazia() && !pilha.getUmItem().equals(")"))
                        {
                            if(pilha.getUmItem().equals("("))
                            {
                                pilha.jogueForaUmItem();
                            }
                            else
                            {
                                fila.guarde(pilha.getUmItem());
                                pilha.jogueForaUmItem();                              
                            }
                            
                        }
                    }
                    else
                    {
                        
                    }
           
            default: 
        }
    }
    if(pilha.vazia())
    {
        return fila;
    }
    else
    {
        fila.guarde(this.pilha.getUmItem());
    }
    return fila;
}
    
} 



