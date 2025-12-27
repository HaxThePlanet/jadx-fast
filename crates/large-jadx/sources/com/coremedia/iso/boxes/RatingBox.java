package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import f.b.a.e;
import f.b.a.g;
import f.b.a.j;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: RatingBox.java */
/* loaded from: classes.dex */
public class RatingBox extends AbstractFullBox {

    public static final String TYPE = "rtng";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    private static final /* synthetic */ a.a ajc$tjp_4;
    private static final /* synthetic */ a.a ajc$tjp_5;
    private static final /* synthetic */ a.a ajc$tjp_6;
    private static final /* synthetic */ a.a ajc$tjp_7;
    private static final /* synthetic */ a.a ajc$tjp_8;
    private String language;
    private String ratingCriteria;
    private String ratingEntity;
    private String ratingInfo;
    static {
        RatingBox.ajc$preClinit();
    }

    public RatingBox() {
        super("rtng");
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("RatingBox.java", RatingBox.class);
        final String str65 = "method-execution";
        RatingBox.ajc$tjp_0 = bVar.h(str65, bVar.g("1", "setRatingEntity", "com.coremedia.iso.boxes.RatingBox", "java.lang.String", "ratingEntity", "", "void"), 46);
        RatingBox.ajc$tjp_1 = bVar.h(str65, bVar.g("1", "setRatingCriteria", "com.coremedia.iso.boxes.RatingBox", "java.lang.String", "ratingCriteria", "", "void"), 50);
        RatingBox.ajc$tjp_2 = bVar.h(str65, bVar.g("1", "setLanguage", "com.coremedia.iso.boxes.RatingBox", "java.lang.String", "language", "", "void"), 54);
        RatingBox.ajc$tjp_3 = bVar.h(str65, bVar.g("1", "setRatingInfo", "com.coremedia.iso.boxes.RatingBox", "java.lang.String", "ratingInfo", "", "void"), 58);
        RatingBox.ajc$tjp_4 = bVar.h(str65, bVar.g("1", "getLanguage", "com.coremedia.iso.boxes.RatingBox", "", "", "", "java.lang.String"), 62);
        RatingBox.ajc$tjp_5 = bVar.h(str65, bVar.g("1", "getRatingEntity", "com.coremedia.iso.boxes.RatingBox", "", "", "", "java.lang.String"), 73);
        RatingBox.ajc$tjp_6 = bVar.h(str65, bVar.g("1", "getRatingCriteria", "com.coremedia.iso.boxes.RatingBox", "", "", "", "java.lang.String"), 83);
        RatingBox.ajc$tjp_7 = bVar.h(str65, bVar.g("1", "getRatingInfo", "com.coremedia.iso.boxes.RatingBox", "", "", "", "java.lang.String"), 87);
        RatingBox.ajc$tjp_8 = bVar.h(str65, bVar.g("1", "toString", "com.coremedia.iso.boxes.RatingBox", "", "", "", "java.lang.String"), 115);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.ratingEntity = e.b(byteBuffer);
        this.ratingCriteria = e.b(byteBuffer);
        this.language = e.f(byteBuffer);
        this.ratingInfo = e.g(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(d.e(this.ratingEntity));
        byteBuffer.put(d.e(this.ratingCriteria));
        g.d(byteBuffer, this.language);
        byteBuffer.put(j.b(this.ratingInfo));
        byteBuffer.put((byte) 0);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)(j.c(this.ratingInfo) + 15);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getLanguage() {
        d.b().c(b.c(RatingBox.ajc$tjp_4, this, this));
        return this.language;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getRatingCriteria() {
        d.b().c(b.c(RatingBox.ajc$tjp_6, this, this));
        return this.ratingCriteria;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getRatingEntity() {
        d.b().c(b.c(RatingBox.ajc$tjp_5, this, this));
        return this.ratingEntity;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getRatingInfo() {
        d.b().c(b.c(RatingBox.ajc$tjp_7, this, this));
        return this.ratingInfo;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setLanguage(String str) {
        d.b().c(b.d(RatingBox.ajc$tjp_2, this, this, str));
        this.language = str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setRatingCriteria(String str) {
        d.b().c(b.d(RatingBox.ajc$tjp_1, this, this, str));
        this.ratingCriteria = str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setRatingEntity(String str) {
        d.b().c(b.d(RatingBox.ajc$tjp_0, this, this, str));
        this.ratingEntity = str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setRatingInfo(String str) {
        d.b().c(b.d(RatingBox.ajc$tjp_3, this, this, str));
        this.ratingInfo = str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(RatingBox.ajc$tjp_8, this, this));
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "RatingBox[language=";
        String language = getLanguage();
        String str3 = "ratingEntity=";
        String ratingEntity = getRatingEntity();
        String str4 = ";ratingCriteria=";
        String ratingCriteria = getRatingCriteria();
        String str5 = ";language=";
        String language2 = getLanguage();
        String str6 = ";ratingInfo=";
        String ratingInfo = getRatingInfo();
        String str7 = "]";
        str = str2 + language + str3 + ratingEntity + str4 + ratingCriteria + str5 + language2 + str6 + ratingInfo + str7;
        return str;
    }
}
