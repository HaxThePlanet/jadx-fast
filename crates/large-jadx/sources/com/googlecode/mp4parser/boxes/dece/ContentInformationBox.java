package com.googlecode.mp4parser.boxes.dece;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import f.b.a.j;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public class ContentInformationBox extends AbstractFullBox {

    public static final String TYPE = "cinf";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_10;
    private static final a.a ajc$tjp_11;
    private static final a.a ajc$tjp_12;
    private static final a.a ajc$tjp_13;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    private static final a.a ajc$tjp_6;
    private static final a.a ajc$tjp_7;
    private static final a.a ajc$tjp_8;
    private static final a.a ajc$tjp_9;
    Map<String, String> brandEntries;
    String codecs;
    Map<String, String> idEntries;
    String languages;
    String mimeSubtypeName;
    String profileLevelIdc;
    String protection;
    static {
        ContentInformationBox.ajc$preClinit();
    }

    public ContentInformationBox() {
        super("cinf");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.brandEntries = linkedHashMap;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        this.idEntries = linkedHashMap2;
    }

    private static void ajc$preClinit() {
        b bVar15 = new b("ContentInformationBox.java", ContentInformationBox.class);
        final String str100 = "method-execution";
        ContentInformationBox.ajc$tjp_0 = bVar15.h(str100, bVar15.g("1", "getMimeSubtypeName", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.lang.String"), 144);
        ContentInformationBox.ajc$tjp_1 = bVar15.h(str100, bVar15.g("1", "setMimeSubtypeName", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "java.lang.String", "mimeSubtypeName", "", "void"), 148);
        ContentInformationBox.ajc$tjp_10 = bVar15.h(str100, bVar15.g("1", "getBrandEntries", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.util.Map"), 184);
        ContentInformationBox.ajc$tjp_11 = bVar15.h(str100, bVar15.g("1", "setBrandEntries", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "java.util.Map", "brandEntries", "", "void"), 188);
        ContentInformationBox.ajc$tjp_12 = bVar15.h(str100, bVar15.g("1", "getIdEntries", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.util.Map"), 192);
        ContentInformationBox.ajc$tjp_13 = bVar15.h(str100, bVar15.g("1", "setIdEntries", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "java.util.Map", "idEntries", "", "void"), 196);
        ContentInformationBox.ajc$tjp_2 = bVar15.h(str100, bVar15.g("1", "getProfileLevelIdc", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.lang.String"), 152);
        ContentInformationBox.ajc$tjp_3 = bVar15.h(str100, bVar15.g("1", "setProfileLevelIdc", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "java.lang.String", "profileLevelIdc", "", "void"), 156);
        ContentInformationBox.ajc$tjp_4 = bVar15.h(str100, bVar15.g("1", "getCodecs", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.lang.String"), 160);
        ContentInformationBox.ajc$tjp_5 = bVar15.h(str100, bVar15.g("1", "setCodecs", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "java.lang.String", "codecs", "", "void"), 164);
        ContentInformationBox.ajc$tjp_6 = bVar15.h(str100, bVar15.g("1", "getProtection", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.lang.String"), 168);
        ContentInformationBox.ajc$tjp_7 = bVar15.h(str100, bVar15.g("1", "setProtection", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "java.lang.String", "protection", "", "void"), 172);
        ContentInformationBox.ajc$tjp_8 = bVar15.h(str100, bVar15.g("1", "getLanguages", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.lang.String"), 176);
        ContentInformationBox.ajc$tjp_9 = bVar15.h(str100, bVar15.g("1", "setLanguages", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "java.lang.String", "languages", "", "void"), 180);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        int i2;
        int i;
        int i3;
        String str;
        String str2;
        parseVersionAndFlags(byteBuffer);
        this.mimeSubtypeName = e.g(byteBuffer);
        this.profileLevelIdc = e.g(byteBuffer);
        this.codecs = e.g(byteBuffer);
        this.protection = e.g(byteBuffer);
        this.languages = e.g(byteBuffer);
        i2 = e.n(byteBuffer);
        while (i2 <= 0) {
            this.brandEntries.put(e.g(byteBuffer), e.g(byteBuffer));
            i2 = i3;
        }
        i = e.n(byteBuffer);
        while (i <= 0) {
            this.idEntries.put(e.g(byteBuffer), e.g(byteBuffer));
            i = i3;
        }
    }

    public Map<String, String> getBrandEntries() {
        d.b().c(b.c(ContentInformationBox.ajc$tjp_10, this, this));
        return this.brandEntries;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getCodecs() {
        d.b().c(b.c(ContentInformationBox.ajc$tjp_4, this, this));
        return this.codecs;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        Set entrySet;
        Object value;
        Object key;
        writeVersionAndFlags(byteBuffer);
        g.l(byteBuffer, this.mimeSubtypeName);
        g.l(byteBuffer, this.profileLevelIdc);
        g.l(byteBuffer, this.codecs);
        g.l(byteBuffer, this.protection);
        g.l(byteBuffer, this.languages);
        g.j(byteBuffer, this.brandEntries.size());
        Iterator iterator = this.brandEntries.entrySet().iterator();
        for (Map.Entry next4 : iterator) {
            g.l(byteBuffer, (String)next4.getKey());
            g.l(byteBuffer, (String)next4.getValue());
        }
        g.j(byteBuffer, this.idEntries.size());
        Iterator iterator2 = this.idEntries.entrySet().iterator();
        for (Map.Entry next2 : iterator2) {
            g.l(byteBuffer, (String)next2.getKey());
            g.l(byteBuffer, (String)next2.getValue());
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i2;
        int i;
        Set entrySet;
        long l3;
        long l;
        long l2;
        int i21 = 1;
        i9 += i21;
        Iterator iterator = this.brandEntries.entrySet().iterator();
        for (Map.Entry next4 : iterator) {
            i10 += l;
        }
        i2 += i21;
        Iterator iterator2 = this.idEntries.entrySet().iterator();
        for (Map.Entry next2 : iterator2) {
            i11 += entrySet;
        }
        return i;
    }

    public Map<String, String> getIdEntries() {
        d.b().c(b.c(ContentInformationBox.ajc$tjp_12, this, this));
        return this.idEntries;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getLanguages() {
        d.b().c(b.c(ContentInformationBox.ajc$tjp_8, this, this));
        return this.languages;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getMimeSubtypeName() {
        d.b().c(b.c(ContentInformationBox.ajc$tjp_0, this, this));
        return this.mimeSubtypeName;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getProfileLevelIdc() {
        d.b().c(b.c(ContentInformationBox.ajc$tjp_2, this, this));
        return this.profileLevelIdc;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getProtection() {
        d.b().c(b.c(ContentInformationBox.ajc$tjp_6, this, this));
        return this.protection;
    }

    public void setBrandEntries(Map<String, String> map) {
        d.b().c(b.d(ContentInformationBox.ajc$tjp_11, this, this, map));
        this.brandEntries = map;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setCodecs(String string) {
        d.b().c(b.d(ContentInformationBox.ajc$tjp_5, this, this, string));
        this.codecs = string;
    }

    public void setIdEntries(Map<String, String> map) {
        d.b().c(b.d(ContentInformationBox.ajc$tjp_13, this, this, map));
        this.idEntries = map;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setLanguages(String string) {
        d.b().c(b.d(ContentInformationBox.ajc$tjp_9, this, this, string));
        this.languages = string;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setMimeSubtypeName(String string) {
        d.b().c(b.d(ContentInformationBox.ajc$tjp_1, this, this, string));
        this.mimeSubtypeName = string;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setProfileLevelIdc(String string) {
        d.b().c(b.d(ContentInformationBox.ajc$tjp_3, this, this, string));
        this.profileLevelIdc = string;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setProtection(String string) {
        d.b().c(b.d(ContentInformationBox.ajc$tjp_7, this, this, string));
        this.protection = string;
    }
}
