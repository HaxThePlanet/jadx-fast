package com.googlecode.mp4parser.e;

import com.googlecode.mp4parser.h.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class c {

    h a;
    List<com.googlecode.mp4parser.e.f> b;
    public c() {
        super();
        this.a = h.j;
        LinkedList linkedList = new LinkedList();
        this.b = linkedList;
    }

    public static long b(long l, long l2) {
        if (Long.compare(obj4, i) == 0) {
            return l;
        }
        return c.b(obj4, obj5);
    }

    public void a(com.googlecode.mp4parser.e.f f) {
        Object fVar;
        long l;
        if (f(f.h0().h()) != null) {
            f.h0().t(d());
        }
        this.b.add(f);
    }

    public h c() {
        return this.a;
    }

    public long d() {
        int i;
        Object next;
        int cmp;
        Iterator iterator = this.b.iterator();
        i = 0;
        while (!iterator.hasNext()) {
            next = iterator.next();
            if (Long.compare(i, l) < 0) {
            }
            i = next.h0().h();
        }
        return i += i3;
    }

    public long e() {
        long l2;
        long l;
        l2 = (f)g().iterator().next().h0().g();
        Iterator iterator2 = g().iterator();
        for (f next3 : iterator2) {
            l2 = c.b(next3.h0().g(), obj4);
        }
        return l2;
    }

    public com.googlecode.mp4parser.e.f f(long l) {
        Object next;
        int cmp;
        Iterator iterator = this.b.iterator();
        for (f next : iterator) {
        }
        return null;
    }

    public List<com.googlecode.mp4parser.e.f> g() {
        return this.b;
    }

    public void h(h h) {
        this.a = h;
    }

    public String toString() {
        String string;
        Object next;
        StringBuilder stringBuilder;
        long l;
        Iterator iterator = this.b.iterator();
        string = "Movie{ ";
        for (f next : iterator) {
            stringBuilder = new StringBuilder(String.valueOf(string));
            stringBuilder.append("track_");
            stringBuilder.append(next.h0().h());
            stringBuilder.append(" (");
            stringBuilder.append(next.Q1());
            stringBuilder.append(") ");
            string = stringBuilder.toString();
        }
        StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(string));
        stringBuilder2.append('}');
        return stringBuilder2.toString();
    }
}
