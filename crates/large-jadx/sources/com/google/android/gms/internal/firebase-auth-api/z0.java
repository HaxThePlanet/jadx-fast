package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
abstract class z0 extends com.google.android.gms.internal.firebase-auth-api.wa<String> {

    final java.lang.CharSequence c;
    int v = 0;
    int w = Integer.MAX_VALUE;
    protected z0(com.google.android.gms.internal.firebase-auth-api.s1 s1, java.lang.CharSequence charSequence2) {
        super();
        final int i = 0;
        s1.a(s1);
        final int obj2 = Integer.MAX_VALUE;
        this.c = charSequence2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.wa
    protected final Object b() {
        int string;
        int length;
        int length2;
        int i3;
        int i4;
        int i2;
        int i;
        int i5 = this.v;
        length2 = this.v;
        i3 = -1;
        while (length2 != i3) {
            length2 = e(length2);
            if (length2 == i3) {
            } else {
            }
            this.v = d(length2);
            i2++;
            this.v = i4;
            if (i4 > this.c.length()) {
            }
            length2 = this.v;
            i3 = -1;
            this.v = i3;
            length2 = this.c.length();
            this.v = i3;
            i2 = i3;
        }
        c();
        string = 0;
        return string;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.wa
    abstract int d(int i);

    @Override // com.google.android.gms.internal.firebase-auth-api.wa
    abstract int e(int i);
}
