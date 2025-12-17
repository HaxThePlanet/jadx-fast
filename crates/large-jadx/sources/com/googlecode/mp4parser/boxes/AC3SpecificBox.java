package com.googlecode.mp4parser.boxes;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.boxes.mp4.a.c;
import com.googlecode.mp4parser.boxes.mp4.a.d;
import com.googlecode.mp4parser.d;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public class AC3SpecificBox extends AbstractBox {

    public static final String TYPE = "dac3";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_10;
    private static final a.a ajc$tjp_11;
    private static final a.a ajc$tjp_12;
    private static final a.a ajc$tjp_13;
    private static final a.a ajc$tjp_14;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    private static final a.a ajc$tjp_6;
    private static final a.a ajc$tjp_7;
    private static final a.a ajc$tjp_8;
    private static final a.a ajc$tjp_9;
    int acmod;
    int bitRateCode;
    int bsid;
    int bsmod;
    int fscod;
    int lfeon;
    int reserved;
    static {
        AC3SpecificBox.ajc$preClinit();
    }

    public AC3SpecificBox() {
        super("dac3");
    }

    private static void ajc$preClinit() {
        b bVar16 = new b("AC3SpecificBox.java", AC3SpecificBox.class);
        final String str107 = "method-execution";
        AC3SpecificBox.ajc$tjp_0 = bVar16.h(str107, bVar16.g("1", "getFscod", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "", "", "", "int"), 55);
        AC3SpecificBox.ajc$tjp_1 = bVar16.h(str107, bVar16.g("1", "setFscod", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "int", "fscod", "", "void"), 59);
        AC3SpecificBox.ajc$tjp_10 = bVar16.h(str107, bVar16.g("1", "getBitRateCode", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "", "", "", "int"), 95);
        AC3SpecificBox.ajc$tjp_11 = bVar16.h(str107, bVar16.g("1", "setBitRateCode", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "int", "bitRateCode", "", "void"), 99);
        AC3SpecificBox.ajc$tjp_12 = bVar16.h(str107, bVar16.g("1", "getReserved", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "", "", "", "int"), 103);
        AC3SpecificBox.ajc$tjp_13 = bVar16.h(str107, bVar16.g("1", "setReserved", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "int", "reserved", "", "void"), 107);
        AC3SpecificBox.ajc$tjp_14 = bVar16.h(str107, bVar16.g("1", "toString", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "", "", "", "java.lang.String"), 112);
        AC3SpecificBox.ajc$tjp_2 = bVar16.h(str107, bVar16.g("1", "getBsid", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "", "", "", "int"), 63);
        AC3SpecificBox.ajc$tjp_3 = bVar16.h(str107, bVar16.g("1", "setBsid", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "int", "bsid", "", "void"), 67);
        AC3SpecificBox.ajc$tjp_4 = bVar16.h(str107, bVar16.g("1", "getBsmod", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "", "", "", "int"), 71);
        AC3SpecificBox.ajc$tjp_5 = bVar16.h(str107, bVar16.g("1", "setBsmod", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "int", "bsmod", "", "void"), 75);
        AC3SpecificBox.ajc$tjp_6 = bVar16.h(str107, bVar16.g("1", "getAcmod", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "", "", "", "int"), 79);
        AC3SpecificBox.ajc$tjp_7 = bVar16.h(str107, bVar16.g("1", "setAcmod", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "int", "acmod", "", "void"), 83);
        AC3SpecificBox.ajc$tjp_8 = bVar16.h(str107, bVar16.g("1", "getLfeon", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "", "", "", "int"), 87);
        AC3SpecificBox.ajc$tjp_9 = bVar16.h(str107, bVar16.g("1", "setLfeon", "com.googlecode.mp4parser.boxes.AC3SpecificBox", "int", "lfeon", "", "void"), 91);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        c cVar = new c(byteBuffer);
        this.fscod = cVar.a(2);
        int obj4 = 5;
        this.bsid = cVar.a(obj4);
        int i2 = 3;
        this.bsmod = cVar.a(i2);
        this.acmod = cVar.a(i2);
        this.lfeon = cVar.a(1);
        this.bitRateCode = cVar.a(obj4);
        this.reserved = cVar.a(obj4);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getAcmod() {
        d.b().c(b.c(AC3SpecificBox.ajc$tjp_6, this, this));
        return this.acmod;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getBitRateCode() {
        d.b().c(b.c(AC3SpecificBox.ajc$tjp_10, this, this));
        return this.bitRateCode;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getBsid() {
        d.b().c(b.c(AC3SpecificBox.ajc$tjp_2, this, this));
        return this.bsid;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getBsmod() {
        d.b().c(b.c(AC3SpecificBox.ajc$tjp_4, this, this));
        return this.bsmod;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        d dVar = new d(byteBuffer);
        dVar.a(this.fscod, 2);
        int i2 = 5;
        dVar.a(this.bsid, i2);
        int i3 = 3;
        dVar.a(this.bsmod, i3);
        dVar.a(this.acmod, i3);
        dVar.a(this.lfeon, 1);
        dVar.a(this.bitRateCode, i2);
        dVar.a(this.reserved, i2);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 3;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getFscod() {
        d.b().c(b.c(AC3SpecificBox.ajc$tjp_0, this, this));
        return this.fscod;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getLfeon() {
        d.b().c(b.c(AC3SpecificBox.ajc$tjp_8, this, this));
        return this.lfeon;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getReserved() {
        d.b().c(b.c(AC3SpecificBox.ajc$tjp_12, this, this));
        return this.reserved;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setAcmod(int i) {
        d.b().c(b.d(AC3SpecificBox.ajc$tjp_7, this, this, a.e(i)));
        this.acmod = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setBitRateCode(int i) {
        d.b().c(b.d(AC3SpecificBox.ajc$tjp_11, this, this, a.e(i)));
        this.bitRateCode = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setBsid(int i) {
        d.b().c(b.d(AC3SpecificBox.ajc$tjp_3, this, this, a.e(i)));
        this.bsid = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setBsmod(int i) {
        d.b().c(b.d(AC3SpecificBox.ajc$tjp_5, this, this, a.e(i)));
        this.bsmod = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setFscod(int i) {
        d.b().c(b.d(AC3SpecificBox.ajc$tjp_1, this, this, a.e(i)));
        this.fscod = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setLfeon(int i) {
        d.b().c(b.d(AC3SpecificBox.ajc$tjp_9, this, this, a.e(i)));
        this.lfeon = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setReserved(int i) {
        d.b().c(b.d(AC3SpecificBox.ajc$tjp_13, this, this, a.e(i)));
        this.reserved = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public String toString() {
        d.b().c(b.c(AC3SpecificBox.ajc$tjp_14, this, this));
        StringBuilder stringBuilder = new StringBuilder("AC3SpecificBox{fscod=");
        stringBuilder.append(this.fscod);
        stringBuilder.append(", bsid=");
        stringBuilder.append(this.bsid);
        stringBuilder.append(", bsmod=");
        stringBuilder.append(this.bsmod);
        stringBuilder.append(", acmod=");
        stringBuilder.append(this.acmod);
        stringBuilder.append(", lfeon=");
        stringBuilder.append(this.lfeon);
        stringBuilder.append(", bitRateCode=");
        stringBuilder.append(this.bitRateCode);
        stringBuilder.append(", reserved=");
        stringBuilder.append(this.reserved);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
