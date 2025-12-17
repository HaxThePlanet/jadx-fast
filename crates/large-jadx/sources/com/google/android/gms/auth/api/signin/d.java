package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

/* loaded from: classes2.dex */
final class d implements Comparator {

    static final Comparator a;
    static {
        d dVar = new d();
        d.a = dVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object object, Object object2) {
        final android.os.Parcelable.Creator cREATOR = GoogleSignInAccount.CREATOR;
        return (Scope)object.j2().compareTo((Scope)object2.j2());
    }
}
