package me.akshay.arclothing.ui.dashboard.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import me.akshay.arclothing.R;
import me.akshay.arclothing.common.ItemClickListener;
import me.akshay.arclothing.common.models.ProductModel;
import me.akshay.arclothing.data.preference.Local;
import me.akshay.arclothing.databinding.ItemProductBinding;
import me.akshay.arclothing.ui.dashboard.DashboardViewModel;
import me.akshay.arclothing.ui.helper.common.UiHelper;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {

    private ArrayList<ProductModel> productList;
    private Activity context;
    public ItemClickListener<ProductModel> mListener;

    public ProductAdapter(ArrayList<ProductModel> productList, Activity context) {
        this.productList = productList;
        this.context = context;
    }

    public void addItem(ArrayList<ProductModel> newList) {
        for (ProductModel products : newList) {
            this.productList.add(products);
            notifyItemInserted(productList.size() - 1);
        }
    }

    public void setItemClickedListener(ItemClickListener<ProductModel> itemClickedListener){
        this.mListener = itemClickedListener;
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemProductBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_product, parent, false);
        return new ProductHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        ProductModel model = productList.get(position);
        holder.setBinding(model);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductHolder extends RecyclerView.ViewHolder {
        final ItemProductBinding binding;

        public ProductHolder(@NonNull ItemProductBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void setBinding(ProductModel model){
            itemView.setOnClickListener(view -> mListener.onItemClick(view, model, getAdapterPosition()));
            UiHelper.setUrlToImageView(context, binding.ivProductImage, model.imageUri);
            binding.setModel(getViewModel(model));
        }
    }

    private DashboardViewModel getViewModel(ProductModel model){
        DashboardViewModel subModel = new DashboardViewModel();
        subModel.title = model.title;
        subModel.description = model.description;
        subModel.currentPrice = String.format("%s%s", Local.getCurrency(context), model.currentPrice);
        subModel.previousPrice = String.format("%s%s", Local.getCurrency(context), model.previousPrice);
        return subModel;
    }

}
