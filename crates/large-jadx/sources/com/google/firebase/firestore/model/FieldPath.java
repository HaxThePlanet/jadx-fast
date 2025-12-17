package com.google.firebase.firestore.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class FieldPath extends com.google.firebase.firestore.model.BasePath<com.google.firebase.firestore.model.FieldPath> {

    public static final com.google.firebase.firestore.model.FieldPath EMPTY_PATH;
    public static final com.google.firebase.firestore.model.FieldPath KEY_PATH;
    static {
        FieldPath.KEY_PATH = FieldPath.fromSingleSegment("__name__");
        FieldPath fieldPath = new FieldPath(Collections.emptyList());
        FieldPath.EMPTY_PATH = fieldPath;
    }

    private FieldPath(List<String> list) {
        super(list);
    }

    public static com.google.firebase.firestore.model.FieldPath fromSegments(List<String> list) {
        boolean fieldPath;
        com.google.firebase.firestore.model.FieldPath obj1;
        if (list.isEmpty()) {
            obj1 = FieldPath.EMPTY_PATH;
        } else {
            fieldPath = new FieldPath(list);
            obj1 = fieldPath;
        }
        return obj1;
    }

    public static com.google.firebase.firestore.model.FieldPath fromServerFormat(String string) {
        StringBuilder stringBuilder;
        int i3;
        int i2;
        char stringBuilder2;
        String str;
        String str2;
        int i;
        ArrayList arrayList = new ArrayList();
        stringBuilder = new StringBuilder();
        i2 = i3;
        str = "). Paths must not be empty, begin with '.', end with '.', or contain '..'";
        str2 = "Invalid field path (";
        while (i3 < string.length()) {
            stringBuilder2 = string.charAt(i3);
            if (stringBuilder2 == 96) {
            } else {
            }
            stringBuilder.append(stringBuilder2);
            i3++;
            str = "). Paths must not be empty, begin with '.', end with '.', or contain '..'";
            str2 = "Invalid field path (";
            i2 ^= 1;
            stringBuilder.append(stringBuilder2);
            String string2 = stringBuilder.toString();
            stringBuilder2 = new StringBuilder();
            arrayList.add(string2);
            stringBuilder = stringBuilder2;
            i3++;
            stringBuilder.append(string.charAt(i3));
        }
        String string3 = stringBuilder.toString();
        if (string3.isEmpty()) {
        } else {
            arrayList.add(string3);
            FieldPath obj8 = new FieldPath(arrayList);
            return obj8;
        }
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(str2);
        stringBuilder4.append(string);
        stringBuilder4.append(str);
        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder4.toString());
        throw illegalArgumentException2;
    }

    public static com.google.firebase.firestore.model.FieldPath fromSingleSegment(String string) {
        FieldPath fieldPath = new FieldPath(Collections.singletonList(string));
        return fieldPath;
    }

    private static boolean isValidIdentifier(String string) {
        int i;
        char charAt;
        int i2;
        final int i4 = 0;
        if (string.isEmpty()) {
            return i4;
        }
        char charAt2 = string.charAt(i4);
        final int i5 = 90;
        final int i6 = 122;
        final int i7 = 65;
        final int i8 = 97;
        final int i9 = 95;
        if (charAt2 != i9) {
            if (charAt2 >= i8) {
                if (charAt2 > i6 && charAt2 >= i7 && charAt2 > i5) {
                    if (charAt2 >= i7) {
                        if (charAt2 > i5) {
                        }
                    }
                }
            } else {
            }
            return i4;
        }
        int i3 = 1;
        i = i3;
        while (i < string.length()) {
            charAt = string.charAt(i);
            i++;
        }
        return i3;
    }

    @Override // com.google.firebase.firestore.model.BasePath
    public String canonicalString() {
        int i;
        String replace;
        int size;
        boolean validIdentifier;
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < this.segments.size()) {
            if (i > 0) {
            }
            replace = (String)this.segments.get(i).replace("\\", "\\\\").replace("`", "\\`");
            if (!FieldPath.isValidIdentifier(replace)) {
            }
            stringBuilder.append(replace);
            i++;
            validIdentifier = new StringBuilder();
            str = 96;
            validIdentifier.append(str);
            validIdentifier.append(replace);
            validIdentifier.append(str);
            replace = validIdentifier.toString();
            stringBuilder.append(".");
        }
        return stringBuilder.toString();
    }

    @Override // com.google.firebase.firestore.model.BasePath
    com.google.firebase.firestore.model.BasePath createPathWithSegments(List list) {
        return createPathWithSegments(list);
    }

    com.google.firebase.firestore.model.FieldPath createPathWithSegments(List<String> list) {
        FieldPath fieldPath = new FieldPath(list);
        return fieldPath;
    }

    @Override // com.google.firebase.firestore.model.BasePath
    public boolean isKeyField() {
        return equals(FieldPath.KEY_PATH);
    }
}
