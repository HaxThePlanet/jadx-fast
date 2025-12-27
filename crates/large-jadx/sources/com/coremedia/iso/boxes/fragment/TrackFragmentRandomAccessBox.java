package com.coremedia.iso.boxes.fragment;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.f;
import f.b.a.g;
import f.b.a.h;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: TrackFragmentRandomAccessBox.java */
/* loaded from: classes.dex */
public class TrackFragmentRandomAccessBox extends AbstractFullBox {

    public static final String TYPE = "tfra";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_10;
    private static final /* synthetic */ a.a ajc$tjp_11;
    private static final /* synthetic */ a.a ajc$tjp_12;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    private static final /* synthetic */ a.a ajc$tjp_4;
    private static final /* synthetic */ a.a ajc$tjp_5;
    private static final /* synthetic */ a.a ajc$tjp_6;
    private static final /* synthetic */ a.a ajc$tjp_7;
    private static final /* synthetic */ a.a ajc$tjp_8;
    private static final /* synthetic */ a.a ajc$tjp_9;
    private List<TrackFragmentRandomAccessBox.a> entries;
    private int lengthSizeOfSampleNum = 2;
    private int lengthSizeOfTrafNum = 2;
    private int lengthSizeOfTrunNum = 2;
    private int reserved;
    private long trackId;

    public static class a {

        private long a;
        private long b;
        private long c;
        private long d;
        private long e;
        static /* synthetic */ void a(TrackFragmentRandomAccessBox.a aVar, long j) {
            aVar.a = j;
        }

        static /* synthetic */ void b(TrackFragmentRandomAccessBox.a aVar, long j) {
            aVar.b = j;
        }

        static /* synthetic */ void c(TrackFragmentRandomAccessBox.a aVar, long j) {
            aVar.c = j;
        }

        static /* synthetic */ void d(TrackFragmentRandomAccessBox.a aVar, long j) {
            aVar.d = j;
        }

        static /* synthetic */ void e(TrackFragmentRandomAccessBox.a aVar, long j) {
            aVar.e = j;
        }

        static /* synthetic */ long f(TrackFragmentRandomAccessBox.a aVar) {
            return aVar.a;
        }

        static /* synthetic */ long g(TrackFragmentRandomAccessBox.a aVar) {
            return aVar.b;
        }

        static /* synthetic */ long h(TrackFragmentRandomAccessBox.a aVar) {
            return aVar.c;
        }

        static /* synthetic */ long i(TrackFragmentRandomAccessBox.a aVar) {
            return aVar.d;
        }

        static /* synthetic */ long j(TrackFragmentRandomAccessBox.a aVar) {
            return aVar.e;
        }

        public boolean equals(Object object) {
            final boolean z = true;
            if (this == object) {
                return true;
            }
            final boolean z2 = false;
            if (object != null) {
                obj = TrackFragmentRandomAccessBox.a.class;
                if (obj == object.getClass()) {
                    if (this.b != object.b) {
                        return false;
                    }
                    if (this.e != object.e) {
                        return false;
                    }
                    if (this.a != object.a) {
                        return false;
                    }
                    if (this.c != object.c) {
                        return false;
                    }
                    return this.d != object.d ? z2 : z;
                }
            }
            return false;
        }

        public int hashCode() {
            final int i14 = 32;
            return (int)(l ^ (l >>> i14)) * 31 + (int)(l6 ^ (l6 >>> i14)) * 31 + (int)(l8 ^ (l8 >>> i14)) * 31 + (int)(l10 ^ (l10 >>> i14)) * 31 + (int)(l12 >>> i14) ^ l12;
        }

        public String toString() {
            String str2 = "Entry{time=";
            StringBuilder stringBuilder = new StringBuilder(str2);
            String str3 = ", moofOffset=";
            String str4 = ", trafNumber=";
            String str5 = ", trunNumber=";
            String str6 = ", sampleNumber=";
            str = str2 + this.a + str3 + this.b + str4 + this.c + str5 + this.d + str6 + this.e + 125;
            return str;
        }
    }
    static {
        TrackFragmentRandomAccessBox.ajc$preClinit();
    }

