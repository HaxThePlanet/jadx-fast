package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import com.googlecode.mp4parser.AbstractFullBox;
import com.mp4parser.iso14496.part15.c;
import com.mp4parser.iso14496.part15.f;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import m.b.a.a.a.a;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: SampleGroupDescriptionBox.java */
/* loaded from: classes2.dex */
public class SampleGroupDescriptionBox extends AbstractFullBox {

    public static final String TYPE = "sgpd";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    private static final /* synthetic */ a.a ajc$tjp_4;
    private static final /* synthetic */ a.a ajc$tjp_5;
    private static final /* synthetic */ a.a ajc$tjp_6;
    private static final /* synthetic */ a.a ajc$tjp_7;
    private static final /* synthetic */ a.a ajc$tjp_8;
    private int defaultLength;
    private List<b> groupEntries = new LinkedList<>();
    private String groupingType;
    static {
        SampleGroupDescriptionBox.ajc$preClinit();
    }

    public SampleGroupDescriptionBox() {
        super("sgpd");
        LinkedList linkedList = new LinkedList();
        setVersion(1);
    }

    private static /* synthetic */ void ajc$preClinit() {
        final m.b.a.a.b.b bVar = new b("SampleGroupDescriptionBox.java", SampleGroupDescriptionBox.class);
        final String str65 = "method-execution";
        SampleGroupDescriptionBox.ajc$tjp_0 = bVar.h(str65, bVar.g("1", "getGroupingType", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "java.lang.String"), 57);
        SampleGroupDescriptionBox.ajc$tjp_1 = bVar.h(str65, bVar.g("1", "setGroupingType", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "java.lang.String", "groupingType", "", "void"), 61);
        SampleGroupDescriptionBox.ajc$tjp_2 = bVar.h(str65, bVar.g("1", "getDefaultLength", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "int"), 153);
        SampleGroupDescriptionBox.ajc$tjp_3 = bVar.h(str65, bVar.g("1", "setDefaultLength", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "int", "defaultLength", "", "void"), 157);
        SampleGroupDescriptionBox.ajc$tjp_4 = bVar.h(str65, bVar.g("1", "getGroupEntries", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "java.util.List"), 161);
        SampleGroupDescriptionBox.ajc$tjp_5 = bVar.h(str65, bVar.g("1", "setGroupEntries", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "java.util.List", "groupEntries", "", "void"), 165);
        SampleGroupDescriptionBox.ajc$tjp_6 = bVar.h(str65, bVar.g("1", "equals", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "java.lang.Object", "o", "", "boolean"), 170);
        SampleGroupDescriptionBox.ajc$tjp_7 = bVar.h(str65, bVar.g("1", "hashCode", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "int"), 191);
        SampleGroupDescriptionBox.ajc$tjp_8 = bVar.h(str65, bVar.g("1", "toString", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "java.lang.String"), 199);
    }

    private b parseGroupEntry(ByteBuffer byteBuffer, String str) {
        com.googlecode.mp4parser.boxes.mp4.samplegrouping.d dVar;
        if ("roll".equals(str)) {
            dVar = new d();
        } else {
            if ("rash".equals(str)) {
                com.googlecode.mp4parser.boxes.mp4.samplegrouping.c cVar = new c();
            } else {
                if ("seig".equals(str)) {
                    com.googlecode.mp4parser.boxes.mp4.samplegrouping.a aVar = new a();
                } else {
                    if ("rap ".equals(str)) {
                        com.googlecode.mp4parser.boxes.mp4.samplegrouping.g gVar = new g();
                    } else {
                        if ("tele".equals(str)) {
                            com.googlecode.mp4parser.boxes.mp4.samplegrouping.e eVar = new e();
                        } else {
                            if ("sync".equals(str)) {
                                com.mp4parser.iso14496.part15.d dVar2 = new d();
                            } else {
                                if ("tscl".equals(str)) {
                                    com.mp4parser.iso14496.part15.e eVar2 = new e();
                                } else {
                                    if ("tsas".equals(str)) {
                                        f fVar2 = new f();
                                    } else {
                                        str = "stsa".equals(str) ? new c() : new f(str);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        str.c(byteBuffer);
        return str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void _parseDetails(ByteBuffer byteBuffer) {
        int version;
        int defaultLength2;
        long l2;
        long l5;
        parseVersionAndFlags(byteBuffer);
        final int i = 1;
        if (getVersion() != i) {
            throw new RuntimeException("SampleGroupDescriptionBox are only supported in version 1");
        } else {
            this.groupingType = e.b(byteBuffer);
            if (getVersion() == i) {
                this.defaultLength = b.a(e.k(byteBuffer));
            }
            l2 = e.k(byteBuffer);
            l2 = l2 - 1L;
            while (l2 <= 0) {
                if (getVersion() != i) {
                    throw new RuntimeException("This should be implemented");
                }
            }
            return;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean equals(Object object) {
        d.b().c(b.d(SampleGroupDescriptionBox.ajc$tjp_6, this, this, object));
        boolean z = true;
        if (this == object) {
            return true;
        }
        boolean z2 = false;
        if (object != null) {
            if (getClass() == object.getClass()) {
                if (this.defaultLength != object.defaultLength) {
                    return false;
                }
                if (this.groupEntries != null) {
                    if (!this.groupEntries.equals(object.groupEntries)) {
                        return false;
                    }
                } else {
                    return object.groupEntries != null ? z2 : z;
                }
            }
        }
        return false;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        int version2;
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(d.e(this.groupingType));
        final int i = 1;
        if (getVersion() == i) {
            l = (long)this.defaultLength;
            g.g(byteBuffer, l);
        }
        l2 = (long)this.groupEntries.size();
        g.g(byteBuffer, l2);
        Iterator it = this.groupEntries.iterator();
        while (!it.hasNext()) {
            Object item = it.next();
            byteBuffer.put(item.a());
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i = 8;
        long l;
        int version;
        final int i2 = 1;
        int r2 = getVersion() == i2 ? 12 : 8;
        final long l3 = 4L;
        l = (getVersion() == i2 ? 12 : 8) + 4L;
        Iterator it = this.groupEntries.iterator();
        while (!it.hasNext()) {
            l2 = (long)(b)it.next().d();
            l = l + l2;
        }
        return l;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getDefaultLength() {
        d.b().c(b.c(SampleGroupDescriptionBox.ajc$tjp_2, this, this));
        return this.defaultLength;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public List<b> getGroupEntries() {
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
        int i = 0;
        d.b().c(b.c(SampleGroupDescriptionBox.ajc$tjp_7, this, this));
        i = 0;
        if (this.groupEntries != null) {
            i = this.groupEntries.hashCode();
        }
        return (this.defaultLength + i) * 31 + i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setDefaultLength(int i) {
        d.b().c(b.d(SampleGroupDescriptionBox.ajc$tjp_3, this, this, a.e(i)));
        this.defaultLength = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setGroupEntries(List<b> list) {
        d.b().c(b.d(SampleGroupDescriptionBox.ajc$tjp_5, this, this, list));
        this.groupEntries = list;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setGroupingType(String str) {
        d.b().c(b.d(SampleGroupDescriptionBox.ajc$tjp_1, this, this, str));
        this.groupingType = str;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        String str;
        d.b().c(b.c(SampleGroupDescriptionBox.ajc$tjp_8, this, this));
        StringBuilder stringBuilder = new StringBuilder("SampleGroupDescriptionBox{groupingType='");
        if (this.groupEntries.size() > 0) {
            int i = 0;
            str = (b)this.groupEntries.get(i).b();
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
