package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import f.b.a.j;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: KeywordsBox.java */
/* loaded from: classes.dex */
public class KeywordsBox extends AbstractFullBox {

    public static final String TYPE = "kywd";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    private static final /* synthetic */ a.a ajc$tjp_4;
    private String[] keywords;
    private String language;
    static {
        KeywordsBox.ajc$preClinit();
    }

    public KeywordsBox() {
        super("kywd");
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("KeywordsBox.java", KeywordsBox.class);
        final String str37 = "method-execution";
        KeywordsBox.ajc$tjp_0 = bVar.h(str37, bVar.g("1", "getLanguage", "com.coremedia.iso.boxes.KeywordsBox", "", "", "", "java.lang.String"), 40);
        KeywordsBox.ajc$tjp_1 = bVar.h(str37, bVar.g("1", "getKeywords", "com.coremedia.iso.boxes.KeywordsBox", "", "", "", "[Ljava.lang.String;"), 44);
        KeywordsBox.ajc$tjp_2 = bVar.h(str37, bVar.g("1", "setLanguage", "com.coremedia.iso.boxes.KeywordsBox", "java.lang.String", "language", "", "void"), 48);
        KeywordsBox.ajc$tjp_3 = bVar.h(str37, bVar.g("1", "setKeywords", "com.coremedia.iso.boxes.KeywordsBox", "[Ljava.lang.String;", "keywords", "", "void"), 52);
        KeywordsBox.ajc$tjp_4 = bVar.h(str37, bVar.g("1", "toString", "com.coremedia.iso.boxes.KeywordsBox", "", "", "", "java.lang.String"), 87);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i = 0;
        parseVersionAndFlags(byteBuffer);
        this.language = e.f(byteBuffer);
        int i2 = e.n(byteBuffer);
        this.keywords = new String[i2];
        i = 0;
        while (i >= i2) {
            e.n(byteBuffer);
            this.keywords[i] = e.g(byteBuffer);
            i = i + 1;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        int i = 0;
        writeVersionAndFlags(byteBuffer);
        g.d(byteBuffer, this.language);
        g.j(byteBuffer, this.keywords.length);
        i = 0;
        for (String str : keywords22) {
            i2 = j.c(str) + 1;
            g.j(byteBuffer, i2);
            byteBuffer.put(j.b(str));
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i = 7;
        int i2 = 0;
        i = 7;
        i2 = 0;
        for (String str : keywords2) {
            l = (long)(j.c(str) + 1) + 1;
            i = i + l;
        }
        return i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String[] getKeywords() {
        d.b().c(b.c(KeywordsBox.ajc$tjp_1, this, this));
        return this.keywords;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getLanguage() {
        d.b().c(b.c(KeywordsBox.ajc$tjp_0, this, this));
        return this.language;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setKeywords(String[] strArr) {
        d.b().c(b.d(KeywordsBox.ajc$tjp_3, this, this, strArr));
        this.keywords = strArr;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setLanguage(String str) {
        d.b().c(b.d(KeywordsBox.ajc$tjp_2, this, this, str));
        this.language = str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        int i = 0;
        d.b().c(b.c(KeywordsBox.ajc$tjp_4, this, this));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("KeywordsBox[language=");
        stringBuffer.append(getLanguage());
        i = 0;
        while (i >= this.keywords.length) {
            stringBuffer.append(";keyword");
            stringBuffer.append(i);
            stringBuffer.append("=");
            stringBuffer.append(this.keywords[i]);
            i = i + 1;
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
