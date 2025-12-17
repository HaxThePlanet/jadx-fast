package zendesk.support.requestlist;

import f.g.e.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
class RequestInfoMerger {

    private static final Comparator<zendesk.support.requestlist.RequestInfo> REQUEST_INFO_COMPARATOR;
    static {
        RequestInfo.LastUpdatedComparator lastUpdatedComparator = new RequestInfo.LastUpdatedComparator();
        RequestInfoMerger.REQUEST_INFO_COMPARATOR = lastUpdatedComparator;
    }

    private zendesk.support.requestlist.RequestInfo merge(zendesk.support.requestlist.RequestInfo requestInfo, zendesk.support.requestlist.RequestInfo requestInfo2) {
        Date lastUpdated;
        boolean after;
        Date date;
        zendesk.support.requestlist.RequestInfo.MessageInfo request;
        lastUpdated = requestInfo.getLastUpdated();
        Date lastUpdated2 = requestInfo2.getLastUpdated();
        if (lastUpdated == null) {
            date = lastUpdated2;
        } else {
            if (lastUpdated2 != null) {
                if (lastUpdated.after(lastUpdated2)) {
                } else {
                    lastUpdated = lastUpdated2;
                }
            }
            date = lastUpdated;
        }
        zendesk.support.requestlist.RequestInfo.MessageInfo lastMessageInfo = requestInfo.getLastMessageInfo();
        zendesk.support.requestlist.RequestInfo.MessageInfo lastMessageInfo2 = requestInfo2.getLastMessageInfo();
        request = lastMessageInfo.getDate().after(lastMessageInfo2.getDate()) ? lastMessageInfo : lastMessageInfo2;
        super(requestInfo.getLocalId(), requestInfo2.getRemoteId(), requestInfo2.getRequestStatus(), requestInfo2.isUnread(), date, requestInfo2.getAgentInfos(), requestInfo2.getFirstMessageInfo(), request, requestInfo.getFailedMessageIds());
        return requestInfo3;
    }

    List<zendesk.support.requestlist.RequestInfo> merge(List<zendesk.support.requestlist.RequestInfo> list, List<zendesk.support.requestlist.RequestInfo> list2) {
        ArrayList arrayList;
        Object next;
        boolean remoteId;
        String remoteId2;
        boolean z;
        HashMap hashMap = new HashMap();
        arrayList = new ArrayList();
        Iterator obj6 = list.iterator();
        while (obj6.hasNext()) {
            next = obj6.next();
            remoteId2 = (RequestInfo)next.getRemoteId();
            if (g.c(remoteId2)) {
            } else {
            }
            arrayList.add(next);
            hashMap.put(remoteId2, next);
        }
        obj6 = new ArrayList(arrayList);
        Iterator obj7 = list2.iterator();
        while (obj7.hasNext()) {
            arrayList = obj7.next();
            remoteId = (RequestInfo)arrayList.getRemoteId();
            if (hashMap.containsKey(remoteId)) {
            } else {
            }
            obj6.add(arrayList);
            obj6.add(merge((RequestInfo)hashMap.get(remoteId), arrayList));
            hashMap.remove(remoteId);
        }
        Collections.sort(obj6, RequestInfoMerger.REQUEST_INFO_COMPARATOR);
        return obj6;
    }
}
