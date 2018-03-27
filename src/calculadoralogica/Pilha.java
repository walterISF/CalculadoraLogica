package calculadoralogica;

public class Pilha<X>
{
    
    private final int tam = 30;
    private int topo;
    private X[] elem;
    
    public Pilha() throws Exception{
        topo = -1;
        elem = (X[])new Object[tam];
    }
    
    public void adcionar(X e) throws Exception
    {
        if(topo == tam - 1)
            throw new Exception("Pilha cheia");

        elem[++topo] = e;
    }
    
    public X retirar(X e) throws Exception
    {
    if(topo == -1)
        throw new Exception("Pilha vazia");   
       
    return elem[topo--];
    }
    
     public X acessar(X e) throws Exception
    {
    if(topo == -1)
        throw new Exception("Pilha vazia");
        
        return elem[topo];
    }
    
     public Boolean vazia(){
        return (topo == -1);
    }
    
    public Boolean cheia(){
        return (topo == tam-1);
    }
}
