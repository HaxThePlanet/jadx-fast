package androidx.compose.animation;

import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008`\u0018\u00002\u00020\u0001J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rH&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u000eÀ\u0006\u0001", d2 = {"Landroidx/compose/animation/LayerRenderer;", "", "parentState", "Landroidx/compose/animation/SharedElementInternalState;", "getParentState", "()Landroidx/compose/animation/SharedElementInternalState;", "zIndex", "", "getZIndex", "()F", "drawInOverlay", "", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface LayerRenderer {
    public abstract void drawInOverlay(DrawScope drawScope);

    public abstract androidx.compose.animation.SharedElementInternalState getParentState();

    public abstract float getZIndex();
}
