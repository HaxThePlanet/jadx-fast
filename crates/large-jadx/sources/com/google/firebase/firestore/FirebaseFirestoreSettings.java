package com.google.firebase.firestore;

import com.google.firebase.firestore.util.Preconditions;

/* loaded from: classes2.dex */
public final class FirebaseFirestoreSettings {

    public static final long CACHE_SIZE_UNLIMITED = -1L;
    private static final long DEFAULT_CACHE_SIZE_BYTES = 104857600L;
    public static final String DEFAULT_HOST = "firestore.googleapis.com";
    private static final long MINIMUM_CACHE_BYTES = 1048576L;
    private final long cacheSizeBytes;
    private final String host;
    private final boolean persistenceEnabled;
    private final boolean sslEnabled;

    public static final class Builder {

        private long cacheSizeBytes;
        private String host;
        private boolean persistenceEnabled;
        private boolean sslEnabled;
        public Builder() {
            super();
            this.host = "firestore.googleapis.com";
            int i = 1;
            this.sslEnabled = i;
            this.persistenceEnabled = i;
            this.cacheSizeBytes = 104857600;
        }

        public Builder(com.google.firebase.firestore.FirebaseFirestoreSettings firebaseFirestoreSettings) {
            super();
            Preconditions.checkNotNull(firebaseFirestoreSettings, "Provided settings must not be null.");
            this.host = FirebaseFirestoreSettings.access$000(firebaseFirestoreSettings);
            this.sslEnabled = FirebaseFirestoreSettings.access$100(firebaseFirestoreSettings);
            this.persistenceEnabled = FirebaseFirestoreSettings.access$200(firebaseFirestoreSettings);
            this.cacheSizeBytes = FirebaseFirestoreSettings.access$300(firebaseFirestoreSettings);
        }

        static String access$500(com.google.firebase.firestore.FirebaseFirestoreSettings.Builder firebaseFirestoreSettings$Builder) {
            return builder.host;
        }

        static boolean access$600(com.google.firebase.firestore.FirebaseFirestoreSettings.Builder firebaseFirestoreSettings$Builder) {
            return builder.sslEnabled;
        }

        static boolean access$700(com.google.firebase.firestore.FirebaseFirestoreSettings.Builder firebaseFirestoreSettings$Builder) {
            return builder.persistenceEnabled;
        }

        static long access$800(com.google.firebase.firestore.FirebaseFirestoreSettings.Builder firebaseFirestoreSettings$Builder) {
            return builder.cacheSizeBytes;
        }

        public com.google.firebase.firestore.FirebaseFirestoreSettings build() {
            boolean sslEnabled;
            String str;
            if (!this.sslEnabled) {
                if (this.host.equals("firestore.googleapis.com")) {
                } else {
                }
                IllegalStateException illegalStateException = new IllegalStateException("You can't set the 'sslEnabled' setting unless you also set a non-default 'host'.");
                throw illegalStateException;
            }
            FirebaseFirestoreSettings firebaseFirestoreSettings = new FirebaseFirestoreSettings(this, 0);
            return firebaseFirestoreSettings;
        }

        public long getCacheSizeBytes() {
            return this.cacheSizeBytes;
        }

        public String getHost() {
            return this.host;
        }

        public boolean isPersistenceEnabled() {
            return this.persistenceEnabled;
        }

        public boolean isSslEnabled() {
            return this.sslEnabled;
        }

        public com.google.firebase.firestore.FirebaseFirestoreSettings.Builder setCacheSizeBytes(long l) {
            int cmp;
            if (Long.compare(l, i) != 0) {
                if (Long.compare(l, i2) < 0) {
                } else {
                }
                IllegalArgumentException obj3 = new IllegalArgumentException("Cache size must be set to at least 1048576 bytes");
                throw obj3;
            }
            this.cacheSizeBytes = l;
            return this;
        }

        public com.google.firebase.firestore.FirebaseFirestoreSettings.Builder setHost(String string) {
            this.host = (String)Preconditions.checkNotNull(string, "Provided host must not be null.");
            return this;
        }

        public com.google.firebase.firestore.FirebaseFirestoreSettings.Builder setPersistenceEnabled(boolean z) {
            this.persistenceEnabled = z;
            return this;
        }

        public com.google.firebase.firestore.FirebaseFirestoreSettings.Builder setSslEnabled(boolean z) {
            this.sslEnabled = z;
            return this;
        }
    }
    private FirebaseFirestoreSettings(com.google.firebase.firestore.FirebaseFirestoreSettings.Builder firebaseFirestoreSettings$Builder) {
        super();
        this.host = FirebaseFirestoreSettings.Builder.access$500(builder);
        this.sslEnabled = FirebaseFirestoreSettings.Builder.access$600(builder);
        this.persistenceEnabled = FirebaseFirestoreSettings.Builder.access$700(builder);
        this.cacheSizeBytes = FirebaseFirestoreSettings.Builder.access$800(builder);
    }

    FirebaseFirestoreSettings(com.google.firebase.firestore.FirebaseFirestoreSettings.Builder firebaseFirestoreSettings$Builder, com.google.firebase.firestore.FirebaseFirestoreSettings.1 firebaseFirestoreSettings$12) {
        super(builder);
    }

    static String access$000(com.google.firebase.firestore.FirebaseFirestoreSettings firebaseFirestoreSettings) {
        return firebaseFirestoreSettings.host;
    }

    static boolean access$100(com.google.firebase.firestore.FirebaseFirestoreSettings firebaseFirestoreSettings) {
        return firebaseFirestoreSettings.sslEnabled;
    }

    static boolean access$200(com.google.firebase.firestore.FirebaseFirestoreSettings firebaseFirestoreSettings) {
        return firebaseFirestoreSettings.persistenceEnabled;
    }

    static long access$300(com.google.firebase.firestore.FirebaseFirestoreSettings firebaseFirestoreSettings) {
        return firebaseFirestoreSettings.cacheSizeBytes;
    }

    public boolean equals(Object object) {
        int i;
        boolean persistenceEnabled;
        Class<com.google.firebase.firestore.FirebaseFirestoreSettings> obj;
        String persistenceEnabled2;
        Class class;
        long cacheSizeBytes;
        Object obj7;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (FirebaseFirestoreSettings.class != object.getClass()) {
            } else {
                if (this.host.equals(object.host) && this.sslEnabled == object.sslEnabled && this.persistenceEnabled == object.persistenceEnabled && Long.compare(persistenceEnabled, cacheSizeBytes) == 0) {
                    if (this.sslEnabled == object.sslEnabled) {
                        if (this.persistenceEnabled == object.persistenceEnabled) {
                            if (Long.compare(persistenceEnabled, cacheSizeBytes) == 0) {
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

    public long getCacheSizeBytes() {
        return this.cacheSizeBytes;
    }

    public String getHost() {
        return this.host;
    }

    public int hashCode() {
        return i6 += i8;
    }

    public boolean isPersistenceEnabled() {
        return this.persistenceEnabled;
    }

    public boolean isSslEnabled() {
        return this.sslEnabled;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FirebaseFirestoreSettings{host=");
        stringBuilder.append(this.host);
        stringBuilder.append(", sslEnabled=");
        stringBuilder.append(this.sslEnabled);
        stringBuilder.append(", persistenceEnabled=");
        stringBuilder.append(this.persistenceEnabled);
        stringBuilder.append(", cacheSizeBytes=");
        stringBuilder.append(this.cacheSizeBytes);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
