package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class h {

    public static final com.google.android.gms.measurement.internal.h c;
    private final Boolean a;
    private final Boolean b;
    static {
        final int i = 0;
        h hVar = new h(i, i);
        h.c = hVar;
    }

    public h(Boolean boolean, Boolean boolean2) {
        super();
        this.a = boolean;
        this.b = boolean2;
    }

    public static com.google.android.gms.measurement.internal.h a(Bundle bundle) {
        if (bundle == null) {
            return h.c;
        }
        h hVar = new h(h.o(bundle.getString("ad_storage")), h.o(bundle.getString("analytics_storage")));
        return hVar;
    }

    public static com.google.android.gms.measurement.internal.h b(String string) {
        int i2;
        int i3;
        int i4;
        int length;
        int i;
        char obj5;
        i2 = 0;
        if (string != 0) {
            i4 = 3;
            if (string.length() >= i4) {
                i3 = h.p(string.charAt(2));
            } else {
                i3 = i2;
            }
            if (string.length() >= 4) {
                i2 = h.p(string.charAt(i4));
            }
            obj5 = i2;
            i2 = i3;
        } else {
            obj5 = i2;
        }
        h hVar = new h(i2, obj5);
        return hVar;
    }

    static Boolean g(Boolean boolean, Boolean boolean2) {
        int i;
        boolean obj1;
        if (boolean == null) {
            return boolean2;
        }
        if (boolean2 == null) {
            return boolean;
        }
        i = 0;
        if (boolean.booleanValue() && boolean2.booleanValue()) {
            if (boolean2.booleanValue()) {
                i = 1;
            }
        }
        return Boolean.valueOf(i);
    }

    public static String h(Bundle bundle) {
        Object str;
        Boolean bool;
        String string = bundle.getString("ad_storage");
        if (string != null && h.o(string) != null) {
            if (h.o(string) != null) {
            }
            return string;
        }
        String obj2 = bundle.getString("analytics_storage");
        if (obj2 != null && h.o(obj2) == null) {
            if (h.o(obj2) == null) {
                return obj2;
            }
        }
        return null;
    }

    public static boolean l(int i, int i2) {
        if (i <= i2) {
            return 1;
        }
        return 0;
    }

    static final int n(Boolean boolean) {
        if (boolean == null) {
            return 0;
        }
        if (boolean.booleanValue()) {
            return 1;
        }
        return 2;
    }

    private static Boolean o(String string) {
        final int i = 0;
        if (string == null) {
            return i;
        }
        if (string.equals("granted")) {
            return Boolean.TRUE;
        }
        if (string.equals("denied")) {
            return Boolean.FALSE;
        }
        return i;
    }

    private static Boolean p(char c) {
        if (c != 48 && c != 49) {
            if (c != 49) {
                return null;
            }
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private static final char q(Boolean boolean) {
        if (boolean == null) {
            return 45;
        }
        if (boolean.booleanValue()) {
            return 49;
        }
        return 48;
    }

    public final com.google.android.gms.measurement.internal.h c(com.google.android.gms.measurement.internal.h h) {
        h hVar = new h(h.g(this.a, h.a), h.g(this.b, h.b));
        return hVar;
    }

    public final com.google.android.gms.measurement.internal.h d(com.google.android.gms.measurement.internal.h h) {
        Boolean bool;
        Boolean bool2;
        if (this.a == null) {
            bool = h.a;
        }
        if (this.b == null) {
            bool2 = h.b;
        }
        h hVar = new h(bool, bool2);
        return hVar;
    }

    public final Boolean e() {
        return this.a;
    }

    public final boolean equals(Object object) {
        int i;
        Object obj4;
        final int i2 = 0;
        if (!object instanceof h) {
            return i2;
        }
        if (h.n(this.a) == h.n(object.a) && h.n(this.b) == h.n(object.b)) {
            if (h.n(this.b) == h.n(object.b)) {
                return 1;
            }
        }
        return i2;
    }

    public final Boolean f() {
        return this.b;
    }

    public final int hashCode() {
        return i3 += i5;
    }

    public final String i() {
        StringBuilder stringBuilder = new StringBuilder("G1");
        stringBuilder.append(h.q(this.a));
        stringBuilder.append(h.q(this.b));
        return stringBuilder.toString();
    }

    public final boolean j() {
        Boolean booleanValue;
        booleanValue = this.a;
        if (booleanValue != null && booleanValue.booleanValue()) {
            if (booleanValue.booleanValue()) {
            }
            return 0;
        }
        return 1;
    }

    public final boolean k() {
        Boolean booleanValue;
        booleanValue = this.b;
        if (booleanValue != null && booleanValue.booleanValue()) {
            if (booleanValue.booleanValue()) {
            }
            return 0;
        }
        return 1;
    }

    public final boolean m(com.google.android.gms.measurement.internal.h h) {
        Boolean bool;
        int i;
        Object obj5;
        final Boolean fALSE = Boolean.FALSE;
        i = 1;
        final int i2 = 0;
        if (this.a == fALSE) {
            if (h.a == fALSE && this.b == fALSE && h.b != fALSE) {
                if (this.b == fALSE) {
                    if (h.b != fALSE) {
                    }
                    return i2;
                }
                i = i2;
            }
        } else {
        }
        return i;
    }

    public final String toString() {
        Object bool;
        Boolean booleanValue;
        String str;
        StringBuilder stringBuilder = new StringBuilder("ConsentSettings: ");
        stringBuilder.append("adStorage=");
        bool = this.a;
        final String str5 = "granted";
        final String str6 = "uninitialized";
        final int i = 1;
        if (bool == null) {
            stringBuilder.append(str6);
        } else {
            bool = i != bool.booleanValue() ? str : str5;
            stringBuilder.append(bool);
        }
        stringBuilder.append(", analyticsStorage=");
        booleanValue = this.b;
        if (booleanValue == null) {
            stringBuilder.append(str6);
        } else {
            if (i != booleanValue.booleanValue()) {
            } else {
                str = str5;
            }
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }
}
