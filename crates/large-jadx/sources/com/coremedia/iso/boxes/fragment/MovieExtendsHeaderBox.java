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
public class MovieExtendsHeaderBox extends AbstractFullBox {

    public static final String TYPE = "mehd";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private long fragmentDuration;
    static {
        MovieExtendsHeaderBox.ajc$preClinit();
    }

    public MovieExtendsHeaderBox() {
        super("mehd");
    }

    private static void ajc$preClinit() {
        b bVar3 = new b("MovieExtendsHeaderBox.java", MovieExtendsHeaderBox.class);
        final String str16 = "method-execution";
        MovieExtendsHeaderBox.ajc$tjp_0 = bVar3.h(str16, bVar3.g("1", "getFragmentDuration", "com.coremedia.iso.boxes.fragment.MovieExtendsHeaderBox", "", "", "", "long"), 65);
        MovieExtendsHeaderBox.ajc$tjp_1 = bVar3.h(str16, bVar3.g("1", "setFragmentDuration", "com.coremedia.iso.boxes.fragment.MovieExtendsHeaderBox", "long", "fragmentDuration", "", "void"), 69);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        long l;
        parseVersionAndFlags(byteBuffer);
        if (getVersion() == 1) {
            l = e.m(byteBuffer);
        } else {
            l = e.k(byteBuffer);
        }
        this.fragmentDuration = l;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        long fragmentDuration;
        writeVersionAndFlags(byteBuffer);
        final int i = 1;
        if (getVersion() == i) {
            g.i(byteBuffer, this.fragmentDuration);
        } else {
            g.g(byteBuffer, this.fragmentDuration);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i;
        i = getVersion() == 1 ? 12 : 8;
        return (long)i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getFragmentDuration() {
        d.b().c(b.c(MovieExtendsHeaderBox.ajc$tjp_0, this, this));
        return this.fragmentDuration;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setFragmentDuration(long l) {
        d.b().c(b.d(MovieExtendsHeaderBox.ajc$tjp_1, this, this, a.f(l)));
        this.fragmentDuration = l;
    }
}
