package com.google.firebase.firestore.local;

import java.util.Comparator;

/* loaded from: classes2.dex */
public final class b implements Comparator {

    public static final com.google.firebase.firestore.local.b a;
    static {
        b bVar = new b();
        b.a = bVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object object, Object object2) {
        return DocumentReference.a((DocumentReference)object, (DocumentReference)object2);
    }
}
