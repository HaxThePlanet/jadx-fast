package com.google.android.play.core.install;

import com.google.android.play.core.install.a.a;
import com.google.android.play.core.tasks.zzj;

/* loaded from: classes2.dex */
public class InstallException extends zzj {

    private final int zza;
    public InstallException(int i) {
        Object[] arr = new Object[2];
        super(String.format("Install Error(%d): %s", Integer.valueOf(i), a.a(i)));
        if (i == 0) {
        } else {
            this.zza = i;
        }
        IllegalArgumentException obj4 = new IllegalArgumentException("errorCode should not be 0.");
        throw obj4;
    }
}
