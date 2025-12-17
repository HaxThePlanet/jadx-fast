package com.google.firebase.database;

import com.google.android.gms.common.internal.p;
import com.google.android.gms.tasks.j;
import com.google.firebase.database.core.ChildEventRegistration;
import com.google.firebase.database.core.EventRegistration;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.Repo;
import com.google.firebase.database.core.ValueEventRegistration;
import com.google.firebase.database.core.ZombieEventManager;
import com.google.firebase.database.core.utilities.PushIdGenerator;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.database.core.view.QueryParams;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.snapshot.BooleanNode;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.DoubleNode;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.KeyIndex;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.PathIndex;
import com.google.firebase.database.snapshot.PriorityIndex;
import com.google.firebase.database.snapshot.PriorityUtilities;
import com.google.firebase.database.snapshot.StringNode;
import com.google.firebase.database.snapshot.ValueIndex;
import java.util.Objects;

/* loaded from: classes2.dex */
public class Query {

    private final boolean orderByCalled;
    protected final QueryParams params;
    protected final Path path;
    protected final Repo repo;
    Query(Repo repo, Path path2) {
        super();
        this.repo = repo;
        this.path = path2;
        this.params = QueryParams.DEFAULT_PARAMS;
        this.orderByCalled = false;
    }

    Query(Repo repo, Path path2, QueryParams queryParams3, boolean z4) {
        super();
        this.repo = repo;
        this.path = path2;
        this.params = queryParams3;
        this.orderByCalled = z4;
        Utilities.hardAssert(queryParams3.isValid(), "Validation of queries failed.");
    }

    private void addEventRegistration(EventRegistration eventRegistration) {
        ZombieEventManager.getInstance().recordEventRegistration(eventRegistration);
        Query.3 anon = new Query.3(this, eventRegistration);
        this.repo.scheduleNow(anon);
    }

    private com.google.firebase.database.Query endAt(Node node, String string2) {
        boolean leafNode;
        int obj5;
        Validation.validateNullableKey(string2);
        if (!node.isLeafNode()) {
            if (!node.isEmpty()) {
            } else {
            }
            IllegalArgumentException obj4 = new IllegalArgumentException("Can only use simple values for endAt()");
            throw obj4;
        }
        if (string2 != null) {
            obj5 = ChildKey.fromString(string2);
        } else {
            obj5 = 0;
        }
        if (this.params.hasEnd()) {
        } else {
            obj4 = this.params.endAt(node, obj5);
            validateLimit(obj4);
            validateQueryEndpoints(obj4);
            Utilities.hardAssert(obj4.isValid());
            obj5 = new Query(this.repo, this.path, obj4, this.orderByCalled);
            return obj5;
        }
        obj4 = new IllegalArgumentException("Can't call endAt() or equalTo() multiple times");
        throw obj4;
    }

    private com.google.firebase.database.Query endBefore(Node node, String string2) {
        return endAt(node, PushIdGenerator.predecessor(string2));
    }

    private void removeEventRegistration(EventRegistration eventRegistration) {
        ZombieEventManager.getInstance().zombifyForRemove(eventRegistration);
        Query.2 anon = new Query.2(this, eventRegistration);
        this.repo.scheduleNow(anon);
    }

    private com.google.firebase.database.Query startAfter(Node node, String string2) {
        return startAt(node, PushIdGenerator.successor(string2));
    }

    private com.google.firebase.database.Query startAt(Node node, String string2) {
        boolean leafNode;
        int minName;
        Validation.validateNullableKey(string2);
        if (!node.isLeafNode()) {
            if (!node.isEmpty()) {
            } else {
            }
            IllegalArgumentException obj4 = new IllegalArgumentException("Can only use simple values for startAt() and startAfter()");
            throw obj4;
        }
        if (this.params.hasStart()) {
        } else {
            minName = 0;
            if (string2 != null) {
                if (string2.equals("[MIN_NAME]")) {
                    minName = ChildKey.getMinName();
                } else {
                    if (string2.equals("[MAX_KEY]")) {
                        minName = ChildKey.getMaxName();
                    } else {
                        minName = ChildKey.fromString(string2);
                    }
                }
            }
            obj4 = this.params.startAt(node, minName);
            validateLimit(obj4);
            validateQueryEndpoints(obj4);
            Utilities.hardAssert(obj4.isValid());
            Query obj5 = new Query(this.repo, this.path, obj4, this.orderByCalled);
            return obj5;
        }
        obj4 = new IllegalArgumentException("Can't call startAt(), startAfte(), or equalTo() multiple times");
        throw obj4;
    }

