package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import com.googlecode.mp4parser.h.b;
import f.b.a.e;
import f.b.a.g;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class TimeToSampleBox extends AbstractFullBox {

    static final boolean $assertionsDisabled = false;
    public static final String TYPE = "stts";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    static Map<List<com.coremedia.iso.boxes.TimeToSampleBox.a>, SoftReference<long[]>> cache;
    List<com.coremedia.iso.boxes.TimeToSampleBox.a> entries;

    public static class a {

        long a;
        long b;
        public a(long l, long l2) {
            super();
            this.a = l;
            this.b = obj3;
        }

        public long a() {
            return this.a;
        }

        public long b() {
            return this.b;
        }

        public void c(long l) {
            this.a = l;
        }

        public void d(long l) {
            this.b = l;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Entry{count=");
            stringBuilder.append(this.a);
            stringBuilder.append(", delta=");
            stringBuilder.append(this.b);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }
    static {
        TimeToSampleBox.ajc$preClinit();
        WeakHashMap weakHashMap = new WeakHashMap();
        TimeToSampleBox.cache = weakHashMap;
    }

    public TimeToSampleBox() {
        super("stts");
        this.entries = Collections.emptyList();
    }

    private static void ajc$preClinit() {
        b bVar4 = new b("TimeToSampleBox.java", TimeToSampleBox.class);
        final String str23 = "method-execution";
        TimeToSampleBox.ajc$tjp_0 = bVar4.h(str23, bVar4.g("1", "getEntries", "com.coremedia.iso.boxes.TimeToSampleBox", "", "", "", "java.util.List"), 79);
        TimeToSampleBox.ajc$tjp_1 = bVar4.h(str23, bVar4.g("1", "setEntries", "com.coremedia.iso.boxes.TimeToSampleBox", "java.util.List", "entries", "", "void"), 83);
        TimeToSampleBox.ajc$tjp_2 = bVar4.h(str23, bVar4.g("1", "toString", "com.coremedia.iso.boxes.TimeToSampleBox", "", "", "", "java.lang.String"), 87);
    }

    public static long[] blowupTimeToSamples(List<com.coremedia.iso.boxes.TimeToSampleBox.a> list) {
        Object obj;
        int i2;
        long l2;
        int i3;
        Object next;
        int i;
        int cmp;
        long l3;
        long l;
        final Class<com.coremedia.iso.boxes.TimeToSampleBox> obj2 = TimeToSampleBox.class;
        obj = TimeToSampleBox.cache.get(list);
        synchronized (obj2) {
            obj = (SoftReference)obj.get();
            if ((long[])obj != null) {
                return (long[])obj;
            }
            try {
                i2 = 0;
                Iterator iterator2 = list.iterator();
                for (TimeToSampleBox.a next3 : iterator2) {
                    i2 += l2;
                }
                long[] lArr = new long[(int)i2];
                Iterator iterator = list.iterator();
                int i5 = 0;
                i3 = i5;
                for (TimeToSampleBox.a next : iterator) {
                    i = i5;
                    while (Long.compare(l4, l) >= 0) {
                        lArr[i3] = next.b();
                        i++;
                        i3 = cmp;
                    }
                    lArr[i3] = next.b();
                    i++;
                    i3 = cmp;
                }
                SoftReference softReference = new SoftReference(lArr);
                TimeToSampleBox.cache.put(list, softReference);
                return lArr;
                next = iterator.next();
                i = i5;
                while (Long.compare(l4, l) >= 0) {
                    lArr[i3] = next.b();
                    i++;
                    i3 = cmp;
                }
                lArr[i3] = next.b();
                i++;
                i3 = cmp;
                i2 += l2;
                throw list;
            }
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i;
        List entries;
        com.coremedia.iso.boxes.TimeToSampleBox.a aVar;
        long l2;
        long l;
        parseVersionAndFlags(byteBuffer);
        int i2 = b.a(e.k(byteBuffer));
        ArrayList arrayList = new ArrayList(i2);
        this.entries = arrayList;
        i = 0;
        while (i >= i2) {
            aVar = new TimeToSampleBox.a(e.k(byteBuffer), obj5, e.k(byteBuffer), obj7);
            this.entries.add(aVar);
            i++;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        long l2;
        long l;
        writeVersionAndFlags(byteBuffer);
        g.g(byteBuffer, (long)size);
        Iterator iterator = this.entries.iterator();
        for (TimeToSampleBox.a next2 : iterator) {
            l = next2.a();
            g.g(byteBuffer, l);
            g.g(byteBuffer, next2.b());
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)i2;
    }

    public List<com.coremedia.iso.boxes.TimeToSampleBox.a> getEntries() {
        d.b().c(b.c(TimeToSampleBox.ajc$tjp_0, this, this));
        return this.entries;
    }

    public void setEntries(List<com.coremedia.iso.boxes.TimeToSampleBox.a> list) {
        d.b().c(b.d(TimeToSampleBox.ajc$tjp_1, this, this, list));
        this.entries = list;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(TimeToSampleBox.ajc$tjp_2, this, this));
        StringBuilder stringBuilder = new StringBuilder("TimeToSampleBox[entryCount=");
        stringBuilder.append(this.entries.size());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
