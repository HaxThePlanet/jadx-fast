package com.google.firebase.firestore;

import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.util.Preconditions;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class FieldPath {

    private static final com.google.firebase.firestore.FieldPath DOCUMENT_ID_INSTANCE;
    private static final Pattern RESERVED;
    private final FieldPath internalPath;
    static {
        FieldPath.RESERVED = Pattern.compile("[~*/\\[\\]]");
        FieldPath fieldPath = new FieldPath(FieldPath.KEY_PATH);
        FieldPath.DOCUMENT_ID_INSTANCE = fieldPath;
    }

    private FieldPath(FieldPath fieldPath) {
        super();
        this.internalPath = fieldPath;
    }

    private FieldPath(List<String> list) {
        super();
        this.internalPath = FieldPath.fromSegments(list);
    }

    public static com.google.firebase.firestore.FieldPath documentId() {
        return FieldPath.DOCUMENT_ID_INSTANCE;
    }

    static com.google.firebase.firestore.FieldPath fromDotSeparatedPath(String string) {
        Preconditions.checkNotNull(string, "Provided field path must not be null.");
        Preconditions.checkArgument(find ^= 1, "Use FieldPath.of() for field names containing '~*/[]'.", new Object[0]);
        return FieldPath.of(string.split("\\.", -1));
    }

    public static com.google.firebase.firestore.FieldPath of(String... stringArr) {
        int i2;
        int i;
        Object[] arr2;
        Object empty;
        String string;
        Object[] arr;
        final int i3 = 1;
        final int i4 = 0;
        i2 = stringArr.length > 0 ? i3 : i4;
        Preconditions.checkArgument(i2, "Invalid field path. Provided path must not be empty.", new Object[i4]);
        i = i4;
        while (i < stringArr.length) {
            if (stringArr[i] != null && !stringArr[i].isEmpty()) {
            } else {
            }
            arr2 = i4;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid field name at argument ");
            stringBuilder.append(i++);
            stringBuilder.append(". Field names must not be null or empty.");
            Preconditions.checkArgument(arr2, stringBuilder.toString(), new Object[i4]);
            if (!stringArr[i].isEmpty()) {
            } else {
            }
            arr2 = i3;
        }
        FieldPath fieldPath = new FieldPath(Arrays.asList(stringArr));
        return fieldPath;
    }

    public boolean equals(Object object) {
        Class<com.google.firebase.firestore.FieldPath> obj;
        Class class;
        if (this == object) {
            return 1;
        }
        if (object != null && FieldPath.class != object.getClass()) {
            if (FieldPath.class != object.getClass()) {
            }
            return this.internalPath.equals(object.internalPath);
        }
        return 0;
    }

    FieldPath getInternalPath() {
        return this.internalPath;
    }

    public int hashCode() {
        return this.internalPath.hashCode();
    }

    public String toString() {
        return this.internalPath.toString();
    }
}
