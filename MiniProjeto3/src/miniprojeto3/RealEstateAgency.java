package miniprojeto3;
/**
 * Classe representante da agencia
 *
 * @author (Joao)
 * @version (22/11/2021)
 */
public class RealEstateAgency
{
    private String name; //nome da agencia
    private Listings listings; //lista de imoveis
    private Listing listing1; //imovel1
    private Listing listing2; //imovel2
    private Listing listing3; //imovel3
    private Listing listing4; //imovel4
    private Address address; //endereco do imovel
    private HouseData houseData; //info do imovel
    private static final short COMISSION = 3%100; //comissao da agencia
    private double earning; //ganhos da agencia
    private Agent agent1; //referencia do agente1
    private Agent agent2; //referencia do agente2
    
    //construtor da agencia
    public RealEstateAgency(String name)
    {
        this.name = name;
        listings = new Listings();
        address = null;
        listing1 = null;
        listing2 = null;
        listing3 = null;
        listing4 = null;
        houseData = null;
        agent1 = null;
        agent2 = null;
        earning = 0.0;
    }
    
    //metodo para adicionar agentes
    public void addAgent(Agent agent){
        if(agent1 == null){
            agent1 = agent;
        }else{
            agent2 = agent;
        }
    }

    //metodo para adicionar imoveis
    //verifica se um imovel ta apto para ser atribuido
    //adiciona o imovel criado a lista
    //verifica se um agente esta apto para receber um imovel 
    //atribui um imovel a um agente
    public void addListing(Listing newListing){
        if(isAbleToAtribute(newListing)){
            if(listing1 == null){
                listing1 = newListing;
                address = listing1.getAddress();
                houseData = listing1.getHouseData();
                listings.addListings(listing1);
            }else if(listing2 == null){
                listing2 = newListing;
                address = listing2.getAddress();
                houseData = listing2.getHouseData();
                listings.addListings(listing2);
            }else if(listing3 == null){
                listing3 = newListing;
                address = listing3.getAddress();
                houseData = listing3.getHouseData();
                listings.addListings(listing3);
            }else{
                listing4 = newListing;
                address = listing4.getAddress();
                houseData = listing4.getHouseData();
                listings.addListings(listing4);
            }
        }else{
            System.out.println("Operacao nao efetuada, valor minimo de 4000$/m2");
        }
        
        if(agent1 != null && agent2 !=null){
            if((agent1.getEarnings() == agent2.getEarnings())){
                if(agent1.isAcceptingListings()){
                    agent1.addListing(newListing);
                }else{
                    agent2.addListing(newListing);
                }
            }
            
            if((agent1.getEarnings() < agent2.getEarnings())){
                if(agent1.isAcceptingListings()){
                    agent1.addListing(newListing);
                }
            }
            
            if(agent2.getEarnings() < agent1.getEarnings()){
                if(agent2.isAcceptingListings()){
                    agent2.addListing(newListing);
                }
            }
        }else{
            System.out.println("Sem agentes para atribuir imoveis.");
        }
    }
    
    //metodo para vender um imovel
    //verifica se o imovel recebido existe
    //retira-o da lista
    //adiciona os ganhos
    //retira o imovel do agente e adiciona os ganhos ao agente
    public void sellListing(Listing listing){
        if(listing1 == listing){
    
            listings.setListing1(null);
    
            earning += listing1.getPrice() * COMISSION / 100;
    
            if(agent1.getListing1() == listing){
                agent1.markAsSold(listing);
            }else if(agent1.getListing2() == listing){
                agent1.markAsSold(listing);
            }else if(agent2.getListing1() == listing){
                agent2.markAsSold(listing);
            }else if(agent2.getListing2() == listing){
                agent2.markAsSold(listing);
            }
            listing1 = null;
    
        }else if(listing2 == listing){
            listings.setListing2(null);
            earning += listing2.getPrice() * COMISSION / 100;
    
            if(agent1.getListing1() == listing){
                agent1.markAsSold(listing);
            }else if(agent1.getListing2() == listing){
                agent1.markAsSold(listing);
            }else if(agent2.getListing1() == listing){
                agent2.markAsSold(listing);
            }else if(agent2.getListing2() == listing){
                agent2.markAsSold(listing);
            }
            listing2 = null;
    
        }else if(listing3 == listing){
            listings.setListing3(null);
            earning += listing3.getPrice() * COMISSION / 100;
    
            if(agent1.getListing1() == listing){
                agent1.markAsSold(listing);
            }else if(agent1.getListing2() == listing){
                agent1.markAsSold(listing);
            }else if(agent2.getListing1() == listing){
                agent2.markAsSold(listing);
            }else if(agent2.getListing2() == listing){
                agent2.markAsSold(listing);
            }
            listing3 = null;
    
        }else if(listing4 == listing){
            listings.setListing4(null);
            earning += listing4.getPrice() * COMISSION / 100;
    
            if(agent1.getListing1() == listing){
                agent1.markAsSold(listing);
            }else if(agent1.getListing2() == listing){
                agent1.markAsSold(listing);
            }else if(agent2.getListing1() == listing){
                agent2.markAsSold(listing);
            }else if(agent2.getListing2() == listing){
                agent2.markAsSold(listing);
            }
            listing4 = null;
    
        }else{
            System.out.println("Imovel nao encontrado.");
        }
    }
   
    //verifica se existem imoveis numa cidade
    public void displayLocatedAt(String city){
        if((listing1 != null) && (listing1.getAddress().getCity() == city)){
            listing1.display();
        }
        
        if((listing2 != null) && (listing2.getAddress().getCity() == city)){
            listing2.display();
        }
        
        if((listing3 != null) && (listing3.getAddress().getCity() == city)){
            listing3.display();
        }
        
        if((listing4 != null) && (listing4.getAddress().getCity() == city)){
            listing4.display();
        }
    }
    
    //verifica se existem imoveis dentro dos valores expecificados
    public void displayListingsBetween(double value1, double value2){
        if(listing1 !=null){
            if((listing1.getPrice()>= value1) && (listing1.getPrice()<= value2)){
                listing1.display();
            }
        }
        
        if(listing2 !=null){
            if((listing2.getPrice()>= value1) && (listing2.getPrice()<= value2)){
                listing2.display();
            }
        }
        
        if(listing3 !=null){
            if((listing3.getPrice()>= value1) && (listing3.getPrice()<= value2)){
                listing3.display();
            }        
        }
        
        if(listing4 !=null){
            if((listing4.getPrice()>= value1) && (listing4.getPrice()<= value2)){
                listing4.display();
            }         
        }
    }
    
    //mostra os imoveis com quintal
    public void displayListingsWithYard(){
        if((listing1 != null) && (listing1.getHouseData().isHasYard())){
            listing1.display();
        }
        
        if((listing2 != null) && (listing2.getHouseData().isHasYard())){
            listing2.display();
        }
        
        if((listing3 != null) && (listing3.getHouseData().isHasYard())){
            listing3.display();
        }
        
        if((listing4 != null) && (listing4.getHouseData().isHasYard())){
            listing4.display();
        }  
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
        if(agent1 == null && agent2 == null){
            System.out.println("Agentes: ");    
        }else{
            System.out.println("Agentes: ");
            System.out.println(agent1.getName());
            System.out.println(agent2.getName());
        }
        System.out.println("Lucro: "+earning+"$");
    }
    
    //verifica se um imovel ta apto para ser recebido e atribuido
    private boolean isAbleToAtribute(Listing listing){
        if((listing.getPrice() * listing.getHouseData().getArea()) < 4000){
            return false;
        }else{
            return true;
        } 
    }
    
}