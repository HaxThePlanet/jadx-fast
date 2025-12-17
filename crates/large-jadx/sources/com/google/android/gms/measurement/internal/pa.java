package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.util.e;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public final class pa {

    private final com.google.android.gms.measurement.internal.b5 a;
    public pa(com.google.android.gms.measurement.internal.b5 b5) {
        super();
        this.a = b5;
    }

    final void a(String string, Bundle bundle2) {
        boolean currentTimeMillis;
        boolean next;
        boolean empty;
        String string2;
        Object obj4;
        boolean obj5;
        this.a.a().h();
        if (!this.a.o()) {
            if (bundle2.isEmpty()) {
                obj4 = 0;
            } else {
                if (1 == string.isEmpty()) {
                    obj4 = "auto";
                }
                currentTimeMillis = new Uri.Builder();
                currentTimeMillis.path(obj4);
                obj4 = bundle2.keySet().iterator();
                for (String empty : obj4) {
                    currentTimeMillis.appendQueryParameter(empty, bundle2.getString(empty));
                }
                obj4 = currentTimeMillis.build().toString();
            }
            if (!TextUtils.isEmpty(obj4)) {
                obj5.u.b(obj4);
                obj4.v.b(this.a.c().currentTimeMillis());
            }
        }
    }

    final void b() {
        Object bundle2;
        Object first;
        Object str;
        String str3;
        Object second;
        String str2;
        Bundle bundle;
        Pair pair;
        Iterator iterator;
        boolean next;
        String queryParameter;
        this.a.a().h();
        if (!d()) {
        }
        String str5 = "_cc";
        str3 = 0;
        if (e()) {
            g4Var.u.b(str3);
            bundle2 = new Bundle();
            String str9 = "(not set)";
            bundle2.putString("source", str9);
            bundle2.putString("medium", str9);
            String str10 = "intent";
            bundle2.putString("_cis", str10);
            bundle2.putLong(str5, 1);
            this.a.I().u("auto", "_cmpx", bundle2);
        } else {
            String str4 = g4Var3.u.a();
            if (TextUtils.isEmpty(str4)) {
                this.a.b().t().a("Cache still valid but referrer not found");
            } else {
                int i6 = 3600000;
                Uri parse = Uri.parse(str4);
                bundle = new Bundle();
                pair = new Pair(parse.getPath(), bundle);
                iterator = parse.getQueryParameterNames().iterator();
                for (String next : iterator) {
                    bundle.putString(next, parse.getQueryParameter(next));
                }
                (Bundle)pair.second.putLong(str5, i4 *= i6);
                if (pair.first == null) {
                    first = "app";
                } else {
                }
                this.a.I().u(first, "_cmp", (Bundle)pair.second);
            }
            g4Var4.u.b(str3);
        }
        g4Var2.v.b(0);
    }

    final void c() {
        boolean z;
        int i;
        if (d() && e()) {
            if (e()) {
                g4Var.u.b(0);
            }
        }
    }

    final boolean d() {
        if (Long.compare(l, i3) > 0) {
            return 1;
        }
        return 0;
    }

    final boolean e() {
        final int i2 = 0;
        if (!d()) {
            return i2;
        }
        if (Long.compare(i3, l2) > 0) {
            return 1;
        }
        return i2;
    }
}
