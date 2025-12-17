package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import com.googlecode.mp4parser.h.b;
import com.mp4parser.iso14496.part15.c;
import com.mp4parser.iso14496.part15.d;
import com.mp4parser.iso14496.part15.e;
import com.mp4parser.iso14496.part15.f;
import f.b.a.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public class SampleGroupDescriptionBox extends AbstractFullBox {

    public static final String TYPE = "sgpd";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    private static final a.a ajc$tjp_6;
    private static final a.a ajc$tjp_7;
    private static final a.a ajc$tjp_8;
    private int defaultLength;
    private List<com.googlecode.mp4parser.boxes.mp4.samplegrouping.b> groupEntries;
    private String groupingType;
    static {
        SampleGroupDescriptionBox.ajc$preClinit();
    }

    public SampleGroupDescriptionBox() {
        super("sgpd");
        LinkedList linkedList = new LinkedList();
        this.groupEntries = linkedList;
        setVersion(1);
    }

    private static void ajc$preClinit() {
        b bVar10 = new b("SampleGroupDescriptionBox.java", SampleGroupDescriptionBox.class);
        final String str65 = "method-execution";
        SampleGroupDescriptionBox.ajc$tjp_0 = bVar10.h(str65, bVar10.g("1", "getGroupingType", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "java.lang.String"), 57);
        SampleGroupDescriptionBox.ajc$tjp_1 = bVar10.h(str65, bVar10.g("1", "setGroupingType", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "java.lang.String", "groupingType", "", "void"), 61);
        SampleGroupDescriptionBox.ajc$tjp_2 = bVar10.h(str65, bVar10.g("1", "getDefaultLength", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "int"), 153);
        SampleGroupDescriptionBox.ajc$tjp_3 = bVar10.h(str65, bVar10.g("1", "setDefaultLength", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "int", "defaultLength", "", "void"), 157);
        SampleGroupDescriptionBox.ajc$tjp_4 = bVar10.h(str65, bVar10.g("1", "getGroupEntries", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "java.util.List"), 161);
        SampleGroupDescriptionBox.ajc$tjp_5 = bVar10.h(str65, bVar10.g("1", "setGroupEntries", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "java.util.List", "groupEntries", "", "void"), 165);
        SampleGroupDescriptionBox.ajc$tjp_6 = bVar10.h(str65, bVar10.g("1", "equals", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "java.lang.Object", "o", "", "boolean"), 170);
        SampleGroupDescriptionBox.ajc$tjp_7 = bVar10.h(str65, bVar10.g("1", "hashCode", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "int"), 191);
        SampleGroupDescriptionBox.ajc$tjp_8 = bVar10.h(str65, bVar10.g("1", "toString", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "java.lang.String"), 199);
    }

    private com.googlecode.mp4parser.boxes.mp4.samplegrouping.b parseGroupEntry(ByteBuffer byteBuffer, String string2) {
        boolean fVar;
        com.googlecode.mp4parser.boxes.mp4.samplegrouping.b obj3;
        if ("roll".equals(string2)) {
            obj3 = new d();
        } else {
            if ("rash".equals(string2)) {
                obj3 = new c();
            } else {
                if ("seig".equals(string2)) {
                    obj3 = new a();
                } else {
                    if ("rap ".equals(string2)) {
                        obj3 = new g();
                    } else {
                        if ("tele".equals(string2)) {
                            obj3 = new e();
                        } else {
                            if ("sync".equals(string2)) {
                                obj3 = new d();
                            } else {
                                if ("tscl".equals(string2)) {
                                    obj3 = new e();
                                } else {
                                    if ("tsas".equals(string2)) {
                                        obj3 = new f();
                                    } else {
                                        if ("stsa".equals(string2)) {
                                            obj3 = new c();
                                        } else {
                                            fVar = new f(string2);
                                            obj3 = fVar;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        obj3.c(byteBuffer);
        return obj3;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        int groupEntries;
        int defaultLength2;
        long l;
        long l2;
        int defaultLength;
        long groupEntry;
        int i;
        String groupingType;
        parseVersionAndFlags(byteBuffer);
        final int i2 = 1;
        if (getVersion() != i2) {
        } else {
            this.groupingType = e.b(byteBuffer);
            if (getVersion() == i2) {
                this.defaultLength = b.a(e.k(byteBuffer));
            }
            l2 = e.k(byteBuffer);
            while (Long.compare(l2, i5) <= 0) {
                defaultLength2 = this.defaultLength;
                if (this.defaultLength == 0) {
                }
                ByteBuffer slice = byteBuffer.slice();
                slice.limit(defaultLength2);
                this.groupEntries.add(parseGroupEntry(slice, this.groupingType));
                byteBuffer.position(position += defaultLength2);
                l2 = i;
                defaultLength2 = b.a(e.k(byteBuffer));
            }
        }
        RuntimeException obj9 = new RuntimeException("SampleGroupDescriptionBox are only supported in version 1");
        throw obj9;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean equals(Object object) {
        Class class;
        Class class2;
        List obj5;
        d.b().c(b.d(SampleGroupDescriptionBox.ajc$tjp_6, this, this, object));
        int i = 1;
        if (this == object) {
            return i;
        }
        int i2 = 0;
        if (object != null) {
            if (getClass() != object.getClass()) {
            } else {
                if (this.defaultLength != object.defaultLength) {
                    return i2;
                }
                List groupEntries = this.groupEntries;
                obj5 = object.groupEntries;
                if (groupEntries != null) {
                    if (!groupEntries.equals(obj5)) {
                        return i2;
                    }
                } else {
                    if (obj5 != null) {
                    }
                }
            }
            return i;
        }
        return i2;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        int defaultLength2;
        long l;
        long l2;
        long defaultLength;
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(d.e(this.groupingType));
        final int i = 1;
        if (getVersion() == i) {
            g.g(byteBuffer, (long)defaultLength2);
        }
        g.g(byteBuffer, (long)size);
        Iterator iterator = this.groupEntries.iterator();
        while (!iterator.hasNext()) {
            Object next2 = iterator.next();
            if (getVersion() == i && this.defaultLength == 0) {
            }
            byteBuffer.put((b)next2.a());
            if (this.defaultLength == 0) {
            }
            g.g(byteBuffer, (long)limit);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i2;
        int i;
        long l;
        int defaultLength;
        final int i3 = 1;
        i2 = getVersion() == i3 ? 12 : 8;
        final int i4 = 4;
        i2 += i4;
        Iterator iterator = this.groupEntries.iterator();
        while (!iterator.hasNext()) {
            if (getVersion() == i3 && this.defaultLength == 0) {
            }
            i += l;
            if (this.defaultLength == 0) {
            }
            i += i4;
        }
        return i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getDefaultLength() {
        d.b().c(b.c(SampleGroupDescriptionBox.ajc$tjp_2, this, this));
        return this.defaultLength;
    }

    public List<com.googlecode.mp4parser.boxes.mp4.samplegrouping.b> getGroupEntries() {
        d.b().c(b.c(SampleGroupDescriptionBox.ajc$tjp_4, this, this));
        return this.groupEntries;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String getGroupingType() {
        d.b().c(b.c(SampleGroupDescriptionBox.ajc$tjp_0, this, this));
        return this.groupingType;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int hashCode() {
        int i;
        d.b().c(b.c(SampleGroupDescriptionBox.ajc$tjp_7, this, this));
        final List groupEntries = this.groupEntries;
        if (groupEntries != null) {
            i = groupEntries.hashCode();
        }
        return i3 += i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setDefaultLength(int i) {
        d.b().c(b.d(SampleGroupDescriptionBox.ajc$tjp_3, this, this, a.e(i)));
        this.defaultLength = i;
    }

    public void setGroupEntries(List<com.googlecode.mp4parser.boxes.mp4.samplegrouping.b> list) {
        d.b().c(b.d(SampleGroupDescriptionBox.ajc$tjp_5, this, this, list));
        this.groupEntries = list;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setGroupingType(String string) {
        d.b().c(b.d(SampleGroupDescriptionBox.ajc$tjp_1, this, this, string));
        this.groupingType = string;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        String str;
        int i;
        d.b().c(b.c(SampleGroupDescriptionBox.ajc$tjp_8, this, this));
        StringBuilder stringBuilder = new StringBuilder("SampleGroupDescriptionBox{groupingType='");
        if (this.groupEntries.size() > 0) {
            str = (b)this.groupEntries.get(0).b();
        } else {
            str = "????";
        }
        stringBuilder.append(str);
        stringBuilder.append('\'');
        stringBuilder.append(", defaultLength=");
        stringBuilder.append(this.defaultLength);
        stringBuilder.append(", groupEntries=");
        stringBuilder.append(this.groupEntries);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
