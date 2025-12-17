package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.a;
import f.b.a.b;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes.dex */
public interface a {
    public abstract void getBox(WritableByteChannel writableByteChannel);

    public abstract com.coremedia.iso.boxes.b getParent();

    public abstract long getSize();

    public abstract String getType();

    public abstract void parse(a a, ByteBuffer byteBuffer2, long l3, b b4);

    public abstract void setParent(com.coremedia.iso.boxes.b b);
}
