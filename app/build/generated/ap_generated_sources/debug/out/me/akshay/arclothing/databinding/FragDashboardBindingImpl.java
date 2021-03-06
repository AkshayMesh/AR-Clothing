package me.akshay.arclothing.databinding;
import me.akshay.arclothing.R;
import me.akshay.arclothing.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragDashboardBindingImpl extends FragDashboardBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.scroll_view, 1);
        sViewsWithIds.put(R.id.relative_layout, 2);
        sViewsWithIds.put(R.id.vp_slider_main, 3);
        sViewsWithIds.put(R.id.layout_slider_main_dots, 4);
        sViewsWithIds.put(R.id.text_view_featured_products, 5);
        sViewsWithIds.put(R.id.rv_feature_product, 6);
        sViewsWithIds.put(R.id.text_view_popular_product, 7);
        sViewsWithIds.put(R.id.rv_offer_product, 8);
        sViewsWithIds.put(R.id.text_view_recent_products, 9);
        sViewsWithIds.put(R.id.rv_p_detail_product_grid, 10);
        sViewsWithIds.put(R.id.progress_bar, 11);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragDashboardBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private FragDashboardBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.LinearLayout) bindings[4]
            , (android.widget.ProgressBar) bindings[11]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[2]
            , (androidx.recyclerview.widget.RecyclerView) bindings[6]
            , (androidx.recyclerview.widget.RecyclerView) bindings[8]
            , (androidx.recyclerview.widget.RecyclerView) bindings[10]
            , (androidx.core.widget.NestedScrollView) bindings[1]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[9]
            , (androidx.viewpager.widget.ViewPager) bindings[3]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
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
            return variableSet;
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
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}