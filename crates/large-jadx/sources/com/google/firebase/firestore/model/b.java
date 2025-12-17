package com.google.firebase.firestore.model;

import java.util.Comparator;

/* loaded from: classes2.dex */
public final class b implements Comparator {

    public final Comparator a;
    public b(Comparator comparator) {
        super();
        this.a = comparator;
    }

    @Override // java.util.Comparator
    public final int compare(Object object, Object object2) {
        return DocumentSet.b(this.a, (Document)object, (Document)object2);
    }
}
