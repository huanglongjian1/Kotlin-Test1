package com.android.kotlin_test1.test3;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.Observer;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.android.kotlin_test1.R;
import com.android.kotlin_test1.base.BaseActivity;
import com.android.kotlin_test1.databinding.Test3ActivityBinding;
import com.android.kotlin_test1.util.Constants;

@Route(path = Constants.PATH_TEST3_ACTIVITY_02)
public class Test3Activity_02 extends BaseActivity<MainViewModel, Test3ActivityBinding> {
    @Override
    protected int getContentViewId() {
        return R.layout.test3_activity;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        binding.getImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.getCSDNImageObservable();

            }
        });
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(Constants.PATH_TEST3_ACTIVITY).navigation();
            }
        });
    }


    @Override
    protected void initData() {
        mViewModel.getImagePngData().observe(this, new Observer<byte[]>() {
            @Override
            public void onChanged(byte[] bytes) {
                binding.image.setImageBitmap(BitmapFactory.decodeByteArray(bytes, 0, bytes.length));
            }
        });
        mViewModel.getLoadState().observe(this, new Observer<LoadState>() {
            @Override
            public void onChanged(LoadState loadState) {
                if (loadState == LoadState.Success || loadState == LoadState.Fail) {
                    binding.getImage.setEnabled(true);
                }
                if (loadState==LoadState.Loading){
                    binding.getImage.setEnabled(false);
                }
            }
        });
    }
}
