package com.googlecode.mp4parser.boxes.mp4;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.boxes.mp4.a.l;
import com.googlecode.mp4parser.d;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: AbstractDescriptorBox.java */
/* loaded from: classes2.dex */
public class AbstractDescriptorBox extends AbstractFullBox {

    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    private static final /* synthetic */ a.a ajc$tjp_4;
    private static Logger log;
    protected ByteBuffer data;
    protected com.googlecode.mp4parser.boxes.mp4.a.b descriptor;
    static {
        AbstractDescriptorBox.ajc$preClinit();
        AbstractDescriptorBox.log = Logger.getLogger(AbstractDescriptorBox.class.getName());
    }

    public AbstractDescriptorBox(String str) {
        super(str);
    }

    private static /* synthetic */ void ajc$preClinit() {
        final m.b.a.a.b.b bVar = new b("AbstractDescriptorBox.java", AbstractDescriptorBox.class);
        final String str37 = "method-execution";
        AbstractDescriptorBox.ajc$tjp_0 = bVar.h(str37, bVar.g("1", "getData", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "", "", "", "java.nio.ByteBuffer"), 42);
        AbstractDescriptorBox.ajc$tjp_1 = bVar.h(str37, bVar.g("1", "setData", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "java.nio.ByteBuffer", "data", "", "void"), 46);
        AbstractDescriptorBox.ajc$tjp_2 = bVar.h(str37, bVar.g("1", "getDescriptor", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "", "", "", "com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor"), 62);
        AbstractDescriptorBox.ajc$tjp_3 = bVar.h(str37, bVar.g("1", "setDescriptor", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor", "descriptor", "", "void"), 66);
        AbstractDescriptorBox.ajc$tjp_4 = bVar.h(str37, bVar.g("1", "getDescriptorAsString", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "", "", "", "java.lang.String"), 70);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.data = byteBuffer.slice();
        byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
        try {
            this.data.rewind();
            this.descriptor = l.a(-1, this.data.duplicate());
        } catch (java.lang.IndexOutOfBoundsException ioobe) {
            Logger log2 = AbstractDescriptorBox.log;
            Level wARNING2 = Level.WARNING;
            log2.log(wARNING2, str, ioobe);
        } catch (java.io.IOException ioException1) {
            log2 = AbstractDescriptorBox.log;
            wARNING2 = Level.WARNING;
            log2.log(wARNING2, str, ioException1);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        this.data.rewind();
        byteBuffer.put(this.data);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)(this.data.limit() + 4);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public ByteBuffer getData() {
        d.b().c(b.c(AbstractDescriptorBox.ajc$tjp_0, this, this));
        return this.data;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public com.googlecode.mp4parser.boxes.mp4.a.b getDescriptor() {
        d.b().c(b.c(AbstractDescriptorBox.ajc$tjp_2, this, this));
        return this.descriptor;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getDescriptorAsString() {
        d.b().c(b.c(AbstractDescriptorBox.ajc$tjp_4, this, this));
        return this.descriptor.toString();
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setData(ByteBuffer byteBuffer) {
        d.b().c(b.d(AbstractDescriptorBox.ajc$tjp_1, this, this, byteBuffer));
        this.data = byteBuffer;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setDescriptor(com.googlecode.mp4parser.boxes.mp4.a.b bVar) {
        d.b().c(b.d(AbstractDescriptorBox.ajc$tjp_3, this, this, bVar));
        this.descriptor = bVar;
    }
}
