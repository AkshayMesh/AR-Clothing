package me.akshay.arclothing.ui.login;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import me.akshay.arclothing.R;
import me.akshay.arclothing.data.util.NetworkHelper;
import me.akshay.arclothing.databinding.ActivityLoginBinding;
import me.akshay.arclothing.databinding.ActivityStartBinding;
import me.akshay.arclothing.ui.helper.common.StatusBarHelper;
import me.akshay.arclothing.ui.start.StartRepo;
import me.akshay.arclothing.ui.start.StartViewModel;

import android.view.Menu;
import android.view.MenuItem;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private LoginViewModel viewModel;
    private LoginRepo repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        repo  = new LoginRepo(viewModel);

        setContentView(binding.getRoot());
        binding.setViewModel(viewModel);
        binding.executePendingBindings();
        checkNetworkStatus();
    }

    private void checkNetworkStatus() {
        StatusBarHelper.getAdaptiveNavBar(this, R.color.white);

        if (NetworkHelper.hasNetworkAccess(this)) {

        }
    }

}