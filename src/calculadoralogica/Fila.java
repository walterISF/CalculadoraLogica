package calculadoralogica;

public class Fila {

    private int inicio=0;
    private int fim=-1;
    private int qtd=0;

    Fila (int capacidade, String[] item) throws Exception
    {
        if(capacidade<=0)
            throw new Exception("Valor invalido");

        item = new String[capacidade];
    }

    void inserir(String elemento, String[] item) throws Exception
    {
        if(elemento==null)
            throw new Exception("Insira um valor");

        if(qtd==item.length)
            throw new Exception("Fila cheia");

        fim++;
        if(fim==item.length)
            fim=0;

        item[fim] = elemento;
        qtd++;

    }

    String retornarElemento()
    {
        //return item[fim];
        return null;
    }

    String removerElemento(String[] item) throws Exception
    {
        if(qtd==0)
        throw new Exception("Fila vazia");

        item[fim] = null;
        qtd--;

        if(fim==item.length)
            fim=0;
        qtd--;
        
        return null;

    }
    
    public Boolean vazia(){
        return (fim == -1);
    }
    
    public Boolean cheia(){
        return (fim == qtd-1);
    }
}
