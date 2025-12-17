package androidx.core.os;

import android.os.UserHandle;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class UserHandleCompat {

    private static Method sGetUserIdMethod;
    private static Constructor<UserHandle> sUserHandleConstructor;

    private static class Api24Impl {
        static UserHandle getUserHandleForUid(int uid) {
            return UserHandle.getUserHandleForUid(uid);
        }
    }
    private static Method getGetUserIdMethod() throws java.lang.NoSuchMethodException {
        Method sGetUserIdMethod;
        int i;
        Class[] arr;
        String str;
        Class tYPE;
        if (UserHandleCompat.sGetUserIdMethod == null) {
            i = 1;
            arr = new Class[i];
            arr[0] = Integer.TYPE;
            UserHandleCompat.sGetUserIdMethod = UserHandle.class.getDeclaredMethod("getUserId", arr);
            UserHandleCompat.sGetUserIdMethod.setAccessible(i);
        }
        return UserHandleCompat.sGetUserIdMethod;
    }

    private static Constructor<UserHandle> getUserHandleConstructor() throws java.lang.NoSuchMethodException {
        Constructor sUserHandleConstructor;
        int i;
        Class[] arr;
        int i2;
        Class tYPE;
        if (UserHandleCompat.sUserHandleConstructor == null) {
            i = 1;
            arr = new Class[i];
            arr[0] = Integer.TYPE;
            UserHandleCompat.sUserHandleConstructor = UserHandle.class.getDeclaredConstructor(arr);
            UserHandleCompat.sUserHandleConstructor.setAccessible(i);
        }
        return UserHandleCompat.sUserHandleConstructor;
    }

    public static UserHandle getUserHandleForUid(int uid) {
        return UserHandleCompat.Api24Impl.getUserHandleForUid(uid);
    }
}
