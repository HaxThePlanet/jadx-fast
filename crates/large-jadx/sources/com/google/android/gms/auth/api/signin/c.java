package com.google.android.gms.auth.api.signin;

import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.i;

/* loaded from: classes2.dex */
public class c implements i {

    private Status a;
    private com.google.android.gms.auth.api.signin.GoogleSignInAccount b;
    public c(com.google.android.gms.auth.api.signin.GoogleSignInAccount googleSignInAccount, Status status2) {
        super();
        this.b = googleSignInAccount;
        this.a = status2;
    }

    public com.google.android.gms.auth.api.signin.GoogleSignInAccount a() {
        return this.b;
    }

    @Override // com.google.android.gms.common.api.i
    public Status m() {
        return this.a;
    }
}
