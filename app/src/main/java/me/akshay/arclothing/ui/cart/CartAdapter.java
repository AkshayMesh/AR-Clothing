package me.akshay.arclothing.ui.cart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import me.akshay.arclothing.R;
import me.akshay.arclothing.common.ItemClickListener;
import me.akshay.arclothing.common.models.ProductInventory;
import me.akshay.arclothing.data.preference.Local;
import me.akshay.arclothing.databinding.ItemCartBinding;
import me.akshay.arclothing.ui.helper.common.UiHelper;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartItemHolder> {
    private final Context mContext;
    private final ArrayList<ProductInventory> inventories;
    private ItemClickListener<ProductInventory> listener;

    public CartAdapter(Context mContext, ArrayList<ProductInventory> inventories) {
        this.mContext = mContext;
        this.inventories = inventories;
    }

    public void setListener(ItemClickListener<ProductInventory> listener) {
        this.listener = listener;
    }

    public void addItems(ArrayList<ProductInventory> newList){
        if (newList!=null){
            inventories.clear();
            inventories.addAll(newList);
            notifyItemInserted(inventories.size()-1);
        }else {
            Toast.makeText(mContext, "Unable to add Items", Toast.LENGTH_SHORT).show();
        }
    }

    @NonNull
    @Override
    public CartItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCartBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.item_cart, parent, false);
        return new CartItemHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CartItemHolder holder, int position) {
        ProductInventory inventory = inventories.get(position);
        holder.setBinding(inventory);
    }

    @Override
    public int getItemCount() {
        return inventories.size();
    }

    public class CartItemHolder extends RecyclerView.ViewHolder{
        private final ItemCartBinding binding;
        public CartItemHolder(ItemCartBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
        public void setBinding(ProductInventory inventory){
            binding.setViewModel(getViewModel(inventory));
            itemView.setOnClickListener(view -> listener.onItemClick(binding.ivCartProductImage, inventory, getAdapterPosition()));
            UiHelper.setUrlToImageView(mContext, binding.ivCartProductImage, inventory.imageUri);
        }
    }

    private CartViewModel getViewModel(ProductInventory inventory) {
        CartViewModel model = new CartViewModel();
        model.title = inventory.productName;
        model.price = String.format("%s%s", Local.getCurrency(mContext), inventory.price);
        model.quantity = String.valueOf(inventory.currentQuantity);
        return model;
    }

}
