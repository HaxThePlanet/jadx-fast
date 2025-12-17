package zendesk.support.request;

import android.content.Context;
import com.zendesk.service.a;
import com.zendesk.service.f;
import f.g.e.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import o.b.k;
import zendesk.core.ActionHandlerRegistry;
import zendesk.support.requestlist.RequestInfo;
import zendesk.support.requestlist.RequestInfo.AgentInfo;
import zendesk.support.requestlist.RequestInfo.MessageInfo;
import zendesk.support.requestlist.RequestInfoDataSource.LocalDataSource;
import zendesk.support.requestlist.RequestListActivity;

/* loaded from: classes3.dex */
class ComponentUpdateActionHandlers implements k<zendesk.support.request.StateConversation> {

    private final ActionHandlerRegistry actionHandlerRegistry;
    private final Context context;
    private final RequestInfoDataSource.LocalDataSource localDataSource;
    private final zendesk.support.request.AsyncMiddleware.Queue queue;

    private class RefreshCallback extends f<List<RequestInfo>> {

        private final zendesk.support.request.AsyncMiddleware.Callback callback;
        final zendesk.support.request.ComponentUpdateActionHandlers this$0;
        private RefreshCallback(zendesk.support.request.ComponentUpdateActionHandlers componentUpdateActionHandlers, zendesk.support.request.AsyncMiddleware.Callback asyncMiddleware$Callback2) {
            this.this$0 = componentUpdateActionHandlers;
            super();
            this.callback = callback2;
        }

        RefreshCallback(zendesk.support.request.ComponentUpdateActionHandlers componentUpdateActionHandlers, zendesk.support.request.AsyncMiddleware.Callback asyncMiddleware$Callback2, zendesk.support.request.ComponentUpdateActionHandlers.1 componentUpdateActionHandlers$13) {
            super(componentUpdateActionHandlers, callback2);
        }

        @Override // com.zendesk.service.f
        public void onError(a a) {
            ActionHandlerRegistry handler;
            boolean obj2;
            this.callback.done();
            if (!ComponentUpdateActionHandlers.access$200(this.this$0).isRunning()) {
                RequestListActivity.refresh(ComponentUpdateActionHandlers.access$300(this.this$0), ComponentUpdateActionHandlers.access$400(this.this$0));
            }
        }

        @Override // com.zendesk.service.f
        public void onSuccess(Object object) {
            onSuccess((List)object);
        }

        public void onSuccess(List<RequestInfo> list) {
            ActionHandlerRegistry handler;
            boolean obj2;
            this.callback.done();
            if (!ComponentUpdateActionHandlers.access$200(this.this$0).isRunning()) {
                RequestListActivity.refresh(ComponentUpdateActionHandlers.access$300(this.this$0), ComponentUpdateActionHandlers.access$400(this.this$0));
            }
        }
    }
    ComponentUpdateActionHandlers(Context context, ActionHandlerRegistry actionHandlerRegistry2, RequestInfoDataSource.LocalDataSource requestInfoDataSource$LocalDataSource3) {
        super();
        AsyncMiddleware.Queue queue = new AsyncMiddleware.Queue();
        this.queue = queue;
        this.context = context;
        this.actionHandlerRegistry = actionHandlerRegistry2;
        this.localDataSource = localDataSource3;
    }

    static RequestInfoDataSource.LocalDataSource access$100(zendesk.support.request.ComponentUpdateActionHandlers componentUpdateActionHandlers) {
        return componentUpdateActionHandlers.localDataSource;
    }

    static zendesk.support.request.AsyncMiddleware.Queue access$200(zendesk.support.request.ComponentUpdateActionHandlers componentUpdateActionHandlers) {
        return componentUpdateActionHandlers.queue;
    }

    static Context access$300(zendesk.support.request.ComponentUpdateActionHandlers componentUpdateActionHandlers) {
        return componentUpdateActionHandlers.context;
    }

