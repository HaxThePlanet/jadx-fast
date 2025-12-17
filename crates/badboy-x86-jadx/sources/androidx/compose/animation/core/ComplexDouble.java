package androidx.compose.animation.core;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0080\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u000b\u001a\u00020\u0003HÂ\u0003J\t\u0010\u000c\u001a\u00020\u0003HÂ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0011\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0003H\u0086\nJ\u0013\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0011\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000H\u0086\nJ\u0011\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0003H\u0086\nJ\u0011\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000H\u0086\nJ\u0011\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0003H\u0086\nJ\u0011\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000H\u0086\nJ\u0011\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0003H\u0086\nJ\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0000H\u0086\nR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\t\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0008¨\u0006\u001a", d2 = {"Landroidx/compose/animation/core/ComplexDouble;", "", "_real", "", "_imaginary", "(DD)V", "imaginary", "getImaginary", "()D", "real", "getReal", "component1", "component2", "copy", "div", "other", "equals", "", "hashCode", "", "minus", "plus", "times", "toString", "", "unaryMinus", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ComplexDouble {

    public static final int $stable = 8;
    private double _imaginary;
    private double _real;
    static {
        final int i = 8;
    }

    public ComplexDouble(double _real, double _imaginary) {
        super();
        this._real = _real;
        this._imaginary = obj3;
    }

    public static final double access$get_imaginary$p(androidx.compose.animation.core.ComplexDouble $this) {
        return $this._imaginary;
    }

    public static final double access$get_real$p(androidx.compose.animation.core.ComplexDouble $this) {
        return $this._real;
    }

    public static final void access$set_imaginary$p(androidx.compose.animation.core.ComplexDouble $this, double <set-?>) {
        $this._imaginary = <set-?>;
    }

    public static final void access$set_real$p(androidx.compose.animation.core.ComplexDouble $this, double <set-?>) {
        $this._real = <set-?>;
    }

    private final double component1() {
        return this._real;
    }

    private final double component2() {
        return this._imaginary;
    }

    public static androidx.compose.animation.core.ComplexDouble copy$default(androidx.compose.animation.core.ComplexDouble complexDouble, double d2, double d3, int i4, Object object5) {
        double obj1;
        double obj3;
        if (obj5 & 1 != 0) {
            obj1 = complexDouble._real;
        }
        if (obj5 &= 2 != 0) {
            obj3 = complexDouble._imaginary;
        }
        return complexDouble.copy(obj1, d3);
    }

    public final androidx.compose.animation.core.ComplexDouble copy(double d, double d2) {
        ComplexDouble complexDouble = new ComplexDouble(d, d2, obj4, obj5);
        return complexDouble;
    }

    public final androidx.compose.animation.core.ComplexDouble div(double other) {
        final int i = 0;
        ComplexDouble.access$set_real$p(this, d /= other);
        ComplexDouble.access$set_imaginary$p(this, d2 /= other);
        return this;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ComplexDouble) {
            return i2;
        }
        Object obj = object;
        if (Double.compare(this._real, obj4) != 0) {
            return i2;
        }
        if (Double.compare(this._imaginary, obj4) != 0) {
            return i2;
        }
        return i;
    }

    public final double getImaginary() {
        return this._imaginary;
    }

    public final double getReal() {
        return this._real;
    }

    public int hashCode() {
        return i2 += i4;
    }

    public final androidx.compose.animation.core.ComplexDouble minus(double other) {
        final int i = 0;
        final androidx.compose.animation.core.ComplexDouble num = this;
        final int i3 = 0;
        ComplexDouble.access$set_real$p(num, d += i2);
        return num;
    }

    public final androidx.compose.animation.core.ComplexDouble minus(androidx.compose.animation.core.ComplexDouble other) {
        final int i = 0;
        final androidx.compose.animation.core.ComplexDouble num = other;
        int i2 = 0;
        double d5 = (double)i8;
        ComplexDouble.access$set_real$p(num, d *= d5);
        ComplexDouble.access$set_imaginary$p(num, d2 *= d5);
        androidx.compose.animation.core.ComplexDouble num2 = this;
        int i5 = 0;
        ComplexDouble.access$set_real$p(num2, d3 += real);
        ComplexDouble.access$set_imaginary$p(num2, d4 += imaginary);
        return num2;
    }

    public final androidx.compose.animation.core.ComplexDouble plus(double other) {
        final int i = 0;
        ComplexDouble.access$set_real$p(this, d += other);
        return this;
    }

    public final androidx.compose.animation.core.ComplexDouble plus(androidx.compose.animation.core.ComplexDouble other) {
        final int i = 0;
        ComplexDouble.access$set_real$p(this, d += real);
        ComplexDouble.access$set_imaginary$p(this, d2 += imaginary);
        return this;
    }

    public final androidx.compose.animation.core.ComplexDouble times(double other) {
        final int i = 0;
        ComplexDouble.access$set_real$p(this, d *= other);
        ComplexDouble.access$set_imaginary$p(this, d2 *= other);
        return this;
    }

    public final androidx.compose.animation.core.ComplexDouble times(androidx.compose.animation.core.ComplexDouble other) {
        final int i = 0;
        ComplexDouble.access$set_real$p(this, i2 -= i6);
        ComplexDouble.access$set_imaginary$p(this, i4 += i7);
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ComplexDouble(_real=").append(this._real).append(", _imaginary=").append(this._imaginary).append(')').toString();
    }

    public final androidx.compose.animation.core.ComplexDouble unaryMinus() {
        final int i = 0;
        double d3 = (double)i4;
        ComplexDouble.access$set_real$p(this, d *= d3);
        ComplexDouble.access$set_imaginary$p(this, d2 *= d3);
        return this;
    }
}
