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

/* compiled from: SegmentedProgressBar.kt */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0015\u0018\u0000 22\u00020\u0001:\u00012B\u0011\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J0\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\tH\u0014J\u0006\u0010#\u001a\u00020\u0018J\u000e\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\tJ\u0010\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\tH\u0016J\u000e\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\tJ\u000e\u0010*\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u0011J\u000e\u0010-\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\tJ\u000e\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\tJ\u0008\u00100\u001a\u00020\u0018H\u0002J\u0008\u00101\u001a\u00020\u0018H\u0002R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063", d2 = {"Lapp/dogo/com/dogo_android/util/customview/SegmentedProgressBar;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activeSegmentPaint", "Landroid/graphics/Paint;", "activeSegmentPosition", "backgroundSegmentPaint", "completedSegmentPaint", "cornerRadius", "", "dividerWidth", "segmentCount", "segmentPositions", "", "Landroid/graphics/RectF;", "init", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "", "left", "top", "right", "bottom", "reset", "setActiveSegmentPosition", "position", "setBackgroundColor", "color", "setCompletedSegmentCount", "progress", "setCornerRadius", "setDividerWidth", "width", "setProgressSegmentColor", "setSegmentCount", "divisions", "setupSegments", "updateProgress", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class SegmentedProgressBar extends View {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final SegmentedProgressBar.a INSTANCE = new SegmentedProgressBar$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private final Paint activeSegmentPaint = new Paint();
    /* renamed from: b, reason: from kotlin metadata */
    private final Paint activeSegmentPosition = new Paint();
    /* renamed from: c, reason: from kotlin metadata */
    private final Paint backgroundSegmentPaint = new Paint();
    /* renamed from: v, reason: from kotlin metadata */
    private float completedSegmentPaint = 1f;
    /* renamed from: w, reason: from kotlin metadata */
    private int cornerRadius = 1;
    /* renamed from: x, reason: from kotlin metadata */
    private List<? extends RectF> dividerWidth;
    /* renamed from: y, reason: from kotlin metadata */
    private float segmentCount = 20f;
    /* renamed from: z, reason: from kotlin metadata */
    private int segmentPositions;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/util/customview/SegmentedProgressBar$Companion;", "", "()V", "TAG", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }
    public SegmentedProgressBar(Context context, AttributeSet set) {
        super(context, set);
        Paint paint = new Paint();
        Paint paint2 = new Paint();
        Paint paint3 = new Paint();
        this.dividerWidth = p.g();
        init(set);
    }

    /* renamed from: a, reason: from kotlin metadata */
    private final void init(AttributeSet attrs) {
        this.dividerWidth = new ArrayList();
        this.segmentCount = 0.0f;
        final int i10 = 0;
        final TypedArray styledAttributes = getContext().getTheme().obtainStyledAttributes(attrs, b.b, i10, i10);
        n.e(styledAttributes, "context.theme.obtainStyledAttributes(attrs, R.styleable.SegmentedProgressBar, 0, 0)");
        try {
            this.activeSegmentPaint.setColor(styledAttributes.getColor(2, a.d(getContext(), 2131099853)));
            this.activeSegmentPosition.setColor(styledAttributes.getColor(3, a.d(getContext(), 2131100352)));
            this.backgroundSegmentPaint.setColor(styledAttributes.getColor(i10, a.d(getContext(), 2131100336)));
            this.completedSegmentPaint = styledAttributes.getDimension(5, this.completedSegmentPaint);
            this.cornerRadius = styledAttributes.getInteger(6, this.cornerRadius);
            this.segmentCount = styledAttributes.getDimension(4, 2f);
            this.segmentPositions = styledAttributes.getInteger(1, i10);
        } finally {
            attrs.recycle();
            throw th;
        }
        styledAttributes.recycle();
    }

    /* renamed from: b, reason: from kotlin metadata */
    private final void reset() {
        int i2 = 0;
        measure(i2, i2);
        final int i4 = 1;
        float f9 = (float)getWidth() - (float)(this.cornerRadius - i4) * this.completedSegmentPaint / (float)this.cornerRadius;
        f intRange = new IntRange(i4, this.cornerRadius);
        ArrayList arrayList = new ArrayList(p.r(intRange, 10));
        Iterator it = intRange.iterator();
        while (it.hasNext()) {
            f = (this.completedSegmentPaint + f9) * (float)(IntIterator)it.d() - i4;
            i = f + f9;
            float f2 = 0.0f;
            f3 = (float)getHeight();
            arrayList.add(new RectF(f, f2, i, f3));
        }
        this.dividerWidth = arrayList;
    }

    private final void c() {
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i2;
        Paint backgroundSegmentPaint2;
        n.f(canvas, "canvas");
        super.onDraw(canvas);
        i2 = 1;
        i = this.dividerWidth.isEmpty() ^ i2;
        if (this.dividerWidth.isEmpty() ^ i2) {
            Iterator it = this.dividerWidth.iterator();
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
        reset();
        c();
    }

    @Override // android.view.View
    public final void setActiveSegmentPosition(int position) {
        this.segmentPositions = position;
        c();
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        this.activeSegmentPaint.setColor(color);
    }

    @Override // android.view.View
    public final void setCompletedSegmentCount(int progress) {
        this.segmentPositions = progress;
        c();
    }

    @Override // android.view.View
    public final void setCornerRadius(float cornerRadius) {
        this.segmentCount = cornerRadius;
    }

    @Override // android.view.View
    public final void setDividerWidth(float width) {
        this.completedSegmentPaint = width;
        reset();
        c();
    }

    @Override // android.view.View
    public final void setProgressSegmentColor(int color) {
        this.activeSegmentPosition.setColor(color);
        c();
    }

    @Override // android.view.View
    public final void setSegmentCount(int divisions) {
        this.cornerRadius = divisions;
        reset();
        c();
    }

}
