package androidx.compose.animation.core;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008E\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0003\"\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0003\"\u0011\u0010\u0008\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0003\"\u0011\u0010\n\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u0003\"\u0011\u0010\u000c\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u0003\"\u0011\u0010\u000e\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0003\"\u0011\u0010\u0010\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0003\"\u0011\u0010\u0012\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0003\"\u0011\u0010\u0014\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0003\"\u0011\u0010\u0016\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0003\"\u0011\u0010\u0018\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0003\"\u0011\u0010\u001a\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0003\"\u0011\u0010\u001c\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u0003\"\u0011\u0010\u001e\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u0003\"\u0011\u0010 \u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\u0003\"\u0011\u0010\"\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010\u0003\"\u0011\u0010$\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010\u0003\"\u0011\u0010&\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010\u0003\"\u0011\u0010(\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010\u0003\"\u0011\u0010*\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010\u0003\"\u0011\u0010,\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010\u0003\"\u0011\u0010.\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u0010\u0003\"\u0011\u00100\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u0010\u0003\"\u0011\u00102\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u0010\u0003\"\u0011\u00104\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u00085\u0010\u0003\"\u0011\u00106\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u00087\u0010\u0003\"\u0011\u00108\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u00089\u0010\u0003\"\u0011\u0010:\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008;\u0010\u0003\"\u0011\u0010<\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008=\u0010\u0003\"\u0011\u0010>\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008?\u0010\u0003\"\u0011\u0010@\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008A\u0010\u0003\"\u0011\u0010B\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008C\u0010\u0003\"\u0011\u0010D\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008E\u0010\u0003¨\u0006F", d2 = {"Ease", "Landroidx/compose/animation/core/Easing;", "getEase", "()Landroidx/compose/animation/core/Easing;", "EaseIn", "getEaseIn", "EaseInBack", "getEaseInBack", "EaseInBounce", "getEaseInBounce", "EaseInCirc", "getEaseInCirc", "EaseInCubic", "getEaseInCubic", "EaseInElastic", "getEaseInElastic", "EaseInExpo", "getEaseInExpo", "EaseInOut", "getEaseInOut", "EaseInOutBack", "getEaseInOutBack", "EaseInOutBounce", "getEaseInOutBounce", "EaseInOutCirc", "getEaseInOutCirc", "EaseInOutCubic", "getEaseInOutCubic", "EaseInOutElastic", "getEaseInOutElastic", "EaseInOutExpo", "getEaseInOutExpo", "EaseInOutQuad", "getEaseInOutQuad", "EaseInOutQuart", "getEaseInOutQuart", "EaseInOutQuint", "getEaseInOutQuint", "EaseInOutSine", "getEaseInOutSine", "EaseInQuad", "getEaseInQuad", "EaseInQuart", "getEaseInQuart", "EaseInQuint", "getEaseInQuint", "EaseInSine", "getEaseInSine", "EaseOut", "getEaseOut", "EaseOutBack", "getEaseOutBack", "EaseOutBounce", "getEaseOutBounce", "EaseOutCirc", "getEaseOutCirc", "EaseOutCubic", "getEaseOutCubic", "EaseOutElastic", "getEaseOutElastic", "EaseOutExpo", "getEaseOutExpo", "EaseOutQuad", "getEaseOutQuad", "EaseOutQuart", "getEaseOutQuart", "EaseOutQuint", "getEaseOutQuint", "EaseOutSine", "getEaseOutSine", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EasingFunctionsKt {

    private static final androidx.compose.animation.core.Easing Ease;
    private static final androidx.compose.animation.core.Easing EaseIn;
    private static final androidx.compose.animation.core.Easing EaseInBack;
    private static final androidx.compose.animation.core.Easing EaseInBounce;
    private static final androidx.compose.animation.core.Easing EaseInCirc;
    private static final androidx.compose.animation.core.Easing EaseInCubic;
    private static final androidx.compose.animation.core.Easing EaseInElastic;
    private static final androidx.compose.animation.core.Easing EaseInExpo;
    private static final androidx.compose.animation.core.Easing EaseInOut;
    private static final androidx.compose.animation.core.Easing EaseInOutBack;
    private static final androidx.compose.animation.core.Easing EaseInOutBounce;
    private static final androidx.compose.animation.core.Easing EaseInOutCirc;
    private static final androidx.compose.animation.core.Easing EaseInOutCubic;
    private static final androidx.compose.animation.core.Easing EaseInOutElastic;
    private static final androidx.compose.animation.core.Easing EaseInOutExpo;
    private static final androidx.compose.animation.core.Easing EaseInOutQuad;
    private static final androidx.compose.animation.core.Easing EaseInOutQuart;
    private static final androidx.compose.animation.core.Easing EaseInOutQuint;
    private static final androidx.compose.animation.core.Easing EaseInOutSine;
    private static final androidx.compose.animation.core.Easing EaseInQuad;
    private static final androidx.compose.animation.core.Easing EaseInQuart;
    private static final androidx.compose.animation.core.Easing EaseInQuint;
    private static final androidx.compose.animation.core.Easing EaseInSine;
    private static final androidx.compose.animation.core.Easing EaseOut;
    private static final androidx.compose.animation.core.Easing EaseOutBack;
    private static final androidx.compose.animation.core.Easing EaseOutBounce;
    private static final androidx.compose.animation.core.Easing EaseOutCirc;
    private static final androidx.compose.animation.core.Easing EaseOutCubic;
    private static final androidx.compose.animation.core.Easing EaseOutElastic;
    private static final androidx.compose.animation.core.Easing EaseOutExpo;
    private static final androidx.compose.animation.core.Easing EaseOutQuad;
    private static final androidx.compose.animation.core.Easing EaseOutQuart;
    private static final androidx.compose.animation.core.Easing EaseOutQuint;
    private static final androidx.compose.animation.core.Easing EaseOutSine;
    public static float $r8$lambda$0mT70ha04S60Nb7kj5GmrRTBujI(float f) {
        return EasingFunctionsKt.EaseInElastic$lambda$0(f);
    }

    public static float $r8$lambda$IM0lvmKM4abXPeEETz8MZPm1uPA(float f) {
        return EasingFunctionsKt.EaseOutBounce$lambda$3(f);
    }

    public static float $r8$lambda$Rw_gAMuJSae-_PfDuqUI-Jv2CnE(float f) {
        return EasingFunctionsKt.EaseInOutElastic$lambda$2(f);
    }

    public static float $r8$lambda$Th_2_OW0nSNGWQlUpYyXgUsD8Kg(float f) {
        return EasingFunctionsKt.EaseOutElastic$lambda$1(f);
    }

    public static float $r8$lambda$haH0mB4KwVWLBMbjhosFFDIQ4bk(float f) {
        return EasingFunctionsKt.EaseInOutBounce$lambda$5(f);
    }

    public static float $r8$lambda$lrLe4bTzQ5p7bBLUaZZav2gblT4(float f) {
        return EasingFunctionsKt.EaseInBounce$lambda$4(f);
    }

    static {
        int i = 1048576000;
        final int i13 = 1065353216;
        CubicBezierEasing cubicBezierEasing = new CubicBezierEasing(i, 1036831949, i, i13);
        EasingFunctionsKt.Ease = (Easing)cubicBezierEasing;
        int i10 = 0;
        int i14 = 1058306785;
        CubicBezierEasing cubicBezierEasing2 = new CubicBezierEasing(i10, i10, i14, i13);
        EasingFunctionsKt.EaseOut = (Easing)cubicBezierEasing2;
        int i31 = 1054280253;
        CubicBezierEasing cubicBezierEasing3 = new CubicBezierEasing(i31, i10, i13, i13);
        EasingFunctionsKt.EaseIn = (Easing)cubicBezierEasing3;
        CubicBezierEasing cubicBezierEasing4 = new CubicBezierEasing(i31, i10, i14, i13);
        EasingFunctionsKt.EaseInOut = (Easing)cubicBezierEasing4;
        CubicBezierEasing cubicBezierEasing5 = new CubicBezierEasing(1039516303, i10, 1053273620, i10);
        EasingFunctionsKt.EaseInSine = (Easing)cubicBezierEasing5;
        CubicBezierEasing cubicBezierEasing6 = new CubicBezierEasing(1058810102, i13, 1063339950, i13);
        EasingFunctionsKt.EaseOutSine = (Easing)cubicBezierEasing6;
        CubicBezierEasing cubicBezierEasing7 = new CubicBezierEasing(1052602532, i10, 1059145646, i13);
        EasingFunctionsKt.EaseInOutSine = (Easing)cubicBezierEasing7;
        int i35 = 1050924810;
        CubicBezierEasing cubicBezierEasing8 = new CubicBezierEasing(i35, i10, 1059816735, i10);
        EasingFunctionsKt.EaseInCubic = (Easing)cubicBezierEasing8;
        final int i36 = 1059984507;
        CubicBezierEasing cubicBezierEasing9 = new CubicBezierEasing(1051260355, i13, i36, i13);
        EasingFunctionsKt.EaseOutCubic = (Easing)cubicBezierEasing9;
        CubicBezierEasing cubicBezierEasing10 = new CubicBezierEasing(1059481190, i10, 1051931443, i13);
        EasingFunctionsKt.EaseInOutCubic = (Easing)cubicBezierEasing10;
        int i38 = 1059313418;
        CubicBezierEasing cubicBezierEasing11 = new CubicBezierEasing(i38, i10, 1061662228, i10);
        EasingFunctionsKt.EaseInQuint = (Easing)cubicBezierEasing11;
        final int i39 = 1052266988;
        CubicBezierEasing cubicBezierEasing12 = new CubicBezierEasing(1046562734, i13, i39, i13);
        EasingFunctionsKt.EaseOutQuint = (Easing)cubicBezierEasing12;
        CubicBezierEasing cubicBezierEasing13 = new CubicBezierEasing(1062501089, i10, 1043207291, i13);
        EasingFunctionsKt.EaseInOutQuint = (Easing)cubicBezierEasing13;
        int i24 = 1057803469;
        int i41 = 1055286886;
        CubicBezierEasing cubicBezierEasing14 = new CubicBezierEasing(i24, i10, i13, i41);
        EasingFunctionsKt.EaseInCirc = (Easing)cubicBezierEasing14;
        CubicBezierEasing cubicBezierEasing15 = new CubicBezierEasing(i10, i24, i41, i13);
        EasingFunctionsKt.EaseOutCirc = (Easing)cubicBezierEasing15;
        CubicBezierEasing cubicBezierEasing16 = new CubicBezierEasing(1062836634, i10, 1041865114, i13);
        EasingFunctionsKt.EaseInOutCirc = (Easing)cubicBezierEasing16;
        int i46 = 1056964608;
        CubicBezierEasing cubicBezierEasing17 = new CubicBezierEasing(1038174126, i10, i46, i10);
        EasingFunctionsKt.EaseInQuad = (Easing)cubicBezierEasing17;
        CubicBezierEasing cubicBezierEasing18 = new CubicBezierEasing(i46, i13, 1063507722, i13);
        EasingFunctionsKt.EaseOutQuad = (Easing)cubicBezierEasing18;
        CubicBezierEasing cubicBezierEasing19 = new CubicBezierEasing(i41, i10, i24, i13);
        EasingFunctionsKt.EaseInOutQuad = (Easing)cubicBezierEasing19;
        CubicBezierEasing cubicBezierEasing20 = new CubicBezierEasing(i46, i10, 1061158912, i10);
        EasingFunctionsKt.EaseInQuart = (Easing)cubicBezierEasing20;
        CubicBezierEasing cubicBezierEasing21 = new CubicBezierEasing(i, i13, i46, i13);
        EasingFunctionsKt.EaseOutQuart = (Easing)cubicBezierEasing21;
        CubicBezierEasing cubicBezierEasing22 = new CubicBezierEasing(1061326684, i10, 1047904911, i13);
        EasingFunctionsKt.EaseInOutQuart = (Easing)cubicBezierEasing22;
        CubicBezierEasing cubicBezierEasing23 = new CubicBezierEasing(1060320051, i10, 1062668861, i10);
        EasingFunctionsKt.EaseInExpo = (Easing)cubicBezierEasing23;
        CubicBezierEasing cubicBezierEasing24 = new CubicBezierEasing(1042536202, i13, 1050253722, i13);
        EasingFunctionsKt.EaseOutExpo = (Easing)cubicBezierEasing24;
        CubicBezierEasing cubicBezierEasing25 = new CubicBezierEasing(1063172178, i10, 1040522936, i13);
        EasingFunctionsKt.EaseInOutExpo = (Easing)cubicBezierEasing25;
        CubicBezierEasing cubicBezierEasing26 = new CubicBezierEasing(i39, i10, 1059648963, -1089512407);
        EasingFunctionsKt.EaseInBack = (Easing)cubicBezierEasing26;
        CubicBezierEasing cubicBezierEasing27 = new CubicBezierEasing(1051595899, 1070050836, i38, i13);
        EasingFunctionsKt.EaseOutBack = (Easing)cubicBezierEasing27;
        CubicBezierEasing cubicBezierEasing28 = new CubicBezierEasing(i36, -1088841318, i35, 1070386381);
        EasingFunctionsKt.EaseInOutBack = (Easing)cubicBezierEasing28;
        EasingFunctionsKt$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new EasingFunctionsKt$$ExternalSyntheticLambda0();
        EasingFunctionsKt.EaseInElastic = externalSyntheticLambda0;
        EasingFunctionsKt$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new EasingFunctionsKt$$ExternalSyntheticLambda1();
        EasingFunctionsKt.EaseOutElastic = externalSyntheticLambda1;
        EasingFunctionsKt$$ExternalSyntheticLambda2 externalSyntheticLambda2 = new EasingFunctionsKt$$ExternalSyntheticLambda2();
        EasingFunctionsKt.EaseInOutElastic = externalSyntheticLambda2;
        EasingFunctionsKt$$ExternalSyntheticLambda3 externalSyntheticLambda3 = new EasingFunctionsKt$$ExternalSyntheticLambda3();
        EasingFunctionsKt.EaseOutBounce = externalSyntheticLambda3;
        EasingFunctionsKt$$ExternalSyntheticLambda4 externalSyntheticLambda4 = new EasingFunctionsKt$$ExternalSyntheticLambda4();
        EasingFunctionsKt.EaseInBounce = externalSyntheticLambda4;
        EasingFunctionsKt$$ExternalSyntheticLambda5 externalSyntheticLambda5 = new EasingFunctionsKt$$ExternalSyntheticLambda5();
        EasingFunctionsKt.EaseInOutBounce = externalSyntheticLambda5;
    }

    private static final float EaseInBounce$lambda$4(float fraction) {
        return f -= transform;
    }

    private static final float EaseInElastic$lambda$0(float fraction) {
        float i2;
        int cmp;
        double i;
        int i3;
        i3 = 0;
        cmp = Float.compare(fraction, i2) == 0 ? i : i3;
        if (cmp != 0) {
        } else {
            cmp = Float.compare(fraction, i2);
            if (cmp == 0) {
            } else {
                i = i3;
            }
            if (i != 0) {
            } else {
                int i7 = 1092616192;
                i3 = 1093402624;
                i2 = (float)i6;
            }
        }
        return i2;
    }

    private static final float EaseInOutBounce$lambda$5(float fraction) {
        int i;
        float transform;
        androidx.compose.animation.core.Easing easeOutBounce;
        int i2;
        int i5 = 1065353216;
        int i7 = 1;
        final int i8 = 1073741824;
        if (Double.compare(d, l) < 0) {
            i3 /= i8;
        } else {
            i4 /= i8;
        }
        return i;
    }

    private static final float EaseInOutElastic$lambda$2(float fraction) {
        int i2;
        int cmp;
        int i3;
        int i;
        int i4;
        int i5;
        double d2;
        double d;
        final long l = 4608967030507783303L;
        i2 = 0;
        i = 1;
        i4 = 0;
        i3 = Float.compare(fraction, i2) == 0 ? i : i4;
        if (i3 != 0) {
        } else {
            i3 = 1065353216;
            i5 = Float.compare(fraction, i3) == 0 ? i : i4;
            if (i5 != 0) {
                i2 = i3;
            } else {
                if (Float.compare(i2, fraction) <= 0 && Float.compare(fraction, i6) <= 0) {
                    if (Float.compare(fraction, i6) <= 0) {
                    } else {
                        i = i4;
                    }
                } else {
                }
                int i7 = 1093795840;
                i4 = 1092616192;
                int i14 = 1073741824;
                int i17 = 1101004800;
                if (i != 0) {
                    i3 = (double)i14;
                    i15 -= i4;
                    i2 = (float)i4;
                } else {
                    d = (double)i14;
                    i21 -= i7;
                    f += i3;
                }
            }
        }
        return i2;
    }

    private static final float EaseOutBounce$lambda$3(float fraction) {
        int newFraction;
        int i2;
        int i;
        final int i3 = 1089601536;
        final int i4 = 1076887552;
        newFraction = fraction;
        if (Float.compare(newFraction, i6) < 0) {
            i23 *= newFraction;
        } else {
            if (Float.compare(newFraction, i8) < 0) {
                newFraction -= i10;
                i12 += i;
            } else {
                if (Float.compare(newFraction, i14) < 0) {
                    newFraction -= i20;
                    i22 += i;
                } else {
                    newFraction -= i16;
                    i18 += i;
                }
            }
        }
        return i2;
    }

    private static final float EaseOutElastic$lambda$1(float fraction) {
        float i2;
        int cmp;
        int i3;
        double i;
        int i4;
        i = 0;
        cmp = Float.compare(fraction, i2) == 0 ? i3 : i;
        if (cmp != 0) {
        } else {
            i2 = 1065353216;
            if (Float.compare(fraction, i2) == 0) {
            } else {
                i3 = i;
            }
            if (i3 != 0) {
            } else {
                i4 = 1061158912;
                i2 = (float)cmp;
            }
        }
        return i2;
    }

    public static final androidx.compose.animation.core.Easing getEase() {
        return EasingFunctionsKt.Ease;
    }

    public static final androidx.compose.animation.core.Easing getEaseIn() {
        return EasingFunctionsKt.EaseIn;
    }

    public static final androidx.compose.animation.core.Easing getEaseInBack() {
        return EasingFunctionsKt.EaseInBack;
    }

    public static final androidx.compose.animation.core.Easing getEaseInBounce() {
        return EasingFunctionsKt.EaseInBounce;
    }

    public static final androidx.compose.animation.core.Easing getEaseInCirc() {
        return EasingFunctionsKt.EaseInCirc;
    }

    public static final androidx.compose.animation.core.Easing getEaseInCubic() {
        return EasingFunctionsKt.EaseInCubic;
    }

    public static final androidx.compose.animation.core.Easing getEaseInElastic() {
        return EasingFunctionsKt.EaseInElastic;
    }

    public static final androidx.compose.animation.core.Easing getEaseInExpo() {
        return EasingFunctionsKt.EaseInExpo;
    }

    public static final androidx.compose.animation.core.Easing getEaseInOut() {
        return EasingFunctionsKt.EaseInOut;
    }

    public static final androidx.compose.animation.core.Easing getEaseInOutBack() {
        return EasingFunctionsKt.EaseInOutBack;
    }

    public static final androidx.compose.animation.core.Easing getEaseInOutBounce() {
        return EasingFunctionsKt.EaseInOutBounce;
    }

    public static final androidx.compose.animation.core.Easing getEaseInOutCirc() {
        return EasingFunctionsKt.EaseInOutCirc;
    }

    public static final androidx.compose.animation.core.Easing getEaseInOutCubic() {
        return EasingFunctionsKt.EaseInOutCubic;
    }

    public static final androidx.compose.animation.core.Easing getEaseInOutElastic() {
        return EasingFunctionsKt.EaseInOutElastic;
    }

    public static final androidx.compose.animation.core.Easing getEaseInOutExpo() {
        return EasingFunctionsKt.EaseInOutExpo;
    }

    public static final androidx.compose.animation.core.Easing getEaseInOutQuad() {
        return EasingFunctionsKt.EaseInOutQuad;
    }

    public static final androidx.compose.animation.core.Easing getEaseInOutQuart() {
        return EasingFunctionsKt.EaseInOutQuart;
    }

    public static final androidx.compose.animation.core.Easing getEaseInOutQuint() {
        return EasingFunctionsKt.EaseInOutQuint;
    }

    public static final androidx.compose.animation.core.Easing getEaseInOutSine() {
        return EasingFunctionsKt.EaseInOutSine;
    }

    public static final androidx.compose.animation.core.Easing getEaseInQuad() {
        return EasingFunctionsKt.EaseInQuad;
    }

    public static final androidx.compose.animation.core.Easing getEaseInQuart() {
        return EasingFunctionsKt.EaseInQuart;
    }

    public static final androidx.compose.animation.core.Easing getEaseInQuint() {
        return EasingFunctionsKt.EaseInQuint;
    }

    public static final androidx.compose.animation.core.Easing getEaseInSine() {
        return EasingFunctionsKt.EaseInSine;
    }

    public static final androidx.compose.animation.core.Easing getEaseOut() {
        return EasingFunctionsKt.EaseOut;
    }

    public static final androidx.compose.animation.core.Easing getEaseOutBack() {
        return EasingFunctionsKt.EaseOutBack;
    }

    public static final androidx.compose.animation.core.Easing getEaseOutBounce() {
        return EasingFunctionsKt.EaseOutBounce;
    }

    public static final androidx.compose.animation.core.Easing getEaseOutCirc() {
        return EasingFunctionsKt.EaseOutCirc;
    }

    public static final androidx.compose.animation.core.Easing getEaseOutCubic() {
        return EasingFunctionsKt.EaseOutCubic;
    }

    public static final androidx.compose.animation.core.Easing getEaseOutElastic() {
        return EasingFunctionsKt.EaseOutElastic;
    }

    public static final androidx.compose.animation.core.Easing getEaseOutExpo() {
        return EasingFunctionsKt.EaseOutExpo;
    }

    public static final androidx.compose.animation.core.Easing getEaseOutQuad() {
        return EasingFunctionsKt.EaseOutQuad;
    }

    public static final androidx.compose.animation.core.Easing getEaseOutQuart() {
        return EasingFunctionsKt.EaseOutQuart;
    }

    public static final androidx.compose.animation.core.Easing getEaseOutQuint() {
        return EasingFunctionsKt.EaseOutQuint;
    }

    public static final androidx.compose.animation.core.Easing getEaseOutSine() {
        return EasingFunctionsKt.EaseOutSine;
    }
}
