package com.google.android.gms.auth.api.signin.internal;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.common.api.d;
import d.p.a.a.a;
import d.p.b.b;

/* loaded from: classes2.dex */
final class x implements a.a<Void> {

    final com.google.android.gms.auth.api.signin.internal.SignInHubActivity a;
    x(com.google.android.gms.auth.api.signin.internal.SignInHubActivity signInHubActivity, com.google.android.gms.auth.api.signin.internal.w w2) {
        this.a = signInHubActivity;
        super();
    }

    @Override // d.p.a.a$a
    public final void a(b b, Object object2) {
        com.google.android.gms.auth.api.signin.internal.SignInHubActivity obj2 = this.a;
        obj2.setResult(SignInHubActivity.i(obj2), SignInHubActivity.j(this.a));
        this.a.finish();
    }

    public final b<Void> b(int i, Bundle bundle2) {
        g obj2 = new g(this.a, d.c());
        return obj2;
    }

    public final void c(b<Void> b) {
    }
}
