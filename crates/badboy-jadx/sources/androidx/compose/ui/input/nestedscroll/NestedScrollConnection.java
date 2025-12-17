package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.Velocity.Companion;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008f\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\u0008\u0006\u0010\u0007J*\u0010\u0008\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u000c\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\u0008\u000f\u0010\u0010J\"\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0012\u0010\u0013ø\u0001\u0001\u0082\u0002\r\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u0006\u0014À\u0006\u0003", d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface NestedScrollConnection {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Object onPostFling-RZ2iAVY(androidx.compose.ui.input.nestedscroll.NestedScrollConnection $this, long consumed, long available, Continuation<? super Velocity> $completion) {
            return NestedScrollConnection.access$onPostFling-RZ2iAVY$jd($this, consumed, available, $completion);
        }

        @Deprecated
        public static long onPostScroll-DzOQY0M(androidx.compose.ui.input.nestedscroll.NestedScrollConnection $this, long consumed, long available, int source) {
            return NestedScrollConnection.access$onPostScroll-DzOQY0M$jd($this, consumed, available, source);
        }

        @Deprecated
        public static Object onPreFling-QWom1Mo(androidx.compose.ui.input.nestedscroll.NestedScrollConnection $this, long available, Continuation<? super Velocity> $completion) {
            return NestedScrollConnection.access$onPreFling-QWom1Mo$jd($this, available, $completion);
        }

        @Deprecated
        public static long onPreScroll-OzD1aCk(androidx.compose.ui.input.nestedscroll.NestedScrollConnection $this, long available, int source) {
            return NestedScrollConnection.access$onPreScroll-OzD1aCk$jd($this, available, source);
        }
    }
    public static Object access$onPostFling-RZ2iAVY$jd(androidx.compose.ui.input.nestedscroll.NestedScrollConnection $this, long consumed, long available, Continuation $completion) {
        return super.onPostFling-RZ2iAVY(consumed, available, $completion);
    }

    public static long access$onPostScroll-DzOQY0M$jd(androidx.compose.ui.input.nestedscroll.NestedScrollConnection $this, long consumed, long available, int source) {
        return super.onPostScroll-DzOQY0M(consumed, available, source);
    }

    public static Object access$onPreFling-QWom1Mo$jd(androidx.compose.ui.input.nestedscroll.NestedScrollConnection $this, long available, Continuation $completion) {
        return super.onPreFling-QWom1Mo(available, $completion);
    }

    public static long access$onPreScroll-OzD1aCk$jd(androidx.compose.ui.input.nestedscroll.NestedScrollConnection $this, long available, int source) {
        return super.onPreScroll-OzD1aCk(available, source);
    }

    public static Object onPostFling-RZ2iAVY$suspendImpl(androidx.compose.ui.input.nestedscroll.NestedScrollConnection $this, long consumed, long available, Continuation<? super Velocity> $completion) {
        return Velocity.box-impl(Velocity.Companion.getZero-9UxMQ8M());
    }

    public static Object onPreFling-QWom1Mo$suspendImpl(androidx.compose.ui.input.nestedscroll.NestedScrollConnection $this, long available, Continuation<? super Velocity> $completion) {
        return Velocity.box-impl(Velocity.Companion.getZero-9UxMQ8M());
    }

    public Object onPostFling-RZ2iAVY(long l, long l2, Continuation<? super Velocity> continuation3) {
        return NestedScrollConnection.onPostFling-RZ2iAVY$suspendImpl(this, l, l2, continuation3);
    }

    public long onPostScroll-DzOQY0M(long consumed, long available, int source) {
        return Offset.Companion.getZero-F1C5BW0();
    }

    public Object onPreFling-QWom1Mo(long l, Continuation<? super Velocity> continuation2) {
        return NestedScrollConnection.onPreFling-QWom1Mo$suspendImpl(this, l, continuation2);
    }

    public long onPreScroll-OzD1aCk(long available, int source) {
        return Offset.Companion.getZero-F1C5BW0();
    }
}
