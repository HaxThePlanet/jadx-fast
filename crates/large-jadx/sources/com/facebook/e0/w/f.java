package com.facebook.e0.w;

import com.facebook.internal.g0.i.a;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u000b\u0008Á\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u001b\u0010\u0008\u001a\u00020\u00062\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00060\nH\u0007¢\u0006\u0002\u0010\u000bJ\u0018\u0010\u000c\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0007J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J+\u0010\u000f\u001a\u00020\u00062\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00110\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0013H\u0007J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0013H\u0007J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0007J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u001e", d2 = {"Lcom/facebook/appevents/ml/Operator;", "", "()V", "addmv", "", "x", "Lcom/facebook/appevents/ml/MTensor;", "b", "concatenate", "tensors", "", "([Lcom/facebook/appevents/ml/MTensor;)Lcom/facebook/appevents/ml/MTensor;", "conv1D", "w", "dense", "embedding", "texts", "", "seqLength", "", "([Ljava/lang/String;ILcom/facebook/appevents/ml/MTensor;)Lcom/facebook/appevents/ml/MTensor;", "flatten", "startDim", "maxPool1D", "poolSize", "mul", "relu", "softmax", "transpose2D", "transpose3D", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class f {
    static {
    }

    public static final void a(com.facebook.e0.w.a a, com.facebook.e0.w.a a2) {
        int i4;
        int i5;
        int i;
        int i2;
        int i3;
        float f;
        if (a.d(f.class)) {
        }
        n.f(a, "x");
        n.f(a2, "b");
        int i6 = 0;
        int i9 = a.b(1);
        int i11 = a.b(2);
        final float[] obj11 = a.a();
        i4 = i6;
        while (i4 < a.b(i6)) {
            i5 = i6;
            while (i5 < i9) {
                i = i6;
                while (i < i11) {
                    i14 += i;
                    obj11[i2] = f2 += f;
                    i++;
                }
                i5++;
                i14 += i;
                obj11[i2] = f2 += f;
                i++;
            }
            i4++;
            i = i6;
            while (i < i11) {
                i14 += i;
                obj11[i2] = f2 += f;
                i++;
            }
            i5++;
            i14 += i;
            obj11[i2] = f2 += f;
            i++;
        }
    }

    public static final com.facebook.e0.w.a b(com.facebook.e0.w.a[] aArr) {
        int i5;
        int i8;
        int i6;
        Object obj;
        int i7;
        int i;
        int length;
        int i4;
        float[] fArr;
        int i2;
        int i3;
        if (a.d(f.class)) {
            return null;
        }
        n.f(aArr, "tensors");
        int i9 = 0;
        int i11 = aArr[i9].b(i9);
        i8 = i5;
        int i13 = 1;
        while (i5 < aArr.length) {
            i8 += i6;
            i5++;
            i13 = 1;
        }
        int[] iArr = new int[2];
        iArr[i9] = i11;
        iArr[i13] = i8;
        a aVar = new a(iArr);
        i7 = i9;
        while (i7 < i11) {
            i = i7 * i8;
            i4 = i9;
            while (i4 < aArr.length) {
                i2 = aArr[i4].b(i13);
                System.arraycopy(aArr[i4].a(), i7 * i2, aVar.a(), i, i2);
                i += i2;
                i4++;
            }
            i7++;
            i2 = aArr[i4].b(i13);
            System.arraycopy(aArr[i4].a(), i7 * i2, fArr2, i, i2);
            i += i2;
            i4++;
        }
        return aVar;
    }

    public static final com.facebook.e0.w.a c(com.facebook.e0.w.a a, com.facebook.e0.w.a a2) {
        int i6;
        int i;
        int i5;
        int i4;
        int[] iArr;
        int i7;
        int i3;
        int i2;
        float f;
        Object obj = a;
        Object obj2 = a2;
        if (a.d(f.class)) {
            return null;
        }
        n.f(obj, "x");
        n.f(obj2, "w");
        i6 = 0;
        final int i14 = obj.b(i6);
        int i15 = 1;
        final int i16 = obj.b(i15);
        int i17 = 2;
        final int i18 = obj.b(i17);
        final int i19 = obj2.b(i6);
        i20 += i15;
        final int i22 = obj2.b(i17);
        iArr = new int[3];
        iArr[i6] = i14;
        iArr[i15] = i21;
        iArr[i17] = i22;
        a aVar = new a(iArr);
        i4 = i6;
        while (i4 < i14) {
            iArr = i6;
            while (iArr < i22) {
                i7 = i6;
                while (i7 < i21) {
                    i3 = 0;
                    while (i6 < i19) {
                        i5 = 0;
                        while (i5 < i18) {
                            i3 += i2;
                            i5++;
                        }
                        i6++;
                        i = 0;
                        i3 += i2;
                        i5++;
                    }
                    aVar.a()[i11 += iArr] = i3;
                    i7++;
                    i6 = 0;
                    i = 0;
                    i5 = 0;
                    while (i5 < i18) {
                        i3 += i2;
                        i5++;
                    }
                    i6++;
                    i = 0;
                    i3 += i2;
                    i5++;
                }
                iArr++;
                i6 = 0;
                i = 0;
                i3 = 0;
                while (i6 < i19) {
                    i5 = 0;
                    while (i5 < i18) {
                        i3 += i2;
                        i5++;
                    }
                    i6++;
                    i = 0;
                    i3 += i2;
                    i5++;
                }
                fArr3[i11 += iArr] = i3;
                i7++;
                i6 = 0;
                i = 0;
                i5 = 0;
                while (i5 < i18) {
                    i3 += i2;
                    i5++;
                }
                i6++;
                i = 0;
                i3 += i2;
                i5++;
            }
            i4++;
            i6 = 0;
            i = 0;
            i7 = i6;
            while (i7 < i21) {
                i3 = 0;
                while (i6 < i19) {
                    i5 = 0;
                    while (i5 < i18) {
                        i3 += i2;
                        i5++;
                    }
                    i6++;
                    i = 0;
                    i3 += i2;
                    i5++;
                }
                fArr3[i11 += iArr] = i3;
                i7++;
                i6 = 0;
                i = 0;
                i5 = 0;
                while (i5 < i18) {
                    i3 += i2;
                    i5++;
                }
                i6++;
                i = 0;
                i3 += i2;
                i5++;
            }
            iArr++;
            i6 = 0;
            i = 0;
            i3 = 0;
            while (i6 < i19) {
                i5 = 0;
                while (i5 < i18) {
                    i3 += i2;
                    i5++;
                }
                i6++;
                i = 0;
                i3 += i2;
                i5++;
            }
            fArr3[i11 += iArr] = i3;
            i7++;
            i6 = 0;
            i = 0;
            i5 = 0;
            while (i5 < i18) {
                i3 += i2;
                i5++;
            }
            i6++;
            i = 0;
            i3 += i2;
            i5++;
        }
        return aVar;
    }

    public static final com.facebook.e0.w.a d(com.facebook.e0.w.a a, com.facebook.e0.w.a a2, com.facebook.e0.w.a a3) {
        int i4;
        int i3;
        int i2;
        int i;
        float f;
        if (a.d(f.class)) {
            return null;
        }
        n.f(a, "x");
        n.f(a2, "w");
        n.f(a3, "b");
        int i5 = 0;
        final int i8 = a3.b(i5);
        final com.facebook.e0.w.a obj10 = f.h(a, a2);
        final float[] obj12 = obj10.a();
        i4 = i5;
        while (i4 < a.b(i5)) {
            i3 = i5;
            while (i3 < i8) {
                i9 += i3;
                obj12[i2] = f2 += f;
                i3++;
            }
            i4++;
            i9 += i3;
            obj12[i2] = f2 += f;
            i3++;
        }
        return obj10;
    }

    public static final com.facebook.e0.w.a e(String[] stringArr, int i2, com.facebook.e0.w.a a3) {
        int i3;
        int[] iArr;
        int i4;
        int i5;
        int i;
        int i6;
        if (a.d(f.class)) {
            return null;
        }
        n.f(stringArr, "texts");
        n.f(a3, "w");
        int length = stringArr.length;
        int i8 = 1;
        final int i10 = a3.b(i8);
        int[] iArr2 = new int[3];
        final int i12 = 0;
        iArr2[i12] = length;
        iArr2[i8] = i2;
        iArr2[2] = i10;
        a aVar = new a(iArr2);
        i3 = i12;
        while (i3 < length) {
            i4 = i12;
            while (i4 < i2) {
                System.arraycopy(a3.a(), i13 *= i10, aVar.a(), i15 += i6, i10);
                i4++;
            }
            i3++;
            System.arraycopy(obj15, i13 *= i10, fArr, i15 += i6, i10);
            i4++;
        }
        return aVar;
    }

    public static final void f(com.facebook.e0.w.a a, int i2) {
        int i;
        int i5;
        int i3;
        int i4;
        if (a.d(f.class)) {
        }
        n.f(a, "x");
        if (i2 >= a.c()) {
        }
        i = 1;
        i5 = i2;
        while (i5 < a.c()) {
            i *= i4;
            i5++;
        }
        int[] iArr = new int[i2 + 1];
        i3 = 0;
        while (i3 < i2) {
            iArr[i3] = a.b(i3);
            i3++;
        }
        iArr[i2] = i;
        a.d(iArr);
    }

    public static final com.facebook.e0.w.a g(com.facebook.e0.w.a a, int i2) {
        int i8;
        int i5;
        int i3;
        int[] iArr;
        int i9;
        int i4;
        int i;
        int i6;
        int i7;
        Object obj = a;
        final int i11 = i2;
        if (a.d(f.class)) {
            return null;
        }
        n.f(obj, "x");
        i8 = 0;
        final int i12 = obj.b(i8);
        int i13 = 1;
        final int i14 = obj.b(i13);
        int i15 = 2;
        final int i16 = obj.b(i15);
        i17 += i13;
        iArr = new int[3];
        iArr[i8] = i12;
        iArr[i13] = i18;
        iArr[i15] = i16;
        a aVar = new a(iArr);
        float[] fArr2 = aVar.a();
        i3 = i8;
        while (i3 < i12) {
            iArr = i8;
            while (iArr < i16) {
                i9 = i8;
                while (i9 < i18) {
                    int i23 = i9 * i16;
                    i22 += iArr;
                    fArr2[i4] = 1;
                    i = i8;
                    while (i < i11) {
                        fArr2[i4] = Math.max(fArr2[i4], a.a()[i28 += i6]);
                        i++;
                        i8 = 0;
                        i5 = 0;
                    }
                    i9++;
                    i8 = 0;
                    i5 = 0;
                    fArr2[i4] = Math.max(fArr2[i4], fArr[i28 += i6]);
                    i++;
                    i8 = 0;
                    i5 = 0;
                }
                iArr++;
                i8 = 0;
                i5 = 0;
                i23 = i9 * i16;
                i22 += iArr;
                fArr2[i4] = 1;
                i = i8;
                while (i < i11) {
                    fArr2[i4] = Math.max(fArr2[i4], fArr[i28 += i6]);
                    i++;
                    i8 = 0;
                    i5 = 0;
                }
                i9++;
                i8 = 0;
                i5 = 0;
                fArr2[i4] = Math.max(fArr2[i4], fArr[i28 += i6]);
                i++;
                i8 = 0;
                i5 = 0;
            }
            i3++;
            i8 = 0;
            i5 = 0;
            i9 = i8;
            while (i9 < i18) {
                i23 = i9 * i16;
                i22 += iArr;
                fArr2[i4] = 1;
                i = i8;
                while (i < i11) {
                    fArr2[i4] = Math.max(fArr2[i4], fArr[i28 += i6]);
                    i++;
                    i8 = 0;
                    i5 = 0;
                }
                i9++;
                i8 = 0;
                i5 = 0;
                fArr2[i4] = Math.max(fArr2[i4], fArr[i28 += i6]);
                i++;
                i8 = 0;
                i5 = 0;
            }
            iArr++;
            i8 = 0;
            i5 = 0;
            i23 = i9 * i16;
            i22 += iArr;
            fArr2[i4] = 1;
            i = i8;
            while (i < i11) {
                fArr2[i4] = Math.max(fArr2[i4], fArr[i28 += i6]);
                i++;
                i8 = 0;
                i5 = 0;
            }
            i9++;
            i8 = 0;
            i5 = 0;
            fArr2[i4] = Math.max(fArr2[i4], fArr[i28 += i6]);
            i++;
            i8 = 0;
            i5 = 0;
        }
        try {
            return aVar;
            a.b(th, obj2);
            return null;
        }
    }

    public static final com.facebook.e0.w.a h(com.facebook.e0.w.a a, com.facebook.e0.w.a a2) {
        int i3;
        int i5;
        int i2;
        int i4;
        int i6;
        int i;
        float f;
        Object obj = a;
        Object obj2 = a2;
        if (a.d(f.class)) {
            return null;
        }
        n.f(obj, "x");
        n.f(obj2, "w");
        int i7 = 0;
        final int i9 = obj.b(i7);
        final int i10 = obj2.b(i7);
        int i11 = 1;
        final int i12 = obj2.b(i11);
        int[] iArr = new int[2];
        iArr[i7] = i9;
        iArr[i11] = i12;
        a aVar = new a(iArr);
        float[] fArr3 = aVar.a();
        i3 = i7;
        while (i3 < i9) {
            i5 = i7;
            while (i5 < i12) {
                i14 += i5;
                fArr3[i2] = 0;
                i4 = i7;
                while (i4 < i10) {
                    fArr3[i2] = f2 += i;
                    i4++;
                }
                i5++;
                fArr3[i2] = f2 += i;
                i4++;
            }
            i3++;
            i14 += i5;
            fArr3[i2] = 0;
            i4 = i7;
            while (i4 < i10) {
                fArr3[i2] = f2 += i;
                i4++;
            }
            i5++;
            fArr3[i2] = f2 += i;
            i4++;
        }
        return aVar;
    }

    public static final void i(com.facebook.e0.w.a a) {
        int i;
        int cmp;
        float f;
        if (a.d(f.class)) {
        }
        n.f(a, "x");
        final float[] obj6 = a.a();
        final int i2 = 0;
        i = i2;
        while (i < obj6.length) {
            if (Float.compare(f2, f) < 0) {
            }
            i++;
            obj6[i] = 0;
        }
    }

    public static final void j(com.facebook.e0.w.a a) {
        int i5;
        int i7;
        int i4;
        int i2;
        int i;
        int i3;
        int i6;
        int cmp;
        if (a.d(f.class)) {
        }
        n.f(a, "x");
        int i10 = a.b(1);
        final float[] obj11 = a.a();
        while (i5 < a.b(0)) {
            i7 = i5 * i10;
            i4 = i7 + i10;
            i2 = 1;
            i = 0;
            i6 = i7;
            while (i6 < i4) {
                if (Float.compare(f2, i2) > 0) {
                }
                i6++;
                i2 = obj11[i6];
            }
            i3 = i7;
            while (i3 < i4) {
                obj11[i3] = (float)d2;
                i += cmp;
                i3++;
            }
            while (i7 < i4) {
                obj11[i7] = f /= i;
                i7++;
            }
            i5++;
            obj11[i7] = f /= i;
            i7++;
            obj11[i3] = (float)d2;
            i += cmp;
            i3++;
            if (Float.compare(f2, i2) > 0) {
            }
            i6++;
            i2 = obj11[i6];
        }
    }

    public static final com.facebook.e0.w.a k(com.facebook.e0.w.a a) {
        int i2;
        int i;
        int i3;
        float f;
        if (a.d(f.class)) {
            return null;
        }
        n.f(a, "x");
        int i4 = 0;
        final int i6 = a.b(i4);
        int i7 = 1;
        final int i8 = a.b(i7);
        int[] iArr = new int[2];
        iArr[i4] = i8;
        iArr[i7] = i6;
        a aVar = new a(iArr);
        i2 = i4;
        while (i2 < i6) {
            i = i4;
            while (i < i8) {
                aVar.a()[i10 += i2] = a.a()[i11 += i];
                i++;
            }
            i2++;
            fArr[i10 += i2] = obj11[i11 += i];
            i++;
        }
        return aVar;
    }

    public static final com.facebook.e0.w.a l(com.facebook.e0.w.a a) {
        int i4;
        int[] iArr;
        int i2;
        int i;
        float f;
        int i3;
        if (a.d(f.class)) {
            return null;
        }
        n.f(a, "x");
        int i5 = 0;
        final int i7 = a.b(i5);
        int i8 = 1;
        final int i9 = a.b(i8);
        int i10 = 2;
        final int i11 = a.b(i10);
        iArr = new int[3];
        iArr[i5] = i11;
        iArr[i8] = i9;
        iArr[i10] = i7;
        a aVar = new a(iArr);
        i4 = i5;
        while (i4 < i7) {
            iArr = i5;
            while (iArr < i9) {
                i2 = i5;
                while (i2 < i11) {
                    aVar.a()[i15 += i4] = a.a()[i19 += i2];
                    i2++;
                }
                iArr++;
                fArr[i15 += i4] = obj14[i19 += i2];
                i2++;
            }
            i4++;
            i2 = i5;
            while (i2 < i11) {
                fArr[i15 += i4] = obj14[i19 += i2];
                i2++;
            }
            iArr++;
            fArr[i15 += i4] = obj14[i19 += i2];
            i2++;
        }
        return aVar;
    }
}
