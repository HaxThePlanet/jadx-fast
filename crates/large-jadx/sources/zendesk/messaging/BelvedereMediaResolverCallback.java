package zendesk.messaging;

import android.net.Uri;
import f.g.c.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import zendesk.belvedere.d;
import zendesk.belvedere.s;

/* loaded from: classes3.dex */
public class BelvedereMediaResolverCallback extends d<List<s>> {

    private final zendesk.messaging.EventFactory eventFactory;
    private final zendesk.messaging.EventListener eventListener;
    public BelvedereMediaResolverCallback(zendesk.messaging.EventListener eventListener, zendesk.messaging.EventFactory eventFactory2) {
        super();
        this.eventListener = eventListener;
        this.eventFactory = eventFactory2;
    }

    @Override // zendesk.belvedere.d
    public void success(Object object) {
        success((List)object);
    }

    public void success(List<s> list) {
        String next;
        Object[] arr;
        int i = 0;
        final String str3 = "BelvedereMediaResolverCallback";
        a.b(str3, "Uris have been resolved, collecting files to send the event", new Object[i]);
        ArrayList arrayList = new ArrayList();
        Iterator obj6 = list.iterator();
        while (obj6.hasNext()) {
            next = obj6.next();
            arr = (s)next.e();
            if (arr == null) {
            } else {
            }
            arrayList.add(arr);
            arr = new Object[1];
            arr[i] = next.n().toString();
            a.k(str3, "Unable to get file, skipping Uri: %s", arr);
        }
        if (arrayList.isEmpty()) {
            a.k(str3, "No files resolved. No event will be sent", new Object[i]);
        }
        a.b(str3, "Sending attachment event", new Object[i]);
        this.eventListener.onEvent(this.eventFactory.sendAttachment(arrayList));
    }
}
