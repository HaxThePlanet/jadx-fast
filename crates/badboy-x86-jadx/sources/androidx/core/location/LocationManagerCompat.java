package androidx.core.location;

import android.location.GnssMeasurementsEvent;
import android.location.GnssMeasurementsEvent.Callback;
import android.location.GnssStatus;
import android.location.GnssStatus.Callback;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.collection.SimpleArrayMap;
import androidx.core.os.CancellationSignal;
import androidx.core.os.ExecutorCompat;
import androidx.core.util.Consumer;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes5.dex */
public final class LocationManagerCompat {

    private static final long GET_CURRENT_LOCATION_TIMEOUT_MS = 30000L;
    private static final long MAX_CURRENT_LOCATION_AGE_MS = 10000L;
    private static final long PRE_N_LOOPER_TIMEOUT_S = 5L;
    private static Field sContextField;
    private static Method sGnssRequestBuilderBuildMethod;
    private static Class<?> sGnssRequestBuilderClass;
    static final WeakHashMap<androidx.core.location.LocationManagerCompat.LocationListenerKey, WeakReference<androidx.core.location.LocationManagerCompat.LocationListenerTransport>> sLocationListeners;
    private static Method sRegisterGnssMeasurementsCallbackMethod;

    static class Api19Impl {

        private static Class<?> sLocationRequestClass;
        private static Method sRequestLocationUpdatesLooperMethod;
        static boolean tryRequestLocationUpdates(LocationManager locationManager, String provider, androidx.core.location.LocationRequestCompat locationRequest, androidx.core.location.LocationListenerCompat listener, Looper looper) {
            Class sLocationRequestClass;
            Method sRequestLocationUpdatesLooperMethod;
            LocationRequest locationRequest2;
            String str;
            Class[] arr;
            Class<Looper> obj;
            int i;
            final int i2 = 0;
            if (LocationManagerCompat.Api19Impl.sLocationRequestClass == null) {
                try {
                    LocationManagerCompat.Api19Impl.sLocationRequestClass = Class.forName("android.location.LocationRequest");
                    final int i3 = 1;
                    if (LocationManagerCompat.Api19Impl.sRequestLocationUpdatesLooperMethod == null) {
                    }
                    arr = new Class[3];
                    arr[i2] = LocationManagerCompat.Api19Impl.sLocationRequestClass;
                    arr[i3] = LocationListener.class;
                    arr[2] = Looper.class;
                    LocationManagerCompat.Api19Impl.sRequestLocationUpdatesLooperMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", arr);
                    LocationManagerCompat.Api19Impl.sRequestLocationUpdatesLooperMethod.setAccessible(i3);
                    locationRequest2 = locationRequest.toLocationRequest(provider);
                    if (locationRequest2 != null) {
                    }
                    LocationManagerCompat.Api19Impl.sRequestLocationUpdatesLooperMethod.invoke(locationManager, /* result */);
                    return i3;
                    return i2;
                }
            }
        }

        static boolean tryRequestLocationUpdates(LocationManager locationManager, String provider, androidx.core.location.LocationRequestCompat locationRequest, androidx.core.location.LocationManagerCompat.LocationListenerTransport transport) {
            Class sLocationRequestClass;
            Method sRequestLocationUpdatesLooperMethod;
            LocationRequest locationRequest2;
            String str;
            Class[] arr;
            Class<Looper> obj;
            int i;
            final int i2 = 0;
            if (LocationManagerCompat.Api19Impl.sLocationRequestClass == null) {
                try {
                    LocationManagerCompat.Api19Impl.sLocationRequestClass = Class.forName("android.location.LocationRequest");
                    final int i3 = 1;
                    if (LocationManagerCompat.Api19Impl.sRequestLocationUpdatesLooperMethod == null) {
                    }
                    arr = new Class[3];
                    arr[i2] = LocationManagerCompat.Api19Impl.sLocationRequestClass;
                    arr[i3] = LocationListener.class;
                    arr[2] = Looper.class;
                    LocationManagerCompat.Api19Impl.sRequestLocationUpdatesLooperMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", arr);
                    LocationManagerCompat.Api19Impl.sRequestLocationUpdatesLooperMethod.setAccessible(i3);
                    locationRequest2 = locationRequest.toLocationRequest(provider);
                    if (locationRequest2 != null) {
                    }
                    WeakHashMap sLocationListeners = LocationManagerCompat.sLocationListeners;
                    LocationManagerCompat.Api19Impl.sRequestLocationUpdatesLooperMethod.invoke(locationManager, /* result */);
                    LocationManagerCompat.registerLocationListenerTransport(locationManager, transport);
                    return i3;
                    throw th2;
                    return i2;
                } catch (Throwable th) {
                }
            }
        }
    }

    static class Api24Impl {
        static boolean registerGnssMeasurementsCallback(LocationManager locationManager, GnssMeasurementsEvent.Callback callback) {
            return locationManager.registerGnssMeasurementsCallback(callback);
        }

        static boolean registerGnssMeasurementsCallback(LocationManager locationManager, GnssMeasurementsEvent.Callback callback, Handler handler) {
            return locationManager.registerGnssMeasurementsCallback(callback, handler);
        }

        static boolean registerGnssStatusCallback(LocationManager locationManager, Handler baseHandler, Executor executor, androidx.core.location.GnssStatusCompat.Callback callback) {
            int i;
            Object transport;
            androidx.core.location.LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport;
            final int i2 = 1;
            int i3 = 0;
            i = baseHandler != null ? i2 : i3;
            Preconditions.checkArgument(i);
            SimpleArrayMap sGnssStatusListeners2 = LocationManagerCompat.GnssListenersHolder.sGnssStatusListeners;
            transport = LocationManagerCompat.GnssListenersHolder.sGnssStatusListeners.get(callback);
            synchronized (sGnssStatusListeners2) {
                preRGnssStatusTransport = new LocationManagerCompat.PreRGnssStatusTransport(callback);
                transport = preRGnssStatusTransport;
                transport.register(executor);
                if (locationManager.registerGnssStatusCallback(transport, baseHandler)) {
                    LocationManagerCompat.GnssListenersHolder.sGnssStatusListeners.put(callback, transport);
                    return i2;
                }
                return i3;
            }
        }

