package com.google.firebase.firestore.local;

import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldIndex;
import com.google.firebase.firestore.model.ResourcePath;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public interface IndexManager {
    public abstract void addFieldIndex(FieldIndex fieldIndex);

    public abstract void addIndexEntries(Document document);

    public abstract void addToCollectionParentIndex(ResourcePath resourcePath);

    public abstract List<ResourcePath> getCollectionParents(String string);

    public abstract Set<DocumentKey> getDocumentsMatchingTarget(Target target);
}
