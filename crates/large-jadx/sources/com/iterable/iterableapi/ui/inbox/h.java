package com.iterable.iterableapi.ui.inbox;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.Fragment;
import com.iterable.iterableapi.e0;
import com.iterable.iterableapi.f0;
import com.iterable.iterableapi.g0;
import com.iterable.iterableapi.g0.a;
import com.iterable.iterableapi.g0.d;
import com.iterable.iterableapi.j;
import com.iterable.iterableapi.j1.c;
import com.iterable.iterableapi.j1.d;
import java.util.Iterator;
import java.util.List;

/* compiled from: IterableInboxMessageFragment.java */
/* loaded from: classes2.dex */
public class h extends Fragment {

    private String a;
    private WebView b;
    private g0 c;
    private boolean v = false;
    private WebViewClient w = new h$a();

    class a extends WebViewClient {

        final /* synthetic */ h a;
        a() {
            this.a = hVar;
            super();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            j.s().U(this.a.c, str, e0.INBOX);
            j.s().q().p(this.a.c, Uri.parse(str));
            if (this.a.getActivity() != null) {
                this.a.getActivity().finish();
            }
            return true;
        }
    }
    public h() {
        super();
        com.iterable.iterableapi.ui.inbox.h.a aVar = new h.a(this);
    }

    static /* synthetic */ g0 B1(h hVar) {
        return hVar.c;
    }

    private g0 C1(String str) {
        Iterator it = j.s().q().l().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            if (item.i().equals(str)) {
                return item;
            }
        }
        return null;
    }

    private void D1() {
        WebViewClient webViewClient;
        String str;
        g0 g0Var = C1(this.a);
        this.c = g0Var;
        if (g0Var != null) {
            str = "";
            str3 = "text/html";
            str4 = "UTF-8";
            str5 = "";
            this.b.loadDataWithBaseURL(str, g0Var.e().a, str3, str4, str5);
            this.b.setWebViewClient(this.w);
            if (!this.v) {
                j.s().a0(this.c, e0.INBOX);
                boolean z = true;
                this.v = z;
            }
            if (getActivity() != null) {
                getActivity().setTitle(this.c.h().a);
            }
        }
    }

    public static h E1(String str) {
        final com.iterable.iterableapi.ui.inbox.h hVar = new h();
        final Bundle bundle = new Bundle();
        bundle.putString("messageId", str);
        hVar.setArguments(bundle);
        return hVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments;
        String str;
        super.onCreate(bundle);
        if (getArguments() != null) {
            str = "messageId";
            this.a = getArguments().getString(str);
        }
        if (bundle != null) {
            str = "loaded";
            this.v = bundle.getBoolean(str, false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final View inflate = layoutInflater.inflate(d.e, viewGroup, false);
        this.b = (WebView)inflate.findViewById(c.j);
        D1();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("loaded", true);
    }
}
