package me.akshay.arclothing.ui.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import me.akshay.arclothing.R;
import me.akshay.arclothing.common.ItemClickListener;
import me.akshay.arclothing.common.models.CategoryModel;
import me.akshay.arclothing.databinding.ItemCategoryBinding;
import me.akshay.arclothing.ui.helper.common.UiHelper;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {

    private final ArrayList<CategoryModel> categories;
    private final Context mContext;
    public ItemClickListener<CategoryModel> mListener;

    public CategoryAdapter(ArrayList<CategoryModel> categories, Context mContext) {
        this.categories = categories;
        this.mContext = mContext;
    }

    public void addItem(ArrayList<CategoryModel> newList){
        this.categories.addAll(newList);
        notifyItemInserted(categories.size() - 1);
    }

    public void setItemClickListener(ItemClickListener<CategoryModel> mListener) {
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCategoryBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.item_category, parent, false);
        return new CategoryHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
        CategoryModel model = categories.get(position);
        holder.setBinding(model);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class CategoryHolder extends RecyclerView.ViewHolder {
        private final ItemCategoryBinding binding;
        public CategoryHolder(ItemCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void setBinding(CategoryModel model){
            itemView.setOnClickListener(view -> mListener.onItemClick(view, model, getAdapterPosition()));
            UiHelper.setUrlToImageView(mContext, binding.ivCategoryImage, model.imageUrl);
            binding.setViewModel(model);
        }
    }
}
