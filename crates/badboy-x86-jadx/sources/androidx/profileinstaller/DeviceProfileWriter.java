package androidx.profileinstaller;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.Build.VERSION;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
public class DeviceProfileWriter {

    private final String mApkName;
    private final AssetManager mAssetManager;
    private final File mCurProfile;
    private final byte[] mDesiredVersion;
    private boolean mDeviceSupportsAotProfile = false;
    private final androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback mDiagnostics;
    private final Executor mExecutor;
    private androidx.profileinstaller.DexProfileData[] mProfile;
    private final String mProfileMetaSourceLocation;
    private final String mProfileSourceLocation;
    private byte[] mTranscodedProfile;
    public DeviceProfileWriter(AssetManager assetManager, Executor executor, androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback diagnosticsCallback, String apkName, String profileSourceLocation, String profileMetaSourceLocation, File curProfile) {
        super();
        int i = 0;
        this.mAssetManager = assetManager;
        this.mExecutor = executor;
        this.mDiagnostics = diagnosticsCallback;
        this.mApkName = apkName;
        this.mProfileSourceLocation = profileSourceLocation;
        this.mProfileMetaSourceLocation = profileMetaSourceLocation;
        this.mCurProfile = curProfile;
        this.mDesiredVersion = DeviceProfileWriter.desiredVersion();
    }

    private androidx.profileinstaller.DeviceProfileWriter addMetadata(androidx.profileinstaller.DexProfileData[] profile, byte[] desiredVersion) {
        InputStream streamFromAssets;
        Throwable mDiagnostics;
        String mProfileMetaSourceLocation;
        Throwable th;
        streamFromAssets = openStreamFromAssets(this.mAssetManager, this.mProfileMetaSourceLocation);
        this.mProfile = ProfileTranscoder.readMeta(streamFromAssets, ProfileTranscoder.readHeader(streamFromAssets, ProfileTranscoder.MAGIC_PROFM), desiredVersion, profile);
        if (streamFromAssets != null && streamFromAssets != null) {
            try {
                this.mProfile = ProfileTranscoder.readMeta(streamFromAssets, ProfileTranscoder.readHeader(streamFromAssets, ProfileTranscoder.MAGIC_PROFM), desiredVersion, profile);
                if (streamFromAssets != null) {
                }
                streamFromAssets.close();
                return this;
                if (th2 == null) {
                } else {
                }
                th2.close();
                mDiagnostics.addSuppressed(th);
                throw mDiagnostics;
            } catch (Throwable th) {
            }
            streamFromAssets.close();
            return null;
        }
    }

    private void assertDeviceAllowsProfileInstallerAotWritesCalled() {
        if (this.mDeviceSupportsAotProfile == null) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        throw illegalStateException;
    }

    private static byte[] desiredVersion() {
        if (Build.VERSION.SDK_INT >= 31) {
            return ProfileVersion.V015_S;
        }
        switch (sDK_INT2) {
            case 24:
                return ProfileVersion.V001_N;
            case 25:
                return ProfileVersion.V005_O;
            case 26:
                return ProfileVersion.V009_O_MR1;
            case 27:
                return ProfileVersion.V010_P;
            default:
                return null;
        }
    }

    private InputStream getProfileInputStream(AssetManager assetManager) {
        InputStream streamFromAssets;
        androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback mDiagnostics;
        int i;
        int i2 = 0;
        try {
            mDiagnostics = this.mDiagnostics;
            i = 7;
            mDiagnostics.onResultReceived(i, e);
            mDiagnostics = this.mDiagnostics;
            i = 6;
            mDiagnostics.onResultReceived(i, e);
            return openStreamFromAssets(assetManager, this.mProfileSourceLocation);
        }
    }

    private InputStream openStreamFromAssets(AssetManager assetManager, String location) throws IOException {
        AssetFileDescriptor assetFileDescriptor;
        java.io.FileInputStream inputStream;
        String mDiagnostics;
        int i;
        int i2;
        int i3 = 0;
        return assetManager.openFd(location).createInputStream();
    }

    private androidx.profileinstaller.DexProfileData[] readProfileInternal(InputStream profileStream) {
        byte[] header;
        androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback diagnosticsCallback;
        androidx.profileinstaller.DexProfileData[] profile;
        int mDiagnostics;
        int i = 0;
        final int i2 = 7;
        profileStream.close();
        return ProfileTranscoder.readProfile(profileStream, ProfileTranscoder.readHeader(profileStream, ProfileTranscoder.MAGIC_PROF), this.mApkName);
    }

