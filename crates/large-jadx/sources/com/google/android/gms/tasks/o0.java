package com.google.android.gms.tasks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
final class o0 implements com.google.android.gms.tasks.c<Void, com.google.android.gms.tasks.j<List<com.google.android.gms.tasks.j<?>>>> {

    final Collection a;
    o0(Collection collection) {
        this.a = collection;
        super();
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(com.google.android.gms.tasks.j j) {
        ArrayList obj2 = new ArrayList();
        obj2.addAll(this.a);
        return m.e(obj2);
    }
}
