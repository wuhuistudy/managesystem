package testdemo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "soapenv:Body")
public class RequestBody2 {

    @XmlElement(required = true,name="user:syncOrgD")
    public BodyContent syncOrgD;

    public BodyContent getSyncOrgD() {
        return syncOrgD;
    }

    public void setSyncOrgD(BodyContent syncOrgD) {
        this.syncOrgD = syncOrgD;
    }
}
