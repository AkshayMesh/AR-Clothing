package me.akshay.arclothing.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

import me.akshay.arclothing.R;
import me.akshay.arclothing.data.preference.Local;
import me.akshay.arclothing.databinding.ActivityLoginBinding;
import me.akshay.arclothing.ui.helper.common.StatusBarHelper;
import me.akshay.arclothing.ui.helper.common.UiHelper.LaunchActivityForResult;
import me.akshay.arclothing.ui.home.HomeActivity;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private LoginViewModel viewModel;
    private LoginRepo repo;
    private GoogleSignInClient mClient;
    private ActivityResultLauncher<Intent> activityLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        repo  = new LoginRepo(viewModel);

        setContentView(binding.getRoot());
        binding.setViewModel(viewModel);
        binding.executePendingBindings();
        StatusBarHelper.getAdaptiveNavBar(this, R.color.start_start);
        initSignInResults();
        initSignInOptions();
    }

    private void initSignInResults() {
//        viewModel.getLoginStatus().observe(this, (flag)->{
//            if (flag){
//                Local.setUserLog(LoginActivity.this, viewModel.getAccount());
//                initSignInOptions();
//            }
//        });
        viewModel.getUserSignInResponse().observe(this, (response)->{
            Local.setUserLog(LoginActivity.this, response);
            initSignInOptions();
        });
        viewModel.getToastMessage().observe(this, (msg)->{
            if (msg!=null)
            Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
        });
    }

    private void initSignInOptions() {
        if (Local.getLogStatus(this)){
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        }else {
            registerForResult();
            initGoogleSignIn();
            initPhoneAuth();
        }
    }

    private void initPhoneAuth() {
        System.out.println("From View Model : "+viewModel.enteredNumber);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(viewModel.enteredNumber)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(repo.phoneCallBack)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    private void initGoogleSignIn() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.key))
                .requestEmail()
                .build();
        mClient = GoogleSignIn.getClient(this, gso);
        binding.googleBtn.setOnClickListener((v)-> startLogin());
    }

    private void registerForResult() {
        activityLauncher = new LaunchActivityForResult() {
            @Override
            public void onResult(ActivityResult result) {
                if (result.getResultCode() == RESULT_OK) {
                    Intent data = result.getData();
                    repo.onGoogleSignInResult(data);
                }
            }
        }.setLauncher(this);
    }

    private void startLogin() {
        Intent signInIntent = mClient.getSignInIntent();
        activityLauncher.launch(signInIntent);
    }

}