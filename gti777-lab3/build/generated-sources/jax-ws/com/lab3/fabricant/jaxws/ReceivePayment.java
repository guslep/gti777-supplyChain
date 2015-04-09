
package com.lab3.fabricant.jaxws;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "receivePayment", namespace = "http://fabricant.lab3.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "receivePayment", namespace = "http://fabricant.lab3.com/", propOrder = {
    "numOrdre",
    "prixTotal"
})
public class ReceivePayment {

    @XmlElement(name = "numOrdre", namespace = "")
    private BigInteger numOrdre;
    @XmlElement(name = "prixTotal", namespace = "")
    private BigInteger prixTotal;

    /**
     * 
     * @return
     *     returns BigInteger
     */
    public BigInteger getNumOrdre() {
        return this.numOrdre;
    }

    /**
     * 
     * @param numOrdre
     *     the value for the numOrdre property
     */
    public void setNumOrdre(BigInteger numOrdre) {
        this.numOrdre = numOrdre;
    }

    /**
     * 
     * @return
     *     returns BigInteger
     */
    public BigInteger getPrixTotal() {
        return this.prixTotal;
    }

    /**
     * 
     * @param prixTotal
     *     the value for the prixTotal property
     */
    public void setPrixTotal(BigInteger prixTotal) {
        this.prixTotal = prixTotal;
    }

}
