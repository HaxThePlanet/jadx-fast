package com.google.firebase.firestore.model;

import f.c.e.c.x;
import java.util.Comparator;

/* loaded from: classes2.dex */
public interface Document {

    public static final Comparator<com.google.firebase.firestore.model.Document> KEY_COMPARATOR;
    static {
        Document.KEY_COMPARATOR = a.a;
    }

    public static int a(com.google.firebase.firestore.model.Document document, com.google.firebase.firestore.model.Document document2) {
        return document.getKey().compareTo(document2.getKey());
    }

    public abstract com.google.firebase.firestore.model.ObjectValue getData();

    public abstract x getField(com.google.firebase.firestore.model.FieldPath fieldPath);

    public abstract com.google.firebase.firestore.model.DocumentKey getKey();

    public abstract com.google.firebase.firestore.model.SnapshotVersion getVersion();

    public abstract boolean hasCommittedMutations();

    public abstract boolean hasLocalMutations();

    public abstract boolean hasPendingWrites();

    public abstract boolean isFoundDocument();

    public abstract boolean isNoDocument();

    public abstract boolean isUnknownDocument();

    public abstract boolean isValidDocument();
}
