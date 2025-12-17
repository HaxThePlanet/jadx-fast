package app.dogo.com.dogo_android.util.customview;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.a;
import app.dogo.com.dogo_android.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.h0.f;
import kotlin.y.h0;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0015\u0018\u0000 22\u00020\u0001:\u00012B\u0011\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J0\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\tH\u0014J\u0006\u0010#\u001a\u00020\u0018J\u000e\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\tJ\u0010\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\tH\u0016J\u000e\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\tJ\u000e\u0010*\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u0011J\u000e\u0010-\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\tJ\u000e\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\tJ\u0008\u00100\u001a\u00020\u0018H\u0002J\u0008\u00101\u001a\u00020\u0018H\u0002R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063", d2 = {"Lapp/dogo/com/dogo_android/util/customview/SegmentedProgressBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activeSegmentPaint", "Landroid/graphics/Paint;", "activeSegmentPosition", "backgroundSegmentPaint", "completedSegmentPaint", "cornerRadius", "", "dividerWidth", "segmentCount", "segmentPositions", "", "Landroid/graphics/RectF;", "init", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "", "left", "top", "right", "bottom", "reset", "setActiveSegmentPosition", "position", "setBackgroundColor", "color", "setCompletedSegmentCount", "progress", "setCornerRadius", "setDividerWidth", "width", "setProgressSegmentColor", "setSegmentCount", "divisions", "setupSegments", "updateProgress", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SegmentedProgressBar extends View {

    public static final app.dogo.com.dogo_android.util.customview.SegmentedProgressBar.a Companion;
    private final Paint a;
    private final Paint b;
    private final Paint c;
    private float v = 1f;
    private int w = 1;
    private List<? extends RectF> x;
    private float y = 20f;
    private int z;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/util/customview/SegmentedProgressBar$Companion;", "", "()V", "TAG", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }
    static {
        SegmentedProgressBar.a aVar = new SegmentedProgressBar.a(0);
        SegmentedProgressBar.Companion = aVar;
    }

    public SegmentedProgressBar(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        Paint obj1 = new Paint();
        this.a = obj1;
        obj1 = new Paint();
        this.b = obj1;
        obj1 = new Paint();
        this.c = obj1;
        obj1 = 1065353216;
        obj1 = 1;
        this.x = p.g();
        obj1 = 1101004800;
        a(attributeSet2);
    }

    private final void a(AttributeSet attributeSet) {
        ArrayList arrayList = new ArrayList();
        this.x = arrayList;
        this.y = 0;
        final int i11 = 0;
        final TypedArray obj6 = getContext().getTheme().obtainStyledAttributes(attributeSet, b.b, i11, i11);
        n.e(obj6, "context.theme.obtainStyledAttributes(attrs, R.styleable.SegmentedProgressBar, 0, 0)");
        this.a.setColor(obj6.getColor(2, a.d(getContext(), 2131099853)));
        this.b.setColor(obj6.getColor(3, a.d(getContext(), 2131100352)));
        this.c.setColor(obj6.getColor(i11, a.d(getContext(), 2131100336)));
        this.v = obj6.getDimension(5, this.v);
        this.w = obj6.getInteger(6, this.w);
        this.y = obj6.getDimension(4, 1073741824);
        this.z = obj6.getInteger(1, i11);
        obj6.recycle();
    }

    private final void b() {
        int i;
        int i2;
        RectF rectF;
        int i3;
        float f;
        int i4 = 0;
        measure(i4, i4);
        final int i9 = 1;
        i10 /= f3;
        f fVar = new f(i9, this.w);
        ArrayList arrayList = new ArrayList(p.r(fVar, 10));
        Iterator iterator = fVar.iterator();
        while (iterator.hasNext()) {
            i16 *= f6;
            rectF = new RectF(i2, 0, i2 + i11, (float)height);
            arrayList.add(rectF);
        }
        this.x = arrayList;
    }

    private final void c() {
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int iterator;
        int i2;
        int i3;
        int i;
        float f;
        boolean next;
        int i4;
        Paint paint;
        int i5;
        n.f(canvas, "canvas");
        super.onDraw(canvas);
        final int i6 = 1;
        if (empty ^= i6 != 0) {
            iterator = this.x.iterator();
            i2 = 0;
            i3 = i2;
            for (Object next : iterator) {
                int i7 = this.z;
                if (i3 == i7) {
                } else {
                }
                i5 = i2;
                if (i3 < i7) {
                } else {
                }
                i = i2;
                if (i5 != 0) {
                } else {
                }
                if (i != 0) {
                } else {
                }
                f = this.y;
                canvas.drawRoundRect((RectF)next, f, f, this.a);
                i3 = i4;
                f = this.y;
                canvas.drawRoundRect(next, f, f, this.b);
                f = this.y;
                canvas.drawRoundRect(next, f, f, this.c);
                i = i6;
                i5 = i6;
            }
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        b();
        c();
    }

    @Override // android.view.View
    public final void setActiveSegmentPosition(int i) {
        this.z = i;
        c();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.a.setColor(i);
    }

    @Override // android.view.View
    public final void setCompletedSegmentCount(int i) {
        this.z = i;
        c();
    }

    @Override // android.view.View
    public final void setCornerRadius(float f) {
        this.y = f;
    }

    @Override // android.view.View
    public final void setDividerWidth(float f) {
        this.v = f;
        b();
        c();
    }

    @Override // android.view.View
    public final void setProgressSegmentColor(int i) {
        this.b.setColor(i);
        c();
    }

    @Override // android.view.View
    public final void setSegmentCount(int i) {
        this.w = i;
        b();
        c();
    }
}