    static ActionHandlerRegistry access$400(zendesk.support.request.ComponentUpdateActionHandlers componentUpdateActionHandlers) {
        return componentUpdateActionHandlers.actionHandlerRegistry;
    }

    private List<RequestInfo.AgentInfo> getLast5AgentInfos(List<zendesk.support.request.StateMessage> list, List<zendesk.support.request.StateRequestUser> list2) {
        int size;
        boolean userId;
        long valueOf;
        long avatar;
        boolean agentInfo;
        HashMap hashMap = new HashMap(list2.size());
        Iterator obj7 = list2.iterator();
        while (obj7.hasNext()) {
            size = obj7.next();
            valueOf = (StateRequestUser)size.getId();
            if (size.isAgent() && !hashMap.containsKey(Long.valueOf(valueOf))) {
            }
            if (!hashMap.containsKey(Long.valueOf(valueOf))) {
            }
            hashMap.put(Long.valueOf(valueOf), size);
        }
        obj7 = new ArrayList();
        List obj6 = a.c(list);
        Collections.reverse(obj6);
        obj6 = obj6.iterator();
        while (obj6.hasNext()) {
            userId = (StateMessage)obj6.next().getUserId();
            if (hashMap.containsKey(Long.valueOf(userId)) != 0) {
            } else {
            }
            Object obj = hashMap.get(Long.valueOf(userId));
            agentInfo = new RequestInfo.AgentInfo(String.valueOf(userId), (StateRequestUser)obj.getName(), obj.getAvatar());
            obj7.add(agentInfo);
            if (obj7.size() != 5) {
            }
        }
        Collections.reverse(obj7);
        return obj7;
    }

    private boolean hasPendingMessages(zendesk.support.request.StateConversation stateConversation) {
        int status;
        int i;
        Iterator obj3 = stateConversation.getMessages().iterator();
        for (StateMessage next2 : obj3) {
        }
        return 0;
    }

    private RequestInfo map(zendesk.support.request.StateConversation stateConversation) {
        String valueOf2;
        String valueOf;
        long l;
        List messages = stateConversation.getMessages();
        if (a.g(messages)) {
            return null;
        }
        Object obj = messages.get(0);
        int i4 = 1;
        Object obj2 = messages.get(size -= i4);
        RequestInfo.MessageInfo messageInfo = new RequestInfo.MessageInfo(String.valueOf((StateMessage)obj.getId()), obj.getDate(), obj.getBody());
        RequestInfo.MessageInfo messageInfo2 = new RequestInfo.MessageInfo(String.valueOf(obj2.getId()), obj2.getDate(), obj2.getBody());
        HashSet hashSet = new HashSet();
        Iterator iterator = messages.iterator();
        while (iterator.hasNext()) {
            Object next2 = iterator.next();
            if (next2.getState().getStatus() == i4) {
            }
            hashSet.add(String.valueOf((StateMessage)next2.getId()));
        }
        super(stateConversation.getLocalId(), stateConversation.getRemoteId(), stateConversation.getStatus(), 0, (StateMessage)obj2.getDate(), getLast5AgentInfos(stateConversation.getMessages(), stateConversation.getUsers()), messageInfo, messageInfo2, hashSet);
        return requestInfo;
    }

    @Override // o.b.k
    public void update(Object object) {
        update((StateConversation)object);
    }

    @Override // o.b.k
    public void update(zendesk.support.request.StateConversation stateConversation) {
        Object queue;
        Object anon;
        zendesk.support.request.StateConversation obj3;
        queue = map(stateConversation);
        if (queue != null) {
            if (!hasPendingMessages(stateConversation)) {
                anon = new ComponentUpdateActionHandlers.1(this, queue);
                this.queue.dispatch(anon);
            }
        } else {
            anon = new ComponentUpdateActionHandlers.2(this, stateConversation);
            this.queue.dispatch(anon);
        }
    }
}
