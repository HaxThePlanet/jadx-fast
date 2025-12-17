package com.google.firebase;

import com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor;

/* loaded from: classes2.dex */
public final class e implements LibraryVersionComponent.VersionExtractor {

    public static final com.google.firebase.e a;
    static {
        e eVar = new e();
        e.a = eVar;
    }

    @Override // com.google.firebase.platforminfo.LibraryVersionComponent$VersionExtractor
    public final String extract(Object object) {
        return FirebaseCommonRegistrar.c((Context)object);
    }
}
