package me.akshay.arclothing.ui.product.details;

import me.akshay.arclothing.common.response.MainProductResponse;
import me.akshay.arclothing.common.response.OneProductResponse;

public interface ProductRepoCallback {
    void setValue(OneProductResponse r);
    void setValue(String m);
    void setValue(MainProductResponse r);
}
