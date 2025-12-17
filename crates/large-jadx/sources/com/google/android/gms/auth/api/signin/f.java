package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

/* loaded from: classes2.dex */
final class f implements Comparator<Scope> {
    @Override // java.util.Comparator
    public final int compare(Object object, Object object2) {
        return (Scope)object.j2().compareTo((Scope)object2.j2());
    }
}
