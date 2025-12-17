package com.googlecode.mp4parser.boxes.apple;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public class TrackEncodedPixelsDimensionsAtom extends AbstractFullBox {

    public static final String TYPE = "enof";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    double height;
    double width;
    static {
        TrackEncodedPixelsDimensionsAtom.ajc$preClinit();
    }

    public TrackEncodedPixelsDimensionsAtom() {
        super("enof");
    }

    private static void ajc$preClinit() {
        b bVar5 = new b("TrackEncodedPixelsDimensionsAtom.java", TrackEncodedPixelsDimensionsAtom.class);
        final String str30 = "method-execution";
        TrackEncodedPixelsDimensionsAtom.ajc$tjp_0 = bVar5.h(str30, bVar5.g("1", "getWidth", "com.googlecode.mp4parser.boxes.apple.TrackEncodedPixelsDimensionsAtom", "", "", "", "double"), 44);
        TrackEncodedPixelsDimensionsAtom.ajc$tjp_1 = bVar5.h(str30, bVar5.g("1", "setWidth", "com.googlecode.mp4parser.boxes.apple.TrackEncodedPixelsDimensionsAtom", "double", "width", "", "void"), 48);
        TrackEncodedPixelsDimensionsAtom.ajc$tjp_2 = bVar5.h(str30, bVar5.g("1", "getHeight", "com.googlecode.mp4parser.boxes.apple.TrackEncodedPixelsDimensionsAtom", "", "", "", "double"), 52);
        TrackEncodedPixelsDimensionsAtom.ajc$tjp_3 = bVar5.h(str30, bVar5.g("1", "setHeight", "com.googlecode.mp4parser.boxes.apple.TrackEncodedPixelsDimensionsAtom", "double", "height", "", "void"), 56);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.width = e.d(byteBuffer);
        this.height = e.d(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        g.b(byteBuffer, this.width);
        g.b(byteBuffer, this.height);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return 12;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public double getHeight() {
        d.b().c(b.c(TrackEncodedPixelsDimensionsAtom.ajc$tjp_2, this, this));
        return this.height;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public double getWidth() {
        d.b().c(b.c(TrackEncodedPixelsDimensionsAtom.ajc$tjp_0, this, this));
        return this.width;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setHeight(double d) {
        d.b().c(b.d(TrackEncodedPixelsDimensionsAtom.ajc$tjp_3, this, this, a.c(d)));
        this.height = d;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setWidth(double d) {
        d.b().c(b.d(TrackEncodedPixelsDimensionsAtom.ajc$tjp_1, this, this, a.c(d)));
        this.width = d;
    }
}
