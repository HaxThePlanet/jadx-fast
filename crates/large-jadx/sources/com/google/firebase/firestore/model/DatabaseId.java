package com.google.firebase.firestore.model;

import com.google.firebase.firestore.util.Assert;

/* loaded from: classes2.dex */
public final class DatabaseId implements Comparable<com.google.firebase.firestore.model.DatabaseId> {

    public static final String DEFAULT_DATABASE_ID = "(default)";
    public static final com.google.firebase.firestore.model.DatabaseId EMPTY;
    private final String databaseId;
    private final String projectId;
    static {
        String str = "";
        DatabaseId.EMPTY = DatabaseId.forDatabase(str, str);
    }

    private DatabaseId(String string, String string2) {
        super();
        this.projectId = string;
        this.databaseId = string2;
    }

    public static com.google.firebase.firestore.model.DatabaseId forDatabase(String string, String string2) {
        DatabaseId databaseId = new DatabaseId(string, string2);
        return databaseId;
    }

    public static com.google.firebase.firestore.model.DatabaseId forProject(String string) {
        return DatabaseId.forDatabase(string, "(default)");
    }

    public static com.google.firebase.firestore.model.DatabaseId fromName(String string) {
        int i;
        int length;
        String str;
        com.google.firebase.firestore.model.ResourcePath obj5 = ResourcePath.fromString(string);
        final int i3 = 3;
        int i4 = 1;
        int i5 = 0;
        if (obj5.length() > i3 && obj5.getSegment(i5).equals("projects") && obj5.getSegment(2).equals("databases")) {
            if (obj5.getSegment(i5).equals("projects")) {
                i = obj5.getSegment(2).equals("databases") ? i4 : i5;
            } else {
            }
        } else {
        }
        Object[] arr = new Object[i4];
        arr[i5] = obj5;
        Assert.hardAssert(i, "Tried to parse an invalid resource name: %s", arr);
        DatabaseId databaseId = new DatabaseId(obj5.getSegment(i4), obj5.getSegment(i3));
        return databaseId;
    }

    @Override // java.lang.Comparable
    public int compareTo(com.google.firebase.firestore.model.DatabaseId databaseId) {
        int compareTo;
        Object obj3;
        if (this.projectId.compareTo(databaseId.projectId) != 0) {
        } else {
            compareTo = this.databaseId.compareTo(databaseId.databaseId);
        }
        return compareTo;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object object) {
        return compareTo((DatabaseId)object);
    }

    @Override // java.lang.Comparable
    public boolean equals(Object object) {
        int i;
        String databaseId;
        Class<com.google.firebase.firestore.model.DatabaseId> obj;
        Class class;
        boolean obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (DatabaseId.class != object.getClass()) {
            } else {
                if (this.projectId.equals(object.projectId) && this.databaseId.equals(object.databaseId)) {
                    if (this.databaseId.equals(object.databaseId)) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            }
            return i;
        }
        return i2;
    }

    @Override // java.lang.Comparable
    public String getDatabaseId() {
        return this.databaseId;
    }

    @Override // java.lang.Comparable
    public String getProjectId() {
        return this.projectId;
    }

    @Override // java.lang.Comparable
    public int hashCode() {
        return i2 += i4;
    }

    @Override // java.lang.Comparable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DatabaseId(");
        stringBuilder.append(this.projectId);
        stringBuilder.append(", ");
        stringBuilder.append(this.databaseId);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
