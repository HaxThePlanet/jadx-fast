package com.iterable.iterableapi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: InboxSessionManager.java */
/* loaded from: classes2.dex */
public class d {

    i0 a = new i0();
    Map<String, b> b = new HashMap<>();
    public d() {
        super();
        com.iterable.iterableapi.i0 i0Var = new i0();
        HashMap hashMap = new HashMap();
    }

    private void a() {
        Iterator it = this.b.values().iterator();
        while (it.hasNext()) {
            (b)it.next().a();
        }
    }

    private void b(String str) {
        Object value = this.b.get(str);
        String str2 = "InboxSessionManager";
        if (value == null) {
            j0.c(str2, "onMessageImpressionEnded: impressionData not found");
            return;
        }
        if (value.e == null) {
            j0.c(str2, "onMessageImpressionEnded: impressionStarted is null");
            return;
        }
        value.a();
    }

    private List<i0.a> d() {
        final ArrayList arrayList = new ArrayList();
        Iterator it = this.b.values().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            arrayList.add(new i0.a(item.a, item.b, item.c, item.d));
        }
        return arrayList;
    }

    private void h(String str, boolean z) {
        Object value;
        if ((b)this.b.get(str) == null) {
            this.b.put(str, new b(str, z));
        }
        value.b();
    }

    public void c() {
        if (!e()) {
            j0.c("InboxSessionManager", "Inbox Session ended without start");
            return;
        }
        a();
        i0 i0Var = new i0(this.a.a, new Date(), i0Var4.c, i0Var4.d, j.s().q().j().size(), j.s().q().o(), d());
        j.s().c0(i0Var);
        j.s().i();
        this.a = new i0();
        this.b = new HashMap();
    }

    public boolean e() {
        boolean z = true;
        int r0 = this.a.a != null ? 1 : 0;
        return (this.a.a != null ? 1 : 0);
    }

    public void f(g0 g0Var) {
        j0.g();
        b(g0Var.i());
    }

    public void g(g0 g0Var) {
        j0.g();
        h(g0Var.i(), g0Var.s());
    }

    public void i() {
        if (e()) {
            j0.c("InboxSessionManager", "Inbox session started twice");
            return;
        }
        i0 i0Var = new i0(new Date(), null, j.s().q().j().size(), j.s().q().o(), 0, 0, null);
        this.a = i0Var;
        j.s().M(this.a.h);
    }
}
