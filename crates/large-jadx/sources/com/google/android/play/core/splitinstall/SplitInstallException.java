package com.google.android.play.core.splitinstall;

import com.google.android.play.core.splitinstall.f.a;
import com.google.android.play.core.tasks.zzj;

/* loaded from: classes2.dex */
public class SplitInstallException extends zzj {

    private final int zza;
    public SplitInstallException(int i) {
        Object[] arr = new Object[2];
        super(String.format("Split Install Error(%d): %s", Integer.valueOf(i), a.b(i)));
        if (i == 0) {
        } else {
            this.zza = i;
        }
        IllegalArgumentException obj4 = new IllegalArgumentException("errorCode should not be 0.");
        throw obj4;
    }

    @Override // com.google.android.play.core.tasks.zzj
    public int a() {
        return this.zza;
    }
}
