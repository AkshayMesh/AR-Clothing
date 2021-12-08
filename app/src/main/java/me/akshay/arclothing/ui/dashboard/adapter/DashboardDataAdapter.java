package me.akshay.arclothing.ui.dashboard.adapter;

import java.util.ArrayList;
import me.akshay.arclothing.common.models.ProductModel;
import me.akshay.arclothing.common.response.MainProductResponse;

public class DashboardDataAdapter {
    private static MainProductResponse mainResponse;
    private static DashboardDataAdapter mInstance;

    public static DashboardDataAdapter newInstance(MainProductResponse mainResponse) {
        if (mainResponse == null)
            return null;
        if (mInstance == null)
            mInstance = new DashboardDataAdapter(mainResponse);
        return mInstance;
    }

    public DashboardDataAdapter(MainProductResponse mainResponse) {
        DashboardDataAdapter.mainResponse = mainResponse;
    }

    public ArrayList<ProductModel> getFeaturedProduct(){
        ArrayList<ProductModel> featuredProducts = new ArrayList<>();
        for (ProductModel model: mainResponse.data) {
            if (model.featured == 1)
                featuredProducts.add(model);
        }
        return featuredProducts;
    }

    public ArrayList<ProductModel> getOfferProduct(){
        ArrayList<ProductModel> offerProduct = new ArrayList<>();
        for (ProductModel model : mainResponse.data) {
            if (model.currentPrice < model.previousPrice)
                offerProduct.add(model);
        }
        return offerProduct;
    }
}
