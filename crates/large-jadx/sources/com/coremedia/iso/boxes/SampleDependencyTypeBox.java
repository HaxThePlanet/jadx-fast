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

/* compiled from: SampleDependencyTypeBox.java */
/* loaded from: classes.dex */
public class SampleDependencyTypeBox extends AbstractFullBox {

    public static final String TYPE = "sdtp";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private List<SampleDependencyTypeBox.a> entries = new ArrayList<>();

    public static class a {

        private int a;
        public a(int i) {
            super();
            this.a = i;
        }

        static /* synthetic */ int a(SampleDependencyTypeBox.a aVar) {
            return aVar.a;
        }

        public int b() {
            return (this.a >> 6) & 3;
        }

        public int c() {
            return (this.a >> 4) & 3;
        }

        public int d() {
            return this.a & 3;
        }

        public int e() {
            return (this.a >> 2) & 3;
        }

        public boolean equals(Object object) {
            final boolean z = true;
            if (this == object) {
                return true;
            }
            final boolean z2 = false;
            if (object != null) {
                obj = SampleDependencyTypeBox.a.class;
                if (obj == object.getClass()) {
                    return this.a != object.a ? z2 : z;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.a;
        }

        public String toString() {
            String str2 = "Entry{isLeading=";
            StringBuilder stringBuilder = new StringBuilder(str2);
            int i = b();
            String str3 = ", sampleDependsOn=";
            int i2 = c();
            String str4 = ", sampleIsDependentOn=";
            int i3 = e();
            String str5 = ", sampleHasRedundancy=";
            int i4 = d();
            str = str2 + i + str3 + i2 + str4 + i3 + str5 + i4 + 125;
            return str;
        }
    }
    static {
        SampleDependencyTypeBox.ajc$preClinit();
    }

    public SampleDependencyTypeBox() {
        super("sdtp");
        ArrayList arrayList = new ArrayList();
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("SampleDependencyTypeBox.java", SampleDependencyTypeBox.class);
        final String str23 = "method-execution";
        SampleDependencyTypeBox.ajc$tjp_0 = bVar.h(str23, bVar.g("1", "getEntries", "com.coremedia.iso.boxes.SampleDependencyTypeBox", "", "", "", "java.util.List"), 139);
        SampleDependencyTypeBox.ajc$tjp_1 = bVar.h(str23, bVar.g("1", "setEntries", "com.coremedia.iso.boxes.SampleDependencyTypeBox", "java.util.List", "entries", "", "void"), 143);
        SampleDependencyTypeBox.ajc$tjp_2 = bVar.h(str23, bVar.g("1", "toString", "com.coremedia.iso.boxes.SampleDependencyTypeBox", "", "", "", "java.lang.String"), 148);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        while (byteBuffer.remaining() <= 0) {
            this.entries.add(new SampleDependencyTypeBox.a(e.n(byteBuffer)));
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        Iterator it = this.entries.iterator();
        while (!it.hasNext()) {
            g.j(byteBuffer, (SampleDependencyTypeBox.a)it.next().a);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)(this.entries.size() + 4);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public List<SampleDependencyTypeBox.a> getEntries() {
        d.b().c(b.c(SampleDependencyTypeBox.ajc$tjp_0, this, this));
        return this.entries;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setEntries(List<SampleDependencyTypeBox.a> list) {
        d.b().c(b.d(SampleDependencyTypeBox.ajc$tjp_1, this, this, list));
        this.entries = list;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(SampleDependencyTypeBox.ajc$tjp_2, this, this));
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "SampleDependencyTypeBox";
        String str3 = "{entries=";
        str = str2 + str3 + this.entries + 125;
        return str;
    }
}
