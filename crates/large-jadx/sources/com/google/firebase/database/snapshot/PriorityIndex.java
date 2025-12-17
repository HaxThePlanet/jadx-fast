package com.google.firebase.database.snapshot;

/* loaded from: classes2.dex */
public class PriorityIndex extends com.google.firebase.database.snapshot.Index {

    private static final com.google.firebase.database.snapshot.PriorityIndex INSTANCE;
    static {
        PriorityIndex priorityIndex = new PriorityIndex();
        PriorityIndex.INSTANCE = priorityIndex;
    }

    public static com.google.firebase.database.snapshot.PriorityIndex getInstance() {
        return PriorityIndex.INSTANCE;
    }

    @Override // com.google.firebase.database.snapshot.Index
    public int compare(com.google.firebase.database.snapshot.NamedNode namedNode, com.google.firebase.database.snapshot.NamedNode namedNode2) {
        return NodeUtilities.nameAndPriorityCompare(namedNode.getName(), namedNode.getNode().getPriority(), namedNode2.getName(), namedNode2.getNode().getPriority());
    }

    @Override // com.google.firebase.database.snapshot.Index
    public int compare(Object object, Object object2) {
        return compare((NamedNode)object, (NamedNode)object2);
    }

    @Override // com.google.firebase.database.snapshot.Index
    public boolean equals(Object object) {
        return object instanceof PriorityIndex;
    }

    @Override // com.google.firebase.database.snapshot.Index
    public String getQueryDefinition() {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can't get query definition on priority index!");
        throw illegalArgumentException;
    }

    @Override // com.google.firebase.database.snapshot.Index
    public int hashCode() {
        return 3155577;
    }

    @Override // com.google.firebase.database.snapshot.Index
    public boolean isDefinedOn(com.google.firebase.database.snapshot.Node node) {
        return obj1 ^= 1;
    }

    @Override // com.google.firebase.database.snapshot.Index
    public com.google.firebase.database.snapshot.NamedNode makePost(com.google.firebase.database.snapshot.ChildKey childKey, com.google.firebase.database.snapshot.Node node2) {
        StringNode stringNode = new StringNode("[PRIORITY-POST]", node2);
        NamedNode namedNode = new NamedNode(childKey, stringNode);
        return namedNode;
    }

    @Override // com.google.firebase.database.snapshot.Index
    public com.google.firebase.database.snapshot.NamedNode maxPost() {
        return makePost(ChildKey.getMaxName(), Node.MAX_NODE);
    }

    @Override // com.google.firebase.database.snapshot.Index
    public String toString() {
        return "PriorityIndex";
    }
}
