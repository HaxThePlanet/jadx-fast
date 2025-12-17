package androidx.compose.foundation.interaction;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008f\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0005À\u0006\u0001", d2 = {"Landroidx/compose/foundation/interaction/DragInteraction;", "Landroidx/compose/foundation/interaction/Interaction;", "Cancel", "Start", "Stop", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface DragInteraction extends androidx.compose.foundation.interaction.Interaction {

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/foundation/interaction/DragInteraction$Cancel;", "Landroidx/compose/foundation/interaction/DragInteraction;", "start", "Landroidx/compose/foundation/interaction/DragInteraction$Start;", "(Landroidx/compose/foundation/interaction/DragInteraction$Start;)V", "getStart", "()Landroidx/compose/foundation/interaction/DragInteraction$Start;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Cancel implements androidx.compose.foundation.interaction.DragInteraction {

        public static final int $stable;
        private final androidx.compose.foundation.interaction.DragInteraction.Start start;
        static {
        }

        public Cancel(androidx.compose.foundation.interaction.DragInteraction.Start start) {
            super();
            this.start = start;
        }

        @Override // androidx.compose.foundation.interaction.DragInteraction
        public final androidx.compose.foundation.interaction.DragInteraction.Start getStart() {
            return this.start;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"Landroidx/compose/foundation/interaction/DragInteraction$Start;", "Landroidx/compose/foundation/interaction/DragInteraction;", "()V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Start implements androidx.compose.foundation.interaction.DragInteraction {

        public static final int $stable;
        static {
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/foundation/interaction/DragInteraction$Stop;", "Landroidx/compose/foundation/interaction/DragInteraction;", "start", "Landroidx/compose/foundation/interaction/DragInteraction$Start;", "(Landroidx/compose/foundation/interaction/DragInteraction$Start;)V", "getStart", "()Landroidx/compose/foundation/interaction/DragInteraction$Start;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Stop implements androidx.compose.foundation.interaction.DragInteraction {

        public static final int $stable;
        private final androidx.compose.foundation.interaction.DragInteraction.Start start;
        static {
        }

        public Stop(androidx.compose.foundation.interaction.DragInteraction.Start start) {
            super();
            this.start = start;
        }

        @Override // androidx.compose.foundation.interaction.DragInteraction
        public final androidx.compose.foundation.interaction.DragInteraction.Start getStart() {
            return this.start;
        }
    }
}