    private void validateEqualToCall() {
        if (this.params.hasStart()) {
        } else {
            if (this.params.hasEnd()) {
            } else {
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot combine equalTo() with endAt() or endBefore()");
            throw illegalArgumentException;
        }
        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Cannot combine equalTo() with startAt() or startAfter()");
        throw illegalArgumentException2;
    }

    private void validateLimit(QueryParams queryParams) {
        boolean start;
        boolean obj2;
        if (queryParams.hasStart() && queryParams.hasEnd() && queryParams.hasLimit()) {
            if (queryParams.hasEnd()) {
                if (queryParams.hasLimit()) {
                    if (!queryParams.hasAnchoredLimit()) {
                    } else {
                    }
                    obj2 = new IllegalArgumentException("Can't combine startAt(), startAfter(), endAt(), endBefore(), and limit(). Use limitToFirst() or limitToLast() instead");
                    throw obj2;
                }
            }
        }
    }

    private void validateNoOrderByCall() {
        if (this.orderByCalled) {
        } else {
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You can't combine multiple orderBy calls!");
        throw illegalArgumentException;
    }

    private void validateQueryEndpoints(QueryParams queryParams) {
        boolean validPriority;
        boolean indexStartValue;
        PriorityIndex indexEndValue;
        boolean maxName;
        ChildKey minName;
        boolean obj5;
        if (queryParams.getIndex().equals(KeyIndex.getInstance())) {
            validPriority = "You must use startAt(String value), startAfter(String value), endAt(String value), endBefore(String value) or equalTo(String value) in combination with orderByKey(). Other type of values or using the version with 2 parameters is not supported";
            if (queryParams.hasStart()) {
                if (!p.a(queryParams.getIndexStartName(), ChildKey.getMinName())) {
                } else {
                    if (!indexStartValue instanceof StringNode) {
                    } else {
                    }
                }
                obj5 = new IllegalArgumentException(validPriority);
                throw obj5;
            }
            if (queryParams.hasEnd()) {
                if (!queryParams.getIndexEndName().equals(ChildKey.getMaxName())) {
                } else {
                    if (!indexEndValue instanceof StringNode) {
                    } else {
                    }
                }
                obj5 = new IllegalArgumentException(validPriority);
                throw obj5;
            }
        } else {
            if (queryParams.getIndex().equals(PriorityIndex.getInstance())) {
                if (queryParams.hasStart() && PriorityUtilities.isValidPriority(queryParams.getIndexStartValue())) {
                    if (!PriorityUtilities.isValidPriority(queryParams.getIndexStartValue())) {
                    } else {
                        if (queryParams.hasEnd()) {
                            if (!PriorityUtilities.isValidPriority(queryParams.getIndexEndValue())) {
                            } else {
                            }
                        }
                    }
                    obj5 = new IllegalArgumentException("When using orderByPriority(), values provided to startAt(), startAfter(), endAt(), endBefore(), or equalTo() must be valid priorities.");
                    throw obj5;
                } else {
                }
            }
        }
    }

    public com.google.firebase.database.ChildEventListener addChildEventListener(com.google.firebase.database.ChildEventListener childEventListener) {
        ChildEventRegistration childEventRegistration = new ChildEventRegistration(this.repo, childEventListener, getSpec());
        addEventRegistration(childEventRegistration);
        return childEventListener;
    }

    public void addListenerForSingleValueEvent(com.google.firebase.database.ValueEventListener valueEventListener) {
        Query.1 anon = new Query.1(this, valueEventListener);
        ValueEventRegistration valueEventRegistration = new ValueEventRegistration(this.repo, anon, getSpec());
        addEventRegistration(valueEventRegistration);
    }

    public com.google.firebase.database.ValueEventListener addValueEventListener(com.google.firebase.database.ValueEventListener valueEventListener) {
        ValueEventRegistration valueEventRegistration = new ValueEventRegistration(this.repo, valueEventListener, getSpec());
        addEventRegistration(valueEventRegistration);
        return valueEventListener;
    }

    public com.google.firebase.database.Query endAt(double d) {
        return endAt(d, obj3);
    }

    public com.google.firebase.database.Query endAt(double d, String string2) {
        DoubleNode doubleNode = new DoubleNode(Double.valueOf(d), PriorityUtilities.NullPriority());
        return endAt(doubleNode, obj4);
    }

    public com.google.firebase.database.Query endAt(String string) {
        return endAt(string, 0);
    }

    public com.google.firebase.database.Query endAt(String string, String string2) {
        Object stringNode;
        Node node;
        if (string != null) {
            stringNode = new StringNode(string, PriorityUtilities.NullPriority());
        } else {
            stringNode = EmptyNode.Empty();
        }
        return endAt(stringNode, string2);
    }

    public com.google.firebase.database.Query endAt(boolean z) {
        return endAt(z, 0);
    }

    public com.google.firebase.database.Query endAt(boolean z, String string2) {
        BooleanNode booleanNode = new BooleanNode(Boolean.valueOf(z), PriorityUtilities.NullPriority());
        return endAt(booleanNode, string2);
    }

    public com.google.firebase.database.Query endBefore(double d) {
        return endAt(d, obj3);
    }

    public com.google.firebase.database.Query endBefore(double d, String string2) {
        DoubleNode doubleNode = new DoubleNode(Double.valueOf(d), PriorityUtilities.NullPriority());
        return endBefore(doubleNode, obj4);
    }

    public com.google.firebase.database.Query endBefore(String string) {
        boolean equals;
        KeyIndex instance;
        if (string != null && this.params.getIndex().equals(KeyIndex.getInstance())) {
            if (this.params.getIndex().equals(KeyIndex.getInstance())) {
                return endAt(PushIdGenerator.predecessor(string));
            }
        }
        return endAt(string, ChildKey.getMinName().asString());
    }

    public com.google.firebase.database.Query endBefore(String string, String string2) {
        boolean equals;
        Object stringNode;
        KeyIndex instance;
        String obj3;
        if (string != null && this.params.getIndex().equals(KeyIndex.getInstance())) {
            if (this.params.getIndex().equals(KeyIndex.getInstance())) {
                obj3 = PushIdGenerator.predecessor(string);
            }
        }
        if (obj3 != null) {
            stringNode = new StringNode(obj3, PriorityUtilities.NullPriority());
        } else {
            stringNode = EmptyNode.Empty();
        }
        return endBefore(stringNode, string2);
    }

    public com.google.firebase.database.Query endBefore(boolean z) {
        return endAt(z, ChildKey.getMinName().asString());
    }

    public com.google.firebase.database.Query endBefore(boolean z, String string2) {
        BooleanNode booleanNode = new BooleanNode(Boolean.valueOf(z), PriorityUtilities.NullPriority());
        return endBefore(booleanNode, string2);
    }

    public com.google.firebase.database.Query equalTo(double d) {
        validateEqualToCall();
        return startAt(d).endAt(d);
    }

    public com.google.firebase.database.Query equalTo(double d, String string2) {
        validateEqualToCall();
        return startAt(d, string2).endAt(d, string2);
    }

    public com.google.firebase.database.Query equalTo(String string) {
        validateEqualToCall();
        return startAt(string).endAt(string);
    }

    public com.google.firebase.database.Query equalTo(String string, String string2) {
        validateEqualToCall();
        return startAt(string, string2).endAt(string, string2);
    }

    public com.google.firebase.database.Query equalTo(boolean z) {
        validateEqualToCall();
        return startAt(z).endAt(z);
    }

    public com.google.firebase.database.Query equalTo(boolean z, String string2) {
        validateEqualToCall();
        return startAt(z, string2).endAt(z, string2);
    }

    public j<com.google.firebase.database.DataSnapshot> get() {
        return this.repo.getValue(this);
    }

    public Path getPath() {
        return this.path;
    }

    public com.google.firebase.database.DatabaseReference getRef() {
        DatabaseReference databaseReference = new DatabaseReference(this.repo, getPath());
        return databaseReference;
    }

    public Repo getRepo() {
        return this.repo;
    }

    public QuerySpec getSpec() {
        QuerySpec querySpec = new QuerySpec(this.path, this.params);
        return querySpec;
    }

    public void keepSynced(boolean z) {
        boolean equals;
        ChildKey infoKey;
        if (!this.path.isEmpty()) {
            if (this.path.getFront().equals(ChildKey.getInfoKey())) {
            } else {
            }
            DatabaseException obj3 = new DatabaseException("Can't call keepSynced() on .info paths.");
            throw obj3;
        }
        Query.4 anon = new Query.4(this, z);
        this.repo.scheduleNow(anon);
    }

    public com.google.firebase.database.Query limitToFirst(int i) {
        if (i <= 0) {
        } else {
            if (this.params.hasLimit()) {
            } else {
                Query query = new Query(this.repo, this.path, this.params.limitToFirst(i), this.orderByCalled);
                return query;
            }
            IllegalArgumentException obj5 = new IllegalArgumentException("Can't call limitToLast on query with previously set limit!");
            throw obj5;
        }
        obj5 = new IllegalArgumentException("Limit must be a positive integer!");
        throw obj5;
    }

    public com.google.firebase.database.Query limitToLast(int i) {
        if (i <= 0) {
        } else {
            if (this.params.hasLimit()) {
            } else {
                Query query = new Query(this.repo, this.path, this.params.limitToLast(i), this.orderByCalled);
                return query;
            }
            IllegalArgumentException obj5 = new IllegalArgumentException("Can't call limitToLast on query with previously set limit!");
            throw obj5;
        }
        obj5 = new IllegalArgumentException("Limit must be a positive integer!");
        throw obj5;
    }

    public com.google.firebase.database.Query orderByChild(String string) {
        boolean equals3;
        boolean equals2;
        boolean equals;
        Objects.requireNonNull(string, "Key can't be null");
        String str9 = "Can't use '";
        if (string.equals("$key")) {
        } else {
            if (string.equals(".key")) {
            } else {
                if (string.equals("$priority")) {
                } else {
                    if (string.equals(".priority")) {
                    } else {
                        if (string.equals("$value")) {
                        } else {
                            if (string.equals(".value")) {
                            } else {
                                Validation.validatePathString(string);
                                validateNoOrderByCall();
                                Path path = new Path(string);
                                if (path.size() == 0) {
                                } else {
                                    PathIndex obj5 = new PathIndex(path);
                                    Query query = new Query(this.repo, this.path, this.params.orderBy(obj5), 1);
                                    return query;
                                }
                                obj5 = new IllegalArgumentException("Can't use empty path, use orderByValue() instead!");
                                throw obj5;
                            }
                        }
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(str9);
                        stringBuilder2.append(string);
                        stringBuilder2.append("' as path, please use orderByValue() instead!");
                        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.toString());
                        throw illegalArgumentException2;
                    }
                }
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(str9);
                stringBuilder3.append(string);
                stringBuilder3.append("' as path, please use orderByPriority() instead!");
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(stringBuilder3.toString());
                throw illegalArgumentException3;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str9);
        stringBuilder.append(string);
        stringBuilder.append("' as path, please use orderByKey() instead!");
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    public com.google.firebase.database.Query orderByKey() {
        validateNoOrderByCall();
        QueryParams orderBy = this.params.orderBy(KeyIndex.getInstance());
        validateQueryEndpoints(orderBy);
        Query query = new Query(this.repo, this.path, orderBy, 1);
        return query;
    }

    public com.google.firebase.database.Query orderByPriority() {
        validateNoOrderByCall();
        QueryParams orderBy = this.params.orderBy(PriorityIndex.getInstance());
        validateQueryEndpoints(orderBy);
        Query query = new Query(this.repo, this.path, orderBy, 1);
        return query;
    }

    public com.google.firebase.database.Query orderByValue() {
        validateNoOrderByCall();
        Query query = new Query(this.repo, this.path, this.params.orderBy(ValueIndex.getInstance()), 1);
        return query;
    }

    public void removeEventListener(com.google.firebase.database.ChildEventListener childEventListener) {
        Objects.requireNonNull(childEventListener, "listener must not be null");
        ChildEventRegistration childEventRegistration = new ChildEventRegistration(this.repo, childEventListener, getSpec());
        removeEventRegistration(childEventRegistration);
    }

    public void removeEventListener(com.google.firebase.database.ValueEventListener valueEventListener) {
        Objects.requireNonNull(valueEventListener, "listener must not be null");
        ValueEventRegistration valueEventRegistration = new ValueEventRegistration(this.repo, valueEventListener, getSpec());
        removeEventRegistration(valueEventRegistration);
    }

    public com.google.firebase.database.Query startAfter(double d) {
        return startAt(d, obj3);
    }

    public com.google.firebase.database.Query startAfter(double d, String string2) {
        DoubleNode doubleNode = new DoubleNode(Double.valueOf(d), PriorityUtilities.NullPriority());
        return startAfter(doubleNode, obj4);
    }

    public com.google.firebase.database.Query startAfter(String string) {
        boolean equals;
        KeyIndex instance;
        if (string != null && this.params.getIndex().equals(KeyIndex.getInstance())) {
            if (this.params.getIndex().equals(KeyIndex.getInstance())) {
                return startAt(PushIdGenerator.successor(string));
            }
        }
        return startAt(string, ChildKey.getMaxName().asString());
    }

    public com.google.firebase.database.Query startAfter(String string, String string2) {
        boolean equals;
        Object stringNode;
        KeyIndex instance;
        String obj3;
        if (string != null && this.params.getIndex().equals(KeyIndex.getInstance())) {
            if (this.params.getIndex().equals(KeyIndex.getInstance())) {
                obj3 = PushIdGenerator.successor(string);
            }
        }
        if (obj3 != null) {
            stringNode = new StringNode(obj3, PriorityUtilities.NullPriority());
        } else {
            stringNode = EmptyNode.Empty();
        }
        return startAfter(stringNode, string2);
    }

    public com.google.firebase.database.Query startAfter(boolean z) {
        return startAt(z, ChildKey.getMaxName().asString());
    }

    public com.google.firebase.database.Query startAfter(boolean z, String string2) {
        BooleanNode booleanNode = new BooleanNode(Boolean.valueOf(z), PriorityUtilities.NullPriority());
        return startAfter(booleanNode, string2);
    }

    public com.google.firebase.database.Query startAt(double d) {
        return startAt(d, obj3);
    }

    public com.google.firebase.database.Query startAt(double d, String string2) {
        DoubleNode doubleNode = new DoubleNode(Double.valueOf(d), PriorityUtilities.NullPriority());
        return startAt(doubleNode, obj4);
    }

    public com.google.firebase.database.Query startAt(String string) {
        return startAt(string, 0);
    }

    public com.google.firebase.database.Query startAt(String string, String string2) {
        Object stringNode;
        Node node;
        if (string != null) {
            stringNode = new StringNode(string, PriorityUtilities.NullPriority());
        } else {
            stringNode = EmptyNode.Empty();
        }
        return startAt(stringNode, string2);
    }

    public com.google.firebase.database.Query startAt(boolean z) {
        return startAt(z, 0);
    }

    public com.google.firebase.database.Query startAt(boolean z, String string2) {
        BooleanNode booleanNode = new BooleanNode(Boolean.valueOf(z), PriorityUtilities.NullPriority());
        return startAt(booleanNode, string2);
    }
}
