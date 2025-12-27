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

/* compiled from: TrackHeaderBox.java */
/* loaded from: classes.dex */
public class TrackHeaderBox extends AbstractFullBox {

    private static f LOG = null;
    public static final String TYPE = "tkhd";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_10;
    private static final /* synthetic */ a.a ajc$tjp_11;
    private static final /* synthetic */ a.a ajc$tjp_12;
    private static final /* synthetic */ a.a ajc$tjp_13;
    private static final /* synthetic */ a.a ajc$tjp_14;
    private static final /* synthetic */ a.a ajc$tjp_15;
    private static final /* synthetic */ a.a ajc$tjp_16;
    private static final /* synthetic */ a.a ajc$tjp_17;
    private static final /* synthetic */ a.a ajc$tjp_18;
    private static final /* synthetic */ a.a ajc$tjp_19;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_20;
    private static final /* synthetic */ a.a ajc$tjp_21;
    private static final /* synthetic */ a.a ajc$tjp_22;
    private static final /* synthetic */ a.a ajc$tjp_23;
    private static final /* synthetic */ a.a ajc$tjp_24;
    private static final /* synthetic */ a.a ajc$tjp_25;
    private static final /* synthetic */ a.a ajc$tjp_26;
    private static final /* synthetic */ a.a ajc$tjp_27;
    private static final /* synthetic */ a.a ajc$tjp_28;
    private static final /* synthetic */ a.a ajc$tjp_29;
    private static final /* synthetic */ a.a ajc$tjp_3;
    private static final /* synthetic */ a.a ajc$tjp_4;
    private static final /* synthetic */ a.a ajc$tjp_5;
    private static final /* synthetic */ a.a ajc$tjp_6;
    private static final /* synthetic */ a.a ajc$tjp_7;
    private static final /* synthetic */ a.a ajc$tjp_8;
    private static final /* synthetic */ a.a ajc$tjp_9;
    private int alternateGroup;
    private Date creationTime = new Date();
    private long duration;
    private double height;
    private int layer;
    private h matrix;
    private Date modificationTime = new Date();
    private long trackId;
    private float volume;
    private double width;
    static {
        TrackHeaderBox.ajc$preClinit();
        TrackHeaderBox.LOG = f.a(TrackHeaderBox.class);
    }

