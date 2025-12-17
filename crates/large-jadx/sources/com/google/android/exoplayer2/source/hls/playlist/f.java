package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import com.google.android.exoplayer2.drm.t;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.i1.b;
import com.google.android.exoplayer2.offline.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class f extends com.google.android.exoplayer2.source.hls.playlist.h {

    public static final com.google.android.exoplayer2.source.hls.playlist.f n;
    public final List<Uri> d;
    public final List<com.google.android.exoplayer2.source.hls.playlist.f.b> e;
    public final List<com.google.android.exoplayer2.source.hls.playlist.f.a> f;
    public final List<com.google.android.exoplayer2.source.hls.playlist.f.a> g;
    public final List<com.google.android.exoplayer2.source.hls.playlist.f.a> h;
    public final List<com.google.android.exoplayer2.source.hls.playlist.f.a> i;
    public final i1 j;
    public final List<i1> k = null;
    public final Map<String, String> l;
    public final List<t> m;

    public static final class a {

        public final Uri a;
        public final i1 b;
        public final String c;
        public a(Uri uri, i1 i12, String string3, String string4) {
            super();
            this.a = uri;
            this.b = i12;
            this.c = string4;
        }
    }

    public static final class b {

        public final Uri a;
        public final i1 b;
        public final String c;
        public final String d;
        public final String e;
        public final String f;
        public b(Uri uri, i1 i12, String string3, String string4, String string5, String string6) {
            super();
            this.a = uri;
            this.b = i12;
            this.c = string3;
            this.d = string4;
            this.e = string5;
            this.f = string6;
        }

        public static com.google.android.exoplayer2.source.hls.playlist.f.b b(Uri uri) {
            i1.b bVar = new i1.b();
            bVar.S("0");
            bVar.K("application/x-mpegURL");
            super(uri, bVar.E(), 0, 0, 0, 0);
            return bVar2;
        }

        public com.google.android.exoplayer2.source.hls.playlist.f.b a(i1 i1) {
            super(this.a, i1, this.c, this.d, this.e, this.f);
            return bVar2;
        }
    }
    static {
        super("", Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), 0, Collections.emptyList(), 0, Collections.emptyMap(), Collections.emptyList());
        f.n = fVar2;
    }

    public f(String string, List<String> list2, List<com.google.android.exoplayer2.source.hls.playlist.f.b> list3, List<com.google.android.exoplayer2.source.hls.playlist.f.a> list4, List<com.google.android.exoplayer2.source.hls.playlist.f.a> list5, List<com.google.android.exoplayer2.source.hls.playlist.f.a> list6, List<com.google.android.exoplayer2.source.hls.playlist.f.a> list7, i1 i18, List<i1> list9, boolean z10, Map<String, String> map11, List<t> list12) {
        super(string, list2, z10);
        this.d = Collections.unmodifiableList(f.f(list3, list4, list5, list6, list7));
        this.e = Collections.unmodifiableList(list3);
        this.f = Collections.unmodifiableList(list4);
        this.g = Collections.unmodifiableList(list5);
        this.h = Collections.unmodifiableList(list6);
        this.i = Collections.unmodifiableList(list7);
        this.j = i18;
        if (list9 != null) {
            List obj1 = Collections.unmodifiableList(list9);
        }
        obj1 = 0;
        this.l = Collections.unmodifiableMap(map11);
        this.m = Collections.unmodifiableList(list12);
    }

    private static void b(List<com.google.android.exoplayer2.source.hls.playlist.f.a> list, List<Uri> list2) {
        int i;
        Uri uri;
        boolean contains;
        i = 0;
        while (i < list.size()) {
            uri = obj.a;
            if (uri != null && !list2.contains(uri)) {
            }
            i++;
            if (!list2.contains(uri)) {
            }
            list2.add(uri);
        }
    }

    private static <T> List<T> d(List<T> list, int i2, List<c> list3) {
        int i4;
        Object obj;
        int i3;
        int size;
        int i;
        ArrayList arrayList = new ArrayList(list3.size());
        int i5 = 0;
        i4 = i5;
        while (i4 < list.size()) {
            i3 = i5;
            while (i3 < list3.size()) {
                size = list3.get(i3);
                if (size.b == i2) {
                    break loop_3;
                } else {
                }
                i3++;
                if (size.c == i4) {
                    break loop_3;
                } else {
                }
            }
            i4++;
            size = list3.get(i3);
            if (size.b == i2) {
            } else {
            }
            i3++;
            if (size.c == i4) {
            } else {
            }
            arrayList.add(list.get(i4));
        }
        return arrayList;
    }

    public static com.google.android.exoplayer2.source.hls.playlist.f e(String string) {
        super("", Collections.emptyList(), Collections.singletonList(f.b.b(Uri.parse(string))), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), 0, 0, 0, Collections.emptyMap(), Collections.emptyList());
        return obj13;
    }

    private static List<Uri> f(List<com.google.android.exoplayer2.source.hls.playlist.f.b> list, List<com.google.android.exoplayer2.source.hls.playlist.f.a> list2, List<com.google.android.exoplayer2.source.hls.playlist.f.a> list3, List<com.google.android.exoplayer2.source.hls.playlist.f.a> list4, List<com.google.android.exoplayer2.source.hls.playlist.f.a> list5) {
        int i;
        Uri uri;
        boolean contains;
        ArrayList arrayList = new ArrayList();
        i = 0;
        while (i < list.size()) {
            uri = obj.a;
            if (!arrayList.contains(uri)) {
            }
            i++;
            arrayList.add(uri);
        }
        f.b(list2, arrayList);
        f.b(list3, arrayList);
        f.b(list4, arrayList);
        f.b(list5, arrayList);
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.h
    public Object a(List list) {
        return c(list);
    }

    public com.google.android.exoplayer2.source.hls.playlist.f c(List<c> list) {
        super(this.a, this.b, f.d(this.e, 0, list), Collections.emptyList(), f.d(this.g, 1, list), f.d(this.h, 2, list), Collections.emptyList(), this.j, this.k, this.c, this.l, this.m);
        return fVar2;
    }
}
