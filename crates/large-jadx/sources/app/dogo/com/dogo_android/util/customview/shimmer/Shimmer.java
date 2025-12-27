package app.dogo.com.dogo_android.util.customview.shimmer;

import android.content.res.TypedArray;
import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.e0.a;

/* compiled from: Shimmer.kt */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0015\n\u0002\u0008\u0007\n\u0002\u0010\u0007\n\u0002\u0008\u0014\n\u0002\u0010\u0014\n\u0002\u0008\u001a\n\u0002\u0010\u0002\n\u0002\u0008\u000c\u0018\u0000 a2\u00020\u0001:\u0006^_`abcB\u0007\u0008\u0000¢\u0006\u0002\u0010\u0002J\u000e\u0010V\u001a\u00020\u00132\u0006\u0010V\u001a\u00020\u0013J\u0016\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u00132\u0006\u0010Z\u001a\u00020\u0013J\u0006\u0010[\u001a\u00020XJ\u0006\u0010\\\u001a\u00020XJ\u000e\u0010]\u001a\u00020\u00132\u0006\u0010]\u001a\u00020\u0013R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0010\u0010\u0006\"\u0004\u0008\u0011\u0010\u0008R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001d\u0010\u0006\"\u0004\u0008\u001e\u0010\u0008R\u0011\u0010\u001f\u001a\u00020 ¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R \u0010#\u001a\u00020\u0013X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u0008$\u0010\u0002\u001a\u0004\u0008%\u0010\u0015\"\u0004\u0008&\u0010\u0017R\u001a\u0010'\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008)\u0010*\"\u0004\u0008+\u0010,R\u001a\u0010-\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008.\u0010\u0015\"\u0004\u0008/\u0010\u0017R\u001a\u00100\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00081\u0010\u0015\"\u0004\u00082\u0010\u0017R\u001a\u00103\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00084\u0010*\"\u0004\u00085\u0010,R\u001e\u00106\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00087\u0010\u0015\"\u0004\u00088\u0010\u0017R\u001a\u00109\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008:\u0010*\"\u0004\u0008;\u0010,R\u0011\u0010<\u001a\u00020=¢\u0006\u0008\n\u0000\u001a\u0004\u0008>\u0010?R\u001a\u0010@\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008A\u0010\u0015\"\u0004\u0008B\u0010\u0017R\u001a\u0010C\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008D\u0010\u000c\"\u0004\u0008E\u0010\u000eR\u001a\u0010F\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008G\u0010\u0015\"\u0004\u0008H\u0010\u0017R \u0010I\u001a\u00020\u0013X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u0008J\u0010\u0002\u001a\u0004\u0008K\u0010\u0015\"\u0004\u0008L\u0010\u0017R\u001a\u0010M\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008N\u0010\u000c\"\u0004\u0008O\u0010\u000eR\u001a\u0010P\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008Q\u0010*\"\u0004\u0008R\u0010,R\u001a\u0010S\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008T\u0010*\"\u0004\u0008U\u0010,¨\u0006d", d2 = {"Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer;", "", "()V", "alphaShimmer", "", "getAlphaShimmer", "()Z", "setAlphaShimmer", "(Z)V", "animationDuration", "", "getAnimationDuration", "()J", "setAnimationDuration", "(J)V", "autoStart", "getAutoStart", "setAutoStart", "baseColor", "", "getBaseColor", "()I", "setBaseColor", "(I)V", "bounds", "Landroid/graphics/RectF;", "getBounds", "()Landroid/graphics/RectF;", "clipToChildren", "getClipToChildren", "setClipToChildren", "colors", "", "getColors", "()[I", "direction", "getDirection$annotations", "getDirection", "setDirection", "dropoff", "", "getDropoff", "()F", "setDropoff", "(F)V", "fixedHeight", "getFixedHeight", "setFixedHeight", "fixedWidth", "getFixedWidth", "setFixedWidth", "heightRatio", "getHeightRatio", "setHeightRatio", "highlightColor", "getHighlightColor", "setHighlightColor", "intensity", "getIntensity", "setIntensity", "positions", "", "getPositions", "()[F", "repeatCount", "getRepeatCount", "setRepeatCount", "repeatDelay", "getRepeatDelay", "setRepeatDelay", "repeatMode", "getRepeatMode", "setRepeatMode", "shape", "getShape$annotations", "getShape", "setShape", "startDelay", "getStartDelay", "setStartDelay", "tilt", "getTilt", "setTilt", "widthRatio", "getWidthRatio", "setWidthRatio", "height", "updateBounds", "", "viewWidth", "viewHeight", "updateColors", "updatePositions", "width", "AlphaHighlightBuilder", "Builder", "ColorHighlightBuilder", "Companion", "Direction", "Shape", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: b, reason: from kotlin metadata */
public final class Shimmer {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final b.d INSTANCE = new b$d(0);
    private final float[] a;
    private final int[] b;
    private int c;
    /* renamed from: d, reason: from kotlin metadata */
    private int baseColor = -1;
    private int e = 1291845631;
    private int f;
    private int g;
    /* renamed from: h, reason: from kotlin metadata */
    private int direction;
    /* renamed from: i, reason: from kotlin metadata */
    private float dropoff = 1f;
    private float j = 1f;
    private float k;
    /* renamed from: l, reason: from kotlin metadata */
    private float heightRatio = 0.5f;
    private float m = 20f;
    private boolean n = true;
    private boolean o = true;
    private boolean p = true;
    private int q = -1;
    /* renamed from: r, reason: from kotlin metadata */
    private int repeatMode = 1;
    private long s = 1000;
    /* renamed from: t, reason: from kotlin metadata */
    private long startDelay;
    private long u;

    @Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\u0018\u0008&\u0018\u0000 @*\u0010\u0008\u0000\u0010\u0001*\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u00002\u00020\u0002:\u0001@B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\u0005J\u001d\u0010\u000c\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\u0015\u0010\u000c\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u0005¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u001a¢\u0006\u0002\u0010\u001bJ\u0015\u0010\u001c\u001a\u00028\u00002\u0008\u0008\u0001\u0010\u001d\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u001a¢\u0006\u0002\u0010\u001bJ\u0013\u0010!\u001a\u00028\u00002\u0006\u0010\"\u001a\u00020#¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00028\u00002\u0006\u0010&\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ\u0013\u0010'\u001a\u00028\u00002\u0006\u0010(\u001a\u00020)¢\u0006\u0002\u0010*J\u0015\u0010+\u001a\u00028\u00002\u0008\u0008\u0001\u0010,\u001a\u00020#¢\u0006\u0002\u0010$J\u0015\u0010-\u001a\u00028\u00002\u0008\u0008\u0001\u0010.\u001a\u00020#¢\u0006\u0002\u0010$J\u0013\u0010/\u001a\u00028\u00002\u0006\u00100\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ\u0015\u00101\u001a\u00028\u00002\u0008\u0008\u0001\u0010\u001d\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ\u0013\u00102\u001a\u00028\u00002\u0006\u00103\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ\u0013\u00104\u001a\u00028\u00002\u0006\u00105\u001a\u00020#¢\u0006\u0002\u0010$J\u0013\u00106\u001a\u00028\u00002\u0006\u0010(\u001a\u00020)¢\u0006\u0002\u0010*J\u0013\u00107\u001a\u00028\u00002\u0006\u00108\u001a\u00020#¢\u0006\u0002\u0010$J\u0013\u00109\u001a\u00028\u00002\u0006\u0010:\u001a\u00020#¢\u0006\u0002\u0010$J\u0013\u0010;\u001a\u00028\u00002\u0006\u0010(\u001a\u00020)¢\u0006\u0002\u0010*J\u0013\u0010<\u001a\u00028\u00002\u0006\u0010=\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ\u0013\u0010>\u001a\u00028\u00002\u0006\u0010?\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0012\u0010\u0008\u001a\u00028\u0000X¤\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\n¨\u0006A", d2 = {"Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer$Builder;", "T", "", "()V", "mShimmer", "Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer;", "getMShimmer", "()Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer;", "this", "getThis", "()Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer$Builder;", "build", "consumeAttributes", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer$Builder;", "a", "Landroid/content/res/TypedArray;", "(Landroid/content/res/TypedArray;)Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer$Builder;", "copyFrom", "other", "(Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer;)Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer$Builder;", "setAutoStart", "status", "", "(Z)Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer$Builder;", "setBaseAlpha", "alpha", "", "(F)Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer$Builder;", "setClipToChildren", "setDirection", "direction", "", "(I)Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer$Builder;", "setDropoff", "dropoff", "setDuration", "millis", "", "(J)Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer$Builder;", "setFixedHeight", "fixedHeight", "setFixedWidth", "fixedWidth", "setHeightRatio", "heightRatio", "setHighlightAlpha", "setIntensity", "intensity", "setRepeatCount", "repeatCount", "setRepeatDelay", "setRepeatMode", "mode", "setShape", "shape", "setStartDelay", "setTilt", "tilt", "setWidthRatio", "widthRatio", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class b<T extends b.b<T>> {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final b.b.a INSTANCE = new b$b$a(0);
        private final b a = new b();
        public b() {
            super();
            final app.dogo.com.dogo_android.util.customview.shimmer.b shimmer = new Shimmer();
        }

        /* renamed from: a, reason: from kotlin metadata */
        public final b build() {
            this.a.updateColors();
            this.a.Q();
            return this.a;
        }

        /* renamed from: b, reason: from kotlin metadata */
        public T consumeAttributes(TypedArray a) {
            n.f(a, "a");
            int i9 = 3;
            if (a.hasValue(i9)) {
                g(a.getBoolean(i9, this.a.e()));
            }
            int i11 = 0;
            if (a.hasValue(i11)) {
                e(a.getBoolean(i11, this.a.c()));
            }
            int i14 = 1;
            if (a.hasValue(i14)) {
                f(a.getFloat(i14, 0.3f));
            }
            int i5 = 11;
            if (a.hasValue(i5)) {
                n(a.getFloat(i5, 1f));
            }
            int i6 = 7;
            if (a.hasValue(i6)) {
                int i17 = (int)this.a.b();
                j((long)(a.getInt(i6, i17)));
            }
            int _int2 = 14;
            if (a.hasValue(_int2)) {
                p(a.getInt(_int2, this.a.o()));
            }
            int i7 = 15;
            if (a.hasValue(i7)) {
                int i22 = (int)this.a.p();
                q((long)(a.getInt(i7, i22)));
            }
            int _int3 = 16;
            if (a.hasValue(_int3)) {
                r(a.getInt(_int3, this.a.q()));
            }
            int i8 = 18;
            if (a.hasValue(i8)) {
                int i21 = (int)this.a.s();
                t((long)(a.getInt(i8, i21)));
            }
            int _int4 = 5;
            if (a.hasValue(_int4)) {
                _int4 = a.getInt(_int4, this.a.g());
                if (_int4 == 0) {
                    h(i11);
                } else {
                    if (_int4 == i14) {
                        h(i14);
                    } else {
                        int i20 = 2;
                        if (_int4 == i20) {
                            h(i20);
                        } else {
                            if (_int4 != i9) {
                                h(i11);
                            } else {
                                h(i9);
                            }
                        }
                    }
                }
            }
            int _int = 17;
            if (a.hasValue(_int)) {
                _int = a.getInt(_int, this.a.r());
                if (_int == 0) {
                    s(i11);
                } else {
                    if (_int != i14) {
                        s(i11);
                    } else {
                        s(i14);
                    }
                }
            }
            int i = 6;
            if (a.hasValue(i)) {
                i(a.getFloat(i, this.a.h()));
            }
            int dimensionPixelSize = 9;
            if (a.hasValue(dimensionPixelSize)) {
                l(a.getDimensionPixelSize(dimensionPixelSize, this.a.j()));
            }
            int dimensionPixelSize2 = 8;
            if (a.hasValue(dimensionPixelSize2)) {
                k(a.getDimensionPixelSize(dimensionPixelSize2, this.a.i()));
            }
            int i2 = 13;
            if (a.hasValue(i2)) {
                o(a.getFloat(i2, this.a.m()));
            }
            int i3 = 20;
            if (a.hasValue(i3)) {
                v(a.getFloat(i3, this.a.u()));
            }
            int i4 = 10;
            if (a.hasValue(i4)) {
                m(a.getFloat(i4, this.a.k()));
            }
            int i10 = 19;
            if (a.hasValue(i10)) {
                u(a.getFloat(i10, this.a.t()));
            }
            return d();
        }

        public final b c() {
            return this.a;
        }

        /* renamed from: e, reason: from kotlin metadata */
        public final T copyFrom(boolean other) {
            this.a.y(other);
            return d();
        }

        /* renamed from: f, reason: from kotlin metadata */
        public final T setAutoStart(float status) {
            this.a.z((int)(Shimmer_Builder.INSTANCE.b(0, 1065353216, status)) * 255f << 24 | (this.a.d() & 16777215));
            return d();
        }

        /* renamed from: g, reason: from kotlin metadata */
        public final T setBaseAlpha(boolean alpha) {
            this.a.height(alpha);
            return d();
        }

        /* renamed from: h, reason: from kotlin metadata */
        public final T setClipToChildren(int status) {
            this.a.width(status);
            return d();
        }

        /* renamed from: i, reason: from kotlin metadata */
        public final T setDirection(float direction) {
            int i = 1;
            int r0 = direction >= 0 ? 1 : 0;
            if (i == 0) {
                throw new IllegalArgumentException(n.o("Given invalid dropoff value: ", Float.valueOf(direction)).toString());
            } else {
                this.a.C(direction);
                return d();
            }
        }

        /* renamed from: j, reason: from kotlin metadata */
        public final T setDropoff(long dropoff) {
            int i = 1;
            int r0 = dropoff >= 0 ? 1 : 0;
            if (i == 0) {
                throw new IllegalArgumentException(n.o("Given a negative duration: ", Long.valueOf(dropoff)).toString());
            } else {
                this.a.x(dropoff);
                return d();
            }
        }

        /* renamed from: k, reason: from kotlin metadata */
        public final T setDuration(int millis) {
            int i = 1;
            int r0 = millis >= 0 ? 1 : 0;
            if (i == 0) {
                throw new IllegalArgumentException(n.o("Given invalid height: ", Integer.valueOf(millis)).toString());
            } else {
                this.a.D(millis);
                return d();
            }
        }

        /* renamed from: l, reason: from kotlin metadata */
        public final T setFixedHeight(int fixedHeight) {
            int i = 1;
            int r0 = fixedHeight >= 0 ? 1 : 0;
            if (i == 0) {
                throw new IllegalArgumentException(n.o("Given invalid width: ", Integer.valueOf(fixedHeight)).toString());
            } else {
                this.a.E(fixedHeight);
                return d();
            }
        }

        /* renamed from: m, reason: from kotlin metadata */
        public final T setFixedWidth(float fixedWidth) {
            int i = 1;
            int r0 = fixedWidth >= 0 ? 1 : 0;
            if (i == 0) {
                throw new IllegalArgumentException(n.o("Given invalid height ratio: ", Float.valueOf(fixedWidth)).toString());
            } else {
                this.a.F(fixedWidth);
                return d();
            }
        }

        /* renamed from: n, reason: from kotlin metadata */
        public final T setHeightRatio(float heightRatio) {
            this.a.G((int)(Shimmer_Builder.INSTANCE.b(0, 1065353216, heightRatio)) * 255f << 24 | (this.a.l() & 16777215));
            return d();
        }

        /* renamed from: o, reason: from kotlin metadata */
        public final T setHighlightAlpha(float alpha) {
            int i = 1;
            int r0 = alpha >= 0 ? 1 : 0;
            if (i == 0) {
                throw new IllegalArgumentException(n.o("Given invalid intensity value: ", Float.valueOf(alpha)).toString());
            } else {
                this.a.H(alpha);
                return d();
            }
        }

        /* renamed from: p, reason: from kotlin metadata */
        public final T setIntensity(int intensity) {
            this.a.I(intensity);
            return d();
        }

        /* renamed from: q, reason: from kotlin metadata */
        public final T setRepeatCount(long repeatCount) {
            int i = 1;
            int r0 = repeatCount >= 0 ? 1 : 0;
            if (i == 0) {
                throw new IllegalArgumentException(n.o("Given a negative repeat delay: ", Long.valueOf(repeatCount)).toString());
            } else {
                this.a.J(repeatCount);
                return d();
            }
        }

        /* renamed from: r, reason: from kotlin metadata */
        public final T setRepeatDelay(int millis) {
            this.a.K(millis);
            return d();
        }

        /* renamed from: s, reason: from kotlin metadata */
        public final T setRepeatMode(int mode) {
            this.a.L(mode);
            return d();
        }

        /* renamed from: t, reason: from kotlin metadata */
        public final T setShape(long shape) {
            int i = 1;
            int r0 = shape >= 0 ? 1 : 0;
            if (i == 0) {
                throw new IllegalArgumentException(n.o("Given a negative start delay: ", Long.valueOf(shape)).toString());
            } else {
                this.a.M(shape);
                return d();
            }
        }

        /* renamed from: u, reason: from kotlin metadata */
        public final T setStartDelay(float millis) {
            this.a.N(millis);
            return d();
        }

        /* renamed from: v, reason: from kotlin metadata */
        public final T setTilt(float tilt) {
            int i = 1;
            int r0 = tilt >= 0 ? 1 : 0;
            if (i == 0) {
                throw new IllegalArgumentException(n.o("Given invalid width ratio: ", Float.valueOf(tilt)).toString());
            } else {
                this.a.O(tilt);
                return d();
            }
        }


        protected abstract T d();
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer$Companion;", "", "()V", "COMPONENT_COUNT", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d {
        private d() {
            super();
        }

        public /* synthetic */ d(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00008TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer$AlphaHighlightBuilder;", "Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer$Builder;", "()V", "this", "getThis", "()Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer$AlphaHighlightBuilder;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends b.b<b.a> {
        public a() {
            super();
            c().w(true);
        }

        @Override // app.dogo.com.dogo_android.util.customview.shimmer.b$b
        protected b.a w() {
            return this;
        }
    }

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0008H\u0016J\u0010\u0010\t\u001a\u00020\u00002\u0008\u0008\u0001\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u000c\u001a\u00020\u00002\u0008\u0008\u0001\u0010\n\u001a\u00020\u000bR\u0014\u0010\u0003\u001a\u00020\u00008TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer$ColorHighlightBuilder;", "Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer$Builder;", "()V", "this", "getThis", "()Lapp/dogo/com/dogo_android/util/customview/shimmer/Shimmer$ColorHighlightBuilder;", "consumeAttributes", "a", "Landroid/content/res/TypedArray;", "setBaseColor", "color", "", "setHighlightColor", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends b.b<b.c> {
        public c() {
            super();
            c().w(false);
        }

        @Override // app.dogo.com.dogo_android.util.customview.shimmer.b$b
        /* renamed from: w, reason: from kotlin metadata */
        public b.c setBaseColor(TypedArray color) {
            n.f(color, "a");
            super.b(color);
            int color2 = 2;
            if (color.hasValue(color2)) {
                setHighlightColor(color.getColor(color2, c().d()));
            }
            int i = 12;
            if (color.hasValue(i)) {
                z(color.getColor(i, c().l()));
            }
            x();
            return this;
        }

        @Override // app.dogo.com.dogo_android.util.customview.shimmer.b$b
        /* renamed from: y, reason: from kotlin metadata */
        public final b.c setHighlightColor(int color) {
            c().z((color & 16777215) | (c().d() & (-16777216)));
            x();
            return this;
        }

        @Override // app.dogo.com.dogo_android.util.customview.shimmer.b$b
        public final b.c z(int i) {
            c().G(i);
            x();
            return this;
        }

        @Override // app.dogo.com.dogo_android.util.customview.shimmer.b$b
        protected b.c x() {
            return this;
        }
    }
    public b() {
        super();
        int i = 4;
        this.a = new float[i];
        this.b = new int[i];
        RectF rectF = new RectF();
    }

    /* renamed from: A, reason: from kotlin metadata */
    public final void height(boolean height) {
        this.n = height;
    }

    /* renamed from: B, reason: from kotlin metadata */
    public final void width(int width) {
        this.c = width;
    }

    public final void C(float f) {
        this.heightRatio = f;
    }

    public final void D(int i) {
        this.direction = i;
    }

    public final void E(int i) {
        this.g = i;
    }

    public final void F(float f) {
        this.j = f;
    }

    public final void G(int i) {
        this.baseColor = i;
    }

    public final void H(float f) {
        this.k = f;
    }

    public final void I(int i) {
        this.q = i;
    }

    public final void J(long j) {
        this.startDelay = j;
    }

    public final void K(int i) {
        this.repeatMode = i;
    }

    public final void L(int i) {
        this.f = i;
    }

    public final void M(long j) {
        this.u = j;
    }

    public final void N(float f) {
        this.m = f;
    }

    public final void O(float f) {
        this.dropoff = f;
    }

    /* renamed from: P, reason: from kotlin metadata */
    public final void updateColors() {
        final int i2 = 3;
        final int i3 = 2;
        int i4 = 0;
        final int i5 = 1;
        if (this.f == 0) {
            this.b[i4] = this.e;
            this.b[i5] = this.baseColor;
            this.b[i3] = this.baseColor;
            this.b[i2] = this.e;
        } else {
            if (this.f != i5) {
                this.b[i4] = this.e;
                this.b[i5] = this.baseColor;
                this.b[i3] = this.baseColor;
                this.b[i2] = this.e;
            } else {
                this.b[i4] = this.baseColor;
                this.b[i5] = this.baseColor;
                this.b[i3] = this.e;
                this.b[i2] = this.e;
            }
        }
    }

    public final void Q() {
        final int i3 = 3;
        int i = 2;
        int i4 = 0;
        float heightRatio2 = 0.001f;
        final int i5 = 1;
        final float f28 = 0.0f;
        final float f29 = 2f;
        final float f30 = 1f;
        if (this.f == 0) {
            this.a[i4] = Math.max((f30 - this.k) - this.heightRatio / f29, 0.0f);
            this.a[i5] = Math.max((f30 - this.k) - heightRatio2 / f29, 0.0f);
            this.a[i] = Math.min((this.k + f30) + heightRatio2 / f29, f30);
            this.a[i3] = Math.min((this.k + f30) + this.heightRatio / f29, f30);
        } else {
            if (this.f != i5) {
                this.a[i4] = Math.max((f30 - this.k) - this.heightRatio / f29, 0.0f);
                this.a[i5] = Math.max((f30 - this.k) - heightRatio2 / f29, 0.0f);
                this.a[i] = Math.min((this.k + f30) + heightRatio2 / f29, f30);
                this.a[i3] = Math.min((this.k + f30) + this.heightRatio / f29, f30);
            } else {
                this.a[i4] = 0.0f;
                this.a[i5] = Math.min(this.k, f30);
                this.a[i] = Math.min(this.k + this.heightRatio, f30);
                this.a[i3] = f30;
            }
        }
    }

    public final int R(int i) {
        int i2;
        if (this.g <= 0) {
            f = (float)i;
            i2 = a.b(this.dropoff * f);
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
        return this.heightRatio;
    }

    public final int i() {
        return this.direction;
    }

    public final int j() {
        return this.g;
    }

    public final float k() {
        return this.j;
    }

    public final int l() {
        return this.baseColor;
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
        return this.startDelay;
    }

    public final int q() {
        return this.repeatMode;
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
        return this.dropoff;
    }

    public final int v(int i) {
        int direction2;
        if (this.direction <= 0) {
            f = (float)i;
            direction2 = a.b(this.j * f);
        }
        return direction2;
    }

    public final void w(boolean z) {
        this.p = z;
    }

    public final void x(long j) {
        this.s = j;
    }

    public final void y(boolean z) {
        this.o = z;
    }

    public final void z(int i) {
        this.e = i;
    }

}
