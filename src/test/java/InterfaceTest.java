import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

public class InterfaceTest {
    //Get请求
        @Test
    public void GetInterface(){
            Getjiekou getjiekou = new Getjiekou();
            getjiekou.Ginterface("");
        }
    //Post请求
      @Test
    public void PostInterface() throws IOException {
            Postjiekou postjiekou = new Postjiekou();
            postjiekou.Pinterface("http://172.20.52.10:8080/");
      }
      //JSON数据
      @Test
    public void JavaUrltest(){
            JAVAURL javaurl = new JAVAURL();
            javaurl.url("http://172.20.52.10:8080/index.html");
      }
}