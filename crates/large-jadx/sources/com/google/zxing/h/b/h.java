package com.google.zxing.h.b;

import com.google.zxing.b;
import java.nio.charset.StandardCharsets;

/* loaded from: classes2.dex */
final class h {

    private final String a;
    private com.google.zxing.h.b.l b;
    private b c;
    private b d;
    private final StringBuilder e;
    int f;
    private int g = -1;
    private com.google.zxing.h.b.k h;
    private int i;
    h(String string) {
        int i2;
        char c;
        int i;
        char charAt;
        super();
        byte[] bytes = string.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder stringBuilder2 = new StringBuilder(bytes.length);
        i2 = 0;
        while (i2 < bytes.length) {
            c = (char)i3;
            i = 63;
            stringBuilder2.append(c);
            i2++;
        }
        this.a = stringBuilder2.toString();
        this.b = l.FORCE_NONE;
        StringBuilder stringBuilder = new StringBuilder(string.length());
        this.e = stringBuilder;
        int obj8 = -1;
    }

    private int h() {
        return length -= i2;
    }

    public int a() {
        return this.e.length();
    }

    public StringBuilder b() {
        return this.e;
    }

    public char c() {
        return this.a.charAt(this.f);
    }

    public String d() {
        return this.a;
    }

    public int e() {
        return this.g;
    }

    public int f() {
        return i -= i3;
    }

    public com.google.zxing.h.b.k g() {
        return this.h;
    }

    public boolean i() {
        if (this.f < h()) {
            return 1;
        }
        return 0;
    }

    public void j() {
        this.g = -1;
    }

    public void k() {
        this.h = 0;
    }

    public void l(b b, b b2) {
        this.c = b;
        this.d = b2;
    }

    public void m(int i) {
        this.i = i;
    }

    public void n(com.google.zxing.h.b.l l) {
        this.b = l;
    }

    public void o(int i) {
        this.g = i;
    }

    public void p() {
        q(a());
    }

    public void q(int i) {
        int kVar;
        b bVar;
        b bVar2;
        int i2;
        int obj5;
        kVar = this.h;
        if (kVar != null) {
            if (i > kVar.a()) {
                this.h = k.l(i, this.b, this.c, this.d, true);
            }
        } else {
        }
    }

    public void r(char c) {
        this.e.append(c);
    }

    public void s(String string) {
        this.e.append(string);
    }
}
