package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class HintMediaHeaderBox extends com.coremedia.iso.boxes.AbstractMediaHeaderBox {

    public static final String TYPE = "hmhd";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private long avgBitrate;
    private int avgPduSize;
    private long maxBitrate;
    private int maxPduSize;
    static {
        HintMediaHeaderBox.ajc$preClinit();
    }

    public HintMediaHeaderBox() {
        super("hmhd");
    }

    private static void ajc$preClinit() {
        b bVar6 = new b("HintMediaHeaderBox.java", HintMediaHeaderBox.class);
        final String str37 = "method-execution";
        HintMediaHeaderBox.ajc$tjp_0 = bVar6.h(str37, bVar6.g("1", "getMaxPduSize", "com.coremedia.iso.boxes.HintMediaHeaderBox", "", "", "", "int"), 42);
        HintMediaHeaderBox.ajc$tjp_1 = bVar6.h(str37, bVar6.g("1", "getAvgPduSize", "com.coremedia.iso.boxes.HintMediaHeaderBox", "", "", "", "int"), 46);
        HintMediaHeaderBox.ajc$tjp_2 = bVar6.h(str37, bVar6.g("1", "getMaxBitrate", "com.coremedia.iso.boxes.HintMediaHeaderBox", "", "", "", "long"), 50);
        HintMediaHeaderBox.ajc$tjp_3 = bVar6.h(str37, bVar6.g("1", "getAvgBitrate", "com.coremedia.iso.boxes.HintMediaHeaderBox", "", "", "", "long"), 54);
        HintMediaHeaderBox.ajc$tjp_4 = bVar6.h(str37, bVar6.g("1", "toString", "com.coremedia.iso.boxes.HintMediaHeaderBox", "", "", "", "java.lang.String"), 84);
    }

    @Override // com.coremedia.iso.boxes.AbstractMediaHeaderBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.maxPduSize = e.i(byteBuffer);
        this.avgPduSize = e.i(byteBuffer);
        this.maxBitrate = e.k(byteBuffer);
        this.avgBitrate = e.k(byteBuffer);
        e.k(byteBuffer);
    }

    @Override // com.coremedia.iso.boxes.AbstractMediaHeaderBox
    public long getAvgBitrate() {
        d.b().c(b.c(HintMediaHeaderBox.ajc$tjp_3, this, this));
        return this.avgBitrate;
    }

    @Override // com.coremedia.iso.boxes.AbstractMediaHeaderBox
    public int getAvgPduSize() {
        d.b().c(b.c(HintMediaHeaderBox.ajc$tjp_1, this, this));
        return this.avgPduSize;
    }

    @Override // com.coremedia.iso.boxes.AbstractMediaHeaderBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        g.e(byteBuffer, this.maxPduSize);
        g.e(byteBuffer, this.avgPduSize);
        g.g(byteBuffer, this.maxBitrate);
        g.g(byteBuffer, this.avgBitrate);
        g.g(byteBuffer, 0);
    }

    @Override // com.coremedia.iso.boxes.AbstractMediaHeaderBox
    protected long getContentSize() {
        return 20;
    }

    @Override // com.coremedia.iso.boxes.AbstractMediaHeaderBox
    public long getMaxBitrate() {
        d.b().c(b.c(HintMediaHeaderBox.ajc$tjp_2, this, this));
        return this.maxBitrate;
    }

    @Override // com.coremedia.iso.boxes.AbstractMediaHeaderBox
    public int getMaxPduSize() {
        d.b().c(b.c(HintMediaHeaderBox.ajc$tjp_0, this, this));
        return this.maxPduSize;
    }

    @Override // com.coremedia.iso.boxes.AbstractMediaHeaderBox
    public String toString() {
        d.b().c(b.c(HintMediaHeaderBox.ajc$tjp_4, this, this));
        StringBuilder stringBuilder = new StringBuilder("HintMediaHeaderBox{maxPduSize=");
        stringBuilder.append(this.maxPduSize);
        stringBuilder.append(", avgPduSize=");
        stringBuilder.append(this.avgPduSize);
        stringBuilder.append(", maxBitrate=");
        stringBuilder.append(this.maxBitrate);
        stringBuilder.append(", avgBitrate=");
        stringBuilder.append(this.avgBitrate);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
