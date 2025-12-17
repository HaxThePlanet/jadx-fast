package com.google.android.play.core.assetpacks;

/* loaded from: classes2.dex */
public final class r1 implements com.google.android.play.core.assetpacks.y1 {

    public final com.google.android.play.core.assetpacks.z1 a;
    public final String b;
    public final int c;
    public final long d;
    public r1(com.google.android.play.core.assetpacks.z1 z1, String string2, int i3, long l4) {
        super();
        this.a = z1;
        this.b = string2;
        this.c = i3;
        this.d = l4;
    }

    @Override // com.google.android.play.core.assetpacks.y1
    public final Object zza() {
        this.a.c(this.b, this.c, this.d);
        return null;
    }
}
