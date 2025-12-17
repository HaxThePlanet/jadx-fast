package androidx.compose.ui.platform;

import android.view.View;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0007¨\u0006\n", d2 = {"Landroidx/compose/ui/platform/ViewLayerVerificationHelper28;", "", "()V", "setOutlineAmbientShadowColor", "", "view", "Landroid/view/View;", "target", "", "setOutlineSpotShadowColor", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ViewLayerVerificationHelper28 {

    public static final androidx.compose.ui.platform.ViewLayerVerificationHelper28 INSTANCE;
    static {
        ViewLayerVerificationHelper28 viewLayerVerificationHelper28 = new ViewLayerVerificationHelper28();
        ViewLayerVerificationHelper28.INSTANCE = viewLayerVerificationHelper28;
    }

    public final void setOutlineAmbientShadowColor(View view, int target) {
        view.setOutlineAmbientShadowColor(target);
    }

    public final void setOutlineSpotShadowColor(View view, int target) {
        view.setOutlineSpotShadowColor(target);
    }
}
