package com.google.firebase.firestore.local;

import java.util.Comparator;

/* loaded from: classes2.dex */
public final class a implements Comparator {

    public static final com.google.firebase.firestore.local.a a;
    static {
        a aVar = new a();
        a.a = aVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object object, Object object2) {
        return DocumentReference.b((DocumentReference)object, (DocumentReference)object2);
    }
}
