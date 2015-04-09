/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapp;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.jws.WebParam;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.netbeans.xml.examples.purchaseorder.Client;

import org.netbeans.xml.examples.purchaseorder.ItemsInfo;
import org.netbeans.xml.examples.purchaseorder.ListeItem;
import org.netbeans.xml.examples.purchaseorder.OrderList;
import org.netbeans.xml.examples.purchaseorder.PurchaseOrder;
import org.netbeans.xml.examples.purchaseorder.PurchaseOrderInfo;
import org.netbeans.xml.examples.purchaseorder.StatutListeItemExpedier;
import org.netbeans.xml.examples.purchaseorder.USAddress;
import warehouse.Warehouse;
import warehouse.Warehouse_Service;



/**
 *
 * @author Guillaume
 */
public class TestApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DatatypeConfigurationException {
        // TODO code application logic here
        
        org.netbeans.xml.examples.purchaseorder.Warehouse test=new org.netbeans.xml.examples.purchaseorder.Warehouse();
        test.setIdWarehouse(BigInteger.valueOf(123456789));
          USAddress billTo=new USAddress();
        billTo.setCity("Washington");
        billTo.setCountry("US");
        billTo.setName("Super warehouse A");
        billTo.setState("Washington DC");
        billTo.setStreet("123 test street");
        billTo.setZip(BigDecimal.valueOf(2398));
        test.setBillTo(billTo);
        test.setLocation(billTo);
       // writeObjectToFile("E:\\universite\\GTI777\\gti777-supplyChain\\gti777-lab3-warehouseA\\data\\warehouse.xml", test.getClass(), test);
        
