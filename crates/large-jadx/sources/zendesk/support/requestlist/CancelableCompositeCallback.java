package zendesk.support.requestlist;

import com.zendesk.service.e;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
class CancelableCompositeCallback {

    private Set<e> zendeskCallbacks;
    CancelableCompositeCallback() {
        super();
        HashSet hashSet = new HashSet();
        this.zendeskCallbacks = hashSet;
    }

    public void add(e e) {
        this.zendeskCallbacks.add(e);
    }

    public void add(e... eArr) {
        int i;
        Object obj;
        i = 0;
        for (Object obj : eArr) {
            add(obj);
        }
    }

    public void cancel() {
        Object next;
        Iterator iterator = this.zendeskCallbacks.iterator();
        for (e next : iterator) {
            next.cancel();
        }
        this.zendeskCallbacks.clear();
    }
}
