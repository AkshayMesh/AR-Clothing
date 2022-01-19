package me.akshay.arclothing.databinding;
import me.akshay.arclothing.R;
import me.akshay.arclothing.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragSearchBindingImpl extends FragSearchBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.appBarLayout, 1);
        sViewsWithIds.put(R.id.search_head, 2);
        sViewsWithIds.put(R.id.toolbar, 3);
        sViewsWithIds.put(R.id.et_seach_product, 4);
        sViewsWithIds.put(R.id.btn_search, 5);
        sViewsWithIds.put(R.id.layout_linear, 6);
        sViewsWithIds.put(R.id.tv_no_products, 7);
        sViewsWithIds.put(R.id.tv_category_name, 8);
        sViewsWithIds.put(R.id.rv_category, 9);
        sViewsWithIds.put(R.id.rv_serach_product_grid, 10);
        sViewsWithIds.put(R.id.progress_bar, 11);
        sViewsWithIds.put(R.id.pbar_container, 12);
        sViewsWithIds.put(R.id.start_progress, 13);
    }
    // views
    @NonNull
    private final androidx.coordinatorlayout.widget.CoordinatorLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragSearchBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private FragSearchBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.appbar.AppBarLayout) bindings[1]
            , (android.widget.ImageButton) bindings[5]
            , (android.widget.EditText) bindings[4]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.RelativeLayout) bindings[12]
            , (android.widget.ProgressBar) bindings[11]
            , (androidx.recyclerview.widget.RecyclerView) bindings[9]
            , (androidx.recyclerview.widget.RecyclerView) bindings[10]
            , (android.widget.TextView) bindings[2]
            , (com.airbnb.lottie.LottieAnimationView) bindings[13]
            , (androidx.cardview.widget.CardView) bindings[3]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[7]
            );
        this.mboundView0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) bindings[0];
        this.mboundView0.setTag(null);
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
            setViewModel((me.akshay.arclothing.ui.search.SearchViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable me.akshay.arclothing.ui.search.SearchViewModel ViewModel) {
        this.mViewModel = ViewModel;
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
        // batch finished
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