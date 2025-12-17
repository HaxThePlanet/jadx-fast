package com.google.android.exoplayer2.video.b0;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;

/* loaded from: classes2.dex */
final class g implements SensorEventListener {

    private final float[] a;
    private final float[] b;
    private final float[] c;
    private final float[] d;
    private final Display e;
    private final com.google.android.exoplayer2.video.b0.g.a[] f;
    private boolean g;

    public interface a {
        public abstract void a(float[] fArr, float f2);
    }
    public g(Display display, com.google.android.exoplayer2.video.b0.g.a... g$a2Arr2) {
        super();
        int i = 16;
        this.a = new float[i];
        this.b = new float[i];
        this.c = new float[i];
        this.d = new float[3];
        this.e = display;
        this.f = a2Arr2;
    }

    private float a(float[] fArr) {
        SensorManager.remapCoordinateSystem(fArr, 1, 131, this.b);
        SensorManager.getOrientation(this.b, this.d);
        return this.d[2];
    }

    private void b(float[] fArr, float f2) {
        int i;
        com.google.android.exoplayer2.video.b0.g.a aVar;
        final com.google.android.exoplayer2.video.b0.g.a[] objArr = this.f;
        i = 0;
        while (i < objArr.length) {
            objArr[i].a(fArr, f2);
            i++;
        }
    }

    private void c(float[] fArr) {
        boolean z;
        if (!this.g) {
            f.a(this.c, fArr);
            this.g = true;
        }
        float[] fArr2 = this.b;
        final int i = 0;
        System.arraycopy(fArr, i, fArr2, i, fArr2.length);
        Matrix.multiplyMM(fArr, 0, this.b, 0, this.c, 0);
    }

    private void d(float[] fArr, int i2) {
        int i4;
        int i3;
        int length;
        int i5;
        int i;
        int obj7;
        if (i2 != 0) {
            int i7 = 2;
            int i8 = 1;
            if (i2 != i8) {
                if (i2 != i7) {
                    if (i2 != 3) {
                    } else {
                        i3 = i8;
                    }
                    IllegalStateException obj6 = new IllegalStateException();
                    throw obj6;
                }
                i3 = i4;
                i4 = i;
            } else {
                i4 = i7;
            }
            obj7 = this.b;
            i5 = 0;
            System.arraycopy(fArr, i5, obj7, i5, obj7.length);
            SensorManager.remapCoordinateSystem(this.b, i4, i3, fArr);
        }
    }

    private static void e(float[] fArr) {
        Matrix.rotateM(fArr, 0, 1119092736, 1065353216, 0, 0);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        SensorManager.getRotationMatrixFromVector(this.a, sensorEvent.values);
        d(this.a, this.e.getRotation());
        g.e(this.a);
        c(this.a);
        b(this.a, a(this.a));
    }
}
