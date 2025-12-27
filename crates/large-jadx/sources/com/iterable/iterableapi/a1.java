package com.iterable.iterableapi;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* compiled from: IterableWebView.java */
/* loaded from: classes2.dex */
class a1 extends WebView {

    class a extends WebChromeClient {

        final /* synthetic */ a1 a;
        a() {
            this.a = a1Var;
            super();
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            this.a.loadUrl("javascript:ITBL.resize(document.body.getBoundingClientRect().height)");
        }
    }
    a1(Context context) {
        super(context);
    }

    @Override // android.webkit.WebView
    void a(b1.a aVar, String str) {
        this.loadDataWithBaseURL("", str, "text/html", "UTF-8", "");
        setWebViewClient(new b1(aVar));
        setWebChromeClient(new a1.a(this));
        setOverScrollMode(2);
        int i2 = 0;
        setBackgroundColor(i2);
        boolean z = true;
        getSettings().setLoadWithOverviewMode(z);
        getSettings().setUseWideViewPort(z);
        getSettings().setAllowFileAccess(false);
        getSettings().setAllowFileAccessFromFileURLs(false);
        getSettings().setAllowUniversalAccessFromFileURLs(false);
        getSettings().setAllowContentAccess(false);
        getSettings().setJavaScriptEnabled(false);
    }
}
