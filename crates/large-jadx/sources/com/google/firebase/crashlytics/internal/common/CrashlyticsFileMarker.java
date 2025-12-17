package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;

/* loaded from: classes2.dex */
class CrashlyticsFileMarker {

    private final FileStore fileStore;
    private final String markerName;
    public CrashlyticsFileMarker(String string, FileStore fileStore2) {
        super();
        this.markerName = string;
        this.fileStore = fileStore2;
    }

    private File getMarkerFile() {
        File file = new File(this.fileStore.getFilesDir(), this.markerName);
        return file;
    }

    public boolean create() {
        boolean newFile;
        Logger logger;
        StringBuilder string;
        String markerName;
        try {
            newFile = getMarkerFile().createNewFile();
            string = new StringBuilder();
            markerName = "Error creating marker: ";
            string.append(markerName);
            markerName = this.markerName;
            string.append(markerName);
            string = string.toString();
            Logger.getLogger().e(string, th);
            return newFile;
        }
    }

    public boolean isPresent() {
        return getMarkerFile().exists();
    }

    public boolean remove() {
        return getMarkerFile().delete();
    }
}
