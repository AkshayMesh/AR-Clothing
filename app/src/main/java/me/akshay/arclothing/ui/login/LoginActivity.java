package me.akshay.arclothing.ui.login;

import static me.akshay.arclothing.data.util.UtilityClass.getBuild;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthProvider;

import me.akshay.arclothing.R;
import me.akshay.arclothing.data.preference.Local;
import me.akshay.arclothing.data.room.FoldDatabase;
import me.akshay.arclothing.data.util.UtilityClass;
import me.akshay.arclothing.databinding.ActivityLoginBinding;
import me.akshay.arclothing.ui.helper.common.Loader;
import me.akshay.arclothing.ui.helper.common.StatusBarHelper;
import me.akshay.arclothing.ui.helper.common.UiHelper.LaunchActivityForResult;
import me.akshay.arclothing.ui.home.HomeActivity;

public class LoginActivity extends AppCompatActivity implements LoginBottomSheet.LoginCallBack {

    private ActivityLoginBinding binding;
    private LoginViewModel viewModel;
    private LoginRepo repo;
    private ActivityResultLauncher<Intent> activityLauncher;
    private Loader loader;
    private LoginBottomSheet otpSheet;

    private void initSignInOptions() {
        if (Local.getLogStatus(this)){
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        }else {
            FoldDatabase.init(this);
            initGoogleSignIn();
            initOnClicks();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initOnClicks() {
        binding.tvGetOtp.setOnClickListener(v-> initPhoneAuth());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setLifecycleOwner(this);
        repo  = new LoginRepo(viewModel);
        loader = new Loader(this);
        otpSheet = LoginBottomSheet.newInstance(LoginActivity.this);
        binding.setViewModel(viewModel);
        binding.executePendingBindings();

        StatusBarHelper.getAdaptiveNavBar(this, R.color.start_start);
        UtilityClass.hideSoftInput(this);
        registerForResult();
        initSignInResults();
        initSignInOptions();
    }

    private void initSignInResults() {

        viewModel.getLoginStatus().observe(this, (flag)->{
            if (flag){
                if (otpSheet.isVisible())
                    otpSheet.dismiss();
                loader.show();
            }
        });

        viewModel.getUserSignInResponse().observe(this, (response)->{
            if (loader.isShowing())
                loader.stopLoader();
            Local.setUserLog(LoginActivity.this, response);
            initSignInOptions();
        });
        viewModel.getToastMessage().observe(this, (msg)->{
            if (msg!=null)
            Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
            if (loader.isShowing())
                loader.stopLoader();
        });
        viewModel.getToken().observe(this, (s)->
            otpSheet.show(getSupportFragmentManager(), "OTP"));
    }

    private void initPhoneAuth() {
        repo.accountToken = binding.etPhoneNo.getText().toString().trim();
        if (UtilityClass.mobileValidity(repo.accountToken)){
            FirebaseAuth mAuth = FirebaseAuth.getInstance();
            PhoneAuthProvider.verifyPhoneNumber(getBuild(mAuth, this,
                    repo.accountToken, repo.phoneCallBack));
        }else {
            Toast.makeText(this, "Enter valid 10 digit phone number", Toast.LENGTH_SHORT).show();
        }
    }

    private void initGoogleSignIn() {
        binding.googleBtn.setOnClickListener((v)-> startLogin());
    }

    private void registerForResult() {
        activityLauncher = new LaunchActivityForResult() {
            @Override
            public void onResult(ActivityResult result) {
                if (result.getData() != null) {
                    Intent data = result.getData();
                    repo.onGoogleSignInResult(data);
                }else {
                    Toast.makeText(LoginActivity.this, "Login cancel", Toast.LENGTH_SHORT).show();
                }
            }
        }.setLauncher(this);
    }

    private void startLogin() {
        GoogleSignInClient mClient = GoogleSignIn.getClient(this, getBuild(this));
        Intent signInIntent = mClient.getSignInIntent();
        activityLauncher.launch(signInIntent);
    }

    @Override
    public void onCallBack(String otp) {
        repo.createAuthCredentials(otp);
    }
}