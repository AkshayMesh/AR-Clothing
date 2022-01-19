package me.akshay.arclothing.ui.cart;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;

import me.akshay.arclothing.R;
import me.akshay.arclothing.common.ItemClickListener;
import me.akshay.arclothing.common.models.ProductInventory;
import me.akshay.arclothing.data.room.DatabaseUtil;
import me.akshay.arclothing.databinding.FragCartBinding;

public class CartFragment extends Fragment implements ItemClickListener<ProductInventory> {

    private FragCartBinding viewBinding;
    private CartViewModel viewModel;
    private CartAdapter adapter;
    private CartRepo repo;
    private Activity mActivity;
    private ArrayList<ProductInventory> inventories;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewBinding = DataBindingUtil.inflate(inflater, R.layout.frag_cart, container, false);
        return viewBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(CartViewModel.class);
        viewBinding.setLifecycleOwner(this);
        viewBinding.executePendingBindings();
        viewBinding.setViewModel(viewModel);
        repo = new CartRepo(viewModel);
        initCart();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mActivity = getActivity();
        if (mActivity!=null){
            initRecyclerView();
        }
    }

    private void initRecyclerView() {
        adapter = new CartAdapter(mActivity, new ArrayList<>());
        adapter.setListener(this);
    }

    private void initCart() {
        inventories = new ArrayList<>();
        AsyncTask.execute(()->{
            inventories.addAll(DatabaseUtil.on().getAllCodes());
            if (inventories.size()>0){
                adapter.addItems(inventories);
                calculateTotals();
            }
        });
    }

    private void calculateTotals() {
        float total = 0;
        for (ProductInventory p :
                inventories) {
            total += p.newPrice*p.currentQuantity;
        }
        System.out.println("total : "+total);
    }

    @Override
    public void onItemClick(View view, ProductInventory item, int i) {

    }
}
