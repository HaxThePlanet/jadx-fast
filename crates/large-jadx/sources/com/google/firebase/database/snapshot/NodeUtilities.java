package com.google.firebase.database.snapshot;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.collection.ImmutableSortedMap.Builder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class NodeUtilities {
    public static com.google.firebase.database.snapshot.Node NodeFromJSON(Object object) {
        return NodeUtilities.NodeFromJSON(object, PriorityUtilities.NullPriority());
    }

    public static com.google.firebase.database.snapshot.Node NodeFromJSON(Object object, com.google.firebase.database.snapshot.Node node2) {
        boolean z;
        HashMap hashMap;
        String str;
        Iterator iterator;
        boolean string;
        boolean next;
        boolean startsWith;
        boolean empty;
        Object obj5;
        Object obj6;
        String str3 = ".value";
        str = ".priority";
        string = object;
        if (object instanceof Map != null && (Map)string.containsKey(str)) {
            string = object;
            if ((Map)string.containsKey(str)) {
                obj6 = PriorityUtilities.parsePriority(string.get(str));
            }
            if (string.containsKey(str3)) {
                try {
                    obj5 = string.get(str3);
                    if (obj5 == null) {
                    }
                    return EmptyNode.Empty();
                    if (obj5 instanceof String != null) {
                    }
                    StringNode stringNode = new StringNode((String)obj5, obj6);
                    return stringNode;
                    if (obj5 instanceof Long) {
                    }
                    LongNode longNode2 = new LongNode((Long)obj5, obj6);
                    return longNode2;
                    if (obj5 instanceof Integer) {
                    }
                    LongNode longNode = new LongNode(Long.valueOf((long)obj5), obj6);
                    return longNode;
                    if (obj5 instanceof Double) {
                    }
                    DoubleNode doubleNode = new DoubleNode((Double)obj5, obj6);
                    return doubleNode;
                    if (obj5 instanceof Boolean) {
                    }
                    BooleanNode booleanNode = new BooleanNode((Boolean)obj5, obj6);
                    return booleanNode;
                    if (obj5 instanceof Map == null) {
                    }
                    if (obj5 instanceof List == null) {
                    } else {
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to parse node with class ");
                    stringBuilder.append(obj5.getClass().toString());
                    obj6 = new DatabaseException(stringBuilder.toString());
                    throw obj6;
                    if (obj5 instanceof Map != null) {
                    } else {
                    }
                    if ((Map)obj5.containsKey(".sv")) {
                    }
                    DeferredValueNode deferredValueNode = new DeferredValueNode(obj5, obj6);
                    return deferredValueNode;
                    hashMap = new HashMap(obj5.size());
                    iterator = obj5.keySet().iterator();
                    while (iterator.hasNext()) {
                        string = iterator.next();
                        startsWith = NodeUtilities.NodeFromJSON(obj5.get(string));
                        if (!(String)string.startsWith(".") && !startsWith.isEmpty()) {
                        }
                        startsWith = NodeUtilities.NodeFromJSON(obj5.get(string));
                        if (!startsWith.isEmpty()) {
                        }
                        hashMap.put(ChildKey.fromString(string), startsWith);
                    }
                    string = iterator.next();
                    startsWith = NodeUtilities.NodeFromJSON(obj5.get(string));
                    if (!(String)string.startsWith(".") && !startsWith.isEmpty()) {
                    }
                    startsWith = NodeUtilities.NodeFromJSON(obj5.get(string));
                    if (!startsWith.isEmpty()) {
                    }
                    hashMap.put(ChildKey.fromString(string), startsWith);
                    hashMap = new HashMap((List)obj5.size());
                    iterator = 0;
                    while (iterator < obj5.size()) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("");
                        stringBuilder2.append(iterator);
                        startsWith = NodeUtilities.NodeFromJSON(obj5.get(iterator));
                        if (!startsWith.isEmpty()) {
                        }
                        iterator++;
                        hashMap.put(ChildKey.fromString(stringBuilder2.toString()), startsWith);
                    }
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("");
                    stringBuilder2.append(iterator);
                    startsWith = NodeUtilities.NodeFromJSON(obj5.get(iterator));
                    if (!startsWith.isEmpty()) {
                    }
                    hashMap.put(ChildKey.fromString(stringBuilder2.toString()), startsWith);
                    iterator++;
                    if (hashMap.isEmpty()) {
                    }
                    return EmptyNode.Empty();
                    ChildrenNode childrenNode = new ChildrenNode(ImmutableSortedMap.Builder.fromMap(hashMap, ChildrenNode.NAME_ONLY_COMPARATOR), obj6);
                    return childrenNode;
                    node2 = new DatabaseException("Failed to parse node", object);
                    throw node2;
                }
            }
        }
    }

    public static int nameAndPriorityCompare(com.google.firebase.database.snapshot.ChildKey childKey, com.google.firebase.database.snapshot.Node node2, com.google.firebase.database.snapshot.ChildKey childKey3, com.google.firebase.database.snapshot.Node node4) {
        final int obj1 = node2.compareTo(node4);
        if (obj1 != null) {
            return obj1;
        }
        return childKey.compareTo(childKey3);
    }
}
