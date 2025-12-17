package com.google.android.exoplayer2.text.t;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.c.b;
import com.google.android.exoplayer2.text.d;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import com.google.common.base.d;
import java.util.List;

/* loaded from: classes2.dex */
public final class a extends d {

    private final d0 n;
    private final boolean o;
    private final int p;
    private final int q;
    private final String r = 11;
    private final float s;
    private final int t;
    public a(List<byte[]> list) {
        int length;
        int i2;
        String str2;
        int i;
        int str;
        int obj7;
        super("Tx3gDecoder");
        d0 d0Var = new d0();
        this.n = d0Var;
        i2 = 1062836634;
        str2 = "sans-serif";
        final int i13 = 0;
        if (list.size() == 1) {
            if (obj.length != 48) {
                if (obj2.length == 53) {
                    obj7 = list.get(i13);
                    this.p = (byte[])obj7[24];
                    this.q = i6 |= i23;
                    int i24 = 43;
                    str2 = "Serif".equals(p0.B(obj7, i24, length2 -= i24)) ? "serif" : str2;
                    this.r = str2;
                    b *= 20;
                    this.t = length;
                    if (b3 &= 32 != 0) {
                    } else {
                        i = i13;
                    }
                    this.o = i;
                    if (i != 0) {
                        this.s = p0.o(obj7 /= f, 0, 1064514355);
                    } else {
                        this.s = i2;
                    }
                } else {
                    this.p = i13;
                    obj7 = -1;
                    this.q = obj7;
                    this.o = i13;
                    this.s = i2;
                    this.t = obj7;
                }
            } else {
            }
        } else {
        }
    }

    private void C(d0 d0, SpannableStringBuilder spannableStringBuilder2) {
        int i;
        int length;
        int str2;
        String str;
        StringBuilder stringBuilder;
        int i4 = 1;
        i = d0.a() >= 12 ? i4 : 0;
        a.D(i);
        int i3 = d0.D();
        str2 = d0.D();
        d0.J(2);
        d0.J(i4);
        String str3 = ").";
        String str4 = "Tx3gDecoder";
        if (str2 > spannableStringBuilder2.length()) {
            stringBuilder = new StringBuilder(68);
            stringBuilder.append("Truncating styl end (");
            stringBuilder.append(str2);
            stringBuilder.append(") to cueText.length() (");
            stringBuilder.append(spannableStringBuilder2.length());
            stringBuilder.append(str3);
            v.h(str4, stringBuilder.toString());
            length = spannableStringBuilder2.length();
        } else {
            length = str2;
        }
        if (i3 >= length) {
            StringBuilder obj10 = new StringBuilder(60);
            obj10.append("Ignoring styl with start (");
            obj10.append(i3);
            obj10.append(") >= end (");
            obj10.append(length);
            obj10.append(str3);
            v.h(str4, obj10.toString());
        }
        int i14 = 0;
        SpannableStringBuilder sb = spannableStringBuilder2;
        int i11 = i3;
        int i12 = length;
        a.F(sb, d0.x(), this.p, i11, i12, i14);
        a.E(sb, d0.n(), this.q, i11, i12, i14);
    }

    private static void D(boolean z) {
        if (!z) {
        } else {
        }
        SubtitleDecoderException obj1 = new SubtitleDecoderException("Unexpected subtitle format.");
        throw obj1;
    }

    private static void E(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4, int i5, int i6) {
        int obj1;
        ForegroundColorSpan obj2;
        if (i2 != i3) {
            obj2 = new ForegroundColorSpan(obj1 |= obj2);
            spannableStringBuilder.setSpan(obj2, i4, i5, i6 | 33);
        }
    }

