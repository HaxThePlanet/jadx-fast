package androidx.compose.foundation;

import android.view.View;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0004\u0008a\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017JR\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H&ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005ø\u0001\u0001\u0082\u0002\r\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u0006\u0018À\u0006\u0001", d2 = {"Landroidx/compose/foundation/PlatformMagnifierFactory;", "", "canUpdateZoom", "", "getCanUpdateZoom", "()Z", "create", "Landroidx/compose/foundation/PlatformMagnifier;", "view", "Landroid/view/View;", "useTextDefault", "size", "Landroidx/compose/ui/unit/DpSize;", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "elevation", "clippingEnabled", "density", "Landroidx/compose/ui/unit/Density;", "initialZoom", "", "create-nHHXs2Y", "(Landroid/view/View;ZJFFZLandroidx/compose/ui/unit/Density;F)Landroidx/compose/foundation/PlatformMagnifier;", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PlatformMagnifierFactory {

    public static final androidx.compose.foundation.PlatformMagnifierFactory.Companion Companion;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005", d2 = {"Landroidx/compose/foundation/PlatformMagnifierFactory$Companion;", "", "()V", "getForCurrentPlatform", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final androidx.compose.foundation.PlatformMagnifierFactory.Companion $$INSTANCE;
        static {
            PlatformMagnifierFactory.Companion companion = new PlatformMagnifierFactory.Companion();
            PlatformMagnifierFactory.Companion.$$INSTANCE = companion;
        }

        public final androidx.compose.foundation.PlatformMagnifierFactory getForCurrentPlatform() {
            if (!Magnifier_androidKt.isPlatformMagnifierSupported$default(0, 1, 0)) {
            } else {
                return (PlatformMagnifierFactory)PlatformMagnifierFactoryApi29Impl.INSTANCE;
            }
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Magnifier is only supported on API level 28 and higher.");
            throw unsupportedOperationException;
        }
    }
    static {
        PlatformMagnifierFactory.Companion = PlatformMagnifierFactory.Companion.$$INSTANCE;
    }

    public abstract androidx.compose.foundation.PlatformMagnifier create-nHHXs2Y(View view, boolean z2, long l3, float f4, float f5, boolean z6, Density density7, float f8);

    public abstract boolean getCanUpdateZoom();
}
