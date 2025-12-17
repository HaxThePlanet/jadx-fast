package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u000c\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0081@\u0018\u0000*\u000e\u0008\u0000\u0010\u0001*\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0014\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000¢\u0006\u0004\u0008\u0005\u0010\u0006J\u001a\u0010\u0010\u001a\u00020\u00082\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÖ\u0003¢\u0006\u0004\u0008\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\u0008\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\u0008\u001a\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\u00088F¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u0017\u0010\u000b\u001a\u00028\u00008F¢\u0006\u000c\u0012\u0004\u0008\u000c\u0010\r\u001a\u0004\u0008\u000e\u0010\u000fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0004\u0092\u0001\u0004\u0018\u00010\u0003ø\u0001\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u001c", d2 = {"Lkotlinx/coroutines/internal/SegmentOrClosed;", "S", "Lkotlinx/coroutines/internal/Segment;", "", "value", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "isClosed", "", "isClosed-impl", "(Ljava/lang/Object;)Z", "segment", "getSegment$annotations", "()V", "getSegment-impl", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/Segment;", "equals", "other", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/Object;)I", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class SegmentOrClosed<S extends kotlinx.coroutines.internal.Segment<S>>  {

    private final Object value;
    private SegmentOrClosed(Object value) {
        super();
        this.value = value;
    }

    public static final kotlinx.coroutines.internal.SegmentOrClosed box-impl(Object object) {
        SegmentOrClosed segmentOrClosed = new SegmentOrClosed(object);
        return segmentOrClosed;
    }

    public static <S extends kotlinx.coroutines.internal.Segment<S>> Object constructor-impl(Object object) {
        return object;
    }

    public static boolean equals-impl(Object object, Object object2) {
        final int i2 = 0;
        if (!object2 instanceof SegmentOrClosed) {
            return i2;
        }
        if (!Intrinsics.areEqual(object, (SegmentOrClosed)object2.unbox-impl())) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(Object object, Object object2) {
        return Intrinsics.areEqual(object, object2);
    }

    public static void getSegment$annotations() {
    }

    public static final S getSegment-impl(Object arg0) {
        if (arg0 == ConcurrentLinkedListKt.access$getCLOSED$p()) {
        } else {
            Intrinsics.checkNotNull(arg0, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
            return (Segment)arg0;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Does not contain segment".toString());
        throw illegalStateException;
    }

    public static int hashCode-impl(Object object) {
        int i;
        if (object == null) {
            i = 0;
        } else {
            i = object.hashCode();
        }
        return i;
    }

    public static final boolean isClosed-impl(Object arg0) {
        int i;
        i = arg0 == ConcurrentLinkedListKt.access$getCLOSED$p() ? 1 : 0;
        return i;
    }

    public static String toString-impl(Object object) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("SegmentOrClosed(value=").append(object).append(')').toString();
    }

    public boolean equals(Object object) {
        return SegmentOrClosed.equals-impl(this.value, object);
    }

    public int hashCode() {
        return SegmentOrClosed.hashCode-impl(this.value);
    }

    public String toString() {
        return SegmentOrClosed.toString-impl(this.value);
    }

    public final Object unbox-impl() {
        return this.value;
    }
}
