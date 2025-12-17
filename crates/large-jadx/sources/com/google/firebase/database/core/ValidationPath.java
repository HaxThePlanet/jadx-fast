package com.google.firebase.database.core;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class ValidationPath {

    public static final int MAX_PATH_DEPTH = 32;
    public static final int MAX_PATH_LENGTH_BYTES = 768;
    private int byteLength = 0;
    private final List<String> parts;
    private ValidationPath(com.google.firebase.database.core.Path path) {
        int i;
        String string;
        int utf8Bytes;
        List parts;
        int obj4;
        super();
        ArrayList arrayList = new ArrayList();
        this.parts = arrayList;
        i = 0;
        obj4 = path.iterator();
        for (ChildKey next2 : obj4) {
            this.parts.add(next2.asString());
        }
        this.byteLength = Math.max(1, this.parts.size());
        while (i < this.parts.size()) {
            this.byteLength = obj4 += utf8Bytes;
            i++;
        }
        checkValid();
    }

    private void checkValid() {
        if (this.byteLength > 768) {
        } else {
            if (this.parts.size() > 32) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Path specified exceeds the maximum depth that can be written (32) or object contains a cycle ");
            stringBuilder.append(toErrorString());
            DatabaseException databaseException = new DatabaseException(stringBuilder.toString());
            throw databaseException;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Data has a key path longer than 768 bytes (");
        stringBuilder2.append(this.byteLength);
        stringBuilder2.append(").");
        DatabaseException databaseException2 = new DatabaseException(stringBuilder2.toString());
        throw databaseException2;
    }

    private static String joinStringList(String string, List<String> list2) {
        int i;
        Object obj;
        StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < list2.size()) {
            if (i > 0) {
            }
            stringBuilder.append((String)list2.get(i));
            i++;
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    private String pop() {
        int size;
        List parts = this.parts;
        Object remove = parts.remove(size2--);
        this.byteLength = byteLength -= utf8Bytes;
        if (this.parts.size() > 0) {
            this.byteLength = byteLength2--;
        }
        return remove;
    }

    private void push(String string) {
        int size;
        if (this.parts.size() > 0) {
            this.byteLength = byteLength2++;
        }
        this.parts.add(string);
        this.byteLength = byteLength += obj2;
        checkValid();
    }

    private String toErrorString() {
        if (this.parts.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("in path '");
        stringBuilder.append(ValidationPath.joinStringList("/", this.parts));
        stringBuilder.append("'");
        return stringBuilder.toString();
    }

    private static int utf8Bytes(java.lang.CharSequence charSequence) {
        int i3;
        int i;
        char highSurrogate;
        int i2;
        i = i3;
        while (i3 < charSequence.length()) {
            highSurrogate = charSequence.charAt(i3);
            if (highSurrogate <= 127) {
            } else {
            }
            if (highSurrogate <= 2047) {
            } else {
            }
            if (Character.isHighSurrogate(highSurrogate)) {
            } else {
            }
            i += 3;
            i3++;
            i += 4;
            i3++;
            i += 2;
            i++;
        }
        return i;
    }

    public static void validateWithObject(com.google.firebase.database.core.Path path, Object object2) {
        ValidationPath validationPath = new ValidationPath(path);
        validationPath.withObject(object2);
    }

    private void withObject(Object object) {
        boolean z;
        int size;
        boolean startsWith;
        if (object instanceof Map != null) {
            Iterator iterator = (Map)object.keySet().iterator();
            while (iterator.hasNext()) {
                size = iterator.next();
                if ((String)size.startsWith(".")) {
                } else {
                }
                push(size);
                withObject(object.get(size));
                pop();
            }
        }
        if (object instanceof List != null) {
            z = 0;
            while (z < (List)object.size()) {
                push(Integer.toString(z));
                withObject(object.get(z));
                pop();
                z++;
            }
        }
    }
}
