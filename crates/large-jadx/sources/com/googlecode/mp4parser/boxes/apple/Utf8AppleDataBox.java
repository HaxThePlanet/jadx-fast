package com.googlecode.mp4parser.boxes.apple;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.j;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: Utf8AppleDataBox.java */
/* loaded from: classes2.dex */
public abstract class Utf8AppleDataBox extends AppleDataBox {

    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    String value;
    static {
        Utf8AppleDataBox.ajc$preClinit();
    }

    protected Utf8AppleDataBox(String str) {
        super(str, 1);
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("Utf8AppleDataBox.java", Utf8AppleDataBox.class);
        final String str16 = "method-execution";
        Utf8AppleDataBox.ajc$tjp_0 = bVar.h(str16, bVar.g("1", "getValue", "com.googlecode.mp4parser.boxes.apple.Utf8AppleDataBox", "", "", "", "java.lang.String"), 21);
        Utf8AppleDataBox.ajc$tjp_1 = bVar.h(str16, bVar.g("1", "setValue", "com.googlecode.mp4parser.boxes.apple.Utf8AppleDataBox", "java.lang.String", "value", "", "void"), 30);
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    protected int getDataLength() throws java.io.UnsupportedEncodingException {
        return this.value.getBytes(Charset.forName("UTF-8")).length;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    public String getValue() {
        d.b().c(b.c(Utf8AppleDataBox.ajc$tjp_0, this, this));
        if (!isParsed()) {
            parseDetails();
        }
        return this.value;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    protected void parseData(ByteBuffer byteBuffer) {
        this.value = e.h(byteBuffer, byteBuffer.remaining());
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    public void setValue(String str) {
        d.b().c(b.d(Utf8AppleDataBox.ajc$tjp_1, this, this, str));
        this.value = str;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    public byte[] writeData() {
        return j.b(this.value);
    }
}
