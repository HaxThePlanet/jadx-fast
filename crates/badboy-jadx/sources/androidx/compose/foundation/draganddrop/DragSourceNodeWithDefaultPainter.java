package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.DelegatingNode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0003\u0018\u00002\u00020\u0001B.\u0012'\u0010\u0002\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003¢\u0006\u0002\u0008\u0008¢\u0006\u0002\u0010\tR=\u0010\u0002\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003¢\u0006\u0002\u0008\u0008X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\t¨\u0006\u000e", d2 = {"Landroidx/compose/foundation/draganddrop/DragSourceNodeWithDefaultPainter;", "Landroidx/compose/ui/node/DelegatingNode;", "dragAndDropSourceHandler", "Lkotlin/Function2;", "Landroidx/compose/foundation/draganddrop/DragAndDropSourceScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)V", "getDragAndDropSourceHandler", "()Lkotlin/jvm/functions/Function2;", "setDragAndDropSourceHandler", "Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DragSourceNodeWithDefaultPainter extends DelegatingNode {

    private Function2<? super androidx.compose.foundation.draganddrop.DragAndDropSourceScope, ? super Continuation<? super Unit>, ? extends Object> dragAndDropSourceHandler;
    public DragSourceNodeWithDefaultPainter(Function2<? super androidx.compose.foundation.draganddrop.DragAndDropSourceScope, ? super Continuation<? super Unit>, ? extends Object> dragAndDropSourceHandler) {
        super();
        this.dragAndDropSourceHandler = dragAndDropSourceHandler;
        CacheDrawScopeDragShadowCallback cacheDrawScopeDragShadowCallback = new CacheDrawScopeDragShadowCallback();
        int i = 0;
        DragSourceNodeWithDefaultPainter.cacheDrawScopeDragShadowCallback.1.1 anon2 = new DragSourceNodeWithDefaultPainter.cacheDrawScopeDragShadowCallback.1.1(cacheDrawScopeDragShadowCallback);
        delegate((DelegatableNode)DrawModifierKt.CacheDrawModifierNode((Function1)anon2));
        DragSourceNodeWithDefaultPainter.1 anon = new DragSourceNodeWithDefaultPainter.1(cacheDrawScopeDragShadowCallback);
        DragSourceNodeWithDefaultPainter.2 anon3 = new DragSourceNodeWithDefaultPainter.2(this, 0);
        DragAndDropSourceNode dragAndDropSourceNode = new DragAndDropSourceNode((Function1)anon, (Function2)anon3);
        delegate((DelegatableNode)dragAndDropSourceNode);
    }

    public final Function2<androidx.compose.foundation.draganddrop.DragAndDropSourceScope, Continuation<? super Unit>, Object> getDragAndDropSourceHandler() {
        return this.dragAndDropSourceHandler;
    }

    public final void setDragAndDropSourceHandler(Function2<? super androidx.compose.foundation.draganddrop.DragAndDropSourceScope, ? super Continuation<? super Unit>, ? extends Object> <set-?>) {
        this.dragAndDropSourceHandler = <set-?>;
    }
}
