package com.google.firebase.database.core.persistence;

import com.google.firebase.database.core.view.QuerySpec;

/* loaded from: classes2.dex */
public final class TrackedQuery {

    public final boolean active;
    public final boolean complete;
    public final long id;
    public final long lastUse;
    public final QuerySpec querySpec;
    public TrackedQuery(long l, QuerySpec querySpec2, long l3, boolean z4, boolean z5) {
        boolean obj1;
        super();
        this.id = l;
        if (l3.loadsAllData()) {
            if (!l3.isDefault()) {
            } else {
            }
            obj1 = new IllegalArgumentException("Can't create TrackedQuery for a non-default query that loads all data");
            throw obj1;
        }
        this.querySpec = l3;
        this.lastUse = z4;
        this.complete = obj6;
        this.active = obj7;
    }

    public boolean equals(Object object) {
        int i;
        int complete;
        Class class;
        Class<com.google.firebase.database.core.persistence.TrackedQuery> querySpec;
        long lastUse;
        Object obj7;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (object.getClass() != TrackedQuery.class) {
            } else {
                if (Long.compare(l, lastUse) == 0 && this.querySpec.equals(object.querySpec) && Long.compare(lastUse2, lastUse) == 0 && this.complete == object.complete && this.active == object.active) {
                    if (this.querySpec.equals(object.querySpec)) {
                        if (Long.compare(lastUse2, lastUse) == 0) {
                            if (this.complete == object.complete) {
                                if (this.active == object.active) {
                                } else {
                                    i = i2;
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            }
            return i;
        }
        return i2;
    }

    public int hashCode() {
        return i8 += i13;
    }

    public com.google.firebase.database.core.persistence.TrackedQuery setActiveState(boolean z) {
        super(this.id, obj2, this.querySpec, this.lastUse, obj5, this.complete, z);
        return trackedQuery2;
    }

    public com.google.firebase.database.core.persistence.TrackedQuery setComplete() {
        super(this.id, obj2, this.querySpec, this.lastUse, obj5, 1, this.active);
        return trackedQuery2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrackedQuery{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", querySpec=");
        stringBuilder.append(this.querySpec);
        stringBuilder.append(", lastUse=");
        stringBuilder.append(this.lastUse);
        stringBuilder.append(", complete=");
        stringBuilder.append(this.complete);
        stringBuilder.append(", active=");
        stringBuilder.append(this.active);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public com.google.firebase.database.core.persistence.TrackedQuery updateLastUse(long l) {
        super(this.id, obj2, this.querySpec, l, obj5, this.complete, this.active);
        return trackedQuery2;
    }
}
