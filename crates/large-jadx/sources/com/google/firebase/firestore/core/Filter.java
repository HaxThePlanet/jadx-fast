package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;

/* loaded from: classes2.dex */
public abstract class Filter {

    public static enum Operator {

        LESS_THAN("<"),
        LESS_THAN_OR_EQUAL("<="),
        EQUAL("=="),
        NOT_EQUAL("!="),
        GREATER_THAN(">"),
        GREATER_THAN_OR_EQUAL(">="),
        ARRAY_CONTAINS("array_contains"),
        ARRAY_CONTAINS_ANY(5),
        IN(4),
        NOT_IN(3);

        private final String text;
        @Override // java.lang.Enum
        public String toString() {
            return this.text;
        }
    }
    public abstract String getCanonicalId();

    public abstract FieldPath getField();

    public abstract boolean matches(Document document);
}
