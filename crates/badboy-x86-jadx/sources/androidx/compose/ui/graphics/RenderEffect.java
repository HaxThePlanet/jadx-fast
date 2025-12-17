package androidx.compose.ui.graphics;

import android.graphics.RenderEffect;
import android.os.Build.VERSION;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00087\u0018\u00002\u00020\u0001B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0005\u001a\u00020\u0004H\u0007J\u0008\u0010\u0006\u001a\u00020\u0004H%J\u0008\u0010\u0007\u001a\u00020\u0008H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0001\u0003\t\n\u000b¨\u0006\u000c", d2 = {"Landroidx/compose/ui/graphics/RenderEffect;", "", "()V", "internalRenderEffect", "Landroid/graphics/RenderEffect;", "asAndroidRenderEffect", "createRenderEffect", "isSupported", "", "Landroidx/compose/ui/graphics/AndroidRenderEffect;", "Landroidx/compose/ui/graphics/BlurEffect;", "Landroidx/compose/ui/graphics/OffsetEffect;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class RenderEffect {

    private RenderEffect internalRenderEffect;
    public RenderEffect(DefaultConstructorMarker defaultConstructorMarker) {
        super();
    }

    public final RenderEffect asAndroidRenderEffect() {
        RenderEffect internalRenderEffect;
        RenderEffect renderEffect;
        int i;
        if (this.internalRenderEffect == null) {
            i = 0;
            this.internalRenderEffect = createRenderEffect();
        }
        return internalRenderEffect;
    }

    protected abstract RenderEffect createRenderEffect();

    public boolean isSupported() {
        int i;
        i = Build.VERSION.SDK_INT >= 31 ? 1 : 0;
        return i;
    }
}
