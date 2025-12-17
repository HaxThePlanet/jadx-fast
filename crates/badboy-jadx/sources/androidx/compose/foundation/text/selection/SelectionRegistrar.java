package androidx.compose.foundation.text.selection;

import androidx.collection.LongObjectMap;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008`\u0018\u0000 $2\u00020\u0001:\u0001$J\u0008\u0010\u0007\u001a\u00020\u0008H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0008H&J\u0010\u0010\u000c\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0008H&JB\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH&ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019J\u0008\u0010\u001a\u001a\u00020\nH&J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00082\u0006\u0010\u0017\u001a\u00020\u000eH&J2\u0010\u001c\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH&ø\u0001\u0000¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H&J\u0010\u0010#\u001a\u00020\n2\u0006\u0010\"\u001a\u00020!H&R\u0018\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006ø\u0001\u0001\u0082\u0002\r\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u0006%À\u0006\u0001", d2 = {"Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "", "subselections", "Landroidx/collection/LongObjectMap;", "Landroidx/compose/foundation/text/selection/Selection;", "getSubselections", "()Landroidx/collection/LongObjectMap;", "nextSelectableId", "", "notifyPositionChange", "", "selectableId", "notifySelectableChange", "notifySelectionUpdate", "", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "newPosition", "Landroidx/compose/ui/geometry/Offset;", "previousPosition", "isStartHandle", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "isInTouchMode", "notifySelectionUpdate-njBpvok", "(Landroidx/compose/ui/layout/LayoutCoordinates;JJZLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)Z", "notifySelectionUpdateEnd", "notifySelectionUpdateSelectAll", "notifySelectionUpdateStart", "startPosition", "notifySelectionUpdateStart-ubNVwUQ", "(Landroidx/compose/ui/layout/LayoutCoordinates;JLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)V", "subscribe", "Landroidx/compose/foundation/text/selection/Selectable;", "selectable", "unsubscribe", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SelectionRegistrar {

    public static final androidx.compose.foundation.text.selection.SelectionRegistrar.Companion Companion;
    public static final long InvalidSelectableId;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Landroidx/compose/foundation/text/selection/SelectionRegistrar$Companion;", "", "()V", "InvalidSelectableId", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final androidx.compose.foundation.text.selection.SelectionRegistrar.Companion $$INSTANCE;
        public static final long InvalidSelectableId;
        static {
            SelectionRegistrar.Companion companion = new SelectionRegistrar.Companion();
            SelectionRegistrar.Companion.$$INSTANCE = companion;
        }
    }
    static {
        SelectionRegistrar.Companion = SelectionRegistrar.Companion.$$INSTANCE;
    }

    public abstract LongObjectMap<androidx.compose.foundation.text.selection.Selection> getSubselections();

    public abstract long nextSelectableId();

    public abstract void notifyPositionChange(long l);

    public abstract void notifySelectableChange(long l);

    public abstract boolean notifySelectionUpdate-njBpvok(LayoutCoordinates layoutCoordinates, long l2, long l3, boolean z4, androidx.compose.foundation.text.selection.SelectionAdjustment selectionAdjustment5, boolean z6);

    public abstract void notifySelectionUpdateEnd();

    public abstract void notifySelectionUpdateSelectAll(long l, boolean z2);

    public abstract void notifySelectionUpdateStart-ubNVwUQ(LayoutCoordinates layoutCoordinates, long l2, androidx.compose.foundation.text.selection.SelectionAdjustment selectionAdjustment3, boolean z4);

    public abstract androidx.compose.foundation.text.selection.Selectable subscribe(androidx.compose.foundation.text.selection.Selectable selectable);

    public abstract void unsubscribe(androidx.compose.foundation.text.selection.Selectable selectable);
}
