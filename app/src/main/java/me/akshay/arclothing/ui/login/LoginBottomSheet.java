package me.akshay.arclothing.ui.login;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import me.akshay.arclothing.data.util.UtilityClass;
import me.akshay.arclothing.databinding.FragOtpBinding;

public class LoginBottomSheet extends BottomSheetDialogFragment {

    private FragOtpBinding binding;
    private LoginCallBack callBack;

    public interface LoginCallBack{
        void onCallBack(String otp);
    }

    public LoginBottomSheet (){

    }

    public  LoginBottomSheet(LoginCallBack callBack){
        this.callBack = callBack;
    }

    public static LoginBottomSheet newInstance(LoginCallBack callBack) {
        Bundle args = new Bundle();
        LoginBottomSheet fragment = new LoginBottomSheet(callBack);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragOtpBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.etCode.requestFocus();
        binding.etCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 6){
                    callBack.onCallBack(charSequence.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
