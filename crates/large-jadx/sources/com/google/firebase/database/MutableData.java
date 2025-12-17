package com.google.firebase.database;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.SnapshotHolder;
import com.google.firebase.database.core.ValidationPath;
import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.database.core.utilities.encoding.CustomClassMapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.snapshot.PriorityUtilities;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class MutableData {

    private final SnapshotHolder holder;
    private final Path prefixPath;
    private MutableData(SnapshotHolder snapshotHolder, Path path2) {
        super();
        this.holder = snapshotHolder;
        this.prefixPath = path2;
        ValidationPath.validateWithObject(path2, getValue());
    }

    MutableData(SnapshotHolder snapshotHolder, Path path2, com.google.firebase.database.MutableData.1 mutableData$13) {
        super(snapshotHolder, path2);
    }

    MutableData(Node node) {
        SnapshotHolder snapshotHolder = new SnapshotHolder(node);
        Path obj3 = new Path("");
        super(snapshotHolder, obj3);
    }

    static SnapshotHolder access$000(com.google.firebase.database.MutableData mutableData) {
        return mutableData.holder;
    }

    static Path access$100(com.google.firebase.database.MutableData mutableData) {
        return mutableData.prefixPath;
    }

    public com.google.firebase.database.MutableData child(String string) {
        Validation.validatePathString(string);
        Path path = new Path(string);
        MutableData mutableData = new MutableData(this.holder, this.prefixPath.child(path));
        return mutableData;
    }

    public boolean equals(Object object) {
        Path prefixPath;
        SnapshotHolder holder;
        int obj3;
        if (object instanceof MutableData != null && this.holder.equals(object.holder) && this.prefixPath.equals(object.prefixPath)) {
            if (this.holder.equals(object.holder)) {
                obj3 = this.prefixPath.equals(object.prefixPath) ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj3;
    }

    public Iterable<com.google.firebase.database.MutableData> getChildren() {
        boolean leafNode;
        Node node = getNode();
        if (!node.isEmpty() && node.isLeafNode()) {
            if (node.isLeafNode()) {
            }
            MutableData.2 anon2 = new MutableData.2(this, IndexedNode.from(node).iterator());
            return anon2;
        }
        MutableData.1 anon = new MutableData.1(this);
        return anon;
    }

    public long getChildrenCount() {
        return (long)childCount;
    }

    public String getKey() {
        String string;
        if (this.prefixPath.getBack() != null) {
            string = this.prefixPath.getBack().asString();
        } else {
            string = 0;
        }
        return string;
    }

    Node getNode() {
        return this.holder.getNode(this.prefixPath);
    }

    public Object getPriority() {
        return getNode().getPriority().getValue();
    }

    public Object getValue() {
        return getNode().getValue();
    }

    public <T> T getValue(com.google.firebase.database.GenericTypeIndicator<T> genericTypeIndicator) {
        return CustomClassMapper.convertToCustomClass(getNode().getValue(), genericTypeIndicator);
    }

    public <T> T getValue(Class<T> class) {
        return CustomClassMapper.convertToCustomClass(getNode().getValue(), class);
    }

    public boolean hasChild(String string) {
        Path path = new Path(string);
        return obj3 ^= 1;
    }

    public boolean hasChildren() {
        Node empty;
        int i;
        empty = getNode();
        if (!empty.isLeafNode() && !empty.isEmpty()) {
            i = !empty.isEmpty() ? 1 : 0;
        } else {
        }
        return i;
    }

    public void setPriority(Object object) {
        this.holder.update(this.prefixPath, getNode().updatePriority(PriorityUtilities.parsePriority(this.prefixPath, object)));
    }

    public void setValue(Object object) {
        ValidationPath.validateWithObject(this.prefixPath, object);
        Object obj3 = CustomClassMapper.convertToPlainJavaTypes(object);
        Validation.validateWritableObject(obj3);
        this.holder.update(this.prefixPath, NodeUtilities.NodeFromJSON(obj3));
    }

    public String toString() {
        String string;
        ChildKey front = this.prefixPath.getFront();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MutableData { key = ");
        if (front != null) {
            string = front.asString();
        } else {
            string = "<none>";
        }
        stringBuilder.append(string);
        stringBuilder.append(", value = ");
        stringBuilder.append(this.holder.getRootNode().getValue(true));
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}
