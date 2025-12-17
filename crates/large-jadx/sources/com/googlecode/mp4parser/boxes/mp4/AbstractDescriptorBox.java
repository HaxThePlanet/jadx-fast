package com.googlecode.mp4parser.boxes.mp4;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.boxes.mp4.a.b;
import com.googlecode.mp4parser.boxes.mp4.a.l;
import com.googlecode.mp4parser.d;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public class AbstractDescriptorBox extends AbstractFullBox {

    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static Logger log;
    protected ByteBuffer data;
    protected b descriptor;
    static {
        AbstractDescriptorBox.ajc$preClinit();
        AbstractDescriptorBox.log = Logger.getLogger(AbstractDescriptorBox.class.getName());
    }

    public AbstractDescriptorBox(String string) {
        super(string);
    }

    private static void ajc$preClinit() {
        b bVar6 = new b("AbstractDescriptorBox.java", AbstractDescriptorBox.class);
        final String str37 = "method-execution";
        AbstractDescriptorBox.ajc$tjp_0 = bVar6.h(str37, bVar6.g("1", "getData", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "", "", "", "java.nio.ByteBuffer"), 42);
        AbstractDescriptorBox.ajc$tjp_1 = bVar6.h(str37, bVar6.g("1", "setData", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "java.nio.ByteBuffer", "data", "", "void"), 46);
        AbstractDescriptorBox.ajc$tjp_2 = bVar6.h(str37, bVar6.g("1", "getDescriptor", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "", "", "", "com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor"), 62);
        AbstractDescriptorBox.ajc$tjp_3 = bVar6.h(str37, bVar6.g("1", "setDescriptor", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BaseDescriptor", "descriptor", "", "void"), 66);
        AbstractDescriptorBox.ajc$tjp_4 = bVar6.h(str37, bVar6.g("1", "getDescriptorAsString", "com.googlecode.mp4parser.boxes.mp4.AbstractDescriptorBox", "", "", "", "java.lang.String"), 70);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        ByteBuffer duplicate;
        int remaining;
        b obj4;
        final String str = "Error parsing ObjectDescriptor";
        parseVersionAndFlags(byteBuffer);
        this.data = byteBuffer.slice();
        byteBuffer.position(position += remaining);
        this.data.rewind();
        this.descriptor = l.a(-1, this.data.duplicate());
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        this.data.rewind();
        byteBuffer.put(this.data);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public ByteBuffer getData() {
        d.b().c(b.c(AbstractDescriptorBox.ajc$tjp_0, this, this));
        return this.data;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public b getDescriptor() {
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
    public void setDescriptor(b b) {
        d.b().c(b.d(AbstractDescriptorBox.ajc$tjp_3, this, this, b));
        this.descriptor = b;
    }
}
