package testdemo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.para.app.data.service.AppDataSyncService;
import com.para.app.model.*;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.*;

/**
 * @Created by wuhui
 * @Description wes人员信息同步
 * @Date 2021/3/29 14:45
 */
public class Deml {

    private static final Log logger = LogFactory.getLog(WesAppDataSyncServiceImpl.class);

    private Gson gson;

    public WesAppDataSyncServiceImpl() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        this.gson = gsonBuilder.create();
    }

    @Override
    public String syncData(String operFlag, String operType, String params) {
        if (logger.isDebugEnabled()) {
            logger.debug("【wes系统】调用，operFlag:" + operFlag + ";operType:" + operType + ";params：" + params);
        }
        String ret = null;
        if ("2".equals(operType)) {
            ret = userSync(operFlag, params);
        }if ("6".equals(operType)) {
            //ret = syncOrgD(operFlag, params);
        } if ("7".equals(operType)) {
            ret = genResult("", "SUCCESS", "岗位不需要同步");
        }
        if (logger.isDebugEnabled()) {
            logger.debug("【wes系统】,operFlag:" + operFlag + ";operType:" + operType + ",ret:" + ret);
        }
        return ret;
    }

    private String userSync(String operFlag, String params)
    {
        String ret = "";
        if ("0".equals(operFlag)) {
            ret = updateModel(params,"1");
        } else if ("1".equals(operFlag)) {
            ret = updateModel(params,"1");
        } else if ("2".equals(operFlag)) {
            ret = updateModel(params,"1");
        } else if ("3".equals(operFlag)) {
            ret = updateModel(params,"1");
        } else if ("4".equals(operFlag)) {
            ret = updateModel(params,"1");
        } else if ("5".equals(operFlag)) {
            ret = genResult("不支持修改密码", "SUCCESS", "不支持修改密码");
        } else {
            ret = genResult("暂不支持该操作", "ERROR", "暂不支持该操作");
            logger.error("【wes系统】暂不支持对人员 " + operFlag + " 的操作。");
        }
        return ret;
    }

    private String updateModel(String params,String state) {
        try {
            ParaUserModel jbAll = gson.fromJson(params, ParaUserModel.class);
            AccountUrlInfo urlInfo = jbAll.getUrlInfo();
            String postUrl = urlInfo.getAccAddUrl();
            String  xmlData = "";
            if (StringUtils.isEmpty(postUrl)) {
                return genResult(postUrl, "exception", "接口参数不全:尚未配置新增api或app_secret");
            }
            //根据是同步用户还是组织同步拼接xml
            String postSoap = doPostSoap(postUrl, xmlData, "");
            // 去除转义字符
            String unPostSoap = StringEscapeUtils.unescapeXml(postSoap);
            System.out.println(unPostSoap);
            return null;
        } catch (Exception exception) {
            logger.error("【wes系统】添加或更新人员出错。", exception);
            return genResult(exception.getMessage(), "exception", exception.getMessage());
        }
    }

    private WesUserInfo getSoapParam(ParaUserModel jbAll, String state) {
        UserInfo userInfo = jbAll.getUserInfo();
        OrgInfo orgInfo = jbAll.getOrgInfo();
        AcountInfo accountInfo = jbAll.getAccountInfo();
        WesUserInfo wesUserInfo = new WesUserInfo();
        wesUserInfo.setState(state);
        wesUserInfo.setPassport(accountInfo.getAccountNo());
        wesUserInfo.setPassword(MD5(accountInfo.getAccountPwd()).toUpperCase());
        wesUserInfo.setUserName(userInfo.getUserName());
        wesUserInfo.setOrgId(orgInfo.getOrgId());
        wesUserInfo.setPosId(orgInfo.getParentResOrgId());
        return wesUserInfo;
    }

    private String genResult(String api_url, String result, String jsonResult) {
        Map<String, String> map = new HashMap<>();
        map.put("api_url", api_url);
        map.put("api_ret", result);
        map.put("api_data", jsonResult);
        if (!"SUCCESS".equalsIgnoreCase(result)) {
            logger.info("wes接口调用返回：" + jsonResult);
        }
        return JSONObject.fromObject(map).toString();
    }

    private String MD5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        try {
            byte[] btInput = s.getBytes("UTF-8");
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *
     * @param postUrl
     * @param soapXml
     * @param soapAction
     * @return string
     */
    public static String doPostSoap(String postUrl, String soapXml, String soapAction){
        String retStr = "";
        // 创建HttpClientBuilder
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        // HttpClient
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
        HttpPost httpPost = new HttpPost(postUrl);
        // 设置请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(6000)
                .setConnectTimeout(6000).build();
        httpPost.setConfig(requestConfig);
        try {
            httpPost.setHeader("Content-Type", "text/xml;charset=UTF-8");
            httpPost.setHeader("SOAPAction", soapAction);
            StringEntity data = new StringEntity(soapXml, Charset.forName("UTF-8"));
            httpPost.setEntity(data);
            CloseableHttpResponse response = closeableHttpClient.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) {
                // 打印响应内容
                retStr = EntityUtils.toString(httpEntity, "UTF-8");
                System.out.println("response:" + retStr);
            }
            // 释放资源
            closeableHttpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retStr;
    }

    private String getResultFromWes() {
        String state = "";
        String id = "";
        String orgId = "";
        String orgName = "";
        String orgParentId = "";
        String remark = "";
        String passport = "";
        String password = "";
        String userName = "";
        String orgId = "";
        String posId = "";
        String state = "";

        StringBuffer sb = new StringBuffer();

        if ("3".equals(state)){
            //组织同步
            sb.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:user=\"http://user.api.xplatform.kintiger.com/\" xmlns:sync=\"http://sync.api.xplatform.kintiger.com/\">");
            sb.append("<soapenv:Header/>");
            sb.append("<soapenv:Body>");
            sb.append("<user:syncOrgD>");
            sb.append("<sync:state>"+state+"</sync:state>");
            sb.append("<sync:id>"+id+"</sync:id>");
            sb.append("<sync:orgId>"+orgId+"</sync:orgId>");
            sb.append("<sync:orgName>"+orgName+"</sync:orgName>");
            sb.append("<sync:orgParentId>"+orgParentId+"</sync:orgParentId>");
            sb.append("<sync:orgParentName>"+orgParentName+"</sync:orgParentName>");
            sb.append("<sync:remark>"+remark+"</sync:remark>");
            sb.append("</user:syncOrg");
            sb.append("</soapenv:Body>");
            sb.append("</soapenv:Envelope>");
        }
        else if ("2".equals(state))
        {
            //用户同步
            sb.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:user=\"http://user.api.xplatform.kintiger.com/\" xmlns:sync=\"http://sync.api.xplatform.kintiger.com/\">");
            sb.append("<soapenv:Header/>");
            sb.append("<soapenv:Body>");
            sb.append("<user:syncUser>");
            sb.append("<sync:state>"+state+"</sync:state>");
            sb.append("<sync:passport>"+passport+"</sync:id>");
            sb.append("<sync:password>"+password+"</sync:orgId>");
            sb.append("<sync:userName>"+userName+"</sync:orgName>");
            sb.append("<sync:orgId>"+orgId+"</sync:orgParentId>");
            sb.append("<sync:posId>"+posId+"</sync:orgParentName>");
            sb.append("</user:syncUser");
            sb.append("</soapenv:Body>");
            sb.append("</soapenv:Envelope>");
        }

        String postSoap = doPostSoap(url, sb.toString(), "");
        // 去除转义字符
        String unPostSoap = StringEscapeUtils.unescapeXml(postSoap);
        System.out.println(unPostSoap);
    }

}

