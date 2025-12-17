package com.google.firebase.firestore.local;

import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldIndex;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
class MemoryIndexManager implements com.google.firebase.firestore.local.IndexManager {

    private final com.google.firebase.firestore.local.MemoryIndexManager.MemoryCollectionParentIndex collectionParentsIndex;

    static class MemoryCollectionParentIndex {

        private final HashMap<String, HashSet<ResourcePath>> index;
        MemoryCollectionParentIndex() {
            super();
            HashMap hashMap = new HashMap();
            this.index = hashMap;
        }

        boolean add(ResourcePath resourcePath) {
            Object hashSet;
            int index;
            int i2 = 0;
            if (length %= 2 == 1) {
            } else {
                index = i2;
            }
            Assert.hardAssert(index, "Expected a collection path.", new Object[i2]);
            String lastSegment = resourcePath.getLastSegment();
            if ((HashSet)this.index.get(lastSegment) == null) {
                hashSet = new HashSet();
                this.index.put(lastSegment, hashSet);
            }
            return hashSet.add((ResourcePath)resourcePath.popLast());
        }

        List<ResourcePath> getEntries(String string) {
            Object arrayList;
            final Object obj2 = this.index.get(string);
            if ((HashSet)obj2 != null) {
                arrayList = new ArrayList((HashSet)obj2);
            } else {
                arrayList = Collections.emptyList();
            }
            return arrayList;
        }
    }
    MemoryIndexManager() {
        super();
        MemoryIndexManager.MemoryCollectionParentIndex memoryCollectionParentIndex = new MemoryIndexManager.MemoryCollectionParentIndex();
        this.collectionParentsIndex = memoryCollectionParentIndex;
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void addFieldIndex(FieldIndex fieldIndex) {
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void addIndexEntries(Document document) {
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void addToCollectionParentIndex(ResourcePath resourcePath) {
        this.collectionParentsIndex.add(resourcePath);
    }

    public List<ResourcePath> getCollectionParents(String string) {
        return this.collectionParentsIndex.getEntries(string);
    }

    public Set<DocumentKey> getDocumentsMatchingTarget(Target target) {
        return 0;
    }
}
