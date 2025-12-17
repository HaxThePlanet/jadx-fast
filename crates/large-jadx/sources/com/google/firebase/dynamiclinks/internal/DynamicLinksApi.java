package com.google.firebase.dynamiclinks.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.a.d.c;
import com.google.android.gms.common.api.a.f;
import com.google.android.gms.common.api.a.g;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.c.a;
import com.google.android.gms.common.api.d.a;
import com.google.android.gms.common.api.d.b;
import com.google.android.gms.common.internal.d;

/* loaded from: classes2.dex */
public class DynamicLinksApi extends c<a.d.c> {

    static final a<a.d.c> API;
    private static final a.a<com.google.firebase.dynamiclinks.internal.DynamicLinksClient, a.d.c> CLIENT_BUILDER;
    private static final a.g<com.google.firebase.dynamiclinks.internal.DynamicLinksClient> CLIENT_KEY;
    static {
        a.g gVar = new a.g();
        DynamicLinksApi.CLIENT_KEY = gVar;
        DynamicLinksApi.1 anon = new DynamicLinksApi.1();
        DynamicLinksApi.CLIENT_BUILDER = anon;
        a aVar = new a("DynamicLinks.API", anon, gVar);
        DynamicLinksApi.API = aVar;
    }

    public DynamicLinksApi(Context context) {
        super(context, DynamicLinksApi.API, a.d.f, c.a.c);
    }
}
