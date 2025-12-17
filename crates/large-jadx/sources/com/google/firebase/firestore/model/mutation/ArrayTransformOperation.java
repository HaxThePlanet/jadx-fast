package com.google.firebase.firestore.model.mutation;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.Values;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import f.c.e.c.a;
import f.c.e.c.a.b;
import f.c.e.c.x;
import f.c.e.c.x.b;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class ArrayTransformOperation implements com.google.firebase.firestore.model.mutation.TransformOperation {

    private final List<x> elements;

    public static class Remove extends com.google.firebase.firestore.model.mutation.ArrayTransformOperation {
        public Remove(List<x> list) {
            super(list);
        }

        @Override // com.google.firebase.firestore.model.mutation.ArrayTransformOperation
        protected x apply(x x) {
            Object next;
            int i;
            int equals;
            a.b obj5 = ArrayTransformOperation.coercedFieldValuesArray(x);
            Iterator iterator = getElements().iterator();
            for (x next : iterator) {
                i = 0;
                while (i < obj5.e()) {
                    if (Values.equals(obj5.d(i), next)) {
                    } else {
                    }
                    i++;
                    obj5.f(i);
                }
                if (Values.equals(obj5.d(i), next)) {
                } else {
                }
                i++;
                obj5.f(i);
            }
            x.b bVar = x.x();
            bVar.c(obj5);
            return (x)bVar.build();
        }
    }

    public static class Union extends com.google.firebase.firestore.model.mutation.ArrayTransformOperation {
        public Union(List<x> list) {
            super(list);
        }

        @Override // com.google.firebase.firestore.model.mutation.ArrayTransformOperation
        protected x apply(x x) {
            Object next;
            boolean contains;
            a.b obj4 = ArrayTransformOperation.coercedFieldValuesArray(x);
            Iterator iterator = getElements().iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (!Values.contains(obj4, (x)next)) {
                }
                obj4.c(next);
            }
            x.b bVar = x.x();
            bVar.c(obj4);
            return (x)bVar.build();
        }
    }
    ArrayTransformOperation(List<x> list) {
        super();
        this.elements = Collections.unmodifiableList(list);
    }

    static a.b coercedFieldValuesArray(x x) {
        if (Values.isArray(x)) {
            return (a.b)x.n().toBuilder();
        }
        return a.l();
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    protected abstract x apply(x x);

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public x applyToLocalView(x x, Timestamp timestamp2) {
        return apply(x);
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public x applyToRemoteDocument(x x, x x2) {
        return apply(x);
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public x computeBaseValue(x x) {
        return null;
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public boolean equals(Object object) {
        Class class;
        Class class2;
        if (this == object) {
            return 1;
        }
        if (object != null && getClass() != object.getClass()) {
            if (getClass() != object.getClass()) {
            }
            return this.elements.equals(object.elements);
        }
        return 0;
    }

    public List<x> getElements() {
        return this.elements;
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public int hashCode() {
        return i2 += i4;
    }
}
