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

/* compiled from: ItemProtectionBox.java */
/* loaded from: classes.dex */
public class ItemProtectionBox extends AbstractContainerBox implements FullBox {

    public static final String TYPE = "ipro";
    private int flags;
    private int version;
    public ItemProtectionBox() {
        super("ipro");
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public void getBox(WritableByteChannel writableByteChannel) throws java.io.IOException {
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
    public SchemeInformationBox getItemProtectionScheme() {
        if (!getBoxes(SchemeInformationBox.class).isEmpty()) {
            return (SchemeInformationBox)getBoxes(SchemeInformationBox.class).get(0);
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public long getSize() {
        int i = 8;
        long l = getContainerSize() + 6L;
        if (!this.largeBox) {
            if (l >= 4294967296L) {
                i = 16;
            } else {
                i = 8;
            }
        }
        return l + (long)i;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public int getVersion() {
        return this.version;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public void parse(a aVar, ByteBuffer byteBuffer, long j, b bVar) {
        ByteBuffer allocate = ByteBuffer.allocate(6);
        aVar.read(allocate);
        allocate.rewind();
        this.version = e.n(allocate);
        this.flags = e.j(allocate);
        initContainer(aVar, j - 6L, bVar);
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
