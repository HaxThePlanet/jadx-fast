package com.google.firebase.perf;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.logging.ConsoleUrlGenerator;
import com.google.firebase.perf.metrics.HttpMetric;
import com.google.firebase.perf.metrics.Trace;
import com.google.firebase.perf.metrics.validator.PerfMetricValidator;
import com.google.firebase.perf.session.gauges.GaugeManager;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.ImmutableBundle;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import f.c.a.b.g;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URL;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class FirebasePerformance implements com.google.firebase.perf.FirebasePerformanceAttributable {

    private static final int MAX_ATTRIBUTE_KEY_LENGTH = 40;
    private static final int MAX_ATTRIBUTE_VALUE_LENGTH = 100;
    private static final int MAX_TRACE_CUSTOM_ATTRIBUTES = 5;
    public static final int MAX_TRACE_NAME_LENGTH = 100;
    private static final AndroidLogger logger;
    private final ConfigResolver configResolver;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallationsApi;
    private final Provider<RemoteConfigComponent> firebaseRemoteConfigProvider;
    private final Map<String, String> mCustomAttributes;
    private final ImmutableBundle mMetadataBundle;
    private Boolean mPerformanceCollectionForceEnabledState = null;
    private final Provider<g> transportFactoryProvider;

    @Retention(RetentionPolicy.SOURCE)
    public @interface HttpMethod {

        public static final String CONNECT = "CONNECT";
        public static final String DELETE = "DELETE";
        public static final String GET = "GET";
        public static final String HEAD = "HEAD";
        public static final String OPTIONS = "OPTIONS";
        public static final String PATCH = "PATCH";
        public static final String POST = "POST";
        public static final String PUT = "PUT";
        public static final String TRACE = "TRACE";
    }
    static {
        FirebasePerformance.logger = AndroidLogger.getInstance();
    }

    FirebasePerformance(FirebaseApp firebaseApp, Provider<RemoteConfigComponent> provider2, FirebaseInstallationsApi firebaseInstallationsApi3, Provider<g> provider4, RemoteConfigManager remoteConfigManager5, ConfigResolver configResolver6, GaugeManager gaugeManager7) {
        Object obj2;
        boolean obj3;
        Object obj4;
        ImmutableBundle obj5;
        int obj6;
        super();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.mCustomAttributes = concurrentHashMap;
        int i = 0;
        this.firebaseApp = firebaseApp;
        this.firebaseRemoteConfigProvider = provider2;
        this.firebaseInstallationsApi = firebaseInstallationsApi3;
        this.transportFactoryProvider = provider4;
        if (firebaseApp == null) {
            this.mPerformanceCollectionForceEnabledState = Boolean.FALSE;
            this.configResolver = configResolver6;
            obj3 = new Bundle();
            obj2 = new ImmutableBundle(obj3);
            this.mMetadataBundle = obj2;
        }
        TransportManager.getInstance().initialize(firebaseApp, firebaseInstallationsApi3, provider4);
        obj4 = firebaseApp.getApplicationContext();
        obj5 = FirebasePerformance.extractMetadata(obj4);
        this.mMetadataBundle = obj5;
        remoteConfigManager5.setFirebaseRemoteConfigProvider(provider2);
        this.configResolver = configResolver6;
        configResolver6.setMetadataBundle(obj5);
        configResolver6.setApplicationContext(obj4);
        gaugeManager7.setApplicationContext(obj4);
        this.mPerformanceCollectionForceEnabledState = configResolver6.getIsPerformanceCollectionEnabled();
        if (isPerformanceCollectionEnabled()) {
            obj5 = new Object[1];
            FirebasePerformance.logger.info(String.format("Firebase Performance Monitoring is successfully initialized! In a minute, visit the Firebase console to view your data: %s", ConsoleUrlGenerator.generateDashboardUrl(firebaseApp.getOptions().getProjectId(), obj4.getPackageName())));
        }
    }

    private void checkAttribute(String string, String string2) {
        boolean size;
        int i;
        if (string == null) {
        } else {
            if (string2 == null) {
            } else {
                if (!this.mCustomAttributes.containsKey(string)) {
                    i = 5;
                    if (this.mCustomAttributes.size() >= i) {
                    } else {
                    }
                    Object[] arr = new Object[1];
                    IllegalArgumentException obj4 = new IllegalArgumentException(String.format(Locale.US, "Exceeds max limit of number of attributes - %d", Integer.valueOf(i)));
                    throw obj4;
                }
                AbstractMap.SimpleEntry simpleEntry = new AbstractMap.SimpleEntry(string, string2);
                obj4 = PerfMetricValidator.validateAttribute(simpleEntry);
                if (obj4 != null) {
                } else {
                }
                IllegalArgumentException obj5 = new IllegalArgumentException(obj4);
                throw obj5;
            }
        }
        obj4 = new IllegalArgumentException("Attribute must not have null key or value.");
        throw obj4;
    }

    private static ImmutableBundle extractMetadata(Context context) {
        PackageManager packageManager;
        int i;
        Bundle obj2;
        try {
            obj2 = obj2.metaData;
            StringBuilder str = new StringBuilder();
            str.append("No perf enable meta data found ");
            context = context.getMessage();
            str.append(context);
            context = str.toString();
            str = "isEnabled";
            Log.d(str, context);
            context = null;
            if (obj2 != null) {
            } else {
            }
            ImmutableBundle immutableBundle = new ImmutableBundle(obj2);
            super();
            return immutableBundle;
        }
    }

    public static com.google.firebase.perf.FirebasePerformance getInstance() {
        return (FirebasePerformance)FirebaseApp.getInstance().get(FirebasePerformance.class);
    }

    public static Trace startTrace(String string) {
        final Trace obj0 = Trace.create(string);
        obj0.start();
        return obj0;
    }

    @Override // com.google.firebase.perf.FirebasePerformanceAttributable
    public String getAttribute(String string) {
        return (String)this.mCustomAttributes.get(string);
    }

    public Map<String, String> getAttributes() {
        HashMap hashMap = new HashMap(this.mCustomAttributes);
        return hashMap;
    }

    @Override // com.google.firebase.perf.FirebasePerformanceAttributable
    Boolean getPerformanceCollectionForceEnabledState() {
        return this.mPerformanceCollectionForceEnabledState;
    }

    @Override // com.google.firebase.perf.FirebasePerformanceAttributable
    public boolean isPerformanceCollectionEnabled() {
        boolean dataCollectionDefaultEnabled;
        Boolean mPerformanceCollectionForceEnabledState = this.mPerformanceCollectionForceEnabledState;
        if (mPerformanceCollectionForceEnabledState != null) {
            dataCollectionDefaultEnabled = mPerformanceCollectionForceEnabledState.booleanValue();
        } else {
            dataCollectionDefaultEnabled = FirebaseApp.getInstance().isDataCollectionDefaultEnabled();
        }
        return dataCollectionDefaultEnabled;
    }

    @Override // com.google.firebase.perf.FirebasePerformanceAttributable
    public HttpMetric newHttpMetric(String string, String string2) {
        Timer timer = new Timer();
        HttpMetric httpMetric = new HttpMetric(string, string2, TransportManager.getInstance(), timer);
        return httpMetric;
    }

    @Override // com.google.firebase.perf.FirebasePerformanceAttributable
    public HttpMetric newHttpMetric(URL uRL, String string2) {
        Timer timer = new Timer();
        HttpMetric httpMetric = new HttpMetric(uRL, string2, TransportManager.getInstance(), timer);
        return httpMetric;
    }

    @Override // com.google.firebase.perf.FirebasePerformanceAttributable
    public Trace newTrace(String string) {
        return Trace.create(string);
    }

    @Override // com.google.firebase.perf.FirebasePerformanceAttributable
    public void putAttribute(String string, String string2) {
        int mCustomAttributes;
        int i;
        Throwable message;
        AndroidLogger logger;
        int arr;
        int i2 = 0;
        final String obj6 = string.trim();
        final String obj7 = string2.trim();
        checkAttribute(obj6, obj7);
        try {
            if (1 != 0) {
            }
            this.mCustomAttributes.put(obj6, obj7);
        }
    }

    @Override // com.google.firebase.perf.FirebasePerformanceAttributable
    public void removeAttribute(String string) {
        this.mCustomAttributes.remove(string);
    }

    @Override // com.google.firebase.perf.FirebasePerformanceAttributable
    public void setPerformanceCollectionEnabled(Boolean boolean) {
        Object mPerformanceCollectionForceEnabledState;
        Boolean obj2;
        FirebaseApp.getInstance();
        synchronized (this) {
            try {
                FirebasePerformance.logger.info("Firebase Performance is permanently disabled");
                this.configResolver.setIsPerformanceCollectionEnabled(boolean);
                this.mPerformanceCollectionForceEnabledState = boolean;
            } catch (Throwable th) {
            }
            try {
                this.mPerformanceCollectionForceEnabledState = this.configResolver.getIsPerformanceCollectionEnabled();
                if (Boolean.TRUE.equals(this.mPerformanceCollectionForceEnabledState)) {
                } else {
                }
                FirebasePerformance.logger.info("Firebase Performance is Enabled");
                if (Boolean.FALSE.equals(this.mPerformanceCollectionForceEnabledState)) {
                }
                FirebasePerformance.logger.info("Firebase Performance is Disabled");
                throw boolean;
            }
        }
    }

    @Override // com.google.firebase.perf.FirebasePerformanceAttributable
    public void setPerformanceCollectionEnabled(boolean z) {
        setPerformanceCollectionEnabled(Boolean.valueOf(z));
    }
}
