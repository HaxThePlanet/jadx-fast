package com.google.firebase.database;

import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.database.core.DatabaseConfig;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.Repo;
import com.google.firebase.database.core.RepoInfo;
import com.google.firebase.database.core.RepoManager;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.emulators.EmulatedServiceSettings;
import java.util.Objects;

/* loaded from: classes2.dex */
public class FirebaseDatabase {

    private static final String SDK_VERSION = "20.0.2";
    private final FirebaseApp app;
    private final DatabaseConfig config;
    private EmulatedServiceSettings emulatorSettings;
    private Repo repo;
    private final RepoInfo repoInfo;
    FirebaseDatabase(FirebaseApp firebaseApp, RepoInfo repoInfo2, DatabaseConfig databaseConfig3) {
        super();
        this.app = firebaseApp;
        this.repoInfo = repoInfo2;
        this.config = databaseConfig3;
    }

    static Repo access$000(com.google.firebase.database.FirebaseDatabase firebaseDatabase) {
        return firebaseDatabase.repo;
    }

    private void assertUnfrozen(String string) {
        if (this.repo != null) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Calls to ");
        stringBuilder.append(string);
        stringBuilder.append("() must be made before any other usage of FirebaseDatabase instance.");
        DatabaseException databaseException = new DatabaseException(stringBuilder.toString());
        throw databaseException;
    }

    static com.google.firebase.database.FirebaseDatabase createForTests(FirebaseApp firebaseApp, RepoInfo repoInfo2, DatabaseConfig databaseConfig3) {
        FirebaseDatabase firebaseDatabase = new FirebaseDatabase(firebaseApp, repoInfo2, databaseConfig3);
        firebaseDatabase.ensureRepo();
        return firebaseDatabase;
    }

    private void ensureRepo() {
        Repo repo;
        RepoInfo repoInfo;
        synchronized (this) {
            try {
                this.repoInfo.applyEmulatorSettings(this.emulatorSettings);
                this.repo = RepoManager.createRepo(this.config, this.repoInfo, this);
                throw th;
            }
        }
    }

    public static com.google.firebase.database.FirebaseDatabase getInstance() {
        FirebaseApp instance = FirebaseApp.getInstance();
        if (instance == null) {
        } else {
            return FirebaseDatabase.getInstance(instance);
        }
        DatabaseException databaseException = new DatabaseException("You must call FirebaseApp.initialize() first.");
        throw databaseException;
    }

    public static com.google.firebase.database.FirebaseDatabase getInstance(FirebaseApp firebaseApp) {
        String databaseUrl;
        String str;
        if (firebaseApp.getOptions().getDatabaseUrl() == null) {
            if (firebaseApp.getOptions().getProjectId() == null) {
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("https://");
                stringBuilder.append(firebaseApp.getOptions().getProjectId());
                stringBuilder.append("-default-rtdb.firebaseio.com");
                databaseUrl = stringBuilder.toString();
            }
            DatabaseException obj2 = new DatabaseException("Failed to get FirebaseDatabase instance: Can't determine Firebase Database URL. Be sure to include a Project ID in your configuration.");
            throw obj2;
        }
        return FirebaseDatabase.getInstance(firebaseApp, databaseUrl);
    }

