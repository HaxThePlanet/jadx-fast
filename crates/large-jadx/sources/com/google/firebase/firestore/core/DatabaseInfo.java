package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.DatabaseId;

/* loaded from: classes2.dex */
public final class DatabaseInfo {

    private final DatabaseId databaseId;
    private final String host;
    private final String persistenceKey;
    private final boolean sslEnabled;
    public DatabaseInfo(DatabaseId databaseId, String string2, String string3, boolean z4) {
        super();
        this.databaseId = databaseId;
        this.persistenceKey = string2;
        this.host = string3;
        this.sslEnabled = z4;
    }

    public DatabaseId getDatabaseId() {
        return this.databaseId;
    }

    public String getHost() {
        return this.host;
    }

    public String getPersistenceKey() {
        return this.persistenceKey;
    }

    public boolean isSslEnabled() {
        return this.sslEnabled;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DatabaseInfo(databaseId:");
        stringBuilder.append(this.databaseId);
        stringBuilder.append(" host:");
        stringBuilder.append(this.host);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
