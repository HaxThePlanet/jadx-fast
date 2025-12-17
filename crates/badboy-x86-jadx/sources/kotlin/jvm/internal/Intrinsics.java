package kotlin.jvm.internal;

import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

/* loaded from: classes5.dex */
public class Intrinsics {

    public static class Kotlin {
    }
    public static boolean areEqual(double first, Double second) {
        int cmp;
        int i;
        if (obj4 != null && Double.compare(first, doubleValue) == 0) {
            i = Double.compare(first, doubleValue) == 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    public static boolean areEqual(float first, Float second) {
        int cmp;
        int i;
        if (second != null && Float.compare(first, floatValue) == 0) {
            i = Float.compare(first, floatValue) == 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    public static boolean areEqual(Double first, double second) {
        int cmp;
        int i;
        if (first != null && Double.compare(doubleValue, second) == 0) {
            i = Double.compare(doubleValue, second) == 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    public static boolean areEqual(Double first, Double second) {
        int i;
        int cmp;
        double doubleValue;
        i = 1;
        if (first == null) {
            if (second == null) {
            } else {
                i = i2;
            }
        } else {
        }
        return i;
    }

    public static boolean areEqual(Float first, float second) {
        int cmp;
        int i;
        if (first != null && Float.compare(floatValue, second) == 0) {
            i = Float.compare(floatValue, second) == 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    public static boolean areEqual(Float first, Float second) {
        int i;
        int cmp;
        float floatValue;
        i = 1;
        if (first == null) {
            if (second == null) {
            } else {
                i = i2;
            }
        } else {
        }
        return i;
    }

    public static boolean areEqual(Object first, Object second) {
        int equals;
        if (first == null) {
            equals = second == null ? 1 : 0;
        } else {
            equals = first.equals(second);
        }
        return equals;
    }

    public static void checkExpressionValueIsNotNull(Object value, String expression) {
        if (value == null) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append(expression).append(" must not be null").toString());
        throw (IllegalStateException)Intrinsics.sanitizeStackTrace(illegalStateException);
    }

    public static void checkFieldIsNotNull(Object value, String message) {
        if (value == null) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException(message);
        throw (IllegalStateException)Intrinsics.sanitizeStackTrace(illegalStateException);
    }

    public static void checkFieldIsNotNull(Object value, String className, String fieldName) {
        if (value == null) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("Field specified as non-null is null: ").append(className).append(".").append(fieldName).toString());
        throw (IllegalStateException)Intrinsics.sanitizeStackTrace(illegalStateException);
    }

    public static void checkHasClass(String internalName) throws java.lang.ClassNotFoundException {
        Class.forName(internalName.replace('/', '.'));
    }

    public static void checkHasClass(String internalName, String requiredVersion) throws java.lang.ClassNotFoundException {
        Class.forName(internalName.replace('/', '.'));
    }

    public static void checkNotNull(Object object) {
        if (object == null) {
            Intrinsics.throwJavaNpe();
        }
    }

    public static void checkNotNull(Object object, String message) {
        if (object == null) {
            Intrinsics.throwJavaNpe(message);
        }
    }

    public static void checkNotNullExpressionValue(Object value, String expression) {
        if (value == null) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        NullPointerException nullPointerException = new NullPointerException(stringBuilder.append(expression).append(" must not be null").toString());
        throw (NullPointerException)Intrinsics.sanitizeStackTrace(nullPointerException);
    }

    public static void checkNotNullParameter(Object value, String paramName) {
        if (value == null) {
            Intrinsics.throwParameterIsNullNPE(paramName);
        }
    }

    public static void checkParameterIsNotNull(Object value, String paramName) {
        if (value == null) {
            Intrinsics.throwParameterIsNullIAE(paramName);
        }
    }

    public static void checkReturnedValueIsNotNull(Object value, String message) {
        if (value == null) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException(message);
        throw (IllegalStateException)Intrinsics.sanitizeStackTrace(illegalStateException);
    }

    public static void checkReturnedValueIsNotNull(Object value, String className, String methodName) {
        if (value == null) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("Method specified as non-null returned null: ").append(className).append(".").append(methodName).toString());
        throw (IllegalStateException)Intrinsics.sanitizeStackTrace(illegalStateException);
    }

    public static int compare(int thisVal, int anotherVal) {
        int i;
        i = thisVal < anotherVal ? -1 : thisVal == anotherVal ? 0 : 1;
        return i;
    }

    public static int compare(long thisVal, long anotherVal) {
        int i;
        i = Long.compare(thisVal, obj3) < 0 ? -1 : cmp2 == 0 ? 0 : 1;
        return i;
    }

    private static String createParameterIsNullExceptionMessage(String paramName) {
        int i;
        boolean equals;
        java.lang.StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = Intrinsics.class.getName();
        i = 0;
        while (!stackTrace[i].getClassName().equals(name)) {
            i++;
        }
        while (stackTrace[i].getClassName().equals(name)) {
            i++;
        }
        java.lang.StackTraceElement stack3 = stackTrace[i];
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Parameter specified as non-null is null: method ").append(stack3.getClassName()).append(".").append(stack3.getMethodName()).append(", parameter ").append(paramName).toString();
    }

    public static void needClassReification() {
        Intrinsics.throwUndefinedForReified();
    }

    public static void needClassReification(String message) {
        Intrinsics.throwUndefinedForReified(message);
    }

    public static void reifiedOperationMarker(int id, String typeParameterIdentifier) {
        Intrinsics.throwUndefinedForReified();
    }

    public static void reifiedOperationMarker(int id, String typeParameterIdentifier, String message) {
        Intrinsics.throwUndefinedForReified(message);
    }

    private static <T extends Throwable> T sanitizeStackTrace(T t) {
        return Intrinsics.sanitizeStackTrace(t, Intrinsics.class.getName());
    }

    static <T extends Throwable> T sanitizeStackTrace(T t, String classNameToDrop) {
        int lastIntrinsic;
        int i;
        boolean equals;
        final java.lang.StackTraceElement[] stackTrace = t.getStackTrace();
        final int length = stackTrace.length;
        lastIntrinsic = -1;
        i = 0;
        while (i < length) {
            if (classNameToDrop.equals(stackTrace[i].getClassName())) {
            }
            i++;
            lastIntrinsic = i;
        }
        t.setStackTrace((StackTraceElement[])Arrays.copyOfRange(stackTrace, lastIntrinsic + 1, length));
        return t;
    }

    public static String stringPlus(String self, Object other) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(self).append(other).toString();
    }

    public static void throwAssert() {
        AssertionError assertionError = new AssertionError();
        throw (AssertionError)Intrinsics.sanitizeStackTrace(assertionError);
    }

    public static void throwAssert(String message) {
        AssertionError assertionError = new AssertionError(message);
        throw (AssertionError)Intrinsics.sanitizeStackTrace(assertionError);
    }

    public static void throwIllegalArgument() {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw (IllegalArgumentException)Intrinsics.sanitizeStackTrace(illegalArgumentException);
    }

    public static void throwIllegalArgument(String message) {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(message);
        throw (IllegalArgumentException)Intrinsics.sanitizeStackTrace(illegalArgumentException);
    }

    public static void throwIllegalState() {
        IllegalStateException illegalStateException = new IllegalStateException();
        throw (IllegalStateException)Intrinsics.sanitizeStackTrace(illegalStateException);
    }

    public static void throwIllegalState(String message) {
        IllegalStateException illegalStateException = new IllegalStateException(message);
        throw (IllegalStateException)Intrinsics.sanitizeStackTrace(illegalStateException);
    }

    public static void throwJavaNpe() {
        NullPointerException nullPointerException = new NullPointerException();
        throw (NullPointerException)Intrinsics.sanitizeStackTrace(nullPointerException);
    }

    public static void throwJavaNpe(String message) {
        NullPointerException nullPointerException = new NullPointerException(message);
        throw (NullPointerException)Intrinsics.sanitizeStackTrace(nullPointerException);
    }

    public static void throwNpe() {
        KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException();
        throw (KotlinNullPointerException)Intrinsics.sanitizeStackTrace(kotlinNullPointerException);
    }

    public static void throwNpe(String message) {
        KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException(message);
        throw (KotlinNullPointerException)Intrinsics.sanitizeStackTrace(kotlinNullPointerException);
    }

    private static void throwParameterIsNullIAE(String paramName) {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(Intrinsics.createParameterIsNullExceptionMessage(paramName));
        throw (IllegalArgumentException)Intrinsics.sanitizeStackTrace(illegalArgumentException);
    }

    private static void throwParameterIsNullNPE(String paramName) {
        NullPointerException nullPointerException = new NullPointerException(Intrinsics.createParameterIsNullExceptionMessage(paramName));
        throw (NullPointerException)Intrinsics.sanitizeStackTrace(nullPointerException);
    }

    public static void throwUndefinedForReified() {
        Intrinsics.throwUndefinedForReified("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void throwUndefinedForReified(String message) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(message);
        throw unsupportedOperationException;
    }

    public static void throwUninitializedProperty(String message) {
        UninitializedPropertyAccessException uninitializedPropertyAccessException = new UninitializedPropertyAccessException(message);
        throw (UninitializedPropertyAccessException)Intrinsics.sanitizeStackTrace(uninitializedPropertyAccessException);
    }

    public static void throwUninitializedPropertyAccessException(String propertyName) {
        StringBuilder stringBuilder = new StringBuilder();
        Intrinsics.throwUninitializedProperty(stringBuilder.append("lateinit property ").append(propertyName).append(" has not been initialized").toString());
    }
}
