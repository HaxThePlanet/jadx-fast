package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class g extends com.googlecode.mp4parser.boxes.mp4.samplegrouping.b {

    private boolean a;
    private short b;
    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public ByteBuffer a() {
        int i;
        ByteBuffer allocate = ByteBuffer.allocate(1);
        i = this.a ? 128 : 0;
        allocate.put((byte)i3);
        allocate.rewind();
        return allocate;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public String b() {
        return "rap ";
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public void c(ByteBuffer byteBuffer) {
        int i;
        byte obj3 = byteBuffer.get();
        i = obj3 & 128 == 128 ? 1 : 0;
        this.a = i;
        this.b = (short)obj3;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public boolean equals(Object object) {
        Class<com.googlecode.mp4parser.boxes.mp4.samplegrouping.g> obj;
        Class class;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object != null) {
            if (g.class != object.getClass()) {
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
        return i += s;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VisualRandomAccessEntry");
        stringBuilder.append("{numLeadingSamplesKnown=");
        stringBuilder.append(this.a);
        stringBuilder.append(", numLeadingSamples=");
        stringBuilder.append(this.b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
