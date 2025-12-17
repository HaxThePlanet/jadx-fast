package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.core.os.HandlerCompat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u000fJ\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\rJ\u0016\u0010\u0017\u001a\u00020\u00132\u000c\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\r0\u0019H\u0002J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\rJ\u0006\u0010\u001b\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d", d2 = {"Landroidx/compose/ui/graphics/layer/LayerManager;", "", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "(Landroidx/compose/ui/graphics/CanvasHolder;)V", "getCanvasHolder", "()Landroidx/compose/ui/graphics/CanvasHolder;", "handler", "Landroid/os/Handler;", "imageReader", "Landroid/media/ImageReader;", "layerSet", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "persistenceIterationInProgress", "", "postponedReleaseRequests", "Landroidx/collection/MutableObjectList;", "destroy", "", "hasImageReader", "persist", "layer", "persistLayers", "layers", "Landroidx/collection/ScatterSet;", "release", "updateLayerPersistence", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LayerManager {

    public static final androidx.compose.ui.graphics.layer.LayerManager.Companion Companion;
    private static final boolean isRobolectric;
    private final CanvasHolder canvasHolder;
    private final Handler handler;
    private ImageReader imageReader;
    private final MutableScatterSet<androidx.compose.ui.graphics.layer.GraphicsLayer> layerSet;
    private boolean persistenceIterationInProgress;
    private MutableObjectList<androidx.compose.ui.graphics.layer.GraphicsLayer> postponedReleaseRequests;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0003\u0010\u0005¨\u0006\u0006", d2 = {"Landroidx/compose/ui/graphics/layer/LayerManager$Companion;", "", "()V", "isRobolectric", "", "()Z", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final boolean isRobolectric() {
            return LayerManager.access$isRobolectric$cp();
        }
    }
    public static void $r8$lambda$aibvIlo-YJwoVsKBYkLpc029810(ImageReader imageReader) {
        LayerManager.persistLayers$lambda$3$lambda$2(imageReader);
    }

    public static boolean $r8$lambda$fg6fcHbjsMbRdqNAHigdN8WSDDg(androidx.compose.ui.graphics.layer.LayerManager layerManager, Message message2) {
        return LayerManager.handler$lambda$0(layerManager, message2);
    }

    static {
        LayerManager.Companion companion = new LayerManager.Companion(0);
        LayerManager.Companion = companion;
        String lowerCase = Build.FINGERPRINT.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        LayerManager.isRobolectric = Intrinsics.areEqual(lowerCase, "robolectric");
    }

    public LayerManager(CanvasHolder canvasHolder) {
        super();
        this.canvasHolder = canvasHolder;
        this.layerSet = ScatterSetKt.mutableScatterSetOf();
        LayerManager$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new LayerManager$$ExternalSyntheticLambda1(this);
        this.handler = HandlerCompat.createAsync(Looper.getMainLooper(), externalSyntheticLambda1);
    }

    public static final boolean access$isRobolectric$cp() {
        return LayerManager.isRobolectric;
    }

    private static final boolean handler$lambda$0(androidx.compose.ui.graphics.layer.LayerManager this$0, Message it) {
        this$0.persistLayers((ScatterSet)this$0.layerSet);
        return 1;
    }

    private final void persistLayers(ScatterSet<androidx.compose.ui.graphics.layer.GraphicsLayer> layers) {
        MutableObjectList postponedReleaseRequests;
        int requiredOsVersion;
        long[] $this$maskEmptyOrDeleted$iv$iv$iv2;
        int content;
        boolean isRobolectric;
        ImageReader imageReader;
        Object surface;
        int lockHardwareCanvas;
        androidx.compose.ui.graphics.layer.LayerManager$$ExternalSyntheticLambda0 j$iv$iv;
        Handler $i$f$isFull;
        Canvas internalCanvas;
        AndroidCanvas androidCanvas;
        int i5;
        Object obj3;
        int i7;
        Object[] elements;
        Object obj2;
        int i6;
        Object obj;
        int requiredOsVersion2;
        long slot$iv$iv;
        CanvasHolder $this$maskEmptyOrDeleted$iv$iv$iv;
        int i3;
        int cmp;
        int i4;
        long[] m$iv$iv;
        long l;
        int i;
        int i2;
        final Object obj4 = this;
        postponedReleaseRequests = 1;
        requiredOsVersion = postponedReleaseRequests;
        $this$maskEmptyOrDeleted$iv$iv$iv2 = 0;
        if (requiredOsVersion != 0 && layers.isNotEmpty() && !LayerManager.isRobolectric) {
            if (layers.isNotEmpty()) {
                content = !LayerManager.isRobolectric ? postponedReleaseRequests : $this$maskEmptyOrDeleted$iv$iv$iv2;
            } else {
            }
        } else {
        }
        if (content != 0) {
            if (obj4.imageReader == null) {
                surface = imageReader;
                int i14 = 0;
                j$iv$iv = new LayerManager$$ExternalSyntheticLambda0();
                surface.setOnImageAvailableListener(j$iv$iv, obj4.handler);
                lockHardwareCanvas = 0;
                obj4.imageReader = surface;
            }
            surface = imageReader.getSurface();
            lockHardwareCanvas = LockHardwareCanvasHelper.INSTANCE.lockHardwareCanvas(surface);
            obj4.persistenceIterationInProgress = postponedReleaseRequests;
            j$iv$iv = obj4.canvasHolder;
            j$iv$iv.getAndroidCanvas().setInternalCanvas(lockHardwareCanvas);
            i5 = 0;
            lockHardwareCanvas.save();
            lockHardwareCanvas.clipRect($this$maskEmptyOrDeleted$iv$iv$iv2, $this$maskEmptyOrDeleted$iv$iv$iv2, postponedReleaseRequests, postponedReleaseRequests);
            obj3 = layers;
            i7 = 0;
            i6 = 0;
            Object obj5 = obj2;
            $this$maskEmptyOrDeleted$iv$iv$iv2 = obj5.metadata;
            obj = obj5;
            this_$iv$iv += -2;
            requiredOsVersion2 = requiredOsVersion;
            if (0 <= i8) {
            } else {
                m$iv$iv = $this$maskEmptyOrDeleted$iv$iv$iv2;
                i4 = content;
                $this$maskEmptyOrDeleted$iv$iv$iv = j$iv$iv;
                i3 = $i$f$isFull;
            }
            lockHardwareCanvas.restore();
            $this$maskEmptyOrDeleted$iv$iv$iv.getAndroidCanvas().setInternalCanvas(j$iv$iv.getAndroidCanvas().getInternalCanvas());
            obj4.persistenceIterationInProgress = false;
            postponedReleaseRequests = obj4.postponedReleaseRequests;
            if (postponedReleaseRequests != null && postponedReleaseRequests.isNotEmpty()) {
                if (postponedReleaseRequests.isNotEmpty()) {
                    requiredOsVersion = postponedReleaseRequests;
                    $this$maskEmptyOrDeleted$iv$iv$iv2 = 0;
                    j$iv$iv = 0;
                    while (j$iv$iv < requiredOsVersion._size) {
                        androidCanvas = null;
                        obj4.release((GraphicsLayer)requiredOsVersion.content[j$iv$iv]);
                        j$iv$iv++;
                    }
                    postponedReleaseRequests.clear();
                }
            }
            surface.unlockCanvasAndPost(lockHardwareCanvas);
        } else {
            requiredOsVersion2 = requiredOsVersion;
            i4 = content;
        }
    }

    private static final void persistLayers$lambda$3$lambda$2(ImageReader it) {
        Image latestImage;
        latestImage = it.acquireLatestImage();
        if (it != null && latestImage != null) {
            latestImage = it.acquireLatestImage();
            if (latestImage != null) {
                latestImage.close();
            }
        }
    }

    public final void destroy() {
        ImageReader imageReader = this.imageReader;
        if (imageReader != null) {
            imageReader.close();
        }
        this.imageReader = 0;
    }

    public final CanvasHolder getCanvasHolder() {
        return this.canvasHolder;
    }

    public final boolean hasImageReader() {
        int i;
        i = this.imageReader != null ? 1 : 0;
        return i;
    }

    public final void persist(androidx.compose.ui.graphics.layer.GraphicsLayer layer) {
        boolean messages;
        int obtain;
        this.layerSet.add(layer);
        if (!this.handler.hasMessages(0)) {
            this.handler.sendMessageAtFrontOfQueue(Message.obtain());
        }
    }

    public final void release(androidx.compose.ui.graphics.layer.GraphicsLayer layer) {
        MutableObjectList $i$f$mutableObjectListOf;
        MutableObjectList mutableObjectList;
        int i;
        int i3;
        int i2;
        if (!this.persistenceIterationInProgress) {
            if (this.layerSet.remove(layer)) {
                layer.discardDisplayList$ui_graphics_release();
            }
        } else {
            if (this.postponedReleaseRequests == null) {
                int i4 = 0;
                mutableObjectList = new MutableObjectList(0, 1, 0);
                i = 0;
                this.postponedReleaseRequests = mutableObjectList;
            }
            $i$f$mutableObjectListOf.add(layer);
        }
    }

    public final void updateLayerPersistence() {
        destroy();
        persistLayers((ScatterSet)this.layerSet);
    }
}
