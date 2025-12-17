package kotlin.math;

import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\"\n\u0000\n\u0002\u0010\u0006\n\u0002\u0008\u0004\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u00088\u001a\u0011\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\u0008\u001a\u0011\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\u0008\u001a\u0011\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0087\u0008\u001a\u0011\u0010\u0016\u001a\u00020\u000c2\u0006\u0010\u0018\u001a\u00020\u000cH\u0087\u0008\u001a\u0011\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\u0008\u001a\u0011\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\u0008\u001a\u0010\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0011\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\u0008\u001a\u0011\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\u0008\u001a\u0011\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\u0008\u001a\u0010\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0011\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\u0008\u001a\u0011\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\u0008\u001a\u0011\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\u0008\u001a\u0019\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\u0008\u001a\u0019\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\u0008\u001a\u0010\u0010 \u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0011\u0010 \u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\u0008\u001a\u0011\u0010!\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\u0008\u001a\u0011\u0010!\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\u0008\u001a\u0011\u0010\"\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\u0008\u001a\u0011\u0010\"\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\u0008\u001a\u0011\u0010#\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\u0008\u001a\u0011\u0010#\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\u0008\u001a\u0011\u0010$\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\u0008\u001a\u0011\u0010$\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\u0008\u001a\u0011\u0010%\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\u0008\u001a\u0011\u0010%\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\u0008\u001a\u0011\u0010&\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\u0008\u001a\u0011\u0010&\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\u0008\u001a\u0011\u0010'\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\u0008\u001a\u0011\u0010'\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\u0008\u001a\u0019\u0010(\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0001H\u0087\u0008\u001a\u0019\u0010(\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0087\u0008\u001a\u0011\u0010)\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\u0008\u001a\u0011\u0010)\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\u0008\u001a\u0011\u0010*\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\u0008\u001a\u0011\u0010*\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\u0008\u001a\u0018\u0010+\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u0001H\u0007\u001a\u0018\u0010+\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0006H\u0007\u001a\u0011\u0010-\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\u0008\u001a\u0011\u0010-\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\u0008\u001a\u0010\u0010.\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0010\u0010.\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0007\u001a\u0019\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001H\u0087\u0008\u001a\u0019\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006H\u0087\u0008\u001a\u0019\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\tH\u0087\u0008\u001a\u0019\u0010/\u001a\u00020\u000c2\u0006\u00100\u001a\u00020\u000c2\u0006\u00101\u001a\u00020\u000cH\u0087\u0008\u001a\u0019\u00102\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u0001H\u0087\u0008\u001a\u0019\u00102\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006H\u0087\u0008\u001a\u0019\u00102\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\tH\u0087\u0008\u001a\u0019\u00102\u001a\u00020\u000c2\u0006\u00100\u001a\u00020\u000c2\u0006\u00101\u001a\u00020\u000cH\u0087\u0008\u001a\u0011\u00103\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\u0008\u001a\u0011\u00103\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\u0008\u001a\u0011\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\u0008\u001a\u0011\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\u0008\u001a\u0011\u00104\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\u0008\u001a\u0011\u00104\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\u0008\u001a\u0011\u00105\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\u0008\u001a\u0011\u00105\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\u0008\u001a\u0011\u00106\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\u0008\u001a\u0011\u00106\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\u0008\u001a\u0011\u00107\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\u0008\u001a\u0011\u00107\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\u0008\u001a\u0011\u00108\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\u0008\u001a\u0011\u00108\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\u0008\u001a\u0010\u00109\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u0010\u00109\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0007\u001a\u0015\u0010:\u001a\u00020\u0001*\u00020\u00012\u0006\u0010;\u001a\u00020\u0001H\u0087\u0008\u001a\u0015\u0010:\u001a\u00020\u0006*\u00020\u00062\u0006\u0010;\u001a\u00020\u0006H\u0087\u0008\u001a\r\u0010<\u001a\u00020\u0001*\u00020\u0001H\u0087\u0008\u001a\r\u0010<\u001a\u00020\u0006*\u00020\u0006H\u0087\u0008\u001a\u0015\u0010=\u001a\u00020\u0001*\u00020\u00012\u0006\u0010>\u001a\u00020\u0001H\u0087\u0008\u001a\u0015\u0010=\u001a\u00020\u0006*\u00020\u00062\u0006\u0010>\u001a\u00020\u0006H\u0087\u0008\u001a\r\u0010?\u001a\u00020\u0001*\u00020\u0001H\u0087\u0008\u001a\r\u0010?\u001a\u00020\u0006*\u00020\u0006H\u0087\u0008\u001a\u0015\u0010@\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\u0008\u001a\u0015\u0010@\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\tH\u0087\u0008\u001a\u0015\u0010@\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0087\u0008\u001a\u0015\u0010@\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\tH\u0087\u0008\u001a\u000c\u0010A\u001a\u00020\t*\u00020\u0001H\u0007\u001a\u000c\u0010A\u001a\u00020\t*\u00020\u0006H\u0007\u001a\u000c\u0010B\u001a\u00020\u000c*\u00020\u0001H\u0007\u001a\u000c\u0010B\u001a\u00020\u000c*\u00020\u0006H\u0007\u001a\u0015\u0010C\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0087\u0008\u001a\u0015\u0010C\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\tH\u0087\u0008\u001a\u0015\u0010C\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\u0008\u001a\u0015\u0010C\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0087\u0008\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0002\u0010\u0003\u001a\u0004\u0008\u0004\u0010\u0005\"\u001f\u0010\u0000\u001a\u00020\u0006*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0002\u0010\u0007\u001a\u0004\u0008\u0004\u0010\u0008\"\u001f\u0010\u0000\u001a\u00020\t*\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0002\u0010\n\u001a\u0004\u0008\u0004\u0010\u000b\"\u001f\u0010\u0000\u001a\u00020\u000c*\u00020\u000c8Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0002\u0010\r\u001a\u0004\u0008\u0004\u0010\u000e\"\u001f\u0010\u000f\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0010\u0010\u0003\u001a\u0004\u0008\u0011\u0010\u0005\"\u001f\u0010\u000f\u001a\u00020\u0006*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0010\u0010\u0007\u001a\u0004\u0008\u0011\u0010\u0008\"\u001e\u0010\u000f\u001a\u00020\t*\u00020\t8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0010\u0010\n\u001a\u0004\u0008\u0011\u0010\u000b\"\u001e\u0010\u000f\u001a\u00020\t*\u00020\u000c8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0010\u0010\r\u001a\u0004\u0008\u0011\u0010\u0012\"\u001f\u0010\u0013\u001a\u00020\u0001*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0014\u0010\u0003\u001a\u0004\u0008\u0015\u0010\u0005\"\u001f\u0010\u0013\u001a\u00020\u0006*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0014\u0010\u0007\u001a\u0004\u0008\u0015\u0010\u0008¨\u0006D", d2 = {"absoluteValue", "", "getAbsoluteValue$annotations", "(D)V", "getAbsoluteValue", "(D)D", "", "(F)V", "(F)F", "", "(I)V", "(I)I", "", "(J)V", "(J)J", "sign", "getSign$annotations", "getSign", "(J)I", "ulp", "getUlp$annotations", "getUlp", "abs", "x", "n", "acos", "acosh", "asin", "asinh", "atan", "atan2", "y", "atanh", "cbrt", "ceil", "cos", "cosh", "exp", "expm1", "floor", "hypot", "ln", "ln1p", "log", "base", "log10", "log2", "max", "a", "b", "min", "round", "sin", "sinh", "sqrt", "tan", "tanh", "truncate", "IEEErem", "divisor", "nextDown", "nextTowards", "to", "nextUp", "pow", "roundToInt", "roundToLong", "withSign", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/math/MathKt")
class MathKt__MathJVMKt extends kotlin.math.MathKt__MathHKt {
    private static final double IEEErem(double $this$IEEErem, double divisor) {
        return Math.IEEEremainder($this$IEEErem, divisor);
    }

    private static final float IEEErem(float $this$IEEErem, float divisor) {
        return (float)d2;
    }

    private static final double abs(double x) {
        return Math.abs(x);
    }

    private static final float abs(float x) {
        return Math.abs(x);
    }

    private static final int abs(int n) {
        return Math.abs(n);
    }

    private static final long abs(long n) {
        return Math.abs(n);
    }

    private static final double acos(double x) {
        return Math.acos(x);
    }

    private static final float acos(float x) {
        return (float)acos;
    }

    public static final double acosh(double x) {
        int y;
        double result;
        int cmp;
        int taylor_n_bound;
        double d;
        if (Double.compare(x, l) < 0) {
            y = 9221120237041090560L;
        } else {
            if (Double.compare(x, upper_taylor_2_bound) > 0) {
                d2 += result;
            } else {
                double d3 = (double)i;
                if (Double.compare(i4, taylor_n_bound) >= 0) {
                    y = Math.log(sqrt2 += x);
                } else {
                    double sqrt = Math.sqrt(x - d3);
                    if (Double.compare(sqrt, taylor_2_bound) >= 0) {
                        result -= cmp;
                    }
                    y = taylor_n_bound;
                }
            }
        }
        return y;
    }

    private static final float acosh(float x) {
        return (float)acosh;
    }

    private static final double asin(double x) {
        return Math.asin(x);
    }

    private static final float asin(float x) {
        return (float)asin;
    }

    public static final double asinh(double x) {
        int result;
        double d;
        int cmp;
        double taylor_2_bound;
        if (Double.compare(x, taylor_n_bound) >= 0) {
            d = 1;
            if (Double.compare(x, upper_taylor_n_bound) > 0) {
                if (Double.compare(x, upper_taylor_2_bound) > 0) {
                    d2 += cmp;
                } else {
                    double d6 = (double)i3;
                    result = Math.log(i10 += i4);
                }
            } else {
                result = Math.log(sqrt += x);
            }
        } else {
            if (Double.compare(x, i) <= 0) {
                result = -asinh;
            } else {
                if (Double.compare(d5, taylor_2_bound) >= 0) {
                    result -= cmp;
                }
            }
        }
        return result;
    }

    private static final float asinh(float x) {
        return (float)asinh;
    }

    private static final double atan(double x) {
        return Math.atan(x);
    }

    private static final float atan(float x) {
        return (float)atan;
    }

    private static final double atan2(double y, double x) {
        return Math.atan2(y, x);
    }

    private static final float atan2(float y, float x) {
        return (float)atan2;
    }

    public static final double atanh(double x) {
        int result;
        int cmp;
        double taylor_2_bound;
        if (Double.compare(d, taylor_n_bound) < 0 && Double.compare(d4, taylor_2_bound) > 0) {
            if (Double.compare(d4, taylor_2_bound) > 0) {
                result += cmp;
            }
            return result;
        }
        double d2 = (double)result2;
        return d3 /= d5;
    }

    private static final float atanh(float x) {
        return (float)atanh;
    }

    private static final double cbrt(double x) {
        return Math.cbrt(x);
    }

    private static final float cbrt(float x) {
        return (float)cbrt;
    }

    private static final double ceil(double x) {
        return Math.ceil(x);
    }

    private static final float ceil(float x) {
        return (float)ceil;
    }

    private static final double cos(double x) {
        return Math.cos(x);
    }

    private static final float cos(float x) {
        return (float)d2;
    }

    private static final double cosh(double x) {
        return Math.cosh(x);
    }

    private static final float cosh(float x) {
        return (float)cosh;
    }

    private static final double exp(double x) {
        return Math.exp(x);
    }

    private static final float exp(float x) {
        return (float)d2;
    }

    private static final double expm1(double x) {
        return Math.expm1(x);
    }

    private static final float expm1(float x) {
        return (float)expm1;
    }

    private static final double floor(double x) {
        return Math.floor(x);
    }

    private static final float floor(float x) {
        return (float)floor;
    }

    private static final double getAbsoluteValue(double $this$absoluteValue) {
        return Math.abs($this$absoluteValue);
    }

    private static final float getAbsoluteValue(float $this$absoluteValue) {
        return Math.abs($this$absoluteValue);
    }

    private static final int getAbsoluteValue(int $this$absoluteValue) {
        return Math.abs($this$absoluteValue);
    }

    private static final long getAbsoluteValue(long $this$absoluteValue) {
        return Math.abs($this$absoluteValue);
    }

    public static void getAbsoluteValue$annotations(double d) {
    }

    public static void getAbsoluteValue$annotations(float f) {
    }

    public static void getAbsoluteValue$annotations(int i) {
    }

    public static void getAbsoluteValue$annotations(long l) {
    }

    private static final double getSign(double $this$sign) {
        return Math.signum($this$sign);
    }

    private static final float getSign(float $this$sign) {
        return Math.signum($this$sign);
    }

    public static final int getSign(int $this$sign) {
        return Integer.signum($this$sign);
    }

    public static final int getSign(long $this$sign) {
        return Long.signum($this$sign);
    }

    public static void getSign$annotations(double d) {
    }

    public static void getSign$annotations(float f) {
    }

    public static void getSign$annotations(int i) {
    }

    public static void getSign$annotations(long l) {
    }

    private static final double getUlp(double $this$ulp) {
        return Math.ulp($this$ulp);
    }

    private static final float getUlp(float $this$ulp) {
        return Math.ulp($this$ulp);
    }

    public static void getUlp$annotations(double d) {
    }

    public static void getUlp$annotations(float f) {
    }

    private static final double hypot(double x, double y) {
        return Math.hypot(x, y);
    }

    private static final float hypot(float x, float y) {
        return (float)hypot;
    }

    private static final double ln(double x) {
        return Math.log(x);
    }

    private static final float ln(float x) {
        return (float)d2;
    }

    private static final double ln1p(double x) {
        return Math.log1p(x);
    }

    private static final float ln1p(float x) {
        return (float)log1p;
    }

    public static final double log(double x, double base) {
        int cmp;
        if (Double.compare(obj6, i) > 0) {
            cmp = Double.compare(obj6, l2) == 0 ? 1 : 0;
            if (cmp != 0) {
            }
            return d /= d2;
        }
        return 9221120237041090560L;
    }

    public static final float log(float x, float base) {
        int cmp;
        if (Float.compare(base, i) > 0) {
            cmp = Float.compare(base, i3) == 0 ? 1 : 0;
            if (cmp != 0) {
            }
            return (float)i4;
        }
        return 2143289344;
    }

    private static final double log10(double x) {
        return Math.log10(x);
    }

    private static final float log10(float x) {
        return (float)log10;
    }

    public static final double log2(double x) {
        return d /= lN2;
    }

    public static final float log2(float x) {
        return (float)i;
    }

    private static final double max(double a, double b) {
        return Math.max(a, b);
    }

    private static final float max(float a, float b) {
        return Math.max(a, b);
    }

    private static final int max(int a, int b) {
        return Math.max(a, b);
    }

    private static final long max(long a, long b) {
        return Math.max(a, b);
    }

    private static final double min(double a, double b) {
        return Math.min(a, b);
    }

    private static final float min(float a, float b) {
        return Math.min(a, b);
    }

    private static final int min(int a, int b) {
        return Math.min(a, b);
    }

    private static final long min(long a, long b) {
        return Math.min(a, b);
    }

    private static final double nextDown(double $this$nextDown) {
        return Math.nextAfter($this$nextDown, obj3);
    }

    private static final float nextDown(float $this$nextDown) {
        return Math.nextAfter($this$nextDown, -4503599627370496L);
    }

    private static final double nextTowards(double $this$nextTowards, double to) {
        return Math.nextAfter($this$nextTowards, to);
    }

    private static final float nextTowards(float $this$nextTowards, float to) {
        return Math.nextAfter($this$nextTowards, (double)to);
    }

    private static final double nextUp(double $this$nextUp) {
        return Math.nextUp($this$nextUp);
    }

    private static final float nextUp(float $this$nextUp) {
        return Math.nextUp($this$nextUp);
    }

    private static final double pow(double $this$pow, double x) {
        return Math.pow($this$pow, x);
    }

    private static final double pow(double $this$pow, int n) {
        return Math.pow($this$pow, n);
    }

    private static final float pow(float $this$pow, float x) {
        return (float)d2;
    }

    private static final float pow(float $this$pow, int n) {
        return (float)d2;
    }

    private static final double round(double x) {
        return Math.rint(x);
    }

    private static final float round(float x) {
        return (float)rint;
    }

    public static final int roundToInt(double $this$roundToInt) {
        int i;
        if (Double.isNaN($this$roundToInt)) {
        } else {
            if (Double.compare($this$roundToInt, l) > 0) {
                i = Integer.MAX_VALUE;
            } else {
                if (Double.compare($this$roundToInt, l2) < 0) {
                    i = Integer.MIN_VALUE;
                } else {
                    i = (int)round;
                }
            }
            return i;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot round NaN value.");
        throw illegalArgumentException;
    }

    public static final int roundToInt(float $this$roundToInt) {
        if (Float.isNaN($this$roundToInt)) {
        } else {
            return Math.round($this$roundToInt);
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot round NaN value.");
        throw illegalArgumentException;
    }

    public static final long roundToLong(double $this$roundToLong) {
        if (Double.isNaN($this$roundToLong)) {
        } else {
            return Math.round($this$roundToLong);
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot round NaN value.");
        throw illegalArgumentException;
    }

    public static final long roundToLong(float $this$roundToLong) {
        return MathKt.roundToLong((double)$this$roundToLong);
    }

    private static final double sign(double x) {
        return Math.signum(x);
    }

    private static final float sign(float x) {
        return Math.signum(x);
    }

    private static final double sin(double x) {
        return Math.sin(x);
    }

    private static final float sin(float x) {
        return (float)d2;
    }

    private static final double sinh(double x) {
        return Math.sinh(x);
    }

    private static final float sinh(float x) {
        return (float)sinh;
    }

    private static final double sqrt(double x) {
        return Math.sqrt(x);
    }

    private static final float sqrt(float x) {
        return (float)sqrt;
    }

    private static final double tan(double x) {
        return Math.tan(x);
    }

    private static final float tan(float x) {
        return (float)d2;
    }

    private static final double tanh(double x) {
        return Math.tanh(x);
    }

    private static final float tanh(float x) {
        return (float)tanh;
    }

    public static final double truncate(double x) {
        int floor;
        boolean naN;
        if (!Double.isNaN(x)) {
            if (Double.isInfinite(x)) {
                floor = x;
            } else {
                if (Double.compare(x, i) > 0) {
                    floor = Math.floor(x);
                } else {
                    floor = Math.ceil(x);
                }
            }
        } else {
        }
        return floor;
    }

    public static final float truncate(float x) {
        float f;
        boolean naN;
        if (!Float.isNaN(x)) {
            if (Float.isInfinite(x)) {
                f = x;
            } else {
                if (Float.compare(x, i) > 0) {
                    f = (float)floor;
                } else {
                    f = (float)ceil;
                }
            }
        } else {
        }
        return f;
    }

    private static final double withSign(double $this$withSign, double sign) {
        return Math.copySign($this$withSign, sign);
    }

    private static final double withSign(double $this$withSign, int sign) {
        return Math.copySign($this$withSign, sign);
    }

    private static final float withSign(float $this$withSign, float sign) {
        return Math.copySign($this$withSign, sign);
    }

    private static final float withSign(float $this$withSign, int sign) {
        return Math.copySign($this$withSign, (float)sign);
    }
}
