package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
public class ProfileInstaller {

    public static final int DIAGNOSTIC_CURRENT_PROFILE_DOES_NOT_EXIST = 2;
    public static final int DIAGNOSTIC_CURRENT_PROFILE_EXISTS = 1;
    public static final int DIAGNOSTIC_PROFILE_IS_COMPRESSED = 5;
    public static final int DIAGNOSTIC_REF_PROFILE_DOES_NOT_EXIST = 4;
    public static final int DIAGNOSTIC_REF_PROFILE_EXISTS = 3;
    private static final androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback EMPTY_DIAGNOSTICS = null;
    static final androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback LOG_DIAGNOSTICS = null;
    private static final String PROFILE_BASE_DIR = "/data/misc/profiles/cur/0";
    private static final String PROFILE_FILE = "primary.prof";
    private static final String PROFILE_INSTALLER_SKIP_FILE_NAME = "profileinstaller_profileWrittenFor_lastUpdateTime.dat";
    private static final String PROFILE_META_LOCATION = "dexopt/baseline.profm";
    static final String PROFILE_SOURCE_LOCATION = "dexopt/baseline.prof";
    public static final int RESULT_ALREADY_INSTALLED = 2;
    public static final int RESULT_BASELINE_PROFILE_NOT_FOUND = 6;
    public static final int RESULT_BENCHMARK_OPERATION_FAILURE = 15;
    public static final int RESULT_BENCHMARK_OPERATION_SUCCESS = 14;
    public static final int RESULT_BENCHMARK_OPERATION_UNKNOWN = 16;
    public static final int RESULT_DELETE_SKIP_FILE_SUCCESS = 11;
    public static final int RESULT_DESIRED_FORMAT_UNSUPPORTED = 5;
    public static final int RESULT_INSTALL_SKIP_FILE_SUCCESS = 10;
    public static final int RESULT_INSTALL_SUCCESS = 1;
    public static final int RESULT_IO_EXCEPTION = 7;
    public static final int RESULT_META_FILE_REQUIRED_BUT_NOT_FOUND = 9;
    public static final int RESULT_NOT_WRITABLE = 4;
    public static final int RESULT_PARSE_EXCEPTION = 8;
    public static final int RESULT_SAVE_PROFILE_SIGNALLED = 12;
    public static final int RESULT_SAVE_PROFILE_SKIPPED = 13;
    public static final int RESULT_UNSUPPORTED_ART_VERSION = 3;
    private static final String TAG = "ProfileInstaller";

    public interface DiagnosticsCallback {
        public abstract void onDiagnosticReceived(int i, Object object2);

        public abstract void onResultReceived(int i, Object object2);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DiagnosticCode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ResultCode {
    }
    static {
        ProfileInstaller.1 anon = new ProfileInstaller.1();
        ProfileInstaller.EMPTY_DIAGNOSTICS = anon;
        ProfileInstaller.2 anon2 = new ProfileInstaller.2();
        ProfileInstaller.LOG_DIAGNOSTICS = anon2;
    }

