package testdemo;

import org.springframework.web.bind.annotation.RequestHeader;

/**
 * Creat by wuhui on 2020/10/28
 */
public class Test001 {
    public static void main(String[] args) throws Exception {
        /*RequestBody body = new RequestBody();
        BodyContent bodyContent = new BodyContent();
        bodyContent.setState("a1");
        bodyContent.setPassport("a1");
        bodyContent.setOrgId("a1");
        bodyContent.setPassword("a1");
        bodyContent.setUserName("a1");
        bodyContent.setPosId("a1");
        body.setSyncUser(bodyContent);
        String xml = JaxbXmlUtil.convertToXml(body);
        System.out.println(xml);*/
        String xml2 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:user=\"http://user.api.xplatform.kintiger.com/\" xmlns:sync=\"http://sync.api.xplatform.kintiger.com/\"><soapenv:Header><soapenv:Body><user:syncUser><sync:state>\" + state +\"</sync:state><sync:passport>19921110</sync:passport><sync:password>E10ADC3949BA59ABBE56E057F20F883E</sync:password><sync:userName>测试1</sync:userName><sync:orgId>070021000036</sync:orgId><sync:posId>1</sync:posId></user:syncUser></soapenv:Body></soapenv:Header></soapenv:Envelope>";
        RequestEntity requestEntity1 = JaxbXmlUtil.convertToJavaBean(xml2, RequestEntity.class);
        System.out.println(requestEntity1);
        StringBuffer sb = new StringBuffer();
        sb.toString()
    }
}
