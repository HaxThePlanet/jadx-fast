package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.NodeSizeEstimator;
import com.google.firebase.database.core.utilities.Utilities;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/* loaded from: classes2.dex */
public class CompoundHash {

    private final List<String> hashes;
    private final List<Path> posts;

    static class CompoundHashBuilder {

        private final List<String> currentHashes;
        private Stack<com.google.firebase.database.snapshot.ChildKey> currentPath;
        private int currentPathDepth;
        private final List<Path> currentPaths;
        private int lastLeafDepth = -1;
        private boolean needsComma = true;
        private StringBuilder optHashValueBuilder = null;
        private final com.google.firebase.database.snapshot.CompoundHash.SplitStrategy splitStrategy;
        public CompoundHashBuilder(com.google.firebase.database.snapshot.CompoundHash.SplitStrategy compoundHash$SplitStrategy) {
            super();
            int i = 0;
            Stack stack = new Stack();
            this.currentPath = stack;
            int i2 = -1;
            int i3 = 1;
            ArrayList arrayList = new ArrayList();
            this.currentPaths = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.currentHashes = arrayList2;
            this.splitStrategy = splitStrategy;
        }

        static void access$000(com.google.firebase.database.snapshot.CompoundHash.CompoundHashBuilder compoundHash$CompoundHashBuilder) {
            compoundHashBuilder.finishHashing();
        }

        static List access$100(com.google.firebase.database.snapshot.CompoundHash.CompoundHashBuilder compoundHash$CompoundHashBuilder) {
            return compoundHashBuilder.currentPaths;
        }

        static List access$200(com.google.firebase.database.snapshot.CompoundHash.CompoundHashBuilder compoundHash$CompoundHashBuilder) {
            return compoundHashBuilder.currentHashes;
        }

        static void access$300(com.google.firebase.database.snapshot.CompoundHash.CompoundHashBuilder compoundHash$CompoundHashBuilder, com.google.firebase.database.snapshot.LeafNode leafNode2) {
            compoundHashBuilder.processLeaf(leafNode2);
        }

        static void access$400(com.google.firebase.database.snapshot.CompoundHash.CompoundHashBuilder compoundHash$CompoundHashBuilder, com.google.firebase.database.snapshot.ChildKey childKey2) {
            compoundHashBuilder.startChild(childKey2);
        }

        static void access$600(com.google.firebase.database.snapshot.CompoundHash.CompoundHashBuilder compoundHash$CompoundHashBuilder) {
            compoundHashBuilder.endChild();
        }

        private void appendKey(StringBuilder stringBuilder, com.google.firebase.database.snapshot.ChildKey childKey2) {
            stringBuilder.append(Utilities.stringHashV2Representation(childKey2.asString()));
        }

        private Path currentPath(int i) {
            int i2;
            Object obj;
            final com.google.firebase.database.snapshot.ChildKey[] arr = new ChildKey[i];
            i2 = 0;
            while (i2 < i) {
                arr[i2] = (ChildKey)this.currentPath.get(i2);
                i2++;
            }
            Path obj4 = new Path(arr);
            return obj4;
        }

        private void endChild() {
            boolean optHashValueBuilder;
            String str;
            final int i2 = 1;
            this.currentPathDepth = currentPathDepth -= i2;
            if (buildingRange()) {
                this.optHashValueBuilder.append(")");
            }
            this.needsComma = i2;
        }

        private void endRange() {
            int i;
            String optHashValueBuilder;
            String str;
            Utilities.hardAssert(buildingRange(), "Can't end range without starting a range!");
            i = 0;
            str = ")";
            while (i < this.currentPathDepth) {
                this.optHashValueBuilder.append(str);
                i++;
                str = ")";
            }
            this.optHashValueBuilder.append(str);
            this.currentHashes.add(Utilities.sha1HexDigest(this.optHashValueBuilder.toString()));
            this.currentPaths.add(currentPath(this.lastLeafDepth));
            this.optHashValueBuilder = 0;
        }

        private void ensureRange() {
            boolean buildingRange;
            boolean next;
            String optHashValueBuilder;
            String str;
            if (!buildingRange()) {
                StringBuilder stringBuilder = new StringBuilder();
                this.optHashValueBuilder = stringBuilder;
                stringBuilder.append("(");
                Iterator iterator = currentPath(this.currentPathDepth).iterator();
                for (ChildKey next2 : iterator) {
                    appendKey(this.optHashValueBuilder, next2);
                    this.optHashValueBuilder.append(":(");
                }
                this.needsComma = false;
            }
        }

        private void finishHashing() {
            int i;
            i = this.currentPathDepth == 0 ? 1 : 0;
            Utilities.hardAssert(i, "Can't finish hashing in the middle processing a child");
            if (buildingRange()) {
                endRange();
            }
            this.currentHashes.add("");
        }

        private void processLeaf(com.google.firebase.database.snapshot.LeafNode<?> leafNode) {
            ensureRange();
            this.lastLeafDepth = this.currentPathDepth;
            this.optHashValueBuilder.append(leafNode.getHashRepresentation(Node.HashVersion.V2));
            this.needsComma = true;
            if (this.splitStrategy.shouldSplit(this)) {
                endRange();
            }
        }

