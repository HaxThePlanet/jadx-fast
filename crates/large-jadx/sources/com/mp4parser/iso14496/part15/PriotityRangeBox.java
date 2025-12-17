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
public class PriotityRangeBox extends AbstractBox {

    public static final String TYPE = "svpr";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    private static final a.a ajc$tjp_6;
    private static final a.a ajc$tjp_7;
    int max_priorityId;
    int min_priorityId;
    int reserved1 = 0;
    int reserved2 = 0;
    static {
        PriotityRangeBox.ajc$preClinit();
    }

    public PriotityRangeBox() {
        super("svpr");
        int i = 0;
    }

    private static void ajc$preClinit() {
        b bVar9 = new b("PriotityRangeBox.java", PriotityRangeBox.class);
        final String str58 = "method-execution";
        PriotityRangeBox.ajc$tjp_0 = bVar9.h(str58, bVar9.g("1", "getReserved1", "com.mp4parser.iso14496.part15.PriotityRangeBox", "", "", "", "int"), 45);
        PriotityRangeBox.ajc$tjp_1 = bVar9.h(str58, bVar9.g("1", "setReserved1", "com.mp4parser.iso14496.part15.PriotityRangeBox", "int", "reserved1", "", "void"), 49);
        PriotityRangeBox.ajc$tjp_2 = bVar9.h(str58, bVar9.g("1", "getMin_priorityId", "com.mp4parser.iso14496.part15.PriotityRangeBox", "", "", "", "int"), 53);
        PriotityRangeBox.ajc$tjp_3 = bVar9.h(str58, bVar9.g("1", "setMin_priorityId", "com.mp4parser.iso14496.part15.PriotityRangeBox", "int", "min_priorityId", "", "void"), 57);
        PriotityRangeBox.ajc$tjp_4 = bVar9.h(str58, bVar9.g("1", "getReserved2", "com.mp4parser.iso14496.part15.PriotityRangeBox", "", "", "", "int"), 61);
        PriotityRangeBox.ajc$tjp_5 = bVar9.h(str58, bVar9.g("1", "setReserved2", "com.mp4parser.iso14496.part15.PriotityRangeBox", "int", "reserved2", "", "void"), 65);
        PriotityRangeBox.ajc$tjp_6 = bVar9.h(str58, bVar9.g("1", "getMax_priorityId", "com.mp4parser.iso14496.part15.PriotityRangeBox", "", "", "", "int"), 69);
        PriotityRangeBox.ajc$tjp_7 = bVar9.h(str58, bVar9.g("1", "setMax_priorityId", "com.mp4parser.iso14496.part15.PriotityRangeBox", "int", "max_priorityId", "", "void"), 73);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        int i = e.n(byteBuffer);
        this.min_priorityId = i;
        this.reserved1 = i5 >>= 6;
        this.min_priorityId = i &= 63;
        int obj3 = e.n(byteBuffer);
        this.max_priorityId = obj3;
        this.reserved2 = i3 >>= 6;
        this.max_priorityId = obj3 &= 63;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        g.j(byteBuffer, i += min_priorityId);
        g.j(byteBuffer, i3 += max_priorityId);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 2;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getMax_priorityId() {
        d.b().c(b.c(PriotityRangeBox.ajc$tjp_6, this, this));
        return this.max_priorityId;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getMin_priorityId() {
        d.b().c(b.c(PriotityRangeBox.ajc$tjp_2, this, this));
        return this.min_priorityId;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getReserved1() {
        d.b().c(b.c(PriotityRangeBox.ajc$tjp_0, this, this));
        return this.reserved1;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getReserved2() {
        d.b().c(b.c(PriotityRangeBox.ajc$tjp_4, this, this));
        return this.reserved2;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setMax_priorityId(int i) {
        d.b().c(b.d(PriotityRangeBox.ajc$tjp_7, this, this, a.e(i)));
        this.max_priorityId = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setMin_priorityId(int i) {
        d.b().c(b.d(PriotityRangeBox.ajc$tjp_3, this, this, a.e(i)));
        this.min_priorityId = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setReserved1(int i) {
        d.b().c(b.d(PriotityRangeBox.ajc$tjp_1, this, this, a.e(i)));
        this.reserved1 = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setReserved2(int i) {
        d.b().c(b.d(PriotityRangeBox.ajc$tjp_5, this, this, a.e(i)));
        this.reserved2 = i;
    }
}
