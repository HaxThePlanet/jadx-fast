package app.dogo.com.dogo_android.util.customview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.e.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.h0.f;
import kotlin.w;
import kotlin.y.h0;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u00002\u00020\u0001:\u000278B\u0011\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0014J0\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\tH\u0014J\u0010\u0010/\u001a\u00020*2\u0006\u00100\u001a\u000201H\u0016J\u000e\u00102\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\tJ\u0010\u00103\u001a\u00020%2\u0008\u00104\u001a\u0004\u0018\u00010\u001fJ\u0008\u00105\u001a\u00020%H\u0002J\u0008\u00106\u001a\u00020%H\u0002R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008 \u0010!\"\u0004\u0008\"\u0010#¨\u00069", d2 = {"Lapp/dogo/com/dogo_android/util/customview/TrickRatingBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activeBorderPaint", "Landroid/graphics/Paint;", "activeRatingPaint", "activeRatingTextPaint", "barHeight", "", "cornerRadius", "dividerWidth", "emptyRatingTextPaint", "rating", "ratingBackgroundPaint", "ratingBorderPaint", "secondaryRating", "secondaryRatingPaint", "segmentCount", "segmentData", "", "Lapp/dogo/com/dogo_android/util/customview/TrickRatingBar$RatingSegment;", "startX", "tagClickListener", "Lapp/dogo/com/dogo_android/util/customview/TrickRatingBar$OnClickEventListener;", "getTagClickListener", "()Lapp/dogo/com/dogo_android/util/customview/TrickRatingBar$OnClickEventListener;", "setTagClickListener", "(Lapp/dogo/com/dogo_android/util/customview/TrickRatingBar$OnClickEventListener;)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "", "left", "top", "right", "bottom", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setInitialRating", "setOnClickEventListener", "listener", "setupSegments", "updateProgress", "OnClickEventListener", "RatingSegment", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TrickRatingBar extends View {

    private float A;
    private final int B = 5;
    private List<app.dogo.com.dogo_android.util.customview.TrickRatingBar.b> C;
    private float D = 100f;
    private int E;
    private int F;
    private float G;
    private app.dogo.com.dogo_android.util.customview.TrickRatingBar.a H;
    private final Paint a;
    private final Paint b;
    private final Paint c;
    private final Paint v;
    private final Paint w;
    private final Paint x;
    private final Paint y;
    private float z;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/util/customview/TrickRatingBar$OnClickEventListener;", "", "onRatingClick", "", "newRating", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        public abstract void a(int i);
    }

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0082\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u0015", d2 = {"Lapp/dogo/com/dogo_android/util/customview/TrickRatingBar$RatingSegment;", "", "segmentPos", "Landroid/graphics/RectF;", "numberPos", "Landroid/graphics/PointF;", "(Landroid/graphics/RectF;Landroid/graphics/PointF;)V", "getNumberPos", "()Landroid/graphics/PointF;", "getSegmentPos", "()Landroid/graphics/RectF;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class b {

        private final RectF a;
        private final PointF b;
        public b(RectF rectF, PointF pointF2) {
            n.f(rectF, "segmentPos");
            n.f(pointF2, "numberPos");
            super();
            this.a = rectF;
            this.b = pointF2;
        }

        public final PointF a() {
            return this.b;
        }

        public final RectF b() {
            return this.a;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof TrickRatingBar.b) {
                return i2;
            }
            if (!n.b(this.a, object.a)) {
                return i2;
            }
            if (!n.b(this.b, object.b)) {
                return i2;
            }
            return i;
        }

        public int hashCode() {
            return i2 += i4;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("RatingSegment(segmentPos=");
            stringBuilder.append(this.a);
            stringBuilder.append(", numberPos=");
            stringBuilder.append(this.b);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }
    public TrickRatingBar(Context context, AttributeSet attributeSet2) {
        boolean inEditMode;
        boolean obj8;
        super(context, attributeSet2);
        obj8 = 1;
        Paint obj7 = new Paint(obj8);
        final int i = -1;
        obj7.setColor(i);
        w wVar = w.a;
        this.a = obj7;
        obj7 = new Paint(obj8);
        int i2 = 2131100352;
        int i4 = 0;
        obj7.setColor(getResources().getColor(i2, i4));
        this.b = obj7;
        obj7 = new Paint(obj8);
        final int i6 = 2131099858;
        obj7.setColor(getResources().getColor(i6, i4));
        this.c = obj7;
        obj7 = new Paint(obj8);
        obj7.setColor(getResources().getColor(i6, i4));
        obj7.setStyle(Paint.Style.STROKE);
        final int i7 = 2131165623;
        obj7.setStrokeWidth(getResources().getDimension(i7));
        this.v = obj7;
        obj7 = new Paint(obj8);
        obj7.setColor(getResources().getColor(i2, i4));
        obj7.setStyle(Paint.Style.STROKE);
        obj7.setStrokeWidth(getResources().getDimension(i7));
        this.w = obj7;
        obj7 = new Paint(obj8);
        obj7.setColor(getResources().getColor(i6, i4));
        int i3 = 2131165912;
        obj7.setTextSize(getResources().getDimension(i3));
        int i5 = 2131296256;
        if (!isInEditMode()) {
            obj7.setTypeface(f.g(getContext(), i5));
        }
        this.x = obj7;
        obj7 = new Paint(obj8);
        obj7.setColor(i);
        obj7.setTextSize(getResources().getDimension(i3));
        if (!isInEditMode()) {
            obj7.setTypeface(f.g(getContext(), i5));
        }
        this.y = obj7;
        this.z = getResources().getDimension(2131165631);
        this.A = getResources().getDimension(2131165911);
        obj7 = 5;
        this.C = p.g();
        obj7 = 1120403456;
    }

    private final void a() {
        int bVar;
        int i2;
        PointF pointF;
        RectF rectF;
        int i;
        final int i3 = 0;
        measure(i3, i3);
        final int i9 = 1;
        float f5 = this.A;
        float f6 = (float)i13;
        i7 /= f6;
        i10 /= f7;
        f fVar = new f(i9, this.B);
        ArrayList arrayList = new ArrayList(p.r(fVar, 10));
        Iterator iterator = fVar.iterator();
        while (iterator.hasNext()) {
            int i17 = (h0)iterator.d();
            float f9 = this.z;
            i22 += f9;
            rectF = new RectF(i23, i8, i23 + i11, f5 += i8);
            Rect rect = new Rect();
            String valueOf = String.valueOf(i17);
            Objects.requireNonNull(valueOf, "null cannot be cast to non-null type java.lang.String");
            char[] charArray = valueOf.toCharArray();
            n.e(charArray, "(this as java.lang.String).toCharArray()");
            this.y.getTextBounds(charArray, i3, i9, rect);
            pointF = new PointF(centerX -= i20, centerY += i18);
            bVar = new TrickRatingBar.b(rectF, pointF);
            arrayList.add(bVar);
        }
        this.C = arrayList;
    }

    private final void b() {
        invalidate();
    }

    @Override // android.view.View
    public final app.dogo.com.dogo_android.util.customview.TrickRatingBar.a getTagClickListener() {
        return this.H;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int iterator;
        int i;
        int i2;
        int i3;
        String valueOf;
        boolean next;
        int i4;
        float f;
        int i5;
        Paint paint;
        n.f(canvas, "canvas");
        super.onDraw(canvas);
        final int i6 = 1;
        if (empty ^= i6 != 0) {
            iterator = this.C.iterator();
            i = 0;
            i2 = i;
            for (Object next2 : iterator) {
                i4 = i2 + 1;
                if (i4 <= this.E) {
                } else {
                }
                i3 = i;
                if (i4 <= this.F) {
                } else {
                }
                i5 = i;
                if (i3 != 0) {
                } else {
                }
                if (i5 != 0) {
                } else {
                }
                float f4 = this.D;
                canvas.drawRoundRect((TrickRatingBar.b)next2.b(), f4, f4, this.a);
                float f5 = this.D;
                canvas.drawRoundRect(next2.b(), f5, f5, this.v);
                canvas.drawText(String.valueOf(i4), pointF5.x, pointF2.y, this.x);
                i2 = i4;
                float f6 = this.D;
                canvas.drawRoundRect(next2.b(), f6, f6, this.c);
                float f7 = this.D;
                canvas.drawRoundRect(next2.b(), f7, f7, this.v);
                canvas.drawText(String.valueOf(i4), pointF6.x, pointF3.y, this.y);
                float f2 = this.D;
                canvas.drawRoundRect(next2.b(), f2, f2, this.b);
                float f3 = this.D;
                canvas.drawRoundRect(next2.b(), f3, f3, this.w);
                canvas.drawText(String.valueOf(i4), pointF4.x, pointF.y, this.y);
                i5 = i6;
                i3 = i6;
            }
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        a();
        b();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        int contains;
        RectF rectF;
        float f;
        n.f(motionEvent, "event");
        int action = motionEvent.getAction();
        if (action != 0 && action != 2) {
            if (action != 2) {
                return super.onTouchEvent(motionEvent);
            }
        }
        this.G = motionEvent.getX();
        i = 0;
        Iterator obj5 = this.C.iterator();
        for (TrickRatingBar.b next : obj5) {
            i++;
        }
        i = -1;
        obj5 = i + 1;
        if (i >= 0 && this.E != obj5) {
            if (this.E != obj5) {
                this.E = obj5;
                i = this.H;
                if (i == null) {
                } else {
                    i.a(obj5);
                }
                invalidate();
            }
        }
        return 1;
    }

    @Override // android.view.View
    public final void setInitialRating(int i) {
        this.E = i;
        this.F = i;
    }

    @Override // android.view.View
    public final void setOnClickEventListener(app.dogo.com.dogo_android.util.customview.TrickRatingBar.a trickRatingBar$a) {
        this.H = a;
    }

    @Override // android.view.View
    public final void setTagClickListener(app.dogo.com.dogo_android.util.customview.TrickRatingBar.a trickRatingBar$a) {
        this.H = a;
    }
}
