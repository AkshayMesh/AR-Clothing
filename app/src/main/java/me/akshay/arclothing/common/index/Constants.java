package me.akshay.arclothing.common.index;

public class Constants {
    public interface IntentKeys {
        int RC_SIGN_IN = 9001;
        int SPLASH_DURATION = 3000;
    }

    public interface IntConstants {
        int LOADER_DELAY = 500;
    }

    public interface StringConstants {
        String BASE = "DATA";
        String APP_KEY = "me_terms";
        String REGISTRATION = "entered";
        String GOOGLE_LOGIN = "google";
        String PROFILE = "photograph";
        String NEW_USER = "new";
        String EMAIL = "email";
        String EMPTY_KEY = "";
        String USER = "user";
    }

    public interface EncryptionKey {
        String ENCRYPTION_KEY = "fedcba9876543210";
        String ENCRYPTION_IV = "0123456789abcdef";
        String PAYU_MARCHAND_KEY = "yeu1PyDI";
        String PAYU_MERCHAND_ID = "7163375";
        String SALT = "Q6MKVCZqrH";
    }

    public interface WebURL {
        String SURL = "https://www.payumoney.com/mobileapp/payumoney/success.php";
        String FURL = "https://www.payumoney.com/mobileapp/payumoney/failure.php";
    }


    public interface ServerUrl {
        String API_TOKEN = "MARHAMADMIN@123456";

        //LOCAL HOST URL
        String PROTOCOL = "http://";
        String IP_ADDRESS = "192.168.0.107";
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
