package androidx.compose.material.pullrefresh;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006", d2 = {"pullRefreshIndicatorTransform", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/material/pullrefresh/PullRefreshState;", "scale", "", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PullRefreshIndicatorTransformKt {
    public static final Modifier pullRefreshIndicatorTransform(Modifier $this$pullRefreshIndicatorTransform, androidx.compose.material.pullrefresh.PullRefreshState state, boolean scale) {
        PullRefreshIndicatorTransformKt.pullRefreshIndicatorTransform.2 anon = new PullRefreshIndicatorTransformKt.pullRefreshIndicatorTransform.2(state, scale);
        return GraphicsLayerModifierKt.graphicsLayer(DrawModifierKt.drawWithContent($this$pullRefreshIndicatorTransform, (Function1)PullRefreshIndicatorTransformKt.pullRefreshIndicatorTransform.1.INSTANCE), (Function1)anon);
    }

    public static Modifier pullRefreshIndicatorTransform$default(Modifier modifier, androidx.compose.material.pullrefresh.PullRefreshState pullRefreshState2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return PullRefreshIndicatorTransformKt.pullRefreshIndicatorTransform(modifier, pullRefreshState2, obj2);
    }
}
