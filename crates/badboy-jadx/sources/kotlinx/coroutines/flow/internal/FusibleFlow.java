package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008g\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002J,\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00022\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tH&¨\u0006\n", d2 = {"Lkotlinx/coroutines/flow/internal/FusibleFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "fuse", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FusibleFlow<T>  extends Flow<T> {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Flow fuse$default(kotlinx.coroutines.flow.internal.FusibleFlow fusibleFlow, CoroutineContext coroutineContext2, int i3, BufferOverflow bufferOverflow4, int i5, Object object6) {
            EmptyCoroutineContext obj1;
            int obj2;
            BufferOverflow obj3;
            if (object6 != null) {
            } else {
                if (i5 & 1 != 0) {
                    obj1 = EmptyCoroutineContext.INSTANCE;
                }
                if (i5 & 2 != 0) {
                    obj2 = -3;
                }
                if (i5 &= 4 != 0) {
                    obj3 = BufferOverflow.SUSPEND;
                }
                return fusibleFlow.fuse(obj1, obj2, obj3);
            }
            UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fuse");
            throw obj0;
        }
    }
    public abstract Flow<T> fuse(CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow3);
}
