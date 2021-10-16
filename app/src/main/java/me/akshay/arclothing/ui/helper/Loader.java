package me.akshay.arclothing.ui.helper;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import me.akshay.arclothing.R;
import me.akshay.arclothing.common.index.Constants;

public class Loader extends AlertDialog {

    public Loader(@NonNull Context context) {
        super(context);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
    }

    @Override
    public void show() {
        super.show();
        setContentView(R.layout.layout_loader);
    }

    @Override
    public void cancel() {
        super.cancel();
    }

    public void stopLoader() {
        new Handler().postDelayed(this::dismiss, Constants.IntConstants.LOADER_DELAY);
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }
}
