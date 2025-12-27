package com.iterable.iterableapi;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/* compiled from: IterableWebViewClient.java */
/* loaded from: classes2.dex */
class b1 extends WebViewClient {

    b1.a a;

    interface a {
        void X0(String str);

        void z0(boolean z);
    }
    b1(b1.a aVar) {
        super();
        this.a = aVar;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.a.z0(true);
        webView.loadUrl("javascript:ITBL.resize(document.body.getBoundingClientRect().height)");
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        this.a.X0(str);
        return true;
    }
}
