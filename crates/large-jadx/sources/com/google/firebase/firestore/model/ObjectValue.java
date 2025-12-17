package com.google.firebase.firestore.model;

import com.google.firebase.firestore.model.mutation.FieldMask;
import com.google.firebase.firestore.util.Assert;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import f.c.e.c.r;
import f.c.e.c.r.b;
import f.c.e.c.x;
import f.c.e.c.x.b;
import f.c.e.c.x.c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public final class ObjectValue implements java.lang.Cloneable {

    private Map<String, Object> overlayMap;
    private x partialValue;
    public ObjectValue() {
        x.b bVar = x.x();
        bVar.l(r.d());
        super((x)bVar.build());
    }

    public ObjectValue(x x) {
        int i;
        super();
        HashMap hashMap = new HashMap();
        this.overlayMap = hashMap;
        int i3 = 1;
        final int i4 = 0;
        i = x.w() == x.c.MAP_VALUE ? i3 : i4;
        Assert.hardAssert(i, "ObjectValues should be backed by a MapValue", new Object[i4]);
        Assert.hardAssert(serverTimestamp ^= i3, "ServerTimestamps should not be used as an ObjectValue", new Object[i4]);
        this.partialValue = x;
    }

    private r applyOverlay(com.google.firebase.firestore.model.FieldPath fieldPath, Map<String, Object> map2) {
        z.a builder;
        int build;
        Object overlay;
        Object key;
        com.google.firebase.firestore.model.BasePath append;
        int i;
        z obj8;
        x nestedValue = extractNestedValue(this.partialValue, fieldPath);
        if (Values.isMapValue(nestedValue)) {
            builder = nestedValue.t().toBuilder();
        } else {
            builder = r.l();
        }
        Iterator obj9 = map2.entrySet().iterator();
        int i2 = 0;
        build = i2;
        while (obj9.hasNext()) {
            Object next2 = obj9.next();
            key = (Map.Entry)next2.getKey();
            overlay = next2.getValue();
            i = 1;
            if (overlay instanceof Map != null) {
            } else {
            }
            if (overlay instanceof x != null) {
            } else {
            }
            if (builder.b((String)key)) {
            }
            if (overlay == null) {
            } else {
            }
            build = i2;
            Assert.hardAssert(build, "Expected entry to be a Map, a Value or null", new Object[i2]);
            builder.e(key);
            build = i;
            build = i;
            builder.d(key, (x)overlay);
            overlay = applyOverlay((FieldPath)fieldPath.append(key), (Map)overlay);
            if (overlay != null) {
            }
            x.b bVar = x.x();
            bVar.l(overlay);
            builder.d(key, (x)bVar.build());
        }
        if (build != 0) {
            obj8 = builder.build();
        } else {
            obj8 = 0;
        }
        return obj8;
    }

    private x buildProto() {
        Object overlayMap2;
        Object overlayMap;
        overlayMap2 = applyOverlay(FieldPath.EMPTY_PATH, this.overlayMap);
        if (overlayMap2 != null) {
            overlayMap = x.x();
            overlayMap.l(overlayMap2);
            this.partialValue = (x)overlayMap.build();
            this.overlayMap.clear();
        }
        return this.partialValue;
    }

    private FieldMask extractFieldMask(r r) {
        Object iterator;
        com.google.firebase.firestore.model.FieldPath singleSegment;
        boolean mapValue;
        HashSet hashSet = new HashSet();
        Iterator obj5 = r.f().entrySet().iterator();
        while (obj5.hasNext()) {
            iterator = obj5.next();
            singleSegment = FieldPath.fromSingleSegment((String)(Map.Entry)iterator.getKey());
            if (Values.isMapValue((x)iterator.getValue())) {
            } else {
            }
            hashSet.add(singleSegment);
            iterator = extractFieldMask((x)iterator.getValue().t()).getMask();
            if (iterator.isEmpty()) {
            } else {
            }
            iterator = iterator.iterator();
            for (FieldPath next2 : iterator) {
                hashSet.add((FieldPath)singleSegment.append(next2));
            }
            hashSet.add((FieldPath)singleSegment.append((FieldPath)iterator.next()));
            hashSet.add(singleSegment);
        }
        return FieldMask.fromSet(hashSet);
    }

    private x extractNestedValue(x x, com.google.firebase.firestore.model.FieldPath fieldPath2) {
        int i;
        boolean mapValue;
        int i2;
        x obj4;
        if (fieldPath2.isEmpty()) {
            return x;
        }
        i = 0;
        i2 = 0;
        while (i < length--) {
            i++;
            i2 = 0;
        }
        return obj4.t().g(fieldPath2.getLastSegment(), i2);
    }

    public static com.google.firebase.firestore.model.ObjectValue fromMap(Map<String, x> map) {
        final x.b bVar = x.x();
        final r.b bVar2 = r.l();
        bVar2.c(map);
        bVar.k(bVar2);
        ObjectValue objectValue = new ObjectValue((x)bVar.build());
        return objectValue;
    }

    private void setOverlay(com.google.firebase.firestore.model.FieldPath fieldPath, x x2) {
        Map overlayMap;
        int i;
        String segment;
        Map hashMap;
        HashMap hashMap2;
        x.c mAP_VALUE;
        overlayMap = this.overlayMap;
        i = 0;
        while (i < length--) {
            segment = fieldPath.getSegment(i);
            hashMap = overlayMap.get(segment);
            if (hashMap instanceof Map != null) {
            } else {
            }
            if (hashMap instanceof x) {
            } else {
            }
            hashMap = new HashMap();
            overlayMap.put(segment, hashMap);
            overlayMap = hashMap;
            i++;
            if ((x)hashMap.w() == x.c.MAP_VALUE) {
            } else {
            }
            hashMap2 = new HashMap(hashMap.t().f());
            overlayMap.put(segment, hashMap2);
            overlayMap = hashMap2;
        }
        overlayMap.put(fieldPath.getLastSegment(), x2);
    }

    @Override // java.lang.Cloneable
    public com.google.firebase.firestore.model.ObjectValue clone() {
        ObjectValue objectValue = new ObjectValue(buildProto());
        return objectValue;
    }

    @Override // java.lang.Cloneable
    public Object clone() {
        return clone();
    }

    @Override // java.lang.Cloneable
    public void delete(com.google.firebase.firestore.model.FieldPath fieldPath) {
        Assert.hardAssert(empty ^= 1, "Cannot delete field for empty path on ObjectValue", new Object[0]);
        setOverlay(fieldPath, 0);
    }

    @Override // java.lang.Cloneable
    public boolean equals(Object object) {
        if (this == object) {
            return 1;
        }
        if (object instanceof ObjectValue) {
            return Values.equals(buildProto(), (ObjectValue)object.buildProto());
        }
        return 0;
    }

    @Override // java.lang.Cloneable
    public x get(com.google.firebase.firestore.model.FieldPath fieldPath) {
        return extractNestedValue(buildProto(), fieldPath);
    }

    @Override // java.lang.Cloneable
    public FieldMask getFieldMask() {
        return extractFieldMask(buildProto().t());
    }

    public Map<String, x> getFieldsMap() {
        return buildProto().t().f();
    }

    @Override // java.lang.Cloneable
    public int hashCode() {
        return buildProto().hashCode();
    }

    @Override // java.lang.Cloneable
    public void set(com.google.firebase.firestore.model.FieldPath fieldPath, x x2) {
        Assert.hardAssert(empty ^= 1, "Cannot set field for empty path on ObjectValue", new Object[0]);
        setOverlay(fieldPath, x2);
    }

    public void setAll(Map<com.google.firebase.firestore.model.FieldPath, x> map) {
        Object value2;
        Object key;
        Object value;
        Iterator obj4 = map.entrySet().iterator();
        while (obj4.hasNext()) {
            value2 = obj4.next();
            key = (Map.Entry)value2.getKey();
            if (value2.getValue() == null) {
            } else {
            }
            set((FieldPath)key, (x)value2.getValue());
            delete(key);
        }
    }

    @Override // java.lang.Cloneable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ObjectValue{internalValue=");
        stringBuilder.append(Values.canonicalId(buildProto()));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
