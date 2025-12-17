package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public abstract class ChunkOffsetBox extends AbstractFullBox {

    private static final a.a ajc$tjp_0;
    static {
        ChunkOffsetBox.ajc$preClinit();
    }

    public ChunkOffsetBox(String string) {
        super(string);
    }

    private static void ajc$preClinit() {
        b bVar2 = new b("ChunkOffsetBox.java", ChunkOffsetBox.class);
        ChunkOffsetBox.ajc$tjp_0 = bVar2.h("method-execution", bVar2.g("1", "toString", "com.coremedia.iso.boxes.ChunkOffsetBox", "", "", "", "java.lang.String"), 18);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public abstract long[] getChunkOffsets();

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public abstract void setChunkOffsets(long[] lArr);

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(ChunkOffsetBox.ajc$tjp_0, this, this));
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(getClass().getSimpleName()));
        stringBuilder.append("[entryCount=");
        stringBuilder.append(chunkOffsets.length);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
