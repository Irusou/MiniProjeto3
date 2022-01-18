package miniprojeto3;
/**
 * Classe representante da agencia
 *
 * @author (Joao)
 * @version (22/11/2021)
 */

import java.util.ArrayList;

public class RealEstateAgency
{
    private String name; //nome da agencia
    private Listings listings; //lista de imoveis
    private static final short COMISSION = 3%100; //comissao da agencia
    private double earning; //ganhos da agencia
    private ArrayList<Agent> agents; //lista de agentes
    
    //construtor da agencia
    public RealEstateAgency(String name)
    {
        this.name = name;
        listings = new Listings();
        agents = new ArrayList<>();
        earning = 0.0;
    }
    
    //metodo para adicionar agentes
    public void addAgent(Agent agent){
        for(int i = 0; i<agents.size();i++){
            if(agents.get(i).isAcceptingListings() && agents.get(i).equals(agent)){
                agents.add(agent);
            }
        }
    }

    //metodo para adicionar imoveis
    //verifica se um imovel esta apto para ser atribuido
    //adiciona o imovel criado a lista
    //verifica se um agente esta apto para receber um imovel 
    //atribui um imovel a um agente
    public void addListing(Listing listing){
        if(isAbleToAtribute(listing)){
            listings.addListing(listing);
        }else{
            System.out.println("Operacao nao efetuada, valor minimo de 4000$/m2");
        }
        if(agents.size()<2){
            if(agents.get(0).isAcceptingListings()){
                agents.get(0).addListing(listing);
            }
        }else{
            for(int i = 0; i<agents.size(); i++){
                if(agents.get(i).isAcceptingListings()&&agents.get(i+1).isAcceptingListings()){
                    if(agents.get(i).getEarnings()<agents.get(i+1).getEarnings()){
                        agents.get(i).addListing(listing);
                    }else{
                        agents.get(i+1).addListing(listing);
                    }
                }
            }
        }
    }
    
    //metodo para vender um imovel
    //verifica se o imovel recebido existe
    //retira-o da lista
    //adiciona os ganhos
    //retira o imovel do agente e adiciona os ganhos ao agente
    public void sellListing(Listing listing){
        listings.removeListing(listing);
    }
   
    //verifica se existem imoveis numa cidade
    public void displayLocatedAt(String city){
        listings.displayLocatedAt(city).display();
    }
    
    //verifica se existem imoveis dentro dos valores expecificados
    public void displayListingsBetween(double value1, double value2){
        listings.displayListingsBetween(value1, value2).display();
    }
    
    //mostra os imoveis com quintal
    public void displayListingsWithYard(){
        listings.displayListingsWithYard().display();
    }
    
    //devolve a lista de imoveis
    public void displayListings(){
        listings.displayListings();
    }
    
    //devolve a informacao da agencia
    public void display(){
        int i = name.length();
        int j;
        for(j=0; j<i+2; j++){
            System.out.print("*");  
        }
        System.out.println("");
        System.out.println("*"+ name +"*");
        for(j=0; j<i+2; j++){
            System.out.print("*");  
        }
        System.out.println("");
        System.out.println("");
        
        if((listings == null)){
            System.out.println("Lista de imoveis indisponivel!");
        }else{
            System.out.println("Imoveis:");
            listings.displayListings();
        }
        if(agents.isEmpty()){
            System.out.println("Agentes: ");    
        }else{
            System.out.println("Agentes: ");
            for(Agent a : agents){
                a.toString();
            }
        }
        System.out.println("Lucro: "+earning+"$");
    }
    
    //verifica se um imovel esta apto para ser recebido e atribuido
    private boolean isAbleToAtribute(Listing listing){
        if((listing.getPrice() * listing.getHouseData().getArea()) < 4000){
            return false;
        }else{
            return true;
        } 
    }
}