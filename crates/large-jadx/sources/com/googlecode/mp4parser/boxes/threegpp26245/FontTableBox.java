package com.googlecode.mp4parser.boxes.threegpp26245;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import f.b.a.j;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public class FontTableBox extends AbstractBox {

    public static final String TYPE = "ftab";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    List<com.googlecode.mp4parser.boxes.threegpp26245.FontTableBox.a> entries;

    public static class a {

        int a;
        String b;
        public void a(ByteBuffer byteBuffer) {
            g.e(byteBuffer, this.a);
            g.j(byteBuffer, this.b.length());
            byteBuffer.put(j.b(this.b));
        }

        public int b() {
            return i += 3;
        }

        public void c(ByteBuffer byteBuffer) {
            this.a = e.i(byteBuffer);
            this.b = e.h(byteBuffer, e.n(byteBuffer));
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("FontRecord{fontId=");
            stringBuilder.append(this.a);
            stringBuilder.append(", fontname='");
            stringBuilder.append(this.b);
            stringBuilder.append('\'');
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }
    static {
        FontTableBox.ajc$preClinit();
    }

    public FontTableBox() {
        super("ftab");
        LinkedList linkedList = new LinkedList();
        this.entries = linkedList;
    }

    private static void ajc$preClinit() {
        b bVar3 = new b("FontTableBox.java", FontTableBox.class);
        final String str16 = "method-execution";
        FontTableBox.ajc$tjp_0 = bVar3.h(str16, bVar3.g("1", "getEntries", "com.googlecode.mp4parser.boxes.threegpp26245.FontTableBox", "", "", "", "java.util.List"), 52);
        FontTableBox.ajc$tjp_1 = bVar3.h(str16, bVar3.g("1", "setEntries", "com.googlecode.mp4parser.boxes.threegpp26245.FontTableBox", "java.util.List", "entries", "", "void"), 56);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i;
        com.googlecode.mp4parser.boxes.threegpp26245.FontTableBox.a aVar;
        List entries;
        i = 0;
        while (i >= e.i(byteBuffer)) {
            aVar = new FontTableBox.a();
            aVar.c(byteBuffer);
            this.entries.add(aVar);
            i++;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        Object next;
        g.e(byteBuffer, this.entries.size());
        Iterator iterator = this.entries.iterator();
        for (FontTableBox.a next : iterator) {
            next.a(byteBuffer);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        int i2;
        int i;
        Iterator iterator = this.entries.iterator();
        i2 = 2;
        for (FontTableBox.a next2 : iterator) {
            i2 += i;
        }
        return (long)i2;
    }

    public List<com.googlecode.mp4parser.boxes.threegpp26245.FontTableBox.a> getEntries() {
        d.b().c(b.c(FontTableBox.ajc$tjp_0, this, this));
        return this.entries;
    }

    public void setEntries(List<com.googlecode.mp4parser.boxes.threegpp26245.FontTableBox.a> list) {
        d.b().c(b.d(FontTableBox.ajc$tjp_1, this, this, list));
        this.entries = list;
    }
}
