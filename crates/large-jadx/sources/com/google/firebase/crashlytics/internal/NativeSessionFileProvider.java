package com.google.firebase.crashlytics.internal;

import java.io.File;

/* loaded from: classes2.dex */
public interface NativeSessionFileProvider {
    public abstract File getAppFile();

    public abstract File getBinaryImagesFile();

    public abstract File getDeviceFile();

    public abstract File getMetadataFile();

    public abstract File getMinidumpFile();

    public abstract File getOsFile();

    public abstract File getSessionFile();
}
