package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File.Builder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes2.dex */
class BytesBackedNativeSessionFile implements com.google.firebase.crashlytics.internal.common.NativeSessionFile {

    private final byte[] bytes;
    private final String dataTransportFilename;
    private final String reportsEndpointFilename;
    BytesBackedNativeSessionFile(String string, String string2, byte[] b3Arr3) {
        super();
        this.dataTransportFilename = string;
        this.reportsEndpointFilename = string2;
        this.bytes = b3Arr3;
    }

    private byte[] asGzippedBytes() {
        Throwable th2;
        Throwable th3;
        if (isEmpty()) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(this.bytes);
        gZIPOutputStream.finish();
        gZIPOutputStream.close();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private boolean isEmpty() {
        int i;
        byte[] length;
        length = this.bytes;
        if (length != null) {
            if (length.length == 0) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // com.google.firebase.crashlytics.internal.common.NativeSessionFile
    public CrashlyticsReport.FilesPayload.File asFilePayload() {
        int build;
        String dataTransportFilename;
        byte[] gzippedBytes = asGzippedBytes();
        if (gzippedBytes == null) {
            build = 0;
        } else {
            build = CrashlyticsReport.FilesPayload.File.builder().setContents(gzippedBytes).setFilename(this.dataTransportFilename).build();
        }
        return build;
    }

    @Override // com.google.firebase.crashlytics.internal.common.NativeSessionFile
    public String getReportsEndpointFilename() {
        return this.reportsEndpointFilename;
    }

    @Override // com.google.firebase.crashlytics.internal.common.NativeSessionFile
    public InputStream getStream() {
        int byteArrayInputStream;
        byte[] bytes;
        if (isEmpty()) {
            byteArrayInputStream = 0;
        } else {
            byteArrayInputStream = new ByteArrayInputStream(this.bytes);
        }
        return byteArrayInputStream;
    }
}
