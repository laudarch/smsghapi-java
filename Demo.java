import com.smsgh.*;

public class Demo {
    /**
     * Main
     */
    public static void main(String[] args) {
        SmsghApi smsghApi = new SmsghApi();
        smsghApi.setClientId("user123");
        smsghApi.setClientSecret("secret");
		smsghApi.setHostname("127.0.0.1").setPort(1337);
        
        try {
			ApiAccountProfile apiAccountProfile = smsghApi.getAccount().getProfile();
			System.out.println(apiAccountProfile);
        } catch (ApiException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }
}
