/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab3.fabricant;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.netbeans.xml.examples.purchaseorder.ItemsInfo;
import org.netbeans.xml.examples.purchaseorder.OrderList;
import org.netbeans.xml.examples.purchaseorder.PurchaseOrder;
import org.netbeans.xml.examples.purchaseorder.PurchaseOrderInfo;


/**
 *
 * @author Gus
 */
@WebService(serviceName = "fabricant")
public class fabricant {
    
  

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    
    
    

    /**
     * Web service operation
     */
    @WebMethod(operationName = "traiterOrdreAchat")
    public boolean traiterOrdreAchat(@WebParam(name = "purchaseOrder") PurchaseOrderInfo purchaseOrderInfo) {
         //TODO write your implementation code here:
        System.out.println("traiter ordre achat");
        PurchaseOrder purchaseOrder=purchaseOrderInfo.getPurchaseOrder();
        HashMap<String,ItemsInfo.Item> itemProduced=singletonItems.getInstance().getItemProduced();
        
        
          boolean status=false;
       List<PurchaseOrder.Item> items = purchaseOrder.getItem();
       
       for(PurchaseOrder.Item processedItem:items){
               System.out.println("traiter  achat "+processedItem.getPartNum());
        
        
         if(itemProduced.get(processedItem.getPartNum())!=null&&processedItem.getUSPrice().compareTo(itemProduced.get(processedItem.getPartNum()).getUSPrice())>=0){
             status=true;
             int quantity=processedItem.getQuantity();
            
             do {  
                    if(quantity<=100){
                produire(processedItem.getPartNum(),quantity,processedItem.getType());
                quantity-=quantity;
                        System.out.println("Quantity updated"+quantity);
                
             }
                     else{
                          produire(processedItem.getPartNum(),100,processedItem.getType());
                            quantity=quantity-100;
                     }
                 
             } 
             while(quantity>0);
                  
          
             
             
        } else{
         status=false;}
         
        }
        if(status){
             try {
                 String fileName="PO-"+purchaseOrderInfo.getPurchaseOrderNumber().toString();
             
 
		File file = new File("E:\\universite\\GTI777\\gti777-supplyChain\\gti777-lab3\\data"+fileName+".xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(PurchaseOrder.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
 
		jaxbMarshaller.marshal(purchaseOrder, file);
                
                OrderList.PoSummary newOrder=new OrderList.PoSummary();
             newOrder.setClientId(purchaseOrderInfo.getClientId());
             newOrder.setPurchaseOrderNumber(purchaseOrderInfo.getPurchaseOrderNumber());
             newOrder.setOrderPrice( purchaseOrderInfo.getTotalPrice());
             newOrder.setStatus("shipped");
             singletonOrderPassed.getInstance().addOrder(newOrder);
		jaxbMarshaller.marshal(purchaseOrder, System.out);
 
	      } catch (JAXBException e) {
		e.printStackTrace();
	      }
 
        }else{
            System.out.println("Did not processed order");}
        System.out.println("ordre achat traiter "+status);
        return status;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtenirInfoProduit")
    public ItemsInfo.Item  obtenirInfoProduit(@WebParam(name = "partNum") String partNum) {
       //TODO write your implementation code here:
         HashMap<String,ItemsInfo.Item>itemProduced= singletonItems.getInstance().getItemProduced();
        ItemsInfo.Item returnedItem=null;
         if(itemProduced.containsKey(partNum)){
        returnedItem=itemProduced.get(partNum);
            
        }
         return returnedItem;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "receivePayment")
    public Boolean receivePayment(@WebParam(name = "numOrdre") BigInteger numOrdre, @WebParam(name = "prixTotal") BigInteger prixTotal) {
       OrderList orderPassed=  singletonOrderPassed.getInstance().getOrderList();
         Iterator iterateOrder=orderPassed.getPoSummary().listIterator();
         boolean orderMatch=false;
         while(iterateOrder.hasNext()&&!orderMatch)
         {
             OrderList.PoSummary currentOrder=(OrderList.PoSummary)iterateOrder.next();
             
             boolean nb=currentOrder.getPurchaseOrderNumber().equals(numOrdre);
             boolean price=currentOrder.getOrderPrice().equals(prixTotal);
             boolean status=!currentOrder.getStatus().equals("paid");
         if(currentOrder.getPurchaseOrderNumber().equals(numOrdre)&&currentOrder.getOrderPrice().equals(prixTotal)&&!currentOrder.getStatus().equals("paid")){
         orderMatch=true;
         singletonOrderPassed.getInstance().updateOrder(numOrdre);
         }
         
         }
          
          
        return orderMatch;
    }

    private boolean produire(String partNum, int quantity, String type) {
       
        return quantity<=100&&(type.equals("DVD player")||type.equals("video camera")||type.equals("TV"));
        
    }

   
}
