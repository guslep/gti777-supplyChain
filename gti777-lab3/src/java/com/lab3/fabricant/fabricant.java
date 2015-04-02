/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab3.fabricant;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.netbeans.xml.examples.purchaseorder.PurchaseOrder;

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
    
    private void produire(){}

    /**
     * Web service operation
     */
    @WebMethod(operationName = "traiterOrdreAchat")
    public boolean traiterOrdreAchat(@WebParam(name = "purchaseOrder") PurchaseOrder purchaseOrder) {
        //TODO write your implementation code here:
        boolean status=false;
       List<PurchaseOrder.Item> items = purchaseOrder.getItem();
        while(items.iterator().hasNext()){
        PurchaseOrder.Item processedItem =(items.iterator()).next();
        
         if(processedItem.getUSPrice().compareTo(BigDecimal.valueOf(100.00))>=0){
             int quantity=processedItem.getQuantity();
             while(quantity/processedItem.getQuantity()>1){
             produire();
             quantity=quantity-100;
             }
        }
         
        }
        if(!status){
             try {
 
		File file = new File("../../../../log/PO.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(PurchaseOrder.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
 
		jaxbMarshaller.marshal(purchaseOrder, file);
		jaxbMarshaller.marshal(purchaseOrder, System.out);
 
	      } catch (JAXBException e) {
		e.printStackTrace();
	      }
 
        }
        
        return status;
    }

   
}
