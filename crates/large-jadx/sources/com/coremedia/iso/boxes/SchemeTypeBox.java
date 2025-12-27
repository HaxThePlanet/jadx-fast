package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import f.b.a.e;
import f.b.a.g;
import f.b.a.j;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: SchemeTypeBox.java */
/* loaded from: classes.dex */
public class SchemeTypeBox extends AbstractFullBox {

    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TYPE = "schm";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    private static final /* synthetic */ a.a ajc$tjp_4;
    private static final /* synthetic */ a.a ajc$tjp_5;
    private static final /* synthetic */ a.a ajc$tjp_6;
    String schemeType = "    ";
    String schemeUri = null;
    long schemeVersion;
    public SchemeTypeBox() {
        super("schm");
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("SchemeTypeBox.java", SchemeTypeBox.class);
        final String str51 = "method-execution";
        SchemeTypeBox.ajc$tjp_0 = bVar.h(str51, bVar.g("1", "getSchemeType", "com.coremedia.iso.boxes.SchemeTypeBox", "", "", "", "java.lang.String"), 44);
        SchemeTypeBox.ajc$tjp_1 = bVar.h(str51, bVar.g("1", "getSchemeVersion", "com.coremedia.iso.boxes.SchemeTypeBox", "", "", "", "long"), 48);
        SchemeTypeBox.ajc$tjp_2 = bVar.h(str51, bVar.g("1", "getSchemeUri", "com.coremedia.iso.boxes.SchemeTypeBox", "", "", "", "java.lang.String"), 52);
        SchemeTypeBox.ajc$tjp_3 = bVar.h(str51, bVar.g("1", "setSchemeType", "com.coremedia.iso.boxes.SchemeTypeBox", "java.lang.String", "schemeType", "", "void"), 56);
        SchemeTypeBox.ajc$tjp_4 = bVar.h(str51, bVar.g("1", "setSchemeVersion", "com.coremedia.iso.boxes.SchemeTypeBox", "int", "schemeVersion", "", "void"), 61);
        SchemeTypeBox.ajc$tjp_5 = bVar.h(str51, bVar.g("1", "setSchemeUri", "com.coremedia.iso.boxes.SchemeTypeBox", "java.lang.String", "schemeUri", "", "void"), 65);
        SchemeTypeBox.ajc$tjp_6 = bVar.h(str51, bVar.g("1", "toString", "com.coremedia.iso.boxes.SchemeTypeBox", "", "", "", "java.lang.String"), 93);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.schemeType = e.b(byteBuffer);
        this.schemeVersion = e.k(byteBuffer);
        final int i2 = 1;
        if ((getFlags() & i2) == i2) {
            this.schemeUri = e.g(byteBuffer);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(d.e(this.schemeType));
        g.g(byteBuffer, this.schemeVersion);
        final int i2 = 1;
        i = getFlags() & i2;
        if ((this.getFlags() & i2) == i2) {
            byteBuffer.put(j.b(this.schemeUri));
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i = 0;
        final int i5 = 1;
        if ((getFlags() & i5) == i5) {
            i = j.c(this.schemeUri) + i5;
        } else {
            i = 0;
        }
        return (long)(i + 12);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getSchemeType() {
        d.b().c(b.c(SchemeTypeBox.ajc$tjp_0, this, this));
        return this.schemeType;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getSchemeUri() {
        d.b().c(b.c(SchemeTypeBox.ajc$tjp_2, this, this));
        return this.schemeUri;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getSchemeVersion() {
        d.b().c(b.c(SchemeTypeBox.ajc$tjp_1, this, this));
        return this.schemeVersion;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setSchemeType(String str) {
        d.b().c(b.d(SchemeTypeBox.ajc$tjp_3, this, this, str));
        this.schemeType = str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setSchemeUri(String str) {
        d.b().c(b.d(SchemeTypeBox.ajc$tjp_5, this, this, str));
        this.schemeUri = str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setSchemeVersion(int i) {
        d.b().c(b.d(SchemeTypeBox.ajc$tjp_4, this, this, a.e(i)));
        this.schemeVersion = (long)i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(SchemeTypeBox.ajc$tjp_6, this, this));
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "Schema Type Box[";
        String str3 = "schemeUri=";
        String str4 = "; ";
        String str6 = "schemeType=";
        String str7 = "schemeVersion=";
        String str5 = "]";
        str = str2 + str3 + this.schemeUri + str4 + str6 + this.schemeType + str4 + str7 + this.schemeVersion + str4 + str5;
        return str;
    }

    static {
        SchemeTypeBox.ajc$preClinit();
    }
}
