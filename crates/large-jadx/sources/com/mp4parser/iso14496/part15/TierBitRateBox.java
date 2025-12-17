package com.mp4parser.iso14496.part15;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public class TierBitRateBox extends AbstractBox {

    public static final String TYPE = "tibr";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_10;
    private static final a.a ajc$tjp_11;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    private static final a.a ajc$tjp_6;
    private static final a.a ajc$tjp_7;
    private static final a.a ajc$tjp_8;
    private static final a.a ajc$tjp_9;
    long avgBitRate;
    long baseBitRate;
    long maxBitRate;
    long tierAvgBitRate;
    long tierBaseBitRate;
    long tierMaxBitRate;
    static {
        TierBitRateBox.ajc$preClinit();
    }

    public TierBitRateBox() {
        super("tibr");
    }

    private static void ajc$preClinit() {
        b bVar13 = new b("TierBitRateBox.java", TierBitRateBox.class);
        final String str86 = "method-execution";
        TierBitRateBox.ajc$tjp_0 = bVar13.h(str86, bVar13.g("1", "getBaseBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", "", "", "", "long"), 52);
        TierBitRateBox.ajc$tjp_1 = bVar13.h(str86, bVar13.g("1", "setBaseBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", "long", "baseBitRate", "", "void"), 56);
        TierBitRateBox.ajc$tjp_10 = bVar13.h(str86, bVar13.g("1", "getTierAvgBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", "", "", "", "long"), 92);
        TierBitRateBox.ajc$tjp_11 = bVar13.h(str86, bVar13.g("1", "setTierAvgBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", "long", "tierAvgBitRate", "", "void"), 96);
        TierBitRateBox.ajc$tjp_2 = bVar13.h(str86, bVar13.g("1", "getMaxBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", "", "", "", "long"), 60);
        TierBitRateBox.ajc$tjp_3 = bVar13.h(str86, bVar13.g("1", "setMaxBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", "long", "maxBitRate", "", "void"), 64);
        TierBitRateBox.ajc$tjp_4 = bVar13.h(str86, bVar13.g("1", "getAvgBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", "", "", "", "long"), 68);
        TierBitRateBox.ajc$tjp_5 = bVar13.h(str86, bVar13.g("1", "setAvgBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", "long", "avgBitRate", "", "void"), 72);
        TierBitRateBox.ajc$tjp_6 = bVar13.h(str86, bVar13.g("1", "getTierBaseBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", "", "", "", "long"), 76);
        TierBitRateBox.ajc$tjp_7 = bVar13.h(str86, bVar13.g("1", "setTierBaseBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", "long", "tierBaseBitRate", "", "void"), 80);
        TierBitRateBox.ajc$tjp_8 = bVar13.h(str86, bVar13.g("1", "getTierMaxBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", "", "", "", "long"), 84);
        TierBitRateBox.ajc$tjp_9 = bVar13.h(str86, bVar13.g("1", "setTierMaxBitRate", "com.mp4parser.iso14496.part15.TierBitRateBox", "long", "tierMaxBitRate", "", "void"), 88);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        this.baseBitRate = e.k(byteBuffer);
        this.maxBitRate = e.k(byteBuffer);
        this.avgBitRate = e.k(byteBuffer);
        this.tierBaseBitRate = e.k(byteBuffer);
        this.tierMaxBitRate = e.k(byteBuffer);
        this.tierAvgBitRate = e.k(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getAvgBitRate() {
        d.b().c(b.c(TierBitRateBox.ajc$tjp_4, this, this));
        return this.avgBitRate;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getBaseBitRate() {
        d.b().c(b.c(TierBitRateBox.ajc$tjp_0, this, this));
        return this.baseBitRate;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        g.g(byteBuffer, this.baseBitRate);
        g.g(byteBuffer, this.maxBitRate);
        g.g(byteBuffer, this.avgBitRate);
        g.g(byteBuffer, this.tierBaseBitRate);
        g.g(byteBuffer, this.tierMaxBitRate);
        g.g(byteBuffer, this.tierAvgBitRate);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 24;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getMaxBitRate() {
        d.b().c(b.c(TierBitRateBox.ajc$tjp_2, this, this));
        return this.maxBitRate;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getTierAvgBitRate() {
        d.b().c(b.c(TierBitRateBox.ajc$tjp_10, this, this));
        return this.tierAvgBitRate;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getTierBaseBitRate() {
        d.b().c(b.c(TierBitRateBox.ajc$tjp_6, this, this));
        return this.tierBaseBitRate;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getTierMaxBitRate() {
        d.b().c(b.c(TierBitRateBox.ajc$tjp_8, this, this));
        return this.tierMaxBitRate;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setAvgBitRate(long l) {
        d.b().c(b.d(TierBitRateBox.ajc$tjp_5, this, this, a.f(l)));
        this.avgBitRate = l;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setBaseBitRate(long l) {
        d.b().c(b.d(TierBitRateBox.ajc$tjp_1, this, this, a.f(l)));
        this.baseBitRate = l;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setMaxBitRate(long l) {
        d.b().c(b.d(TierBitRateBox.ajc$tjp_3, this, this, a.f(l)));
        this.maxBitRate = l;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setTierAvgBitRate(long l) {
        d.b().c(b.d(TierBitRateBox.ajc$tjp_11, this, this, a.f(l)));
        this.tierAvgBitRate = l;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setTierBaseBitRate(long l) {
        d.b().c(b.d(TierBitRateBox.ajc$tjp_7, this, this, a.f(l)));
        this.tierBaseBitRate = l;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setTierMaxBitRate(long l) {
        d.b().c(b.d(TierBitRateBox.ajc$tjp_9, this, this, a.f(l)));
        this.tierMaxBitRate = l;
    }
}
