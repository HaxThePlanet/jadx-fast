package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.utilities.Utilities;

/* loaded from: classes2.dex */
public class StringNode extends com.google.firebase.database.snapshot.LeafNode<com.google.firebase.database.snapshot.StringNode> {

    private final String value;
    public StringNode(String string, com.google.firebase.database.snapshot.Node node2) {
        super(node2);
        this.value = string;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    protected int compareLeafValues(com.google.firebase.database.snapshot.LeafNode leafNode) {
        return compareLeafValues((StringNode)leafNode);
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    protected int compareLeafValues(com.google.firebase.database.snapshot.StringNode stringNode) {
        return this.value.compareTo(stringNode.value);
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public boolean equals(Object object) {
        boolean priority;
        int i;
        Object obj4;
        if (!object instanceof StringNode) {
            return 0;
        }
        if (this.value.equals(object.value) && this.priority.equals(object.priority)) {
            if (this.priority.equals(object.priority)) {
                i = 1;
            }
        }
        return i;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public String getHashRepresentation(com.google.firebase.database.snapshot.Node.HashVersion node$HashVersion) {
        int i = StringNode.1.$SwitchMap$com$google$firebase$database$snapshot$Node$HashVersion[hashVersion.ordinal()];
        String str = "string:";
        if (i != 1) {
            if (i != 2) {
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(getPriorityHash(hashVersion));
                stringBuilder.append(str);
                stringBuilder.append(Utilities.stringHashV2Representation(this.value));
                return stringBuilder.toString();
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Invalid hash version for string node: ");
            stringBuilder3.append(hashVersion);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder3.toString());
            throw illegalArgumentException;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(getPriorityHash(hashVersion));
        stringBuilder2.append(str);
        stringBuilder2.append(this.value);
        return stringBuilder2.toString();
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    protected com.google.firebase.database.snapshot.LeafNode.LeafType getLeafType() {
        return LeafNode.LeafType.String;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public Object getValue() {
        return this.value;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public int hashCode() {
        return i += i3;
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public com.google.firebase.database.snapshot.Node updatePriority(com.google.firebase.database.snapshot.Node node) {
        return updatePriority(node);
    }

    @Override // com.google.firebase.database.snapshot.LeafNode
    public com.google.firebase.database.snapshot.StringNode updatePriority(com.google.firebase.database.snapshot.Node node) {
        StringNode stringNode = new StringNode(this.value, node);
        return stringNode;
    }
}
