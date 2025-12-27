package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import java.nio.ByteBuffer;

/* compiled from: VisualRandomAccessEntry.java */
/* loaded from: classes2.dex */
public class g extends b {

    private boolean a;
    private short b;
    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public ByteBuffer a() {
        int i = 128;
        ByteBuffer allocate = ByteBuffer.allocate(1);
        int r1 = this.a ? 128 : 0;
        allocate.put((this.a ? 128 : 0));
        allocate.rewind();
        return allocate;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public void c(ByteBuffer byteBuffer) {
        int i = 1;
        byte b = byteBuffer.get();
        int r0 = (b & 128) == 128 ? 1 : 0;
        this.a = ((b & 128) == 128 ? 1 : 0);
        this.b = (short)b & 127;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public boolean equals(Object object) {
        final boolean z = true;
        if (this == object) {
            return true;
        }
        final boolean z2 = false;
        if (object != null) {
            obj = g.class;
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
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "VisualRandomAccessEntry";
        String str3 = "{numLeadingSamplesKnown=";
        String str4 = ", numLeadingSamples=";
        str = str2 + str3 + this.a + str4 + this.b + 125;
        return str;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public String b() {
        return "rap ";
    }
}
