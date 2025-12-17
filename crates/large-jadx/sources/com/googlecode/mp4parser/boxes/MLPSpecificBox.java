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
public class MLPSpecificBox extends AbstractBox {

    public static final String TYPE = "dmlp";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    private static final a.a ajc$tjp_6;
    private static final a.a ajc$tjp_7;
    int format_info;
    int peak_data_rate;
    int reserved;
    int reserved2;
    static {
        MLPSpecificBox.ajc$preClinit();
    }

    public MLPSpecificBox() {
        super("dmlp");
    }

    private static void ajc$preClinit() {
        b bVar9 = new b("MLPSpecificBox.java", MLPSpecificBox.class);
        final String str58 = "method-execution";
        MLPSpecificBox.ajc$tjp_0 = bVar9.h(str58, bVar9.g("1", "getFormat_info", "com.googlecode.mp4parser.boxes.MLPSpecificBox", "", "", "", "int"), 49);
        MLPSpecificBox.ajc$tjp_1 = bVar9.h(str58, bVar9.g("1", "setFormat_info", "com.googlecode.mp4parser.boxes.MLPSpecificBox", "int", "format_info", "", "void"), 53);
        MLPSpecificBox.ajc$tjp_2 = bVar9.h(str58, bVar9.g("1", "getPeak_data_rate", "com.googlecode.mp4parser.boxes.MLPSpecificBox", "", "", "", "int"), 57);
        MLPSpecificBox.ajc$tjp_3 = bVar9.h(str58, bVar9.g("1", "setPeak_data_rate", "com.googlecode.mp4parser.boxes.MLPSpecificBox", "int", "peak_data_rate", "", "void"), 61);
        MLPSpecificBox.ajc$tjp_4 = bVar9.h(str58, bVar9.g("1", "getReserved", "com.googlecode.mp4parser.boxes.MLPSpecificBox", "", "", "", "int"), 65);
        MLPSpecificBox.ajc$tjp_5 = bVar9.h(str58, bVar9.g("1", "setReserved", "com.googlecode.mp4parser.boxes.MLPSpecificBox", "int", "reserved", "", "void"), 69);
        MLPSpecificBox.ajc$tjp_6 = bVar9.h(str58, bVar9.g("1", "getReserved2", "com.googlecode.mp4parser.boxes.MLPSpecificBox", "", "", "", "int"), 73);
        MLPSpecificBox.ajc$tjp_7 = bVar9.h(str58, bVar9.g("1", "setReserved2", "com.googlecode.mp4parser.boxes.MLPSpecificBox", "int", "reserved2", "", "void"), 77);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        c cVar = new c(byteBuffer);
        int obj3 = 32;
        this.format_info = cVar.a(obj3);
        this.peak_data_rate = cVar.a(15);
        this.reserved = cVar.a(1);
        this.reserved2 = cVar.a(obj3);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        d dVar = new d(byteBuffer);
        final int i = 32;
        dVar.a(this.format_info, i);
        dVar.a(this.peak_data_rate, 15);
        dVar.a(this.reserved, 1);
        dVar.a(this.reserved2, i);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 10;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getFormat_info() {
        d.b().c(b.c(MLPSpecificBox.ajc$tjp_0, this, this));
        return this.format_info;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getPeak_data_rate() {
        d.b().c(b.c(MLPSpecificBox.ajc$tjp_2, this, this));
        return this.peak_data_rate;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getReserved() {
        d.b().c(b.c(MLPSpecificBox.ajc$tjp_4, this, this));
        return this.reserved;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getReserved2() {
        d.b().c(b.c(MLPSpecificBox.ajc$tjp_6, this, this));
        return this.reserved2;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setFormat_info(int i) {
        d.b().c(b.d(MLPSpecificBox.ajc$tjp_1, this, this, a.e(i)));
        this.format_info = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setPeak_data_rate(int i) {
        d.b().c(b.d(MLPSpecificBox.ajc$tjp_3, this, this, a.e(i)));
        this.peak_data_rate = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setReserved(int i) {
        d.b().c(b.d(MLPSpecificBox.ajc$tjp_5, this, this, a.e(i)));
        this.reserved = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setReserved2(int i) {
        d.b().c(b.d(MLPSpecificBox.ajc$tjp_7, this, this, a.e(i)));
        this.reserved2 = i;
    }
}
