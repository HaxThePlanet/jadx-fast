package androidx.compose.ui.graphics.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.media.ImageReader;
import android.os.Looper;
import android.view.Surface;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.IntSize;
import androidx.core.os.HandlerCompat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlinx.coroutines.CancellableContinuationImpl;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Á\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0096@¢\u0006\u0002\u0010\u0007¨\u0006\u0008", d2 = {"Landroidx/compose/ui/graphics/layer/LayerSnapshotV22;", "Landroidx/compose/ui/graphics/layer/LayerSnapshotImpl;", "()V", "toBitmap", "Landroid/graphics/Bitmap;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LayerSnapshotV22 implements androidx.compose.ui.graphics.layer.LayerSnapshotImpl {

    public static final androidx.compose.ui.graphics.layer.LayerSnapshotV22 INSTANCE;
    static {
        LayerSnapshotV22 layerSnapshotV22 = new LayerSnapshotV22();
        LayerSnapshotV22.INSTANCE = layerSnapshotV22;
    }

    public Object toBitmap(androidx.compose.ui.graphics.layer.GraphicsLayer graphicsLayer, Continuation<? super Bitmap> continuation2) {
        Object obj;
        int i3;
        boolean anon;
        int i4;
        Throwable th;
        int i;
        long l;
        Object obj2;
        Object obj3;
        Object cOROUTINE_SUSPENDED;
        Canvas lockCanvas;
        Looper mainLooper;
        androidx.compose.ui.graphics.Canvas canvas;
        int i5;
        androidx.compose.ui.graphics.layer.LayerSnapshotV22.toBitmap.1 anon2;
        int i6;
        int i2;
        int i7;
        CancellableContinuationImpl cancellableContinuationImpl;
        PorterDuff.Mode cLEAR;
        obj = continuation2;
        anon = obj;
        th = Integer.MIN_VALUE;
        if (obj instanceof LayerSnapshotV22.toBitmap.1 && label2 &= th != 0) {
            anon = obj;
            th = Integer.MIN_VALUE;
            if (label2 &= th != 0) {
                anon.label = label -= th;
            } else {
                anon = new LayerSnapshotV22.toBitmap.1(this, obj);
            }
        } else {
        }
        Object result = anon.result;
        Object cOROUTINE_SUSPENDED2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        final int i8 = 0;
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure(result);
                Object obj4 = graphicsLayer;
                long size-YbymL2g = obj4.getSize-YbymL2g();
                mainLooper = Looper.getMainLooper();
                int i9 = 1;
                ImageReader instance = ImageReader.newInstance(IntSize.getWidth-impl(size-YbymL2g), IntSize.getHeight-impl(size-YbymL2g), i9, i9);
                ImageReader reader = instance;
                anon2 = anon;
                anon.L$0 = obj4;
                anon.L$1 = mainLooper;
                anon.L$2 = (AutoCloseable)instance;
                anon.L$3 = (ImageReader)reader;
                anon.L$4 = anon2;
                anon.label = i9;
                i7 = 0;
                cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted((Continuation)anon2), i9);
                cancellableContinuationImpl.initCancellability();
                i2 = 0;
                LayerSnapshotV22.toBitmap.2.image.1.1 anon4 = new LayerSnapshotV22.toBitmap.2.image.1.1((CancellableContinuation)cancellableContinuationImpl);
                reader.setOnImageAvailableListener((ImageReader.OnImageAvailableListener)anon4, HandlerCompat.createAsync(mainLooper));
                Surface surface = reader.getSurface();
                lockCanvas = SurfaceUtils.INSTANCE.lockCanvas(surface);
                lockCanvas.drawColor(ColorKt.toArgb-8_81llA(Color.Companion.getBlack-0d7_KjU()), PorterDuff.Mode.CLEAR);
                obj4.draw$ui_graphics_release(AndroidCanvas_androidKt.Canvas(lockCanvas), i8);
                surface.unlockCanvasAndPost(lockCanvas);
                Object result2 = cancellableContinuationImpl.getResult();
                DebugProbesKt.probeCoroutineSuspended((Continuation)anon2);
                return cOROUTINE_SUSPENDED2;
                obj3 = instance;
                i3 = i5;
                obj2 = result2;
                i = i6;
                break;
            case 1:
                i3 = 0;
                i = 0;
                Object l$4 = anon.L$4;
                Object l$3 = anon.L$3;
                Object l$1 = anon.L$1;
                Object l$0 = anon.L$0;
                ResultKt.throwOnFailure(result);
                obj3 = l$2;
                obj2 = result;
                break;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw illegalStateException;
        }
        AutoCloseableKt.closeFinally(obj3, i8);
        return LayerSnapshot_androidKt.access$toBitmap((Image)obj2);
    }
}
