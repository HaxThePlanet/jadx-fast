package com.appsflyer.internal;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class v implements SensorEventListener {

    long AFInAppEventParameterName;
    private final int AFInAppEventType;
    double AFKeystoreWrapper;
    private final Executor AFLogger$LogLevel;
    private final String AFVersionDeclaration;
    private final int AppsFlyer2dXConversionCallback;
    private final String init;
    final float[][] valueOf;
    final long[] values;
    v(Sensor sensor, Executor executor2) {
        String name;
        String str;
        super();
        int i = 2;
        this.valueOf = new float[i];
        this.values = new long[i];
        this.AFLogger$LogLevel = executor2;
        int obj4 = sensor.getType();
        this.AFInAppEventType = obj4;
        name = sensor.getName() == null ? str : name;
        this.AFVersionDeclaration = name;
        String obj3 = sensor.getVendor();
        if (obj3 == null) {
        } else {
            str = obj3;
        }
        this.init = str;
        this.AppsFlyer2dXConversionCallback = obj4 += obj3;
    }

    private boolean AFInAppEventParameterName() {
        final int i2 = 0;
        if (this.valueOf[i2] != null) {
            return 1;
        }
        return i2;
    }

    static double AFKeystoreWrapper(float[] fArr, float[] f2Arr2) {
        int i;
        int i3;
        double d;
        int i2;
        long l;
        i = 0;
        i3 = 0;
        while (i3 < Math.min(fArr.length, f2Arr2.length)) {
            i2 = f2Arr2[i3];
            i += d;
            i3++;
        }
        return Math.sqrt(i);
    }

    private static List<Float> AFKeystoreWrapper(float[] fArr) {
        int i;
        Float valueOf;
        ArrayList arrayList = new ArrayList(fArr.length);
        i = 0;
        while (i < fArr.length) {
            arrayList.add(Float.valueOf(fArr[i]));
            i++;
        }
        return arrayList;
    }

    private Map<String, Object> AFKeystoreWrapper() {
        float[] fArr;
        float[] fArr2;
        int str2;
        int str;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(7);
        concurrentHashMap.put("sT", Integer.valueOf(this.AFInAppEventType));
        concurrentHashMap.put("sN", this.AFVersionDeclaration);
        concurrentHashMap.put("sV", this.init);
        fArr = this.valueOf[0];
        if (fArr != null) {
            concurrentHashMap.put("sVS", v.AFKeystoreWrapper(fArr));
        }
        fArr2 = this.valueOf[1];
        if (fArr2 != null) {
            concurrentHashMap.put("sVE", v.AFKeystoreWrapper(fArr2));
        }
        return concurrentHashMap;
    }

    private boolean values(int i, String string2, String string3) {
        int obj2;
        if (this.AFInAppEventType == i && this.AFVersionDeclaration.equals(string2) && this.init.equals(string3)) {
            if (this.AFVersionDeclaration.equals(string2)) {
                if (this.init.equals(string3)) {
                    return 1;
                }
            }
        }
        return 0;
    }

    @Override // android.hardware.SensorEventListener
    public final boolean equals(Object object) {
        if (object == this) {
            return 1;
        }
        if (object instanceof v) {
            return values(object.AFInAppEventType, object.AFVersionDeclaration, object.init);
        }
        return 0;
    }

    @Override // android.hardware.SensorEventListener
    public final int hashCode() {
        return this.AppsFlyer2dXConversionCallback;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        v.4 anon = new v.4(this, sensorEvent.values, sensorEvent.timestamp, obj1);
        this.AFLogger$LogLevel.execute(anon);
    }

    final void valueOf(Map<com.appsflyer.internal.v, Map<String, Object>> map, boolean z2) {
        boolean z;
        int i;
        float[][] valueOf;
        int values;
        boolean obj5;
        if (AFInAppEventParameterName()) {
            map.put(this, AFKeystoreWrapper());
            if (z2) {
                i = obj5;
                while (i < obj4.length) {
                    this.valueOf[i] = 0;
                    i++;
                }
                i = 0;
                while (obj5 < obj4.length) {
                    this.values[obj5] = i;
                    obj5++;
                    i = 0;
                }
                this.AFKeystoreWrapper = 0;
                this.AFInAppEventParameterName = i;
            }
        } else {
            if (!map.containsKey(this)) {
                map.put(this, AFKeystoreWrapper());
            }
        }
    }
}