    public TrackFragmentRandomAccessBox() {
        super("tfra");
        this.entries = Collections.emptyList();
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("TrackFragmentRandomAccessBox.java", TrackFragmentRandomAccessBox.class);
        final String str93 = "method-execution";
        TrackFragmentRandomAccessBox.ajc$tjp_0 = bVar.h(str93, bVar.g("1", "setTrackId", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "long", "trackId", "", "void"), 145);
        TrackFragmentRandomAccessBox.ajc$tjp_1 = bVar.h(str93, bVar.g("1", "setLengthSizeOfTrafNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "int", "lengthSizeOfTrafNum", "", "void"), 149);
        TrackFragmentRandomAccessBox.ajc$tjp_10 = bVar.h(str93, bVar.g("1", "getEntries", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "java.util.List"), 185);
        TrackFragmentRandomAccessBox.ajc$tjp_11 = bVar.h(str93, bVar.g("1", "setEntries", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "java.util.List", "entries", "", "void"), 189);
        TrackFragmentRandomAccessBox.ajc$tjp_12 = bVar.h(str93, bVar.g("1", "toString", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "java.lang.String"), 290);
        TrackFragmentRandomAccessBox.ajc$tjp_2 = bVar.h(str93, bVar.g("1", "setLengthSizeOfTrunNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "int", "lengthSizeOfTrunNum", "", "void"), 153);
        TrackFragmentRandomAccessBox.ajc$tjp_3 = bVar.h(str93, bVar.g("1", "setLengthSizeOfSampleNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "int", "lengthSizeOfSampleNum", "", "void"), 157);
        TrackFragmentRandomAccessBox.ajc$tjp_4 = bVar.h(str93, bVar.g("1", "getTrackId", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "long"), 161);
        TrackFragmentRandomAccessBox.ajc$tjp_5 = bVar.h(str93, bVar.g("1", "getReserved", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "int"), 165);
        TrackFragmentRandomAccessBox.ajc$tjp_6 = bVar.h(str93, bVar.g("1", "getLengthSizeOfTrafNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "int"), 169);
        TrackFragmentRandomAccessBox.ajc$tjp_7 = bVar.h(str93, bVar.g("1", "getLengthSizeOfTrunNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "int"), 173);
        TrackFragmentRandomAccessBox.ajc$tjp_8 = bVar.h(str93, bVar.g("1", "getLengthSizeOfSampleNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "int"), 177);
        TrackFragmentRandomAccessBox.ajc$tjp_9 = bVar.h(str93, bVar.g("1", "getNumberOfEntries", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "long"), 181);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i = 0;
        parseVersionAndFlags(byteBuffer);
        this.trackId = e.k(byteBuffer);
        long l4 = e.k(byteBuffer);
        this.reserved = (int)(l4 >> 6L);
        final int i13 = 1;
        this.lengthSizeOfTrafNum = (int)(63L & l4) >> 4 + i13;
        this.lengthSizeOfTrunNum = (int)(12L & l4) >> 2 + i13;
        long l = 3L;
        this.lengthSizeOfSampleNum = (int)(l4 & l) + i13;
        long l6 = e.k(byteBuffer);
        this.entries = new ArrayList();
        i = 0;
        long l10 = (long)i;
        while (l10 >= l6) {
            com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox.a aVar = new TrackFragmentRandomAccessBox.a();
            aVar.c = f.a(byteBuffer, this.lengthSizeOfTrafNum);
            aVar.d = f.a(byteBuffer, this.lengthSizeOfTrunNum);
            aVar.e = f.a(byteBuffer, this.lengthSizeOfSampleNum);
            this.entries.add(aVar);
            i = i + 1;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        g.g(byteBuffer, this.trackId);
        final int i9 = 1;
        lengthSizeOfTrunNum2 = (this.lengthSizeOfSampleNum - i9) & 3;
        l2 = (long)lengthSizeOfTrunNum2;
        g.g(byteBuffer, (long)(this.reserved << 6) | (long)(this.lengthSizeOfTrafNum - i9) & 3 << 4 | (long)(this.lengthSizeOfTrunNum - i9) & 3 << 2 | l2);
        g.g(byteBuffer, (long)this.entries.size());
        Iterator it = this.entries.iterator();
        while (!it.hasNext()) {
            Object item = it.next();
            h.a(item.c, byteBuffer, this.lengthSizeOfTrafNum);
            h.a(item.d, byteBuffer, this.lengthSizeOfTrunNum);
            h.a(item.e, byteBuffer, this.lengthSizeOfSampleNum);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i;
        if (getVersion() == 1) {
            i = this.entries.size() * 16;
        } else {
            i = this.entries.size() * 8;
        }
        return (16L + (long)i) + (long)(this.lengthSizeOfTrafNum * this.entries.size()) + (long)(this.lengthSizeOfTrunNum * this.entries.size()) + (long)(this.lengthSizeOfSampleNum * this.entries.size());
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public List<TrackFragmentRandomAccessBox.a> getEntries() {
        d.b().c(b.c(TrackFragmentRandomAccessBox.ajc$tjp_10, this, this));
        return Collections.unmodifiableList(this.entries);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getLengthSizeOfSampleNum() {
        d.b().c(b.c(TrackFragmentRandomAccessBox.ajc$tjp_8, this, this));
        return this.lengthSizeOfSampleNum;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getLengthSizeOfTrafNum() {
        d.b().c(b.c(TrackFragmentRandomAccessBox.ajc$tjp_6, this, this));
        return this.lengthSizeOfTrafNum;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getLengthSizeOfTrunNum() {
        d.b().c(b.c(TrackFragmentRandomAccessBox.ajc$tjp_7, this, this));
        return this.lengthSizeOfTrunNum;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getNumberOfEntries() {
        d.b().c(b.c(TrackFragmentRandomAccessBox.ajc$tjp_9, this, this));
        return (long)this.entries.size();
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getReserved() {
        d.b().c(b.c(TrackFragmentRandomAccessBox.ajc$tjp_5, this, this));
        return this.reserved;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public long getTrackId() {
        d.b().c(b.c(TrackFragmentRandomAccessBox.ajc$tjp_4, this, this));
        return this.trackId;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setEntries(List<TrackFragmentRandomAccessBox.a> list) {
        d.b().c(b.d(TrackFragmentRandomAccessBox.ajc$tjp_11, this, this, list));
        this.entries = list;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setLengthSizeOfSampleNum(int i) {
        d.b().c(b.d(TrackFragmentRandomAccessBox.ajc$tjp_3, this, this, a.e(i)));
        this.lengthSizeOfSampleNum = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setLengthSizeOfTrafNum(int i) {
        d.b().c(b.d(TrackFragmentRandomAccessBox.ajc$tjp_1, this, this, a.e(i)));
        this.lengthSizeOfTrafNum = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setLengthSizeOfTrunNum(int i) {
        d.b().c(b.d(TrackFragmentRandomAccessBox.ajc$tjp_2, this, this, a.e(i)));
        this.lengthSizeOfTrunNum = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setTrackId(long j) {
        d.b().c(b.d(TrackFragmentRandomAccessBox.ajc$tjp_0, this, this, a.f(j)));
        this.trackId = j;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public String toString() {
        d.b().c(b.c(TrackFragmentRandomAccessBox.ajc$tjp_12, this, this));
        String str2 = "TrackFragmentRandomAccessBox{trackId=";
        StringBuilder stringBuilder = new StringBuilder(str2);
        String str3 = ", entries=";
        str = str2 + this.trackId + str3 + this.entries + 125;
        return str;
    }
}
