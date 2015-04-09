/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapp;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import org.netbeans.xml.examples.purchaseorder.Inventory;
import org.netbeans.xml.examples.purchaseorder.USAddress;
import org.netbeans.xml.examples.purchaseorder.Warehouse;

/**
 *
 * @author Guillaume
 */
public class testAppWareHouse {
    

 public static void main(String[] args) throws DatatypeConfigurationException {

    singletonItem.getInstance();
    singletonWareHouse.getInstance();
 
 }



 private static void writeObjectToFile(String path,Class objectClass,Object writtenObject){
   
   
     try {
 
		File file = new File(path);
                System.out.println("Writing to "+file.getAbsolutePath());
		JAXBContext jaxbContext = JAXBContext.newInstance(objectClass);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
 
		jaxbMarshaller.marshal(writtenObject, file);
		jaxbMarshaller.marshal(writtenObject, System.out);
 
	      } catch (JAXBException e) {
		e.printStackTrace();
	      }
   
   
   }




}
