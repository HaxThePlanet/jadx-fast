package com.googlecode.mp4parser.boxes.mp4;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.boxes.mp4.a.h;
import com.googlecode.mp4parser.d;
import java.nio.ByteBuffer;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: ESDescriptorBox.java */
/* loaded from: classes2.dex */
public class ESDescriptorBox extends AbstractDescriptorBox {

    public static final String TYPE = "esds";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    static {
        ESDescriptorBox.ajc$preClinit();
    }

    public ESDescriptorBox() {
        super("esds");
    }

    private static /* synthetic */ void ajc$preClinit() {
        final m.b.a.a.b.b bVar = new b("ESDescriptorBox.java", ESDescriptorBox.class);
        final String str30 = "method-execution";
        ESDescriptorBox.ajc$tjp_0 = bVar.h(str30, bVar.g("1", "getEsDescriptor", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "", "", "", "com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor"), 35);
        ESDescriptorBox.ajc$tjp_1 = bVar.h(str30, bVar.g("1", "setEsDescriptor", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor", "esDescriptor", "", "void"), 39);
        ESDescriptorBox.ajc$tjp_2 = bVar.h(str30, bVar.g("1", "equals", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "java.lang.Object", "o", "", "boolean"), 44);
        ESDescriptorBox.ajc$tjp_3 = bVar.h(str30, bVar.g("1", "hashCode", "com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox", "", "", "", "int"), 55);
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox
    public boolean equals(Object object) {
        d.b().c(b.d(ESDescriptorBox.ajc$tjp_2, this, this, object));
        boolean z = true;
        if (this == object) {
            return true;
        }
        boolean z2 = false;
        if (object != null) {
            if (getClass() == object.getClass()) {
                if (this.data != null) {
                    if (!this.data.equals(object.data)) {
                        return false;
                    }
                } else {
                    return object.data != null ? z2 : z;
                }
            }
        }
        return false;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox
    protected void getContent(ByteBuffer byteBuffer) {
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
        return (long)(remaining + 4);
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox
    public h getEsDescriptor() {
        d.b().c(b.c(ESDescriptorBox.ajc$tjp_0, this, this));
        return (h)super.getDescriptor();
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox
    public int hashCode() {
        int i = 0;
        d.b().c(b.c(ESDescriptorBox.ajc$tjp_3, this, this));
        if (this.data != null) {
            i = this.data.hashCode();
        } else {
            i = 0;
        }
        return i;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox
    public void setEsDescriptor(h hVar) {
        d.b().c(b.d(ESDescriptorBox.ajc$tjp_1, this, this, hVar));
        super.setDescriptor(hVar);
    }
}
