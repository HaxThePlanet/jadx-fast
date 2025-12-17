package com.google.firebase.firestore.core;

import java.util.Comparator;

/* loaded from: classes2.dex */
public final class c0 implements Comparator {

    public final com.google.firebase.firestore.core.View a;
    public c0(com.google.firebase.firestore.core.View view) {
        super();
        this.a = view;
    }

    @Override // java.util.Comparator
    public final int compare(Object object, Object object2) {
        return this.a.b((DocumentViewChange)object, (DocumentViewChange)object2);
    }
}
