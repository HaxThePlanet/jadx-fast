package androidx.profileinstaller;

import android.content.Context;
import android.os.Build.VERSION;
import java.io.File;

/* loaded from: classes5.dex */
class BenchmarkOperation {

    private static class Api21ContextHelper {
        static File getCodeCacheDir(Context context) {
            return context.getCodeCacheDir();
        }
    }

    private static class Api24ContextHelper {
        static Context createDeviceProtectedStorageContext(Context context) {
            return context.createDeviceProtectedStorageContext();
        }
    }
    static boolean deleteFilesRecursively(File file) {
        int success;
        int i;
        File file2;
        int i2;
        final int i3 = 1;
        File[] listFiles = file.listFiles();
        final int i4 = 0;
        if (file.isDirectory() != null && listFiles == null) {
            listFiles = file.listFiles();
            i4 = 0;
            if (listFiles == null) {
                return i4;
            }
            success = 1;
            i = i4;
            while (i < listFiles.length) {
                if (BenchmarkOperation.deleteFilesRecursively(listFiles[i]) != null && success != 0) {
                } else {
                }
                i2 = i4;
                success = i2;
                i++;
                if (success != 0) {
                } else {
                }
                i2 = i3;
            }
            return success;
        }
        file.delete();
        return i3;
    }

    static void dropShaderCache(Context context, androidx.profileinstaller.ProfileInstallReceiver.ResultDiagnostics callback) {
        File codeCacheDir;
        int i;
        if (Build.VERSION.SDK_INT >= 34) {
            codeCacheDir = BenchmarkOperation.Api24ContextHelper.createDeviceProtectedStorageContext(context).getCacheDir();
        } else {
            codeCacheDir = BenchmarkOperation.Api21ContextHelper.getCodeCacheDir(BenchmarkOperation.Api24ContextHelper.createDeviceProtectedStorageContext(context));
        }
        final int i3 = 0;
        if (BenchmarkOperation.deleteFilesRecursively(codeCacheDir) != null) {
            callback.onResultReceived(14, i3);
        } else {
            callback.onResultReceived(15, i3);
        }
    }
}
