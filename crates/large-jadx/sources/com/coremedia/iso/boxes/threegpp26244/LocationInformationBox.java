package com.coremedia.iso.boxes.threegpp26244;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import f.b.a.j;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class LocationInformationBox extends AbstractFullBox {

    public static final String TYPE = "loci";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_10;
    private static final a.a ajc$tjp_11;
    private static final a.a ajc$tjp_12;
    private static final a.a ajc$tjp_13;
    private static final a.a ajc$tjp_14;
    private static final a.a ajc$tjp_15;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    private static final a.a ajc$tjp_6;
    private static final a.a ajc$tjp_7;
    private static final a.a ajc$tjp_8;
    private static final a.a ajc$tjp_9;
    private String additionalNotes;
    private double altitude;
    private String astronomicalBody;
    private String language;
    private double latitude;
    private double longitude;
    private String name;
    private int role;
    static {
        LocationInformationBox.ajc$preClinit();
    }

    public LocationInformationBox() {
        super("loci");
        String str2 = "";
        this.name = str2;
        this.astronomicalBody = str2;
        this.additionalNotes = str2;
    }

    private static void ajc$preClinit() {
        b bVar17 = new b("LocationInformationBox.java", LocationInformationBox.class);
        final String str114 = "method-execution";
        LocationInformationBox.ajc$tjp_0 = bVar17.h(str114, bVar17.g("1", "getLanguage", "com.coremedia.iso.boxes.threegpp26244.LocationInformationBox", "", "", "", "java.lang.String"), 30);
        LocationInformationBox.ajc$tjp_1 = bVar17.h(str114, bVar17.g("1", "setLanguage", "com.coremedia.iso.boxes.threegpp26244.LocationInformationBox", "java.lang.String", "language", "", "void"), 34);
        LocationInformationBox.ajc$tjp_10 = bVar17.h(str114, bVar17.g("1", "getAltitude", "com.coremedia.iso.boxes.threegpp26244.LocationInformationBox", "", "", "", "double"), 70);
        LocationInformationBox.ajc$tjp_11 = bVar17.h(str114, bVar17.g("1", "setAltitude", "com.coremedia.iso.boxes.threegpp26244.LocationInformationBox", "double", "altitude", "", "void"), 74);
        LocationInformationBox.ajc$tjp_12 = bVar17.h(str114, bVar17.g("1", "getAstronomicalBody", "com.coremedia.iso.boxes.threegpp26244.LocationInformationBox", "", "", "", "java.lang.String"), 78);
        LocationInformationBox.ajc$tjp_13 = bVar17.h(str114, bVar17.g("1", "setAstronomicalBody", "com.coremedia.iso.boxes.threegpp26244.LocationInformationBox", "java.lang.String", "astronomicalBody", "", "void"), 82);
        LocationInformationBox.ajc$tjp_14 = bVar17.h(str114, bVar17.g("1", "getAdditionalNotes", "com.coremedia.iso.boxes.threegpp26244.LocationInformationBox", "", "", "", "java.lang.String"), 86);
        LocationInformationBox.ajc$tjp_15 = bVar17.h(str114, bVar17.g("1", "setAdditionalNotes", "com.coremedia.iso.boxes.threegpp26244.LocationInformationBox", "java.lang.String", "additionalNotes", "", "void"), 90);
        LocationInformationBox.ajc$tjp_2 = bVar17.h(str114, bVar17.g("1", "getName", "com.coremedia.iso.boxes.threegpp26244.LocationInformationBox", "", "", "", "java.lang.String"), 38);
        LocationInformationBox.ajc$tjp_3 = bVar17.h(str114, bVar17.g("1", "setName", "com.coremedia.iso.boxes.threegpp26244.LocationInformationBox", "java.lang.String", "name", "", "void"), 42);
        LocationInformationBox.ajc$tjp_4 = bVar17.h(str114, bVar17.g("1", "getRole", "com.coremedia.iso.boxes.threegpp26244.LocationInformationBox", "", "", "", "int"), 46);
        LocationInformationBox.ajc$tjp_5 = bVar17.h(str114, bVar17.g("1", "setRole", "com.coremedia.iso.boxes.threegpp26244.LocationInformationBox", "int", "role", "", "void"), 50);
        LocationInformationBox.ajc$tjp_6 = bVar17.h(str114, bVar17.g("1", "getLongitude", "com.coremedia.iso.boxes.threegpp26244.LocationInformationBox", "", "", "", "double"), 54);
        LocationInformationBox.ajc$tjp_7 = bVar17.h(str114, bVar17.g("1", "setLongitude", "com.coremedia.iso.boxes.threegpp26244.LocationInformationBox", "double", "longitude", "", "void"), 58);
        LocationInformationBox.ajc$tjp_8 = bVar17.h(str114, bVar17.g("1", "getLatitude", "com.coremedia.iso.boxes.threegpp26244.LocationInformationBox", "", "", "", "double"), 62);
        LocationInformationBox.ajc$tjp_9 = bVar17.h(str114, bVar17.g("1", "setLatitude", "com.coremedia.iso.boxes.threegpp26244.LocationInformationBox", "double", "latitude", "", "void"), 66);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.language = e.f(byteBuffer);
        this.name = e.g(byteBuffer);
        this.role = e.n(byteBuffer);
        this.longitude = e.d(byteBuffer);
        this.latitude = e.d(byteBuffer);
        this.altitude = e.d(byteBuffer);
        this.astronomicalBody = e.g(byteBuffer);
        this.additionalNotes = e.g(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getAdditionalNotes() {
        d.b().c(b.c(LocationInformationBox.ajc$tjp_14, this, this));
        return this.additionalNotes;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public double getAltitude() {
        d.b().c(b.c(LocationInformationBox.ajc$tjp_10, this, this));
        return this.altitude;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getAstronomicalBody() {
        d.b().c(b.c(LocationInformationBox.ajc$tjp_12, this, this));
        return this.astronomicalBody;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        g.d(byteBuffer, this.language);
        byteBuffer.put(j.b(this.name));
        int i = 0;
        byteBuffer.put(i);
        g.j(byteBuffer, this.role);
        g.b(byteBuffer, this.longitude);
        g.b(byteBuffer, this.latitude);
        g.b(byteBuffer, this.altitude);
        byteBuffer.put(j.b(this.astronomicalBody));
        byteBuffer.put(i);
        byteBuffer.put(j.b(this.additionalNotes));
        byteBuffer.put(i);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)i3;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getLanguage() {
        d.b().c(b.c(LocationInformationBox.ajc$tjp_0, this, this));
        return this.language;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public double getLatitude() {
        d.b().c(b.c(LocationInformationBox.ajc$tjp_8, this, this));
        return this.latitude;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public double getLongitude() {
        d.b().c(b.c(LocationInformationBox.ajc$tjp_6, this, this));
        return this.longitude;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getName() {
        d.b().c(b.c(LocationInformationBox.ajc$tjp_2, this, this));
        return this.name;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getRole() {
        d.b().c(b.c(LocationInformationBox.ajc$tjp_4, this, this));
        return this.role;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setAdditionalNotes(String string) {
        d.b().c(b.d(LocationInformationBox.ajc$tjp_15, this, this, string));
        this.additionalNotes = string;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setAltitude(double d) {
        d.b().c(b.d(LocationInformationBox.ajc$tjp_11, this, this, a.c(d)));
        this.altitude = d;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setAstronomicalBody(String string) {
        d.b().c(b.d(LocationInformationBox.ajc$tjp_13, this, this, string));
        this.astronomicalBody = string;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setLanguage(String string) {
        d.b().c(b.d(LocationInformationBox.ajc$tjp_1, this, this, string));
        this.language = string;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setLatitude(double d) {
        d.b().c(b.d(LocationInformationBox.ajc$tjp_9, this, this, a.c(d)));
        this.latitude = d;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setLongitude(double d) {
        d.b().c(b.d(LocationInformationBox.ajc$tjp_7, this, this, a.c(d)));
        this.longitude = d;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setName(String string) {
        d.b().c(b.d(LocationInformationBox.ajc$tjp_3, this, this, string));
        this.name = string;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setRole(int i) {
        d.b().c(b.d(LocationInformationBox.ajc$tjp_5, this, this, a.e(i)));
        this.role = i;
    }
}
