package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes2.dex */
final class x {

    private int A;
    private int B;
    private int C;
    private int D;
    private StaticLayout E;
    private StaticLayout F;
    private int G;
    private int H;
    private int I;
    private Rect J;
    private final float a;
    private final float b;
    private final float c;
    private final float d;
    private final float e;
    private final TextPaint f;
    private final Paint g;
    private final Paint h;
    private java.lang.CharSequence i;
    private Layout.Alignment j;
    private Bitmap k;
    private float l;
    private int m;
    private int n;
    private float o;
    private int p;
    private float q;
    private float r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private float x;
    private float y;
    private float z;
    public x(Context context) {
        super();
        int[] iArr = new int[2];
        iArr = new int[]{16843287, 16843288};
        int i7 = 0;
        TypedArray styledAttributes = context.obtainStyledAttributes(0, iArr, i7, i7);
        this.e = (float)dimensionPixelSize;
        int i5 = 1;
        this.d = styledAttributes.getFloat(i5, 1065353216);
        styledAttributes.recycle();
        float obj4 = (float)obj4;
        this.a = obj4;
        this.b = obj4;
        this.c = obj4;
        obj4 = new TextPaint();
        this.f = obj4;
        obj4.setAntiAlias(i5);
        obj4.setSubpixelText(i5);
        obj4 = new Paint();
        this.g = obj4;
        obj4.setAntiAlias(i5);
        obj4.setStyle(Paint.Style.FILL);
        obj4 = new Paint();
        this.h = obj4;
        obj4.setAntiAlias(i5);
        obj4.setFilterBitmap(i5);
    }

    private static boolean a(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2) {
        boolean obj0;
        if (charSequence != charSequence2) {
            if (charSequence != null && charSequence.equals(charSequence2)) {
                if (charSequence.equals(charSequence2)) {
                    obj0 = 1;
                } else {
                    obj0 = 0;
                }
            } else {
            }
        } else {
        }
        return obj0;
    }

    @RequiresNonNull({"cueBitmap", "bitmapRect"})
    private void c(Canvas canvas) {
        canvas.drawBitmap(this.k, 0, this.J, this.h);
    }

    private void d(Canvas canvas, boolean z2) {
        Bitmap obj2;
        if (z2 != null) {
            e(canvas);
        } else {
            g.e(this.J);
            g.e(this.k);
            c(canvas);
        }
    }

    private void e(Canvas canvas) {
        Object staticLayout2;
        Object staticLayout;
        int save;
        int height;
        TextPaint i4;
        Paint.Style fILL;
        float f3;
        int i2;
        float fILL_AND_STROKE;
        int i3;
        int i;
        float f2;
        float f;
        Paint paint;
        staticLayout2 = this.E;
        staticLayout = this.F;
        if (staticLayout2 != null) {
            if (staticLayout == null) {
            } else {
                canvas.translate((float)i5, (float)i11);
                if (Color.alpha(this.u) > 0) {
                    this.g.setColor(this.u);
                    canvas.drawRect((float)i8, 0, (float)i9, (float)height, this.g);
                }
                i4 = this.w;
                i2 = 0;
                if (i4 == 1) {
                    this.f.setStrokeJoin(Paint.Join.ROUND);
                    this.f.setStrokeWidth(this.a);
                    this.f.setColor(this.v);
                    this.f.setStyle(Paint.Style.FILL_AND_STROKE);
                    staticLayout.draw(canvas);
                } else {
                    if (i4 == 2) {
                        fILL_AND_STROKE = this.c;
                        this.f.setShadowLayer(this.b, fILL_AND_STROKE, fILL_AND_STROKE, this.v);
                    } else {
                        i3 = 3;
                        if (i4 != i3) {
                            if (i4 == 4) {
                                if (i4 == i3) {
                                } else {
                                    fILL_AND_STROKE = i2;
                                }
                                i = fILL_AND_STROKE != 0 ? i4 : this.v;
                                if (fILL_AND_STROKE != 0) {
                                    i4 = this.v;
                                }
                                f6 /= i16;
                                this.f.setColor(this.s);
                                this.f.setStyle(Paint.Style.FILL);
                                paint = -fILL_AND_STROKE;
                                this.f.setShadowLayer(this.b, paint, paint, i);
                                staticLayout.draw(canvas);
                                this.f.setShadowLayer(this.b, fILL_AND_STROKE, fILL_AND_STROKE, i4);
                            }
                        } else {
                        }
                    }
                }
                this.f.setColor(this.s);
                this.f.setStyle(Paint.Style.FILL);
                staticLayout2.draw(canvas);
                staticLayout = 0;
                this.f.setShadowLayer(staticLayout, staticLayout, staticLayout, i2);
                canvas.restoreToCount(canvas.save());
            }
        }
    }

