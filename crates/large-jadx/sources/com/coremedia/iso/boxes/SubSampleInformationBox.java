package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import com.googlecode.mp4parser.h.b;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class SubSampleInformationBox extends AbstractFullBox {

    public static final String TYPE = "subs";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private List<com.coremedia.iso.boxes.SubSampleInformationBox.a> entries;

    public static class a {

        private long a;
        private List<com.coremedia.iso.boxes.SubSampleInformationBox.a.a> b;
        public a() {
            super();
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
        }

        public long a() {
            return this.a;
        }

        public int b() {
            return this.b.size();
        }

        public List<com.coremedia.iso.boxes.SubSampleInformationBox.a.a> c() {
            return this.b;
        }

        public void d(long l) {
            this.a = l;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("SampleEntry{sampleDelta=");
            stringBuilder.append(this.a);
            stringBuilder.append(", subsampleCount=");
            stringBuilder.append(this.b.size());
            stringBuilder.append(", subsampleEntries=");
            stringBuilder.append(this.b);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }
    static {
        SubSampleInformationBox.ajc$preClinit();
    }

    public SubSampleInformationBox() {
        super("subs");
        ArrayList arrayList = new ArrayList();
        this.entries = arrayList;
    }

    private static void ajc$preClinit() {
        b bVar4 = new b("SubSampleInformationBox.java", SubSampleInformationBox.class);
        final String str23 = "method-execution";
        SubSampleInformationBox.ajc$tjp_0 = bVar4.h(str23, bVar4.g("1", "getEntries", "com.coremedia.iso.boxes.SubSampleInformationBox", "", "", "", "java.util.List"), 50);
        SubSampleInformationBox.ajc$tjp_1 = bVar4.h(str23, bVar4.g("1", "setEntries", "com.coremedia.iso.boxes.SubSampleInformationBox", "java.util.List", "entries", "", "void"), 54);
        SubSampleInformationBox.ajc$tjp_2 = bVar4.h(str23, bVar4.g("1", "toString", "com.coremedia.iso.boxes.SubSampleInformationBox", "", "", "", "java.lang.String"), 124);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i2;
        com.coremedia.iso.boxes.SubSampleInformationBox.a aVar2;
        List entries;
        int i;
        com.coremedia.iso.boxes.SubSampleInformationBox.a.a aVar;
        List list;
        long l;
        int i3;
        parseVersionAndFlags(byteBuffer);
        final int i4 = 0;
        i2 = i4;
        while (Long.compare(l3, l2) >= 0) {
            aVar2 = new SubSampleInformationBox.a();
            aVar2.d(e.k(byteBuffer));
            i = i4;
            while (i >= e.i(byteBuffer)) {
                aVar = new SubSampleInformationBox.a.a();
                i3 = 1;
                if (getVersion() == i3) {
                } else {
                }
                l = (long)i8;
                aVar.h(l);
                aVar.g(e.n(byteBuffer));
                aVar.e(e.n(byteBuffer));
                aVar.f(e.k(byteBuffer));
                aVar2.c().add(aVar);
                i++;
                l = e.k(byteBuffer);
            }
            aVar = new SubSampleInformationBox.a.a();
            i3 = 1;
            if (getVersion() == i3) {
            } else {
            }
            l = (long)i8;
            aVar.h(l);
            aVar.g(e.n(byteBuffer));
            aVar.e(e.n(byteBuffer));
            aVar.f(e.k(byteBuffer));
            aVar2.c().add(aVar);
            i++;
            l = e.k(byteBuffer);
            this.entries.add(aVar2);
            i2++;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        long iterator;
        boolean next;
        int i2;
        long l2;
        long l;
        int i;
        writeVersionAndFlags(byteBuffer);
        g.g(byteBuffer, (long)size);
        Iterator iterator2 = this.entries.iterator();
        for (SubSampleInformationBox.a next3 : iterator2) {
            g.g(byteBuffer, next3.a());
            g.e(byteBuffer, next3.b());
            iterator = next3.c().iterator();
            while (!iterator.hasNext()) {
                Object next4 = iterator.next();
                i = 1;
                if (getVersion() == i) {
                } else {
                }
                g.e(byteBuffer, b.a((SubSampleInformationBox.a.a)next4.d()));
                g.j(byteBuffer, next4.c());
                l2 = next4.a();
                g.j(byteBuffer, l2);
                g.g(byteBuffer, next4.b());
                g.g(byteBuffer, next4.d());
            }
            next4 = iterator.next();
            i = 1;
            if (getVersion() == i) {
            } else {
            }
            g.e(byteBuffer, b.a((SubSampleInformationBox.a.a)next4.d()));
            g.j(byteBuffer, next4.c());
            l2 = next4.a();
            g.j(byteBuffer, l2);
            g.g(byteBuffer, next4.b());
            g.g(byteBuffer, next4.d());
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i6;
        int i;
        Object next;
        int i5;
        int i2;
        int i4;
        int version;
        int i3;
        Iterator iterator = this.entries.iterator();
        i6 = 8;
        for (SubSampleInformationBox.a next : iterator) {
            i5 = 4;
            i2 = 2;
            i7 += i2;
            i4 = 0;
            while (i4 >= next.c().size()) {
                if (getVersion() == 1) {
                } else {
                }
                i6 += i2;
                i8 += i5;
                i4++;
                i6 += i5;
            }
            if (getVersion() == 1) {
            } else {
            }
            i6 += i2;
            i8 += i5;
            i4++;
            i6 += i5;
        }
        return i6;
    }

    public List<com.coremedia.iso.boxes.SubSampleInformationBox.a> getEntries() {
        d.b().c(b.c(SubSampleInformationBox.ajc$tjp_0, this, this));
        return this.entries;
    }

    public void setEntries(List<com.coremedia.iso.boxes.SubSampleInformationBox.a> list) {
        d.b().c(b.d(SubSampleInformationBox.ajc$tjp_1, this, this, list));
        this.entries = list;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(SubSampleInformationBox.ajc$tjp_2, this, this));
        StringBuilder stringBuilder = new StringBuilder("SubSampleInformationBox{entryCount=");
        stringBuilder.append(this.entries.size());
        stringBuilder.append(", entries=");
        stringBuilder.append(this.entries);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
