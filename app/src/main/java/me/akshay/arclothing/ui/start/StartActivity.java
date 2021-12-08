package me.akshay.arclothing.ui.start;

import static me.akshay.arclothing.common.index.Constants.PreferenceKeys.MAIN_RESPONSE;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import me.akshay.arclothing.R;
import me.akshay.arclothing.common.index.Constants;
import me.akshay.arclothing.common.response.DashboardResponse;
import me.akshay.arclothing.data.preference.Local;
import me.akshay.arclothing.data.preference.Shared;
import me.akshay.arclothing.data.util.NetworkHelper;
import me.akshay.arclothing.data.util.UtilityClass;
import me.akshay.arclothing.databinding.ActivityStartBinding;
import me.akshay.arclothing.ui.helper.common.StatusBarHelper;
import me.akshay.arclothing.ui.helper.common.UiHelper;
import me.akshay.arclothing.ui.home.HomeActivity;
import me.akshay.arclothing.ui.login.LoginActivity;

public class StartActivity extends AppCompatActivity implements Observer<DashboardResponse>{

    private ActivityStartBinding viewBinding;
    private StartViewModel viewModel;
    private StartRepo repo;
    private long startTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(StartViewModel.class);
        viewBinding = ActivityStartBinding.inflate(getLayoutInflater());
        repo  = new StartRepo(viewModel);
        startTime = System.currentTimeMillis();

        setContentView(viewBinding.getRoot());
        viewBinding.setViewModel(viewModel);
        viewBinding.executePendingBindings();
        checkNetworkStatus();
    }

    private void checkNetworkStatus() {
        StatusBarHelper.getAdaptiveNavBar(this, R.color.start_start);

        if (NetworkHelper.hasNetworkAccess(this)) {
            UiHelper.hideViews(viewBinding.offlineText);
            repo.updateProducts();
            repo.updateSlides();
            repo.updateCats();
            viewModel.getSettings().observe(this, this);
            viewModel.getErrorMsg().observe(this, s ->
                    Toast.makeText(StartActivity.this, s, Toast.LENGTH_SHORT).show());
        } else UiHelper.showViews(viewBinding.offlineText);
    }

    private void checkTimeToFinish(long endTime) {
        Intent intent;
                if (Local.getLogStatus(StartActivity.this)){
                    intent = new Intent(StartActivity.this, HomeActivity.class);
                } else {
        intent = new Intent(StartActivity.this, LoginActivity.class);
                }
        ActivityOptions options = ActivityOptions
                .makeSceneTransitionAnimation(this, viewBinding.appNameTv, getString(R.string.title_transition));

        double differenceInSec = (double) (endTime - startTime) / 1000;
        if (differenceInSec >= 2.5) {
            startActivity(intent, options.toBundle());
            finish();
        } else if (differenceInSec >= 2 && differenceInSec < 2.5) {
            new Handler().postDelayed(() -> {
                startActivity(intent, options.toBundle());
                finish();
            }, 1000);
        } else if (differenceInSec >= 0 && differenceInSec <= 1.9) {
            new Handler().postDelayed(() -> {
                startActivity(intent, options.toBundle());
                finish();
            }, 2000);
        }
    }

    @Override
    public void onChanged(DashboardResponse settings) {
        String error_code;
        if(settings.products == null){
            error_code = "Error : 22001";
        }else if (settings.slides == null){
            error_code = "Error : 22002";
        }else if (settings.categories == null){
            error_code = "Error : 22003";
        }else{
            error_code = "Welcome";
            Shared.setLocaleString(this, MAIN_RESPONSE,UtilityClass.objectToString(settings));
            long endTime = System.currentTimeMillis();
            Shared.setLocaleFlag(this, Constants.PreferenceKeys.IS_BUY_NOW,false);
            Local.setCurrency(this, "₹");
            checkTimeToFinish(endTime);
        }
//        Toast.makeText(this, error_code, Toast.LENGTH_SHORT).show();
    }
}