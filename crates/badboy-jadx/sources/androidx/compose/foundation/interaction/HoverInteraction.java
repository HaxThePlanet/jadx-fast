package androidx.compose.foundation.interaction;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0004À\u0006\u0001", d2 = {"Landroidx/compose/foundation/interaction/HoverInteraction;", "Landroidx/compose/foundation/interaction/Interaction;", "Enter", "Exit", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface HoverInteraction extends androidx.compose.foundation.interaction.Interaction {

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"Landroidx/compose/foundation/interaction/HoverInteraction$Enter;", "Landroidx/compose/foundation/interaction/HoverInteraction;", "()V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Enter implements androidx.compose.foundation.interaction.HoverInteraction {

        public static final int $stable;
        static {
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/foundation/interaction/HoverInteraction$Exit;", "Landroidx/compose/foundation/interaction/HoverInteraction;", "enter", "Landroidx/compose/foundation/interaction/HoverInteraction$Enter;", "(Landroidx/compose/foundation/interaction/HoverInteraction$Enter;)V", "getEnter", "()Landroidx/compose/foundation/interaction/HoverInteraction$Enter;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Exit implements androidx.compose.foundation.interaction.HoverInteraction {

        public static final int $stable;
        private final androidx.compose.foundation.interaction.HoverInteraction.Enter enter;
        static {
        }

        public Exit(androidx.compose.foundation.interaction.HoverInteraction.Enter enter) {
            super();
            this.enter = enter;
        }

        @Override // androidx.compose.foundation.interaction.HoverInteraction
        public final androidx.compose.foundation.interaction.HoverInteraction.Enter getEnter() {
            return this.enter;
        }
    }
}
