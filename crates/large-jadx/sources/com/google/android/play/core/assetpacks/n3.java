package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.b;

/* loaded from: classes2.dex */
public final class n3 implements b {

    public static final com.google.android.play.core.assetpacks.n3 a;
    static {
        n3 n3Var = new n3();
        n3.a = n3Var;
    }

    @Override // com.google.android.play.core.tasks.b
    public final void onFailure(Exception exception) {
        q3.a(exception);
    }
}
