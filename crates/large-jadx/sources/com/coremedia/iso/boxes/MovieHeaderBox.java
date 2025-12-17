package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import com.googlecode.mp4parser.h.c;
import com.googlecode.mp4parser.h.f;
import com.googlecode.mp4parser.h.h;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.Date;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class MovieHeaderBox extends AbstractFullBox {

    private static f LOG = null;
    public static final String TYPE = "mvhd";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_10;
    private static final a.a ajc$tjp_11;
    private static final a.a ajc$tjp_12;
    private static final a.a ajc$tjp_13;
    private static final a.a ajc$tjp_14;
    private static final a.a ajc$tjp_15;
    private static final a.a ajc$tjp_16;
    private static final a.a ajc$tjp_17;
    private static final a.a ajc$tjp_18;
    private static final a.a ajc$tjp_19;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_20;
    private static final a.a ajc$tjp_21;
    private static final a.a ajc$tjp_22;
    private static final a.a ajc$tjp_23;
    private static final a.a ajc$tjp_24;
    private static final a.a ajc$tjp_25;
    private static final a.a ajc$tjp_26;
    private static final a.a ajc$tjp_27;
    private static final a.a ajc$tjp_28;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    private static final a.a ajc$tjp_6;
    private static final a.a ajc$tjp_7;
    private static final a.a ajc$tjp_8;
    private static final a.a ajc$tjp_9;
    private Date creationTime;
    private int currentTime;
    private long duration;
    private h matrix = 1065353216;
    private Date modificationTime;
    private long nextTrackId;
    private int posterTime;
    private int previewDuration;
    private int previewTime;
    private double rate = 1d;
    private int selectionDuration;
    private int selectionTime;
    private long timescale;
    private float volume = 1f;
    static {
        MovieHeaderBox.ajc$preClinit();
        MovieHeaderBox.LOG = f.a(MovieHeaderBox.class);
    }

    public MovieHeaderBox() {
        super("mvhd");
        long l = 4607182418800017408L;
        int i = 1065353216;
        h hVar = h.j;
    }

    private static void ajc$preClinit() {
        b bVar30 = new b("MovieHeaderBox.java", MovieHeaderBox.class);
        final String str205 = "method-execution";
        MovieHeaderBox.ajc$tjp_0 = bVar30.h(str205, bVar30.g("1", "getCreationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "java.util.Date"), 66);
        MovieHeaderBox.ajc$tjp_1 = bVar30.h(str205, bVar30.g("1", "getModificationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "java.util.Date"), 70);
        MovieHeaderBox.ajc$tjp_10 = bVar30.h(str205, bVar30.g("1", "setModificationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "java.util.Date", "modificationTime", "", "void"), 212);
        MovieHeaderBox.ajc$tjp_11 = bVar30.h(str205, bVar30.g("1", "setTimescale", "com.coremedia.iso.boxes.MovieHeaderBox", "long", "timescale", "", "void"), 220);
        MovieHeaderBox.ajc$tjp_12 = bVar30.h(str205, bVar30.g("1", "setDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "long", "duration", "", "void"), 224);
        MovieHeaderBox.ajc$tjp_13 = bVar30.h(str205, bVar30.g("1", "setRate", "com.coremedia.iso.boxes.MovieHeaderBox", "double", "rate", "", "void"), 231);
        MovieHeaderBox.ajc$tjp_14 = bVar30.h(str205, bVar30.g("1", "setVolume", "com.coremedia.iso.boxes.MovieHeaderBox", "float", "volume", "", "void"), 235);
        MovieHeaderBox.ajc$tjp_15 = bVar30.h(str205, bVar30.g("1", "setMatrix", "com.coremedia.iso.boxes.MovieHeaderBox", "com.googlecode.mp4parser.util.Matrix", "matrix", "", "void"), 239);
        MovieHeaderBox.ajc$tjp_16 = bVar30.h(str205, bVar30.g("1", "setNextTrackId", "com.coremedia.iso.boxes.MovieHeaderBox", "long", "nextTrackId", "", "void"), 243);
        MovieHeaderBox.ajc$tjp_17 = bVar30.h(str205, bVar30.g("1", "getPreviewTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 247);
        MovieHeaderBox.ajc$tjp_18 = bVar30.h(str205, bVar30.g("1", "setPreviewTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "previewTime", "", "void"), 251);
        MovieHeaderBox.ajc$tjp_19 = bVar30.h(str205, bVar30.g("1", "getPreviewDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 255);
        MovieHeaderBox.ajc$tjp_2 = bVar30.h(str205, bVar30.g("1", "getTimescale", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "long"), 74);
        MovieHeaderBox.ajc$tjp_20 = bVar30.h(str205, bVar30.g("1", "setPreviewDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "previewDuration", "", "void"), 259);
        MovieHeaderBox.ajc$tjp_21 = bVar30.h(str205, bVar30.g("1", "getPosterTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 263);
        MovieHeaderBox.ajc$tjp_22 = bVar30.h(str205, bVar30.g("1", "setPosterTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "posterTime", "", "void"), 267);
        MovieHeaderBox.ajc$tjp_23 = bVar30.h(str205, bVar30.g("1", "getSelectionTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 271);
        MovieHeaderBox.ajc$tjp_24 = bVar30.h(str205, bVar30.g("1", "setSelectionTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "selectionTime", "", "void"), 275);
        MovieHeaderBox.ajc$tjp_25 = bVar30.h(str205, bVar30.g("1", "getSelectionDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 279);
        MovieHeaderBox.ajc$tjp_26 = bVar30.h(str205, bVar30.g("1", "setSelectionDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "selectionDuration", "", "void"), 283);
        MovieHeaderBox.ajc$tjp_27 = bVar30.h(str205, bVar30.g("1", "getCurrentTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 287);
        MovieHeaderBox.ajc$tjp_28 = bVar30.h(str205, bVar30.g("1", "setCurrentTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "currentTime", "", "void"), 291);
        MovieHeaderBox.ajc$tjp_3 = bVar30.h(str205, bVar30.g("1", "getDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "long"), 78);
        MovieHeaderBox.ajc$tjp_4 = bVar30.h(str205, bVar30.g("1", "getRate", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "double"), 82);
        MovieHeaderBox.ajc$tjp_5 = bVar30.h(str205, bVar30.g("1", "getVolume", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "float"), 86);
        MovieHeaderBox.ajc$tjp_6 = bVar30.h(str205, bVar30.g("1", "getMatrix", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "com.googlecode.mp4parser.util.Matrix"), 90);
        MovieHeaderBox.ajc$tjp_7 = bVar30.h(str205, bVar30.g("1", "getNextTrackId", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "long"), 94);
        MovieHeaderBox.ajc$tjp_8 = bVar30.h(str205, bVar30.g("1", "toString", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "java.lang.String"), 148);
        MovieHeaderBox.ajc$tjp_9 = bVar30.h(str205, bVar30.g("1", "setCreationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "java.util.Date", "creationTime", "", "void"), 204);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        long long;
        int lOG;
        int str;
        parseVersionAndFlags(byteBuffer);
        str = 1;
        if (getVersion() == str) {
            this.creationTime = c.b(e.m(byteBuffer));
            this.modificationTime = c.b(e.m(byteBuffer));
            this.timescale = e.k(byteBuffer);
            this.duration = byteBuffer.getLong();
        } else {
            this.creationTime = c.b(e.k(byteBuffer));
            this.modificationTime = c.b(e.k(byteBuffer));
            this.timescale = e.k(byteBuffer);
            this.duration = (long)int7;
        }
        if (Long.compare(duration, i) < 0) {
            MovieHeaderBox.LOG.d("mvhd duration is not in expected range");
        }
        this.rate = e.d(byteBuffer);
        this.volume = e.e(byteBuffer);
        e.i(byteBuffer);
        e.k(byteBuffer);
        e.k(byteBuffer);
        this.matrix = h.a(byteBuffer);
        this.previewTime = byteBuffer.getInt();
        this.previewDuration = byteBuffer.getInt();
        this.posterTime = byteBuffer.getInt();
        this.selectionTime = byteBuffer.getInt();
        this.selectionDuration = byteBuffer.getInt();
        this.currentTime = byteBuffer.getInt();
        this.nextTrackId = e.k(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        long duration;
        writeVersionAndFlags(byteBuffer);
        final int i3 = 1;
        if (getVersion() == i3) {
            g.i(byteBuffer, c.a(this.creationTime));
            g.i(byteBuffer, c.a(this.modificationTime));
            g.g(byteBuffer, this.timescale);
            byteBuffer.putLong(this.duration);
        } else {
            g.g(byteBuffer, c.a(this.creationTime));
            g.g(byteBuffer, c.a(this.modificationTime));
            g.g(byteBuffer, this.timescale);
            byteBuffer.putInt((int)duration2);
        }
        g.b(byteBuffer, this.rate);
        g.c(byteBuffer, (double)volume);
        g.e(byteBuffer, 0);
        int i2 = 0;
        g.g(byteBuffer, i2);
        g.g(byteBuffer, i2);
        this.matrix.c(byteBuffer);
        byteBuffer.putInt(this.previewTime);
        byteBuffer.putInt(this.previewDuration);
        byteBuffer.putInt(this.posterTime);
        byteBuffer.putInt(this.selectionTime);
        byteBuffer.putInt(this.selectionDuration);
        byteBuffer.putInt(this.currentTime);
        g.g(byteBuffer, this.nextTrackId);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i;
        i = getVersion() == 1 ? 32 : 20;
        return i += i4;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public Date getCreationTime() {
        d.b().c(b.c(MovieHeaderBox.ajc$tjp_0, this, this));
        return this.creationTime;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getCurrentTime() {
        d.b().c(b.c(MovieHeaderBox.ajc$tjp_27, this, this));
        return this.currentTime;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getDuration() {
        d.b().c(b.c(MovieHeaderBox.ajc$tjp_3, this, this));
        return this.duration;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public h getMatrix() {
        d.b().c(b.c(MovieHeaderBox.ajc$tjp_6, this, this));
        return this.matrix;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public Date getModificationTime() {
        d.b().c(b.c(MovieHeaderBox.ajc$tjp_1, this, this));
        return this.modificationTime;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getNextTrackId() {
        d.b().c(b.c(MovieHeaderBox.ajc$tjp_7, this, this));
        return this.nextTrackId;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getPosterTime() {
        d.b().c(b.c(MovieHeaderBox.ajc$tjp_21, this, this));
        return this.posterTime;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getPreviewDuration() {
        d.b().c(b.c(MovieHeaderBox.ajc$tjp_19, this, this));
        return this.previewDuration;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getPreviewTime() {
        d.b().c(b.c(MovieHeaderBox.ajc$tjp_17, this, this));
        return this.previewTime;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public double getRate() {
        d.b().c(b.c(MovieHeaderBox.ajc$tjp_4, this, this));
        return this.rate;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getSelectionDuration() {
        d.b().c(b.c(MovieHeaderBox.ajc$tjp_25, this, this));
        return this.selectionDuration;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getSelectionTime() {
        d.b().c(b.c(MovieHeaderBox.ajc$tjp_23, this, this));
        return this.selectionTime;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getTimescale() {
        d.b().c(b.c(MovieHeaderBox.ajc$tjp_2, this, this));
        return this.timescale;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public float getVolume() {
        d.b().c(b.c(MovieHeaderBox.ajc$tjp_5, this, this));
        return this.volume;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setCreationTime(Date date) {
        int obj5;
        d.b().c(b.d(MovieHeaderBox.ajc$tjp_9, this, this, date));
        this.creationTime = date;
        if (Long.compare(l, l2) >= 0) {
            setVersion(1);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setCurrentTime(int i) {
        d.b().c(b.d(MovieHeaderBox.ajc$tjp_28, this, this, a.e(i)));
        this.currentTime = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setDuration(long l) {
        int obj3;
        d.b().c(b.d(MovieHeaderBox.ajc$tjp_12, this, this, a.f(l)));
        this.duration = l;
        if (Long.compare(l, l2) >= 0) {
            setVersion(1);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setMatrix(h h) {
        d.b().c(b.d(MovieHeaderBox.ajc$tjp_15, this, this, h));
        this.matrix = h;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setModificationTime(Date date) {
        int obj5;
        d.b().c(b.d(MovieHeaderBox.ajc$tjp_10, this, this, date));
        this.modificationTime = date;
        if (Long.compare(l, l2) >= 0) {
            setVersion(1);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setNextTrackId(long l) {
        d.b().c(b.d(MovieHeaderBox.ajc$tjp_16, this, this, a.f(l)));
        this.nextTrackId = l;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setPosterTime(int i) {
        d.b().c(b.d(MovieHeaderBox.ajc$tjp_22, this, this, a.e(i)));
        this.posterTime = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setPreviewDuration(int i) {
        d.b().c(b.d(MovieHeaderBox.ajc$tjp_20, this, this, a.e(i)));
        this.previewDuration = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setPreviewTime(int i) {
        d.b().c(b.d(MovieHeaderBox.ajc$tjp_18, this, this, a.e(i)));
        this.previewTime = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setRate(double d) {
        d.b().c(b.d(MovieHeaderBox.ajc$tjp_13, this, this, a.c(d)));
        this.rate = d;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setSelectionDuration(int i) {
        d.b().c(b.d(MovieHeaderBox.ajc$tjp_26, this, this, a.e(i)));
        this.selectionDuration = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setSelectionTime(int i) {
        d.b().c(b.d(MovieHeaderBox.ajc$tjp_24, this, this, a.e(i)));
        this.selectionTime = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setTimescale(long l) {
        d.b().c(b.d(MovieHeaderBox.ajc$tjp_11, this, this, a.f(l)));
        this.timescale = l;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setVolume(float f) {
        d.b().c(b.d(MovieHeaderBox.ajc$tjp_14, this, this, a.d(f)));
        this.volume = f;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(MovieHeaderBox.ajc$tjp_8, this, this));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MovieHeaderBox[");
        stringBuilder.append("creationTime=");
        stringBuilder.append(getCreationTime());
        String str3 = ";";
        stringBuilder.append(str3);
        stringBuilder.append("modificationTime=");
        stringBuilder.append(getModificationTime());
        stringBuilder.append(str3);
        stringBuilder.append("timescale=");
        stringBuilder.append(getTimescale());
        stringBuilder.append(str3);
        stringBuilder.append("duration=");
        stringBuilder.append(getDuration());
        stringBuilder.append(str3);
        stringBuilder.append("rate=");
        stringBuilder.append(getRate());
        stringBuilder.append(str3);
        stringBuilder.append("volume=");
        stringBuilder.append(getVolume());
        stringBuilder.append(str3);
        stringBuilder.append("matrix=");
        h matrix = this.matrix;
        stringBuilder.append(matrix);
        stringBuilder.append(str3);
        stringBuilder.append("nextTrackId=");
        stringBuilder.append(getNextTrackId());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
