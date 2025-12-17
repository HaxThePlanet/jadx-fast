package androidx.compose.animation.core;

import androidx.compose.ui.graphics.BezierKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0013\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\rH\u0096\u0002J\u0008\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0002J\u0008\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016", d2 = {"Landroidx/compose/animation/core/CubicBezierEasing;", "Landroidx/compose/animation/core/Easing;", "a", "", "b", "c", "d", "(FFFF)V", "max", "min", "equals", "", "other", "", "hashCode", "", "throwNoSolution", "", "fraction", "toString", "", "transform", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CubicBezierEasing implements androidx.compose.animation.core.Easing {

    public static final int $stable;
    private final float a;
    private final float b;
    private final float c;
    private final float d;
    private final float max;
    private final float min;
    static {
    }

    public CubicBezierEasing(float a, float b, float c, float d) {
        int i;
        boolean naN;
        String $i$a$RequirePreconditionCubicBezierEasing$1;
        StringBuilder append;
        int i2;
        float f;
        super();
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        if (!Float.isNaN(this.a) && !Float.isNaN(this.b) && !Float.isNaN(this.c) && !Float.isNaN(this.d)) {
            if (!Float.isNaN(this.b)) {
                if (!Float.isNaN(this.c)) {
                    i = !Float.isNaN(this.d) ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        int i3 = 0;
        if (i == 0) {
            int i5 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = ", ";
            PreconditionsKt.throwIllegalArgumentException(stringBuilder.append("Parameters to CubicBezierEasing cannot be NaN. Actual parameters are: ").append(this.a).append(str2).append(this.b).append(str2).append(this.c).append(str2).append(this.d).append('.').toString());
        }
        long cubicVerticalBounds = BezierKt.computeCubicVerticalBounds(0, this.b, this.d, 1065353216, new float[5], 0);
        int i6 = 0;
        int i14 = 0;
        this.min = Float.intBitsToFloat((int)i9);
        int i7 = 0;
        int i15 = 0;
        this.max = Float.intBitsToFloat((int)i11);
    }

    private final void throwNoSolution(float fraction) {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = ", ";
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("The cubic curve with parameters (").append(this.a).append(str2).append(this.b).append(str2).append(this.c).append(str2).append(this.d).append(") has no solution at ").append(fraction).toString());
        throw illegalArgumentException;
    }

    @Override // androidx.compose.animation.core.Easing
    public boolean equals(Object other) {
        int i;
        int i3;
        int i2;
        float f;
        i3 = 0;
        if (other instanceof CubicBezierEasing) {
            i2 = 1;
            i = Float.compare(f2, f6) == 0 ? i2 : i3;
            if (i != 0) {
                i = Float.compare(f3, f) == 0 ? i2 : i3;
                if (i != 0) {
                    i = Float.compare(f4, f) == 0 ? i2 : i3;
                    if (i != 0) {
                        i = Float.compare(f5, f) == 0 ? i2 : i3;
                        if (i != 0) {
                            i3 = i2;
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
        return i3;
    }

    @Override // androidx.compose.animation.core.Easing
    public int hashCode() {
        return i6 += i10;
    }

    @Override // androidx.compose.animation.core.Easing
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("CubicBezierEasing(a=").append(this.a).append(", b=").append(this.b).append(", c=").append(this.c).append(", d=").append(this.d).append(')').toString();
    }

    @Override // androidx.compose.animation.core.Easing
    public float transform(float fraction) {
        int firstCubicRoot;
        int evaluateCubic;
        int cmp;
        float max;
        int i;
        int $this$fastCoerceAtMost$iv$iv;
        int i2;
        int cmp2;
        firstCubicRoot = 0;
        evaluateCubic = 1065353216;
        if (Float.compare(fraction, firstCubicRoot) > 0 && Float.compare(fraction, evaluateCubic) < 0) {
            evaluateCubic = 1065353216;
            if (Float.compare(fraction, evaluateCubic) < 0) {
                firstCubicRoot = BezierKt.findFirstCubicRoot(firstCubicRoot -= fraction, f2 -= fraction, f4 -= fraction, evaluateCubic -= fraction);
                if (Float.isNaN(firstCubicRoot)) {
                    throwNoSolution(fraction);
                }
                cmp = this.min;
                max = this.max;
                i = 0;
                int i7 = 0;
                if (Float.compare($this$fastCoerceAtMost$iv$iv, cmp) < 0) {
                    $this$fastCoerceAtMost$iv$iv = cmp;
                }
                i2 = 0;
                if (Float.compare($this$fastCoerceAtMost$iv$iv, max) > 0) {
                    $this$fastCoerceAtMost$iv$iv = max;
                }
            } else {
                $this$fastCoerceAtMost$iv$iv = fraction;
            }
        } else {
        }
        return $this$fastCoerceAtMost$iv$iv;
    }
}
