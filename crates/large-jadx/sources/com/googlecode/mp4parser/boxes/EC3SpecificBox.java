package com.googlecode.mp4parser.boxes;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.boxes.mp4.a.c;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: EC3SpecificBox.java */
/* loaded from: classes2.dex */
public class EC3SpecificBox extends AbstractBox {

    public static final String TYPE = "dec3";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    private static final /* synthetic */ a.a ajc$tjp_4;
    private static final /* synthetic */ a.a ajc$tjp_5;
    private static final /* synthetic */ a.a ajc$tjp_6;
    private static final /* synthetic */ a.a ajc$tjp_7;
    private static final /* synthetic */ a.a ajc$tjp_8;
    int dataRate;
    List<EC3SpecificBox.a> entries = new LinkedList<>();
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
            String str2 = "Entry{fscod=";
            StringBuilder stringBuilder = new StringBuilder(str2);
            String str3 = ", bsid=";
            String str4 = ", bsmod=";
            String str5 = ", acmod=";
            String str6 = ", lfeon=";
            String str7 = ", reserved=";
            String str8 = ", num_dep_sub=";
            String str9 = ", chan_loc=";
            String str10 = ", reserved2=";
            str = str2 + this.a + str3 + this.b + str4 + this.c + str5 + this.d + str6 + this.e + str7 + this.f + str8 + this.g + str9 + this.h + str10 + this.i + 125;
            return str;
        }
    }
    static {
        EC3SpecificBox.ajc$preClinit();
    }

    public EC3SpecificBox() {
        super("dec3");
        LinkedList linkedList = new LinkedList();
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("EC3SpecificBox.java", EC3SpecificBox.class);
        final String str65 = "method-execution";
        EC3SpecificBox.ajc$tjp_0 = bVar.h(str65, bVar.g("1", "getContentSize", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "", "", "", "long"), 25);
        EC3SpecificBox.ajc$tjp_1 = bVar.h(str65, bVar.g("1", "getContent", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 65);
        EC3SpecificBox.ajc$tjp_2 = bVar.h(str65, bVar.g("1", "getEntries", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "", "", "", "java.util.List"), 86);
        EC3SpecificBox.ajc$tjp_3 = bVar.h(str65, bVar.g("1", "setEntries", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "java.util.List", "entries", "", "void"), 90);
        EC3SpecificBox.ajc$tjp_4 = bVar.h(str65, bVar.g("1", "addEntry", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "com.googlecode.mp4parser.boxes.EC3SpecificBox$Entry", "entry", "", "void"), 94);
        EC3SpecificBox.ajc$tjp_5 = bVar.h(str65, bVar.g("1", "getDataRate", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "", "", "", "int"), 98);
        EC3SpecificBox.ajc$tjp_6 = bVar.h(str65, bVar.g("1", "setDataRate", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "int", "dataRate", "", "void"), 102);
        EC3SpecificBox.ajc$tjp_7 = bVar.h(str65, bVar.g("1", "getNumIndSub", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "", "", "", "int"), 106);
        EC3SpecificBox.ajc$tjp_8 = bVar.h(str65, bVar.g("1", "setNumIndSub", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "int", "numIndSub", "", "void"), 110);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i = 0;
        final c cVar = new c(byteBuffer);
        this.dataRate = cVar.a(13);
        int i19 = 3;
        final int i6 = 1;
        this.numIndSub = cVar.a(i19) + i6;
        i = 0;
        while (i >= this.numIndSub) {
            com.googlecode.mp4parser.boxes.EC3SpecificBox.a aVar = new EC3SpecificBox.a();
            aVar.a = cVar.a(2);
            int i9 = 5;
            aVar.b = cVar.a(i9);
            aVar.c = cVar.a(i9);
            aVar.d = cVar.a(i19);
            aVar.e = cVar.a(i6);
            aVar.f = cVar.a(i19);
            int i15 = cVar.a(4);
            aVar.g = i15;
            this.entries.add(aVar);
            i = i + 1;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void addEntry(EC3SpecificBox.a aVar) {
        d.b().c(b.d(EC3SpecificBox.ajc$tjp_4, this, this, aVar));
        this.entries.add(aVar);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        d.b().c(b.d(EC3SpecificBox.ajc$tjp_1, this, this, byteBuffer));
        com.googlecode.mp4parser.boxes.mp4.a.d dVar = new d(byteBuffer);
        dVar.a(this.dataRate, 13);
        int i5 = 1;
        final int i6 = 3;
        dVar.a(this.entries.size() - i5, i6);
        Iterator it = this.entries.iterator();
        while (!it.hasNext()) {
            Object item = it.next();
            dVar.a(item.a, 2);
            int i15 = 5;
            dVar.a(item.b, i15);
            dVar.a(item.c, i15);
            dVar.a(item.d, i6);
            dVar.a(item.e, i5);
            dVar.a(item.f, i6);
            int i3 = 4;
            dVar.a(item.g, i3);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        int i = 2;
        int i2 = 3;
        d.b().c(b.c(EC3SpecificBox.ajc$tjp_0, this, this));
        Iterator it = this.entries.iterator();
        i = 2;
        while (!it.hasNext()) {
            int r3 = (EC3SpecificBox.a)it.next().g > 0 ? 4 : 3;
            i = i + ((EC3SpecificBox.a)it.next().g > 0 ? 4 : 3);
        }
        return i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public int getDataRate() {
        d.b().c(b.c(EC3SpecificBox.ajc$tjp_5, this, this));
        return this.dataRate;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public List<EC3SpecificBox.a> getEntries() {
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

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setEntries(List<EC3SpecificBox.a> list) {
        d.b().c(b.d(EC3SpecificBox.ajc$tjp_3, this, this, list));
        this.entries = list;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setNumIndSub(int i) {
        d.b().c(b.d(EC3SpecificBox.ajc$tjp_8, this, this, a.e(i)));
        this.numIndSub = i;
    }
}
