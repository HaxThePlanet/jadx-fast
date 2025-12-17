package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import f.b.a.c;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class f extends com.googlecode.mp4parser.boxes.mp4.samplegrouping.b {

    private ByteBuffer a;
    private String b;
    public f(String string) {
        super();
        this.b = string;
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
        Class<com.googlecode.mp4parser.boxes.mp4.samplegrouping.f> obj;
        Class class;
        boolean obj5;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object != null) {
            if (f.class != object.getClass()) {
            } else {
                ByteBuffer byteBuffer = this.a;
                obj5 = object.a;
                if (byteBuffer != null) {
                    if (!byteBuffer.equals(obj5)) {
                        return i2;
                    }
                } else {
                    if (obj5 != null) {
                    }
                }
            }
            return i;
        }
        return i2;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public int hashCode() {
        int i;
        ByteBuffer byteBuffer = this.a;
        if (byteBuffer != null) {
            i = byteBuffer.hashCode();
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
        StringBuilder stringBuilder = new StringBuilder("UnknownEntry{content=");
        stringBuilder.append(c.a(bArr));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
