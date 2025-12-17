package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.a;
import f.b.a.b;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.List;

/* loaded from: classes.dex */
public class ItemProtectionBox extends AbstractContainerBox implements com.coremedia.iso.boxes.FullBox {

    public static final String TYPE = "ipro";
    private int flags;
    private int version;
    public ItemProtectionBox() {
        super("ipro");
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public void getBox(WritableByteChannel writableByteChannel) {
        writableByteChannel.write(getHeader());
        ByteBuffer allocate = ByteBuffer.allocate(6);
        g.j(allocate, this.version);
        g.f(allocate, this.flags);
        g.e(allocate, getBoxes().size());
        writableByteChannel.write((ByteBuffer)allocate.rewind());
        writeContainer(writableByteChannel);
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public int getFlags() {
        return this.flags;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public com.coremedia.iso.boxes.SchemeInformationBox getItemProtectionScheme() {
        if (!getBoxes(SchemeInformationBox.class).isEmpty()) {
            return (SchemeInformationBox)getBoxes(SchemeInformationBox.class).get(0);
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public long getSize() {
        int i;
        boolean largeBox;
        containerSize += i4;
        if (!this.largeBox) {
            if (Long.compare(i2, l) >= 0) {
                i = 16;
            } else {
                i = 8;
            }
        } else {
        }
        return i2 += l2;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public int getVersion() {
        return this.version;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public void parse(a a, ByteBuffer byteBuffer2, long l3, b b4) {
        ByteBuffer obj4 = ByteBuffer.allocate(6);
        a.read(obj4);
        obj4.rewind();
        this.version = e.n(obj4);
        this.flags = e.j(obj4);
        initContainer(a, l3 -= i2, b4);
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public void setFlags(int i) {
        this.flags = i;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public void setVersion(int i) {
        this.version = i;
    }
}
