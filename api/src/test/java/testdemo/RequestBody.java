package testdemo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "soapenv:Body")
public class RequestBody {

    @XmlElement(required = true,name="user:syncUser")
    public BodyContent syncUser;

    public BodyContent getSyncUser() {
        return syncUser;
    }

    public void setSyncUser(BodyContent syncUser) {
        this.syncUser = syncUser;
    }
}
