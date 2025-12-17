package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.p.a;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.u;
import com.google.android.gms.common.util.n;

/* loaded from: classes2.dex */
public final class FirebaseOptions {

    private static final String API_KEY_RESOURCE_NAME = "google_api_key";
    private static final String APP_ID_RESOURCE_NAME = "google_app_id";
    private static final String DATABASE_URL_RESOURCE_NAME = "firebase_database_url";
    private static final String GA_TRACKING_ID_RESOURCE_NAME = "ga_trackingId";
    private static final String GCM_SENDER_ID_RESOURCE_NAME = "gcm_defaultSenderId";
    private static final String PROJECT_ID_RESOURCE_NAME = "project_id";
    private static final String STORAGE_BUCKET_RESOURCE_NAME = "google_storage_bucket";
    private final String apiKey;
    private final String applicationId;
    private final String databaseUrl;
    private final String gaTrackingId;
    private final String gcmSenderId;
    private final String projectId;
    private final String storageBucket;

    public static final class Builder {

        private String apiKey;
        private String applicationId;
        private String databaseUrl;
        private String gaTrackingId;
        private String gcmSenderId;
        private String projectId;
        private String storageBucket;
        public Builder(com.google.firebase.FirebaseOptions firebaseOptions) {
            super();
            this.applicationId = FirebaseOptions.access$000(firebaseOptions);
            this.apiKey = FirebaseOptions.access$100(firebaseOptions);
            this.databaseUrl = FirebaseOptions.access$200(firebaseOptions);
            this.gaTrackingId = FirebaseOptions.access$300(firebaseOptions);
            this.gcmSenderId = FirebaseOptions.access$400(firebaseOptions);
            this.storageBucket = FirebaseOptions.access$500(firebaseOptions);
            this.projectId = FirebaseOptions.access$600(firebaseOptions);
        }

        public com.google.firebase.FirebaseOptions build() {
            super(this.applicationId, this.apiKey, this.databaseUrl, this.gaTrackingId, this.gcmSenderId, this.storageBucket, this.projectId, 0);
            return firebaseOptions2;
        }

        public com.google.firebase.FirebaseOptions.Builder setApiKey(String string) {
            r.g(string, "ApiKey must be set.");
            this.apiKey = string;
            return this;
        }

        public com.google.firebase.FirebaseOptions.Builder setApplicationId(String string) {
            r.g(string, "ApplicationId must be set.");
            this.applicationId = string;
            return this;
        }

        public com.google.firebase.FirebaseOptions.Builder setDatabaseUrl(String string) {
            this.databaseUrl = string;
            return this;
        }

        public com.google.firebase.FirebaseOptions.Builder setGaTrackingId(String string) {
            this.gaTrackingId = string;
            return this;
        }

        public com.google.firebase.FirebaseOptions.Builder setGcmSenderId(String string) {
            this.gcmSenderId = string;
            return this;
        }

        public com.google.firebase.FirebaseOptions.Builder setProjectId(String string) {
            this.projectId = string;
            return this;
        }

        public com.google.firebase.FirebaseOptions.Builder setStorageBucket(String string) {
            this.storageBucket = string;
            return this;
        }
    }
    private FirebaseOptions(String string, String string2, String string3, String string4, String string5, String string6, String string7) {
        super();
        r.n(z ^= 1, "ApplicationId must be set.");
        this.applicationId = string;
        this.apiKey = string2;
        this.databaseUrl = string3;
        this.gaTrackingId = string4;
        this.gcmSenderId = string5;
        this.storageBucket = string6;
        this.projectId = string7;
    }

    FirebaseOptions(String string, String string2, String string3, String string4, String string5, String string6, String string7, com.google.firebase.FirebaseOptions.1 firebaseOptions$18) {
        super(string, string2, string3, string4, string5, string6, string7);
    }

    static String access$000(com.google.firebase.FirebaseOptions firebaseOptions) {
        return firebaseOptions.applicationId;
    }

    static String access$100(com.google.firebase.FirebaseOptions firebaseOptions) {
        return firebaseOptions.apiKey;
    }

    static String access$200(com.google.firebase.FirebaseOptions firebaseOptions) {
        return firebaseOptions.databaseUrl;
    }

    static String access$300(com.google.firebase.FirebaseOptions firebaseOptions) {
        return firebaseOptions.gaTrackingId;
    }

    static String access$400(com.google.firebase.FirebaseOptions firebaseOptions) {
        return firebaseOptions.gcmSenderId;
    }

    static String access$500(com.google.firebase.FirebaseOptions firebaseOptions) {
        return firebaseOptions.storageBucket;
    }

    static String access$600(com.google.firebase.FirebaseOptions firebaseOptions) {
        return firebaseOptions.projectId;
    }

    public static com.google.firebase.FirebaseOptions fromResource(Context context) {
        u uVar = new u(context);
        final String str7 = uVar.a("google_app_id");
        if (TextUtils.isEmpty(str7)) {
            return null;
        }
        super(str7, uVar.a("google_api_key"), uVar.a("firebase_database_url"), uVar.a("ga_trackingId"), uVar.a("gcm_defaultSenderId"), uVar.a("google_storage_bucket"), uVar.a("project_id"));
        return obj9;
    }

    public boolean equals(Object object) {
        boolean projectId;
        int i;
        String applicationId;
        Object obj4;
        if (!object instanceof FirebaseOptions) {
            return 0;
        }
        if (p.a(this.applicationId, object.applicationId) && p.a(this.apiKey, object.apiKey) && p.a(this.databaseUrl, object.databaseUrl) && p.a(this.gaTrackingId, object.gaTrackingId) && p.a(this.gcmSenderId, object.gcmSenderId) && p.a(this.storageBucket, object.storageBucket) != null && p.a(this.projectId, object.projectId)) {
            if (p.a(this.apiKey, object.apiKey)) {
                if (p.a(this.databaseUrl, object.databaseUrl)) {
                    if (p.a(this.gaTrackingId, object.gaTrackingId)) {
                        if (p.a(this.gcmSenderId, object.gcmSenderId)) {
                            if (p.a(this.storageBucket, object.storageBucket) != null) {
                                if (p.a(this.projectId, object.projectId)) {
                                    i = 1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return i;
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public String getDatabaseUrl() {
        return this.databaseUrl;
    }

    public String getGaTrackingId() {
        return this.gaTrackingId;
    }

    public String getGcmSenderId() {
        return this.gcmSenderId;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public String getStorageBucket() {
        return this.storageBucket;
    }

    public int hashCode() {
        Object[] arr = new Object[7];
        return p.b(this.applicationId, this.apiKey, this.databaseUrl, this.gaTrackingId, this.gcmSenderId, this.storageBucket, this.projectId);
    }

    public String toString() {
        p.a aVar = p.c(this);
        aVar.a("applicationId", this.applicationId);
        aVar.a("apiKey", this.apiKey);
        aVar.a("databaseUrl", this.databaseUrl);
        aVar.a("gcmSenderId", this.gcmSenderId);
        aVar.a("storageBucket", this.storageBucket);
        aVar.a("projectId", this.projectId);
        return aVar.toString();
    }
}
