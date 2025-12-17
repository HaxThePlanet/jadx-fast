package com.google.firebase.firestore;

import android.app.Activity;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import com.google.android.gms.tasks.m;
import com.google.firebase.firestore.core.ActivityScope;
import com.google.firebase.firestore.core.AsyncEventListener;
import com.google.firebase.firestore.core.Bound;
import com.google.firebase.firestore.core.EventManager.ListenOptions;
import com.google.firebase.firestore.core.FieldFilter;
import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.core.Filter.Operator;
import com.google.firebase.firestore.core.FirestoreClient;
import com.google.firebase.firestore.core.ListenerRegistrationImpl;
import com.google.firebase.firestore.core.OrderBy;
import com.google.firebase.firestore.core.OrderBy.Direction;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.core.ViewSnapshot;
import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.ServerTimestamps;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Preconditions;
import com.google.firebase.firestore.util.Util;
import com.google.protobuf.z.a;
import f.c.e.c.a;
import f.c.e.c.a.b;
import f.c.e.c.x;
import f.c.e.c.x.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class Query {

    final com.google.firebase.firestore.FirebaseFirestore firestore;
    final Query query;

    public static enum Direction {

        ASCENDING,
        DESCENDING;
    }
    Query(Query query, com.google.firebase.firestore.FirebaseFirestore firebaseFirestore2) {
        super();
        this.query = (Query)Preconditions.checkNotNull(query);
        this.firestore = (FirebaseFirestore)Preconditions.checkNotNull(firebaseFirestore2);
    }

    private void a(com.google.firebase.firestore.EventListener eventListener, ViewSnapshot viewSnapshot2, com.google.firebase.firestore.FirebaseFirestoreException firebaseFirestoreException3) {
        int i;
        final int i2 = 0;
        if (firebaseFirestoreException3 != null) {
            eventListener.onEvent(i2, firebaseFirestoreException3);
        }
        int obj6 = 0;
        i = viewSnapshot2 != null ? 1 : obj6;
        Assert.hardAssert(i, "Got event without value or error set", new Object[obj6]);
        obj6 = new QuerySnapshot(this, viewSnapshot2, this.firestore);
        eventListener.onEvent(obj6, i2);
    }

    private com.google.firebase.firestore.ListenerRegistration addSnapshotListenerInternal(Executor executor, EventManager.ListenOptions eventManager$ListenOptions2, Activity activity3, com.google.firebase.firestore.EventListener<com.google.firebase.firestore.QuerySnapshot> eventListener4) {
        validateHasExplicitOrderByForLimitToLast();
        p pVar = new p(this, eventListener4);
        AsyncEventListener obj5 = new AsyncEventListener(executor, pVar);
        ListenerRegistrationImpl obj3 = new ListenerRegistrationImpl(this.firestore.getClient(), this.firestore.getClient().listen(this.query, listenOptions2, obj5), obj5);
        return ActivityScope.bind(activity3, obj3);
    }

    private Bound boundFromDocumentSnapshot(String string, com.google.firebase.firestore.DocumentSnapshot documentSnapshot2, boolean z3) {
        Object refValue;
        Object field;
        boolean serverTimestamp;
        String str;
        Preconditions.checkNotNull(documentSnapshot2, "Provided snapshot must not be null.");
        if (!documentSnapshot2.exists()) {
        } else {
            Document obj6 = documentSnapshot2.getDocument();
            ArrayList obj7 = new ArrayList();
            Iterator iterator = this.query.getOrderBy().iterator();
            for (OrderBy refValue : iterator) {
                field = obj6.getField(refValue.getField());
                str = "Invalid query. You are trying to start or end a query using a document for which the field '";
                obj7.add(field);
                obj7.add(Values.refValue(this.firestore.getDatabaseId(), obj6.getKey()));
            }
            obj6 = new Bound(obj7, z3);
            return obj6;
        }
        StringBuilder obj8 = new StringBuilder();
        obj8.append("Can't use a DocumentSnapshot for a document that doesn't exist for ");
        obj8.append(string);
        obj8.append("().");
        obj7 = new IllegalArgumentException(obj8.toString());
        throw obj7;
    }

    private Bound boundFromFields(String string, Object[] object2Arr2, boolean z3) {
        int i;
        x queryValue;
        com.google.firebase.firestore.model.DatabaseId userDataReader;
        boolean collectionGroupQuery;
        FieldPath kEY_PATH;
        List explicitOrderBy = this.query.getExplicitOrderBy();
        if (object2Arr2.length > explicitOrderBy.size()) {
        } else {
            ArrayList arrayList = new ArrayList();
            i = 0;
            for (Object obj : object2Arr2) {
                arrayList.add(this.firestore.getUserDataReader().parseQueryValue(obj));
                BasePath append = this.query.getPath().append(ResourcePath.fromString((String)obj));
                arrayList.add(Values.refValue(this.firestore.getDatabaseId(), DocumentKey.fromPath(append)));
            }
            Bound obj7 = new Bound(arrayList, z3);
            return obj7;
        }
        StringBuilder obj9 = new StringBuilder();
        obj9.append("Too many arguments provided to ");
        obj9.append(string);
        obj9.append("(). The number of arguments must be less than or equal to the number of orderBy() clauses.");
        IllegalArgumentException obj8 = new IllegalArgumentException(obj9.toString());
        throw obj8;
    }

    private com.google.firebase.firestore.QuerySnapshot c(j j) {
        Query query = new Query(this.query, this.firestore);
        QuerySnapshot querySnapshot = new QuerySnapshot(query, (ViewSnapshot)j.getResult(), this.firestore);
        return querySnapshot;
    }

    private List<Filter.Operator> conflictingOps(Filter.Operator filter$Operator) {
        int obj7 = Query.1.$SwitchMap$com$google$firebase$firestore$core$Filter$Operator[operator.ordinal()];
        int i = 0;
        int i2 = 2;
        final int i3 = 1;
        int i4 = 3;
        int i5 = 4;
        int i6 = 5;
        if (obj7 != i3 && obj7 != i2 && obj7 != i4 && obj7 != i5 && obj7 != i6) {
            i4 = 3;
            if (obj7 != i2) {
                if (obj7 != i4) {
                    i5 = 4;
                    if (obj7 != i5) {
                        i6 = 5;
                        if (obj7 != i6) {
                            obj7 = new ArrayList();
                            return obj7;
                        }
                        obj7 = new Filter.Operator[i6];
                        obj7[i] = Filter.Operator.ARRAY_CONTAINS;
                        obj7[i3] = Filter.Operator.ARRAY_CONTAINS_ANY;
                        obj7[i2] = Filter.Operator.IN;
                        obj7[i4] = Filter.Operator.NOT_IN;
                        obj7[i5] = Filter.Operator.NOT_EQUAL;
                        return Arrays.asList(obj7);
                    }
                    obj7 = new Filter.Operator[i5];
                    obj7[i] = Filter.Operator.ARRAY_CONTAINS;
                    obj7[i3] = Filter.Operator.ARRAY_CONTAINS_ANY;
                    obj7[i2] = Filter.Operator.IN;
                    obj7[i4] = Filter.Operator.NOT_IN;
                    return Arrays.asList(obj7);
                }
                obj7 = new Filter.Operator[i4];
                obj7[i] = Filter.Operator.ARRAY_CONTAINS_ANY;
                obj7[i3] = Filter.Operator.IN;
                obj7[i2] = Filter.Operator.NOT_IN;
                return Arrays.asList(obj7);
            }
            obj7 = new Filter.Operator[i4];
            obj7[i] = Filter.Operator.ARRAY_CONTAINS;
            obj7[i3] = Filter.Operator.ARRAY_CONTAINS_ANY;
            obj7[i2] = Filter.Operator.NOT_IN;
            return Arrays.asList(obj7);
        }
        obj7 = new Filter.Operator[i2];
        obj7[i] = Filter.Operator.NOT_EQUAL;
        obj7[i3] = Filter.Operator.NOT_IN;
        return Arrays.asList(obj7);
    }

    static void e(k k, k k2, com.google.firebase.firestore.Source source3, com.google.firebase.firestore.QuerySnapshot querySnapshot4, com.google.firebase.firestore.FirebaseFirestoreException firebaseFirestoreException5) {
        boolean obj2;
        Object obj3;
        Object obj4;
        final String str = "Failed to register a listener for a query result";
        if (firebaseFirestoreException5 != null) {
            k.b(firebaseFirestoreException5);
        }
        final int obj5 = 0;
        (ListenerRegistration)m.a(k2.a()).remove();
        if (querySnapshot4.getMetadata().isFromCache() && source3 == Source.SERVER) {
            if (source3 == Source.SERVER) {
                obj2 = new FirebaseFirestoreException("Failed to get documents from server. (However, these documents may exist in the local cache. Run again without setting source to SERVER to retrieve the cached documents.)", FirebaseFirestoreException.Code.UNAVAILABLE);
                k.b(obj2);
            } else {
                k.c(querySnapshot4);
            }
        } else {
        }
    }

    private j<com.google.firebase.firestore.QuerySnapshot> getViaSnapshotListener(com.google.firebase.firestore.Source source) {
        k kVar = new k();
        k kVar2 = new k();
        EventManager.ListenOptions listenOptions = new EventManager.ListenOptions();
        int i = 1;
        listenOptions.includeDocumentMetadataChanges = i;
        listenOptions.includeQueryMetadataChanges = i;
        listenOptions.waitForSyncWhenOnline = i;
        n nVar = new n(kVar, kVar2, source);
        kVar2.c(addSnapshotListenerInternal(Executors.DIRECT_EXECUTOR, listenOptions, 0, nVar));
        return kVar.a();
    }

    private static EventManager.ListenOptions internalOptions(com.google.firebase.firestore.MetadataChanges metadataChanges) {
        int i;
        int i2;
        EventManager.ListenOptions listenOptions = new EventManager.ListenOptions();
        final com.google.firebase.firestore.MetadataChanges iNCLUDE = MetadataChanges.INCLUDE;
        final int i3 = 0;
        i2 = metadataChanges == iNCLUDE ? i : i3;
        listenOptions.includeDocumentMetadataChanges = i2;
        if (metadataChanges == iNCLUDE) {
        } else {
            i = i3;
        }
        listenOptions.includeQueryMetadataChanges = i;
        listenOptions.waitForSyncWhenOnline = i3;
        return listenOptions;
    }

    private com.google.firebase.firestore.Query orderBy(FieldPath fieldPath, com.google.firebase.firestore.Query.Direction query$Direction2) {
        OrderBy.Direction obj4;
        Preconditions.checkNotNull(direction2, "Provided direction must not be null.");
        if (this.query.getStartAt() != null) {
        } else {
            if (this.query.getEndAt() != null) {
            } else {
                validateOrderByField(fieldPath);
                obj4 = direction2 == Query.Direction.ASCENDING ? OrderBy.Direction.ASCENDING : OrderBy.Direction.DESCENDING;
                Query query3 = new Query(this.query.orderBy(OrderBy.getInstance(obj4, fieldPath)), this.firestore);
                return query3;
            }
            IllegalArgumentException obj3 = new IllegalArgumentException("Invalid query. You must not call Query.endAt() or Query.endBefore() before calling Query.orderBy().");
            throw obj3;
        }
        obj3 = new IllegalArgumentException("Invalid query. You must not call Query.startAt() or Query.startAfter() before calling Query.orderBy().");
        throw obj3;
    }

    private x parseDocumentIdValue(Object object) {
        boolean collectionGroupQuery;
        if (object instanceof String != null) {
            if ((String)object.isEmpty()) {
            } else {
                if (!this.query.isCollectionGroupQuery()) {
                    if (object.contains("/")) {
                    } else {
                    }
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Invalid query. When querying a collection by FieldPath.documentId() you must provide a plain document ID, but '");
                    stringBuilder2.append(object);
                    stringBuilder2.append("' contains a '/' character.");
                    IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.toString());
                    throw illegalArgumentException2;
                }
                BasePath obj4 = this.query.getPath().append(ResourcePath.fromString(object));
                if (!DocumentKey.isDocumentKey((ResourcePath)obj4)) {
                } else {
                    return Values.refValue(getFirestore().getDatabaseId(), DocumentKey.fromPath(obj4));
                }
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Invalid query. When querying a collection group by FieldPath.documentId(), the value provided must result in a valid document path, but '");
                stringBuilder3.append(obj4);
                stringBuilder3.append("' is not because it has an odd number of segments (");
                stringBuilder3.append(obj4.length());
                stringBuilder3.append(").");
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(stringBuilder3.toString());
                throw illegalArgumentException3;
            }
            obj4 = new IllegalArgumentException("Invalid query. When querying with FieldPath.documentId() you must provide a valid document ID, but it was an empty string.");
            throw obj4;
        }
        if (object instanceof DocumentReference == null) {
        } else {
            return Values.refValue(getFirestore().getDatabaseId(), (DocumentReference)object.getKey());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid query. When querying with FieldPath.documentId() you must provide a valid String or DocumentReference, but it was of type: ");
        stringBuilder.append(Util.typeName(object));
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    private void validateDisjunctiveFilterElements(Object object, Filter.Operator filter$Operator2) {
        boolean size;
        if (object instanceof List == null) {
        } else {
            if ((List)object.size() == 0) {
            } else {
                if (object.size() > 10) {
                } else {
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Invalid Query. '");
                stringBuilder2.append(operator2.toString());
                stringBuilder2.append("' filters support a maximum of 10 elements in the value array.");
                IllegalArgumentException obj3 = new IllegalArgumentException(stringBuilder2.toString());
                throw obj3;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid Query. A non-empty array is required for '");
        stringBuilder.append(operator2.toString());
        stringBuilder.append("' filters.");
        obj3 = new IllegalArgumentException(stringBuilder.toString());
        throw obj3;
    }

    private void validateHasExplicitOrderByForLimitToLast() {
        boolean limitToLast;
        if (this.query.hasLimitToLast()) {
            if (this.query.getExplicitOrderBy().isEmpty()) {
            } else {
            }
            IllegalStateException illegalStateException = new IllegalStateException("limitToLast() queries require specifying at least one orderBy() clause");
            throw illegalStateException;
        }
    }

    private void validateNewFilter(Filter filter) {
        boolean firstOrderByField;
        boolean conflictingOps;
        Filter.Operator operator;
        boolean equals;
        Object obj5;
        Object obj = filter;
        operator = (FieldFilter)obj.getOperator();
        FieldPath inequalityField = this.query.inequalityField();
        obj5 = filter.getField();
        if (filter instanceof FieldFilter && obj.isInequality() && inequalityField != null) {
            obj = filter;
            operator = (FieldFilter)obj.getOperator();
            if (obj.isInequality()) {
                inequalityField = this.query.inequalityField();
                obj5 = filter.getField();
                if (inequalityField != null) {
                    if (!inequalityField.equals(obj5)) {
                    } else {
                    }
                    Object[] arr = new Object[2];
                    IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(String.format("All where filters with an inequality (notEqualTo, notIn, lessThan, lessThanOrEqualTo, greaterThan, or greaterThanOrEqualTo) must be on the same field. But you have filters on '%s' and '%s'", inequalityField.canonicalString(), obj5.canonicalString()));
                    throw illegalArgumentException2;
                }
                firstOrderByField = this.query.getFirstOrderByField();
                if (firstOrderByField != null) {
                    validateOrderByFieldMatchesInequality(firstOrderByField, obj5);
                }
            }
            obj5 = this.query.findFilterOperator(conflictingOps(operator));
            if (obj5 != null && obj5 == operator) {
                if (obj5 == operator) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid Query. You cannot use more than one '");
                    stringBuilder.append(operator.toString());
                    stringBuilder.append("' filter.");
                    obj5 = new IllegalArgumentException(stringBuilder.toString());
                    throw obj5;
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Invalid Query. You cannot use '");
                stringBuilder2.append(operator.toString());
                stringBuilder2.append("' filters with '");
                stringBuilder2.append(obj5.toString());
                stringBuilder2.append("' filters.");
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder2.toString());
                throw illegalArgumentException;
            }
        }
    }

    private void validateOrderByField(FieldPath fieldPath) {
        FieldPath inequalityField = this.query.inequalityField();
        if (this.query.getFirstOrderByField() == null && inequalityField != null) {
            if (inequalityField != null) {
                validateOrderByFieldMatchesInequality(fieldPath, inequalityField);
            }
        }
    }

    private void validateOrderByFieldMatchesInequality(FieldPath fieldPath, FieldPath fieldPath2) {
        if (!fieldPath.equals(fieldPath2)) {
        } else {
        }
        String obj5 = fieldPath2.canonicalString();
        Object[] arr = new Object[3];
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Invalid query. You have an inequality where filter (whereLessThan(), whereGreaterThan(), etc.) on field '%s' and so you must also have '%s' as your first orderBy() field, but your first orderBy() is currently on field '%s' instead.", obj5, obj5, fieldPath.canonicalString()));
        throw illegalArgumentException;
    }

    private com.google.firebase.firestore.Query whereHelper(com.google.firebase.firestore.FieldPath fieldPath, Filter.Operator filter$Operator2, Object object3) {
        int nOT_IN;
        Filter.Operator nOT_IN2;
        Filter.Operator aRRAY_CONTAINS_ANY;
        com.google.firebase.firestore.UserDataReader aRRAY_CONTAINS_ANY2;
        com.google.protobuf.z obj5;
        Preconditions.checkNotNull(fieldPath, "Provided field path must not be null.");
        Preconditions.checkNotNull(operator2, "Provided op must not be null.");
        if (fieldPath.getInternalPath().isKeyField()) {
            if (operator2 == Filter.Operator.ARRAY_CONTAINS) {
            } else {
                if (operator2 == Filter.Operator.ARRAY_CONTAINS_ANY) {
                } else {
                    if (operator2 != Filter.Operator.IN) {
                        if (operator2 == Filter.Operator.NOT_IN) {
                            validateDisjunctiveFilterElements(object3, operator2);
                            nOT_IN = a.l();
                            obj5 = (List)object3.iterator();
                            for (Object next : obj5) {
                                nOT_IN.c(parseDocumentIdValue(next));
                            }
                            obj5 = x.x();
                            obj5.c(nOT_IN);
                            obj5 = obj5.build();
                        } else {
                            obj5 = parseDocumentIdValue(object3);
                        }
                    } else {
                    }
                    FieldFilter obj3 = FieldFilter.create(fieldPath.getInternalPath(), operator2, obj5);
                    validateNewFilter(obj3);
                    Query obj4 = new Query(this.query.filter(obj3), this.firestore);
                    return obj4;
                }
            }
            obj5 = new StringBuilder();
            obj5.append("Invalid query. You can't perform '");
            obj5.append(operator2.toString());
            obj5.append("' queries on FieldPath.documentId().");
            obj3 = new IllegalArgumentException(obj5.toString());
            throw obj3;
        }
        nOT_IN2 = Filter.Operator.IN;
        if (operator2 != nOT_IN2 && operator2 != Filter.Operator.NOT_IN) {
            if (operator2 != Filter.Operator.NOT_IN) {
                if (operator2 == Filter.Operator.ARRAY_CONTAINS_ANY) {
                    validateDisjunctiveFilterElements(object3, operator2);
                }
            } else {
            }
        } else {
        }
        if (operator2 != nOT_IN2) {
            if (operator2 == Filter.Operator.NOT_IN) {
                nOT_IN = 1;
            } else {
                nOT_IN = 0;
            }
        } else {
        }
        obj5 = this.firestore.getUserDataReader().parseQueryValue(object3, nOT_IN);
    }

    public com.google.firebase.firestore.ListenerRegistration addSnapshotListener(Activity activity, com.google.firebase.firestore.EventListener<com.google.firebase.firestore.QuerySnapshot> eventListener2) {
        return addSnapshotListener(activity, MetadataChanges.EXCLUDE, eventListener2);
    }

    public com.google.firebase.firestore.ListenerRegistration addSnapshotListener(Activity activity, com.google.firebase.firestore.MetadataChanges metadataChanges2, com.google.firebase.firestore.EventListener<com.google.firebase.firestore.QuerySnapshot> eventListener3) {
        Preconditions.checkNotNull(activity, "Provided activity must not be null.");
        Preconditions.checkNotNull(metadataChanges2, "Provided MetadataChanges value must not be null.");
        Preconditions.checkNotNull(eventListener3, "Provided EventListener must not be null.");
        return addSnapshotListenerInternal(Executors.DEFAULT_CALLBACK_EXECUTOR, Query.internalOptions(metadataChanges2), activity, eventListener3);
    }

    public com.google.firebase.firestore.ListenerRegistration addSnapshotListener(com.google.firebase.firestore.EventListener<com.google.firebase.firestore.QuerySnapshot> eventListener) {
        return addSnapshotListener(MetadataChanges.EXCLUDE, eventListener);
    }

    public com.google.firebase.firestore.ListenerRegistration addSnapshotListener(com.google.firebase.firestore.MetadataChanges metadataChanges, com.google.firebase.firestore.EventListener<com.google.firebase.firestore.QuerySnapshot> eventListener2) {
        return addSnapshotListener(Executors.DEFAULT_CALLBACK_EXECUTOR, metadataChanges, eventListener2);
    }

    public com.google.firebase.firestore.ListenerRegistration addSnapshotListener(Executor executor, com.google.firebase.firestore.EventListener<com.google.firebase.firestore.QuerySnapshot> eventListener2) {
        return addSnapshotListener(executor, MetadataChanges.EXCLUDE, eventListener2);
    }

    public com.google.firebase.firestore.ListenerRegistration addSnapshotListener(Executor executor, com.google.firebase.firestore.MetadataChanges metadataChanges2, com.google.firebase.firestore.EventListener<com.google.firebase.firestore.QuerySnapshot> eventListener3) {
        Preconditions.checkNotNull(executor, "Provided executor must not be null.");
        Preconditions.checkNotNull(metadataChanges2, "Provided MetadataChanges value must not be null.");
        Preconditions.checkNotNull(eventListener3, "Provided EventListener must not be null.");
        return addSnapshotListenerInternal(executor, Query.internalOptions(metadataChanges2), 0, eventListener3);
    }

    public void b(com.google.firebase.firestore.EventListener eventListener, ViewSnapshot viewSnapshot2, com.google.firebase.firestore.FirebaseFirestoreException firebaseFirestoreException3) {
        a(eventListener, viewSnapshot2, firebaseFirestoreException3);
    }

    public com.google.firebase.firestore.QuerySnapshot d(j j) {
        return c(j);
    }

    public com.google.firebase.firestore.Query endAt(com.google.firebase.firestore.DocumentSnapshot documentSnapshot) {
        Query query = new Query(this.query.endAt(boundFromDocumentSnapshot("endAt", documentSnapshot, true)), this.firestore);
        return query;
    }

    public com.google.firebase.firestore.Query endAt(Object... objectArr) {
        Query query = new Query(this.query.endAt(boundFromFields("endAt", objectArr, true)), this.firestore);
        return query;
    }

    public com.google.firebase.firestore.Query endBefore(com.google.firebase.firestore.DocumentSnapshot documentSnapshot) {
        Query query = new Query(this.query.endAt(boundFromDocumentSnapshot("endBefore", documentSnapshot, false)), this.firestore);
        return query;
    }

    public com.google.firebase.firestore.Query endBefore(Object... objectArr) {
        Query query = new Query(this.query.endAt(boundFromFields("endBefore", objectArr, false)), this.firestore);
        return query;
    }

    public boolean equals(Object object) {
        int i;
        boolean firestore;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (!object instanceof Query) {
            return i2;
        }
        if (this.query.equals(object.query) && this.firestore.equals(object.firestore)) {
            if (this.firestore.equals(object.firestore)) {
            } else {
                i = i2;
            }
        } else {
        }
        return i;
    }

    public j<com.google.firebase.firestore.QuerySnapshot> get() {
        return get(Source.DEFAULT);
    }

    public j<com.google.firebase.firestore.QuerySnapshot> get(com.google.firebase.firestore.Source source) {
        validateHasExplicitOrderByForLimitToLast();
        if (source == Source.CACHE) {
            o oVar = new o(this);
            return this.firestore.getClient().getDocumentsFromLocalCache(this.query).continueWith(Executors.DIRECT_EXECUTOR, oVar);
        }
        return getViaSnapshotListener(source);
    }

    public com.google.firebase.firestore.FirebaseFirestore getFirestore() {
        return this.firestore;
    }

    public int hashCode() {
        return i2 += i4;
    }

    public com.google.firebase.firestore.Query limit(long l) {
        if (Long.compare(l, i) <= 0) {
        } else {
            Query query = new Query(this.query.limitToFirst(l), this.firestore);
            return query;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid Query. Query limit (");
        stringBuilder.append(l);
        stringBuilder.append(") is invalid. Limit must be positive.");
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    public com.google.firebase.firestore.Query limitToLast(long l) {
        if (Long.compare(l, i) <= 0) {
        } else {
            Query query = new Query(this.query.limitToLast(l), this.firestore);
            return query;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid Query. Query limitToLast (");
        stringBuilder.append(l);
        stringBuilder.append(") is invalid. Limit must be positive.");
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    public com.google.firebase.firestore.Query orderBy(com.google.firebase.firestore.FieldPath fieldPath) {
        Preconditions.checkNotNull(fieldPath, "Provided field path must not be null.");
        return orderBy(fieldPath.getInternalPath(), Query.Direction.ASCENDING);
    }

    public com.google.firebase.firestore.Query orderBy(com.google.firebase.firestore.FieldPath fieldPath, com.google.firebase.firestore.Query.Direction query$Direction2) {
        Preconditions.checkNotNull(fieldPath, "Provided field path must not be null.");
        return orderBy(fieldPath.getInternalPath(), direction2);
    }

    public com.google.firebase.firestore.Query orderBy(String string) {
        return orderBy(FieldPath.fromDotSeparatedPath(string), Query.Direction.ASCENDING);
    }

    public com.google.firebase.firestore.Query orderBy(String string, com.google.firebase.firestore.Query.Direction query$Direction2) {
        return orderBy(FieldPath.fromDotSeparatedPath(string), direction2);
    }

    public com.google.firebase.firestore.Query startAfter(com.google.firebase.firestore.DocumentSnapshot documentSnapshot) {
        Query query = new Query(this.query.startAt(boundFromDocumentSnapshot("startAfter", documentSnapshot, false)), this.firestore);
        return query;
    }

    public com.google.firebase.firestore.Query startAfter(Object... objectArr) {
        Query query = new Query(this.query.startAt(boundFromFields("startAfter", objectArr, false)), this.firestore);
        return query;
    }

    public com.google.firebase.firestore.Query startAt(com.google.firebase.firestore.DocumentSnapshot documentSnapshot) {
        Query query = new Query(this.query.startAt(boundFromDocumentSnapshot("startAt", documentSnapshot, true)), this.firestore);
        return query;
    }

    public com.google.firebase.firestore.Query startAt(Object... objectArr) {
        Query query = new Query(this.query.startAt(boundFromFields("startAt", objectArr, true)), this.firestore);
        return query;
    }

    public com.google.firebase.firestore.Query whereArrayContains(com.google.firebase.firestore.FieldPath fieldPath, Object object2) {
        return whereHelper(fieldPath, Filter.Operator.ARRAY_CONTAINS, object2);
    }

    public com.google.firebase.firestore.Query whereArrayContains(String string, Object object2) {
        return whereHelper(FieldPath.fromDotSeparatedPath(string), Filter.Operator.ARRAY_CONTAINS, object2);
    }

    public com.google.firebase.firestore.Query whereArrayContainsAny(com.google.firebase.firestore.FieldPath fieldPath, List<? extends Object> list2) {
        return whereHelper(fieldPath, Filter.Operator.ARRAY_CONTAINS_ANY, list2);
    }

    public com.google.firebase.firestore.Query whereArrayContainsAny(String string, List<? extends Object> list2) {
        return whereHelper(FieldPath.fromDotSeparatedPath(string), Filter.Operator.ARRAY_CONTAINS_ANY, list2);
    }

    public com.google.firebase.firestore.Query whereEqualTo(com.google.firebase.firestore.FieldPath fieldPath, Object object2) {
        return whereHelper(fieldPath, Filter.Operator.EQUAL, object2);
    }

    public com.google.firebase.firestore.Query whereEqualTo(String string, Object object2) {
        return whereHelper(FieldPath.fromDotSeparatedPath(string), Filter.Operator.EQUAL, object2);
    }

    public com.google.firebase.firestore.Query whereGreaterThan(com.google.firebase.firestore.FieldPath fieldPath, Object object2) {
        return whereHelper(fieldPath, Filter.Operator.GREATER_THAN, object2);
    }

    public com.google.firebase.firestore.Query whereGreaterThan(String string, Object object2) {
        return whereHelper(FieldPath.fromDotSeparatedPath(string), Filter.Operator.GREATER_THAN, object2);
    }

    public com.google.firebase.firestore.Query whereGreaterThanOrEqualTo(com.google.firebase.firestore.FieldPath fieldPath, Object object2) {
        return whereHelper(fieldPath, Filter.Operator.GREATER_THAN_OR_EQUAL, object2);
    }

    public com.google.firebase.firestore.Query whereGreaterThanOrEqualTo(String string, Object object2) {
        return whereHelper(FieldPath.fromDotSeparatedPath(string), Filter.Operator.GREATER_THAN_OR_EQUAL, object2);
    }

    public com.google.firebase.firestore.Query whereIn(com.google.firebase.firestore.FieldPath fieldPath, List<? extends Object> list2) {
        return whereHelper(fieldPath, Filter.Operator.IN, list2);
    }

    public com.google.firebase.firestore.Query whereIn(String string, List<? extends Object> list2) {
        return whereHelper(FieldPath.fromDotSeparatedPath(string), Filter.Operator.IN, list2);
    }

    public com.google.firebase.firestore.Query whereLessThan(com.google.firebase.firestore.FieldPath fieldPath, Object object2) {
        return whereHelper(fieldPath, Filter.Operator.LESS_THAN, object2);
    }

    public com.google.firebase.firestore.Query whereLessThan(String string, Object object2) {
        return whereHelper(FieldPath.fromDotSeparatedPath(string), Filter.Operator.LESS_THAN, object2);
    }

    public com.google.firebase.firestore.Query whereLessThanOrEqualTo(com.google.firebase.firestore.FieldPath fieldPath, Object object2) {
        return whereHelper(fieldPath, Filter.Operator.LESS_THAN_OR_EQUAL, object2);
    }

    public com.google.firebase.firestore.Query whereLessThanOrEqualTo(String string, Object object2) {
        return whereHelper(FieldPath.fromDotSeparatedPath(string), Filter.Operator.LESS_THAN_OR_EQUAL, object2);
    }

    public com.google.firebase.firestore.Query whereNotEqualTo(com.google.firebase.firestore.FieldPath fieldPath, Object object2) {
        return whereHelper(fieldPath, Filter.Operator.NOT_EQUAL, object2);
    }

    public com.google.firebase.firestore.Query whereNotEqualTo(String string, Object object2) {
        return whereHelper(FieldPath.fromDotSeparatedPath(string), Filter.Operator.NOT_EQUAL, object2);
    }

    public com.google.firebase.firestore.Query whereNotIn(com.google.firebase.firestore.FieldPath fieldPath, List<? extends Object> list2) {
        return whereHelper(fieldPath, Filter.Operator.NOT_IN, list2);
    }

    public com.google.firebase.firestore.Query whereNotIn(String string, List<? extends Object> list2) {
        return whereHelper(FieldPath.fromDotSeparatedPath(string), Filter.Operator.NOT_IN, list2);
    }
}
