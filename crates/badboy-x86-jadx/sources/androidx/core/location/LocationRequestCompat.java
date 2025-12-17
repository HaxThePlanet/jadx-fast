package androidx.core.location;

import android.location.LocationRequest;
import android.location.LocationRequest.Builder;
import android.os.Build.VERSION;
import androidx.core.util.Preconditions;
import androidx.core.util.TimeUtils;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public final class LocationRequestCompat {

    private static final long IMPLICIT_MIN_UPDATE_INTERVAL = -1L;
    public static final long PASSIVE_INTERVAL = Long.MAX_VALUE;
    public static final int QUALITY_BALANCED_POWER_ACCURACY = 102;
    public static final int QUALITY_HIGH_ACCURACY = 100;
    public static final int QUALITY_LOW_POWER = 104;
    final long mDurationMillis;
    final long mIntervalMillis;
    final long mMaxUpdateDelayMillis;
    final int mMaxUpdates;
    final float mMinUpdateDistanceMeters;
    final long mMinUpdateIntervalMillis;
    final int mQuality;

    private static class Api19Impl {

        private static Method sCreateFromDeprecatedProviderMethod;
        private static Class<?> sLocationRequestClass;
        private static Method sSetExpireInMethod;
        private static Method sSetFastestIntervalMethod;
        private static Method sSetNumUpdatesMethod;
        private static Method sSetQualityMethod;
        public static Object toLocationRequest(androidx.core.location.LocationRequestCompat obj, String provider) {
            Class sLocationRequestClass;
            Method sCreateFromDeprecatedProviderMethod;
            int sSetExpireInMethod;
            int arr2;
            String str;
            Method sSetQualityMethod;
            Method sSetFastestIntervalMethod;
            Method sSetNumUpdatesMethod;
            int sSetNumUpdatesMethod2;
            Object sLocationRequestClass2;
            Class[] arr4;
            Object valueOf;
            Object[] arr;
            int str2;
            Class tYPE;
            Boolean valueOf2;
            long arr3;
            int tYPE2;
            final int i = 0;
            if (LocationRequestCompat.Api19Impl.sLocationRequestClass == null) {
                try {
                    LocationRequestCompat.Api19Impl.sLocationRequestClass = Class.forName("android.location.LocationRequest");
                    sSetExpireInMethod = 0;
                    arr2 = 1;
                    if (LocationRequestCompat.Api19Impl.sCreateFromDeprecatedProviderMethod == null) {
                    }
                    arr4 = new Class[4];
                    arr4[sSetExpireInMethod] = String.class;
                    arr4[arr2] = Long.TYPE;
                    arr4[2] = Float.TYPE;
                    arr4[3] = Boolean.TYPE;
                    LocationRequestCompat.Api19Impl.sCreateFromDeprecatedProviderMethod = LocationRequestCompat.Api19Impl.sLocationRequestClass.getDeclaredMethod("createFromDeprecatedProvider", arr4);
                    LocationRequestCompat.Api19Impl.sCreateFromDeprecatedProviderMethod.setAccessible(arr2);
                    Object invoke = LocationRequestCompat.Api19Impl.sCreateFromDeprecatedProviderMethod.invoke(i, /* result */);
                    if (invoke == null) {
                    }
                    return i;
                    if (LocationRequestCompat.Api19Impl.sSetQualityMethod == null) {
                    }
                    valueOf2 = new Class[arr2];
                    valueOf2[sSetExpireInMethod] = Integer.TYPE;
                    LocationRequestCompat.Api19Impl.sSetQualityMethod = LocationRequestCompat.Api19Impl.sLocationRequestClass.getDeclaredMethod("setQuality", valueOf2);
                    LocationRequestCompat.Api19Impl.sSetQualityMethod.setAccessible(arr2);
                    LocationRequestCompat.Api19Impl.sSetQualityMethod.invoke(invoke, /* result */);
                    if (LocationRequestCompat.Api19Impl.sSetFastestIntervalMethod == null) {
                    }
                    valueOf2 = new Class[arr2];
                    valueOf2[sSetExpireInMethod] = Long.TYPE;
                    LocationRequestCompat.Api19Impl.sSetFastestIntervalMethod = LocationRequestCompat.Api19Impl.sLocationRequestClass.getDeclaredMethod("setFastestInterval", valueOf2);
                    LocationRequestCompat.Api19Impl.sSetFastestIntervalMethod.setAccessible(arr2);
                    LocationRequestCompat.Api19Impl.sSetFastestIntervalMethod.invoke(invoke, /* result */);
                    if (obj.getMaxUpdates() < Integer.MAX_VALUE && LocationRequestCompat.Api19Impl.sSetNumUpdatesMethod == null) {
                    }
                    if (LocationRequestCompat.Api19Impl.sSetNumUpdatesMethod == null) {
                    }
                    valueOf2 = new Class[arr2];
                    valueOf2[sSetExpireInMethod] = Integer.TYPE;
                    LocationRequestCompat.Api19Impl.sSetNumUpdatesMethod = LocationRequestCompat.Api19Impl.sLocationRequestClass.getDeclaredMethod("setNumUpdates", valueOf2);
                    LocationRequestCompat.Api19Impl.sSetNumUpdatesMethod.setAccessible(arr2);
                    LocationRequestCompat.Api19Impl.sSetNumUpdatesMethod.invoke(invoke, /* result */);
                    if (Long.compare(durationMillis2, arr3) < 0 && LocationRequestCompat.Api19Impl.sSetExpireInMethod == null) {
                    }
                    if (LocationRequestCompat.Api19Impl.sSetExpireInMethod == null) {
                    }
                    arr3 = new Class[arr2];
                    arr3[sSetExpireInMethod] = Long.TYPE;
                    LocationRequestCompat.Api19Impl.sSetExpireInMethod = LocationRequestCompat.Api19Impl.sLocationRequestClass.getDeclaredMethod("setExpireIn", arr3);
                    LocationRequestCompat.Api19Impl.sSetExpireInMethod.setAccessible(arr2);
                    LocationRequestCompat.Api19Impl.sSetExpireInMethod.invoke(invoke, /* result */);
                    return invoke;
                    return obj0;
                }
            }
        }
    }

    private static class Api31Impl {
        public static LocationRequest toLocationRequest(androidx.core.location.LocationRequestCompat obj) {
            LocationRequest.Builder builder = new LocationRequest.Builder(obj.getIntervalMillis(), obj2);
            return builder.setQuality(obj.getQuality()).setMinUpdateIntervalMillis(obj.getMinUpdateIntervalMillis()).setDurationMillis(obj.getDurationMillis()).setMaxUpdates(obj.getMaxUpdates()).setMinUpdateDistanceMeters(obj.getMinUpdateDistanceMeters()).setMaxUpdateDelayMillis(obj.getMaxUpdateDelayMillis()).build();
        }
    }

    public static final class Builder {

        private long mDurationMillis;
        private long mIntervalMillis;
        private long mMaxUpdateDelayMillis;
        private int mMaxUpdates;
        private float mMinUpdateDistanceMeters;
        private long mMinUpdateIntervalMillis;
        private int mQuality;
        public Builder(long intervalMillis) {
            super();
            setIntervalMillis(intervalMillis);
            this.mQuality = 102;
            this.mDurationMillis = Long.MAX_VALUE;
            this.mMaxUpdates = Integer.MAX_VALUE;
            this.mMinUpdateIntervalMillis = -1;
            this.mMinUpdateDistanceMeters = 0;
            this.mMaxUpdateDelayMillis = 0;
        }

        public Builder(androidx.core.location.LocationRequestCompat locationRequest) {
            super();
            this.mIntervalMillis = locationRequest.mIntervalMillis;
            this.mQuality = locationRequest.mQuality;
            this.mDurationMillis = locationRequest.mDurationMillis;
            this.mMaxUpdates = locationRequest.mMaxUpdates;
            this.mMinUpdateIntervalMillis = locationRequest.mMinUpdateIntervalMillis;
            this.mMinUpdateDistanceMeters = locationRequest.mMinUpdateDistanceMeters;
            this.mMaxUpdateDelayMillis = locationRequest.mMaxUpdateDelayMillis;
        }

        public androidx.core.location.LocationRequestCompat build() {
            int i;
            int cmp;
            int l;
            if (Long.compare(mIntervalMillis, l) == 0) {
                if (Long.compare(mMinUpdateIntervalMillis, l) != 0) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
            final String str = "passive location requests must have an explicit minimum update interval";
            Preconditions.checkState(i, str);
            LocationRequestCompat locationRequestCompat = new LocationRequestCompat(this.mIntervalMillis, obj4, this.mQuality, this.mDurationMillis, obj7, this.mMaxUpdates, Math.min(this.mMinUpdateIntervalMillis, str), obj10, this.mMinUpdateDistanceMeters, this.mMaxUpdateDelayMillis, obj13);
            return locationRequestCompat;
        }

        public androidx.core.location.LocationRequestCompat.Builder clearMinUpdateIntervalMillis() {
            this.mMinUpdateIntervalMillis = -1;
            return this;
        }

        public androidx.core.location.LocationRequestCompat.Builder setDurationMillis(long durationMillis) {
            this.mDurationMillis = Preconditions.checkArgumentInRange(durationMillis, obj1, 1, obj3);
            return this;
        }

        public androidx.core.location.LocationRequestCompat.Builder setIntervalMillis(long intervalMillis) {
            this.mIntervalMillis = Preconditions.checkArgumentInRange(intervalMillis, obj1, 0, obj3);
            return this;
        }

        public androidx.core.location.LocationRequestCompat.Builder setMaxUpdateDelayMillis(long maxUpdateDelayMillis) {
            this.mMaxUpdateDelayMillis = maxUpdateDelayMillis;
            this.mMaxUpdateDelayMillis = Preconditions.checkArgumentInRange(maxUpdateDelayMillis, obj1, 0, obj3);
            return this;
        }

        public androidx.core.location.LocationRequestCompat.Builder setMaxUpdates(int maxUpdates) {
            this.mMaxUpdates = Preconditions.checkArgumentInRange(maxUpdates, 1, Integer.MAX_VALUE, "maxUpdates");
            return this;
        }

        public androidx.core.location.LocationRequestCompat.Builder setMinUpdateDistanceMeters(float minUpdateDistanceMeters) {
            this.mMinUpdateDistanceMeters = minUpdateDistanceMeters;
            this.mMinUpdateDistanceMeters = Preconditions.checkArgumentInRange(minUpdateDistanceMeters, 0, 2139095039, "minUpdateDistanceMeters");
            return this;
        }

        public androidx.core.location.LocationRequestCompat.Builder setMinUpdateIntervalMillis(long minUpdateIntervalMillis) {
            this.mMinUpdateIntervalMillis = Preconditions.checkArgumentInRange(minUpdateIntervalMillis, obj1, 0, obj3);
            return this;
        }

        public androidx.core.location.LocationRequestCompat.Builder setQuality(int quality) {
            int i;
            int i2;
            if (quality != 104 && quality != 102) {
                if (quality != 102) {
                    if (quality == 100) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                } else {
                }
            } else {
            }
            Preconditions.checkArgument(i2, "quality must be a defined QUALITY constant, not %d", /* result */);
            this.mQuality = quality;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Quality {
    }
    LocationRequestCompat(long intervalMillis, int quality, long durationMillis, int maxUpdates, long minUpdateIntervalMillis, float minUpdateDistanceMeters, long maxUpdateDelayMillis) {
        super();
        this.mIntervalMillis = intervalMillis;
        this.mQuality = durationMillis;
        this.mMinUpdateIntervalMillis = maxUpdateDelayMillis;
        this.mDurationMillis = maxUpdates;
        this.mMaxUpdates = minUpdateDistanceMeters;
        this.mMinUpdateDistanceMeters = obj9;
        this.mMaxUpdateDelayMillis = obj10;
    }

    public boolean equals(Object o) {
        int i;
        int mMaxUpdates;
        float mMinUpdateDistanceMeters;
        long mMinUpdateIntervalMillis;
        if (this == o) {
            return 1;
        }
        final int i2 = 0;
        if (!o instanceof LocationRequestCompat) {
            return i2;
        }
        Object obj = o;
        if (this.mQuality == obj.mQuality && Long.compare(mIntervalMillis, mMinUpdateIntervalMillis) == 0 && Long.compare(mMinUpdateIntervalMillis2, mMinUpdateIntervalMillis) == 0 && Long.compare(mDurationMillis, mMinUpdateIntervalMillis) == 0 && this.mMaxUpdates == obj.mMaxUpdates && Float.compare(obj.mMinUpdateDistanceMeters, this.mMinUpdateDistanceMeters) == 0 && Long.compare(mMaxUpdateDelayMillis, mMinUpdateIntervalMillis) == 0) {
            if (Long.compare(mIntervalMillis, mMinUpdateIntervalMillis) == 0) {
                if (Long.compare(mMinUpdateIntervalMillis2, mMinUpdateIntervalMillis) == 0) {
                    if (Long.compare(mDurationMillis, mMinUpdateIntervalMillis) == 0) {
                        if (this.mMaxUpdates == obj.mMaxUpdates) {
                            if (Float.compare(obj.mMinUpdateDistanceMeters, this.mMinUpdateDistanceMeters) == 0) {
                                if (Long.compare(mMaxUpdateDelayMillis, mMinUpdateIntervalMillis) == 0) {
                                } else {
                                    i = i2;
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public long getDurationMillis() {
        return this.mDurationMillis;
    }

    public long getIntervalMillis() {
        return this.mIntervalMillis;
    }

    public long getMaxUpdateDelayMillis() {
        return this.mMaxUpdateDelayMillis;
    }

    public int getMaxUpdates() {
        return this.mMaxUpdates;
    }

    public float getMinUpdateDistanceMeters() {
        return this.mMinUpdateDistanceMeters;
    }

    public long getMinUpdateIntervalMillis() {
        if (Long.compare(mMinUpdateIntervalMillis, i) == 0) {
            return this.mIntervalMillis;
        }
        return this.mMinUpdateIntervalMillis;
    }

    public int getQuality() {
        return this.mQuality;
    }

    public int hashCode() {
        final int i10 = 32;
        return result += i7;
    }

    public LocationRequest toLocationRequest() {
        return LocationRequestCompat.Api31Impl.toLocationRequest(this);
    }

    public LocationRequest toLocationRequest(String provider) {
        if (Build.VERSION.SDK_INT >= 31) {
            return toLocationRequest();
        }
        return (LocationRequest)LocationRequestCompat.Api19Impl.toLocationRequest(this, provider);
    }

    public String toString() {
        String mQuality;
        int mDurationMillis;
        int mMaxUpdates;
        int mMinUpdateIntervalMillis;
        int append;
        int mMaxUpdateDelayMillis;
        int mMinUpdateDistanceMeters;
        int mIntervalMillis;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Request[");
        long l = Long.MAX_VALUE;
        if (Long.compare(mIntervalMillis2, l) != 0) {
            stringBuilder.append("@");
            TimeUtils.formatDuration(this.mIntervalMillis, obj2);
            switch (mQuality) {
                case 100:
                    stringBuilder.append(" HIGH_ACCURACY");
                    break;
                case 101:
                    break;
                case 102:
                    stringBuilder.append(" BALANCED");
                    break;
                default:
                    stringBuilder.append(" LOW_POWER");
            }
        } else {
            stringBuilder.append("PASSIVE");
        }
        if (Long.compare(mDurationMillis2, l) != 0) {
            stringBuilder.append(", duration=");
            TimeUtils.formatDuration(this.mDurationMillis, obj2);
        }
        if (this.mMaxUpdates != Integer.MAX_VALUE) {
            stringBuilder.append(", maxUpdates=").append(this.mMaxUpdates);
        }
        if (Long.compare(mMinUpdateIntervalMillis2, mIntervalMillis) != 0 && Long.compare(mMinUpdateIntervalMillis3, mIntervalMillis) < 0) {
            if (Long.compare(mMinUpdateIntervalMillis3, mIntervalMillis) < 0) {
                stringBuilder.append(", minUpdateInterval=");
                TimeUtils.formatDuration(this.mMinUpdateIntervalMillis, mMinUpdateDistanceMeters);
            }
        }
        if (Double.compare(d, i3) > 0) {
            stringBuilder.append(", minUpdateDistance=").append(this.mMinUpdateDistanceMeters);
        }
        if (Long.compare(i, mIntervalMillis4) > 0) {
            stringBuilder.append(", maxUpdateDelay=");
            TimeUtils.formatDuration(this.mMaxUpdateDelayMillis, mMinUpdateDistanceMeters);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
