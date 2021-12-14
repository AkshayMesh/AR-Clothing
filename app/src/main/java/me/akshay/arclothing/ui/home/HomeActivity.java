package me.akshay.arclothing.ui.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import me.akshay.arclothing.R;
import me.akshay.arclothing.data.preference.Local;
import me.akshay.arclothing.data.util.UtilityClass;
import me.akshay.arclothing.databinding.ActivityHomeBinding;
import me.akshay.arclothing.ui.dashboard.DashboardFragment;
import me.akshay.arclothing.ui.helper.common.StatusBarHelper;
import me.akshay.arclothing.ui.helper.common.UiHelper;
import me.akshay.arclothing.ui.login.LoginActivity;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private HomeViewModel viewModel;
    private HomeRepo repo;
    private boolean isRegistered;
    public static boolean visitedDashBoard = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding.setLifecycleOwner(this);
        binding.setViewModel(viewModel);
        binding.executePendingBindings();
        repo  = new HomeRepo(viewModel);
        isRegistered = Local.getLogStatus(this);

        initActivity();
        initBottomNav();
    }

    @SuppressLint("NonConstantResourceId")
    private void initBottomNav() {
        binding.bottomNav.bottomNav.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.search:
//                    startActivity(new Intent(HomeActivity.this, SearchActivity.class));
                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                    break;
                case R.id.cart:
//                    startActivity(new Intent(HomeActivity.this, CartActivity.class));
                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                    break;
                case R.id.profile:
                    if (isRegistered){
//                        startActivity(new Intent(HomeActivity.this, UserDetailActivity.class));
                        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                    }else {
                        UiHelper.openSignInPopUp(HomeActivity.this);
                    }
                    break;
            }
            return true;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        isRegistered = Local.getLogStatus(this);
        if (!isRegistered){
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }
    }

    private void initActivity() {
        StatusBarHelper.getAdaptiveNavBar(this, R.color.colorPrimary);
        UtilityClass.hideSoftInput(this);
        UtilityClass.commitFragment(this, binding.fragmentContainer.getId(), new DashboardFragment());
    }
}