package androidx.compose.foundation.content.internal;

import android.view.DragEvent;
import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.foundation.content.TransferableContent.Source;
import androidx.compose.foundation.content.TransferableContent.Source.Companion;
import androidx.compose.ui.draganddrop.DragAndDropEvent;
import androidx.compose.ui.draganddrop.DragAndDropModifierNode;
import androidx.compose.ui.draganddrop.DragAndDropNodeKt;
import androidx.compose.ui.draganddrop.DragAndDrop_androidKt;
import androidx.compose.ui.platform.AndroidClipboardManager_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0000\u001a\u000c\u0010\u0008\u001a\u00020\t*\u00020\u0006H\u0000¨\u0006\n", d2 = {"ReceiveContentDragAndDropNode", "Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "receiveContentConfiguration", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "dragAndDropRequestPermission", "Lkotlin/Function1;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "", "toTransferableContent", "Landroidx/compose/foundation/content/TransferableContent;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ReceiveContentDragAndDropNode_androidKt {
    public static final DragAndDropModifierNode ReceiveContentDragAndDropNode(androidx.compose.foundation.content.internal.ReceiveContentConfiguration receiveContentConfiguration, Function1<? super DragAndDropEvent, Unit> dragAndDropRequestPermission) {
        ReceiveContentDragAndDropNode_androidKt.ReceiveContentDragAndDropNode.2 anon = new ReceiveContentDragAndDropNode_androidKt.ReceiveContentDragAndDropNode.2(receiveContentConfiguration, dragAndDropRequestPermission);
        return DragAndDropNodeKt.DragAndDropModifierNode((Function1)ReceiveContentDragAndDropNode_androidKt.ReceiveContentDragAndDropNode.1.INSTANCE, (DragAndDropTarget)anon);
    }

    public static final TransferableContent toTransferableContent(DragAndDropEvent $this$toTransferableContent) {
        final DragEvent androidDragEvent = DragAndDrop_androidKt.toAndroidDragEvent($this$toTransferableContent);
        final int i = 0;
        TransferableContent transferableContent = new TransferableContent(AndroidClipboardManager_androidKt.toClipEntry(androidDragEvent.getClipData()), AndroidClipboardManager_androidKt.toClipMetadata(androidDragEvent.getClipDescription()), TransferableContent.Source.Companion.getDragAndDrop-kB6V9T0(), 0, 8, 0);
        return transferableContent;
    }
}
