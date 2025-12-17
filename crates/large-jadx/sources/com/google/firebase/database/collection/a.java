package com.google.firebase.database.collection;

/* loaded from: classes2.dex */
public final class a implements com.google.firebase.database.collection.ImmutableSortedMap.Builder.KeyTranslator {

    public static final com.google.firebase.database.collection.a a;
    static {
        a aVar = new a();
        a.a = aVar;
    }

    @Override // com.google.firebase.database.collection.ImmutableSortedMap$Builder$KeyTranslator
    public final Object translate(Object object) {
        ImmutableSortedMap.Builder.a(object);
        return object;
    }
}
