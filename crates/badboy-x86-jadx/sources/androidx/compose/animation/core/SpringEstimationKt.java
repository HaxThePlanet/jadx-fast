package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0006\n\u0002\u0008\u0007\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\u001a0\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u0004H\u0007\u001a8\u0010\u0002\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u0004H\u0007\u001a0\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u000c2\u0006\u0010\u0005\u001a\u00020\u000c2\u0006\u0010\u0006\u001a\u00020\u000c2\u0006\u0010\u0007\u001a\u00020\u000c2\u0006\u0010\u0008\u001a\u00020\u000cH\u0007\u001a(\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u0004H\u0002\u001a8\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u0004H\u0002\u001a0\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u0004H\u0002\u001a(\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u0004H\u0002\u001a9\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001aH\u0082\u0008\u001a\r\u0010\u001c\u001a\u00020\u001d*\u00020\u0004H\u0082\u0008\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e", d2 = {"MAX_LONG_MILLIS", "", "estimateAnimationDurationMillis", "stiffness", "", "dampingRatio", "initialVelocity", "initialDisplacement", "delta", "springConstant", "dampingCoefficient", "mass", "", "estimateCriticallyDamped", "firstRoot", "Landroidx/compose/animation/core/ComplexDouble;", "p0", "v0", "estimateDurationInternal", "secondRoot", "initialPosition", "estimateOverDamped", "estimateUnderDamped", "iterateNewtonsMethod", "x", "fn", "Lkotlin/Function1;", "fnPrime", "isNotFinite", "", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SpringEstimationKt {

    private static final long MAX_LONG_MILLIS = 9223372036854L;
    public static final long estimateAnimationDurationMillis(double stiffness, double dampingRatio, double initialVelocity, double initialDisplacement, double delta) {
        i *= sqrt;
        i3 -= i5;
        int i12 = 0;
        androidx.compose.animation.core.ComplexDouble num = complexSqrt;
        int i14 = 0;
        d5 += i6;
        ComplexDouble.access$set_real$p(num, i19);
        long $this$plus$iv = 4602678819172646912L;
        int i11 = 0;
        ComplexDouble.access$set_real$p(num, d3 *= $this$plus$iv);
        ComplexDouble.access$set_imaginary$p(num, d4 *= $this$plus$iv);
        androidx.compose.animation.core.ComplexDouble complexSqrt2 = ComplexDoubleKt.complexSqrt(i4);
        int i13 = 0;
        androidx.compose.animation.core.ComplexDouble num2 = complexSqrt2;
        int i17 = 0;
        double d8 = (double)i20;
        ComplexDouble.access$set_real$p(num2, d6 *= d8);
        ComplexDouble.access$set_imaginary$p(num2, d7 *= d8);
        int i23 = 0;
        androidx.compose.animation.core.ComplexDouble num5 = num2;
        final int i26 = i2;
        ComplexDouble.access$set_real$p(num5, d9 + i18);
        long l2 = 4602678819172646912L;
        androidx.compose.animation.core.ComplexDouble num4 = num5;
        int i8 = 0;
        ComplexDouble.access$set_real$p(num4, d *= l2);
        ComplexDouble.access$set_imaginary$p(num4, d2 *= l2);
        return SpringEstimationKt.estimateDurationInternal(num, num4, initialVelocity, 0, delta, obj16);
    }

    public static final long estimateAnimationDurationMillis(double springConstant, double dampingCoefficient, double mass, double initialVelocity, double initialDisplacement, double delta) {
        int i = mass;
        long l = 4611686018427387904L;
        final int i28 = i10 - i15;
        int i9 = l2 / i8;
        final int i21 = 0;
        androidx.compose.animation.core.ComplexDouble num = complexSqrt2;
        int i23 = 0;
        ComplexDouble.access$set_real$p(num, d9 += i11);
        androidx.compose.animation.core.ComplexDouble $this$plus$iv = num;
        int i12 = 0;
        ComplexDouble.access$set_real$p($this$plus$iv, d3 *= i9);
        ComplexDouble.access$set_imaginary$p($this$plus$iv, d4 *= i9);
        int i22 = 0;
        androidx.compose.animation.core.ComplexDouble num2 = complexSqrt;
        int i25 = 0;
        final double d12 = d;
        ComplexDouble.access$set_real$p(num2, d10 * d12);
        ComplexDouble.access$set_imaginary$p(num2, d2 *= d12);
        int i26 = 0;
        androidx.compose.animation.core.ComplexDouble num3 = num2;
        int i29 = 0;
        ComplexDouble.access$set_real$p(num3, d11 + i30);
        androidx.compose.animation.core.ComplexDouble other$iv = num3;
        int i5 = 0;
        ComplexDouble.access$set_real$p(other$iv, d5 *= i9);
        ComplexDouble.access$set_imaginary$p(other$iv, d6 *= i9);
        return SpringEstimationKt.estimateDurationInternal($this$plus$iv, other$iv, i / i7, obj9, obj29, i21);
    }

    public static final long estimateAnimationDurationMillis(float stiffness, float dampingRatio, float initialVelocity, float initialDisplacement, float delta) {
        int i;
        i = Float.compare(dampingRatio, i2) == 0 ? 1 : 0;
        if (i != 0) {
            return 9223372036854L;
        }
        return SpringEstimationKt.estimateAnimationDurationMillis((double)stiffness, obj3, (double)dampingRatio, obj5, (double)obj);
    }

    private static final double estimateCriticallyDamped(androidx.compose.animation.core.ComplexDouble firstRoot, double p0, double v0, double delta) {
        int i7;
        int i5;
        double real;
        double d4;
        int xInflection2;
        double tCurr;
        int cmp;
        int cmp3;
        int i8;
        boolean infinite2;
        int infinite;
        int i3;
        boolean naN;
        int iterations;
        double t;
        int i4;
        double d3;
        int xInflection;
        int i9;
        long tDelta;
        int cmp2;
        double d2;
        double d;
        int i;
        int i6;
        int i10;
        int i2;
        i7 = obj41;
        real = firstRoot.getReal();
        cmp = p0;
        int i23 = delta - i22;
        d10 /= real;
        int i26 = 0;
        double d12 = Math.log(Math.abs(i7 / i23));
        t = d12;
        i4 = 0;
        d3 = real;
        while (i4 < 6) {
            t = d12 - d8;
            i4++;
            real = d3;
            d3 = real;
        }
        t /= d3;
        int i14 = i25;
        i8 = 0;
        if (!Double.isInfinite(i14) && !Double.isNaN(i14)) {
            infinite = !Double.isNaN(i14) ? 1 : i3;
        } else {
        }
        if (infinite == 0) {
            d4 = i32;
        } else {
            int i15 = i32;
            i8 = 0;
            if (!Double.isInfinite(i15) && !Double.isNaN(i15)) {
                if (!Double.isNaN(i15)) {
                    i3 = 1;
                }
            }
            if (i3 == 0) {
                d4 = i25;
            } else {
                d4 = Math.max(i25, obj9);
            }
        }
        i29 /= i33;
        double d15 = d4;
        int tCurr2 = i35 + i38;
        if (!Double.isNaN(i30)) {
            int i36 = 0;
            if (Double.compare(i30, i36) <= 0) {
                xInflection = tCurr2;
                i9 = cmp;
                xInflection2 = -i7;
                tCurr = d15;
            } else {
                if (Double.compare(i30, i36) > 0) {
                    if (Double.compare(c1, i7) < 0) {
                        if (Double.compare(i23, i36) < 0 && Double.compare(i9, i36) > 0) {
                            tCurr = Double.compare(i9, i36) > 0 ? 0 : d15;
                        } else {
                        }
                        xInflection = tCurr2;
                        xInflection2 = -i7;
                    } else {
                        xInflection = tCurr2;
                        tCurr = i19;
                        xInflection2 = i7;
                    }
                } else {
                    xInflection = tCurr2;
                    i9 = cmp;
                }
            }
        } else {
            xInflection = tCurr2;
            i9 = cmp;
        }
        tDelta = 9218868437227405311L;
        iterations = 0;
        while (Double.compare(tDelta, l) > 0) {
            if (iterations < 100) {
            }
            iterations++;
            i4 = 0;
            d = tCurr;
            int i40 = 0;
            i = 0;
            int i16 = d3 * d;
            tDelta = Math.abs(d2 - tCurr);
            i7 = obj41;
            xInflection2 = i2;
        }
        int signedDelta = xInflection2;
        return tCurr;
    }

    private static final long estimateDurationInternal(androidx.compose.animation.core.ComplexDouble firstRoot, androidx.compose.animation.core.ComplexDouble secondRoot, double dampingRatio, double initialVelocity, double initialPosition, double delta) {
        int i3;
        double estimateCriticallyDamped;
        int cmp;
        Object obj;
        int i2;
        double d4;
        int i;
        int i4;
        double d2;
        double d;
        double d3;
        final int i5 = initialPosition;
        int i6 = 0;
        i = 0;
        cmp = Double.compare(obj18, i6) == 0 ? i2 : i;
        if (cmp != 0) {
            if (Double.compare(i5, i6) == 0) {
            } else {
                i2 = i;
            }
            if (i2 != 0) {
                return 0;
            }
        }
        i3 = Double.compare(obj18, i6) < 0 ? -i5 : i5;
        i4 = i3;
        d4 = Math.abs(obj18);
        long l = 4607182418800017408L;
        if (Double.compare(dampingRatio, l) > 0) {
            d2 = i4;
            i = d4;
            estimateCriticallyDamped = SpringEstimationKt.estimateOverDamped(firstRoot, secondRoot, i, i4, d2);
            d4 = i;
            i4 = d2;
        } else {
            if (Double.compare(dampingRatio, l) < 0) {
                estimateCriticallyDamped = SpringEstimationKt.estimateUnderDamped(firstRoot, d4, i, i4);
            } else {
                estimateCriticallyDamped = SpringEstimationKt.estimateCriticallyDamped(firstRoot, d4, i, i4);
            }
        }
        return (long)i7;
    }

    private static final double estimateOverDamped(androidx.compose.animation.core.ComplexDouble firstRoot, androidx.compose.animation.core.ComplexDouble secondRoot, double p0, double v0, double delta) {
        int iterations;
        int i4;
        int cmp;
        int c1;
        double d2;
        int t1;
        int cmp3;
        int cmp2;
        int i7;
        double tCurr;
        boolean infinite2;
        int infinite;
        int i;
        int c12;
        int i6;
        long tDelta;
        int i8;
        double d3;
        int i2;
        int i9;
        int i3;
        int i5;
        double d;
        int i10 = obj41;
        final double real = firstRoot.getReal();
        final double real2 = secondRoot.getReal();
        final int i24 = i12 / i15;
        int i13 = p0 - i24;
        cmp3 = d6 / real;
        final int i30 = d8 / real2;
        int i18 = cmp3;
        i7 = 0;
        final int i32 = 1;
        if (!Double.isInfinite(i18) && !Double.isNaN(i18)) {
            infinite = !Double.isNaN(i18) ? i32 : i;
        } else {
        }
        if (infinite == 0) {
            d2 = i30;
        } else {
            int i19 = i30;
            i7 = 0;
            if (!Double.isInfinite(i19) && !Double.isNaN(i19)) {
                if (!Double.isNaN(i19)) {
                    i = i32;
                }
            }
            if (i == 0) {
                d2 = cmp3;
            } else {
                d2 = Math.max(cmp3, obj13);
            }
        }
        tCurr = d2;
        int i31 = i13;
        int i23 = d4 / i22;
        if (!Double.isNaN(i23)) {
            i6 = 0;
            if (Double.compare(i23, i6) <= 0) {
                c1 = i31;
                c12 = cmp3;
                t1 = -i10;
            } else {
                if (Double.compare(i23, i6) > 0) {
                    c1 = i31;
                    c12 = cmp3;
                    if (Double.compare(i29, i10) < 0) {
                        if (Double.compare(i24, i6) > 0 && Double.compare(c1, i6) < 0) {
                            if (Double.compare(c1, i6) < 0) {
                                tCurr = cmp2;
                            }
                        }
                        t1 = -i10;
                    } else {
                        tCurr = i28;
                        t1 = i10;
                    }
                } else {
                    c1 = i31;
                    c12 = cmp3;
                }
            }
        } else {
            c1 = i31;
            c12 = cmp3;
        }
        if (Double.compare(d10, l) < 0) {
            return tCurr;
        }
        tDelta = 9218868437227405311L;
        iterations = i8;
        while (Double.compare(tDelta, l2) > 0) {
            if (iterations < 100) {
            }
            iterations++;
            i4 = 0;
            double d12 = tCurr;
            int i43 = 0;
            i2 = 0;
            tDelta = Math.abs(i8 - tCurr);
        }
        return tCurr;
    }

    private static final double estimateOverDamped$xInflection(double c1, double r1, double tInflection, double c2, double r2) {
        return i2 += i5;
    }

    private static final double estimateUnderDamped(androidx.compose.animation.core.ComplexDouble firstRoot, double p0, double v0, double delta) {
        final double real = firstRoot.getReal();
        final int i = p0;
        i3 /= imaginary;
        return d /= real;
    }

    private static final boolean isNotFinite(double $this$isNotFinite) {
        boolean infinite;
        int i;
        final int i2 = 0;
        final int i4 = 1;
        if (!Double.isInfinite($this$isNotFinite) && !Double.isNaN($this$isNotFinite)) {
            i = !Double.isNaN($this$isNotFinite) ? i4 : 0;
        } else {
        }
        return i ^= i4;
    }

    private static final double iterateNewtonsMethod(double x, Function1<? super Double, Double> fn, Function1<? super Double, Double> fnPrime) {
        final int i = 0;
        return x - i2;
    }
}
