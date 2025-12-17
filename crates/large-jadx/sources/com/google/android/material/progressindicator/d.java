package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import f.c.a.e.r.a;

/* loaded from: classes2.dex */
final class d extends com.google.android.material.progressindicator.i<com.google.android.material.progressindicator.f> {

    private int c = 1;
    private float d;
    private float e;
    private float f;
    public d(com.google.android.material.progressindicator.f f) {
        super(f);
        final int obj1 = 1;
    }

    private void h(Canvas canvas, Paint paint2, float f3, float f4, float f5) {
        canvas.save();
        canvas.rotate(f5);
        float f = this.f;
        f3 /= i2;
        RectF obj7 = new RectF(f - obj5, f4, f += obj5, -f4);
        canvas.drawRoundRect(obj7, f4, f4, paint2);
        canvas.restore();
    }

    private int i() {
        com.google.android.material.progressindicator.c cVar = this.a;
        return i3 += i2;
    }

    @Override // com.google.android.material.progressindicator.i
    public void a(Canvas canvas, float f2) {
        int i;
        int i2;
        int obj5;
        float obj6;
        com.google.android.material.progressindicator.c cVar = this.a;
        final int i21 = 1073741824;
        i18 += f;
        canvas.translate(i19, i19);
        canvas.rotate(-1028390912);
        int i5 = -i19;
        canvas.clipRect(i5, i5, i19, i19);
        obj5 = this.a;
        int i20 = 1;
        i = cVar2.i == 0 ? i20 : -1;
        this.c = i;
        this.d = f3 *= f2;
        this.e = f4 *= f2;
        this.f = obj5 /= i21;
        i2 = 1065353216;
        final int i22 = 2;
        if (this.b.j()) {
            if (obj5.e != i22) {
                if (this.b.i() && obj5.f == i20) {
                    if (obj5.f == i20) {
                        this.f = obj5 += i2;
                    } else {
                        if (this.b.j()) {
                            if (obj5.e != i20) {
                                if (this.b.i() && obj5.f == i22) {
                                    if (obj5.f == i22) {
                                        this.f = obj5 -= i2;
                                    }
                                }
                            } else {
                            }
                        } else {
                        }
                    }
                } else {
                }
            } else {
            }
        } else {
        }
    }

    @Override // com.google.android.material.progressindicator.i
    void b(Canvas canvas, Paint paint2, float f3, float f4, int i5) {
        int i2;
        int cmp;
        int i6;
        int i4;
        int i3;
        int i;
        Paint paint;
        final Object obj = this;
        final Paint paint3 = paint2;
        if (Float.compare(f3, f4) == 0) {
        }
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeCap(Paint.Cap.BUTT);
        paint2.setAntiAlias(true);
        paint2.setColor(i5);
        paint2.setStrokeWidth(obj.d);
        final int i18 = 1135869952;
        int i14 = obj.c;
        final int i19 = i9 * f8;
        if (Float.compare(f4, f3) >= 0) {
            i2 = f4 - f3;
        } else {
            i13 -= f3;
        }
        final int i20 = i11;
        float f2 = obj.f;
        RectF rectF = new RectF(-f2, -f2, f2, f2);
        canvas.drawArc(rectF, i19, i20, false, paint2);
        if (Float.compare(f5, i6) > 0 && Float.compare(f6, i18) < 0) {
            if (Float.compare(f6, i18) < 0) {
                paint2.setStyle(Paint.Style.FILL);
                cmp = this;
                i6 = canvas;
                i4 = paint2;
                cmp.h(i6, i4, obj.d, obj.e, i19);
                cmp.h(i6, i4, obj.d, obj.e, i19 + i20);
            }
        }
    }

    @Override // com.google.android.material.progressindicator.i
    void c(Canvas canvas, Paint paint2) {
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeCap(Paint.Cap.BUTT);
        paint2.setAntiAlias(true);
        paint2.setColor(a.a(cVar.d, this.b.getAlpha()));
        paint2.setStrokeWidth(this.d);
        float f2 = this.f;
        RectF rectF = new RectF(-f2, -f2, f2, f2);
        canvas.drawArc(rectF, 0, 1135869952, false, paint2);
    }

    @Override // com.google.android.material.progressindicator.i
    public int d() {
        return i();
    }

    @Override // com.google.android.material.progressindicator.i
    public int e() {
        return i();
    }
}
