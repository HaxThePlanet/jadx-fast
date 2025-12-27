package app.dogo.com.dogo_android.util.customview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.e0.a;
import kotlin.h0.f;
import kotlin.k0.l;
import kotlin.w;
import kotlin.y.h0;
import kotlin.y.p;

/* compiled from: DogLogView.kt */
@Metadata(d1 = "\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000c\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\u0018\u0000 a2\u00020\u0001:\u0006`abcdeB\u0011\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0002J\u0018\u00105\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00106\u001a\u00020&H\u0002J\u0010\u00107\u001a\u0002022\u0006\u00103\u001a\u000204H\u0002J\u001a\u00108\u001a\u0002092\u0008\u0008\u0001\u0010:\u001a\u00020\t2\u0006\u0010;\u001a\u000209H\u0002J\u001c\u0010<\u001a\u00020\t2\u0008\u0008\u0001\u0010=\u001a\u00020\t2\u0008\u0008\u0001\u0010>\u001a\u00020\tH\u0003J\u0008\u0010?\u001a\u000202H\u0002J(\u0010@\u001a\u00020A2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010C\u001a\u00020\u000eH\u0002J\u0010\u0010D\u001a\u0002022\u0006\u00103\u001a\u000204H\u0014J0\u0010E\u001a\u0002022\u0006\u0010F\u001a\u00020A2\u0006\u0010G\u001a\u00020\t2\u0006\u0010H\u001a\u00020\t2\u0006\u0010I\u001a\u00020\t2\u0006\u0010J\u001a\u00020\tH\u0014J\u0018\u0010K\u001a\u0002022\u0006\u0010L\u001a\u00020\t2\u0006\u0010M\u001a\u00020\tH\u0014J\u0010\u0010N\u001a\u00020A2\u0006\u0010O\u001a\u00020PH\u0016J\u0010\u0010Q\u001a\u00020\u00122\u0006\u0010R\u001a\u00020\u0019H\u0002J\u0008\u0010S\u001a\u000202H\u0002J\u0008\u0010T\u001a\u000202H\u0002J\u0010\u0010U\u001a\u0002022\u0008\u0010V\u001a\u0004\u0018\u00010 J\u0014\u0010W\u001a\u0002022\u000c\u0010X\u001a\u0008\u0012\u0004\u0012\u00020Y0\rJ\u0008\u0010Z\u001a\u000202H\u0002J\u0018\u0010[\u001a\u00020&2\u0006\u0010R\u001a\u00020\u00192\u0006\u0010\\\u001a\u00020]H\u0002J\u0016\u0010^\u001a\u0008\u0012\u0004\u0012\u00020&0\r2\u0006\u0010_\u001a\u00020\tH\u0002R\u000e\u0010\u000b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00190\r0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008!\u0010\"\"\u0004\u0008#\u0010$R\u0014\u0010%\u001a\u0008\u0012\u0004\u0012\u00020&0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00120+X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020.0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006f", d2 = {"Lapp/dogo/com/dogo_android/util/customview/DogLogView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cellCount", "cellLinePoints", "", "", "defaultLetterPaint", "Landroid/graphics/Paint;", "defaultStyleGraphics", "Lapp/dogo/com/dogo_android/util/customview/DogLogView$TagStyleGraphics;", "gridPaint", "lineCount", "lineThresholdMs", "", "positionBucket", "Landroid/util/SparseArray;", "Lapp/dogo/com/dogo_android/util/customview/DogLogView$TagModel;", "ringPaint", "ringRadius", "ringStrokeWidth", "startX", "startY", "tagClickListener", "Lapp/dogo/com/dogo_android/util/customview/DogLogView$OnClickEventListener;", "getTagClickListener", "()Lapp/dogo/com/dogo_android/util/customview/DogLogView$OnClickEventListener;", "setTagClickListener", "(Lapp/dogo/com/dogo_android/util/customview/DogLogView$OnClickEventListener;)V", "tagGraphicsList", "Lapp/dogo/com/dogo_android/util/customview/DogLogView$TagGraphics;", "tagLineGapHeight", "tagLineStartYPosition", "tagRadius", "tagStyleGraphics", "", "", "tagStyles", "Lapp/dogo/com/dogo_android/util/customview/DogLogView$CalendarTag$TagStyles;", "viewHeight", "viewWidth", "drawGrid", "", "canvas", "Landroid/graphics/Canvas;", "drawTag", "tagGraphics", "drawTags", "getCharOrDefault", "", "stringRes", "defaultChar", "getColorOrDefault", "colorRes", "defaultColorInt", "init", "isAClick", "", "endX", "endY", "onDraw", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "parseTagStyleGraphics", "tagModel", "prepareGridGraphics", "prepareTagGraphics", "setOnClickEventListener", "listener", "setTags", "tagModels", "Lapp/dogo/com/dogo_android/util/customview/DogLogView$CalendarTag;", "setupGraphics", "setupTagGraphics", "center", "Landroid/graphics/PointF;", "setupTagLineGraphics", "tagLinePosition", "CalendarTag", "Companion", "OnClickEventListener", "TagGraphics", "TagModel", "TagStyleGraphics", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class DogLogView extends View {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final DogLogView.b INSTANCE = new DogLogView$b(0);
    private static final long O = 0L;
    /* renamed from: A, reason: from kotlin metadata */
    private final int cellCount;
    /* renamed from: B, reason: from kotlin metadata */
    private final int cellLinePoints;
    /* renamed from: C, reason: from kotlin metadata */
    private final Paint defaultLetterPaint = new Paint(1);
    /* renamed from: D, reason: from kotlin metadata */
    private final Paint defaultStyleGraphics = new Paint(1);
    /* renamed from: E, reason: from kotlin metadata */
    private final Paint gridPaint = new Paint();
    /* renamed from: F, reason: from kotlin metadata */
    private final DogLogView.f lineCount = new DogLogView$f();
    /* renamed from: G, reason: from kotlin metadata */
    private final Map<String, DogLogView.f> lineThresholdMs = new LinkedHashMap<>();
    /* renamed from: H, reason: from kotlin metadata */
    private final Map<String, DogLogView.a.b> positionBucket = new LinkedHashMap<>();
    /* renamed from: I, reason: from kotlin metadata */
    private final SparseArray<List<DogLogView.e>> ringPaint = new SparseArray<>();
    /* renamed from: J, reason: from kotlin metadata */
    private List<DogLogView.d> ringRadius;
    /* renamed from: K, reason: from kotlin metadata */
    private List<Float> ringStrokeWidth;
    /* renamed from: L, reason: from kotlin metadata */
    private float startX;
    /* renamed from: M, reason: from kotlin metadata */
    private float startY;
    private DogLogView.c N;
    /* renamed from: a, reason: from kotlin metadata */
    private final float tagGraphicsList;
    /* renamed from: b, reason: from kotlin metadata */
    private final float tagLineGapHeight;
    /* renamed from: c, reason: from kotlin metadata */
    private final float tagLineStartYPosition;
    /* renamed from: v, reason: from kotlin metadata */
    private final float tagRadius;
    /* renamed from: w, reason: from kotlin metadata */
    private final float tagStyleGraphics;
    /* renamed from: x, reason: from kotlin metadata */
    private final int tagStyles = 24;
    /* renamed from: y, reason: from kotlin metadata */
    private final int viewHeight;
    /* renamed from: z, reason: from kotlin metadata */
    private final long viewWidth;

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0017\u0018\u00002\u00020\u0001:\u0001\u0016B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u0017", d2 = {"Lapp/dogo/com/dogo_android/util/customview/DogLogView$CalendarTag;", "Landroid/os/Parcelable;", "timeOfDayMs", "", "hasBorder", "", "style", "Lapp/dogo/com/dogo_android/util/customview/DogLogView$CalendarTag$TagStyles;", "(JZLapp/dogo/com/dogo_android/util/customview/DogLogView$CalendarTag$TagStyles;)V", "getHasBorder", "()Z", "getStyle", "()Lapp/dogo/com/dogo_android/util/customview/DogLogView$CalendarTag$TagStyles;", "getTimeOfDayMs", "()J", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "TagStyles", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class a implements Parcelable {

        public static final Parcelable.Creator<DogLogView.a> CREATOR = new DogLogView$a$a<>();
        private final long a;
        private final boolean b;
        private final DogLogView.a.b c;
        public a(long j, boolean z, DogLogView.a.b bVar) {
            n.f(bVar, "style");
            super();
            this.a = j;
            this.b = z;
            this.c = bVar;
        }

        /* renamed from: a, reason: from kotlin metadata */
        public boolean describeContents() {
            return this.b;
        }

        public DogLogView.a.b b() {
            return this.c;
        }

        public long c() {
            return this.a;
        }


        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeLong(this.a);
            parcel.writeInt(this.b);
            parcel.writeParcelable(this.c, flags);
        }
    }

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/util/customview/DogLogView$Companion;", "", "()V", "CLICK_ACTION_POSITION_DIFFERENCE_THRESHOLD", "", "MS_IN_DAY", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b {
        private b() {
            super();
        }

        public /* synthetic */ b(kotlin.d0.d.g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/util/customview/DogLogView$OnClickEventListener;", "", "onLineClicked", "", "approximateDayTimeMs", "", "lowerBoundDayTimeMs", "upperBoundDayTimeMs", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface c {
        /* renamed from: a, reason: from kotlin metadata */
        void onLineClicked(long approximateDayTimeMs, long lowerBoundDayTimeMs, long upperBoundDayTimeMs);
    }

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0082\u0008\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0008HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/util/customview/DogLogView$TagGraphics;", "", "center", "Landroid/graphics/PointF;", "hasBorder", "", "letterCenter", "style", "Lapp/dogo/com/dogo_android/util/customview/DogLogView$TagStyleGraphics;", "(Landroid/graphics/PointF;ZLandroid/graphics/PointF;Lapp/dogo/com/dogo_android/util/customview/DogLogView$TagStyleGraphics;)V", "getCenter", "()Landroid/graphics/PointF;", "getHasBorder", "()Z", "getLetterCenter", "getStyle", "()Lapp/dogo/com/dogo_android/util/customview/DogLogView$TagStyleGraphics;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class d {

        /* renamed from: a, reason: from kotlin metadata */
        private final PointF center;
        /* renamed from: b, reason: from kotlin metadata */
        private final boolean hasBorder;
        /* renamed from: c, reason: from kotlin metadata */
        private final PointF letterCenter;
        private final DogLogView.f d;
        public d(PointF pointF, boolean z, PointF pointF2, DogLogView.f fVar) {
            n.f(pointF, "center");
            n.f(pointF2, "letterCenter");
            n.f(fVar, "style");
            super();
            this.center = pointF;
            this.hasBorder = z;
            this.letterCenter = pointF2;
            this.d = fVar;
        }

        /* renamed from: a, reason: from kotlin metadata */
        /* operator */ public final PointF component1() {
            return this.center;
        }

        public final boolean b() {
            return this.hasBorder;
        }

        public final PointF c() {
            return this.letterCenter;
        }

        public final DogLogView.f d() {
            return this.d;
        }

        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z5 = false;
            if (!(other instanceof DogLogView_TagGraphics)) {
                return false;
            }
            if (!n.b(this.center, other.center)) {
                return false;
            }
            if (this.hasBorder != other.hasBorder) {
                return false;
            }
            if (!n.b(this.letterCenter, other.letterCenter)) {
                return false;
            }
            return !n.b(this.d, other.d) ? z5 : z;
        }

        public int hashCode() {
            boolean hasBorder2 = true;
            if (this.hasBorder) {
                int i10 = 1;
            }
            return (this.center.hashCode() * 31) + hasBorder2 * 31 + this.letterCenter.hashCode() * 31 + this.d.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "TagGraphics(center=";
            String str3 = ", hasBorder=";
            String str4 = ", letterCenter=";
            String str5 = ", style=";
            str = str2 + this.center + str3 + this.hasBorder + str4 + this.letterCenter + str5 + this.d + 41;
            return str;
        }
    }

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0010\u0008\u0082\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u0017", d2 = {"Lapp/dogo/com/dogo_android/util/customview/DogLogView$TagModel;", "", "linePosition", "", "styleId", "", "hasBorder", "", "(ILjava/lang/String;Z)V", "getHasBorder", "()Z", "getLinePosition", "()I", "getStyleId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class e {

        private final int a;
        private final String b;
        private final boolean c;
        public e(int i, String str, boolean z) {
            n.f(str, "styleId");
            super();
            this.a = i;
            this.b = str;
            this.c = z;
        }

        /* renamed from: a, reason: from kotlin metadata */
        /* operator */ public final boolean component1() {
            return this.c;
        }

        public final String b() {
            return this.b;
        }

        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z5 = false;
            if (!(other instanceof DogLogView_TagModel)) {
                return false;
            }
            if (this.a != other.a) {
                return false;
            }
            if (!n.b(this.b, other.b)) {
                return false;
            }
            return this.c != other.c ? z5 : z;
        }

        public int hashCode() {
            boolean z = true;
            if (this.c) {
                int i8 = 1;
            }
            return (Integer.hashCode(this.a) * 31) + this.b.hashCode() * 31 + z;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "TagModel(linePosition=";
            String str3 = ", styleId=";
            String str5 = ", hasBorder=";
            str = str2 + this.a + str3 + this.b + str5 + this.c + 41;
            return str;
        }
    }

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000c\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0082\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000b¨\u0006\u0018", d2 = {"Lapp/dogo/com/dogo_android/util/customview/DogLogView$TagStyleGraphics;", "", "tagColor", "Landroid/graphics/Paint;", "letter", "", "letterColor", "(Landroid/graphics/Paint;CLandroid/graphics/Paint;)V", "getLetter", "()C", "getLetterColor", "()Landroid/graphics/Paint;", "getTagColor", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class f {

        private final Paint a;
        private final char b;
        /* renamed from: c, reason: from kotlin metadata */
        private final Paint tagColor;
        public f(Paint paint, char c, Paint paint2) {
            n.f(paint, "tagColor");
            n.f(paint2, "letterColor");
            super();
            this.a = paint;
            this.b = c;
            this.tagColor = paint2;
        }

        /* renamed from: a, reason: from kotlin metadata */
        /* operator */ public final char component1() {
            return this.b;
        }

        public final Paint b() {
            return this.tagColor;
        }

        public final Paint c() {
            return this.a;
        }

        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z4 = false;
            if (!(other instanceof DogLogView_TagStyleGraphics)) {
                return false;
            }
            if (!n.b(this.a, other.a)) {
                return false;
            }
            if (this.b != other.b) {
                return false;
            }
            return !n.b(this.tagColor, other.tagColor) ? z4 : z;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + Character.hashCode(this.b) * 31 + this.tagColor.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "TagStyleGraphics(tagColor=";
            String str3 = ", letter=";
            String str4 = ", letterColor=";
            str = str2 + this.a + str3 + this.b + str4 + this.tagColor + 41;
            return str;
        }
    }
    static {
        DogLogView.O = TimeUnit.DAYS.toMillis(1L);
    }

    public DogLogView(Context context, AttributeSet set) throws android.content.res.Resources.NotFoundException {
        super(context, set);
        float dimension = getContext().getResources().getDimension(2131165284);
        this.tagGraphicsList = dimension;
        this.tagLineGapHeight = dimension;
        float f6 = 0.8f * dimension;
        this.tagLineStartYPosition = f6;
        float f = f6 / 8f;
        this.tagRadius = f;
        this.tagStyleGraphics = f6 - (1.5f * f);
        int i6 = 24 * 2;
        this.viewHeight = i6;
        this.viewWidth = DogLogView.O / (long)i6;
        this.cellCount = (int)(dimension * (float)(i6 + 1));
        this.cellLinePoints = (int)getContext().getResources().getDimension(2131165283);
        int i9 = 1;
        Paint paint = new Paint(i9);
        int i11 = -1;
        paint.setColor(i11);
        paint.setStrokeWidth(f);
        paint.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(i9);
        paint2.setColor(i11);
        paint2.setTextSize(f6 * 1.6f);
        paint2.setTypeface(Typeface.create(Typeface.DEFAULT, i9));
        new Paint().setColor(getResources().getColor(2131099855, null));
        Paint paint4 = new Paint(i9);
        paint4.setColor(-12303292);
        app.dogo.com.dogo_android.util.customview.DogLogView.f dogLogView_TagStyleGraphics = new DogLogView_TagStyleGraphics(paint4, '?', paint2);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        SparseArray sparseArray = new SparseArray(i6);
        this.ringRadius = p.g();
        this.ringStrokeWidth = p.g();
        init();
    }

    /* renamed from: a, reason: from kotlin metadata */
    private final void drawGrid(Canvas canvas) {
        canvas.drawLines(p.I0(this.ringStrokeWidth), this.gridPaint);
    }

    /* renamed from: b, reason: from kotlin metadata */
    private final void drawTag(Canvas canvas, DogLogView.d tagGraphics) {
        canvas.drawCircle(tagGraphics.component1().x, tagGraphics.component1().y, this.tagLineStartYPosition, tagGraphics.d().c());
        if (tagGraphics.b()) {
            canvas.drawCircle(tagGraphics.component1().x, tagGraphics.component1().y, this.tagStyleGraphics, this.defaultLetterPaint);
        }
        canvas.drawText(String.valueOf(tagGraphics.d().component1()), tagGraphics.c().x, tagGraphics.c().y, tagGraphics.d().b());
    }

    /* renamed from: c, reason: from kotlin metadata */
    private final void drawTags(Canvas canvas) {
        Iterator it = this.ringRadius.iterator();
        while (it.hasNext()) {
            drawTag(canvas, (DogLogView_TagGraphics)it.next());
        }
    }

    /* renamed from: d, reason: from kotlin metadata */
    private final char getCharOrDefault(int stringRes, char defaultChar) throws android.content.res.Resources.NotFoundException {
        char c;
        if (stringRes != 0) {
            String string = getResources().getString(stringRes);
            n.e(string, "resources.getString(stringRes)");
            c = l.c1(string);
        }
        return c;
    }

    /* renamed from: e, reason: from kotlin metadata */
    private final int getColorOrDefault(int colorRes, int defaultColorInt) throws android.content.res.Resources.NotFoundException {
        int color;
        if (colorRes != 0) {
            android.content.res.Resources.Theme theme = null;
            color = getResources().getColor(colorRes, theme);
        }
        return color;
    }

    /* renamed from: f, reason: from kotlin metadata */
    private final void init() {
        k();
    }

    /* renamed from: g, reason: from kotlin metadata */
    private final boolean isAClick(float startX, float endX, float startY, float endY) {
        boolean z = false;
        float abs = Math.abs(startX - endX);
        final float abs2 = Math.abs(startY - endY);
        float f3 = 200f;
        if (abs <= f3) {
            startX = abs2 <= f3 ? 1 : 0;
        }
        return (abs2 <= f3 ? 1 : 0);
    }

    /* renamed from: h, reason: from kotlin metadata */
    private final DogLogView.f onDraw(DogLogView.e canvas) {
        app.dogo.com.dogo_android.util.customview.DogLogView.f dogLogView_TagStyleGraphics;
        Object value = this.positionBucket.get(canvas.b());
        if (value != null) {
            int i = 1;
            Paint paint2 = new Paint(i);
            paint2.setColor(getColorOrDefault(value.getTagColorRes(), this.lineCount.c().getColor()));
            Paint paint = new Paint(i);
            paint.setColor(getColorOrDefault(value.getLetterColorRes(), this.lineCount.b().getColor()));
            paint.setTextSize(this.defaultStyleGraphics.getTextSize());
            paint.setTypeface(this.defaultStyleGraphics.getTypeface());
            dogLogView_TagStyleGraphics = new DogLogView_TagStyleGraphics(paint2, getCharOrDefault(value.getNameRes(), this.lineCount.component1()), paint);
        } else {
        }
        return dogLogView_TagStyleGraphics;
    }

    private final void i() {
        final ArrayList arrayList = new ArrayList();
        final int i2 = 0;
        Iterator it = g.l(i2, this.tagStyles).iterator();
        while (it.hasNext()) {
            int i5 = 2;
            float f5 = this.tagLineGapHeight + (float)(IntIterator)it.d() * this.tagGraphicsList * (float)i5;
            Float[] arr = new Float[4];
            arr[i2] = 0f;
            arr[1] = Float.valueOf(f5);
            arr[i5] = Float.valueOf((float)getWidth());
            int i = 3;
            arr[i] = Float.valueOf(f5);
            arrayList.addAll(p.j(arr));
        }
        this.ringStrokeWidth = arrayList;
    }

    private final void j() {
        final ArrayList arrayList = new ArrayList();
        int i = 0;
        Iterator it = g.l(i, this.viewHeight).iterator();
        while (it.hasNext()) {
            i2 = (this.tagStyles * 2) - 1 - (IntIterator)it.d();
            arrayList.addAll(onTouchEvent(i2));
        }
        this.ringRadius = arrayList;
    }

    private final void k() {
        int i = 0;
        measure(i, i);
        this.lineThresholdMs.clear();
        i();
        j();
    }

    /* renamed from: l, reason: from kotlin metadata */
    private final DogLogView.d onMeasure(DogLogView.e widthMeasureSpec, PointF heightMeasureSpec) {
        app.dogo.com.dogo_android.util.customview.DogLogView.f onDraw;
        if (!this.lineThresholdMs.containsKey(widthMeasureSpec.b())) {
            this.lineThresholdMs.put(widthMeasureSpec.b(), onDraw(widthMeasureSpec));
        } else {
            n.d(this.lineThresholdMs.get(widthMeasureSpec.b()));
        }
        Rect rect = new Rect();
        int i = 1;
        char[] cArr = new char[i];
        int i2 = 0;
        cArr[i2] = onDraw.component1();
        onDraw.b().getTextBounds(cArr, i2, i, rect);
        float f9 = (float)2;
        return new DogLogView_TagGraphics(heightMeasureSpec, widthMeasureSpec.component1(), new PointF(heightMeasureSpec.x - (float)rect.width() / f9, heightMeasureSpec.y + (float)rect.height() / f9), onDraw);
    }

    /* renamed from: m, reason: from kotlin metadata */
    private final List<DogLogView.d> onTouchEvent(int event) {
        Iterable iterable;
        int i;
        int i5 = 10;
        if ((List)this.ringPaint.get(event) == null) {
            List list = p.g();
        }
        final ArrayList arrayList2 = new ArrayList();
        float f3 = (this.tagGraphicsList * (float)event) + this.tagLineGapHeight;
        tagLineStartYPosition2 = (float)getWidth();
        int i2 = 2;
        i = 0;
        i = 1;
        int r3 = i;
        int r7 = i;
        int r8 = i;
        final int i9 = 0;
        i5 = 10;
        if (i != 0) {
            f = (float)getWidth() - this.tagLineStartYPosition - tagLineStartYPosition2;
            i2 = iterable.size() - i;
            ArrayList arrayList = new ArrayList(p.r(iterable, i5));
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                i = i + 1;
                if (i < 0) {
                    p.q();
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i9;
                }
            }
            arrayList2.addAll(arrayList);
        } else {
            if (i != 0) {
                ArrayList arrayList3 = new ArrayList(p.r(iterable, i5));
                it = iterable.iterator();
                while (it.hasNext()) {
                    i = i + 1;
                    if (i < 0) {
                        p.q();
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i9;
                    }
                }
                arrayList2.addAll(arrayList3);
            } else {
                if (i != 0) {
                    arrayList2.add(onMeasure((DogLogView_TagModel)p.X(iterable), new PointF(tagLineStartYPosition2 / (float)i2, f3)));
                }
            }
        }
        return arrayList2;
    }

    @Override // android.view.View
    public final DogLogView.c getTagClickListener() {
        return this.N;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        n.f(canvas, "canvas");
        super.onDraw(canvas);
        drawGrid(canvas);
        drawTags(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        k();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 1073741824;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.cellLinePoints, i3), View.MeasureSpec.makeMeasureSpec(this.cellCount, i3));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        n.f(motionEvent, "event");
        int action = motionEvent.getAction();
        final int i4 = 1;
        if (action != 0 && action != i4) {
            return super.onTouchEvent(motionEvent);
        }
        this.startX = motionEvent.getX();
        this.startY = motionEvent.getY();
        return true;
    }

    @Override // android.view.View
    public final void setOnClickEventListener(DogLogView.c listener) {
        this.N = listener;
    }

    @Override // android.view.View
    public final void setTagClickListener(DogLogView.c cVar) {
        this.N = cVar;
    }

    @Override // android.view.View
    public final void setTags(List<? extends DogLogView.a> tagModels) {
        ArrayList arrayList2;
        boolean hasNext2;
        int i = 1;
        String str;
        long viewWidth2;
        n.f(tagModels, "tagModels");
        this.ringPaint.clear();
        i = 0;
        Iterator it = new IntRange(i, this.viewHeight).iterator();
        while (it.hasNext()) {
            int viewHeight2 = (IntIterator)it.d();
            arrayList2 = new ArrayList();
            Iterator it3 = tagModels.iterator();
            i = 1;
            while (it3.hasNext()) {
                Object item2 = it3.next();
            }
            item2 = it3.next();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it4 = tagModels.iterator();
        while (it4.hasNext()) {
            Object item = it4.next();
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            Object item3 = it5.next();
            this.positionBucket.put(item3.b().getId(), item3.b());
        }
        k();
        invalidate();
    }
}
