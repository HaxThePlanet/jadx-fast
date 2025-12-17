package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0000\u001a\u00020\u0001H\u0007\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004¨\u0006\u0006", d2 = {"layoutId", "", "Landroidx/compose/ui/layout/Measurable;", "getLayoutId", "(Landroidx/compose/ui/layout/Measurable;)Ljava/lang/Object;", "Landroidx/compose/ui/Modifier;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LayoutIdKt {
    public static final Object getLayoutId(androidx.compose.ui.layout.Measurable $this$layoutId) {
        Object parentData;
        int layoutId;
        if (parentData instanceof LayoutIdParentData != null) {
        } else {
            parentData = layoutId;
        }
        if (parentData != null) {
            layoutId = parentData.getLayoutId();
        }
        return layoutId;
    }

    public static final Modifier layoutId(Modifier $this$layoutId, Object layoutId) {
        LayoutIdElement layoutIdElement = new LayoutIdElement(layoutId);
        return $this$layoutId.then((Modifier)layoutIdElement);
    }
}
