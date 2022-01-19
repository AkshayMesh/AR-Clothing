package me.akshay.arclothing.ui.product.details;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import me.akshay.arclothing.R;
import me.akshay.arclothing.common.ItemClickListener;
import me.akshay.arclothing.common.models.ProductModel;
import me.akshay.arclothing.data.preference.Local;
import me.akshay.arclothing.databinding.ItemRelatedBinding;
import me.akshay.arclothing.ui.helper.common.UiHelper;

public class InterestProductAdapter extends RecyclerView.Adapter<InterestProductAdapter.ProductHolder> {

    private final ArrayList<ProductModel> productList;
    private final Context mContext;
    public ItemClickListener<ProductModel> mListener;

    public InterestProductAdapter(ArrayList<ProductModel> productList, Activity context) {
        this.productList = productList;
        this.mContext = context;
    }

    public void setItemClickedListener(ItemClickListener<ProductModel> itemClickedListener){
        this.mListener = itemClickedListener;
    }

    public void addItem(ArrayList<ProductModel> newList) {
        for (ProductModel products : newList) {
            this.productList.add(products);
            notifyItemInserted(productList.size() - 1);
        }
    }

    public ProductViewModel getViewModel(ProductModel model){
        ProductViewModel subModel = new ProductViewModel();
        subModel.title = model.title;
        subModel.description = model.description;
        subModel.currentPrice = String.format("%s%s", Local.getCurrency(mContext), model.currentPrice);
        subModel.previousPrice = String.format("%s%s", Local.getCurrency(mContext), model.previousPrice);
        return subModel;
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRelatedBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.item_related, parent, false);
        return new ProductHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        ProductModel model = productList.get(position);
        holder.setBinding(model);
    }

    @Override
    public int getItemCount() {
        return Math.min(productList.size(), 6);
    }

    public class ProductHolder extends RecyclerView.ViewHolder {
        private final ItemRelatedBinding binding;
        public ProductHolder(ItemRelatedBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
        public void setBinding(ProductModel model){
            itemView.setOnClickListener(view -> mListener.onItemClick(view, model, getAdapterPosition()));
            UiHelper.setUrlToImageView(mContext, binding.imageView, model.imageUri);
            binding.setModel(getViewModel(model));
        }
    }
}