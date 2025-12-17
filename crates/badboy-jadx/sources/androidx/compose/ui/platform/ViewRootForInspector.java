package androidx.compose.ui.platform;

import android.view.View;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\nÀ\u0006\u0003", d2 = {"Landroidx/compose/ui/platform/ViewRootForInspector;", "", "subCompositionView", "Landroidx/compose/ui/platform/AbstractComposeView;", "getSubCompositionView", "()Landroidx/compose/ui/platform/AbstractComposeView;", "viewRoot", "Landroid/view/View;", "getViewRoot", "()Landroid/view/View;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ViewRootForInspector {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static androidx.compose.ui.platform.AbstractComposeView getSubCompositionView(androidx.compose.ui.platform.ViewRootForInspector $this) {
            return ViewRootForInspector.access$getSubCompositionView$jd($this);
        }

        @Deprecated
        public static View getViewRoot(androidx.compose.ui.platform.ViewRootForInspector $this) {
            return ViewRootForInspector.access$getViewRoot$jd($this);
        }
    }
    public static androidx.compose.ui.platform.AbstractComposeView access$getSubCompositionView$jd(androidx.compose.ui.platform.ViewRootForInspector $this) {
        return super.getSubCompositionView();
    }

    public static View access$getViewRoot$jd(androidx.compose.ui.platform.ViewRootForInspector $this) {
        return super.getViewRoot();
    }

    public androidx.compose.ui.platform.AbstractComposeView getSubCompositionView() {
        return null;
    }

    public View getViewRoot() {
        return null;
    }
}
