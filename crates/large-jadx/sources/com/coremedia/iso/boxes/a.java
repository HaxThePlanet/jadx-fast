package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.a;
import f.b.a.b;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* compiled from: Box.java */
/* loaded from: classes.dex */
public interface a {
    void getBox(WritableByteChannel writableByteChannel);

    b getParent();

    long getSize();

    String getType();

    void parse(a aVar, ByteBuffer byteBuffer, long j, b bVar);

    void setParent(b bVar);
}
