package com.google.android.play.core.assetpacks;

import android.content.ComponentName;
import android.content.Context;
import com.google.android.play.core.internal.d1;
import com.google.android.play.core.internal.q1;
import com.google.android.play.core.internal.r1;

/* loaded from: classes2.dex */
public final class x3 implements r1<Object> {

    private final r1<com.google.android.play.core.assetpacks.q3> a;
    private final r1<Context> b;
    public x3(r1<com.google.android.play.core.assetpacks.q3> r1, r1<Context> r12) {
        super();
        this.a = r1;
        this.b = r12;
    }

    @Override // com.google.android.play.core.internal.r1
    public final Object zza() {
        Object obj = this.a.zza();
        Context context = (z3)this.b.a();
        ComponentName componentName = new ComponentName(context.getPackageName(), "com.google.android.play.core.assetpacks.AssetPackExtractionService");
        int i = 4;
        d1.a(context.getPackageManager(), componentName, i);
        ComponentName componentName2 = new ComponentName(context.getPackageName(), "com.google.android.play.core.assetpacks.ExtractionForegroundService");
        d1.a(context.getPackageManager(), componentName2, i);
        q1.a((q3)obj);
        return obj;
    }
}
