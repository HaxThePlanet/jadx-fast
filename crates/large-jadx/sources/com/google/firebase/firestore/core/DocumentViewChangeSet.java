package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public class DocumentViewChangeSet {

    private final TreeMap<DocumentKey, com.google.firebase.firestore.core.DocumentViewChange> changes;
    public DocumentViewChangeSet() {
        super();
        TreeMap treeMap = new TreeMap();
        this.changes = treeMap;
    }

    public void addChange(com.google.firebase.firestore.core.DocumentViewChange documentViewChange) {
        Object changes;
        com.google.firebase.firestore.core.DocumentViewChange.Type mETADATA;
        com.google.firebase.firestore.core.DocumentViewChange.Type rEMOVED;
        Object obj8;
        DocumentKey key = documentViewChange.getDocument().getKey();
        changes = this.changes.get(key);
        if ((DocumentViewChange)changes == null) {
            this.changes.put(key, documentViewChange);
        }
        final com.google.firebase.firestore.core.DocumentViewChange.Type type = (DocumentViewChange)changes.getType();
        final com.google.firebase.firestore.core.DocumentViewChange.Type type2 = documentViewChange.getType();
        final com.google.firebase.firestore.core.DocumentViewChange.Type aDDED = DocumentViewChange.Type.ADDED;
        if (type2 != aDDED && type == DocumentViewChange.Type.METADATA) {
            if (type == DocumentViewChange.Type.METADATA) {
                this.changes.put(key, documentViewChange);
            } else {
                if (type2 == DocumentViewChange.Type.METADATA && type != DocumentViewChange.Type.REMOVED) {
                    if (type != DocumentViewChange.Type.REMOVED) {
                        this.changes.put(key, DocumentViewChange.create(type, documentViewChange.getDocument()));
                    } else {
                        mETADATA = DocumentViewChange.Type.MODIFIED;
                        if (type2 == mETADATA && type == mETADATA) {
                            if (type == mETADATA) {
                                this.changes.put(key, DocumentViewChange.create(mETADATA, documentViewChange.getDocument()));
                            } else {
                                if (type2 == mETADATA && type == aDDED) {
                                    if (type == aDDED) {
                                        this.changes.put(key, DocumentViewChange.create(aDDED, documentViewChange.getDocument()));
                                    } else {
                                        rEMOVED = DocumentViewChange.Type.REMOVED;
                                        if (type2 == rEMOVED && type == aDDED) {
                                            if (type == aDDED) {
                                                this.changes.remove(key);
                                            } else {
                                                if (type2 == rEMOVED && type == mETADATA) {
                                                    if (type == mETADATA) {
                                                        this.changes.put(key, DocumentViewChange.create(rEMOVED, changes.getDocument()));
                                                    } else {
                                                        if (type2 != aDDED) {
                                                        } else {
                                                            if (type != rEMOVED) {
                                                            } else {
                                                                this.changes.put(key, DocumentViewChange.create(mETADATA, documentViewChange.getDocument()));
                                                            }
                                                        }
                                                    }
                                                } else {
                                                }
                                            }
                                        } else {
                                        }
                                    }
                                } else {
                                }
                            }
                        } else {
                        }
                    }
                } else {
                }
            }
        } else {
        }
        obj8 = new Object[2];
        throw Assert.fail("Unsupported combination of changes %s after %s", type2, type);
    }

    List<com.google.firebase.firestore.core.DocumentViewChange> getChanges() {
        ArrayList arrayList = new ArrayList(this.changes.values());
        return arrayList;
    }
}