    private static void F(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4, int i5, int i6) {
        int i9;
        int i8;
        int i;
        StyleSpan styleSpan;
        int i7;
        int obj6;
        int obj7;
        int obj10;
        if (i2 != i3) {
            obj7 = i6 | 33;
            i9 = 0;
            i8 = 1;
            obj10 = i2 & 1 != 0 ? i8 : i9;
            i = i2 & 2 != 0 ? i8 : i9;
            if (obj10 != null) {
                if (i != 0) {
                    styleSpan = new StyleSpan(3);
                    spannableStringBuilder.setSpan(styleSpan, i4, i5, obj7);
                } else {
                    styleSpan = new StyleSpan(i8);
                    spannableStringBuilder.setSpan(styleSpan, i4, i5, obj7);
                }
            } else {
                if (i != 0) {
                    styleSpan = new StyleSpan(2);
                    spannableStringBuilder.setSpan(styleSpan, i4, i5, obj7);
                }
            }
            if (i2 &= 4 != 0) {
            } else {
                i8 = i9;
            }
            if (i8 != 0) {
                obj6 = new UnderlineSpan();
                spannableStringBuilder.setSpan(obj6, i4, i5, obj7);
            }
            if (i8 == 0 && obj10 == null && i == 0) {
                if (obj10 == null) {
                    if (i == 0) {
                        obj6 = new StyleSpan(i9);
                        spannableStringBuilder.setSpan(obj6, i4, i5, obj7);
                    }
                }
            }
        }
    }

    private static void G(SpannableStringBuilder spannableStringBuilder, String string2, int i3, int i4) {
        Object typefaceSpan;
        String obj2;
        if (string2 != "sans-serif") {
            typefaceSpan = new TypefaceSpan(string2);
            spannableStringBuilder.setSpan(typefaceSpan, i3, i4, 16711713);
        }
    }

    private static String H(d0 d0) {
        int i;
        int i2;
        int i3;
        i2 = 2;
        i = d0.a() >= i2 ? 1 : 0;
        a.D(i);
        int i5 = d0.D();
        if (i5 == 0) {
            return "";
        }
        i2 = d0.g();
        if (d0.a() >= i2 && i2 != 65279 && i2 == 65534) {
            i2 = d0.g();
            if (i2 != 65279) {
                if (i2 == 65534) {
                }
            }
            return d0.v(i5, d.e);
        }
        return d0.v(i5, d.c);
    }

    @Override // com.google.android.exoplayer2.text.d
    protected f z(byte[] bArr, int i2, boolean z3) {
        int i;
        int i4;
        int i6;
        int i3;
        int length;
        int i5;
        float obj7;
        int obj9;
        this.n.G(bArr, i2);
        obj7 = a.H(this.n);
        if (obj7.isEmpty()) {
            return b.b;
        }
        SpannableStringBuilder obj8 = new SpannableStringBuilder(obj7);
        i3 = 0;
        i5 = 16711680;
        SpannableStringBuilder sb = obj8;
        a.F(sb, this.p, 0, i3, obj8.length(), i5);
        a.E(sb, this.q, -1, i3, obj8.length(), i5);
        int i7 = 0;
        a.G(obj8, this.r, i7, obj8.length());
        obj7 = this.s;
        while (this.n.a() >= 8) {
            i6 = this.n.n();
            length = 2;
            i5 = 1;
            if (i6 == 1937013100) {
            } else {
            }
            if (i6 == 1952608120 && this.o) {
            }
            this.n.I(obj9 += i);
            if (this.o) {
            }
            if (this.n.a() >= length) {
            } else {
            }
            i5 = i7;
            a.D(i5);
            obj7 = p0.o(obj7 /= f, 0, 1064514355);
            if (this.n.a() >= length) {
            } else {
            }
            i5 = i7;
            a.D(i5);
            i3 = i7;
            while (i3 < this.n.D()) {
                C(this.n, obj8);
                i3++;
            }
            C(this.n, obj8);
            i3++;
        }
        c.b bVar = new c.b();
        bVar.o(obj8);
        bVar.h(obj7, i7);
        bVar.i(i7);
        obj9 = new b(bVar.a());
        return obj9;
    }
}
