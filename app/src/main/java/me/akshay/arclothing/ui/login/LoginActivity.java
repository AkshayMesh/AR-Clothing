package me.akshay.arclothing.ui.login;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import me.akshay.arclothing.R;
import me.akshay.arclothing.databinding.ActivityLoginBinding;
import android.view.Menu;
import android.view.MenuItem;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.setViewModel(viewModel);
        binding.executePendingBindings();

    }

}