    @RequiresNonNull("cueBitmap")
    private void f() {
        int round;
        int i2;
        int i5;
        float i3;
        float i4;
        int i;
        int f;
        Bitmap bitmap = this.k;
        int i11 = this.A;
        int i16 = this.B;
        float f3 = (float)i8;
        float f5 = (float)i13;
        int round2 = Math.round(f3 *= f10);
        f = this.r;
        if (Float.compare(f, i20) != 0) {
            round = Math.round(f5 *= f);
        } else {
            round = Math.round(f6 *= f);
        }
        i3 = this.p;
        int i19 = 1;
        int i21 = 2;
        if (i3 == i21) {
            i3 = (float)round2;
            i2 -= i3;
        } else {
        }
        int round3 = Math.round(i2);
        i4 = this.n;
        if (i4 == i21) {
            i4 = (float)round;
            i -= i4;
        } else {
        }
        int round4 = Math.round(i);
        Rect rect = new Rect(round3, round4, round2 += round3, round += round4);
        this.J = rect;
    }

    @RequiresNonNull("cueText")
    private void g() {
        Object spannableStringBuilder;
        java.lang.CharSequence charSequence;
        int i10;
        int i3;
        int i9;
        int absoluteSizeSpan;
        int spans;
        int backgroundColorSpan;
        Layout.Alignment aLIGN_CENTER;
        int height;
        int i5;
        int i2;
        int length;
        int i12;
        int cmp;
        float f;
        int i13;
        int i6;
        int i7;
        int cmp2;
        int i8;
        int i11;
        int i15;
        int i14;
        int i;
        int i4;
        final Object obj = this;
        if (spannableStringBuilder instanceof SpannableStringBuilder != null) {
        } else {
            spannableStringBuilder = new SpannableStringBuilder(obj.i);
        }
        i17 -= i24;
        int i61 = i25 - i32;
        obj.f.setTextSize(obj.x);
        int i62 = (int)i27;
        final int i64 = i62 * 2;
        float f9 = obj.q;
        if (Float.compare(f9, i65) != 0) {
            i9 = (int)i31;
        }
        i = i9;
        String str3 = "SubtitlePainter";
        if (i <= 0) {
            v.h(str3, "Skipped drawing subtitle cue (insufficient space)");
        }
        final int i66 = 0;
        int i35 = 16711680;
        int i58 = 0;
        if (Float.compare(f4, i66) > 0) {
            absoluteSizeSpan = new AbsoluteSizeSpan((int)f20);
            spannableStringBuilder.setSpan(absoluteSizeSpan, i58, spannableStringBuilder.length(), i35);
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
        if (obj.w == 1) {
            spans = spannableStringBuilder2.getSpans(i58, spannableStringBuilder2.length(), ForegroundColorSpan.class);
            i6 = i58;
            while (i6 < spans.length) {
                spannableStringBuilder2.removeSpan((ForegroundColorSpan[])spans[i6]);
                i6++;
                i8 = 1;
            }
        }
        if (Color.alpha(obj.t) > 0) {
            int i29 = obj.w;
            if (i29 != 0) {
                if (i29 == 2) {
                    backgroundColorSpan = new BackgroundColorSpan(obj.t);
                    spannableStringBuilder.setSpan(backgroundColorSpan, i58, spannableStringBuilder.length(), i35);
                } else {
                    backgroundColorSpan = new BackgroundColorSpan(obj.t);
                    spannableStringBuilder2.setSpan(backgroundColorSpan, i58, spannableStringBuilder2.length(), i35);
                }
            } else {
            }
        }
        if (obj.j == null) {
            aLIGN_CENTER = Layout.Alignment.ALIGN_CENTER;
        }
        final Layout.Alignment alignment3 = aLIGN_CENTER;
        StaticLayout staticLayout10 = staticLayout6;
        Layout.Alignment alignment = alignment3;
        int i63 = i58;
        super(spannableStringBuilder, obj.f, i, alignment, obj.d, obj.e, 1);
        obj.E = staticLayout10;
        height = staticLayout10.getHeight();
        i12 = 0;
        i15 = 0;
        while (i15 < obj.E.getLineCount()) {
            i12 = Math.max((int)ceil, i12);
            i15++;
        }
        int i55 = -8388609;
        if (Float.compare(f11, i55) != 0 && i12 < i) {
            if (i12 < i) {
            } else {
                i = i12;
            }
        } else {
        }
        i += i64;
        float f12 = obj.o;
        if (Float.compare(f12, i55) != 0) {
            int i41 = obj.A;
            round += i41;
            cmp = obj.p;
            if (cmp != 1) {
                if (cmp != 2) {
                } else {
                    i3 -= i4;
                }
            } else {
                i21 /= i11;
            }
            i5 = Math.min(i4 += i10, obj.C);
        } else {
            cmp2 = 1;
            i5 = i10 + i4;
        }
        int i68 = i5 - i10;
        if (i68 <= 0) {
            v.h(str3, "Skipped drawing subtitle cue (invalid horizontal positioning)");
        }
        float f13 = obj.l;
        if (Float.compare(f13, i46) != 0) {
            if (obj.m == 0) {
                i13 = obj.n;
                if (i13 == i11) {
                    i2 -= height;
                } else {
                    if (i13 == cmp2) {
                        i40 /= i11;
                    }
                }
            } else {
                int i48 = 0;
                lineBottom -= lineTop;
                float f17 = obj.l;
                if (Float.compare(f17, i66) >= 0) {
                    round3 += i13;
                } else {
                    round2 += i13;
                }
            }
            cmp2 = obj.D;
            if (i2 + height > cmp2) {
                i2 = cmp2 - height;
                i14 = i2;
            } else {
                height = obj.B;
                if (i2 < height) {
                    i14 = height;
                } else {
                }
            }
        } else {
            i37 -= height;
        }
        super(spannableStringBuilder, obj.f, i68, alignment3, obj.d, obj.e, 1);
        obj.E = staticLayout9;
        super(spannableStringBuilder2, obj.f, i68, alignment3, obj.d, obj.e, 1);
        obj.F = staticLayout;
        obj.G = i10;
        obj.H = i14;
        obj.I = i62;
    }

    public void b(c c, com.google.android.exoplayer2.ui.k k2, float f3, float f4, float f5, Canvas canvas6, int i7, int i8, int i9, int i10) {
        int i;
        int i2;
        boolean cmp;
        java.lang.CharSequence valueOf;
        Object obj5;
        i = c.d == null ? 1 : 0;
        i2 = -16777216;
        if (i != 0 && TextUtils.isEmpty(c.a)) {
            if (TextUtils.isEmpty(c.a)) {
            }
            i2 = c.l ? c.m : k2.c;
        }
        if (x.a(this.i, c.a) && p0.b(this.j, c.b) && this.k == c.d && Float.compare(f7, valueOf) == 0 && this.m == c.f && p0.b(Integer.valueOf(this.n), Integer.valueOf(c.g)) && Float.compare(f8, valueOf) == 0 && p0.b(Integer.valueOf(this.p), Integer.valueOf(c.i)) && Float.compare(f9, valueOf) == 0 && Float.compare(f10, valueOf) == 0 && this.s == k2.a && this.t == k2.b && this.u == i2 && this.w == k2.d && this.v == k2.e && p0.b(this.f.getTypeface(), k2.f) && Float.compare(f11, f3) == 0 && Float.compare(f12, f4) == 0 && Float.compare(f13, f5) == 0 && this.A == i7 && this.B == i8 && this.C == i9 && this.D == i10) {
            if (p0.b(this.j, c.b)) {
                if (this.k == c.d) {
                    if (Float.compare(f7, valueOf) == 0) {
                        if (this.m == c.f) {
                            if (p0.b(Integer.valueOf(this.n), Integer.valueOf(c.g))) {
                                if (Float.compare(f8, valueOf) == 0) {
                                    if (p0.b(Integer.valueOf(this.p), Integer.valueOf(c.i))) {
                                        if (Float.compare(f9, valueOf) == 0) {
                                            if (Float.compare(f10, valueOf) == 0) {
                                                if (this.s == k2.a) {
                                                    if (this.t == k2.b) {
                                                        if (this.u == i2) {
                                                            if (this.w == k2.d) {
                                                                if (this.v == k2.e) {
                                                                    if (p0.b(this.f.getTypeface(), k2.f)) {
                                                                        if (Float.compare(f11, f3) == 0) {
                                                                            if (Float.compare(f12, f4) == 0) {
                                                                                if (Float.compare(f13, f5) == 0) {
                                                                                    if (this.A == i7) {
                                                                                        if (this.B == i8) {
                                                                                            if (this.C == i9) {
                                                                                                if (this.D == i10) {
                                                                                                    d(canvas6, i);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        this.i = c.a;
        this.j = c.b;
        this.k = c.d;
        this.l = c.e;
        this.m = c.f;
        this.n = c.g;
        this.o = c.h;
        this.p = c.i;
        this.q = c.j;
        this.r = c.k;
        this.s = k2.a;
        this.t = k2.b;
        this.u = i2;
        this.w = k2.d;
        this.v = k2.e;
        this.f.setTypeface(k2.f);
        this.x = f3;
        this.y = f4;
        this.z = f5;
        this.A = i7;
        this.B = i8;
        this.C = i9;
        this.D = i10;
        if (i != 0) {
            g.e(this.i);
            g();
        } else {
            g.e(this.k);
            f();
        }
        d(canvas6, i);
    }
}
