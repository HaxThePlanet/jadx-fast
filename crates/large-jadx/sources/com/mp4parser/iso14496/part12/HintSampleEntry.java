package com.mp4parser.iso14496.part12;

import com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.a;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* compiled from: HintSampleEntry.java */
/* loaded from: classes2.dex */
public class HintSampleEntry extends AbstractSampleEntry {

    protected byte[] data;
    public HintSampleEntry(String str) {
        super(str);
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void getBox(WritableByteChannel writableByteChannel) throws java.io.IOException {
        writableByteChannel.write(getHeader());
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.position(6);
        g.e(allocate, this.dataReferenceIndex);
        allocate.rewind();
        writableByteChannel.write(allocate);
        writableByteChannel.write(ByteBuffer.wrap(this.data));
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public byte[] getData() {
        return this.data;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public long getSize() {
        boolean largeBox2;
        int i = 8;
        long l;
        long l2 = 4294967296L;
        i = 8;
        long l4 = (long)(this.data.length + i);
        if (!this.largeBox) {
            l = 8L + l4;
            l2 = 4294967296L;
            if (l >= l2) {
                i = 16;
            }
        }
        return l4 + (long)i;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void parse(a aVar, ByteBuffer byteBuffer, long j, f.b.a.b bVar) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        aVar.read(allocate);
        allocate.position(6);
        this.dataReferenceIndex = e.i(allocate);
        byte[] bArr = new byte[b.a(j - 8L)];
        this.data = bArr;
        aVar.read(ByteBuffer.wrap(bArr));
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setData(byte[] bArr) {
        this.data = bArr;
    }
}
