package androidx.core.util;

import java.util.Objects;

/* loaded from: classes5.dex */
public interface Predicate<T>  {
    public static <T> androidx.core.util.Predicate<T> isEqual(Object targetRef) {
        Object externalSyntheticLambda1;
        if (targetRef == null) {
            externalSyntheticLambda1 = new Predicate$$ExternalSyntheticLambda1();
        } else {
            externalSyntheticLambda1 = new Predicate$$ExternalSyntheticLambda2(targetRef);
        }
        return externalSyntheticLambda1;
    }

    public static boolean lambda$and$0(androidx.core.util.Predicate _this, androidx.core.util.Predicate other, Object t) {
        boolean test;
        int i;
        if (_this.test(t) && other.test(t)) {
            i = other.test(t) ? 1 : 0;
        } else {
        }
        return i;
    }

    public static boolean lambda$isEqual$3(Object object) {
        return Objects.isNull(object);
    }

    public static boolean lambda$isEqual$4(Object targetRef, Object object) {
        return targetRef.equals(object);
    }

    public static boolean lambda$negate$1(androidx.core.util.Predicate _this, Object t) {
        return test ^= 1;
    }

    public static boolean lambda$or$2(androidx.core.util.Predicate _this, androidx.core.util.Predicate other, Object t) {
        int i;
        boolean test;
        if (!_this.test(t)) {
            if (other.test(t)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public static <T> androidx.core.util.Predicate<T> not(androidx.core.util.Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return predicate.negate();
    }

    public androidx.core.util.Predicate<T> and(androidx.core.util.Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        Predicate$$ExternalSyntheticLambda3 externalSyntheticLambda3 = new Predicate$$ExternalSyntheticLambda3(this, predicate);
        return externalSyntheticLambda3;
    }

    public androidx.core.util.Predicate<T> negate() {
        Predicate$$ExternalSyntheticLambda4 externalSyntheticLambda4 = new Predicate$$ExternalSyntheticLambda4(this);
        return externalSyntheticLambda4;
    }

    public androidx.core.util.Predicate<T> or(androidx.core.util.Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        Predicate$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new Predicate$$ExternalSyntheticLambda0(this, predicate);
        return externalSyntheticLambda0;
    }

    public abstract boolean test(T t);
}
