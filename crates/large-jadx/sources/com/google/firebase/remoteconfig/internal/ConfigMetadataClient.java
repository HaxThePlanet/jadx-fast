package com.google.firebase.remoteconfig.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings.Builder;
import java.util.Date;

/* loaded from: classes2.dex */
public class ConfigMetadataClient {

    private static final String BACKOFF_END_TIME_IN_MILLIS_KEY = "backoff_end_time_in_millis";
    private static final String FETCH_TIMEOUT_IN_SECONDS_KEY = "fetch_timeout_in_seconds";
    private static final String LAST_FETCH_ETAG_KEY = "last_fetch_etag";
    private static final String LAST_FETCH_STATUS_KEY = "last_fetch_status";
    public static final long LAST_FETCH_TIME_IN_MILLIS_NO_FETCH_YET = -1L;
    static final Date LAST_FETCH_TIME_NO_FETCH_YET = null;
    private static final String LAST_SUCCESSFUL_FETCH_TIME_IN_MILLIS_KEY = "last_fetch_time_in_millis";
    private static final String MINIMUM_FETCH_INTERVAL_IN_SECONDS_KEY = "minimum_fetch_interval_in_seconds";
    static final Date NO_BACKOFF_TIME = null;
    private static final long NO_BACKOFF_TIME_IN_MILLIS = -1L;
    static final int NO_FAILED_FETCHES = 0;
    private static final String NUM_FAILED_FETCHES_KEY = "num_failed_fetches";
    private final Object backoffMetadataLock;
    private final Object frcInfoLock;
    private final SharedPreferences frcMetadata;

    static class BackoffMetadata {

        private Date backoffEndTime;
        private int numFailedFetches;
        BackoffMetadata(int i, Date date2) {
            super();
            this.numFailedFetches = i;
            this.backoffEndTime = date2;
        }

        Date getBackoffEndTime() {
            return this.backoffEndTime;
        }

        int getNumFailedFetches() {
            return this.numFailedFetches;
        }
    }
    static {
        final int i = -1;
        Date date = new Date(i, obj2);
        ConfigMetadataClient.LAST_FETCH_TIME_NO_FETCH_YET = date;
        Date date2 = new Date(i, obj2);
        ConfigMetadataClient.NO_BACKOFF_TIME = date2;
    }

    public ConfigMetadataClient(SharedPreferences sharedPreferences) {
        super();
        this.frcMetadata = sharedPreferences;
        Object obj1 = new Object();
        this.frcInfoLock = obj1;
        obj1 = new Object();
        this.backoffMetadataLock = obj1;
    }

    public void clear() {
        final Object frcInfoLock = this.frcInfoLock;
        this.frcMetadata.edit().clear().commit();
        return;
        synchronized (frcInfoLock) {
            frcInfoLock = this.frcInfoLock;
            this.frcMetadata.edit().clear().commit();
        }
    }

    com.google.firebase.remoteconfig.internal.ConfigMetadataClient.BackoffMetadata getBackoffMetadata() {
        final Object backoffMetadataLock = this.backoffMetadataLock;
        final String str2 = "backoff_end_time_in_millis";
        Date date = new Date(this.frcMetadata.getLong(str2, -1), str2);
        ConfigMetadataClient.BackoffMetadata backoffMetadata = new ConfigMetadataClient.BackoffMetadata(this.frcMetadata.getInt("num_failed_fetches", 0), date);
        return backoffMetadata;
        synchronized (backoffMetadataLock) {
            backoffMetadataLock = this.backoffMetadataLock;
            str2 = "backoff_end_time_in_millis";
            date = new Date(this.frcMetadata.getLong(str2, -1), str2);
            backoffMetadata = new ConfigMetadataClient.BackoffMetadata(this.frcMetadata.getInt("num_failed_fetches", 0), date);
            return backoffMetadata;
        }
    }

    public long getFetchTimeoutInSeconds() {
        return this.frcMetadata.getLong("fetch_timeout_in_seconds", 60);
    }

    public FirebaseRemoteConfigInfo getInfo() {
        final Object frcInfoLock = this.frcInfoLock;
        final String str = "last_fetch_time_in_millis";
        FirebaseRemoteConfigSettings.Builder builder = new FirebaseRemoteConfigSettings.Builder();
        String str3 = "fetch_timeout_in_seconds";
        String str4 = "minimum_fetch_interval_in_seconds";
        return FirebaseRemoteConfigInfoImpl.newBuilder().withLastFetchStatus(this.frcMetadata.getInt("last_fetch_status", 0)).withLastSuccessfulFetchTimeInMillis(this.frcMetadata.getLong(str, -1)).withConfigSettings(builder.setFetchTimeoutInSeconds(this.frcMetadata.getLong(str3, 60)).setMinimumFetchIntervalInSeconds(this.frcMetadata.getLong(str4, ConfigFetchHandler.DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS)).build()).build();
        synchronized (frcInfoLock) {
            frcInfoLock = this.frcInfoLock;
            str = "last_fetch_time_in_millis";
            builder = new FirebaseRemoteConfigSettings.Builder();
            str3 = "fetch_timeout_in_seconds";
            str4 = "minimum_fetch_interval_in_seconds";
            return FirebaseRemoteConfigInfoImpl.newBuilder().withLastFetchStatus(this.frcMetadata.getInt("last_fetch_status", 0)).withLastSuccessfulFetchTimeInMillis(this.frcMetadata.getLong(str, -1)).withConfigSettings(builder.setFetchTimeoutInSeconds(this.frcMetadata.getLong(str3, 60)).setMinimumFetchIntervalInSeconds(this.frcMetadata.getLong(str4, ConfigFetchHandler.DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS)).build()).build();
        }
    }

