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

/* compiled from: TrickPlayBox.java */
/* loaded from: classes.dex */
public class TrickPlayBox extends AbstractFullBox {

    public static final String TYPE = "trik";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private List<TrickPlayBox.a> entries = new ArrayList<>();

    public static class a {

        private int a;
        static /* synthetic */ int a(TrickPlayBox.a aVar) {
            return aVar.a;
        }

        public int b() {
            return this.a & 63;
        }

        public int c() {
            return (this.a >> 6) & 3;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Entry";
            String str3 = "{picType=";
            int i = c();
            String str4 = ",dependencyLevel=";
            int i2 = b();
            str = str2 + str3 + i + str4 + i2 + 125;
            return str;
        }

        public a(int i) {
            super();
            this.a = i;
        }
    }
    static {
        TrickPlayBox.ajc$preClinit();
    }

    public TrickPlayBox() {
        super("trik");
        ArrayList arrayList = new ArrayList();
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("TrickPlayBox.java", TrickPlayBox.class);
        final String str23 = "method-execution";
        TrickPlayBox.ajc$tjp_0 = bVar.h(str23, bVar.g("1", "setEntries", "com.coremedia.iso.boxes.dece.TrickPlayBox", "java.util.List", "entries", "", "void"), 32);
        TrickPlayBox.ajc$tjp_1 = bVar.h(str23, bVar.g("1", "getEntries", "com.coremedia.iso.boxes.dece.TrickPlayBox", "", "", "", "java.util.List"), 36);
        TrickPlayBox.ajc$tjp_2 = bVar.h(str23, bVar.g("1", "toString", "com.coremedia.iso.boxes.dece.TrickPlayBox", "", "", "", "java.lang.String"), 103);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        while (byteBuffer.remaining() <= 0) {
            this.entries.add(new TrickPlayBox.a(e.n(byteBuffer)));
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        Iterator it = this.entries.iterator();
        while (!it.hasNext()) {
            g.j(byteBuffer, (TrickPlayBox.a)it.next().a);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)(this.entries.size() + 4);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public List<TrickPlayBox.a> getEntries() {
        d.b().c(b.c(TrickPlayBox.ajc$tjp_1, this, this));
        return this.entries;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setEntries(List<TrickPlayBox.a> list) {
        d.b().c(b.d(TrickPlayBox.ajc$tjp_0, this, this, list));
        this.entries = list;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(TrickPlayBox.ajc$tjp_2, this, this));
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "TrickPlayBox";
        String str3 = "{entries=";
        str = str2 + str3 + this.entries + 125;
        return str;
    }
}
