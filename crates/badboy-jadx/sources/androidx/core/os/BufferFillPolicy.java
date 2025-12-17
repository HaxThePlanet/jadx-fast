package androidx.core.os;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00087\u0018\u0000 \u00072\u00020\u0001:\u0003\u0007\u0008\tB\u000f\u0008\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0001\u0002\n\u000b¨\u0006\u000c", d2 = {"Landroidx/core/os/BufferFillPolicy;", "", "value", "", "(I)V", "getValue$core_release", "()I", "Companion", "Discard", "RingBuffer", "Landroidx/core/os/BufferFillPolicy$Discard;", "Landroidx/core/os/BufferFillPolicy$RingBuffer;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class BufferFillPolicy {

    public static final androidx.core.os.BufferFillPolicy.Companion Companion;
    public static final androidx.core.os.BufferFillPolicy DISCARD;
    public static final androidx.core.os.BufferFillPolicy RING_BUFFER;
    private final int value;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"Landroidx/core/os/BufferFillPolicy$Companion;", "", "()V", "DISCARD", "Landroidx/core/os/BufferFillPolicy;", "RING_BUFFER", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"Landroidx/core/os/BufferFillPolicy$Discard;", "Landroidx/core/os/BufferFillPolicy;", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Discard extends androidx.core.os.BufferFillPolicy {
        public Discard() {
            super(1, 0);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"Landroidx/core/os/BufferFillPolicy$RingBuffer;", "Landroidx/core/os/BufferFillPolicy;", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class RingBuffer extends androidx.core.os.BufferFillPolicy {
        public RingBuffer() {
            super(2, 0);
        }
    }
    static {
        BufferFillPolicy.Companion companion = new BufferFillPolicy.Companion(0);
        BufferFillPolicy.Companion = companion;
        BufferFillPolicy.Discard discard = new BufferFillPolicy.Discard();
        BufferFillPolicy.DISCARD = (BufferFillPolicy)discard;
        BufferFillPolicy.RingBuffer ringBuffer = new BufferFillPolicy.RingBuffer();
        BufferFillPolicy.RING_BUFFER = (BufferFillPolicy)ringBuffer;
    }

    private BufferFillPolicy(int value) {
        super();
        this.value = value;
    }

    public BufferFillPolicy(int i, DefaultConstructorMarker defaultConstructorMarker2) {
        super(i);
    }

    public final int getValue$core_release() {
        return this.value;
    }
}
