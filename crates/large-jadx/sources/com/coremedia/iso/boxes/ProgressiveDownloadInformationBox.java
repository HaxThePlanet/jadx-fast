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

/* compiled from: ProgressiveDownloadInformationBox.java */
/* loaded from: classes.dex */
public class ProgressiveDownloadInformationBox extends AbstractFullBox {

    public static final String TYPE = "pdin";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    List<ProgressiveDownloadInformationBox.a> entries;

    public static class a {

        long a;
        long b;
        public a(long j, long j2) {
            super();
            this.a = j;
            this.b = j2;
        }

        public long a() {
            return this.b;
        }

        public long b() {
            return this.a;
        }

        public boolean equals(Object object) {
            final boolean z = true;
            if (this == object) {
                return true;
            }
            final boolean z2 = false;
            if (object != null) {
                obj = ProgressiveDownloadInformationBox.a.class;
                if (obj == object.getClass()) {
                    if (this.b != object.b) {
                        return false;
                    }
                    return this.a != object.a ? z2 : z;
                }
            }
            return false;
        }

        public int hashCode() {
            final int i5 = 32;
            return (int)(l ^ (l >>> i5)) * 31 + (int)(l6 >>> i5) ^ l6;
        }

        public String toString() {
            String str2 = "Entry{rate=";
            StringBuilder stringBuilder = new StringBuilder(str2);
            String str3 = ", initialDelay=";
            str = str2 + this.a + str3 + this.b + 125;
            return str;
        }
    }
    static {
        ProgressiveDownloadInformationBox.ajc$preClinit();
    }

    public ProgressiveDownloadInformationBox() {
        super("pdin");
        this.entries = Collections.emptyList();
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("ProgressiveDownloadInformationBox.java", ProgressiveDownloadInformationBox.class);
        final String str23 = "method-execution";
        ProgressiveDownloadInformationBox.ajc$tjp_0 = bVar.h(str23, bVar.g("1", "getEntries", "com.coremedia.iso.boxes.ProgressiveDownloadInformationBox", "", "", "", "java.util.List"), 38);
        ProgressiveDownloadInformationBox.ajc$tjp_1 = bVar.h(str23, bVar.g("1", "setEntries", "com.coremedia.iso.boxes.ProgressiveDownloadInformationBox", "java.util.List", "entries", "", "void"), 42);
        ProgressiveDownloadInformationBox.ajc$tjp_2 = bVar.h(str23, bVar.g("1", "toString", "com.coremedia.iso.boxes.ProgressiveDownloadInformationBox", "", "", "", "java.lang.String"), 112);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.entries = new LinkedList();
        while (byteBuffer.remaining() < 8) {
            this.entries.add(new ProgressiveDownloadInformationBox.a(e.k(byteBuffer), r2, e.k(byteBuffer), r4));
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        Iterator it = this.entries.iterator();
        while (!it.hasNext()) {
            Object item = it.next();
            long l2 = item.b();
            g.g(byteBuffer, l2);
            g.g(byteBuffer, item.a());
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        return (long)(this.entries.size() * 8) + 4;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public List<ProgressiveDownloadInformationBox.a> getEntries() {
        d.b().c(b.c(ProgressiveDownloadInformationBox.ajc$tjp_0, this, this));
        return this.entries;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setEntries(List<ProgressiveDownloadInformationBox.a> list) {
        d.b().c(b.d(ProgressiveDownloadInformationBox.ajc$tjp_1, this, this, list));
        this.entries = list;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(ProgressiveDownloadInformationBox.ajc$tjp_2, this, this));
        String str2 = "ProgressiveDownloadInfoBox{entries=";
        StringBuilder stringBuilder = new StringBuilder(str2);
        str = str2 + this.entries + 125;
        return str;
    }
}
