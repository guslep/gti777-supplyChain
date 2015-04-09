/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse;

import java.io.File;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.netbeans.xml.examples.purchaseorder.Inventory;
import org.netbeans.xml.examples.purchaseorder.Warehouse;

/**
 *
 * @author Guillaume
 */
public class singletonWareHouse {
    

private static singletonWareHouse instance=null;
    private Warehouse warehouseInfo;
    private singletonWareHouse(){
        
    File file = new File("E:\\universite\\GTI777\\gti777-supplyChain\\gti777-lab3-warehouseA\\data\\warehouse.xml");
		JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Warehouse.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		warehouseInfo = (Warehouse) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException ex) {
            Logger.getLogger(singletonItem.class.getName()).log(Level.SEVERE, null, ex);
        }
 
		System.out.print("Warehouse: " + warehouseInfo.getIdWarehouse());
	
    
    }
    
    public static singletonWareHouse getInstance(){
        if( instance==null){
        instance= new singletonWareHouse();
        }
    return instance;
    }
    
    public Warehouse getWarehouseInfo(){
    return warehouseInfo;
    }
    
    
    







}
