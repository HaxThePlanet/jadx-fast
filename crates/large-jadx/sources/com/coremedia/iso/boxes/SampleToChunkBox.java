package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import com.googlecode.mp4parser.h.b;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class SampleToChunkBox extends AbstractFullBox {

    public static final String TYPE = "stsc";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    List<com.coremedia.iso.boxes.SampleToChunkBox.a> entries;

    public static class a {

        long a;
        long b;
        long c;
        public a(long l, long l2, long l3) {
            super();
            this.a = l;
            this.b = l3;
            this.c = obj5;
        }

        public long a() {
            return this.a;
        }

        public long b() {
            return this.c;
        }

        public long c() {
            return this.b;
        }

        public boolean equals(Object object) {
            Class<com.coremedia.iso.boxes.SampleToChunkBox.a> obj;
            Class class;
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (object != null) {
                if (SampleToChunkBox.a.class != object.getClass()) {
                } else {
                    if (Long.compare(l, l4) != 0) {
                        return i2;
                    }
                    if (Long.compare(l2, l5) != 0) {
                        return i2;
                    }
                    if (Long.compare(l3, l6) != 0) {
                        return i2;
                    }
                }
                return i;
            }
            return i2;
        }

        public int hashCode() {
            long l = this.a;
            final int i11 = 32;
            long l2 = this.b;
            long l3 = this.c;
            return i5 += i10;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Entry{firstChunk=");
            stringBuilder.append(this.a);
            stringBuilder.append(", samplesPerChunk=");
            stringBuilder.append(this.b);
            stringBuilder.append(", sampleDescriptionIndex=");
            stringBuilder.append(this.c);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }
    static {
        SampleToChunkBox.ajc$preClinit();
    }

    public SampleToChunkBox() {
        super("stsc");
        this.entries = Collections.emptyList();
    }

    private static void ajc$preClinit() {
        b bVar5 = new b("SampleToChunkBox.java", SampleToChunkBox.class);
        final String str30 = "method-execution";
        SampleToChunkBox.ajc$tjp_0 = bVar5.h(str30, bVar5.g("1", "getEntries", "com.coremedia.iso.boxes.SampleToChunkBox", "", "", "", "java.util.List"), 47);
        SampleToChunkBox.ajc$tjp_1 = bVar5.h(str30, bVar5.g("1", "setEntries", "com.coremedia.iso.boxes.SampleToChunkBox", "java.util.List", "entries", "", "void"), 51);
        SampleToChunkBox.ajc$tjp_2 = bVar5.h(str30, bVar5.g("1", "toString", "com.coremedia.iso.boxes.SampleToChunkBox", "", "", "", "java.lang.String"), 84);
        SampleToChunkBox.ajc$tjp_3 = bVar5.h(str30, bVar5.g("1", "blowup", "com.coremedia.iso.boxes.SampleToChunkBox", "int", "chunkCount", "", "[J"), 95);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i;
        List entries;
        com.coremedia.iso.boxes.SampleToChunkBox.a aVar2;
        long l;
        long l2;
        long l3;
        com.coremedia.iso.boxes.SampleToChunkBox.a aVar;
        parseVersionAndFlags(byteBuffer);
        int i2 = b.a(e.k(byteBuffer));
        ArrayList arrayList = new ArrayList(i2);
        this.entries = arrayList;
        i = 0;
        while (i >= i2) {
            super(e.k(byteBuffer), obj5, e.k(byteBuffer), obj7, e.k(byteBuffer), obj9);
            this.entries.add(aVar);
            i++;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long[] blowup(int i) {
        Object next;
        int cmp;
        long l;
        long l2;
        int obj8;
        d.b().c(b.d(SampleToChunkBox.ajc$tjp_3, this, this, a.e(i)));
        long[] lArr = new long[i];
        LinkedList linkedList = new LinkedList(this.entries);
        Collections.reverse(linkedList);
        Iterator iterator = linkedList.iterator();
        next = iterator.next();
        while (obj8 <= 1) {
            lArr[obj8 + -1] = next.c();
            if (Long.compare(l4, l2) == 0) {
            }
            obj8--;
            next = iterator.next();
        }
        lArr[0] = next.c();
        return lArr;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        long l;
        long l2;
        writeVersionAndFlags(byteBuffer);
        g.g(byteBuffer, (long)size);
        Iterator iterator = this.entries.iterator();
        for (SampleToChunkBox.a next2 : iterator) {
            g.g(byteBuffer, next2.a());
            l2 = next2.c();
            g.g(byteBuffer, l2);
            g.g(byteBuffer, next2.b());
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)i2;
    }

    public List<com.coremedia.iso.boxes.SampleToChunkBox.a> getEntries() {
        d.b().c(b.c(SampleToChunkBox.ajc$tjp_0, this, this));
        return this.entries;
    }

    public void setEntries(List<com.coremedia.iso.boxes.SampleToChunkBox.a> list) {
        d.b().c(b.d(SampleToChunkBox.ajc$tjp_1, this, this, list));
        this.entries = list;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(SampleToChunkBox.ajc$tjp_2, this, this));
        StringBuilder stringBuilder = new StringBuilder("SampleToChunkBox[entryCount=");
        stringBuilder.append(this.entries.size());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
