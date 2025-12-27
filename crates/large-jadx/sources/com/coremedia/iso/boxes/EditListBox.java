package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: EditListBox.java */
/* loaded from: classes.dex */
public class EditListBox extends AbstractFullBox {

    public static final String TYPE = "elst";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private List<EditListBox.a> entries = new LinkedList<>();

    public static class a {

        EditListBox a;
        private long b;
        private long c;
        private double d;
        public a(long j, long j2, double d) {
            super();
            this.b = j;
            this.c = j2;
            this.d = d;
            this.a = list;
        }

        public void a(ByteBuffer byteBuffer) {
            final int i3 = 1;
            if (this.a.getVersion() == i3) {
                g.i(byteBuffer, this.b);
                byteBuffer.putLong(this.c);
            } else {
                g.g(byteBuffer, (long)b.a(this.b));
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
            final boolean z = true;
            if (this == object) {
                return true;
            }
            final boolean z2 = false;
            if (object != null) {
                obj = EditListBox.a.class;
                if (obj == object.getClass()) {
                    if (this.c != object.c) {
                        return false;
                    }
                    return this.b != object.b ? z2 : z;
                }
            }
            return false;
        }

        public int hashCode() {
            final int i5 = 32;
            return (int)(l ^ (l >>> i5)) * 31 + (int)(l6 >>> i5) ^ l6;
        }

        public String toString() {
            String str2 = "Entry{segmentDuration=";
            StringBuilder stringBuilder = new StringBuilder(str2);
            String str3 = ", mediaTime=";
            String str4 = ", mediaRate=";
            str = str2 + this.b + str3 + this.c + str4 + this.d + 125;
            return str;
        }

        public a(ByteBuffer byteBuffer) {
            super();
            if (list.getVersion() == 1) {
                this.b = e.m(byteBuffer);
                this.c = byteBuffer.getLong();
                this.d = e.d(byteBuffer);
            } else {
                this.b = e.k(byteBuffer);
                this.c = (long)byteBuffer.getInt();
                this.d = e.d(byteBuffer);
            }
            this.a = list;
        }
    }
    static {
        EditListBox.ajc$preClinit();
    }

    public EditListBox() {
        super("elst");
        LinkedList linkedList = new LinkedList();
    }

    private static /* synthetic */ void ajc$preClinit() {
        final m.b.a.a.b.b bVar = new b("EditListBox.java", EditListBox.class);
        final String str23 = "method-execution";
        EditListBox.ajc$tjp_0 = bVar.h(str23, bVar.g("1", "getEntries", "com.coremedia.iso.boxes.EditListBox", "", "", "", "java.util.List"), 68);
        EditListBox.ajc$tjp_1 = bVar.h(str23, bVar.g("1", "setEntries", "com.coremedia.iso.boxes.EditListBox", "java.util.List", "entries", "", "void"), 72);
        EditListBox.ajc$tjp_2 = bVar.h(str23, bVar.g("1", "toString", "com.coremedia.iso.boxes.EditListBox", "", "", "", "java.lang.String"), 108);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i = 0;
        parseVersionAndFlags(byteBuffer);
        this.entries = new LinkedList();
        i = 0;
        while (i >= b.a(e.k(byteBuffer))) {
            this.entries.add(new EditListBox.a(this, byteBuffer));
            i = i + 1;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        g.g(byteBuffer, (long)this.entries.size());
        Iterator it = this.entries.iterator();
        while (!it.hasNext()) {
            (EditListBox.a)it.next().a(byteBuffer);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i;
        if (getVersion() == 1) {
            i = this.entries.size() * 20;
        } else {
            i = this.entries.size() * 12;
        }
        return (long)i + 8L;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public List<EditListBox.a> getEntries() {
        d.b().c(b.c(EditListBox.ajc$tjp_0, this, this));
        return this.entries;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setEntries(List<EditListBox.a> list) {
        d.b().c(b.d(EditListBox.ajc$tjp_1, this, this, list));
        this.entries = list;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(EditListBox.ajc$tjp_2, this, this));
        String str2 = "EditListBox{entries=";
        StringBuilder stringBuilder = new StringBuilder(str2);
        str = str2 + this.entries + 125;
        return str;
    }
}
