package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.view.Surface;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u0010\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\u000c\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0003J\n\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Landroidx/compose/ui/graphics/layer/SurfaceUtils;", "", "()V", "hasRetrievedMethod", "", "lockHardwareCanvasMethod", "Ljava/lang/reflect/Method;", "isLockHardwareCanvasAvailable", "lockCanvas", "Landroid/graphics/Canvas;", "surface", "Landroid/view/Surface;", "lockCanvasFallback", "resolveLockHardwareCanvasMethod", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SurfaceUtils {

    public static final androidx.compose.ui.graphics.layer.SurfaceUtils INSTANCE;
    private static boolean hasRetrievedMethod;
    private static Method lockHardwareCanvasMethod;
    static {
        SurfaceUtils surfaceUtils = new SurfaceUtils();
        SurfaceUtils.INSTANCE = surfaceUtils;
    }

    private final Canvas lockCanvasFallback(Surface surface) {
        Object lockCanvas;
        String str;
        final Method resolveLockHardwareCanvasMethod = resolveLockHardwareCanvasMethod();
        if (resolveLockHardwareCanvasMethod != null) {
            Intrinsics.checkNotNull(resolveLockHardwareCanvasMethod.invoke(surface, new Object[0]), "null cannot be cast to non-null type android.graphics.Canvas");
        } else {
            lockCanvas = surface.lockCanvas(0);
        }
        return lockCanvas;
    }

    private final Method resolveLockHardwareCanvasMethod() {
        Method method;
        boolean hasRetrievedMethod;
        Method declaredMethod;
        Method method2;
        int i;
        final int i2 = 0;
        method = SurfaceUtils.lockHardwareCanvasMethod;
        synchronized (this) {
            hasRetrievedMethod = 1;
            SurfaceUtils.hasRetrievedMethod = hasRetrievedMethod;
            declaredMethod = Surface.class.getDeclaredMethod("lockHardwareCanvas", new Class[0]);
            method2 = declaredMethod;
            i = 0;
            method2.setAccessible(hasRetrievedMethod);
            SurfaceUtils.lockHardwareCanvasMethod = method2;
            method = declaredMethod;
            return method;
        }
    }

    public final boolean isLockHardwareCanvasAvailable() {
        return 1;
    }

    public final Canvas lockCanvas(Surface surface) {
        return SurfaceVerificationHelper.INSTANCE.lockHardwareCanvas(surface);
    }
}
