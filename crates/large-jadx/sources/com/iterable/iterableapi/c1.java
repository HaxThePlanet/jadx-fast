package com.iterable.iterableapi;

import android.content.Context;
import android.os.AsyncTask;
import java.util.Arrays;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: OfflineRequestProcessor.java */
/* loaded from: classes2.dex */
class c1 implements h1 {

    private static final Set<String> e = new HashSet<>();
    private i1 a = new i1();
    private v0 b = new v0();
    private w0 c;
    private a d = new a();
    static {
    }

    c1(Context context) {
        super();
        com.iterable.iterableapi.w0 w0Var3 = w0.m(context);
        this.c = w0Var3;
        com.iterable.iterableapi.a aVar = new a(w0Var3);
        com.iterable.iterableapi.v0 v0Var2 = new v0(this.c, i.l(), k0.e(context), this.d);
        com.iterable.iterableapi.i1 i1Var = new i1(this.c, this.b);
    }

    public void a(String str, String str2, JSONObject jSONObject, String str3, x xVar, u uVar) {
        l lVar = new l(str, str2, jSONObject, "POST", str3, xVar, uVar);
        if (d(lVar.c)) {
            if (this.d.d()) {
                lVar.c(l.b.OFFLINE);
                this.a.b(lVar, xVar, uVar);
            } else {
                com.iterable.iterableapi.l[] arr = new l[1];
                int i = 0;
                arr[i] = lVar;
                new t0().execute(arr);
            }
        }
    }

    public void b(String str, String str2, JSONObject jSONObject, String str3, v vVar) {
        l lVar = new l(str, str2, jSONObject, "GET", str3, vVar);
        com.iterable.iterableapi.l[] arr = new l[1];
        new t0().execute(new l[] { lVar });
    }

    public void c(Context context) {
        this.c.g();
    }

    boolean d(String str) {
        return c1.e.contains(str);
    }
}
