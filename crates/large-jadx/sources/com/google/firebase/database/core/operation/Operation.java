package com.google.firebase.database.core.operation;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.ChildKey;

/* loaded from: classes2.dex */
public abstract class Operation {

    protected final Path path;
    protected final com.google.firebase.database.core.operation.OperationSource source;
    protected final com.google.firebase.database.core.operation.Operation.OperationType type;

    public static enum OperationType {

        Overwrite,
        Merge,
        AckUserWrite,
        ListenComplete;
    }
    protected Operation(com.google.firebase.database.core.operation.Operation.OperationType operation$OperationType, com.google.firebase.database.core.operation.OperationSource operationSource2, Path path3) {
        super();
        this.type = operationType;
        this.source = operationSource2;
        this.path = path3;
    }

    public Path getPath() {
        return this.path;
    }

    public com.google.firebase.database.core.operation.OperationSource getSource() {
        return this.source;
    }

    public com.google.firebase.database.core.operation.Operation.OperationType getType() {
        return this.type;
    }

    public abstract com.google.firebase.database.core.operation.Operation operationForChild(ChildKey childKey);
}
