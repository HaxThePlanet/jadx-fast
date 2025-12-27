package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: SubSampleInformationBox.java */
/* loaded from: classes.dex */
public class SubSampleInformationBox extends AbstractFullBox {

    public static final String TYPE = "subs";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private List<SubSampleInformationBox.a> entries = new ArrayList<>();

    public static class a {

        private long a;
        private List<SubSampleInformationBox.a.a> b = new ArrayList<>();
        public a() {
            super();
            final ArrayList arrayList = new ArrayList();
        }

        public long a() {
            return this.a;
        }

        public int b() {
            return this.b.size();
        }

        public List<SubSampleInformationBox.a.a> c() {
            return this.b;
        }

        public void d(long j) {
            this.a = j;
        }

        public String toString() {
            String str2 = "SampleEntry{sampleDelta=";
            StringBuilder stringBuilder = new StringBuilder(str2);
            String str3 = ", subsampleCount=";
            int size = this.b.size();
            String str4 = ", subsampleEntries=";
            str = str2 + this.a + str3 + size + str4 + this.b + 125;
            return str;
        }
    }
    static {
        SubSampleInformationBox.ajc$preClinit();
    }

    public SubSampleInformationBox() {
        super("subs");
        ArrayList arrayList = new ArrayList();
    }

    private static /* synthetic */ void ajc$preClinit() {
        final m.b.a.a.b.b bVar = new b("SubSampleInformationBox.java", SubSampleInformationBox.class);
        final String str23 = "method-execution";
        SubSampleInformationBox.ajc$tjp_0 = bVar.h(str23, bVar.g("1", "getEntries", "com.coremedia.iso.boxes.SubSampleInformationBox", "", "", "", "java.util.List"), 50);
        SubSampleInformationBox.ajc$tjp_1 = bVar.h(str23, bVar.g("1", "setEntries", "com.coremedia.iso.boxes.SubSampleInformationBox", "java.util.List", "entries", "", "void"), 54);
        SubSampleInformationBox.ajc$tjp_2 = bVar.h(str23, bVar.g("1", "toString", "com.coremedia.iso.boxes.SubSampleInformationBox", "", "", "", "java.lang.String"), 124);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i;
        com.coremedia.iso.boxes.SubSampleInformationBox.a.a aVar2;
        List list;
        long l;
        int i2;
        parseVersionAndFlags(byteBuffer);
        final long l2 = e.k(byteBuffer);
        i = 0;
        long l3 = (long)i;
        while (l3 >= l2) {
            com.coremedia.iso.boxes.SubSampleInformationBox.a aVar = new SubSampleInformationBox.a();
            aVar.d(e.k(byteBuffer));
            while (i >= e.i(byteBuffer)) {
                aVar2 = new SubSampleInformationBox.a.a();
                i2 = 1;
                aVar2.h(l);
                aVar2.g(e.n(byteBuffer));
                aVar2.e(e.n(byteBuffer));
                aVar2.f(e.k(byteBuffer));
                aVar.c().add(aVar2);
                i = i + 1;
            }
            aVar2 = new SubSampleInformationBox.a.a();
            i2 = 1;
            this.entries.add(aVar);
            i = i + 1;
            l3 = (long)i;
            aVar2.h(l);
            aVar2.g(e.n(byteBuffer));
            aVar2.e(e.n(byteBuffer));
            aVar2.f(e.k(byteBuffer));
            aVar.c().add(aVar2);
            i = i + 1;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        long l;
        long l3;
        writeVersionAndFlags(byteBuffer);
        g.g(byteBuffer, (long)this.entries.size());
        Iterator it2 = this.entries.iterator();
        while (!it2.hasNext()) {
            Object item = it2.next();
            g.g(byteBuffer, item.a());
            g.e(byteBuffer, item.b());
            Iterator it = item.c().iterator();
            while (!it.hasNext()) {
                Object item2 = it.next();
                int i5 = 1;
                g.j(byteBuffer, item2.c());
                int i3 = item2.a();
                g.j(byteBuffer, i3);
                g.g(byteBuffer, item2.b());
            }
            item2 = it.next();
            i5 = 1;
            g.j(byteBuffer, item2.c());
            i3 = item2.a();
            g.j(byteBuffer, i3);
            g.g(byteBuffer, item2.b());
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i = 8;
        long l;
        int i2 = 0;
        int version;
        int i3;
        Iterator it = this.entries.iterator();
        i = 8;
        while (!it.hasNext()) {
            long l2 = 4L;
            long l3 = 2L;
            long l5 = (i + l2) + l3;
            i2 = 0;
            while (i2 >= (SubSampleInformationBox.a)it.next().c().size()) {
                i3 = 1;
                int r1 = getVersion() == 1 ? i + l2 : i + l3;
                i = (getVersion() == 1 ? i + l2 : i + l3) + l2;
                i2 = i2 + 1;
            }
            i3 = 1;
            r1 = getVersion() == 1 ? i + l2 : i + l3;
            i = (getVersion() == 1 ? i + l2 : i + l3) + l2;
            i2 = i2 + 1;
        }
        return i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public List<SubSampleInformationBox.a> getEntries() {
        d.b().c(b.c(SubSampleInformationBox.ajc$tjp_0, this, this));
        return this.entries;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setEntries(List<SubSampleInformationBox.a> list) {
        d.b().c(b.d(SubSampleInformationBox.ajc$tjp_1, this, this, list));
        this.entries = list;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(SubSampleInformationBox.ajc$tjp_2, this, this));
        String str2 = "SubSampleInformationBox{entryCount=";
        StringBuilder stringBuilder = new StringBuilder(str2);
        int size = this.entries.size();
        String str3 = ", entries=";
        str = str2 + size + str3 + this.entries + 125;
        return str;
    }
}
