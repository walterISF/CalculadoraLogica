package calculadoralogica;

public class Fila <X>
{
    private Object[] item;
    private int      inicio =  0;
    private int      fim    = -1;
    private int      qtd    =  0;

    public Fila (int capacidade) throws Exception
    {
        if (capacidade<=0)
            throw new Exception ("Capacidade invalida");

        item = new Object [capacidade];
    }

    /**
     * Método responsável em inserir elementos na fila
     * @param x Parametro do tipo generico
     * @throws Exception No caso de excessão o chamante deve tratar
     */
    public void guarde (X x) throws Exception
    {
        if (x==null)
            throw new Exception ("Falta o que guardar");

        if (qtd==item.length)
            throw new Exception ("Nao cabe mais nada");

        fim++;
        if (fim==item.length)
            fim = 0;
        item[fim] = x;
        qtd++;
    }

    /**
     * Método responsável em exibir o elemento no no início da fila
     * @return Retorna um tipo genérico
     * @throws Exception Em caso de excessão deve-se tratar no chamante
     */
    public X getUmItem () throws Exception
    {
        if (qtd==0)
            throw new Exception ("Nada guardado");

        return (X)(item[inicio]);
    }

    /**
     * Método responsável em eliminar o primeiro item da fila 
     * passando a mesma para o próximo
     * @throws Exception Em caso de excessão deve-se tratar no chamante
     */
    public void jogueForaUmItem () throws Exception
    {
        if (qtd==0)
            throw new Exception ("Nada guardado");

        item[inicio] = null;
        inicio++;
        if (inicio==item.length)
            inicio = 0;
        qtd--;
    }
    public boolean cheia() throws Exception
    {
        if(qtd<0)
            throw new Exception("impossivel obter resultado");
        
        if (qtd==item.length)
            return true;
        
        return false;
    }
    public boolean vazia() throws Exception
    {
        if(qtd == 0)
            return true;
        
        return false;
    }
}