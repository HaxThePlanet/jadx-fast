package zendesk.support.guide;

import com.zendesk.service.a;
import com.zendesk.service.e;
import com.zendesk.service.f;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
final class AggregatedCallback<T>  extends f<T> {

    private final Set<e<T>> callbackSet;
    AggregatedCallback() {
        super();
        HashSet hashSet = new HashSet();
        this.callbackSet = Collections.synchronizedSet(hashSet);
    }

    public boolean add(f<T> f) {
        this.callbackSet.add(e.a(f));
        return this.callbackSet.isEmpty();
    }

    @Override // com.zendesk.service.f
    public void cancel() {
        Object next;
        Iterator iterator = this.callbackSet.iterator();
        for (e next : iterator) {
            next.cancel();
        }
        this.callbackSet.clear();
    }

    @Override // com.zendesk.service.f
    public void onError(a a) {
        Object next;
        Iterator iterator = this.callbackSet.iterator();
        for (e next : iterator) {
            next.onError(a);
        }
        this.callbackSet.clear();
    }

    public void onSuccess(T t) {
        Object next;
        Iterator iterator = this.callbackSet.iterator();
        for (e next : iterator) {
            next.onSuccess(t);
        }
        this.callbackSet.clear();
    }
}
