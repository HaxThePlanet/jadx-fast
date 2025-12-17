package com.google.firebase.storage;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.r;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.appcheck.AppCheckTokenResult;
import com.google.firebase.appcheck.interop.AppCheckTokenListener;
import com.google.firebase.appcheck.interop.InternalAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.emulators.EmulatedServiceSettings;
import com.google.firebase.inject.Provider;
import com.google.firebase.storage.internal.Util;

/* loaded from: classes2.dex */
public class FirebaseStorage {

    static final boolean $assertionsDisabled = false;
    private static final String STORAGE_BUCKET_WITH_PATH_EXCEPTION = "The storage Uri cannot contain a path element.";
    private static final String STORAGE_URI_PARSE_EXCEPTION = "The storage Uri could not be parsed.";
    private static final String TAG = "FirebaseStorage";
    private EmulatedServiceSettings emulatorSettings;
    private final FirebaseApp mApp;
    private final Provider<InternalAppCheckTokenProvider> mAppCheckProvider;
    private final Provider<InternalAuthProvider> mAuthProvider;
    private final String mBucketName;
    private long sMaxDownloadRetry = 600000;
    private long sMaxQueryRetry = 120000;
    private long sMaxUploadRetry = 600000;
    static {
    }

    FirebaseStorage(String string, FirebaseApp firebaseApp2, Provider<InternalAuthProvider> provider3, Provider<InternalAppCheckTokenProvider> provider4) {
        Object obj3;
        Object obj4;
        super();
        int i = 600000;
        int i2 = 120000;
        this.mBucketName = string;
        this.mApp = firebaseApp2;
        this.mAuthProvider = provider3;
        this.mAppCheckProvider = provider4;
        if (provider4 != null && provider4.get() != null) {
            if (provider4.get() != null) {
                obj4 = new FirebaseStorage.1(this);
                (InternalAppCheckTokenProvider)provider4.get().addAppCheckTokenListener(obj4);
            }
        }
    }

    private String getBucketName() {
        return this.mBucketName;
    }

    public static com.google.firebase.storage.FirebaseStorage getInstance() {
        int i;
        FirebaseApp instance = FirebaseApp.getInstance();
        i = instance != null ? 1 : 0;
        r.b(i, "You must call FirebaseApp.initialize() first.");
        return FirebaseStorage.getInstance(instance);
    }

