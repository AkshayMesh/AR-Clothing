package me.akshay.arclothing.ui.search;

import static me.akshay.arclothing.common.index.Constants.IntConstants.DELAY_INTERVAL;
import static me.akshay.arclothing.common.index.Constants.PreferenceKeys.MAIN_RESPONSE;
import static me.akshay.arclothing.common.index.Constants.PreferenceKeys.PROD_CODE;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import java.util.ArrayList;

import me.akshay.arclothing.R;
import me.akshay.arclothing.common.ItemClickListener;
import me.akshay.arclothing.common.models.CategoryModel;
import me.akshay.arclothing.common.models.ProductModel;
import me.akshay.arclothing.common.response.DashboardResponse;
import me.akshay.arclothing.data.preference.Shared;
import me.akshay.arclothing.data.util.UtilityClass;
import me.akshay.arclothing.databinding.FragSearchBinding;
import me.akshay.arclothing.ui.dashboard.adapter.ProductAdapter;
import me.akshay.arclothing.ui.helper.common.Loader;
import me.akshay.arclothing.ui.helper.common.UiHelper;
import me.akshay.arclothing.ui.product.details.ProductDetailsActivity;

public class SearchFragment extends Fragment implements ItemClickListener<CategoryModel> {

    private SearchViewModel viewModel;
    private SearchRepo repo;
    private FragSearchBinding binding;
    private Activity mActivity;
    private CategoryAdapter catAdapter;
    private ProductAdapter prodAdapter;
    private DashboardResponse dashboard;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_search, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(SearchViewModel.class);
        binding.setLifecycleOwner(this);
        binding.executePendingBindings();
        binding.setViewModel(viewModel);
        repo = new SearchRepo(viewModel);
        initDashboardData();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mActivity = getActivity();
        if (mActivity!=null){
            initRecyclerViews();
            getSearchText();
        }
    }

    private void getSearchText() {
        binding.etSeachProduct.setOnEditorActionListener(this::onEditorAction);
        binding.etSeachProduct.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().length() > 0){
                    UiHelper.hideViews(binding.tvCategoryName, binding.rvCategory, binding.tvNoProducts, binding.rvSerachProductGrid);
                }else {
                    UiHelper.hideViews(binding.pbarContainer, binding.tvNoProducts, binding.rvSerachProductGrid);
                    UiHelper.showViews(binding.tvCategoryName, binding.rvCategory);
               }
            }

            @Override
            public void afterTextChanged(Editable e) {
                if (e.toString().length()>0){
                    UiHelper.showViews(binding.pbarContainer);
                    getSearchResultsFor(e);
                }
            }
        });
    }

    private void getSearchResultsFor(Editable e) {
        ArrayList <ProductModel> mpList = new ArrayList<>();
        new CountDownTimer(DELAY_INTERVAL, 1){
            public  void onTick(long millisUntilFinish){
                mpList.clear();
                mpList.addAll(viewModel.getSortedArray(dashboard.products, e.toString()).data);
            }
            public void onFinish(){
                UiHelper.hideViews(binding.pbarContainer);
                if (mpList.size() > 0){
                    setAdapterWithList(mpList);
                    UiHelper.showViews(binding.rvSerachProductGrid);
                    UiHelper.hideViews(binding.tvNoProducts);
                }else{
                    UiHelper.showViews(binding.tvNoProducts);
                    UiHelper.hideViews(binding.rvSerachProductGrid);
                }
            }
        }.start();
    }

    private void initDashboardData() {
        dashboard = UtilityClass.Converter().fromJson(Shared.getLocaleString(mActivity, MAIN_RESPONSE), DashboardResponse.class);
        if (dashboard == null){
            repo.updateCats();
            viewModel.getCategories().observe(getViewLifecycleOwner(), data ->
                    catAdapter.addItem(data.data));
        } else {
            catAdapter.addItem(dashboard.categories.data);
        }
        repo.updateProducts();
        viewModel.getErrorMsg().observe(getViewLifecycleOwner(), m ->
                Toast.makeText(mActivity, m, Toast.LENGTH_SHORT).show());
        viewModel.getProducts().observe(getViewLifecycleOwner(), data ->
            dashboard.products = data);
    }

    private void initRecyclerViews() {
        catAdapter = new CategoryAdapter(new ArrayList<>(), mActivity);
        catAdapter.setItemClickListener(this);
        binding.rvCategory.setHasFixedSize(true);
        binding.rvCategory.setLayoutManager(new GridLayoutManager(mActivity, 2));
        binding.rvCategory.setAdapter(catAdapter);

        prodAdapter = new ProductAdapter(new ArrayList<>(), mActivity);
        binding.rvSerachProductGrid.setHasFixedSize(false);
        binding.rvSerachProductGrid.setLayoutManager(new GridLayoutManager(mActivity, 2));
        binding.rvSerachProductGrid.setAdapter(prodAdapter);
    }

    private void setAdapterWithList(ArrayList<ProductModel> mpList){
        prodAdapter = new ProductAdapter(mpList, mActivity);
        prodAdapter.setItemClickedListener(this::onSearchItemClick);
        binding.rvSerachProductGrid.setAdapter(prodAdapter);
    }

    private void onSearchItemClick(View v, ProductModel m, int p) {
        Intent intent = new Intent(mActivity, ProductDetailsActivity.class);
        intent.putExtra(PROD_CODE, ""+m.productCode);
        ActivityOptions options = ActivityOptions
                .makeSceneTransitionAnimation(mActivity, v, getString(R.string.product_transition));
        startActivity(intent, options.toBundle());
    }

    @Override
    public void onItemClick(View view, CategoryModel item, int i) {

    }

    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            UtilityClass.hideSoftInput(mActivity);
            return true;
        }
        return false;
    }

}
