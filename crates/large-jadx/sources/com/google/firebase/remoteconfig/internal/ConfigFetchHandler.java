package com.google.firebase.remoteconfig.internal;

import android.text.format.DateUtils;
import com.google.android.gms.common.util.e;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.m;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigFetchThrottledException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class ConfigFetchHandler {

    static final int[] BACKOFF_TIME_DURATIONS_IN_MINUTES = null;
    public static final long DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS = 0L;
    static final int HTTP_TOO_MANY_REQUESTS = 429;
    private final Provider<AnalyticsConnector> analyticsConnector;
    private final e clock;
    private final Map<String, String> customHttpHeaders;
    private final Executor executor;
    private final com.google.firebase.remoteconfig.internal.ConfigCacheClient fetchedConfigsCache;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final com.google.firebase.remoteconfig.internal.ConfigFetchHttpClient frcBackendApiClient;
    private final com.google.firebase.remoteconfig.internal.ConfigMetadataClient frcMetadata;
    private final Random randomGenerator;

    public static class FetchResponse {

        private final Date fetchTime;
        private final com.google.firebase.remoteconfig.internal.ConfigContainer fetchedConfigs;
        private final String lastFetchETag;
        private final int status;
        private FetchResponse(Date date, int i2, com.google.firebase.remoteconfig.internal.ConfigContainer configContainer3, String string4) {
            super();
            this.fetchTime = date;
            this.status = i2;
            this.fetchedConfigs = configContainer3;
            this.lastFetchETag = string4;
        }

        public static com.google.firebase.remoteconfig.internal.ConfigFetchHandler.FetchResponse forBackendHasNoUpdates(Date date) {
            final int i2 = 0;
            ConfigFetchHandler.FetchResponse fetchResponse = new ConfigFetchHandler.FetchResponse(date, 1, i2, i2);
            return fetchResponse;
        }

        public static com.google.firebase.remoteconfig.internal.ConfigFetchHandler.FetchResponse forBackendUpdatesFetched(com.google.firebase.remoteconfig.internal.ConfigContainer configContainer, String string2) {
            ConfigFetchHandler.FetchResponse fetchResponse = new ConfigFetchHandler.FetchResponse(configContainer.getFetchTime(), 0, configContainer, string2);
            return fetchResponse;
        }

        public static com.google.firebase.remoteconfig.internal.ConfigFetchHandler.FetchResponse forLocalStorageUsed(Date date) {
            final int i2 = 0;
            ConfigFetchHandler.FetchResponse fetchResponse = new ConfigFetchHandler.FetchResponse(date, 2, i2, i2);
            return fetchResponse;
        }

        Date getFetchTime() {
            return this.fetchTime;
        }

        public com.google.firebase.remoteconfig.internal.ConfigContainer getFetchedConfigs() {
            return this.fetchedConfigs;
        }

        String getLastFetchETag() {
            return this.lastFetchETag;
        }

        int getStatus() {
            return this.status;
        }
    }
    static {
        ConfigFetchHandler.DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS = TimeUnit.HOURS.toSeconds(12);
        int[] iArr = new int[8];
        iArr = new int[]{2, 4, 8, 16, 32, 64, 128, 256};
        ConfigFetchHandler.BACKOFF_TIME_DURATIONS_IN_MINUTES = iArr;
    }

    public ConfigFetchHandler(FirebaseInstallationsApi firebaseInstallationsApi, Provider<AnalyticsConnector> provider2, Executor executor3, e e4, Random random5, com.google.firebase.remoteconfig.internal.ConfigCacheClient configCacheClient6, com.google.firebase.remoteconfig.internal.ConfigFetchHttpClient configFetchHttpClient7, com.google.firebase.remoteconfig.internal.ConfigMetadataClient configMetadataClient8, Map<String, String> map9) {
        super();
        this.firebaseInstallations = firebaseInstallationsApi;
        this.analyticsConnector = provider2;
        this.executor = executor3;
        this.clock = e4;
        this.randomGenerator = random5;
        this.fetchedConfigsCache = configCacheClient6;
        this.frcBackendApiClient = configFetchHttpClient7;
        this.frcMetadata = configMetadataClient8;
        this.customHttpHeaders = map9;
    }

    private j a(long l, j j2) {
        return fetchIfCacheExpiredAndNotThrottled(obj3, l);
    }

    private boolean areCachedFetchConfigsValid(long l, Date date2) {
        Date lastSuccessfulFetchTime = this.frcMetadata.getLastSuccessfulFetchTime();
        if (lastSuccessfulFetchTime.equals(ConfigMetadataClient.LAST_FETCH_TIME_NO_FETCH_YET)) {
            return 0;
        }
        Date date = new Date(time += obj5, obj3);
        return obj7.before(date);
    }

    static j c(com.google.firebase.remoteconfig.internal.ConfigFetchHandler.FetchResponse configFetchHandler$FetchResponse, com.google.firebase.remoteconfig.internal.ConfigContainer configContainer2) {
        return m.e(fetchResponse);
    }

    private FirebaseRemoteConfigServerException createExceptionWithGenericMessage(FirebaseRemoteConfigServerException firebaseRemoteConfigServerException) {
        String str;
        int i;
        int httpStatusCode = firebaseRemoteConfigServerException.getHttpStatusCode();
        if (httpStatusCode != 401) {
            if (httpStatusCode != 403) {
                if (httpStatusCode == 429) {
                } else {
                    if (httpStatusCode != 500) {
                        str = /* condition */ ? "The server is unavailable. Please try again later." : "The server returned an unexpected error.";
                    } else {
                        str = "There was an internal server error.";
                    }
                }
                FirebaseRemoteConfigClientException obj6 = new FirebaseRemoteConfigClientException("The throttled response from the server was not handled correctly by the FRC SDK.");
                throw obj6;
            }
            str = "The user is not authorized to access the project. Please make sure you are using the API key that corresponds to your Firebase project.";
        } else {
            str = "The request did not have the required credentials. Please make sure your google-services.json is valid.";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fetch failed: ");
        stringBuilder.append(str);
        FirebaseRemoteConfigServerException firebaseRemoteConfigServerException2 = new FirebaseRemoteConfigServerException(firebaseRemoteConfigServerException.getHttpStatusCode(), stringBuilder.toString(), firebaseRemoteConfigServerException);
        return firebaseRemoteConfigServerException2;
    }

    private String createThrottledMessage(long l) {
        Object[] arr = new Object[1];
        return String.format("Fetch is throttled. Please wait before calling fetch again: %s", DateUtils.formatElapsedTime(TimeUnit.MILLISECONDS.toSeconds(l)));
    }

    private j d(j j, j j2, Date date3, j j4) {
        if (!j.isSuccessful()) {
            FirebaseRemoteConfigClientException obj2 = new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation ID for fetch.", j.getException());
            return m.d(obj2);
        }
        if (!j2.isSuccessful()) {
            FirebaseRemoteConfigClientException obj1 = new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation auth token for fetch.", j2.getException());
            return m.d(obj1);
        }
        return fetchFromBackendAndCacheResponse((String)j.getResult(), (InstallationTokenResult)j2.getResult().getToken(), date3);
    }

    private j f(Date date, j j2) {
        updateLastFetchStatusAndTime(j2, date);
        return j2;
    }

    private com.google.firebase.remoteconfig.internal.ConfigFetchHandler.FetchResponse fetchFromBackend(String string, String string2, Date date3) {
        Object lastFetchETag;
        Object obj11;
        try {
            final com.google.firebase.remoteconfig.internal.ConfigFetchHandler.FetchResponse obj10 = this.frcBackendApiClient.fetch(this.frcBackendApiClient.createHttpURLConnection(), string, string2, getUserProperties(), this.frcMetadata.getLastFetchETag(), this.customHttpHeaders, date3);
            if (obj10.getLastFetchETag() != null) {
            }
            this.frcMetadata.setLastFetchETag(obj10.getLastFetchETag());
            this.frcMetadata.resetBackoff();
            return obj10;
            string2 = string.getHttpStatusCode();
            string2 = updateAndReturnBackoffMetadata(string2, date3);
            date3 = string.getHttpStatusCode();
            date3 = shouldThrottle(string2, date3);
            if (date3 != null) {
            }
            string2 = string2.getBackoffEndTime();
            string2 = string2.getTime();
            string = new FirebaseRemoteConfigFetchThrottledException(string2, date3);
            throw string;
            string = createExceptionWithGenericMessage(string);
            throw string;
        }
    }

    private j<com.google.firebase.remoteconfig.internal.ConfigFetchHandler.FetchResponse> fetchFromBackendAndCacheResponse(String string, String string2, Date date3) {
        try {
            com.google.firebase.remoteconfig.internal.ConfigFetchHandler.FetchResponse obj2 = fetchFromBackend(string, string2, date3);
            if (obj2.getStatus() != 0) {
            }
            return m.e(obj2);
            f fVar = new f(obj2);
            return this.fetchedConfigsCache.put(obj2.getFetchedConfigs()).onSuccessTask(this.executor, fVar);
            string = m.d(string);
            return string;
        }
    }

    private j<com.google.firebase.remoteconfig.internal.ConfigFetchHandler.FetchResponse> fetchIfCacheExpiredAndNotThrottled(j<com.google.firebase.remoteconfig.internal.ConfigContainer> j, long l2) {
        Executor executor;
        com.google.firebase.remoteconfig.internal.c cVar;
        long time;
        boolean obj6;
        Object obj7;
        Object obj8;
        Date date = new Date(this.clock.currentTimeMillis(), obj2);
        if (j.isSuccessful() && areCachedFetchConfigsValid(l2, obj8)) {
            if (areCachedFetchConfigsValid(l2, obj8)) {
                return m.e(ConfigFetchHandler.FetchResponse.forLocalStorageUsed(date));
            }
        }
        obj6 = getBackoffEndTimeInMillis(date);
        if (obj6 != null) {
            obj7 = new FirebaseRemoteConfigFetchThrottledException(createThrottledMessage(time2 -= time), obj6.getTime(), obj2);
            obj6 = m.d(obj7);
        } else {
            obj6 = this.firebaseInstallations.getId();
            obj8 = 0;
            obj7 = this.firebaseInstallations.getToken(obj8);
            j[] arr = new j[2];
            arr[obj8] = obj6;
            arr[1] = obj7;
            cVar = new c(this, obj6, obj7, date);
            obj6 = m.i(arr).continueWithTask(this.executor, cVar);
        }
        obj8 = new e(this, date);
        return obj6.continueWithTask(this.executor, obj8);
    }

    private Date getBackoffEndTimeInMillis(Date date) {
        Date backoffEndTime = this.frcMetadata.getBackoffMetadata().getBackoffEndTime();
        if (date.before(backoffEndTime)) {
            return backoffEndTime;
        }
        return null;
    }

    private long getRandomizedBackoffDurationInMillis(int i) {
        int[] bACKOFF_TIME_DURATIONS_IN_MINUTES = ConfigFetchHandler.BACKOFF_TIME_DURATIONS_IN_MINUTES;
        int length = bACKOFF_TIME_DURATIONS_IN_MINUTES.length;
        long millis = TimeUnit.MINUTES.toMillis((long)obj5);
        return i4 += l;
    }

    private Map<String, String> getUserProperties() {
        int string;
        Object key;
        HashMap hashMap = new HashMap();
        Object obj = this.analyticsConnector.get();
        if ((AnalyticsConnector)obj == null) {
            return hashMap;
        }
        Iterator iterator = (AnalyticsConnector)obj.getUserProperties(false).entrySet().iterator();
        for (Map.Entry next2 : iterator) {
            hashMap.put((String)next2.getKey(), next2.getValue().toString());
        }
        return hashMap;
    }

    private boolean isThrottleableServerError(int i) {
        int i2;
        int obj2;
        if (i != 429 && i != 502 && i != 503) {
            if (i != 502) {
                if (i != 503) {
                    if (i == 504) {
                        obj2 = 1;
                    } else {
                        obj2 = 0;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj2;
    }

    private boolean shouldThrottle(com.google.firebase.remoteconfig.internal.ConfigMetadataClient.BackoffMetadata configMetadataClient$BackoffMetadata, int i2) {
        int i;
        int obj2;
        if (backoffMetadata.getNumFailedFetches() <= 1) {
            if (i2 == 429) {
            } else {
                i = 0;
            }
        }
        return i;
    }

    private com.google.firebase.remoteconfig.internal.ConfigMetadataClient.BackoffMetadata updateAndReturnBackoffMetadata(int i, Date date2) {
        if (isThrottleableServerError(i)) {
            updateBackoffMetadataWithLastFailedFetchTime(date2);
        }
        return this.frcMetadata.getBackoffMetadata();
    }

    private void updateBackoffMetadataWithLastFailedFetchTime(Date date) {
        numFailedFetches++;
        Date date2 = new Date(time += randomizedBackoffDurationInMillis, obj5);
        this.frcMetadata.setBackoffMetadata(i, date2);
    }

    private void updateLastFetchStatusAndTime(j<com.google.firebase.remoteconfig.internal.ConfigFetchHandler.FetchResponse> j, Date date2) {
        com.google.firebase.remoteconfig.internal.ConfigMetadataClient obj2;
        if (j.isSuccessful()) {
            this.frcMetadata.updateLastFetchAsSuccessfulAt(date2);
        }
        obj2 = j.getException();
        if (obj2 == null) {
        }
        if (obj2 instanceof FirebaseRemoteConfigFetchThrottledException != null) {
            this.frcMetadata.updateLastFetchAsThrottled();
        } else {
            this.frcMetadata.updateLastFetchAsFailed();
        }
    }

    public j b(long l, j j2) {
        return a(l, j2);
    }

    public j e(j j, j j2, Date date3, j j4) {
        return d(j, j2, date3, j4);
    }

    public j<com.google.firebase.remoteconfig.internal.ConfigFetchHandler.FetchResponse> fetch() {
        return fetch(this.frcMetadata.getMinimumFetchIntervalInSeconds());
    }

    public j<com.google.firebase.remoteconfig.internal.ConfigFetchHandler.FetchResponse> fetch(long l) {
        d dVar = new d(this, l, obj5);
        return this.fetchedConfigsCache.get().continueWithTask(this.executor, dVar);
    }

    public j g(Date date, j j2) {
        f(date, j2);
        return j2;
    }

    public Provider<AnalyticsConnector> getAnalyticsConnector() {
        return this.analyticsConnector;
    }
}
