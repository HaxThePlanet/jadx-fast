package androidx.core.os;

import android.os.PersistableBundle;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0000\u001a\u0008\u0010\u0000\u001a\u00020\u0001H\u0007\u001a=\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a\u0018\u0012\u0014\u0008\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0007¢\u0006\u0002\u0010\u0007\u001a\u001a\u0010\u0008\u001a\u00020\u0001*\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\tH\u0007¨\u0006\n", d2 = {"persistableBundleOf", "Landroid/os/PersistableBundle;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Landroid/os/PersistableBundle;", "toPersistableBundle", "", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PersistableBundleKt {
    public static final PersistableBundle persistableBundleOf() {
        return PersistableBundleApi21ImplKt.createPersistableBundle(0);
    }

    public static final PersistableBundle persistableBundleOf(Pair<String, ? extends Object>... pairs) {
        int i;
        Object obj;
        int i2;
        Object component1;
        Object component2;
        PersistableBundle persistableBundle = PersistableBundleApi21ImplKt.createPersistableBundle(pairs.length);
        final Object[] objArr = pairs;
        final int i3 = 0;
        i = 0;
        while (i < objArr.length) {
            obj = objArr[i];
            i2 = 0;
            PersistableBundleApi21ImplKt.putValue(persistableBundle, (String)obj.component1(), obj.component2());
            i++;
        }
        return persistableBundle;
    }

    public static final PersistableBundle toPersistableBundle(Map<String, ? extends Object> $this$toPersistableBundle) {
        Object value;
        Object key;
        PersistableBundle persistableBundle = PersistableBundleApi21ImplKt.createPersistableBundle($this$toPersistableBundle.size());
        Iterator iterator = $this$toPersistableBundle.entrySet().iterator();
        for (Map.Entry next2 : iterator) {
            PersistableBundleApi21ImplKt.putValue(persistableBundle, (String)next2.getKey(), next2.getValue());
        }
        return persistableBundle;
    }
}
