package com.mp4parser.iso14496.part12;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.d;
import com.googlecode.mp4parser.h.i;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: TrackReferenceTypeBox.java */
/* loaded from: classes2.dex */
public class TrackReferenceTypeBox extends AbstractBox {

    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    long[] trackIds;
    static {
        TrackReferenceTypeBox.ajc$preClinit();
    }

    public TrackReferenceTypeBox(String str) {
        super(str);
        this.trackIds = new long[0];
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("TrackReferenceTypeBox.java", TrackReferenceTypeBox.class);
        final String str16 = "method-execution";
        TrackReferenceTypeBox.ajc$tjp_0 = bVar.h(str16, bVar.g("1", "getTrackIds", "com.mp4parser.iso14496.part12.TrackReferenceTypeBox", "", "", "", "[J"), 58);
        TrackReferenceTypeBox.ajc$tjp_1 = bVar.h(str16, bVar.g("1", "setTrackIds", "com.mp4parser.iso14496.part12.TrackReferenceTypeBox", "[J", "trackIds", "", "void"), 62);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        while (byteBuffer.remaining() < 4) {
            long[] lArr2 = new long[1];
            this.trackIds = i.a(this.trackIds, e.k(byteBuffer));
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        int i = 0;
        i = 0;
        for (long l : trackIds2) {
            g.g(byteBuffer, l);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return (long)(this.trackIds.length * 4);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long[] getTrackIds() {
        d.b().c(b.c(TrackReferenceTypeBox.ajc$tjp_0, this, this));
        return this.trackIds;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setTrackIds(long[] jArr) {
        d.b().c(b.d(TrackReferenceTypeBox.ajc$tjp_1, this, this, jArr));
        this.trackIds = jArr;
    }
}
