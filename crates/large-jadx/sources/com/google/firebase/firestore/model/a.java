package com.google.firebase.firestore.model;

import java.util.Comparator;

/* loaded from: classes2.dex */
public final class a implements Comparator {

    public static final com.google.firebase.firestore.model.a a;
    static {
        a aVar = new a();
        a.a = aVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object object, Object object2) {
        return Document.a((Document)object, (Document)object2);
    }
}
