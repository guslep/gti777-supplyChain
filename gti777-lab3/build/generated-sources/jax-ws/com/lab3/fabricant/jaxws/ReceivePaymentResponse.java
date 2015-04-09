
package com.lab3.fabricant.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "receivePaymentResponse", namespace = "http://fabricant.lab3.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "receivePaymentResponse", namespace = "http://fabricant.lab3.com/")
public class ReceivePaymentResponse {

    @XmlElement(name = "return", namespace = "")
    private Boolean _return;

    /**
     * 
     * @return
     *     returns Boolean
     */
    public Boolean getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(Boolean _return) {
        this._return = _return;
    }

}
