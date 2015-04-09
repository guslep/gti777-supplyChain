/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package warehouse;
import com.lab3.fabricant.Fabricant_Service;
import com.lab3.fabricant.ObtenirInfoProduitResponse;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.WebServiceRef;
import org.netbeans.xml.examples.purchaseorder.Client;
import org.netbeans.xml.examples.purchaseorder.Inventory;
import org.netbeans.xml.examples.purchaseorder.ListeItem;
import org.netbeans.xml.examples.purchaseorder.PurchaseOrder;
import org.netbeans.xml.examples.purchaseorder.PurchaseOrderInfo;
import org.netbeans.xml.examples.purchaseorder.StatutListeItemExpedier;
import org.netbeans.xml.examples.purchaseorder.Warehouse;

/**
 *
 * @author Guillaume
 */

@WebService(serviceName = "warehouse")
public class warehouse {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/gti777-lab3-fabricant/fabricant.wsdl")
    private Fabricant_Service service;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
        
        
        
    }
    private ArrayList <PurchaseOrderInfo> reStockOrder=new ArrayList<PurchaseOrderInfo>();///Au cas ou on aurait plusieurs fabricant

    /**
     * Web service operation
     */
    @WebMethod(operationName = "expedierProduits")
    public StatutListeItemExpedier expedierProduits(@WebParam(name = "Listeitem") ListeItem Listeitem, @WebParam(name = "client") Client client) {
        //TODO write your implementation code here:
        ArrayList<String> itemToReStock=new ArrayList<>();
        
        //updater la quantité setté les objets si quantité négative updater les stock si en bas de X ensuite
        StatutListeItemExpedier commandStatus=new StatutListeItemExpedier();
        
            HashMap<String, Inventory.InventoryItem> inventoryList=singletonItem.getInstance().getHashItem();
        for(ListeItem.Item currentItem :Listeitem.getItem()){
           
            System.out.println("Liste Item"+currentItem.getPartNum());
            if(inventoryList.containsKey(currentItem.getPartNum())){
            Inventory.InventoryItem itempurchased=inventoryList.get(currentItem.getPartNum());
            BigInteger quantityNotShipped=singletonItem.getInstance().updateInventory(currentItem.getPartNum(),currentItem.getQuantity());
               
                if(quantityNotShipped.compareTo(BigInteger.ZERO)<0){
                    itempurchased.setQuantity(BigInteger.ZERO);
                    
                    
                    StatutListeItemExpedier.Item deliveredItem= new StatutListeItemExpedier.Item();
                    deliveredItem.setPartNum(currentItem.getPartNum());
                    deliveredItem.setProductName(currentItem.getProductName());
                    deliveredItem.setQuantity(currentItem.getQuantity().subtract(quantityNotShipped));
                    deliveredItem.setStatus("delivered");
                    commandStatus.getItem().add(deliveredItem);
                    
                    
                    StatutListeItemExpedier.Item notdeliveredItem= new StatutListeItemExpedier.Item();
                    notdeliveredItem.setPartNum(currentItem.getPartNum());
                    notdeliveredItem.setProductName(currentItem.getProductName());
                    notdeliveredItem.setStatus("not deliverd");
                    notdeliveredItem.setQuantity(quantityNotShipped);
                    commandStatus.getItem().add(notdeliveredItem);
                    
                    
                    
                
                }
                else{
                    
                    StatutListeItemExpedier.Item deliveredItem= new StatutListeItemExpedier.Item();
                    deliveredItem.setPartNum(currentItem.getPartNum());
                    deliveredItem.setProductName(currentItem.getProductName());
                    deliveredItem.setStatus("delivered");
                    deliveredItem.setQuantity(currentItem.getQuantity());                   
                    commandStatus.getItem().add(deliveredItem);
                    itempurchased.setQuantity(itempurchased.getQuantity().subtract(currentItem.getQuantity()));
                }
                
                if(itempurchased.getQuantity().compareTo(BigInteger.valueOf(30))<0){
               itemToReStock.add(itempurchased.getPartNum());
                }
                
            }
        
        }
        try {
            remplir(itemToReStock);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(warehouse.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("returning listeItem");
        return commandStatus;
    }

   
    
    
        private void passerCommande() {
            
            traiterOrdreAchat(reStockOrder.get(0));//on a jsute un fabricant mais on pourrait en avoir plus
    }

    private boolean traiterOrdreAchat(org.netbeans.xml.examples.purchaseorder.PurchaseOrderInfo purchaseOrder) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.lab3.fabricant.Fabricant port = service.getFabricantPort();
        return port.traiterOrdreAchat(purchaseOrder);
    }

    private boolean remplir(ArrayList<String> itemToReStock) throws DatatypeConfigurationException {
       
        
        PurchaseOrderInfo newPO=new PurchaseOrderInfo();
     
        Warehouse thisWarehouse=singletonWareHouse.getInstance().getWarehouseInfo();
        
        
        newPO.setBillTo(thisWarehouse.getBillTo());
        newPO.setShipTo(thisWarehouse.getLocation());
        newPO.setClientId(thisWarehouse.getIdWarehouse());
        
         GregorianCalendar greg = new GregorianCalendar();
        greg.setTime(new Date());
         XMLGregorianCalendar orderDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(greg);
         newPO.setOrderDate(orderDate);
        greg.add(GregorianCalendar.DAY_OF_YEAR, 30);
        XMLGregorianCalendar ship = DatatypeFactory.newInstance().newXMLGregorianCalendar(greg);
        newPO.setShipDate(ship);
        
        
        newPO.setPurchaseOrderNumber(BigInteger.valueOf(1234567899));
        
        PurchaseOrder purchaseOrderProcesed=new PurchaseOrder();
        
          HashMap<String, Inventory.InventoryItem> inventoryList=singletonItem.getInstance().getHashItem();
        
          for(String itemNum:itemToReStock){
              System.out.println("remplir "+itemNum);
                 System.out.println("remplir ");
            PurchaseOrder.Item newBoughtItem=new PurchaseOrder.Item();        
            Inventory.InventoryItem itemInfo=inventoryList.get(itemNum);
            newBoughtItem.setPartNum(itemNum);
            newBoughtItem.setProductName(itemInfo.getProductName());
            newBoughtItem.setType(itemNum);
            newBoughtItem.setUSPrice(itemInfo.getUSPrice());
            newBoughtItem.setQuantity(100);
            purchaseOrderProcesed.getItem().add(newBoughtItem);
            
        }
        
        newPO.setPurchaseOrder(purchaseOrderProcesed);
        
        return traiterOrdreAchat(newPO);
        
        
        
    }

   

  
}
