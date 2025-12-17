package app.dogo.com.dogo_android.util.customview.shimmer;

import android.content.res.TypedArray;
import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.e0.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0015\n\u0002\u0008\u0007\n\u0002\u0010\u0007\n\u0002\u0008\u0014\n\u0002\u0010\u0014\n\u0002\u0008\u001a\n\u0002\u0010\u0002\n\u0002\u0008\u000c\u0018\u0000 a2\u00020\u0001:\u0006^_`abcB\u0007\u0008\u0000¢\u0006\u0002\u0010\u0002J\u000e\u0010V\u001a\u00020\u00132\u0006\u0010V\u001a\u00020\u0013J\u0016\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u00132\u0006\u0010Z\u001a\u00020\u0013J\u0006\u0010[\u001a\u00020XJ\u0006\u0010\\\u001a\u00020XJ\u000e\u0010]\u001a\u00020\u00132\u0006\u0010]\u001a\u00020\u0013R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0010\u0010\u0006\"\u0004\u0008\u0011\u0010\u0008R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001d\u0010\u0006\"\u0004\u0008\u001e\u0010\u0008R\u0011\u0010\u001f\u001a\u00020 ¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R \u0010#\u001a\u00020\u0013X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u0008$\u0010\u0002\u001a\u0004\u0008%\u0010\u0015\"\u0004\u0008&\u0010\u0017R\u001a\u0010'\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008)\u0010*\"\u0004\u0008+\u0010,R\u001a\u0010-\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008.\u0010\u0015\"\u0004\u0008/\u0010\u0017R\u001a\u00100\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00081\u0010\u0015\"\u0004\u00082\u0010\u0017R\u001a\u00103\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00084\u0010*\"\u0004\u00085\u0010,R\u001e\u00106\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00087\u0010\u0015\"\u0004\u00088\u0010\u0017R\u001a\u00109\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008:\u0010*\"\u0004\u0008;\u0010,R\u0011\u0010<\u001a\u00020=¢\u0006\u0008\n\u0000\u001a\u0004\u0008>\u0010?R\u001a\u0010@\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008A\u0010\u0015\"\u0004\u0008B\u0010\u0017R\u001a\u0010C\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008D\u0010\u000c\"\u0004\u0008E\u0010\u000eR\u001a\u0010F\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008G\u0010\u0015\"\u0004\u0008H\u0010\u0017R \u0010I\u001a\u00020\u0013X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u0008J\u0010\u0002\u001a\u0004\u0008K\u0010\u0015\"\u0004\u0008L\u0010\u0017R\u001a\u0010M\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008N\u0010\u000c\"\u0004\u0008O\u0010\u000eR\u001a\u0010P\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008Q\u0010*\"\u0004\u0008R\u0010,R\u001a\u0010S\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008T\u0010*\"\u0004\u0008U\u0010,¨\u0006d", d2 = {"Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer;", "", "()V", "alphaShimmer", "", "getAlphaShimmer", "()Z", "setAlphaShimmer", "(Z)V", "animationDuration", "", "getAnimationDuration", "()J", "setAnimationDuration", "(J)V", "autoStart", "getAutoStart", "setAutoStart", "baseColor", "", "getBaseColor", "()I", "setBaseColor", "(I)V", "bounds", "Landroid/graphics/RectF;", "getBounds", "()Landroid/graphics/RectF;", "clipToChildren", "getClipToChildren", "setClipToChildren", "colors", "", "getColors", "()[I", "direction", "getDirection$annotations", "getDirection", "setDirection", "dropoff", "", "getDropoff", "()F", "setDropoff", "(F)V", "fixedHeight", "getFixedHeight", "setFixedHeight", "fixedWidth", "getFixedWidth", "setFixedWidth", "heightRatio", "getHeightRatio", "setHeightRatio", "highlightColor", "getHighlightColor", "setHighlightColor", "intensity", "getIntensity", "setIntensity", "positions", "", "getPositions", "()[F", "repeatCount", "getRepeatCount", "setRepeatCount", "repeatDelay", "getRepeatDelay", "setRepeatDelay", "repeatMode", "getRepeatMode", "setRepeatMode", "shape", "getShape$annotations", "getShape", "setShape", "startDelay", "getStartDelay", "setStartDelay", "tilt", "getTilt", "setTilt", "widthRatio", "getWidthRatio", "setWidthRatio", "height", "updateBounds", "", "viewWidth", "viewHeight", "updateColors", "updatePositions", "width", "AlphaHighlightBuilder", "Builder", "ColorHighlightBuilder", "Companion", "Direction", "Shape", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class b {

    public static final app.dogo.com.dogo_android.util.customview.shimmer.b.d Companion;
    private final float[] a;
    private final int[] b;
    private int c;
    private int d = -1;
    private int e = 1291845631;
    private int f;
    private int g;
    private int h;
    private float i = 1f;
    private float j = 1f;
    private float k;
    private float l = 0.5f;
    private float m = 20f;
    private boolean n = true;
    private boolean o = true;
    private boolean p = true;
    private int q = -1;
    private int r = 1;
    private long s = 1000;
    private long t;
    private long u;

    @Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\u0018\u0008&\u0018\u0000 @*\u0010\u0008\u0000\u0010\u0001*\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u00002\u00020\u0002:\u0001@B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\u0005J\u001d\u0010\u000c\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\u0015\u0010\u000c\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u0005¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u001a¢\u0006\u0002\u0010\u001bJ\u0015\u0010\u001c\u001a\u00028\u00002\u0008\u0008\u0001\u0010\u001d\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u001a¢\u0006\u0002\u0010\u001bJ\u0013\u0010!\u001a\u00028\u00002\u0006\u0010\"\u001a\u00020#¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00028\u00002\u0006\u0010&\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ\u0013\u0010'\u001a\u00028\u00002\u0006\u0010(\u001a\u00020)¢\u0006\u0002\u0010*J\u0015\u0010+\u001a\u00028\u00002\u0008\u0008\u0001\u0010,\u001a\u00020#¢\u0006\u0002\u0010$J\u0015\u0010-\u001a\u00028\u00002\u0008\u0008\u0001\u0010.\u001a\u00020#¢\u0006\u0002\u0010$J\u0013\u0010/\u001a\u00028\u00002\u0006\u00100\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ\u0015\u00101\u001a\u00028\u00002\u0008\u0008\u0001\u0010\u001d\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ\u0013\u00102\u001a\u00028\u00002\u0006\u00103\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ\u0013\u00104\u001a\u00028\u00002\u0006\u00105\u001a\u00020#¢\u0006\u0002\u0010$J\u0013\u00106\u001a\u00028\u00002\u0006\u0010(\u001a\u00020)¢\u0006\u0002\u0010*J\u0013\u00107\u001a\u00028\u00002\u0006\u00108\u001a\u00020#¢\u0006\u0002\u0010$J\u0013\u00109\u001a\u00028\u00002\u0006\u0010:\u001a\u00020#¢\u0006\u0002\u0010$J\u0013\u0010;\u001a\u00028\u00002\u0006\u0010(\u001a\u00020)¢\u0006\u0002\u0010*J\u0013\u0010<\u001a\u00028\u00002\u0006\u0010=\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ\u0013\u0010>\u001a\u00028\u00002\u0006\u0010?\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0012\u0010\u0008\u001a\u00028\u0000X¤\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\n¨\u0006A", d2 = {"Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer$Builder;", "T", "", "()V", "mShimmer", "Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer;", "getMShimmer", "()Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer;", "this", "getThis", "()Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer$Builder;", "build", "consumeAttributes", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer$Builder;", "a", "Landroid/content/res/TypedArray;", "(Landroid/content/res/TypedArray;)Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer$Builder;", "copyFrom", "other", "(Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer;)Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer$Builder;", "setAutoStart", "status", "", "(Z)Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer$Builder;", "setBaseAlpha", "alpha", "", "(F)Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer$Builder;", "setClipToChildren", "setDirection", "direction", "", "(I)Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer$Builder;", "setDropoff", "dropoff", "setDuration", "millis", "", "(J)Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer$Builder;", "setFixedHeight", "fixedHeight", "setFixedWidth", "fixedWidth", "setHeightRatio", "heightRatio", "setHighlightAlpha", "setIntensity", "intensity", "setRepeatCount", "repeatCount", "setRepeatDelay", "setRepeatMode", "mode", "setShape", "shape", "setStartDelay", "setTilt", "tilt", "setWidthRatio", "widthRatio", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class b {

        public static final app.dogo.com.dogo_android.util.customview.shimmer.b.b.a Companion;
        private final app.dogo.com.dogo_android.util.customview.shimmer.b a;
        static {
            b.b.a aVar = new b.b.a(0);
            b.b.Companion = aVar;
        }

        public b() {
            super();
            b bVar = new b();
            this.a = bVar;
        }

        public final app.dogo.com.dogo_android.util.customview.shimmer.b a() {
            this.a.P();
            this.a.Q();
            return this.a;
        }

        public T b(TypedArray typedArray) {
            int int2;
            int float4;
            int dimensionPixelSize2;
            int dimensionPixelSize;
            int float5;
            int float3;
            int float2;
            boolean boolean;
            boolean value9;
            boolean value2;
            boolean value3;
            boolean value;
            boolean value7;
            boolean value10;
            boolean value15;
            boolean boolean2;
            boolean value14;
            int float;
            int i2;
            int int;
            int i;
            int int3;
            int i3;
            int int4;
            boolean value16;
            boolean value6;
            boolean value13;
            boolean value12;
            boolean value4;
            boolean value5;
            boolean value11;
            boolean value8;
            Object obj7;
            n.f(typedArray, "a");
            int i4 = 3;
            if (typedArray.hasValue(i4)) {
                g(typedArray.getBoolean(i4, this.a.e()));
            }
            int i6 = 0;
            if (typedArray.hasValue(i6)) {
                e(typedArray.getBoolean(i6, this.a.c()));
            }
            int i7 = 1;
            if (typedArray.hasValue(i7)) {
                f(typedArray.getFloat(i7, 1050253722));
            }
            float = 11;
            if (typedArray.hasValue(float)) {
                n(typedArray.getFloat(float, 1065353216));
            }
            i2 = 7;
            if (typedArray.hasValue(i2)) {
                value13 = (int)l;
                j((long)int5);
            }
            int = 14;
            if (typedArray.hasValue(int)) {
                p(typedArray.getInt(int, this.a.o()));
            }
            i = 15;
            if (typedArray.hasValue(i)) {
                value4 = (int)l3;
                q((long)int7);
            }
            int3 = 16;
            if (typedArray.hasValue(int3)) {
                r(typedArray.getInt(int3, this.a.q()));
            }
            i3 = 18;
            if (typedArray.hasValue(i3)) {
                value11 = (int)l2;
                t((long)int6);
            }
            int4 = 5;
            if (typedArray.hasValue(int4)) {
                int4 = typedArray.getInt(int4, this.a.g());
                if (int4 != 0) {
                    if (int4 != i7) {
                        value8 = 2;
                        if (int4 != value8) {
                            if (int4 != i4) {
                                h(i6);
                            } else {
                                h(i4);
                            }
                        } else {
                            h(value8);
                        }
                    } else {
                        h(i7);
                    }
                } else {
                    h(i6);
                }
            }
            int2 = 17;
            if (typedArray.hasValue(int2)) {
                int2 = typedArray.getInt(int2, this.a.r());
                if (int2 != 0) {
                    if (int2 != i7) {
                        s(i6);
                    } else {
                        s(i7);
                    }
                } else {
                    s(i6);
                }
            }
            float4 = 6;
            if (typedArray.hasValue(float4)) {
                i(typedArray.getFloat(float4, this.a.h()));
            }
            dimensionPixelSize2 = 9;
            if (typedArray.hasValue(dimensionPixelSize2)) {
                l(typedArray.getDimensionPixelSize(dimensionPixelSize2, this.a.j()));
            }
            dimensionPixelSize = 8;
            if (typedArray.hasValue(dimensionPixelSize)) {
                k(typedArray.getDimensionPixelSize(dimensionPixelSize, this.a.i()));
            }
            float5 = 13;
            if (typedArray.hasValue(float5)) {
                o(typedArray.getFloat(float5, this.a.m()));
            }
            float3 = 20;
            if (typedArray.hasValue(float3)) {
                v(typedArray.getFloat(float3, this.a.u()));
            }
            float2 = 10;
            if (typedArray.hasValue(float2)) {
                m(typedArray.getFloat(float2, this.a.k()));
            }
            int i5 = 19;
            if (typedArray.hasValue(i5)) {
                u(typedArray.getFloat(i5, this.a.t()));
            }
            return d();
        }

        public final app.dogo.com.dogo_android.util.customview.shimmer.b c() {
            return this.a;
        }

        protected abstract T d();

        public final T e(boolean z) {
            this.a.y(z);
            return d();
        }

        public final T f(float f) {
            app.dogo.com.dogo_android.util.customview.shimmer.b bVar = this.a;
            bVar.z(obj4 |= i4);
            return d();
        }

        public final T g(boolean z) {
            this.a.A(z);
            return d();
        }

        public final T h(int i) {
            this.a.B(i);
            return d();
        }

        public final T i(float f) {
            int i;
            i = Float.compare(f, i2) >= 0 ? 1 : 0;
            if (i == 0) {
            } else {
                this.a.C(f);
                return d();
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(n.o("Given invalid dropoff value: ", Float.valueOf(f)).toString());
            throw illegalArgumentException;
        }

        public final T j(long l) {
            int i;
            i = Long.compare(l, i2) >= 0 ? 1 : 0;
            if (i == 0) {
            } else {
                this.a.x(l);
                return d();
            }
            IllegalArgumentException obj4 = new IllegalArgumentException(n.o("Given a negative duration: ", Long.valueOf(l)).toString());
            throw obj4;
        }

        public final T k(int i) {
            int i2;
            i2 = i >= 0 ? 1 : 0;
            if (i2 == 0) {
            } else {
                this.a.D(i);
                return d();
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(n.o("Given invalid height: ", Integer.valueOf(i)).toString());
            throw illegalArgumentException;
        }

        public final T l(int i) {
            int i2;
            i2 = i >= 0 ? 1 : 0;
            if (i2 == 0) {
            } else {
                this.a.E(i);
                return d();
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(n.o("Given invalid width: ", Integer.valueOf(i)).toString());
            throw illegalArgumentException;
        }

        public final T m(float f) {
            int i;
            i = Float.compare(f, i2) >= 0 ? 1 : 0;
            if (i == 0) {
            } else {
                this.a.F(f);
                return d();
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(n.o("Given invalid height ratio: ", Float.valueOf(f)).toString());
            throw illegalArgumentException;
        }

        public final T n(float f) {
            app.dogo.com.dogo_android.util.customview.shimmer.b bVar = this.a;
            bVar.G(obj4 |= i4);
            return d();
        }

        public final T o(float f) {
            int i;
            i = Float.compare(f, i2) >= 0 ? 1 : 0;
            if (i == 0) {
            } else {
                this.a.H(f);
                return d();
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(n.o("Given invalid intensity value: ", Float.valueOf(f)).toString());
            throw illegalArgumentException;
        }

        public final T p(int i) {
            this.a.I(i);
            return d();
        }

        public final T q(long l) {
            int i;
            i = Long.compare(l, i2) >= 0 ? 1 : 0;
            if (i == 0) {
            } else {
                this.a.J(l);
                return d();
            }
            IllegalArgumentException obj4 = new IllegalArgumentException(n.o("Given a negative repeat delay: ", Long.valueOf(l)).toString());
            throw obj4;
        }

        public final T r(int i) {
            this.a.K(i);
            return d();
        }

        public final T s(int i) {
            this.a.L(i);
            return d();
        }

        public final T t(long l) {
            int i;
            i = Long.compare(l, i2) >= 0 ? 1 : 0;
            if (i == 0) {
            } else {
                this.a.M(l);
                return d();
            }
            IllegalArgumentException obj4 = new IllegalArgumentException(n.o("Given a negative start delay: ", Long.valueOf(l)).toString());
            throw obj4;
        }

        public final T u(float f) {
            this.a.N(f);
            return d();
        }

        public final T v(float f) {
            int i;
            i = Float.compare(f, i2) >= 0 ? 1 : 0;
            if (i == 0) {
            } else {
                this.a.O(f);
                return d();
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(n.o("Given invalid width ratio: ", Float.valueOf(f)).toString());
            throw illegalArgumentException;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer$Companion;", "", "()V", "COMPONENT_COUNT", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d {
        public d(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00008TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer$AlphaHighlightBuilder;", "Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer$Builder;", "()V", "this", "getThis", "()Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer$AlphaHighlightBuilder;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends app.dogo.com.dogo_android.util.customview.shimmer.b.b<app.dogo.com.dogo_android.util.customview.shimmer.b.a> {
        public a() {
            super();
            c().w(true);
        }

        @Override // app.dogo.com.dogo_android.util.customview.shimmer.b$b
        public app.dogo.com.dogo_android.util.customview.shimmer.b.b d() {
            w();
            return this;
        }

        @Override // app.dogo.com.dogo_android.util.customview.shimmer.b$b
        protected app.dogo.com.dogo_android.util.customview.shimmer.b.a w() {
            return this;
        }
    }

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0008H\u0016J\u0010\u0010\t\u001a\u00020\u00002\u0008\u0008\u0001\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u000c\u001a\u00020\u00002\u0008\u0008\u0001\u0010\n\u001a\u00020\u000bR\u0014\u0010\u0003\u001a\u00020\u00008TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer$ColorHighlightBuilder;", "Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer$Builder;", "()V", "this", "getThis", "()Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer$ColorHighlightBuilder;", "consumeAttributes", "a", "Landroid/content/res/TypedArray;", "setBaseColor", "color", "", "setHighlightColor", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends app.dogo.com.dogo_android.util.customview.shimmer.b.b<app.dogo.com.dogo_android.util.customview.shimmer.b.c> {
        public c() {
            super();
            c().w(false);
        }

        @Override // app.dogo.com.dogo_android.util.customview.shimmer.b$b
        public app.dogo.com.dogo_android.util.customview.shimmer.b.b b(TypedArray typedArray) {
            w(typedArray);
            return this;
        }

        @Override // app.dogo.com.dogo_android.util.customview.shimmer.b$b
        public app.dogo.com.dogo_android.util.customview.shimmer.b.b d() {
            x();
            return this;
        }

        @Override // app.dogo.com.dogo_android.util.customview.shimmer.b$b
        public app.dogo.com.dogo_android.util.customview.shimmer.b.c w(TypedArray typedArray) {
            int color;
            boolean value;
            boolean value2;
            Object obj3;
            n.f(typedArray, "a");
            super.b(typedArray);
            color = 2;
            if (typedArray.hasValue(color)) {
                y(typedArray.getColor(color, c().d()));
            }
            int i = 12;
            if (typedArray.hasValue(i)) {
                z(typedArray.getColor(i, c().l()));
            }
            x();
            return this;
        }

        @Override // app.dogo.com.dogo_android.util.customview.shimmer.b$b
        protected app.dogo.com.dogo_android.util.customview.shimmer.b.c x() {
            return this;
        }

        @Override // app.dogo.com.dogo_android.util.customview.shimmer.b$b
        public final app.dogo.com.dogo_android.util.customview.shimmer.b.c y(int i) {
            c().z(obj4 |= i3);
            x();
            return this;
        }

        @Override // app.dogo.com.dogo_android.util.customview.shimmer.b$b
        public final app.dogo.com.dogo_android.util.customview.shimmer.b.c z(int i) {
            c().G(i);
            x();
            return this;
        }
    }
    static {
        b.d dVar = new b.d(0);
        b.Companion = dVar;
    }

    public b() {
        super();
        int i = 4;
        this.a = new float[i];
        this.b = new int[i];
        RectF rectF = new RectF();
        int i2 = -1;
        int i4 = 1291845631;
        int i5 = 1065353216;
        int i6 = 1056964608;
        int i7 = 1101004800;
        int i8 = 1;
        int i3 = 1000;
    }

    public final void A(boolean z) {
        this.n = z;
    }

    public final void B(int i) {
        this.c = i;
    }

    public final void C(float f) {
        this.l = f;
    }

    public final void D(int i) {
        this.h = i;
    }

    public final void E(int i) {
        this.g = i;
    }

    public final void F(float f) {
        this.j = f;
    }

    public final void G(int i) {
        this.d = i;
    }

    public final void H(float f) {
        this.k = f;
    }

    public final void I(int i) {
        this.q = i;
    }

    public final void J(long l) {
        this.t = l;
    }

    public final void K(int i) {
        this.r = i;
    }

    public final void L(int i) {
        this.f = i;
    }

    public final void M(long l) {
        this.u = l;
    }

    public final void N(float f) {
        this.m = f;
    }

    public final void O(float f) {
        this.i = f;
    }

    public final void P() {
        int[] iArr;
        int i;
        int i2;
        int i3 = this.f;
        final int i4 = 3;
        final int i5 = 2;
        int i6 = 0;
        final int i7 = 1;
        if (i3 != 0) {
            if (i3 != i7) {
                iArr = this.b;
                i2 = this.e;
                iArr[i6] = i2;
                i = this.d;
                iArr[i7] = i;
                iArr[i5] = i;
                iArr[i4] = i2;
            } else {
                iArr = this.b;
                i2 = this.d;
                iArr[i6] = i2;
                iArr[i7] = i2;
                i = this.e;
                iArr[i5] = i;
                iArr[i4] = i;
            }
        } else {
            iArr = this.b;
            i2 = this.e;
            iArr[i6] = i2;
            i = this.d;
            iArr[i7] = i;
            iArr[i5] = i;
            iArr[i4] = i2;
        }
    }

    public final void Q() {
        float[] fArr;
        int i;
        float f2;
        float i2;
        float f3;
        float f;
        int i3 = this.f;
        final int i4 = 3;
        i = 2;
        int i11 = 0;
        i2 = 981668463;
        final int i25 = 1;
        final int i26 = 0;
        final int i27 = 1073741824;
        final int i28 = 1065353216;
        if (i3 != 0) {
            if (i3 != i25) {
                this.a[i11] = Math.max(i30 /= i27, i26);
                this.a[i25] = Math.max(i14 /= i27, i26);
                this.a[i] = Math.min(i17 /= i27, i28);
                this.a[i4] = Math.min(i6 /= i27, i28);
            } else {
                float[] fArr2 = this.a;
                fArr2[i11] = i26;
                fArr2[i25] = Math.min(this.k, i28);
                this.a[i] = Math.min(f8 += i2, i28);
                this.a[i4] = i28;
            }
        } else {
            this.a[i11] = Math.max(i33 /= i27, i26);
            this.a[i25] = Math.max(i20 /= i27, i26);
            this.a[i] = Math.min(i23 /= i27, i28);
            this.a[i4] = Math.min(i9 /= i27, i28);
        }
    }

    public final int R(int i) {
        int i2;
        float obj2;
        if (this.g > 0) {
        } else {
            i2 = a.b(f *= obj2);
        }
        return i2;
    }

    public final boolean a() {
        return this.p;
    }

    public final long b() {
        return this.s;
    }

    public final boolean c() {
        return this.o;
    }

    public final int d() {
        return this.e;
    }

    public final boolean e() {
        return this.n;
    }

    public final int[] f() {
        return this.b;
    }

    public final int g() {
        return this.c;
    }

    public final float h() {
        return this.l;
    }

    public final int i() {
        return this.h;
    }

    public final int j() {
        return this.g;
    }

    public final float k() {
        return this.j;
    }

    public final int l() {
        return this.d;
    }

    public final float m() {
        return this.k;
    }

    public final float[] n() {
        return this.a;
    }

    public final int o() {
        return this.q;
    }

    public final long p() {
        return this.t;
    }

    public final int q() {
        return this.r;
    }

    public final int r() {
        return this.f;
    }

    public final long s() {
        return this.u;
    }

    public final float t() {
        return this.m;
    }

    public final float u() {
        return this.i;
    }

    public final int v(int i) {
        int i2;
        float obj2;
        if (this.h > 0) {
        } else {
            i2 = a.b(f *= obj2);
        }
        return i2;
    }

    public final void w(boolean z) {
        this.p = z;
    }

    public final void x(long l) {
        this.s = l;
    }

    public final void y(boolean z) {
        this.o = z;
    }

    public final void z(int i) {
        this.e = i;
    }
}
