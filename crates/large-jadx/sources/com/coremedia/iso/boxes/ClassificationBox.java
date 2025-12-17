package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.d;
import f.b.a.e;
import f.b.a.g;
import f.b.a.j;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class ClassificationBox extends AbstractFullBox {

    public static final String TYPE = "clsf";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    private static final a.a ajc$tjp_6;
    private static final a.a ajc$tjp_7;
    private static final a.a ajc$tjp_8;
    private String classificationEntity;
    private String classificationInfo;
    private int classificationTableIndex;
    private String language;
    static {
        ClassificationBox.ajc$preClinit();
    }

    public ClassificationBox() {
        super("clsf");
    }

    private static void ajc$preClinit() {
        b bVar10 = new b("ClassificationBox.java", ClassificationBox.class);
        final String str65 = "method-execution";
        ClassificationBox.ajc$tjp_0 = bVar10.h(str65, bVar10.g("1", "getLanguage", "com.coremedia.iso.boxes.ClassificationBox", "", "", "", "java.lang.String"), 44);
        ClassificationBox.ajc$tjp_1 = bVar10.h(str65, bVar10.g("1", "getClassificationEntity", "com.coremedia.iso.boxes.ClassificationBox", "", "", "", "java.lang.String"), 48);
        ClassificationBox.ajc$tjp_2 = bVar10.h(str65, bVar10.g("1", "getClassificationTableIndex", "com.coremedia.iso.boxes.ClassificationBox", "", "", "", "int"), 52);
        ClassificationBox.ajc$tjp_3 = bVar10.h(str65, bVar10.g("1", "getClassificationInfo", "com.coremedia.iso.boxes.ClassificationBox", "", "", "", "java.lang.String"), 56);
        ClassificationBox.ajc$tjp_4 = bVar10.h(str65, bVar10.g("1", "setClassificationEntity", "com.coremedia.iso.boxes.ClassificationBox", "java.lang.String", "classificationEntity", "", "void"), 60);
        ClassificationBox.ajc$tjp_5 = bVar10.h(str65, bVar10.g("1", "setClassificationTableIndex", "com.coremedia.iso.boxes.ClassificationBox", "int", "classificationTableIndex", "", "void"), 64);
        ClassificationBox.ajc$tjp_6 = bVar10.h(str65, bVar10.g("1", "setLanguage", "com.coremedia.iso.boxes.ClassificationBox", "java.lang.String", "language", "", "void"), 68);
        ClassificationBox.ajc$tjp_7 = bVar10.h(str65, bVar10.g("1", "setClassificationInfo", "com.coremedia.iso.boxes.ClassificationBox", "java.lang.String", "classificationInfo", "", "void"), 72);
        ClassificationBox.ajc$tjp_8 = bVar10.h(str65, bVar10.g("1", "toString", "com.coremedia.iso.boxes.ClassificationBox", "", "", "", "java.lang.String"), 101);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        this.classificationEntity = d.c(bArr);
        this.classificationTableIndex = e.i(byteBuffer);
        this.language = e.f(byteBuffer);
        this.classificationInfo = e.g(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getClassificationEntity() {
        d.b().c(b.c(ClassificationBox.ajc$tjp_1, this, this));
        return this.classificationEntity;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getClassificationInfo() {
        d.b().c(b.c(ClassificationBox.ajc$tjp_3, this, this));
        return this.classificationInfo;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getClassificationTableIndex() {
        d.b().c(b.c(ClassificationBox.ajc$tjp_2, this, this));
        return this.classificationTableIndex;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        byteBuffer.put(d.e(this.classificationEntity));
        g.e(byteBuffer, this.classificationTableIndex);
        g.d(byteBuffer, this.language);
        byteBuffer.put(j.b(this.classificationInfo));
        byteBuffer.put(0);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)i3;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getLanguage() {
        d.b().c(b.c(ClassificationBox.ajc$tjp_0, this, this));
        return this.language;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setClassificationEntity(String string) {
        d.b().c(b.d(ClassificationBox.ajc$tjp_4, this, this, string));
        this.classificationEntity = string;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setClassificationInfo(String string) {
        d.b().c(b.d(ClassificationBox.ajc$tjp_7, this, this, string));
        this.classificationInfo = string;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setClassificationTableIndex(int i) {
        d.b().c(b.d(ClassificationBox.ajc$tjp_5, this, this, a.e(i)));
        this.classificationTableIndex = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setLanguage(String string) {
        d.b().c(b.d(ClassificationBox.ajc$tjp_6, this, this, string));
        this.language = string;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(ClassificationBox.ajc$tjp_8, this, this));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ClassificationBox[language=");
        stringBuilder.append(getLanguage());
        stringBuilder.append("classificationEntity=");
        stringBuilder.append(getClassificationEntity());
        stringBuilder.append(";classificationTableIndex=");
        stringBuilder.append(getClassificationTableIndex());
        stringBuilder.append(";language=");
        stringBuilder.append(getLanguage());
        stringBuilder.append(";classificationInfo=");
        stringBuilder.append(getClassificationInfo());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
