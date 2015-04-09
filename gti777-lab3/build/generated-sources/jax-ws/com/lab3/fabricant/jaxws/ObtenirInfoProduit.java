
package com.lab3.fabricant.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "obtenirInfoProduit", namespace = "http://fabricant.lab3.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "obtenirInfoProduit", namespace = "http://fabricant.lab3.com/")
public class ObtenirInfoProduit {

    @XmlElement(name = "partNum", namespace = "")
    private String partNum;

    /**
     * 
     * @return
     *     returns String
     */
    public String getPartNum() {
        return this.partNum;
    }

    /**
     * 
     * @param partNum
     *     the value for the partNum property
     */
    public void setPartNum(String partNum) {
        this.partNum = partNum;
    }

}
