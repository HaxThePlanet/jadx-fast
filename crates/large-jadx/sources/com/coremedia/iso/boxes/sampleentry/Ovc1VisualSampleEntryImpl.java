package com.coremedia.iso.boxes.sampleentry;

import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.a;
import com.googlecode.mp4parser.h.b;
import f.b.a.b;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes.dex */
public class Ovc1VisualSampleEntryImpl extends com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry {

    public static final String TYPE = "ovc1";
    private byte[] vc1Content;
    public Ovc1VisualSampleEntryImpl() {
        super("ovc1");
        this.vc1Content = new byte[0];
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void getBox(WritableByteChannel writableByteChannel) {
        writableByteChannel.write(getHeader());
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.position(6);
        g.e(allocate, this.dataReferenceIndex);
        writableByteChannel.write((ByteBuffer)allocate.rewind());
        writableByteChannel.write(ByteBuffer.wrap(this.vc1Content));
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public long getSize() {
        boolean largeBox;
        int i;
        long l;
        long l2;
        if (!this.largeBox) {
            if (Long.compare(l, l2) >= 0) {
            } else {
                i = 8;
            }
        }
        return i3 += i5;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public byte[] getVc1Content() {
        return this.vc1Content;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void parse(a a, ByteBuffer byteBuffer2, long l3, b b4) {
        ByteBuffer obj2 = ByteBuffer.allocate(b.a(l3));
        a.read(obj2);
        obj2.position(6);
        this.dataReferenceIndex = e.i(obj2);
        byte[] obj1 = new byte[obj2.remaining()];
        this.vc1Content = obj1;
        obj2.get(obj1);
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setVc1Content(byte[] bArr) {
        this.vc1Content = bArr;
    }
}
