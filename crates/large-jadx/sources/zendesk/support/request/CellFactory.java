package zendesk.support.request;

import android.content.Context;
import com.squareup.picasso.t;
import f.g.e.a;
import f.g.e.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import o.a.a;
import o.a.b;
import o.b.f;
import zendesk.core.ActionHandlerRegistry;
import zendesk.support.RequestStatus;

/* loaded from: classes3.dex */
class CellFactory {

    private final zendesk.support.request.DocumentRenderer documentRenderer;
    private final zendesk.support.request.DocumentRenderer.HtmlParser htmlParser;
    private final zendesk.support.request.CellBindHelper utils;
    CellFactory(Context context, t t2, zendesk.support.request.ActionFactory actionFactory3, f f4, ActionHandlerRegistry actionHandlerRegistry5, b b6, a a7) {
        super();
        CellBindHelper cellBindHelper = new CellBindHelper(context, t2, actionFactory3, f4);
        this.utils = cellBindHelper;
        DocumentRenderer.HtmlParser obj3 = new DocumentRenderer.HtmlParser();
        this.htmlParser = obj3;
        obj3 = new DocumentRenderer(context, actionHandlerRegistry5, b6, a7);
        this.documentRenderer = obj3;
    }

    CellFactory(zendesk.support.request.CellBindHelper cellBindHelper, zendesk.support.request.DocumentRenderer.HtmlParser documentRenderer$HtmlParser2, zendesk.support.request.DocumentRenderer documentRenderer3) {
        super();
        this.utils = cellBindHelper;
        this.htmlParser = htmlParser2;
        this.documentRenderer = documentRenderer3;
    }

    private java.lang.CharSequence generateRichText(String string, String string2) {
        return this.documentRenderer.render(this.htmlParser.parse(string, string2));
    }

    private List<zendesk.support.request.CellType.Base> markMessagesAsErrored(Collection<zendesk.support.request.CellType.Stateful> collection, Collection<zendesk.support.request.StateMessage> collection2) {
        int markAsErrored;
        int i;
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList(collection.size());
        final Iterator obj5 = collection.iterator();
        for (CellType.Stateful next2 : obj5) {
            arrayList = new ArrayList(collection2);
            arrayList2.add(next2.markAsErrored(arrayList, next3 ^= 1));
        }
        return arrayList2;
    }

