package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class CompositionShiftLeastGreatestAtom extends AbstractFullBox {

    public static final String TYPE = "cslg";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    private static final a.a ajc$tjp_6;
    private static final a.a ajc$tjp_7;
    private static final a.a ajc$tjp_8;
    private static final a.a ajc$tjp_9;
    int compositionOffsetToDisplayOffsetShift;
    int displayEndTime;
    int displayStartTime;
    int greatestDisplayOffset;
    int leastDisplayOffset;
    static {
        CompositionShiftLeastGreatestAtom.ajc$preClinit();
    }

    public CompositionShiftLeastGreatestAtom() {
        super("cslg");
    }

    private static void ajc$preClinit() {
        b bVar11 = new b("CompositionShiftLeastGreatestAtom.java", CompositionShiftLeastGreatestAtom.class);
        final String str72 = "method-execution";
        CompositionShiftLeastGreatestAtom.ajc$tjp_0 = bVar11.h(str72, bVar11.g("1", "getCompositionOffsetToDisplayOffsetShift", "com.coremedia.iso.boxes.CompositionShiftLeastGreatestAtom", "", "", "", "int"), 66);
        CompositionShiftLeastGreatestAtom.ajc$tjp_1 = bVar11.h(str72, bVar11.g("1", "setCompositionOffsetToDisplayOffsetShift", "com.coremedia.iso.boxes.CompositionShiftLeastGreatestAtom", "int", "compositionOffsetToDisplayOffsetShift", "", "void"), 70);
        CompositionShiftLeastGreatestAtom.ajc$tjp_2 = bVar11.h(str72, bVar11.g("1", "getLeastDisplayOffset", "com.coremedia.iso.boxes.CompositionShiftLeastGreatestAtom", "", "", "", "int"), 74);
        CompositionShiftLeastGreatestAtom.ajc$tjp_3 = bVar11.h(str72, bVar11.g("1", "setLeastDisplayOffset", "com.coremedia.iso.boxes.CompositionShiftLeastGreatestAtom", "int", "leastDisplayOffset", "", "void"), 78);
        CompositionShiftLeastGreatestAtom.ajc$tjp_4 = bVar11.h(str72, bVar11.g("1", "getGreatestDisplayOffset", "com.coremedia.iso.boxes.CompositionShiftLeastGreatestAtom", "", "", "", "int"), 82);
        CompositionShiftLeastGreatestAtom.ajc$tjp_5 = bVar11.h(str72, bVar11.g("1", "setGreatestDisplayOffset", "com.coremedia.iso.boxes.CompositionShiftLeastGreatestAtom", "int", "greatestDisplayOffset", "", "void"), 86);
        CompositionShiftLeastGreatestAtom.ajc$tjp_6 = bVar11.h(str72, bVar11.g("1", "getDisplayStartTime", "com.coremedia.iso.boxes.CompositionShiftLeastGreatestAtom", "", "", "", "int"), 90);
        CompositionShiftLeastGreatestAtom.ajc$tjp_7 = bVar11.h(str72, bVar11.g("1", "setDisplayStartTime", "com.coremedia.iso.boxes.CompositionShiftLeastGreatestAtom", "int", "displayStartTime", "", "void"), 94);
        CompositionShiftLeastGreatestAtom.ajc$tjp_8 = bVar11.h(str72, bVar11.g("1", "getDisplayEndTime", "com.coremedia.iso.boxes.CompositionShiftLeastGreatestAtom", "", "", "", "int"), 98);
        CompositionShiftLeastGreatestAtom.ajc$tjp_9 = bVar11.h(str72, bVar11.g("1", "setDisplayEndTime", "com.coremedia.iso.boxes.CompositionShiftLeastGreatestAtom", "int", "displayEndTime", "", "void"), 102);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.compositionOffsetToDisplayOffsetShift = byteBuffer.getInt();
        this.leastDisplayOffset = byteBuffer.getInt();
        this.greatestDisplayOffset = byteBuffer.getInt();
        this.displayStartTime = byteBuffer.getInt();
        this.displayEndTime = byteBuffer.getInt();
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getCompositionOffsetToDisplayOffsetShift() {
        d.b().c(b.c(CompositionShiftLeastGreatestAtom.ajc$tjp_0, this, this));
        return this.compositionOffsetToDisplayOffsetShift;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.putInt(this.compositionOffsetToDisplayOffsetShift);
        byteBuffer.putInt(this.leastDisplayOffset);
        byteBuffer.putInt(this.greatestDisplayOffset);
        byteBuffer.putInt(this.displayStartTime);
        byteBuffer.putInt(this.displayEndTime);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return 24;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getDisplayEndTime() {
        d.b().c(b.c(CompositionShiftLeastGreatestAtom.ajc$tjp_8, this, this));
        return this.displayEndTime;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getDisplayStartTime() {
        d.b().c(b.c(CompositionShiftLeastGreatestAtom.ajc$tjp_6, this, this));
        return this.displayStartTime;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getGreatestDisplayOffset() {
        d.b().c(b.c(CompositionShiftLeastGreatestAtom.ajc$tjp_4, this, this));
        return this.greatestDisplayOffset;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getLeastDisplayOffset() {
        d.b().c(b.c(CompositionShiftLeastGreatestAtom.ajc$tjp_2, this, this));
        return this.leastDisplayOffset;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setCompositionOffsetToDisplayOffsetShift(int i) {
        d.b().c(b.d(CompositionShiftLeastGreatestAtom.ajc$tjp_1, this, this, a.e(i)));
        this.compositionOffsetToDisplayOffsetShift = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setDisplayEndTime(int i) {
        d.b().c(b.d(CompositionShiftLeastGreatestAtom.ajc$tjp_9, this, this, a.e(i)));
        this.displayEndTime = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setDisplayStartTime(int i) {
        d.b().c(b.d(CompositionShiftLeastGreatestAtom.ajc$tjp_7, this, this, a.e(i)));
        this.displayStartTime = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setGreatestDisplayOffset(int i) {
        d.b().c(b.d(CompositionShiftLeastGreatestAtom.ajc$tjp_5, this, this, a.e(i)));
        this.greatestDisplayOffset = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setLeastDisplayOffset(int i) {
        d.b().c(b.d(CompositionShiftLeastGreatestAtom.ajc$tjp_3, this, this, a.e(i)));
        this.leastDisplayOffset = i;
    }
}
