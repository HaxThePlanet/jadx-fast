package com.facebook.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.facebook.FacebookException;
import com.facebook.FacebookServiceException;
import com.facebook.a;
import com.facebook.f;
import com.facebook.internal.b0;
import com.facebook.n;
import com.facebook.o;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes.dex */
abstract class x extends com.facebook.login.q {

    private String v;
    x(Parcel parcel) {
        super(parcel);
    }

    x(com.facebook.login.l l) {
        super(l);
    }

    private String u() {
        return f().i().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).getString("TOKEN", "");
    }

    private void x(String string) {
        f().i().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).edit().putString("TOKEN", string).apply();
    }

    @Override // com.facebook.login.q
    protected Bundle p(Bundle bundle, com.facebook.login.l.d l$d2) {
        String str4;
        String str3;
        String str5;
        String str9;
        boolean string;
        boolean str12;
        String str;
        String str8;
        String str11;
        String str10;
        String str6;
        String str13;
        String str7;
        String str2;
        String obj7;
        bundle.putString("redirect_uri", r());
        if (d2.o()) {
            bundle.putString("app_id", d2.a());
        } else {
            bundle.putString("client_id", d2.a());
        }
        f();
        bundle.putString("e2e", l.k());
        str11 = "response_type";
        if (d2.o()) {
            bundle.putString(str11, "token,signed_request,graph_domain,granted_scopes");
        } else {
            if (d2.k().contains("openid")) {
                bundle.putString(str11, "id_token,token,signed_request,graph_domain");
                bundle.putString("nonce", d2.j());
            } else {
                bundle.putString(str11, "token,signed_request,graph_domain");
            }
        }
        str10 = "true";
        bundle.putString("return_scopes", str10);
        bundle.putString("auth_type", d2.c());
        bundle.putString("login_behavior", d2.g().name());
        Object[] arr = new Object[1];
        bundle.putString("sdk", String.format(Locale.ROOT, "android-%s", o.u()));
        if (s() != null) {
            bundle.putString("sso", s());
        }
        String str24 = "0";
        str9 = o.o ? str7 : str24;
        bundle.putString("cct_prefetching", str9);
        if (d2.n()) {
            bundle.putString("fx_app", d2.h().toString());
        }
        if (d2.x()) {
            bundle.putString("skip_dedupe", str10);
        }
        if (d2.i() != null) {
            bundle.putString("messenger_page_id", d2.i());
            if (d2.l()) {
            } else {
                str7 = str24;
            }
            bundle.putString("reset_messenger_state", str7);
        }
        return bundle;
    }

    @Override // com.facebook.login.q
    protected Bundle q(com.facebook.login.l.d l$d) {
        boolean join;
        String str;
        String str2;
        boolean equals;
        String obj6;
        Bundle bundle = new Bundle();
        if (!b0.X(d.k())) {
            join = TextUtils.join(",", d.k());
            str2 = "scope";
            bundle.putString(str2, join);
            a(str2, join);
        }
        bundle.putString("default_audience", d.d().getNativeProtocolAudience());
        bundle.putString("state", e(d.b()));
        obj6 = a.d();
        if (obj6 != null) {
            obj6 = obj6.m();
        } else {
            obj6 = 0;
        }
        String str5 = "0";
        String str7 = "access_token";
        if (obj6 != null && obj6.equals(u())) {
            if (obj6.equals(u())) {
                bundle.putString(str7, obj6);
                a(str7, "1");
            } else {
                b0.h(f().i());
                a(str7, str5);
            }
        } else {
        }
        bundle.putString("cbt", String.valueOf(System.currentTimeMillis()));
        if (o.j()) {
        } else {
            str = str5;
        }
        bundle.putString("ies", str);
        return bundle;
    }

    @Override // com.facebook.login.q
    protected String r() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fb");
        stringBuilder.append(o.g());
        stringBuilder.append("://authorize/");
        return stringBuilder.toString();
    }

    @Override // com.facebook.login.q
    protected String s() {
        return null;
    }

    @Override // com.facebook.login.q
    abstract f t();

    @Override // com.facebook.login.q
    protected void v(com.facebook.login.l.d l$d, Bundle bundle2, FacebookException facebookException3) {
        String str;
        Integer valueOf;
        String obj5;
        int obj6;
        Object obj7;
        final com.facebook.login.l lVar = f();
        final int i = 0;
        this.v = i;
        if (bundle2 != null) {
            obj7 = "e2e";
            if (bundle2.containsKey(obj7)) {
                this.v = bundle2.getString(obj7);
            }
            obj7 = q.c(d.k(), bundle2, t(), d.a());
            obj5 = l.e.b(lVar.q(), obj7, q.d(bundle2, d.j()));
            CookieSyncManager.createInstance(lVar.i()).sync();
            if (obj7 != null) {
                x(obj7.m());
            }
        } else {
            if (facebookException3 instanceof FacebookOperationCanceledException != null) {
                obj5 = l.e.a(lVar.q(), "User canceled log in.");
            } else {
                this.v = i;
                obj5 = facebookException3.getMessage();
                if (facebookException3 instanceof FacebookServiceException != null) {
                    obj5 = (FacebookServiceException)facebookException3.a();
                    obj7 = new Object[1];
                    obj6 = String.format(Locale.ROOT, "%d", Integer.valueOf(obj5.b()));
                    obj5 = obj5.toString();
                } else {
                    obj6 = i;
                }
                obj5 = l.e.d(lVar.q(), i, obj5, obj6);
            }
        }
        if (!b0.W(this.v)) {
            i(this.v);
        }
        lVar.g(obj5);
    }
}
