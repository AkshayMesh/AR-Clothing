package me.akshay.arclothing.databinding;
import me.akshay.arclothing.R;
import me.akshay.arclothing.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemFearureProductBindingImpl extends ItemFearureProductBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.iv_grid_product_image, 4);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemFearureProductBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private ItemFearureProductBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[4]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[1]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.tvGridProductPreviousPriceRight.setTag(null);
        this.tvGridProductPrice.setTag(null);
        this.tvTitle.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.featureModel == variableId) {
            setFeatureModel((me.akshay.arclothing.common.models.ProductModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setFeatureModel(@Nullable me.akshay.arclothing.common.models.ProductModel FeatureModel) {
        this.mFeatureModel = FeatureModel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.featureModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String stringValueOfFeatureModelPreviousPrice = null;
        float featureModelCurrentPrice = 0f;
        float featureModelPreviousPrice = 0f;
        java.lang.String featureModelTitle = null;
        java.lang.String stringValueOfFeatureModelCurrentPrice = null;
        me.akshay.arclothing.common.models.ProductModel featureModel = mFeatureModel;

        if ((dirtyFlags & 0x3L) != 0) {



                if (featureModel != null) {
                    // read featureModel.currentPrice
                    featureModelCurrentPrice = featureModel.currentPrice;
                    // read featureModel.previousPrice
                    featureModelPreviousPrice = featureModel.previousPrice;
                    // read featureModel.title
                    featureModelTitle = featureModel.title;
                }


                // read String.valueOf(featureModel.currentPrice)
                stringValueOfFeatureModelCurrentPrice = java.lang.String.valueOf(featureModelCurrentPrice);
                // read String.valueOf(featureModel.previousPrice)
                stringValueOfFeatureModelPreviousPrice = java.lang.String.valueOf(featureModelPreviousPrice);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvGridProductPreviousPriceRight, stringValueOfFeatureModelPreviousPrice);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvGridProductPrice, stringValueOfFeatureModelCurrentPrice);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvTitle, featureModelTitle);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): featureModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}