package com.google.firebase.database.core.operation;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Node;

/* loaded from: classes2.dex */
public class Overwrite extends com.google.firebase.database.core.operation.Operation {

    private final Node snapshot;
    public Overwrite(com.google.firebase.database.core.operation.OperationSource operationSource, Path path2, Node node3) {
        super(Operation.OperationType.Overwrite, operationSource, path2);
        this.snapshot = node3;
    }

    @Override // com.google.firebase.database.core.operation.Operation
    public Node getSnapshot() {
        return this.snapshot;
    }

    @Override // com.google.firebase.database.core.operation.Operation
    public com.google.firebase.database.core.operation.Operation operationForChild(ChildKey childKey) {
        if (this.path.isEmpty()) {
            Overwrite overwrite = new Overwrite(this.source, Path.getEmptyPath(), this.snapshot.getImmediateChild(childKey));
            return overwrite;
        }
        Overwrite obj5 = new Overwrite(this.source, this.path.popFront(), this.snapshot);
        return obj5;
    }

    @Override // com.google.firebase.database.core.operation.Operation
    public String toString() {
        Object[] arr = new Object[3];
        return String.format("Overwrite { path=%s, source=%s, snapshot=%s }", getPath(), getSource(), this.snapshot);
    }
}
