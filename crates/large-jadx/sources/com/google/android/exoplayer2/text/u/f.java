package com.google.android.exoplayer2.text.u;

import android.text.TextUtils;
import com.google.common.base.b;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public final class f {

    private String a;
    private String b;
    private Set<String> c;
    private String d;
    private String e = null;
    private int f;
    private boolean g = false;
    private int h;
    private boolean i = false;
    private int j = -1;
    private int k = -1;
    private int l = -1;
    private int m = -1;
    private int n = -1;
    private float o;
    private int p = -1;
    private boolean q = false;
    public f() {
        super();
        String str = "";
        this.a = str;
        this.b = str;
        this.c = Collections.emptySet();
        this.d = str;
        int i = 0;
        int i2 = 0;
        int i3 = -1;
    }

    private static int B(int i, String string2, String string3, int i4) {
        int empty;
        if (!string2.isEmpty()) {
            if (i == -1) {
            } else {
                if (string2.equals(string3)) {
                    empty = i + i4;
                }
            }
            return empty;
        }
        return i;
    }

    public com.google.android.exoplayer2.text.u.f A(boolean z) {
        this.k = z;
        return this;
    }

    public int a() {
        if (!this.i) {
        } else {
            return this.h;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Background color not defined.");
        throw illegalStateException;
    }

    public boolean b() {
        return this.q;
    }

    public int c() {
        if (!this.g) {
        } else {
            return this.f;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Font color not defined");
        throw illegalStateException;
    }

    public String d() {
        return this.e;
    }

    public float e() {
        return this.o;
    }

    public int f() {
        return this.n;
    }

    public int g() {
        return this.p;
    }

    public int h(String string, String string2, Set<String> set3, String string4) {
        boolean empty;
        int obj5;
        if (this.a.isEmpty() && this.b.isEmpty() && this.c.isEmpty() && this.d.isEmpty()) {
            if (this.b.isEmpty()) {
                if (this.c.isEmpty()) {
                    if (this.d.isEmpty()) {
                        return TextUtils.isEmpty(string2);
                    }
                }
            }
        }
        final int i4 = 0;
        int i = 4;
        int obj4 = f.B(f.B(f.B(i4, this.a, string, 1073741824), this.b, string2, 2), this.d, string4, i);
        if (obj4 != -1 && !set3.containsAll(this.c)) {
            if (!set3.containsAll(this.c)) {
            }
            return obj4 += obj5;
        }
        return i4;
    }

    public int i() {
        int i2;
        int i3;
        int i;
        int i4 = this.l;
        int i6 = -1;
        if (i4 == i6 && this.m == i6) {
            if (this.m == i6) {
                return i6;
            }
        }
        int i7 = 1;
        i2 = i4 == i7 ? i7 : i3;
        if (this.m == i7) {
            i3 = 2;
        }
        return i2 |= i3;
    }

    public boolean j() {
        return this.i;
    }

    public boolean k() {
        return this.g;
    }

    public boolean l() {
        int i;
        if (this.j == 1) {
        } else {
            i = 0;
        }
        return i;
    }

    public boolean m() {
        int i;
        if (this.k == 1) {
        } else {
            i = 0;
        }
        return i;
    }

    public com.google.android.exoplayer2.text.u.f n(int i) {
        this.h = i;
        this.i = true;
        return this;
    }

    public com.google.android.exoplayer2.text.u.f o(boolean z) {
        this.l = z;
        return this;
    }

    public com.google.android.exoplayer2.text.u.f p(boolean z) {
        this.q = z;
        return this;
    }

    public com.google.android.exoplayer2.text.u.f q(int i) {
        this.f = i;
        this.g = true;
        return this;
    }

    public com.google.android.exoplayer2.text.u.f r(String string) {
        int obj1;
        if (string == null) {
            obj1 = 0;
        } else {
            obj1 = b.c(string);
        }
        this.e = obj1;
        return this;
    }

    public com.google.android.exoplayer2.text.u.f s(float f) {
        this.o = f;
        return this;
    }

    public com.google.android.exoplayer2.text.u.f t(int i) {
        this.n = i;
        return this;
    }

    public com.google.android.exoplayer2.text.u.f u(boolean z) {
        this.m = z;
        return this;
    }

    public com.google.android.exoplayer2.text.u.f v(int i) {
        this.p = i;
        return this;
    }

    public void w(String[] stringArr) {
        HashSet hashSet = new HashSet(Arrays.asList(stringArr));
        this.c = hashSet;
    }

    public void x(String string) {
        this.a = string;
    }

    public void y(String string) {
        this.b = string;
    }

    public void z(String string) {
        this.d = string;
    }
}
