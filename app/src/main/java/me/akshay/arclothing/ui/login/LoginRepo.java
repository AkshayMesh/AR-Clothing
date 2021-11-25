package me.akshay.arclothing.ui.login;

import static java.net.HttpURLConnection.HTTP_OK;
import static me.akshay.arclothing.common.index.Constants.ServerUrl.API_TOKEN;
import static me.akshay.arclothing.common.index.Constants.StringConstants.GOOGLE_LOGIN;
import static me.akshay.arclothing.common.index.Constants.StringConstants.PHONE_LOGIN;

import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import me.akshay.arclothing.common.models.UserRegistrationInfo;
import me.akshay.arclothing.common.response.UserRegistrationResponse;
import me.akshay.arclothing.data.web.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepo {
    private final LoginRepoCallBack callBack;
    private static final String TAG = "Login Repo";
    private UserRegistrationInfo account;
    private String verificationId;
    public String accountToken;
    public PhoneAuthProvider.OnVerificationStateChangedCallbacks phoneCallBack;
    private Callback<UserRegistrationResponse> userRegistrationResponseCallback;

    public LoginRepo(LoginRepoCallBack callBack) {
        this.callBack = callBack;
        initPhoneCallBack();
    }

    private void initPhoneCallBack() {
        phoneCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                Log.d(TAG, "onVerificationCompleted");
                account = new UserRegistrationInfo();
                account.loginType = PHONE_LOGIN;
                signInWithCredential(phoneAuthCredential, false);
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                 if (e instanceof FirebaseAuthInvalidCredentialsException) {
                    callBack.setValue("invalid request");
                } else if (e instanceof FirebaseTooManyRequestsException) {
                    callBack.setValue("Please try again later");
                    // The SMS quota for the project has been exceeded
                }callBack.setValue("Unable to log in");

            }

            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                verificationId = s;
                callBack.setValue("SMS Sent");
                callBack.setValue(s, true);
            }
        };
    }

    public void createAuthCredentials(String s){
        account = new UserRegistrationInfo();
        account.loginType = PHONE_LOGIN;
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, s);
        signInWithCredential(credential, false);
    }

    public void onGoogleSignInResult(Intent data) {
        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
        try {
            GoogleSignInAccount account = task.getResult(ApiException.class);
            callBack.setValue("authenticating...");
            firebaseAuthWithGoogleAccount(account);
        }catch (ApiException e){
            e.printStackTrace();
            callBack.setValue("Unable to log in");
        }
    }


    private Call<UserRegistrationResponse> registerViaPhone() {
        return RetrofitClient.getApiService().setUserViaPhone(API_TOKEN, accountToken, account.loginType);
    }

    private Call<UserRegistrationResponse> registerViaGoogle(){
        return RetrofitClient.getApiService().setUserViaGoogle(API_TOKEN, account.userfullname, account.userprofilepath, account.useremail, account.loginType);
    }

    private void firebaseAuthWithGoogleAccount(GoogleSignInAccount account) {
        this.account = new UserRegistrationInfo();
        this.account.loginType = GOOGLE_LOGIN;
        this.account.useremail = account.getEmail();
        this.account.userfullname = account.getDisplayName();
        this.account.userprofilepath = account.getPhotoUrl()!=null ? account.getPhotoUrl().toString() : "";
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        signInWithCredential(credential, true);
    }

    private void signInWithCredential(AuthCredential credential, boolean haveAccount) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()){
                        callBack.setValue(true);
                        registerToServer(haveAccount);
                    }else {
                        if (task.getException() instanceof FirebaseAuthInvalidCredentialsException){
                            callBack.setValue("Invalid code");
                        }else {
                            callBack.setValue("Please try again later");
                        }
                    }
                });
    }

    private void registerToServer(boolean hasAccount) {
        initUserResponseCallBack();
        if (hasAccount)
        registerViaGoogle().enqueue(userRegistrationResponseCallback);
        else registerViaPhone().enqueue(userRegistrationResponseCallback);
    }

    private void initUserResponseCallBack() {
        userRegistrationResponseCallback = new Callback<UserRegistrationResponse>() {
            @Override
            public void onResponse(@NonNull Call<UserRegistrationResponse> call
                    , @NonNull Response<UserRegistrationResponse> response) {
                if (response.body()!=null){
                    Log.d(TAG, "Registering.. got response");
                    if (response.body().statusCode == HTTP_OK){
                        callBack.setValue(response.body());
                    }else {
                        callBack.setValue(response.body().message);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<UserRegistrationResponse> call, @NonNull Throwable t) {
                Log.e(TAG, t.getMessage());
                callBack.setValue("Unable to register account");
            }
        };
    }

}
