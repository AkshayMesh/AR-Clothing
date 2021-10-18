package me.akshay.arclothing.ui.start;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import me.akshay.arclothing.R;
import me.akshay.arclothing.common.response.MainProductResponse;
import me.akshay.arclothing.data.LocalPreference;
import me.akshay.arclothing.data.util.NetworkHelper;
import me.akshay.arclothing.data.util.StatusBarHelper;
import me.akshay.arclothing.databinding.ActivityStartBinding;
import me.akshay.arclothing.ui.helper.common.UiHelper;
import me.akshay.arclothing.ui.login.LoginActivity;

public class StartActivity extends AppCompatActivity implements Observer<MainProductResponse>{

    private ActivityStartBinding viewBinding;
    private StartViewModel viewModel;
    private StartRepo repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(StartViewModel.class);
        viewBinding = ActivityStartBinding.inflate(getLayoutInflater());
        repo  = new StartRepo(viewModel);

        setContentView(viewBinding.getRoot());
        viewBinding.setViewModel(viewModel);
        viewBinding.executePendingBindings();
        checkNetworkStatus();
    }

    private void checkNetworkStatus() {
        StatusBarHelper.getStatusBarTransparent(this, R.color.transparent);
        if (NetworkHelper.hasNetworkAccess(this)) {
            UiHelper.hideViews(viewBinding.offlineText);

            repo.updateSettings(LocalPreference.getLoggedInUserId(this));
            viewModel.getMainLiveData().observe(this, this);
            viewModel.getErrorMsg().observe(this, s ->
                Toast.makeText(StartActivity.this, s, Toast.LENGTH_SHORT).show());

        } else UiHelper.showViews(viewBinding.offlineText);
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
                        viewBinding.appNameTv, getString(R.string.title_transition));
        startActivity(intent, options.toBundle());
        finish();
    }

    @Override
    public void onChanged(MainProductResponse prodResponse) {
        openActivity();
    }
}