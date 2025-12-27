package com.googlecode.mp4parser.boxes.apple;

import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.j;
import java.nio.ByteBuffer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: AppleRecordingYearBox.java */
/* loaded from: classes2.dex */
public class AppleRecordingYearBox extends AppleDataBox {

    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    Date date = new Date();
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ssZ");
    static {
        AppleRecordingYearBox.ajc$preClinit();
    }

    public AppleRecordingYearBox() {
        super("©day", 1);
        Date date = new Date();
        new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ssZ").setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("AppleRecordingYearBox.java", AppleRecordingYearBox.class);
        final String str16 = "method-execution";
        AppleRecordingYearBox.ajc$tjp_0 = bVar.h(str16, bVar.g("1", "getDate", "com.googlecode.mp4parser.boxes.apple.AppleRecordingYearBox", "", "", "", "java.util.Date"), 27);
        AppleRecordingYearBox.ajc$tjp_1 = bVar.h(str16, bVar.g("1", "setDate", "com.googlecode.mp4parser.boxes.apple.AppleRecordingYearBox", "java.util.Date", "date", "", "void"), 31);
    }

    protected static String iso8601toRfc822Date(String str) {
        return str.replaceAll("Z$", "+0000").replaceAll("([0-9][0-9]):([0-9][0-9])$", "$1$2");
    }

    protected static String rfc822toIso8601Date(String str) {
        return str.replaceAll("\\+0000$", "Z");
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    protected int getDataLength() {
        return j.b(AppleRecordingYearBox.rfc822toIso8601Date(this.df.format(this.date))).length;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    public Date getDate() {
        d.b().c(b.c(AppleRecordingYearBox.ajc$tjp_0, this, this));
        return this.date;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    protected void parseData(ByteBuffer byteBuffer) {
        try {
            this.date = this.df.parse(AppleRecordingYearBox.iso8601toRfc822Date(e.h(byteBuffer, byteBuffer.remaining())));
        } catch (java.text.ParseException parse) {
            throw new RuntimeException(parse);
        }
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    public void setDate(Date date) {
        d.b().c(b.d(AppleRecordingYearBox.ajc$tjp_1, this, this, date));
        this.date = date;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    protected byte[] writeData() {
        return j.b(AppleRecordingYearBox.rfc822toIso8601Date(this.df.format(this.date)));
    }
}
