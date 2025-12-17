package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.a;
import f.c.a.b.i.a0.j.i0;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class v {

    private final Executor a;
    private final i0 b;
    private final com.google.android.datatransport.runtime.scheduling.jobscheduling.x c;
    private final a d;
    v(Executor executor, i0 i02, com.google.android.datatransport.runtime.scheduling.jobscheduling.x x3, a a4) {
        super();
        this.a = executor;
        this.b = i02;
        this.c = x3;
        this.d = a4;
    }

    private Object b() {
        Object next;
        com.google.android.datatransport.runtime.scheduling.jobscheduling.x xVar;
        int i;
        Iterator iterator = this.b.i0().iterator();
        for (p next : iterator) {
            this.c.a(next, 1);
        }
        return null;
    }

    private void d() {
        l lVar = new l(this);
        this.d.a(lVar);
    }

    public void a() {
        m mVar = new m(this);
        this.a.execute(mVar);
    }

    public Object c() {
        return b();
    }

    public void e() {
        d();
    }
}
