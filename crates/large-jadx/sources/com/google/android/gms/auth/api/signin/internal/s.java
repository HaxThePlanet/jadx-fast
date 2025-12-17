package com.google.android.gms.auth.api.signin.internal;

import android.os.IInterface;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
public interface s extends IInterface {
    @Override // android.os.IInterface
    public abstract void E0(Status status);

    @Override // android.os.IInterface
    public abstract void I0(GoogleSignInAccount googleSignInAccount, Status status2);

    @Override // android.os.IInterface
    public abstract void f1(Status status);
}
