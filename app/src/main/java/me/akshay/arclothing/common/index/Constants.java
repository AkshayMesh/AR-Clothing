package me.akshay.arclothing.common.index;

public class Constants {
    public interface IntentKeys {
        int RC_SIGN_IN = 9001;
        int SPLASH_DURATION = 3000;
    }

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
        String REGISTRATION = "entered";
        String USER = "user";

        String EMPTY_KEY = "";

        String TAX = "tax";
        String ENVIRONMENT = "envo";
        String MERCHANT_ID = "m_id";
        String PUBLIC_KEY = "pub_id";
        String PRIVATE_KEY = "pri_id";

        String COMPANY_NAME="company_name";

        String IS_BUY_NOW = "is_buy_now";
        String MAIN_RESPONSE = "main_response";
    }

    public interface StringConstants {
        String GOOGLE_LOGIN = "google";
        String PROFILE = "photograph";
        String NEW_USER = "new";
        String EMAIL = "email";
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
        String API_TOKEN = "MARHAMADMIN@123456";

        //LOCAL HOST URL
        String PROTOCOL = "http://";
        String IP_ADDRESS = "192.168.0.104";
        String PARENT = "/marhamproducts/";

        String MAIN_URL = PROTOCOL+IP_ADDRESS+PARENT+"mhmadmindash/public/";
        String ROOT_URL = MAIN_URL + "api/";
        String FULL_IMAGE_URL = PROTOCOL+IP_ADDRESS+PARENT+"products/";
        String THUMB_IMAGE_URL = PROTOCOL+IP_ADDRESS+PARENT+"products/thumb/";
    }

    public interface Functions{
        String SETTINGS_URL = "settings/setting.php";
        String MAIN_PRODUCT_URL = "product/home.php";
    }

}
