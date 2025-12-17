package com.coremedia.iso.boxes;

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

/* loaded from: classes.dex */
public class EditListBox extends AbstractFullBox {

    public static final String TYPE = "elst";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private List<com.coremedia.iso.boxes.EditListBox.a> entries;

    public static class a {

        com.coremedia.iso.boxes.EditListBox a;
        private long b;
        private long c;
        private double d;
        public a(com.coremedia.iso.boxes.EditListBox editListBox, long l2, long l3, double d4) {
            super();
            this.b = l2;
            this.c = d4;
            this.d = obj6;
            this.a = editListBox;
        }

        public a(com.coremedia.iso.boxes.EditListBox editListBox, ByteBuffer byteBuffer2) {
            double d;
            super();
            if (editListBox.getVersion() == 1) {
                this.b = e.m(byteBuffer2);
                this.c = byteBuffer2.getLong();
                this.d = e.d(byteBuffer2);
            } else {
                this.b = e.k(byteBuffer2);
                this.c = (long)int;
                this.d = e.d(byteBuffer2);
            }
            this.a = editListBox;
        }

        public void a(ByteBuffer byteBuffer) {
            long l;
            final int i2 = 1;
            if (this.a.getVersion() == i2) {
                g.i(byteBuffer, this.b);
                byteBuffer.putLong(this.c);
            } else {
                g.g(byteBuffer, (long)i);
                byteBuffer.putInt(b.a(this.c));
            }
            g.b(byteBuffer, this.d);
        }

        public double b() {
            return this.d;
        }

        public long c() {
            return this.c;
        }

        public long d() {
            return this.b;
        }

        public boolean equals(Object object) {
            Class<com.coremedia.iso.boxes.EditListBox.a> obj;
            Class class;
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (object != null) {
                if (EditListBox.a.class != object.getClass()) {
                } else {
                    if (Long.compare(l, l3) != 0) {
                        return i2;
                    }
                    if (Long.compare(l2, l4) != 0) {
                        return i2;
                    }
                }
                return i;
            }
            return i2;
        }

        public int hashCode() {
            long l = this.b;
            final int i8 = 32;
            long l2 = this.c;
            return i3 += i7;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Entry{segmentDuration=");
            stringBuilder.append(this.b);
            stringBuilder.append(", mediaTime=");
            stringBuilder.append(this.c);
            stringBuilder.append(", mediaRate=");
            stringBuilder.append(this.d);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }
    static {
        EditListBox.ajc$preClinit();
    }

    public EditListBox() {
        super("elst");
        LinkedList linkedList = new LinkedList();
        this.entries = linkedList;
    }

    private static void ajc$preClinit() {
        b bVar4 = new b("EditListBox.java", EditListBox.class);
        final String str23 = "method-execution";
        EditListBox.ajc$tjp_0 = bVar4.h(str23, bVar4.g("1", "getEntries", "com.coremedia.iso.boxes.EditListBox", "", "", "", "java.util.List"), 68);
        EditListBox.ajc$tjp_1 = bVar4.h(str23, bVar4.g("1", "setEntries", "com.coremedia.iso.boxes.EditListBox", "java.util.List", "entries", "", "void"), 72);
        EditListBox.ajc$tjp_2 = bVar4.h(str23, bVar4.g("1", "toString", "com.coremedia.iso.boxes.EditListBox", "", "", "", "java.lang.String"), 108);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i;
        List entries;
        com.coremedia.iso.boxes.EditListBox.a aVar;
        parseVersionAndFlags(byteBuffer);
        LinkedList linkedList = new LinkedList();
        this.entries = linkedList;
        i = 0;
        while (i >= b.a(e.k(byteBuffer))) {
            aVar = new EditListBox.a(this, byteBuffer);
            this.entries.add(aVar);
            i++;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        long next;
        writeVersionAndFlags(byteBuffer);
        g.g(byteBuffer, (long)size);
        Iterator iterator = this.entries.iterator();
        for (EditListBox.a next : iterator) {
            next.a(byteBuffer);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i;
        if (getVersion() == 1) {
            size *= 20;
        } else {
            size2 *= 12;
        }
        return l += i2;
    }

    public List<com.coremedia.iso.boxes.EditListBox.a> getEntries() {
        d.b().c(b.c(EditListBox.ajc$tjp_0, this, this));
        return this.entries;
    }

    public void setEntries(List<com.coremedia.iso.boxes.EditListBox.a> list) {
        d.b().c(b.d(EditListBox.ajc$tjp_1, this, this, list));
        this.entries = list;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(EditListBox.ajc$tjp_2, this, this));
        StringBuilder stringBuilder = new StringBuilder("EditListBox{entries=");
        stringBuilder.append(this.entries);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
