package com.googlecode.mp4parser.boxes.mp4.a;

import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
@g(tags = 20)
public class m extends com.googlecode.mp4parser.boxes.mp4.a.b {

    int d;
    public m() {
        super();
        this.a = 20;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public int a() {
        return 1;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public void e(ByteBuffer byteBuffer) {
        this.d = e.n(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public boolean equals(Object object) {
        Class<com.googlecode.mp4parser.boxes.mp4.a.m> obj;
        Class class;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object != null) {
            if (m.class != object.getClass()) {
            } else {
                if (this.d != object.d) {
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
        g.j(allocate, 20);
        f(allocate, a());
        g.j(allocate, this.d);
        return allocate;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public int hashCode() {
        return this.d;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ProfileLevelIndicationDescriptor");
        stringBuilder.append("{profileLevelIndicationIndex=");
        stringBuilder.append(Integer.toHexString(this.d));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
