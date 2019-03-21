package com.wow.shuigugu.cctest.ui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.wow.shuigugu.cctest.R;
import com.wow.shuigugu.cctest.util.UtilPermission;
import com.wow.shuigugu.cctest.util.UtilToast;

import net.everybim.layer.BIMData;
import net.everybim.layer.BIMGLSurfaceView;
import net.everybim.layer.BIMView;

import java.io.File;

public class BimActivity extends AppCompatActivity {
    BIMGLSurfaceView surfaceView;
    BIMData bimData;
    BIMView bimView;
    private TextView tv_open;


    static final String[] PERMISSIONS = new String[]{
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };
    int REQUEST_READ_EXTERNAL_STORAGE_PERMISSION = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bim);
        initBIM();
        if(UtilPermission.getPermission(this,UtilPermission.READ_EXTERNAL_STORAGE)){
            bimData.dataLoad().openModelData("/storage/emulated/0/小别墅纹理.yz", true);
        }
        tv_open = findViewById(R.id.tv_open);
        tv_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bimData.dataLoad().openModelData(getExternalCacheDir().getAbsolutePath() + File.separator + "model" + File.separator + "小别墅纹理.yz", true);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == UtilPermission.read_external_storage) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                bimData.dataLoad().openModelData("/storage/emulated/0/小别墅纹理.yz", true);
            } else {
                UtilToast.shortgmsg(this, "拒绝了权限");
            }
        }
    }

    private void initBIM() {
        surfaceView = findViewById(R.id.yzmodelview);
        bimData = new BIMData(getApplicationContext());
        bimView = new BIMView(getApplicationContext(), surfaceView);
        bimView.bindBIMData(bimData);
    }

    @Override
    public void onBackPressed() {
        GlobalData.viewData = bimView.saveViewState(BIMView.ViewStateType.Camera);
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        if (bimView != null) bimView.destroy();
        if (bimData != null) bimData.destroy();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        surfaceView.onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        surfaceView.onResume();
        super.onResume();
    }


}
