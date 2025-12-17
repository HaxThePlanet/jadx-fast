package zendesk.support;

import f.g.e.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
class ZendeskRequestSessionCache implements zendesk.support.RequestSessionCache {

    private final Map<Long, zendesk.support.TicketForm> cachedTicketForms;
    ZendeskRequestSessionCache() {
        super();
        HashMap hashMap = new HashMap();
        this.cachedTicketForms = hashMap;
    }

    public boolean containsAllTicketForms(List<Long> list) {
        boolean next;
        Map cachedTicketForms;
        int obj4;
        final Map cachedTicketForms2 = this.cachedTicketForms;
        obj4 = a.e(list).iterator();
        synchronized (cachedTicketForms2) {
            for (Long next2 : obj4) {
            }
            obj4 = 1;
            return obj4;
        }
    }

    public List<zendesk.support.TicketForm> getTicketFormsById(List<Long> list) {
        Object obj;
        Map cachedTicketForms;
        ArrayList arrayList = new ArrayList();
        final Map cachedTicketForms2 = this.cachedTicketForms;
        Iterator obj5 = a.e(list).iterator();
        synchronized (this) {
            try {
                for (Long next2 : obj5) {
                    arrayList.add(this.cachedTicketForms.get(next2));
                }
                arrayList.add(this.cachedTicketForms.get((Long)obj5.next()));
                return arrayList;
                throw list;
                throw list;
            } catch (Throwable th) {
            }
        }
    }

    public void updateTicketFormCache(List<zendesk.support.TicketForm> list) {
        Object next;
        Long valueOf;
        HashMap hashMap = new HashMap();
        Iterator obj5 = a.e(list).iterator();
        for (TicketForm next : obj5) {
            hashMap.put(Long.valueOf(next.getId()), next);
        }
        obj5 = this.cachedTicketForms;
        this.cachedTicketForms.putAll(hashMap);
        return;
        synchronized (obj5) {
            obj5 = this.cachedTicketForms;
            this.cachedTicketForms.putAll(hashMap);
        }
    }
}
