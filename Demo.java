
import com.smsgh.*;

public class Demo {

    /**
     * Main
     */
    public static void main(String[] args) {
        SmsghApi smsghApi = new SmsghApi();
        smsghApi.setContextPath("v3");
        smsghApi.setClientId("pitnnmim");
        smsghApi.setClientSecret("btfdtdze");

        try {
            ApiMessageResponse response = smsghApi.getMessages().send("SMSGH", "+23324818378", "Hello world!");
        } catch (ApiException ex) {
            System.out.println("Exception: " + ex.getMessage());
            System.out.println("Reason: " + ex.getReason());
            System.out.println("Body: " + ex.getRawBody());
            System.out.println("Description: " + ex.getDescription());
            System.out.println("HTTP Status Code: " + ex.getHttpStatusCode());
            
        }
    }
}
