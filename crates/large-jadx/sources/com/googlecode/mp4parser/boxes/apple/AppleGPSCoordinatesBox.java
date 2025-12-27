package com.googlecode.mp4parser.boxes.apple;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.d;
import f.b.a.j;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: AppleGPSCoordinatesBox.java */
/* loaded from: classes2.dex */
public class AppleGPSCoordinatesBox extends AbstractBox {

    private static final int DEFAULT_LANG = 5575;
    public static final String TYPE = "©xyz";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    String coords;
    int lang = 5575;
    static {
        AppleGPSCoordinatesBox.ajc$preClinit();
    }

    public AppleGPSCoordinatesBox() {
        super("©xyz");
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("AppleGPSCoordinatesBox.java", AppleGPSCoordinatesBox.class);
        final String str23 = "method-execution";
        AppleGPSCoordinatesBox.ajc$tjp_0 = bVar.h(str23, bVar.g("1", "getValue", "com.googlecode.mp4parser.boxes.apple.AppleGPSCoordinatesBox", "", "", "", "java.lang.String"), 22);
        AppleGPSCoordinatesBox.ajc$tjp_1 = bVar.h(str23, bVar.g("1", "setValue", "com.googlecode.mp4parser.boxes.apple.AppleGPSCoordinatesBox", "java.lang.String", "iso6709String", "", "void"), 26);
        AppleGPSCoordinatesBox.ajc$tjp_2 = bVar.h(str23, bVar.g("1", "toString", "com.googlecode.mp4parser.boxes.apple.AppleGPSCoordinatesBox", "", "", "", "java.lang.String"), 52);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        this.lang = byteBuffer.getShort();
        byte[] bArr = new byte[byteBuffer.getShort()];
        byteBuffer.get(bArr);
        this.coords = j.a(bArr);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        byteBuffer.putShort((short)this.coords.length());
        byteBuffer.putShort((short)this.lang);
        byteBuffer.put(j.b(this.coords));
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return (long)(j.c(this.coords) + 4);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public String getValue() {
        d.b().c(b.c(AppleGPSCoordinatesBox.ajc$tjp_0, this, this));
        return this.coords;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setValue(String str) {
        d.b().c(b.d(AppleGPSCoordinatesBox.ajc$tjp_1, this, this, str));
        this.lang = 5575;
        this.coords = str;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public String toString() {
        d.b().c(b.c(AppleGPSCoordinatesBox.ajc$tjp_2, this, this));
        String str2 = "AppleGPSCoordinatesBox[";
        StringBuilder stringBuilder = new StringBuilder(str2);
        String str3 = "]";
        str = str2 + this.coords + str3;
        return str;
    }
}
