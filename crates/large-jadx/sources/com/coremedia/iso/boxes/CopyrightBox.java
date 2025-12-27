package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import f.b.a.j;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: CopyrightBox.java */
/* loaded from: classes.dex */
public class CopyrightBox extends AbstractFullBox {

    public static final String TYPE = "cprt";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    private static final /* synthetic */ a.a ajc$tjp_4;
    private String copyright;
    private String language;
    static {
        CopyrightBox.ajc$preClinit();
    }

    public CopyrightBox() {
        super("cprt");
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("CopyrightBox.java", CopyrightBox.class);
        final String str37 = "method-execution";
        CopyrightBox.ajc$tjp_0 = bVar.h(str37, bVar.g("1", "getLanguage", "com.coremedia.iso.boxes.CopyrightBox", "", "", "", "java.lang.String"), 46);
        CopyrightBox.ajc$tjp_1 = bVar.h(str37, bVar.g("1", "getCopyright", "com.coremedia.iso.boxes.CopyrightBox", "", "", "", "java.lang.String"), 50);
        CopyrightBox.ajc$tjp_2 = bVar.h(str37, bVar.g("1", "setLanguage", "com.coremedia.iso.boxes.CopyrightBox", "java.lang.String", "language", "", "void"), 54);
        CopyrightBox.ajc$tjp_3 = bVar.h(str37, bVar.g("1", "setCopyright", "com.coremedia.iso.boxes.CopyrightBox", "java.lang.String", "copyright", "", "void"), 58);
        CopyrightBox.ajc$tjp_4 = bVar.h(str37, bVar.g("1", "toString", "com.coremedia.iso.boxes.CopyrightBox", "", "", "", "java.lang.String"), 81);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.language = e.f(byteBuffer);
        this.copyright = e.g(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        g.d(byteBuffer, this.language);
        byteBuffer.put(j.b(this.copyright));
        byteBuffer.put((byte) 0);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)(j.c(this.copyright) + 7);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getCopyright() {
        d.b().c(b.c(CopyrightBox.ajc$tjp_1, this, this));
        return this.copyright;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getLanguage() {
        d.b().c(b.c(CopyrightBox.ajc$tjp_0, this, this));
        return this.language;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setCopyright(String str) {
        d.b().c(b.d(CopyrightBox.ajc$tjp_3, this, this, str));
        this.copyright = str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setLanguage(String str) {
        d.b().c(b.d(CopyrightBox.ajc$tjp_2, this, this, str));
        this.language = str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(CopyrightBox.ajc$tjp_4, this, this));
        String str2 = "CopyrightBox[language=";
        StringBuilder stringBuilder = new StringBuilder(str2);
        String language = getLanguage();
        String str3 = ";copyright=";
        String copyright = getCopyright();
        String str4 = "]";
        str = str2 + language + str3 + copyright + str4;
        return str;
    }
}
