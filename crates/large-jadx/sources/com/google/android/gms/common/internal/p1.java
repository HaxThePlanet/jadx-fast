package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.util.Log;

/* loaded from: classes2.dex */
public final class p1 {

    private static final Uri f;
    private final String a;
    private final String b;
    private final ComponentName c = null;
    private final int d;
    private final boolean e;
    static {
        Uri.Builder builder = new Uri.Builder();
        p1.f = builder.scheme("content").authority("com.google.android.gms.chimera").build();
    }

    public p1(String string, String string2, int i3, boolean z4) {
        super();
        r.f(string);
        this.a = string;
        r.f(string2);
        this.b = string2;
        final int obj1 = 0;
        this.d = i3;
        this.e = z4;
    }

    public final String a() {
        return this.b;
    }

    public final ComponentName b() {
        return this.c;
    }

    public final int c() {
        return this.d;
    }

    public final Intent d(Context context) {
        Object str2;
        boolean bundle;
        int component;
        StringBuilder stringBuilder;
        String str;
        Object obj6;
        if (this.a != null && this.e) {
            if (this.e) {
                bundle = new Bundle();
                bundle.putString("serviceActionBundleKey", this.a);
                obj6 = context.getContentResolver().call(p1.f, "serviceIntentCall", 0, bundle);
                if (obj6 == null) {
                } else {
                    component = obj6;
                }
                if (component == null) {
                    obj6 = String.valueOf(this.a);
                    bundle = "Dynamic lookup for intent failed for action: ";
                    if (obj6.length() != 0) {
                        obj6 = bundle.concat(obj6);
                    } else {
                        obj6 = new String(bundle);
                    }
                    Log.w("ConnectionStatusConfig", obj6);
                }
            }
            if (component != 0) {
                return component;
            }
            obj6 = new Intent(this.a);
            return obj6.setPackage(this.b);
        }
        obj6 = new Intent();
        component = obj6.setComponent(this.c);
    }

    public final boolean equals(Object object) {
        boolean z;
        String str;
        Object obj5;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof p1) {
            return i2;
        }
        if (p.a(this.a, object.a) && p.a(this.b, object.b) && p.a(this.c, object.c) && this.d == object.d && this.e == object.e) {
            if (p.a(this.b, object.b)) {
                if (p.a(this.c, object.c)) {
                    if (this.d == object.d) {
                        if (this.e == object.e) {
                            return i;
                        }
                    }
                }
            }
        }
        return i2;
    }

    public final int hashCode() {
        Object[] arr = new Object[5];
        return p.b(this.a, this.b, this.c, Integer.valueOf(this.d), Boolean.valueOf(this.e));
    }

    public final String toString() {
        String flattenToString;
        if (this.a == null) {
            r.j(this.c);
            flattenToString = this.c.flattenToString();
        }
        return flattenToString;
    }
}
