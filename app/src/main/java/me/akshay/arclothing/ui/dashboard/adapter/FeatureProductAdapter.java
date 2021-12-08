package me.akshay.arclothing.ui.dashboard.adapter;

import android.app.Activity;
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
import me.akshay.arclothing.databinding.ItemFearureProductBinding;
import me.akshay.arclothing.ui.dashboard.DashboardViewModel;
import me.akshay.arclothing.ui.helper.common.UiHelper;

public class FeatureProductAdapter extends RecyclerView.Adapter<FeatureProductAdapter.FeatureProductHolder> {

    private final ArrayList<ProductModel> productList;
    private final Activity context;
    public ItemClickListener<ProductModel> mListener;


    public FeatureProductAdapter(ArrayList<ProductModel> categoryList, Activity context ) {
        this.productList = categoryList;
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
    public FeatureProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFearureProductBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_fearure_product, parent, false);
        return new FeatureProductHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FeatureProductHolder holder, int position) {
        ProductModel model = productList.get(position);
        holder.bind(model);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class FeatureProductHolder extends RecyclerView.ViewHolder {
        final ItemFearureProductBinding binding;
        public FeatureProductHolder(ItemFearureProductBinding binding){
            super (binding.getRoot());
            this.binding = binding;
        }
        public void bind(ProductModel model){
            itemView.setOnClickListener(view -> mListener.onItemClick(view, model, getAdapterPosition()));
            binding.setFeatureModel(getViewModel(model));
            UiHelper.setUrlToImageView(context, binding.ivGridProductImage, model.imageUri);
        }
    }

    private DashboardViewModel getViewModel(ProductModel model){
        DashboardViewModel subModel = new DashboardViewModel();
        subModel.title = model.title;
        subModel.currentPrice = String.format("%s%s", Local.getCurrency(context), model.currentPrice);
        subModel.previousPrice = String.format("%s%s", Local.getCurrency(context), model.previousPrice);
        return subModel;
    }
}
