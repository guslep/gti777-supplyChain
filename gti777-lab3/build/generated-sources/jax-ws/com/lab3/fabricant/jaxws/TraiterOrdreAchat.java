
package com.lab3.fabricant.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.netbeans.xml.examples.purchaseorder.PurchaseOrderInfo;

@XmlRootElement(name = "traiterOrdreAchat", namespace = "http://fabricant.lab3.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "traiterOrdreAchat", namespace = "http://fabricant.lab3.com/")
public class TraiterOrdreAchat {

    @XmlElement(name = "purchaseOrder", namespace = "")
    private PurchaseOrderInfo purchaseOrder;

    /**
     * 
     * @return
     *     returns PurchaseOrderInfo
     */
    public PurchaseOrderInfo getPurchaseOrder() {
        return this.purchaseOrder;
    }

    /**
     * 
     * @param purchaseOrder
     *     the value for the purchaseOrder property
     */
    public void setPurchaseOrder(PurchaseOrderInfo purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

}
