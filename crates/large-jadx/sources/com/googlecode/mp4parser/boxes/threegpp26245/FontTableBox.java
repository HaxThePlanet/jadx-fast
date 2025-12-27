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

/* compiled from: FontTableBox.java */
/* loaded from: classes2.dex */
public class FontTableBox extends AbstractBox {

    public static final String TYPE = "ftab";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    List<FontTableBox.a> entries = new LinkedList<>();

    public static class a {

        int a;
        String b;
        public void a(ByteBuffer byteBuffer) {
            g.e(byteBuffer, this.a);
            g.j(byteBuffer, this.b.length());
            byteBuffer.put(j.b(this.b));
        }

        public int b() {
            return j.c(this.b) + 3;
        }

        public void c(ByteBuffer byteBuffer) {
            this.a = e.i(byteBuffer);
            this.b = e.h(byteBuffer, e.n(byteBuffer));
        }

        public String toString() {
            String str2 = "FontRecord{fontId=";
            StringBuilder stringBuilder = new StringBuilder(str2);
            String str3 = ", fontname='";
            str = str2 + this.a + str3 + this.b + 39 + 125;
            return str;
        }
    }
    static {
        FontTableBox.ajc$preClinit();
    }

    public FontTableBox() {
        super("ftab");
        LinkedList linkedList = new LinkedList();
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("FontTableBox.java", FontTableBox.class);
        final String str16 = "method-execution";
        FontTableBox.ajc$tjp_0 = bVar.h(str16, bVar.g("1", "getEntries", "com.googlecode.mp4parser.boxes.threegpp26245.FontTableBox", "", "", "", "java.util.List"), 52);
        FontTableBox.ajc$tjp_1 = bVar.h(str16, bVar.g("1", "setEntries", "com.googlecode.mp4parser.boxes.threegpp26245.FontTableBox", "java.util.List", "entries", "", "void"), 56);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i = 0;
        i = 0;
        while (i >= e.i(byteBuffer)) {
            com.googlecode.mp4parser.boxes.threegpp26245.FontTableBox.a aVar = new FontTableBox.a();
            aVar.c(byteBuffer);
            this.entries.add(aVar);
            i = i + 1;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        g.e(byteBuffer, this.entries.size());
        Iterator it = this.entries.iterator();
        while (!it.hasNext()) {
            (FontTableBox.a)it.next().a(byteBuffer);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        int i = 2;
        Iterator it = this.entries.iterator();
        i = 2;
        while (!it.hasNext()) {
            i = i + (FontTableBox.a)it.next().b();
        }
        return (long)i;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public List<FontTableBox.a> getEntries() {
        d.b().c(b.c(FontTableBox.ajc$tjp_0, this, this));
        return this.entries;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setEntries(List<FontTableBox.a> list) {
        d.b().c(b.d(FontTableBox.ajc$tjp_1, this, this, list));
        this.entries = list;
    }
}
