package com.google.firebase.crashlytics.internal.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes2.dex */
class NativeSessionFileGzipper {
    private static void gzipInputStream(InputStream inputStream, File file2) {
        java.io.Closeable closeable;
        int i;
        File obj5;
        if (inputStream == null) {
        }
        byte[] bArr = new byte[8192];
        i = 0;
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(fileOutputStream);
        obj5 = inputStream.read(bArr);
        while (obj5 > 0) {
            gZIPOutputStream.write(bArr, 0, obj5);
            obj5 = inputStream.read(bArr);
        }
        gZIPOutputStream.finish();
        CommonUtils.closeQuietly(gZIPOutputStream);
    }

    static void processNativeSessions(File file, List<com.google.firebase.crashlytics.internal.common.NativeSessionFile> list2) {
        Object reportsEndpointFilename;
        Object stream;
        File file2;
        final Iterator obj4 = list2.iterator();
        while (obj4.hasNext()) {
            reportsEndpointFilename = obj4.next();
            int i = 0;
            stream = (NativeSessionFile)reportsEndpointFilename.getStream();
            if (stream != null) {
            }
            file2 = new File(file, reportsEndpointFilename.getReportsEndpointFilename());
            NativeSessionFileGzipper.gzipInputStream(stream, file2);
            CommonUtils.closeQuietly(stream);
        }
    }
}
