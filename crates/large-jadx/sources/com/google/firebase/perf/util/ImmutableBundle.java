package com.google.firebase.perf.util;

import android.os.Bundle;
import com.google.firebase.perf.logging.AndroidLogger;

/* loaded from: classes2.dex */
public final class ImmutableBundle {

    private static final AndroidLogger logger;
    private final Bundle bundle;
    static {
        ImmutableBundle.logger = AndroidLogger.getInstance();
    }

    public ImmutableBundle() {
        Bundle bundle = new Bundle();
        super(bundle);
    }

    public ImmutableBundle(Bundle bundle) {
        super();
        this.bundle = (Bundle)bundle.clone();
    }

    private com.google.firebase.perf.util.Optional<Integer> getInt(String string) {
        if (!containsKey(string)) {
            return Optional.absent();
        }
        return Optional.fromNullable((Integer)this.bundle.get(string));
    }

    public boolean containsKey(String string) {
        Bundle bundle;
        String obj2;
        if (string != null && this.bundle.containsKey(string)) {
            obj2 = this.bundle.containsKey(string) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    public com.google.firebase.perf.util.Optional<Boolean> getBoolean(String string) {
        if (!containsKey(string)) {
            return Optional.absent();
        }
        return Optional.fromNullable((Boolean)this.bundle.get(string));
    }

    public com.google.firebase.perf.util.Optional<Float> getFloat(String string) {
        if (!containsKey(string)) {
            return Optional.absent();
        }
        return Optional.fromNullable((Float)this.bundle.get(string));
    }

    public com.google.firebase.perf.util.Optional<Long> getLong(String string) {
        com.google.firebase.perf.util.Optional obj3 = getInt(string);
        if (obj3.isAvailable()) {
            return Optional.of(Long.valueOf((long)obj3));
        }
        return Optional.absent();
    }
}
