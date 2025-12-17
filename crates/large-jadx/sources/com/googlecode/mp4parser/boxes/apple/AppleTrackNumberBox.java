package com.googlecode.mp4parser.boxes.apple;

import com.googlecode.mp4parser.d;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public class AppleTrackNumberBox extends com.googlecode.mp4parser.boxes.apple.AppleDataBox {

    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    int a;
    int b;
    static {
        AppleTrackNumberBox.ajc$preClinit();
    }

    public AppleTrackNumberBox() {
        super("trkn", 0);
    }

    private static void ajc$preClinit() {
        b bVar5 = new b("AppleTrackNumberBox.java", AppleTrackNumberBox.class);
        final String str30 = "method-execution";
        AppleTrackNumberBox.ajc$tjp_0 = bVar5.h(str30, bVar5.g("1", "getA", "com.googlecode.mp4parser.boxes.apple.AppleTrackNumberBox", "", "", "", "int"), 16);
        AppleTrackNumberBox.ajc$tjp_1 = bVar5.h(str30, bVar5.g("1", "setA", "com.googlecode.mp4parser.boxes.apple.AppleTrackNumberBox", "int", "a", "", "void"), 20);
        AppleTrackNumberBox.ajc$tjp_2 = bVar5.h(str30, bVar5.g("1", "getB", "com.googlecode.mp4parser.boxes.apple.AppleTrackNumberBox", "", "", "", "int"), 24);
        AppleTrackNumberBox.ajc$tjp_3 = bVar5.h(str30, bVar5.g("1", "setB", "com.googlecode.mp4parser.boxes.apple.AppleTrackNumberBox", "int", "b", "", "void"), 28);
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    public int getA() {
        d.b().c(b.c(AppleTrackNumberBox.ajc$tjp_0, this, this));
        return this.a;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    public int getB() {
        d.b().c(b.c(AppleTrackNumberBox.ajc$tjp_2, this, this));
        return this.b;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    protected int getDataLength() {
        return 8;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    protected void parseData(ByteBuffer byteBuffer) {
        this.a = byteBuffer.getInt();
        this.b = byteBuffer.getInt();
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    public void setA(int i) {
        d.b().c(b.d(AppleTrackNumberBox.ajc$tjp_1, this, this, a.e(i)));
        this.a = i;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    public void setB(int i) {
        d.b().c(b.d(AppleTrackNumberBox.ajc$tjp_3, this, this, a.e(i)));
        this.b = i;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    protected byte[] writeData() {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.putInt(this.a);
        allocate.putInt(this.b);
        return allocate.array();
    }
}
