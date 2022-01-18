package miniprojeto3;
/**
 * Classe representante do vendedor.
 *
 * @author (João)
 * @version (22/11/2021)
 */
public class Agent
{
    private String name;//nome
    private int sales;//vendas
    private double earning;//ganhos
    private static final short COMISSION = 2%100;//comissao do agente
    private Listing[] listing;
    private static final short MAX_LISTINGS = 10;//nr de imoveis por agente
    private int numberOfListings;
    
    //construtor de agentes
    public Agent(String newName)
    {
        name = newName;
        sales = 0;
        listing = new Listing[MAX_LISTINGS];
        numberOfListings = 0;
        earning = 0.0;
    }
    
    /**
     * Metodo para verificar um imovel da lista
     * @param index posicao do imovel na lista
     * @return imovel na posicao do index ou null caso nao exista
     */
    public Listing getListing(int index){
        for(int i = 0;i<numberOfListings;i++){
            if(i==index){
                return listing[index];
            }
        }
        return null;
    }
    
    //selector do nome do agente
    public String getName(){
        return name;
    }

    //selectore das vendas do agente
    public int getSales(){
        return sales;
    }
    
    //selector dos ganhos do agente
    public double getEarnings(){
        return earning;
    }
    
    /**
     * Metodo display permite ver as informacoes do agente
     */
    public void display(){
        System.out.println("Nome: "+name);
        System.out.println("Imoveis: ");
        displayListings();
        System.out.println("Comissoes: "+earning+"$");
        System.out.println("Imoveis vendidos: "+sales);
    }
    
    private void displayListings(){
        for(int i = 0; i<numberOfListings; i++){
            listing[i].display();
        }
    }
    
    /**
     * Metodo isAcceptingListings verifica se um agente pode receber imoveis
     * @return isAccepting true se pode, false caso contrario
     */
    public boolean isAcceptingListings(){
        boolean isAccepting = false;
        if(numberOfListings<MAX_LISTINGS){
            isAccepting = true;
        }
        return isAccepting;
    }
    
    /**
     * Metodo addListing permite adicionar um imovel a lista do vendedor
     * 
     * @param listing objeto do tipo Listing que pretende adicionar
     */
    public void addListing(Listing listing){
        if(isAcceptingListings()){
            for(int i = 0; i<numberOfListings; i++){
                if(!this.listing[i].equals(listing)){
                    this.listing[numberOfListings++] = listing;
                }
            }
        }else{
            System.out.println("Lista de imoveis cheia.");
        }
    }

    /**
     * Metodo markAsSold permite ao vendedor realizar uma venda
     * 
     * @param listing objeto do tipo Listing que pretende vender
     */
    public void markAsSold(Listing listing){
        sales++;
        for(int i = 0; i<numberOfListings; i++){
            if(this.listing[i].equals(listing)){
                earning += (this.listing[i].getPrice() * COMISSION)/100;
                this.listing[i] = null;
            }else{
                System.out.println("Imovel nao encontrado.");
            }
        }
    }
    
    
    @Override
    public String toString(){
        return "Nome: "+getName()+"\n";
    }
}