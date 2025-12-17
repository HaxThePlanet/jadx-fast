package com.coremedia.iso.boxes.sampleentry;

import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.a;
import f.b.a.b;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;

/* loaded from: classes.dex */
public class MpegSampleEntry extends com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry {
    public MpegSampleEntry() {
        super("mp4s");
    }

    public MpegSampleEntry(String string) {
        super(string);
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void getBox(WritableByteChannel writableByteChannel) {
        writableByteChannel.write(getHeader());
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.position(6);
        g.e(allocate, this.dataReferenceIndex);
        writableByteChannel.write((ByteBuffer)allocate.rewind());
        writeContainer(writableByteChannel);
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
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

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void parse(a a, ByteBuffer byteBuffer2, long l3, b b4) {
        ByteBuffer obj4 = ByteBuffer.allocate(8);
        a.read(obj4);
        obj4.position(6);
        this.dataReferenceIndex = e.i(obj4);
        initContainer(a, l3 -= i2, b4);
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("MpegSampleEntry");
        java.util.List[] arr = new List[1];
        stringBuilder.append(Arrays.asList(getBoxes()));
        return stringBuilder.toString();
    }
}
