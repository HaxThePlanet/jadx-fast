package com.google.firebase.database.core.operation;

import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.ChildKey;

/* loaded from: classes2.dex */
public class Merge extends com.google.firebase.database.core.operation.Operation {

    private final CompoundWrite children;
    public Merge(com.google.firebase.database.core.operation.OperationSource operationSource, Path path2, CompoundWrite compoundWrite3) {
        super(Operation.OperationType.Merge, operationSource, path2);
        this.children = compoundWrite3;
    }

    @Override // com.google.firebase.database.core.operation.Operation
    public CompoundWrite getChildren() {
        return this.children;
    }

    @Override // com.google.firebase.database.core.operation.Operation
    public com.google.firebase.database.core.operation.Operation operationForChild(ChildKey childKey) {
        int i = 0;
        ChildKey[] arr = new ChildKey[1];
        Path path4 = new Path(arr);
        CompoundWrite obj6 = this.children.childCompoundWrite(path4);
        if (this.path.isEmpty() && obj6.isEmpty()) {
            arr = new ChildKey[1];
            path4 = new Path(arr);
            obj6 = this.children.childCompoundWrite(path4);
            if (obj6.isEmpty()) {
                return i;
            }
            if (obj6.rootWrite() != null) {
                Overwrite overwrite = new Overwrite(this.source, Path.getEmptyPath(), obj6.rootWrite());
                return overwrite;
            }
            Merge merge = new Merge(this.source, Path.getEmptyPath(), obj6);
            return merge;
        }
        if (this.path.getFront().equals(childKey)) {
            obj6 = new Merge(this.source, this.path.popFront(), this.children);
            return obj6;
        }
        return i;
    }

    @Override // com.google.firebase.database.core.operation.Operation
    public String toString() {
        Object[] arr = new Object[3];
        return String.format("Merge { path=%s, source=%s, children=%s }", getPath(), getSource(), this.children);
    }
}
