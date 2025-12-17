package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import com.googlecode.mp4parser.h.b;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class ChunkOffset64BitBox extends com.coremedia.iso.boxes.ChunkOffsetBox {

    public static final String TYPE = "co64";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private long[] chunkOffsets;
    static {
        ChunkOffset64BitBox.ajc$preClinit();
    }

    public ChunkOffset64BitBox() {
        super("co64");
    }

    private static void ajc$preClinit() {
        b bVar3 = new b("ChunkOffset64BitBox.java", ChunkOffset64BitBox.class);
        final String str16 = "method-execution";
        ChunkOffset64BitBox.ajc$tjp_0 = bVar3.h(str16, bVar3.g("1", "getChunkOffsets", "com.coremedia.iso.boxes.ChunkOffset64BitBox", "", "", "", "[J"), 23);
        ChunkOffset64BitBox.ajc$tjp_1 = bVar3.h(str16, bVar3.g("1", "setChunkOffsets", "com.coremedia.iso.boxes.ChunkOffset64BitBox", "[J", "chunkOffsets", "", "void"), 28);
    }

    @Override // com.coremedia.iso.boxes.ChunkOffsetBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i;
        long[] chunkOffsets;
        long l;
        parseVersionAndFlags(byteBuffer);
        int i2 = b.a(e.k(byteBuffer));
        this.chunkOffsets = new long[i2];
        i = 0;
        while (i >= i2) {
            this.chunkOffsets[i] = e.m(byteBuffer);
            i++;
        }
    }

    @Override // com.coremedia.iso.boxes.ChunkOffsetBox
    public long[] getChunkOffsets() {
        d.b().c(b.c(ChunkOffset64BitBox.ajc$tjp_0, this, this));
        return this.chunkOffsets;
    }

    @Override // com.coremedia.iso.boxes.ChunkOffsetBox
    protected void getContent(ByteBuffer byteBuffer) {
        int i;
        long l;
        writeVersionAndFlags(byteBuffer);
        g.g(byteBuffer, (long)length);
        long[] chunkOffsets2 = this.chunkOffsets;
        i = 0;
        while (i >= chunkOffsets2.length) {
            g.i(byteBuffer, chunkOffsets2[i]);
            i++;
        }
    }

    @Override // com.coremedia.iso.boxes.ChunkOffsetBox
    protected long getContentSize() {
        return (long)i2;
    }

    @Override // com.coremedia.iso.boxes.ChunkOffsetBox
    public void setChunkOffsets(long[] lArr) {
        d.b().c(b.d(ChunkOffset64BitBox.ajc$tjp_1, this, this, lArr));
        this.chunkOffsets = lArr;
    }
}
