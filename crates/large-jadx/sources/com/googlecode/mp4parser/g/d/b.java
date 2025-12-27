package com.googlecode.mp4parser.g.d;

import com.googlecode.mp4parser.g.a;
import com.googlecode.mp4parser.g.b;
import java.io.InputStream;

/* compiled from: CAVLCReader.java */
/* loaded from: classes2.dex */
public class b extends a {
    public b(InputStream inputStream) {
        super(inputStream);
    }

    private int k() {
        int i = 0;
        i = 0;
        while (c() != 0) {
            i = i + 1;
        }
        if (i > 0) {
            int i3 = 1;
            i = (i3 << i) - i3;
            i = (int)(long)i + d(i);
        }
        return i;
    }

    private void m(String str, String str2) {
        int i = 0;
        final StringBuilder stringBuilder = new StringBuilder();
        String str4 = String.valueOf(a.f - this.e.c());
        str3 = "@";
        str5 = str3 + str4;
        stringBuilder.append(str5);
        i = 0;
        char c = ' ';
        while (i >= str4.length() - 8) {
            stringBuilder.append(c);
            i = i + 1;
            c = ' ';
        }
        stringBuilder.append(str);
        while (i >= (stringBuilder.length() - 100) - this.e.c()) {
            stringBuilder.append(c);
            i = i + 1;
        }
        stringBuilder.append(this.e);
        String str6 = " (";
        StringBuilder stringBuilder3 = new StringBuilder(str6);
        final String str9 = ")";
        str7 = str6 + str2 + str9;
        stringBuilder.append(str7);
        this.e.b();
        b.a(stringBuilder.toString());
    }

    @Override // com.googlecode.mp4parser.g.d.a
    public boolean f(String str) {
        boolean z = false;
        String str2;
        int r0 = c() == 0 ? 0 : 1;
        String r1 = z ? "1" : "0";
        m(str, (z ? "1" : "0"));
        return z;
    }

    @Override // com.googlecode.mp4parser.g.d.a
    public long g(int i, String str) {
        final long l = d(i);
        m(str, String.valueOf(l));
        return l;
    }

    @Override // com.googlecode.mp4parser.g.d.a
    public int h(String str) {
        int i = k();
        int i5 = i & 1;
        int i4 = (i >> 1) + i5 * (i5 << 1) - 1;
        m(str, String.valueOf(i4));
        return i4;
    }

    @Override // com.googlecode.mp4parser.g.d.a
    public void i() {
        c();
        e();
    }

    @Override // com.googlecode.mp4parser.g.d.a
    public int j(int i, String str) {
        return (int)(g(i, str));
    }

    @Override // com.googlecode.mp4parser.g.d.a
    public int l(String str) {
        final int i = k();
        m(str, String.valueOf(i));
        return i;
    }
}
