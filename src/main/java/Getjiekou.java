import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Getjiekou {
    public void Ginterface(String path){
        try {
            //创建url对象
            URL url=new URL(path);
            //打开一个URL连接，并运行客户端访问资源。
            URLConnection urlConnection =(HttpURLConnection)url.openConnection();

            urlConnection.connect();//调用URLConnection对象提供的connect方法连接远程服务
            InputStream is=urlConnection.getInputStream();//获取输入流访问的资源数据

            //通过bufferedReader来读取
            BufferedReader buffer=new BufferedReader(new InputStreamReader(is));
            StringBuffer bs=new StringBuffer();//存储读取的值
            String l=null;
            //判断读取的值存在则存入StringBuffer
            while((l=buffer.readLine())!=null) {
                bs.append(l).append("\n");
            }
            System.out.println(bs.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
