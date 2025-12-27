package com.googlecode.mp4parser.boxes.mp4.a;

import f.b.a.c;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: DecoderSpecificInfo.java */
@g(tags = 5)
/* loaded from: classes2.dex */
public class f extends b {

    byte[] d;
    public f() {
        super();
        this.a = 5;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    int a() {
        return this.d.length;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public void e(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.remaining()];
        this.d = bArr;
        byteBuffer.get(bArr);
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public boolean equals(Object object) {
        final boolean z = true;
        if (this == object) {
            return true;
        }
        final boolean z2 = false;
        if (object != null) {
            obj = f.class;
            if (obj == object.getClass()) {
                return !Arrays.equals(this.d, object.d) ? z2 : z;
            }
        }
        return false;
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
        int i = 0;
        if (this.d != null) {
            i = Arrays.hashCode(this.d);
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
        if (this.d == null) {
            str = "null";
        } else {
            str = c.a(this.d);
        }
        stringBuilder.append(str);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
