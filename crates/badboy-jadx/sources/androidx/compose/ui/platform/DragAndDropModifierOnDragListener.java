package androidx.compose.ui.platform;

import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;
import androidx.collection.ArraySet;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draganddrop.DragAndDropEvent;
import androidx.compose.ui.draganddrop.DragAndDropManager;
import androidx.compose.ui.draganddrop.DragAndDropModifierNode;
import androidx.compose.ui.draganddrop.DragAndDropNode;
import androidx.compose.ui.draganddrop.DragAndDropTransferData;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002Bc\u0012\\\u0010\u0003\u001aX\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\u0008\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\n\u0012$\u0012\"\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0008\u000e¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\u000f\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\u0002\u0010\u0011J;\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0008\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0008\u000eH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0014H\u0016J\u0018\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0014H\u0016R\u0014\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u0016X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000Rd\u0010\u0003\u001aX\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\u0008\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\n\u0012$\u0012\"\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0008\u000e¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\u000f\u0012\u0004\u0012\u00020\u00100\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006&", d2 = {"Landroidx/compose/ui/platform/DragAndDropModifierOnDragListener;", "Landroid/view/View$OnDragListener;", "Landroidx/compose/ui/draganddrop/DragAndDropManager;", "startDrag", "Lkotlin/Function3;", "Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "Lkotlin/ParameterName;", "name", "transferData", "Landroidx/compose/ui/geometry/Size;", "decorationSize", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "drawDragDecoration", "", "(Lkotlin/jvm/functions/Function3;)V", "interestedNodes", "Landroidx/collection/ArraySet;", "Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "rootDragAndDropNode", "Landroidx/compose/ui/draganddrop/DragAndDropNode;", "drag", "drag-12SF9DM", "(Landroidx/compose/ui/draganddrop/DragAndDropTransferData;JLkotlin/jvm/functions/Function1;)Z", "isInterestedNode", "node", "onDrag", "view", "Landroid/view/View;", "event", "Landroid/view/DragEvent;", "registerNodeInterest", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DragAndDropModifierOnDragListener implements View.OnDragListener, DragAndDropManager {

    private final ArraySet<DragAndDropModifierNode> interestedNodes;
    private final Modifier modifier;
    private final DragAndDropNode rootDragAndDropNode;
    private final Function3<DragAndDropTransferData, Size, Function1<? super DrawScope, Unit>, Boolean> startDrag;
    public DragAndDropModifierOnDragListener(Function3<? super DragAndDropTransferData, ? super Size, ? super Function1<? super DrawScope, Unit>, Boolean> startDrag) {
        super();
        this.startDrag = startDrag;
        DragAndDropNode dragAndDropNode = new DragAndDropNode((Function1)DragAndDropModifierOnDragListener.rootDragAndDropNode.1.INSTANCE);
        this.rootDragAndDropNode = dragAndDropNode;
        ArraySet arraySet = new ArraySet(0, 1, 0);
        this.interestedNodes = arraySet;
        DragAndDropModifierOnDragListener.modifier.1 anon = new DragAndDropModifierOnDragListener.modifier.1(this);
        this.modifier = (Modifier)anon;
    }

    public static final DragAndDropNode access$getRootDragAndDropNode$p(androidx.compose.ui.platform.DragAndDropModifierOnDragListener $this) {
        return $this.rootDragAndDropNode;
    }

    public boolean drag-12SF9DM(DragAndDropTransferData transferData, long decorationSize, Function1<? super DrawScope, Unit> drawDragDecoration) {
        return (Boolean)this.startDrag.invoke(transferData, Size.box-impl(decorationSize), obj6).booleanValue();
    }

    @Override // android.view.View$OnDragListener
    public Modifier getModifier() {
        return this.modifier;
    }

    @Override // android.view.View$OnDragListener
    public boolean isInterestedNode(DragAndDropModifierNode node) {
        return this.interestedNodes.contains(node);
    }

    @Override // android.view.View$OnDragListener
    public boolean onDrag(View view, DragEvent event) {
        ArraySet rootDragAndDropNode;
        boolean acceptDragAndDropTransfer;
        int i;
        Iterator iterator;
        boolean next;
        Object obj;
        int i2;
        DragAndDropEvent dragAndDropEvent2 = new DragAndDropEvent(event);
        acceptDragAndDropTransfer = 0;
        switch (rootDragAndDropNode) {
            case 1:
                acceptDragAndDropTransfer = this.rootDragAndDropNode.acceptDragAndDropTransfer(dragAndDropEvent2);
                i = 0;
                iterator = (Iterable)this.interestedNodes.iterator();
                i2 = 0;
                (DragAndDropModifierNode)iterator.next().onStarted(dragAndDropEvent2);
                break;
            case 2:
                this.rootDragAndDropNode.onMoved(dragAndDropEvent2);
                break;
            case 3:
                acceptDragAndDropTransfer = this.rootDragAndDropNode.onDrop(dragAndDropEvent2);
                break;
            case 4:
                this.rootDragAndDropNode.onEnded(dragAndDropEvent2);
                break;
            case 5:
                this.rootDragAndDropNode.onEntered(dragAndDropEvent2);
                break;
            case 6:
                this.rootDragAndDropNode.onExited(dragAndDropEvent2);
                break;
            default:
        }
        return acceptDragAndDropTransfer;
    }

    @Override // android.view.View$OnDragListener
    public void registerNodeInterest(DragAndDropModifierNode node) {
        this.interestedNodes.add(node);
    }
}
