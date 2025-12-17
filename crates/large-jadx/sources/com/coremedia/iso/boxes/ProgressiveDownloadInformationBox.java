package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class ProgressiveDownloadInformationBox extends AbstractFullBox {

    public static final String TYPE = "pdin";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    List<com.coremedia.iso.boxes.ProgressiveDownloadInformationBox.a> entries;

    public static class a {

        long a;
        long b;
        public a(long l, long l2) {
            super();
            this.a = l;
            this.b = obj3;
        }

        public long a() {
            return this.b;
        }

        public long b() {
            return this.a;
        }

        public boolean equals(Object object) {
            Class<com.coremedia.iso.boxes.ProgressiveDownloadInformationBox.a> obj;
            Class class;
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (object != null) {
                if (ProgressiveDownloadInformationBox.a.class != object.getClass()) {
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
            long l = this.a;
            final int i8 = 32;
            long l2 = this.b;
            return i3 += i7;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Entry{rate=");
            stringBuilder.append(this.a);
            stringBuilder.append(", initialDelay=");
            stringBuilder.append(this.b);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }
    static {
        ProgressiveDownloadInformationBox.ajc$preClinit();
    }

    public ProgressiveDownloadInformationBox() {
        super("pdin");
        this.entries = Collections.emptyList();
    }

    private static void ajc$preClinit() {
        b bVar4 = new b("ProgressiveDownloadInformationBox.java", ProgressiveDownloadInformationBox.class);
        final String str23 = "method-execution";
        ProgressiveDownloadInformationBox.ajc$tjp_0 = bVar4.h(str23, bVar4.g("1", "getEntries", "com.coremedia.iso.boxes.ProgressiveDownloadInformationBox", "", "", "", "java.util.List"), 38);
        ProgressiveDownloadInformationBox.ajc$tjp_1 = bVar4.h(str23, bVar4.g("1", "setEntries", "com.coremedia.iso.boxes.ProgressiveDownloadInformationBox", "java.util.List", "entries", "", "void"), 42);
        ProgressiveDownloadInformationBox.ajc$tjp_2 = bVar4.h(str23, bVar4.g("1", "toString", "com.coremedia.iso.boxes.ProgressiveDownloadInformationBox", "", "", "", "java.lang.String"), 112);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        LinkedList linkedList;
        List entries;
        long l;
        parseVersionAndFlags(byteBuffer);
        linkedList = new LinkedList();
        this.entries = linkedList;
        while (byteBuffer.remaining() < 8) {
            linkedList = new ProgressiveDownloadInformationBox.a(e.k(byteBuffer), obj2, e.k(byteBuffer), obj4);
            this.entries.add(linkedList);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        long l;
        long l2;
        writeVersionAndFlags(byteBuffer);
        Iterator iterator = this.entries.iterator();
        for (ProgressiveDownloadInformationBox.a next2 : iterator) {
            l2 = next2.b();
            g.g(byteBuffer, l2);
            g.g(byteBuffer, next2.a());
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)i2;
    }

    public List<com.coremedia.iso.boxes.ProgressiveDownloadInformationBox.a> getEntries() {
        d.b().c(b.c(ProgressiveDownloadInformationBox.ajc$tjp_0, this, this));
        return this.entries;
    }

    public void setEntries(List<com.coremedia.iso.boxes.ProgressiveDownloadInformationBox.a> list) {
        d.b().c(b.d(ProgressiveDownloadInformationBox.ajc$tjp_1, this, this, list));
        this.entries = list;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(ProgressiveDownloadInformationBox.ajc$tjp_2, this, this));
        StringBuilder stringBuilder = new StringBuilder("ProgressiveDownloadInfoBox{entries=");
        stringBuilder.append(this.entries);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
