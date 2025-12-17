package com.google.firebase.database.core.view;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.Index;
import java.util.Map;

/* loaded from: classes2.dex */
public final class QuerySpec {

    private final com.google.firebase.database.core.view.QueryParams params;
    private final Path path;
    public QuerySpec(Path path, com.google.firebase.database.core.view.QueryParams queryParams2) {
        super();
        this.path = path;
        this.params = queryParams2;
    }

    public static com.google.firebase.database.core.view.QuerySpec defaultQueryAtPath(Path path) {
        QuerySpec querySpec = new QuerySpec(path, QueryParams.DEFAULT_PARAMS);
        return querySpec;
    }

    public static com.google.firebase.database.core.view.QuerySpec fromPathAndQueryObject(Path path, Map<String, Object> map2) {
        QuerySpec querySpec = new QuerySpec(path, QueryParams.fromQueryObject(map2));
        return querySpec;
    }

    public boolean equals(Object object) {
        Class<com.google.firebase.database.core.view.QuerySpec> obj;
        Class class;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object != null) {
            if (QuerySpec.class != object.getClass()) {
            } else {
                if (!this.path.equals(object.path)) {
                    return i2;
                }
                if (!this.params.equals(object.params)) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    public Index getIndex() {
        return this.params.getIndex();
    }

    public com.google.firebase.database.core.view.QueryParams getParams() {
        return this.params;
    }

    public Path getPath() {
        return this.path;
    }

    public int hashCode() {
        return i2 += i4;
    }

    public boolean isDefault() {
        return this.params.isDefault();
    }

    public boolean loadsAllData() {
        return this.params.loadsAllData();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.path);
        stringBuilder.append(":");
        stringBuilder.append(this.params);
        return stringBuilder.toString();
    }
}