    public static com.google.firebase.storage.FirebaseStorage getInstance(FirebaseApp firebaseApp) {
        int i;
        i = firebaseApp != null ? 1 : 0;
        r.b(i, "Null is not a valid value for the FirebaseApp.");
        if (firebaseApp.getOptions().getStorageBucket() == null) {
            return FirebaseStorage.getInstanceImpl(firebaseApp, 0);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("gs://");
        stringBuilder.append(firebaseApp.getOptions().getStorageBucket());
        return FirebaseStorage.getInstanceImpl(firebaseApp, Util.normalize(firebaseApp, stringBuilder.toString()));
    }

    public static com.google.firebase.storage.FirebaseStorage getInstance(FirebaseApp firebaseApp, String string2) {
        int i;
        int i2;
        int i3 = 0;
        i2 = firebaseApp != null ? i : i3;
        r.b(i2, "Null is not a valid value for the FirebaseApp.");
        if (string2 != null) {
        } else {
            i = i3;
        }
        r.b(i, "Null is not a valid value for the Firebase Storage URL.");
        if (!string2.toLowerCase().startsWith("gs://")) {
        } else {
            return FirebaseStorage.getInstanceImpl(firebaseApp, Util.normalize(firebaseApp, string2));
        }
        IllegalArgumentException obj4 = new IllegalArgumentException("Please use a gs:// URL for your Firebase Storage bucket.");
        throw obj4;
    }

    public static com.google.firebase.storage.FirebaseStorage getInstance(String string) {
        int i;
        final FirebaseApp instance = FirebaseApp.getInstance();
        i = instance != null ? 1 : 0;
        r.b(i, "You must call FirebaseApp.initialize() first.");
        return FirebaseStorage.getInstance(instance, string);
    }

    private static com.google.firebase.storage.FirebaseStorage getInstanceImpl(FirebaseApp firebaseApp, Uri uri2) {
        int host;
        boolean obj2;
        if (uri2 != null) {
            host = uri2.getHost();
        } else {
            host = 0;
        }
        if (uri2 != null) {
            if (!TextUtils.isEmpty(uri2.getPath())) {
            } else {
            }
            IllegalArgumentException obj1 = new IllegalArgumentException("The storage Uri cannot contain a path element.");
            throw obj1;
        }
        r.k(firebaseApp, "Provided FirebaseApp must not be null.");
        obj1 = firebaseApp.get(FirebaseStorageComponent.class);
        r.k((FirebaseStorageComponent)obj1, "Firebase Storage component is not present.");
        return obj1.get(host);
    }

    private com.google.firebase.storage.StorageReference getReference(Uri uri) {
        int i;
        String equalsIgnoreCase;
        String authority;
        r.k(uri, "uri must not be null");
        equalsIgnoreCase = getBucketName();
        if (!TextUtils.isEmpty(equalsIgnoreCase)) {
            if (uri.getAuthority().equalsIgnoreCase(equalsIgnoreCase)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        r.b(i, "The supplied bucketname does not match the storage bucket of the current instance.");
        StorageReference storageReference = new StorageReference(uri, this);
        return storageReference;
    }

    public FirebaseApp getApp() {
        return this.mApp;
    }

    InternalAppCheckTokenProvider getAppCheckProvider() {
        Object obj;
        Provider mAppCheckProvider = this.mAppCheckProvider;
        if (mAppCheckProvider != null) {
            obj = mAppCheckProvider.get();
        } else {
            obj = 0;
        }
        return obj;
    }

    InternalAuthProvider getAuthProvider() {
        Object obj;
        Provider mAuthProvider = this.mAuthProvider;
        if (mAuthProvider != null) {
            obj = mAuthProvider.get();
        } else {
            obj = 0;
        }
        return obj;
    }

    EmulatedServiceSettings getEmulatorSettings() {
        return this.emulatorSettings;
    }

    public long getMaxDownloadRetryTimeMillis() {
        return this.sMaxDownloadRetry;
    }

    public long getMaxOperationRetryTimeMillis() {
        return this.sMaxQueryRetry;
    }

    public long getMaxUploadRetryTimeMillis() {
        return this.sMaxUploadRetry;
    }

    public com.google.firebase.storage.StorageReference getReference() {
        if (TextUtils.isEmpty(getBucketName())) {
        } else {
            Uri.Builder builder = new Uri.Builder();
            return getReference(builder.scheme("gs").authority(getBucketName()).path("/").build());
        }
        IllegalStateException illegalStateException = new IllegalStateException("FirebaseApp was not initialized with a bucket name.");
        throw illegalStateException;
    }

    public com.google.firebase.storage.StorageReference getReference(String string) {
        String startsWith;
        boolean startsWith2;
        r.b(empty ^= 1, "location must not be null or empty");
        startsWith = string.toLowerCase();
        if (startsWith.startsWith("gs://")) {
        } else {
            if (startsWith.startsWith("https://")) {
            } else {
                if (startsWith.startsWith("http://")) {
                } else {
                    return getReference().child(string);
                }
            }
        }
        IllegalArgumentException obj3 = new IllegalArgumentException("location should not be a full URL.");
        throw obj3;
    }

    public com.google.firebase.storage.StorageReference getReferenceFromUrl(String string) {
        String startsWith;
        boolean startsWith2;
        r.b(empty ^= 1, "location must not be null or empty");
        startsWith = string.toLowerCase();
        final String str5 = "The storage Uri could not be parsed.";
        if (!startsWith.startsWith("gs://") && !startsWith.startsWith("https://")) {
            if (!startsWith.startsWith("https://")) {
                if (!startsWith.startsWith("http://")) {
                } else {
                }
                IllegalArgumentException obj5 = new IllegalArgumentException(str5);
                throw obj5;
            }
        }
        Uri normalize = Util.normalize(this.mApp, string);
        if (normalize == null) {
        } else {
            return getReference(normalize);
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(str5);
        throw illegalArgumentException;
    }

    public void setMaxDownloadRetryTimeMillis(long l) {
        this.sMaxDownloadRetry = l;
    }

    public void setMaxOperationRetryTimeMillis(long l) {
        this.sMaxQueryRetry = l;
    }

    public void setMaxUploadRetryTimeMillis(long l) {
        this.sMaxUploadRetry = l;
    }

    public void useEmulator(String string, int i2) {
        EmulatedServiceSettings emulatedServiceSettings = new EmulatedServiceSettings(string, i2);
        this.emulatorSettings = emulatedServiceSettings;
    }
}
