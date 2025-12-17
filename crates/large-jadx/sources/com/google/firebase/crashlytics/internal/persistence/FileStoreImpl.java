package com.google.firebase.crashlytics.internal.persistence;

import android.content.Context;
import android.os.Environment;
import com.google.firebase.crashlytics.internal.Logger;
import java.io.File;

/* loaded from: classes2.dex */
public class FileStoreImpl implements com.google.firebase.crashlytics.internal.persistence.FileStore {

    public static final String FILES_PATH = ".com.google.firebase.crashlytics";
    private final Context context;
    public FileStoreImpl(Context context) {
        super();
        this.context = context;
    }

    @Override // com.google.firebase.crashlytics.internal.persistence.FileStore
    public File getFilesDir() {
        File file = new File(this.context.getFilesDir(), ".com.google.firebase.crashlytics");
        return prepare(file);
    }

    @Override // com.google.firebase.crashlytics.internal.persistence.FileStore
    public String getFilesDirPath() {
        File file = new File(this.context.getFilesDir(), ".com.google.firebase.crashlytics");
        return file.getPath();
    }

    @Override // com.google.firebase.crashlytics.internal.persistence.FileStore
    boolean isExternalStorageAvailable() {
        if ("mounted".equals(Environment.getExternalStorageState()) == null) {
            Logger.getLogger().w("External Storage is not mounted and/or writable\nHave you declared android.permission.WRITE_EXTERNAL_STORAGE in the manifest?");
            return 0;
        }
        return 1;
    }

    @Override // com.google.firebase.crashlytics.internal.persistence.FileStore
    File prepare(File file) {
        String str;
        boolean exists;
        Logger obj2;
        if (file != null && file.exists() == null && file.mkdirs() != null) {
            if (file.exists() == null) {
                if (file.mkdirs() != null) {
                }
                Logger.getLogger().w("Couldn't create file");
                return null;
            }
            return file;
        }
        Logger.getLogger().w("Null File");
    }
}
