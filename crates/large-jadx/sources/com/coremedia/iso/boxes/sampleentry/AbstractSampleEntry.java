package com.coremedia.iso.boxes.sampleentry;

import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.a;
import f.b.a.b;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* compiled from: AbstractSampleEntry.java */
/* loaded from: classes.dex */
public abstract class AbstractSampleEntry extends AbstractContainerBox implements SampleEntry {

    protected int dataReferenceIndex = 1;
    protected AbstractSampleEntry(String str) {
        super(str);
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public int getDataReferenceIndex() {
        return this.dataReferenceIndex;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public void setDataReferenceIndex(int i) {
        this.dataReferenceIndex = i;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public abstract void getBox(WritableByteChannel writableByteChannel);

    @Override // com.googlecode.mp4parser.AbstractContainerBox
    public abstract void parse(a aVar, ByteBuffer byteBuffer, long j, b bVar);
}
