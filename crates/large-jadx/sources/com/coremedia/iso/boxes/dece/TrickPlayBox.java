package com.coremedia.iso.boxes.dece;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class TrickPlayBox extends AbstractFullBox {

    public static final String TYPE = "trik";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private List<com.coremedia.iso.boxes.dece.TrickPlayBox.a> entries;

    public static class a {

        private int a;
        public a(int i) {
            super();
            this.a = i;
        }

        static int a(com.coremedia.iso.boxes.dece.TrickPlayBox.a trickPlayBox$a) {
            return a.a;
        }

        public int b() {
            return i &= 63;
        }

        public int c() {
            return i2 &= 3;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Entry");
            stringBuilder.append("{picType=");
            stringBuilder.append(c());
            stringBuilder.append(",dependencyLevel=");
            stringBuilder.append(b());
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }
    static {
        TrickPlayBox.ajc$preClinit();
    }

    public TrickPlayBox() {
        super("trik");
        ArrayList arrayList = new ArrayList();
        this.entries = arrayList;
    }

    private static void ajc$preClinit() {
        b bVar4 = new b("TrickPlayBox.java", TrickPlayBox.class);
        final String str23 = "method-execution";
        TrickPlayBox.ajc$tjp_0 = bVar4.h(str23, bVar4.g("1", "setEntries", "com.coremedia.iso.boxes.dece.TrickPlayBox", "java.util.List", "entries", "", "void"), 32);
        TrickPlayBox.ajc$tjp_1 = bVar4.h(str23, bVar4.g("1", "getEntries", "com.coremedia.iso.boxes.dece.TrickPlayBox", "", "", "", "java.util.List"), 36);
        TrickPlayBox.ajc$tjp_2 = bVar4.h(str23, bVar4.g("1", "toString", "com.coremedia.iso.boxes.dece.TrickPlayBox", "", "", "", "java.lang.String"), 103);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        List entries;
        com.coremedia.iso.boxes.dece.TrickPlayBox.a aVar;
        int i;
        parseVersionAndFlags(byteBuffer);
        while (byteBuffer.remaining() <= 0) {
            aVar = new TrickPlayBox.a(e.n(byteBuffer));
            this.entries.add(aVar);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        int i;
        writeVersionAndFlags(byteBuffer);
        Iterator iterator = this.entries.iterator();
        for (TrickPlayBox.a next2 : iterator) {
            g.j(byteBuffer, TrickPlayBox.a.a(next2));
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)i;
    }

    public List<com.coremedia.iso.boxes.dece.TrickPlayBox.a> getEntries() {
        d.b().c(b.c(TrickPlayBox.ajc$tjp_1, this, this));
        return this.entries;
    }

    public void setEntries(List<com.coremedia.iso.boxes.dece.TrickPlayBox.a> list) {
        d.b().c(b.d(TrickPlayBox.ajc$tjp_0, this, this, list));
        this.entries = list;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(TrickPlayBox.ajc$tjp_2, this, this));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrickPlayBox");
        stringBuilder.append("{entries=");
        stringBuilder.append(this.entries);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
