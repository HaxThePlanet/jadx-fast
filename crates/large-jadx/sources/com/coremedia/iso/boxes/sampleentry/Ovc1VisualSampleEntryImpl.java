package com.coremedia.iso.boxes.sampleentry;

import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.a;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* compiled from: Ovc1VisualSampleEntryImpl.java */
/* loaded from: classes.dex */
public class Ovc1VisualSampleEntryImpl extends AbstractSampleEntry {

    public static final String TYPE = "ovc1";
    private byte[] vc1Content;
    public Ovc1VisualSampleEntryImpl() {
        super("ovc1");
        this.vc1Content = new byte[0];
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void getBox(WritableByteChannel writableByteChannel) throws java.io.IOException {
        writableByteChannel.write(getHeader());
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.position(6);
        g.e(allocate, this.dataReferenceIndex);
        writableByteChannel.write((ByteBuffer)allocate.rewind());
        writableByteChannel.write(ByteBuffer.wrap(this.vc1Content));
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public long getSize() {
        int i = 16;
        i = 16;
        if (!this.largeBox) {
            l = (long)(this.vc1Content.length + 16);
            long l2 = 4294967296L;
            if (l < l2) {
                i = 8;
            }
        }
        return (long)i + (long)this.vc1Content.length + 8L;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public byte[] getVc1Content() {
        return this.vc1Content;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void parse(a aVar, ByteBuffer byteBuffer, long j, f.b.a.b bVar) {
        ByteBuffer allocate = ByteBuffer.allocate(b.a(j));
        aVar.read(allocate);
        allocate.position(6);
        this.dataReferenceIndex = e.i(allocate);
        byte[] bArr = new byte[allocate.remaining()];
        this.vc1Content = bArr;
        allocate.get(bArr);
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry
    public void setVc1Content(byte[] bArr) {
        this.vc1Content = bArr;
    }
}
