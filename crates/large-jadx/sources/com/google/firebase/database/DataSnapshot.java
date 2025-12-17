package com.google.firebase.database;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.database.core.utilities.encoding.CustomClassMapper;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.Node;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class DataSnapshot {

    private final IndexedNode node;
    private final com.google.firebase.database.DatabaseReference query;
    DataSnapshot(com.google.firebase.database.DatabaseReference databaseReference, IndexedNode indexedNode2) {
        super();
        this.node = indexedNode2;
        this.query = databaseReference;
    }

    static com.google.firebase.database.DatabaseReference access$000(com.google.firebase.database.DataSnapshot dataSnapshot) {
        return dataSnapshot.query;
    }

    public com.google.firebase.database.DataSnapshot child(String string) {
        Path path = new Path(string);
        DataSnapshot dataSnapshot = new DataSnapshot(this.query.child(string), IndexedNode.from(this.node.getNode().getChild(path)));
        return dataSnapshot;
    }

    public boolean exists() {
        return empty ^= 1;
    }

    public Iterable<com.google.firebase.database.DataSnapshot> getChildren() {
        DataSnapshot.1 anon = new DataSnapshot.1(this, this.node.iterator());
        return anon;
    }

    public long getChildrenCount() {
        return (long)childCount;
    }

    public String getKey() {
        return this.query.getKey();
    }

    public Object getPriority() {
        Object valueOf;
        valueOf = this.node.getNode().getPriority().getValue();
        final boolean z = valueOf instanceof Long;
        if (z) {
            valueOf = Double.valueOf((double)longValue);
        }
        return valueOf;
    }

    public com.google.firebase.database.DatabaseReference getRef() {
        return this.query;
    }

    public Object getValue() {
        return this.node.getNode().getValue();
    }

    public <T> T getValue(com.google.firebase.database.GenericTypeIndicator<T> genericTypeIndicator) {
        return CustomClassMapper.convertToCustomClass(this.node.getNode().getValue(), genericTypeIndicator);
    }

    public <T> T getValue(Class<T> class) {
        return CustomClassMapper.convertToCustomClass(this.node.getNode().getValue(), class);
    }

    public Object getValue(boolean z) {
        return this.node.getNode().getValue(z);
    }

    public boolean hasChild(String string) {
        if (this.query.getParent() == null) {
            Validation.validateRootPathString(string);
        } else {
            Validation.validatePathString(string);
        }
        Path path = new Path(string);
        return obj3 ^= 1;
    }

    public boolean hasChildren() {
        int i;
        i = this.node.getNode().getChildCount() > 0 ? 1 : 0;
        return i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataSnapshot { key = ");
        stringBuilder.append(this.query.getKey());
        stringBuilder.append(", value = ");
        stringBuilder.append(this.node.getNode().getValue(true));
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}
