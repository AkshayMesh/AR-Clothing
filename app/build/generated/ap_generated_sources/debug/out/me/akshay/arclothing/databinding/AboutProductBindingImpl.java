package me.akshay.arclothing.databinding;
import me.akshay.arclothing.R;
import me.akshay.arclothing.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class AboutProductBindingImpl extends AboutProductBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.layout_buy_now, 5);
    }
    // views
    @NonNull
    private final androidx.cardview.widget.CardView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public AboutProductBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private AboutProductBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[4]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[5]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[1]
            );
        this.currentPrice.setTag(null);
        this.mboundView0 = (androidx.cardview.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        this.prevPrice.setTag(null);
        this.textViewProductDescription.setTag(null);
        this.textViewTitle.setTag(null);
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
        if (BR.viewModel == variableId) {
            setViewModel((me.akshay.arclothing.ui.product.details.ProductViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable me.akshay.arclothing.ui.product.details.ProductViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.viewModel);
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
        java.lang.String viewModelCurrentPrice = null;
        me.akshay.arclothing.ui.product.details.ProductViewModel viewModel = mViewModel;
        java.lang.String viewModelTitle = null;
        java.lang.String viewModelDescription = null;
        java.lang.String viewModelPreviousPrice = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (viewModel != null) {
                    // read viewModel.currentPrice
                    viewModelCurrentPrice = viewModel.currentPrice;
                    // read viewModel.title
                    viewModelTitle = viewModel.title;
                    // read viewModel.description
                    viewModelDescription = viewModel.description;
                    // read viewModel.previousPrice
                    viewModelPreviousPrice = viewModel.previousPrice;
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.currentPrice, viewModelCurrentPrice);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.prevPrice, viewModelPreviousPrice);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textViewProductDescription, viewModelDescription);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textViewTitle, viewModelTitle);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}