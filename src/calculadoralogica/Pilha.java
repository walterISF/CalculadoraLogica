package calculadoralogica;

public class Pilha <X>
{ 
    private final int tam = 30;
    private int       topo = -1;
    private Object[]  item;
    
    public Pilha (int capacidade) throws Exception
    {
        if (capacidade<=0)
            throw new Exception ("Capacidade invalida");
        item = new Object [capacidade];
    }
    
    /**
     * Método responsável em inserir itens no topo da pilha
     * @param e Recebe um objeto tipo genérico
     * @throws Exception Em caso de excessão deve-se tratar no chamante
     */
    public void guarde (X e) throws Exception
    {
        if(topo == tam - 1)
            throw new Exception("Pilha cheia");
        
        topo++;
        item[topo] = e;
        
    }

    /**
     * Método responsável em devolver o item que está no topo da pilha
     * @return Retorna o item do topo da pilha
     * @throws Exception Em caso de excessão deve-se tratar no chamante
     */
    public Object getUmItem () throws Exception
    {
    if(topo == -1)
        throw new Exception("Pilha vazia");
        
        return item[topo];
    }
    
    /**
     * Método responsável em jogar fora o item que está no topo da pilha
     * @throws Exception Em caso de excessão deve-se tratar no chamante
     */
    public void jogueForaUmItem () throws Exception
    {
        if(topo == -1)
            throw new Exception("Pilha vazia");   

        item[topo] = null;
        topo --;
        
    }
    
    /**
     * Método responsável em informar se a pilha está ou não vazia
     * @return Retorna um boolean sendo true caso a pilha esteja vazia
     * e false caso contrário
     * @throws Exception Em caso de excessão deve-se tratar no chamante
     */
    public boolean vazia () throws Exception
    {
        if(tam <= 0)
           throw new Exception("Capacidade invalida");
        
        if(topo == -1)
            return true;
        
        return false;
    }
    
    /**
     * Método responsável em informar se a pilha está ou não cheia
     * @return Retorna um boolean sendo true no caso da pilha estar cheia
     * e false caso contrário
     * @throws Exception Em caso de excessão deve-se tratar no chamante
     */
    public boolean cheia () throws Exception
    {
        if(topo == -1)
            throw new Exception("Pilha vazia");
        
        if(topo == tam - 1)
            return true;
        
        return false;
    }
    /**
     * Método responsável por verificar se existe somente um elemento na pilha
     * @return Retorna um boolean sendo true para o caso de ter e false se não tiver
     */
    public boolean temUmElemento()
    {
        if(topo == 0)
            return true;
        
        return false;
    }
}
