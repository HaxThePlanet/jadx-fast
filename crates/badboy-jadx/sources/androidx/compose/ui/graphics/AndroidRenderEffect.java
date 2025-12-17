package androidx.compose.ui.graphics;

import android.graphics.RenderEffect;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0007\u001a\u00020\u0003H\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0008", d2 = {"Landroidx/compose/ui/graphics/AndroidRenderEffect;", "Landroidx/compose/ui/graphics/RenderEffect;", "androidRenderEffect", "Landroid/graphics/RenderEffect;", "(Landroid/graphics/RenderEffect;)V", "getAndroidRenderEffect", "()Landroid/graphics/RenderEffect;", "createRenderEffect", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidRenderEffect extends androidx.compose.ui.graphics.RenderEffect {

    private final RenderEffect androidRenderEffect;
    public AndroidRenderEffect(RenderEffect androidRenderEffect) {
        super(0);
        this.androidRenderEffect = androidRenderEffect;
    }

    @Override // androidx.compose.ui.graphics.RenderEffect
    protected RenderEffect createRenderEffect() {
        return this.androidRenderEffect;
    }

    @Override // androidx.compose.ui.graphics.RenderEffect
    public final RenderEffect getAndroidRenderEffect() {
        return this.androidRenderEffect;
    }
}
