package androidx.compose.ui.platform;

import android.graphics.RenderNode;
import androidx.compose.ui.graphics.RenderEffect;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008H\u0007¨\u0006\t", d2 = {"Landroidx/compose/ui/platform/RenderNodeApi29VerificationHelper;", "", "()V", "setRenderEffect", "", "renderNode", "Landroid/graphics/RenderNode;", "target", "Landroidx/compose/ui/graphics/RenderEffect;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class RenderNodeApi29VerificationHelper {

    public static final androidx.compose.ui.platform.RenderNodeApi29VerificationHelper INSTANCE;
    static {
        RenderNodeApi29VerificationHelper renderNodeApi29VerificationHelper = new RenderNodeApi29VerificationHelper();
        RenderNodeApi29VerificationHelper.INSTANCE = renderNodeApi29VerificationHelper;
    }

    public final void setRenderEffect(RenderNode renderNode, RenderEffect target) {
        android.graphics.RenderEffect androidRenderEffect;
        if (target != null) {
            androidRenderEffect = target.asAndroidRenderEffect();
        } else {
            androidRenderEffect = 0;
        }
        renderNode.setRenderEffect(androidRenderEffect);
    }
}
