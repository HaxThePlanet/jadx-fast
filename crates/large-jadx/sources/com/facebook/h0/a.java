package com.facebook.h0;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.facebook.CustomTabMainActivity;
import com.facebook.internal.b0;
import com.facebook.internal.e;
import com.facebook.internal.f;
import com.facebook.login.b;
import com.facebook.o;

/* loaded from: classes.dex */
@Deprecated
class a {

    private Fragment a;
    private String b;
    protected String c;
    a(Fragment fragment) {
        super();
        this.a = fragment;
    }

    private void a(int i, Intent intent2) {
        boolean activity;
        activity = this.a.getActivity();
        if (this.a.isAdded() && activity != null) {
            activity = this.a.getActivity();
            if (activity != null) {
                activity.setResult(i, intent2);
                activity.finish();
            }
        }
    }

    private String b() {
        String str;
        if (this.b == null) {
            this.b = f.a();
        }
        return this.b;
    }

    static String c() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fb");
        stringBuilder.append(o.g());
        stringBuilder.append("://authorize");
        return stringBuilder.toString();
    }

    private Bundle d() {
        Bundle bundle = new Bundle();
        this.c = b0.r(20);
        bundle.putString("redirect_uri", f.c(a.c()));
        bundle.putString("app_id", o.g());
        bundle.putString("state", this.c);
        return bundle;
    }

    private boolean e() {
        int i;
        i = b() != null ? 1 : 0;
        return i;
    }

    private boolean h() {
        androidx.fragment.app.e checkCallingOrSelfPermission;
        String str;
        boolean z;
        if (this.a.getActivity() != null && this.a.getActivity().checkCallingOrSelfPermission("android.permission.INTERNET") == 0) {
            if (this.a.getActivity().checkCallingOrSelfPermission("android.permission.INTERNET") == 0) {
                if (!e()) {
                } else {
                    Bundle bundle = d();
                    String str3 = "share_referral";
                    if (o.o) {
                        b.f(e.a(str3, bundle));
                    }
                }
                Intent intent = new Intent(this.a.getActivity(), CustomTabMainActivity.class);
                intent.putExtra(CustomTabMainActivity.c, str3);
                intent.putExtra(CustomTabMainActivity.v, bundle);
                intent.putExtra(CustomTabMainActivity.w, b());
                int i2 = 1;
                this.a.startActivityForResult(intent, i2);
                return i2;
            }
        }
        return 0;
    }

    private boolean i(Bundle bundle) {
        int str;
        boolean obj2;
        if (this.c != null) {
            obj2 = this.c.equals(bundle.getString("state"));
            this.c = 0;
        } else {
            obj2 = 1;
        }
        return obj2;
    }

    void f(int i, int i2, Intent intent3) {
        int startsWith;
        int obj2;
        int obj3;
        if (i != 1) {
        }
        obj2 = intent3.getStringExtra(CustomTabMainActivity.x);
        if (intent3 != null && obj2 != null && obj2.startsWith(f.c(a.c()))) {
            obj2 = intent3.getStringExtra(CustomTabMainActivity.x);
            if (obj2 != null) {
                if (obj2.startsWith(f.c(a.c()))) {
                    obj2 = b0.i0(Uri.parse(obj2).getQuery());
                    if (i(obj2)) {
                        intent3.putExtras(obj2);
                    } else {
                        obj3 = 0;
                        intent3.putExtra("error_message", "The referral response was missing a valid challenge string.");
                    }
                }
            }
        }
        a(obj3, intent3);
    }

    void g() {
        boolean intent;
        int i;
        String str;
        if (!h()) {
            intent = new Intent();
            intent.putExtra("error_message", "Failed to open Referral dialog: Chrome custom tab could not be started. Please make sure internet permission is granted and Chrome is installed");
            a(0, intent);
        }
    }
}
