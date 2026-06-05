package com.luck.picture.lib.widget;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureSelectionConfig;

public class PermissExplainDialog extends Dialog {
    public PermissExplainDialog(Context context, String permission) {
        super(context);
        setContentView(R.layout.permission_explain_dialog);
        getWindow().setGravity(Gravity.TOP);
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        LinearLayout llFile = findViewById(R.id.llFile);
        LinearLayout llCamera = findViewById(R.id.llCamera);
        TextView tvFileDescribe = findViewById(R.id.tvFileDescribe);
        TextView tvCameraDescribe = findViewById(R.id.tvCameraDescribe);

        if (!TextUtils.isEmpty(PictureSelectionConfig.STORAGE_PERMISSIONS_DESCRIBE)){
            tvFileDescribe.setText(PictureSelectionConfig.STORAGE_PERMISSIONS_DESCRIBE);
        }
        if (!TextUtils.isEmpty(PictureSelectionConfig.CAMERA_PERMISSIONS_DESCRIBE)){
            tvCameraDescribe.setText(PictureSelectionConfig.CAMERA_PERMISSIONS_DESCRIBE);
        }

        llFile.setVisibility(View.GONE);
        llCamera.setVisibility(View.GONE);

        if (TextUtils.equals(permission, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            llFile.setVisibility(View.VISIBLE);
        }
        if (TextUtils.equals(permission, Manifest.permission.CAMERA)) {
            llCamera.setVisibility(View.VISIBLE);
        }
    }
}
