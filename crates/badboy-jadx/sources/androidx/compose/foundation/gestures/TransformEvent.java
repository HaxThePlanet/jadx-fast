package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00082\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\u0008¨\u0006\t", d2 = {"Landroidx/compose/foundation/gestures/TransformEvent;", "", "()V", "TransformDelta", "TransformStarted", "TransformStopped", "Landroidx/compose/foundation/gestures/TransformEvent$TransformDelta;", "Landroidx/compose/foundation/gestures/TransformEvent$TransformStarted;", "Landroidx/compose/foundation/gestures/TransformEvent$TransformStopped;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
abstract class TransformEvent {

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000c\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u000e", d2 = {"Landroidx/compose/foundation/gestures/TransformEvent$TransformDelta;", "Landroidx/compose/foundation/gestures/TransformEvent;", "zoomChange", "", "panChange", "Landroidx/compose/ui/geometry/Offset;", "rotationChange", "(FJFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPanChange-F1C5BW0", "()J", "J", "getRotationChange", "()F", "getZoomChange", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class TransformDelta extends androidx.compose.foundation.gestures.TransformEvent {

        public static final int $stable;
        private final long panChange;
        private final float rotationChange;
        private final float zoomChange;
        static {
        }

        private TransformDelta(float zoomChange, long panChange, float rotationChange) {
            super(0);
            this.zoomChange = zoomChange;
            this.panChange = panChange;
            this.rotationChange = obj5;
        }

        public TransformDelta(float f, long l2, float f3, DefaultConstructorMarker defaultConstructorMarker4) {
            super(f, l2, f3, defaultConstructorMarker4);
        }

        @Override // androidx.compose.foundation.gestures.TransformEvent
        public final long getPanChange-F1C5BW0() {
            return this.panChange;
        }

        @Override // androidx.compose.foundation.gestures.TransformEvent
        public final float getRotationChange() {
            return this.rotationChange;
        }

        @Override // androidx.compose.foundation.gestures.TransformEvent
        public final float getZoomChange() {
            return this.zoomChange;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"Landroidx/compose/foundation/gestures/TransformEvent$TransformStarted;", "Landroidx/compose/foundation/gestures/TransformEvent;", "()V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class TransformStarted extends androidx.compose.foundation.gestures.TransformEvent {

        public static final int $stable;
        public static final androidx.compose.foundation.gestures.TransformEvent.TransformStarted INSTANCE;
        static {
            TransformEvent.TransformStarted transformStarted = new TransformEvent.TransformStarted();
            TransformEvent.TransformStarted.INSTANCE = transformStarted;
        }

        private TransformStarted() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"Landroidx/compose/foundation/gestures/TransformEvent$TransformStopped;", "Landroidx/compose/foundation/gestures/TransformEvent;", "()V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class TransformStopped extends androidx.compose.foundation.gestures.TransformEvent {

        public static final int $stable;
        public static final androidx.compose.foundation.gestures.TransformEvent.TransformStopped INSTANCE;
        static {
            TransformEvent.TransformStopped transformStopped = new TransformEvent.TransformStopped();
            TransformEvent.TransformStopped.INSTANCE = transformStopped;
        }

        private TransformStopped() {
            super(0);
        }
    }
    public TransformEvent(DefaultConstructorMarker defaultConstructorMarker) {
        super();
    }
}
