/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecttool;

/**
 *
 * @author Sakina Pan
 */
public class RemarkList {
    
    private String Listing;

    public RemarkList(){
        
        this.Listing = "";
    }
    
    public RemarkList(String Listing){
        
        this.Listing = Listing;
        
    }

    public void setListing(String Listing) {
        this.Listing = Listing;
    }

    public String getListing() {
        return Listing;
    }
}



