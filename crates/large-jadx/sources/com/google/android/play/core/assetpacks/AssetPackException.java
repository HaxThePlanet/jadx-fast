package com.google.android.play.core.assetpacks;

import com.google.android.play.core.assetpacks.c.a;
import com.google.android.play.core.tasks.zzj;

/* loaded from: classes2.dex */
public class AssetPackException extends zzj {

    private final int zza;
    AssetPackException(int i) {
        Object[] arr = new Object[2];
        super(String.format("Asset Pack Download Error(%d): %s", Integer.valueOf(i), a.a(i)));
        if (i == 0) {
        } else {
            this.zza = i;
        }
        IllegalArgumentException obj4 = new IllegalArgumentException("errorCode should not be 0.");
        throw obj4;
    }
}
