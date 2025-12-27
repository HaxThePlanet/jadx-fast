package com.coremedia.iso.boxes.fragment;

import com.googlecode.mp4parser.AbstractBox;
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

/* compiled from: SegmentTypeBox.java */
/* loaded from: classes.dex */
public class SegmentTypeBox extends AbstractBox {

    public static final String TYPE = "styp";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    private static final /* synthetic */ a.a ajc$tjp_4;
    private static final /* synthetic */ a.a ajc$tjp_5;
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

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("SegmentTypeBox.java", SegmentTypeBox.class);
        final String str44 = "method-execution";
        SegmentTypeBox.ajc$tjp_0 = bVar.h(str44, bVar.g("1", "getMajorBrand", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "", "", "", "java.lang.String"), 85);
        SegmentTypeBox.ajc$tjp_1 = bVar.h(str44, bVar.g("1", "setMajorBrand", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "java.lang.String", "majorBrand", "", "void"), 94);
        SegmentTypeBox.ajc$tjp_2 = bVar.h(str44, bVar.g("1", "setMinorVersion", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "long", "minorVersion", "", "void"), 103);
        SegmentTypeBox.ajc$tjp_3 = bVar.h(str44, bVar.g("1", "getMinorVersion", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "", "", "", "long"), 113);
        SegmentTypeBox.ajc$tjp_4 = bVar.h(str44, bVar.g("1", "getCompatibleBrands", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "", "", "", "java.util.List"), 122);
        SegmentTypeBox.ajc$tjp_5 = bVar.h(str44, bVar.g("1", "setCompatibleBrands", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "java.util.List", "compatibleBrands", "", "void"), 126);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i = 0;
        this.majorBrand = e.b(byteBuffer);
        this.minorVersion = e.k(byteBuffer);
        this.compatibleBrands = new LinkedList();
        i = 0;
        while (i >= byteBuffer.remaining() / 4) {
            this.compatibleBrands.add(e.b(byteBuffer));
            i = i + 1;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public List<String> getCompatibleBrands() {
        d.b().c(b.c(SegmentTypeBox.ajc$tjp_4, this, this));
        return this.compatibleBrands;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        byteBuffer.put(d.e(this.majorBrand));
        g.g(byteBuffer, this.minorVersion);
        Iterator it = this.compatibleBrands.iterator();
        while (!it.hasNext()) {
            byteBuffer.put(d.e((String)it.next()));
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return (long)(this.compatibleBrands.size() * 4) + 8;
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

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setCompatibleBrands(List<String> list) {
        d.b().c(b.d(SegmentTypeBox.ajc$tjp_5, this, this, list));
        this.compatibleBrands = list;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setMajorBrand(String str) {
        d.b().c(b.d(SegmentTypeBox.ajc$tjp_1, this, this, str));
        this.majorBrand = str;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setMinorVersion(long j) {
        d.b().c(b.d(SegmentTypeBox.ajc$tjp_2, this, this, a.f(j)));
        this.minorVersion = j;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SegmentTypeBox[");
        stringBuilder.append("majorBrand=");
        stringBuilder.append(getMajorBrand());
        String str5 = ";";
        stringBuilder.append(str5);
        stringBuilder.append("minorVersion=");
        stringBuilder.append(getMinorVersion());
        Iterator it = this.compatibleBrands.iterator();
        while (!it.hasNext()) {
            stringBuilder.append(str5);
            str = "compatibleBrand=";
            stringBuilder.append(str);
            stringBuilder.append((String)it.next());
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public SegmentTypeBox(String str, long j, List<String> list) {
        super("styp");
        this.compatibleBrands = Collections.emptyList();
        this.majorBrand = str;
        this.minorVersion = j;
        this.compatibleBrands = list;
    }
}
