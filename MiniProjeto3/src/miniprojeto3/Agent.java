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
    private Listing listing1;//imovel1
    private Listing listing2;//imovel2
    
    //construtor de agentes
    public Agent(String newName)
    {
        name = newName;
        sales = 0;
        listing1 = null;
        listing2 = null;
        earning = 0.0;
    }
    
    //selector do imovel1
    public Listing getListing1(){
        if(listing1 != null){
            return listing1;
        }else{
            return null;
        }
    }
    
    //selector do imovel2
    public Listing getListing2(){
        if(listing2 != null){
            return listing2;
        }else{
            return null;
        }
    }
    
    //modificador do imovel1
    public void setListing1(Listing listing){
        listing1 = listing;
    }
    
    //modificador do imovel2
    public void setListing2(Listing listing){
        listing2 = listing;
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
    
    //display das informacoes do agente
    public void display(){
        System.out.println("Nome: "+name);
        System.out.println("Imoveis: ");
        displayListings();
        System.out.println("Comissoes: "+earning+"$");
        System.out.println("Imoveis vendidos: "+sales);
    }
    
    //display das informacoes relativas aos imoveis do agente
    public void displayListings(){
       if(listing1 == null && listing2 == null){
           System.out.println("Sem imoveis.");
       }else if(listing1 != null && listing2 == null){
           listing1.display();
       }else if(listing2 != null && listing1 == null){
           listing2.display();
       }else{
           listing1.display();
           listing2.display();
       }
    }
    
    //verificador de se um agente pode receber imoveis
    public boolean isAcceptingListings(){
        if((listing1 != null) && (listing2 != null)){
            return false;
        }else{
            return true;
        }
    }
    
    //metodo para atribuir imoveis ao agente
    public void addListing(Listing listing){
        if(isAcceptingListings()){
            if(listing1 == null){
                listing1 = listing;
            }else{
                listing2 = listing;
            }
        }else{
            System.out.println("Lista de imoveis cheia.");
        }
    }

    //metodo para marcar como vendido um imovel
    //verifica se o imovel recebido � igual a algum dos do agente
    public void markAsSold(Listing listing){
        sales++;
        if(listing1 == null && listing2 == null){
            System.out.println("Sem imoveis para venda.");
        }else{
            if(listing1 == listing){
                earning += ((listing1.getPrice() * COMISSION)/100);
                listing1 = null;  
            }else if(listing2 == listing){
                earning +=  ((listing2.getPrice() * COMISSION)/100);
                listing2 = null;
            }else{
                System.out.println("Imovel nao encontrado.");
            }
        }
    }
}

