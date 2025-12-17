package com.coremedia.iso.boxes.fragment;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.d;
import f.b.a.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class SegmentTypeBox extends AbstractBox {

    public static final String TYPE = "styp";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    private List<String> compatibleBrands;
    private String majorBrand;
    private long minorVersion;
    static {
        SegmentTypeBox.ajc$preClinit();
    }

    public SegmentTypeBox() {
        super("styp");
        this.compatibleBrands = Collections.emptyList();
    }

    public SegmentTypeBox(String string, long l2, List<String> list3) {
        super("styp");
        this.compatibleBrands = Collections.emptyList();
        this.majorBrand = string;
        this.minorVersion = l2;
        this.compatibleBrands = obj5;
    }

    private static void ajc$preClinit() {
        b bVar7 = new b("SegmentTypeBox.java", SegmentTypeBox.class);
        final String str44 = "method-execution";
        SegmentTypeBox.ajc$tjp_0 = bVar7.h(str44, bVar7.g("1", "getMajorBrand", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "", "", "", "java.lang.String"), 85);
        SegmentTypeBox.ajc$tjp_1 = bVar7.h(str44, bVar7.g("1", "setMajorBrand", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "java.lang.String", "majorBrand", "", "void"), 94);
        SegmentTypeBox.ajc$tjp_2 = bVar7.h(str44, bVar7.g("1", "setMinorVersion", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "long", "minorVersion", "", "void"), 103);
        SegmentTypeBox.ajc$tjp_3 = bVar7.h(str44, bVar7.g("1", "getMinorVersion", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "", "", "", "long"), 113);
        SegmentTypeBox.ajc$tjp_4 = bVar7.h(str44, bVar7.g("1", "getCompatibleBrands", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "", "", "", "java.util.List"), 122);
        SegmentTypeBox.ajc$tjp_5 = bVar7.h(str44, bVar7.g("1", "setCompatibleBrands", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "java.util.List", "compatibleBrands", "", "void"), 126);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i;
        List compatibleBrands;
        String str;
        this.majorBrand = e.b(byteBuffer);
        this.minorVersion = e.k(byteBuffer);
        LinkedList linkedList = new LinkedList();
        this.compatibleBrands = linkedList;
        i = 0;
        while (i >= remaining /= 4) {
            this.compatibleBrands.add(e.b(byteBuffer));
            i++;
        }
    }

    public List<String> getCompatibleBrands() {
        d.b().c(b.c(SegmentTypeBox.ajc$tjp_4, this, this));
        return this.compatibleBrands;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        long l;
        byteBuffer.put(d.e(this.majorBrand));
        g.g(byteBuffer, this.minorVersion);
        Iterator iterator = this.compatibleBrands.iterator();
        for (String next2 : iterator) {
            byteBuffer.put(d.e(next2));
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return (long)i2;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public String getMajorBrand() {
        d.b().c(b.c(SegmentTypeBox.ajc$tjp_0, this, this));
        return this.majorBrand;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getMinorVersion() {
        d.b().c(b.c(SegmentTypeBox.ajc$tjp_3, this, this));
        return this.minorVersion;
    }

    public void setCompatibleBrands(List<String> list) {
        d.b().c(b.d(SegmentTypeBox.ajc$tjp_5, this, this, list));
        this.compatibleBrands = list;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setMajorBrand(String string) {
        d.b().c(b.d(SegmentTypeBox.ajc$tjp_1, this, this, string));
        this.majorBrand = string;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setMinorVersion(long l) {
        d.b().c(b.d(SegmentTypeBox.ajc$tjp_2, this, this, a.f(l)));
        this.minorVersion = l;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public String toString() {
        Object next;
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SegmentTypeBox[");
        stringBuilder.append("majorBrand=");
        stringBuilder.append(getMajorBrand());
        String str4 = ";";
        stringBuilder.append(str4);
        stringBuilder.append("minorVersion=");
        stringBuilder.append(getMinorVersion());
        Iterator iterator = this.compatibleBrands.iterator();
        for (String next : iterator) {
            stringBuilder.append(str4);
            stringBuilder.append("compatibleBrand=");
            stringBuilder.append(next);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
