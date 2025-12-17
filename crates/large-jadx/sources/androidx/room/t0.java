package androidx.room;

import android.content.Context;

/* loaded from: classes.dex */
public class t0 {
    public static <T extends androidx.room.u0> androidx.room.u0.a<T> a(Context context, Class<T> class2, String string3) {
        int length;
        if (string3 == null) {
        } else {
            if (string3.trim().length() == 0) {
            } else {
                u0.a aVar = new u0.a(context, class2, string3);
                return aVar;
            }
        }
        IllegalArgumentException obj1 = new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        throw obj1;
    }

    public static <T, C> T b(Class<C> class, String string2) {
        String string;
        String canonicalName;
        StringBuilder stringBuilder;
        boolean empty;
        String name = class.getPackage().getName();
        final int i = 1;
        if (name.isEmpty()) {
        } else {
            canonicalName = class.getCanonicalName().substring(length += i);
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(canonicalName.replace('.', '_'));
        stringBuilder3.append(string2);
        final String obj7 = stringBuilder3.toString();
        if (name.isEmpty()) {
            string = obj7;
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(name);
            stringBuilder.append(".");
            stringBuilder.append(obj7);
            string = stringBuilder.toString();
        }
        return Class.forName(string, i, class.getClassLoader()).newInstance();
    }
}
