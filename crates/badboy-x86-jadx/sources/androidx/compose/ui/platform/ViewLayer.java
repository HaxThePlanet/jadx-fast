package androidx.compose.ui.platform;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.CompositingStrategy.Companion;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOrigin.Companion;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.GraphicLayerInfo;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u0000 n2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002noB]\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00128\u0010\u0008\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\u000c\u0008\u000b\u0012\u0008\u0008\u000c\u0012\u0004\u0008\u0008(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\u000c\u0008\u000b\u0012\u0008\u0008\u000c\u0012\u0004\u0008\u0008(\u000f\u0012\u0004\u0012\u00020\u00100\t\u0012\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\u0002\u0010\u0013J\u0008\u0010>\u001a\u00020\u0010H\u0016J\u0010\u0010?\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020@H\u0014J\u001a\u0010A\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\n2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0008\u0010B\u001a\u00020\u0010H\u0016J\u0008\u0010C\u001a\u00020 H\u0016J\u0008\u0010D\u001a\u00020\u0010H\u0016J\u001a\u0010E\u001a\u00020\u00102\u0006\u0010F\u001a\u00020GH\u0016ø\u0001\u0000¢\u0006\u0004\u0008H\u0010IJ\u001a\u0010J\u001a\u00020 2\u0006\u0010K\u001a\u00020LH\u0016ø\u0001\u0000¢\u0006\u0004\u0008M\u0010NJ\u0018\u0010O\u001a\u00020\u00102\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020 H\u0016J\"\u0010S\u001a\u00020L2\u0006\u0010T\u001a\u00020L2\u0006\u0010R\u001a\u00020 H\u0016ø\u0001\u0000¢\u0006\u0004\u0008U\u0010VJ\u001a\u0010W\u001a\u00020\u00102\u0006\u0010K\u001a\u00020XH\u0016ø\u0001\u0000¢\u0006\u0004\u0008Y\u0010ZJ0\u0010[\u001a\u00020\u00102\u0006\u0010\\\u001a\u00020 2\u0006\u0010]\u001a\u0002072\u0006\u0010^\u001a\u0002072\u0006\u0010_\u001a\u0002072\u0006\u0010`\u001a\u000207H\u0014J\u0008\u0010a\u001a\u00020\u0010H\u0002J\u001a\u0010b\u001a\u00020\u00102\u0006\u0010c\u001a\u00020dH\u0016ø\u0001\u0000¢\u0006\u0004\u0008e\u0010ZJP\u0010f\u001a\u00020\u001028\u0010\u0008\u001a4\u0012\u0013\u0012\u00110\n¢\u0006\u000c\u0008\u000b\u0012\u0008\u0008\u000c\u0012\u0004\u0008\u0008(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\u000c\u0008\u000b\u0012\u0008\u0008\u000c\u0012\u0004\u0008\u0008(\u000f\u0012\u0004\u0012\u00020\u00100\t2\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u0012H\u0016J\u001a\u0010g\u001a\u00020\u00102\u0006\u0010F\u001a\u00020GH\u0016ø\u0001\u0000¢\u0006\u0004\u0008h\u0010IJ\u0008\u0010i\u001a\u00020\u0010H\u0016J\u0010\u0010j\u001a\u00020\u00102\u0006\u0010k\u001a\u00020lH\u0016J\u0008\u0010m\u001a\u00020\u0010H\u0002R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"RB\u0010\u0008\u001a6\u0012\u0013\u0012\u00110\n¢\u0006\u000c\u0008\u000b\u0012\u0008\u0008\u000c\u0012\u0004\u0008\u0008(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\u000c\u0008\u000b\u0012\u0008\u0008\u000c\u0012\u0004\u0008\u0008(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010$\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020 @BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008$\u0010%\"\u0004\u0008&\u0010'R\u0014\u0010(\u001a\u00020)X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010+R\u000e\u0010,\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010-\u001a\u00020.X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010/R\u0016\u00100\u001a\u0004\u0018\u0001018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u00082\u00103R\u0014\u00104\u001a\u0008\u0012\u0004\u0012\u00020\u000105X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008:\u0010;R\u0014\u0010<\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008=\u0010+\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006p", d2 = {"Landroidx/compose/ui/platform/ViewLayer;", "Landroid/view/View;", "Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/layout/GraphicLayerInfo;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "container", "Landroidx/compose/ui/platform/DrawChildContainer;", "drawBlock", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/Canvas;", "Lkotlin/ParameterName;", "name", "canvas", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "parentLayer", "", "invalidateParentLayer", "Lkotlin/Function0;", "(Landroidx/compose/ui/platform/AndroidComposeView;Landroidx/compose/ui/platform/DrawChildContainer;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "value", "", "cameraDistancePx", "getCameraDistancePx", "()F", "setCameraDistancePx", "(F)V", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "clipBoundsCache", "Landroid/graphics/Rect;", "clipToBounds", "", "getContainer", "()Landroidx/compose/ui/platform/DrawChildContainer;", "drawnWithZ", "isInvalidated", "()Z", "setInvalidated", "(Z)V", "layerId", "", "getLayerId", "()J", "mHasOverlappingRendering", "mTransformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "J", "manualClipPath", "Landroidx/compose/ui/graphics/Path;", "getManualClipPath", "()Landroidx/compose/ui/graphics/Path;", "matrixCache", "Landroidx/compose/ui/platform/LayerMatrixCache;", "mutatedFields", "", "outlineResolver", "Landroidx/compose/ui/platform/OutlineResolver;", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "ownerViewId", "getOwnerViewId", "destroy", "dispatchDraw", "Landroid/graphics/Canvas;", "drawLayer", "forceLayout", "hasOverlappingRendering", "invalidate", "inverseTransform", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "inverseTransform-58bKbWc", "([F)V", "isInLayer", "position", "Landroidx/compose/ui/geometry/Offset;", "isInLayer-k-4lQ0M", "(J)Z", "mapBounds", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "inverse", "mapOffset", "point", "mapOffset-8S9VItk", "(JZ)J", "move", "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "(J)V", "onLayout", "changed", "l", "t", "r", "b", "resetClipBounds", "resize", "size", "Landroidx/compose/ui/unit/IntSize;", "resize-ozmzZPI", "reuseLayer", "transform", "transform-58bKbWc", "updateDisplayList", "updateLayerProperties", "scope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "updateOutlineResolver", "Companion", "UniqueDrawingIdApi29", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ViewLayer extends View implements OwnedLayer, GraphicLayerInfo {

    public static final int $stable = 8;
    public static final androidx.compose.ui.platform.ViewLayer.Companion Companion;
    private static final ViewOutlineProvider OutlineProvider;
    private static final Function2<View, Matrix, Unit> getMatrix = 8;
    private static boolean hasRetrievedMethod;
    private static Field recreateDisplayList;
    private static boolean shouldUseDispatchDraw;
    private static Method updateDisplayListIfDirtyMethod;
    private final CanvasHolder canvasHolder;
    private Rect clipBoundsCache;
    private boolean clipToBounds;
    private final androidx.compose.ui.platform.DrawChildContainer container;
    private Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock;
    private boolean drawnWithZ;
    private Function0<Unit> invalidateParentLayer;
    private boolean isInvalidated;
    private final long layerId;
    private boolean mHasOverlappingRendering = true;
    private long mTransformOrigin;
    private final androidx.compose.ui.platform.LayerMatrixCache<View> matrixCache;
    private int mutatedFields;
    private final androidx.compose.ui.platform.OutlineResolver outlineResolver;
    private final androidx.compose.ui.platform.AndroidComposeView ownerView;

    @Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\tH\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000c\u001a\u00020\r@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000c\u001a\u00020\r@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0014\u0010\u0010\"\u0004\u0008\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b", d2 = {"Landroidx/compose/ui/platform/ViewLayer$Companion;", "", "()V", "OutlineProvider", "Landroid/view/ViewOutlineProvider;", "getOutlineProvider", "()Landroid/view/ViewOutlineProvider;", "getMatrix", "Lkotlin/Function2;", "Landroid/view/View;", "Landroid/graphics/Matrix;", "", "<set-?>", "", "hasRetrievedMethod", "getHasRetrievedMethod", "()Z", "recreateDisplayList", "Ljava/lang/reflect/Field;", "shouldUseDispatchDraw", "getShouldUseDispatchDraw", "setShouldUseDispatchDraw$ui_release", "(Z)V", "updateDisplayListIfDirtyMethod", "Ljava/lang/reflect/Method;", "updateDisplayList", "view", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final boolean getHasRetrievedMethod() {
            return ViewLayer.access$getHasRetrievedMethod$cp();
        }

        public final ViewOutlineProvider getOutlineProvider() {
            return ViewLayer.access$getOutlineProvider$cp();
        }

        public final boolean getShouldUseDispatchDraw() {
            return ViewLayer.access$getShouldUseDispatchDraw$cp();
        }

        public final void setShouldUseDispatchDraw$ui_release(boolean <set-?>) {
            ViewLayer.access$setShouldUseDispatchDraw$cp(<set-?>);
        }

        public final void updateDisplayList(View view) {
            boolean hasRetrievedMethod;
            Method method;
            int arr2;
            Method declaredMethod;
            Object invoke;
            Object[] arr;
            Class<String> obj;
            final int i = 1;
            arr2 = 0;
            if (!getHasRetrievedMethod()) {
                ViewLayer.access$setHasRetrievedMethod$cp(i);
                Class[] arr3 = new Class[2];
                arr3[arr2] = String.class;
                arr3[i] = new Class[arr2].getClass();
                int i3 = 0;
                ViewLayer.access$setUpdateDisplayListIfDirtyMethod$cp((Method)Class.class.getDeclaredMethod("getDeclaredMethod", arr3).invoke(View.class, /* result */));
                Class[] arr6 = new Class[i];
                arr6[arr2] = String.class;
                ViewLayer.access$setRecreateDisplayList$cp((Field)Class.class.getDeclaredMethod("getDeclaredField", arr6).invoke(View.class, /* result */));
                Method method2 = ViewLayer.access$getUpdateDisplayListIfDirtyMethod$cp();
                if (method2 == null) {
                    try {
                        method2.setAccessible(i);
                        hasRetrievedMethod = ViewLayer.access$getRecreateDisplayList$cp();
                        if (hasRetrievedMethod == null) {
                        } else {
                        }
                        hasRetrievedMethod.setAccessible(i);
                        Field field = ViewLayer.access$getRecreateDisplayList$cp();
                        if (field != null) {
                        }
                        field.setBoolean(view, i);
                        method = ViewLayer.access$getUpdateDisplayListIfDirtyMethod$cp();
                        if (method != null) {
                        }
                        method.invoke(view, new Object[arr2]);
                        setShouldUseDispatchDraw$ui_release(obj0);
                    }
                } else {
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007", d2 = {"Landroidx/compose/ui/platform/ViewLayer$UniqueDrawingIdApi29;", "", "()V", "getUniqueDrawingId", "", "view", "Landroid/view/View;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class UniqueDrawingIdApi29 {

        public static final androidx.compose.ui.platform.ViewLayer.UniqueDrawingIdApi29 INSTANCE;
        static {
            ViewLayer.UniqueDrawingIdApi29 uniqueDrawingIdApi29 = new ViewLayer.UniqueDrawingIdApi29();
            ViewLayer.UniqueDrawingIdApi29.INSTANCE = uniqueDrawingIdApi29;
        }

        @JvmStatic
        public static final long getUniqueDrawingId(View view) {
            return view.getUniqueDrawingId();
        }
    }
    static {
        ViewLayer.Companion companion = new ViewLayer.Companion(0);
        ViewLayer.Companion = companion;
        int i = 8;
        androidx.compose.ui.platform.ViewLayer.Companion.getMatrix.1 iNSTANCE = ViewLayer.Companion.getMatrix.1.INSTANCE;
        ViewLayer.Companion.OutlineProvider.1 anon = new ViewLayer.Companion.OutlineProvider.1();
        ViewLayer.OutlineProvider = (ViewOutlineProvider)anon;
    }

    public ViewLayer(androidx.compose.ui.platform.AndroidComposeView ownerView, androidx.compose.ui.platform.DrawChildContainer container, Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock, Function0<Unit> invalidateParentLayer) {
        super(ownerView.getContext());
        this.ownerView = ownerView;
        this.container = container;
        this.drawBlock = drawBlock;
        this.invalidateParentLayer = invalidateParentLayer;
        OutlineResolver outlineResolver = new OutlineResolver();
        this.outlineResolver = outlineResolver;
        CanvasHolder canvasHolder = new CanvasHolder();
        this.canvasHolder = canvasHolder;
        LayerMatrixCache layerMatrixCache = new LayerMatrixCache(ViewLayer.getMatrix);
        this.matrixCache = layerMatrixCache;
        this.mTransformOrigin = TransformOrigin.Companion.getCenter-SzJe1aQ();
        int i = 1;
        setWillNotDraw(false);
        this.container.addView((View)this);
        this.layerId = (long)viewId;
    }

    public static final boolean access$getHasRetrievedMethod$cp() {
        return ViewLayer.hasRetrievedMethod;
    }

    public static final ViewOutlineProvider access$getOutlineProvider$cp() {
        return ViewLayer.OutlineProvider;
    }

    public static final androidx.compose.ui.platform.OutlineResolver access$getOutlineResolver$p(androidx.compose.ui.platform.ViewLayer $this) {
        return $this.outlineResolver;
    }

    public static final Field access$getRecreateDisplayList$cp() {
        return ViewLayer.recreateDisplayList;
    }

    public static final boolean access$getShouldUseDispatchDraw$cp() {
        return ViewLayer.shouldUseDispatchDraw;
    }

    public static final Method access$getUpdateDisplayListIfDirtyMethod$cp() {
        return ViewLayer.updateDisplayListIfDirtyMethod;
    }

    public static final void access$setHasRetrievedMethod$cp(boolean <set-?>) {
        ViewLayer.hasRetrievedMethod = <set-?>;
    }

    public static final void access$setRecreateDisplayList$cp(Field <set-?>) {
        ViewLayer.recreateDisplayList = <set-?>;
    }

    public static final void access$setShouldUseDispatchDraw$cp(boolean <set-?>) {
        ViewLayer.shouldUseDispatchDraw = <set-?>;
    }

    public static final void access$setUpdateDisplayListIfDirtyMethod$cp(Method <set-?>) {
        ViewLayer.updateDisplayListIfDirtyMethod = <set-?>;
    }

    private final Path getManualClipPath() {
        Path clipPath;
        boolean outlineClipSupported;
        if (getClipToOutline()) {
            if (this.outlineResolver.getOutlineClipSupported()) {
                clipPath = 0;
            } else {
                clipPath = this.outlineResolver.getClipPath();
            }
        } else {
        }
        return clipPath;
    }

    private final void resetClipBounds() {
        Rect clipBoundsCache2;
        int clipBoundsCache;
        int i;
        int width;
        int height;
        if (this.clipToBounds) {
            i = 0;
            if (this.clipBoundsCache == null) {
                clipBoundsCache2 = new Rect(i, i, getWidth(), getHeight());
                this.clipBoundsCache = clipBoundsCache2;
            } else {
                clipBoundsCache2 = this.clipBoundsCache;
                Intrinsics.checkNotNull(clipBoundsCache2);
                clipBoundsCache2.set(i, i, getWidth(), getHeight());
            }
            clipBoundsCache = this.clipBoundsCache;
        } else {
            clipBoundsCache = 0;
        }
        setClipBounds(clipBoundsCache);
    }

    private final void setInvalidated(boolean value) {
        boolean isInvalidated;
        Object obj;
        if (value != this.isInvalidated) {
            this.isInvalidated = value;
            this.ownerView.notifyLayerIsDirty$ui_release((OwnedLayer)this, value);
        }
    }

    private final void updateOutlineResolver() {
        ViewOutlineProvider outlineProvider;
        outlineProvider = this.outlineResolver.getAndroidOutline() != null ? ViewLayer.OutlineProvider : 0;
        setOutlineProvider(outlineProvider);
    }

    @Override // android.view.View
    public void destroy() {
        setInvalidated(false);
        this.ownerView.requestClearInvalidObservations();
        int i2 = 0;
        this.drawBlock = i2;
        this.invalidateParentLayer = i2;
        boolean recycle$ui_release = this.ownerView.recycle$ui_release((OwnedLayer)this);
        this.container.removeViewInLayout((View)this);
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int didClip;
        androidx.compose.ui.platform.OutlineResolver hardwareAccelerated;
        int i;
        CanvasHolder canvasHolder = this.canvasHolder;
        final int i2 = 0;
        canvasHolder.getAndroidCanvas().setInternalCanvas(canvas);
        AndroidCanvas androidCanvas3 = canvasHolder.getAndroidCanvas();
        final int i3 = 0;
        didClip = 0;
        if (getManualClipPath() == null) {
            if (!canvas.isHardwareAccelerated()) {
                didClip = 1;
                (Canvas)androidCanvas3.save();
                this.outlineResolver.clipToOutline(androidCanvas3);
            }
        } else {
        }
        Function2 drawBlock = this.drawBlock;
        if (drawBlock != null) {
            drawBlock.invoke(androidCanvas3, 0);
        }
        if (didClip != 0) {
            androidCanvas3.restore();
        }
        canvasHolder.getAndroidCanvas().setInternalCanvas(canvasHolder.getAndroidCanvas().getInternalCanvas());
        setInvalidated(false);
    }

    @Override // android.view.View
    public void drawLayer(Canvas canvas, GraphicsLayer parentLayer) {
        int i;
        i = Float.compare(elevation, i2) > 0 ? 1 : 0;
        this.drawnWithZ = i;
        if (this.drawnWithZ) {
            canvas.enableZ();
        }
        this.container.drawChild$ui_release(canvas, (View)this, getDrawingTime());
        if (this.drawnWithZ) {
            canvas.disableZ();
        }
    }

    @Override // android.view.View
    public void forceLayout() {
    }

    @Override // android.view.View
    public final float getCameraDistancePx() {
        return cameraDistance /= f;
    }

    @Override // android.view.View
    public final androidx.compose.ui.platform.DrawChildContainer getContainer() {
        return this.container;
    }

    @Override // android.view.View
    public long getLayerId() {
        return this.layerId;
    }

    @Override // android.view.View
    public final androidx.compose.ui.platform.AndroidComposeView getOwnerView() {
        return this.ownerView;
    }

    @Override // android.view.View
    public long getOwnerViewId() {
        return ViewLayer.UniqueDrawingIdApi29.getUniqueDrawingId((View)this.ownerView);
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return this.mHasOverlappingRendering;
    }

    @Override // android.view.View
    public void invalidate() {
        boolean isInvalidated;
        if (!this.isInvalidated) {
            setInvalidated(true);
            super.invalidate();
            this.ownerView.invalidate();
        }
    }

    @Override // android.view.View
    public void inverseTransform-58bKbWc(float[] matrix) {
        float[] inverseMatrix-bWbORWo = this.matrixCache.calculateInverseMatrix-bWbORWo(this);
        if (inverseMatrix-bWbORWo != null) {
            Matrix.timesAssign-58bKbWc(matrix, inverseMatrix-bWbORWo);
        }
    }

    @Override // android.view.View
    public boolean isInLayer-k-4lQ0M(long position) {
        int cmp2;
        int i;
        int cmp;
        final float x-impl = Offset.getX-impl(position);
        final float y-impl = Offset.getY-impl(position);
        if (this.clipToBounds) {
            cmp2 = 0;
            if (Float.compare(cmp2, x-impl) <= 0 && Float.compare(x-impl, f2) < 0 && Float.compare(cmp2, y-impl) <= 0 && Float.compare(y-impl, f) < 0) {
                if (Float.compare(x-impl, f2) < 0) {
                    if (Float.compare(cmp2, y-impl) <= 0) {
                        if (Float.compare(y-impl, f) < 0) {
                        } else {
                            i = 0;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        if (getClipToOutline()) {
            return this.outlineResolver.isInOutline-k-4lQ0M(position);
        }
        return 1;
    }

    @Override // android.view.View
    public final boolean isInvalidated() {
        return this.isInvalidated;
    }

    @Override // android.view.View
    public void mapBounds(MutableRect rect, boolean inverse) {
        float[] inverseMatrix-bWbORWo;
        int i;
        if (inverse) {
            inverseMatrix-bWbORWo = this.matrixCache.calculateInverseMatrix-bWbORWo(this);
            if (inverseMatrix-bWbORWo != null) {
                Matrix.map-impl(inverseMatrix-bWbORWo, rect);
            } else {
                i = 0;
                rect.set(i, i, i, i);
            }
        } else {
            Matrix.map-impl(this.matrixCache.calculateMatrix-GrdbGEg(this), rect);
        }
    }

    @Override // android.view.View
    public long mapOffset-8S9VItk(long point, boolean inverse) {
        long map-MK-Hz9U;
        if (obj5 != null) {
            float[] inverseMatrix-bWbORWo = this.matrixCache.calculateInverseMatrix-bWbORWo(this);
            if (inverseMatrix-bWbORWo != null) {
                map-MK-Hz9U = Matrix.map-MK-Hz9U(inverseMatrix-bWbORWo, point);
            } else {
                map-MK-Hz9U = Offset.Companion.getInfinite-F1C5BW0();
            }
        } else {
            map-MK-Hz9U = Matrix.map-MK-Hz9U(this.matrixCache.calculateMatrix-GrdbGEg(this), point);
        }
        return map-MK-Hz9U;
    }

    @Override // android.view.View
    public void move--gyyYBs(long position) {
        int matrixCache2;
        int matrixCache;
        final int x-impl = IntOffset.getX-impl(position);
        if (x-impl != getLeft()) {
            offsetLeftAndRight(x-impl - left);
            this.matrixCache.invalidate();
        }
        int y-impl = IntOffset.getY-impl(position);
        if (y-impl != getTop()) {
            offsetTopAndBottom(y-impl - top);
            this.matrixCache.invalidate();
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
    }

    @Override // android.view.View
    public void resize-ozmzZPI(long size) {
        int matrixCache;
        long top;
        int i2;
        int i;
        final int width-impl = IntSize.getWidth-impl(size);
        final int height-impl = IntSize.getHeight-impl(size);
        if (width-impl == getWidth()) {
            if (height-impl != getHeight()) {
                float f = (float)width-impl;
                setPivotX(pivotFractionX-impl *= f);
                setPivotY(pivotFractionY-impl *= f2);
                updateOutlineResolver();
                layout(getLeft(), getTop(), left2 += width-impl, top2 += height-impl);
                resetClipBounds();
                this.matrixCache.invalidate();
            }
        } else {
        }
    }

    public void reuseLayer(Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock, Function0<Unit> invalidateParentLayer) {
        this.container.addView((View)this);
        int i = 0;
        this.clipToBounds = i;
        this.drawnWithZ = i;
        this.mTransformOrigin = TransformOrigin.Companion.getCenter-SzJe1aQ();
        this.drawBlock = drawBlock;
        this.invalidateParentLayer = invalidateParentLayer;
    }

    @Override // android.view.View
    public final void setCameraDistancePx(float value) {
        setCameraDistance(f *= value);
    }

    @Override // android.view.View
    public void transform-58bKbWc(float[] matrix) {
        Matrix.timesAssign-58bKbWc(matrix, this.matrixCache.calculateMatrix-GrdbGEg(this));
    }

    @Override // android.view.View
    public void updateDisplayList() {
        boolean shouldUseDispatchDraw;
        Object obj;
        if (this.isInvalidated && !ViewLayer.shouldUseDispatchDraw) {
            if (!ViewLayer.shouldUseDispatchDraw) {
                ViewLayer.Companion.updateDisplayList((View)this);
                setInvalidated(false);
            }
        }
    }

    @Override // android.view.View
    public void updateLayerProperties(ReusableGraphicsLayerScope scope) {
        int i;
        int scaleX;
        int scaleY;
        int alpha;
        int translationX;
        int translationY;
        int shadowElevation2;
        int rotationZ;
        int rotationX;
        int rotationY;
        int cameraDistance;
        int i5;
        long l;
        int i4;
        int i6;
        int i2;
        boolean shape2;
        boolean shape;
        androidx.compose.ui.graphics.Shape rectangleShape;
        int i3;
        boolean invalidateParentLayer;
        int matrixCache;
        int iNSTANCE3;
        int iNSTANCE;
        int iNSTANCE2;
        boolean compositingStrategy--NrFUSI;
        float alpha2;
        int modulateAlpha--NrFUSI;
        float shadowElevation;
        mutatedFields$ui_release |= mutatedFields;
        if (i7 & 4096 != 0) {
            this.mTransformOrigin = scope.getTransformOrigin-SzJe1aQ();
            float f = (float)width;
            setPivotX(pivotFractionX-impl *= f);
            setPivotY(pivotFractionY-impl *= l);
        }
        if (i7 & 1 != 0) {
            setScaleX(scope.getScaleX());
        }
        if (i7 & 2 != 0) {
            setScaleY(scope.getScaleY());
        }
        if (i7 & 4 != 0) {
            setAlpha(scope.getAlpha());
        }
        if (i7 & 8 != 0) {
            setTranslationX(scope.getTranslationX());
        }
        if (i7 & 16 != 0) {
            setTranslationY(scope.getTranslationY());
        }
        if (i7 & 32 != 0) {
            setElevation(scope.getShadowElevation());
        }
        if (i7 & 1024 != 0) {
            setRotation(scope.getRotationZ());
        }
        if (i7 & 256 != 0) {
            setRotationX(scope.getRotationX());
        }
        if (i7 & 512 != 0) {
            setRotationY(scope.getRotationY());
        }
        if (i7 & 2048 != 0) {
            setCameraDistancePx(scope.getCameraDistance());
        }
        i4 = 0;
        final int i10 = 1;
        i5 = getManualClipPath() != null ? i10 : i4;
        if (scope.getClip() && scope.getShape() != RectangleShapeKt.getRectangleShape()) {
            i6 = scope.getShape() != RectangleShapeKt.getRectangleShape() ? i10 : i4;
        } else {
        }
        final int i13 = i6;
        if (i7 & 24576 != 0) {
            if (scope.getClip() && scope.getShape() == RectangleShapeKt.getRectangleShape()) {
                i2 = scope.getShape() == RectangleShapeKt.getRectangleShape() ? i10 : i4;
            } else {
            }
            this.clipToBounds = i2;
            resetClipBounds();
            setClipToOutline(i13);
        }
        final long size-NH-jbRc = scope.getSize-NH-jbRc();
        if (this.outlineResolver.getCacheIsDirty$ui_release()) {
            updateOutlineResolver();
        }
        i3 = getManualClipPath() != null ? i10 : i4;
        if (i5 == i3) {
            if (i3 != 0 && this.outlineResolver.update-S_szKao(scope.getOutline$ui_release(), scope.getAlpha(), i13, scope.getShadowElevation(), size-NH-jbRc)) {
                if (this.outlineResolver.update-S_szKao(scope.getOutline$ui_release(), scope.getAlpha(), i13, scope.getShadowElevation(), size-NH-jbRc)) {
                    invalidate();
                }
            }
        } else {
        }
        invalidateParentLayer = this.invalidateParentLayer;
        if (!this.drawnWithZ && Float.compare(elevation, alpha2) > 0 && invalidateParentLayer != null) {
            if (Float.compare(elevation, alpha2) > 0) {
                invalidateParentLayer = this.invalidateParentLayer;
                if (invalidateParentLayer != null) {
                    invalidateParentLayer.invoke();
                }
            }
        }
        if (i7 & 7963 != 0) {
            this.matrixCache.invalidate();
        }
        if (i7 & 64 != 0) {
            ViewLayerVerificationHelper28.INSTANCE.setOutlineAmbientShadowColor((View)this, ColorKt.toArgb-8_81llA(scope.getAmbientShadowColor-0d7_KjU()));
        }
        if (i7 & 128 != 0) {
            ViewLayerVerificationHelper28.INSTANCE.setOutlineSpotShadowColor((View)this, ColorKt.toArgb-8_81llA(scope.getSpotShadowColor-0d7_KjU()));
        }
        if (Build.VERSION.SDK_INT >= 31 && i11 &= i7 != 0) {
            if (i11 &= i7 != 0) {
                ViewLayerVerificationHelper31.INSTANCE.setRenderEffect((View)this, scope.getRenderEffect());
            }
        }
        if (i12 &= i7 != 0) {
            compositingStrategy--NrFUSI = scope.getCompositingStrategy--NrFUSI();
            shadowElevation = 0;
            if (CompositingStrategy.equals-impl0(compositingStrategy--NrFUSI, CompositingStrategy.Companion.getOffscreen--NrFUSI())) {
                setLayerType(2, shadowElevation);
                i4 = i10;
            } else {
                if (CompositingStrategy.equals-impl0(compositingStrategy--NrFUSI, CompositingStrategy.Companion.getModulateAlpha--NrFUSI())) {
                    setLayerType(i4, shadowElevation);
                } else {
                    setLayerType(i4, shadowElevation);
                    i4 = i10;
                }
            }
            this.mHasOverlappingRendering = i4;
        }
        this.mutatedFields = scope.getMutatedFields$ui_release();
    }
}
