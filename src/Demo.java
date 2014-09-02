
import com.smsgh.ApiHost;
import com.smsgh.BasicAuth;
import com.smsgh.HttpRequestException;
import com.smsgh.Message;
import com.smsgh.MessageResponse;
import com.smsgh.MessagingApi;
import java.util.Calendar;

/**
 *
 * @author Arsene
 */
public class Demo {

    public static void main(String[] args) throws Exception {

        BasicAuth auth = new BasicAuth("user123", "password123");
        ApiHost host = new ApiHost(auth);

        // Instance of the Messaging API
        MessagingApi messagingApi = new MessagingApi(host);

        try {
            // Here we will send the message next week
            Message message = new Message();
            message.setContent("Hello Arsene...");
            message.setFrom("Arsene");
            message.setTo("+233247063817");
            message.setRegisteredDelivery(true);

            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_WEEK, 1);
            message.setTime(cal.getTime());
            MessageResponse response = messagingApi.sendMessage(message);

            System.out.println("Server " + response.getMessageId());
        } catch (HttpRequestException ex) {
            System.out.println("Exception Server Response Status " + ex.getHttpResponse().getStatus());
            System.out.println("Exception Server Response Body " + ex.getHttpResponse().getBodyAsString());
        }

    }
}
