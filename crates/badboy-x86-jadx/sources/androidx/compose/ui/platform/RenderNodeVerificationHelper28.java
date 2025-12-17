package androidx.compose.ui.platform;

import android.view.RenderNode;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0008\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0007J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0007¨\u0006\u000c", d2 = {"Landroidx/compose/ui/platform/RenderNodeVerificationHelper28;", "", "()V", "getAmbientShadowColor", "", "renderNode", "Landroid/view/RenderNode;", "getSpotShadowColor", "setAmbientShadowColor", "", "target", "setSpotShadowColor", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class RenderNodeVerificationHelper28 {

    public static final androidx.compose.ui.platform.RenderNodeVerificationHelper28 INSTANCE;
    static {
        RenderNodeVerificationHelper28 renderNodeVerificationHelper28 = new RenderNodeVerificationHelper28();
        RenderNodeVerificationHelper28.INSTANCE = renderNodeVerificationHelper28;
    }

    public final int getAmbientShadowColor(RenderNode renderNode) {
        return renderNode.getAmbientShadowColor();
    }

    public final int getSpotShadowColor(RenderNode renderNode) {
        return renderNode.getSpotShadowColor();
    }

    public final void setAmbientShadowColor(RenderNode renderNode, int target) {
        renderNode.setAmbientShadowColor(target);
    }

    public final void setSpotShadowColor(RenderNode renderNode, int target) {
        renderNode.setSpotShadowColor(target);
    }
}
