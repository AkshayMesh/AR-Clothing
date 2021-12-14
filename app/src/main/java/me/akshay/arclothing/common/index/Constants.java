package me.akshay.arclothing.common.index;

/**
 *
 * Contains confidential data
 * not to be updated or deleted by anyone
 * except for the head developer
 */
public class Constants {

    public interface IntConstants {
        int LOADER_DELAY = 500;
    }

    public interface Credentials {
        String BASE = "DATA";
        String APP_KEY = "me_terms";

        String SHARED_PREF_CURRENCY = "sharedPreferencesCurrency";
        String SHARED_PREF_CURRENCY_IN = "sharedPreferencesCurrencyIn";
    }

    public interface PreferenceKeys{
        String EMPTY_KEY = "";
        String REGISTRATION = "entered";
        String USER = "user";

        String AUTH_TOKEN = "authToken";

        String TAX = "tax";
        String INVOICE = "invoice";

        String IS_BUY_NOW = "is_buy_now";

        String MAIN_RESPONSE = "main_response";

        String PROD_CODE = "productcode";
    }

    public interface StringConstants {
        String GOOGLE_LOGIN = "google";
        String PHONE_LOGIN = "phone";
        String PROFILE = "photograph";
        String NEW_USER = "new";
        String IND_CODE = "+91";
    }

    public interface EncryptionKey {
        String ENCRYPTION_KEY = "fedcba9876543210";
        String ENCRYPTION_IV = "0123456789abcdef";
    }

    public interface WebURL {
        String SURL = "https://www.payumoney.com/mobileapp/payumoney/success.php";
        String FURL = "https://www.payumoney.com/mobileapp/payumoney/failure.php";
    }

    public interface ServerUrl {
        String API_TOKEN = "mAdmin4";

        //LOCAL HOST URL
        String IP_ADDRESS = "192.168.0.104";
        String PROTOCOL = "http://";
        String PARENT = "/vto";
        String MAIN_URL = PROTOCOL+IP_ADDRESS+PARENT+"/api";
        String ROOT_URL = MAIN_URL + "/requests/";
        String FULL_IMAGE_URL = PROTOCOL+IP_ADDRESS+PARENT+"/products/";
        String THUMB_IMAGE_URL = PROTOCOL+IP_ADDRESS+PARENT+"/products/thumb/";
    }

    public interface ParentPath{
        String PRODUCT = "product";
        String SLIDER = "slider";
        String USER = "user";
        String CATS = "category";
    }

    public interface Functions{
        String ADD = "/add";
        String ONE = "/one";
        String ALL = "/all";
    }

    public interface Fields{
        String COMMON_FIELD = "api_token";
    }

    public interface Extensions{
        String PHP = ".php";
    }
}
