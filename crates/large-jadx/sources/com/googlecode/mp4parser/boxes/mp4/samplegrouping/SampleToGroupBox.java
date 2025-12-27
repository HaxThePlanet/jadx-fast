package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: SampleToGroupBox.java */
/* loaded from: classes2.dex */
public class SampleToGroupBox extends AbstractFullBox {

    public static final String TYPE = "sbgp";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    private static final /* synthetic */ a.a ajc$tjp_4;
    private static final /* synthetic */ a.a ajc$tjp_5;
    List<SampleToGroupBox.a> entries = new LinkedList<>();
    private String groupingType;
    private String groupingTypeParameter;

    public static class a {

        private long a;
        private int b;
        public a(long j, int i) {
            super();
            this.a = j;
            this.b = i;
        }

        public int a() {
            return this.b;
        }

        public long b() {
            return this.a;
        }

        public void c(long j) {
            this.a = j;
        }

        public boolean equals(Object object) {
            final boolean z = true;
            if (this == object) {
                return true;
            }
            final boolean z2 = false;
            if (object != null) {
                obj = SampleToGroupBox.a.class;
                if (obj == object.getClass()) {
                    if (this.b != object.b) {
                        return false;
                    }
                    return this.a != object.a ? z2 : z;
                }
            }
            return false;
        }

        public int hashCode() {
            return (int)(l ^ (l >>> 32L)) * 31 + this.b;
        }

        public String toString() {
            String str2 = "Entry{sampleCount=";
            StringBuilder stringBuilder = new StringBuilder(str2);
            String str3 = ", groupDescriptionIndex=";
            str = str2 + this.a + str3 + this.b + 125;
            return str;
        }
    }
    static {
        SampleToGroupBox.ajc$preClinit();
    }

    public SampleToGroupBox() {
        super("sbgp");
        LinkedList linkedList = new LinkedList();
    }

    private static /* synthetic */ void ajc$preClinit() {
        final m.b.a.a.b.b bVar = new b("SampleToGroupBox.java", SampleToGroupBox.class);
        final String str44 = "method-execution";
        SampleToGroupBox.ajc$tjp_0 = bVar.h(str44, bVar.g("1", "getGroupingType", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox", "", "", "", "java.lang.String"), 150);
        SampleToGroupBox.ajc$tjp_1 = bVar.h(str44, bVar.g("1", "setGroupingType", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox", "java.lang.String", "groupingType", "", "void"), 154);
        SampleToGroupBox.ajc$tjp_2 = bVar.h(str44, bVar.g("1", "getGroupingTypeParameter", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox", "", "", "", "java.lang.String"), 158);
        SampleToGroupBox.ajc$tjp_3 = bVar.h(str44, bVar.g("1", "setGroupingTypeParameter", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox", "java.lang.String", "groupingTypeParameter", "", "void"), 162);
        SampleToGroupBox.ajc$tjp_4 = bVar.h(str44, bVar.g("1", "getEntries", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox", "", "", "", "java.util.List"), 166);
        SampleToGroupBox.ajc$tjp_5 = bVar.h(str44, bVar.g("1", "setEntries", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox", "java.util.List", "entries", "", "void"), 170);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        long l;
        parseVersionAndFlags(byteBuffer);
        this.groupingType = e.b(byteBuffer);
        int i = 1;
        if (getVersion() == 1) {
            this.groupingTypeParameter = e.b(byteBuffer);
        }
        l = e.k(byteBuffer);
        l = l - 1L;
        while (l <= 0) {
            l2 = (long)b.a(e.k(byteBuffer));
            this.entries.add(new SampleToGroupBox.a(l2, l4, b.a(e.k(byteBuffer))));
            l = l - 1L;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) throws java.io.UnsupportedEncodingException {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(this.groupingType.getBytes());
        int i = 1;
        if (getVersion() == i) {
            byteBuffer.put(this.groupingTypeParameter.getBytes());
        }
        g.g(byteBuffer, (long)this.entries.size());
        Iterator it = this.entries.iterator();
        while (!it.hasNext()) {
            Object item = it.next();
            long l = item.b();
            g.g(byteBuffer, l);
            g.g(byteBuffer, (long)item.a());
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i;
        if (getVersion() == 1) {
            i = (this.entries.size() * 8) + 16;
        } else {
            i = (this.entries.size() * 8) + 12;
        }
        return (long)i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public List<SampleToGroupBox.a> getEntries() {
        d.b().c(b.c(SampleToGroupBox.ajc$tjp_4, this, this));
        return this.entries;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getGroupingType() {
        d.b().c(b.c(SampleToGroupBox.ajc$tjp_0, this, this));
        return this.groupingType;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getGroupingTypeParameter() {
        d.b().c(b.c(SampleToGroupBox.ajc$tjp_2, this, this));
        return this.groupingTypeParameter;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setEntries(List<SampleToGroupBox.a> list) {
        d.b().c(b.d(SampleToGroupBox.ajc$tjp_5, this, this, list));
        this.entries = list;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setGroupingType(String str) {
        d.b().c(b.d(SampleToGroupBox.ajc$tjp_1, this, this, str));
        this.groupingType = str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setGroupingTypeParameter(String str) {
        d.b().c(b.d(SampleToGroupBox.ajc$tjp_3, this, this, str));
        this.groupingTypeParameter = str;
    }
}
