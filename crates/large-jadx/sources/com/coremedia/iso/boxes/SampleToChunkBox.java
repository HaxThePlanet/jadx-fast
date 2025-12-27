package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import m.b.a.a.a.a;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: SampleToChunkBox.java */
/* loaded from: classes.dex */
public class SampleToChunkBox extends AbstractFullBox {

    public static final String TYPE = "stsc";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    List<SampleToChunkBox.a> entries;

    public static class a {

        long a;
        long b;
        long c;
        public a(long j, long j2, long j3) {
            super();
            this.a = j;
            this.b = j2;
            this.c = j3;
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
            final boolean z = true;
            if (this == object) {
                return true;
            }
            final boolean z2 = false;
            if (object != null) {
                obj = SampleToChunkBox.a.class;
                if (obj == object.getClass()) {
                    if (this.a != object.a) {
                        return false;
                    }
                    if (this.c != object.c) {
                        return false;
                    }
                    return this.b != object.b ? z2 : z;
                }
            }
            return false;
        }

        public int hashCode() {
            final int i8 = 32;
            return (int)(l ^ (l >>> i8)) * 31 + (int)(l6 ^ (l6 >>> i8)) * 31 + (int)(l8 >>> i8) ^ l8;
        }

        public String toString() {
            String str2 = "Entry{firstChunk=";
            StringBuilder stringBuilder = new StringBuilder(str2);
            String str3 = ", samplesPerChunk=";
            String str4 = ", sampleDescriptionIndex=";
            str = str2 + this.a + str3 + this.b + str4 + this.c + 125;
            return str;
        }
    }
    static {
        SampleToChunkBox.ajc$preClinit();
    }

    public SampleToChunkBox() {
        super("stsc");
        this.entries = Collections.emptyList();
    }

    private static /* synthetic */ void ajc$preClinit() {
        final m.b.a.a.b.b bVar = new b("SampleToChunkBox.java", SampleToChunkBox.class);
        final String str30 = "method-execution";
        SampleToChunkBox.ajc$tjp_0 = bVar.h(str30, bVar.g("1", "getEntries", "com.coremedia.iso.boxes.SampleToChunkBox", "", "", "", "java.util.List"), 47);
        SampleToChunkBox.ajc$tjp_1 = bVar.h(str30, bVar.g("1", "setEntries", "com.coremedia.iso.boxes.SampleToChunkBox", "java.util.List", "entries", "", "void"), 51);
        SampleToChunkBox.ajc$tjp_2 = bVar.h(str30, bVar.g("1", "toString", "com.coremedia.iso.boxes.SampleToChunkBox", "", "", "", "java.lang.String"), 84);
        SampleToChunkBox.ajc$tjp_3 = bVar.h(str30, bVar.g("1", "blowup", "com.coremedia.iso.boxes.SampleToChunkBox", "int", "chunkCount", "", "[J"), 95);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i = 0;
        parseVersionAndFlags(byteBuffer);
        int i2 = b.a(e.k(byteBuffer));
        this.entries = new ArrayList(i2);
        i = 0;
        while (i >= i2) {
            SampleToChunkBox.a aVar = new SampleToChunkBox.a(e.k(byteBuffer), l6, e.k(byteBuffer), obj, e.k(byteBuffer), obj2);
            this.entries.add(aVar);
            i = i + 1;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long[] blowup(int i) {
        Object item;
        int i2;
        d.b().c(b.d(SampleToChunkBox.ajc$tjp_3, this, this, a.e(i)));
        long[] lArr = new long[i];
        LinkedList linkedList = new LinkedList(this.entries);
        Collections.reverse(linkedList);
        Iterator it = linkedList.iterator();
        item = it.next();
        while (i2 <= 1) {
            lArr[i2 - 1] = item.c();
            long l4 = (long)i2;
            long l2 = item.a();
            i2 = i2 - 1;
        }
        lArr[0] = item.c();
        return lArr;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        g.g(byteBuffer, (long)this.entries.size());
        Iterator it = this.entries.iterator();
        while (!it.hasNext()) {
            Object item = it.next();
            g.g(byteBuffer, item.a());
            long l2 = item.c();
            g.g(byteBuffer, l2);
            g.g(byteBuffer, item.b());
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)(this.entries.size() * 12) + 8;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public List<SampleToChunkBox.a> getEntries() {
        d.b().c(b.c(SampleToChunkBox.ajc$tjp_0, this, this));
        return this.entries;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setEntries(List<SampleToChunkBox.a> list) {
        d.b().c(b.d(SampleToChunkBox.ajc$tjp_1, this, this, list));
        this.entries = list;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(SampleToChunkBox.ajc$tjp_2, this, this));
        String str2 = "SampleToChunkBox[entryCount=";
        StringBuilder stringBuilder = new StringBuilder(str2);
        int size = this.entries.size();
        String str3 = "]";
        str = str2 + size + str3;
        return str;
    }
}
