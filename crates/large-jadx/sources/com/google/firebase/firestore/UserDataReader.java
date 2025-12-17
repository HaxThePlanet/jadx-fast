package com.google.firebase.firestore;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.core.UserData.ParseAccumulator;
import com.google.firebase.firestore.core.UserData.ParseContext;
import com.google.firebase.firestore.core.UserData.ParsedSetData;
import com.google.firebase.firestore.core.UserData.ParsedUpdateData;
import com.google.firebase.firestore.core.UserData.Source;
import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.model.ObjectValue;
import com.google.firebase.firestore.model.mutation.ArrayTransformOperation.Remove;
import com.google.firebase.firestore.model.mutation.ArrayTransformOperation.Union;
import com.google.firebase.firestore.model.mutation.FieldMask;
import com.google.firebase.firestore.model.mutation.NumericIncrementTransformOperation;
import com.google.firebase.firestore.model.mutation.ServerTimestampOperation;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.CustomClassMapper;
import com.google.firebase.firestore.util.Preconditions;
import com.google.firebase.firestore.util.Util;
import com.google.protobuf.c1;
import com.google.protobuf.r1;
import com.google.protobuf.r1.b;
import com.google.protobuf.z.a;
import f.c.e.c.a;
import f.c.e.c.a.b;
import f.c.e.c.r;
import f.c.e.c.r.b;
import f.c.e.c.x;
import f.c.e.c.x.b;
import f.c.e.c.x.c;
import f.c.h.b;
import f.c.h.b.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public final class UserDataReader {

    private final DatabaseId databaseId;
    public UserDataReader(DatabaseId databaseId) {
        super();
        this.databaseId = databaseId;
    }

    private ObjectValue convertAndParseDocumentData(Object object, UserData.ParseContext userData$ParseContext2) {
        String str2 = "Invalid data. Data must be a Map<String, Object> or a suitable POJO object, but it was ";
        if (object.getClass().isArray()) {
        } else {
            x obj5 = parseData(CustomClassMapper.convertToPlainJavaTypes(object), parseContext2);
            if (obj5.w() != x.c.MAP_VALUE) {
            } else {
                ObjectValue obj4 = new ObjectValue(obj5);
                return obj4;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str2);
            stringBuilder.append("of type: ");
            stringBuilder.append(Util.typeName(object));
            obj5 = new IllegalArgumentException(stringBuilder.toString());
            throw obj5;
        }
        obj5 = new StringBuilder();
        obj5.append(str2);
        obj5.append("an array");
        obj4 = new IllegalArgumentException(obj5.toString());
        throw obj4;
    }

    private List<x> parseArrayTransformElements(List<Object> list) {
        int i;
        x convertAndParseFieldData;
        UserData.ParseContext childContext;
        UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(UserData.Source.Argument);
        ArrayList arrayList = new ArrayList(list.size());
        i = 0;
        while (i < list.size()) {
            arrayList.add(convertAndParseFieldData(list.get(i), parseAccumulator.rootContext().childContext(i)));
            i++;
        }
        return arrayList;
    }

    private x parseData(Object object, UserData.ParseContext userData$ParseContext2) {
        com.google.firebase.firestore.model.FieldPath path;
        boolean arrayElement;
        UserData.Source arrayArgument;
        if (object instanceof Map != null) {
            return parseMap((Map)object, parseContext2);
        }
        if (object instanceof FieldValue) {
            parseSentinelFieldValue((FieldValue)object, parseContext2);
            return null;
        }
        if (parseContext2.getPath() != null) {
            parseContext2.addToFieldMask(parseContext2.getPath());
        }
        if (object instanceof List != null && parseContext2.isArrayElement()) {
            if (parseContext2.isArrayElement()) {
                if (parseContext2.getDataSource() != UserData.Source.ArrayArgument) {
                } else {
                }
                throw parseContext2.createError("Nested arrays are not supported");
            }
            return parseList((List)object, parseContext2);
        }
        return parseScalarValue(object, parseContext2);
    }

    private <T> x parseList(List<T> list, UserData.ParseContext userData$ParseContext2) {
        int i;
        x build;
        UserData.ParseContext childContext;
        final a.b bVar = a.l();
        Iterator obj5 = list.iterator();
        i = 0;
        while (obj5.hasNext()) {
            if (parseData(obj5.next(), parseContext2.childContext(i)) == null) {
            }
            bVar.c(build);
            i++;
            x.b bVar2 = x.x();
            bVar2.m(c1.NULL_VALUE);
            build = bVar2.build();
        }
        obj5 = x.x();
        obj5.c(bVar);
        return (x)obj5.build();
    }

    private <K, V> x parseMap(Map<K, V> map, UserData.ParseContext userData$ParseContext2) {
        x data;
        Object key;
        UserData.ParseContext childContext;
        com.google.firebase.firestore.model.FieldPath obj5;
        if (map.isEmpty() && parseContext2.getPath() != null && !parseContext2.getPath().isEmpty()) {
            if (parseContext2.getPath() != null) {
                if (!parseContext2.getPath().isEmpty()) {
                    parseContext2.addToFieldMask(parseContext2.getPath());
                }
            }
            obj5 = x.x();
            obj5.l(r.d());
            return (x)obj5.build();
        }
        r.b bVar = r.l();
        obj5 = map.entrySet().iterator();
        for (Map.Entry next2 : obj5) {
            key = next2.getKey();
            data = parseData(next2.getValue(), parseContext2.childContext((String)key));
            if (data != null) {
            }
            bVar.d(key, data);
        }
        obj5 = x.x();
        obj5.k(bVar);
        return (x)obj5.build();
    }

    private x parseScalarValue(Object object, UserData.ParseContext userData$ParseContext2) {
        Object databaseId;
        boolean equals;
        if (object == null) {
            x.b obj7 = x.x();
            obj7.m(c1.NULL_VALUE);
            return (x)obj7.build();
        }
        if (object instanceof Integer) {
            x.b obj8 = x.x();
            obj8.j((long)obj7);
            return (x)obj8.build();
        }
        if (object instanceof Long) {
            obj8 = x.x();
            obj8.j((Long)object.longValue());
            return (x)obj8.build();
        }
        if (object instanceof Float) {
            obj8 = x.x();
            obj8.g((Float)object.doubleValue());
            return (x)obj8.build();
        }
        if (object instanceof Double) {
            obj8 = x.x();
            obj8.g((Double)object.doubleValue());
            return (x)obj8.build();
        }
        if (object instanceof Boolean) {
            obj8 = x.x();
            obj8.e((Boolean)object.booleanValue());
            return (x)obj8.build();
        }
        if (object instanceof String != null) {
            obj8 = x.x();
            obj8.o((String)object);
            return (x)obj8.build();
        }
        if (object instanceof Date) {
            obj8 = new Timestamp((Date)object);
            return parseTimestamp(obj8);
        }
        if (object instanceof Timestamp) {
            return parseTimestamp((Timestamp)object);
        }
        if (object instanceof GeoPoint) {
            obj8 = x.x();
            b.b bVar = b.h();
            bVar.b((GeoPoint)object.getLatitude());
            bVar.c(object.getLongitude());
            obj8.h(bVar);
            return (x)obj8.build();
        }
        if (object instanceof Blob) {
            obj8 = x.x();
            obj8.f((Blob)object.toByteString());
            return (x)obj8.build();
        }
        int i = 2;
        final int i2 = 1;
        int i3 = 0;
        int i4 = 3;
        if (object instanceof DocumentReference != null && (DocumentReference)object.getFirestore() != null) {
            i = 2;
            i2 = 1;
            i3 = 0;
            i4 = 3;
            if ((DocumentReference)object.getFirestore() != null) {
                databaseId = object.getFirestore().getDatabaseId();
                if (!databaseId.equals(this.databaseId)) {
                } else {
                }
                obj7 = new Object[4];
                obj7[i3] = databaseId.getProjectId();
                obj7[i2] = databaseId.getDatabaseId();
                obj7[i] = this.databaseId.getProjectId();
                obj7[i4] = this.databaseId.getDatabaseId();
                throw parseContext2.createError(String.format("Document reference is for database %s/%s but should be for database %s/%s", obj7));
            }
            obj8 = x.x();
            Object[] arr = new Object[i4];
            arr[i3] = this.databaseId.getProjectId();
            arr[i2] = this.databaseId.getDatabaseId();
            arr[i] = object.getPath();
            obj8.n(String.format("projects/%s/databases/%s/documents/%s", arr));
            return (x)obj8.build();
        }
        if (object.getClass().isArray()) {
            throw parseContext2.createError("Arrays are not supported; use a List instead");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported type: ");
        stringBuilder.append(Util.typeName(object));
        throw parseContext2.createError(stringBuilder.toString());
    }

    private void parseSentinelFieldValue(com.google.firebase.firestore.FieldValue fieldValue, UserData.ParseContext userData$ParseContext2) {
        Object numericIncrementTransformOperation;
        int i;
        com.google.firebase.firestore.model.FieldPath obj4;
        i = 1;
        final int i2 = 0;
        if (!parseContext2.isWrite()) {
        } else {
            if (parseContext2.getPath() == null) {
            } else {
                if (fieldValue instanceof FieldValue.DeleteFieldValue) {
                    if (parseContext2.getDataSource() == UserData.Source.MergeSet) {
                        parseContext2.addToFieldMask(parseContext2.getPath());
                    } else {
                        if (parseContext2.getDataSource() != UserData.Source.Update) {
                        } else {
                            if (parseContext2.getPath().length() > 0) {
                            } else {
                                i = i2;
                            }
                            Assert.hardAssert(i, "FieldValue.delete() at the top level should have already been handled.", new Object[i2]);
                            throw parseContext2.createError("FieldValue.delete() can only appear at the top level of your update data");
                        }
                    }
                    throw parseContext2.createError("FieldValue.delete() can only be used with update() and set() with SetOptions.merge()");
                }
                if (fieldValue instanceof FieldValue.ServerTimestampFieldValue) {
                    parseContext2.addToFieldTransforms(parseContext2.getPath(), ServerTimestampOperation.getInstance());
                } else {
                    if (fieldValue instanceof FieldValue.ArrayUnionFieldValue) {
                        numericIncrementTransformOperation = new ArrayTransformOperation.Union(parseArrayTransformElements((FieldValue.ArrayUnionFieldValue)fieldValue.getElements()));
                        parseContext2.addToFieldTransforms(parseContext2.getPath(), numericIncrementTransformOperation);
                    } else {
                        if (fieldValue instanceof FieldValue.ArrayRemoveFieldValue) {
                            numericIncrementTransformOperation = new ArrayTransformOperation.Remove(parseArrayTransformElements((FieldValue.ArrayRemoveFieldValue)fieldValue.getElements()));
                            parseContext2.addToFieldTransforms(parseContext2.getPath(), numericIncrementTransformOperation);
                        } else {
                            if (!fieldValue instanceof FieldValue.NumericIncrementFieldValue) {
                            } else {
                                numericIncrementTransformOperation = new NumericIncrementTransformOperation(parseQueryValue((FieldValue.NumericIncrementFieldValue)fieldValue.getOperand()));
                                parseContext2.addToFieldTransforms(parseContext2.getPath(), numericIncrementTransformOperation);
                            }
                        }
                    }
                }
                final Object[] obj5 = new Object[i];
                obj5[i2] = Util.typeName(fieldValue);
                throw Assert.fail("Unknown FieldValue type: %s", obj5);
            }
            Object[] arr2 = new Object[i];
            arr2[i2] = fieldValue.getMethodName();
            throw parseContext2.createError(String.format("%s() is not currently supported inside arrays", arr2));
        }
        Object[] arr = new Object[i];
        arr[i2] = fieldValue.getMethodName();
        throw parseContext2.createError(String.format("%s() can only be used with set() and update()", arr));
    }

    private x parseTimestamp(Timestamp timestamp) {
        final x.b bVar = x.x();
        final r1.b bVar2 = r1.h();
        bVar2.c(timestamp.getSeconds());
        bVar2.b(i *= 1000);
        bVar.p(bVar2);
        return (x)bVar.build();
    }

    public x convertAndParseFieldData(Object object, UserData.ParseContext userData$ParseContext2) {
        return parseData(CustomClassMapper.convertToPlainJavaTypes(object), parseContext2);
    }

    public UserData.ParsedSetData parseMergeData(Object object, FieldMask fieldMask2) {
        Object next;
        boolean contains;
        UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(UserData.Source.MergeSet);
        ObjectValue obj5 = convertAndParseDocumentData(object, parseAccumulator.rootContext());
        if (fieldMask2 != null) {
            Iterator iterator = fieldMask2.getMask().iterator();
            for (FieldPath next : iterator) {
            }
            return parseAccumulator.toMergeData(obj5, fieldMask2);
        }
        return parseAccumulator.toMergeData(obj5);
    }

    public x parseQueryValue(Object object) {
        return parseQueryValue(object, false);
    }

    public x parseQueryValue(Object object, boolean z2) {
        int i;
        UserData.Source obj6;
        obj6 = z2 ? UserData.Source.ArrayArgument : UserData.Source.Argument;
        UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(obj6);
        final x obj5 = convertAndParseFieldData(object, parseAccumulator.rootContext());
        obj6 = 0;
        i = obj5 != null ? 1 : obj6;
        Assert.hardAssert(i, "Parsed data should not be null.", new Object[obj6]);
        Assert.hardAssert(parseAccumulator.getFieldTransforms().isEmpty(), "Field transforms should have been disallowed.", new Object[obj6]);
        return obj5;
    }

    public UserData.ParsedSetData parseSetData(Object object) {
        UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(UserData.Source.Set);
        return parseAccumulator.toSetData(convertAndParseDocumentData(object, parseAccumulator.rootContext()));
    }

    public UserData.ParsedUpdateData parseUpdateData(List<Object> list) {
        int i2;
        com.google.firebase.firestore.model.FieldPath internalPath;
        Object convertAndParseFieldData;
        boolean childContext;
        int i;
        Object[] arr;
        String str;
        final int i4 = 1;
        final int i5 = 0;
        i2 = size %= 2 == 0 ? i4 : i5;
        Assert.hardAssert(i2, "Expected fieldAndValues to contain an even number of elements", new Object[i5]);
        UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(UserData.Source.Update);
        UserData.ParseContext rootContext = parseAccumulator.rootContext();
        ObjectValue objectValue = new ObjectValue();
        Iterator obj12 = list.iterator();
        while (obj12.hasNext()) {
            Object next2 = obj12.next();
            convertAndParseFieldData = obj12.next();
            boolean z = next2 instanceof String;
            if (!z) {
            } else {
            }
            i = i4;
            Assert.hardAssert(i, "Expected argument to be String or FieldPath.", new Object[i5]);
            if (z) {
            } else {
            }
            internalPath = (FieldPath)next2.getInternalPath();
            if (convertAndParseFieldData instanceof FieldValue.DeleteFieldValue) {
            } else {
            }
            convertAndParseFieldData = convertAndParseFieldData(convertAndParseFieldData, rootContext.childContext(internalPath));
            if (convertAndParseFieldData != null) {
            }
            rootContext.addToFieldMask(internalPath);
            objectValue.set(internalPath, convertAndParseFieldData);
            rootContext.addToFieldMask(internalPath);
            internalPath = FieldPath.fromDotSeparatedPath((String)next2).getInternalPath();
            if (next2 instanceof FieldPath != null) {
            } else {
            }
            i = i5;
        }
        return parseAccumulator.toUpdateData(objectValue);
    }

    public UserData.ParsedUpdateData parseUpdateData(Map<String, Object> map) {
        Object convertAndParseFieldData;
        com.google.firebase.firestore.model.FieldPath internalPath;
        boolean childContext;
        Preconditions.checkNotNull(map, "Provided update data must not be null.");
        UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(UserData.Source.Update);
        UserData.ParseContext rootContext = parseAccumulator.rootContext();
        ObjectValue objectValue = new ObjectValue();
        Iterator obj7 = map.entrySet().iterator();
        while (obj7.hasNext()) {
            Object next2 = obj7.next();
            internalPath = FieldPath.fromDotSeparatedPath((String)(Map.Entry)next2.getKey()).getInternalPath();
            convertAndParseFieldData = next2.getValue();
            if (convertAndParseFieldData instanceof FieldValue.DeleteFieldValue) {
            } else {
            }
            convertAndParseFieldData = convertAndParseFieldData(convertAndParseFieldData, rootContext.childContext(internalPath));
            if (convertAndParseFieldData != null) {
            }
            rootContext.addToFieldMask(internalPath);
            objectValue.set(internalPath, convertAndParseFieldData);
            rootContext.addToFieldMask(internalPath);
        }
        return parseAccumulator.toUpdateData(objectValue);
    }
}
