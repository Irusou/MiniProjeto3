package miniprojeto3;
/**
 * Classe representante do vendedor.
 *
 * @author (João)
 * @version (14/11/2021)
 */
public class Address
{
    private String address;//endereco
    private String postalCode;//codigo postal
    private String city;//cidade
    
    //construtor 
    public Address(String newAddress, String newPostalCode, String newCity){
        address = newAddress;
        postalCode = newPostalCode;
        city = newCity;
    }
    
    //seletor address
    public String getAddress(){
        return address;
    }
    
    //modificador address
    public void setAddress(String newAddress){
        address = newAddress;    
    }
    
    //seletor postalCode
    public String getPostalCode(){
        return postalCode;
    }
    
    //modificador postalCode
    public void setPostalCode(String newPostalCode){
        postalCode = newPostalCode;    
    }
    
    //seletor city
    public String getCity(){
        return city;
    }
    
    //modificador city
    public void setCity(String newCity){
        city = newCity;
    }
}
