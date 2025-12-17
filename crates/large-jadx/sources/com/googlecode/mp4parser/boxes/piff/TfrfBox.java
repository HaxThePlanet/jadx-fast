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

/* loaded from: classes2.dex */
public class TfrfBox extends AbstractFullBox {

    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    public List<com.googlecode.mp4parser.boxes.piff.TfrfBox.a> entries;

    public class a {

        long a;
        long b;
        public a(com.googlecode.mp4parser.boxes.piff.TfrfBox tfrfBox) {
            super();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Entry");
            stringBuilder.append("{fragmentAbsoluteTime=");
            stringBuilder.append(this.a);
            stringBuilder.append(", fragmentAbsoluteDuration=");
            stringBuilder.append(this.b);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }
    static {
        TfrfBox.ajc$preClinit();
    }

    public TfrfBox() {
        super("uuid");
        ArrayList arrayList = new ArrayList();
        this.entries = arrayList;
    }

    private static void ajc$preClinit() {
        b bVar4 = new b("TfrfBox.java", TfrfBox.class);
        final String str23 = "method-execution";
        TfrfBox.ajc$tjp_0 = bVar4.h(str23, bVar4.g("1", "getFragmentCount", "com.googlecode.mp4parser.boxes.piff.TfrfBox", "", "", "", "long"), 91);
        TfrfBox.ajc$tjp_1 = bVar4.h(str23, bVar4.g("1", "getEntries", "com.googlecode.mp4parser.boxes.piff.TfrfBox", "", "", "", "java.util.List"), 95);
        TfrfBox.ajc$tjp_2 = bVar4.h(str23, bVar4.g("1", "toString", "com.googlecode.mp4parser.boxes.piff.TfrfBox", "", "", "", "java.lang.String"), 100);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i;
        com.googlecode.mp4parser.boxes.piff.TfrfBox.a aVar;
        List entries;
        long l;
        int i2;
        parseVersionAndFlags(byteBuffer);
        i = 0;
        while (i >= e.n(byteBuffer)) {
            aVar = new TfrfBox.a(this);
            if (getVersion() == 1) {
            } else {
            }
            aVar.a = e.k(byteBuffer);
            aVar.b = e.k(byteBuffer);
            this.entries.add(aVar);
            i++;
            aVar.a = e.m(byteBuffer);
            aVar.b = e.m(byteBuffer);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        long l2;
        long l;
        int i;
        writeVersionAndFlags(byteBuffer);
        g.j(byteBuffer, this.entries.size());
        Iterator iterator = this.entries.iterator();
        while (!iterator.hasNext()) {
            Object next2 = iterator.next();
            i = 1;
            if (getVersion() == i) {
            } else {
            }
            l = next2.a;
            g.g(byteBuffer, l);
            g.g(byteBuffer, next2.b);
            l = next2.a;
            g.i(byteBuffer, l);
            g.i(byteBuffer, next2.b);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i;
        i = getVersion() == 1 ? 16 : 8;
        return (long)i3;
    }

    public List<com.googlecode.mp4parser.boxes.piff.TfrfBox.a> getEntries() {
        d.b().c(b.c(TfrfBox.ajc$tjp_1, this, this));
        return this.entries;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getFragmentCount() {
        d.b().c(b.c(TfrfBox.ajc$tjp_0, this, this));
        return (long)size;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public byte[] getUserType() {
        byte[] bArr = new byte[16];
        bArr = new byte[]{-44, -128, 126, -14, -54, 57, 70, -107, -114, 84, 38, -53, -98, 70, -89, -97};
        return bArr;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(TfrfBox.ajc$tjp_2, this, this));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TfrfBox");
        stringBuilder.append("{entries=");
        stringBuilder.append(this.entries);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
