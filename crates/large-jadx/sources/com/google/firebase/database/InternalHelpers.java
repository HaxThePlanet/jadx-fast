package com.google.firebase.database;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.core.DatabaseConfig;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.Repo;
import com.google.firebase.database.core.RepoInfo;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.Node;

/* loaded from: classes2.dex */
public class InternalHelpers {
    public static com.google.firebase.database.DataSnapshot createDataSnapshot(com.google.firebase.database.DatabaseReference databaseReference, IndexedNode indexedNode2) {
        DataSnapshot dataSnapshot = new DataSnapshot(databaseReference, indexedNode2);
        return dataSnapshot;
    }

    public static com.google.firebase.database.FirebaseDatabase createDatabaseForTests(FirebaseApp firebaseApp, RepoInfo repoInfo2, DatabaseConfig databaseConfig3) {
        return FirebaseDatabase.createForTests(firebaseApp, repoInfo2, databaseConfig3);
    }

    public static com.google.firebase.database.MutableData createMutableData(Node node) {
        MutableData mutableData = new MutableData(node);
        return mutableData;
    }

    public static com.google.firebase.database.DatabaseReference createReference(Repo repo, Path path2) {
        DatabaseReference databaseReference = new DatabaseReference(repo, path2);
        return databaseReference;
    }
}
