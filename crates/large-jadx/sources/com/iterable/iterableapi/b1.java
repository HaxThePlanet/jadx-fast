package com.iterable.iterableapi;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/* loaded from: classes2.dex */
class b1 extends WebViewClient {

    com.iterable.iterableapi.b1.a a;

    interface a {
        public abstract void X0(String string);

        public abstract void z0(boolean z);
    }
    b1(com.iterable.iterableapi.b1.a b1$a) {
        super();
        this.a = a;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String string2) {
        this.a.z0(true);
        webView.loadUrl("javascript:ITBL.resize(document.body.getBoundingClientRect().height)");
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String string2) {
        this.a.X0(string2);
        return 1;
    }
}
