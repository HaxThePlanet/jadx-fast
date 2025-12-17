package androidx.compose.ui.graphics.colorspace;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\u0008\u0018\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000cR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000cR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000cR\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000cR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u000c¨\u0006\"", d2 = {"Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "", "gamma", "", "a", "b", "c", "d", "e", "f", "(DDDDDDD)V", "getA", "()D", "getB", "getC", "getD", "getE", "getF", "getGamma", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TransferParameters {

    private final double a;
    private final double b;
    private final double c;
    private final double d;
    private final double e;
    private final double f;
    private final double gamma;
    public TransferParameters(double gamma, double a, double b, double c, double d, double e, double f) {
        boolean naN;
        int cmp;
        int i2;
        int cmp3;
        double d2;
        int cmp2;
        int i;
        long l;
        final Object obj = this;
        super();
        obj.gamma = gamma;
        obj.a = b;
        obj.b = d;
        obj.c = f;
        obj.d = obj29;
        obj.e = obj31;
        obj.f = obj33;
        if (Double.isNaN(obj.a)) {
        } else {
            if (Double.isNaN(obj.b)) {
            } else {
                if (Double.isNaN(obj.c)) {
                } else {
                    if (Double.isNaN(obj.d)) {
                    } else {
                        if (Double.isNaN(obj.e)) {
                        } else {
                            if (Double.isNaN(obj.f)) {
                            } else {
                                if (Double.isNaN(obj.gamma)) {
                                } else {
                                    final int i3 = 0;
                                    if (Double.compare(d10, i3) < 0) {
                                    } else {
                                        l = 4607182418800017408L;
                                        if (Double.compare(d11, l) > 0) {
                                        } else {
                                            final int i4 = 0;
                                            i2 = Double.compare(d12, i3) == 0 ? 1 : i4;
                                            if (i2 != 0) {
                                                d2 = Double.compare(d19, i3) == 0 ? 1 : i4;
                                                if (d2 != 0) {
                                                } else {
                                                    d2 = Double.compare(gamma5, i3) == 0 ? 1 : i4;
                                                    if (d2 != 0) {
                                                    } else {
                                                    }
                                                }
                                                IllegalArgumentException illegalArgumentException7 = new IllegalArgumentException("Parameter a or g is zero, the transfer function is constant");
                                                throw illegalArgumentException7;
                                            }
                                            if (Double.compare(d15, l) >= 0) {
                                                cmp2 = Double.compare(d16, i3) == 0 ? 1 : i4;
                                                if (cmp2 != 0) {
                                                } else {
                                                }
                                                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Parameter c is zero, the transfer function is constant");
                                                throw illegalArgumentException3;
                                            }
                                            i = Double.compare(d17, i3) == 0 ? 1 : i4;
                                            if (i == 0) {
                                                i = Double.compare(gamma4, i3) == 0 ? 1 : i4;
                                                if (i != 0) {
                                                    i = Double.compare(d18, i3) == 0 ? 1 : i4;
                                                    if (i != 0) {
                                                    } else {
                                                        if (Double.compare(d13, i3) < 0) {
                                                        } else {
                                                            if (Double.compare(d14, i3) < 0) {
                                                            } else {
                                                                if (Double.compare(gamma3, i3) < 0) {
                                                                } else {
                                                                }
                                                            }
                                                            IllegalArgumentException illegalArgumentException5 = new IllegalArgumentException("The transfer function must be positive or increasing");
                                                            throw illegalArgumentException5;
                                                        }
                                                    }
                                                } else {
                                                }
                                                IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("The transfer function must be increasing");
                                                throw illegalArgumentException4;
                                            } else {
                                            }
                                            IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("Parameter a or g is zero, and c is zero, the transfer function is constant");
                                            throw illegalArgumentException6;
                                        }
                                    }
                                    StringBuilder stringBuilder = new StringBuilder();
                                    IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder.append("Parameter d must be in the range [0..1], was ").append(obj.d).toString());
                                    throw illegalArgumentException2;
                                }
                            }
                        }
                    }
                }
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Parameters cannot be NaN");
        throw illegalArgumentException;
    }

    public TransferParameters(double d, double d2, double d3, double d4, double d5, double d6, double d7, int i8, DefaultConstructorMarker defaultConstructorMarker9) {
        int i2;
        int i;
        final int i5 = 0;
        i2 = obj33 & 32 != 0 ? i5 : obj29;
        i = obj33 & 64 != 0 ? i5 : obj31;
        super(d, obj5, d3, obj7, d5, obj9, d7, obj11, defaultConstructorMarker9, obj13, i2, obj15, i, obj17);
    }

    public static androidx.compose.ui.graphics.colorspace.TransferParameters copy$default(androidx.compose.ui.graphics.colorspace.TransferParameters transferParameters, double d2, double d3, double d4, double d5, double d6, double d7, double d8, int i9, Object object10) {
        double gamma;
        double d9;
        double d11;
        double d10;
        double d;
        double d12;
        int i;
        double obj28;
        gamma = obj29 & 1 != 0 ? transferParameters.gamma : d2;
        d9 = obj29 & 2 != 0 ? transferParameters.a : d4;
        d11 = obj29 & 4 != 0 ? transferParameters.b : d6;
        d10 = obj29 & 8 != 0 ? transferParameters.c : d8;
        d = obj29 & 16 != 0 ? transferParameters.d : object10;
        d12 = obj29 & 32 != 0 ? transferParameters.e : obj25;
        obj28 = obj29 & 64 != 0 ? i : obj27;
        return transferParameters.copy(gamma, d4, d9, d6, d11, d8, d10);
    }

    public final double component1() {
        return this.gamma;
    }

    public final double component2() {
        return this.a;
    }

    public final double component3() {
        return this.b;
    }

    public final double component4() {
        return this.c;
    }

    public final double component5() {
        return this.d;
    }

    public final double component6() {
        return this.e;
    }

    public final double component7() {
        return this.f;
    }

    public final androidx.compose.ui.graphics.colorspace.TransferParameters copy(double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        TransferParameters transferParameters = new TransferParameters(d, obj2, d3, obj4, d5, obj6, d7, obj8, obj24, obj10, obj26, obj12, obj28, obj14);
        return transferParameters;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof TransferParameters) {
            return i2;
        }
        Object obj = object;
        if (Double.compare(this.gamma, obj4) != 0) {
            return i2;
        }
        if (Double.compare(this.a, obj4) != 0) {
            return i2;
        }
        if (Double.compare(this.b, obj4) != 0) {
            return i2;
        }
        if (Double.compare(this.c, obj4) != 0) {
            return i2;
        }
        if (Double.compare(this.d, obj4) != 0) {
            return i2;
        }
        if (Double.compare(this.e, obj4) != 0) {
            return i2;
        }
        if (Double.compare(this.f, obj4) != 0) {
            return i2;
        }
        return i;
    }

    public final double getA() {
        return this.a;
    }

    public final double getB() {
        return this.b;
    }

    public final double getC() {
        return this.c;
    }

    public final double getD() {
        return this.d;
    }

    public final double getE() {
        return this.e;
    }

    public final double getF() {
        return this.f;
    }

    public final double getGamma() {
        return this.gamma;
    }

    public int hashCode() {
        return i6 += i19;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("TransferParameters(gamma=").append(this.gamma).append(", a=").append(this.a).append(", b=").append(this.b).append(", c=").append(this.c).append(", d=").append(this.d).append(", e=").append(this.e).append(", f=").append(this.f).append(')').toString();
    }
}