    public TrackHeaderBox() {
        super("tkhd");
        final long l = 0L;
        Date date = new Date(l, r2);
        Date date2 = new Date(l, r2);
        this.matrix = h.j;
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("TrackHeaderBox.java", TrackHeaderBox.class);
        final String str212 = "method-execution";
        TrackHeaderBox.ajc$tjp_0 = bVar.h(str212, bVar.g("1", "getCreationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "java.util.Date"), 62);
        TrackHeaderBox.ajc$tjp_1 = bVar.h(str212, bVar.g("1", "getModificationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "java.util.Date"), 66);
        TrackHeaderBox.ajc$tjp_10 = bVar.h(str212, bVar.g("1", "getContent", "com.coremedia.iso.boxes.TrackHeaderBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 145);
        TrackHeaderBox.ajc$tjp_11 = bVar.h(str212, bVar.g("1", "toString", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "java.lang.String"), 173);
        TrackHeaderBox.ajc$tjp_12 = bVar.h(str212, bVar.g("1", "setCreationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "java.util.Date", "creationTime", "", "void"), 199);
        TrackHeaderBox.ajc$tjp_13 = bVar.h(str212, bVar.g("1", "setModificationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "java.util.Date", "modificationTime", "", "void"), 206);
        TrackHeaderBox.ajc$tjp_14 = bVar.h(str212, bVar.g("1", "setTrackId", "com.coremedia.iso.boxes.TrackHeaderBox", "long", "trackId", "", "void"), 214);
        TrackHeaderBox.ajc$tjp_15 = bVar.h(str212, bVar.g("1", "setDuration", "com.coremedia.iso.boxes.TrackHeaderBox", "long", "duration", "", "void"), 218);
        TrackHeaderBox.ajc$tjp_16 = bVar.h(str212, bVar.g("1", "setLayer", "com.coremedia.iso.boxes.TrackHeaderBox", "int", "layer", "", "void"), 225);
        TrackHeaderBox.ajc$tjp_17 = bVar.h(str212, bVar.g("1", "setAlternateGroup", "com.coremedia.iso.boxes.TrackHeaderBox", "int", "alternateGroup", "", "void"), 229);
        TrackHeaderBox.ajc$tjp_18 = bVar.h(str212, bVar.g("1", "setVolume", "com.coremedia.iso.boxes.TrackHeaderBox", "float", "volume", "", "void"), 233);
        TrackHeaderBox.ajc$tjp_19 = bVar.h(str212, bVar.g("1", "setMatrix", "com.coremedia.iso.boxes.TrackHeaderBox", "com.googlecode.mp4parser.util.Matrix", "matrix", "", "void"), 237);
        TrackHeaderBox.ajc$tjp_2 = bVar.h(str212, bVar.g("1", "getTrackId", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "long"), 70);
        TrackHeaderBox.ajc$tjp_20 = bVar.h(str212, bVar.g("1", "setWidth", "com.coremedia.iso.boxes.TrackHeaderBox", "double", "width", "", "void"), 241);
        TrackHeaderBox.ajc$tjp_21 = bVar.h(str212, bVar.g("1", "setHeight", "com.coremedia.iso.boxes.TrackHeaderBox", "double", "height", "", "void"), 245);
        TrackHeaderBox.ajc$tjp_22 = bVar.h(str212, bVar.g("1", "isEnabled", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), 250);
        TrackHeaderBox.ajc$tjp_23 = bVar.h(str212, bVar.g("1", "isInMovie", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), 254);
        TrackHeaderBox.ajc$tjp_24 = bVar.h(str212, bVar.g("1", "isInPreview", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), 258);
        TrackHeaderBox.ajc$tjp_25 = bVar.h(str212, bVar.g("1", "isInPoster", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), 262);
        TrackHeaderBox.ajc$tjp_26 = bVar.h(str212, bVar.g("1", "setEnabled", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "enabled", "", "void"), 266);
        TrackHeaderBox.ajc$tjp_27 = bVar.h(str212, bVar.g("1", "setInMovie", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "inMovie", "", "void"), 274);
        TrackHeaderBox.ajc$tjp_28 = bVar.h(str212, bVar.g("1", "setInPreview", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "inPreview", "", "void"), 282);
        TrackHeaderBox.ajc$tjp_29 = bVar.h(str212, bVar.g("1", "setInPoster", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "inPoster", "", "void"), 290);
        TrackHeaderBox.ajc$tjp_3 = bVar.h(str212, bVar.g("1", "getDuration", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "long"), 74);
        TrackHeaderBox.ajc$tjp_4 = bVar.h(str212, bVar.g("1", "getLayer", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "int"), 78);
        TrackHeaderBox.ajc$tjp_5 = bVar.h(str212, bVar.g("1", "getAlternateGroup", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "int"), 82);
        TrackHeaderBox.ajc$tjp_6 = bVar.h(str212, bVar.g("1", "getVolume", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "float"), 86);
        TrackHeaderBox.ajc$tjp_7 = bVar.h(str212, bVar.g("1", "getMatrix", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "com.googlecode.mp4parser.util.Matrix"), 90);
        TrackHeaderBox.ajc$tjp_8 = bVar.h(str212, bVar.g("1", "getWidth", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "double"), 94);
        TrackHeaderBox.ajc$tjp_9 = bVar.h(str212, bVar.g("1", "getHeight", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "double"), 98);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        int i = 1;
        if (getVersion() == i) {
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
            _long = (long)byteBuffer.getInt();
            this.duration = _long;
        }
        if (this.duration < -1) {
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
        d.b().c(b.d(TrackHeaderBox.ajc$tjp_10, this, this, byteBuffer));
        writeVersionAndFlags(byteBuffer);
        ByteBuffer byteBuffer2 = null;
        if (getVersion() == 1) {
            g.i(byteBuffer, c.a(this.creationTime));
            g.i(byteBuffer, c.a(this.modificationTime));
            g.g(byteBuffer, this.trackId);
            g.g(byteBuffer, byteBuffer2);
            byteBuffer.putLong(this.duration);
        } else {
            g.g(byteBuffer, c.a(this.creationTime));
            g.g(byteBuffer, c.a(this.modificationTime));
            g.g(byteBuffer, this.trackId);
            g.g(byteBuffer, byteBuffer2);
            byteBuffer.putInt((int)this.duration);
        }
        g.g(byteBuffer, byteBuffer2);
        g.g(byteBuffer, byteBuffer2);
        g.e(byteBuffer, this.layer);
        g.e(byteBuffer, this.alternateGroup);
        g.c(byteBuffer, (double)this.volume);
        g.e(byteBuffer, 0);
        this.matrix.c(byteBuffer);
        g.b(byteBuffer, this.width);
        g.b(byteBuffer, this.height);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i = 36;
        int r0 = getVersion() == 1 ? 36 : 24;
        return (getVersion() == 1 ? 36 : 24);
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
        boolean z = true;
        if (getFlags() & z > 0) {
            return true;
        }
        return false;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean isInMovie() {
        d.b().c(b.c(TrackHeaderBox.ajc$tjp_23, this, this));
        if (getFlags() & 2 > 0) {
            return true;
        }
        return false;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean isInPoster() {
        d.b().c(b.c(TrackHeaderBox.ajc$tjp_25, this, this));
        if (getFlags() & 8 > 0) {
            return true;
        }
        return false;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean isInPreview() {
        d.b().c(b.c(TrackHeaderBox.ajc$tjp_24, this, this));
        if (getFlags() & 4 > 0) {
            return true;
        }
        return false;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setAlternateGroup(int i) {
        d.b().c(b.d(TrackHeaderBox.ajc$tjp_17, this, this, a.e(i)));
        this.alternateGroup = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setCreationTime(Date date) {
        d.b().c(b.d(TrackHeaderBox.ajc$tjp_12, this, this, date));
        this.creationTime = date;
        long l = c.a(date);
        if (l >= 4294967296L) {
            int cmp = 1;
            setVersion(cmp);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setDuration(long j) {
        d.b().c(b.d(TrackHeaderBox.ajc$tjp_15, this, this, a.f(j)));
        this.duration = j;
        if (j >= 4294967296L) {
            int cmp = 1;
            setFlags(cmp);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setEnabled(boolean z) {
        d.b().c(b.d(TrackHeaderBox.ajc$tjp_26, this, this, a.a(z)));
        if (z) {
            i = getFlags() | 1;
            setFlags(i);
        } else {
            i = getFlags() & (-2);
            setFlags(i);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setHeight(double d) {
        d.b().c(b.d(TrackHeaderBox.ajc$tjp_21, this, this, a.c(d)));
        this.height = d;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setInMovie(boolean z) {
        d.b().c(b.d(TrackHeaderBox.ajc$tjp_27, this, this, a.a(z)));
        if (z) {
            i = getFlags() | 2;
            setFlags(i);
        } else {
            i = getFlags() & (-3);
            setFlags(i);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setInPoster(boolean z) {
        d.b().c(b.d(TrackHeaderBox.ajc$tjp_29, this, this, a.a(z)));
        if (z) {
            i = getFlags() | 8;
            setFlags(i);
        } else {
            i = getFlags() & (-9);
            setFlags(i);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setInPreview(boolean z) {
        d.b().c(b.d(TrackHeaderBox.ajc$tjp_28, this, this, a.a(z)));
        if (z) {
            i = getFlags() | 4;
            setFlags(i);
        } else {
            i = getFlags() & (-5);
            setFlags(i);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setLayer(int i) {
        d.b().c(b.d(TrackHeaderBox.ajc$tjp_16, this, this, a.e(i)));
        this.layer = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setMatrix(h hVar) {
        d.b().c(b.d(TrackHeaderBox.ajc$tjp_19, this, this, hVar));
        this.matrix = hVar;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setModificationTime(Date date) {
        d.b().c(b.d(TrackHeaderBox.ajc$tjp_13, this, this, date));
        this.modificationTime = date;
        long l = c.a(date);
        if (l >= 4294967296L) {
            int cmp = 1;
            setVersion(cmp);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setTrackId(long j) {
        d.b().c(b.d(TrackHeaderBox.ajc$tjp_14, this, this, a.f(j)));
        this.trackId = j;
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
        String str2 = "TrackHeaderBox[";
        String str3 = "creationTime=";
        Date creationTime = getCreationTime();
        String str4 = ";";
        String str7 = "modificationTime=";
        Date modificationTime = getModificationTime();
        String str8 = "trackId=";
        long trackId = getTrackId();
        String str9 = "duration=";
        long duration = getDuration();
        String str10 = "layer=";
        int layer = getLayer();
        String str11 = "alternateGroup=";
        int alternateGroup = getAlternateGroup();
        String str12 = "volume=";
        float volume = getVolume();
        String str13 = "matrix=";
        String str14 = "width=";
        double width = getWidth();
        String str5 = "height=";
        double height = getHeight();
        String str6 = "]";
        str = str2 + str3 + creationTime + str4 + str7 + modificationTime + str4 + str8 + trackId + str4 + str9 + duration + str4 + str10 + layer + str4 + str11 + alternateGroup + str4 + str12 + volume + str4 + str13 + this.matrix + str4 + str14 + width + str4 + str5 + height + str6;
        return str;
    }
}