        testProject();
       
        
    }
    
   public static void testPO() throws DatatypeConfigurationException{
       PurchaseOrderInfo purchaseOrderSlip=new PurchaseOrderInfo();
       purchaseOrderSlip.setComment("test Order");
       purchaseOrderSlip.setClientId(BigInteger.valueOf(787879546));
       purchaseOrderSlip.setTotalPrice(BigInteger.valueOf(265248));
       purchaseOrderSlip.setPurchaseOrderNumber(BigInteger.valueOf(654987321));
         GregorianCalendar greg = new GregorianCalendar();
        greg.setTime(new Date());
         XMLGregorianCalendar orderDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(greg);
         purchaseOrderSlip.setOrderDate(orderDate);
        greg.add(GregorianCalendar.DAY_OF_YEAR, 30);
        XMLGregorianCalendar ship = DatatypeFactory.newInstance().newXMLGregorianCalendar(greg);
        purchaseOrderSlip.setShipDate(ship);
        USAddress billTo=new USAddress();
        billTo.setCity("Washington");
        billTo.setCountry("US");
        billTo.setName("Super warehouse A");
        billTo.setState("Washington DC");
        billTo.setStreet("123 test street");
        billTo.setZip(BigDecimal.valueOf(2398));
        
        
        purchaseOrderSlip.setBillTo(billTo);
        purchaseOrderSlip.setShipTo(billTo);
       
        
       
   PurchaseOrder testPo=new PurchaseOrder();
        PurchaseOrder.Item testItem1=new PurchaseOrder.Item();
        testItem1.setPartNum("123-PB");
      // testItem1.setType("DVD player");
        testItem1.setProductName("DVDPLAYER");
        testItem1.setQuantity(200);
       
       
        testItem1.setUSPrice(BigDecimal.valueOf(200.55));
        testPo.getItem().add(testItem1);
        
         PurchaseOrder.Item testItem2=new PurchaseOrder.Item();
         testItem2.setPartNum("457-CA");
      //  testItem2.setType("TV");
        testItem2.setProductName("TV 3d 56''");
        testItem2.setQuantity(250);
        
      
        testItem2.setUSPrice(BigDecimal.valueOf(900.55));
        
        testPo.getItem().add(testItem2);
        purchaseOrderSlip.setPurchaseOrder(testPo);
        
        
        writeObjectToFile("./log/purchaseOrdertest.xml",purchaseOrderSlip.getClass(),purchaseOrderSlip); 
        
        
       
        
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
   public static void testLoadingPO(){
         System.out.println("loading PO");
    PurchaseOrderInfo test=(PurchaseOrderInfo)loadFromDisk("./log/purchaseOrdertest.xml", PurchaseOrderInfo.class); 
        //traiterOrdreAchat(test);
    
    System.out.println(traiterOrdreAchat(test));
  
   
   }
   
   
   
   private static Object loadFromDisk(String path,Class objectClass){
       Object returnObject=null;
        try {
 
		File file = new File(path);
		JAXBContext jaxbContext = JAXBContext.newInstance(objectClass);
 
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		returnObject = (Object) jaxbUnmarshaller.unmarshal(file);
		
 
	  } catch (JAXBException e) {
		e.printStackTrace();
	  }
       return returnObject;
   }
   
   
   private static void createItemList(){
   
       ItemsInfo item=new ItemsInfo();
       ItemsInfo.Item dvd=new ItemsInfo.Item();
       dvd.setPartNum("123-AB");
       dvd.setProductName("DVD player black with multiple tray");
       dvd.setType("DVD player");
       dvd.setUSPrice(BigDecimal.valueOf(72.0));
       item.getItem().add(dvd);
       
       ItemsInfo.Item tv=new ItemsInfo.Item();
       tv.setPartNum("122-AE");
       tv.setProductName("TV Inteligente ");
       tv.setType("DVD player");
       tv.setUSPrice(BigDecimal.valueOf(500.0));
       item.getItem().add(tv);
       
       ItemsInfo.Item camrera=new ItemsInfo.Item();
       camrera.setPartNum("456-CA");
       camrera.setProductName("Camera Numerique 8x");
       camrera.setType("video camera");
       camrera.setUSPrice(BigDecimal.valueOf(220.33));
       item.getItem().add(camrera);
       
       writeObjectToFile("./log/itemList.xml", item.getClass(), item);       
   
   
   
   }
   
   
   
   
     public static boolean traiterOrdreAchat(PurchaseOrderInfo purchaseOrderInfo) {
        //TODO write your implementation code here:
         PurchaseOrder purchaseOrder=purchaseOrderInfo.getPurchaseOrder();
        HashMap<String,ItemsInfo.Item> itemProduced=singletonItems.getInstance().getItemProduced();
        
        
          boolean status=false;
       List<PurchaseOrder.Item> items = purchaseOrder.getItem();
       
       for(PurchaseOrder.Item processedItem:items){
    
        
        
         if(itemProduced.get(processedItem.getPartNum())!=null&&processedItem.getUSPrice().compareTo(itemProduced.get(processedItem.getPartNum()).getUSPrice())>=0){
             status=true;
             int quantity=processedItem.getQuantity();
             while(quantity/processedItem.getQuantity()>1){
             //produire();
             quantity=quantity-100;
             
             }
        } else{
         status=false;}
         
        }
        if(status){
             try {
 
		File file = new File("E:\\universite\\GTI777\\gti777-supplyChain\\gti777-lab3\\data\\PO.xml");
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
        
        return status;
    }
     
     
     public static ItemsInfo.Item  obtenirInfoProduit(@WebParam(name = "partNum") String partNum) {
        //TODO write your implementation code here:
         HashMap<String,ItemsInfo.Item>itemProduced= singletonItems.getInstance().getItemProduced();
        ItemsInfo.Item returnedItem=null;
         if(itemProduced.containsKey(partNum)){
        returnedItem=itemProduced.get(partNum);
            
        }
         return returnedItem;
    }
     
     
     
     
      public static Boolean receivePayment( BigInteger numOrdre, BigInteger prixTotal) {
       
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
     
     private static void testProject(){
         System.out.print("testing");
     ListeItem list=new ListeItem();
         ListeItem.Item item=new ListeItem.Item();
         item.setPartNum("123-AB");
         item.setQuantity(BigInteger.valueOf(5));
         item.setUSPrice(BigDecimal.valueOf(500.10));
         item.setProductName("DVD player black with multiple tray" );
        
     list.getItem().add(item);
     Client client= new Client();
     client.setName("sfdsd");
        StatutListeItemExpedier result= expedierProduits(list, client);
       // System.out.print(" adedwdAEW");
        System.out.print(result.getItem().listIterator().next().getQuantity());
        
     
     
     
     }

    private static StatutListeItemExpedier expedierProduits(org.netbeans.xml.examples.purchaseorder.ListeItem listeitem, org.netbeans.xml.examples.purchaseorder.Client client) {
        Warehouse_Service service = new warehouse.Warehouse_Service();
        Warehouse port = service.getWarehousePort();
        System.out.println("test expedier");
        return port.expedierProduits(listeitem, client);
    }

   
    
}
