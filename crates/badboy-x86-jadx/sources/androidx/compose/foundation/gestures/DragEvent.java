package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00080\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\u0008\t\n¨\u0006\u000b", d2 = {"Landroidx/compose/foundation/gestures/DragEvent;", "", "()V", "DragCancelled", "DragDelta", "DragStarted", "DragStopped", "Landroidx/compose/foundation/gestures/DragEvent$DragCancelled;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Landroidx/compose/foundation/gestures/DragEvent$DragStarted;", "Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class DragEvent {

    public static final int $stable;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"Landroidx/compose/foundation/gestures/DragEvent$DragCancelled;", "Landroidx/compose/foundation/gestures/DragEvent;", "()V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class DragCancelled extends androidx.compose.foundation.gestures.DragEvent {

        public static final int $stable;
        public static final androidx.compose.foundation.gestures.DragEvent.DragCancelled INSTANCE;
        static {
            DragEvent.DragCancelled dragCancelled = new DragEvent.DragCancelled();
            DragEvent.DragCancelled.INSTANCE = dragCancelled;
        }

        private DragCancelled() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0008", d2 = {"Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Landroidx/compose/foundation/gestures/DragEvent;", "delta", "Landroidx/compose/ui/geometry/Offset;", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDelta-F1C5BW0", "()J", "J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class DragDelta extends androidx.compose.foundation.gestures.DragEvent {

        public static final int $stable;
        private final long delta;
        static {
        }

        private DragDelta(long delta) {
            super(0);
            this.delta = delta;
        }

        public DragDelta(long l, DefaultConstructorMarker defaultConstructorMarker2) {
            super(l, defaultConstructorMarker2);
        }

        @Override // androidx.compose.foundation.gestures.DragEvent
        public final long getDelta-F1C5BW0() {
            return this.delta;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0008", d2 = {"Landroidx/compose/foundation/gestures/DragEvent$DragStarted;", "Landroidx/compose/foundation/gestures/DragEvent;", "startPoint", "Landroidx/compose/ui/geometry/Offset;", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStartPoint-F1C5BW0", "()J", "J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class DragStarted extends androidx.compose.foundation.gestures.DragEvent {

        public static final int $stable;
        private final long startPoint;
        static {
        }

        private DragStarted(long startPoint) {
            super(0);
            this.startPoint = startPoint;
        }

        public DragStarted(long l, DefaultConstructorMarker defaultConstructorMarker2) {
            super(l, defaultConstructorMarker2);
        }

        @Override // androidx.compose.foundation.gestures.DragEvent
        public final long getStartPoint-F1C5BW0() {
            return this.startPoint;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0008", d2 = {"Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "Landroidx/compose/foundation/gestures/DragEvent;", "velocity", "Landroidx/compose/ui/unit/Velocity;", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getVelocity-9UxMQ8M", "()J", "J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class DragStopped extends androidx.compose.foundation.gestures.DragEvent {

        public static final int $stable;
        private final long velocity;
        static {
        }

        private DragStopped(long velocity) {
            super(0);
            this.velocity = velocity;
        }

        public DragStopped(long l, DefaultConstructorMarker defaultConstructorMarker2) {
            super(l, defaultConstructorMarker2);
        }

        @Override // androidx.compose.foundation.gestures.DragEvent
        public final long getVelocity-9UxMQ8M() {
            return this.velocity;
        }
    }
    static {
    }

    public DragEvent(DefaultConstructorMarker defaultConstructorMarker) {
        super();
    }
}
