package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.Rect;
import java.util.Set;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008f\u0018\u00002\u00020\u0001J\u0011\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0010H¦\u0002J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u0003H&J\"\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u001fH&ø\u0001\u0000¢\u0006\u0004\u0008!\u0010\"J.\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u00002\u0008\u0008\u0002\u0010 \u001a\u00020\u001f2\u0008\u0008\u0002\u0010#\u001a\u00020\u0003H\u0016ø\u0001\u0000¢\u0006\u0004\u0008$\u0010%J\u001a\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u001fH&ø\u0001\u0000¢\u0006\u0004\u0008(\u0010)J\u001a\u0010*\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\u0008+\u0010)J\u001a\u0010,\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u001fH&ø\u0001\u0000¢\u0006\u0004\u0008-\u0010)J\u001a\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\u00080\u0010)J\"\u00101\u001a\u0002022\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u00103\u001a\u000204H\u0016ø\u0001\u0000¢\u0006\u0004\u00085\u00106J\u001a\u00107\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016ø\u0001\u0000¢\u0006\u0004\u00088\u00109J\u001a\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\u001fH&ø\u0001\u0000¢\u0006\u0004\u0008<\u0010)R\u001a\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u000c\u0012\u0004\u0008\u0004\u0010\u0005\u001a\u0004\u0008\u0006\u0010\u0007R\u0012\u0010\u0008\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\u0007R\u0014\u0010\t\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0014\u0010\u000c\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000bR\u0018\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u00020\u0014X¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0016ø\u0001\u0002\u0082\u0002\u0011\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!\n\u0004\u0008!0\u0001¨\u0006=À\u0006\u0003", d2 = {"Landroidx/compose/ui/layout/LayoutCoordinates;", "", "introducesMotionFrameOfReference", "", "getIntroducesMotionFrameOfReference$annotations", "()V", "getIntroducesMotionFrameOfReference", "()Z", "isAttached", "parentCoordinates", "getParentCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "providedAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getProvidedAlignmentLines", "()Ljava/util/Set;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "get", "", "alignmentLine", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "clipBounds", "localPositionOf", "Landroidx/compose/ui/geometry/Offset;", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "includeMotionFrameOfReference", "localPositionOf-S_NoaFU", "(Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "(J)J", "localToScreen", "localToScreen-MK-Hz9U", "localToWindow", "localToWindow-MK-Hz9U", "screenToLocal", "relativeToScreen", "screenToLocal-MK-Hz9U", "transformFrom", "", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformToScreen", "transformToScreen-58bKbWc", "([F)V", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface LayoutCoordinates {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean getIntroducesMotionFrameOfReference(androidx.compose.ui.layout.LayoutCoordinates $this) {
            return LayoutCoordinates.access$getIntroducesMotionFrameOfReference$jd($this);
        }

        public static void getIntroducesMotionFrameOfReference$annotations() {
        }

        public static Rect localBoundingBoxOf$default(androidx.compose.ui.layout.LayoutCoordinates layoutCoordinates, androidx.compose.ui.layout.LayoutCoordinates layoutCoordinates2, boolean z3, int i4, Object object5) {
            return LayoutCoordinates.localBoundingBoxOf$default(layoutCoordinates, layoutCoordinates2, z3, i4, object5);
        }

        @Deprecated
        public static long localPositionOf-S_NoaFU(androidx.compose.ui.layout.LayoutCoordinates $this, androidx.compose.ui.layout.LayoutCoordinates sourceCoordinates, long relativeToSource, boolean includeMotionFrameOfReference) {
            return LayoutCoordinates.access$localPositionOf-S_NoaFU$jd($this, sourceCoordinates, relativeToSource, includeMotionFrameOfReference);
        }

        public static long localPositionOf-S_NoaFU$default(androidx.compose.ui.layout.LayoutCoordinates layoutCoordinates, androidx.compose.ui.layout.LayoutCoordinates layoutCoordinates2, long l3, boolean z4, int i5, Object object6) {
            return LayoutCoordinates.localPositionOf-S_NoaFU$default(layoutCoordinates, layoutCoordinates2, l3, z4, i5, object6);
        }

        @Deprecated
        public static long localToScreen-MK-Hz9U(androidx.compose.ui.layout.LayoutCoordinates $this, long relativeToLocal) {
            return LayoutCoordinates.access$localToScreen-MK-Hz9U$jd($this, relativeToLocal);
        }

        @Deprecated
        public static long screenToLocal-MK-Hz9U(androidx.compose.ui.layout.LayoutCoordinates $this, long relativeToScreen) {
            return LayoutCoordinates.access$screenToLocal-MK-Hz9U$jd($this, relativeToScreen);
        }

        @Deprecated
        public static void transformFrom-EL8BTi8(androidx.compose.ui.layout.LayoutCoordinates $this, androidx.compose.ui.layout.LayoutCoordinates sourceCoordinates, float[] matrix) {
            LayoutCoordinates.access$transformFrom-EL8BTi8$jd($this, sourceCoordinates, matrix);
        }

        @Deprecated
        public static void transformToScreen-58bKbWc(androidx.compose.ui.layout.LayoutCoordinates $this, float[] matrix) {
            LayoutCoordinates.access$transformToScreen-58bKbWc$jd($this, matrix);
        }
    }
    public static boolean access$getIntroducesMotionFrameOfReference$jd(androidx.compose.ui.layout.LayoutCoordinates $this) {
        return super.getIntroducesMotionFrameOfReference();
    }

    public static long access$localPositionOf-S_NoaFU$jd(androidx.compose.ui.layout.LayoutCoordinates $this, androidx.compose.ui.layout.LayoutCoordinates sourceCoordinates, long relativeToSource, boolean includeMotionFrameOfReference) {
        return super.localPositionOf-S_NoaFU(sourceCoordinates, relativeToSource, includeMotionFrameOfReference);
    }

    public static long access$localToScreen-MK-Hz9U$jd(androidx.compose.ui.layout.LayoutCoordinates $this, long relativeToLocal) {
        return super.localToScreen-MK-Hz9U(relativeToLocal);
    }

    public static long access$screenToLocal-MK-Hz9U$jd(androidx.compose.ui.layout.LayoutCoordinates $this, long relativeToScreen) {
        return super.screenToLocal-MK-Hz9U(relativeToScreen);
    }

    public static void access$transformFrom-EL8BTi8$jd(androidx.compose.ui.layout.LayoutCoordinates $this, androidx.compose.ui.layout.LayoutCoordinates sourceCoordinates, float[] matrix) {
        super.transformFrom-EL8BTi8(sourceCoordinates, matrix);
    }

    public static void access$transformToScreen-58bKbWc$jd(androidx.compose.ui.layout.LayoutCoordinates $this, float[] matrix) {
        super.transformToScreen-58bKbWc(matrix);
    }

    public static Rect localBoundingBoxOf$default(androidx.compose.ui.layout.LayoutCoordinates layoutCoordinates, androidx.compose.ui.layout.LayoutCoordinates layoutCoordinates2, boolean z3, int i4, Object object5) {
        int obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 2 != 0) {
                obj2 = 1;
            }
            return layoutCoordinates.localBoundingBoxOf(layoutCoordinates2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: localBoundingBoxOf");
        throw obj0;
    }

    public static long localPositionOf-S_NoaFU$default(androidx.compose.ui.layout.LayoutCoordinates layoutCoordinates, androidx.compose.ui.layout.LayoutCoordinates layoutCoordinates2, long l3, boolean z4, int i5, Object object6) {
        long obj2;
        int obj4;
        if (obj6 != null) {
        } else {
            if (object6 & 2 != 0) {
                obj2 = Offset.Companion.getZero-F1C5BW0();
            }
            if (object6 &= 4 != 0) {
                obj4 = 1;
            }
            return layoutCoordinates.localPositionOf-S_NoaFU(layoutCoordinates2, obj2, z4);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: localPositionOf-S_NoaFU");
        throw obj0;
    }

    public abstract int get(androidx.compose.ui.layout.AlignmentLine alignmentLine);

    public boolean getIntroducesMotionFrameOfReference() {
        return 0;
    }

    public abstract androidx.compose.ui.layout.LayoutCoordinates getParentCoordinates();

    public abstract androidx.compose.ui.layout.LayoutCoordinates getParentLayoutCoordinates();

    public abstract Set<androidx.compose.ui.layout.AlignmentLine> getProvidedAlignmentLines();

    public abstract long getSize-YbymL2g();

    public abstract boolean isAttached();

    public abstract Rect localBoundingBoxOf(androidx.compose.ui.layout.LayoutCoordinates layoutCoordinates, boolean z2);

    public abstract long localPositionOf-R5De75A(androidx.compose.ui.layout.LayoutCoordinates layoutCoordinates, long l2);

    public long localPositionOf-S_NoaFU(androidx.compose.ui.layout.LayoutCoordinates sourceCoordinates, long relativeToSource, boolean includeMotionFrameOfReference) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("localPositionOf is not implemented on this LayoutCoordinates");
        throw unsupportedOperationException;
    }

    public abstract long localToRoot-MK-Hz9U(long l);

    public long localToScreen-MK-Hz9U(long relativeToLocal) {
        return Offset.Companion.getUnspecified-F1C5BW0();
    }

    public abstract long localToWindow-MK-Hz9U(long l);

    public long screenToLocal-MK-Hz9U(long relativeToScreen) {
        return Offset.Companion.getUnspecified-F1C5BW0();
    }

    public void transformFrom-EL8BTi8(androidx.compose.ui.layout.LayoutCoordinates sourceCoordinates, float[] matrix) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("transformFrom is not implemented on this LayoutCoordinates");
        throw unsupportedOperationException;
    }

    public void transformToScreen-58bKbWc(float[] matrix) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("transformToScreen is not implemented on this LayoutCoordinates");
        throw unsupportedOperationException;
    }

    public abstract long windowToLocal-MK-Hz9U(long l);
}
