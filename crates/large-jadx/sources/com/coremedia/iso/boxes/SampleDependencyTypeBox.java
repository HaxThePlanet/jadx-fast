package com.coremedia.iso.boxes;

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

/* loaded from: classes.dex */
public class SampleDependencyTypeBox extends AbstractFullBox {

    public static final String TYPE = "sdtp";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private List<com.coremedia.iso.boxes.SampleDependencyTypeBox.a> entries;

    public static class a {

        private int a;
        public a(int i) {
            super();
            this.a = i;
        }

        static int a(com.coremedia.iso.boxes.SampleDependencyTypeBox.a sampleDependencyTypeBox$a) {
            return a.a;
        }

        public int b() {
            return i2 &= 3;
        }

        public int c() {
            return i2 &= 3;
        }

        public int d() {
            return i &= 3;
        }

        public int e() {
            return i2 &= 3;
        }

        public boolean equals(Object object) {
            Class<com.coremedia.iso.boxes.SampleDependencyTypeBox.a> obj;
            Class class;
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (object != null) {
                if (SampleDependencyTypeBox.a.class != object.getClass()) {
                } else {
                    if (this.a != object.a) {
                        return i2;
                    }
                }
                return i;
            }
            return i2;
        }

        public int hashCode() {
            return this.a;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Entry{isLeading=");
            stringBuilder.append(b());
            stringBuilder.append(", sampleDependsOn=");
            stringBuilder.append(c());
            stringBuilder.append(", sampleIsDependentOn=");
            stringBuilder.append(e());
            stringBuilder.append(", sampleHasRedundancy=");
            stringBuilder.append(d());
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }
    static {
        SampleDependencyTypeBox.ajc$preClinit();
    }

    public SampleDependencyTypeBox() {
        super("sdtp");
        ArrayList arrayList = new ArrayList();
        this.entries = arrayList;
    }

    private static void ajc$preClinit() {
        b bVar4 = new b("SampleDependencyTypeBox.java", SampleDependencyTypeBox.class);
        final String str23 = "method-execution";
        SampleDependencyTypeBox.ajc$tjp_0 = bVar4.h(str23, bVar4.g("1", "getEntries", "com.coremedia.iso.boxes.SampleDependencyTypeBox", "", "", "", "java.util.List"), 139);
        SampleDependencyTypeBox.ajc$tjp_1 = bVar4.h(str23, bVar4.g("1", "setEntries", "com.coremedia.iso.boxes.SampleDependencyTypeBox", "java.util.List", "entries", "", "void"), 143);
        SampleDependencyTypeBox.ajc$tjp_2 = bVar4.h(str23, bVar4.g("1", "toString", "com.coremedia.iso.boxes.SampleDependencyTypeBox", "", "", "", "java.lang.String"), 148);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        List entries;
        com.coremedia.iso.boxes.SampleDependencyTypeBox.a aVar;
        int i;
        parseVersionAndFlags(byteBuffer);
        while (byteBuffer.remaining() <= 0) {
            aVar = new SampleDependencyTypeBox.a(e.n(byteBuffer));
            this.entries.add(aVar);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        int i;
        writeVersionAndFlags(byteBuffer);
        Iterator iterator = this.entries.iterator();
        for (SampleDependencyTypeBox.a next2 : iterator) {
            g.j(byteBuffer, SampleDependencyTypeBox.a.a(next2));
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)i;
    }

    public List<com.coremedia.iso.boxes.SampleDependencyTypeBox.a> getEntries() {
        d.b().c(b.c(SampleDependencyTypeBox.ajc$tjp_0, this, this));
        return this.entries;
    }

    public void setEntries(List<com.coremedia.iso.boxes.SampleDependencyTypeBox.a> list) {
        d.b().c(b.d(SampleDependencyTypeBox.ajc$tjp_1, this, this, list));
        this.entries = list;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(SampleDependencyTypeBox.ajc$tjp_2, this, this));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SampleDependencyTypeBox");
        stringBuilder.append("{entries=");
        stringBuilder.append(this.entries);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