        static void unregisterGnssMeasurementsCallback(LocationManager locationManager, GnssMeasurementsEvent.Callback callback) {
            locationManager.unregisterGnssMeasurementsCallback(callback);
        }

        static void unregisterGnssStatusCallback(LocationManager locationManager, Object callback) {
            boolean z;
            if (callback instanceof LocationManagerCompat.PreRGnssStatusTransport) {
                (LocationManagerCompat.PreRGnssStatusTransport)callback.unregister();
            }
            locationManager.unregisterGnssStatusCallback((GnssStatus.Callback)callback);
        }
    }

    private static class Api28Impl {
        static String getGnssHardwareModelName(LocationManager locationManager) {
            return locationManager.getGnssHardwareModelName();
        }

        static int getGnssYearOfHardware(LocationManager locationManager) {
            return locationManager.getGnssYearOfHardware();
        }

        static boolean isLocationEnabled(LocationManager locationManager) {
            return locationManager.isLocationEnabled();
        }
    }

    private static class Api30Impl {

        private static Class<?> sLocationRequestClass;
        private static Method sRequestLocationUpdatesExecutorMethod;
        static void getCurrentLocation(LocationManager locationManager, String provider, CancellationSignal cancellationSignal, Executor executor, Consumer<Location> consumer5) {
            Objects.requireNonNull(consumer5);
            LocationManagerCompat.Api30Impl$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new LocationManagerCompat.Api30Impl$$ExternalSyntheticLambda0(consumer5);
            locationManager.getCurrentLocation(provider, cancellationSignal, executor, externalSyntheticLambda0);
        }

        public static boolean registerGnssStatusCallback(LocationManager locationManager, Handler baseHandler, Executor executor, androidx.core.location.GnssStatusCompat.Callback callback) {
            Object transport;
            androidx.core.location.LocationManagerCompat.GnssStatusTransport gnssStatusTransport;
            SimpleArrayMap sGnssStatusListeners = LocationManagerCompat.GnssListenersHolder.sGnssStatusListeners;
            synchronized (sGnssStatusListeners) {
                gnssStatusTransport = new LocationManagerCompat.GnssStatusTransport(callback);
                transport = gnssStatusTransport;
                if (locationManager.registerGnssStatusCallback(executor, transport)) {
                    try {
                        LocationManagerCompat.GnssListenersHolder.sGnssStatusListeners.put(callback, transport);
                        return 1;
                        return 0;
                        throw transport2;
                    }
                }
            }
        }

        public static boolean tryRequestLocationUpdates(LocationManager locationManager, String provider, androidx.core.location.LocationRequestCompat locationRequest, Executor executor, androidx.core.location.LocationListenerCompat listener) {
            int locationRequest2;
            Class sLocationRequestClass;
            Method sRequestLocationUpdatesExecutorMethod;
            int i2;
            String str;
            Class[] arr;
            Class<LocationListener> obj;
            int i;
            final int i3 = 0;
            if (Build.VERSION.SDK_INT >= 30 && LocationManagerCompat.Api30Impl.sLocationRequestClass == null) {
                if (LocationManagerCompat.Api30Impl.sLocationRequestClass == null) {
                    LocationManagerCompat.Api30Impl.sLocationRequestClass = Class.forName("android.location.LocationRequest");
                }
                i2 = 1;
                if (LocationManagerCompat.Api30Impl.sRequestLocationUpdatesExecutorMethod == null) {
                    arr = new Class[3];
                    arr[i3] = LocationManagerCompat.Api30Impl.sLocationRequestClass;
                    arr[i2] = Executor.class;
                    arr[2] = LocationListener.class;
                    LocationManagerCompat.Api30Impl.sRequestLocationUpdatesExecutorMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", arr);
                    LocationManagerCompat.Api30Impl.sRequestLocationUpdatesExecutorMethod.setAccessible(i2);
                }
                locationRequest2 = locationRequest.toLocationRequest(provider);
                if (locationRequest2 != null) {
                    LocationManagerCompat.Api30Impl.sRequestLocationUpdatesExecutorMethod.invoke(locationManager, /* result */);
                    return i2;
                }
                try {
                    return i3;
                }
            }
        }
    }

    private static class Api31Impl {
        static boolean hasProvider(LocationManager locationManager, String provider) {
            return locationManager.hasProvider(provider);
        }

        static boolean registerGnssMeasurementsCallback(LocationManager locationManager, Executor executor, GnssMeasurementsEvent.Callback callback) {
            return locationManager.registerGnssMeasurementsCallback(executor, callback);
        }

        static void requestLocationUpdates(LocationManager locationManager, String provider, LocationRequest locationRequest, Executor executor, LocationListener listener) {
            locationManager.requestLocationUpdates(provider, locationRequest, executor, listener);
        }
    }

    private static final class CancellableLocationListener implements LocationListener {

        private Consumer<Location> mConsumer;
        private final Executor mExecutor;
        private final LocationManager mLocationManager;
        private final Handler mTimeoutHandler;
        Runnable mTimeoutRunnable;
        private boolean mTriggered;
        CancellableLocationListener(LocationManager locationManager, Executor executor, Consumer<Location> consumer3) {
            super();
            this.mLocationManager = locationManager;
            this.mExecutor = executor;
            Handler handler = new Handler(Looper.getMainLooper());
            this.mTimeoutHandler = handler;
            this.mConsumer = consumer3;
        }

        private void cleanup() {
            Object mTimeoutRunnable;
            Runnable mTimeoutRunnable2;
            final int i = 0;
            this.mConsumer = i;
            this.mLocationManager.removeUpdates(this);
            if (this.mTimeoutRunnable != null) {
                this.mTimeoutHandler.removeCallbacks(this.mTimeoutRunnable);
                this.mTimeoutRunnable = i;
            }
        }

