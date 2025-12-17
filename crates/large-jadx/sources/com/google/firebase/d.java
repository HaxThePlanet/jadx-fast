package com.google.firebase;

import com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor;

/* loaded from: classes2.dex */
public final class d implements LibraryVersionComponent.VersionExtractor {

    public static final com.google.firebase.d a;
    static {
        d dVar = new d();
        d.a = dVar;
    }

    @Override // com.google.firebase.platforminfo.LibraryVersionComponent$VersionExtractor
    public final String extract(Object object) {
        return FirebaseCommonRegistrar.b((Context)object);
    }
}
