package warehouse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.netbeans.xml.examples.purchaseorder.Inventory;
import org.netbeans.xml.examples.purchaseorder.ItemsInfo;

/**
 *
 * @author Guillaume
 */
public class singletonItem {
    
    
    private static singletonItem instance=null;
    private Inventory warehouseInventory;
    private singletonItem(){
    File file = new File("E:\\universite\\GTI777\\gti777-supplyChain\\gti777-lab3-warehouseA\\data\\itemInventory.xml");
		JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Inventory.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		warehouseInventory = (Inventory) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException ex) {
            Logger.getLogger(singletonItem.class.getName()).log(Level.SEVERE, null, ex);
        }
 
		
	
    
    }
    
    public static singletonItem getInstance(){
        if( instance==null){
        instance= new singletonItem();
        }
    return instance;
    }
    
    public Inventory getInventory(){
    return warehouseInventory;
    }
    
    public HashMap getHashItem(){
    
    return warehouseInventory.getHashitem();
    }

    BigInteger updateInventory(String partNum, BigInteger quantity) {
        boolean updated=false;
        BigInteger remaining=null;
        BigInteger notProcessed = null;
      for( Inventory.InventoryItem currentItem:warehouseInventory.getInventoryItem()){
        
            System.out.print("Data "+quantity);
               System.out.print("Data "+currentItem.getPartNum());
            System.out.print(currentItem.getUSPrice().toString());
              System.out.print(currentItem.getQuantity().toString());
           
          
            if(currentItem.getPartNum().equals(partNum)&&!updated){
                updated=true;
           remaining=quantity.subtract(currentItem.getQuantity());
            if(remaining.compareTo(BigInteger.ZERO)<0){
            currentItem.setQuantity(BigInteger.ZERO);
            notProcessed=remaining.negate();
            }
            else{
            currentItem.setQuantity(remaining);
            notProcessed=BigInteger.ZERO;
            }
            }
        }
          System.out.print("Data "+"returning");
   return notProcessed;
    }
    
    
}
