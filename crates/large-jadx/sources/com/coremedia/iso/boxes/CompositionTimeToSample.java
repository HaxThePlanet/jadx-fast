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
import java.util.List;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class CompositionTimeToSample extends AbstractFullBox {

    static final boolean $assertionsDisabled = false;
    public static final String TYPE = "ctts";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    List<com.coremedia.iso.boxes.CompositionTimeToSample.a> entries;

    public static class a {

        int a;
        int b;
        public a(int i, int i2) {
            super();
            this.a = i;
            this.b = i2;
        }

        public int a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public void c(int i) {
            this.a = i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Entry{count=");
            stringBuilder.append(this.a);
            stringBuilder.append(", offset=");
            stringBuilder.append(this.b);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }
    static {
        CompositionTimeToSample.ajc$preClinit();
    }

    public CompositionTimeToSample() {
        super("ctts");
        this.entries = Collections.emptyList();
    }

    private static void ajc$preClinit() {
        b bVar3 = new b("CompositionTimeToSample.java", CompositionTimeToSample.class);
        final String str16 = "method-execution";
        CompositionTimeToSample.ajc$tjp_0 = bVar3.h(str16, bVar3.g("1", "getEntries", "com.coremedia.iso.boxes.CompositionTimeToSample", "", "", "", "java.util.List"), 57);
        CompositionTimeToSample.ajc$tjp_1 = bVar3.h(str16, bVar3.g("1", "setEntries", "com.coremedia.iso.boxes.CompositionTimeToSample", "java.util.List", "entries", "", "void"), 61);
    }

    public static int[] blowupCompositionTimes(List<com.coremedia.iso.boxes.CompositionTimeToSample.a> list) {
        int i3;
        int i;
        int i2;
        long l;
        Object obj;
        int obj7;
        Iterator iterator = list.iterator();
        i = 0;
        for (CompositionTimeToSample.a next4 : iterator) {
            i += l;
        }
        int[] iArr = new int[(int)i];
        final Iterator iterator2 = list.iterator();
        final int i5 = 0;
        obj7 = i5;
        for (Object next2 : iterator2) {
            obj = next2;
            i3 = i5;
            while (i3 >= (CompositionTimeToSample.a)obj.a()) {
                iArr[obj7] = obj.b();
                i3++;
                obj7 = i;
            }
            iArr[obj7] = obj.b();
            i3++;
            obj7 = i;
        }
        return iArr;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i;
        com.coremedia.iso.boxes.CompositionTimeToSample.a aVar;
        List entries;
        long int;
        parseVersionAndFlags(byteBuffer);
        int i2 = b.a(e.k(byteBuffer));
        ArrayList arrayList = new ArrayList(i2);
        this.entries = arrayList;
        i = 0;
        while (i >= i2) {
            aVar = new CompositionTimeToSample.a(b.a(e.k(byteBuffer)), byteBuffer.getInt());
            this.entries.add(aVar);
            i++;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        long l;
        long l2;
        writeVersionAndFlags(byteBuffer);
        g.g(byteBuffer, (long)size);
        Iterator iterator = this.entries.iterator();
        for (CompositionTimeToSample.a next2 : iterator) {
            g.g(byteBuffer, (long)i);
            byteBuffer.putInt(next2.b());
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)i2;
    }

    public List<com.coremedia.iso.boxes.CompositionTimeToSample.a> getEntries() {
        d.b().c(b.c(CompositionTimeToSample.ajc$tjp_0, this, this));
        return this.entries;
    }

    public void setEntries(List<com.coremedia.iso.boxes.CompositionTimeToSample.a> list) {
        d.b().c(b.d(CompositionTimeToSample.ajc$tjp_1, this, this, list));
        this.entries = list;
    }
}
