import com.smsgh.AirtimeNetwork;
import com.smsgh.ApiHost;
import com.smsgh.BasicAuth;
import com.smsgh.BrokerApi;
import com.smsgh.BrokerResponse;

/**
 *
 * @author Seth
 */
public class BrokerDemo {

    static String hostname = "api.smsgh.com"; //api url
    static String contextPath = "usp/test/"; //Change to fit test or lvie
    
     static String apiToken = "token";// Token
    static String clientId = "ClientId"; //clientId for smsgh api
    static String clientSecret = "ClientSecrete";//client secret for smsgh api


    public static void main(String[] args) {
        BasicAuth auth = new BasicAuth(clientId, clientSecret);
        ApiHost host = new ApiHost(auth, contextPath);

        //Initialisation of brokerClient
        BrokerApi brokerClient = new BrokerApi(host, apiToken);

        try {
            //Example buy airtime
      
             BrokerResponse response = brokerClient.buyBusyBundle("0244126631", "701", 3, "");
         System.out.println(String.format("isSuccessful : %s", response.isSuccessful()));
            if (response.isSuccessful()) {
                System.out.println(String.format("ProviderId : %s\nStatus\t:%s", response.getProviderId(), "Successful"));
            } else {
                System.out.println(String.format("Reason for Failure : %s", response.getErrorMessage()));
            }
        } catch (Exception e) {
        }

    }
}
