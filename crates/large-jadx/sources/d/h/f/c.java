package d.h.f;

import android.app.ActivityManager.ProcessErrorStateInfo;
import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

/* compiled from: PathParser.java */
/* loaded from: classes.dex */
public class c {

    private static class a {

        int a;
        boolean b;
        a() {
            super();
        }
    }

    public static class b {

        public char a;
        public float[] b;
        b(char c, float[] fArr) {
            super();
            this.a = c;
            this.b = fArr;
        }

        private static void a(Path path, float[] fArr, char c, char c2, float[] fArr2) {
            int c42;
            float c32;
            int i3;
            int i4 = 0;
            float f;
            float f3 = 0;
            int i6;
            int i7;
            float f11 = 0;
            int i9 = 0;
            int i8;
            float f10;
            int i2;
            float f4;
            float f8;
            float f9;
            boolean z2 = false;
            float f2;
            float f5;
            float f12;
            float f6;
            boolean z4 = true;
            int i10;
            int i11;
            final Path path2 = path;
            final int[] fArr52 = fArr2;
            i2 = 0;
            c42 = fArr[i2];
            c42 = 1;
            c42 = fArr[c42];
            c42 = 2;
            c42 = fArr[c42];
            final int i86 = 3;
            c42 = fArr[i86];
            c42 = 4;
            c42 = fArr[c42];
            final int i87 = 5;
            c42 = fArr[i87];
            switch (c2) {
                case 65:
                    c42 = 7;
                    break;
                case 67:
                    c42 = 6;
                    break;
                case 72:
                    break;
                case 76:
                    break;
                case 77:
                    break;
                default:
                    path.close();
                    path2.moveTo(c42, c42);
            }
            c32 = c;
            while (i2 < fArr52.length) {
                i2 = i2 + c42;
                c42 = c2;
                i2 = 0;
                c42 = 1;
                c42 = 2;
            }
            fArr[i2] = c42;
            fArr[1] = c42;
            fArr[2] = c42;
            fArr[i86] = c42;
            fArr[c42] = c42;
            fArr[i87] = c42;
        }

        private static void b(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            int d62;
            int i;
            int i2;
            double cos;
            double sin;
            double d82;
            double d102;
            double d13;
            double d15;
            double d12;
            double d14;
            float f5;
            double d11 = 3.141592653589793d;
            double ceiled = Math.ceil(Math.abs((d9 * 4d) / d11));
            i2 = (int)ceiled;
            cos = Math.cos(d7);
            sin = Math.sin(d7);
            double cos2 = Math.cos(d8);
            double sin2 = Math.sin(d8);
            int i3 = -d3;
            final double d28 = i3 * cos;
            final double d31 = d4 * sin;
            d13 = i3 * sin;
            double d33 = d4 * cos;
            d82 = d9 / ceiled;
            i = 0;
            d102 = d5;
            d = d6;
            d15 = d8;
            while (i < i2) {
                d15 = d15 + d82;
                double sin4 = Math.sin(d15);
                double cos3 = Math.cos(d15);
                d102 = (d + (d62 * cos) * cos3) - (d31 * sin4);
                d = (d2 + (d62 * sin) * cos3) + (d33 * sin4);
                d14 = (d28 * sin4) - (d31 * cos3);
                d12 = (sin4 * d13) + (cos3 * d33);
                double d34 = d15 - d15;
                double tan = Math.tan(d34 / 2d);
                double d18 = 3d;
                double d16 = 4d;
                d17 = (Math.sqrt((tan * d18) * tan + d16)) - 1d;
                double d36 = (Math.sin(d34) * d17) / d18;
                float f7 = 0.0f;
                path.rLineTo(f7, f7);
                d11 = (float)(d102 - (d36 * d14));
                f3 = (float)d102;
                path.cubicTo(f5, f, d11, f2, f3, f4);
                i = i + 1;
                d62 = d3;
            }
        }

        private static void c(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double d;
            int i = 0;
            double d6;
            double d7;
            int f23 = f;
            int f43 = f3;
            float f62 = f5;
            float f72 = f6;
            double f82 = f7;
            final double radians = Math.toRadians((double)f82);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d3 = (double)f23;
            double d4 = (double)f2;
            double d2 = (double)f62;
            double d42 = (d3 * cos) + (d4 * sin) / d2;
            double d38 = (double)f72;
            double d27 = (double)f4;
            double d11 = (double)f43 * cos + (d27 * sin) / d2;
            double d20 = (double)-f43 * sin + (d27 * cos) / d38;
            double d29 = d42 - d11;
            final double d48 = d5 - d20;
            double d53 = 2d;
            double d50 = (d42 + d11) / d53;
            double d57 = (d5 + d20) / d53;
            double d33 = (d29 * d29) + (d48 * d48);
            double d55 = 0.0d;
            String str4 = "PathParser";
            if (d33 == 0.0d) {
                Log.w(str4, " Points are coincident");
                return;
            }
            double d62 = (1d / d33) - 0.25d;
            if (d62 < 0.0d) {
                StringBuilder stringBuilder = new StringBuilder();
                String str3 = "Points are too far apart ";
                str2 = str3 + d33;
                Log.w(str4, str2);
                f = (float)(Math.sqrt(d33) / 1.99999d);
                c.b.c(path, f, f2, f3, f4, f62 * f, f6 * f, f7, z, z2);
                return;
            }
            double sqrt2 = Math.sqrt(d62);
            d29 *= sqrt2;
            sqrt2 *= d48;
            double z102 = z2;
            d7 = z == z102 ? d57 + d30 : d57 - d30;
            double d31 = d5 - d7;
            double atan2 = Math.atan2(d31, d42 - d6);
            d = (Math.atan2(d20 - d7, d11 - d6)) - atan2;
            int r6 = d >= 0.0d ? 1 : 0;
            if (z102 != 6.283185307179586d && d > 0.0d) {
                d = d - d22;
            }
            d6 *= d2;
            d7 *= d38;
            double d36 = d58 * sin;
            c.b.b(path, (d51 * cos) - d36, (d51 * sin) + (d58 * cos), d2, d38, d3, d4, radians, atan2, d);
        }

