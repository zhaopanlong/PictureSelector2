package com.luck.picture.lib.widget;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.luck.picture.lib.R;

public class PermissExplainDialog extends Dialog {
    public PermissExplainDialog(Context context, String permission) {
        super(context);
        setContentView(R.layout.permission_explain_dialog);
        getWindow().setGravity(Gravity.TOP);
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        LinearLayout llFile = findViewById(R.id.llFile);
        LinearLayout llCamera = findViewById(R.id.llCamera);

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
