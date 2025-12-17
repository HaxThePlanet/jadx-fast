package com.google.firebase.firestore.local;

import com.google.firebase.firestore.bundle.BundleMetadata;
import com.google.firebase.firestore.bundle.NamedQuery;

/* loaded from: classes2.dex */
public interface BundleCache {
    public abstract BundleMetadata getBundleMetadata(String string);

    public abstract NamedQuery getNamedQuery(String string);

    public abstract void saveBundleMetadata(BundleMetadata bundleMetadata);

    public abstract void saveNamedQuery(NamedQuery namedQuery);
}