        static void lambda$onLocationChanged$1(Consumer consumer, Location location) {
            consumer.accept(location);
        }

        @Override // android.location.LocationListener
        public void cancel() {
            synchronized (this) {
                try {
                    this.mTriggered = true;
                    cleanup();
                    throw th;
                }
            }
        }

        @Override // android.location.LocationListener
        void lambda$startTimeout$0$androidx-core-location-LocationManagerCompat$CancellableLocationListener() {
            final int i = 0;
            this.mTimeoutRunnable = i;
            final int i2 = i;
            onLocationChanged(i);
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            synchronized (this) {
                try {
                    this.mTriggered = true;
                    LocationManagerCompat.CancellableLocationListener$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new LocationManagerCompat.CancellableLocationListener$$ExternalSyntheticLambda1(this.mConsumer, location);
                    this.mExecutor.execute(externalSyntheticLambda1);
                    cleanup();
                    throw consumer;
                }
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String p) {
            final int i = 0;
            final int i2 = i;
            onLocationChanged(i);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String provider) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        @Override // android.location.LocationListener
        public void startTimeout(long timeoutMs) {
            synchronized (this) {
                try {
                    LocationManagerCompat.CancellableLocationListener$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new LocationManagerCompat.CancellableLocationListener$$ExternalSyntheticLambda0(this);
                    this.mTimeoutRunnable = externalSyntheticLambda0;
                    this.mTimeoutHandler.postDelayed(this.mTimeoutRunnable, timeoutMs);
                    throw th;
                }
            }
        }
    }

    private static class GnssListenersHolder {

        static final SimpleArrayMap<GnssMeasurementsEvent.Callback, GnssMeasurementsEvent.Callback> sGnssMeasurementListeners;
        static final SimpleArrayMap<Object, Object> sGnssStatusListeners;
        static {
            SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
            LocationManagerCompat.GnssListenersHolder.sGnssStatusListeners = simpleArrayMap;
            SimpleArrayMap simpleArrayMap2 = new SimpleArrayMap();
            LocationManagerCompat.GnssListenersHolder.sGnssMeasurementListeners = simpleArrayMap2;
        }
    }

    private static class GnssMeasurementsTransport extends GnssMeasurementsEvent.Callback {

        final GnssMeasurementsEvent.Callback mCallback;
        volatile Executor mExecutor;
        GnssMeasurementsTransport(GnssMeasurementsEvent.Callback callback, Executor executor) {
            super();
            this.mCallback = callback;
            this.mExecutor = executor;
        }

        @Override // android.location.GnssMeasurementsEvent$Callback
        void lambda$onGnssMeasurementsReceived$0$androidx-core-location-LocationManagerCompat$GnssMeasurementsTransport(Executor executor, GnssMeasurementsEvent gnssMeasurementsEvent) {
            if (this.mExecutor != executor) {
            }
            this.mCallback.onGnssMeasurementsReceived(gnssMeasurementsEvent);
        }

        @Override // android.location.GnssMeasurementsEvent$Callback
        void lambda$onStatusChanged$1$androidx-core-location-LocationManagerCompat$GnssMeasurementsTransport(Executor executor, int status) {
            if (this.mExecutor != executor) {
            }
            this.mCallback.onStatusChanged(status);
        }

        @Override // android.location.GnssMeasurementsEvent$Callback
        public void onGnssMeasurementsReceived(GnssMeasurementsEvent gnssMeasurementsEvent) {
            final Executor mExecutor = this.mExecutor;
            if (mExecutor == null) {
            }
            LocationManagerCompat.GnssMeasurementsTransport$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new LocationManagerCompat.GnssMeasurementsTransport$$ExternalSyntheticLambda0(this, mExecutor, gnssMeasurementsEvent);
            mExecutor.execute(externalSyntheticLambda0);
        }

        @Override // android.location.GnssMeasurementsEvent$Callback
        public void onStatusChanged(int status) {
            final Executor mExecutor = this.mExecutor;
            if (mExecutor == null) {
            }
            LocationManagerCompat.GnssMeasurementsTransport$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new LocationManagerCompat.GnssMeasurementsTransport$$ExternalSyntheticLambda1(this, mExecutor, status);
            mExecutor.execute(externalSyntheticLambda1);
        }

        @Override // android.location.GnssMeasurementsEvent$Callback
        public void unregister() {
            this.mExecutor = 0;
        }
    }

    private static class GnssStatusTransport extends GnssStatus.Callback {

        final androidx.core.location.GnssStatusCompat.Callback mCallback;
        GnssStatusTransport(androidx.core.location.GnssStatusCompat.Callback callback) {
            int i;
            super();
            i = callback != null ? 1 : 0;
            Preconditions.checkArgument(i, "invalid null callback");
            this.mCallback = callback;
        }

        @Override // android.location.GnssStatus$Callback
        public void onFirstFix(int ttffMillis) {
            this.mCallback.onFirstFix(ttffMillis);
        }

        @Override // android.location.GnssStatus$Callback
        public void onSatelliteStatusChanged(GnssStatus status) {
            this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(status));
        }

        @Override // android.location.GnssStatus$Callback
        public void onStarted() {
            this.mCallback.onStarted();
        }

        @Override // android.location.GnssStatus$Callback
        public void onStopped() {
            this.mCallback.onStopped();
        }
    }

    private static class GpsStatusTransport implements GpsStatus.Listener {

        final androidx.core.location.GnssStatusCompat.Callback mCallback;
        volatile Executor mExecutor;
        private final LocationManager mLocationManager;
        GpsStatusTransport(LocationManager locationManager, androidx.core.location.GnssStatusCompat.Callback callback) {
            int i;
            super();
            i = callback != null ? 1 : 0;
            Preconditions.checkArgument(i, "invalid null callback");
            this.mLocationManager = locationManager;
            this.mCallback = callback;
        }

