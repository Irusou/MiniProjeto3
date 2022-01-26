/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojeto3;

import java.util.ArrayList;

/**
 *
 * @author João Pedro
 */
public class Sell {
    private ArrayList<Agent> agents;
    private ArrayList<Listing> listings;
    private static int sellNumber = 1;
    
    public Sell(){
        agents = new ArrayList<>();
        listings = new ArrayList<>();
        sellNumber++;
    }
    
    public void makeSell(Agent agent, Listing listing){
        agents.add(agent);
        this.listings.add(listing);
        for(int i = 0; i< agents.size();i++){
            for(int j = 0; j<listings.size();j++){
                agents.get(i).addListing((Listing) listings.get(j));
            }
        }
    }
    
    public void sortSells(){
        for(int i = 0; i<agents.size();i++){
            agents.get(i).getListing(i);
        }
    }
    
    @Override
    public String toString(){
        String str = "";
        for(Agent a : agents){
            str += a.toString()+"\n";
        }
        for(Listing l : listings){
            str += l.toString()+"\n";
        }
        return str;
    }
}
