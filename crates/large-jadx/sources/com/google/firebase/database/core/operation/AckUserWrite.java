package com.google.firebase.database.core.operation;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.ChildKey;

/* loaded from: classes2.dex */
public class AckUserWrite extends com.google.firebase.database.core.operation.Operation {

    private final ImmutableTree<Boolean> affectedTree;
    private final boolean revert;
    public AckUserWrite(Path path, ImmutableTree<Boolean> immutableTree2, boolean z3) {
        super(Operation.OperationType.AckUserWrite, OperationSource.USER, path);
        this.affectedTree = immutableTree2;
        this.revert = z3;
    }

    public ImmutableTree<Boolean> getAffectedTree() {
        return this.affectedTree;
    }

    @Override // com.google.firebase.database.core.operation.Operation
    public boolean isRevert() {
        return this.revert;
    }

    @Override // com.google.firebase.database.core.operation.Operation
    public com.google.firebase.database.core.operation.Operation operationForChild(ChildKey childKey) {
        if (!this.path.isEmpty()) {
            Utilities.hardAssert(this.path.getFront().equals(childKey), "operationForChild called for unrelated child.");
            AckUserWrite obj5 = new AckUserWrite(this.path.popFront(), this.affectedTree, this.revert);
            return obj5;
        }
        if (this.affectedTree.getValue() != null) {
            Utilities.hardAssert(this.affectedTree.getChildren().isEmpty(), "affectedTree should not have overlapping affected paths.");
            return this;
        }
        ChildKey[] arr = new ChildKey[1];
        Path path4 = new Path(arr);
        AckUserWrite ackUserWrite = new AckUserWrite(Path.getEmptyPath(), this.affectedTree.subtree(path4), this.revert);
        return ackUserWrite;
    }

    @Override // com.google.firebase.database.core.operation.Operation
    public String toString() {
        Object[] arr = new Object[3];
        return String.format("AckUserWrite { path=%s, revert=%s, affectedTree=%s }", getPath(), Boolean.valueOf(this.revert), this.affectedTree);
    }
}
