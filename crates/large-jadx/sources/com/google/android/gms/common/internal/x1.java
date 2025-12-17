package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import f.c.a.d.b.g.a;
import f.c.a.d.b.g.c;

/* loaded from: classes2.dex */
public final class x1 extends a implements com.google.android.gms.common.internal.k {
    x1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    @Override // f.c.a.d.b.g.a
    public final Account zzb() {
        Parcel parcel2 = j(2, n());
        parcel2.recycle();
        return (Account)c.c(parcel2, Account.CREATOR);
    }
}
