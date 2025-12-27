package com.googlecode.mp4parser.boxes.mp4.a;

import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;

/* compiled from: SLConfigDescriptor.java */
@g(tags = 6)
/* loaded from: classes2.dex */
public class n extends b {

    int d;
    public n() {
        super();
        this.a = 6;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public void e(ByteBuffer byteBuffer) {
        this.d = e.n(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public boolean equals(Object object) {
        final boolean z = true;
        if (this == object) {
            return true;
        }
        final boolean z2 = false;
        if (object != null) {
            obj = n.class;
            if (obj == object.getClass()) {
                return this.d != object.d ? z2 : z;
            }
        }
        return false;
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
        String str2 = "SLConfigDescriptor";
        String str3 = "{predefined=";
        str = str2 + str3 + this.d + 125;
        return str;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    int a() {
        return 1;
    }
}
