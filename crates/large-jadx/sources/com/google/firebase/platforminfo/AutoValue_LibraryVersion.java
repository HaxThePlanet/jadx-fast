package com.google.firebase.platforminfo;

import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_LibraryVersion extends com.google.firebase.platforminfo.LibraryVersion {

    private final String libraryName;
    private final String version;
    AutoValue_LibraryVersion(String string, String string2) {
        super();
        Objects.requireNonNull(string, "Null libraryName");
        this.libraryName = string;
        Objects.requireNonNull(string2, "Null version");
        this.version = string2;
    }

    @Override // com.google.firebase.platforminfo.LibraryVersion
    public boolean equals(Object object) {
        int i;
        boolean version;
        Object obj5;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof LibraryVersion) {
            if (this.libraryName.equals((LibraryVersion)object.getLibraryName()) && this.version.equals(object.getVersion())) {
                if (this.version.equals(object.getVersion())) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.firebase.platforminfo.LibraryVersion
    public String getLibraryName() {
        return this.libraryName;
    }

    @Override // com.google.firebase.platforminfo.LibraryVersion
    public String getVersion() {
        return this.version;
    }

    @Override // com.google.firebase.platforminfo.LibraryVersion
    public int hashCode() {
        int i5 = 1000003;
        return i3 ^= i6;
    }

    @Override // com.google.firebase.platforminfo.LibraryVersion
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LibraryVersion{libraryName=");
        stringBuilder.append(this.libraryName);
        stringBuilder.append(", version=");
        stringBuilder.append(this.version);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
