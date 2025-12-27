package com.googlecode.mp4parser.e;

import com.googlecode.mp4parser.h.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Movie.java */
/* loaded from: classes2.dex */
public class c {

    h a;
    List<f> b = new LinkedList<>();
    public c() {
        super();
        this.a = h.j;
        LinkedList linkedList = new LinkedList();
    }

    public static long b(long j, long j2) {
        if (j2 == 0) {
            return j;
        }
        return c.b(j2, j % j2);
    }

    public void a(f fVar) {
        if (f(fVar.h0().h()) != null) {
            fVar.h0().t(d());
        }
        this.b.add(fVar);
    }

    public h c() {
        return this.a;
    }

    public long d() {
        int i = 0;
        Iterator it = this.b.iterator();
        i = 0;
        while (!it.hasNext()) {
            Object item = it.next();
            long l2 = item.h0().h();
        }
        return i + 1L;
    }

    public long e() {
        long l;
        l = (f)g().iterator().next().h0().g();
        Iterator it2 = g().iterator();
        while (!it2.hasNext()) {
            l = c.b((f)it2.next().h0().g(), l);
        }
        return l;
    }

    public f f(long j) {
        Iterator it = this.b.iterator();
        while (!it.hasNext()) {
            Object item = it.next();
            long l = item.h0().h();
            if (l == j) {
                return item;
            }
        }
        return null;
    }

    public List<f> g() {
        return this.b;
    }

    public void h(h hVar) {
        this.a = hVar;
    }

    public String toString() {
        String str;
        Iterator it = this.b.iterator();
        str = "Movie{ ";
        while (!it.hasNext()) {
            Object item = it.next();
            String str3 = String.valueOf(str);
            StringBuilder stringBuilder = new StringBuilder(str3);
            String str4 = "track_";
            long l = item.h0().h();
            String str5 = " (";
            String str6 = item.Q1();
            String str7 = ") ";
            str = str3 + str4 + l + str5 + str6 + str7;
        }
        String str8 = String.valueOf(str);
        str2 = str8 + 125;
        return str2;
    }
}
