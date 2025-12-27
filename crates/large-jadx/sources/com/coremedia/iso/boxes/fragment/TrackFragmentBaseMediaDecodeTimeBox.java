package com.coremedia.iso.boxes.fragment;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: TrackFragmentBaseMediaDecodeTimeBox.java */
/* loaded from: classes.dex */
public class TrackFragmentBaseMediaDecodeTimeBox extends AbstractFullBox {

    public static final String TYPE = "tfdt";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private long baseMediaDecodeTime;
    static {
        TrackFragmentBaseMediaDecodeTimeBox.ajc$preClinit();
    }

    public TrackFragmentBaseMediaDecodeTimeBox() {
        super("tfdt");
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("TrackFragmentBaseMediaDecodeTimeBox.java", TrackFragmentBaseMediaDecodeTimeBox.class);
        final String str23 = "method-execution";
        TrackFragmentBaseMediaDecodeTimeBox.ajc$tjp_0 = bVar.h(str23, bVar.g("1", "getBaseMediaDecodeTime", "com.coremedia.iso.boxes.fragment.TrackFragmentBaseMediaDecodeTimeBox", "", "", "", "long"), 65);
        TrackFragmentBaseMediaDecodeTimeBox.ajc$tjp_1 = bVar.h(str23, bVar.g("1", "setBaseMediaDecodeTime", "com.coremedia.iso.boxes.fragment.TrackFragmentBaseMediaDecodeTimeBox", "long", "baseMediaDecodeTime", "", "void"), 69);
        TrackFragmentBaseMediaDecodeTimeBox.ajc$tjp_2 = bVar.h(str23, bVar.g("1", "toString", "com.coremedia.iso.boxes.fragment.TrackFragmentBaseMediaDecodeTimeBox", "", "", "", "java.lang.String"), 74);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        if (getVersion() == 1) {
            this.baseMediaDecodeTime = e.m(byteBuffer);
        } else {
            this.baseMediaDecodeTime = e.k(byteBuffer);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getBaseMediaDecodeTime() {
        d.b().c(b.c(TrackFragmentBaseMediaDecodeTimeBox.ajc$tjp_0, this, this));
        return this.baseMediaDecodeTime;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        final int i = 1;
        if (getVersion() == i) {
            g.i(byteBuffer, this.baseMediaDecodeTime);
        } else {
            g.g(byteBuffer, this.baseMediaDecodeTime);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i = 8;
        int r0 = getVersion() == 0 ? 8 : 12;
        return (getVersion() == 0 ? 8 : 12);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setBaseMediaDecodeTime(long j) {
        d.b().c(b.d(TrackFragmentBaseMediaDecodeTimeBox.ajc$tjp_1, this, this, a.f(j)));
        this.baseMediaDecodeTime = j;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(TrackFragmentBaseMediaDecodeTimeBox.ajc$tjp_2, this, this));
        String str2 = "TrackFragmentBaseMediaDecodeTimeBox{baseMediaDecodeTime=";
        StringBuilder stringBuilder = new StringBuilder(str2);
        str = str2 + this.baseMediaDecodeTime + 125;
        return str;
    }
}
