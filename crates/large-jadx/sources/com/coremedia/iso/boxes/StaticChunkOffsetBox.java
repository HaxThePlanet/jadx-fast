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
public class StaticChunkOffsetBox extends com.coremedia.iso.boxes.ChunkOffsetBox {

    public static final String TYPE = "stco";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private long[] chunkOffsets;
    static {
        StaticChunkOffsetBox.ajc$preClinit();
    }

    public StaticChunkOffsetBox() {
        super("stco");
        this.chunkOffsets = new long[0];
    }

    private static void ajc$preClinit() {
        b bVar3 = new b("StaticChunkOffsetBox.java", StaticChunkOffsetBox.class);
        final String str16 = "method-execution";
        StaticChunkOffsetBox.ajc$tjp_0 = bVar3.h(str16, bVar3.g("1", "getChunkOffsets", "com.coremedia.iso.boxes.StaticChunkOffsetBox", "", "", "", "[J"), 39);
        StaticChunkOffsetBox.ajc$tjp_1 = bVar3.h(str16, bVar3.g("1", "setChunkOffsets", "com.coremedia.iso.boxes.StaticChunkOffsetBox", "[J", "chunkOffsets", "", "void"), 48);
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
            this.chunkOffsets[i] = e.k(byteBuffer);
            i++;
        }
    }

    @Override // com.coremedia.iso.boxes.ChunkOffsetBox
    public long[] getChunkOffsets() {
        d.b().c(b.c(StaticChunkOffsetBox.ajc$tjp_0, this, this));
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
            g.g(byteBuffer, chunkOffsets2[i]);
            i++;
        }
    }

    @Override // com.coremedia.iso.boxes.ChunkOffsetBox
    protected long getContentSize() {
        return (long)i2;
    }

    @Override // com.coremedia.iso.boxes.ChunkOffsetBox
    public void setChunkOffsets(long[] lArr) {
        d.b().c(b.d(StaticChunkOffsetBox.ajc$tjp_1, this, this, lArr));
        this.chunkOffsets = lArr;
    }
}
