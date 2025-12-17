package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.a;
import f.b.a.b;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes.dex */
public interface FullBox extends com.coremedia.iso.boxes.a {
    @Override // com.coremedia.iso.boxes.a
    public abstract void getBox(WritableByteChannel writableByteChannel);

    @Override // com.coremedia.iso.boxes.a
    public abstract int getFlags();

    @Override // com.coremedia.iso.boxes.a
    public abstract long getOffset();

    @Override // com.coremedia.iso.boxes.a
    public abstract com.coremedia.iso.boxes.b getParent();

    @Override // com.coremedia.iso.boxes.a
    public abstract long getSize();

    @Override // com.coremedia.iso.boxes.a
    public abstract String getType();

    @Override // com.coremedia.iso.boxes.a
    public abstract int getVersion();

    @Override // com.coremedia.iso.boxes.a
    public abstract void parse(a a, ByteBuffer byteBuffer2, long l3, b b4);

    @Override // com.coremedia.iso.boxes.a
    public abstract void setFlags(int i);

    @Override // com.coremedia.iso.boxes.a
    public abstract void setParent(com.coremedia.iso.boxes.b b);

    @Override // com.coremedia.iso.boxes.a
    public abstract void setVersion(int i);
}