        @Override // android.location.GpsStatus$Listener
        void lambda$onGpsStatusChanged$0$androidx-core-location-LocationManagerCompat$GpsStatusTransport(Executor executor) {
            if (this.mExecutor != executor) {
            }
            this.mCallback.onStarted();
        }

        @Override // android.location.GpsStatus$Listener
        void lambda$onGpsStatusChanged$1$androidx-core-location-LocationManagerCompat$GpsStatusTransport(Executor executor) {
            if (this.mExecutor != executor) {
            }
            this.mCallback.onStopped();
        }

        @Override // android.location.GpsStatus$Listener
        void lambda$onGpsStatusChanged$2$androidx-core-location-LocationManagerCompat$GpsStatusTransport(Executor executor, int ttff) {
            if (this.mExecutor != executor) {
            }
            this.mCallback.onFirstFix(ttff);
        }

        @Override // android.location.GpsStatus$Listener
        void lambda$onGpsStatusChanged$3$androidx-core-location-LocationManagerCompat$GpsStatusTransport(Executor executor, androidx.core.location.GnssStatusCompat gnssStatus) {
            if (this.mExecutor != executor) {
            }
            this.mCallback.onSatelliteStatusChanged(gnssStatus);
        }

        @Override // android.location.GpsStatus$Listener
        public void onGpsStatusChanged(int event) {
            int gpsStatus;
            LocationManager gnssStatus;
            Object externalSyntheticLambda2;
            final Executor mExecutor = this.mExecutor;
            if (mExecutor == null) {
            }
            gpsStatus = 0;
            switch (event) {
                case 1:
                    gpsStatus = new LocationManagerCompat.GpsStatusTransport$$ExternalSyntheticLambda0(this, mExecutor);
                    mExecutor.execute(gpsStatus);
                    break;
                case 2:
                    gpsStatus = new LocationManagerCompat.GpsStatusTransport$$ExternalSyntheticLambda1(this, mExecutor);
                    mExecutor.execute(gpsStatus);
                    break;
                case 3:
                    gpsStatus = this.mLocationManager.getGpsStatus(gpsStatus);
                    externalSyntheticLambda2 = new LocationManagerCompat.GpsStatusTransport$$ExternalSyntheticLambda2(this, mExecutor, gpsStatus.getTimeToFirstFix());
                    mExecutor.execute(externalSyntheticLambda2);
                    break;
                case 4:
                    gpsStatus = this.mLocationManager.getGpsStatus(gpsStatus);
                    externalSyntheticLambda2 = new LocationManagerCompat.GpsStatusTransport$$ExternalSyntheticLambda3(this, mExecutor, GnssStatusCompat.wrap(gpsStatus));
                    mExecutor.execute(externalSyntheticLambda2);
                    break;
                default:
            }
        }

        @Override // android.location.GpsStatus$Listener
        public void register(Executor executor) {
            int i;
            i = this.mExecutor == null ? 1 : 0;
            Preconditions.checkState(i);
            this.mExecutor = executor;
        }

        @Override // android.location.GpsStatus$Listener
        public void unregister() {
            this.mExecutor = 0;
        }
    }

    private static final class InlineHandlerExecutor implements Executor {

