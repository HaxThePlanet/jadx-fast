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
public class MovieFragmentRandomAccessOffsetBox extends AbstractFullBox {

    public static final String TYPE = "mfro";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private long mfraSize;
    static {
        MovieFragmentRandomAccessOffsetBox.ajc$preClinit();
    }

    public MovieFragmentRandomAccessOffsetBox() {
        super("mfro");
    }

    private static void ajc$preClinit() {
        b bVar3 = new b("MovieFragmentRandomAccessOffsetBox.java", MovieFragmentRandomAccessOffsetBox.class);
        final String str16 = "method-execution";
        MovieFragmentRandomAccessOffsetBox.ajc$tjp_0 = bVar3.h(str16, bVar3.g("1", "getMfraSize", "com.coremedia.iso.boxes.fragment.MovieFragmentRandomAccessOffsetBox", "", "", "", "long"), 56);
        MovieFragmentRandomAccessOffsetBox.ajc$tjp_1 = bVar3.h(str16, bVar3.g("1", "setMfraSize", "com.coremedia.iso.boxes.fragment.MovieFragmentRandomAccessOffsetBox", "long", "mfraSize", "", "void"), 60);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.mfraSize = e.k(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        g.g(byteBuffer, this.mfraSize);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return 8;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getMfraSize() {
        d.b().c(b.c(MovieFragmentRandomAccessOffsetBox.ajc$tjp_0, this, this));
        return this.mfraSize;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setMfraSize(long l) {
        d.b().c(b.d(MovieFragmentRandomAccessOffsetBox.ajc$tjp_1, this, this, a.f(l)));
        this.mfraSize = l;
    }
}
