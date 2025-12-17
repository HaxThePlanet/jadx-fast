package kotlinx.coroutines.internal;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.j0.i;
import kotlinx.coroutines.j2;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0007\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0008", d2 = {"Lkotlinx/coroutines/internal/MainDispatcherLoader;", "", "()V", "FAST_SERVICE_LOADER_ENABLED", "", "dispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "loadMainDispatcher", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class r {

    public static final kotlinx.coroutines.internal.r a;
    private static final boolean b;
    public static final j2 c;
    static {
        r rVar = new r();
        r.a = rVar;
        r.b = a0.e("kotlinx.coroutines.fast.service.loader", true);
        r.c = rVar.a();
    }

    private final j2 a() {
        j2 tVar;
        java.util.List list;
        Iterator iterator;
        int next2;
        boolean loadPriority;
        boolean next;
        int loadPriority2;
        int i = 0;
        if (r.b) {
            try {
                list = j.a.c();
                list = i.A(i.a(a.b()));
                iterator = list.iterator();
                if (!iterator.hasNext()) {
                } else {
                }
                next2 = i;
                if (!iterator.hasNext()) {
                } else {
                }
                loadPriority = (MainDispatcherFactory)iterator.next().getLoadPriority();
                Object next4 = iterator.next();
                loadPriority2 = (MainDispatcherFactory)next4.getLoadPriority();
                do {
                    next4 = iterator.next();
                    loadPriority2 = (MainDispatcherFactory)next4.getLoadPriority();
                    if (iterator.hasNext()) {
                    }
                    next2 = next4;
                    loadPriority = loadPriority2;
                } while (loadPriority < loadPriority2);
                next2 = next4;
                loadPriority = loadPriority2;
                if (iterator.hasNext()) {
                }
                if ((MainDispatcherFactory)next2 == 0) {
                } else {
                }
                tVar = s.b(i, i, 3, i);
                tVar = s.d((MainDispatcherFactory)next2, list);
                String str = s.b(th, str, 2, str);
                return tVar;
            }
        } else {
        }
    }
}
