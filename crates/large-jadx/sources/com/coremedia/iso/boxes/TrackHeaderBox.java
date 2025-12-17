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
public class TrackHeaderBox extends AbstractFullBox {

    private static f LOG = null;
    public static final String TYPE = "tkhd";
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
    private static final a.a ajc$tjp_29;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    private static final a.a ajc$tjp_6;
    private static final a.a ajc$tjp_7;
    private static final a.a ajc$tjp_8;
    private static final a.a ajc$tjp_9;
    private int alternateGroup;
    private Date creationTime;
    private long duration;
    private double height;
    private int layer;
    private h matrix;
    private Date modificationTime;
    private long trackId;
    private float volume;
    private double width;
    static {
        TrackHeaderBox.ajc$preClinit();
        TrackHeaderBox.LOG = f.a(TrackHeaderBox.class);
    }

    public TrackHeaderBox() {
        super("tkhd");
        final int i = 0;
        Date date = new Date(i, obj2);
        this.creationTime = date;
        Date date2 = new Date(i, obj2);
        this.modificationTime = date2;
        this.matrix = h.j;
    }

    private static void ajc$preClinit() {
        b bVar31 = new b("TrackHeaderBox.java", TrackHeaderBox.class);
        final String str212 = "method-execution";
        TrackHeaderBox.ajc$tjp_0 = bVar31.h(str212, bVar31.g("1", "getCreationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "java.util.Date"), 62);
        TrackHeaderBox.ajc$tjp_1 = bVar31.h(str212, bVar31.g("1", "getModificationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "java.util.Date"), 66);
        TrackHeaderBox.ajc$tjp_10 = bVar31.h(str212, bVar31.g("1", "getContent", "com.coremedia.iso.boxes.TrackHeaderBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 145);
        TrackHeaderBox.ajc$tjp_11 = bVar31.h(str212, bVar31.g("1", "toString", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "java.lang.String"), 173);
        TrackHeaderBox.ajc$tjp_12 = bVar31.h(str212, bVar31.g("1", "setCreationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "java.util.Date", "creationTime", "", "void"), 199);
        TrackHeaderBox.ajc$tjp_13 = bVar31.h(str212, bVar31.g("1", "setModificationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "java.util.Date", "modificationTime", "", "void"), 206);
        TrackHeaderBox.ajc$tjp_14 = bVar31.h(str212, bVar31.g("1", "setTrackId", "com.coremedia.iso.boxes.TrackHeaderBox", "long", "trackId", "", "void"), 214);
        TrackHeaderBox.ajc$tjp_15 = bVar31.h(str212, bVar31.g("1", "setDuration", "com.coremedia.iso.boxes.TrackHeaderBox", "long", "duration", "", "void"), 218);
        TrackHeaderBox.ajc$tjp_16 = bVar31.h(str212, bVar31.g("1", "setLayer", "com.coremedia.iso.boxes.TrackHeaderBox", "int", "layer", "", "void"), 225);
        TrackHeaderBox.ajc$tjp_17 = bVar31.h(str212, bVar31.g("1", "setAlternateGroup", "com.coremedia.iso.boxes.TrackHeaderBox", "int", "alternateGroup", "", "void"), 229);
        TrackHeaderBox.ajc$tjp_18 = bVar31.h(str212, bVar31.g("1", "setVolume", "com.coremedia.iso.boxes.TrackHeaderBox", "float", "volume", "", "void"), 233);
        TrackHeaderBox.ajc$tjp_19 = bVar31.h(str212, bVar31.g("1", "setMatrix", "com.coremedia.iso.boxes.TrackHeaderBox", "com.googlecode.mp4parser.util.Matrix", "matrix", "", "void"), 237);
        TrackHeaderBox.ajc$tjp_2 = bVar31.h(str212, bVar31.g("1", "getTrackId", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "long"), 70);
        TrackHeaderBox.ajc$tjp_20 = bVar31.h(str212, bVar31.g("1", "setWidth", "com.coremedia.iso.boxes.TrackHeaderBox", "double", "width", "", "void"), 241);
        TrackHeaderBox.ajc$tjp_21 = bVar31.h(str212, bVar31.g("1", "setHeight", "com.coremedia.iso.boxes.TrackHeaderBox", "double", "height", "", "void"), 245);
        TrackHeaderBox.ajc$tjp_22 = bVar31.h(str212, bVar31.g("1", "isEnabled", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), 250);
        TrackHeaderBox.ajc$tjp_23 = bVar31.h(str212, bVar31.g("1", "isInMovie", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), 254);
        TrackHeaderBox.ajc$tjp_24 = bVar31.h(str212, bVar31.g("1", "isInPreview", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), 258);
        TrackHeaderBox.ajc$tjp_25 = bVar31.h(str212, bVar31.g("1", "isInPoster", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), 262);
        TrackHeaderBox.ajc$tjp_26 = bVar31.h(str212, bVar31.g("1", "setEnabled", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "enabled", "", "void"), 266);
        TrackHeaderBox.ajc$tjp_27 = bVar31.h(str212, bVar31.g("1", "setInMovie", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "inMovie", "", "void"), 274);
        TrackHeaderBox.ajc$tjp_28 = bVar31.h(str212, bVar31.g("1", "setInPreview", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "inPreview", "", "void"), 282);
        TrackHeaderBox.ajc$tjp_29 = bVar31.h(str212, bVar31.g("1", "setInPoster", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "inPoster", "", "void"), 290);
        TrackHeaderBox.ajc$tjp_3 = bVar31.h(str212, bVar31.g("1", "getDuration", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "long"), 74);
        TrackHeaderBox.ajc$tjp_4 = bVar31.h(str212, bVar31.g("1", "getLayer", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "int"), 78);
        TrackHeaderBox.ajc$tjp_5 = bVar31.h(str212, bVar31.g("1", "getAlternateGroup", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "int"), 82);
        TrackHeaderBox.ajc$tjp_6 = bVar31.h(str212, bVar31.g("1", "getVolume", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "float"), 86);
        TrackHeaderBox.ajc$tjp_7 = bVar31.h(str212, bVar31.g("1", "getMatrix", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "com.googlecode.mp4parser.util.Matrix"), 90);
        TrackHeaderBox.ajc$tjp_8 = bVar31.h(str212, bVar31.g("1", "getWidth", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "double"), 94);
        TrackHeaderBox.ajc$tjp_9 = bVar31.h(str212, bVar31.g("1", "getHeight", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "double"), 98);
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
            this.trackId = e.k(byteBuffer);
            e.k(byteBuffer);
            this.duration = byteBuffer.getLong();
        } else {
            this.creationTime = c.b(e.k(byteBuffer));
            this.modificationTime = c.b(e.k(byteBuffer));
            this.trackId = e.k(byteBuffer);
            e.k(byteBuffer);
            this.duration = (long)int;
        }
        if (Long.compare(duration, i3) < 0) {
            TrackHeaderBox.LOG.d("tkhd duration is not in expected range");
        }
        e.k(byteBuffer);
        e.k(byteBuffer);
        this.layer = e.i(byteBuffer);
        this.alternateGroup = e.i(byteBuffer);
        this.volume = e.e(byteBuffer);
        e.i(byteBuffer);
        this.matrix = h.a(byteBuffer);
        this.width = e.d(byteBuffer);
        this.height = e.d(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getAlternateGroup() {
        d.b().c(b.c(TrackHeaderBox.ajc$tjp_5, this, this));
        return this.alternateGroup;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void getContent(ByteBuffer byteBuffer) {
        Date modificationTime;
        long duration;
        d.b().c(b.d(TrackHeaderBox.ajc$tjp_10, this, this, byteBuffer));
        writeVersionAndFlags(byteBuffer);
        int i2 = 0;
        if (getVersion() == 1) {
            g.i(byteBuffer, c.a(this.creationTime));
            g.i(byteBuffer, c.a(this.modificationTime));
            g.g(byteBuffer, this.trackId);
            g.g(byteBuffer, i2);
            byteBuffer.putLong(this.duration);
        } else {
            g.g(byteBuffer, c.a(this.creationTime));
            g.g(byteBuffer, c.a(this.modificationTime));
            g.g(byteBuffer, this.trackId);
            g.g(byteBuffer, i2);
            byteBuffer.putInt((int)duration);
        }
        g.g(byteBuffer, i2);
        g.g(byteBuffer, i2);
        g.e(byteBuffer, this.layer);
        g.e(byteBuffer, this.alternateGroup);
        g.c(byteBuffer, (double)volume);
        g.e(byteBuffer, 0);
        this.matrix.c(byteBuffer);
        g.b(byteBuffer, this.width);
        g.b(byteBuffer, this.height);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i;
        i = getVersion() == 1 ? 36 : 24;
        return i += i4;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public Date getCreationTime() {
        d.b().c(b.c(TrackHeaderBox.ajc$tjp_0, this, this));
        return this.creationTime;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getDuration() {
        d.b().c(b.c(TrackHeaderBox.ajc$tjp_3, this, this));
        return this.duration;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public double getHeight() {
        d.b().c(b.c(TrackHeaderBox.ajc$tjp_9, this, this));
        return this.height;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getLayer() {
        d.b().c(b.c(TrackHeaderBox.ajc$tjp_4, this, this));
        return this.layer;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public h getMatrix() {
        d.b().c(b.c(TrackHeaderBox.ajc$tjp_7, this, this));
        return this.matrix;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public Date getModificationTime() {
        d.b().c(b.c(TrackHeaderBox.ajc$tjp_1, this, this));
        return this.modificationTime;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getTrackId() {
        d.b().c(b.c(TrackHeaderBox.ajc$tjp_2, this, this));
        return this.trackId;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public float getVolume() {
        d.b().c(b.c(TrackHeaderBox.ajc$tjp_6, this, this));
        return this.volume;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public double getWidth() {
        d.b().c(b.c(TrackHeaderBox.ajc$tjp_8, this, this));
        return this.width;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean isEnabled() {
        d.b().c(b.c(TrackHeaderBox.ajc$tjp_22, this, this));
        int i3 = 1;
        if (flags &= i3 > 0) {
            return i3;
        }
        return 0;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean isInMovie() {
        d.b().c(b.c(TrackHeaderBox.ajc$tjp_23, this, this));
        if (flags &= 2 > 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean isInPoster() {
        d.b().c(b.c(TrackHeaderBox.ajc$tjp_25, this, this));
        if (flags &= 8 > 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean isInPreview() {
        d.b().c(b.c(TrackHeaderBox.ajc$tjp_24, this, this));
        if (flags &= 4 > 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setAlternateGroup(int i) {
        d.b().c(b.d(TrackHeaderBox.ajc$tjp_17, this, this, a.e(i)));
        this.alternateGroup = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setCreationTime(Date date) {
        int obj5;
        d.b().c(b.d(TrackHeaderBox.ajc$tjp_12, this, this, date));
        this.creationTime = date;
        if (Long.compare(l, l2) >= 0) {
            setVersion(1);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setDuration(long l) {
        int obj3;
        d.b().c(b.d(TrackHeaderBox.ajc$tjp_15, this, this, a.f(l)));
        this.duration = l;
        if (Long.compare(l, l2) >= 0) {
            setFlags(1);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setEnabled(boolean z) {
        int obj3;
        d.b().c(b.d(TrackHeaderBox.ajc$tjp_26, this, this, a.a(z)));
        if (z) {
            setFlags(obj3 |= 1);
        } else {
            setFlags(obj3 &= -2);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setHeight(double d) {
        d.b().c(b.d(TrackHeaderBox.ajc$tjp_21, this, this, a.c(d)));
        this.height = d;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setInMovie(boolean z) {
        int obj3;
        d.b().c(b.d(TrackHeaderBox.ajc$tjp_27, this, this, a.a(z)));
        if (z) {
            setFlags(obj3 |= 2);
        } else {
            setFlags(obj3 &= -3);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setInPoster(boolean z) {
        int obj3;
        d.b().c(b.d(TrackHeaderBox.ajc$tjp_29, this, this, a.a(z)));
        if (z) {
            setFlags(obj3 |= 8);
        } else {
            setFlags(obj3 &= -9);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setInPreview(boolean z) {
        int obj3;
        d.b().c(b.d(TrackHeaderBox.ajc$tjp_28, this, this, a.a(z)));
        if (z) {
            setFlags(obj3 |= 4);
        } else {
            setFlags(obj3 &= -5);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setLayer(int i) {
        d.b().c(b.d(TrackHeaderBox.ajc$tjp_16, this, this, a.e(i)));
        this.layer = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setMatrix(h h) {
        d.b().c(b.d(TrackHeaderBox.ajc$tjp_19, this, this, h));
        this.matrix = h;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setModificationTime(Date date) {
        int obj5;
        d.b().c(b.d(TrackHeaderBox.ajc$tjp_13, this, this, date));
        this.modificationTime = date;
        if (Long.compare(l, l2) >= 0) {
            setVersion(1);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setTrackId(long l) {
        d.b().c(b.d(TrackHeaderBox.ajc$tjp_14, this, this, a.f(l)));
        this.trackId = l;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setVolume(float f) {
        d.b().c(b.d(TrackHeaderBox.ajc$tjp_18, this, this, a.d(f)));
        this.volume = f;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setWidth(double d) {
        d.b().c(b.d(TrackHeaderBox.ajc$tjp_20, this, this, a.c(d)));
        this.width = d;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(TrackHeaderBox.ajc$tjp_11, this, this));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrackHeaderBox[");
        stringBuilder.append("creationTime=");
        stringBuilder.append(getCreationTime());
        String str3 = ";";
        stringBuilder.append(str3);
        stringBuilder.append("modificationTime=");
        stringBuilder.append(getModificationTime());
        stringBuilder.append(str3);
        stringBuilder.append("trackId=");
        stringBuilder.append(getTrackId());
        stringBuilder.append(str3);
        stringBuilder.append("duration=");
        stringBuilder.append(getDuration());
        stringBuilder.append(str3);
        stringBuilder.append("layer=");
        stringBuilder.append(getLayer());
        stringBuilder.append(str3);
        stringBuilder.append("alternateGroup=");
        stringBuilder.append(getAlternateGroup());
        stringBuilder.append(str3);
        stringBuilder.append("volume=");
        stringBuilder.append(getVolume());
        stringBuilder.append(str3);
        stringBuilder.append("matrix=");
        stringBuilder.append(this.matrix);
        stringBuilder.append(str3);
        stringBuilder.append("width=");
        double width = getWidth();
        stringBuilder.append(width);
        stringBuilder.append(str3);
        stringBuilder.append("height=");
        stringBuilder.append(getHeight());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
