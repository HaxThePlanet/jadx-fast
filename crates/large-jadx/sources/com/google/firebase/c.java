package com.google.firebase;

import com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor;

/* loaded from: classes2.dex */
public final class c implements LibraryVersionComponent.VersionExtractor {

    public static final com.google.firebase.c a;
    static {
        c cVar = new c();
        c.a = cVar;
    }

    @Override // com.google.firebase.platforminfo.LibraryVersionComponent$VersionExtractor
    public final String extract(Object object) {
        return FirebaseCommonRegistrar.a((Context)object);
    }
}
