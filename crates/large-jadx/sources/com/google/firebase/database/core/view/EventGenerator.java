package com.google.firebase.database.core.view;

import com.google.firebase.database.core.EventRegistration;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.Index;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class EventGenerator {

    private final Index index;
    private final com.google.firebase.database.core.view.QuerySpec query;
    public EventGenerator(com.google.firebase.database.core.view.QuerySpec querySpec) {
        super();
        this.query = querySpec;
        this.index = querySpec.getIndex();
    }

    static Index access$000(com.google.firebase.database.core.view.EventGenerator eventGenerator) {
        return eventGenerator.index;
    }

    private Comparator<com.google.firebase.database.core.view.Change> changeComparator() {
        EventGenerator.1 anon = new EventGenerator.1(this);
        return anon;
    }

    private com.google.firebase.database.core.view.DataEvent generateEvent(com.google.firebase.database.core.view.Change change, EventRegistration eventRegistration2, IndexedNode indexedNode3) {
        boolean childKey;
        Object cHILD_REMOVED;
        Index index;
        com.google.firebase.database.core.view.Change obj4;
        com.google.firebase.database.snapshot.ChildKey obj6;
        if (!change.getEventType().equals(Event.EventType.VALUE)) {
            if (change.getEventType().equals(Event.EventType.CHILD_REMOVED)) {
            } else {
                obj4 = change.changeWithPrevName(indexedNode3.getPredecessorChildName(change.getChildKey(), change.getIndexedNode().getNode(), this.index));
            }
        }
        return eventRegistration2.createEvent(obj4, this.query);
    }

    private void generateEventsForType(List<com.google.firebase.database.core.view.DataEvent> list, com.google.firebase.database.core.view.Event.EventType event$EventType2, List<com.google.firebase.database.core.view.Change> list3, List<EventRegistration> list4, IndexedNode indexedNode5) {
        ArrayList arrayList;
        Object next;
        boolean iterator;
        boolean equals;
        boolean respondsTo;
        arrayList = new ArrayList();
        Iterator obj7 = list3.iterator();
        while (obj7.hasNext()) {
            next = obj7.next();
            if ((Change)next.getEventType().equals(eventType2)) {
            }
            arrayList.add(next);
        }
        Collections.sort(arrayList, changeComparator());
        obj7 = arrayList.iterator();
        for (Change arrayList : obj7) {
            iterator = list4.iterator();
            while (iterator.hasNext()) {
                equals = iterator.next();
                if ((EventRegistration)equals.respondsTo(eventType2)) {
                }
                list.add(generateEvent(arrayList, equals, indexedNode5));
            }
            equals = iterator.next();
            if ((EventRegistration)equals.respondsTo(eventType2)) {
            }
            list.add(generateEvent(arrayList, equals, indexedNode5));
        }
    }

    public List<com.google.firebase.database.core.view.DataEvent> generateEventsForChanges(List<com.google.firebase.database.core.view.Change> list, IndexedNode indexedNode2, List<EventRegistration> list3) {
        Object childMovedChange;
        boolean indexedValueChanged;
        Object cHILD_CHANGED;
        com.google.firebase.database.snapshot.Node node;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            childMovedChange = iterator.next();
            if ((Change)childMovedChange.getEventType().equals(Event.EventType.CHILD_CHANGED) && this.index.indexedValueChanged(childMovedChange.getOldIndexedNode().getNode(), childMovedChange.getIndexedNode().getNode())) {
            }
            if (this.index.indexedValueChanged(childMovedChange.getOldIndexedNode().getNode(), childMovedChange.getIndexedNode().getNode())) {
            }
            arrayList2.add(Change.childMovedChange(childMovedChange.getChildKey(), childMovedChange.getIndexedNode()));
        }
        Object obj = this;
        ArrayList list2 = arrayList;
        List list4 = list;
        List list7 = list3;
        final IndexedNode indexedNode4 = indexedNode2;
        obj.generateEventsForType(list2, Event.EventType.CHILD_REMOVED, list4, list7, indexedNode4);
        obj.generateEventsForType(list2, Event.EventType.CHILD_ADDED, list4, list7, indexedNode4);
        obj.generateEventsForType(list2, Event.EventType.CHILD_MOVED, arrayList2, list7, indexedNode4);
        List list6 = list;
        obj.generateEventsForType(list2, Event.EventType.CHILD_CHANGED, list6, list7, indexedNode4);
        obj.generateEventsForType(list2, Event.EventType.VALUE, list6, list7, indexedNode4);
        return arrayList;
    }
}
