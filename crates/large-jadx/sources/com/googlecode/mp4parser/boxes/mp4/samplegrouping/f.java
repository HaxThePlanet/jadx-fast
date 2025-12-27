package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import f.b.a.c;
import java.nio.ByteBuffer;

/* compiled from: UnknownEntry.java */
/* loaded from: classes2.dex */
public class f extends b {

    private ByteBuffer a;
    private String b;
    public f(String str) {
        super();
        this.b = str;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public ByteBuffer a() {
        return this.a.duplicate();
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public String b() {
        return this.b;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public void c(ByteBuffer byteBuffer) {
        this.a = (ByteBuffer)byteBuffer.duplicate().rewind();
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public boolean equals(Object object) {
        final boolean z = true;
        if (this == object) {
            return true;
        }
        final boolean z2 = false;
        if (object != null) {
            obj = f.class;
            if (obj == object.getClass()) {
                if (this.a != null) {
                    if (!this.a.equals(object.a)) {
                        return false;
                    }
                } else {
                    return object.a != null ? z2 : z;
                }
            }
        }
        return false;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public int hashCode() {
        int i = 0;
        if (this.a != null) {
            i = this.a.hashCode();
        } else {
            i = 0;
        }
        return i;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public String toString() {
        ByteBuffer duplicate = this.a.duplicate();
        duplicate.rewind();
        byte[] bArr = new byte[duplicate.limit()];
        duplicate.get(bArr);
        final String str3 = "UnknownEntry{content=";
        StringBuilder stringBuilder = new StringBuilder(str3);
        String str2 = c.a(bArr);
        str = str3 + str2 + 125;
        return str;
    }
}
