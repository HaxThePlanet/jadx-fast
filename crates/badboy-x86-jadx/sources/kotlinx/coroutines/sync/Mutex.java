package kotlinx.coroutines.sync;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.selects.SelectClause2;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\u0001H&J\u001d\u0010\r\u001a\u00020\u000e2\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u0001H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0010\u001a\u00020\u00032\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u0001H&J\u0014\u0010\u0011\u001a\u00020\u000e2\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u0001H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0002\u0010\u0004R(\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00000\u00068&X§\u0004¢\u0006\u000c\u0012\u0004\u0008\u0007\u0010\u0008\u001a\u0004\u0008\t\u0010\n\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0012", d2 = {"Lkotlinx/coroutines/sync/Mutex;", "", "isLocked", "", "()Z", "onLock", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnLock$annotations", "()V", "getOnLock", "()Lkotlinx/coroutines/selects/SelectClause2;", "holdsLock", "owner", "lock", "", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryLock", "unlock", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Mutex {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated(level = DeprecationLevel.WARNING, message = "Mutex.onLock deprecated without replacement. For additional details please refer to #2794")
        public static void getOnLock$annotations() {
        }

        public static Object lock$default(kotlinx.coroutines.sync.Mutex mutex, Object object2, Continuation continuation3, int i4, Object object5) {
            int obj1;
            if (object5 != null) {
            } else {
                if (i4 &= 1 != 0) {
                    obj1 = 0;
                }
                return mutex.lock(obj1, continuation3);
            }
            UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lock");
            throw obj0;
        }

        public static boolean tryLock$default(kotlinx.coroutines.sync.Mutex mutex, Object object2, int i3, Object object4) {
            int obj1;
            if (object4 != null) {
            } else {
                if (i3 &= 1 != 0) {
                    obj1 = 0;
                }
                return mutex.tryLock(obj1);
            }
            UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryLock");
            throw obj0;
        }

        public static void unlock$default(kotlinx.coroutines.sync.Mutex mutex, Object object2, int i3, Object object4) {
            int obj1;
            if (object4 != null) {
            } else {
                if (i3 &= 1 != 0) {
                    obj1 = 0;
                }
                mutex.unlock(obj1);
            }
            UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock");
            throw obj0;
        }
    }
    public abstract SelectClause2<Object, kotlinx.coroutines.sync.Mutex> getOnLock();

    public abstract boolean holdsLock(Object object);

    public abstract boolean isLocked();

    public abstract Object lock(Object object, Continuation<? super Unit> continuation2);

    public abstract boolean tryLock(Object object);

    public abstract void unlock(Object object);
}
