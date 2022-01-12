package miniprojeto3;
/**
 * Classe representante do imovel.
 *
 * @author (João)
 * @version (21/11/2021)
 */
public class Listing
{
    private double price;//preco
    private Address address;//endereco do imovel
    private HouseData houseData;//info do imovel
    private int listingIdentifier;//contador de imoveis
    private static int identifier;//identificador de imoveis
    
    //construtor imovel1
    public Listing(double newPrice, String newAddress, String newPostalCode, String newCity, double newArea)
    {
        if(newPrice > 0){
            price = newPrice;
        }else{
            price = 0;
        }
        
        //atribuir os valores da classe Address
        address = new Address(newAddress, newPostalCode, newCity);
        
        //atribuir os valores da classe HouseData
        houseData = new HouseData(newArea, false, address.getAddress(), address.getPostalCode(), address.getCity());
        
        identifier++;
        listingIdentifier = identifier;
    }

    //construtor imovel2
    public Listing(double newPrice, String newAddress, String newPostalCode, String newCity, double newArea, boolean newHasYard)
    {
        if(newPrice > 0){
            price = newPrice;
        }else{
            price = 0;
        }
        
        //atribuir os valores da classe Address
        address = new Address(newAddress, newPostalCode, newCity);
        
        //atribuir os valores da classe HouseData
        houseData = new HouseData(newArea, newHasYard, address.getAddress(), address.getPostalCode(), address.getCity());
        
        identifier++;
        listingIdentifier = identifier;
    }
    
    //construtor imovel3
    public Listing(double newPrice, String newAddress, double newArea, String newCity, boolean newHasYard)
    {
        if(newPrice > 0){
            price = newPrice;
        }else{
            price = 0;
        }

        //atribuir os valores da classe Address
        address = new Address(newAddress, "", newCity);

        //atribuir os valores da classe HouseData
        houseData = new HouseData(newArea, newHasYard, address.getAddress(), "", address.getCity());

        identifier++;  
        listingIdentifier = identifier;
    }
    
    //verificar se existe uma cidade
    public boolean isLocatedAt(String newCity){
        if(newCity == address.getCity()){
            return true;
        }else{
            return false;
        }
    }
    
    //selector preco
    public double getPrice(){
        return price;
    }
    
    //modificador preco
    public void setPrice(double newPrice){
        price = newPrice;
    }
    
    //selector objeto address - retorna a referencia do objeto
    public Address getAddress(){
        return address;
    }
    
    //selector objeto houseData - retorna a referencia do objeto
    public HouseData getHouseData(){
        return houseData;
    }
    
    //selector identifier - de cada imovel
    public int getIdentifier(){
        return listingIdentifier;
    }
    
    //display das informacoes do imovel
    public void display(){
        String yard;
        System.out.println("");
        System.out.println("#" + listingIdentifier + " preco: " + price + "$");
        if(address.getPostalCode() == ""){
            System.out.println(address.getAddress() + "," + address.getCity());
        }else{
            System.out.println(address.getAddress() + "," + address.getPostalCode() + "," + address.getCity());
        }
        System.out.println(houseData.getArea() + "m2");
        if(houseData.isHasYard()){
            yard = "tem.";
        }else{
            yard = "nao tem.";
        }
        System.out.println("Quintal: " + yard);
        System.out.println("");
    }
}
