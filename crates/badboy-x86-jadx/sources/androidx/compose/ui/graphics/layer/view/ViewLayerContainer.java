package androidx.compose.ui.graphics.layer.view;

import android.content.Context;
import android.graphics.Canvas;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0014J\u0008\u0010\t\u001a\u00020\u0006H\u0004¨\u0006\n", d2 = {"Landroidx/compose/ui/graphics/layer/view/ViewLayerContainer;", "Landroidx/compose/ui/graphics/layer/view/DrawChildContainer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "dispatchGetDisplayList", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ViewLayerContainer extends androidx.compose.ui.graphics.layer.view.DrawChildContainer {
    public ViewLayerContainer(Context context) {
        super(context);
    }

    @Override // androidx.compose.ui.graphics.layer.view.DrawChildContainer
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // androidx.compose.ui.graphics.layer.view.DrawChildContainer
    protected final void dispatchGetDisplayList() {
    }
}
