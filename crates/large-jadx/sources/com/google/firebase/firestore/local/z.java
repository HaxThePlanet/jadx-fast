package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Function;

/* loaded from: classes2.dex */
public final class z implements Function {

    public final String a;
    public z(String string) {
        super();
        this.a = string;
    }

    @Override // com.google.firebase.firestore.util.Function
    public final Object apply(Object object) {
        return SQLiteBundleCache.a(this.a, (Cursor)object);
    }
}
