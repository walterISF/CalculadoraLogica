package calculadoralogica;

public class Pilha<E>{
    
    private static final int tamPad = 10; //Pode ser alterado
    private final int tam;
    private int topo;
    private E[] elem;
    
    public Pilha(int tam){
        this.tam = tam > 0 ? tam : tamPad;
        topo = -1;
        elem = (E[])new Object[tam];
    }
    
    public Pilha()
    {
     this(tamPad);   
    }
    
    public void adcionar(E e) throws Exception
    {
    if(topo == tam - 1)
        throw new Exception("Pilha cheia");
    
    elem[++topo] = e;
    
    }
    
    public E retirar(E e) throws Exception
    {
    if(topo == -1)
        throw new Exception("Pilha vazia");   
       
    return elem[topo--];
    }
    
     public E acessar(E e) throws Exception
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
