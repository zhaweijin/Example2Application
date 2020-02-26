package com.example2.test.webview;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;

import android.util.Log;
import android.view.KeyEvent;
import android.webkit.PermissionRequest;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example2.test.R;
import com.example2.test.base.BaseActivity;

import butterknife.BindView;


public class WebTest extends BaseActivity {

    @BindView(R.id.web_view)
    WebView webView;


    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, WebTest.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_test);




        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        //如果不调用这个函数，将会打开一个默认的浏览器

        WebSettings settings = webView.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setDomStorageEnabled(true);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setAllowContentAccess(true); // 是否可访问Content Provider的资源，默认值 true
        settings.setAllowFileAccess(true);    // 是否可访问本地文件，默认值 true
        // 是否允许通过file url加载的Javascript读取本地文件，默认值 false
        settings.setAllowFileAccessFromFileURLs(false);
        // 是否允许通过file url加载的Javascript读取全部资源(包括文件,http,https)，默认值 false
        settings.setAllowUniversalAccessFromFileURLs(false);
        //开启JavaScript支持
        settings.setJavaScriptEnabled(true);

        //https://webrtc.github.io/samples/src/content/getusermedia/gum/
        //https://webrtc.github.io/samples/src/content/devices/input-output/
        webView.loadUrl("https://webrtc.github.io/samples/src/content/devices/input-output/");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }

            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });




        //判断页面加载的过程
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                // TODO Auto-generated method stub
                if (newProgress == 100) {
                    // 网页加载完成
                    Log.d("aa", "success");
                } else {
                    // 加载中
                    Log.d("aa", +newProgress + "");
                }
            }

            @Override
            public void onPermissionRequest(final PermissionRequest request) {
                Log.v("aa","onPermissionRequest");
                request.grant(request.getResources());
            }
        });
    }



}
