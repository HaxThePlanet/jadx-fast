package com.googlecode.mp4parser.boxes;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.boxes.mp4.a.c;
import com.googlecode.mp4parser.boxes.mp4.a.d;
import com.googlecode.mp4parser.d;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public class EC3SpecificBox extends AbstractBox {

    public static final String TYPE = "dec3";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    private static final a.a ajc$tjp_6;
    private static final a.a ajc$tjp_7;
    private static final a.a ajc$tjp_8;
    int dataRate;
    List<com.googlecode.mp4parser.boxes.EC3SpecificBox.a> entries;
    int numIndSub;

    public static class a {

        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Entry{fscod=");
            stringBuilder.append(this.a);
            stringBuilder.append(", bsid=");
            stringBuilder.append(this.b);
            stringBuilder.append(", bsmod=");
            stringBuilder.append(this.c);
            stringBuilder.append(", acmod=");
            stringBuilder.append(this.d);
            stringBuilder.append(", lfeon=");
            stringBuilder.append(this.e);
            stringBuilder.append(", reserved=");
            stringBuilder.append(this.f);
            stringBuilder.append(", num_dep_sub=");
            stringBuilder.append(this.g);
            stringBuilder.append(", chan_loc=");
            stringBuilder.append(this.h);
            stringBuilder.append(", reserved2=");
            stringBuilder.append(this.i);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }
    static {
        EC3SpecificBox.ajc$preClinit();
    }

    public EC3SpecificBox() {
        super("dec3");
        LinkedList linkedList = new LinkedList();
        this.entries = linkedList;
    }

    private static void ajc$preClinit() {
        b bVar10 = new b("EC3SpecificBox.java", EC3SpecificBox.class);
        final String str65 = "method-execution";
        EC3SpecificBox.ajc$tjp_0 = bVar10.h(str65, bVar10.g("1", "getContentSize", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "", "", "", "long"), 25);
        EC3SpecificBox.ajc$tjp_1 = bVar10.h(str65, bVar10.g("1", "getContent", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 65);
        EC3SpecificBox.ajc$tjp_2 = bVar10.h(str65, bVar10.g("1", "getEntries", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "", "", "", "java.util.List"), 86);
        EC3SpecificBox.ajc$tjp_3 = bVar10.h(str65, bVar10.g("1", "setEntries", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "java.util.List", "entries", "", "void"), 90);
        EC3SpecificBox.ajc$tjp_4 = bVar10.h(str65, bVar10.g("1", "addEntry", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "com.googlecode.mp4parser.boxes.EC3SpecificBox$Entry", "entry", "", "void"), 94);
        EC3SpecificBox.ajc$tjp_5 = bVar10.h(str65, bVar10.g("1", "getDataRate", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "", "", "", "int"), 98);
        EC3SpecificBox.ajc$tjp_6 = bVar10.h(str65, bVar10.g("1", "setDataRate", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "int", "dataRate", "", "void"), 102);
        EC3SpecificBox.ajc$tjp_7 = bVar10.h(str65, bVar10.g("1", "getNumIndSub", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "", "", "", "int"), 106);
        EC3SpecificBox.ajc$tjp_8 = bVar10.h(str65, bVar10.g("1", "setNumIndSub", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "int", "numIndSub", "", "void"), 110);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i3;
        com.googlecode.mp4parser.boxes.EC3SpecificBox.a aVar;
        List entries;
        int i;
        int i2;
        c cVar = new c(byteBuffer);
        this.dataRate = cVar.a(13);
        int obj7 = 3;
        final int i6 = 1;
        this.numIndSub = i4 += i6;
        i3 = 0;
        while (i3 >= this.numIndSub) {
            aVar = new EC3SpecificBox.a();
            aVar.a = cVar.a(2);
            int i9 = 5;
            aVar.b = cVar.a(i9);
            aVar.c = cVar.a(i9);
            aVar.d = cVar.a(obj7);
            aVar.e = cVar.a(i6);
            aVar.f = cVar.a(obj7);
            int i15 = cVar.a(4);
            aVar.g = i15;
            if (i15 > 0) {
            } else {
            }
            aVar.i = cVar.a(i6);
            this.entries.add(aVar);
            i3++;
            aVar.h = cVar.a(9);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void addEntry(com.googlecode.mp4parser.boxes.EC3SpecificBox.a eC3SpecificBox$a) {
        d.b().c(b.d(EC3SpecificBox.ajc$tjp_4, this, this, a));
        this.entries.add(a);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        int i;
        int i3;
        int i2;
        d.b().c(b.d(EC3SpecificBox.ajc$tjp_1, this, this, byteBuffer));
        d dVar = new d(byteBuffer);
        dVar.a(this.dataRate, 13);
        int i5 = 1;
        final int i6 = 3;
        dVar.a(obj7 -= i5, i6);
        Iterator obj7 = this.entries.iterator();
        while (!obj7.hasNext()) {
            Object next2 = obj7.next();
            dVar.a(next2.a, 2);
            int i15 = 5;
            dVar.a(next2.b, i15);
            dVar.a(next2.c, i15);
            dVar.a(next2.d, i6);
            dVar.a(next2.e, i5);
            dVar.a(next2.f, i6);
            dVar.a(next2.g, 4);
            if (next2.g > 0) {
            } else {
            }
            dVar.a(next2.i, i5);
            dVar.a(next2.h, 9);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        int i2;
        int i;
        d.b().c(b.c(EC3SpecificBox.ajc$tjp_0, this, this));
        Iterator iterator = this.entries.iterator();
        i2 = 2;
        while (!iterator.hasNext()) {
            if (next2.g > 0) {
            } else {
            }
            i = 3;
            i2 += i;
            i = 4;
        }
        return i2;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getDataRate() {
        d.b().c(b.c(EC3SpecificBox.ajc$tjp_5, this, this));
        return this.dataRate;
    }

    public List<com.googlecode.mp4parser.boxes.EC3SpecificBox.a> getEntries() {
        d.b().c(b.c(EC3SpecificBox.ajc$tjp_2, this, this));
        return this.entries;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getNumIndSub() {
        d.b().c(b.c(EC3SpecificBox.ajc$tjp_7, this, this));
        return this.numIndSub;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setDataRate(int i) {
        d.b().c(b.d(EC3SpecificBox.ajc$tjp_6, this, this, a.e(i)));
        this.dataRate = i;
    }

    public void setEntries(List<com.googlecode.mp4parser.boxes.EC3SpecificBox.a> list) {
        d.b().c(b.d(EC3SpecificBox.ajc$tjp_3, this, this, list));
        this.entries = list;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setNumIndSub(int i) {
        d.b().c(b.d(EC3SpecificBox.ajc$tjp_8, this, this, a.e(i)));
        this.numIndSub = i;
    }
}
