package com.google.firebase;

import com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor;

/* loaded from: classes2.dex */
public final class b implements LibraryVersionComponent.VersionExtractor {

    public static final com.google.firebase.b a;
    static {
        b bVar = new b();
        b.a = bVar;
    }

    @Override // com.google.firebase.platforminfo.LibraryVersionComponent$VersionExtractor
    public final String extract(Object object) {
        return FirebaseCommonRegistrar.d((Context)object);
    }
}
