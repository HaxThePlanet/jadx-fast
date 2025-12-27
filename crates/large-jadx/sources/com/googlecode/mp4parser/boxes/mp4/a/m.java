package com.googlecode.mp4parser.boxes.mp4.a;

import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;

/* compiled from: ProfileLevelIndicationDescriptor.java */
@g(tags = 20)
/* loaded from: classes2.dex */
public class m extends b {

    int d;
    public m() {
        super();
        this.a = 20;
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
            obj = m.class;
            if (obj == object.getClass()) {
                return this.d != object.d ? z2 : z;
            }
        }
        return false;
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
        String str2 = "ProfileLevelIndicationDescriptor";
        String str3 = "{profileLevelIndicationIndex=";
        String str4 = Integer.toHexString(this.d);
        str = str2 + str3 + str4 + 125;
        return str;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public int a() {
        return 1;
    }
}
