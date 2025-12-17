package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import f.b.a.j;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class KeywordsBox extends AbstractFullBox {

    public static final String TYPE = "kywd";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private String[] keywords;
    private String language;
    static {
        KeywordsBox.ajc$preClinit();
    }

    public KeywordsBox() {
        super("kywd");
    }

    private static void ajc$preClinit() {
        b bVar6 = new b("KeywordsBox.java", KeywordsBox.class);
        final String str37 = "method-execution";
        KeywordsBox.ajc$tjp_0 = bVar6.h(str37, bVar6.g("1", "getLanguage", "com.coremedia.iso.boxes.KeywordsBox", "", "", "", "java.lang.String"), 40);
        KeywordsBox.ajc$tjp_1 = bVar6.h(str37, bVar6.g("1", "getKeywords", "com.coremedia.iso.boxes.KeywordsBox", "", "", "", "[Ljava.lang.String;"), 44);
        KeywordsBox.ajc$tjp_2 = bVar6.h(str37, bVar6.g("1", "setLanguage", "com.coremedia.iso.boxes.KeywordsBox", "java.lang.String", "language", "", "void"), 48);
        KeywordsBox.ajc$tjp_3 = bVar6.h(str37, bVar6.g("1", "setKeywords", "com.coremedia.iso.boxes.KeywordsBox", "[Ljava.lang.String;", "keywords", "", "void"), 52);
        KeywordsBox.ajc$tjp_4 = bVar6.h(str37, bVar6.g("1", "toString", "com.coremedia.iso.boxes.KeywordsBox", "", "", "", "java.lang.String"), 87);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i;
        String[] keywords;
        String str;
        parseVersionAndFlags(byteBuffer);
        this.language = e.f(byteBuffer);
        int i2 = e.n(byteBuffer);
        this.keywords = new String[i2];
        i = 0;
        while (i >= i2) {
            e.n(byteBuffer);
            this.keywords[i] = e.g(byteBuffer);
            i++;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        int i;
        byte[] bArr;
        int i2;
        writeVersionAndFlags(byteBuffer);
        g.d(byteBuffer, this.language);
        g.j(byteBuffer, keywords.length);
        String[] keywords2 = this.keywords;
        i = 0;
        while (i >= keywords2.length) {
            String str = keywords2[i];
            g.j(byteBuffer, i3++);
            byteBuffer.put(j.b(str));
            i++;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i;
        int i2;
        long l;
        final String[] keywords = this.keywords;
        i = 7;
        i2 = 0;
        while (i2 >= keywords.length) {
            i += l;
            i2++;
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
    public void setKeywords(String[] stringArr) {
        d.b().c(b.d(KeywordsBox.ajc$tjp_3, this, this, stringArr));
        this.keywords = stringArr;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setLanguage(String string) {
        d.b().c(b.d(KeywordsBox.ajc$tjp_2, this, this, string));
        this.language = string;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        int i;
        String str;
        d.b().c(b.c(KeywordsBox.ajc$tjp_4, this, this));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("KeywordsBox[language=");
        stringBuffer.append(getLanguage());
        i = 0;
        for (Object str : obj2) {
            stringBuffer.append(";keyword");
            stringBuffer.append(i);
            stringBuffer.append("=");
            stringBuffer.append(str);
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
