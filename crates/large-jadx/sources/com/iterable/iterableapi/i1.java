package com.iterable.iterableapi;

import android.os.AsyncTask;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: OfflineRequestProcessor.java */
/* loaded from: classes2.dex */
class i1 implements v0.b {

    static HashMap<String, x> b;
    static HashMap<String, u> c;
    private final w0 a;
    static {
        i1.b = new HashMap();
        i1.c = new HashMap();
    }

    i1(w0 w0Var, v0 v0Var) {
        super();
        this.a = w0Var;
        v0Var.f(this);
    }

    public void a(String str, v0.c cVar, m mVar) {
        Object value = i1.b.get(str);
        Object value2 = i1.c.get(str);
        i1.b.remove(str);
        i1.c.remove(str);
        if (mVar.a) {
            if (value != null) {
                value.a(mVar.d);
            }
        } else {
            if (value2 != null) {
                value2.a(mVar.e, mVar.d);
            }
        }
    }

    void b(l lVar, x xVar, u uVar) {
        try {
        } catch (org.json.JSONException unused) {
            xVar = "RequestProcessor";
            uVar = "Failed serializing the request for offline execution. Attempting to request the request now...";
            j0.c(xVar, uVar);
            xVar = new t0();
            uVar = new l[i3];
            uVar[i] = lVar;
            xVar.execute(uVar);
            return;
        }
        String str = this.a.e(lVar.c, x0.API, lVar.d().toString());
        if (str == null) {
            final com.iterable.iterableapi.l[] arr = new l[1];
            new t0().execute(new l[] { lVar });
            return;
        }
        i1.b.put(str, xVar);
        i1.c.put(str, uVar);
    }
}
