package com.airbnb.lottie;

import com.airbnb.lottie.y.f;
import d.e.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: PerformanceTracker.java */
/* loaded from: classes.dex */
public class n {

    private boolean a = false;
    private final Set<n.a> b = new b<>();
    private final Map<String, f> c = new HashMap<>();

    public interface a {
        void a(float f);
    }
    public n() {
        super();
        b bVar = new b();
        HashMap hashMap = new HashMap();
    }

    public void a(String str, float f) {
        Object value;
        if (!this.a) {
            return;
        }
        if ((f)this.c.get(str) == null) {
            this.c.put(str, new f());
        }
        value.a(f);
        item = "__container";
        if (str.equals(item)) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                (n.a)it.next().a(f);
            }
        }
    }

    void b(boolean z) {
        this.a = z;
    }
}
