package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager.PackageInfoFlags;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.Build.VERSION;
import androidx.concurrent.futures.ResolvableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* loaded from: classes5.dex */
public final class ProfileVerifier {

    private static final String CUR_PROFILES_BASE_DIR = "/data/misc/profiles/cur/0/";
    private static final String PROFILE_FILE_NAME = "primary.prof";
    private static final String PROFILE_INSTALLED_CACHE_FILE_NAME = "profileInstalled";
    private static final String REF_PROFILES_BASE_DIR = "/data/misc/profiles/ref/";
    private static final Object SYNC_OBJ = null;
    private static final String TAG = "ProfileVerifier";
    private static androidx.profileinstaller.ProfileVerifier.CompilationStatus sCompilationStatus;
    private static final ResolvableFuture<androidx.profileinstaller.ProfileVerifier.CompilationStatus> sFuture;

    private static class Api33Impl {
        static PackageInfo getPackageInfo(PackageManager packageManager, Context context) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0));
        }
    }

    static class Cache {

        private static final int SCHEMA = 1;
        final long mInstalledCurrentProfileSize;
        final long mPackageLastUpdateTime;
        final int mResultCode;
        final int mSchema;
        Cache(int schema, int resultCode, long packageLastUpdateTime, long installedCurrentProfileSize) {
            super();
            this.mSchema = schema;
            this.mResultCode = resultCode;
            this.mPackageLastUpdateTime = packageLastUpdateTime;
            this.mInstalledCurrentProfileSize = obj5;
        }

        static androidx.profileinstaller.ProfileVerifier.Cache readFromFile(File file) throws IOException {
            Throwable th2;
            FileInputStream fileInputStream = new FileInputStream(file);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            DataInputStream inputStream = dataInputStream;
            ProfileVerifier.Cache cache = new ProfileVerifier.Cache(inputStream.readInt(), inputStream.readInt(), inputStream.readLong(), obj6, inputStream.readLong(), obj8);
            inputStream.close();
            return cache;
        }

        public boolean equals(Object o) {
            int i;
            boolean z;
            int mResultCode2;
            int mResultCode;
            long mPackageLastUpdateTime;
            if (this == o) {
                return 1;
            }
            final int i2 = 0;
            if (o != null) {
                if (o instanceof ProfileVerifier.Cache == null) {
                } else {
                    Object obj = o;
                    if (this.mResultCode == obj.mResultCode && Long.compare(mPackageLastUpdateTime2, mPackageLastUpdateTime) == 0 && this.mSchema == obj.mSchema && Long.compare(mInstalledCurrentProfileSize, mPackageLastUpdateTime) == null) {
                        if (Long.compare(mPackageLastUpdateTime2, mPackageLastUpdateTime) == 0) {
                            if (this.mSchema == obj.mSchema) {
                                if (Long.compare(mInstalledCurrentProfileSize, mPackageLastUpdateTime) == null) {
                                } else {
                                    i = i2;
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                }
                return i;
            }
            return i2;
        }

        public int hashCode() {
            return Objects.hash(/* result */);
        }

        void writeOnFile(File file) throws IOException {
            Throwable th;
            Throwable th2;
            file.delete();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
            dataOutputStream.writeInt(this.mSchema);
            dataOutputStream.writeInt(this.mResultCode);
            dataOutputStream.writeLong(this.mPackageLastUpdateTime);
            dataOutputStream.writeLong(this.mInstalledCurrentProfileSize);
            dataOutputStream.close();
        }
    }

    public static class CompilationStatus {

        public static final int RESULT_CODE_COMPILED_WITH_PROFILE = 1;
        public static final int RESULT_CODE_COMPILED_WITH_PROFILE_NON_MATCHING = 3;
        public static final int RESULT_CODE_ERROR_CACHE_FILE_EXISTS_BUT_CANNOT_BE_READ = 131072;
        public static final int RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE = 196608;
        private static final int RESULT_CODE_ERROR_CODE_BIT_SHIFT = 16;
        public static final int RESULT_CODE_ERROR_NO_PROFILE_EMBEDDED = 327680;
        public static final int RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST = 65536;
        public static final int RESULT_CODE_ERROR_UNSUPPORTED_API_VERSION = 262144;
        @Deprecated
        public static final int RESULT_CODE_NO_PROFILE = 0;
        public static final int RESULT_CODE_NO_PROFILE_INSTALLED = 0;
        public static final int RESULT_CODE_PROFILE_ENQUEUED_FOR_COMPILATION = 2;
        private final boolean mHasCurrentProfile;
        private final boolean mHasEmbeddedProfile;
        private final boolean mHasReferenceProfile;
        final int mResultCode;
        CompilationStatus(int resultCode, boolean hasReferenceProfile, boolean hasCurrentProfile, boolean hasEmbeddedProfile) {
            super();
            this.mResultCode = resultCode;
            this.mHasCurrentProfile = hasCurrentProfile;
            this.mHasReferenceProfile = hasReferenceProfile;
            this.mHasEmbeddedProfile = hasEmbeddedProfile;
        }

        public boolean appApkHasEmbeddedProfile() {
            return this.mHasEmbeddedProfile;
        }

        public int getProfileInstallResultCode() {
            return this.mResultCode;
        }

        public boolean hasProfileEnqueuedForCompilation() {
            return this.mHasCurrentProfile;
        }

        public boolean isCompiledWithProfile() {
            return this.mHasReferenceProfile;
        }
    }
    static {
        ProfileVerifier.sFuture = ResolvableFuture.create();
        Object object = new Object();
        ProfileVerifier.SYNC_OBJ = object;
        ProfileVerifier.sCompilationStatus = 0;
    }

    public static ListenableFuture<androidx.profileinstaller.ProfileVerifier.CompilationStatus> getCompilationStatusAsync() {
        return ProfileVerifier.sFuture;
    }

    private static long getPackageLastUpdateTime(Context context) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        if (Build.VERSION.SDK_INT >= 33) {
            return packageInfo.lastUpdateTime;
        }
        return packageInfo2.lastUpdateTime;
    }

    private static androidx.profileinstaller.ProfileVerifier.CompilationStatus setCompilationStatus(int resultCode, boolean hasReferenceProfile, boolean hasCurrentProfile, boolean hasEmbeddedProfile) {
        ProfileVerifier.CompilationStatus compilationStatus = new ProfileVerifier.CompilationStatus(resultCode, hasReferenceProfile, hasCurrentProfile, hasEmbeddedProfile);
        ProfileVerifier.sCompilationStatus = compilationStatus;
        ProfileVerifier.sFuture.set(ProfileVerifier.sCompilationStatus);
        return ProfileVerifier.sCompilationStatus;
    }

    public static androidx.profileinstaller.ProfileVerifier.CompilationStatus writeProfileVerification(Context context) {
        return ProfileVerifier.writeProfileVerification(context, false);
    }

    static androidx.profileinstaller.ProfileVerifier.CompilationStatus writeProfileVerification(Context context, boolean forceVerifyCurrentProfile) {
        Object resultCode;
        int i4;
        int i5;
        boolean exists;
        boolean fromFile;
        int e;
        int i3;
        boolean exists2;
        int currentCache;
        int i2;
        int afd;
        Throwable th;
        int resultCode2;
        long mResultCode;
        long mInstalledCurrentProfileSize;
        int i;
        if (forceVerifyCurrentProfile == null && ProfileVerifier.sCompilationStatus != null) {
            if (ProfileVerifier.sCompilationStatus != null) {
                return ProfileVerifier.sCompilationStatus;
            }
        }
        final Object sYNC_OBJ = ProfileVerifier.SYNC_OBJ;
        synchronized (sYNC_OBJ) {
            if (ProfileVerifier.sCompilationStatus != null) {
                return ProfileVerifier.sCompilationStatus;
            }
            int i7 = 0;
            int i8 = 1;
            i2 = 0;
            AssetFileDescriptor assetFileDescriptor = fd;
            i4 = Long.compare(length, i7) > 0 ? i8 : i2;
            if (assetFileDescriptor != null) {
                assetFileDescriptor.close();
            }
            afd = i4;
            if (Build.VERSION.SDK_INT == 30) {
                return ProfileVerifier.setCompilationStatus(262144, i2, i2, afd);
            }
            File file5 = new File("/data/misc/profiles/ref/", context.getPackageName());
            File file = new File(file5, "primary.prof");
            File file6 = file;
            long length2 = file6.length();
            if (file6.exists() != null && Long.compare(length2, i7) > 0) {
                i5 = Long.compare(length2, i7) > 0 ? i8 : i2;
            } else {
            }
            final int i11 = i5;
            File file7 = new File("/data/misc/profiles/cur/0/", context.getPackageName());
            File file2 = new File(file7, "primary.prof");
            File file8 = file2;
            final long l = mResultCode;
            if (file8.exists() != null && Long.compare(l, i7) > 0) {
                if (Long.compare(l, i7) > 0) {
                    try {
                        i2 = i8;
                        final long packageLastUpdateTime = ProfileVerifier.getPackageLastUpdateTime(context);
                        File file3 = new File(context.getFilesDir(), "profileInstalled");
                        File file4 = file3;
                        currentCache = 0;
                        if (file4.exists() != null) {
                        }
                        currentCache = fromFile;
                        int compilationStatus3 = 131072;
                        compilationStatus3 = ProfileVerifier.setCompilationStatus(compilationStatus3, obj10, obj5, i9);
                        return compilationStatus3;
                        e = 2;
                        resultCode2 = currentCache.mResultCode;
                    } catch (Throwable th) {
                    }
                    if (forceVerifyCurrentProfile != null && i2 != 0 && resultCode2 != i8) {
                        if (i2 != 0) {
                            if (resultCode2 != i8) {
                                resultCode2 = 2;
                            }
                        }
                    }
                    if (currentCache != 0 && currentCache.mResultCode == e && resultCode2 == i8 && Long.compare(length2, mInstalledCurrentProfileSize) < 0) {
                        if (currentCache.mResultCode == e) {
                            if (resultCode2 == i8) {
                                if (Long.compare(length2, mInstalledCurrentProfileSize) < 0) {
                                    try {
                                        i = resultCode2;
                                        i = resultCode2;
                                        ProfileVerifier.Cache cache = new ProfileVerifier.Cache(1, i, packageLastUpdateTime, obj18, l, obj20);
                                    } catch (Throwable th) {
                                    }
                                    if (!currentCache.equals(cache)) {
                                        cache.writeOnFile(file4);
                                    }
                                    i3 = i;
                                    return ProfileVerifier.setCompilationStatus(i3, i11, i2, afd);
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                }
            }
        }
    }
}
