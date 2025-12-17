package androidx.compose.foundation.content.internal;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ContextWrapper;
import android.net.Uri;
import android.view.DragEvent;
import android.view.View;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.draganddrop.DragAndDropEvent;
import androidx.compose.ui.draganddrop.DragAndDrop_androidKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import androidx.core.view.DragAndDropPermissionsCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u000c\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0002\u001a\u0014\u0010\u0007\u001a\u00020\u0008*\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000¨\u0006\u000c", d2 = {"tryGetActivity", "Landroid/app/Activity;", "view", "Landroid/view/View;", "containsContentUri", "", "Landroid/content/ClipData;", "dragAndDropRequestPermission", "", "Landroidx/compose/ui/node/DelegatableNode;", "event", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DragAndDropRequestPermission_androidKt {
    private static final boolean containsContentUri(ClipData $this$containsContentUri) {
        int i;
        Uri uri;
        boolean equal;
        String str;
        i = 0;
        while (i < $this$containsContentUri.getItemCount()) {
            uri = $this$containsContentUri.getItemAt(i).getUri();
            i++;
        }
        return 0;
    }

    public static final void dragAndDropRequestPermission(DelegatableNode $this$dragAndDropRequestPermission, DragAndDropEvent event) {
        boolean requireView;
        Activity tryGetActivity;
        DragEvent androidDragEvent;
        if (!DragAndDropRequestPermission_androidKt.containsContentUri(DragAndDrop_androidKt.toAndroidDragEvent(event).getClipData())) {
        }
        tryGetActivity = DragAndDropRequestPermission_androidKt.tryGetActivity(DelegatableNode_androidKt.requireView($this$dragAndDropRequestPermission));
        if ($this$dragAndDropRequestPermission.getNode().isAttached() && tryGetActivity == null) {
            tryGetActivity = DragAndDropRequestPermission_androidKt.tryGetActivity(DelegatableNode_androidKt.requireView($this$dragAndDropRequestPermission));
            if (tryGetActivity == null) {
            }
            DragAndDropPermissionsCompat.request(tryGetActivity, DragAndDrop_androidKt.toAndroidDragEvent(event));
        }
    }

    private static final Activity tryGetActivity(View view) {
        android.content.Context context;
        android.content.Context context2;
        context = view.getContext();
        while (context instanceof ContextWrapper) {
            context = (ContextWrapper)context.getBaseContext();
        }
        return null;
    }
}
