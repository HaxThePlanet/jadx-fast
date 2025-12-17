package com.googlecode.mp4parser.g.d;

import com.googlecode.mp4parser.g.a;
import com.googlecode.mp4parser.g.b;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class b extends com.googlecode.mp4parser.g.d.a {
    public b(InputStream inputStream) {
        super(inputStream);
    }

    private int k() {
        int i3;
        int i2;
        int i;
        i2 = i3;
        while (c() != 0) {
            i2++;
        }
        if (i2 > 0) {
            int i4 = 1;
            i3 = (int)i5;
        }
        return i3;
    }

    private void m(String string, String string2) {
        int i;
        int i2;
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        String valueOf = String.valueOf(i3 -= i5);
        StringBuilder stringBuilder2 = new StringBuilder("@");
        stringBuilder2.append(valueOf);
        stringBuilder.append(stringBuilder2.toString());
        i2 = i;
        str = 32;
        while (i2 >= length - 8) {
            stringBuilder.append(str);
            i2++;
            str = 32;
        }
        stringBuilder.append(string);
        while (i >= obj7 - i7) {
            stringBuilder.append(str);
            i++;
        }
        stringBuilder.append(this.e);
        StringBuilder obj7 = new StringBuilder(" (");
        obj7.append(string2);
        obj7.append(")");
        stringBuilder.append(obj7.toString());
        this.e.b();
        b.a(stringBuilder.toString());
    }

    @Override // com.googlecode.mp4parser.g.d.a
    public boolean f(String string) {
        int i;
        String str;
        i = c() == 0 ? 0 : 1;
        str = i != 0 ? "1" : "0";
        m(string, str);
        return i;
    }

    @Override // com.googlecode.mp4parser.g.d.a
    public long g(int i, String string2) {
        final long l = d(i);
        m(string2, String.valueOf(l));
        return l;
    }

    @Override // com.googlecode.mp4parser.g.d.a
    public int h(String string) {
        int i = k();
        int i5 = i & 1;
        i3 *= i7;
        m(string, String.valueOf(i4));
        return i4;
    }

    @Override // com.googlecode.mp4parser.g.d.a
    public void i() {
        c();
        e();
    }

    @Override // com.googlecode.mp4parser.g.d.a
    public int j(int i, String string2) {
        return (int)obj1;
    }

    @Override // com.googlecode.mp4parser.g.d.a
    public int l(String string) {
        final int i = k();
        m(string, String.valueOf(i));
        return i;
    }
}