        private void startChild(com.google.firebase.database.snapshot.ChildKey childKey) {
            boolean optHashValueBuilder;
            Stack currentPath;
            String str;
            int currentPathDepth;
            ensureRange();
            if (this.needsComma) {
                this.optHashValueBuilder.append(",");
            }
            appendKey(this.optHashValueBuilder, childKey);
            this.optHashValueBuilder.append(":(");
            if (this.currentPathDepth == this.currentPath.size()) {
                this.currentPath.add(childKey);
            } else {
                this.currentPath.set(this.currentPathDepth, childKey);
            }
            this.currentPathDepth = obj3++;
            this.needsComma = false;
        }

        public boolean buildingRange() {
            int i;
            i = this.optHashValueBuilder != null ? 1 : 0;
            return i;
        }

        public int currentHashLength() {
            return this.optHashValueBuilder.length();
        }

        public Path currentPath() {
            return currentPath(this.currentPathDepth);
        }
    }

    public interface SplitStrategy {
        public abstract boolean shouldSplit(com.google.firebase.database.snapshot.CompoundHash.CompoundHashBuilder compoundHash$CompoundHashBuilder);
    }

    private static class SimpleSizeSplitStrategy implements com.google.firebase.database.snapshot.CompoundHash.SplitStrategy {

        private final long splitThreshold;
        public SimpleSizeSplitStrategy(com.google.firebase.database.snapshot.Node node) {
            super();
            this.splitThreshold = Math.max(512, obj3);
        }

        @Override // com.google.firebase.database.snapshot.CompoundHash$SplitStrategy
        public boolean shouldSplit(com.google.firebase.database.snapshot.CompoundHash.CompoundHashBuilder compoundHash$CompoundHashBuilder) {
            boolean priorityKey;
            boolean obj5;
            if (Long.compare(l, splitThreshold) > 0) {
                if (!compoundHashBuilder.currentPath().isEmpty()) {
                    obj5 = !compoundHashBuilder.currentPath().getBack().equals(ChildKey.getPriorityKey()) ? 1 : 0;
                } else {
                }
            } else {
            }
            return obj5;
        }
    }
    private CompoundHash(List<Path> list, List<String> list2) {
        super();
        if (list.size() != size2--) {
        } else {
            this.posts = list;
            this.hashes = list2;
        }
        IllegalArgumentException obj3 = new IllegalArgumentException("Number of posts need to be n-1 for n hashes in CompoundHash");
        throw obj3;
    }

    static void access$500(com.google.firebase.database.snapshot.Node node, com.google.firebase.database.snapshot.CompoundHash.CompoundHashBuilder compoundHash$CompoundHashBuilder2) {
        CompoundHash.processNode(node, compoundHashBuilder2);
    }

    public static com.google.firebase.database.snapshot.CompoundHash fromNode(com.google.firebase.database.snapshot.Node node) {
        CompoundHash.SimpleSizeSplitStrategy simpleSizeSplitStrategy = new CompoundHash.SimpleSizeSplitStrategy(node);
        return CompoundHash.fromNode(node, simpleSizeSplitStrategy);
    }

    public static com.google.firebase.database.snapshot.CompoundHash fromNode(com.google.firebase.database.snapshot.Node node, com.google.firebase.database.snapshot.CompoundHash.SplitStrategy compoundHash$SplitStrategy2) {
        if (node.isEmpty()) {
            CompoundHash obj1 = new CompoundHash(Collections.emptyList(), Collections.singletonList(""));
            return obj1;
        }
        CompoundHash.CompoundHashBuilder compoundHashBuilder = new CompoundHash.CompoundHashBuilder(splitStrategy2);
        CompoundHash.processNode(node, compoundHashBuilder);
        CompoundHash.CompoundHashBuilder.access$000(compoundHashBuilder);
        obj1 = new CompoundHash(CompoundHash.CompoundHashBuilder.access$100(compoundHashBuilder), CompoundHash.CompoundHashBuilder.access$200(compoundHashBuilder));
        return obj1;
    }

    private static void processNode(com.google.firebase.database.snapshot.Node node, com.google.firebase.database.snapshot.CompoundHash.CompoundHashBuilder compoundHash$CompoundHashBuilder2) {
        com.google.firebase.database.snapshot.CompoundHash.1 leafNode;
        int obj3;
        if (node.isLeafNode()) {
            CompoundHash.CompoundHashBuilder.access$300(compoundHashBuilder2, (LeafNode)node);
        } else {
            if (node.isEmpty()) {
            } else {
                if (!node instanceof ChildrenNode) {
                } else {
                    leafNode = new CompoundHash.1(compoundHashBuilder2);
                    (ChildrenNode)node.forEachChild(leafNode, true);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Expected children node, but got: ");
                stringBuilder.append(node);
                obj3 = new IllegalStateException(stringBuilder.toString());
                throw obj3;
            }
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("Can't calculate hash on empty node!");
        throw obj2;
    }

    public List<String> getHashes() {
        return Collections.unmodifiableList(this.hashes);
    }

    public List<Path> getPosts() {
        return Collections.unmodifiableList(this.posts);
    }
}
