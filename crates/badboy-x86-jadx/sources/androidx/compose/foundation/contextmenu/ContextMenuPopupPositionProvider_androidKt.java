package androidx.compose.foundation.contextmenu;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0008\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a*\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005H\u0001\u001a \u0010\u0008\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a \u0010\t\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a \u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a(\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a(\u0010\u000c\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\r", d2 = {"alignEndEdges", "", "popupLength", "windowLength", "closeAffinity", "", "alignPopupAxis", "position", "alignPopupEndEdgeToPosition", "alignPopupStartEdgeToPosition", "alignStartEdges", "popupFitsBetweenPositionAndEndEdge", "popupFitsBetweenPositionAndStartEdge", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ContextMenuPopupPositionProvider_androidKt {
    private static final int alignEndEdges(int popupLength, int windowLength, boolean closeAffinity) {
        return ContextMenuPopupPositionProvider_androidKt.alignStartEdges(popupLength, windowLength, closeAffinity ^ 1);
    }

    public static final int alignPopupAxis(int position, int popupLength, int windowLength, boolean closeAffinity) {
        int alignPopupStartEdgeToPosition;
        if (popupLength >= windowLength) {
            alignPopupStartEdgeToPosition = ContextMenuPopupPositionProvider_androidKt.alignStartEdges(popupLength, windowLength, closeAffinity);
        } else {
            if (ContextMenuPopupPositionProvider_androidKt.popupFitsBetweenPositionAndEndEdge(position, popupLength, windowLength, closeAffinity)) {
                alignPopupStartEdgeToPosition = ContextMenuPopupPositionProvider_androidKt.alignPopupStartEdgeToPosition(position, popupLength, closeAffinity);
            } else {
                if (ContextMenuPopupPositionProvider_androidKt.popupFitsBetweenPositionAndStartEdge(position, popupLength, windowLength, closeAffinity)) {
                    alignPopupStartEdgeToPosition = ContextMenuPopupPositionProvider_androidKt.alignPopupEndEdgeToPosition(position, popupLength, closeAffinity);
                } else {
                    alignPopupStartEdgeToPosition = ContextMenuPopupPositionProvider_androidKt.alignEndEdges(popupLength, windowLength, closeAffinity);
                }
            }
        }
        return alignPopupStartEdgeToPosition;
    }

    public static int alignPopupAxis$default(int i, int i2, int i3, boolean z4, int i5, Object object6) {
        int obj3;
        if (i5 &= 8 != 0) {
            obj3 = 1;
        }
        return ContextMenuPopupPositionProvider_androidKt.alignPopupAxis(i, i2, i3, obj3);
    }

    private static final int alignPopupEndEdgeToPosition(int position, int popupLength, boolean closeAffinity) {
        return ContextMenuPopupPositionProvider_androidKt.alignPopupStartEdgeToPosition(position, popupLength, closeAffinity ^ 1);
    }

    private static final int alignPopupStartEdgeToPosition(int position, int popupLength, boolean closeAffinity) {
        int i;
        i = closeAffinity ? position : position - popupLength;
        return i;
    }

    private static final int alignStartEdges(int popupLength, int windowLength, boolean closeAffinity) {
        int i;
        i = closeAffinity ? 0 : windowLength - popupLength;
        return i;
    }

    private static final boolean popupFitsBetweenPositionAndEndEdge(int position, int popupLength, int windowLength, boolean closeAffinity) {
        return ContextMenuPopupPositionProvider_androidKt.popupFitsBetweenPositionAndStartEdge(position, popupLength, windowLength, closeAffinity ^ 1);
    }

    private static final boolean popupFitsBetweenPositionAndStartEdge(int position, int popupLength, int windowLength, boolean closeAffinity) {
        int i;
        int i2;
        i = 1;
        final int i3 = 0;
        if (closeAffinity) {
            if (popupLength <= position) {
            } else {
                i = i3;
            }
        } else {
            if (windowLength - popupLength > position) {
            } else {
                i = i3;
            }
        }
        return i;
    }
}
