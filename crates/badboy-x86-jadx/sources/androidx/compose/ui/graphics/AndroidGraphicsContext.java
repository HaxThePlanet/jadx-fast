package androidx.compose.ui.graphics;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerV29;
import androidx.compose.ui.graphics.layer.LayerManager;
import androidx.compose.ui.graphics.layer.view.DrawChildContainer;
import androidx.compose.ui.graphics.layer.view.ViewLayerContainer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0006\u0010\u0016\u001a\u00020\u0008J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0011H\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!", d2 = {"Landroidx/compose/ui/graphics/AndroidGraphicsContext;", "Landroidx/compose/ui/graphics/GraphicsContext;", "ownerView", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "componentCallback", "Landroid/content/ComponentCallbacks2;", "componentCallbackRegistered", "", "layerManager", "Landroidx/compose/ui/graphics/layer/LayerManager;", "lock", "", "predrawListenerRegistered", "viewLayerContainer", "Landroidx/compose/ui/graphics/layer/view/DrawChildContainer;", "createGraphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "getUniqueDrawingId", "", "view", "Landroid/view/View;", "isLayerManagerInitialized", "obtainViewLayerContainer", "registerComponentCallback", "", "context", "Landroid/content/Context;", "releaseGraphicsLayer", "layer", "unregisterComponentCallback", "Companion", "UniqueDrawingIdApi29", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class AndroidGraphicsContext implements androidx.compose.ui.graphics.GraphicsContext {

    public static final androidx.compose.ui.graphics.AndroidGraphicsContext.Companion Companion = null;
    public static final boolean enableLayerPersistence = false;
    private static boolean isRenderNodeCompatible;
    private final ComponentCallbacks2 componentCallback = null;
    private boolean componentCallbackRegistered;
    private final LayerManager layerManager = null;
    private final Object lock;
    private final ViewGroup ownerView;
    private boolean predrawListenerRegistered;
    private DrawChildContainer viewLayerContainer;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008¨\u0006\t", d2 = {"Landroidx/compose/ui/graphics/AndroidGraphicsContext$Companion;", "", "()V", "enableLayerPersistence", "", "isRenderNodeCompatible", "()Z", "setRenderNodeCompatible", "(Z)V", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final boolean isRenderNodeCompatible() {
            return AndroidGraphicsContext.access$isRenderNodeCompatible$cp();
        }

        public final void setRenderNodeCompatible(boolean <set-?>) {
            AndroidGraphicsContext.access$setRenderNodeCompatible$cp(<set-?>);
        }
    }

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007", d2 = {"Landroidx/compose/ui/graphics/AndroidGraphicsContext$UniqueDrawingIdApi29;", "", "()V", "getUniqueDrawingId", "", "view", "Landroid/view/View;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class UniqueDrawingIdApi29 {

        public static final androidx.compose.ui.graphics.AndroidGraphicsContext.UniqueDrawingIdApi29 INSTANCE;
        static {
            AndroidGraphicsContext.UniqueDrawingIdApi29 uniqueDrawingIdApi29 = new AndroidGraphicsContext.UniqueDrawingIdApi29();
            AndroidGraphicsContext.UniqueDrawingIdApi29.INSTANCE = uniqueDrawingIdApi29;
        }

        @JvmStatic
        public static final long getUniqueDrawingId(View view) {
            return view.getUniqueDrawingId();
        }
    }
    static {
        AndroidGraphicsContext.Companion companion = new AndroidGraphicsContext.Companion(0);
        AndroidGraphicsContext.Companion = companion;
        AndroidGraphicsContext.isRenderNodeCompatible = true;
    }

    public AndroidGraphicsContext(ViewGroup ownerView) {
        super();
        this.ownerView = ownerView;
        Object object = new Object();
        this.lock = object;
        int i = 0;
    }

    public static final LayerManager access$getLayerManager$p(androidx.compose.ui.graphics.AndroidGraphicsContext $this) {
        return $this.layerManager;
    }

    public static final ViewGroup access$getOwnerView$p(androidx.compose.ui.graphics.AndroidGraphicsContext $this) {
        return $this.ownerView;
    }

    public static final boolean access$getPredrawListenerRegistered$p(androidx.compose.ui.graphics.AndroidGraphicsContext $this) {
        return $this.predrawListenerRegistered;
    }

    public static final boolean access$isRenderNodeCompatible$cp() {
        return AndroidGraphicsContext.isRenderNodeCompatible;
    }

    public static final void access$registerComponentCallback(androidx.compose.ui.graphics.AndroidGraphicsContext $this, Context context) {
        $this.registerComponentCallback(context);
    }

    public static final void access$setPredrawListenerRegistered$p(androidx.compose.ui.graphics.AndroidGraphicsContext $this, boolean <set-?>) {
        $this.predrawListenerRegistered = <set-?>;
    }

    public static final void access$setRenderNodeCompatible$cp(boolean <set-?>) {
        AndroidGraphicsContext.isRenderNodeCompatible = <set-?>;
    }

    public static final void access$unregisterComponentCallback(androidx.compose.ui.graphics.AndroidGraphicsContext $this, Context context) {
        $this.unregisterComponentCallback(context);
    }

    private final long getUniqueDrawingId(View view) {
        return AndroidGraphicsContext.UniqueDrawingIdApi29.getUniqueDrawingId(view);
    }

    private final DrawChildContainer obtainViewLayerContainer(ViewGroup ownerView) {
        DrawChildContainer container;
        Context context;
        ViewLayerContainer view;
        if (this.viewLayerContainer == null) {
            ViewLayerContainer viewLayerContainer = new ViewLayerContainer(ownerView.getContext());
            container = viewLayerContainer;
            ownerView.addView((View)(DrawChildContainer)container);
            this.viewLayerContainer = container;
        }
        return container;
    }

    private final void registerComponentCallback(Context context) {
        boolean componentCallbackRegistered;
        ComponentCallbacks2 componentCallback;
        if (!this.componentCallbackRegistered) {
            context.getApplicationContext().registerComponentCallbacks((ComponentCallbacks)this.componentCallback);
            this.componentCallbackRegistered = true;
        }
    }

    private final void unregisterComponentCallback(Context context) {
        boolean componentCallbackRegistered;
        ComponentCallbacks2 componentCallback;
        if (this.componentCallbackRegistered) {
            context.getApplicationContext().unregisterComponentCallbacks((ComponentCallbacks)this.componentCallback);
            this.componentCallbackRegistered = false;
        }
    }

    @Override // androidx.compose.ui.graphics.GraphicsContext
    public GraphicsLayer createGraphicsLayer() {
        final Object lock = this.lock;
        final int i = 0;
        GraphicsLayerV29 graphicsLayerV29 = new GraphicsLayerV29(getUniqueDrawingId((View)this.ownerView), obj6, 0, 0, 6, 0);
        GraphicsLayer graphicsLayer = new GraphicsLayer((GraphicsLayerImpl)graphicsLayerV29, this.layerManager);
        return graphicsLayer;
        synchronized (lock) {
            lock = this.lock;
            i = 0;
            graphicsLayerV29 = new GraphicsLayerV29(getUniqueDrawingId((View)this.ownerView), obj6, 0, 0, 6, 0);
            graphicsLayer = new GraphicsLayer((GraphicsLayerImpl)graphicsLayerV29, this.layerManager);
            return graphicsLayer;
        }
    }

    @Override // androidx.compose.ui.graphics.GraphicsContext
    public final boolean isLayerManagerInitialized() {
        boolean imageReader;
        LayerManager layerManager = this.layerManager;
        if (layerManager != null) {
            imageReader = layerManager.hasImageReader();
        } else {
            imageReader = 0;
        }
        return imageReader;
    }

    @Override // androidx.compose.ui.graphics.GraphicsContext
    public void releaseGraphicsLayer(GraphicsLayer layer) {
        final Object lock = this.lock;
        int i = 0;
        layer.release$ui_graphics_release();
        Unit iNSTANCE = Unit.INSTANCE;
        return;
        synchronized (lock) {
            lock = this.lock;
            i = 0;
            layer.release$ui_graphics_release();
            iNSTANCE = Unit.INSTANCE;
        }
    }
}
