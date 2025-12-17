package com.google.android.exoplayer2.util;

import java.io.BufferedOutputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public final class g0 extends BufferedOutputStream {

    private boolean a;
    public g0(OutputStream outputStream) {
        super(outputStream);
    }

    public g0(OutputStream outputStream, int i2) {
        super(outputStream, i2);
    }

    @Override // java.io.BufferedOutputStream
    public void a(OutputStream outputStream) {
        g.f(this.a);
        this.out = outputStream;
        final int obj2 = 0;
        this.count = obj2;
        this.a = obj2;
    }

    @Override // java.io.BufferedOutputStream
    public void close() {
        int i;
        OutputStream out;
        this.a = true;
        int i3 = 0;
        flush();
        i = i3;
        this.out.close();
        if (i != 0) {
        } else {
        }
        p0.A0(i);
        throw i3;
    }
}
