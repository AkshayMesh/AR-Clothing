package me.akshay.arclothing.databinding;
import me.akshay.arclothing.R;
import me.akshay.arclothing.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityProductDetailsBindingImpl extends ActivityProductDetailsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(16);
        sIncludes.setIncludes(1, 
            new String[] {"layout_product_details", "about_product", "layout_product_actions", "layout_interest_product", "layout_no_internet"},
            new int[] {2, 3, 4, 5, 6},
            new int[] {me.akshay.arclothing.R.layout.layout_product_details,
                me.akshay.arclothing.R.layout.about_product,
                me.akshay.arclothing.R.layout.layout_product_actions,
                me.akshay.arclothing.R.layout.layout_interest_product,
                me.akshay.arclothing.R.layout.layout_no_internet});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.appBarLayout, 7);
        sViewsWithIds.put(R.id.toolbar, 8);
        sViewsWithIds.put(R.id.toolbar_logo, 9);
        sViewsWithIds.put(R.id.tv_title, 10);
        sViewsWithIds.put(R.id.count_card, 11);
        sViewsWithIds.put(R.id.cart_tv, 12);
        sViewsWithIds.put(R.id.cart_iv, 13);
        sViewsWithIds.put(R.id.share_iv, 14);
        sViewsWithIds.put(R.id.scroll_view, 15);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityProductDetailsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }
    private ActivityProductDetailsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 5
            , (com.google.android.material.appbar.AppBarLayout) bindings[7]
            , (android.widget.ImageView) bindings[13]
            , (android.widget.TextView) bindings[12]
            , (androidx.cardview.widget.CardView) bindings[11]
            , (me.akshay.arclothing.databinding.LayoutProductActionsBinding) bindings[4]
            , (me.akshay.arclothing.databinding.AboutProductBinding) bindings[3]
            , (me.akshay.arclothing.databinding.LayoutProductDetailsBinding) bindings[2]
            , (me.akshay.arclothing.databinding.LayoutNoInternetBinding) bindings[6]
            , (me.akshay.arclothing.databinding.LayoutInterestProductBinding) bindings[5]
            , (androidx.core.widget.NestedScrollView) bindings[15]
            , (android.widget.ImageView) bindings[14]
            , (androidx.appcompat.widget.Toolbar) bindings[8]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.TextView) bindings[10]
            );
        setContainedBinding(this.layoutAdd);
        setContainedBinding(this.layoutBuy);
        setContainedBinding(this.layoutImage);
        setContainedBinding(this.layoutIncludeNoNet);
        setContainedBinding(this.layoutInterestProduct);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[1];
        this.mboundView1.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x20L;
        }
        layoutImage.invalidateAll();
        layoutBuy.invalidateAll();
        layoutAdd.invalidateAll();
        layoutInterestProduct.invalidateAll();
        layoutIncludeNoNet.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (layoutImage.hasPendingBindings()) {
            return true;
        }
        if (layoutBuy.hasPendingBindings()) {
            return true;
        }
        if (layoutAdd.hasPendingBindings()) {
            return true;
        }
        if (layoutInterestProduct.hasPendingBindings()) {
            return true;
        }
        if (layoutIncludeNoNet.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        layoutImage.setLifecycleOwner(lifecycleOwner);
        layoutBuy.setLifecycleOwner(lifecycleOwner);
        layoutAdd.setLifecycleOwner(lifecycleOwner);
        layoutInterestProduct.setLifecycleOwner(lifecycleOwner);
        layoutIncludeNoNet.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeLayoutBuy((me.akshay.arclothing.databinding.AboutProductBinding) object, fieldId);
            case 1 :
                return onChangeLayoutImage((me.akshay.arclothing.databinding.LayoutProductDetailsBinding) object, fieldId);
            case 2 :
                return onChangeLayoutAdd((me.akshay.arclothing.databinding.LayoutProductActionsBinding) object, fieldId);
            case 3 :
                return onChangeLayoutIncludeNoNet((me.akshay.arclothing.databinding.LayoutNoInternetBinding) object, fieldId);
            case 4 :
                return onChangeLayoutInterestProduct((me.akshay.arclothing.databinding.LayoutInterestProductBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeLayoutBuy(me.akshay.arclothing.databinding.AboutProductBinding LayoutBuy, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeLayoutImage(me.akshay.arclothing.databinding.LayoutProductDetailsBinding LayoutImage, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeLayoutAdd(me.akshay.arclothing.databinding.LayoutProductActionsBinding LayoutAdd, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeLayoutIncludeNoNet(me.akshay.arclothing.databinding.LayoutNoInternetBinding LayoutIncludeNoNet, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeLayoutInterestProduct(me.akshay.arclothing.databinding.LayoutInterestProductBinding LayoutInterestProduct, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
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
        executeBindingsOn(layoutImage);
        executeBindingsOn(layoutBuy);
        executeBindingsOn(layoutAdd);
        executeBindingsOn(layoutInterestProduct);
        executeBindingsOn(layoutIncludeNoNet);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): layoutBuy
        flag 1 (0x2L): layoutImage
        flag 2 (0x3L): layoutAdd
        flag 3 (0x4L): layoutIncludeNoNet
        flag 4 (0x5L): layoutInterestProduct
        flag 5 (0x6L): null
    flag mapping end*/
    //end
}