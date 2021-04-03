package testdemo;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "state",
        "id",
        "orgId",
        "orgName",
        "orgParentId",
        "orgParentName",
        "remark"
})
@XmlRootElement(name = "user:syncOrg")
public class BodyContent2 {

    @XmlElement(required = true,name="sync:state")
    protected String state;
    @XmlElement(required = true,name="sync:orgId")
    protected String orgId;
    @XmlElement(required = true,name="sync:id")
    protected String id;
    @XmlElement(required = true,name="sync:orgName")
    protected String orgName;
    @XmlElement(required = true,name="sync:orgParentId")
    protected String orgParentId;
    @XmlElement(required = true,name="sync:orgParentName")
    protected String orgParentName;
    @XmlElement(required = true,name="sync:remark")
    protected String remark;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgParentId() {
        return orgParentId;
    }

    public void setOrgParentId(String orgParentId) {
        this.orgParentId = orgParentId;
    }

    public String getOrgParentName() {
        return orgParentName;
    }

    public void setOrgParentName(String orgParentName) {
        this.orgParentName = orgParentName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
