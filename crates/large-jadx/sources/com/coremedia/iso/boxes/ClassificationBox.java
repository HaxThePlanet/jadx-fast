package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import f.b.a.e;
import f.b.a.g;
import f.b.a.j;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: ClassificationBox.java */
/* loaded from: classes.dex */
public class ClassificationBox extends AbstractFullBox {

    public static final String TYPE = "clsf";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    private static final /* synthetic */ a.a ajc$tjp_4;
    private static final /* synthetic */ a.a ajc$tjp_5;
    private static final /* synthetic */ a.a ajc$tjp_6;
    private static final /* synthetic */ a.a ajc$tjp_7;
    private static final /* synthetic */ a.a ajc$tjp_8;
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

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("ClassificationBox.java", ClassificationBox.class);
        final String str65 = "method-execution";
        ClassificationBox.ajc$tjp_0 = bVar.h(str65, bVar.g("1", "getLanguage", "com.coremedia.iso.boxes.ClassificationBox", "", "", "", "java.lang.String"), 44);
        ClassificationBox.ajc$tjp_1 = bVar.h(str65, bVar.g("1", "getClassificationEntity", "com.coremedia.iso.boxes.ClassificationBox", "", "", "", "java.lang.String"), 48);
        ClassificationBox.ajc$tjp_2 = bVar.h(str65, bVar.g("1", "getClassificationTableIndex", "com.coremedia.iso.boxes.ClassificationBox", "", "", "", "int"), 52);
        ClassificationBox.ajc$tjp_3 = bVar.h(str65, bVar.g("1", "getClassificationInfo", "com.coremedia.iso.boxes.ClassificationBox", "", "", "", "java.lang.String"), 56);
        ClassificationBox.ajc$tjp_4 = bVar.h(str65, bVar.g("1", "setClassificationEntity", "com.coremedia.iso.boxes.ClassificationBox", "java.lang.String", "classificationEntity", "", "void"), 60);
        ClassificationBox.ajc$tjp_5 = bVar.h(str65, bVar.g("1", "setClassificationTableIndex", "com.coremedia.iso.boxes.ClassificationBox", "int", "classificationTableIndex", "", "void"), 64);
        ClassificationBox.ajc$tjp_6 = bVar.h(str65, bVar.g("1", "setLanguage", "com.coremedia.iso.boxes.ClassificationBox", "java.lang.String", "language", "", "void"), 68);
        ClassificationBox.ajc$tjp_7 = bVar.h(str65, bVar.g("1", "setClassificationInfo", "com.coremedia.iso.boxes.ClassificationBox", "java.lang.String", "classificationInfo", "", "void"), 72);
        ClassificationBox.ajc$tjp_8 = bVar.h(str65, bVar.g("1", "toString", "com.coremedia.iso.boxes.ClassificationBox", "", "", "", "java.lang.String"), 101);
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
        byteBuffer.put((byte) 0);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)(j.c(this.classificationInfo) + 8) + 1;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getLanguage() {
        d.b().c(b.c(ClassificationBox.ajc$tjp_0, this, this));
        return this.language;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setClassificationEntity(String str) {
        d.b().c(b.d(ClassificationBox.ajc$tjp_4, this, this, str));
        this.classificationEntity = str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setClassificationInfo(String str) {
        d.b().c(b.d(ClassificationBox.ajc$tjp_7, this, this, str));
        this.classificationInfo = str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setClassificationTableIndex(int i) {
        d.b().c(b.d(ClassificationBox.ajc$tjp_5, this, this, a.e(i)));
        this.classificationTableIndex = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setLanguage(String str) {
        d.b().c(b.d(ClassificationBox.ajc$tjp_6, this, this, str));
        this.language = str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(ClassificationBox.ajc$tjp_8, this, this));
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ClassificationBox[language=";
        String language = getLanguage();
        String str3 = "classificationEntity=";
        String classificationEntity = getClassificationEntity();
        String str4 = ";classificationTableIndex=";
        int classificationTableIndex = getClassificationTableIndex();
        String str5 = ";language=";
        String language2 = getLanguage();
        String str6 = ";classificationInfo=";
        String classificationInfo = getClassificationInfo();
        String str7 = "]";
        str = str2 + language + str3 + classificationEntity + str4 + classificationTableIndex + str5 + language2 + str6 + classificationInfo + str7;
        return str;
    }
}
