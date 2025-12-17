package androidx.core.os;

import android.os.Environment;
import java.io.File;

/* loaded from: classes5.dex */
public final class EnvironmentCompat {

    @Deprecated
    public static final String MEDIA_UNKNOWN = "unknown";

    static class Api21Impl {
        static String getExternalStorageState(File path) {
            return Environment.getExternalStorageState(path);
        }
    }
    public static String getStorageState(File path) {
        return EnvironmentCompat.Api21Impl.getExternalStorageState(path);
    }
}
