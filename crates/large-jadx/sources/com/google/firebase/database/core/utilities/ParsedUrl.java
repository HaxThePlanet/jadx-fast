package com.google.firebase.database.core.utilities;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.RepoInfo;

/* loaded from: classes2.dex */
public final class ParsedUrl {

    public Path path;
    public RepoInfo repoInfo;
    public boolean equals(Object object) {
        Class<com.google.firebase.database.core.utilities.ParsedUrl> obj;
        Class class;
        if (this == object) {
            return 1;
        }
        int i = 0;
        if (object != null) {
            if (ParsedUrl.class != object.getClass()) {
            } else {
                if (!this.repoInfo.equals(object.repoInfo)) {
                    return i;
                }
            }
            return this.path.equals(object.path);
        }
        return i;
    }

    public int hashCode() {
        return i2 += i4;
    }
}
