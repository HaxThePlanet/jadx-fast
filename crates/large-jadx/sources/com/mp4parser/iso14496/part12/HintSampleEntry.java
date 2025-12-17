package com.mp4parser.iso14496.part12;

import com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.a;
import com.googlecode.mp4parser.h.b;
import f.b.a.b;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes2.dex */
public class HintSampleEntry extends AbstractSampleEntry {

    protected byte[] data;
    public HintSampleEntry(String string) {
        super(string);
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void getBox(WritableByteChannel writableByteChannel) {
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
        int largeBox;
        int i2;
        int i;
        long l;
        long l3 = (long)i3;
        if (!this.largeBox) {
            if (Long.compare(i, l) >= 0) {
                i2 = 16;
            }
        } else {
        }
        return l3 += l2;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void parse(a a, ByteBuffer byteBuffer2, long l3, b b4) {
        ByteBuffer obj4 = ByteBuffer.allocate(8);
        a.read(obj4);
        obj4.position(6);
        this.dataReferenceIndex = e.i(obj4);
        obj4 = new byte[b.a(l3 -= i)];
        this.data = obj4;
        a.read(ByteBuffer.wrap(obj4));
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setData(byte[] bArr) {
        this.data = bArr;
    }
}
