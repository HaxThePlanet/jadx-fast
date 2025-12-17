package com.google.firebase.firestore.util;

/* loaded from: classes2.dex */
public class Assert {
    public static java.lang.AssertionError fail(String string, Object... object2Arr2) {
        AssertionError assertionError = new AssertionError(Assert.format(string, object2Arr2));
        throw assertionError;
    }

    public static java.lang.AssertionError fail(Throwable throwable, String string2, Object... object3Arr3) {
        throw ApiUtil.newAssertionError(Assert.format(string2, object3Arr3), throwable);
    }

    private static String format(String string, Object... object2Arr2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INTERNAL ASSERTION FAILED: ");
        stringBuilder.append(String.format(string, object2Arr2));
        return stringBuilder.toString();
    }

    public static void hardAssert(boolean z, String string2, Object... object3Arr3) {
        if (!z) {
        } else {
        }
        throw Assert.fail(string2, object3Arr3);
    }
}
