package androidx.compose.animation.core;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\t\u0008\u0001\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J8\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001cJ \u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0003J\u0018\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001cH\u0002J8\u0010 \u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J#\u0010!\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001cH\u0002¢\u0006\u0002\u0010$R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006%", d2 = {"Landroidx/compose/animation/core/MonoSpline;", "", "time", "", "y", "", "periodicBias", "", "([F[[FF)V", "isExtrapolate", "", "slopeTemp", "tangents", "[[F", "timePoints", "values", "diff", "h", "x", "y1", "y2", "t1", "t2", "getPos", "", "v", "Landroidx/compose/animation/core/AnimationVector;", "index", "", "t", "j", "getSlope", "interpolate", "makeFloatArray", "a", "b", "(II)[[F", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MonoSpline {

    public static final int $stable = 8;
    private final boolean isExtrapolate;
    private final float[] slopeTemp;
    private final float[][] tangents;
    private final float[] timePoints;
    private final float[][] values;
    static {
        final int i = 8;
    }

    public MonoSpline(float[] time, float[][] y, float periodicBias) {
        int i3;
        int length;
        int j4;
        int j2;
        int j3;
        float[] fArr2;
        int i2;
        float j;
        int i;
        int i5;
        float[] fArr;
        int i4;
        int i6;
        int n;
        long l;
        final Object obj = this;
        final float[] fArr3 = time;
        final float[][] arr = y;
        super();
        i3 = 1;
        obj.isExtrapolate = i3;
        length = fArr3.length;
        final int i8 = 0;
        int length2 = obj2.length;
        obj.slopeTemp = new float[length2];
        float[][] floatArray = obj.makeFloatArray(length + -1, length2);
        final float[][] floatArray2 = obj.makeFloatArray(length, length2);
        j4 = 0;
        while (j4 < length2) {
            i2 = 0;
            while (i2 < length + -1) {
                floatArray[i2][j4] = i28 /= i;
                if (i2 == 0) {
                } else {
                }
                floatArray2[i2][j4] = i31 *= i6;
                i2++;
                floatArray2[i2][j4] = floatArray[i2][j4];
            }
            floatArray2[length + -1][j4] = floatArray[length + -2][j4];
            j4++;
            floatArray[i2][j4] = i28 /= i;
            if (i2 == 0) {
            } else {
            }
            floatArray2[i2][j4] = i31 *= i6;
            i2++;
            floatArray2[i2][j4] = floatArray[i2][j4];
        }
        if (!Float.isNaN(periodicBias)) {
            j2 = 0;
            while (j2 < length2) {
                i11 += i15;
                floatArray[i8][j2] = fArr2;
                floatArray[length + -2][j2] = fArr2;
                floatArray2[length + -1][j2] = fArr2;
                floatArray2[i8][j2] = fArr2;
                j2++;
            }
        }
        j3 = 0;
        while (j3 < length + -1) {
            j = 0;
            while (j < length2) {
                fArr = 0;
                if (Float.compare(f4, fArr) == 0) {
                } else {
                }
                i5 = i8;
                if (i5 != 0) {
                } else {
                }
                f5 /= f6;
                f7 /= f8;
                n = length;
                i3 = (float)hypot;
                if (Double.compare(i4, l) > 0) {
                }
                j++;
                length = n;
                i3 = 1;
                i7 /= i3;
                floatArray2[j3][j] = i32 *= f11;
                floatArray2[j3 + 1][j] = i34 *= l;
                floatArray2[j3][j] = fArr;
                floatArray2[j3 + 1][j] = fArr;
                n = length;
                i5 = i3;
            }
            n = length;
            j3++;
            i3 = 1;
            fArr = 0;
            if (Float.compare(f4, fArr) == 0) {
            } else {
            }
            i5 = i8;
            if (i5 != 0) {
            } else {
            }
            f5 /= f6;
            f7 /= f8;
            n = length;
            i3 = (float)hypot;
            if (Double.compare(i4, l) > 0) {
            }
            j++;
            length = n;
            i3 = 1;
            i7 /= i3;
            floatArray2[j3][j] = i32 *= f11;
            floatArray2[j3 + 1][j] = i34 *= l;
            floatArray2[j3][j] = fArr;
            floatArray2[j3 + 1][j] = fArr;
            n = length;
            i5 = i3;
        }
        obj.timePoints = fArr3;
        obj.values = arr;
        obj.tangents = floatArray2;
    }

    private final float diff(float h, float x, float y1, float y2, float t1, float t2) {
        final int i = x * x;
        float f2 = (float)i13;
        float f3 = (float)i16;
        return i11 += i28;
    }

    public static void getPos$default(androidx.compose.animation.core.MonoSpline monoSpline, float f2, androidx.compose.animation.core.AnimationVector animationVector3, int i4, int i5, Object object6) {
        int obj3;
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        monoSpline.getPos(f2, animationVector3, obj3);
    }

    private final float getSlope(float time, int j) {
        float t;
        int timePoints;
        int i3;
        int i2;
        int cmp;
        int i;
        t = time;
        int length = timePoints2.length;
        i2 = 0;
        if (Float.compare(t, f) < 0) {
            t = this.timePoints[i2];
        } else {
            if (Float.compare(t, f2) >= 0) {
                t = this.timePoints[length + -1];
            }
        }
        i3 = 0;
        while (i3 < length + -1) {
            i3++;
        }
        return 0;
    }

    public static void getSlope$default(androidx.compose.animation.core.MonoSpline monoSpline, float f2, androidx.compose.animation.core.AnimationVector animationVector3, int i4, int i5, Object object6) {
        int obj3;
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        monoSpline.getSlope(f2, animationVector3, obj3);
    }

    private final float interpolate(float h, float x, float y1, float y2, float t1, float t2) {
        final int i = x * x;
        final int i2 = i * x;
        float f2 = (float)i15;
        float f3 = (float)i28;
        return i13 += i25;
    }

    private final float[][] makeFloatArray(int a, int b) {
        int i;
        float[] fArr;
        final float[][] fArr2 = new float[a];
        i = 0;
        while (i < a) {
            fArr2[i] = new float[b];
            i++;
        }
        return fArr2;
    }

    public final float getPos(float t, int j) {
        int cmp;
        int i;
        int i2;
        int cmp2;
        int i3;
        int i4;
        int length = timePoints.length;
        int i8 = 0;
        if (this.isExtrapolate) {
            if (Float.compare(t, f) <= 0) {
                return f4 += i20;
            }
            if (Float.compare(t, f2) >= 0) {
                return f3 += i12;
            }
        } else {
            if (Float.compare(t, f5) <= 0) {
                return this.values[i8][j];
            }
            if (Float.compare(t, f7) >= 0) {
                return this.values[length + -1][j];
            }
        }
        i = 0;
        while (i < length + -1) {
            if (Float.compare(t, f17) == 0) {
            } else {
            }
            i3 = i8;
            i++;
            i3 = 1;
        }
        return 0;
    }

    public final void getPos(float time, androidx.compose.animation.core.AnimationVector v, int index) {
        int j5;
        int j4;
        int j2;
        int cmp;
        int i2;
        int j;
        float[] slopeTemp;
        int j6;
        int i;
        float interpolate;
        float f3;
        float[] slopeTemp2;
        int cmp2;
        int j3;
        int i3;
        float f4;
        float f5;
        float f;
        float f2;
        int length = timePoints.length;
        int i4 = 0;
        int length2 = fArr.length;
        if (this.isExtrapolate) {
            if (Float.compare(time, f11) <= 0) {
                getSlope(this.timePoints[i4], this.slopeTemp);
                j6 = 0;
                while (j6 < length2) {
                    v.set$animation_core_release(j6, f16 += cmp2);
                    j6++;
                }
            }
            if (Float.compare(time, f12) >= 0) {
                getSlope(this.timePoints[length + -1], this.slopeTemp);
                j2 = 0;
                while (j2 < length2) {
                    v.set$animation_core_release(j2, f13 += i);
                    j2++;
                }
            }
        } else {
            if (Float.compare(time, f9) <= 0) {
                j = 0;
                while (j < length2) {
                    v.set$animation_core_release(j, this.values[i4][j]);
                    j++;
                }
            }
            if (Float.compare(time, f10) >= 0) {
                j4 = 0;
                while (j4 < length2) {
                    v.set$animation_core_release(j4, this.values[length + -1][j4]);
                    j4++;
                }
            }
        }
        i2 = index;
        while (i2 < length + -1) {
            if (Float.compare(time, f17) == 0) {
            } else {
            }
            j3 = i4;
            if (j3 != 0) {
            }
            if (Float.compare(time, f18) < 0) {
                break;
            } else {
            }
            i2++;
            j3 = 0;
            while (j3 < length2) {
                v.set$animation_core_release(j3, this.values[i2][j3]);
                j3++;
            }
            v.set$animation_core_release(j3, this.values[i2][j3]);
            j3++;
            j3 = 1;
        }
    }

    public final void getSlope(float time, androidx.compose.animation.core.AnimationVector v, int index) {
        int j3;
        int i4;
        int j2;
        int i3;
        int j;
        float cmp;
        int i2;
        int i5;
        int i;
        float f;
        float f2;
        float f3;
        float f4;
        final Object obj = v;
        final float f5 = time;
        int length = timePoints.length;
        int i6 = 0;
        int length2 = fArr.length;
        if (Float.compare(f5, f7) <= 0) {
            j2 = 0;
            while (j2 < length2) {
                obj.set$animation_core_release(j2, this.tangents[i6][j2]);
                j2++;
            }
        }
        if (Float.compare(f5, f6) >= 0) {
            j3 = 0;
            while (j3 < length2) {
                obj.set$animation_core_release(j3, this.tangents[length + -1][j3]);
                j3++;
            }
        }
        i4 = index;
        while (i4 < length + -1) {
            if (Float.compare(f5, f10) <= 0) {
                break;
            } else {
            }
            i4++;
        }
    }

    public final void getSlope(float time, float[] v) {
        float t;
        int timePoints2;
        int i3;
        int timePoints;
        int j;
        int cmp;
        int i2;
        int i;
        int i4;
        float f;
        float f2;
        float f3;
        float f4;
        t = time;
        int length = timePoints3.length;
        timePoints2 = 0;
        if (Float.compare(t, f6) <= 0) {
            t = this.timePoints[timePoints2];
        } else {
            if (Float.compare(t, f5) >= 0) {
                t = this.timePoints[length + -1];
            }
        }
        i3 = 0;
        while (i3 < length + -1) {
            if (Float.compare(t, f9) <= 0) {
                break;
            } else {
            }
            i3++;
        }
    }
}
