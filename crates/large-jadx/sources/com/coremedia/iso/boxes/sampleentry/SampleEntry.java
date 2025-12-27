package com.coremedia.iso.boxes.sampleentry;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.List;

/* compiled from: SampleEntry.java */
/* loaded from: classes.dex */
public interface SampleEntry extends com.coremedia.iso.boxes.a, com.coremedia.iso.boxes.b {
    /* synthetic */ void getBox(WritableByteChannel writableByteChannel);

    /* synthetic */ List<com.coremedia.iso.boxes.a> getBoxes();

    /* synthetic */ <T extends com.coremedia.iso.boxes.a> List<T> getBoxes(Class<T> cls);

    /* synthetic */ <T extends com.coremedia.iso.boxes.a> List<T> getBoxes(Class<T> cls, boolean z);

    /* synthetic */ ByteBuffer getByteBuffer(long j, long j2);

    int getDataReferenceIndex();

    /* synthetic */ long getOffset();

    /* synthetic */ com.coremedia.iso.boxes.b getParent();

    /* synthetic */ long getSize();

    /* synthetic */ String getType();

    /* synthetic */ void parse(com.googlecode.mp4parser.a aVar, ByteBuffer byteBuffer, long j, f.b.a.b bVar);

    /* synthetic */ void setBoxes(List<com.coremedia.iso.boxes.a> list);

    void setDataReferenceIndex(int i);

    /* synthetic */ void setParent(com.coremedia.iso.boxes.b bVar);

    /* synthetic */ void writeContainer(WritableByteChannel writableByteChannel);
}
