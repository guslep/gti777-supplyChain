//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.04.04 at 10:43:50 AM EDT 
//


package org.netbeans.xml.examples.purchaseorder;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for orderList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="orderList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="poSummary" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="purchaseOrderNumber" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *                   &lt;element name="clientId" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *                   &lt;element name="orderPrice" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *                   &lt;element name="status">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="paid"/>
 *                         &lt;enumeration value="not paid"/>
 *                         &lt;enumeration value="open"/>
 *                         &lt;enumeration value="processed"/>
 *                         &lt;enumeration value="shipped"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderList", propOrder = {
    "poSummary"
})
public class OrderList {

    protected List<OrderList.PoSummary> poSummary;

    /**
     * Gets the value of the poSummary property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the poSummary property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPoSummary().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrderList.PoSummary }
     * 
     * 
     */
    public List<OrderList.PoSummary> getPoSummary() {
        if (poSummary == null) {
            poSummary = new ArrayList<OrderList.PoSummary>();
        }
        return this.poSummary;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;all>
     *         &lt;element name="purchaseOrderNumber" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
     *         &lt;element name="clientId" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
     *         &lt;element name="orderPrice" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
     *         &lt;element name="status">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="paid"/>
     *               &lt;enumeration value="not paid"/>
     *               &lt;enumeration value="open"/>
     *               &lt;enumeration value="processed"/>
     *               &lt;enumeration value="shipped"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/all>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class PoSummary {

        @XmlElement(required = true)
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger purchaseOrderNumber;
        @XmlElement(required = true)
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger clientId;
        @XmlElement(required = true)
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger orderPrice;
        @XmlElement(required = true)
        protected String status;

        /**
         * Gets the value of the purchaseOrderNumber property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getPurchaseOrderNumber() {
            return purchaseOrderNumber;
        }

        /**
         * Sets the value of the purchaseOrderNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setPurchaseOrderNumber(BigInteger value) {
            this.purchaseOrderNumber = value;
        }

        /**
         * Gets the value of the clientId property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getClientId() {
            return clientId;
        }

        /**
         * Sets the value of the clientId property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setClientId(BigInteger value) {
            this.clientId = value;
        }

        /**
         * Gets the value of the orderPrice property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getOrderPrice() {
            return orderPrice;
        }

        /**
         * Sets the value of the orderPrice property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setOrderPrice(BigInteger value) {
            this.orderPrice = value;
        }

        /**
         * Gets the value of the status property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStatus() {
            return status;
        }

        /**
         * Sets the value of the status property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStatus(String value) {
            this.status = value;
        }

    }

}
