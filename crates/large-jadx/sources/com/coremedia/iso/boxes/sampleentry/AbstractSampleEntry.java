package com.coremedia.iso.boxes.sampleentry;

import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.a;
import f.b.a.b;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes.dex */
public abstract class AbstractSampleEntry extends AbstractContainerBox implements com.coremedia.iso.boxes.sampleentry.SampleEntry {

    protected int dataReferenceIndex = 1;
    protected AbstractSampleEntry(String string) {
        super(string);
        final int obj1 = 1;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public abstract void getBox(WritableByteChannel writableByteChannel);

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public int getDataReferenceIndex() {
        return this.dataReferenceIndex;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public abstract void parse(a a, ByteBuffer byteBuffer2, long l3, b b4);

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public void setDataReferenceIndex(int i) {
        this.dataReferenceIndex = i;
    }
}
