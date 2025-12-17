package com.coremedia.iso.boxes;

import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.List;

/* loaded from: classes.dex */
public interface b {
    public abstract List<com.coremedia.iso.boxes.a> getBoxes();

    public abstract <T extends com.coremedia.iso.boxes.a> List<T> getBoxes(Class<T> class);

    public abstract <T extends com.coremedia.iso.boxes.a> List<T> getBoxes(Class<T> class, boolean z2);

    public abstract ByteBuffer getByteBuffer(long l, long l2);

    public abstract void writeContainer(WritableByteChannel writableByteChannel);
}
