package com.googlecode.mp4parser.boxes.mp4.a;

import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
@g(tags = 6)
public class n extends com.googlecode.mp4parser.boxes.mp4.a.b {

    int d;
    public n() {
        super();
        this.a = 6;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    int a() {
        return 1;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public void e(ByteBuffer byteBuffer) {
        this.d = e.n(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public boolean equals(Object object) {
        Class<com.googlecode.mp4parser.boxes.mp4.a.n> obj;
        Class class;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object != null) {
            if (n.class != object.getClass()) {
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
        g.j(allocate, 6);
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
        stringBuilder.append("SLConfigDescriptor");
        stringBuilder.append("{predefined=");
        stringBuilder.append(this.d);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
