package com.google.android.gms.auth.a;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.h;
import com.google.android.gms.common.api.a.a;
import com.google.android.gms.common.api.a.f;
import com.google.android.gms.common.api.d.a;
import com.google.android.gms.common.api.d.b;
import com.google.android.gms.common.internal.d;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
final class g extends a.a<h, GoogleSignInOptions> {
    @Override // com.google.android.gms.common.api.a$a
    public final a.f buildClient(Context context, Looper looper2, d d3, Object object4, d.a d$a5, d.b d$b6) {
        super(context, looper2, d3, (GoogleSignInOptions)object4, a5, b6);
        return obj11;
    }

    @Override // com.google.android.gms.common.api.a$a
    public final List getImpliedScopes(Object object) {
        Object obj1;
        if ((GoogleSignInOptions)object == null) {
            obj1 = Collections.emptyList();
        } else {
            obj1 = (GoogleSignInOptions)object.l2();
        }
        return obj1;
    }
}
