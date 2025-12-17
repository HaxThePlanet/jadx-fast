package com.google.firebase.firestore.core;

import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.local.IndexBackfiller;
import com.google.firebase.firestore.local.LocalSerializer;
import com.google.firebase.firestore.local.LruDelegate;
import com.google.firebase.firestore.local.LruGarbageCollector;
import com.google.firebase.firestore.local.LruGarbageCollector.Params;
import com.google.firebase.firestore.local.Persistence;
import com.google.firebase.firestore.local.SQLitePersistence;
import com.google.firebase.firestore.local.Scheduler;
import com.google.firebase.firestore.remote.RemoteSerializer;

/* loaded from: classes2.dex */
public class SQLiteComponentProvider extends com.google.firebase.firestore.core.MemoryComponentProvider {
    @Override // com.google.firebase.firestore.core.MemoryComponentProvider
    protected Scheduler createGarbageCollectionScheduler(com.google.firebase.firestore.core.ComponentProvider.Configuration componentProvider$Configuration) {
        return (SQLitePersistence)getPersistence().getReferenceDelegate().getGarbageCollector().newScheduler(configuration.getAsyncQueue(), getLocalStore());
    }

    @Override // com.google.firebase.firestore.core.MemoryComponentProvider
    protected Scheduler createIndexBackfillScheduler(com.google.firebase.firestore.core.ComponentProvider.Configuration componentProvider$Configuration) {
        return (SQLitePersistence)getPersistence().getIndexBackfiller().newScheduler(configuration.getAsyncQueue(), getLocalStore());
    }

    @Override // com.google.firebase.firestore.core.MemoryComponentProvider
    protected Persistence createPersistence(com.google.firebase.firestore.core.ComponentProvider.Configuration componentProvider$Configuration) {
        com.google.firebase.firestore.model.DatabaseId databaseId = configuration.getDatabaseInfo().getDatabaseId();
        RemoteSerializer remoteSerializer = new RemoteSerializer(databaseId);
        LocalSerializer localSerializer = new LocalSerializer(remoteSerializer);
        super(configuration.getContext(), configuration.getDatabaseInfo().getPersistenceKey(), configuration.getDatabaseInfo().getDatabaseId(), localSerializer, LruGarbageCollector.Params.WithCacheSizeBytes(configuration.getSettings().getCacheSizeBytes()));
        return sQLitePersistence2;
    }
}
