package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.content.MediaType;
import androidx.compose.ui.draganddrop.DragAndDropEvent;
import androidx.compose.ui.draganddrop.DragAndDropModifierNode;
import androidx.compose.ui.draganddrop.DragAndDropNodeKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.ClipMetadata;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001aÒ\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050\u00040\u000326\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\u0008¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000b\u0012\u0013\u0012\u00110\u000c¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\r\u0012\u0004\u0012\u00020\u000e0\u00072\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102%\u0008\u0002\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u0014\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00102%\u0008\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u0014\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00102%\u0008\u0002\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110\u0017¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u0018\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00102%\u0008\u0002\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u0014\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00102%\u0008\u0002\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u0014\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00102%\u0008\u0002\u0010\u001b\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u0014\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010H\u0000¨\u0006\u001c", d2 = {"textFieldDragAndDropNode", "Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "hintMediaTypes", "Lkotlin/Function0;", "", "Landroidx/compose/foundation/content/MediaType;", "onDrop", "Lkotlin/Function2;", "Landroidx/compose/ui/platform/ClipEntry;", "Lkotlin/ParameterName;", "name", "clipEntry", "Landroidx/compose/ui/platform/ClipMetadata;", "clipMetadata", "", "dragAndDropRequestPermission", "Lkotlin/Function1;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "", "onStarted", "event", "onEntered", "onMoved", "Landroidx/compose/ui/geometry/Offset;", "position", "onChanged", "onExited", "onEnded", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextFieldDragAndDropNode_androidKt {
    public static final DragAndDropModifierNode textFieldDragAndDropNode(Function0<? extends Set<MediaType>> hintMediaTypes, Function2<? super ClipEntry, ? super ClipMetadata, Boolean> onDrop, Function1<? super DragAndDropEvent, Unit> dragAndDropRequestPermission, Function1<? super DragAndDropEvent, Unit> onStarted, Function1<? super DragAndDropEvent, Unit> onEntered, Function1<? super Offset, Unit> onMoved, Function1<? super DragAndDropEvent, Unit> onChanged, Function1<? super DragAndDropEvent, Unit> onExited, Function1<? super DragAndDropEvent, Unit> onEnded) {
        TextFieldDragAndDropNode_androidKt.textFieldDragAndDropNode.1 anon = new TextFieldDragAndDropNode_androidKt.textFieldDragAndDropNode.1(hintMediaTypes);
        TextFieldDragAndDropNode_androidKt.textFieldDragAndDropNode.2 anon2 = new TextFieldDragAndDropNode_androidKt.textFieldDragAndDropNode.2(dragAndDropRequestPermission, onDrop, onStarted, onEntered, onMoved, onExited, onChanged, onEnded);
        return DragAndDropNodeKt.DragAndDropModifierNode((Function1)anon, (DragAndDropTarget)anon2);
    }

    public static DragAndDropModifierNode textFieldDragAndDropNode$default(Function0 function0, Function2 function22, Function1 function13, Function1 function14, Function1 function15, Function1 function16, Function1 function17, Function1 function18, Function1 function19, int i10, Object object11) {
        int obj4;
        int obj5;
        int obj6;
        int obj7;
        int obj8;
        int obj9;
        final int i = 0;
        if (i10 & 8 != 0) {
            obj4 = i;
        }
        if (i10 & 16 != 0) {
            obj5 = i;
        }
        if (i10 & 32 != 0) {
            obj6 = i;
        }
        if (i10 & 64 != 0) {
            obj7 = i;
        }
        if (i10 & 128 != 0) {
            obj8 = i;
        }
        if (i10 &= 256 != 0) {
            obj9 = i;
        }
        return TextFieldDragAndDropNode_androidKt.textFieldDragAndDropNode(function0, function22, function13, obj4, obj5, obj6, obj7, obj8, obj9);
    }
}