        private final Handler mHandler;
        InlineHandlerExecutor(Handler handler) {
            super();
            this.mHandler = (Handler)Preconditions.checkNotNull(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable command) {
            Looper myLooper;
            Object checkNotNull;
            if (Looper.myLooper() == this.mHandler.getLooper()) {
                command.run();
            } else {
                if (!this.mHandler.post((Runnable)Preconditions.checkNotNull(command))) {
                } else {
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            RejectedExecutionException rejectedExecutionException = new RejectedExecutionException(stringBuilder.append(this.mHandler).append(" is shutting down").toString());
            throw rejectedExecutionException;
        }
    }

    private static class LocationListenerKey {

        final androidx.core.location.LocationListenerCompat mListener;
        final String mProvider;
        LocationListenerKey(String provider, androidx.core.location.LocationListenerCompat listener) {
            super();
            this.mProvider = (String)ObjectsCompat.requireNonNull(provider, "invalid null provider");
            this.mListener = (LocationListenerCompat)ObjectsCompat.requireNonNull(listener, "invalid null listener");
        }

        public boolean equals(Object o) {
            int i;
            boolean equals;
            Object mProvider;
            if (!o instanceof LocationManagerCompat.LocationListenerKey) {
                return 0;
            }
            Object obj = o;
            if (this.mProvider.equals(obj.mProvider) && this.mListener.equals(obj.mListener)) {
                if (this.mListener.equals(obj.mListener)) {
                    i = 1;
                }
            }
            return i;
        }

        public int hashCode() {
            return ObjectsCompat.hash(/* result */);
        }
    }

    private static class LocationListenerTransport implements LocationListener {

        final Executor mExecutor;
        volatile androidx.core.location.LocationManagerCompat.LocationListenerKey mKey;
        LocationListenerTransport(androidx.core.location.LocationManagerCompat.LocationListenerKey key, Executor executor) {
            super();
            this.mKey = key;
            this.mExecutor = executor;
        }

        @Override // android.location.LocationListener
        public androidx.core.location.LocationManagerCompat.LocationListenerKey getKey() {
            return (LocationManagerCompat.LocationListenerKey)ObjectsCompat.requireNonNull(this.mKey);
        }

        @Override // android.location.LocationListener
        void lambda$onFlushComplete$2$androidx-core-location-LocationManagerCompat$LocationListenerTransport(int requestCode) {
            final androidx.core.location.LocationManagerCompat.LocationListenerKey mKey = this.mKey;
            if (mKey == null) {
            }
            mKey.mListener.onFlushComplete(requestCode);
        }

        @Override // android.location.LocationListener
        void lambda$onLocationChanged$0$androidx-core-location-LocationManagerCompat$LocationListenerTransport(Location location) {
            final androidx.core.location.LocationManagerCompat.LocationListenerKey mKey = this.mKey;
            if (mKey == null) {
            }
            mKey.mListener.onLocationChanged(location);
        }

        @Override // android.location.LocationListener
        void lambda$onLocationChanged$1$androidx-core-location-LocationManagerCompat$LocationListenerTransport(List locations) {
            final androidx.core.location.LocationManagerCompat.LocationListenerKey mKey = this.mKey;
            if (mKey == null) {
            }
            mKey.mListener.onLocationChanged(locations);
        }

        @Override // android.location.LocationListener
        void lambda$onProviderDisabled$5$androidx-core-location-LocationManagerCompat$LocationListenerTransport(String provider) {
            final androidx.core.location.LocationManagerCompat.LocationListenerKey mKey = this.mKey;
            if (mKey == null) {
            }
            mKey.mListener.onProviderDisabled(provider);
        }

        @Override // android.location.LocationListener
        void lambda$onProviderEnabled$4$androidx-core-location-LocationManagerCompat$LocationListenerTransport(String provider) {
            final androidx.core.location.LocationManagerCompat.LocationListenerKey mKey = this.mKey;
            if (mKey == null) {
            }
            mKey.mListener.onProviderEnabled(provider);
        }

        @Override // android.location.LocationListener
        void lambda$onStatusChanged$3$androidx-core-location-LocationManagerCompat$LocationListenerTransport(String provider, int status, Bundle extras) {
            final androidx.core.location.LocationManagerCompat.LocationListenerKey mKey = this.mKey;
            if (mKey == null) {
            }
            mKey.mListener.onStatusChanged(provider, status, extras);
        }

        @Override // android.location.LocationListener
        public void onFlushComplete(int requestCode) {
            if (this.mKey == null) {
            }
            LocationManagerCompat.LocationListenerTransport$$ExternalSyntheticLambda4 externalSyntheticLambda4 = new LocationManagerCompat.LocationListenerTransport$$ExternalSyntheticLambda4(this, requestCode);
            this.mExecutor.execute(externalSyntheticLambda4);
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (this.mKey == null) {
            }
            LocationManagerCompat.LocationListenerTransport$$ExternalSyntheticLambda3 externalSyntheticLambda3 = new LocationManagerCompat.LocationListenerTransport$$ExternalSyntheticLambda3(this, location);
            this.mExecutor.execute(externalSyntheticLambda3);
        }

        public void onLocationChanged(List<Location> list) {
            if (this.mKey == null) {
            }
            LocationManagerCompat.LocationListenerTransport$$ExternalSyntheticLambda2 externalSyntheticLambda2 = new LocationManagerCompat.LocationListenerTransport$$ExternalSyntheticLambda2(this, list);
            this.mExecutor.execute(externalSyntheticLambda2);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String provider) {
            if (this.mKey == null) {
            }
            LocationManagerCompat.LocationListenerTransport$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new LocationManagerCompat.LocationListenerTransport$$ExternalSyntheticLambda1(this, provider);
            this.mExecutor.execute(externalSyntheticLambda1);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String provider) {
            if (this.mKey == null) {
            }
            LocationManagerCompat.LocationListenerTransport$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new LocationManagerCompat.LocationListenerTransport$$ExternalSyntheticLambda0(this, provider);
            this.mExecutor.execute(externalSyntheticLambda0);
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String provider, int status, Bundle extras) {
            if (this.mKey == null) {
            }
            LocationManagerCompat.LocationListenerTransport$$ExternalSyntheticLambda5 externalSyntheticLambda5 = new LocationManagerCompat.LocationListenerTransport$$ExternalSyntheticLambda5(this, provider, status, extras);
            this.mExecutor.execute(externalSyntheticLambda5);
        }

        @Override // android.location.LocationListener
        public void unregister() {
            this.mKey = 0;
        }
    }

    private static class PreRGnssStatusTransport extends GnssStatus.Callback {

        final androidx.core.location.GnssStatusCompat.Callback mCallback;
        volatile Executor mExecutor;
        PreRGnssStatusTransport(androidx.core.location.GnssStatusCompat.Callback callback) {
            int i;
            super();
            i = callback != null ? 1 : 0;
            Preconditions.checkArgument(i, "invalid null callback");
            this.mCallback = callback;
        }

        @Override // android.location.GnssStatus$Callback
        void lambda$onFirstFix$2$androidx-core-location-LocationManagerCompat$PreRGnssStatusTransport(Executor executor, int ttffMillis) {
            if (this.mExecutor != executor) {
            }
            this.mCallback.onFirstFix(ttffMillis);
        }

        @Override // android.location.GnssStatus$Callback
        void lambda$onSatelliteStatusChanged$3$androidx-core-location-LocationManagerCompat$PreRGnssStatusTransport(Executor executor, GnssStatus status) {
            if (this.mExecutor != executor) {
            }
            this.mCallback.onSatelliteStatusChanged(GnssStatusCompat.wrap(status));
        }

        @Override // android.location.GnssStatus$Callback
        void lambda$onStarted$0$androidx-core-location-LocationManagerCompat$PreRGnssStatusTransport(Executor executor) {
            if (this.mExecutor != executor) {
            }
            this.mCallback.onStarted();
        }

        @Override // android.location.GnssStatus$Callback
        void lambda$onStopped$1$androidx-core-location-LocationManagerCompat$PreRGnssStatusTransport(Executor executor) {
            if (this.mExecutor != executor) {
            }
            this.mCallback.onStopped();
        }

        @Override // android.location.GnssStatus$Callback
        public void onFirstFix(int ttffMillis) {
            final Executor mExecutor = this.mExecutor;
            if (mExecutor == null) {
            }
            LocationManagerCompat.PreRGnssStatusTransport$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new LocationManagerCompat.PreRGnssStatusTransport$$ExternalSyntheticLambda0(this, mExecutor, ttffMillis);
            mExecutor.execute(externalSyntheticLambda0);
        }

        @Override // android.location.GnssStatus$Callback
        public void onSatelliteStatusChanged(GnssStatus status) {
            final Executor mExecutor = this.mExecutor;
            if (mExecutor == null) {
            }
            LocationManagerCompat.PreRGnssStatusTransport$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new LocationManagerCompat.PreRGnssStatusTransport$$ExternalSyntheticLambda1(this, mExecutor, status);
            mExecutor.execute(externalSyntheticLambda1);
        }

        @Override // android.location.GnssStatus$Callback
        public void onStarted() {
            final Executor mExecutor = this.mExecutor;
            if (mExecutor == null) {
            }
            LocationManagerCompat.PreRGnssStatusTransport$$ExternalSyntheticLambda3 externalSyntheticLambda3 = new LocationManagerCompat.PreRGnssStatusTransport$$ExternalSyntheticLambda3(this, mExecutor);
            mExecutor.execute(externalSyntheticLambda3);
        }

        @Override // android.location.GnssStatus$Callback
        public void onStopped() {
            final Executor mExecutor = this.mExecutor;
            if (mExecutor == null) {
            }
            LocationManagerCompat.PreRGnssStatusTransport$$ExternalSyntheticLambda2 externalSyntheticLambda2 = new LocationManagerCompat.PreRGnssStatusTransport$$ExternalSyntheticLambda2(this, mExecutor);
            mExecutor.execute(externalSyntheticLambda2);
        }

        @Override // android.location.GnssStatus$Callback
        public void register(Executor executor) {
            int i2;
            int i;
            final int i3 = 0;
            i = executor != null ? i2 : i3;
            Preconditions.checkArgument(i, "invalid null executor");
            if (this.mExecutor == null) {
            } else {
                i2 = i3;
            }
            Preconditions.checkState(i2);
            this.mExecutor = executor;
        }

        @Override // android.location.GnssStatus$Callback
        public void unregister() {
            this.mExecutor = 0;
        }
    }
    static {
        WeakHashMap weakHashMap = new WeakHashMap();
        LocationManagerCompat.sLocationListeners = weakHashMap;
    }

    public static void getCurrentLocation(LocationManager locationManager, String provider, CancellationSignal cancellationSignal, Executor executor, Consumer<Location> consumer5) {
        int i;
        int cmp;
        Object obj9;
        if (Build.VERSION.SDK_INT >= 30) {
            LocationManagerCompat.Api30Impl.getCurrentLocation(locationManager, provider, cancellationSignal, executor, consumer5);
        }
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        Location lastKnownLocation = locationManager.getLastKnownLocation(provider);
        if (lastKnownLocation != null && Long.compare(i, i2) < 0) {
            if (Long.compare(i, i2) < 0) {
                LocationManagerCompat$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new LocationManagerCompat$$ExternalSyntheticLambda0(consumer5, lastKnownLocation);
                executor.execute(externalSyntheticLambda0);
            }
        }
        LocationManagerCompat.CancellableLocationListener locationAgeMs = new LocationManagerCompat.CancellableLocationListener(locationManager, executor, consumer5);
        final androidx.core.location.LocationManagerCompat.CancellableLocationListener list = locationAgeMs;
        locationManager.requestLocationUpdates(provider, 0, obj5, 0, list);
        if (cancellationSignal != null) {
            Objects.requireNonNull(list);
            obj9 = new LocationManagerCompat$$ExternalSyntheticLambda1(list);
            cancellationSignal.setOnCancelListener(obj9);
        }
        list.startTimeout(30000);
    }

    @Deprecated
    public static void getCurrentLocation(LocationManager locationManager, String provider, CancellationSignal cancellationSignal, Executor executor, Consumer<Location> consumer5) {
        Object cancellationSignalObject;
        if (cancellationSignal != null) {
            cancellationSignalObject = cancellationSignal.getCancellationSignalObject();
        } else {
            cancellationSignalObject = 0;
        }
        LocationManagerCompat.getCurrentLocation(locationManager, provider, cancellationSignalObject, executor, consumer5);
    }

    public static String getGnssHardwareModelName(LocationManager locationManager) {
        return LocationManagerCompat.Api28Impl.getGnssHardwareModelName(locationManager);
    }

    public static int getGnssYearOfHardware(LocationManager locationManager) {
        return LocationManagerCompat.Api28Impl.getGnssYearOfHardware(locationManager);
    }

    public static boolean hasProvider(LocationManager locationManager, String provider) {
        int i;
        if (Build.VERSION.SDK_INT >= 31) {
            return LocationManagerCompat.Api31Impl.hasProvider(locationManager, provider);
        }
        if (locationManager.getAllProviders().contains(provider)) {
            return 1;
        }
        if (locationManager.getProvider(provider) != null) {
        } else {
            i = i2;
        }
        return i;
    }

    public static boolean isLocationEnabled(LocationManager locationManager) {
        return LocationManagerCompat.Api28Impl.isLocationEnabled(locationManager);
    }

    static void lambda$getCurrentLocation$0(Consumer consumer, Location location) {
        consumer.accept(location);
    }

    static Boolean lambda$registerGnssStatusCallback$1(LocationManager locationManager, androidx.core.location.LocationManagerCompat.GpsStatusTransport myTransport) throws Exception {
        return Boolean.valueOf(locationManager.addGpsStatusListener(myTransport));
    }

    public static boolean registerGnssMeasurementsCallback(LocationManager locationManager, GnssMeasurementsEvent.Callback callback, Handler handler) {
        int i3 = 30;
        if (Build.VERSION.SDK_INT > i3) {
            return LocationManagerCompat.Api24Impl.registerGnssMeasurementsCallback(locationManager, callback, handler);
        }
        if (Build.VERSION.SDK_INT == i3) {
            return LocationManagerCompat.registerGnssMeasurementsCallbackOnR(locationManager, ExecutorCompat.create(handler), callback);
        }
        SimpleArrayMap sGnssMeasurementListeners = LocationManagerCompat.GnssListenersHolder.sGnssMeasurementListeners;
        LocationManagerCompat.unregisterGnssMeasurementsCallback(locationManager, callback);
        synchronized (sGnssMeasurementListeners) {
            LocationManagerCompat.GnssListenersHolder.sGnssMeasurementListeners.put(callback, callback);
            return 1;
        }
    }

    public static boolean registerGnssMeasurementsCallback(LocationManager locationManager, Executor executor, GnssMeasurementsEvent.Callback callback) {
        int i3 = 30;
        if (Build.VERSION.SDK_INT > i3) {
            return LocationManagerCompat.Api31Impl.registerGnssMeasurementsCallback(locationManager, executor, callback);
        }
        if (Build.VERSION.SDK_INT == i3) {
            return LocationManagerCompat.registerGnssMeasurementsCallbackOnR(locationManager, executor, callback);
        }
        SimpleArrayMap sGnssMeasurementListeners = LocationManagerCompat.GnssListenersHolder.sGnssMeasurementListeners;
        LocationManagerCompat.GnssMeasurementsTransport gnssMeasurementsTransport = new LocationManagerCompat.GnssMeasurementsTransport(callback, executor);
        LocationManagerCompat.unregisterGnssMeasurementsCallback(locationManager, callback);
        synchronized (sGnssMeasurementListeners) {
            LocationManagerCompat.GnssListenersHolder.sGnssMeasurementListeners.put(callback, gnssMeasurementsTransport);
            return 1;
        }
    }

    private static boolean registerGnssMeasurementsCallbackOnR(LocationManager locationManager, Executor executor, GnssMeasurementsEvent.Callback callback) {
        int i;
        Class sGnssRequestBuilderClass;
        Method sGnssRequestBuilderBuildMethod;
        Method sRegisterGnssMeasurementsCallbackMethod;
        String str;
        Object[] booleanValue;
        Class[] arr;
        Class<GnssMeasurementsEvent.Callback> obj;
        int i2;
        if (Build.VERSION.SDK_INT != 30) {
        } else {
            i = 0;
            if (LocationManagerCompat.sGnssRequestBuilderClass == null) {
                LocationManagerCompat.sGnssRequestBuilderClass = Class.forName("android.location.GnssRequest$Builder");
            }
            final int i4 = 1;
            if (LocationManagerCompat.sGnssRequestBuilderBuildMethod == null) {
                LocationManagerCompat.sGnssRequestBuilderBuildMethod = LocationManagerCompat.sGnssRequestBuilderClass.getDeclaredMethod("build", new Class[i]);
                LocationManagerCompat.sGnssRequestBuilderBuildMethod.setAccessible(i4);
            }
            if (LocationManagerCompat.sRegisterGnssMeasurementsCallbackMethod == null) {
                arr = new Class[3];
                arr[i] = Class.forName("android.location.GnssRequest");
                arr[i4] = Executor.class;
                arr[2] = GnssMeasurementsEvent.Callback.class;
                LocationManagerCompat.sRegisterGnssMeasurementsCallbackMethod = LocationManager.class.getDeclaredMethod("registerGnssMeasurementsCallback", arr);
                LocationManagerCompat.sRegisterGnssMeasurementsCallbackMethod.setAccessible(i4);
            }
            try {
                Object invoke = LocationManagerCompat.sRegisterGnssMeasurementsCallbackMethod.invoke(locationManager, /* result */);
                if (invoke != null && (Boolean)invoke.booleanValue()) {
                }
                if ((Boolean)invoke.booleanValue()) {
                }
                i = i4;
                return i;
                return obj0;
                IllegalStateException illegalStateException = new IllegalStateException();
                throw illegalStateException;
            }
        }
    }

    private static boolean registerGnssStatusCallback(LocationManager locationManager, Handler baseHandler, Executor executor, androidx.core.location.GnssStatusCompat.Callback callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            return LocationManagerCompat.Api30Impl.registerGnssStatusCallback(locationManager, baseHandler, executor, callback);
        }
        return LocationManagerCompat.Api24Impl.registerGnssStatusCallback(locationManager, baseHandler, executor, callback);
    }

    public static boolean registerGnssStatusCallback(LocationManager locationManager, androidx.core.location.GnssStatusCompat.Callback callback, Handler handler) {
        if (Build.VERSION.SDK_INT >= 30) {
            return LocationManagerCompat.registerGnssStatusCallback(locationManager, ExecutorCompat.create(handler), callback);
        }
        LocationManagerCompat.InlineHandlerExecutor inlineHandlerExecutor = new LocationManagerCompat.InlineHandlerExecutor(handler);
        return LocationManagerCompat.registerGnssStatusCallback(locationManager, inlineHandlerExecutor, callback);
    }

    public static boolean registerGnssStatusCallback(LocationManager locationManager, Executor executor, androidx.core.location.GnssStatusCompat.Callback callback) {
        Looper looper;
        if (Build.VERSION.SDK_INT >= 30) {
            return LocationManagerCompat.registerGnssStatusCallback(locationManager, 0, executor, callback);
        }
        if (Looper.myLooper() == null) {
            looper = Looper.getMainLooper();
        }
        Handler handler = new Handler(looper);
        return LocationManagerCompat.registerGnssStatusCallback(locationManager, handler, executor, callback);
    }

    static void registerLocationListenerTransport(LocationManager locationManager, androidx.core.location.LocationManagerCompat.LocationListenerTransport transport) {
        Object obj;
        WeakReference weakReference = new WeakReference(transport);
        Object obj2 = LocationManagerCompat.sLocationListeners.put(transport.getKey(), weakReference);
        if ((WeakReference)obj2 != null) {
            obj = (WeakReference)obj2.get();
        } else {
            obj = 0;
        }
        if (obj != null) {
            obj.unregister();
            locationManager.removeUpdates(obj);
        }
    }

    public static void removeUpdates(LocationManager locationManager, androidx.core.location.LocationListenerCompat listener) {
        int cleanup;
        Iterator iterator;
        Object next2;
        boolean next;
        Object sLocationListeners;
        androidx.core.location.LocationManagerCompat.LocationListenerKey key;
        androidx.core.location.LocationListenerCompat mListener;
        final WeakHashMap sLocationListeners2 = LocationManagerCompat.sLocationListeners;
        cleanup = 0;
        iterator = LocationManagerCompat.sLocationListeners.values().iterator();
        synchronized (sLocationListeners2) {
            while (iterator.hasNext()) {
                sLocationListeners = (WeakReference)iterator.next().get();
                if ((LocationManagerCompat.LocationListenerTransport)sLocationListeners == null) {
                } else {
                }
                key = (LocationManagerCompat.LocationListenerTransport)sLocationListeners.getKey();
                if (key.mListener == listener && cleanup == 0) {
                }
                if (cleanup == 0) {
                }
                cleanup.add(key);
                sLocationListeners.unregister();
                locationManager.removeUpdates(sLocationListeners);
                mListener = new ArrayList();
                cleanup = mListener;
            }
            if (cleanup != 0) {
                iterator = cleanup.iterator();
                for (LocationManagerCompat.LocationListenerKey next : iterator) {
                    LocationManagerCompat.sLocationListeners.remove(next);
                }
            }
            locationManager.removeUpdates(listener);
        }
    }

    public static void requestLocationUpdates(LocationManager locationManager, String provider, androidx.core.location.LocationRequestCompat locationRequest, androidx.core.location.LocationListenerCompat listener, Looper looper) {
        if (Build.VERSION.SDK_INT >= 31) {
            Handler handler = new Handler(looper);
            LocationManagerCompat.Api31Impl.requestLocationUpdates(locationManager, provider, locationRequest.toLocationRequest(), ExecutorCompat.create(handler), listener);
        }
        if (LocationManagerCompat.Api19Impl.tryRequestLocationUpdates(locationManager, provider, locationRequest, listener, looper)) {
        }
        locationManager.requestLocationUpdates(provider, locationRequest.getIntervalMillis(), obj4, locationRequest.getMinUpdateDistanceMeters(), listener);
    }

    public static void requestLocationUpdates(LocationManager locationManager, String provider, androidx.core.location.LocationRequestCompat locationRequest, Executor executor, androidx.core.location.LocationListenerCompat listener) {
        int tryRequestLocationUpdates;
        LocationManager locationManager2;
        String str;
        if (Build.VERSION.SDK_INT >= 31) {
            LocationManagerCompat.Api31Impl.requestLocationUpdates(locationManager, provider, locationRequest.toLocationRequest(), executor, listener);
        }
        if (Build.VERSION.SDK_INT >= 30 && LocationManagerCompat.Api30Impl.tryRequestLocationUpdates(locationManager, provider, locationRequest, executor, listener)) {
            if (LocationManagerCompat.Api30Impl.tryRequestLocationUpdates(locationManager, provider, locationRequest, executor, listener)) {
            }
        }
        LocationManagerCompat.LocationListenerKey locationListenerKey = new LocationManagerCompat.LocationListenerKey(provider, listener);
        LocationManagerCompat.LocationListenerTransport locationListenerTransport = new LocationManagerCompat.LocationListenerTransport(locationListenerKey, executor);
        final androidx.core.location.LocationManagerCompat.LocationListenerTransport list = locationListenerTransport;
        if (LocationManagerCompat.Api19Impl.tryRequestLocationUpdates(locationManager, provider, locationRequest, list)) {
        }
        WeakHashMap sLocationListeners = LocationManagerCompat.sLocationListeners;
        final LocationManager locationManager3 = locationManager;
        locationManager3.requestLocationUpdates(provider, locationRequest.getIntervalMillis(), obj5, locationRequest.getMinUpdateDistanceMeters(), list);
        LocationManagerCompat.registerLocationListenerTransport(locationManager3, list);
        return;
        synchronized (sLocationListeners) {
            sLocationListeners = LocationManagerCompat.sLocationListeners;
            locationManager3 = locationManager;
            locationManager3.requestLocationUpdates(provider, locationRequest.getIntervalMillis(), obj5, locationRequest.getMinUpdateDistanceMeters(), list);
            LocationManagerCompat.registerLocationListenerTransport(locationManager3, list);
        }
    }

    public static void unregisterGnssMeasurementsCallback(LocationManager locationManager, GnssMeasurementsEvent.Callback callback) {
        SimpleArrayMap sGnssMeasurementListeners;
        Object remove;
        boolean z;
        if (Build.VERSION.SDK_INT >= 30) {
            LocationManagerCompat.Api24Impl.unregisterGnssMeasurementsCallback(locationManager, callback);
        } else {
            sGnssMeasurementListeners = LocationManagerCompat.GnssListenersHolder.sGnssMeasurementListeners;
            remove = LocationManagerCompat.GnssListenersHolder.sGnssMeasurementListeners.remove(callback);
            synchronized (sGnssMeasurementListeners) {
                if (remove instanceof LocationManagerCompat.GnssMeasurementsTransport) {
                    (LocationManagerCompat.GnssMeasurementsTransport)(GnssMeasurementsEvent.Callback)remove.unregister();
                }
                LocationManagerCompat.Api24Impl.unregisterGnssMeasurementsCallback(locationManager, remove);
            }
        }
    }

    public static void unregisterGnssStatusCallback(LocationManager locationManager, androidx.core.location.GnssStatusCompat.Callback callback) {
        final SimpleArrayMap sGnssStatusListeners = LocationManagerCompat.GnssListenersHolder.sGnssStatusListeners;
        Object remove = LocationManagerCompat.GnssListenersHolder.sGnssStatusListeners.remove(callback);
        synchronized (sGnssStatusListeners) {
            LocationManagerCompat.Api24Impl.unregisterGnssStatusCallback(locationManager, remove);
        }
    }
}
