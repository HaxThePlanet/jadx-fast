package com.iterable.iterableapi;

import org.json.JSONObject;

/* compiled from: IterableRequestTask.java */
/* loaded from: classes2.dex */
class m {

    final boolean a;
    final int b;
    final String c;
    final JSONObject d;
    final String e;
    m(boolean z, int i, String str, JSONObject jSONObject, String str2) {
        super();
        this.a = z;
        this.b = i;
        this.c = str;
        this.d = jSONObject;
        this.e = str2;
    }

    static m a(int i, String str, JSONObject jSONObject, String str2) {
        m mVar = new m(false, i, str, jSONObject, str2);
        return mVar;
    }

    static m b(int i, String str, JSONObject jSONObject) {
        m mVar = new m(true, i, str, jSONObject, null);
        return mVar;
    }
}
