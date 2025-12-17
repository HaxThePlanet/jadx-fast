package com.google.firebase.firestore.local;

import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.mutation.Mutation;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class MemoryDocumentOverlay implements com.google.firebase.firestore.local.DocumentOverlay {

    private Map<DocumentKey, Mutation> overlays;
    public MemoryDocumentOverlay() {
        super();
        HashMap hashMap = new HashMap();
        this.overlays = hashMap;
    }

    @Override // com.google.firebase.firestore.local.DocumentOverlay
    public Mutation getOverlay(DocumentKey documentKey) {
        return (Mutation)this.overlays.get(documentKey);
    }

    @Override // com.google.firebase.firestore.local.DocumentOverlay
    public void removeOverlay(DocumentKey documentKey) {
        this.overlays.remove(documentKey);
    }

    @Override // com.google.firebase.firestore.local.DocumentOverlay
    public void saveOverlay(DocumentKey documentKey, Mutation mutation2) {
        this.overlays.put(documentKey, mutation2);
    }
}
