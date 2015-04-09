/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab3.fabricant;

import java.io.File;
import java.util.HashMap;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.netbeans.xml.examples.purchaseorder.ItemsInfo;



/**
 *
 * @author Guillaume
 */
public class singletonItems {
    
    
    private singletonItems(){    
        
        
          try {
 
		File file = new File("E:\\universite\\GTI777\\gti777-supplyChain\\gti777-lab3\\data\\itemAvailaible.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(ItemsInfo.class);
 
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		ItemsInfo  itemsAvailaible = (ItemsInfo) jaxbUnmarshaller.unmarshal(file);
		itemProduced=itemsAvailaible.getItemsHashMap();
            
 
	  } catch (JAXBException e) {
		e.printStackTrace();
	  }
    
    }
    
    private static  singletonItems instance=null;
      HashMap<String,ItemsInfo.Item> itemProduced=null;
    public static singletonItems getInstance(){
    if(instance==null){
    instance=new singletonItems();
    }
    
    
    return instance;
    }
    
    
    public HashMap getItemProduced(){
  
    
    
    return itemProduced;
    }
    
}
