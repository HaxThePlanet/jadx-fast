package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\u001a\u0008\u0010\u0000\u001a\u00020\u0001H\u0007\u001a\u001e\u0010\u0002\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0008\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u00040\u0003H\u0007\u001a\u0010\u0010\u0008\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0007\u001a\u0010\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u000c\u001a\u00020\rH\u0007¨\u0006\u000e", d2 = {"clearCompositionErrors", "", "currentCompositionErrors", "", "Lkotlin/Pair;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "invalidateGroupsWithKey", "key", "", "simulateHotReload", "context", "", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class HotReloaderKt {
    public static final void clearCompositionErrors() {
        HotReloader.Companion.clearErrors$runtime_release();
    }

    public static final List<Pair<Exception, Boolean>> currentCompositionErrors() {
        Object next;
        Pair it;
        int i;
        Exception cause;
        Boolean valueOf;
        List currentErrors$runtime_release = HotReloader.Companion.getCurrentErrors$runtime_release();
        final int i2 = 0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)currentErrors$runtime_release, 10));
        final int i4 = 0;
        final Iterator iterator = currentErrors$runtime_release.iterator();
        for (Object next : iterator) {
            Object obj = next;
            i = 0;
            (Collection)arrayList.add(TuplesKt.to((RecomposerErrorInfo)obj.getCause(), Boolean.valueOf(obj.getRecoverable())));
        }
        return (List)arrayList;
    }

    public static final void invalidateGroupsWithKey(int key) {
        HotReloader.Companion.invalidateGroupsWithKey$runtime_release(key);
    }

    public static final void simulateHotReload(Object context) {
        HotReloader.Companion.simulateHotReload$runtime_release(context);
    }
}
