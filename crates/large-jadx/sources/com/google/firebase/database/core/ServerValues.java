package com.google.firebase.database.core;

import com.google.firebase.database.core.utilities.Clock;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.ChildrenNode;
import com.google.firebase.database.snapshot.ChildrenNode.ChildVisitor;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.snapshot.PriorityUtilities;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* loaded from: classes2.dex */
public class ServerValues {

    public static final String NAME_OP_INCREMENT = "increment";
    public static final String NAME_OP_TIMESTAMP = "timestamp";
    public static final String NAME_SUBKEY_SERVERVALUE = ".sv";
    static Node access$000(Node node, com.google.firebase.database.core.ValueProvider valueProvider2, Map map3) {
        return ServerValues.resolveDeferredValueSnapshot(node, valueProvider2, map3);
    }

    private static boolean canBeRepresentedAsLong(Number number) {
        Object obj1;
        if (!number instanceof Double && !number instanceof Float) {
            obj1 = !number instanceof Float ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public static Map<String, Object> generateServerValues(Clock clock) {
        HashMap hashMap = new HashMap();
        hashMap.put("timestamp", Long.valueOf(clock.millis()));
        return hashMap;
    }

    static Object resolveComplexDeferredValue(Map<String, Object> map, com.google.firebase.database.core.ValueProvider valueProvider2, Map<String, Object> map3) {
        boolean key;
        int i;
        int i2;
        Object obj6;
        Object obj7;
        boolean obj8;
        obj8 = "increment";
        final int i4 = 0;
        if (!map.containsKey(obj8)) {
            return i4;
        }
        obj6 = map.get(obj8);
        if (!obj6 instanceof Number) {
            return i4;
        }
        obj7 = valueProvider2.node();
        if (obj7.isLeafNode()) {
            if (!obj8 instanceof Number) {
            } else {
                obj7 = obj7.getValue();
                long longValue = obj6.longValue();
                long longValue2 = obj7.longValue();
                i2 = longValue + longValue2;
                if (ServerValues.canBeRepresentedAsLong((Number)obj6) && ServerValues.canBeRepresentedAsLong((Number)obj7) && Long.compare(key, i) >= 0) {
                    if (ServerValues.canBeRepresentedAsLong(obj7)) {
                        longValue = obj6.longValue();
                        longValue2 = obj7.longValue();
                        i2 = longValue + longValue2;
                        if (Long.compare(key, i) >= 0) {
                            return Long.valueOf(i2);
                        }
                    }
                }
                obj6 = Double.valueOf(doubleValue += obj6);
            }
        }
        return obj6;
    }

    public static Object resolveDeferredLeafValue(Object object, com.google.firebase.database.core.ValueProvider valueProvider2, Map<String, Object> map3) {
        int resolveComplexDeferredValue;
        boolean z;
        if (object instanceof Map == null) {
            return object;
        }
        Object obj = object;
        String str = ".sv";
        if (!(Map)obj.containsKey(str)) {
            return object;
        }
        Object obj2 = obj.get(str);
        resolveComplexDeferredValue = 0;
        if (obj2 instanceof String != null) {
            resolveComplexDeferredValue = ServerValues.resolveScalarDeferredValue((String)obj2, map3);
        } else {
            if (obj2 instanceof Map != null) {
                resolveComplexDeferredValue = ServerValues.resolveComplexDeferredValue((Map)obj2, valueProvider2, map3);
            }
        }
        if (resolveComplexDeferredValue == 0) {
            return object;
        }
        return resolveComplexDeferredValue;
    }

    public static com.google.firebase.database.core.CompoundWrite resolveDeferredValueMerge(com.google.firebase.database.core.CompoundWrite compoundWrite, com.google.firebase.database.core.SyncTree syncTree2, com.google.firebase.database.core.Path path3, Map<String, Object> map4) {
        com.google.firebase.database.core.CompoundWrite emptyWrite;
        Node resolveDeferredValueSnapshot;
        com.google.firebase.database.core.ValueProvider.DeferredValueProvider deferredValueProvider;
        Object key;
        emptyWrite = CompoundWrite.emptyWrite();
        final Iterator obj4 = compoundWrite.iterator();
        for (Map.Entry next2 : obj4) {
            deferredValueProvider = new ValueProvider.DeferredValueProvider(syncTree2, path3.child((Path)next2.getKey()));
            emptyWrite = emptyWrite.addWrite((Path)next2.getKey(), ServerValues.resolveDeferredValueSnapshot((Node)next2.getValue(), deferredValueProvider, map4));
        }
        return emptyWrite;
    }

    public static Node resolveDeferredValueSnapshot(Node node, com.google.firebase.database.core.SyncTree syncTree2, com.google.firebase.database.core.Path path3, Map<String, Object> map4) {
        ValueProvider.DeferredValueProvider deferredValueProvider = new ValueProvider.DeferredValueProvider(syncTree2, path3);
        return ServerValues.resolveDeferredValueSnapshot(node, deferredValueProvider, map4);
    }

    private static Node resolveDeferredValueSnapshot(Node node, com.google.firebase.database.core.ValueProvider valueProvider2, Map<String, Object> map3) {
        boolean obj5;
        Object value = node.getPriority().getValue();
        Object resolveDeferredLeafValue = ServerValues.resolveDeferredLeafValue(value, valueProvider2.getImmediateChild(ChildKey.fromString(".priority")), map3);
        Object obj4 = ServerValues.resolveDeferredLeafValue(node.getValue(), valueProvider2, map3);
        if (node.isLeafNode() && obj4.equals(node.getValue()) && !Utilities.equals(resolveDeferredLeafValue, value)) {
            obj4 = ServerValues.resolveDeferredLeafValue(node.getValue(), valueProvider2, map3);
            if (obj4.equals(node.getValue())) {
                if (!Utilities.equals(resolveDeferredLeafValue, value)) {
                }
                return node;
            }
            return NodeUtilities.NodeFromJSON(obj4, PriorityUtilities.parsePriority(resolveDeferredLeafValue));
        }
        if (node.isEmpty()) {
            return node;
        }
        SnapshotHolder snapshotHolder = new SnapshotHolder((ChildrenNode)node);
        ServerValues.1 anon = new ServerValues.1(valueProvider2, map3, snapshotHolder);
        node.forEachChild(anon);
        if (!snapshotHolder.getRootNode().getPriority().equals(resolveDeferredLeafValue)) {
            return snapshotHolder.getRootNode().updatePriority(PriorityUtilities.parsePriority(resolveDeferredLeafValue));
        }
        return snapshotHolder.getRootNode();
    }

    public static Node resolveDeferredValueSnapshot(Node node, Node node2, Map<String, Object> map3) {
        ValueProvider.ExistingValueProvider existingValueProvider = new ValueProvider.ExistingValueProvider(node2);
        return ServerValues.resolveDeferredValueSnapshot(node, existingValueProvider, map3);
    }

    static Object resolveScalarDeferredValue(String string, Map<String, Object> map2) {
        boolean equals;
        if ("timestamp".equals(string) && map2.containsKey(string)) {
            if (map2.containsKey(string)) {
                return map2.get(string);
            }
        }
        return null;
    }
}
