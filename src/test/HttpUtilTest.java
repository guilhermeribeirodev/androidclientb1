package test;

import com.example.androidclientb1.HttpUtil;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: guilherme
 * Date: 11/17/13
 * Time: 3:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class HttpUtilTest {

    @Test
    public void test(){


        try {
            HttpUtil.asd();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
