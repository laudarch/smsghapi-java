import com.smsgh.*;

public class Demo {
    /**
     * Main
     */
    public static void main(String[] args) {
        SmsghApi smsghApi = new SmsghApi();
	smsghApi.setContextPath("v3");
        smsghApi.setClientId("user123");
        smsghApi.setClientSecret("secret");
        
        try {
			ApiAccountProfile apiAccountProfile = smsghApi.getAccount().getProfile();
			// Do something with apiAccountProfile.
        } catch (ApiException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }
}
