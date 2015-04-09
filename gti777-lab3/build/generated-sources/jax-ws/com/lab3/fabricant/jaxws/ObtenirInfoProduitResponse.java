
package com.lab3.fabricant.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "obtenirInfoProduitResponse", namespace = "http://fabricant.lab3.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "obtenirInfoProduitResponse", namespace = "http://fabricant.lab3.com/")
public class ObtenirInfoProduitResponse {

    @XmlElement(name = "return", namespace = "")
    private org.netbeans.xml.examples.purchaseorder.ItemsInfo.Item _return;

    /**
     * 
     * @return
     *     returns Item
     */
    public org.netbeans.xml.examples.purchaseorder.ItemsInfo.Item getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(org.netbeans.xml.examples.purchaseorder.ItemsInfo.Item _return) {
        this._return = _return;
    }

}
