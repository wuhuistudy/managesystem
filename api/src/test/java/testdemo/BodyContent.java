package testdemo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "state",
        "passport",
        "password",
        "userName",
        "orgId",
        "posId"

})
@XmlRootElement(name = "user:syncUser")
public class BodyContent {

    @XmlElement(required = true,name="sync:state")
    protected String state;
    @XmlElement(required = true,name="sync:passport")
    protected String passport;
    @XmlElement(required = true,name="sync:password")
    protected String password;
    @XmlElement(required = true,name="sync:userName")
    protected String userName;
    @XmlElement(required = true,name="sync:orgId")
    protected String orgId;
    @XmlElement(required = true,name="sync:posId")
    protected String posId;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getPosId() {
        return posId;
    }

    public void setPosId(String posId) {
        this.posId = posId;
    }
}
