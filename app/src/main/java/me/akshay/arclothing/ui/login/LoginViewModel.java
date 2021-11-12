package me.akshay.arclothing.ui.login;

import android.content.Intent;

import androidx.databinding.Bindable;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

import me.akshay.arclothing.common.models.UserRegistrationInfo;

public class LoginViewModel extends ViewModel implements LoginRepoCallBack{

    @Bindable
    private String toastMessage = null;
    public String getToastMessage() {
        return toastMessage;
    }
    private void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
    }

    private UserRegistrationInfo account;
    public void onGoogleSignInResult(Intent data) {
        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
        try {
            GoogleSignInAccount account = task.getResult(ApiException.class);
            setToastMessage("authenticating...");
            firebaseAuthWithGoogleAccount(account);
        }catch (ApiException e){
            setToastMessage("Unable to log in");
        }
    }

    private void firebaseAuthWithGoogleAccount(GoogleSignInAccount account) {
        this.account = new UserRegistrationInfo();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()){

                    }else {
                        setToastMessage("Please try again later");
                    }
                });
    }

}
