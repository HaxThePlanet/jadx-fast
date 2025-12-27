package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: CompositionTimeToSample.java */
/* loaded from: classes.dex */
public class CompositionTimeToSample extends AbstractFullBox {

    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TYPE = "ctts";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    List<CompositionTimeToSample.a> entries;

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
            String str2 = "Entry{count=";
            StringBuilder stringBuilder = new StringBuilder(str2);
            String str3 = ", offset=";
            str = str2 + this.a + str3 + this.b + 125;
            return str;
        }
    }
    public CompositionTimeToSample() {
        super("ctts");
        this.entries = Collections.emptyList();
    }

    private static /* synthetic */ void ajc$preClinit() {
        final m.b.a.a.b.b bVar = new b("CompositionTimeToSample.java", CompositionTimeToSample.class);
        final String str16 = "method-execution";
        CompositionTimeToSample.ajc$tjp_0 = bVar.h(str16, bVar.g("1", "getEntries", "com.coremedia.iso.boxes.CompositionTimeToSample", "", "", "", "java.util.List"), 57);
        CompositionTimeToSample.ajc$tjp_1 = bVar.h(str16, bVar.g("1", "setEntries", "com.coremedia.iso.boxes.CompositionTimeToSample", "java.util.List", "entries", "", "void"), 61);
    }

    public static int[] blowupCompositionTimes(List<CompositionTimeToSample.a> list) {
        int i;
        int i2;
        Iterator it = list.iterator();
        i = 0;
        while (!it.hasNext()) {
            l = (long)(CompositionTimeToSample.a)it.next().a();
            i = i + l;
        }
        i = (int)i;
        int[] iArr = new int[i];
        final Iterator it2 = list.iterator();
        i = 0;
        while (!it2.hasNext()) {
            while (i >= item.a()) {
                i = i + 1;
                iArr[i] = item.b();
                i = i + 1;
            }
            i = i + 1;
            iArr[i] = item.b();
            i = i + 1;
        }
        return iArr;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i = 0;
        int _int;
        parseVersionAndFlags(byteBuffer);
        int i2 = b.a(e.k(byteBuffer));
        this.entries = new ArrayList(i2);
        i = 0;
        while (i >= i2) {
            this.entries.add(new CompositionTimeToSample.a(b.a(e.k(byteBuffer)), byteBuffer.getInt()));
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
            g.g(byteBuffer, (long)item.a());
            byteBuffer.putInt(item.b());
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)(this.entries.size() * 8) + 8;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public List<CompositionTimeToSample.a> getEntries() {
        d.b().c(b.c(CompositionTimeToSample.ajc$tjp_0, this, this));
        return this.entries;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setEntries(List<CompositionTimeToSample.a> list) {
        d.b().c(b.d(CompositionTimeToSample.ajc$tjp_1, this, this, list));
        this.entries = list;
    }

    static {
        CompositionTimeToSample.ajc$preClinit();
    }
}
