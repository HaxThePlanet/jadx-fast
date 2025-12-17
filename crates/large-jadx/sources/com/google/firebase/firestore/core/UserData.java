package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.ObjectValue;
import com.google.firebase.firestore.model.mutation.FieldMask;
import com.google.firebase.firestore.model.mutation.FieldTransform;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.PatchMutation;
import com.google.firebase.firestore.model.mutation.Precondition;
import com.google.firebase.firestore.model.mutation.SetMutation;
import com.google.firebase.firestore.model.mutation.TransformOperation;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public class UserData {

    public static class ParseAccumulator {

        private final com.google.firebase.firestore.core.UserData.Source dataSource;
        private final Set<FieldPath> fieldMask;
        private final ArrayList<FieldTransform> fieldTransforms;
        public ParseAccumulator(com.google.firebase.firestore.core.UserData.Source userData$Source) {
            super();
            this.dataSource = source;
            HashSet obj1 = new HashSet();
            this.fieldMask = obj1;
            obj1 = new ArrayList();
            this.fieldTransforms = obj1;
        }

        static com.google.firebase.firestore.core.UserData.Source access$100(com.google.firebase.firestore.core.UserData.ParseAccumulator userData$ParseAccumulator) {
            return parseAccumulator.dataSource;
        }

        void addToFieldMask(FieldPath fieldPath) {
            this.fieldMask.add(fieldPath);
        }

        void addToFieldTransforms(FieldPath fieldPath, TransformOperation transformOperation2) {
            FieldTransform fieldTransform = new FieldTransform(fieldPath, transformOperation2);
            this.fieldTransforms.add(fieldTransform);
        }

        public boolean contains(FieldPath fieldPath) {
            boolean prefixOf;
            boolean prefixOf2;
            int i;
            Iterator iterator = this.fieldMask.iterator();
            i = 1;
            for (FieldPath next : iterator) {
                i = 1;
            }
            Iterator iterator2 = this.fieldTransforms.iterator();
            for (FieldTransform next3 : iterator2) {
            }
            return 0;
        }

        public com.google.firebase.firestore.core.UserData.Source getDataSource() {
            return this.dataSource;
        }

        public List<FieldTransform> getFieldTransforms() {
            return this.fieldTransforms;
        }

        public com.google.firebase.firestore.core.UserData.ParseContext rootContext() {
            UserData.ParseContext parseContext = new UserData.ParseContext(this, FieldPath.EMPTY_PATH, 0, 0);
            return parseContext;
        }

        public com.google.firebase.firestore.core.UserData.ParsedSetData toMergeData(ObjectValue objectValue) {
            UserData.ParsedSetData parsedSetData = new UserData.ParsedSetData(objectValue, FieldMask.fromSet(this.fieldMask), Collections.unmodifiableList(this.fieldTransforms));
            return parsedSetData;
        }

        public com.google.firebase.firestore.core.UserData.ParsedSetData toMergeData(ObjectValue objectValue, FieldMask fieldMask2) {
            Object next;
            boolean covers;
            ArrayList arrayList = new ArrayList();
            Iterator iterator = this.fieldTransforms.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (fieldMask2.covers((FieldTransform)next.getFieldPath())) {
                }
                arrayList.add(next);
            }
            UserData.ParsedSetData parsedSetData = new UserData.ParsedSetData(objectValue, fieldMask2, Collections.unmodifiableList(arrayList));
            return parsedSetData;
        }

        public com.google.firebase.firestore.core.UserData.ParsedSetData toSetData(ObjectValue objectValue) {
            UserData.ParsedSetData parsedSetData = new UserData.ParsedSetData(objectValue, 0, Collections.unmodifiableList(this.fieldTransforms));
            return parsedSetData;
        }

        public com.google.firebase.firestore.core.UserData.ParsedUpdateData toUpdateData(ObjectValue objectValue) {
            UserData.ParsedUpdateData parsedUpdateData = new UserData.ParsedUpdateData(objectValue, FieldMask.fromSet(this.fieldMask), Collections.unmodifiableList(this.fieldTransforms));
            return parsedUpdateData;
        }
    }

    public static class ParseContext {

        private static final String RESERVED_FIELD_DESIGNATOR = "__";
        private final com.google.firebase.firestore.core.UserData.ParseAccumulator accumulator;
        private final boolean arrayElement;
        private final FieldPath path;
        private ParseContext(com.google.firebase.firestore.core.UserData.ParseAccumulator userData$ParseAccumulator, FieldPath fieldPath2, boolean z3) {
            super();
            this.accumulator = parseAccumulator;
            this.path = fieldPath2;
            this.arrayElement = z3;
        }

        ParseContext(com.google.firebase.firestore.core.UserData.ParseAccumulator userData$ParseAccumulator, FieldPath fieldPath2, boolean z3, com.google.firebase.firestore.core.UserData.1 userData$14) {
            super(parseAccumulator, fieldPath2, z3);
        }

        private void validatePath() {
            int i;
            String segment;
            if (this.path == null) {
            }
            i = 0;
            while (i < this.path.length()) {
                validatePathSegment(this.path.getSegment(i));
                i++;
            }
        }

        private void validatePathSegment(String string) {
            boolean write;
            boolean startsWith;
            boolean obj3;
            if (string.isEmpty()) {
            } else {
                write = "__";
                if (isWrite() && string.startsWith(write)) {
                    write = "__";
                    if (string.startsWith(write)) {
                        if (string.endsWith(write)) {
                        } else {
                        }
                        throw createError("Document fields cannot begin and end with \"__\"");
                    }
                }
            }
            throw createError("Document fields must not be empty");
        }

        public void addToFieldMask(FieldPath fieldPath) {
            this.accumulator.addToFieldMask(fieldPath);
        }

        public void addToFieldTransforms(FieldPath fieldPath, TransformOperation transformOperation2) {
            this.accumulator.addToFieldTransforms(fieldPath, transformOperation2);
        }

        public com.google.firebase.firestore.core.UserData.ParseContext childContext(int i) {
            UserData.ParseContext obj4 = new UserData.ParseContext(this.accumulator, 0, 1);
            return obj4;
        }

        public com.google.firebase.firestore.core.UserData.ParseContext childContext(FieldPath fieldPath) {
            int obj4;
            FieldPath path = this.path;
            if (path == null) {
                obj4 = 0;
            } else {
                obj4 = path.append(fieldPath);
            }
            UserData.ParseContext parseContext = new UserData.ParseContext(this.accumulator, obj4, 0);
            parseContext.validatePath();
            return parseContext;
        }

        public com.google.firebase.firestore.core.UserData.ParseContext childContext(String string) {
            int append;
            FieldPath path = this.path;
            if (path == null) {
                append = 0;
            } else {
                append = path.append(string);
            }
            UserData.ParseContext parseContext = new UserData.ParseContext(this.accumulator, append, 0);
            parseContext.validatePathSegment(string);
            return parseContext;
        }

        public RuntimeException createError(String string) {
            String string2;
            FieldPath empty;
            String str;
            empty = this.path;
            if (empty != null) {
                if (empty.isEmpty()) {
                    string2 = "";
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(" (found in field ");
                    stringBuilder.append(this.path.toString());
                    stringBuilder.append(")");
                    string2 = stringBuilder.toString();
                }
            } else {
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Invalid data. ");
            stringBuilder2.append(string);
            stringBuilder2.append(string2);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder2.toString());
            return illegalArgumentException;
        }

        public com.google.firebase.firestore.core.UserData.Source getDataSource() {
            return UserData.ParseAccumulator.access$100(this.accumulator);
        }

        public FieldPath getPath() {
            return this.path;
        }

        public boolean isArrayElement() {
            return this.arrayElement;
        }

        public boolean isWrite() {
            int i;
            int i2;
            int i3 = UserData.1.$SwitchMap$com$google$firebase$firestore$core$UserData$Source[UserData.ParseAccumulator.access$100(this.accumulator).ordinal()];
            int i4 = 1;
            final int i5 = 0;
            if (i3 != i4 && i3 != 2 && i3 != 3 && i3 != 4) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        i5 = 0;
                        if (i3 != 4) {
                            if (i3 != 5) {
                            } else {
                            }
                            Object[] arr = new Object[i4];
                            arr[i5] = UserData.ParseAccumulator.access$100(this.accumulator).name();
                            throw Assert.fail("Unexpected case for UserDataSource: %s", arr);
                        }
                        return i5;
                    }
                }
            }
            return i4;
        }
    }

    public static class ParsedSetData {

        private final ObjectValue data;
        private final FieldMask fieldMask;
        private final List<FieldTransform> fieldTransforms;
        ParsedSetData(ObjectValue objectValue, FieldMask fieldMask2, List<FieldTransform> list3) {
            super();
            this.data = objectValue;
            this.fieldMask = fieldMask2;
            this.fieldTransforms = list3;
        }

        public ObjectValue getData() {
            return this.data;
        }

        public FieldMask getFieldMask() {
            return this.fieldMask;
        }

        public List<FieldTransform> getFieldTransforms() {
            return this.fieldTransforms;
        }

        public Mutation toMutation(DocumentKey documentKey, Precondition precondition2) {
            final FieldMask fieldMask = this.fieldMask;
            if (fieldMask != null) {
                super(documentKey, this.data, fieldMask, precondition2, this.fieldTransforms);
                return patchMutation2;
            }
            SetMutation setMutation = new SetMutation(documentKey, this.data, precondition2, this.fieldTransforms);
            return setMutation;
        }
    }

    public static class ParsedUpdateData {

        private final ObjectValue data;
        private final FieldMask fieldMask;
        private final List<FieldTransform> fieldTransforms;
        ParsedUpdateData(ObjectValue objectValue, FieldMask fieldMask2, List<FieldTransform> list3) {
            super();
            this.data = objectValue;
            this.fieldMask = fieldMask2;
            this.fieldTransforms = list3;
        }

        public ObjectValue getData() {
            return this.data;
        }

        public FieldMask getFieldMask() {
            return this.fieldMask;
        }

        public List<FieldTransform> getFieldTransforms() {
            return this.fieldTransforms;
        }

        public Mutation toMutation(DocumentKey documentKey, Precondition precondition2) {
            super(documentKey, this.data, this.fieldMask, precondition2, this.fieldTransforms);
            return patchMutation2;
        }
    }

    public static enum Source {

        Set,
        MergeSet,
        Update,
        Argument,
        ArrayArgument;
    }
}
