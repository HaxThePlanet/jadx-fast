package com.google.firebase.firestore.model;

import java.util.Comparator;

/* loaded from: classes2.dex */
public final class c implements Comparator {

    public static final com.google.firebase.firestore.model.c a;
    static {
        c cVar = new c();
        c.a = cVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object object, Object object2) {
        return (DocumentKey)object.compareTo((DocumentKey)object2);
    }
}
