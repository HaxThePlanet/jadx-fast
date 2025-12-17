package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import com.googlecode.mp4parser.h.c;
import com.googlecode.mp4parser.h.f;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.Date;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class MediaHeaderBox extends AbstractFullBox {

    private static f LOG = null;
    public static final String TYPE = "mdhd";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_10;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    private static final a.a ajc$tjp_6;
    private static final a.a ajc$tjp_7;
    private static final a.a ajc$tjp_8;
    private static final a.a ajc$tjp_9;
    private Date creationTime;
    private long duration;
    private String language;
    private Date modificationTime;
    private long timescale;
    static {
        MediaHeaderBox.ajc$preClinit();
        MediaHeaderBox.LOG = f.a(MediaHeaderBox.class);
    }

    public MediaHeaderBox() {
        super("mdhd");
        Date date = new Date();
        this.creationTime = date;
        Date date2 = new Date();
        this.modificationTime = date2;
        this.language = "eng";
    }

    private static void ajc$preClinit() {
        b bVar12 = new b("MediaHeaderBox.java", MediaHeaderBox.class);
        final String str79 = "method-execution";
        MediaHeaderBox.ajc$tjp_0 = bVar12.h(str79, bVar12.g("1", "getCreationTime", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.util.Date"), 48);
        MediaHeaderBox.ajc$tjp_1 = bVar12.h(str79, bVar12.g("1", "getModificationTime", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.util.Date"), 52);
        MediaHeaderBox.ajc$tjp_10 = bVar12.h(str79, bVar12.g("1", "toString", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.lang.String"), 125);
        MediaHeaderBox.ajc$tjp_2 = bVar12.h(str79, bVar12.g("1", "getTimescale", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "long"), 56);
        MediaHeaderBox.ajc$tjp_3 = bVar12.h(str79, bVar12.g("1", "getDuration", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "long"), 60);
        MediaHeaderBox.ajc$tjp_4 = bVar12.h(str79, bVar12.g("1", "getLanguage", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.lang.String"), 64);
        MediaHeaderBox.ajc$tjp_5 = bVar12.h(str79, bVar12.g("1", "setCreationTime", "com.coremedia.iso.boxes.MediaHeaderBox", "java.util.Date", "creationTime", "", "void"), 81);
        MediaHeaderBox.ajc$tjp_6 = bVar12.h(str79, bVar12.g("1", "setModificationTime", "com.coremedia.iso.boxes.MediaHeaderBox", "java.util.Date", "modificationTime", "", "void"), 85);
        MediaHeaderBox.ajc$tjp_7 = bVar12.h(str79, bVar12.g("1", "setTimescale", "com.coremedia.iso.boxes.MediaHeaderBox", "long", "timescale", "", "void"), 89);
        MediaHeaderBox.ajc$tjp_8 = bVar12.h(str79, bVar12.g("1", "setDuration", "com.coremedia.iso.boxes.MediaHeaderBox", "long", "duration", "", "void"), 93);
        MediaHeaderBox.ajc$tjp_9 = bVar12.h(str79, bVar12.g("1", "setLanguage", "com.coremedia.iso.boxes.MediaHeaderBox", "java.lang.String", "language", "", "void"), 97);
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
            this.duration = e.k(byteBuffer);
        }
        if (Long.compare(duration, i) < 0) {
            MediaHeaderBox.LOG.d("mdhd duration is not in expected range");
        }
        this.language = e.f(byteBuffer);
        e.i(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        long duration;
        writeVersionAndFlags(byteBuffer);
        final int i2 = 1;
        if (getVersion() == i2) {
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
        g.d(byteBuffer, this.language);
        g.e(byteBuffer, 0);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i;
        i = getVersion() == 1 ? 32 : 20;
        final int i5 = 2;
        return i2 += i5;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public Date getCreationTime() {
        d.b().c(b.c(MediaHeaderBox.ajc$tjp_0, this, this));
        return this.creationTime;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getDuration() {
        d.b().c(b.c(MediaHeaderBox.ajc$tjp_3, this, this));
        return this.duration;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getLanguage() {
        d.b().c(b.c(MediaHeaderBox.ajc$tjp_4, this, this));
        return this.language;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public Date getModificationTime() {
        d.b().c(b.c(MediaHeaderBox.ajc$tjp_1, this, this));
        return this.modificationTime;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getTimescale() {
        d.b().c(b.c(MediaHeaderBox.ajc$tjp_2, this, this));
        return this.timescale;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setCreationTime(Date date) {
        d.b().c(b.d(MediaHeaderBox.ajc$tjp_5, this, this, date));
        this.creationTime = date;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setDuration(long l) {
        d.b().c(b.d(MediaHeaderBox.ajc$tjp_8, this, this, a.f(l)));
        this.duration = l;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setLanguage(String string) {
        d.b().c(b.d(MediaHeaderBox.ajc$tjp_9, this, this, string));
        this.language = string;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setModificationTime(Date date) {
        d.b().c(b.d(MediaHeaderBox.ajc$tjp_6, this, this, date));
        this.modificationTime = date;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setTimescale(long l) {
        d.b().c(b.d(MediaHeaderBox.ajc$tjp_7, this, this, a.f(l)));
        this.timescale = l;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(MediaHeaderBox.ajc$tjp_10, this, this));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MediaHeaderBox[");
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
        stringBuilder.append("language=");
        stringBuilder.append(getLanguage());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
