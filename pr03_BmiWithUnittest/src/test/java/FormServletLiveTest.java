
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;



public class FormServletLiveTest {

    @Test
    public void whenPostRequestUsingHttpClient_thenCorrect ()
            throws Exception {


        HttpClient client = new DefaultHttpClient ();
        HttpPost method = new HttpPost (
                "http://localhost:8080/pr03_BmiWithUnittest/calculateServlet" );

        List<BasicNameValuePair> nvps = new ArrayList<> ();
        nvps.add ( new BasicNameValuePair ( "height", String.valueOf ( 2 ) ) );
        nvps.add ( new BasicNameValuePair ( "weight", String.valueOf ( 80 ) ) );

        method.setEntity ( new UrlEncodedFormEntity ( nvps ) );
        HttpResponse httpResponse = client.execute ( method );

        System.out.println (httpResponse.getStatusLine ());
        assertEquals("Success", httpResponse
          .getHeaders("Test")[0].getValue());
        assertEquals("20.0", httpResponse
          .getHeaders("BMI")[0].getValue());    
    }
}
