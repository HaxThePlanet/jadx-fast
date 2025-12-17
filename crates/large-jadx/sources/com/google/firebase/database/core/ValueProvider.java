package com.google.firebase.database.core;

import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Node;
import java.util.ArrayList;

/* loaded from: classes2.dex */
abstract class ValueProvider {

    public static class DeferredValueProvider extends com.google.firebase.database.core.ValueProvider {

        private final com.google.firebase.database.core.Path path;
        private final com.google.firebase.database.core.SyncTree syncTree;
        DeferredValueProvider(com.google.firebase.database.core.SyncTree syncTree, com.google.firebase.database.core.Path path2) {
            super();
            this.syncTree = syncTree;
            this.path = path2;
        }

        @Override // com.google.firebase.database.core.ValueProvider
        public com.google.firebase.database.core.ValueProvider getImmediateChild(ChildKey childKey) {
            ValueProvider.DeferredValueProvider deferredValueProvider = new ValueProvider.DeferredValueProvider(this.syncTree, this.path.child(childKey));
            return deferredValueProvider;
        }

        @Override // com.google.firebase.database.core.ValueProvider
        public Node node() {
            ArrayList arrayList = new ArrayList();
            return this.syncTree.calcCompleteEventCache(this.path, arrayList);
        }
    }

    public static class ExistingValueProvider extends com.google.firebase.database.core.ValueProvider {

        private final Node node;
        ExistingValueProvider(Node node) {
            super();
            this.node = node;
        }

        @Override // com.google.firebase.database.core.ValueProvider
        public com.google.firebase.database.core.ValueProvider getImmediateChild(ChildKey childKey) {
            ValueProvider.ExistingValueProvider existingValueProvider = new ValueProvider.ExistingValueProvider(this.node.getImmediateChild(childKey));
            return existingValueProvider;
        }

        @Override // com.google.firebase.database.core.ValueProvider
        public Node node() {
            return this.node;
        }
    }
    public abstract com.google.firebase.database.core.ValueProvider getImmediateChild(ChildKey childKey);

    public abstract Node node();
}
