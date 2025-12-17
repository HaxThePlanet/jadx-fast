package com.googlecode.mp4parser.boxes.apple;

import com.googlecode.mp4parser.d;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public class AppleCoverBox extends com.googlecode.mp4parser.boxes.apple.AppleDataBox {

    private static final int IMAGE_TYPE_JPG = 13;
    private static final int IMAGE_TYPE_PNG = 14;
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private byte[] data;
    static {
        AppleCoverBox.ajc$preClinit();
    }

    public AppleCoverBox() {
        super("covr", 1);
    }

    private static void ajc$preClinit() {
        b bVar4 = new b("AppleCoverBox.java", AppleCoverBox.class);
        final String str23 = "method-execution";
        AppleCoverBox.ajc$tjp_0 = bVar4.h(str23, bVar4.g("1", "getCoverData", "com.googlecode.mp4parser.boxes.apple.AppleCoverBox", "", "", "", "[B"), 21);
        AppleCoverBox.ajc$tjp_1 = bVar4.h(str23, bVar4.g("1", "setJpg", "com.googlecode.mp4parser.boxes.apple.AppleCoverBox", "[B", "data", "", "void"), 25);
        AppleCoverBox.ajc$tjp_2 = bVar4.h(str23, bVar4.g("1", "setPng", "com.googlecode.mp4parser.boxes.apple.AppleCoverBox", "[B", "data", "", "void"), 29);
    }

    private void setImageData(byte[] bArr, int i2) {
        this.data = bArr;
        this.dataType = i2;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    public byte[] getCoverData() {
        d.b().c(b.c(AppleCoverBox.ajc$tjp_0, this, this));
        return this.data;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    protected int getDataLength() {
        return data.length;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    protected void parseData(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.limit()];
        this.data = bArr;
        byteBuffer.get(bArr);
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    public void setJpg(byte[] bArr) {
        d.b().c(b.d(AppleCoverBox.ajc$tjp_1, this, this, bArr));
        setImageData(bArr, 13);
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    public void setPng(byte[] bArr) {
        d.b().c(b.d(AppleCoverBox.ajc$tjp_2, this, this, bArr));
        setImageData(bArr, 14);
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    protected byte[] writeData() {
        return this.data;
    }
}
