package com.google.firebase.inappmessaging.internal;

import java.util.Comparator;

/* loaded from: classes2.dex */
public final class v0 implements Comparator {

    public static final com.google.firebase.inappmessaging.internal.v0 a;
    static {
        v0 v0Var = new v0();
        v0.a = v0Var;
    }

    @Override // java.util.Comparator
    public final int compare(Object object, Object object2) {
        return InAppMessageStreamManager.b((c)object, (c)object2);
    }
}
