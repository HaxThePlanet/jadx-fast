package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import com.googlecode.mp4parser.h.b;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public class SampleToGroupBox extends AbstractFullBox {

    public static final String TYPE = "sbgp";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    List<com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox.a> entries;
    private String groupingType;
    private String groupingTypeParameter;

    public static class a {

        private long a;
        private int b;
        public a(long l, int i2) {
            super();
            this.a = l;
            this.b = obj3;
        }

        public int a() {
            return this.b;
        }

        public long b() {
            return this.a;
        }

        public void c(long l) {
            this.a = l;
        }

        public boolean equals(Object object) {
            Class<com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox.a> obj;
            Class class;
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (object != null) {
                if (SampleToGroupBox.a.class != object.getClass()) {
                } else {
                    if (this.b != object.b) {
                        return i2;
                    }
                    if (Long.compare(l, l2) != 0) {
                        return i2;
                    }
                }
                return i;
            }
            return i2;
        }

        public int hashCode() {
            long l = this.a;
            return i3 += i5;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Entry{sampleCount=");
            stringBuilder.append(this.a);
            stringBuilder.append(", groupDescriptionIndex=");
            stringBuilder.append(this.b);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }
    static {
        SampleToGroupBox.ajc$preClinit();
    }

    public SampleToGroupBox() {
        super("sbgp");
        LinkedList linkedList = new LinkedList();
        this.entries = linkedList;
    }

    private static void ajc$preClinit() {
        b bVar7 = new b("SampleToGroupBox.java", SampleToGroupBox.class);
        final String str44 = "method-execution";
        SampleToGroupBox.ajc$tjp_0 = bVar7.h(str44, bVar7.g("1", "getGroupingType", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox", "", "", "", "java.lang.String"), 150);
        SampleToGroupBox.ajc$tjp_1 = bVar7.h(str44, bVar7.g("1", "setGroupingType", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox", "java.lang.String", "groupingType", "", "void"), 154);
        SampleToGroupBox.ajc$tjp_2 = bVar7.h(str44, bVar7.g("1", "getGroupingTypeParameter", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox", "", "", "", "java.lang.String"), 158);
        SampleToGroupBox.ajc$tjp_3 = bVar7.h(str44, bVar7.g("1", "setGroupingTypeParameter", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox", "java.lang.String", "groupingTypeParameter", "", "void"), 162);
        SampleToGroupBox.ajc$tjp_4 = bVar7.h(str44, bVar7.g("1", "getEntries", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox", "", "", "", "java.util.List"), 166);
        SampleToGroupBox.ajc$tjp_5 = bVar7.h(str44, bVar7.g("1", "setEntries", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox", "java.util.List", "entries", "", "void"), 170);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        int version;
        long l2;
        int aVar;
        int i;
        long l;
        int i2;
        parseVersionAndFlags(byteBuffer);
        this.groupingType = e.b(byteBuffer);
        if (getVersion() == 1) {
            this.groupingTypeParameter = e.b(byteBuffer);
        }
        l2 = e.k(byteBuffer);
        while (Long.compare(l2, i4) <= 0) {
            aVar = new SampleToGroupBox.a((long)i5, obj5, b.a(e.k(byteBuffer)));
            this.entries.add(aVar);
            l2 = i;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        int version;
        int i;
        long l;
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(this.groupingType.getBytes());
        i = 1;
        if (getVersion() == i) {
            byteBuffer.put(this.groupingTypeParameter.getBytes());
        }
        g.g(byteBuffer, (long)size);
        Iterator iterator = this.entries.iterator();
        for (SampleToGroupBox.a next2 : iterator) {
            l = next2.b();
            g.g(byteBuffer, l);
            g.g(byteBuffer, (long)i2);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i;
        if (getVersion() == 1) {
            i2 += 16;
        } else {
            i3 += 12;
        }
        return (long)i;
    }

    public List<com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox.a> getEntries() {
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

    public void setEntries(List<com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox.a> list) {
        d.b().c(b.d(SampleToGroupBox.ajc$tjp_5, this, this, list));
        this.entries = list;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setGroupingType(String string) {
        d.b().c(b.d(SampleToGroupBox.ajc$tjp_1, this, this, string));
        this.groupingType = string;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setGroupingTypeParameter(String string) {
        d.b().c(b.d(SampleToGroupBox.ajc$tjp_3, this, this, string));
        this.groupingTypeParameter = string;
    }
}
