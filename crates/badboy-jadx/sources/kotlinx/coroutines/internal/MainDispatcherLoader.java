package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0007\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0008", d2 = {"Lkotlinx/coroutines/internal/MainDispatcherLoader;", "", "()V", "FAST_SERVICE_LOADER_ENABLED", "", "dispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "loadMainDispatcher", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MainDispatcherLoader {

    private static final boolean FAST_SERVICE_LOADER_ENABLED;
    public static final kotlinx.coroutines.internal.MainDispatcherLoader INSTANCE;
    public static final MainCoroutineDispatcher dispatcher;
    static {
        MainDispatcherLoader mainDispatcherLoader = new MainDispatcherLoader();
        MainDispatcherLoader.INSTANCE = mainDispatcherLoader;
        MainDispatcherLoader.FAST_SERVICE_LOADER_ENABLED = SystemPropsKt.systemProp("kotlinx.coroutines.fast.service.loader", true);
        MainDispatcherLoader.dispatcher = MainDispatcherLoader.INSTANCE.loadMainDispatcher();
    }

    private final MainCoroutineDispatcher loadMainDispatcher() {
        int i;
        java.util.List mainDispatcherFactory$kotlinx_coroutines_core;
        java.lang.ClassLoader classLoader;
        Object missingDispatcher$default;
        int maxElem$iv;
        boolean next;
        int i2;
        int maxValue$iv;
        int i3;
        int loadPriority;
        i = 0;
        if (MainDispatcherLoader.FAST_SERVICE_LOADER_ENABLED) {
            mainDispatcherFactory$kotlinx_coroutines_core = FastServiceLoader.INSTANCE.loadMainDispatcherFactory$kotlinx_coroutines_core();
        } else {
            try {
                mainDispatcherFactory$kotlinx_coroutines_core = SequencesKt.toList(SequencesKt.asSequence(ServiceLoader.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader()).iterator()));
                final int i5 = 0;
                final Iterator iterator2 = (Iterable)mainDispatcherFactory$kotlinx_coroutines_core.iterator();
                if (!iterator2.hasNext()) {
                } else {
                }
                maxElem$iv = i;
                if (!iterator2.hasNext()) {
                } else {
                }
                i2 = 0;
                maxValue$iv = (MainDispatcherFactory)iterator2.next().getLoadPriority();
                Object next3 = iterator2.next();
                i3 = 0;
                loadPriority = (MainDispatcherFactory)next3.getLoadPriority();
                do {
                    next3 = iterator2.next();
                    i3 = 0;
                    loadPriority = (MainDispatcherFactory)next3.getLoadPriority();
                    if (iterator2.hasNext() != null) {
                    }
                    maxElem$iv = next3;
                    maxValue$iv = i2;
                } while (maxValue$iv < loadPriority);
                maxElem$iv = next3;
                maxValue$iv = i2;
                if (iterator2.hasNext() != null) {
                }
                if ((MainDispatcherFactory)maxElem$iv != 0) {
                } else {
                }
                if (MainDispatchersKt.tryCreateDispatcher((MainDispatcherFactory)maxElem$iv, mainDispatcherFactory$kotlinx_coroutines_core) == null) {
                }
                missingDispatcher$default = MainDispatchersKt.createMissingDispatcher$default(i, i, 3, i);
                String missingDispatcher$default2 = MainDispatchersKt.createMissingDispatcher$default(th, missingDispatcher$default2, 2, missingDispatcher$default2);
                return missingDispatcher$default;
            }
        }
    }
}
