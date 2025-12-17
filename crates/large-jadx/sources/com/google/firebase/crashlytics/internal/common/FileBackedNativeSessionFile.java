package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File.Builder;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes2.dex */
class FileBackedNativeSessionFile implements com.google.firebase.crashlytics.internal.common.NativeSessionFile {

    private final String dataTransportFilename;
    private final File file;
    private final String reportsEndpointFilename;
    FileBackedNativeSessionFile(String string, String string2, File file3) {
        super();
        this.dataTransportFilename = string;
        this.reportsEndpointFilename = string2;
        this.file = file3;
    }

    private byte[] asGzippedBytes() {
        Throwable th3;
        Throwable th4;
        Throwable th2;
        int read;
        int i;
        byte[] bArr = new byte[8192];
        final InputStream stream = getStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.close();
        byteArrayOutputStream.close();
        if (stream == null && stream != null) {
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            if (stream != null) {
                stream.close();
            }
            return null;
        }
        read = stream.read(bArr);
        while (read > 0) {
            gZIPOutputStream.write(bArr, 0, read);
            read = stream.read(bArr);
        }
        gZIPOutputStream.finish();
        gZIPOutputStream.close();
        byteArrayOutputStream.close();
        if (stream != null) {
            stream.close();
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.google.firebase.crashlytics.internal.common.NativeSessionFile
    public CrashlyticsReport.FilesPayload.File asFilePayload() {
        CrashlyticsReport.FilesPayload.File build;
        String dataTransportFilename;
        byte[] gzippedBytes = asGzippedBytes();
        if (gzippedBytes != null) {
            build = CrashlyticsReport.FilesPayload.File.builder().setContents(gzippedBytes).setFilename(this.dataTransportFilename).build();
        } else {
            build = 0;
        }
        return build;
    }

    @Override // com.google.firebase.crashlytics.internal.common.NativeSessionFile
    public String getReportsEndpointFilename() {
        return this.reportsEndpointFilename;
    }

    @Override // com.google.firebase.crashlytics.internal.common.NativeSessionFile
    public InputStream getStream() {
        boolean exists;
        if (this.file.exists() != null && this.file.isFile() == null) {
            if (this.file.isFile() == null) {
            }
            FileInputStream fileInputStream = new FileInputStream(this.file);
            return fileInputStream;
        }
        return null;
    }
}
