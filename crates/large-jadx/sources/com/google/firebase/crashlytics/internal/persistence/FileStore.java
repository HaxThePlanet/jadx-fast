package com.google.firebase.crashlytics.internal.persistence;

import java.io.File;

/* loaded from: classes2.dex */
public interface FileStore {
    public abstract File getFilesDir();

    public abstract String getFilesDirPath();
}
