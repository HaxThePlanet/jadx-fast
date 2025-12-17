package com.google.firebase.firestore.local;

import com.google.firebase.firestore.bundle.BundleMetadata;
import com.google.firebase.firestore.bundle.NamedQuery;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
class MemoryBundleCache implements com.google.firebase.firestore.local.BundleCache {

    private final Map<String, BundleMetadata> bundles;
    private final Map<String, NamedQuery> namedQueries;
    MemoryBundleCache() {
        super();
        HashMap hashMap = new HashMap();
        this.bundles = hashMap;
        HashMap hashMap2 = new HashMap();
        this.namedQueries = hashMap2;
    }

    @Override // com.google.firebase.firestore.local.BundleCache
    public BundleMetadata getBundleMetadata(String string) {
        return (BundleMetadata)this.bundles.get(string);
    }

    @Override // com.google.firebase.firestore.local.BundleCache
    public NamedQuery getNamedQuery(String string) {
        return (NamedQuery)this.namedQueries.get(string);
    }

    @Override // com.google.firebase.firestore.local.BundleCache
    public void saveBundleMetadata(BundleMetadata bundleMetadata) {
        this.bundles.put(bundleMetadata.getBundleId(), bundleMetadata);
    }

    @Override // com.google.firebase.firestore.local.BundleCache
    public void saveNamedQuery(NamedQuery namedQuery) {
        this.namedQueries.put(namedQuery.getName(), namedQuery);
    }
}
