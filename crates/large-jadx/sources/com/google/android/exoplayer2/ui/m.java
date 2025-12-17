package com.google.android.exoplayer2.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.z;
import java.util.Locale;

/* loaded from: classes2.dex */
public class m implements com.google.android.exoplayer2.ui.a0 {

    private final Resources a;
    public m(Resources resources) {
        super();
        g.e(resources);
        this.a = (Resources)resources;
    }

    private String b(i1 i1) {
        int i;
        int i2;
        int obj2 = i1.Q;
        if (obj2 != -1) {
            i = 1;
            if (obj2 < i) {
            } else {
                if (obj2 != i && obj2 != 2 && obj2 != 6 && obj2 != 7 && obj2 != 8) {
                    if (obj2 != 2) {
                        if (obj2 != 6) {
                            if (obj2 != 7) {
                                if (obj2 != 8) {
                                    return this.a.getString(u.s);
                                }
                                return this.a.getString(u.u);
                            }
                        }
                        return this.a.getString(u.t);
                    }
                    return this.a.getString(u.r);
                }
            }
            return this.a.getString(u.j);
        }
        return "";
    }

    private String c(i1 i1) {
        int i4;
        int i3;
        Object[] arr;
        int i;
        int i2;
        String obj6;
        obj6 = i1.z;
        if (obj6 == -1) {
            obj6 = "";
        } else {
            arr = new Object[1];
            obj6 = this.a.getString(u.i, Float.valueOf(obj6 /= i2));
        }
        return obj6;
    }

    private String d(i1 i1) {
        String obj2;
        obj2 = TextUtils.isEmpty(i1.b) ? "" : i1.b;
        return obj2;
    }

    private String e(i1 i1) {
        String str;
        String[] strArr = new String[2];
        if (TextUtils.isEmpty(j(f(i1), h(i1)))) {
            str = d(i1);
        }
        return str;
    }

    private String f(i1 i1) {
        boolean equals;
        Locale locale;
        Locale obj3;
        obj3 = i1.c;
        if (!TextUtils.isEmpty(obj3)) {
            if ("und".equals(obj3)) {
            } else {
                if (p0.a >= 21) {
                    obj3 = Locale.forLanguageTag(obj3);
                } else {
                    locale = new Locale(obj3);
                    obj3 = locale;
                }
            }
            return obj3.getDisplayName();
        }
        return "";
    }

    private String g(i1 i1) {
        int i3;
        Resources i;
        int i2;
        Object[] arr;
        int i4;
        String obj6;
        i3 = i1.I;
        obj6 = i1.J;
        i = -1;
        if (i3 != i) {
            if (obj6 == i) {
                obj6 = "";
            } else {
                arr = new Object[2];
                obj6 = this.a.getString(u.k, Integer.valueOf(i3), Integer.valueOf(obj6));
            }
        } else {
        }
        return obj6;
    }

    private String h(i1 i1) {
        String string;
        int i2;
        int i3;
        int strArr2;
        int strArr;
        int i;
        int obj7;
        i2 = 2;
        if (i4 &= i2 != 0) {
            string = this.a.getString(u.l);
        } else {
            string = "";
        }
        final int i8 = 1;
        final int i9 = 0;
        if (i6 &= 4 != 0) {
            strArr2 = new String[i2];
            strArr2[i9] = string;
            strArr2[i8] = this.a.getString(u.o);
            string = j(strArr2);
        }
        if (i7 &= 8 != 0) {
            strArr = new String[i2];
            strArr[i9] = string;
            strArr[i8] = this.a.getString(u.n);
            string = j(strArr);
        }
        if (obj7 &= 1088 != 0) {
            obj7 = new String[i2];
            obj7[i9] = string;
            obj7[i8] = this.a.getString(u.m);
            string = j(obj7);
        }
        return string;
    }

    private static int i(i1 i1) {
        int i;
        Object obj4;
        int i2 = z.k(i1.D);
        final int i4 = -1;
        if (i2 != i4) {
            return i2;
        }
        final int i5 = 2;
        if (z.n(i1.A) != null) {
            return i5;
        }
        final int i6 = 1;
        if (z.c(i1.A) != null) {
            return i6;
        }
        if (i1.I == i4) {
            if (i1.J != i4) {
            } else {
                if (i1.Q == i4 && i1.R != i4) {
                    if (i1.R != i4) {
                    }
                    return i4;
                }
            }
            return i6;
        }
        return i5;
    }

    private String j(String... stringArr) {
        String string;
        int i2;
        Object obj;
        int length;
        int i;
        Object[] arr;
        final int i3 = 0;
        string = "";
        i2 = i3;
        while (i2 < stringArr.length) {
            obj = stringArr[i2];
            if (obj.length() > 0) {
            }
            i2++;
            if (TextUtils.isEmpty(string)) {
            } else {
            }
            arr = new Object[2];
            arr[i3] = string;
            arr[1] = obj;
            string = this.a.getString(u.h, arr);
            string = obj;
        }
        return string;
    }

    @Override // com.google.android.exoplayer2.ui.a0
    public String a(i1 i1) {
        String[] strArr;
        int length;
        String i2;
        String i;
        String obj6;
        strArr = m.i(i1);
        i2 = 0;
        i = 3;
        final int i3 = 1;
        final int i4 = 2;
        if (strArr == i4) {
            strArr = new String[i];
            strArr[i2] = h(i1);
            strArr[i3] = g(i1);
            strArr[i4] = c(i1);
            obj6 = j(strArr);
        } else {
            if (strArr == i3) {
                strArr = new String[i];
                strArr[i2] = e(i1);
                strArr[i3] = b(i1);
                strArr[i4] = c(i1);
                obj6 = j(strArr);
            } else {
                obj6 = e(i1);
            }
        }
        if (obj6.length() == 0) {
            obj6 = this.a.getString(u.v);
        }
        return obj6;
    }
}
