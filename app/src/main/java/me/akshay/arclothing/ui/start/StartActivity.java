package me.akshay.arclothing.ui.start;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.net.HttpURLConnection;

import me.akshay.arclothing.R;
import me.akshay.arclothing.common.index.Constants;
import me.akshay.arclothing.common.models.Slider;
import me.akshay.arclothing.common.response.MainProductResponse;
import me.akshay.arclothing.common.response.SettingsResponse;
import me.akshay.arclothing.data.preference.Local;
import me.akshay.arclothing.data.preference.Shared;
import me.akshay.arclothing.data.util.NetworkHelper;
import me.akshay.arclothing.databinding.ActivityStartBinding;
import me.akshay.arclothing.ui.helper.common.StatusBarHelper;
import me.akshay.arclothing.ui.helper.common.UiHelper;
import me.akshay.arclothing.ui.login.LoginActivity;

public class StartActivity extends AppCompatActivity implements Observer<SettingsResponse>{

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
        StatusBarHelper.getAdaptiveNavBar(this, R.color.white);

        if (NetworkHelper.hasNetworkAccess(this)) {
            UiHelper.hideViews(viewBinding.offlineText);
            repo.updateSettings(Local.getLoggedInUserId(this));

            viewModel.getSettingsLiveData().observe(this, this);
            viewModel.getErrorMsg().observe(this, s ->
                    Toast.makeText(StartActivity.this, s, Toast.LENGTH_SHORT).show());
            viewModel.getMainLiveData().observe(this, this::onChanged);
        } else UiHelper.showViews(viewBinding.offlineText);
    }

    private void onChanged(MainProductResponse mainResponse) {
        long endTime = System.currentTimeMillis();
        if (mainResponse.statusCode == HttpURLConnection.HTTP_OK) {
            mainResponse.isOkay = mainResponse.dataModel != null;
        } else {
            mainResponse.isOkay = false;
        }
        Local.setMainResponse(this, mainResponse);
        if (mainResponse.dataModel.mSliderMains!=null){
            Slider slider = new Slider();
            slider.mSliderMains = mainResponse.dataModel.mSliderMains;
            if (slider.mSliderMains.size()>0){
                Local.setSlider(this, slider);
                checkTimeToFinish(endTime);
            }else {
                Toast.makeText(this,"Unable to connect to server",Toast.LENGTH_LONG).show();
            }
        }
    }

    private void checkTimeToFinish(long endTime) {
        Intent intent;
//                if (LocalPreference.getLogStatus(StartActivity.this)){
//                    intent = new Intent(StartActivity.this, HomeActivity.class);
//                } else {
        intent = new Intent(StartActivity.this, LoginActivity.class);
//                }
        ActivityOptions options = ActivityOptions
                .makeSceneTransitionAnimation(StartActivity.this,
                        viewBinding.appNameTv, getString(R.string.title_transition));

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
    public void onChanged(SettingsResponse settings) {
        if(settings.settingsModel.currencyFont == null){
            settings.settingsModel.currencyFont = "₹";
        }

        Shared.setLocaleFlag(this, Constants.PreferenceKeys.IS_BUY_NOW,false);
        Local.setCurrency(this, settings.settingsModel.currencyFont);
        Shared.setLocaleString(this, Constants.PreferenceKeys.TAX, settings.settingsModel.tax);
        Shared.setLocaleString(this, Constants.PreferenceKeys.MERCHANT_ID,
                settings.settingsModel.paymentModel.merchantId);
        Shared.setLocaleString(this, Constants.PreferenceKeys.ENVIRONMENT,
                settings.settingsModel.paymentModel.environment);
        Shared.setLocaleString(this, Constants.PreferenceKeys.PUBLIC_KEY,
                settings.settingsModel.paymentModel.publicKey);
        Shared.setLocaleString(this, Constants.PreferenceKeys.PRIVATE_KEY,
                settings.settingsModel.paymentModel.privateKey);
        Shared.setLocaleString(this, Constants.PreferenceKeys.COMPANY_NAME,
                settings.settingsModel.addressModel.companyName);

    }
}