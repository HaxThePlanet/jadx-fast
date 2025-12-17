package com.google.android.exoplayer2.m2.i;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

/* loaded from: classes2.dex */
public final class c {

    private final ByteArrayOutputStream a;
    private final DataOutputStream b;
    public c() {
        super();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.a = byteArrayOutputStream;
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        this.b = dataOutputStream;
    }

    private static void b(DataOutputStream dataOutputStream, String string2) {
        dataOutputStream.writeBytes(string2);
        dataOutputStream.writeByte(0);
    }

    public byte[] a(com.google.android.exoplayer2.m2.i.a a) {
        String str;
        this.a.reset();
        c.b(this.b, a.a);
        if (a.b != null) {
        } else {
            str = "";
        }
        c.b(this.b, str);
        this.b.writeLong(a.c);
        this.b.writeLong(a.v);
        this.b.write(a.w);
        this.b.flush();
        return this.a.toByteArray();
    }
}
