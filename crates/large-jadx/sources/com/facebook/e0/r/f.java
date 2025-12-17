package com.facebook.e0.r;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.facebook.internal.g0.i.a;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0001\u0018\u0000 \u00102\u00020\u0001:\u0002\u0010\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"Lcom/facebook/appevents/codeless/ViewIndexingTrigger;", "Landroid/hardware/SensorEventListener;", "()V", "onShakeListener", "Lcom/facebook/appevents/codeless/ViewIndexingTrigger$OnShakeListener;", "onAccuracyChanged", "", "sensor", "Landroid/hardware/Sensor;", "accuracy", "", "onSensorChanged", "event", "Landroid/hardware/SensorEvent;", "setOnShakeListener", "listener", "Companion", "OnShakeListener", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class f implements SensorEventListener {

    private com.facebook.e0.r.f.a a;

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\u0008æ\u0080\u0001\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004", d2 = {"Lcom/facebook/appevents/codeless/ViewIndexingTrigger$OnShakeListener;", "", "onShake", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface a {
        public abstract void a();
    }
    static {
    }

    @Override // android.hardware.SensorEventListener
    public final void a(com.facebook.e0.r.f.a f$a) {
        if (a.d(this)) {
        }
        this.a = a;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
        if (a.d(this)) {
        }
        n.f(sensor, "sensor");
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        double sqrt;
        int i2;
        long l;
        int i3;
        int i;
        Object obj9;
        if (a.d(this)) {
        }
        n.f(sensorEvent, "event");
        com.facebook.e0.r.f.a aVar = this.a;
        obj9 = sensorEvent.values;
        int i9 = 1092413450;
        double d2 = (double)i5;
        double d = (double)i2;
        double d3 = (double)obj9;
        if (aVar != null && Double.compare(sqrt, l) > 0) {
            obj9 = sensorEvent.values;
            i9 = 1092413450;
            d2 = (double)i5;
            d = (double)i2;
            d3 = (double)obj9;
            if (Double.compare(sqrt, l) > 0) {
                aVar.a();
            }
        }
    }
}
