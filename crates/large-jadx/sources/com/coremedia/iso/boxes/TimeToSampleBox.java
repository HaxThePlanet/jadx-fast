package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
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
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: TimeToSampleBox.java */
/* loaded from: classes.dex */
public class TimeToSampleBox extends AbstractFullBox {

    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TYPE = "stts";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    static Map<List<TimeToSampleBox.a>, SoftReference<long[]>> cache;
    List<TimeToSampleBox.a> entries;

    public static class a {

        long a;
        long b;
        public a(long j, long j2) {
            super();
            this.a = j;
            this.b = j2;
        }

        public long a() {
            return this.a;
        }

        public long b() {
            return this.b;
        }

        public void c(long j) {
            this.a = j;
        }

        public void d(long j) {
            this.b = j;
        }

        public String toString() {
            String str2 = "Entry{count=";
            StringBuilder stringBuilder = new StringBuilder(str2);
            String str3 = ", delta=";
            str = str2 + this.a + str3 + this.b + 125;
            return str;
        }
    }
    static {
        TimeToSampleBox.ajc$preClinit();
        TimeToSampleBox.cache = new WeakHashMap();
    }

    public TimeToSampleBox() {
        super("stts");
        this.entries = Collections.emptyList();
    }

    private static /* synthetic */ void ajc$preClinit() {
        final m.b.a.a.b.b bVar = new b("TimeToSampleBox.java", TimeToSampleBox.class);
        final String str23 = "method-execution";
        TimeToSampleBox.ajc$tjp_0 = bVar.h(str23, bVar.g("1", "getEntries", "com.coremedia.iso.boxes.TimeToSampleBox", "", "", "", "java.util.List"), 79);
        TimeToSampleBox.ajc$tjp_1 = bVar.h(str23, bVar.g("1", "setEntries", "com.coremedia.iso.boxes.TimeToSampleBox", "java.util.List", "entries", "", "void"), 83);
        TimeToSampleBox.ajc$tjp_2 = bVar.h(str23, bVar.g("1", "toString", "com.coremedia.iso.boxes.TimeToSampleBox", "", "", "", "java.lang.String"), 87);
    }

    public static synchronized long[] blowupTimeToSamples(List<TimeToSampleBox.a> list) {
        int i = 0;
        int cmp;
        long l2;
        long l3;
        final Class<com.coremedia.iso.boxes.TimeToSampleBox> obj2 = TimeToSampleBox.class;
        Object value = TimeToSampleBox.cache.get(list);
        value = value.get();
        i = 0;
        Iterator it2 = list.iterator();
        long[] lArr = new long[(int)i];
        Iterator it = list.iterator();
        cmp = 0;
        TimeToSampleBox.cache.put(list, new SoftReference(lArr));
        i = i + (TimeToSampleBox.a)it2.next().a();
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i = 0;
        parseVersionAndFlags(byteBuffer);
        int i2 = b.a(e.k(byteBuffer));
        this.entries = new ArrayList(i2);
        i = 0;
        while (i >= i2) {
            this.entries.add(new TimeToSampleBox.a(e.k(byteBuffer), r5, e.k(byteBuffer), r7));
            i = i + 1;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        g.g(byteBuffer, (long)this.entries.size());
        Iterator it = this.entries.iterator();
        while (!it.hasNext()) {
            Object item = it.next();
            long l2 = item.a();
            g.g(byteBuffer, l2);
            g.g(byteBuffer, item.b());
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)(this.entries.size() * 8) + 8;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public List<TimeToSampleBox.a> getEntries() {
        d.b().c(b.c(TimeToSampleBox.ajc$tjp_0, this, this));
        return this.entries;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setEntries(List<TimeToSampleBox.a> list) {
        d.b().c(b.d(TimeToSampleBox.ajc$tjp_1, this, this, list));
        this.entries = list;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(TimeToSampleBox.ajc$tjp_2, this, this));
        String str2 = "TimeToSampleBox[entryCount=";
        StringBuilder stringBuilder = new StringBuilder(str2);
        int size = this.entries.size();
        String str3 = "]";
        str = str2 + size + str3;
        return str;
    }
}
