package com.iterable.iterableapi;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* loaded from: classes2.dex */
class a1 extends WebView {

    class a extends WebChromeClient {

        final com.iterable.iterableapi.a1 a;
        a(com.iterable.iterableapi.a1 a1) {
            this.a = a1;
            super();
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            this.a.loadUrl("javascript:ITBL.resize(document.body.getBoundingClientRect().height)");
        }
    }
    a1(Context context) {
        super(context);
    }

    @Override // android.webkit.WebView
    void a(com.iterable.iterableapi.b1.a b1$a, String string2) {
        b1 b1Var = new b1(a);
        this.loadDataWithBaseURL("", string2, "text/html", "UTF-8", "");
        setWebViewClient(b1Var);
        a1.a obj8 = new a1.a(this);
        setWebChromeClient(obj8);
        setOverScrollMode(2);
        obj8 = 0;
        setBackgroundColor(obj8);
        int i = 1;
        getSettings().setLoadWithOverviewMode(i);
        getSettings().setUseWideViewPort(i);
        getSettings().setAllowFileAccess(obj8);
        getSettings().setAllowFileAccessFromFileURLs(obj8);
        getSettings().setAllowUniversalAccessFromFileURLs(obj8);
        getSettings().setAllowContentAccess(obj8);
        getSettings().setJavaScriptEnabled(obj8);
    }
}
