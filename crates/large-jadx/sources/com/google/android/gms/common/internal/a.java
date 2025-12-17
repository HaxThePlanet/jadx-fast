package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.util.Log;
import androidx.annotation.RecentlyNullable;

/* loaded from: classes2.dex */
public class a extends com.google.android.gms.common.internal.k.a {
    public static Account n(com.google.android.gms.common.internal.k k) {
        int i;
        long clearCallingIdentity;
        String str;
        Throwable obj4;
        i = 0;
        if (k != null) {
            i = k.zzb();
            Binder.restoreCallingIdentity(Binder.clearCallingIdentity());
        }
        return i;
    }
}
