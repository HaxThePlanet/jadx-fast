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

/* compiled from: MpegSampleEntry.java */
/* loaded from: classes.dex */
public class MpegSampleEntry extends AbstractSampleEntry {
    public MpegSampleEntry() {
        super("mp4s");
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void getBox(WritableByteChannel writableByteChannel) throws java.io.IOException {
        writableByteChannel.write(getHeader());
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.position(6);
        g.e(allocate, this.dataReferenceIndex);
        writableByteChannel.write((ByteBuffer)allocate.rewind());
        writeContainer(writableByteChannel);
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public long getSize() {
        int i = 8;
        long l = getContainerSize() + 8L;
        if (!this.largeBox) {
            if (l >= 4294967296L) {
                i = 16;
            } else {
                i = 8;
            }
        }
        return l + (long)i;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void parse(a aVar, ByteBuffer byteBuffer, long j, b bVar) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        aVar.read(allocate);
        allocate.position(6);
        this.dataReferenceIndex = e.i(allocate);
        initContainer(aVar, j - 8L, bVar);
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public String toString() {
        String str2 = "MpegSampleEntry";
        java.util.List[] arr = new List[1];
        java.util.List list = Arrays.asList(new List[] { getBoxes() });
        str = str2 + list;
        return str;
    }

    public MpegSampleEntry(String str) {
        super(str);
    }
}
