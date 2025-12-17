package androidx.compose.foundation.content;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008ç\u0080\u0001\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016J\u0008\u0010\u0004\u001a\u00020\u0003H\u0016J\u0008\u0010\u0005\u001a\u00020\u0003H\u0016J\u0008\u0010\u0006\u001a\u00020\u0003H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0006\u0010\t\u001a\u00020\u0008H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\nÀ\u0006\u0001", d2 = {"Landroidx/compose/foundation/content/ReceiveContentListener;", "", "onDragEnd", "", "onDragEnter", "onDragExit", "onDragStart", "onReceive", "Landroidx/compose/foundation/content/TransferableContent;", "transferableContent", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ReceiveContentListener {
    public void onDragEnd() {
    }

    public void onDragEnter() {
    }

    public void onDragExit() {
    }

    public void onDragStart() {
    }

    public abstract androidx.compose.foundation.content.TransferableContent onReceive(androidx.compose.foundation.content.TransferableContent transferableContent);
}
