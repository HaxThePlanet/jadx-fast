package com.googlecode.mp4parser.boxes.apple;

import com.googlecode.mp4parser.d;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public class AppleDiskNumberBox extends com.googlecode.mp4parser.boxes.apple.AppleDataBox {

    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    int a;
    short b;
    static {
        AppleDiskNumberBox.ajc$preClinit();
    }

    public AppleDiskNumberBox() {
        super("disk", 0);
    }

    private static void ajc$preClinit() {
        b bVar5 = new b("AppleDiskNumberBox.java", AppleDiskNumberBox.class);
        final String str30 = "method-execution";
        AppleDiskNumberBox.ajc$tjp_0 = bVar5.h(str30, bVar5.g("1", "getA", "com.googlecode.mp4parser.boxes.apple.AppleDiskNumberBox", "", "", "", "int"), 16);
        AppleDiskNumberBox.ajc$tjp_1 = bVar5.h(str30, bVar5.g("1", "setA", "com.googlecode.mp4parser.boxes.apple.AppleDiskNumberBox", "int", "a", "", "void"), 20);
        AppleDiskNumberBox.ajc$tjp_2 = bVar5.h(str30, bVar5.g("1", "getB", "com.googlecode.mp4parser.boxes.apple.AppleDiskNumberBox", "", "", "", "short"), 24);
        AppleDiskNumberBox.ajc$tjp_3 = bVar5.h(str30, bVar5.g("1", "setB", "com.googlecode.mp4parser.boxes.apple.AppleDiskNumberBox", "short", "b", "", "void"), 28);
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    public int getA() {
        d.b().c(b.c(AppleDiskNumberBox.ajc$tjp_0, this, this));
        return this.a;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    public short getB() {
        d.b().c(b.c(AppleDiskNumberBox.ajc$tjp_2, this, this));
        return this.b;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    protected int getDataLength() {
        return 6;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    protected void parseData(ByteBuffer byteBuffer) {
        this.a = byteBuffer.getInt();
        this.b = byteBuffer.getShort();
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    public void setA(int i) {
        d.b().c(b.d(AppleDiskNumberBox.ajc$tjp_1, this, this, a.e(i)));
        this.a = i;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    public void setB(short s) {
        d.b().c(b.d(AppleDiskNumberBox.ajc$tjp_3, this, this, a.g(s)));
        this.b = s;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    protected byte[] writeData() {
        ByteBuffer allocate = ByteBuffer.allocate(6);
        allocate.putInt(this.a);
        allocate.putShort(this.b);
        return allocate.array();
    }
}
