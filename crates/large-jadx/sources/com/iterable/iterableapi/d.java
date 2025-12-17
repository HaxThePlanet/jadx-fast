package com.iterable.iterableapi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class d {

    com.iterable.iterableapi.i0 a;
    Map<String, com.iterable.iterableapi.b> b;
    public d() {
        super();
        i0 i0Var = new i0();
        this.a = i0Var;
        HashMap hashMap = new HashMap();
        this.b = hashMap;
    }

    private void a() {
        Object next;
        Iterator iterator = this.b.values().iterator();
        for (b next : iterator) {
            next.a();
        }
    }

    private void b(String string) {
        Object obj3 = this.b.get(string);
        String str = "InboxSessionManager";
        if ((b)obj3 == null) {
            j0.c(str, "onMessageImpressionEnded: impressionData not found");
        }
        if (obj3.e == null) {
            j0.c(str, "onMessageImpressionEnded: impressionStarted is null");
        }
        (b)obj3.a();
    }

    private List<com.iterable.iterableapi.i0.a> d() {
        float f;
        com.iterable.iterableapi.i0.a aVar;
        String str;
        boolean z;
        int i;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.b.values().iterator();
        for (b next2 : iterator) {
            aVar = new i0.a(next2.a, next2.b, next2.c, next2.d);
            arrayList.add(aVar);
        }
        return arrayList;
    }

    private void h(String string, boolean z2) {
        Object bVar;
        boolean obj3;
        if ((b)this.b.get(string) == null) {
            bVar = new b(string, z2);
            this.b.put(string, bVar);
        }
        bVar.b();
    }

    public void c() {
        if (!e()) {
            j0.c("InboxSessionManager", "Inbox Session ended without start");
        }
        a();
        Date date2 = new Date();
        com.iterable.iterableapi.i0 i0Var4 = this.a;
        super(i0Var3.a, date2, i0Var4.c, i0Var4.d, j.s().q().j().size(), j.s().q().o(), d());
        j.s().c0(i0Var);
        j.s().i();
        i0 i0Var2 = new i0();
        this.a = i0Var2;
        HashMap hashMap = new HashMap();
        this.b = hashMap;
    }

    public boolean e() {
        int i;
        i = i0Var.a != null ? 1 : 0;
        return i;
    }

    public void f(com.iterable.iterableapi.g0 g0) {
        j0.g();
        b(g0.i());
    }

    public void g(com.iterable.iterableapi.g0 g0) {
        j0.g();
        h(g0.i(), g0.s());
    }

    public void i() {
        if (e()) {
            j0.c("InboxSessionManager", "Inbox session started twice");
        }
        Date date = new Date();
        super(date, 0, j.s().q().j().size(), j.s().q().o(), 0, 0, 0);
        this.a = i0Var;
        j.s().M(i0Var2.h);
    }
}