    static boolean deleteProfileWrittenFor(File appFilesDir) {
        File file = new File(appFilesDir, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
        return file.delete();
    }

    static void deleteSkipFile(Context context, Executor executor, androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback diagnostics) {
        ProfileInstaller.deleteProfileWrittenFor(context.getFilesDir());
        ProfileInstaller.result(executor, diagnostics, 11, 0);
    }

    static void diagnostic(Executor executor, androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback diagnostics, int code, Object data) {
        ProfileInstaller$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new ProfileInstaller$$ExternalSyntheticLambda1(diagnostics, code, data);
        executor.execute(externalSyntheticLambda1);
    }

    static boolean hasAlreadyWrittenProfileForThisInstall(PackageInfo packageInfo, File appFilesDir, androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback diagnostics) {
        int cmp;
        int i;
        Throwable lastProfileWritePackageUpdateTime;
        Throwable th;
        long lastUpdateTime;
        File file = new File(appFilesDir, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
        if (file.exists() == null) {
            return 0;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        DataInputStream dataInputStream2 = new DataInputStream(fileInputStream);
        dataInputStream2.close();
        if (Long.compare(long, lastUpdateTime) == 0) {
            i = 1;
        }
        if (i != 0) {
            diagnostics.onResultReceived(2, 0);
        }
        return i;
    }

    static void lambda$diagnostic$1(androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback diagnostics, int code, Object data) {
        diagnostics.onDiagnosticReceived(code, data);
    }

    static void lambda$result$0(androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback diagnostics, int code, Object data) {
        diagnostics.onResultReceived(code, data);
    }

    static void noteProfileWrittenFor(PackageInfo packageInfo, File appFilesDir) {
        DataOutputStream dataOutputStream;
        Throwable th;
        Throwable th2;
        File file = new File(appFilesDir, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        dataOutputStream = new DataOutputStream(fileOutputStream);
        dataOutputStream.writeLong(packageInfo.lastUpdateTime);
        dataOutputStream.close();
    }

    static void result(Executor executor, androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback diagnostics, int code, Object data) {
        ProfileInstaller$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new ProfileInstaller$$ExternalSyntheticLambda0(diagnostics, code, data);
        executor.execute(externalSyntheticLambda0);
    }

    private static boolean transcodeAndWrite(AssetManager assets, String packageName, PackageInfo packageInfo, File filesDir, String apkName, Executor executor, androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback diagnostics) {
        File file2 = new File("/data/misc/profiles/cur/0", packageName);
        File file = new File(file2, "primary.prof");
        DeviceProfileWriter deviceProfileWriter = new DeviceProfileWriter(assets, executor, diagnostics, apkName, "dexopt/baseline.prof", "dexopt/baseline.profm", file);
        if (deviceProfileWriter.deviceAllowsProfileInstallerAotWrites() == null) {
            return 0;
        }
        boolean write = deviceProfileWriter.read().transcodeIfNeeded().write();
        if (write) {
            ProfileInstaller.noteProfileWrittenFor(packageInfo, filesDir);
        }
        return write;
    }

    public static void writeProfile(Context context) {
        ProfileInstallReceiver$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new ProfileInstallReceiver$$ExternalSyntheticLambda0();
        ProfileInstaller.writeProfile(context, externalSyntheticLambda0, ProfileInstaller.EMPTY_DIAGNOSTICS);
    }

    public static void writeProfile(Context context, Executor executor, androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback diagnostics) {
        ProfileInstaller.writeProfile(context, executor, diagnostics, false);
    }

    static void writeProfile(Context context, Executor executor, androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback diagnostics, boolean forceWriteProfile) {
        Object th;
        boolean alreadyWrittenProfileForThisInstall;
        androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback diagnosticsCallback;
        int i;
        boolean obj13;
        final Context applicationContext = context.getApplicationContext();
        final String packageName = applicationContext.getPackageName();
        File file = new File(applicationInfo.sourceDir);
        i = 0;
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, i);
        final File filesDir = context.getFilesDir();
        String str = "ProfileInstaller";
        if (forceWriteProfile == null) {
            if (ProfileInstaller.hasAlreadyWrittenProfileForThisInstall(packageInfo, filesDir, diagnostics) == null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                Log.d(str, stringBuilder2.append("Installing profile for ").append(context.getPackageName()).toString());
                if (ProfileInstaller.transcodeAndWrite(applicationContext.getAssets(), packageName, packageInfo, filesDir, file.getName(), executor, diagnostics) != null && forceWriteProfile != null) {
                    if (forceWriteProfile != null) {
                        i = 1;
                    }
                }
                ProfileVerifier.writeProfileVerification(context, i);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                Log.d(str, stringBuilder.append("Skipping profile installation for ").append(context.getPackageName()).toString());
                ProfileVerifier.writeProfileVerification(context, i);
                th = executor;
                diagnosticsCallback = diagnostics;
            }
        } else {
        }
    }

    static void writeSkipFile(Context context, Executor executor, androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback diagnostics) {
        ProfileInstaller.noteProfileWrittenFor(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
        ProfileInstaller.result(executor, diagnostics, 10, 0);
    }
}
