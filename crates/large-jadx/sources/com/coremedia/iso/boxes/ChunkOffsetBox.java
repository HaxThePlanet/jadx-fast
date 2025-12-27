package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: ChunkOffsetBox.java */
/* loaded from: classes.dex */
public abstract class ChunkOffsetBox extends AbstractFullBox {

    private static final /* synthetic */ a.a ajc$tjp_0;
    static {
        ChunkOffsetBox.ajc$preClinit();
    }

    public ChunkOffsetBox(String str) {
        super(str);
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("ChunkOffsetBox.java", ChunkOffsetBox.class);
        ChunkOffsetBox.ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "toString", "com.coremedia.iso.boxes.ChunkOffsetBox", "", "", "", "java.lang.String"), 18);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(ChunkOffsetBox.ajc$tjp_0, this, this));
        String str2 = String.valueOf(getClass().getSimpleName());
        StringBuilder stringBuilder = new StringBuilder(str2);
        String str3 = "[entryCount=";
        int length = getChunkOffsets().length;
        String str4 = "]";
        str = str2 + str3 + length + str4;
        return str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public abstract long[] getChunkOffsets();

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public abstract void setChunkOffsets(long[] jArr);
}
