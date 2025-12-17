package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.RecentlyNonNull;
import f.c.a.d.b.g.b;

/* loaded from: classes2.dex */
public interface k extends IInterface {

    public static abstract class a extends b implements com.google.android.gms.common.internal.k {
        public static com.google.android.gms.common.internal.k m(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface localInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            if (localInterface instanceof k) {
                return (k)localInterface;
            }
            x1 x1Var = new x1(iBinder);
            return x1Var;
        }
    }
    public abstract Account zzb();
}
