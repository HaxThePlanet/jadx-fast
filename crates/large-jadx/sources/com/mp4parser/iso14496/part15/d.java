package com.mp4parser.iso14496.part15;

import com.googlecode.mp4parser.boxes.mp4.samplegrouping.b;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class d extends b {

    int a;
    int b;
    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public ByteBuffer a() {
        ByteBuffer allocate = ByteBuffer.allocate(1);
        g.j(allocate, i2 += i5);
        return (ByteBuffer)allocate.rewind();
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public String b() {
        return "sync";
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public void c(ByteBuffer byteBuffer) {
        int obj2 = e.n(byteBuffer);
        this.a = i >>= 6;
        this.b = obj2 &= 63;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public boolean equals(Object object) {
        Class<com.mp4parser.iso14496.part15.d> obj;
        Class class;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object != null) {
            if (d.class != object.getClass()) {
            } else {
                if (this.b != object.b) {
                    return i2;
                }
                if (this.a != object.a) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public int hashCode() {
        return i2 += i4;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SyncSampleEntry{reserved=");
        stringBuilder.append(this.a);
        stringBuilder.append(", nalUnitType=");
        stringBuilder.append(this.b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
