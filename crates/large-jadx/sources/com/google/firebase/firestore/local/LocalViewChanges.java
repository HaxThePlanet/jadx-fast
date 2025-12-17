package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.DocumentViewChange;
import com.google.firebase.firestore.core.DocumentViewChange.Type;
import com.google.firebase.firestore.core.ViewSnapshot;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class LocalViewChanges {

    private final ImmutableSortedSet<DocumentKey> added;
    private final boolean fromCache;
    private final ImmutableSortedSet<DocumentKey> removed;
    private final int targetId;
    public LocalViewChanges(int i, boolean z2, ImmutableSortedSet<DocumentKey> immutableSortedSet3, ImmutableSortedSet<DocumentKey> immutableSortedSet4) {
        super();
        this.targetId = i;
        this.fromCache = z2;
        this.added = immutableSortedSet3;
        this.removed = immutableSortedSet4;
    }

    public static com.google.firebase.firestore.local.LocalViewChanges fromViewSnapshot(int i, ViewSnapshot viewSnapshot2) {
        ImmutableSortedSet immutableSortedSet;
        ImmutableSortedSet immutableSortedSet2;
        java.util.Comparator comparator;
        int i3;
        int i2;
        ArrayList arrayList = new ArrayList();
        immutableSortedSet = new ImmutableSortedSet(arrayList, DocumentKey.comparator());
        ArrayList arrayList2 = new ArrayList();
        immutableSortedSet2 = new ImmutableSortedSet(arrayList2, DocumentKey.comparator());
        Iterator iterator = viewSnapshot2.getChanges().iterator();
        while (iterator.hasNext()) {
            comparator = iterator.next();
            i3 = LocalViewChanges.1.$SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type[(DocumentViewChange)comparator.getType().ordinal()];
            if (i3 != 1) {
            } else {
            }
            immutableSortedSet = immutableSortedSet.insert(comparator.getDocument().getKey());
            if (i3 != 2) {
            } else {
            }
            immutableSortedSet2 = immutableSortedSet2.insert(comparator.getDocument().getKey());
        }
        LocalViewChanges localViewChanges = new LocalViewChanges(i, viewSnapshot2.isFromCache(), immutableSortedSet, immutableSortedSet2);
        return localViewChanges;
    }

    public ImmutableSortedSet<DocumentKey> getAdded() {
        return this.added;
    }

    public ImmutableSortedSet<DocumentKey> getRemoved() {
        return this.removed;
    }

    public int getTargetId() {
        return this.targetId;
    }

    public boolean isFromCache() {
        return this.fromCache;
    }
}
