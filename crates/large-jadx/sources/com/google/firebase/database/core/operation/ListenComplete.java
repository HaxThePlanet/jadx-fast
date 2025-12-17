package com.google.firebase.database.core.operation;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.ChildKey;

/* loaded from: classes2.dex */
public class ListenComplete extends com.google.firebase.database.core.operation.Operation {
    public ListenComplete(com.google.firebase.database.core.operation.OperationSource operationSource, Path path2) {
        super(Operation.OperationType.ListenComplete, operationSource, path2);
        Utilities.hardAssert(obj2 ^= 1, "Can't have a listen complete from a user source");
    }

    @Override // com.google.firebase.database.core.operation.Operation
    public com.google.firebase.database.core.operation.Operation operationForChild(ChildKey childKey) {
        if (this.path.isEmpty()) {
            ListenComplete obj3 = new ListenComplete(this.source, Path.getEmptyPath());
            return obj3;
        }
        obj3 = new ListenComplete(this.source, this.path.popFront());
        return obj3;
    }

    @Override // com.google.firebase.database.core.operation.Operation
    public String toString() {
        Object[] arr = new Object[2];
        return String.format("ListenComplete { path=%s, source=%s }", getPath(), getSource());
    }
}
