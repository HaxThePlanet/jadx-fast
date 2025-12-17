package androidx.compose.ui.draganddrop;

import android.content.ClipData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0008\u0008\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u000e", d2 = {"Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "", "clipData", "Landroid/content/ClipData;", "localState", "flags", "", "(Landroid/content/ClipData;Ljava/lang/Object;I)V", "getClipData", "()Landroid/content/ClipData;", "getFlags", "()I", "getLocalState", "()Ljava/lang/Object;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DragAndDropTransferData {

    public static final int $stable = 8;
    private final ClipData clipData;
    private final int flags;
    private final Object localState;
    static {
        final int i = 8;
    }

    public DragAndDropTransferData(ClipData clipData, Object localState, int flags) {
        super();
        this.clipData = clipData;
        this.localState = localState;
        this.flags = flags;
    }

    public DragAndDropTransferData(ClipData clipData, Object object2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        int obj2;
        int obj3;
        obj2 = i4 & 2 != 0 ? 0 : obj2;
        obj3 = i4 &= 4 != 0 ? 0 : obj3;
        super(clipData, obj2, obj3);
    }

    public final ClipData getClipData() {
        return this.clipData;
    }

    public final int getFlags() {
        return this.flags;
    }

    public final Object getLocalState() {
        return this.localState;
    }
}
