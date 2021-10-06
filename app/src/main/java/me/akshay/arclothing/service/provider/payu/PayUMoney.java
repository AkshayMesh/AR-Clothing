package me.akshay.arclothing.service.provider.payu;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.payumoney.core.PayUmoneyConfig;
import com.payumoney.core.PayUmoneyConstants;
import com.payumoney.core.PayUmoneySdkInitializer;
import com.payumoney.sdkui.ui.utils.PayUmoneyFlowManager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import me.akshay.arclothing.R;
import me.akshay.arclothing.data.util.Loader;
//todo uncomment
abstract public class PayUMoney {
    private Context mContext;
    private String title;
    private String payingFor;
    private String userName;
    private String userMail;
    private String userNumber;
    Loader mLoader;
    private final boolean currentMode = false;
    private PayUmoneySdkInitializer.PaymentParam mPaymentParams;

    public abstract void onDetailsVerified();
    public abstract void onDetailsWrong();

    public PayUMoney(Context mContext, String title, String payingFor) {
        this.mContext = mContext;
        this.title = title;
        this.payingFor = payingFor;
        mLoader = new Loader(mContext);
    }

//    public void getUserDetails(){
//        UserRegistrationInfo urInfo = CustomSharedPrefs.getLoggedInUser(mContext).userRegistrationInfo;
//        userMail = urInfo.useremail;
//        userName = urInfo.userfullname;
//        userNumber = urInfo.usermobileno;
//        getTransactionId();
//    }

//    public void createHashAndStartPnP(float payId) {
//        String transId = SharedPref.getSharedPref(mContext).read(Constants.IntentKey.INVOICE_ID);
//        PayUmoneyConfig payUmoneyConfig = PayUmoneyConfig.getInstance();
//        payUmoneyConfig.setPayUmoneyActivityTitle(title);
//        payUmoneyConfig.setDoneButtonText("Amount ₹" + payId);
//        PayUmoneySdkInitializer.PaymentParam.Builder builder = new PayUmoneySdkInitializer
//                .PaymentParam.Builder();
//        builder.setAmount(String.valueOf(payId))
//                .setTxnId(transId)
//                .setPhone(userNumber)
//                .setProductName(payingFor)
//                .setFirstName(userName)
//                .setEmail(userMail)
//                .setsUrl(Constants.ServerUrl.SURL)
//                .setfUrl(Constants.ServerUrl.FURL)
//                .setUdf1("")
//                .setUdf2("")
//                .setUdf3("")
//                .setUdf4("")
//                .setUdf5("")
//                .setUdf6("")
//                .setUdf7("")
//                .setUdf8("")
//                .setUdf9("")
//                .setUdf10("")
//                .setIsDebug(currentMode)
//                .setKey(Constants.EncryptionKey.PAYU_MARCHAND_KEY)
//                .setMerchantId(Constants.EncryptionKey.PAYU_MERCHAND_ID);
//        try {
//            mPaymentParams = builder.build();
//            StringBuilder stringBuilder = new StringBuilder();
//            HashMap<String, String> params = mPaymentParams.getParams();
//            stringBuilder.append(params.get(PayUmoneyConstants.KEY)).append("|");
//            stringBuilder.append(params.get(PayUmoneyConstants.TXNID)).append("|");
//            stringBuilder.append(params.get(PayUmoneyConstants.AMOUNT)).append("|");
//            stringBuilder.append(params.get(PayUmoneyConstants.PRODUCT_INFO)).append("|");
//            stringBuilder.append(params.get(PayUmoneyConstants.FIRSTNAME)).append("|");
//            stringBuilder.append(params.get(PayUmoneyConstants.EMAIL)).append("|");
//            stringBuilder.append(params.get(PayUmoneyConstants.UDF1)).append("|");
//            stringBuilder.append(params.get(PayUmoneyConstants.UDF2)).append("|");
//            stringBuilder.append(params.get(PayUmoneyConstants.UDF3)).append("|");
//            stringBuilder.append(params.get(PayUmoneyConstants.UDF4)).append("|");
//            stringBuilder.append(params.get(PayUmoneyConstants.UDF5)).append("||||||");
//            stringBuilder.append(Constants.EncryptionKey.SALT);
//            String hash = hashCal(stringBuilder.toString());
//            mPaymentParams.setMerchantHash(hash);
//            startPayUMoneyPnP();
//        } catch (Exception e) {
//            Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_LONG).show();
//            e.printStackTrace();
//        }
//    }

//    private void getTransactionId() {
//        mLoader.show();
//        RetrofitClient.getApiService().getTransId(CustomSharedPrefs.getLoggedInUserId(mContext))
//            .enqueue(new Callback<RequestResponse>() {
//                 @Override
//                 public void onResponse(@NonNull Call<RequestResponse> call
//                         , @NonNull Response<RequestResponse> response) {
//                     if (response.body()!=null){
//                         mLoader.stopLoader();
//                         if (response.body().statusCode==200){
//                             onIdGenerated(response.body());
//                         }else {
//                             Toast.makeText(mContext,response.body().message
//                                     ,Toast.LENGTH_SHORT).show();
//                         }
//                     }
//                 }
//
//                 @Override
//                 public void onFailure(@NonNull Call<RequestResponse> call
//                         , @NonNull Throwable t) {
//                     mLoader.stopLoader();
//                     onDetailsWrong();
//                     t.printStackTrace();
//                     Toast.makeText(mContext,"Unable to start payment"
//                             , Toast.LENGTH_SHORT).show();
//                 }
//            }
//        );
//    }

//    private void onIdGenerated(RequestResponse response) {
//        if (currentMode) {System.out.println();}
//        SharedPref.getSharedPref(mContext).write(Constants.IntentKey.INVOICE_ID
//                , response.data);
////            currentMode = idModels.get(0).mode;
//        onDetailsVerified();
//    }

    private static String hashCal(String str) {
        byte[] hashseq = str.getBytes();
        StringBuilder hexString = new StringBuilder();
        try {
            MessageDigest algorithm = MessageDigest.getInstance("SHA-512");
            algorithm.reset();
            algorithm.update(hashseq);
            byte[] messageDigest = algorithm.digest();
            for (byte aMessageDigest : messageDigest) {
                String hex = Integer.toHexString(0xFF & aMessageDigest);
                if (hex.length() == 1) {
                    hexString.append("0");
                }
                hexString.append(hex);
            }
        } catch (NoSuchAlgorithmException ignored) {
        }
        return hexString.toString();
    }

    private void startPayUMoneyPnP(){
        PayUmoneyFlowManager.startPayUMoneyFlow(mPaymentParams, (Activity) mContext
                , R.style.AppTheme_default, false);
    }
}
