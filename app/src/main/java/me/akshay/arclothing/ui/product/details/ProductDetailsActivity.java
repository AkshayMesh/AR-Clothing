package me.akshay.arclothing.ui.product.details;

import static me.akshay.arclothing.common.index.Constants.PreferenceKeys.PROD_CODE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import me.akshay.arclothing.R;
import me.akshay.arclothing.common.ItemClickListener;
import me.akshay.arclothing.common.models.ProductModel;
import me.akshay.arclothing.data.preference.Local;
import me.akshay.arclothing.data.room.DatabaseUtil;
import me.akshay.arclothing.data.util.NetworkHelper;
import me.akshay.arclothing.databinding.ActivityProductDetailsBinding;
import me.akshay.arclothing.ui.helper.common.Loader;
import me.akshay.arclothing.ui.helper.common.StatusBarHelper;
import me.akshay.arclothing.ui.helper.common.UiHelper;

public class ProductDetailsActivity extends AppCompatActivity implements ItemClickListener<ProductModel> {

    private ProductRepo repo;
    private ProductViewModel viewModel;
    private ActivityProductDetailsBinding binding;
    private Loader loader;
    private InterestProductAdapter mProductAdapter;
    private ProductModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_details);
        viewModel = new ViewModelProvider(this).get(ProductViewModel.class);
        repo = new ProductRepo(viewModel);
        binding.setLifecycleOwner(this);
        binding.executePendingBindings();
        binding.layoutBuy.setViewModel(viewModel);
        loader = new Loader(this);

        initInterestProductRecycler();
        checkNetworkStatus();

    }

    private void checkNetworkStatus() {
        StatusBarHelper.getAdaptiveNavBar(this, R.color.colorPrimary);
        binding.toolbarLogo.setOnClickListener(l-> onBackPressed());
        if (NetworkHelper.hasNetworkAccess(this)) {
            binding.layoutIncludeNoNet.linearNoInternet.setVisibility(View.GONE);
            binding.scrollView.setVisibility(View.VISIBLE);
            initActivity();
            setObservers();
        }else{
            binding.layoutIncludeNoNet.linearNoInternet.setVisibility(View.VISIBLE);
            binding.scrollView.setVisibility(View.GONE);
            binding.layoutIncludeNoNet.buttonRetry.setOnClickListener(l-> checkNetworkStatus());
        }
    }

    private void setObservers() {
        viewModel.getErrorMsg().observe(this, s -> {
            loader.stopLoader();
            Toast.makeText(ProductDetailsActivity.this, s, Toast.LENGTH_SHORT).show();
            finish();
        });
        viewModel.getProductsResponse().observe(this, rs->
                mProductAdapter.addItem(rs.data));
        viewModel.getProductResponse().observe(this, r->{
            loader.stopLoader();
            setModel(r.data);
            binding.layoutBuy.setViewModel(viewModel);
            binding.layoutImage.pagerIndicator.setVisibility(View.GONE);
            UiHelper.setUrlToImageView(this, binding.layoutImage.ivProductImage, r.data.imageUri);
            setClickActions();
        });
    }

    private void setClickActions() {
        DatabaseUtil.init(this);
        binding.layoutAdd.buttonBuyNow.setOnClickListener(view -> {});
        binding.layoutAdd.fabCart.setOnClickListener(view ->
            AsyncTask.execute(()->
                DatabaseUtil.on().insertItem(DatabaseUtil.getInventoryFromModel(model))));
    }

    private void initActivity() {
        Intent intent = getIntent();
        if (intent != null) {
            String intentValue = intent.getStringExtra(PROD_CODE);
            if(intentValue != null && !intentValue.equals("")){
                loader.show();
                repo.updateDetails(intentValue);
                repo.updateProducts();
            }else {
                Toast.makeText(this, "Product Not Found", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    private void setModel(ProductModel model){
        this.model = model;
        viewModel.title = model.title;
        viewModel.description = model.description;
        viewModel.currentPrice = String.format("%s%s", Local.getCurrency(ProductDetailsActivity.this), model.currentPrice);
        viewModel.previousPrice = String.format("%s%s", Local.getCurrency(ProductDetailsActivity.this), model.previousPrice);
    }

    /**
     * initialization of {@link InterestProductAdapter } with recycler view
     */
    private void initInterestProductRecycler() {
        mProductAdapter = new InterestProductAdapter(new ArrayList<>(), this);
        binding.layoutInterestProduct.recyclerViewInterest.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.layoutInterestProduct.recyclerViewInterest.setAdapter(mProductAdapter);
        mProductAdapter.setItemClickedListener(this);
    }

    @Override
    public void onItemClick(View view, ProductModel item, int i) {
        Intent intent = new Intent(this, ProductDetailsActivity.class);
        intent.putExtra(PROD_CODE, ""+item.productCode);
        ActivityOptions options = ActivityOptions
                .makeSceneTransitionAnimation(this, view, getString(R.string.product_transition));
        startActivity(intent, options.toBundle());
    }
}