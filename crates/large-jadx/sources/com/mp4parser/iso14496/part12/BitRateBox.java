package com.mp4parser.iso14496.part12;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: BitRateBox.java */
/* loaded from: classes2.dex */
public final class BitRateBox extends AbstractBox {

    public static final String TYPE = "btrt";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    private static final /* synthetic */ a.a ajc$tjp_4;
    private static final /* synthetic */ a.a ajc$tjp_5;
    private long avgBitrate;
    private long bufferSizeDb;
    private long maxBitrate;
    static {
        BitRateBox.ajc$preClinit();
    }

    public BitRateBox() {
        super("btrt");
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("BitRateBox.java", BitRateBox.class);
        final String str44 = "method-execution";
        BitRateBox.ajc$tjp_0 = bVar.h(str44, bVar.g("1", "getBufferSizeDb", "com.mp4parser.iso14496.part12.BitRateBox", "", "", "", "long"), 74);
        BitRateBox.ajc$tjp_1 = bVar.h(str44, bVar.g("1", "setBufferSizeDb", "com.mp4parser.iso14496.part12.BitRateBox", "long", "bufferSizeDb", "", "void"), 82);
        BitRateBox.ajc$tjp_2 = bVar.h(str44, bVar.g("1", "getMaxBitrate", "com.mp4parser.iso14496.part12.BitRateBox", "", "", "", "long"), 90);
        BitRateBox.ajc$tjp_3 = bVar.h(str44, bVar.g("1", "setMaxBitrate", "com.mp4parser.iso14496.part12.BitRateBox", "long", "maxBitrate", "", "void"), 98);
        BitRateBox.ajc$tjp_4 = bVar.h(str44, bVar.g("1", "getAvgBitrate", "com.mp4parser.iso14496.part12.BitRateBox", "", "", "", "long"), 106);
        BitRateBox.ajc$tjp_5 = bVar.h(str44, bVar.g("1", "setAvgBitrate", "com.mp4parser.iso14496.part12.BitRateBox", "long", "avgBitrate", "", "void"), 114);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        this.bufferSizeDb = e.k(byteBuffer);
        this.maxBitrate = e.k(byteBuffer);
        this.avgBitrate = e.k(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getAvgBitrate() {
        d.b().c(b.c(BitRateBox.ajc$tjp_4, this, this));
        return this.avgBitrate;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getBufferSizeDb() {
        d.b().c(b.c(BitRateBox.ajc$tjp_0, this, this));
        return this.bufferSizeDb;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        g.g(byteBuffer, this.bufferSizeDb);
        g.g(byteBuffer, this.maxBitrate);
        g.g(byteBuffer, this.avgBitrate);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getMaxBitrate() {
        d.b().c(b.c(BitRateBox.ajc$tjp_2, this, this));
        return this.maxBitrate;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setAvgBitrate(long j) {
        d.b().c(b.d(BitRateBox.ajc$tjp_5, this, this, a.f(j)));
        this.avgBitrate = j;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setBufferSizeDb(long j) {
        d.b().c(b.d(BitRateBox.ajc$tjp_1, this, this, a.f(j)));
        this.bufferSizeDb = j;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setMaxBitrate(long j) {
        d.b().c(b.d(BitRateBox.ajc$tjp_3, this, this, a.f(j)));
        this.maxBitrate = j;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 12;
    }
}
