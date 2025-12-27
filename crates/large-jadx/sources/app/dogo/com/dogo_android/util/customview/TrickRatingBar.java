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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.w;
import kotlin.y.h0;
import kotlin.y.p;

/* compiled from: TrickRatingBar.kt */
@Metadata(d1 = "\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u00002\u00020\u0001:\u000278B\u0011\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0014J0\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\tH\u0014J\u0010\u0010/\u001a\u00020*2\u0006\u00100\u001a\u000201H\u0016J\u000e\u00102\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\tJ\u0010\u00103\u001a\u00020%2\u0008\u00104\u001a\u0004\u0018\u00010\u001fJ\u0008\u00105\u001a\u00020%H\u0002J\u0008\u00106\u001a\u00020%H\u0002R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008 \u0010!\"\u0004\u0008\"\u0010#¨\u00069", d2 = {"Lapp/dogo/com/dogo_android/util/customview/TrickRatingBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activeBorderPaint", "Landroid/graphics/Paint;", "activeRatingPaint", "activeRatingTextPaint", "barHeight", "", "cornerRadius", "dividerWidth", "emptyRatingTextPaint", "rating", "ratingBackgroundPaint", "ratingBorderPaint", "secondaryRating", "secondaryRatingPaint", "segmentCount", "segmentData", "", "Lapp/dogo/com/dogo_android/util/customview/TrickRatingBar$RatingSegment;", "startX", "tagClickListener", "Lapp/dogo/com/dogo_android/util/customview/TrickRatingBar$OnClickEventListener;", "getTagClickListener", "()Lapp/dogo/com/dogo_android/util/customview/TrickRatingBar$OnClickEventListener;", "setTagClickListener", "(Lapp/dogo/com/dogo_android/util/customview/TrickRatingBar$OnClickEventListener;)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "", "left", "top", "right", "bottom", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setInitialRating", "setOnClickEventListener", "listener", "setupSegments", "updateProgress", "OnClickEventListener", "RatingSegment", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class TrickRatingBar extends View {

    /* renamed from: A, reason: from kotlin metadata */
    private float activeBorderPaint;
    /* renamed from: B, reason: from kotlin metadata */
    private final int activeRatingPaint = 5;
    /* renamed from: C, reason: from kotlin metadata */
    private List<TrickRatingBar.b> activeRatingTextPaint;
    /* renamed from: D, reason: from kotlin metadata */
    private float barHeight = 100f;
    /* renamed from: E, reason: from kotlin metadata */
    private int cornerRadius;
    /* renamed from: F, reason: from kotlin metadata */
    private int dividerWidth;
    /* renamed from: G, reason: from kotlin metadata */
    private float emptyRatingTextPaint;
    /* renamed from: H, reason: from kotlin metadata */
    private TrickRatingBar.a rating;
    /* renamed from: a, reason: from kotlin metadata */
    private final Paint ratingBackgroundPaint = new Paint(1);
    /* renamed from: b, reason: from kotlin metadata */
    private final Paint ratingBorderPaint = new Paint(1);
    /* renamed from: c, reason: from kotlin metadata */
    private final Paint secondaryRating = new Paint(1);
    /* renamed from: v, reason: from kotlin metadata */
    private final Paint secondaryRatingPaint = new Paint(1);
    /* renamed from: w, reason: from kotlin metadata */
    private final Paint segmentCount = new Paint(1);
    /* renamed from: x, reason: from kotlin metadata */
    private final Paint segmentData = new Paint(1);
    /* renamed from: y, reason: from kotlin metadata */
    private final Paint startX = new Paint(1);
    private float z;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/util/customview/TrickRatingBar$OnClickEventListener;", "", "onRatingClick", "", "newRating", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        /* renamed from: a, reason: from kotlin metadata */
        void onRatingClick(int newRating);
    }

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0082\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u0015", d2 = {"Lapp/dogo/com/dogo_android/util/customview/TrickRatingBar$RatingSegment;", "", "segmentPos", "Landroid/graphics/RectF;", "numberPos", "Landroid/graphics/PointF;", "(Landroid/graphics/RectF;Landroid/graphics/PointF;)V", "getNumberPos", "()Landroid/graphics/PointF;", "getSegmentPos", "()Landroid/graphics/RectF;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class b {

        private final RectF a;
        private final PointF b;
        public b(RectF rectF, PointF pointF) {
            n.f(rectF, "segmentPos");
            n.f(pointF, "numberPos");
            super();
            this.a = rectF;
            this.b = pointF;
        }

        /* renamed from: a, reason: from kotlin metadata */
        /* operator */ public final PointF component1() {
            return this.b;
        }

        public final RectF b() {
            return this.a;
        }

        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z4 = false;
            if (!(other instanceof TrickRatingBar_RatingSegment)) {
                return false;
            }
            if (!n.b(this.a, other.a)) {
                return false;
            }
            return !n.b(this.b, other.b) ? z4 : z;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "RatingSegment(segmentPos=";
            String str3 = ", numberPos=";
            str = str2 + this.a + str3 + this.b + 41;
            return str;
        }
    }
    public TrickRatingBar(Context context, AttributeSet set) throws android.content.res.Resources.NotFoundException {
        super(context, set);
        int i9 = 1;
        final int i = -1;
        new Paint(i9).setColor(i);
        int i2 = 2131100352;
        android.content.res.Resources.Theme theme = null;
        new Paint(i9).setColor(getResources().getColor(i2, theme));
        final int i5 = 2131099858;
        new Paint(i9).setColor(getResources().getColor(i5, theme));
        Paint paint4 = new Paint(i9);
        paint4.setColor(getResources().getColor(i5, theme));
        paint4.setStyle(Paint.Style.STROKE);
        final int i6 = 2131165623;
        paint4.setStrokeWidth(getResources().getDimension(i6));
        Paint paint5 = new Paint(i9);
        paint5.setColor(getResources().getColor(i2, theme));
        paint5.setStyle(Paint.Style.STROKE);
        paint5.setStrokeWidth(getResources().getDimension(i6));
        Paint paint6 = new Paint(i9);
        paint6.setColor(getResources().getColor(i5, theme));
        int i3 = 2131165912;
        paint6.setTextSize(getResources().getDimension(i3));
        int i4 = 2131296256;
        paint6.setTypeface(f.g(getContext(), i4));
        Paint paint7 = new Paint(i9);
        paint7.setColor(i);
        paint7.setTextSize(getResources().getDimension(i3));
        paint7.setTypeface(f.g(getContext(), i4));
        this.z = getResources().getDimension(2131165631);
        this.activeBorderPaint = getResources().getDimension(2131165911);
        this.activeRatingTextPaint = p.g();
    }

    /* renamed from: a, reason: from kotlin metadata */
    private final void setupSegments() {
        final int i2 = 0;
        measure(i2, i2);
        final int i4 = 1;
        float f13 = (float)2;
        float f7 = (float)getHeight() - activeBorderPaint2 / f13;
        float f11 = (float)getWidth() - (float)(this.activeRatingPaint + i4) * this.z / (float)this.activeRatingPaint;
        kotlin.h0.f intRange = new IntRange(i4, this.activeRatingPaint);
        ArrayList arrayList = new ArrayList(p.r(intRange, 10));
        Iterator it = intRange.iterator();
        while (it.hasNext()) {
            int i7 = (IntIterator)it.d();
            float f23 = (f11 + f17) * (float)(i7 - 1) + f17;
            RectF rectF = new RectF(f23, f7, f23 + f11, activeBorderPaint2 + f7);
            Rect rect = new Rect();
            String str = String.valueOf(i7);
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            char[] charArray = str.toCharArray();
            n.e(charArray, "(this as java.lang.String).toCharArray()");
            this.startX.getTextBounds(charArray, i2, i4, rect);
            f2 = rectF.centerX() - (float)rect.width() / f13;
            f = rectF.centerY() + (float)rect.height() / f13;
            arrayList.add(new TrickRatingBar_RatingSegment(rectF, new PointF(f2, f)));
        }
        this.activeRatingTextPaint = arrayList;
    }

    private final void b() {
        invalidate();
    }

    @Override // android.view.View
    public final TrickRatingBar.a getTagClickListener() {
        return this.rating;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i2;
        float f;
        float f2;
        Paint startX2;
        n.f(canvas, "canvas");
        super.onDraw(canvas);
        i2 = 1;
        i = this.activeRatingTextPaint.isEmpty() ^ i2;
        if (this.activeRatingTextPaint.isEmpty() ^ i2) {
            Iterator it = this.activeRatingTextPaint.iterator();
            i2 = 0;
            while (it.hasNext()) {
                Object item = it.next();
                i2 = i2 + 1;
                if (i2 < 0) {
                    p.q();
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) 0;
                }
            }
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        setupSegments();
        b();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        int cornerRadius2 = 0;
        int i = 2;
        RectF rectF;
        float emptyRatingTextPaint2;
        n.f(event, "event");
        int action = event.getAction();
        if (action != 0 && action != 2) {
            return super.onTouchEvent(event);
        }
        this.emptyRatingTextPaint = event.getX();
        cornerRadius2 = 0;
        Iterator it = this.activeRatingTextPaint.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            if (item.b().contains(this.emptyRatingTextPaint, item.b().centerY())) {
                break;
            }
        }
        cornerRadius2 = -1;
        int i2 = cornerRadius2 + 1;
        if (this.cornerRadius >= 0 && this.cornerRadius != this.activeRatingTextPaint) {
            this.cornerRadius = i2;
            if (this.rating != null) {
                this.rating.onRatingClick(i2);
            }
            invalidate();
        }
        return true;
    }

    @Override // android.view.View
    public final void setInitialRating(int rating) {
        this.cornerRadius = rating;
        this.dividerWidth = rating;
    }

    @Override // android.view.View
    public final void setOnClickEventListener(TrickRatingBar.a listener) {
        this.rating = listener;
    }

    @Override // android.view.View
    public final void setTagClickListener(TrickRatingBar.a aVar) {
        this.rating = aVar;
    }
}
