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
import com.iterable.iterableapi.j;
import com.iterable.iterableapi.j1.c;
import com.iterable.iterableapi.j1.d;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class h extends Fragment {

    private String a;
    private WebView b;
    private g0 c;
    private boolean v = false;
    private WebViewClient w;

    class a extends WebViewClient {

        final com.iterable.iterableapi.ui.inbox.h a;
        a(com.iterable.iterableapi.ui.inbox.h h) {
            this.a = h;
            super();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String string2) {
            androidx.fragment.app.e obj3;
            j.s().U(h.B1(this.a), string2, e0.INBOX);
            j.s().q().p(h.B1(this.a), Uri.parse(string2));
            if (this.a.getActivity() != null) {
                this.a.getActivity().finish();
            }
            return 1;
        }
    }
    public h() {
        super();
        int i = 0;
        h.a aVar = new h.a(this);
        this.w = aVar;
    }

    static g0 B1(com.iterable.iterableapi.ui.inbox.h h) {
        return h.c;
    }

    private g0 C1(String string) {
        Object next;
        boolean equals;
        Iterator iterator = j.s().q().l().iterator();
        for (g0 next : iterator) {
        }
        return null;
    }

    private void D1() {
        boolean z;
        Object activity;
        Object view;
        Object iNBOX;
        String str3;
        String str2;
        String str;
        String str4;
        activity = C1(this.a);
        this.c = activity;
        this.b.loadDataWithBaseURL("", aVar.a, "text/html", "UTF-8", "");
        this.b.setWebViewClient(this.w);
        if (activity != null && !this.v) {
            this.b.loadDataWithBaseURL("", aVar.a, "text/html", "UTF-8", "");
            this.b.setWebViewClient(this.w);
            if (!this.v) {
                j.s().a0(this.c, e0.INBOX);
                this.v = true;
            }
            if (getActivity() != null) {
                getActivity().setTitle(dVar.a);
            }
        }
    }

    public static com.iterable.iterableapi.ui.inbox.h E1(String string) {
        h hVar = new h();
        Bundle bundle = new Bundle();
        bundle.putString("messageId", string);
        hVar.setArguments(bundle);
        return hVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Object arguments;
        String str;
        Bundle obj3;
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.a = getArguments().getString("messageId");
        }
        if (bundle != null) {
            this.v = bundle.getBoolean("loaded", false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        final View obj2 = layoutInflater.inflate(d.e, viewGroup2, false);
        this.b = (WebView)obj2.findViewById(c.j);
        D1();
        return obj2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("loaded", true);
    }
}
