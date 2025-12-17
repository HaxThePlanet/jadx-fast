package com.google.firebase.firestore;

import com.google.firebase.firestore.model.mutation.FieldMask;
import com.google.firebase.firestore.util.Preconditions;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public final class SetOptions {

    private static final com.google.firebase.firestore.SetOptions MERGE_ALL_FIELDS;
    static final com.google.firebase.firestore.SetOptions OVERWRITE;
    private final FieldMask fieldMask;
    private final boolean merge;
    static {
        final int i3 = 0;
        SetOptions setOptions = new SetOptions(0, i3);
        SetOptions.OVERWRITE = setOptions;
        SetOptions setOptions2 = new SetOptions(1, i3);
        SetOptions.MERGE_ALL_FIELDS = setOptions2;
    }

    private SetOptions(boolean z, FieldMask fieldMask2) {
        int i;
        super();
        int i2 = 0;
        if (fieldMask2 != null) {
            if (z) {
                i = 1;
            } else {
                i = i2;
            }
        } else {
        }
        Preconditions.checkArgument(i, "Cannot specify a fieldMask for non-merge sets()", new Object[i2]);
        this.merge = z;
        this.fieldMask = fieldMask2;
    }

    public static com.google.firebase.firestore.SetOptions merge() {
        return SetOptions.MERGE_ALL_FIELDS;
    }

    public static com.google.firebase.firestore.SetOptions mergeFieldPaths(List<com.google.firebase.firestore.FieldPath> list) {
        com.google.firebase.firestore.model.FieldPath internalPath;
        HashSet hashSet = new HashSet();
        Iterator obj2 = list.iterator();
        for (FieldPath next2 : obj2) {
            hashSet.add(next2.getInternalPath());
        }
        obj2 = new SetOptions(1, FieldMask.fromSet(hashSet));
        return obj2;
    }

    public static com.google.firebase.firestore.SetOptions mergeFields(List<String> list) {
        com.google.firebase.firestore.model.FieldPath internalPath;
        HashSet hashSet = new HashSet();
        Iterator obj2 = list.iterator();
        for (String next2 : obj2) {
            hashSet.add(FieldPath.fromDotSeparatedPath(next2).getInternalPath());
        }
        obj2 = new SetOptions(1, FieldMask.fromSet(hashSet));
        return obj2;
    }

    public static com.google.firebase.firestore.SetOptions mergeFields(String... stringArr) {
        int i;
        com.google.firebase.firestore.model.FieldPath internalPath;
        HashSet hashSet = new HashSet();
        i = 0;
        while (i < stringArr.length) {
            hashSet.add(FieldPath.fromDotSeparatedPath(stringArr[i]).getInternalPath());
            i++;
        }
        SetOptions obj4 = new SetOptions(1, FieldMask.fromSet(hashSet));
        return obj4;
    }

    public boolean equals(Object object) {
        int equals;
        Class<com.google.firebase.firestore.SetOptions> obj;
        Class class;
        if (this == object) {
            return 1;
        }
        final int i = 0;
        if (object != null) {
            if (SetOptions.class != object.getClass()) {
            } else {
                if (this.merge != object.merge) {
                    return i;
                }
                FieldMask fieldMask = this.fieldMask;
                final FieldMask obj5 = object.fieldMask;
                if (fieldMask != null) {
                    equals = fieldMask.equals(obj5);
                } else {
                    if (obj5 == null) {
                    } else {
                        equals = i;
                    }
                }
            }
            return equals;
        }
        return i;
    }

    public FieldMask getFieldMask() {
        return this.fieldMask;
    }

    public int hashCode() {
        int i;
        FieldMask fieldMask = this.fieldMask;
        if (fieldMask != null) {
            i = fieldMask.hashCode();
        } else {
            i = 0;
        }
        return i2 += i;
    }

    boolean isMerge() {
        return this.merge;
    }
}
