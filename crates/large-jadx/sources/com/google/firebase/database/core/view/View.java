package com.google.firebase.database.core.view;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.core.EventRegistration;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.WriteTreeRef;
import com.google.firebase.database.core.operation.Operation;
import com.google.firebase.database.core.operation.Operation.OperationType;
import com.google.firebase.database.core.operation.OperationSource;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.filter.IndexedFilter;
import com.google.firebase.database.core.view.filter.NodeFilter;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class View {

    private final com.google.firebase.database.core.view.EventGenerator eventGenerator;
    private final List<EventRegistration> eventRegistrations;
    private final com.google.firebase.database.core.view.ViewProcessor processor;
    private final com.google.firebase.database.core.view.QuerySpec query;
    private com.google.firebase.database.core.view.ViewCache viewCache;

    public static class OperationResult {

        public final List<com.google.firebase.database.core.view.Change> changes;
        public final List<com.google.firebase.database.core.view.DataEvent> events;
        public OperationResult(List<com.google.firebase.database.core.view.DataEvent> list, List<com.google.firebase.database.core.view.Change> list2) {
            super();
            this.events = list;
            this.changes = list2;
        }
    }
    public View(com.google.firebase.database.core.view.QuerySpec querySpec, com.google.firebase.database.core.view.ViewCache viewCache2) {
        super();
        this.query = querySpec;
        IndexedFilter indexedFilter = new IndexedFilter(querySpec.getIndex());
        NodeFilter nodeFilter = querySpec.getParams().getNodeFilter();
        ViewProcessor viewProcessor = new ViewProcessor(nodeFilter);
        this.processor = viewProcessor;
        com.google.firebase.database.core.view.CacheNode serverCache = viewCache2.getServerCache();
        com.google.firebase.database.core.view.CacheNode obj9 = viewCache2.getEventCache();
        IndexedNode from = IndexedNode.from(EmptyNode.Empty(), querySpec.getIndex());
        int i = 0;
        CacheNode cacheNode2 = new CacheNode(indexedFilter.updateFullNode(from, serverCache.getIndexedNode(), i), serverCache.isFullyInitialized(), indexedFilter.filtersNodes());
        CacheNode cacheNode = new CacheNode(nodeFilter.updateFullNode(from, obj9.getIndexedNode(), i), obj9.isFullyInitialized(), nodeFilter.filtersNodes());
        obj9 = new ViewCache(cacheNode, cacheNode2);
        this.viewCache = obj9;
        obj9 = new ArrayList();
        this.eventRegistrations = obj9;
        obj9 = new EventGenerator(querySpec);
        this.eventGenerator = obj9;
    }

    private List<com.google.firebase.database.core.view.DataEvent> generateEventsForChanges(List<com.google.firebase.database.core.view.Change> list, IndexedNode indexedNode2, EventRegistration eventRegistration3) {
        EventRegistration[] arr;
        int i;
        List obj5;
        if (eventRegistration3 == null) {
            obj5 = this.eventRegistrations;
        } else {
            arr = new EventRegistration[1];
            obj5 = Arrays.asList(eventRegistration3);
        }
        return this.eventGenerator.generateEventsForChanges(list, indexedNode2, obj5);
    }

    public void addEventRegistration(EventRegistration eventRegistration) {
        this.eventRegistrations.add(eventRegistration);
    }

    public com.google.firebase.database.core.view.View.OperationResult applyOperation(Operation operation, WriteTreeRef writeTreeRef2, Node node3) {
        Operation.OperationType queryParams;
        int i2;
        Object merge;
        int i;
        boolean obj6;
        i = 0;
        final int i4 = 1;
        if (operation.getType() == Operation.OperationType.Merge && operation.getSource().getQueryParams() != null) {
            if (operation.getSource().getQueryParams() != null) {
                i2 = this.viewCache.getCompleteServerSnap() != null ? i4 : i;
                Utilities.hardAssert(i2, "We should always have a full cache before handling merges");
                queryParams = this.viewCache.getCompleteEventSnap() != null ? i4 : i;
                Utilities.hardAssert(queryParams, "Missing event cache, even though we have a server cache");
            }
        }
        com.google.firebase.database.core.view.ViewCache viewCache = this.viewCache;
        com.google.firebase.database.core.view.ViewProcessor.ProcessorResult obj5 = this.processor.applyOperation(viewCache, operation, writeTreeRef2, node3);
        if (!obj5.viewCache.getServerCache().isFullyInitialized()) {
            if (!viewCache.getServerCache().isFullyInitialized()) {
                i = i4;
            }
        } else {
        }
        Utilities.hardAssert(i, "Once a server snap is complete, it should never go back");
        obj6 = obj5.viewCache;
        this.viewCache = obj6;
        View.OperationResult obj7 = new View.OperationResult(generateEventsForChanges(obj5.changes, obj6.getEventCache().getIndexedNode(), 0), obj5.changes);
        return obj7;
    }

    public Node getCompleteNode() {
        return this.viewCache.getCompleteEventSnap();
    }

    public Node getCompleteServerCache(Path path) {
        boolean loadsAllData;
        Node completeServerSnap = this.viewCache.getCompleteServerSnap();
        if (completeServerSnap != null && !this.query.loadsAllData() && !path.isEmpty() && !completeServerSnap.getImmediateChild(path.getFront()).isEmpty()) {
            if (!this.query.loadsAllData()) {
                if (!path.isEmpty()) {
                    if (!completeServerSnap.getImmediateChild(path.getFront()).isEmpty()) {
                    }
                }
            }
            return completeServerSnap.getChild(path);
        }
        return null;
    }

    public Node getEventCache() {
        return this.viewCache.getEventCache().getNode();
    }

    List<EventRegistration> getEventRegistrations() {
        return this.eventRegistrations;
    }

    public List<com.google.firebase.database.core.view.DataEvent> getInitialEvents(EventRegistration eventRegistration) {
        boolean fullyInitialized;
        com.google.firebase.database.core.view.Change childAddedChange;
        com.google.firebase.database.snapshot.ChildKey name;
        com.google.firebase.database.core.view.CacheNode eventCache = this.viewCache.getEventCache();
        ArrayList arrayList = new ArrayList();
        Iterator iterator = eventCache.getNode().iterator();
        for (NamedNode next2 : iterator) {
            arrayList.add(Change.childAddedChange(next2.getName(), next2.getNode()));
        }
        if (eventCache.isFullyInitialized()) {
            arrayList.add(Change.valueChange(eventCache.getIndexedNode()));
        }
        return generateEventsForChanges(arrayList, eventCache.getIndexedNode(), eventRegistration);
    }

    public com.google.firebase.database.core.view.QuerySpec getQuery() {
        return this.query;
    }

    public Node getServerCache() {
        return this.viewCache.getServerCache().getNode();
    }

    public boolean isEmpty() {
        return this.eventRegistrations.isEmpty();
    }

    public List<com.google.firebase.database.core.view.Event> removeEventRegistration(EventRegistration eventRegistration, DatabaseError databaseError2) {
        int i2;
        Object arrayList;
        int i;
        Path zombied;
        Iterator iterator;
        boolean sameListener;
        com.google.firebase.database.core.view.CancelEvent cancelEvent;
        Object obj7;
        int obj8;
        if (databaseError2 != null) {
            arrayList = new ArrayList();
            i = eventRegistration == null ? 1 : i2;
            Utilities.hardAssert(i, "A cancel should cancel all event registrations");
            iterator = this.eventRegistrations.iterator();
            for (EventRegistration sameListener : iterator) {
                cancelEvent = new CancelEvent(sameListener, databaseError2, this.query.getPath());
                arrayList.add(cancelEvent);
            }
        } else {
            arrayList = Collections.emptyList();
        }
        if (eventRegistration != null) {
            obj8 = -1;
            zombied = obj8;
            while (i2 < this.eventRegistrations.size()) {
                iterator = this.eventRegistrations.get(i2);
                i2++;
                zombied = i2;
            }
            i2 = zombied;
            if (i2 != obj8) {
                this.eventRegistrations.remove(i2);
                (EventRegistration)this.eventRegistrations.get(i2).zombify();
            }
        } else {
            obj7 = this.eventRegistrations.iterator();
            for (EventRegistration obj8 : obj7) {
                obj8.zombify();
            }
            this.eventRegistrations.clear();
        }
        return arrayList;
    }
}
