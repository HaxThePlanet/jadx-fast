package zendesk.support.request;

import f.g.e.a;
import f.g.e.g;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import o.b.k;
import o.b.o;
import o.b.p;
import zendesk.support.SupportUiStorage;

/* loaded from: classes3.dex */
class ComponentPersistence implements k<zendesk.support.request.ComponentPersistence.RequestPersistenceModel> {

    private static final String LOG_TAG = "ComponentPersistence";
    private final Executor executor;
    private final AtomicBoolean isMappingComplete;
    private final zendesk.support.request.ComponentPersistence.PersistenceSelector persistenceSelector;
    private final zendesk.support.request.ComponentPersistence.PersistenceQueue queue;
    private final SupportUiStorage supportUiStorage;

    interface Item {
        public abstract void persist();
    }

    static class PersistenceQueue {

        private final List<zendesk.support.request.ComponentPersistence.Item> actions;
        private final Executor executor;
        private final AtomicBoolean workerRunning;
        public PersistenceQueue(Executor executor) {
            super();
            ArrayList arrayList = new ArrayList(2);
            this.actions = arrayList;
            AtomicBoolean atomicBoolean = new AtomicBoolean(0);
            this.workerRunning = atomicBoolean;
            this.executor = executor;
        }

        static List access$300(zendesk.support.request.ComponentPersistence.PersistenceQueue componentPersistence$PersistenceQueue) {
            return persistenceQueue.actions;
        }

        static AtomicBoolean access$400(zendesk.support.request.ComponentPersistence.PersistenceQueue componentPersistence$PersistenceQueue) {
            return persistenceQueue.workerRunning;
        }

        private void startWorker() {
            boolean compareAndSet;
            int worker;
            int i;
            if (this.workerRunning.compareAndSet(false, true)) {
                worker = new ComponentPersistence.PersistenceQueue.Worker(this, 0);
                this.executor.execute(worker);
            }
        }

        void dispatch(zendesk.support.request.ComponentPersistence.Item componentPersistence$Item) {
            List actions2;
            List actions;
            int i;
            if (item != null) {
                actions2 = this.actions;
                synchronized (actions2) {
                    this.actions.set(1, item);
                    startWorker();
                }
            }
        }
    }

    static class RequestIdMapper {

        private final Map<String, String> localToRemote;
        private final Map<String, String> remoteToLocal;
        public RequestIdMapper() {
            super();
            HashMap hashMap = new HashMap();
            this.localToRemote = hashMap;
            HashMap hashMap2 = new HashMap();
            this.remoteToLocal = hashMap2;
        }

        zendesk.support.request.ComponentPersistence.RequestIdMapper addIdMapping(String string, String string2) {
            this.localToRemote.put(string2, string);
            this.remoteToLocal.put(string, string2);
            return this;
        }

        zendesk.support.request.ComponentPersistence.RequestIdMapper addLocalId(String string) {
            this.localToRemote.put(string, "");
            return this;
        }

        String getLocalId(String string) {
            return (String)this.remoteToLocal.get(string);
        }

        Set<String> getLocalIds() {
            return this.localToRemote.keySet();
        }

        String getRemoteId(String string) {
            return (String)this.localToRemote.get(string);
        }

        boolean hasLocalId(String string) {
            boolean remoteToLocal;
            Object obj2;
            if (this.remoteToLocal.containsKey(string) && g.c((String)this.remoteToLocal.get(string))) {
                obj2 = g.c((String)this.remoteToLocal.get(string)) ? 1 : 0;
            } else {
            }
            return obj2;
        }

        boolean hasRemoteId(String string) {
            boolean localToRemote;
            Object obj2;
            if (this.localToRemote.containsKey(string) && g.c((String)this.localToRemote.get(string))) {
                obj2 = g.c((String)this.localToRemote.get(string)) ? 1 : 0;
            } else {
            }
            return obj2;
        }

        zendesk.support.request.ComponentPersistence.RequestIdMapper removeLocalIdMapping(String string) {
            this.localToRemote.remove(string);
            return this;
        }
    }

    static class RequestPersistenceModel {

        private final transient boolean activityStopped;
        private final zendesk.support.request.StateConversation conversation;
        private final Date date;
        private final transient String requestId;
        private final String version;
        RequestPersistenceModel(String string, Date date2, String string3, zendesk.support.request.StateConversation stateConversation4, boolean z5) {
            super();
            this.requestId = string;
            this.date = date2;
            this.version = string3;
            this.conversation = stateConversation4;
            this.activityStopped = z5;
        }

        zendesk.support.request.StateConversation getConversation() {
            return this.conversation;
        }

        Date getDate() {
            return this.date;
        }

        String getLocalRequestId() {
            return this.requestId;
        }

        String getVersion() {
            return this.version;
        }

        boolean isActivityStopped() {
            return this.activityStopped;
        }
    }

