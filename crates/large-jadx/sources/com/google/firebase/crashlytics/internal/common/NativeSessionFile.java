package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File;
import java.io.InputStream;

/* loaded from: classes2.dex */
interface NativeSessionFile {
    public abstract CrashlyticsReport.FilesPayload.File asFilePayload();

    public abstract String getReportsEndpointFilename();

    public abstract InputStream getStream();
}
