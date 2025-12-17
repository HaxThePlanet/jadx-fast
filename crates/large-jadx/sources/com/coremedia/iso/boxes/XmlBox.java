package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.j;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class XmlBox extends AbstractFullBox {

    public static final String TYPE = "xml ";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    String xml;
    static {
        XmlBox.ajc$preClinit();
    }

    public XmlBox() {
        super("xml ");
        this.xml = "";
    }

    private static void ajc$preClinit() {
        b bVar4 = new b("XmlBox.java", XmlBox.class);
        final String str23 = "method-execution";
        XmlBox.ajc$tjp_0 = bVar4.h(str23, bVar4.g("1", "getXml", "com.coremedia.iso.boxes.XmlBox", "", "", "", "java.lang.String"), 20);
        XmlBox.ajc$tjp_1 = bVar4.h(str23, bVar4.g("1", "setXml", "com.coremedia.iso.boxes.XmlBox", "java.lang.String", "xml", "", "void"), 24);
        XmlBox.ajc$tjp_2 = bVar4.h(str23, bVar4.g("1", "toString", "com.coremedia.iso.boxes.XmlBox", "", "", "", "java.lang.String"), 46);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.xml = e.h(byteBuffer, byteBuffer.remaining());
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(j.b(this.xml));
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)i2;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getXml() {
        d.b().c(b.c(XmlBox.ajc$tjp_0, this, this));
        return this.xml;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setXml(String string) {
        d.b().c(b.d(XmlBox.ajc$tjp_1, this, this, string));
        this.xml = string;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(XmlBox.ajc$tjp_2, this, this));
        StringBuilder stringBuilder = new StringBuilder("XmlBox{xml='");
        stringBuilder.append(this.xml);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
