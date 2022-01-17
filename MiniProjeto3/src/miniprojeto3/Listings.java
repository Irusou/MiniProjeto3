package miniprojeto3;

import java.util.ArrayList;

/**
 * Classe representante dos imoveis.
 *
 * @author (João)
 * @version (22/11/2021)
 */
public class Listings
{
   private ArrayList<Listing> listings;
    
   //construtor da lista de imoveis
   public Listings(){
       listings = new ArrayList<>();
   }
   
   public boolean addListing(Listing listing){
       boolean added = false;
       if(!listing.equals(null)){
           listings.add(listing);
           added = true;
       }
       return added;
   }
   
   public void displayListings(){
       for(Listing l : listings){
           l.display();
       }
   }
}