    List<zendesk.support.request.CellType.Base> calculatePositionTypes(List<zendesk.support.request.CellType.Base> list) {
        int groupId;
        boolean lastErrorCellOfBlock;
        boolean markedAsDelivered;
        int i;
        Object obj;
        long groupId2;
        if (a.g(list)) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list.size());
        groupId = -1;
        i = 0;
        while (i < list.size()) {
            obj = list.get(i);
            if (i != 0) {
            } else {
            }
            (CellType.Base)obj.setPositionType(2);
            if (obj instanceof CellType.Stateful) {
            }
            groupId = obj.getGroupId();
            arrayList.add(obj);
            i++;
            lastErrorCellOfBlock = obj;
            if (!(CellType.Stateful)lastErrorCellOfBlock.isMarkedAsDelivered()) {
            } else {
            }
            obj.setPositionType(8);
            if (lastErrorCellOfBlock.isLastErrorCellOfBlock()) {
            }
            if (Long.compare(groupId2, groupId) != 0) {
            }
        }
        (CellType.Base)arrayList.get(obj8--).setPositionType(16);
        return arrayList;
    }

    zendesk.support.request.StateMessage findFirstDelivered(List<zendesk.support.request.StateMessage> list) {
        Object next;
        int status;
        int i;
        Iterator obj4 = list.iterator();
        for (StateMessage next : obj4) {
        }
        return null;
    }

    zendesk.support.request.StateRequestUser findUserForId(List<zendesk.support.request.StateRequestUser> list, long l2) {
        Object next;
        int cmp;
        Iterator obj4 = list.iterator();
        for (StateRequestUser next : obj4) {
        }
        return null;
    }

    public List<zendesk.support.request.CellType.Base> generateCells(List<zendesk.support.request.StateMessage> list, List<zendesk.support.request.StateRequestUser> list2, RequestStatus requestStatus3, String string4) {
        List systemMessage;
        zendesk.support.request.StateMessage stateMessage;
        Object obj;
        List viewModelsForMessage;
        String str;
        int i;
        ArrayList arrayList = new ArrayList();
        Iterator obj9 = list.iterator();
        for (Object next2 : obj9) {
            obj = next2;
            zendesk.support.request.StateRequestUser userForId = findUserForId(list2, (StateMessage)obj.getUserId());
            boolean userAgent = isUserAgent(userForId);
            arrayList.addAll(this.insertSystemMessage(findFirstDelivered(list), obj, getViewModelsForMessage(obj, userAgent, userForId), string4, userAgent ^ 1));
        }
        return calculatePositionTypes(markAgentCells(insertRequestStatus(insertDateCells(markLastDeliveredCell(markCellsErrored(arrayList))), requestStatus3)));
    }

    zendesk.support.request.CellType.Base getAgentAttachment(zendesk.support.request.StateRequestAttachment stateRequestAttachment, zendesk.support.request.StateRequestUser stateRequestUser2, Date date3) {
        if (UtilsAttachment.isImageAttachment(stateRequestAttachment)) {
            CellAgentAttachmentImage cellAgentAttachmentImage = new CellAgentAttachmentImage(this.utils, stateRequestAttachment, stateRequestUser2, date3);
            return cellAgentAttachmentImage;
        }
        CellAgentAttachmentGeneric cellAgentAttachmentGeneric = new CellAgentAttachmentGeneric(this.utils, stateRequestAttachment, stateRequestUser2, date3);
        return cellAgentAttachmentGeneric;
    }

    zendesk.support.request.CellType.Base getAgentMessage(zendesk.support.request.StateMessage stateMessage, zendesk.support.request.StateRequestUser stateRequestUser2) {
        CellAgentMessage cellAgentMessage = new CellAgentMessage(this.utils, stateMessage, generateRichText(stateMessage.getHtmlBody(), stateMessage.getPlainBody()), stateRequestUser2);
        return cellAgentMessage;
    }

    zendesk.support.request.CellType.Base getUserAttachment(zendesk.support.request.StateMessage stateMessage, zendesk.support.request.StateRequestAttachment stateRequestAttachment2, Date date3) {
        final Object obj = this;
        final int i = 0;
        if (UtilsAttachment.isImageAttachment(stateRequestAttachment2)) {
            ArrayList arrayList2 = new ArrayList(i);
            super(obj.utils, stateMessage, stateRequestAttachment2, date3, 0, 0, arrayList2, 0);
            return cellUserAttachmentImage;
        }
        ArrayList arrayList = new ArrayList(i);
        super(obj.utils, stateMessage, stateRequestAttachment2, date3, 0, 0, arrayList, 0);
        return cellUserAttachmentGeneric;
    }

    List<zendesk.support.request.CellType.Base> getUserMessage(zendesk.support.request.StateMessage stateMessage) {
        if (!UtilsAttachment.hasAttachmentBody(stateMessage)) {
            ArrayList arrayList = new ArrayList(0);
            super(this.utils, stateMessage, 0, 0, generateRichText(stateMessage.getHtmlBody(), stateMessage.getPlainBody()), arrayList, 0);
            return Collections.singletonList(cellUserMessage);
        }
        ArrayList obj11 = new ArrayList();
        return obj11;
    }

    List<zendesk.support.request.CellType.Base> getViewModelsForMessage(zendesk.support.request.StateMessage stateMessage, boolean z2, zendesk.support.request.StateRequestUser stateRequestUser3) {
        Object agentMessage;
        int i;
        zendesk.support.request.CellType.Base agentAttachment;
        Date date;
        final List attachments = stateMessage.getAttachments();
        ArrayList arrayList = new ArrayList();
        if (z2) {
            arrayList.add(getAgentMessage(stateMessage, stateRequestUser3));
        } else {
            arrayList.addAll(getUserMessage(stateMessage));
        }
        i = 0;
        while (i < attachments.size()) {
            Object obj = attachments.get(i);
            if (z2) {
            } else {
            }
            arrayList.add(getUserAttachment(stateMessage, (StateRequestAttachment)obj, stateMessage.getDate()));
            i++;
            arrayList.add(getAgentAttachment(obj, stateRequestUser3, stateMessage.getDate()));
        }
        return arrayList;
    }

    List<zendesk.support.request.CellType.Base> insertDateCells(List<zendesk.support.request.CellType.Base> list) {
        Date timeStamp;
        int next;
        boolean sameDay;
        zendesk.support.request.CellSystemMessages.CellDateMessage cellDateMessage;
        zendesk.support.request.CellBindHelper utils;
        ArrayList arrayList = new ArrayList(list.size());
        timeStamp = new Date(0, obj3);
        final Iterator obj8 = list.iterator();
        while (obj8.hasNext()) {
            next = obj8.next();
            if (!UtilsDate.isSameDay(timeStamp, (CellType.Base)next.getTimeStamp())) {
            }
            arrayList.add(next);
            timeStamp = next.getTimeStamp();
            cellDateMessage = new CellSystemMessages.CellDateMessage(this.utils, UtilsDate.getBeginOfDay(timeStamp).getTime(), obj4, timeStamp);
            arrayList.add(cellDateMessage);
        }
        return arrayList;
    }

    List<zendesk.support.request.CellType.Base> insertRequestStatus(List<zendesk.support.request.CellType.Base> list, RequestStatus requestStatus2) {
        RequestStatus cellRequestStatus;
        zendesk.support.request.CellBindHelper utils;
        if (requestStatus2 == RequestStatus.Closed && list.size() > 0) {
            if (list.size() > 0) {
                cellRequestStatus = new CellSystemMessages.CellRequestStatus(this.utils, requestStatus2);
                list.add(cellRequestStatus);
            }
        }
        return list;
    }

    List<zendesk.support.request.CellType.Base> insertSystemMessage(zendesk.support.request.StateMessage stateMessage, zendesk.support.request.StateMessage stateMessage2, List<zendesk.support.request.CellType.Base> list3, String string4, boolean z5) {
        boolean obj1;
        Date obj2;
        if (z5 && stateMessage2 == stateMessage && g.c(string4)) {
            if (stateMessage2 == stateMessage) {
                if (g.c(string4)) {
                    obj1 = new CellSystemMessages.CellSystemMessage(stateMessage2.getDate(), string4);
                    list3.add(obj1);
                }
            }
        }
        return list3;
    }

    boolean isUserAgent(zendesk.support.request.StateRequestUser stateRequestUser) {
        boolean obj1;
        if (stateRequestUser && stateRequestUser.isAgent()) {
            obj1 = stateRequestUser.isAgent() ? 1 : 0;
        } else {
        }
        return obj1;
    }

    List<zendesk.support.request.CellType.Base> markAgentCells(List<zendesk.support.request.CellType.Base> list) {
        int i;
        long l;
        Object obj;
        int cmp;
        final int i2 = 1;
        size -= i2;
        final long l2 = Long.MIN_VALUE;
        l = l2;
        while (i >= 0) {
            if (obj2 instanceof CellType.Agent) {
            } else {
            }
            l = l2;
            i--;
            obj = list.get(i);
            if (Long.compare(l, id) != 0) {
            } else {
            }
            obj.showAgentName(false);
            obj.showAgentName(i2);
            l = obj.getAgent().getId();
        }
        return list;
    }

    List<zendesk.support.request.CellType.Base> markCellsErrored(List<zendesk.support.request.CellType.Base> list) {
        Object stateMessage;
        Object markMessagesAsErrored;
        int status;
        int i;
        ArrayList arrayList = new ArrayList();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList2 = new ArrayList();
        Iterator obj8 = list.iterator();
        while (obj8.hasNext()) {
            stateMessage = obj8.next();
            if (stateMessage instanceof CellType.Stateful) {
            } else {
            }
            arrayList2.addAll(markMessagesAsErrored(arrayList, linkedHashSet));
            arrayList2.add((CellType.Base)stateMessage);
            arrayList.clear();
            linkedHashSet.clear();
            markMessagesAsErrored = stateMessage;
            if ((CellType.Stateful)markMessagesAsErrored.getStateMessage().getState().getStatus() == 1) {
            } else {
            }
            arrayList2.addAll(markMessagesAsErrored(arrayList, linkedHashSet));
            arrayList2.add(stateMessage);
            arrayList.clear();
            linkedHashSet.clear();
            arrayList.add(markMessagesAsErrored);
            linkedHashSet.add(markMessagesAsErrored.getStateMessage());
        }
        arrayList2.addAll(markMessagesAsErrored(arrayList, linkedHashSet));
        return arrayList2;
    }

    List<zendesk.support.request.CellType.Base> markLastDeliveredCell(List<zendesk.support.request.CellType.Base> list) {
        int i;
        Object status;
        int i3;
        int i4;
        int i2;
        int markAsDelivered;
        boolean status2;
        int i5;
        Iterator iterator = list.iterator();
        i4 = 1;
        for (CellType.Base status : iterator) {
            i4 = 1;
        }
        i = i3;
        ArrayList arrayList = new ArrayList(list.size());
        if (i == 0) {
            size -= i4;
            while (i >= 0) {
                markAsDelivered = list.get(i);
                Object obj = markAsDelivered;
                if (markAsDelivered instanceof CellType.Stateful && i3 == 0 && (CellType.Stateful)obj.getStateMessage().getState().getStatus() == 2) {
                }
                arrayList.add(markAsDelivered);
                i--;
                if (i3 == 0) {
                }
                obj = markAsDelivered;
                if ((CellType.Stateful)obj.getStateMessage().getState().getStatus() == 2) {
                }
                i3 = i4;
                markAsDelivered = obj.markAsDelivered();
            }
            Collections.reverse(arrayList);
        } else {
            arrayList.addAll(list);
        }
        return arrayList;
    }
}
