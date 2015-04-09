/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab3.fabricant;

import java.io.File;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.netbeans.xml.examples.purchaseorder.ItemsInfo;
import org.netbeans.xml.examples.purchaseorder.OrderList;

/**
 *
 * @author Guillaume
 */
public class singletonOrderPassed {
    
    
    private singletonOrderPassed(){    
        
        
          try {
 
		File file = new File("E:\\universite\\GTI777\\gti777-supplyChain\\gti777-lab3\\data\\orderProcessed.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(OrderList.class);
 
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		  orderList = (OrderList) jaxbUnmarshaller.unmarshal(file);
		
            
 
	  } catch (JAXBException e) {
		e.printStackTrace();
	  }
    
    }

    public OrderList getOrderList() {
        return orderList;
    }
    
    
    
    private static  singletonOrderPassed instance=null;
      
      OrderList  orderList;
    public static singletonOrderPassed getInstance(){
    if(instance==null){
    instance=new singletonOrderPassed();
    }
    
    
    return instance;
    }
    
    
 
    
    public void updateOrder(BigInteger orderId){
        Iterator iter=orderList.getPoSummary().listIterator(0);
        boolean found=false;
        while(!found&&iter.hasNext()){
        
            OrderList.PoSummary currentOrder=(OrderList.PoSummary)iter.next();
            if(currentOrder.getPurchaseOrderNumber().equals(orderId)){
                currentOrder.setStatus("paid");
                found=true;
            
            }
            saveToFile();
        }
   
        
    
    }
    
    
    
    
    public void addOrder(OrderList.PoSummary newPo){
        //System.out.println("ClientId order "+orde);
        System.out.println("ClientId order"+newPo.getClientId());
    orderList.getPoSummary().add(newPo);
    saveToFile();
    
    }
    
    
    private void saveToFile(){
    
      
   
   
     try {
 
		File file = new File("E:\\universite\\GTI777\\gti777-supplyChain\\gti777-lab3\\data\\orderProcessed.xml");
                System.out.println("Writing to "+file.getAbsolutePath());
		JAXBContext jaxbContext = JAXBContext.newInstance(OrderList.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
 
		jaxbMarshaller.marshal(orderList, file);
		jaxbMarshaller.marshal(orderList, System.out);
 
	      } catch (JAXBException e) {
		e.printStackTrace();
	      }
   
   
   }
    

}
