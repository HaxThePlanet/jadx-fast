package com.google.firebase.perf.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.firebase.FirebaseApp;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public class DeviceCacheManager {

    private static final String PREFS_NAME = "FirebasePerfSharedPrefs";
    private static com.google.firebase.perf.config.DeviceCacheManager instance;
    private static final AndroidLogger logger;
    private final ExecutorService serialExecutor;
    private volatile SharedPreferences sharedPref;
    static {
        DeviceCacheManager.logger = AndroidLogger.getInstance();
    }

    public DeviceCacheManager(ExecutorService executorService) {
        super();
        this.serialExecutor = executorService;
    }

    private void a(Context context) {
        SharedPreferences sharedPref;
        String str;
        SharedPreferences obj3;
        if (this.sharedPref == null && context != null) {
            if (context != null) {
                this.sharedPref = context.getSharedPreferences("FirebasePerfSharedPrefs", 0);
            }
        }
    }

    public static void clearInstance() {
        DeviceCacheManager.instance = 0;
    }

    private Context getFirebaseApplicationContext() {
        try {
            FirebaseApp.getInstance();
            return FirebaseApp.getInstance().getApplicationContext();
            return null;
        }
    }

    public static com.google.firebase.perf.config.DeviceCacheManager getInstance() {
        com.google.firebase.perf.config.DeviceCacheManager deviceCacheManager;
        ExecutorService singleThreadExecutor;
        final Class<com.google.firebase.perf.config.DeviceCacheManager> obj = DeviceCacheManager.class;
        synchronized (obj) {
            deviceCacheManager = new DeviceCacheManager(Executors.newSingleThreadExecutor());
            DeviceCacheManager.instance = deviceCacheManager;
            return DeviceCacheManager.instance;
        }
    }

    public void b(Context context) {
        a(context);
    }

    public void clear(String string) {
        if (string == null) {
            DeviceCacheManager.logger.debug("Key is null. Cannot clear nullable key");
        }
        this.sharedPref.edit().remove(string).apply();
    }

    public boolean containsKey(String string) {
        SharedPreferences sharedPref;
        int obj2;
        if (this.sharedPref != null && string != null && this.sharedPref.contains(string)) {
            if (string != null) {
                obj2 = this.sharedPref.contains(string) ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj2;
    }

    public Optional<Boolean> getBoolean(String string) {
        SharedPreferences sharedPref;
        if (string == null) {
            DeviceCacheManager.logger.debug("Key is null when getting boolean value on device cache.");
            return Optional.absent();
        }
        setContext(getFirebaseApplicationContext());
        if (this.sharedPref == null && this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return Optional.absent();
            }
        }
        if (!this.sharedPref.contains(string)) {
            return Optional.absent();
        }
        return Optional.of(Boolean.valueOf(this.sharedPref.getBoolean(string, false)));
    }

    public Optional<Float> getFloat(String string) {
        SharedPreferences sharedPref;
        if (string == null) {
            DeviceCacheManager.logger.debug("Key is null when getting float value on device cache.");
            return Optional.absent();
        }
        setContext(getFirebaseApplicationContext());
        if (this.sharedPref == null && this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return Optional.absent();
            }
        }
        if (!this.sharedPref.contains(string)) {
            return Optional.absent();
        }
        return Optional.of(Float.valueOf(this.sharedPref.getFloat(string, 0)));
    }

    public Optional<Long> getLong(String string) {
        SharedPreferences sharedPref;
        if (string == null) {
            DeviceCacheManager.logger.debug("Key is null when getting long value on device cache.");
            return Optional.absent();
        }
        setContext(getFirebaseApplicationContext());
        if (this.sharedPref == null && this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return Optional.absent();
            }
        }
        if (!this.sharedPref.contains(string)) {
            return Optional.absent();
        }
        final int i = 0;
        return Optional.of(Long.valueOf(this.sharedPref.getLong(string, i)));
    }

    public Optional<String> getString(String string) {
        SharedPreferences sharedPref;
        if (string == null) {
            DeviceCacheManager.logger.debug("Key is null when getting String value on device cache.");
            return Optional.absent();
        }
        setContext(getFirebaseApplicationContext());
        if (this.sharedPref == null && this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return Optional.absent();
            }
        }
        if (!this.sharedPref.contains(string)) {
            return Optional.absent();
        }
        return Optional.of(this.sharedPref.getString(string, ""));
    }

    public void setContext(Context context) {
        Object serialExecutor;
        com.google.firebase.perf.config.a aVar;
        synchronized (this) {
            try {
                if (context != null) {
                }
                aVar = new a(this, context);
                this.serialExecutor.execute(aVar);
                throw context;
            }
        }
    }

    public boolean setValue(String string, float f2) {
        SharedPreferences sharedPref;
        int i = 0;
        if (string == null) {
            DeviceCacheManager.logger.debug("Key is null when setting float value on device cache.");
            return i;
        }
        setContext(getFirebaseApplicationContext());
        if (this.sharedPref == null && this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return i;
            }
        }
        this.sharedPref.edit().putFloat(string, f2).apply();
        return 1;
    }

    public boolean setValue(String string, long l2) {
        SharedPreferences sharedPref;
        int i = 0;
        if (string == null) {
            DeviceCacheManager.logger.debug("Key is null when setting long value on device cache.");
            return i;
        }
        setContext(getFirebaseApplicationContext());
        if (this.sharedPref == null && this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return i;
            }
        }
        this.sharedPref.edit().putLong(string, l2).apply();
        return 1;
    }

    public boolean setValue(String string, String string2) {
        SharedPreferences sharedPref;
        int i = 0;
        if (string == null) {
            DeviceCacheManager.logger.debug("Key is null when setting String value on device cache.");
            return i;
        }
        setContext(getFirebaseApplicationContext());
        if (this.sharedPref == null && this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return i;
            }
        }
        int i2 = 1;
        if (string2 == null) {
            this.sharedPref.edit().remove(string).apply();
            return i2;
        }
        this.sharedPref.edit().putString(string, string2).apply();
        return i2;
    }

    public boolean setValue(String string, boolean z2) {
        SharedPreferences sharedPref;
        int i = 0;
        if (string == null) {
            DeviceCacheManager.logger.debug("Key is null when setting boolean value on device cache.");
            return i;
        }
        setContext(getFirebaseApplicationContext());
        if (this.sharedPref == null && this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return i;
            }
        }
        this.sharedPref.edit().putBoolean(string, z2).apply();
        return 1;
    }
}
