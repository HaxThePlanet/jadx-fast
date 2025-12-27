package com.mp4parser.iso14496.part15;

import com.googlecode.mp4parser.boxes.mp4.samplegrouping.b;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;

/* compiled from: SyncSampleEntry.java */
/* loaded from: classes2.dex */
public class d extends b {

    int a;
    int b;
    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public ByteBuffer a() {
        ByteBuffer allocate = ByteBuffer.allocate(1);
        g.j(allocate, this.b + (this.a << 6));
        return (ByteBuffer)allocate.rewind();
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public void c(ByteBuffer byteBuffer) {
        int i3 = e.n(byteBuffer);
        this.a = (i3 & 192) >> 6;
        this.b = i3 & 63;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public boolean equals(Object object) {
        final boolean z = true;
        if (this == object) {
            return true;
        }
        final boolean z2 = false;
        if (object != null) {
            obj = d.class;
            if (obj == object.getClass()) {
                if (this.b != object.b) {
                    return false;
                }
                return this.a != object.a ? z2 : z;
            }
        }
        return false;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public int hashCode() {
        return (this.a * 31) + this.b;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public String toString() {
        String str2 = "SyncSampleEntry{reserved=";
        StringBuilder stringBuilder = new StringBuilder(str2);
        String str3 = ", nalUnitType=";
        str = str2 + this.a + str3 + this.b + 125;
        return str;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public String b() {
        return "sync";
    }
}
