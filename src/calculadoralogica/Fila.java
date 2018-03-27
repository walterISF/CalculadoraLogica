package calculadoralogica;

public class Fila <X>
{
    private Object[] item;
    private int      inicio =  0;
    private int      fim    = -1;
    private int      qtd    =  0;
    private int      capacidade = 40;

    public Fila () throws Exception
    {
        item = new Object [capacidade];
    }

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

    public X getUmItem () throws Exception
    {
        if (qtd==0)
            throw new Exception ("Nada guardado");

        return (X)(item[inicio]);
    }

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
}