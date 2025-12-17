package androidx.compose.foundation.interaction;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008f\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0005À\u0006\u0001", d2 = {"Landroidx/compose/foundation/interaction/PressInteraction;", "Landroidx/compose/foundation/interaction/Interaction;", "Cancel", "Press", "Release", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PressInteraction extends androidx.compose.foundation.interaction.Interaction {

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/foundation/interaction/PressInteraction$Cancel;", "Landroidx/compose/foundation/interaction/PressInteraction;", "press", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;)V", "getPress", "()Landroidx/compose/foundation/interaction/PressInteraction$Press;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Cancel implements androidx.compose.foundation.interaction.PressInteraction {

        public static final int $stable;
        private final androidx.compose.foundation.interaction.PressInteraction.Press press;
        static {
        }

        public Cancel(androidx.compose.foundation.interaction.PressInteraction.Press press) {
            super();
            this.press = press;
        }

        @Override // androidx.compose.foundation.interaction.PressInteraction
        public final androidx.compose.foundation.interaction.PressInteraction.Press getPress() {
            return this.press;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0008", d2 = {"Landroidx/compose/foundation/interaction/PressInteraction$Press;", "Landroidx/compose/foundation/interaction/PressInteraction;", "pressPosition", "Landroidx/compose/ui/geometry/Offset;", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPressPosition-F1C5BW0", "()J", "J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Press implements androidx.compose.foundation.interaction.PressInteraction {

        public static final int $stable;
        private final long pressPosition;
        static {
        }

        private Press(long pressPosition) {
            super();
            this.pressPosition = pressPosition;
        }

        public Press(long l, DefaultConstructorMarker defaultConstructorMarker2) {
            super(l, defaultConstructorMarker2);
        }

        @Override // androidx.compose.foundation.interaction.PressInteraction
        public final long getPressPosition-F1C5BW0() {
            return this.pressPosition;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/foundation/interaction/PressInteraction$Release;", "Landroidx/compose/foundation/interaction/PressInteraction;", "press", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;)V", "getPress", "()Landroidx/compose/foundation/interaction/PressInteraction$Press;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Release implements androidx.compose.foundation.interaction.PressInteraction {

        public static final int $stable;
        private final androidx.compose.foundation.interaction.PressInteraction.Press press;
        static {
        }

        public Release(androidx.compose.foundation.interaction.PressInteraction.Press press) {
            super();
            this.press = press;
        }

        @Override // androidx.compose.foundation.interaction.PressInteraction
        public final androidx.compose.foundation.interaction.PressInteraction.Press getPress() {
            return this.press;
        }
    }
}
