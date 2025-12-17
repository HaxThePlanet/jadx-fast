package com.googlecode.mp4parser;

import com.coremedia.iso.boxes.FullBox;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public abstract class AbstractFullBox extends com.googlecode.mp4parser.AbstractBox implements FullBox {

    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private int flags;
    private int version;
    static {
        AbstractFullBox.ajc$preClinit();
    }

    protected AbstractFullBox(String string) {
        super(string);
    }

    protected AbstractFullBox(String string, byte[] b2Arr2) {
        super(string, b2Arr2);
    }

    private static void ajc$preClinit() {
        b bVar3 = new b("AbstractFullBox.java", AbstractFullBox.class);
        final String str16 = "method-execution";
        AbstractFullBox.ajc$tjp_0 = bVar3.h(str16, bVar3.g("1", "setVersion", "com.googlecode.mp4parser.AbstractFullBox", "int", "version", "", "void"), 51);
        AbstractFullBox.ajc$tjp_1 = bVar3.h(str16, bVar3.g("1", "setFlags", "com.googlecode.mp4parser.AbstractFullBox", "int", "flags", "", "void"), 64);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getFlags() {
        if (!this.isParsed) {
            parseDetails();
        }
        return this.flags;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getVersion() {
        if (!this.isParsed) {
            parseDetails();
        }
        return this.version;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected final long parseVersionAndFlags(ByteBuffer byteBuffer) {
        this.version = e.n(byteBuffer);
        this.flags = e.j(byteBuffer);
        return 4;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setFlags(int i) {
        d.b().c(b.d(AbstractFullBox.ajc$tjp_1, this, this, a.e(i)));
        this.flags = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setVersion(int i) {
        d.b().c(b.d(AbstractFullBox.ajc$tjp_0, this, this, a.e(i)));
        this.version = i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected final void writeVersionAndFlags(ByteBuffer byteBuffer) {
        g.j(byteBuffer, this.version);
        g.f(byteBuffer, this.flags);
    }
}
