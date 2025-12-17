package com.google.android.gms.internal.firebase-auth-api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;

/* loaded from: classes2.dex */
public final class s1 {

    private final com.google.android.gms.internal.firebase-auth-api.yg a;
    private final com.google.android.gms.internal.firebase-auth-api.r1 b;
    private s1(com.google.android.gms.internal.firebase-auth-api.r1 r1) {
        super();
        this.b = r1;
        this.a = xf.b;
    }

    static com.google.android.gms.internal.firebase-auth-api.yg a(com.google.android.gms.internal.firebase-auth-api.s1 s1) {
        return s1.a;
    }

    public static com.google.android.gms.internal.firebase-auth-api.s1 b(char c) {
        vd obj2 = new vd(46);
        cr crVar = new cr(obj2);
        s1 s1Var = new s1(crVar);
        return s1Var;
    }

    public static com.google.android.gms.internal.firebase-auth-api.s1 c(String string) {
        com.google.android.gms.internal.firebase-auth-api.ak obj3 = dp.a("[.-]");
        int i2 = 1;
        if (matches ^= i2 == 0) {
        } else {
            z zVar = new z(obj3);
            s1 s1Var = new s1(zVar);
            return s1Var;
        }
        Object[] arr = new Object[i2];
        arr[0] = obj3;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(t1.b("The pattern may not match the empty string: %s", arr));
        throw illegalArgumentException;
    }

    public final List<String> d(java.lang.CharSequence charSequence) {
        Object next;
        Objects.requireNonNull(charSequence);
        Iterator obj3 = this.b.a(this, charSequence);
        ArrayList arrayList = new ArrayList();
        for (String next : obj3) {
            arrayList.add(next);
        }
        return Collections.unmodifiableList(arrayList);
    }
}