    String getLastFetchETag() {
        return this.frcMetadata.getString("last_fetch_etag", 0);
    }

    int getLastFetchStatus() {
        return this.frcMetadata.getInt("last_fetch_status", 0);
    }

    Date getLastSuccessfulFetchTime() {
        final String str = "last_fetch_time_in_millis";
        Date date = new Date(this.frcMetadata.getLong(str, -1), str);
        return date;
    }

    public long getMinimumFetchIntervalInSeconds() {
        return this.frcMetadata.getLong("minimum_fetch_interval_in_seconds", ConfigFetchHandler.DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS);
    }

    void resetBackoff() {
        setBackoffMetadata(0, ConfigMetadataClient.NO_BACKOFF_TIME);
    }

    void setBackoffMetadata(int i, Date date2) {
        final Object backoffMetadataLock = this.backoffMetadataLock;
        this.frcMetadata.edit().putInt("num_failed_fetches", i).putLong("backoff_end_time_in_millis", date2.getTime()).apply();
        return;
        synchronized (backoffMetadataLock) {
            backoffMetadataLock = this.backoffMetadataLock;
            this.frcMetadata.edit().putInt("num_failed_fetches", i).putLong("backoff_end_time_in_millis", date2.getTime()).apply();
        }
    }

    public void setConfigSettings(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        final Object frcInfoLock = this.frcInfoLock;
        this.frcMetadata.edit().putLong("fetch_timeout_in_seconds", firebaseRemoteConfigSettings.getFetchTimeoutInSeconds()).putLong("minimum_fetch_interval_in_seconds", firebaseRemoteConfigSettings.getMinimumFetchIntervalInSeconds()).commit();
        return;
        synchronized (frcInfoLock) {
            frcInfoLock = this.frcInfoLock;
            this.frcMetadata.edit().putLong("fetch_timeout_in_seconds", firebaseRemoteConfigSettings.getFetchTimeoutInSeconds()).putLong("minimum_fetch_interval_in_seconds", firebaseRemoteConfigSettings.getMinimumFetchIntervalInSeconds()).commit();
        }
    }

    public void setConfigSettingsWithoutWaitingOnDiskWrite(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        final Object frcInfoLock = this.frcInfoLock;
        this.frcMetadata.edit().putLong("fetch_timeout_in_seconds", firebaseRemoteConfigSettings.getFetchTimeoutInSeconds()).putLong("minimum_fetch_interval_in_seconds", firebaseRemoteConfigSettings.getMinimumFetchIntervalInSeconds()).apply();
        return;
        synchronized (frcInfoLock) {
            frcInfoLock = this.frcInfoLock;
            this.frcMetadata.edit().putLong("fetch_timeout_in_seconds", firebaseRemoteConfigSettings.getFetchTimeoutInSeconds()).putLong("minimum_fetch_interval_in_seconds", firebaseRemoteConfigSettings.getMinimumFetchIntervalInSeconds()).apply();
        }
    }

    void setLastFetchETag(String string) {
        final Object frcInfoLock = this.frcInfoLock;
        this.frcMetadata.edit().putString("last_fetch_etag", string).apply();
        return;
        synchronized (frcInfoLock) {
            frcInfoLock = this.frcInfoLock;
            this.frcMetadata.edit().putString("last_fetch_etag", string).apply();
        }
    }

    void updateLastFetchAsFailed() {
        final Object frcInfoLock = this.frcInfoLock;
        this.frcMetadata.edit().putInt("last_fetch_status", 1).apply();
        return;
        synchronized (frcInfoLock) {
            frcInfoLock = this.frcInfoLock;
            this.frcMetadata.edit().putInt("last_fetch_status", 1).apply();
        }
    }

    void updateLastFetchAsSuccessfulAt(Date date) {
        final Object frcInfoLock = this.frcInfoLock;
        this.frcMetadata.edit().putInt("last_fetch_status", -1).putLong("last_fetch_time_in_millis", date.getTime()).apply();
        return;
        synchronized (frcInfoLock) {
            frcInfoLock = this.frcInfoLock;
            this.frcMetadata.edit().putInt("last_fetch_status", -1).putLong("last_fetch_time_in_millis", date.getTime()).apply();
        }
    }

    void updateLastFetchAsThrottled() {
        final Object frcInfoLock = this.frcInfoLock;
        this.frcMetadata.edit().putInt("last_fetch_status", 2).apply();
        return;
        synchronized (frcInfoLock) {
            frcInfoLock = this.frcInfoLock;
            this.frcMetadata.edit().putInt("last_fetch_status", 2).apply();
        }
    }
}
