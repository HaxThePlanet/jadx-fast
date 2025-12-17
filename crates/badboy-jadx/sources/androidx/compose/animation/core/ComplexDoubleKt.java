package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\u0008\t\u001a,\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0008\u001a\u00020\u0004H\u0000\u001a\u0015\u0010\t\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0080\n\u001a\u0015\u0010\u000b\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0080\n\u001a\u0015\u0010\u000c\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0080\n¨\u0006\r", d2 = {"complexQuadraticFormula", "Lkotlin/Pair;", "Landroidx/compose/animation/core/ComplexDouble;", "a", "", "b", "c", "complexSqrt", "num", "minus", "other", "plus", "times", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ComplexDoubleKt {
    public static final Pair<androidx.compose.animation.core.ComplexDouble, androidx.compose.animation.core.ComplexDouble> complexQuadraticFormula(double a, double b, double c) {
        int i = c;
        i4 -= i7;
        l3 /= i8;
        int i17 = 0;
        final androidx.compose.animation.core.ComplexDouble num = complexSqrt;
        int i19 = 0;
        ComplexDouble.access$set_real$p(num, d6 += i9);
        int i10 = 0;
        ComplexDouble.access$set_real$p(num, d4 *= i14);
        ComplexDouble.access$set_imaginary$p(num, d5 *= i14);
        int i18 = 0;
        androidx.compose.animation.core.ComplexDouble num2 = complexSqrt2;
        int i21 = 0;
        double d = (double)i26;
        ComplexDouble.access$set_real$p(num2, d7 *= d);
        ComplexDouble.access$set_imaginary$p(num2, d8 *= d);
        int i22 = 0;
        androidx.compose.animation.core.ComplexDouble num3 = num2;
        final int i25 = 0;
        ComplexDouble.access$set_real$p(num3, d9 + i27);
        int i3 = 0;
        ComplexDouble.access$set_real$p(num3, d2 *= i14);
        ComplexDouble.access$set_imaginary$p(num3, d3 *= i14);
        return TuplesKt.to(num, num3);
    }

    public static final androidx.compose.animation.core.ComplexDouble complexSqrt(double num) {
        androidx.compose.animation.core.ComplexDouble complexDouble;
        double sqrt;
        final int i = 0;
        if (Double.compare(num, i) < 0) {
            complexDouble = new ComplexDouble(i, obj1, Math.sqrt(Math.abs(num)), obj4);
        } else {
            complexDouble = new ComplexDouble(Math.sqrt(num), obj4, i, obj1);
        }
        return complexDouble;
    }

    public static final androidx.compose.animation.core.ComplexDouble minus(double $this$minus, androidx.compose.animation.core.ComplexDouble other) {
        final int i = 0;
        final androidx.compose.animation.core.ComplexDouble num = obj11;
        int i2 = 0;
        double d3 = (double)i7;
        ComplexDouble.access$set_real$p(num, d *= d3);
        ComplexDouble.access$set_imaginary$p(num, d2 *= d3);
        final int i6 = 0;
        androidx.compose.animation.core.ComplexDouble num2 = num;
        final int i8 = 0;
        ComplexDouble.access$set_real$p(num2, d4 += i3);
        return num2;
    }

    public static final androidx.compose.animation.core.ComplexDouble plus(double $this$plus, androidx.compose.animation.core.ComplexDouble other) {
        final int i = 0;
        final androidx.compose.animation.core.ComplexDouble num = obj7;
        final int i2 = 0;
        ComplexDouble.access$set_real$p(num, d += $this$plus);
        return num;
    }

    public static final androidx.compose.animation.core.ComplexDouble times(double $this$times, androidx.compose.animation.core.ComplexDouble other) {
        final int i = 0;
        final androidx.compose.animation.core.ComplexDouble num = obj7;
        final int i2 = 0;
        ComplexDouble.access$set_real$p(num, d *= $this$times);
        ComplexDouble.access$set_imaginary$p(num, d2 *= $this$times);
        return num;
    }
}
