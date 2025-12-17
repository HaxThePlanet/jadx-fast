package androidx.core.location;

import android.location.Location;
import android.os.Build.VERSION;
import android.os.Bundle;
import androidx.annotation.ReplaceWith;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public final class LocationCompat {

    public static final String EXTRA_BEARING_ACCURACY = "bearingAccuracy";
    public static final String EXTRA_IS_MOCK = "mockLocation";
    public static final String EXTRA_MSL_ALTITUDE = "androidx.core.location.extra.MSL_ALTITUDE";
    public static final String EXTRA_MSL_ALTITUDE_ACCURACY = "androidx.core.location.extra.MSL_ALTITUDE_ACCURACY";
    public static final String EXTRA_SPEED_ACCURACY = "speedAccuracy";
    public static final String EXTRA_VERTICAL_ACCURACY = "verticalAccuracy";
    private static Field sFieldsMaskField;
    private static Integer sHasBearingAccuracyMask;
    private static Integer sHasSpeedAccuracyMask;
    private static Integer sHasVerticalAccuracyMask;
    private static Method sSetIsFromMockProviderMethod;

    private static class Api26Impl {
        static float getBearingAccuracyDegrees(Location location) {
            return location.getBearingAccuracyDegrees();
        }

        static float getSpeedAccuracyMetersPerSecond(Location location) {
            return location.getSpeedAccuracyMetersPerSecond();
        }

        static float getVerticalAccuracyMeters(Location location) {
            return location.getVerticalAccuracyMeters();
        }

        static boolean hasBearingAccuracy(Location location) {
            return location.hasBearingAccuracy();
        }

        static boolean hasSpeedAccuracy(Location location) {
            return location.hasSpeedAccuracy();
        }

        static boolean hasVerticalAccuracy(Location location) {
            return location.hasVerticalAccuracy();
        }

        static void removeBearingAccuracy(Location location) {
            try {
                LocationCompat.getFieldsMaskField().setByte(location, (byte)i2);
                IllegalAccessError noSuchFieldError = new IllegalAccessError();
                noSuchFieldError.initCause(e);
                throw noSuchFieldError;
                noSuchFieldError = new NoSuchFieldError();
                noSuchFieldError.initCause(e);
                throw noSuchFieldError;
            }
        }

        static void removeSpeedAccuracy(Location location) {
            try {
                LocationCompat.getFieldsMaskField().setByte(location, (byte)i2);
                IllegalAccessError noSuchFieldError = new IllegalAccessError();
                noSuchFieldError.initCause(e);
                throw noSuchFieldError;
                noSuchFieldError = new NoSuchFieldError();
                noSuchFieldError.initCause(e);
                throw noSuchFieldError;
            }
        }

        static void removeVerticalAccuracy(Location location) {
            try {
                LocationCompat.getFieldsMaskField().setByte(location, (byte)i2);
                IllegalAccessError illegalAccessError = new IllegalAccessError();
                illegalAccessError.initCause(th);
                throw illegalAccessError;
            }
        }

        static void setBearingAccuracyDegrees(Location location, float bearingAccuracyD) {
            location.setBearingAccuracyDegrees(bearingAccuracyD);
        }

        static void setSpeedAccuracyMetersPerSecond(Location location, float speedAccuracyMps) {
            location.setSpeedAccuracyMetersPerSecond(speedAccuracyMps);
        }

        static void setVerticalAccuracyMeters(Location location, float verticalAccuracyM) {
            location.setVerticalAccuracyMeters(verticalAccuracyM);
        }
    }

    private static class Api28Impl {
        static void removeBearingAccuracy(Location location) {
            float provider2;
            float verticalAccuracy2;
            float verticalAccuracy;
            String provider;
            final Object obj = location;
            if (!obj.hasBearingAccuracy()) {
            }
            String provider3 = obj.getProvider();
            float f = verticalAccuracyMeters;
            final float f2 = speedAccuracyMetersPerSecond;
            Bundle extras = obj.getExtras();
            obj.reset();
            obj.setProvider(provider3);
            obj.setTime(obj.getTime());
            obj.setElapsedRealtimeNanos(obj.getElapsedRealtimeNanos());
            obj.setLatitude(obj.getLatitude());
            obj.setLongitude(obj.getLongitude());
            if (obj.hasAltitude()) {
                obj.setAltitude(obj.getAltitude());
            }
            if (obj.hasSpeed()) {
                obj.setSpeed(obj.getSpeed());
            }
            if (obj.hasBearing()) {
                obj.setBearing(obj.getBearing());
            }
            if (obj.hasAccuracy()) {
                obj.setAccuracy(obj.getAccuracy());
            }
            if (obj.hasVerticalAccuracy()) {
                provider = provider3;
                obj.setVerticalAccuracyMeters(f);
            } else {
                provider = provider3;
                provider2 = f;
            }
            if (obj.hasSpeedAccuracy()) {
                verticalAccuracy = provider2;
                obj.setBearingAccuracyDegrees(f2);
            } else {
                verticalAccuracy = provider2;
                verticalAccuracy2 = f2;
            }
            if (extras != null) {
                obj.setExtras(extras);
            }
        }

        static void removeSpeedAccuracy(Location location) {
            float provider2;
            float verticalAccuracy2;
            float verticalAccuracy;
            String provider;
            final Object obj = location;
            if (!obj.hasSpeedAccuracy()) {
            }
            String provider3 = obj.getProvider();
            float f = verticalAccuracyMeters;
            final float f2 = bearingAccuracyDegrees;
            Bundle extras = obj.getExtras();
            obj.reset();
            obj.setProvider(provider3);
            obj.setTime(obj.getTime());
            obj.setElapsedRealtimeNanos(obj.getElapsedRealtimeNanos());
            obj.setLatitude(obj.getLatitude());
            obj.setLongitude(obj.getLongitude());
            if (obj.hasAltitude()) {
                obj.setAltitude(obj.getAltitude());
            }
            if (obj.hasSpeed()) {
                obj.setSpeed(obj.getSpeed());
            }
            if (obj.hasBearing()) {
                obj.setBearing(obj.getBearing());
            }
            if (obj.hasAccuracy()) {
                obj.setAccuracy(obj.getAccuracy());
            }
            if (obj.hasVerticalAccuracy()) {
                provider = provider3;
                obj.setVerticalAccuracyMeters(f);
            } else {
                provider = provider3;
                provider2 = f;
            }
            if (obj.hasBearingAccuracy()) {
                verticalAccuracy = provider2;
                obj.setBearingAccuracyDegrees(f2);
            } else {
                verticalAccuracy = provider2;
                verticalAccuracy2 = f2;
            }
            if (extras != null) {
                obj.setExtras(extras);
            }
        }

        static void removeVerticalAccuracy(Location location) {
            float provider;
            float speedAccuracy;
            float speedAccuracy2;
            String provider2;
            final Object obj = location;
            if (!obj.hasVerticalAccuracy()) {
            }
            String provider3 = obj.getProvider();
            float f = speedAccuracyMetersPerSecond;
            final float f2 = bearingAccuracyDegrees;
            Bundle extras = obj.getExtras();
            obj.reset();
            obj.setProvider(provider3);
            obj.setTime(obj.getTime());
            obj.setElapsedRealtimeNanos(obj.getElapsedRealtimeNanos());
            obj.setLatitude(obj.getLatitude());
            obj.setLongitude(obj.getLongitude());
            if (obj.hasAltitude()) {
                obj.setAltitude(obj.getAltitude());
            }
            if (obj.hasSpeed()) {
                obj.setSpeed(obj.getSpeed());
            }
            if (obj.hasBearing()) {
                obj.setBearing(obj.getBearing());
            }
            if (obj.hasAccuracy()) {
                obj.setAccuracy(obj.getAccuracy());
            }
            if (obj.hasSpeedAccuracy()) {
                provider2 = provider3;
                obj.setSpeedAccuracyMetersPerSecond(f);
            } else {
                provider2 = provider3;
                provider = f;
            }
            if (obj.hasBearingAccuracy()) {
                speedAccuracy2 = provider;
                obj.setBearingAccuracyDegrees(f2);
            } else {
                speedAccuracy2 = provider;
                speedAccuracy = f2;
            }
            if (extras != null) {
                obj.setExtras(extras);
            }
        }
    }

    private static class Api29Impl {
        static void removeBearingAccuracy(Location location) {
            if (!location.hasBearingAccuracy()) {
            }
            LocationCompat.Api28Impl.removeBearingAccuracy(location);
            location.setElapsedRealtimeUncertaintyNanos(location.getElapsedRealtimeUncertaintyNanos());
        }

        static void removeSpeedAccuracy(Location location) {
            if (!location.hasSpeedAccuracy()) {
            }
            LocationCompat.Api28Impl.removeSpeedAccuracy(location);
            location.setElapsedRealtimeUncertaintyNanos(location.getElapsedRealtimeUncertaintyNanos());
        }

        static void removeVerticalAccuracy(Location location) {
            if (!location.hasVerticalAccuracy()) {
            }
            LocationCompat.Api28Impl.removeVerticalAccuracy(location);
            location.setElapsedRealtimeUncertaintyNanos(location.getElapsedRealtimeUncertaintyNanos());
        }
    }

    static class Api31Impl {
        static boolean isMock(Location location) {
            return location.isMock();
        }
    }

    private static class Api33Impl {
        static void removeBearingAccuracy(Location location) {
            location.removeBearingAccuracy();
        }

        static void removeSpeedAccuracy(Location location) {
            location.removeSpeedAccuracy();
        }

        static void removeVerticalAccuracy(Location location) {
            location.removeVerticalAccuracy();
        }
    }

    private static class Api34Impl {
        static float getMslAltitudeAccuracyMeters(Location location) {
            return location.getMslAltitudeAccuracyMeters();
        }

        static double getMslAltitudeMeters(Location location) {
            return location.getMslAltitudeMeters();
        }

        static boolean hasMslAltitude(Location location) {
            return location.hasMslAltitude();
        }

        static boolean hasMslAltitudeAccuracy(Location location) {
            return location.hasMslAltitudeAccuracy();
        }

        static void removeMslAltitude(Location location) {
            location.removeMslAltitude();
        }

        static void removeMslAltitudeAccuracy(Location location) {
            location.removeMslAltitudeAccuracy();
        }

        static void setMslAltitudeAccuracyMeters(Location location, float mslAltitudeAccuracyMeters) {
            location.setMslAltitudeAccuracyMeters(mslAltitudeAccuracyMeters);
        }

        static void setMslAltitudeMeters(Location location, double mslAltitudeMeters) {
            location.setMslAltitudeMeters(mslAltitudeMeters);
        }
    }
    private static boolean containsExtra(Location location, String key) {
        boolean key2;
        int i;
        final Bundle extras = location.getExtras();
        if (extras != null && extras.containsKey(key)) {
            i = extras.containsKey(key) ? 1 : 0;
        } else {
        }
        return i;
    }

    public static float getBearingAccuracyDegrees(Location location) {
        return LocationCompat.Api26Impl.getBearingAccuracyDegrees(location);
    }

    public static long getElapsedRealtimeMillis(Location location) {
        return TimeUnit.NANOSECONDS.toMillis(location.getElapsedRealtimeNanos());
    }

    @ReplaceWith(expression = "location.getElapsedRealtimeNanos()")
    @Deprecated
    public static long getElapsedRealtimeNanos(Location location) {
        return location.getElapsedRealtimeNanos();
    }

    static Field getFieldsMaskField() throws java.lang.NoSuchFieldException {
        Field sFieldsMaskField;
        int i;
        if (LocationCompat.sFieldsMaskField == null) {
            LocationCompat.sFieldsMaskField = Location.class.getDeclaredField("mFieldsMask");
            LocationCompat.sFieldsMaskField.setAccessible(true);
        }
        return LocationCompat.sFieldsMaskField;
    }

    static int getHasBearingAccuracyMask() throws java.lang.NoSuchFieldException, java.lang.IllegalAccessException {
        Object sHasBearingAccuracyMask;
        Integer valueOf;
        if (LocationCompat.sHasBearingAccuracyMask == null) {
            sHasBearingAccuracyMask = Location.class.getDeclaredField("HAS_BEARING_ACCURACY_MASK");
            sHasBearingAccuracyMask.setAccessible(true);
            LocationCompat.sHasBearingAccuracyMask = Integer.valueOf(sHasBearingAccuracyMask.getInt(0));
        }
        return LocationCompat.sHasBearingAccuracyMask.intValue();
    }

    static int getHasSpeedAccuracyMask() throws java.lang.NoSuchFieldException, java.lang.IllegalAccessException {
        Object sHasSpeedAccuracyMask;
        Integer valueOf;
        if (LocationCompat.sHasSpeedAccuracyMask == null) {
            sHasSpeedAccuracyMask = Location.class.getDeclaredField("HAS_SPEED_ACCURACY_MASK");
            sHasSpeedAccuracyMask.setAccessible(true);
            LocationCompat.sHasSpeedAccuracyMask = Integer.valueOf(sHasSpeedAccuracyMask.getInt(0));
        }
        return LocationCompat.sHasSpeedAccuracyMask.intValue();
    }

    static int getHasVerticalAccuracyMask() throws java.lang.NoSuchFieldException, java.lang.IllegalAccessException {
        Object sHasVerticalAccuracyMask;
        Integer valueOf;
        if (LocationCompat.sHasVerticalAccuracyMask == null) {
            sHasVerticalAccuracyMask = Location.class.getDeclaredField("HAS_VERTICAL_ACCURACY_MASK");
            sHasVerticalAccuracyMask.setAccessible(true);
            LocationCompat.sHasVerticalAccuracyMask = Integer.valueOf(sHasVerticalAccuracyMask.getInt(0));
        }
        return LocationCompat.sHasVerticalAccuracyMask.intValue();
    }

    public static float getMslAltitudeAccuracyMeters(Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            return LocationCompat.Api34Impl.getMslAltitudeAccuracyMeters(location);
        }
        return LocationCompat.getOrCreateExtras(location).getFloat("androidx.core.location.extra.MSL_ALTITUDE_ACCURACY");
    }

    public static double getMslAltitudeMeters(Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            return LocationCompat.Api34Impl.getMslAltitudeMeters(location);
        }
        return LocationCompat.getOrCreateExtras(location).getDouble("androidx.core.location.extra.MSL_ALTITUDE");
    }

    private static Bundle getOrCreateExtras(Location location) {
        Bundle extras;
        Bundle bundle;
        if (location.getExtras() == null) {
            bundle = new Bundle();
            location.setExtras(bundle);
            extras = location.getExtras();
        }
        return extras;
    }

    private static Method getSetIsFromMockProviderMethod() throws java.lang.NoSuchMethodException {
        Method sSetIsFromMockProviderMethod;
        int i;
        Class[] arr;
        String str;
        Class tYPE;
        if (LocationCompat.sSetIsFromMockProviderMethod == null) {
            i = 1;
            arr = new Class[i];
            arr[0] = Boolean.TYPE;
            LocationCompat.sSetIsFromMockProviderMethod = Location.class.getDeclaredMethod("setIsFromMockProvider", arr);
            LocationCompat.sSetIsFromMockProviderMethod.setAccessible(i);
        }
        return LocationCompat.sSetIsFromMockProviderMethod;
    }

    public static float getSpeedAccuracyMetersPerSecond(Location location) {
        return LocationCompat.Api26Impl.getSpeedAccuracyMetersPerSecond(location);
    }

    public static float getVerticalAccuracyMeters(Location location) {
        return LocationCompat.Api26Impl.getVerticalAccuracyMeters(location);
    }

    public static boolean hasBearingAccuracy(Location location) {
        return LocationCompat.Api26Impl.hasBearingAccuracy(location);
    }

    public static boolean hasMslAltitude(Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            return LocationCompat.Api34Impl.hasMslAltitude(location);
        }
        return LocationCompat.containsExtra(location, "androidx.core.location.extra.MSL_ALTITUDE");
    }

    public static boolean hasMslAltitudeAccuracy(Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            return LocationCompat.Api34Impl.hasMslAltitudeAccuracy(location);
        }
        return LocationCompat.containsExtra(location, "androidx.core.location.extra.MSL_ALTITUDE_ACCURACY");
    }

    public static boolean hasSpeedAccuracy(Location location) {
        return LocationCompat.Api26Impl.hasSpeedAccuracy(location);
    }

    public static boolean hasVerticalAccuracy(Location location) {
        return LocationCompat.Api26Impl.hasVerticalAccuracy(location);
    }

    public static boolean isMock(Location location) {
        if (Build.VERSION.SDK_INT >= 31) {
            return LocationCompat.Api31Impl.isMock(location);
        }
        return location.isFromMockProvider();
    }

    public static void removeBearingAccuracy(Location location) {
        if (Build.VERSION.SDK_INT >= 33) {
            LocationCompat.Api33Impl.removeBearingAccuracy(location);
        } else {
            LocationCompat.Api29Impl.removeBearingAccuracy(location);
        }
    }

    private static void removeExtra(Location location, String key) {
        boolean empty;
        final Bundle extras = location.getExtras();
        extras.remove(key);
        if (extras != null && extras.isEmpty()) {
            extras.remove(key);
            if (extras.isEmpty()) {
                location.setExtras(0);
            }
        }
    }

    public static void removeMslAltitude(Location location) {
        int sDK_INT;
        if (Build.VERSION.SDK_INT >= 34) {
            LocationCompat.Api34Impl.removeMslAltitude(location);
        } else {
            LocationCompat.removeExtra(location, "androidx.core.location.extra.MSL_ALTITUDE");
        }
    }

    public static void removeMslAltitudeAccuracy(Location location) {
        int sDK_INT;
        if (Build.VERSION.SDK_INT >= 34) {
            LocationCompat.Api34Impl.removeMslAltitudeAccuracy(location);
        } else {
            LocationCompat.removeExtra(location, "androidx.core.location.extra.MSL_ALTITUDE_ACCURACY");
        }
    }

    public static void removeSpeedAccuracy(Location location) {
        if (Build.VERSION.SDK_INT >= 33) {
            LocationCompat.Api33Impl.removeSpeedAccuracy(location);
        } else {
            LocationCompat.Api29Impl.removeSpeedAccuracy(location);
        }
    }

    public static void removeVerticalAccuracy(Location location) {
        if (Build.VERSION.SDK_INT >= 33) {
            LocationCompat.Api33Impl.removeVerticalAccuracy(location);
        } else {
            LocationCompat.Api29Impl.removeVerticalAccuracy(location);
        }
    }

    public static void setBearingAccuracyDegrees(Location location, float bearingAccuracyD) {
        LocationCompat.Api26Impl.setBearingAccuracyDegrees(location, bearingAccuracyD);
    }

    public static void setMock(Location location, boolean mock) {
        try {
            LocationCompat.getSetIsFromMockProviderMethod().invoke(location, /* result */);
            RuntimeException noSuchMethodError = new RuntimeException(e);
            throw noSuchMethodError;
            noSuchMethodError = new IllegalAccessError();
            noSuchMethodError.initCause(e);
            throw noSuchMethodError;
            noSuchMethodError = new NoSuchMethodError();
            noSuchMethodError.initCause(e);
            throw noSuchMethodError;
        }
    }

    public static void setMslAltitudeAccuracyMeters(Location location, float mslAltitudeAccuracyMeters) {
        int orCreateExtras;
        int str;
        if (Build.VERSION.SDK_INT >= 34) {
            LocationCompat.Api34Impl.setMslAltitudeAccuracyMeters(location, mslAltitudeAccuracyMeters);
        } else {
            LocationCompat.getOrCreateExtras(location).putFloat("androidx.core.location.extra.MSL_ALTITUDE_ACCURACY", mslAltitudeAccuracyMeters);
        }
    }

    public static void setMslAltitudeMeters(Location location, double mslAltitudeMeters) {
        int orCreateExtras;
        int str;
        if (Build.VERSION.SDK_INT >= 34) {
            LocationCompat.Api34Impl.setMslAltitudeMeters(location, mslAltitudeMeters);
        } else {
            LocationCompat.getOrCreateExtras(location).putDouble("androidx.core.location.extra.MSL_ALTITUDE", mslAltitudeMeters);
        }
    }

    public static void setSpeedAccuracyMetersPerSecond(Location location, float speedAccuracyMps) {
        LocationCompat.Api26Impl.setSpeedAccuracyMetersPerSecond(location, speedAccuracyMps);
    }

    public static void setVerticalAccuracyMeters(Location location, float verticalAccuracyM) {
        LocationCompat.Api26Impl.setVerticalAccuracyMeters(location, verticalAccuracyM);
    }
}
