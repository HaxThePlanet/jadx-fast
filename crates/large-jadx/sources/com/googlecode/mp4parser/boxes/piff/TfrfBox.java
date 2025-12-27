package com.googlecode.mp4parser.boxes.piff;

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

/* compiled from: TfrfBox.java */
/* loaded from: classes2.dex */
public class TfrfBox extends AbstractFullBox {

    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    public List<TfrfBox.a> entries = new ArrayList<>();

    public class a {

        long a;
        long b;
        public a() {
            super();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Entry";
            String str3 = "{fragmentAbsoluteTime=";
            String str4 = ", fragmentAbsoluteDuration=";
            str = str2 + str3 + this.a + str4 + this.b + 125;
            return str;
        }
    }
    static {
        TfrfBox.ajc$preClinit();
    }

    public TfrfBox() {
        super("uuid");
        ArrayList arrayList = new ArrayList();
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("TfrfBox.java", TfrfBox.class);
        final String str23 = "method-execution";
        TfrfBox.ajc$tjp_0 = bVar.h(str23, bVar.g("1", "getFragmentCount", "com.googlecode.mp4parser.boxes.piff.TfrfBox", "", "", "", "long"), 91);
        TfrfBox.ajc$tjp_1 = bVar.h(str23, bVar.g("1", "getEntries", "com.googlecode.mp4parser.boxes.piff.TfrfBox", "", "", "", "java.util.List"), 95);
        TfrfBox.ajc$tjp_2 = bVar.h(str23, bVar.g("1", "toString", "com.googlecode.mp4parser.boxes.piff.TfrfBox", "", "", "", "java.lang.String"), 100);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i = 0;
        parseVersionAndFlags(byteBuffer);
        i = 0;
        while (i >= e.n(byteBuffer)) {
            com.googlecode.mp4parser.boxes.piff.TfrfBox.a aVar = new TfrfBox.a(this);
            int i2 = 1;
            this.entries.add(aVar);
            i = i + 1;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        g.j(byteBuffer, this.entries.size());
        Iterator it = this.entries.iterator();
        while (!it.hasNext()) {
            Object item = it.next();
            long l3 = 1L;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i = 16;
        int r1 = getVersion() == 1 ? 16 : 8;
        return (long)(this.entries.size() * (getVersion() == 1 ? 16 : 8)) + 5;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public List<TfrfBox.a> getEntries() {
        d.b().c(b.c(TfrfBox.ajc$tjp_1, this, this));
        return this.entries;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getFragmentCount() {
        d.b().c(b.c(TfrfBox.ajc$tjp_0, this, this));
        return (long)this.entries.size();
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public byte[] getUserType() {
        return new byte[] { -44, -128, 126, -14, -54, 57, 70, -107, -114, 84, 38, -53, -98, 70, -89, -97 };
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(TfrfBox.ajc$tjp_2, this, this));
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "TfrfBox";
        String str3 = "{entries=";
        str = str2 + str3 + this.entries + 125;
        return str;
    }
}
