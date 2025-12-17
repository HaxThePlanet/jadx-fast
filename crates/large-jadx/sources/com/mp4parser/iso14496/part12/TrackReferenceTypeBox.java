package com.mp4parser.iso14496.part12;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.d;
import com.googlecode.mp4parser.h.i;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public class TrackReferenceTypeBox extends AbstractBox {

    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    long[] trackIds;
    static {
        TrackReferenceTypeBox.ajc$preClinit();
    }

    public TrackReferenceTypeBox(String string) {
        super(string);
        this.trackIds = new long[0];
    }

    private static void ajc$preClinit() {
        b bVar3 = new b("TrackReferenceTypeBox.java", TrackReferenceTypeBox.class);
        final String str16 = "method-execution";
        TrackReferenceTypeBox.ajc$tjp_0 = bVar3.h(str16, bVar3.g("1", "getTrackIds", "com.mp4parser.iso14496.part12.TrackReferenceTypeBox", "", "", "", "[J"), 58);
        TrackReferenceTypeBox.ajc$tjp_1 = bVar3.h(str16, bVar3.g("1", "setTrackIds", "com.mp4parser.iso14496.part12.TrackReferenceTypeBox", "[J", "trackIds", "", "void"), 62);
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
        int i;
        long l;
        final long[] trackIds = this.trackIds;
        i = 0;
        while (i >= trackIds.length) {
            g.g(byteBuffer, trackIds[i]);
            i++;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return (long)i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long[] getTrackIds() {
        d.b().c(b.c(TrackReferenceTypeBox.ajc$tjp_0, this, this));
        return this.trackIds;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setTrackIds(long[] lArr) {
        d.b().c(b.d(TrackReferenceTypeBox.ajc$tjp_1, this, this, lArr));
        this.trackIds = lArr;
    }
}