    public static com.google.firebase.database.FirebaseDatabase getInstance(FirebaseApp firebaseApp, String string2) {
        final Class<com.google.firebase.database.FirebaseDatabase> obj = FirebaseDatabase.class;
        synchronized (obj) {
            r.k(firebaseApp, "Provided FirebaseApp must not be null.");
            Object obj4 = firebaseApp.get(FirebaseDatabaseComponent.class);
            r.k((FirebaseDatabaseComponent)obj4, "Firebase Database component is not present.");
            com.google.firebase.database.core.utilities.ParsedUrl url = Utilities.parseUrl(string2);
            if (!url.path.isEmpty()) {
            } else {
                return obj4.get(url.repoInfo);
            }
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Specified Database URL '");
                stringBuilder.append(string2);
                stringBuilder.append("' is invalid. It should point to the root of a Firebase Database but it includes a path: ");
                stringBuilder.append(url.path.toString());
                obj4 = new DatabaseException(stringBuilder.toString());
                throw obj4;
                obj4 = new DatabaseException("Failed to get FirebaseDatabase instance: Specify DatabaseURL within FirebaseApp or from your getInstance() call.");
                throw obj4;
                throw firebaseApp;
            }
        }
    }

    public static com.google.firebase.database.FirebaseDatabase getInstance(String string) {
        FirebaseApp instance = FirebaseApp.getInstance();
        if (instance == null) {
        } else {
            return FirebaseDatabase.getInstance(instance, string);
        }
        DatabaseException obj1 = new DatabaseException("You must call FirebaseApp.initialize() first.");
        throw obj1;
    }

    public static String getSdkVersion() {
        return "20.0.2";
    }

    public FirebaseApp getApp() {
        return this.app;
    }

    DatabaseConfig getConfig() {
        return this.config;
    }

    public com.google.firebase.database.DatabaseReference getReference() {
        ensureRepo();
        DatabaseReference databaseReference = new DatabaseReference(this.repo, Path.getEmptyPath());
        return databaseReference;
    }

    public com.google.firebase.database.DatabaseReference getReference(String string) {
        ensureRepo();
        Objects.requireNonNull(string, "Can't pass null for argument 'pathString' in FirebaseDatabase.getReference()");
        Validation.validateRootPathString(string);
        Path path = new Path(string);
        DatabaseReference obj3 = new DatabaseReference(this.repo, path);
        return obj3;
    }

    public com.google.firebase.database.DatabaseReference getReferenceFromUrl(String string) {
        ensureRepo();
        Objects.requireNonNull(string, "Can't pass null for argument 'url' in FirebaseDatabase.getReferenceFromUrl()");
        com.google.firebase.database.core.utilities.ParsedUrl url = Utilities.parseUrl(string);
        url.repoInfo.applyEmulatorSettings(this.emulatorSettings);
        if (!repoInfo2.host.equals(repoInfo3.host)) {
        } else {
            DatabaseReference obj4 = new DatabaseReference(this.repo, url.path);
            return obj4;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid URL (");
        stringBuilder.append(string);
        stringBuilder.append(") passed to getReference().  URL was expected to match configured Database URL: ");
        stringBuilder.append(getReference().toString());
        DatabaseException databaseException = new DatabaseException(stringBuilder.toString());
        throw databaseException;
    }

    public void goOffline() {
        ensureRepo();
        RepoManager.interrupt(this.repo);
    }

    public void goOnline() {
        ensureRepo();
        RepoManager.resume(this.repo);
    }

    public void purgeOutstandingWrites() {
        ensureRepo();
        FirebaseDatabase.1 anon = new FirebaseDatabase.1(this);
        this.repo.scheduleNow(anon);
    }

    public void setLogLevel(com.google.firebase.database.Logger.Level logger$Level) {
        assertUnfrozen("setLogLevel");
        this.config.setLogLevel(level);
        return;
        synchronized (this) {
            assertUnfrozen("setLogLevel");
            this.config.setLogLevel(level);
        }
    }

    public void setPersistenceCacheSizeBytes(long l) {
        assertUnfrozen("setPersistenceCacheSizeBytes");
        this.config.setPersistenceCacheSizeBytes(l);
        return;
        synchronized (this) {
            assertUnfrozen("setPersistenceCacheSizeBytes");
            this.config.setPersistenceCacheSizeBytes(l);
        }
    }

    public void setPersistenceEnabled(boolean z) {
        assertUnfrozen("setPersistenceEnabled");
        this.config.setPersistenceEnabled(z);
        return;
        synchronized (this) {
            assertUnfrozen("setPersistenceEnabled");
            this.config.setPersistenceEnabled(z);
        }
    }

    public void useEmulator(String string, int i2) {
        if (this.repo != null) {
        } else {
            EmulatedServiceSettings emulatedServiceSettings = new EmulatedServiceSettings(string, i2);
            this.emulatorSettings = emulatedServiceSettings;
        }
        IllegalStateException obj2 = new IllegalStateException("Cannot call useEmulator() after instance has already been initialized.");
        throw obj2;
    }
}
