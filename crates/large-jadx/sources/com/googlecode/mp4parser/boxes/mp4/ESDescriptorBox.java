package com.googlecode.mp4parser.boxes.mp4;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.boxes.mp4.a.b;
import com.googlecode.mp4parser.boxes.mp4.a.h;
import com.googlecode.mp4parser.d;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public class ESDescriptorBox extends com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox {

    public static final String TYPE = "esds";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    static {
        ESDescriptorBox.ajc$preClinit();
    }

    public ESDescriptorBox() {
        super("esds");
    }

    private static void ajc$preClinit() {
        b bVar5 = new b("ESDescriptorBox.java", ESDescriptorBox.class);
        final String str30 = "method-execution";
        ESDescriptorBox.ajc$tjp_0 = bVar5.h(str30, bVar5.g("1", "getEsDescriptor", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "", "", "", "com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor"), 35);
        ESDescriptorBox.ajc$tjp_1 = bVar5.h(str30, bVar5.g("1", "setEsDescriptor", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor", "esDescriptor", "", "void"), 39);
        ESDescriptorBox.ajc$tjp_2 = bVar5.h(str30, bVar5.g("1", "equals", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "java.lang.Object", "o", "", "boolean"), 44);
        ESDescriptorBox.ajc$tjp_3 = bVar5.h(str30, bVar5.g("1", "hashCode", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "", "", "", "int"), 55);
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox
    public boolean equals(Object object) {
        Class class2;
        Class class;
        boolean obj5;
        d.b().c(b.d(ESDescriptorBox.ajc$tjp_2, this, this, object));
        int i = 1;
        if (this == object) {
            return i;
        }
        int i2 = 0;
        if (object != null) {
            if (getClass() != object.getClass()) {
            } else {
                ByteBuffer data = this.data;
                obj5 = object.data;
                if (data != null) {
                    if (!data.equals(obj5)) {
                        return i2;
                    }
                } else {
                    if (obj5 != null) {
                    }
                }
            }
            return i;
        }
        return i2;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox
    protected void getContent(ByteBuffer byteBuffer) {
        Object duplicate;
        writeVersionAndFlags(byteBuffer);
        h esDescriptor = getEsDescriptor();
        if (esDescriptor != null) {
            byteBuffer.put((ByteBuffer)esDescriptor.g().rewind());
        } else {
            byteBuffer.put(this.data.duplicate());
        }
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox
    protected long getContentSize() {
        int remaining;
        h esDescriptor = getEsDescriptor();
        if (esDescriptor != null) {
            remaining = esDescriptor.b();
        } else {
            remaining = this.data.remaining();
        }
        return (long)i;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox
    public h getEsDescriptor() {
        d.b().c(b.c(ESDescriptorBox.ajc$tjp_0, this, this));
        return (h)super.getDescriptor();
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox
    public int hashCode() {
        int i;
        d.b().c(b.c(ESDescriptorBox.ajc$tjp_3, this, this));
        ByteBuffer data = this.data;
        if (data != null) {
            i = data.hashCode();
        } else {
            i = 0;
        }
        return i;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox
    public void setEsDescriptor(h h) {
        d.b().c(b.d(ESDescriptorBox.ajc$tjp_1, this, this, h));
        super.setDescriptor(h);
    }
}
