package com.coremedia.iso.boxes.sampleentry;

import com.coremedia.iso.boxes.a;
import com.coremedia.iso.boxes.b;
import com.googlecode.mp4parser.a;
import f.b.a.b;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.List;

/* loaded from: classes.dex */
public interface SampleEntry extends a, b {
    @Override // com.coremedia.iso.boxes.a
    public abstract void getBox(WritableByteChannel writableByteChannel);

    public abstract List<a> getBoxes();

    public abstract <T extends a> List<T> getBoxes(Class<T> class);

    public abstract <T extends a> List<T> getBoxes(Class<T> class, boolean z2);

    @Override // com.coremedia.iso.boxes.a
    public abstract ByteBuffer getByteBuffer(long l, long l2);

    @Override // com.coremedia.iso.boxes.a
    public abstract int getDataReferenceIndex();

    @Override // com.coremedia.iso.boxes.a
    public abstract long getOffset();

    @Override // com.coremedia.iso.boxes.a
    public abstract b getParent();

    @Override // com.coremedia.iso.boxes.a
    public abstract long getSize();

    @Override // com.coremedia.iso.boxes.a
    public abstract String getType();

    @Override // com.coremedia.iso.boxes.a
    public abstract void parse(a a, ByteBuffer byteBuffer2, long l3, b b4);

    public abstract void setBoxes(List<a> list);

    @Override // com.coremedia.iso.boxes.a
    public abstract void setDataReferenceIndex(int i);

    @Override // com.coremedia.iso.boxes.a
    public abstract void setParent(b b);

    @Override // com.coremedia.iso.boxes.a
    public abstract void writeContainer(WritableByteChannel writableByteChannel);
}
