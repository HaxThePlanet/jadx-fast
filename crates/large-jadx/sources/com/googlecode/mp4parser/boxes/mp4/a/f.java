package com.googlecode.mp4parser.boxes.mp4.a;

import f.b.a.c;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes2.dex */
@g(tags = 5)
public class f extends com.googlecode.mp4parser.boxes.mp4.a.b {

    byte[] d;
    public f() {
        super();
        this.a = 5;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    int a() {
        return bArr.length;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public void e(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.remaining()];
        this.d = bArr;
        byteBuffer.get(bArr);
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public boolean equals(Object object) {
        Class<com.googlecode.mp4parser.boxes.mp4.a.f> obj;
        Class class;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object != null) {
            if (f.class != object.getClass()) {
            } else {
                if (!Arrays.equals(this.d, object.d)) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public ByteBuffer g() {
        ByteBuffer allocate = ByteBuffer.allocate(b());
        g.j(allocate, this.a);
        f(allocate, a());
        allocate.put(this.d);
        return (ByteBuffer)allocate.rewind();
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public int hashCode() {
        int i;
        byte[] bArr = this.d;
        if (bArr != null) {
            i = Arrays.hashCode(bArr);
        } else {
            i = 0;
        }
        return i;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public String toString() {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DecoderSpecificInfo");
        stringBuilder.append("{bytes=");
        byte[] bArr = this.d;
        if (bArr == null) {
            str = "null";
        } else {
            str = c.a(bArr);
        }
        stringBuilder.append(str);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
