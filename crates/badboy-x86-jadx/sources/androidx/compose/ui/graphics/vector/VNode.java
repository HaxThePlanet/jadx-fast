package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00087\u0018\u00002\u00020\u0001B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u0005J\u000c\u0010\u000b\u001a\u00020\u0005*\u00020\u000cH&R(\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\t\u0082\u0001\u0003\r\u000e\u000f¨\u0006\u0010", d2 = {"Landroidx/compose/ui/graphics/vector/VNode;", "", "()V", "invalidateListener", "Lkotlin/Function1;", "", "getInvalidateListener$ui_release", "()Lkotlin/jvm/functions/Function1;", "setInvalidateListener$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "invalidate", "draw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "Landroidx/compose/ui/graphics/vector/PathComponent;", "Landroidx/compose/ui/graphics/vector/VectorComponent;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class VNode {

    public static final int $stable = 8;
    private Function1<? super androidx.compose.ui.graphics.vector.VNode, Unit> invalidateListener;
    static {
        final int i = 8;
    }

    public VNode(DefaultConstructorMarker defaultConstructorMarker) {
        super();
    }

    public abstract void draw(DrawScope drawScope);

    public Function1<androidx.compose.ui.graphics.vector.VNode, Unit> getInvalidateListener$ui_release() {
        return this.invalidateListener;
    }

    public final void invalidate() {
        final Function1 invalidateListener$ui_release = getInvalidateListener$ui_release();
        if (invalidateListener$ui_release != null) {
            invalidateListener$ui_release.invoke(this);
        }
    }

    public void setInvalidateListener$ui_release(Function1<? super androidx.compose.ui.graphics.vector.VNode, Unit> <set-?>) {
        this.invalidateListener = <set-?>;
    }
}
