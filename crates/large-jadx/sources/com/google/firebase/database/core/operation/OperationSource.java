package com.google.firebase.database.core.operation;

import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.QueryParams;

/* loaded from: classes2.dex */
public class OperationSource {

    public static final com.google.firebase.database.core.operation.OperationSource SERVER;
    public static final com.google.firebase.database.core.operation.OperationSource USER;
    private final QueryParams queryParams;
    private final com.google.firebase.database.core.operation.OperationSource.Source source;
    private final boolean tagged;

    private static enum Source {

        User,
        Server;
    }
    static {
        final int i = 0;
        final int i2 = 0;
        OperationSource operationSource = new OperationSource(OperationSource.Source.User, i, i2);
        OperationSource.USER = operationSource;
        OperationSource operationSource2 = new OperationSource(OperationSource.Source.Server, i, i2);
        OperationSource.SERVER = operationSource2;
    }

    public OperationSource(com.google.firebase.database.core.operation.OperationSource.Source operationSource$Source, QueryParams queryParams2, boolean z3) {
        int obj1;
        super();
        this.source = source;
        this.queryParams = queryParams2;
        this.tagged = z3;
        if (z3) {
            if (isFromServer()) {
                obj1 = 1;
            } else {
                obj1 = 0;
            }
        } else {
        }
        Utilities.hardAssert(obj1);
    }

    public static com.google.firebase.database.core.operation.OperationSource forServerTaggedQuery(QueryParams queryParams) {
        OperationSource operationSource = new OperationSource(OperationSource.Source.Server, queryParams, 1);
        return operationSource;
    }

    public QueryParams getQueryParams() {
        return this.queryParams;
    }

    public boolean isFromServer() {
        int i;
        i = this.source == OperationSource.Source.Server ? 1 : 0;
        return i;
    }

    public boolean isFromUser() {
        int i;
        i = this.source == OperationSource.Source.User ? 1 : 0;
        return i;
    }

    public boolean isTagged() {
        return this.tagged;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OperationSource{source=");
        stringBuilder.append(this.source);
        stringBuilder.append(", queryParams=");
        stringBuilder.append(this.queryParams);
        stringBuilder.append(", tagged=");
        stringBuilder.append(this.tagged);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