        public static void e(c.b[] bVarArr, Path path) {
            char c = 109;
            int i = 0;
            c = 'm';
            i = 0;
            while (i < bVarArr.length) {
                c.b.a(path, new float[6], c, bVarArr[i].a, bVarArr[i].b);
                i = i + 1;
            }
        }

        public void d(c.b bVar, c.b bVar2, float f) {
            int i = 0;
            this.a = bVar.a;
            i = 0;
            while (bVar.a < fArr2.length) {
                f2 = bVar2.b[i] * f;
                f = (fArr2[i] * (1f - f)) + f2;
                this.b[i] = f;
                i = i + 1;
            }
        }

        b(c.b bVar) {
            super();
            this.a = bVar.a;
            this.b = c.c(bVar.b, 0, fArr.length);
        }
    }
    private static void a(ArrayList<c.b> arrayList, char c, float[] fArr) {
        arrayList.add(new c.b(c, fArr));
    }

    public static boolean b(c.b[] bVarArr, c.b[] bVarArr2) {
        int i;
        i = 0;
        return false;
    }

    static float[] c(float[] fArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        } else {
            int length = fArr.length;
            if (i < 0) {
                throw new ArrayIndexOutOfBoundsException();
            } else {
                if (i <= length) {
                    i2 -= i;
                    float[] fArr2 = new float[i5];
                    System.arraycopy(fArr, i, fArr2, 0, Math.min(i5, length - i));
                    return fArr2;
                }
            }
        }
    }

    public static c.b[] d(String str) {
        int length;
        int i;
        int length2;
        if (str == null) {
            return null;
        }
        final ArrayList arrayList = new ArrayList();
        length = 1;
        i = 0;
        while (length < str.length()) {
            i = c.i(str, length);
            String trimmed = str.substring(i, i).trim();
        }
        if (length - i == length && i < str.length()) {
            c.a(arrayList, str.charAt(i), new float[i]);
        }
        return (c.b[])arrayList.toArray(new c.b[arrayList.size()]);
    }

    public static Path e(String str) {
        final Path path = new Path();
        final d.h.f.c.b[] objArr = c.d(str);
        if (objArr != null) {
            try {
                c.b.e(objArr, path);
            } catch (RuntimeException e) {
                StringBuilder stringBuilder = new StringBuilder();
                String str2 = "Error in parsing ";
                str = str2 + str;
                throw new RuntimeException(str, e);
            }
            return path;
        }
        return null;
    }

    public static c.b[] f(c.b[] bVarArr) {
        int i = 0;
        if (bVarArr == null) {
            return null;
        }
        d.h.f.c.b[] arr = new c.b[bVarArr.length];
        i = 0;
        while (i < bVarArr.length) {
            arr[i] = new c.b(bVarArr[i]);
            i = i + 1;
        }
        return arr;
    }

    private static void g(String str, int i, c.a aVar) {
        int i22;
        boolean z;
        char c;
        z = false;
        aVar.b = z;
        i22 = i;
        while (i22 < str.length()) {
            char charAt = str.charAt(i22);
            c = ' ';
            z = true;
            if (z) {
                break;
            }
        }
        aVar.a = i22;
    }

    private static float[] h(String str) {
        int i2 = 1;
        int i;
        i = 0;
        char c = 'z';
        if (str.charAt(i) != 'z') {
            c = 'Z';
            if (str.charAt(i) != 'Z') {
                try {
                    float[] fArr = new float[str.length()];
                    d.h.f.c.a aVar = new c.a();
                    i2 = 1;
                    while (i2 < str.length()) {
                        c.g(str, i2, aVar);
                        if (i2 < aVar.a) {
                            i = i + 1;
                            fArr[i] = Float.parseFloat(str.substring(i2, aVar.a));
                        }
                        int r4 = aVar.b ? i2 : i2 + 1;
                    }
                } catch (java.lang.NumberFormatException numberFormat) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str2 = "error in parsing \"";
                    str = "\"";
                    str = str2 + str + str;
                    throw new RuntimeException(str, numberFormat);
                }
            }
            return c.c(fArr, i, i);
        }
        return new float[i];
    }

    private static int i(String str, int i) {
        int i3;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            i3 = charAt - 90;
            i = (charAt - 65) * i3;
            if (charAt - 65 * charAt - 90 <= 0) {
                char c = 'e';
            }
        }
        return i;
    }

    public static void j(c.b[] bVarArr, c.b[] bVarArr2) {
        int i;
        float f;
        i = 0;
        while (i < bVarArr2.length) {
            bVarArr[i].a = bVarArr2[i].a;
            length = bVarArr2[i].b.length;
            while (bVarArr2.length < bVarArr2[i].b.length) {
                bVarArr[i].b[i] = bVarArr2[i].b[i];
                i = i + 1;
                length = bVarArr2[i].b.length;
            }
            i = i + 1;
            bVarArr[i].b[i] = bVarArr2[i].b[i];
            i = i + 1;
        }
    }
}
