package d.h.f;

import android.app.ActivityManager.ProcessErrorStateInfo;
import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class c {

    private static class a {

        int a;
        boolean b;
    }

    public static class b {

        public char a;
        public float[] b;
        b(char c, float[] f2Arr2) {
            super();
            this.a = c;
            this.b = f2Arr2;
        }

        b(d.h.f.c.b c$b) {
            super();
            this.a = b.a;
            float[] obj3 = b.b;
            this.b = c.c(obj3, 0, obj3.length);
        }

        private static void a(Path path, float[] f2Arr2, char c3, char c4, float[] f5Arr5) {
            int i26;
            int i13;
            int i18;
            int i29;
            int i14;
            int i7;
            int i17;
            int i10;
            int i31;
            int i25;
            int i;
            int i23;
            int i28;
            int i16;
            int i5;
            int i3;
            int i22;
            int i27;
            int i30;
            int i20;
            int i4;
            int i21;
            int i19;
            int i2;
            int i15;
            int i9;
            int i6;
            int i12;
            int i8;
            int i11;
            int i24;
            final int i117 = path;
            final int[] iArr = f5Arr5;
            i19 = 0;
            i26 = f2Arr2[i19];
            i2 = 1;
            i29 = f2Arr2[i2];
            i15 = 2;
            i7 = f2Arr2[i15];
            final int i122 = 3;
            i25 = f2Arr2[i122];
            final int i123 = 4;
            i28 = f2Arr2[i123];
            final int i124 = 5;
            i5 = f2Arr2[i124];
            switch (i21) {
                case 65:
                    i3 = 7;
                    i9 = i3;
                    break;
                case 67:
                    i3 = 6;
                    i9 = i3;
                    break;
                case 72:
                    i9 = i2;
                    break;
                case 76:
                    i9 = i15;
                    break;
                case 77:
                    i9 = i123;
                    break;
                default:
                    i9 = i15;
                    path.close();
                    i117.moveTo(i28, i5);
                    i7 = i26;
                    i25 = i29;
            }
            i20 = i26;
            i27 = i29;
            i6 = i28;
            i12 = i5;
            i22 = i19;
            i13 = c3;
            while (i22 < iArr.length) {
                if (i21 != 65) {
                } else {
                }
                i24 = i22;
                i19 = i24 + 5;
                i2 = i24 + 6;
                int i86 = 0;
                if (Float.compare(i65, i86) != 0) {
                } else {
                }
                i30 = 0;
                if (Float.compare(i67, i86) != 0) {
                } else {
                }
                i4 = 0;
                c.b.c(path, i20, i27, iArr[i19], iArr[i2], iArr[i24 + 0], iArr[i24 + 1], iArr[i24 + 2], i30, i4);
                i20 = iArr[i19];
                i27 = iArr[i2];
                i25 = i27;
                i7 = i20;
                i22 = i24 + i9;
                i21 = i13;
                i19 = 0;
                i2 = 1;
                i15 = 2;
                i4 = 1;
                i30 = 1;
                if (i21 != 67) {
                } else {
                }
                i24 = i22;
                i22 = i24 + 2;
                int i111 = i24 + 3;
                int i116 = i24 + 4;
                i21 = i24 + 5;
                path.cubicTo(iArr[i24 + 0], iArr[i24 + 1], iArr[i22], iArr[i111], iArr[i116], iArr[i21]);
                i20 = iArr[i116];
                i27 = i13;
                i25 = i96;
                i7 = i29;
                if (i21 != 72) {
                } else {
                }
                i22 = i24 + 0;
                i117.lineTo(iArr[i22], i27);
                i20 = iArr[i22];
                i5 = 81;
                if (i21 != i5) {
                } else {
                }
                i24 = i22;
                i22 = i24 + 0;
                int i69 = i24 + 1;
                int i97 = i24 + 2;
                i5 = i24 + 3;
                i117.quadTo(iArr[i22], iArr[i69], iArr[i97], iArr[i5]);
                i20 = iArr[i97];
                i27 = iArr[i5];
                i7 = i13;
                i25 = i29;
                if (i21 != 86) {
                } else {
                }
                i22 = i24 + 0;
                i117.lineTo(i20, iArr[i22]);
                i27 = iArr[i22];
                if (i21 != 97) {
                } else {
                }
                i19 = i22 + 5;
                i2 = i22 + 6;
                int i70 = 0;
                if (Float.compare(i43, i70) != 0) {
                } else {
                }
                i8 = 0;
                if (Float.compare(i45, i70) != 0) {
                } else {
                }
                i11 = 0;
                i24 = i22;
                c.b.c(path, i20, i27, i37 + i20, i38 + i27, iArr[i22 + 0], iArr[i22 + 1], iArr[i22 + 2], i8, i11);
                i20 = i21 + i46;
                i27 = i15 + i13;
                i11 = 1;
                i8 = 1;
                i3 = 99;
                i15 = 113;
                i2 = 115;
                i8 = 1073741824;
                if (i21 != i3 && i21 != 104 && i21 != i15 && i21 != 118 && i21 != 76 && i21 != 77 && i21 != 83) {
                } else {
                }
                i19 = i22 + 2;
                i2 = i22 + 3;
                i15 = i22 + 4;
                i8 = i22 + 5;
                path.rCubicTo(iArr[i22 + 0], iArr[i22 + 1], iArr[i19], iArr[i2], iArr[i15], iArr[i8]);
                i62 += i20;
                i84 += i27;
                i20 += i94;
                i10 = iArr[i8];
                i27 += i10;
                i7 = i13;
                i25 = i29;
                i24 = i22;
                if (i21 != 104) {
                } else {
                }
                int i47 = i22 + 0;
                i117.rLineTo(iArr[i47], 0);
                i20 += i13;
                i15 = 113;
                if (i21 != i15) {
                } else {
                }
                int i48 = i22 + 0;
                int i88 = i22 + 1;
                i28 = i22 + 2;
                i3 = i22 + 3;
                i117.rQuadTo(iArr[i48], iArr[i88], iArr[i28], iArr[i3]);
                i49 += i20;
                i72 += i27;
                i20 += i89;
                i10 = iArr[i3];
                if (i21 != 118) {
                } else {
                }
                int i50 = i22 + 0;
                i117.rLineTo(0, iArr[i50]);
                i13 = iArr[i50];
                i27 += i13;
                if (i21 != 76) {
                } else {
                }
                i13 = i22 + 0;
                i28 = i22 + 1;
                i117.lineTo(iArr[i13], iArr[i28]);
                i20 = iArr[i13];
                i27 = iArr[i28];
                if (i21 != 77) {
                } else {
                }
                int i51 = i22 + 0;
                i20 = iArr[i51];
                int i73 = i22 + 1;
                i27 = iArr[i73];
                if (i22 > 0) {
                } else {
                }
                i117.moveTo(iArr[i51], iArr[i73]);
                i24 = i22;
                i12 = i27;
                i6 = i20;
                i117.lineTo(iArr[i51], iArr[i73]);
                i2 = 115;
                i8 = 1073741824;
                if (i21 != 83) {
                } else {
                }
                if (i13 != i3 && i13 != i2 && i13 != 67) {
                } else {
                }
                i114 -= i7;
                i109 -= i25;
                int i108 = i22 + 0;
                int i113 = i22 + 1;
                i19 = i22 + 2;
                i2 = i22 + 3;
                path.cubicTo(i20, i27, iArr[i108], iArr[i113], iArr[i19], iArr[i2]);
                i13 = iArr[i108];
                i29 = iArr[i113];
                i20 = iArr[i19];
                i27 = iArr[i2];
                if (i13 != i2) {
                } else {
                }
                if (i13 != 67) {
                } else {
                }
                if (i13 == 83) {
                }
                i28 = 116;
                i19 = 84;
                if (i21 != i19) {
                } else {
                }
                if (i13 != i15 && i13 != i28 && i13 != i5) {
                } else {
                }
                i115 -= i7;
                i110 -= i25;
                int i53 = i22 + 0;
                int i90 = i22 + 1;
                i117.quadTo(i20, i27, iArr[i53], iArr[i90]);
                i24 = i22;
                i25 = i27;
                i7 = i20;
                i20 = i13;
                i27 = i29;
                if (i13 != i28) {
                } else {
                }
                if (i13 != i5) {
                } else {
                }
                if (i13 == i19) {
                }
                if (i21 != 108 && i21 != 109) {
                } else {
                }
                int i57 = i22 + 0;
                i28 = i22 + 1;
                i117.rLineTo(iArr[i57], iArr[i28]);
                i20 += i58;
                i13 = iArr[i28];
                if (i21 != 109) {
                } else {
                }
                int i54 = i22 + 0;
                i20 += i77;
                int i78 = i22 + 1;
                i27 += i28;
                if (i22 > 0) {
                } else {
                }
                i117.rMoveTo(iArr[i54], iArr[i78]);
                i117.rLineTo(iArr[i54], iArr[i78]);
                if (i21 != i2) {
                } else {
                }
                if (i13 != i3 && i13 != i2 && i13 != 67) {
                } else {
                }
                i17 = i80;
                i14 = i13;
                i19 = i22 + 0;
                i2 = i22 + 1;
                i15 = i22 + 2;
                i8 = i22 + 3;
                path.rCubicTo(i14, i17, iArr[i19], iArr[i2], iArr[i15], iArr[i8]);
                i56 += i20;
                i79 += i27;
                i20 += i91;
                i10 = iArr[i8];
                if (i13 != i2) {
                } else {
                }
                if (i13 != 67) {
                } else {
                }
                if (i13 == 83) {
                } else {
                }
                i14 = 0;
                i17 = 0;
                if (i21 == i28) {
                }
                if (i13 != i15 && i13 != i28 && i13 != i5) {
                } else {
                }
                i16 = i20 - i7;
                i18 = i27 - i25;
                int i81 = i22 + 0;
                int i99 = i22 + 1;
                i117.rQuadTo(i16, i18, iArr[i81], iArr[i99]);
                i20 += i82;
                i27 += i29;
                i25 = i13;
                i7 = i28;
                if (i13 != i28) {
                } else {
                }
                if (i13 != i5) {
                } else {
                }
                if (i13 == i19) {
                } else {
                }
                i18 = 0;
                i16 = 0;
            }
            f2Arr2[i19] = i20;
            f2Arr2[1] = i27;
            f2Arr2[2] = i7;
            f2Arr2[i122] = i25;
            f2Arr2[i123] = i6;
            f2Arr2[i124] = i12;
        }

        private static void b(Path path, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
            int i10;
            int i3;
            int i7;
            int i16;
            double d;
            long l;
            double d11;
            float f4;
            int i8;
            int i6;
            int i5;
            Object obj;
            int i15;
            int i13;
            int i12;
            int i;
            long l4;
            int i4;
            int i2;
            int i11;
            int i14;
            long l2;
            int i9;
            Object obj2;
            double d12;
            float f;
            long l3;
            float f2;
            float f3;
            float f5;
            int obj56;
            double obj62;
            d = Math.cos(obj62);
            d11 = Math.sin(obj62);
            double d14 = Math.cos(obj64);
            double d16 = Math.sin(obj64);
            int i27 = -i10;
            final int i29 = i27 * d;
            final int i34 = d8 * d11;
            int i36 = d8 * d;
            i8 = obj66 / d15;
            i12 = i25;
            i = i31;
            i3 = i37;
            i6 = d10;
            i15 = obj60;
            i13 = obj64;
            while (i3 < i16) {
                i4 = i13 + i8;
                double d19 = Math.sin(i4);
                double d20 = Math.cos(i4);
                i7 = i49 - i54;
                int i17 = i52 + i55;
                i53 -= i56;
                i44 += i45;
                int i38 = i4 - i13;
                double d21 = Math.tan(i38 / l6);
                l2 = 4613937818241073152L;
                i39 /= l2;
                int i28 = 0;
                path.rLineTo(i28, i28);
                path.cubicTo((float)i26, (float)i20, (float)i21, (float)i23, (float)i7, (float)i17);
                i3++;
                i8 = obj56;
                d11 = obj62;
                i6 = i7;
                i5 = i33;
                d = d18;
                i13 = i4;
                i12 = i2;
                i = i14;
                i16 = i9;
                i15 = i17;
                i10 = d6;
            }
        }

        private static void c(Path path, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean z9, boolean z10) {
            int i3;
            int i;
            int i4;
            int i2;
            int i6 = f2;
            int i14 = f4;
            int i5 = f6;
            int i12 = f7;
            double d9 = f8;
            final double radians = Math.toRadians((double)d9);
            double d5 = Math.cos(radians);
            double d13 = Math.sin(radians);
            double d15 = (double)i6;
            double d16 = (double)f13;
            double d7 = (double)i5;
            i38 /= d7;
            double d17 = (double)i12;
            int i42 = i26;
            double d11 = (double)f15;
            i8 /= d7;
            double d23 = d7;
            i18 /= d17;
            int i28 = i39 - i9;
            final int i45 = i42 - i19;
            long l2 = 4611686018427387904L;
            i46 /= l2;
            i52 /= l2;
            final double d24 = d13;
            int i32 = i50 + i56;
            int i51 = 0;
            String str3 = "PathParser";
            if (Double.compare(i32, i51) == 0) {
                Log.w(str3, " Points are coincident");
            }
            i57 -= l4;
            int cmp3 = Double.compare(i58, i51);
            if (cmp3 < 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Points are too far apart ");
                stringBuilder.append(i32);
                Log.w(str3, stringBuilder.toString());
                float f = (float)i10;
                c.b.c(path, f2, f3, f4, f5, i5 * f, f7 * f, f8, z9, z10);
            }
            double sqrt2 = Math.sqrt(i58);
            i28 *= sqrt2;
            sqrt2 *= i45;
            int i15 = z10;
            i2 = z9 == i15 ? i53 + i29 : i53 - i29;
            int i30 = i42 - i2;
            double atan22 = Math.atan2(i30, z10);
            atan2 -= atan22;
            int cmp = Double.compare(i3, i51);
            i = cmp >= 0 ? 1 : 0;
            if (i15 != i) {
                i = 4618760256179416344L;
                i3 = cmp > 0 ? i3 - i : i3 + i;
            }
            i4 *= d23;
            i2 *= d17;
            int i35 = i54 * d24;
            c.b.b(path, i13 - i35, i30, i49 + i55, i35, d23, cmp3, d17, obj14, d15);
        }

        public static void e(d.h.f.c.b[] c$bArr, Path path2) {
            int i2;
            int i;
            char c;
            float[] fArr;
            i2 = 109;
            i = 0;
            for (Object obj : bArr) {
                c.b.a(path2, new float[6], i2, obj2.a, obj3.b);
                i2 = obj.a;
            }
        }

        public void d(d.h.f.c.b c$b, d.h.f.c.b c$b2, float f3) {
            int i2;
            int i;
            float[] fArr;
            int i3;
            this.a = b.a;
            i2 = 0;
            float[] fArr2 = b.b;
            for (int f : obj1) {
                this.b[i2] = i4 += i3;
                fArr2 = b.b;
            }
        }
    }
    private static void a(ArrayList<d.h.f.c.b> arrayList, char c2, float[] f3Arr3) {
        c.b bVar = new c.b(c2, f3Arr3);
        arrayList.add(bVar);
    }

    public static boolean b(d.h.f.c.b[] c$bArr, d.h.f.c.b[] c$b2Arr2) {
        int i;
        int length;
        int length2;
        final int i2 = 0;
        if (bArr != null) {
            if (b2Arr2 == null) {
            } else {
                if (bArr.length != b2Arr2.length) {
                    return i2;
                }
                i = i2;
                for (Object obj2 : bArr) {
                }
            }
            return 1;
        }
        return i2;
    }

    static float[] c(float[] fArr, int i2, int i3) {
        if (i2 > i3) {
        } else {
            int length = fArr.length;
            if (i2 < 0) {
            } else {
                if (i2 > length) {
                } else {
                    i3 -= i2;
                    float[] obj4 = new float[obj4];
                    System.arraycopy(fArr, i2, obj4, 0, Math.min(obj4, length -= i2));
                    return obj4;
                }
            }
            ArrayIndexOutOfBoundsException obj2 = new ArrayIndexOutOfBoundsException();
            throw obj2;
        }
        obj2 = new IllegalArgumentException();
        throw obj2;
    }

    public static d.h.f.c.b[] d(String string) {
        int fArr;
        int i3;
        int i;
        String charAt;
        int length;
        int i2;
        String obj7;
        if (string == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        fArr = 1;
        final int i4 = 0;
        i3 = fArr;
        i = i4;
        while (i3 < string.length()) {
            int i6 = c.i(string, i3);
            charAt = string.substring(i, i6).trim();
            if (charAt.length() > 0) {
            }
            i = i6;
            i3 = i2;
            c.a(arrayList, charAt.charAt(i4), c.h(charAt));
        }
        if (i3 -= i == fArr && i < string.length()) {
            if (i < string.length()) {
                c.a(arrayList, string.charAt(i), new float[i4]);
            }
        }
        return (c.b[])arrayList.toArray(new c.b[arrayList.size()]);
    }

    public static Path e(String string) {
        Path path = new Path();
        final d.h.f.c.b[] objArr = c.d(string);
        if (objArr != null) {
            c.b.e(objArr, path);
            return path;
        }
        return null;
    }

    public static d.h.f.c.b[] f(d.h.f.c.b[] c$bArr) {
        int i;
        d.h.f.c.b bVar;
        Object obj;
        if (bArr == null) {
            return null;
        }
        d.h.f.c.b[] arr = new c.b[bArr.length];
        i = 0;
        for (Object obj : bArr) {
            bVar = new c.b(obj);
            arr[i] = bVar;
        }
        return arr;
    }

    private static void g(String string, int i2, d.h.f.c.a c$a3) {
        int i5;
        int i3;
        int i6;
        int i;
        char charAt;
        int i4;
        int i7;
        final int i9 = 0;
        a3.b = i9;
        i5 = i2;
        i = i6;
        while (i5 < string.length()) {
            charAt = string.charAt(i5);
            i7 = 1;
            if (charAt != 32) {
            } else {
            }
            i3 = i9;
            i = i7;
            if (i != 0) {
                break;
            } else {
            }
            i5++;
            if (charAt != 69 && charAt != 101) {
            } else {
            }
            i3 = i7;
            if (charAt != 101) {
            } else {
            }
            i3 = i9;
            if (i6 == 0) {
            } else {
            }
            a3.b = i7;
            i3 = i9;
            i6 = i7;
            if (i5 != i2 && i3 == 0) {
            } else {
            }
            if (i3 == 0) {
            } else {
            }
            a3.b = i7;
        }
        a3.a = i5;
    }

    private static float[] h(String string) {
        char charAt;
        int i;
        int float;
        int i3;
        int i2;
        int i4;
        final int i5 = 0;
        if (string.charAt(i5) != 122) {
            if (string.charAt(i5) == 90) {
            } else {
                float[] fArr = new float[string.length()];
                c.a aVar = new c.a();
                float = 1;
                i3 = i5;
                while (float < string.length()) {
                    c.g(string, float, aVar);
                    i2 = aVar.a;
                    if (float < i2) {
                    }
                    if (aVar.b) {
                    } else {
                    }
                    float = i2 + 1;
                    float = i2;
                    fArr[i3] = Float.parseFloat(string.substring(float, i2));
                    i3 = i4;
                }
            }
            return c.c(fArr, i5, i3);
        }
        return new float[i5];
    }

    private static int i(String string, int i2) {
        int i;
        int i3;
        while (i2 < string.length()) {
            char charAt = string.charAt(i2);
            i2++;
        }
        return i2;
    }

    public static void j(d.h.f.c.b[] c$bArr, d.h.f.c.b[] c$b2Arr2) {
        int i;
        int i2;
        int length;
        char c;
        float f;
        final int i3 = 0;
        i = i3;
        for (Object obj5 : b2Arr2) {
            obj.a = obj2.a;
            i2 = i3;
            while (i2 < fArr.length) {
                obj4.b[i2] = obj5.b[i2];
                i2++;
            }
            obj4.b[i2] = obj5.b[i2];
            i2++;
        }
    }
}
