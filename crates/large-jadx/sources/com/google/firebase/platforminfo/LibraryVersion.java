package com.google.firebase.platforminfo;

/* loaded from: classes2.dex */
abstract class LibraryVersion {
    static com.google.firebase.platforminfo.LibraryVersion create(String string, String string2) {
        AutoValue_LibraryVersion autoValue_LibraryVersion = new AutoValue_LibraryVersion(string, string2);
        return autoValue_LibraryVersion;
    }

    public abstract String getLibraryName();

    public abstract String getVersion();
}
