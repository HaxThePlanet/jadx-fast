package androidx.compose.material3.internal;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\u0008`\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0007À\u0006\u0001", d2 = {"Landroidx/compose/material3/internal/AnchoredDragScope;", "", "dragTo", "", "newOffset", "", "lastKnownVelocity", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface AnchoredDragScope {
    public static void dragTo$default(androidx.compose.material3.internal.AnchoredDragScope anchoredDragScope, float f2, float f3, int i4, Object object5) {
        int obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 2 != 0) {
                obj2 = 0;
            }
            anchoredDragScope.dragTo(f2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dragTo");
        throw obj0;
    }

    public abstract void dragTo(float f, float f2);
}
