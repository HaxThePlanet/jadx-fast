package com.google.android.play.core.splitinstall.g;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class r {

    public static final com.google.android.play.core.splitinstall.g.r a;
    static {
        r.a = r.c().e();
    }

    static com.google.android.play.core.splitinstall.g.q c() {
        b bVar = new b();
        HashMap hashMap = new HashMap();
        bVar.b(hashMap);
        return bVar;
    }

    public abstract Integer a();

    public abstract Map<String, Integer> b();
}
