package androidx.compose.ui.draganddrop;

import android.content.ClipDescription;
import android.view.DragEvent;
import androidx.compose.ui.geometry.OffsetKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006*\u00020\u0002\u001a\n\u0010\u0008\u001a\u00020\t*\u00020\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004¨\u0006\n", d2 = {"positionInRoot", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "getPositionInRoot", "(Landroidx/compose/ui/draganddrop/DragAndDropEvent;)J", "mimeTypes", "", "", "toAndroidDragEvent", "Landroid/view/DragEvent;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DragAndDrop_androidKt {
    public static final long getPositionInRoot(androidx.compose.ui.draganddrop.DragAndDropEvent $this$positionInRoot) {
        return OffsetKt.Offset($this$positionInRoot.getDragEvent$ui_release().getX(), $this$positionInRoot.getDragEvent$ui_release().getY());
    }

    public static final Set<String> mimeTypes(androidx.compose.ui.draganddrop.DragAndDropEvent $this$mimeTypes) {
        int i;
        String mimeType;
        ClipDescription clipDescription = $this$mimeTypes.getDragEvent$ui_release().getClipDescription();
        if (clipDescription == null) {
            return SetsKt.emptySet();
        }
        Set setBuilder = SetsKt.createSetBuilder(clipDescription.getMimeTypeCount());
        final int i2 = 0;
        i = 0;
        while (i < clipDescription.getMimeTypeCount()) {
            setBuilder.add(clipDescription.getMimeType(i));
            i++;
        }
        return SetsKt.build(setBuilder);
    }

    public static final DragEvent toAndroidDragEvent(androidx.compose.ui.draganddrop.DragAndDropEvent $this$toAndroidDragEvent) {
        return $this$toAndroidDragEvent.getDragEvent$ui_release();
    }
}
