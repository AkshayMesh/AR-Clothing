package me.akshay.arclothing.ui.product.details;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import me.akshay.arclothing.R;
import me.akshay.arclothing.databinding.ActivityProductDetailsBinding;

public class ProductDetailsActivity extends AppCompatActivity {

    private ProductRepo repo;
    private ProductViewModel viewModel;
    private ActivityProductDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_details);
        viewModel = new ViewModelProvider(this).get(ProductViewModel.class);
        binding.setLifecycleOwner(this);
        binding.executePendingBindings();

        initActivity();
    }

    private void initActivity() {

    }
}