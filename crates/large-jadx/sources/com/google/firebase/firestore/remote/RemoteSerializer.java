package com.google.firebase.firestore.remote;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.core.Bound;
import com.google.firebase.firestore.core.FieldFilter;
import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.core.Filter.Operator;
import com.google.firebase.firestore.core.OrderBy;
import com.google.firebase.firestore.core.OrderBy.Direction;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.local.QueryPurpose;
import com.google.firebase.firestore.local.TargetData;
import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.ObjectValue;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.model.mutation.ArrayTransformOperation;
import com.google.firebase.firestore.model.mutation.ArrayTransformOperation.Remove;
import com.google.firebase.firestore.model.mutation.ArrayTransformOperation.Union;
import com.google.firebase.firestore.model.mutation.DeleteMutation;
import com.google.firebase.firestore.model.mutation.FieldMask;
import com.google.firebase.firestore.model.mutation.FieldTransform;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationResult;
import com.google.firebase.firestore.model.mutation.NumericIncrementTransformOperation;
import com.google.firebase.firestore.model.mutation.PatchMutation;
import com.google.firebase.firestore.model.mutation.Precondition;
import com.google.firebase.firestore.model.mutation.ServerTimestampOperation;
import com.google.firebase.firestore.model.mutation.SetMutation;
import com.google.firebase.firestore.model.mutation.VerifyMutation;
import com.google.firebase.firestore.util.Assert;
import com.google.protobuf.a0;
import com.google.protobuf.a0.b;
import com.google.protobuf.j;
import com.google.protobuf.r1;
import com.google.protobuf.r1.b;
import com.google.protobuf.z.a;
import f.c.e.c.a;
import f.c.e.c.a.b;
import f.c.e.c.c0;
import f.c.e.c.d;
import f.c.e.c.d.c;
import f.c.e.c.g;
import f.c.e.c.g.b;
import f.c.e.c.h;
import f.c.e.c.h.b;
import f.c.e.c.i;
import f.c.e.c.j;
import f.c.e.c.k;
import f.c.e.c.k.b;
import f.c.e.c.l;
import f.c.e.c.m.c;
import f.c.e.c.m.c.a;
import f.c.e.c.m.c.b;
import f.c.e.c.m.c.c;
import f.c.e.c.n;
import f.c.e.c.q;
import f.c.e.c.q.c;
import f.c.e.c.s;
import f.c.e.c.s.b;
import f.c.e.c.s.c;
import f.c.e.c.t;
import f.c.e.c.t.b;
import f.c.e.c.t.c;
import f.c.e.c.t.c.a;
import f.c.e.c.t.d;
import f.c.e.c.t.d.a;
import f.c.e.c.t.d.b;
import f.c.e.c.t.e;
import f.c.e.c.t.f;
import f.c.e.c.t.f.a;
import f.c.e.c.t.f.b;
import f.c.e.c.t.g;
import f.c.e.c.t.g.a;
import f.c.e.c.t.h;
import f.c.e.c.t.h.a;
import f.c.e.c.t.h.b;
import f.c.e.c.t.i;
import f.c.e.c.t.i.a;
import f.c.e.c.t.k;
import f.c.e.c.t.k.a;
import f.c.e.c.t.k.b;
import f.c.e.c.u;
import f.c.e.c.u.b;
import f.c.e.c.u.c;
import f.c.e.c.u.c.a;
import f.c.e.c.u.d;
import f.c.e.c.u.d.a;
import f.c.e.c.v;
import f.c.e.c.v.c;
import f.c.e.c.y;
import f.c.e.c.y.b;
import f.c.e.c.y.c;
import f.c.g.a;
import io.grpc.d1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class RemoteSerializer {

    private final DatabaseId databaseId;
    private final String databaseName;
    public RemoteSerializer(DatabaseId databaseId) {
        super();
        this.databaseId = databaseId;
        this.databaseName = RemoteSerializer.encodedDatabaseId(databaseId).canonicalString();
    }

    private FieldMask decodeDocumentMask(k k) {
        int i;
        FieldPath serverFormat;
        final int i2 = k.h();
        HashSet hashSet = new HashSet(i2);
        i = 0;
        while (i < i2) {
            hashSet.add(FieldPath.fromServerFormat(k.g(i)));
            i++;
        }
        return FieldMask.fromSet(hashSet);
    }

    private Filter.Operator decodeFieldFilterOperator(t.f.b t$f$b) {
        switch (i) {
            case 1:
                return Filter.Operator.LESS_THAN;
            case 2:
                return Filter.Operator.LESS_THAN_OR_EQUAL;
            case 3:
                return Filter.Operator.EQUAL;
            case 4:
                return Filter.Operator.NOT_EQUAL;
            case 5:
                return Filter.Operator.GREATER_THAN_OR_EQUAL;
            case 6:
                return Filter.Operator.GREATER_THAN;
            case 7:
                return Filter.Operator.ARRAY_CONTAINS;
            case 8:
                return Filter.Operator.IN;
            case 9:
                return Filter.Operator.ARRAY_CONTAINS_ANY;
            case 10:
                return Filter.Operator.NOT_IN;
            default:
                Object[] arr = new Object[1];
                throw Assert.fail("Unhandled FieldFilter.operator %d", b);
        }
    }

    private FieldTransform decodeFieldTransform(m.c m$c) {
        int i;
        int i2 = RemoteSerializer.1.$SwitchMap$com$google$firestore$v1$DocumentTransform$FieldTransform$TransformTypeCase[c.m().ordinal()];
        int i3 = 0;
        int i4 = 1;
        if (i2 != i4 && i2 != 2 && i2 != 3) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                    } else {
                        NumericIncrementTransformOperation numericIncrementTransformOperation = new NumericIncrementTransformOperation(c.j());
                        FieldTransform fieldTransform2 = new FieldTransform(FieldPath.fromServerFormat(c.i()), numericIncrementTransformOperation);
                        return fieldTransform2;
                    }
                    Object[] arr = new Object[i4];
                    arr[i3] = c;
                    throw Assert.fail("Unknown FieldTransform proto: %s", arr);
                }
                ArrayTransformOperation.Remove remove = new ArrayTransformOperation.Remove(c.k().a());
                FieldTransform fieldTransform3 = new FieldTransform(FieldPath.fromServerFormat(c.i()), remove);
                return fieldTransform3;
            }
            ArrayTransformOperation.Union union = new ArrayTransformOperation.Union(c.h().a());
            FieldTransform fieldTransform = new FieldTransform(FieldPath.fromServerFormat(c.i()), union);
            return fieldTransform;
        }
        i = c.l() == m.c.b.REQUEST_TIME ? i4 : i3;
        Object[] arr2 = new Object[i4];
        arr2[i3] = c.l();
        Assert.hardAssert(i, "Unknown transform setToServerValue: %s", arr2);
        FieldTransform fieldTransform4 = new FieldTransform(FieldPath.fromServerFormat(c.i()), ServerTimestampOperation.getInstance());
        return fieldTransform4;
    }

    private List<Filter> decodeFilters(t.h t$h) {
        int bVar;
        Object[] cOMPOSITE_FILTER;
        int decodeUnaryFilter;
        String str;
        int i;
        List obj7;
        final int i2 = 1;
        final int i3 = 0;
        if (h.i() == t.h.b.COMPOSITE_FILTER) {
            bVar = h.f().i() == t.d.b.AND ? i2 : i3;
            cOMPOSITE_FILTER = new Object[i2];
            cOMPOSITE_FILTER[i3] = h.f().i();
            Assert.hardAssert(bVar, "Only AND-type composite filters are supported, got %d", cOMPOSITE_FILTER);
            obj7 = h.f().h();
        } else {
            obj7 = Collections.singletonList(h);
        }
        ArrayList arrayList = new ArrayList(obj7.size());
        obj7 = obj7.iterator();
        for (t.h next2 : obj7) {
            str = RemoteSerializer.1.$SwitchMap$com$google$firestore$v1$StructuredQuery$Filter$FilterTypeCase[next2.i().ordinal()];
            arrayList.add(decodeFieldFilter(next2.h()));
            arrayList.add(decodeUnaryFilter(next2.j()));
        }
        return arrayList;
    }

    private MutableDocument decodeFoundDocument(d d) {
        int i = 0;
        Assert.hardAssert(d.f().equals(d.c.FOUND), "Tried to deserialize a found document from a missing document.", new Object[i]);
        SnapshotVersion obj6 = decodeVersion(d.d().i());
        Assert.hardAssert(equals2 ^= 1, "Got a document response with no snapshot version", new Object[i]);
        return MutableDocument.newFoundDocument(decodeKey(d.d().getName()), obj6, ObjectValue.fromMap(d.d().g()));
    }

    private MutableDocument decodeMissingDocument(d d) {
        int i = 0;
        Assert.hardAssert(d.f().equals(d.c.MISSING), "Tried to deserialize a missing document from a found document.", new Object[i]);
        SnapshotVersion obj5 = decodeVersion(d.getReadTime());
        Assert.hardAssert(equals2 ^= 1, "Got a no document response with no snapshot version", new Object[i]);
        return MutableDocument.newNoDocument(decodeKey(d.e()), obj5);
    }

    private OrderBy decodeOrderBy(t.i t$i) {
        int i2;
        OrderBy.Direction obj5;
        int i3 = RemoteSerializer.1.$SwitchMap$com$google$firestore$v1$StructuredQuery$Direction[i.e().ordinal()];
        int i5 = 1;
        if (i3 != i5) {
            if (i3 != 2) {
            } else {
                obj5 = OrderBy.Direction.DESCENDING;
                return OrderBy.getInstance(obj5, FieldPath.fromServerFormat(i.f().e()));
            }
            Object[] arr = new Object[i5];
            arr[0] = i.e();
            throw Assert.fail("Unrecognized direction %d", arr);
        }
        obj5 = OrderBy.Direction.ASCENDING;
    }

    private Precondition decodePrecondition(s s) {
        int i = RemoteSerializer.1.$SwitchMap$com$google$firestore$v1$Precondition$ConditionTypeCase[s.e().ordinal()];
        if (i != 1 && i != 2) {
            if (i != 2) {
                if (i != 3) {
                } else {
                    return Precondition.NONE;
                }
                throw Assert.fail("Unknown precondition", new Object[0]);
            }
            return Precondition.exists(s.g());
        }
        return Precondition.updateTime(decodeVersion(s.h()));
    }

    private ResourcePath decodeQueryPath(String string) {
        ResourcePath obj3 = decodeResourceName(string);
        if (obj3.length() == 4) {
            return ResourcePath.EMPTY;
        }
        return RemoteSerializer.extractLocalPathFromResourceName(obj3);
    }

    private ResourcePath decodeResourceName(String string) {
        final ResourcePath obj4 = ResourcePath.fromString(string);
        Object[] arr = new Object[1];
        Assert.hardAssert(RemoteSerializer.isValidResourceName(obj4), "Tried to deserialize invalid key %s", obj4);
        return obj4;
    }

    private Filter decodeUnaryFilter(t.k t$k) {
        FieldPath serverFormat = FieldPath.fromServerFormat(k.f().e());
        int i = RemoteSerializer.1.$SwitchMap$com$google$firestore$v1$StructuredQuery$UnaryFilter$Operator[k.g().ordinal()];
        int i3 = 1;
        if (i != i3 && i != 2 && i != 3) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                    } else {
                        return FieldFilter.create(serverFormat, Filter.Operator.NOT_EQUAL, Values.NULL_VALUE);
                    }
                    Object[] arr = new Object[i3];
                    arr[0] = k.g();
                    throw Assert.fail("Unrecognized UnaryFilter.operator %d", arr);
                }
                return FieldFilter.create(serverFormat, Filter.Operator.NOT_EQUAL, Values.NAN_VALUE);
            }
            return FieldFilter.create(serverFormat, Filter.Operator.EQUAL, Values.NULL_VALUE);
        }
        return FieldFilter.create(serverFormat, Filter.Operator.EQUAL, Values.NAN_VALUE);
    }

    private k encodeDocumentMask(FieldMask fieldMask) {
        String canonicalString;
        final k.b bVar = k.i();
        Iterator obj3 = fieldMask.getMask().iterator();
        for (FieldPath next2 : obj3) {
            bVar.b(next2.canonicalString());
        }
        return (k)bVar.build();
    }

    private t.f.b encodeFieldFilterOperator(Filter.Operator filter$Operator) {
        switch (i) {
            case 1:
                return t.f.b.LESS_THAN;
            case 2:
                return t.f.b.LESS_THAN_OR_EQUAL;
            case 3:
                return t.f.b.EQUAL;
            case 4:
                return t.f.b.NOT_EQUAL;
            case 5:
                return t.f.b.GREATER_THAN;
            case 6:
                return t.f.b.GREATER_THAN_OR_EQUAL;
            case 7:
                return t.f.b.ARRAY_CONTAINS;
            case 8:
                return t.f.b.IN;
            case 9:
                return t.f.b.ARRAY_CONTAINS_ANY;
            case 10:
                return t.f.b.NOT_IN;
            default:
                Object[] arr = new Object[1];
                throw Assert.fail("Unknown operator %d", operator);
        }
    }

    private t.g encodeFieldPath(FieldPath fieldPath) {
        final t.g.a aVar = t.g.f();
        aVar.b(fieldPath.canonicalString());
        return (t.g)aVar.build();
    }

    private m.c encodeFieldTransform(FieldTransform fieldTransform) {
        com.google.firebase.firestore.model.mutation.TransformOperation operation = fieldTransform.getOperation();
        if (operation instanceof ServerTimestampOperation) {
            m.c.a aVar = m.c.n();
            aVar.c(fieldTransform.getFieldPath().canonicalString());
            aVar.f(m.c.b.REQUEST_TIME);
            return (m.c)aVar.build();
        }
        if (operation instanceof ArrayTransformOperation.Union) {
            m.c.a aVar2 = m.c.n();
            aVar2.c(fieldTransform.getFieldPath().canonicalString());
            a.b obj3 = a.l();
            obj3.b((ArrayTransformOperation.Union)operation.getElements());
            aVar2.b(obj3);
            return (m.c)aVar2.build();
        }
        if (operation instanceof ArrayTransformOperation.Remove) {
            m.c.a aVar4 = m.c.n();
            aVar4.c(fieldTransform.getFieldPath().canonicalString());
            obj3 = a.l();
            obj3.b((ArrayTransformOperation.Remove)operation.getElements());
            aVar4.e(obj3);
            return (m.c)aVar4.build();
        }
        if (!operation instanceof NumericIncrementTransformOperation) {
        } else {
            m.c.a aVar3 = m.c.n();
            aVar3.c(fieldTransform.getFieldPath().canonicalString());
            aVar3.d((NumericIncrementTransformOperation)operation.getOperand());
            return (m.c)aVar3.build();
        }
        obj3 = new Object[1];
        throw Assert.fail("Unknown transform: %s", operation);
    }

    private t.h encodeFilters(List<Filter> list) {
        Object encodeUnaryOrFieldFilter;
        boolean z;
        ArrayList arrayList = new ArrayList(list.size());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            encodeUnaryOrFieldFilter = iterator.next();
            if (encodeUnaryOrFieldFilter instanceof FieldFilter) {
            }
            arrayList.add(encodeUnaryOrFieldFilter((FieldFilter)(Filter)encodeUnaryOrFieldFilter));
        }
        if (list.size() == 1) {
            return (t.h)arrayList.get(0);
        }
        t.d.a obj5 = t.d.j();
        obj5.c(t.d.b.AND);
        obj5.b(arrayList);
        t.h.a aVar = t.h.k();
        aVar.b(obj5);
        return (t.h)aVar.build();
    }

    private String encodeLabel(QueryPurpose queryPurpose) {
        int i = RemoteSerializer.1.$SwitchMap$com$google$firebase$firestore$local$QueryPurpose[queryPurpose.ordinal()];
        int i2 = 1;
        if (i != i2 && i != 2) {
            if (i != 2) {
                if (i != 3) {
                } else {
                    return "limbo-document";
                }
                Object[] arr = new Object[i2];
                arr[0] = queryPurpose;
                throw Assert.fail("Unrecognized query purpose: %s", arr);
            }
            return "existence-filter-mismatch";
        }
        return null;
    }

    private t.i encodeOrderBy(OrderBy orderBy) {
        t.e dESCENDING;
        final t.i.a aVar = t.i.g();
        if (orderBy.getDirection().equals(OrderBy.Direction.ASCENDING)) {
            aVar.b(t.e.ASCENDING);
        } else {
            aVar.b(t.e.DESCENDING);
        }
        aVar.c(encodeFieldPath(orderBy.getField()));
        return (t.i)aVar.build();
    }

    private s encodePrecondition(Precondition precondition) {
        final int i2 = 0;
        Assert.hardAssert(none ^= 1, "Can't serialize an empty precondition", new Object[i2]);
        s.b bVar = s.i();
        if (precondition.getUpdateTime() != null) {
            bVar.c(encodeVersion(precondition.getUpdateTime()));
            return (s)bVar.build();
        }
        if (precondition.getExists() == null) {
        } else {
            bVar.b(precondition.getExists().booleanValue());
            return (s)bVar.build();
        }
        throw Assert.fail("Unknown Precondition", new Object[i2]);
    }

    private String encodeQueryPath(ResourcePath resourcePath) {
        return encodeResourceName(this.databaseId, resourcePath);
    }

    private String encodeResourceName(DatabaseId databaseId, ResourcePath resourcePath2) {
        return (ResourcePath)(ResourcePath)RemoteSerializer.encodedDatabaseId(databaseId).append("documents").append(resourcePath2).canonicalString();
    }

    private static ResourcePath encodedDatabaseId(DatabaseId databaseId) {
        String[] strArr = new String[4];
        return ResourcePath.fromSegments(Arrays.asList("projects", databaseId.getProjectId(), "databases", databaseId.getDatabaseId()));
    }

    private static ResourcePath extractLocalPathFromResourceName(ResourcePath resourcePath) {
        int length;
        int i;
        int str;
        int i3 = 1;
        int i4 = 0;
        str = 4;
        if (resourcePath.length() > str && resourcePath.getSegment(str).equals("documents")) {
            i = resourcePath.getSegment(str).equals("documents") ? i3 : i4;
        } else {
        }
        Object[] arr = new Object[i3];
        arr[i4] = resourcePath;
        Assert.hardAssert(i, "Tried to deserialize invalid key %s", arr);
        return (ResourcePath)resourcePath.popFirst(5);
    }

    private d1 fromStatus(a a) {
        return d1.i(a.c()).r(a.e());
    }

    private static boolean isValidResourceName(ResourcePath resourcePath) {
        int length;
        int i;
        int str;
        boolean obj3;
        if (resourcePath.length() >= 4 && resourcePath.getSegment(0).equals("projects") && resourcePath.getSegment(2).equals("databases")) {
            if (resourcePath.getSegment(i).equals("projects")) {
                if (resourcePath.getSegment(2).equals("databases")) {
                    i = 1;
                }
            }
        }
        return i;
    }

    public String databaseName() {
        return this.databaseName;
    }

    public Target decodeDocumentsTarget(u.c u$c) {
        int i;
        int i2 = c.h();
        final int i3 = 0;
        int i4 = 1;
        i = i2 == i4 ? i4 : i3;
        Object[] arr = new Object[i4];
        arr[i3] = Integer.valueOf(i2);
        Assert.hardAssert(i, "DocumentsTarget contained other than 1 document %d", arr);
        return Query.atPath(decodeQueryPath(c.g(i3))).toTarget();
    }

    FieldFilter decodeFieldFilter(t.f t$f) {
        return FieldFilter.create(FieldPath.fromServerFormat(f.g().e()), decodeFieldFilterOperator(f.h()), f.i());
    }

    public DocumentKey decodeKey(String string) {
        ResourcePath obj5 = decodeResourceName(string);
        int i3 = 0;
        Assert.hardAssert(obj5.getSegment(1).equals(this.databaseId.getProjectId()), "Tried to deserialize key from different project.", new Object[i3]);
        Assert.hardAssert(obj5.getSegment(3).equals(this.databaseId.getDatabaseId()), "Tried to deserialize key from different database.", new Object[i3]);
        return DocumentKey.fromPath(RemoteSerializer.extractLocalPathFromResourceName(obj5));
    }

    public MutableDocument decodeMaybeDocument(d d) {
        if (d.f().equals(d.c.FOUND)) {
            return decodeFoundDocument(d);
        }
        if (!d.f().equals(d.c.MISSING)) {
        } else {
            return decodeMissingDocument(d);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown result case: ");
        stringBuilder.append(d.f());
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    public Mutation decodeMutation(y y) {
        Precondition decodePrecondition;
        FieldTransform decodeFieldTransform;
        if (y.s()) {
            decodePrecondition = decodePrecondition(y.k());
        } else {
            decodePrecondition = Precondition.NONE;
        }
        final Precondition precondition = decodePrecondition;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = y.q().iterator();
        for (m.c next2 : iterator) {
            arrayList.add(decodeFieldTransform(next2));
        }
        int i = RemoteSerializer.1.$SwitchMap$com$google$firestore$v1$Write$OperationCase[y.m().ordinal()];
        int i2 = 1;
        if (i != i2 && i != 2) {
            if (i != 2) {
                if (i != 3) {
                } else {
                    VerifyMutation verifyMutation = new VerifyMutation(decodeKey(y.r()), precondition);
                    return verifyMutation;
                }
                Object[] arr = new Object[i2];
                arr[0] = y.m();
                throw Assert.fail("Unknown mutation operation: %d", arr);
            }
            DeleteMutation deleteMutation = new DeleteMutation(decodeKey(y.l()), precondition);
            return deleteMutation;
        }
        if (y.v()) {
            super(decodeKey(y.o().getName()), ObjectValue.fromMap(y.o().g()), decodeDocumentMask(y.p()), precondition, arrayList);
            return patchMutation;
        }
        SetMutation setMutation = new SetMutation(decodeKey(y.o().getName()), ObjectValue.fromMap(y.o().g()), precondition, arrayList);
        return setMutation;
    }

    public MutationResult decodeMutationResult(c0 c0, SnapshotVersion snapshotVersion2) {
        int i;
        f.c.e.c.x xVar;
        SnapshotVersion obj6;
        SnapshotVersion decodeVersion = decodeVersion(c0.e());
        if (SnapshotVersion.NONE.equals(decodeVersion)) {
        } else {
            obj6 = decodeVersion;
        }
        int i2 = c0.d();
        ArrayList arrayList = new ArrayList(i2);
        i = 0;
        while (i < i2) {
            arrayList.add(c0.c(i));
            i++;
        }
        MutationResult obj5 = new MutationResult(obj6, arrayList);
        return obj5;
    }

    public Target decodeQueryTarget(u.d u$d) {
        return decodeQueryTarget(d.f(), d.g());
    }

    public Target decodeQueryTarget(String string, t t2) {
        int i;
        int arrayList;
        int bound;
        int i3;
        boolean decodeOrderBy;
        String str2;
        ResourcePath resourcePath;
        String str;
        Object obj;
        int i2;
        Bound bound2;
        BasePath obj14;
        int obj15;
        obj14 = decodeQueryPath(string);
        arrayList = t2.p();
        bound = 0;
        i3 = 0;
        final int i4 = 1;
        if (arrayList > 0) {
            i = arrayList == i4 ? i4 : i3;
            Assert.hardAssert(i, "StructuredQuery.from with more than one collection is not supported.", new Object[i3]);
            t.c cVar = t2.o(i3);
            if (cVar.e()) {
                resourcePath = obj14;
                str = arrayList;
            } else {
                obj14 = obj14.append(cVar.f());
                resourcePath = obj14;
                str = bound;
            }
        } else {
        }
        if (t2.y()) {
            obj14 = decodeFilters(t2.u());
        } else {
            obj14 = Collections.emptyList();
        }
        obj14 = t2.s();
        if (obj14 > 0) {
            arrayList = new ArrayList(obj14);
            while (i3 < obj14) {
                arrayList.add(decodeOrderBy(t2.r(i3)));
                i3++;
            }
            obj = arrayList;
        } else {
            obj = obj14;
        }
        i2 = -1;
        if (t2.w()) {
            i2 = (long)obj14;
        }
        if (t2.x()) {
            obj14 = new Bound(t2.t().a(), t2.t().g());
            bound2 = obj14;
        } else {
            bound2 = bound;
        }
        if (t2.v()) {
            bound = new Bound(t2.n().a(), obj15 ^= i4);
        }
        super(resourcePath, str, obj14, obj, i2, obj10, bound2, bound);
        return obj14;
    }

    public Timestamp decodeTimestamp(r1 r1) {
        Timestamp timestamp = new Timestamp(r1.g(), obj2, r1.f());
        return timestamp;
    }

    public SnapshotVersion decodeVersion(r1 r1) {
        int cmp;
        if (Long.compare(l, i) == 0 && r1.f() == 0) {
            if (r1.f() == 0) {
                return SnapshotVersion.NONE;
            }
        }
        SnapshotVersion snapshotVersion = new SnapshotVersion(decodeTimestamp(r1));
        return snapshotVersion;
    }

    public SnapshotVersion decodeVersionFromListenResponse(q q) {
        if (q.h() != q.c.TARGET_CHANGE) {
            return SnapshotVersion.NONE;
        }
        if (q.i().f() != 0) {
            return SnapshotVersion.NONE;
        }
        return decodeVersion(q.i().getReadTime());
    }

    public com.google.firebase.firestore.remote.WatchChange decodeWatchChange(q q) {
        com.google.firebase.firestore.remote.WatchChange.WatchTargetChangeType existenceFilter;
        int status;
        com.google.firebase.firestore.remote.WatchChange existenceFilterWatchChange;
        int watchTargetChange;
        int emptyList;
        int i;
        int arr;
        int str;
        int ordinal;
        int obj9;
        int i2 = RemoteSerializer.1.$SwitchMap$com$google$firestore$v1$ListenResponse$ResponseTypeCase[q.h().ordinal()];
        watchTargetChange = 5;
        emptyList = 4;
        i = 3;
        arr = 2;
        str = 1;
        if (i2 != str && i2 != arr) {
            if (i2 != arr) {
                if (i2 != i) {
                    if (i2 != emptyList) {
                        if (i2 != watchTargetChange) {
                        } else {
                            obj9 = q.g();
                            existenceFilter = new ExistenceFilter(obj9.getCount());
                            existenceFilterWatchChange = new WatchChange.ExistenceFilterWatchChange(obj9.getTargetId(), existenceFilter);
                        }
                        obj9 = new IllegalArgumentException("Unknown change type set");
                        throw obj9;
                    }
                    obj9 = q.f();
                    watchTargetChange = new WatchChange.DocumentChange(Collections.emptyList(), obj9.e(), decodeKey(obj9.d()), 0);
                    existenceFilterWatchChange = watchTargetChange;
                } else {
                    obj9 = q.e();
                    obj9 = MutableDocument.newNoDocument(decodeKey(obj9.d()), decodeVersion(obj9.getReadTime()));
                    existenceFilterWatchChange = new WatchChange.DocumentChange(Collections.emptyList(), obj9.e(), obj9.getKey(), obj9);
                }
            } else {
            }
        } else {
        }
        return existenceFilterWatchChange;
    }

    public h encodeDocument(DocumentKey documentKey, ObjectValue objectValue2) {
        final h.b bVar = h.l();
        bVar.c(encodeKey(documentKey));
        bVar.b(objectValue2.getFieldsMap());
        return (h)bVar.build();
    }

    public u.c encodeDocumentsTarget(Target target) {
        final u.c.a aVar = u.c.i();
        aVar.b(encodeQueryPath(target.getPath()));
        return (u.c)aVar.build();
    }

    public String encodeKey(DocumentKey documentKey) {
        return encodeResourceName(this.databaseId, documentKey.getPath());
    }

    public Map<String, String> encodeListenRequestLabels(TargetData targetData) {
        String obj3 = encodeLabel(targetData.getPurpose());
        if (obj3 == null) {
            return 0;
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("goog-listen-tags", obj3);
        return hashMap;
    }

    public y encodeMutation(Mutation mutation) {
        Object encodeDocumentMask;
        Object encodeFieldTransform;
        ObjectValue value;
        Object obj5;
        y.b bVar = y.w();
        if (mutation instanceof SetMutation) {
            bVar.e(encodeDocument(mutation.getKey(), (SetMutation)mutation.getValue()));
            Iterator iterator = mutation.getFieldTransforms().iterator();
            for (FieldTransform next2 : iterator) {
                bVar.b(encodeFieldTransform(next2));
            }
            if (!mutation.getPrecondition().isNone()) {
                bVar.c(encodePrecondition(mutation.getPrecondition()));
            }
            return (y)bVar.build();
        } else {
            if (mutation instanceof PatchMutation) {
                encodeFieldTransform = mutation;
                bVar.e(encodeDocument(mutation.getKey(), (PatchMutation)encodeFieldTransform.getValue()));
                bVar.f(encodeDocumentMask(encodeFieldTransform.getMask()));
            } else {
                if (mutation instanceof DeleteMutation) {
                    bVar.d(encodeKey(mutation.getKey()));
                } else {
                    if (!mutation instanceof VerifyMutation) {
                    } else {
                        bVar.g(encodeKey(mutation.getKey()));
                    }
                }
            }
        }
        Object[] arr = new Object[1];
        throw Assert.fail("unknown mutation type %s", mutation.getClass());
    }

    public u.d encodeQueryTarget(Target target) {
        Object lastSegment;
        int encodeFilters;
        boolean limit;
        Object startAt;
        Object endAt;
        Object collectionGroup;
        boolean inclusive;
        int i2;
        int i;
        Object[] limit2;
        String str;
        int obj8;
        final u.d.a aVar = u.d.h();
        final t.b bVar = t.z();
        ResourcePath path = target.getPath();
        final int i5 = 1;
        int i6 = 0;
        if (target.getCollectionGroup() != null) {
            i2 = length %= 2 == 0 ? i5 : i6;
            Assert.hardAssert(i2, "Collection Group queries should be within a document path or root.", new Object[i6]);
            aVar.b(encodeQueryPath(path));
            lastSegment = t.c.g();
            lastSegment.c(target.getCollectionGroup());
            lastSegment.b(i5);
            bVar.b(lastSegment);
        } else {
            i = length2 %= 2 != 0 ? i5 : i6;
            Assert.hardAssert(i, "Document queries with filters are not supported.", new Object[i6]);
            aVar.b(encodeQueryPath((ResourcePath)path.popLast()));
            collectionGroup = t.c.g();
            collectionGroup.c(path.getLastSegment());
            bVar.b(collectionGroup);
        }
        if (target.getFilters().size() > 0) {
            bVar.g(encodeFilters(target.getFilters()));
        }
        Iterator iterator = target.getOrderBy().iterator();
        for (OrderBy next : iterator) {
            bVar.c(encodeOrderBy(next));
        }
        if (target.hasLimit()) {
            limit = a0.e();
            limit.b((int)limit2);
            bVar.e(limit);
        }
        if (target.getStartAt() != null) {
            startAt = g.i();
            startAt.b(target.getStartAt().getPosition());
            startAt.c(target.getStartAt().isInclusive());
            bVar.f(startAt);
        }
        if (target.getEndAt() != null) {
            endAt = g.i();
            endAt.b(target.getEndAt().getPosition());
            endAt.c(obj8 ^= i5);
            bVar.d(endAt);
        }
        aVar.c(bVar);
        return (u.d)aVar.build();
    }

    public u encodeTarget(TargetData targetData) {
        com.google.protobuf.z encodeDocumentsTarget;
        boolean compareTo;
        boolean documentQuery;
        Object obj4;
        final u.b bVar = u.h();
        Target target = targetData.getTarget();
        if (target.isDocumentQuery()) {
            bVar.b(encodeDocumentsTarget(target));
        } else {
            bVar.c(encodeQueryTarget(target));
        }
        bVar.f(targetData.getTargetId());
        if (targetData.getResumeToken().isEmpty() && targetData.getSnapshotVersion().compareTo(SnapshotVersion.NONE) > 0) {
            if (targetData.getSnapshotVersion().compareTo(SnapshotVersion.NONE) > 0) {
                bVar.d(encodeTimestamp(targetData.getSnapshotVersion().getTimestamp()));
            } else {
                bVar.e(targetData.getResumeToken());
            }
        } else {
        }
        return (u)bVar.build();
    }

    public r1 encodeTimestamp(Timestamp timestamp) {
        final r1.b bVar = r1.h();
        bVar.c(timestamp.getSeconds());
        bVar.b(timestamp.getNanoseconds());
        return (r1)bVar.build();
    }

    t.h encodeUnaryOrFieldFilter(FieldFilter fieldFilter) {
        Filter.Operator operator;
        Filter.Operator nullValue;
        t.k.b obj4;
        Filter.Operator eQUAL = Filter.Operator.EQUAL;
        if (fieldFilter.getOperator() != eQUAL) {
            operator = t.k.h();
            operator.b(encodeFieldPath(fieldFilter.getField()));
            if (fieldFilter.getOperator() == Filter.Operator.NOT_EQUAL && Values.isNanValue(fieldFilter.getValue())) {
                operator = t.k.h();
                operator.b(encodeFieldPath(fieldFilter.getField()));
                if (Values.isNanValue(fieldFilter.getValue())) {
                    obj4 = fieldFilter.getOperator() == eQUAL ? t.k.b.IS_NAN : t.k.b.IS_NOT_NAN;
                    operator.c(obj4);
                    obj4 = t.h.k();
                    obj4.d(operator);
                    return (t.h)obj4.build();
                }
                if (Values.isNullValue(fieldFilter.getValue())) {
                    obj4 = fieldFilter.getOperator() == eQUAL ? t.k.b.IS_NULL : t.k.b.IS_NOT_NULL;
                    operator.c(obj4);
                    obj4 = t.h.k();
                    obj4.d(operator);
                    return (t.h)obj4.build();
                }
            }
        } else {
        }
        t.f.a aVar = t.f.j();
        aVar.b(encodeFieldPath(fieldFilter.getField()));
        aVar.c(encodeFieldFilterOperator(fieldFilter.getOperator()));
        aVar.d(fieldFilter.getValue());
        obj4 = t.h.k();
        obj4.c(aVar);
        return (t.h)obj4.build();
    }

    public r1 encodeVersion(SnapshotVersion snapshotVersion) {
        return encodeTimestamp(snapshotVersion.getTimestamp());
    }

    public boolean isLocalResourceName(ResourcePath resourcePath) {
        String validResourceName;
        int i;
        String projectId;
        boolean obj4;
        if (RemoteSerializer.isValidResourceName(resourcePath) && resourcePath.getSegment(1).equals(this.databaseId.getProjectId()) && resourcePath.getSegment(3).equals(this.databaseId.getDatabaseId())) {
            if (resourcePath.getSegment(i).equals(this.databaseId.getProjectId())) {
                if (resourcePath.getSegment(3).equals(this.databaseId.getDatabaseId())) {
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }
}
