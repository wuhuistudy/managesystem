package testdemo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "header",
        "body"
})
@XmlRootElement(name = "soapenv:Envelope")
public class RequestEntity {

    @XmlAttribute(name="xmlns:soapenv")
    protected String soapenv="http://schemas.xmlsoap.org/soap/envelope/";
    @XmlAttribute(name="xmlns:user")
    protected String user="http://user.api.xplatform.kintiger.com";

    @XmlAttribute(name="xmlns:sync")
    protected String sync="http://sync.api.xplatform.kintiger.com";

    @XmlElement(required = true,name="soapenv:Header")
    protected RequestHeader header;

    @XmlElement(required = true,name="soapenv:Body")
    protected RequestBody body;

    public String getSoapenv() {
        return soapenv;
    }

    public void setSoapenv(String soapenv) {
        this.soapenv = soapenv;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSync() {
        return sync;
    }

    public void setSync(String sync) {
        this.sync = sync;
    }

    public RequestHeader getHeader() {
        return header;
    }

    public void setHeader(RequestHeader header) {
        this.header = header;
    }

    public RequestBody getBody() {
        return body;
    }

    public void setBody(RequestBody body) {
        this.body = body;
    }
}
