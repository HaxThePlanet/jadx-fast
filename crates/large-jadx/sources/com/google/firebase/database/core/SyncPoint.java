package com.google.firebase.database.core;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.core.operation.Operation;
import com.google.firebase.database.core.operation.OperationSource;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.utilities.Pair;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.CacheNode;
import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.core.view.DataEvent;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.core.view.Event.EventType;
import com.google.firebase.database.core.view.QueryParams;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.core.view.View;
import com.google.firebase.database.core.view.ViewCache;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public class SyncPoint {

    private final PersistenceManager persistenceManager;
    private final Map<QueryParams, View> views;
    public SyncPoint(PersistenceManager persistenceManager) {
        super();
        HashMap hashMap = new HashMap();
        this.views = hashMap;
        this.persistenceManager = persistenceManager;
    }

    private List<DataEvent> applyOperationToView(View view, Operation operation2, com.google.firebase.database.core.WriteTreeRef writeTreeRef3, Node node4) {
        PersistenceManager persistenceManager;
        boolean childKey;
        Event.EventType eventType;
        Event.EventType cHILD_REMOVED;
        QuerySpec obj5;
        boolean obj7;
        Object obj8;
        final com.google.firebase.database.core.view.View.OperationResult obj6 = view.applyOperation(operation2, writeTreeRef3, node4);
        if (!view.getQuery().loadsAllData()) {
            obj7 = new HashSet();
            obj8 = new HashSet();
            Iterator iterator = obj6.changes.iterator();
            while (iterator.hasNext()) {
                childKey = iterator.next();
                eventType = (Change)childKey.getEventType();
                if (eventType == Event.EventType.CHILD_ADDED) {
                } else {
                }
                if (eventType == Event.EventType.CHILD_REMOVED) {
                }
                obj7.add(childKey.getChildKey());
                obj8.add(childKey.getChildKey());
            }
            if (obj8.isEmpty()) {
                if (!obj7.isEmpty()) {
                    this.persistenceManager.updateTrackedQueryKeys(view.getQuery(), obj8, obj7);
                }
            } else {
            }
        }
        return obj6.events;
    }

    public List<DataEvent> addEventRegistration(com.google.firebase.database.core.EventRegistration eventRegistration, com.google.firebase.database.core.WriteTreeRef writeTreeRef2, CacheNode cacheNode3) {
        PersistenceManager persistenceManager;
        QueryParams params;
        boolean next;
        boolean obj6;
        QuerySpec querySpec = eventRegistration.getQuerySpec();
        final View obj5 = getView(querySpec, writeTreeRef2, cacheNode3);
        if (!querySpec.loadsAllData()) {
            obj6 = new HashSet();
            Iterator iterator = obj5.getEventCache().iterator();
            for (NamedNode next2 : iterator) {
                obj6.add(next2.getName());
            }
            this.persistenceManager.setTrackedQueryKeys(querySpec, obj6);
        }
        if (!this.views.containsKey(querySpec.getParams())) {
            this.views.put(querySpec.getParams(), obj5);
        }
        this.views.put(querySpec.getParams(), obj5);
        obj5.addEventRegistration(eventRegistration);
        return obj5.getInitialEvents(eventRegistration);
    }

    public List<DataEvent> applyOperation(Operation operation, com.google.firebase.database.core.WriteTreeRef writeTreeRef2, Node node3) {
        int i;
        List operationToView;
        QueryParams queryParams = operation.getSource().getQueryParams();
        if (queryParams != null) {
            Object obj = this.views.get(queryParams);
            i = (View)obj != null ? 1 : 0;
            Utilities.hardAssert(i);
            return applyOperationToView((View)obj, operation, writeTreeRef2, node3);
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.views.entrySet().iterator();
        for (Map.Entry next2 : iterator) {
            arrayList.addAll(applyOperationToView((View)next2.getValue(), operation, writeTreeRef2, node3));
        }
        return arrayList;
    }

    public Node getCompleteServerCache(com.google.firebase.database.core.Path path) {
        Object next;
        Node completeServerCache;
        Iterator iterator = this.views.values().iterator();
        for (View next : iterator) {
        }
        return null;
    }

    public View getCompleteView() {
        Object value;
        boolean loadsAllData;
        Iterator iterator = this.views.entrySet().iterator();
        for (Map.Entry next2 : iterator) {
            value = next2.getValue();
        }
        return null;
    }

    public List<View> getQueryViews() {
        Object value;
        boolean loadsAllData;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.views.entrySet().iterator();
        while (iterator.hasNext()) {
            value = (Map.Entry)iterator.next().getValue();
            if (!(View)value.getQuery().loadsAllData()) {
            }
            arrayList.add(value);
        }
        return arrayList;
    }

    public View getView(QuerySpec querySpec, com.google.firebase.database.core.WriteTreeRef writeTreeRef2, CacheNode cacheNode3) {
        int node2;
        Node calcCompleteEventCache;
        Node node;
        int obj6;
        Object obj = this.views.get(querySpec.getParams());
        if ((View)obj == null) {
            if (cacheNode3.isFullyInitialized()) {
                node2 = cacheNode3.getNode();
            } else {
                node2 = 0;
            }
            int i = 0;
            if (writeTreeRef2.calcCompleteEventCache(node2) != null) {
                obj6 = 1;
            } else {
                if (cacheNode3.getNode() != null) {
                    node = cacheNode3.getNode();
                } else {
                    node = EmptyNode.Empty();
                }
                calcCompleteEventCache = writeTreeRef2.calcCompleteEventChildren(node);
                obj6 = i;
            }
            CacheNode cacheNode = new CacheNode(IndexedNode.from(calcCompleteEventCache, querySpec.getIndex()), obj6, i);
            ViewCache viewCache = new ViewCache(cacheNode, cacheNode3);
            obj6 = new View(querySpec, viewCache);
            return obj6;
        }
        return (View)obj;
    }

    Map<QueryParams, View> getViews() {
        return this.views;
    }

    public boolean hasCompleteView() {
        int i;
        i = getCompleteView() != null ? 1 : 0;
        return i;
    }

    public boolean isEmpty() {
        return this.views.isEmpty();
    }

    public Pair<List<QuerySpec>, List<Event>> removeEventRegistration(QuerySpec querySpec, com.google.firebase.database.core.EventRegistration eventRegistration2, DatabaseError databaseError3) {
        Object iterator;
        QueryParams params;
        Object value;
        boolean loadsAllData;
        QuerySpec obj7;
        com.google.firebase.database.core.EventRegistration obj8;
        Object obj9;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (querySpec.isDefault()) {
            iterator = this.views.entrySet().iterator();
            while (iterator.hasNext()) {
                value = (Map.Entry)iterator.next().getValue();
                arrayList2.addAll((View)value.removeEventRegistration(eventRegistration2, databaseError3));
                iterator.remove();
                if (value.isEmpty() && !value.getQuery().loadsAllData()) {
                }
                iterator.remove();
                if (!value.getQuery().loadsAllData()) {
                }
                arrayList.add(value.getQuery());
            }
        } else {
            iterator = this.views.get(querySpec.getParams());
            arrayList2.addAll((View)iterator.removeEventRegistration(eventRegistration2, databaseError3));
            this.views.remove(querySpec.getParams());
            if (iterator != null && iterator.isEmpty() && !iterator.getQuery().loadsAllData()) {
                arrayList2.addAll(iterator.removeEventRegistration(eventRegistration2, databaseError3));
                if (iterator.isEmpty()) {
                    this.views.remove(querySpec.getParams());
                    if (!iterator.getQuery().loadsAllData()) {
                        arrayList.add(iterator.getQuery());
                    }
                }
            }
        }
        if (hasCompleteView() && !hasCompleteView()) {
            if (!hasCompleteView()) {
                arrayList.add(QuerySpec.defaultQueryAtPath(querySpec.getPath()));
            }
        }
        obj7 = new Pair(arrayList, arrayList2);
        return obj7;
    }

    public boolean viewExistsForQuery(QuerySpec querySpec) {
        int obj1;
        obj1 = viewForQuery(querySpec) != null ? 1 : 0;
        return obj1;
    }

    public View viewForQuery(QuerySpec querySpec) {
        if (querySpec.loadsAllData()) {
            return getCompleteView();
        }
        return (View)this.views.get(querySpec.getParams());
    }
}
