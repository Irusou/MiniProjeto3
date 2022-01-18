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
       if(!listing.equals(null) && isValidListing(listing)){
           listings.add(listing);
           added = true;
       }
       return added;
   }
   
   public boolean removeListing(Listing listing){
       boolean removed = false;
       for(int i=0; i<listings.size();i++){
           if(listings.get(i).getIdentifier() == listing.getIdentifier()){
               listings.remove(listing);
               removed = true;
           }
       }
       return removed;
   }
   
   public void displayListings(){
       for(Listing l : listings){
           l.display();
       }
   }
   
   public Listing displayLocatedAt(String city){
       for(Listing l : listings){
           if(l.isLocatedAt(city)){
               return l;
           }
       }
       return null;
   }
   
   public Listing displayListingsBetween(double value1, double value2){
       for(Listing l : listings){
           if(l.getPrice()>=value1 && l.getPrice()<=value2){
               return l;
           }
       }
       return null;       
   }
   
   public Listing displayListingsWithYard(){
       for(Listing l : listings){
           if(l.getHouseData().isHasYard()){
               return l;
           }
       }
       return null; 
   }
   
   private boolean isValidListing(Listing listing){
       boolean isValid = false;
       for(int i = 0; i<listings.size();i++){
           if(listings.get(i).getIdentifier()!= listing.getIdentifier()){
               isValid = true;
           }
       }
       return isValid;
   }
}
