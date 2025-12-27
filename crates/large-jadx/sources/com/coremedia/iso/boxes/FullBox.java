package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.a;
import f.b.a.b;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* compiled from: FullBox.java */
/* loaded from: classes.dex */
public interface FullBox extends a {
    /* synthetic */ void getBox(WritableByteChannel writableByteChannel);

    int getFlags();

    /* synthetic */ long getOffset();

    /* synthetic */ b getParent();

    /* synthetic */ long getSize();

    /* synthetic */ String getType();

    int getVersion();

    /* synthetic */ void parse(a aVar, ByteBuffer byteBuffer, long j, b bVar);

    void setFlags(int i);

    /* synthetic */ void setParent(b bVar);

    void setVersion(int i);
}
