package com.google.firebase.firestore.util;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirebaseFirestoreException.Code;
import com.google.protobuf.j;
import f.c.b.a.a.a.a;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import io.grpc.d1;
import io.grpc.d1.b;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/* loaded from: classes2.dex */
public class Util {

    private static final String AUTO_ID_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int AUTO_ID_LENGTH = 20;
    private static final Comparator COMPARABLE_COMPARATOR;
    private static final c<Void, Void> VOID_ERROR_TRANSFORMER;
    private static final Random rand;
    static {
        SecureRandom secureRandom = new SecureRandom();
        Util.rand = secureRandom;
        Util.1 anon = new Util.1();
        Util.COMPARABLE_COMPARATOR = anon;
        Util.VOID_ERROR_TRANSFORMER = q.a;
    }

    static void a(RuntimeException runtimeException) {
        throw runtimeException;
    }

    public static String autoId() {
        int i;
        char charAt;
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i < 20) {
            stringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(Util.rand.nextInt(62)));
            i++;
        }
        return stringBuilder.toString();
    }

    static Void b(j j) {
        if (j.isSuccessful()) {
            return (Void)j.getResult();
        }
        Exception obj3 = Util.convertStatusException(j.getException());
        if (obj3 instanceof FirebaseFirestoreException != null) {
            throw obj3;
        }
        FirebaseFirestoreException firebaseFirestoreException = new FirebaseFirestoreException(obj3.getMessage(), FirebaseFirestoreException.Code.UNKNOWN, obj3);
        throw firebaseFirestoreException;
    }

    public static List<Object> collectUpdateArguments(int i, Object object2, Object object3, Object... object4Arr4) {
        int obj4;
        Object obj5;
        Object[] obj6;
        final int i3 = 1;
        if (length %= 2 == i3) {
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(object2);
            arrayList.add(object3);
            Collections.addAll(arrayList, object4Arr4);
            obj4 = 0;
            while (obj4 < arrayList.size()) {
                obj5 = arrayList.get(obj4);
                obj4 += 2;
            }
            return arrayList;
        }
        IllegalArgumentException obj3 = new IllegalArgumentException("Missing value in call to update().  There must be an even number of arguments that alternate between field names and values");
        throw obj3;
    }

    public static <T extends Comparable<T>> Comparator<T> comparator() {
        return Util.COMPARABLE_COMPARATOR;
    }

    public static int compareBooleans(boolean z, boolean z2) {
        if (z == z2) {
            return 0;
        }
        if (z) {
            return 1;
        }
        return -1;
    }

    public static int compareByteStrings(j j, j j2) {
        int i2;
        int i;
        int i3;
        i2 = 0;
        while (i2 < Math.min(j.size(), j2.size())) {
            b &= 255;
            b2 &= 255;
            i2++;
        }
        return Util.compareIntegers(j.size(), j2.size());
    }

    public static int compareDoubles(double d, double d2) {
        return a.c(d, d2);
    }

    public static int compareIntegers(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        return 0;
    }

    public static int compareLongs(long l, long l2) {
        return a.a(l, l2);
    }

    public static int compareMixed(double d, long l2) {
        return a.b(d, l2);
    }

    private static Exception convertStatusException(Exception exception) {
        Object obj1;
        if (exception instanceof StatusException != null) {
            return Util.exceptionFromStatus((StatusException)exception.a());
        }
        if (exception instanceof StatusRuntimeException != null) {
            obj1 = Util.exceptionFromStatus((StatusRuntimeException)exception.a());
        }
        return obj1;
    }

    public static Exception convertThrowableToException(Throwable throwable) {
        if (throwable instanceof Exception != null) {
            return Util.convertStatusException((Exception)throwable);
        }
        Exception exception = new Exception(throwable);
        return exception;
    }

    public static void crashMainThread(RuntimeException runtimeException) {
        Handler handler = new Handler(Looper.getMainLooper());
        p pVar = new p(runtimeException);
        handler.post(pVar);
    }

    public static FirebaseFirestoreException exceptionFromStatus(d1 d1) {
        final StatusException exc = d1.c();
        FirebaseFirestoreException firebaseFirestoreException = new FirebaseFirestoreException(exc.getMessage(), FirebaseFirestoreException.Code.fromValue(d1.n().value()), exc);
        return firebaseFirestoreException;
    }

    public static String repeatSequence(java.lang.CharSequence charSequence, int i2, java.lang.CharSequence charSequence3) {
        int i;
        if (i2 == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(charSequence);
        i = 1;
        while (i < i2) {
            stringBuilder.append(charSequence3);
            stringBuilder.append(charSequence);
            i++;
        }
        return stringBuilder.toString();
    }

    public static String toDebugString(j j) {
        int i2;
        char forDigit;
        char forDigit2;
        int i;
        final int size = j.size();
        StringBuilder stringBuilder = new StringBuilder(size * 2);
        i2 = 0;
        while (i2 < size) {
            b &= 255;
            i = 16;
            stringBuilder.append(Character.forDigit(i4 >>> 4, i));
            stringBuilder.append(Character.forDigit(i4 &= 15, i));
            i2++;
        }
        return stringBuilder.toString();
    }

    public static String typeName(Object object) {
        String obj0;
        if (object == null) {
            obj0 = "null";
        } else {
            obj0 = object.getClass().getName();
        }
        return obj0;
    }

    public static c<Void, Void> voidErrorTransformer() {
        return Util.VOID_ERROR_TRANSFORMER;
    }
}
