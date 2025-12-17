package com.google.firebase.firestore.remote;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.DocumentViewChange.Type;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.util.Assert;
import com.google.protobuf.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
final class TargetState {

    private boolean current = false;
    private final Map<DocumentKey, DocumentViewChange.Type> documentChanges;
    private boolean hasChanges = true;
    private int outstandingResponses = 0;
    private j resumeToken = 1;
    TargetState() {
        super();
        final int i = 0;
        HashMap hashMap = new HashMap();
        this.documentChanges = hashMap;
        int i2 = 1;
        j jVar = j.a;
    }

    void addDocumentChange(DocumentKey documentKey, DocumentViewChange.Type documentViewChange$Type2) {
        this.hasChanges = true;
        this.documentChanges.put(documentKey, type2);
    }

    void clearChanges() {
        this.hasChanges = false;
        this.documentChanges.clear();
    }

    boolean hasChanges() {
        return this.hasChanges;
    }

    boolean isCurrent() {
        return this.current;
    }

    boolean isPending() {
        int i;
        i = this.outstandingResponses != 0 ? 1 : 0;
        return i;
    }

    void markCurrent() {
        final int i = 1;
        this.hasChanges = i;
        this.current = i;
    }

    void recordPendingTargetRequest() {
        this.outstandingResponses = outstandingResponses++;
    }

    void recordTargetResponse() {
        this.outstandingResponses = outstandingResponses--;
    }

    void removeDocumentChange(DocumentKey documentKey) {
        this.hasChanges = true;
        this.documentChanges.remove(documentKey);
    }

    com.google.firebase.firestore.remote.TargetChange toTargetChange() {
        ImmutableSortedSet emptyKeySet3;
        ImmutableSortedSet emptyKeySet;
        ImmutableSortedSet emptyKeySet2;
        int i2;
        int i;
        ImmutableSortedSet set2;
        ImmutableSortedSet set3;
        ImmutableSortedSet set;
        Iterator iterator = this.documentChanges.entrySet().iterator();
        set2 = emptyKeySet3;
        set3 = emptyKeySet;
        set = emptyKeySet2;
        for (Map.Entry next2 : iterator) {
            emptyKeySet = next2.getKey();
            Object value = next2.getValue();
            emptyKeySet2 = TargetState.1.$SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type[(DocumentViewChange.Type)value.ordinal()];
            i2 = 1;
            set2 = emptyKeySet3;
            set3 = emptyKeySet3;
            set = emptyKeySet3;
        }
        super(this.resumeToken, this.current, set2, set3, set);
        return targetChange;
    }

    void updateResumeToken(j j) {
        boolean empty;
        if (!j.isEmpty()) {
            this.hasChanges = true;
            this.resumeToken = j;
        }
    }
}
