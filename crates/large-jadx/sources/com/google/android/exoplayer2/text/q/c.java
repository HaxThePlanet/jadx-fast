package com.google.android.exoplayer2.text.q;

import android.graphics.Color;
import android.graphics.PointF;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import com.google.common.base.b;
import f.c.c.b.b;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
final class c {

    public final String a;
    public final int b;
    public final Integer c;
    public final float d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;

    static final class a {

        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;
        private a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            super();
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.h = i8;
            this.i = i9;
        }

        public static com.google.android.exoplayer2.text.q.c.a a(String string) {
            com.google.android.exoplayer2.text.q.c.a aVar;
            int i4;
            int i9;
            String equals;
            com.google.android.exoplayer2.text.q.c.a length;
            int i5;
            int i;
            int i8;
            int i11;
            int i6;
            int i2;
            int i3;
            int i10;
            int length2;
            int i12 = 7;
            String[] obj14 = TextUtils.split(string.substring(i12), ",");
            int i13 = 0;
            final int i15 = -1;
            i4 = i13;
            i10 = i3;
            for (Object str2 : string) {
                equals = b.c(str2.trim());
                equals.hashCode();
                i9 = i15;
                i = i4;
                i11 = i4;
                i5 = i4;
                i6 = i4;
                i8 = i4;
                i10 = i4;
                i3 = i4;
                i2 = i4;
                if (equals.equals("alignment") == null) {
                } else {
                }
                i9 = i12;
                if (equals.equals("fontsize") == null) {
                } else {
                }
                i9 = 6;
                if (equals.equals("name") == null) {
                } else {
                }
                i9 = 5;
                if (equals.equals("bold") == null) {
                } else {
                }
                i9 = 4;
                if (equals.equals("primarycolour") == null) {
                } else {
                }
                i9 = 3;
                if (equals.equals("strikeout") == null) {
                } else {
                }
                i9 = 2;
                if (equals.equals("underline") == null) {
                } else {
                }
                i9 = 1;
                if (equals.equals("italic") == null) {
                } else {
                }
                i9 = i13;
            }
            if (i5 != i15) {
                super(i5, i, i8, i11, i6, i2, i3, i10, obj14.length);
            } else {
                aVar = 0;
            }
            return aVar;
        }
    }

    static final class b {

        private static final Pattern c;
        private static final Pattern d;
        private static final Pattern e;
        private static final Pattern f;
        public final int a;
        public final PointF b;
        static {
            c.b.c = Pattern.compile("\\{([^}]*)\\}");
            int i = 1;
            Object[] arr2 = new Object[i];
            final int i2 = 0;
            final String str6 = "\\s*\\d+(?:\\.\\d+)?\\s*";
            arr2[i2] = str6;
            c.b.d = Pattern.compile(p0.z("\\\\pos\\((%1$s),(%1$s)\\)", arr2));
            Object[] arr = new Object[i];
            arr[i2] = str6;
            c.b.e = Pattern.compile(p0.z("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", arr));
            c.b.f = Pattern.compile("\\\\an(\\d+)");
        }

        private b(int i, PointF pointF2) {
            super();
            this.a = i;
            this.b = pointF2;
        }

        private static int a(String string) {
            int find;
            int obj1;
            obj1 = c.b.f.matcher(string);
            if (obj1.find()) {
                obj1 = obj1.group(1);
                g.e(obj1);
                obj1 = c.a((String)obj1);
            } else {
                obj1 = -1;
            }
            return obj1;
        }

        public static com.google.android.exoplayer2.text.q.c.b b(String string) {
            int i;
            int i3;
            int i2;
            PointF pointF;
            Matcher obj5 = c.b.c.matcher(string);
            int i4 = -1;
            i = 0;
            i3 = i4;
            while (obj5.find()) {
                String group = obj5.group(1);
                g.e(group);
                pointF = c.b.c((String)group);
                if (pointF != null) {
                }
                i2 = c.b.a(group);
                if (i2 != i4) {
                }
                i3 = i2;
                i = pointF;
            }
            obj5 = new c.b(i3, i);
            return obj5;
        }

        private static PointF c(String string) {
            String group;
            Object matcher;
            boolean stringBuilder;
            String obj6;
            Matcher matcher2 = c.b.d.matcher(string);
            matcher = c.b.e.matcher(string);
            final boolean find = matcher.find();
            final int i2 = 2;
            final int i3 = 1;
            if (matcher2.find()) {
                if (find) {
                    stringBuilder = new StringBuilder(length += 82);
                    stringBuilder.append("Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='");
                    stringBuilder.append(string);
                    stringBuilder.append("'");
                    v.f("SsaStyle.Overrides", stringBuilder.toString());
                }
                obj6 = matcher2.group(i3);
                group = matcher2.group(i2);
                g.e(obj6);
                g.e(group);
                PointF pointF = new PointF(Float.parseFloat((String)obj6.trim()), Float.parseFloat((String)group.trim()));
                return pointF;
            } else {
                if (find) {
                    obj6 = matcher.group(i3);
                    group = matcher.group(i2);
                }
            }
            return null;
        }

        public static String d(String string) {
            return c.b.c.matcher(string).replaceAll("");
        }
    }
    private c(String string, int i2, Integer integer3, float f4, boolean z5, boolean z6, boolean z7, boolean z8) {
        super();
        this.a = string;
        this.b = i2;
        this.c = integer3;
        this.d = f4;
        this.e = z5;
        this.f = z6;
        this.g = z7;
        this.h = z8;
    }

    static int a(String string) {
        return c.d(string);
    }

    public static com.google.android.exoplayer2.text.q.c b(String string, com.google.android.exoplayer2.text.q.c.a c$a2) {
        int i3;
        Integer num;
        float f;
        int i;
        int i7;
        int i2;
        int i4;
        int i6;
        int i5;
        int obj15;
        g.a(string.startsWith("Style:"));
        String[] split = TextUtils.split(string.substring(6), ",");
        int i10 = a2.i;
        final int i12 = 0;
        int i13 = 1;
        int i14 = 0;
        if (split.length != i10) {
            obj15 = new Object[3];
            obj15[i14] = Integer.valueOf(i10);
            obj15[i13] = Integer.valueOf(split.length);
            obj15[2] = string;
            v.h("SsaStyle", p0.z("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", obj15));
            return i12;
        }
        int i15 = a2.b;
        int i16 = -1;
        if (i15 != i16) {
            i3 = c.d(split[i15].trim());
        } else {
            i3 = i16;
        }
        int i17 = a2.c;
        if (i17 != i16) {
            num = c.f(split[i17].trim());
        } else {
            num = i12;
        }
        int i18 = a2.d;
        if (i18 != i16) {
            f = c.g(split[i18].trim());
        } else {
            f = -8388609;
        }
        i = a2.e;
        if (i != i16 && c.e(split[i].trim())) {
            i7 = c.e(split[i].trim()) ? i13 : i14;
        } else {
        }
        i2 = a2.f;
        if (i2 != i16 && c.e(split[i2].trim())) {
            i4 = c.e(split[i2].trim()) ? i13 : i14;
        } else {
        }
        i6 = a2.g;
        if (i6 != i16 && c.e(split[i6].trim())) {
            i5 = c.e(split[i6].trim()) ? i13 : i14;
        } else {
        }
        obj15 = a2.h;
        if (obj15 != i16 && c.e(split[obj15].trim())) {
            obj15 = c.e(split[obj15].trim()) ? i13 : i14;
        } else {
        }
        super(split[a2.a].trim(), i3, num, f, i7, i4, i5, obj15);
        return cVar;
    }

    private static boolean c(int i) {
        if (/* condition */) {
            return 1;
        }
        return 0;
    }

    private static int d(String string) {
        String obj2;
        try {
            int int = Integer.parseInt(string.trim());
            if (c.c(int)) {
            }
            return int;
            String str = "Ignoring unknown alignment: ";
            obj2 = String.valueOf(string);
            if (obj2.length() != 0) {
            } else {
            }
            obj2 = str.concat(obj2);
            obj2 = new String(str);
            v.h("SsaStyle", obj2);
            return -1;
        }
    }

    private static boolean e(String string) {
        int i;
        int str;
        i = 0;
        final int obj4 = Integer.parseInt(string);
        final int i2 = 1;
        if (obj4 != i2) {
            try {
                if (obj4 == -1) {
                }
                i = i2;
                return i;
                str = String.valueOf(string);
                str = str.length();
                str += 33;
                StringBuilder stringBuilder = new StringBuilder(str);
                str = "Failed to parse boolean value: '";
                stringBuilder.append(str);
                stringBuilder.append(string);
                string = "'";
                stringBuilder.append(string);
                string = stringBuilder.toString();
                str = "SsaStyle";
                v.i(str, string, th);
                return obj0;
            }
        } else {
        }
    }

    public static Integer f(String string) {
        String startsWith;
        int i;
        long long;
        try {
            int i6 = 16;
            if (string.startsWith("&H")) {
            } else {
            }
            long = Long.parseLong(string.substring(2), i6);
            long = Long.parseLong(string);
            if (Long.compare(long, l) <= 0) {
            } else {
            }
            i = 1;
            i = 0;
            g.a(i);
            final int i16 = 255;
            return Integer.valueOf(Color.argb(b.c(i12 ^= i16), b.c(long &= i16), b.c(i14 &= i16), b.c(i2 &= i16)));
            String str2 = String.valueOf(string);
            str2 = str2.length();
            str2 += 36;
            StringBuilder stringBuilder = new StringBuilder(str2);
            str2 = "Failed to parse color expression: '";
            stringBuilder.append(str2);
            stringBuilder.append(string);
            string = "'";
            stringBuilder.append(string);
            string = stringBuilder.toString();
            str2 = "SsaStyle";
            v.i(str2, string, th);
            string = null;
            return string;
        }
    }

    private static float g(String string) {
        try {
            return Float.parseFloat(string);
            String str = String.valueOf(string);
            str = str.length();
            str += 29;
            StringBuilder stringBuilder = new StringBuilder(str);
            str = "Failed to parse font size: '";
            stringBuilder.append(str);
            stringBuilder.append(string);
            string = "'";
            stringBuilder.append(string);
            string = stringBuilder.toString();
            str = "SsaStyle";
            v.i(str, string, th);
            string = -8388609;
            return string;
        }
    }
}
