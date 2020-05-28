import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.util.concurrent.ConcurrentHashMap;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;


public class JAVAURL {
    public void url(String url){
        System.out.println("URL："+url);
        StringBuffer json = new StringBuffer();
        try {
            //实例一个url和URLConnection
            URL oracle = new URL(url);
            //打开链接
            URLConnection yc = oracle.openConnection();
            //输入流作参数传进InputStreamReader并用BufferedReader接受
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream()));
            String inputLine = null;
            //一直读到空，并设置流编码是UTF8
            while ( (inputLine = in.readLine()) != null) {
                json.append(new String(inputLine.getBytes(),"GBK"));
            }
            //记得关闭连接
            in.close();
        } catch (Exception e)  {
            e.printStackTrace();
        }
        try {
            JSONArray jn =  JSONArray.fromObject(json.toString());
            if(jn.size()>0){
                for (int i = 0; i < jn.size(); i++) {
                    JSONObject jo = (JSONObject) jn.get(i);
                    System.out.println(jo.get("id"));
                    System.out.println(jo.get("fdName"));
                }
                System.out.println(jn);
            }
            System.out.println("数据大小："+jn.size());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("连接超时！");
        }
    }
    }

