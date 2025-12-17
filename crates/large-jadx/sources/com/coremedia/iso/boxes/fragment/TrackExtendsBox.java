package com.coremedia.iso.boxes.fragment;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class TrackExtendsBox extends AbstractFullBox {

    public static final String TYPE = "trex";
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
    private long defaultSampleDescriptionIndex;
    private long defaultSampleDuration;
    private com.coremedia.iso.boxes.fragment.a defaultSampleFlags;
    private long defaultSampleSize;
    private long trackId;
    static {
        TrackExtendsBox.ajc$preClinit();
    }

    public TrackExtendsBox() {
        super("trex");
    }

    private static void ajc$preClinit() {
        b bVar12 = new b("TrackExtendsBox.java", TrackExtendsBox.class);
        final String str79 = "method-execution";
        TrackExtendsBox.ajc$tjp_0 = bVar12.h(str79, bVar12.g("1", "getTrackId", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "", "", "", "long"), 72);
        TrackExtendsBox.ajc$tjp_1 = bVar12.h(str79, bVar12.g("1", "getDefaultSampleDescriptionIndex", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "", "", "", "long"), 76);
        TrackExtendsBox.ajc$tjp_10 = bVar12.h(str79, bVar12.g("1", "setDefaultSampleFlags", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "com.coremedia.iso.boxes.fragment.SampleFlags", "defaultSampleFlags", "", "void"), 112);
        TrackExtendsBox.ajc$tjp_2 = bVar12.h(str79, bVar12.g("1", "getDefaultSampleDuration", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "", "", "", "long"), 80);
        TrackExtendsBox.ajc$tjp_3 = bVar12.h(str79, bVar12.g("1", "getDefaultSampleSize", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "", "", "", "long"), 84);
        TrackExtendsBox.ajc$tjp_4 = bVar12.h(str79, bVar12.g("1", "getDefaultSampleFlags", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "", "", "", "com.coremedia.iso.boxes.fragment.SampleFlags"), 88);
        TrackExtendsBox.ajc$tjp_5 = bVar12.h(str79, bVar12.g("1", "getDefaultSampleFlagsStr", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "", "", "", "java.lang.String"), 92);
        TrackExtendsBox.ajc$tjp_6 = bVar12.h(str79, bVar12.g("1", "setTrackId", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "long", "trackId", "", "void"), 96);
        TrackExtendsBox.ajc$tjp_7 = bVar12.h(str79, bVar12.g("1", "setDefaultSampleDescriptionIndex", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "long", "defaultSampleDescriptionIndex", "", "void"), 100);
        TrackExtendsBox.ajc$tjp_8 = bVar12.h(str79, bVar12.g("1", "setDefaultSampleDuration", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "long", "defaultSampleDuration", "", "void"), 104);
        TrackExtendsBox.ajc$tjp_9 = bVar12.h(str79, bVar12.g("1", "setDefaultSampleSize", "com.coremedia.iso.boxes.fragment.TrackExtendsBox", "long", "defaultSampleSize", "", "void"), 108);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.trackId = e.k(byteBuffer);
        this.defaultSampleDescriptionIndex = e.k(byteBuffer);
        this.defaultSampleDuration = e.k(byteBuffer);
        this.defaultSampleSize = e.k(byteBuffer);
        a aVar = new a(byteBuffer);
        this.defaultSampleFlags = aVar;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        g.g(byteBuffer, this.trackId);
        g.g(byteBuffer, this.defaultSampleDescriptionIndex);
        g.g(byteBuffer, this.defaultSampleDuration);
        g.g(byteBuffer, this.defaultSampleSize);
        this.defaultSampleFlags.a(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return 24;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getDefaultSampleDescriptionIndex() {
        d.b().c(b.c(TrackExtendsBox.ajc$tjp_1, this, this));
        return this.defaultSampleDescriptionIndex;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getDefaultSampleDuration() {
        d.b().c(b.c(TrackExtendsBox.ajc$tjp_2, this, this));
        return this.defaultSampleDuration;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public com.coremedia.iso.boxes.fragment.a getDefaultSampleFlags() {
        d.b().c(b.c(TrackExtendsBox.ajc$tjp_4, this, this));
        return this.defaultSampleFlags;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getDefaultSampleFlagsStr() {
        d.b().c(b.c(TrackExtendsBox.ajc$tjp_5, this, this));
        return this.defaultSampleFlags.toString();
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getDefaultSampleSize() {
        d.b().c(b.c(TrackExtendsBox.ajc$tjp_3, this, this));
        return this.defaultSampleSize;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getTrackId() {
        d.b().c(b.c(TrackExtendsBox.ajc$tjp_0, this, this));
        return this.trackId;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setDefaultSampleDescriptionIndex(long l) {
        d.b().c(b.d(TrackExtendsBox.ajc$tjp_7, this, this, a.f(l)));
        this.defaultSampleDescriptionIndex = l;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setDefaultSampleDuration(long l) {
        d.b().c(b.d(TrackExtendsBox.ajc$tjp_8, this, this, a.f(l)));
        this.defaultSampleDuration = l;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setDefaultSampleFlags(com.coremedia.iso.boxes.fragment.a a) {
        d.b().c(b.d(TrackExtendsBox.ajc$tjp_10, this, this, a));
        this.defaultSampleFlags = a;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setDefaultSampleSize(long l) {
        d.b().c(b.d(TrackExtendsBox.ajc$tjp_9, this, this, a.f(l)));
        this.defaultSampleSize = l;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setTrackId(long l) {
        d.b().c(b.d(TrackExtendsBox.ajc$tjp_6, this, this, a.f(l)));
        this.trackId = l;
    }
}
