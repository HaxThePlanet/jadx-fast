package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class l3 {

    protected static final AtomicReference<String[]> b;
    protected static final AtomicReference<String[]> c;
    protected static final AtomicReference<String[]> d;
    private final com.google.android.gms.measurement.internal.k3 a;
    static {
        AtomicReference atomicReference = new AtomicReference();
        l3.b = atomicReference;
        AtomicReference atomicReference2 = new AtomicReference();
        l3.c = atomicReference2;
        AtomicReference atomicReference3 = new AtomicReference();
        l3.d = atomicReference3;
    }

    public l3(com.google.android.gms.measurement.internal.k3 k3) {
        super();
        this.a = k3;
    }

    private static final String g(String string, String[] string2Arr2, String[] string3Arr3, AtomicReference<String[]> atomicReference4) {
        int i2;
        Object string2;
        int i;
        Object obj3;
        Object obj4;
        Object obj5;
        r.j(string2Arr2);
        r.j(string3Arr3);
        r.j(atomicReference4);
        i2 = string2Arr2.length == string3Arr3.length ? 1 : i;
        r.a(i2);
        for (Object obj : string2Arr2) {
        }
        return string;
    }

    protected final String a(Object[] objectArr) {
        int i2;
        String valueOf;
        boolean length;
        int i;
        if (objectArr == null) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        i2 = 0;
        while (i2 < objectArr.length) {
            Object obj = objectArr[i2];
            if (obj instanceof Bundle != null) {
            } else {
            }
            valueOf = String.valueOf(obj);
            if (valueOf != null && stringBuilder.length() != 1) {
            }
            i2++;
            if (stringBuilder.length() != 1) {
            }
            stringBuilder.append(valueOf);
            stringBuilder.append(", ");
            valueOf = b((Bundle)obj);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    protected final String b(Bundle bundle) {
        String valueOf;
        Object[] arr;
        int length;
        int i;
        if (bundle == null) {
            return null;
        }
        if (!this.a.zza()) {
            return bundle.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bundle[{");
        Iterator iterator = bundle.keySet().iterator();
        while (iterator.hasNext()) {
            Object next2 = iterator.next();
            if (stringBuilder.length() != 8) {
            }
            stringBuilder.append(e((String)next2));
            stringBuilder.append("=");
            Object obj = bundle.get(next2);
            if (obj instanceof Bundle != null) {
            } else {
            }
            if (obj instanceof Object[]) {
            } else {
            }
            if (obj instanceof ArrayList != null) {
            } else {
            }
            valueOf = String.valueOf(obj);
            stringBuilder.append(valueOf);
            valueOf = a((ArrayList)obj.toArray());
            valueOf = a((Object[])obj);
            arr = new Object[1];
            valueOf = a(arr);
            stringBuilder.append(", ");
        }
        stringBuilder.append("}]");
        return stringBuilder.toString();
    }

    protected final String c(com.google.android.gms.measurement.internal.u u) {
        String str;
        int obj3;
        if (!this.a.zza()) {
            return u.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("origin=");
        stringBuilder.append(u.c);
        stringBuilder.append(",name=");
        stringBuilder.append(d(u.a));
        stringBuilder.append(",params=");
        obj3 = u.b;
        if (obj3 == null) {
            obj3 = 0;
        } else {
            if (!this.a.zza()) {
                obj3 = obj3.toString();
            } else {
                obj3 = b(obj3.k2());
            }
        }
        stringBuilder.append(obj3);
        return stringBuilder.toString();
    }

    protected final String d(String string) {
        if (string == null) {
            return null;
        }
        if (!this.a.zza()) {
            return string;
        }
        return l3.g(string, z5.c, z5.a, l3.b);
    }

    protected final String e(String string) {
        if (string == null) {
            return null;
        }
        if (!this.a.zza()) {
            return string;
        }
        return l3.g(string, a6.b, a6.a, l3.c);
    }

    protected final String f(String string) {
        if (string == null) {
            return null;
        }
        if (!this.a.zza()) {
            return string;
        }
        if (string.startsWith("_exp_")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("experiment_id(");
            stringBuilder.append(string);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
        return l3.g(string, b6.b, b6.a, l3.d);
    }
}