    private static boolean requiresMetadata() {
        final int i3 = 1;
        if (Build.VERSION.SDK_INT >= 31) {
            return i3;
        }
        int i2 = 0;
        switch (sDK_INT2) {
            case 24:
                return i3;
            case 25:
                return i2;
            default:
                return i2;
        }
    }

    private void result(int code, Object data) {
        DeviceProfileWriter$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new DeviceProfileWriter$$ExternalSyntheticLambda0(this, code, data);
        this.mExecutor.execute(externalSyntheticLambda0);
    }

    public boolean deviceAllowsProfileInstallerAotWrites() {
        boolean newFile;
        final int i2 = 0;
        if (this.mDesiredVersion == null) {
            result(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return i2;
        }
        int i3 = 0;
        final int i5 = 4;
        if (this.mCurProfile.exists() != null) {
            if (this.mCurProfile.canWrite() == null) {
                result(i5, i3);
                return i2;
            }
        } else {
            if (this.mCurProfile.createNewFile() == null) {
                result(i5, i3);
                return i2;
            }
        }
        int i = 1;
        this.mDeviceSupportsAotProfile = i;
        return i;
    }

    void lambda$result$0$androidx-profileinstaller-DeviceProfileWriter(int code, Object data) {
        this.mDiagnostics.onResultReceived(code, data);
    }

    public androidx.profileinstaller.DeviceProfileWriter read() {
        androidx.profileinstaller.DexProfileData[] profileInternal;
        androidx.profileinstaller.DexProfileData[] mProfile;
        boolean requiresMetadata;
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        if (this.mDesiredVersion == null) {
            return this;
        }
        InputStream profileInputStream = getProfileInputStream(this.mAssetManager);
        if (profileInputStream != null) {
            this.mProfile = readProfileInternal(profileInputStream);
        }
        requiresMetadata = addMetadata(this.mProfile, this.mDesiredVersion);
        if (this.mProfile != null && DeviceProfileWriter.requiresMetadata() != null && requiresMetadata != null) {
            if (DeviceProfileWriter.requiresMetadata() != null) {
                requiresMetadata = addMetadata(this.mProfile, this.mDesiredVersion);
                if (requiresMetadata != null) {
                    return requiresMetadata;
                }
            }
        }
        return this;
    }

    public androidx.profileinstaller.DeviceProfileWriter transcodeIfNeeded() {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable mDiagnostics;
        boolean transcodeAndWriteBody;
        Throwable th;
        byte[] byteArray;
        final androidx.profileinstaller.DexProfileData[] mProfile = this.mProfile;
        final byte[] mDesiredVersion = this.mDesiredVersion;
        if (mProfile != null) {
            if (mDesiredVersion == null) {
            } else {
                assertDeviceAllowsProfileInstallerAotWritesCalled();
                final int i = 0;
                byteArrayOutputStream = new ByteArrayOutputStream();
                ProfileTranscoder.writeHeader(byteArrayOutputStream, mDesiredVersion);
                if (ProfileTranscoder.transcodeAndWriteBody(byteArrayOutputStream, mDesiredVersion, mProfile) == null) {
                    this.mDiagnostics.onResultReceived(5, i);
                    this.mProfile = i;
                    byteArrayOutputStream.close();
                    return this;
                }
                this.mTranscodedProfile = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            }
            this.mProfile = i;
            return this;
        }
        try {
            return this;
        } catch (Throwable th) {
        }
    }

    public boolean write() {
        Throwable th;
        Throwable th5;
        Throwable th2;
        Throwable th3;
        Throwable th4;
        Throwable th6;
        final byte[] mTranscodedProfile = this.mTranscodedProfile;
        if (mTranscodedProfile == null) {
            return 0;
        }
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        final int i2 = 0;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(mTranscodedProfile);
        FileOutputStream fileOutputStream = new FileOutputStream(this.mCurProfile);
        FileChannel channel = fileOutputStream.getChannel();
        final FileLock tryLock = channel.tryLock();
        Encoding.writeAll(byteArrayInputStream, fileOutputStream, tryLock);
        final int i3 = 1;
        result(i3, i2);
        if (tryLock != null) {
            tryLock.close();
        }
        if (channel != null) {
            channel.close();
        }
        fileOutputStream.close();
        byteArrayInputStream.close();
        this.mTranscodedProfile = i2;
        this.mProfile = i2;
        return i3;
    }
}
