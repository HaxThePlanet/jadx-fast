package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.d;
import f.b.a.d;
import f.b.a.e;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class OriginalFormatBox extends AbstractBox {

    static final boolean $assertionsDisabled = false;
    public static final String TYPE = "frma";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private String dataFormat;
    static {
        OriginalFormatBox.ajc$preClinit();
    }

    public OriginalFormatBox() {
        super("frma");
        this.dataFormat = "    ";
    }

    private static void ajc$preClinit() {
        b bVar4 = new b("OriginalFormatBox.java", OriginalFormatBox.class);
        final String str23 = "method-execution";
        OriginalFormatBox.ajc$tjp_0 = bVar4.h(str23, bVar4.g("1", "getDataFormat", "com.coremedia.iso.boxes.OriginalFormatBox", "", "", "", "java.lang.String"), 42);
        OriginalFormatBox.ajc$tjp_1 = bVar4.h(str23, bVar4.g("1", "setDataFormat", "com.coremedia.iso.boxes.OriginalFormatBox", "java.lang.String", "dataFormat", "", "void"), 47);
        OriginalFormatBox.ajc$tjp_2 = bVar4.h(str23, bVar4.g("1", "toString", "com.coremedia.iso.boxes.OriginalFormatBox", "", "", "", "java.lang.String"), 67);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        this.dataFormat = e.b(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        byteBuffer.put(d.e(this.dataFormat));
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return 4;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public String getDataFormat() {
        d.b().c(b.c(OriginalFormatBox.ajc$tjp_0, this, this));
        return this.dataFormat;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setDataFormat(String string) {
        d.b().c(b.d(OriginalFormatBox.ajc$tjp_1, this, this, string));
        this.dataFormat = string;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public String toString() {
        d.b().c(b.c(OriginalFormatBox.ajc$tjp_2, this, this));
        StringBuilder stringBuilder = new StringBuilder("OriginalFormatBox[dataFormat=");
        stringBuilder.append(getDataFormat());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
