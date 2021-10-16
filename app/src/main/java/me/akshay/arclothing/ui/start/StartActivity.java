package me.akshay.arclothing.ui.start;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import me.akshay.arclothing.R;
import me.akshay.arclothing.data.util.NetworkHelper;
import me.akshay.arclothing.data.util.StatusBarHelper;
import me.akshay.arclothing.databinding.ActivityStartBinding;
import me.akshay.arclothing.ui.helper.common.UiHelper;
import me.akshay.arclothing.ui.login.LoginActivity;

public class StartActivity extends AppCompatActivity {

    private ActivityStartBinding viewBinding;
    private StartViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new StartViewModel();
        viewBinding = ActivityStartBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());
        viewBinding.setViewModel(viewModel);
        viewBinding.executePendingBindings();

        checkNetworkStatus();
    }

    private void checkNetworkStatus() {
        StatusBarHelper.getStatusBarTransparent(this, R.color.transparent);
        if (NetworkHelper.hasNetworkAccess(this)) UiHelper.hideViews(viewBinding.offlineText);
        else UiHelper.showViews(viewBinding.offlineText);
    }

    private void openActivity() {
        Intent intent;
//                if (LocalPreference.getLogStatus(StartActivity.this)){
//                    intent = new Intent(StartActivity.this, HomeActivity.class);
//                } else {
        intent = new Intent(StartActivity.this, LoginActivity.class);
//                }
        ActivityOptions options = ActivityOptions
                .makeSceneTransitionAnimation(StartActivity.this,
                        viewBinding.appNameTv, getString(R.string.app_name));
        startActivity(intent, options.toBundle());
        finish();
    }

}