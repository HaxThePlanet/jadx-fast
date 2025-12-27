package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.d;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: FreeSpaceBox.java */
/* loaded from: classes.dex */
public class FreeSpaceBox extends AbstractBox {

    public static final String TYPE = "skip";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    byte[] data;
    static {
        FreeSpaceBox.ajc$preClinit();
    }

    public FreeSpaceBox() {
        super("skip");
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("FreeSpaceBox.java", FreeSpaceBox.class);
        final String str23 = "method-execution";
        FreeSpaceBox.ajc$tjp_0 = bVar.h(str23, bVar.g("1", "setData", "com.coremedia.iso.boxes.FreeSpaceBox", "[B", "data", "", "void"), 42);
        FreeSpaceBox.ajc$tjp_1 = bVar.h(str23, bVar.g("1", "getData", "com.coremedia.iso.boxes.FreeSpaceBox", "", "", "", "[B"), 46);
        FreeSpaceBox.ajc$tjp_2 = bVar.h(str23, bVar.g("1", "toString", "com.coremedia.iso.boxes.FreeSpaceBox", "", "", "", "java.lang.String"), 61);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.remaining()];
        this.data = bArr;
        byteBuffer.get(bArr);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        byteBuffer.put(this.data);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return (long)this.data.length;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public byte[] getData() {
        d.b().c(b.c(FreeSpaceBox.ajc$tjp_1, this, this));
        return this.data;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setData(byte[] bArr) {
        d.b().c(b.d(FreeSpaceBox.ajc$tjp_0, this, this, bArr));
        this.data = bArr;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public String toString() {
        d.b().c(b.c(FreeSpaceBox.ajc$tjp_2, this, this));
        String str2 = "FreeSpaceBox[size=";
        StringBuilder stringBuilder = new StringBuilder(str2);
        int length = this.data.length;
        String str3 = ";type=";
        String type = getType();
        String str4 = "]";
        str = str2 + length + str3 + type + str4;
        return str;
    }
}
