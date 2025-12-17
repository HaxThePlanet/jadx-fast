package com.google.android.play.core.assetpacks;

import java.util.List;

/* loaded from: classes2.dex */
public final class s1 implements com.google.android.play.core.assetpacks.y1 {

    public final com.google.android.play.core.assetpacks.z1 a;
    public final List b;
    public s1(com.google.android.play.core.assetpacks.z1 z1, List list2) {
        super();
        this.a = z1;
        this.b = list2;
    }

    @Override // com.google.android.play.core.assetpacks.y1
    public final Object zza() {
        return this.a.g(this.b);
    }
}
