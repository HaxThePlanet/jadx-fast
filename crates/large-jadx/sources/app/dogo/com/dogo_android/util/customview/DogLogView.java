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
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.e0.a;
import kotlin.h0.f;
import kotlin.h0.g;
import kotlin.k0.l;
import kotlin.w;
import kotlin.y.h0;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000c\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\u0018\u0000 a2\u00020\u0001:\u0006`abcdeB\u0011\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0002J\u0018\u00105\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00106\u001a\u00020&H\u0002J\u0010\u00107\u001a\u0002022\u0006\u00103\u001a\u000204H\u0002J\u001a\u00108\u001a\u0002092\u0008\u0008\u0001\u0010:\u001a\u00020\t2\u0006\u0010;\u001a\u000209H\u0002J\u001c\u0010<\u001a\u00020\t2\u0008\u0008\u0001\u0010=\u001a\u00020\t2\u0008\u0008\u0001\u0010>\u001a\u00020\tH\u0003J\u0008\u0010?\u001a\u000202H\u0002J(\u0010@\u001a\u00020A2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010C\u001a\u00020\u000eH\u0002J\u0010\u0010D\u001a\u0002022\u0006\u00103\u001a\u000204H\u0014J0\u0010E\u001a\u0002022\u0006\u0010F\u001a\u00020A2\u0006\u0010G\u001a\u00020\t2\u0006\u0010H\u001a\u00020\t2\u0006\u0010I\u001a\u00020\t2\u0006\u0010J\u001a\u00020\tH\u0014J\u0018\u0010K\u001a\u0002022\u0006\u0010L\u001a\u00020\t2\u0006\u0010M\u001a\u00020\tH\u0014J\u0010\u0010N\u001a\u00020A2\u0006\u0010O\u001a\u00020PH\u0016J\u0010\u0010Q\u001a\u00020\u00122\u0006\u0010R\u001a\u00020\u0019H\u0002J\u0008\u0010S\u001a\u000202H\u0002J\u0008\u0010T\u001a\u000202H\u0002J\u0010\u0010U\u001a\u0002022\u0008\u0010V\u001a\u0004\u0018\u00010 J\u0014\u0010W\u001a\u0002022\u000c\u0010X\u001a\u0008\u0012\u0004\u0012\u00020Y0\rJ\u0008\u0010Z\u001a\u000202H\u0002J\u0018\u0010[\u001a\u00020&2\u0006\u0010R\u001a\u00020\u00192\u0006\u0010\\\u001a\u00020]H\u0002J\u0016\u0010^\u001a\u0008\u0012\u0004\u0012\u00020&0\r2\u0006\u0010_\u001a\u00020\tH\u0002R\u000e\u0010\u000b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00190\r0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008!\u0010\"\"\u0004\u0008#\u0010$R\u0014\u0010%\u001a\u0008\u0012\u0004\u0012\u00020&0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00120+X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020.0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006f", d2 = {"Lapp/dogo/com/dogo_android/util/customview/DogLogView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cellCount", "cellLinePoints", "", "", "defaultLetterPaint", "Landroid/graphics/Paint;", "defaultStyleGraphics", "Lapp/dogo/com/dogo_android/util/customview/DogLogView$TagStyleGraphics;", "gridPaint", "lineCount", "lineThresholdMs", "", "positionBucket", "Landroid/util/SparseArray;", "Lapp/dogo/com/dogo_android/util/customview/DogLogView$TagModel;", "ringPaint", "ringRadius", "ringStrokeWidth", "startX", "startY", "tagClickListener", "Lapp/dogo/com/dogo_android/util/customview/DogLogView$OnClickEventListener;", "getTagClickListener", "()Lapp/dogo/com/dogo_android/util/customview/DogLogView$OnClickEventListener;", "setTagClickListener", "(Lapp/dogo/com/dogo_android/util/customview/DogLogView$OnClickEventListener;)V", "tagGraphicsList", "Lapp/dogo/com/dogo_android/util/customview/DogLogView$TagGraphics;", "tagLineGapHeight", "tagLineStartYPosition", "tagRadius", "tagStyleGraphics", "", "", "tagStyles", "Lapp/dogo/com/dogo_android/util/customview/DogLogView$CalendarTag$TagStyles;", "viewHeight", "viewWidth", "drawGrid", "", "canvas", "Landroid/graphics/Canvas;", "drawTag", "tagGraphics", "drawTags", "getCharOrDefault", "", "stringRes", "defaultChar", "getColorOrDefault", "colorRes", "defaultColorInt", "init", "isAClick", "", "endX", "endY", "onDraw", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "parseTagStyleGraphics", "tagModel", "prepareGridGraphics", "prepareTagGraphics", "setOnClickEventListener", "listener", "setTags", "tagModels", "Lapp/dogo/com/dogo_android/util/customview/DogLogView$CalendarTag;", "setupGraphics", "setupTagGraphics", "center", "Landroid/graphics/PointF;", "setupTagLineGraphics", "tagLinePosition", "CalendarTag", "Companion", "OnClickEventListener", "TagGraphics", "TagModel", "TagStyleGraphics", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DogLogView extends View {

    public static final app.dogo.com.dogo_android.util.customview.DogLogView.b Companion;
    private static final long O;
    private final int A;
    private final int B;
    private final Paint C;
    private final Paint D;
    private final Paint E;
    private final app.dogo.com.dogo_android.util.customview.DogLogView.f F;
    private final Map<String, app.dogo.com.dogo_android.util.customview.DogLogView.f> G;
    private final Map<String, app.dogo.com.dogo_android.util.customview.DogLogView.a.b> H;
    private final SparseArray<List<app.dogo.com.dogo_android.util.customview.DogLogView.e>> I;
    private List<app.dogo.com.dogo_android.util.customview.DogLogView.d> J;
    private List<Float> K;
    private float L;
    private float M;
    private app.dogo.com.dogo_android.util.customview.DogLogView.c N;
    private final float a;
    private final float b;
    private final float c = 0.8f;
    private final float v = 8f;
    private final float w = 1.5f;
    private final int x = 24;
    private final int y = 24;
    private final long z;

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0017\u0018\u00002\u00020\u0001:\u0001\u0016B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u0017", d2 = {"Lapp/dogo/com/dogo_android/util/customview/DogLogView$CalendarTag;", "Landroid/os/Parcelable;", "timeOfDayMs", "", "hasBorder", "", "style", "Lapp/dogo/com/dogo_android/util/customview/DogLogView$CalendarTag$TagStyles;", "(JZLapp/dogo/com/dogo_android/util/customview/DogLogView$CalendarTag$TagStyles;)V", "getHasBorder", "()Z", "getStyle", "()Lapp/dogo/com/dogo_android/util/customview/DogLogView$CalendarTag$TagStyles;", "getTimeOfDayMs", "()J", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "TagStyles", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class a implements Parcelable {

        public static final Parcelable.Creator<app.dogo.com.dogo_android.util.customview.DogLogView.a> CREATOR;
        private final long a;
        private final boolean b;
        private final app.dogo.com.dogo_android.util.customview.DogLogView.a.b c;
        static {
            DogLogView.a.a aVar = new DogLogView.a.a();
            DogLogView.a.CREATOR = aVar;
        }

        public a(long l, boolean z2, app.dogo.com.dogo_android.util.customview.DogLogView.a.b dogLogView$a$b3) {
            n.f(obj5, "style");
            super();
            this.a = l;
            this.b = b3;
            this.c = obj5;
        }

        @Override // android.os.Parcelable
        public boolean a() {
            return this.b;
        }

        @Override // android.os.Parcelable
        public app.dogo.com.dogo_android.util.customview.DogLogView.a.b b() {
            return this.c;
        }

        @Override // android.os.Parcelable
        public long c() {
            return this.a;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeLong(this.a);
            parcel.writeInt(this.b);
            parcel.writeParcelable(this.c, i2);
        }
    }

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/util/customview/DogLogView$Companion;", "", "()V", "CLICK_ACTION_POSITION_DIFFERENCE_THRESHOLD", "", "MS_IN_DAY", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b {
        public b(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/util/customview/DogLogView$OnClickEventListener;", "", "onLineClicked", "", "approximateDayTimeMs", "", "lowerBoundDayTimeMs", "upperBoundDayTimeMs", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface c {
        public abstract void a(long l, long l2, long l3);
    }

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0082\u0008\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0008HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/util/customview/DogLogView$TagGraphics;", "", "center", "Landroid/graphics/PointF;", "hasBorder", "", "letterCenter", "style", "Lapp/dogo/com/dogo_android/util/customview/DogLogView$TagStyleGraphics;", "(Landroid/graphics/PointF;ZLandroid/graphics/PointF;Lapp/dogo/com/dogo_android/util/customview/DogLogView$TagStyleGraphics;)V", "getCenter", "()Landroid/graphics/PointF;", "getHasBorder", "()Z", "getLetterCenter", "getStyle", "()Lapp/dogo/com/dogo_android/util/customview/DogLogView$TagStyleGraphics;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class d {

        private final PointF a;
        private final boolean b;
        private final PointF c;
        private final app.dogo.com.dogo_android.util.customview.DogLogView.f d;
        public d(PointF pointF, boolean z2, PointF pointF3, app.dogo.com.dogo_android.util.customview.DogLogView.f dogLogView$f4) {
            n.f(pointF, "center");
            n.f(pointF3, "letterCenter");
            n.f(f4, "style");
            super();
            this.a = pointF;
            this.b = z2;
            this.c = pointF3;
            this.d = f4;
        }

        public final PointF a() {
            return this.a;
        }

        public final boolean b() {
            return this.b;
        }

        public final PointF c() {
            return this.c;
        }

        public final app.dogo.com.dogo_android.util.customview.DogLogView.f d() {
            return this.d;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof DogLogView.d) {
                return i2;
            }
            if (!n.b(this.a, object.a)) {
                return i2;
            }
            if (this.b != object.b) {
                return i2;
            }
            if (!n.b(this.c, object.c)) {
                return i2;
            }
            if (!n.b(this.d, object.d)) {
                return i2;
            }
            return i;
        }

        public int hashCode() {
            boolean z;
            if (this.b) {
                z = 1;
            }
            return i6 += i9;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TagGraphics(center=");
            stringBuilder.append(this.a);
            stringBuilder.append(", hasBorder=");
            stringBuilder.append(this.b);
            stringBuilder.append(", letterCenter=");
            stringBuilder.append(this.c);
            stringBuilder.append(", style=");
            stringBuilder.append(this.d);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0010\u0008\u0082\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u0017", d2 = {"Lapp/dogo/com/dogo_android/util/customview/DogLogView$TagModel;", "", "linePosition", "", "styleId", "", "hasBorder", "", "(ILjava/lang/String;Z)V", "getHasBorder", "()Z", "getLinePosition", "()I", "getStyleId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class e {

        private final int a;
        private final String b;
        private final boolean c;
        public e(int i, String string2, boolean z3) {
            n.f(string2, "styleId");
            super();
            this.a = i;
            this.b = string2;
            this.c = z3;
        }

        public final boolean a() {
            return this.c;
        }

        public final String b() {
            return this.b;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i3 = 0;
            if (!object instanceof DogLogView.e) {
                return i3;
            }
            if (this.a != object.a) {
                return i3;
            }
            if (!n.b(this.b, object.b)) {
                return i3;
            }
            if (this.c != object.c) {
                return i3;
            }
            return i;
        }

        public int hashCode() {
            boolean z;
            if (this.c) {
                z = 1;
            }
            return i5 += z;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TagModel(linePosition=");
            stringBuilder.append(this.a);
            stringBuilder.append(", styleId=");
            stringBuilder.append(this.b);
            stringBuilder.append(", hasBorder=");
            stringBuilder.append(this.c);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000c\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0082\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000b¨\u0006\u0018", d2 = {"Lapp/dogo/com/dogo_android/util/customview/DogLogView$TagStyleGraphics;", "", "tagColor", "Landroid/graphics/Paint;", "letter", "", "letterColor", "(Landroid/graphics/Paint;CLandroid/graphics/Paint;)V", "getLetter", "()C", "getLetterColor", "()Landroid/graphics/Paint;", "getTagColor", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class f {

        private final Paint a;
        private final char b;
        private final Paint c;
        public f(Paint paint, char c2, Paint paint3) {
            n.f(paint, "tagColor");
            n.f(paint3, "letterColor");
            super();
            this.a = paint;
            this.b = c2;
            this.c = paint3;
        }

        public final char a() {
            return this.b;
        }

        public final Paint b() {
            return this.c;
        }

        public final Paint c() {
            return this.a;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof DogLogView.f) {
                return i2;
            }
            if (!n.b(this.a, object.a)) {
                return i2;
            }
            if (this.b != object.b) {
                return i2;
            }
            if (!n.b(this.c, object.c)) {
                return i2;
            }
            return i;
        }

        public int hashCode() {
            return i4 += i7;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TagStyleGraphics(tagColor=");
            stringBuilder.append(this.a);
            stringBuilder.append(", letter=");
            stringBuilder.append(this.b);
            stringBuilder.append(", letterColor=");
            stringBuilder.append(this.c);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }
    static {
        DogLogView.b bVar = new DogLogView.b(0);
        DogLogView.Companion = bVar;
        DogLogView.O = TimeUnit.DAYS.toMillis(1);
    }

    public DogLogView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        float obj7 = getContext().getResources().getDimension(2131165284);
        this.a = obj7;
        this.b = obj7;
        obj8 *= obj7;
        int i2 = obj8 / i;
        int i7 = obj8 - i6;
        i8 *= 2;
        this.z = l /= l2;
        this.A = (int)obj7;
        this.B = (int)obj7;
        int i13 = 1;
        obj7 = new Paint(i13);
        int i15 = -1;
        obj7.setColor(i15);
        obj7.setStrokeWidth(i2);
        obj7.setStyle(Paint.Style.STROKE);
        w wVar = w.a;
        this.C = obj7;
        obj7 = new Paint(i13);
        obj7.setColor(i15);
        obj7.setTextSize(obj8 *= i3);
        obj7.setTypeface(Typeface.create(Typeface.DEFAULT, i13));
        this.D = obj7;
        Paint obj8 = new Paint();
        obj8.setColor(getResources().getColor(2131099855, 0));
        this.E = obj8;
        obj8 = new Paint(i13);
        obj8.setColor(-12303292);
        DogLogView.f fVar = new DogLogView.f(obj8, 63, obj7);
        this.F = fVar;
        obj7 = new LinkedHashMap();
        this.G = obj7;
        obj7 = new LinkedHashMap();
        this.H = obj7;
        obj7 = new SparseArray(i9);
        this.I = obj7;
        this.J = p.g();
        this.K = p.g();
        f();
    }

    private final void a(Canvas canvas) {
        canvas.drawLines(p.I0(this.K), this.E);
    }

    private final void b(Canvas canvas, app.dogo.com.dogo_android.util.customview.DogLogView.d dogLogView$d2) {
        boolean z;
        float f;
        float f2;
        Paint paint;
        canvas.drawCircle(pointF.x, pointF3.y, this.c, d2.d().c());
        if (d2.b()) {
            canvas.drawCircle(pointF2.x, pointF5.y, this.w, this.C);
        }
        canvas.drawText(String.valueOf(d2.d().a()), pointF4.x, pointF6.y, d2.d().b());
    }

    private final void c(Canvas canvas) {
        Object next;
        Iterator iterator = this.J.iterator();
        for (DogLogView.d next : iterator) {
            b(canvas, next);
        }
    }

    private final char d(int i, char c2) {
        int obj1;
        char obj2;
        if (i != 0) {
            obj1 = getResources().getString(i);
            n.e(obj1, "resources.getString(stringRes)");
            obj2 = l.c1(obj1);
        }
        return obj2;
    }

    private final int e(int i, int i2) {
        int i3;
        int obj3;
        if (i != 0) {
            obj3 = getResources().getColor(i, 0);
        }
        return obj3;
    }

    private final void f() {
        k();
    }

    private final boolean g(float f, float f2, float f3, float f4) {
        int obj1;
        int obj3 = 1128792064;
        if (Float.compare(obj1, obj3) <= 0 && Float.compare(obj2, obj3) <= 0) {
            obj1 = Float.compare(obj2, obj3) <= 0 ? 1 : 0;
        } else {
        }
        return obj1;
    }

    private final app.dogo.com.dogo_android.util.customview.DogLogView.f h(app.dogo.com.dogo_android.util.customview.DogLogView.e dogLogView$e) {
        Object paint;
        app.dogo.com.dogo_android.util.customview.DogLogView.f fVar;
        Paint paint2;
        int i;
        char obj5;
        obj5 = this.H.get(e.b());
        if ((DogLogView.a.b)obj5 != null) {
            i = 1;
            paint2 = new Paint(i);
            paint2.setColor(e((DogLogView.a.b)obj5.getTagColorRes(), this.F.c().getColor()));
            paint = new Paint(i);
            paint.setColor(e(obj5.getLetterColorRes(), this.F.b().getColor()));
            paint.setTextSize(this.D.getTextSize());
            paint.setTypeface(this.D.getTypeface());
            fVar = new DogLogView.f(paint2, d(obj5.getNameRes(), this.F.a()), paint);
        } else {
            fVar = this.F;
        }
        return fVar;
    }

    private final void i() {
        List list;
        Float valueOf2;
        int i;
        Float valueOf3;
        Float valueOf;
        ArrayList arrayList = new ArrayList();
        final int i3 = 0;
        Iterator iterator = g.l(i3, this.x).iterator();
        while (iterator.hasNext()) {
            int i9 = 2;
            f3 += i6;
            Float[] arr = new Float[4];
            arr[i3] = 0f;
            arr[1] = Float.valueOf(i8);
            arr[i9] = Float.valueOf((float)width);
            arr[3] = Float.valueOf(i8);
            arrayList.addAll(p.j(arr));
        }
        this.K = arrayList;
    }

    private final void j() {
        int i;
        int i2;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = g.l(0, this.y).iterator();
        while (iterator.hasNext()) {
            arrayList.addAll(m(i7 -= i4));
        }
        this.J = arrayList;
    }

    private final void k() {
        int i = 0;
        measure(i, i);
        this.G.clear();
        i();
        j();
    }

    private final app.dogo.com.dogo_android.util.customview.DogLogView.d l(app.dogo.com.dogo_android.util.customview.DogLogView.e dogLogView$e, PointF pointF2) {
        Object obj;
        Object obj2;
        String str;
        if (!this.G.containsKey(e.b())) {
            this.G.put(e.b(), h(e));
        } else {
            n.d(this.G.get(e.b()));
        }
        Rect rect = new Rect();
        int i4 = 1;
        char[] cArr = new char[i4];
        int i6 = 0;
        cArr[i6] = obj.a();
        obj.b().getTextBounds(cArr, i6, i4, rect);
        float f5 = (float)i7;
        PointF pointF = new PointF(f4 -= i, f2 += i3);
        DogLogView.d dVar = new DogLogView.d(pointF2, e.a(), pointF, obj);
        return dVar;
    }

    private final List<app.dogo.com.dogo_android.util.customview.DogLogView.d> m(int i) {
        Object iterator;
        int arrayList2;
        int i3;
        int next2;
        int i2;
        ArrayList arrayList;
        int next;
        int next3;
        int i4;
        int pointF;
        float obj12;
        if ((List)this.I.get(i) == null) {
            iterator = p.g();
        }
        ArrayList arrayList3 = new ArrayList();
        i5 += obj12;
        obj12 = (float)obj12;
        next2 = 2;
        i2 = 0;
        arrayList = 1;
        arrayList2 = iterator.size() > next2 ? arrayList : i2;
        next = iterator.size() == next2 ? arrayList : i2;
        i4 = iterator.size() == arrayList ? arrayList : i2;
        final int i15 = 0;
        pointF = 10;
        if (arrayList2 != null) {
            obj12 = this.c;
            arrayList = new ArrayList(p.r(iterator, pointF));
            iterator = iterator.iterator();
            for (Object next3 : iterator) {
                pointF = new PointF(i9 += obj12, i6);
                arrayList.add(l((DogLogView.e)next3, pointF));
                i2 = i4;
            }
            arrayList3.addAll(arrayList);
        } else {
            if (next != 0) {
                arrayList2 = new ArrayList(p.r(iterator, pointF));
                iterator = iterator.iterator();
                for (Object next4 : iterator) {
                    PointF pointF2 = new PointF(i14 *= f6, i6);
                    arrayList2.add(l((DogLogView.e)next4, pointF2));
                    i2 = next;
                }
                arrayList3.addAll(arrayList2);
            } else {
                if (i4 != 0) {
                    arrayList2 = new PointF(obj12 /= f3, i6);
                    arrayList3.add(l((DogLogView.e)p.X(iterator), arrayList2));
                }
            }
        }
        return arrayList3;
    }

    @Override // android.view.View
    public final app.dogo.com.dogo_android.util.customview.DogLogView.c getTagClickListener() {
        return this.N;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        n.f(canvas, "canvas");
        super.onDraw(canvas);
        a(canvas);
        c(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        k();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int obj3 = 1073741824;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.B, obj3), View.MeasureSpec.makeMeasureSpec(this.A, obj3));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean action;
        float f3;
        float f;
        float f2;
        app.dogo.com.dogo_android.util.customview.DogLogView.c view;
        int i;
        int i2;
        int i3;
        n.f(motionEvent, "event");
        action = motionEvent.getAction();
        final int i9 = 1;
        if (action != 0) {
            if (action != i9) {
            } else {
                if (g(this.L, motionEvent.getX(), this.M, motionEvent.getY())) {
                    float f7 = this.a;
                    int i7 = g.b(a.b(i4 /= f7), 0);
                    f3 = this.z;
                    view = this.N;
                    if (view == null) {
                    } else {
                        view.a(f3 * l, obj8, f3 * f2);
                    }
                }
            }
            return super.onTouchEvent(motionEvent);
        }
        this.L = motionEvent.getX();
        this.M = motionEvent.getY();
        return i9;
    }

    @Override // android.view.View
    public final void setOnClickEventListener(app.dogo.com.dogo_android.util.customview.DogLogView.c dogLogView$c) {
        this.N = c;
    }

    @Override // android.view.View
    public final void setTagClickListener(app.dogo.com.dogo_android.util.customview.DogLogView.c dogLogView$c) {
        this.N = c;
    }

    public final void setTags(List<? extends app.dogo.com.dogo_android.util.customview.DogLogView.a> list) {
        HashSet hashSet;
        int i;
        ArrayList arrayList;
        int next2;
        boolean next;
        Object arrayList3;
        int arrayList2;
        boolean next3;
        int i2;
        int eVar;
        int i3;
        long l;
        n.f(list, "tagModels");
        this.I.clear();
        next2 = 0;
        f fVar = new f(next2, this.y);
        Iterator iterator = fVar.iterator();
        while (iterator.hasNext()) {
            i = (h0)iterator.d();
            arrayList3 = new ArrayList();
            Iterator iterator3 = list.iterator();
            while (iterator3.hasNext()) {
                next3 = iterator3.next();
                if ((int)i6 == i) {
                } else {
                }
                eVar = next2;
                if (eVar != 0) {
                }
                arrayList3.add(next3);
            }
            if (empty ^= eVar != 0) {
            }
            arrayList2 = new ArrayList(p.r(arrayList3, 10));
            Iterator iterator2 = arrayList3.iterator();
            for (DogLogView.a next7 : iterator2) {
                eVar = new DogLogView.e(i, next7.b().getId(), next7.a());
                arrayList2.add(eVar);
            }
            this.I.put(i, arrayList2);
            Object next7 = iterator2.next();
            eVar = new DogLogView.e(i, (DogLogView.a)next7.b().getId(), next7.a());
            arrayList2.add(eVar);
            next3 = iterator3.next();
            if ((int)i6 == i) {
            } else {
            }
            eVar = next2;
            if (eVar != 0) {
            }
            arrayList3.add(next3);
        }
        hashSet = new HashSet();
        arrayList = new ArrayList();
        Iterator obj12 = list.iterator();
        while (obj12.hasNext()) {
            next2 = obj12.next();
            if (hashSet.add((DogLogView.a)next2.b().getId())) {
            }
            arrayList.add(next2);
        }
        obj12 = arrayList.iterator();
        for (DogLogView.a next5 : obj12) {
            this.H.put(next5.b().getId(), next5.b());
        }
        k();
        invalidate();
    }
}
