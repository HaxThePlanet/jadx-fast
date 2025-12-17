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
public class MovieFragmentHeaderBox extends AbstractFullBox {

    public static final String TYPE = "mfhd";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private long sequenceNumber;
    static {
        MovieFragmentHeaderBox.ajc$preClinit();
    }

    public MovieFragmentHeaderBox() {
        super("mfhd");
    }

    private static void ajc$preClinit() {
        b bVar4 = new b("MovieFragmentHeaderBox.java", MovieFragmentHeaderBox.class);
        final String str23 = "method-execution";
        MovieFragmentHeaderBox.ajc$tjp_0 = bVar4.h(str23, bVar4.g("1", "getSequenceNumber", "com.coremedia.iso.boxes.fragment.MovieFragmentHeaderBox", "", "", "", "long"), 59);
        MovieFragmentHeaderBox.ajc$tjp_1 = bVar4.h(str23, bVar4.g("1", "setSequenceNumber", "com.coremedia.iso.boxes.fragment.MovieFragmentHeaderBox", "long", "sequenceNumber", "", "void"), 63);
        MovieFragmentHeaderBox.ajc$tjp_2 = bVar4.h(str23, bVar4.g("1", "toString", "com.coremedia.iso.boxes.fragment.MovieFragmentHeaderBox", "", "", "", "java.lang.String"), 68);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.sequenceNumber = e.k(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        g.g(byteBuffer, this.sequenceNumber);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return 8;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getSequenceNumber() {
        d.b().c(b.c(MovieFragmentHeaderBox.ajc$tjp_0, this, this));
        return this.sequenceNumber;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setSequenceNumber(long l) {
        d.b().c(b.d(MovieFragmentHeaderBox.ajc$tjp_1, this, this, a.f(l)));
        this.sequenceNumber = l;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(MovieFragmentHeaderBox.ajc$tjp_2, this, this));
        StringBuilder stringBuilder = new StringBuilder("MovieFragmentHeaderBox{sequenceNumber=");
        stringBuilder.append(this.sequenceNumber);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
