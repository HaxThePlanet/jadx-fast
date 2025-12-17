package com.airbnb.lottie;

import com.airbnb.lottie.y.f;
import d.e.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class n {

    private boolean a = false;
    private final Set<com.airbnb.lottie.n.a> b;
    private final Map<String, f> c;

    public interface a {
        public abstract void a(float f);
    }
    public n() {
        super();
        int i = 0;
        b bVar = new b();
        this.b = bVar;
        HashMap hashMap = new HashMap();
        this.c = hashMap;
    }

    public void a(String string, float f2) {
        Object fVar;
        String next;
        Map map;
        boolean obj3;
        if (!this.a) {
        }
        if ((f)this.c.get(string) == null) {
            fVar = new f();
            this.c.put(string, fVar);
        }
        fVar.a(f2);
        if (string.equals("__container")) {
            obj3 = this.b.iterator();
            for (n.a next : obj3) {
                next.a(f2);
            }
        }
    }

    void b(boolean z) {
        this.a = z;
    }
}