    static class PersistenceItem implements zendesk.support.request.ComponentPersistence.Item {

        private final zendesk.support.request.ComponentPersistence.RequestPersistenceModel model;
        private final SupportUiStorage supportUiStorage;
        PersistenceItem(SupportUiStorage supportUiStorage, zendesk.support.request.ComponentPersistence.RequestPersistenceModel componentPersistence$RequestPersistenceModel2) {
            super();
            this.supportUiStorage = supportUiStorage;
            this.model = requestPersistenceModel2;
        }

        @Override // zendesk.support.request.ComponentPersistence$Item
        public void persist() {
            this.supportUiStorage.write(this.model.getLocalRequestId(), this.model);
        }
    }

    static class PersistenceSelector implements p<zendesk.support.request.ComponentPersistence.RequestPersistenceModel> {
        @Override // o.b.p
        public Object selectData(o o) {
            return selectData(o);
        }

        @Override // o.b.p
        public zendesk.support.request.ComponentPersistence.RequestPersistenceModel selectData(o o) {
            int obj7;
            final zendesk.support.request.StateConversation state = StateConversation.fromState(o);
            obj7 = StateAndroidLifecycle.fromState(o).getState() == 2 ? 1 : 0;
            Date date = new Date();
            super(state.getLocalId(), date, "5.0.3", state, obj7);
            return obj7;
        }
    }
    ComponentPersistence(SupportUiStorage supportUiStorage, zendesk.support.request.ComponentPersistence.PersistenceQueue componentPersistence$PersistenceQueue2, Executor executor3) {
        super();
        AtomicBoolean atomicBoolean = new AtomicBoolean(0);
        this.isMappingComplete = atomicBoolean;
        this.supportUiStorage = supportUiStorage;
        ComponentPersistence.PersistenceSelector obj3 = new ComponentPersistence.PersistenceSelector();
        this.persistenceSelector = obj3;
        this.queue = persistenceQueue2;
        this.executor = executor3;
    }

    static SupportUiStorage access$000(zendesk.support.request.ComponentPersistence componentPersistence) {
        return componentPersistence.supportUiStorage;
    }

    static AtomicBoolean access$100(zendesk.support.request.ComponentPersistence componentPersistence) {
        return componentPersistence.isMappingComplete;
    }

    private void persistConversation(zendesk.support.request.ComponentPersistence.RequestPersistenceModel componentPersistence$RequestPersistenceModel) {
        boolean activityStopped;
        boolean persistenceItem;
        int supportUiStorage;
        supportUiStorage = requestPersistenceModel.getConversation().getMessages().size() > 0 ? 1 : 0;
        if (requestPersistenceModel.isActivityStopped() && g.c(requestPersistenceModel.getLocalRequestId()) && supportUiStorage != null) {
            if (g.c(requestPersistenceModel.getLocalRequestId())) {
                if (supportUiStorage != null) {
                    persistenceItem = new ComponentPersistence.PersistenceItem(this.supportUiStorage, requestPersistenceModel);
                    this.queue.dispatch(persistenceItem);
                }
            }
        }
    }

    private void persistRequestId(zendesk.support.request.ComponentPersistence.RequestPersistenceModel componentPersistence$RequestPersistenceModel) {
        boolean remoteId;
        Object localId;
        int i;
        zendesk.support.request.ComponentPersistence.1 anon;
        boolean z;
        zendesk.support.request.ComponentPersistence.RequestPersistenceModel obj6;
        if (!this.isMappingComplete.get()) {
            remoteId = requestPersistenceModel.getConversation().getRemoteId();
            localId = requestPersistenceModel.getConversation().getLocalId();
            anon = 1;
            obj6 = requestPersistenceModel.getConversation().getMessages().size() > 0 ? anon : i;
            if (g.c(remoteId) && g.c(localId)) {
                if (g.c(localId)) {
                    i = anon;
                }
            }
            if (i == 0) {
                if (obj6 != null && i != 0) {
                    if (i != 0) {
                        this.isMappingComplete.set(anon);
                    }
                    anon = new ComponentPersistence.1(this, i, remoteId, localId);
                    this.executor.execute(anon);
                }
            } else {
            }
        } else {
            if (a.g(requestPersistenceModel.getConversation().getMessages())) {
                localId = new ComponentPersistence.2(this, requestPersistenceModel);
                this.executor.execute(localId);
            }
        }
    }

    p<zendesk.support.request.ComponentPersistence.RequestPersistenceModel> getSelector() {
        return this.persistenceSelector;
    }

    @Override // o.b.k
    public void update(Object object) {
        update((ComponentPersistence.RequestPersistenceModel)object);
    }

    @Override // o.b.k
    public void update(zendesk.support.request.ComponentPersistence.RequestPersistenceModel componentPersistence$RequestPersistenceModel) {
        persistConversation(requestPersistenceModel);
        persistRequestId(requestPersistenceModel);
    }
}
