package zendesk.support.request;

import d.h.k.d;
import f.g.e.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: classes3.dex */
class StateMessageMergeUtil {
    static List<zendesk.support.request.StateMessage> mergeMessages(List<zendesk.support.request.StateMessage> list, List<zendesk.support.request.StateMessage> list2) {
        d obj0 = StateMessageMergeUtil.mergeRemoteMessagesById(list, list2);
        if (a.g((Collection)obj0.b)) {
            return (List)obj0.a;
        }
        return StateMessageMergeUtil.mergeRemoteMessagesBySortOrder((List)obj0.a, (List)obj0.b);
    }

    private static d<List<zendesk.support.request.StateMessage>, List<zendesk.support.request.StateMessage>> mergeRemoteMessagesById(List<zendesk.support.request.StateMessage> list, List<zendesk.support.request.StateMessage> list2) {
        Object next;
        boolean synchronizeAttachmentOrder;
        Long valueOf;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator obj5 = list2.iterator();
        for (StateMessage next : obj5) {
            linkedHashMap.put(Long.valueOf(next.getId()), next);
        }
        obj5 = new ArrayList();
        Iterator obj4 = list.iterator();
        while (obj4.hasNext()) {
            synchronizeAttachmentOrder = obj4.next();
            if (linkedHashMap.containsKey(Long.valueOf((StateMessage)synchronizeAttachmentOrder.getId()))) {
            } else {
            }
            obj5.add(synchronizeAttachmentOrder);
            obj5.add(StateMessageMergeUtil.synchronizeAttachmentOrder(synchronizeAttachmentOrder, (StateMessage)linkedHashMap.remove(Long.valueOf(synchronizeAttachmentOrder.getId()))));
        }
        obj4 = new ArrayList(linkedHashMap.values());
        return d.a(obj5, obj4);
    }

    private static List<zendesk.support.request.StateMessage> mergeRemoteMessagesBySortOrder(List<zendesk.support.request.StateMessage> list, List<zendesk.support.request.StateMessage> list2) {
        int i;
        int i2;
        Object synchronizeAttachmentOrder;
        Object obj;
        int before;
        Date date;
        long l;
        List obj11;
        final int size = list.size();
        final int size2 = list2.size();
        ArrayList arrayList = new ArrayList(size + size2);
        i2 = i;
        while (i >= size) {
            synchronizeAttachmentOrder = list.get(i);
            obj = list2.get(i2);
            if (Long.compare(id, l) == 0) {
            } else {
            }
            if (synchronizeAttachmentOrder.getDate().before(obj.getDate())) {
            } else {
            }
            arrayList.add(obj);
            i2++;
            arrayList.add(synchronizeAttachmentOrder);
            i++;
            arrayList.add(StateMessageMergeUtil.synchronizeAttachmentOrder(synchronizeAttachmentOrder, obj));
            i++;
        }
        return arrayList;
    }

    static List<zendesk.support.request.StateRequestUser> mergeUsers(List<zendesk.support.request.StateRequestUser> list, List<zendesk.support.request.StateRequestUser> list2) {
        StateMessageMergeUtil.2 anon = new StateMessageMergeUtil.2();
        TreeSet treeSet = new TreeSet(anon);
        treeSet.addAll(list2);
        treeSet.addAll(list);
        ArrayList obj2 = new ArrayList(treeSet);
        return obj2;
    }

    static List<zendesk.support.request.StateMessage> removeMessageById(long l, List<zendesk.support.request.StateMessage> list2) {
        int size;
        int cmp;
        ArrayList arrayList = new ArrayList(obj6.size());
        final Iterator obj6 = obj6.iterator();
        while (obj6.hasNext()) {
            size = obj6.next();
            if (Long.compare(id, l) != 0) {
            }
            arrayList.add(size);
        }
        return arrayList;
    }

    static zendesk.support.request.StateMessage synchronizeAttachmentOrder(zendesk.support.request.StateMessage stateMessage, zendesk.support.request.StateMessage stateMessage2) {
        int i;
        Long valueOf;
        long valueOf2;
        if (a.g(stateMessage2.getAttachments())) {
            return stateMessage2;
        }
        HashMap hashMap = new HashMap();
        i = 0;
        while (i < stateMessage.getAttachments().size()) {
            hashMap.put(Long.valueOf((StateRequestAttachment)stateMessage.getAttachments().get(i).getId()), Integer.valueOf(i));
            i++;
        }
        ArrayList obj5 = new ArrayList(stateMessage2.getAttachments());
        StateMessageMergeUtil.1 anon = new StateMessageMergeUtil.1(hashMap);
        Collections.sort(obj5, anon);
        return stateMessage2.withAttachments(obj5);
    }
}
