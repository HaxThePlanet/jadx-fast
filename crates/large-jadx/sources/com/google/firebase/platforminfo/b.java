package com.google.firebase.platforminfo;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* loaded from: classes2.dex */
public final class b implements ComponentFactory {

    public final String a;
    public final com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor b;
    public b(String string, com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor libraryVersionComponent$VersionExtractor2) {
        super();
        this.a = string;
        this.b = versionExtractor2;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return LibraryVersionComponent.a(this.a, this.b, componentContainer);
    }
}
