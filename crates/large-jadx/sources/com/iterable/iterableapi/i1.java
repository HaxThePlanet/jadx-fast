package com.iterable.iterableapi;

import android.os.AsyncTask;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class i1 implements com.iterable.iterableapi.v0.b {

    static HashMap<String, com.iterable.iterableapi.x> b;
    static HashMap<String, com.iterable.iterableapi.u> c;
    private final com.iterable.iterableapi.w0 a;
    static {
        HashMap hashMap = new HashMap();
        i1.b = hashMap;
        HashMap hashMap2 = new HashMap();
        i1.c = hashMap2;
    }

    i1(com.iterable.iterableapi.w0 w0, com.iterable.iterableapi.v0 v02) {
        super();
        this.a = w0;
        v02.f(this);
    }

    @Override // com.iterable.iterableapi.v0$b
    public void a(String string, com.iterable.iterableapi.v0.c v0$c2, com.iterable.iterableapi.m m3) {
        boolean obj3;
        Object obj4;
        obj4 = i1.b.get(string);
        Object obj = i1.c.get(string);
        i1.b.remove(string);
        i1.c.remove(string);
        if (m3.a) {
            if ((x)obj4 != null) {
                (x)obj4.a(m3.d);
            }
        } else {
            if ((u)obj != null) {
                (u)obj.a(m3.e, m3.d);
            }
        }
    }

    @Override // com.iterable.iterableapi.v0$b
    void b(com.iterable.iterableapi.l l, com.iterable.iterableapi.x x2, com.iterable.iterableapi.u u3) {
        String str = this.a.e(l.c, x0.API, l.d().toString());
        if (str == null) {
            t0 obj8 = new t0();
            final com.iterable.iterableapi.l[] obj9 = new l[1];
            obj8.execute(l);
        }
        try {
            i1.b.put(str, x2);
            i1.c.put(str, u3);
            x2 = "RequestProcessor";
            u3 = "Failed serializing the request for offline execution. Attempting to request the request now...";
            j0.c(x2, u3);
            x2 = new t0();
            u3 = new l[obj1];
            u3[obj0] = l;
            x2.execute(u3);
        }
    }
}
