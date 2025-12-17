package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.util.Assert;
import f.c.e.c.x;

/* loaded from: classes2.dex */
public class IndexRange {

    private final x end;
    private final FieldPath fieldPath;
    private final x start;

    public static class Builder {

        private x end;
        private FieldPath fieldPath;
        private x start;
        static FieldPath access$000(com.google.firebase.firestore.core.IndexRange.Builder indexRange$Builder) {
            return builder.fieldPath;
        }

        static x access$100(com.google.firebase.firestore.core.IndexRange.Builder indexRange$Builder) {
            return builder.start;
        }

        static x access$200(com.google.firebase.firestore.core.IndexRange.Builder indexRange$Builder) {
            return builder.end;
        }

        public com.google.firebase.firestore.core.IndexRange build() {
            int i;
            int i2 = 0;
            i = this.fieldPath != null ? 1 : i2;
            Assert.hardAssert(i, "Field path must be specified", new Object[i2]);
            IndexRange indexRange = new IndexRange(this, 0);
            return indexRange;
        }

        public com.google.firebase.firestore.core.IndexRange.Builder setEnd(x x) {
            this.end = x;
            return this;
        }

        public com.google.firebase.firestore.core.IndexRange.Builder setFieldPath(FieldPath fieldPath) {
            this.fieldPath = fieldPath;
            return this;
        }

        public com.google.firebase.firestore.core.IndexRange.Builder setStart(x x) {
            this.start = x;
            return this;
        }
    }
    private IndexRange(com.google.firebase.firestore.core.IndexRange.Builder indexRange$Builder) {
        super();
        this.fieldPath = IndexRange.Builder.access$000(builder);
        this.start = IndexRange.Builder.access$100(builder);
        this.end = IndexRange.Builder.access$200(builder);
    }

    IndexRange(com.google.firebase.firestore.core.IndexRange.Builder indexRange$Builder, com.google.firebase.firestore.core.IndexRange.1 indexRange$12) {
        super(builder);
    }

    public static com.google.firebase.firestore.core.IndexRange.Builder builder() {
        IndexRange.Builder builder = new IndexRange.Builder();
        return builder;
    }

    public x getEnd() {
        return this.end;
    }

    public FieldPath getFieldPath() {
        return this.fieldPath;
    }

    public x getStart() {
        return this.start;
    }
}
