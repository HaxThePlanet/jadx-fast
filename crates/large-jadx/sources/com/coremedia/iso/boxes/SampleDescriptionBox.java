package com.coremedia.iso.boxes;

import com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.a;
import f.b.a.b;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.Iterator;
import java.util.List;

/* compiled from: SampleDescriptionBox.java */
/* loaded from: classes.dex */
public class SampleDescriptionBox extends AbstractContainerBox implements FullBox {

    public static final String TYPE = "stsd";
    private int flags;
    private int version;
    public SampleDescriptionBox() {
        super("stsd");
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public void getBox(WritableByteChannel writableByteChannel) throws java.io.IOException {
        writableByteChannel.write(getHeader());
        ByteBuffer allocate = ByteBuffer.allocate(8);
        g.j(allocate, this.version);
        g.f(allocate, this.flags);
        g.g(allocate, (long)getBoxes().size());
        writableByteChannel.write((ByteBuffer)allocate.rewind());
        writeContainer(writableByteChannel);
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public int getFlags() {
        return this.flags;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public AbstractSampleEntry getSampleEntry() {
        Iterator it = getBoxes(AbstractSampleEntry.class).iterator();
        if (it.hasNext()) {
            return (AbstractSampleEntry)it.next();
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public long getSize() {
        int i = 8;
        boolean largeBox2;
        long l = 8L;
        long l3 = getContainerSize() + l;
        if (!this.largeBox) {
            l += l3;
            long l2 = 4294967296L;
            if (l5 >= l2) {
                i = 16;
            } else {
                i = 8;
            }
        }
        return l3 + (long)i;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public int getVersion() {
        return this.version;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public void parse(a aVar, ByteBuffer byteBuffer, long j, b bVar) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        aVar.read(allocate);
        allocate.rewind();
        this.version = e.n(allocate);
        this.flags = e.j(allocate);
        initContainer(aVar, j - 8L, bVar);
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
