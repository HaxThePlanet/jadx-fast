package com.iterable.iterableapi;

import android.content.Context;
import android.os.AsyncTask;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class c1 implements com.iterable.iterableapi.h1 {

    private static final Set<String> e;
    private com.iterable.iterableapi.i1 a;
    private com.iterable.iterableapi.v0 b;
    private com.iterable.iterableapi.w0 c;
    private com.iterable.iterableapi.a d;
    static {
        HashSet hashSet = new HashSet(Arrays.asList(/* result */));
        c1.e = hashSet;
    }

    c1(Context context) {
        super();
        com.iterable.iterableapi.w0 obj5 = w0.m(context);
        this.c = obj5;
        a aVar = new a(obj5);
        this.d = aVar;
        obj5 = new v0(this.c, i.l(), k0.e(context), this.d);
        this.b = obj5;
        obj5 = new i1(this.c, this.b);
        this.a = obj5;
    }

    @Override // com.iterable.iterableapi.h1
    public void a(String string, String string2, JSONObject jSONObject3, String string4, com.iterable.iterableapi.x x5, com.iterable.iterableapi.u u6) {
        boolean obj10;
        com.iterable.iterableapi.l[] obj11;
        int obj12;
        super(string, string2, jSONObject3, "POST", string4, x5, u6);
        if (d(lVar2.c) && this.d.d()) {
            if (this.d.d()) {
                lVar2.c(l.b.OFFLINE);
                this.a.b(lVar2, x5, u6);
            } else {
                obj10 = new t0();
                obj11 = new l[1];
                obj10.execute(lVar2);
            }
        } else {
        }
    }

    @Override // com.iterable.iterableapi.h1
    public void b(String string, String string2, JSONObject jSONObject3, String string4, com.iterable.iterableapi.v v5) {
        super(string, string2, jSONObject3, "GET", string4, v5);
        t0 obj9 = new t0();
        com.iterable.iterableapi.l[] obj10 = new l[1];
        obj9.execute(lVar2);
    }

    @Override // com.iterable.iterableapi.h1
    public void c(Context context) {
        this.c.g();
    }

    @Override // com.iterable.iterableapi.h1
    boolean d(String string) {
        return c1.e.contains(string);
    }
}
