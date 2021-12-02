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
import me.akshay.arclothing.databinding.ItemOfferProductBinding;
import me.akshay.arclothing.ui.helper.common.UiHelper;

public class OfferProductAdapter extends RecyclerView.Adapter<OfferProductAdapter.OfferHolder> {

    private ArrayList<ProductModel> productList;
    private Activity context;
    private static final int PRODUCT_AVG = 100;
    public ItemClickListener<ProductModel> mListener;

    public OfferProductAdapter(ArrayList<ProductModel> productList, Activity context) {
        this.productList = productList;
        this.context = context;
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

    @NonNull
    @Override
    public OfferHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemOfferProductBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_offer_product, parent, false);
        return new OfferHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull OfferHolder holder, int position) {
        ProductModel model = productList.get(position);
        holder.setBinding(model);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class OfferHolder extends RecyclerView.ViewHolder {
        final ItemOfferProductBinding binding;
        public OfferHolder(ItemOfferProductBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }

        public void setBinding(ProductModel model){
            itemView.setOnClickListener(view -> mListener.onItemClick(view, model, getAdapterPosition()));
            binding.setOfferProduct(model);
            int offerPricePercent = (int) (PRODUCT_AVG - ((model.currentPrice/model.previousPrice)*PRODUCT_AVG));
            binding.tvOfferPercent.setText(String.format("%s%% OFF",offerPricePercent));
            UiHelper.setUrlToImageView(context, binding.ivGridProductImage, model.imageUri);
        }
    }
}
