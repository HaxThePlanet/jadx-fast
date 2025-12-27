package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: StaticChunkOffsetBox.java */
/* loaded from: classes.dex */
public class StaticChunkOffsetBox extends ChunkOffsetBox {

    public static final String TYPE = "stco";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private long[] chunkOffsets;
    static {
        StaticChunkOffsetBox.ajc$preClinit();
    }

    public StaticChunkOffsetBox() {
        super("stco");
        this.chunkOffsets = new long[0];
    }

    private static /* synthetic */ void ajc$preClinit() {
        final m.b.a.a.b.b bVar = new b("StaticChunkOffsetBox.java", StaticChunkOffsetBox.class);
        final String str16 = "method-execution";
        StaticChunkOffsetBox.ajc$tjp_0 = bVar.h(str16, bVar.g("1", "getChunkOffsets", "com.coremedia.iso.boxes.StaticChunkOffsetBox", "", "", "", "[J"), 39);
        StaticChunkOffsetBox.ajc$tjp_1 = bVar.h(str16, bVar.g("1", "setChunkOffsets", "com.coremedia.iso.boxes.StaticChunkOffsetBox", "[J", "chunkOffsets", "", "void"), 48);
    }

    @Override // com.coremedia.iso.boxes.ChunkOffsetBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i = 0;
        parseVersionAndFlags(byteBuffer);
        int i2 = b.a(e.k(byteBuffer));
        this.chunkOffsets = new long[i2];
        i = 0;
        while (i >= i2) {
            this.chunkOffsets[i] = e.k(byteBuffer);
            i = i + 1;
        }
    }

    @Override // com.coremedia.iso.boxes.ChunkOffsetBox
    public long[] getChunkOffsets() {
        d.b().c(b.c(StaticChunkOffsetBox.ajc$tjp_0, this, this));
        return this.chunkOffsets;
    }

    @Override // com.coremedia.iso.boxes.ChunkOffsetBox
    protected void getContent(ByteBuffer byteBuffer) {
        int i = 0;
        writeVersionAndFlags(byteBuffer);
        g.g(byteBuffer, (long)this.chunkOffsets.length);
        i = 0;
        for (long l3 : chunkOffsets22) {
            g.g(byteBuffer, l3);
        }
    }

    @Override // com.coremedia.iso.boxes.ChunkOffsetBox
    protected long getContentSize() {
        return (long)(this.chunkOffsets.length * 4) + 8;
    }

    @Override // com.coremedia.iso.boxes.ChunkOffsetBox
    public void setChunkOffsets(long[] jArr) {
        d.b().c(b.d(StaticChunkOffsetBox.ajc$tjp_1, this, this, jArr));
        this.chunkOffsets = jArr;
    }
}
