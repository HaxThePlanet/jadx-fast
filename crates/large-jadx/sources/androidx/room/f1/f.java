package androidx.room.f1;

/* loaded from: classes.dex */
public class f {
    static {
    }

    public static void a(StringBuilder stringBuilder, int i2) {
        int i;
        int str;
        i = 0;
        while (i < i2) {
            stringBuilder.append("?");
            if (i < i2 + -1) {
            }
            i++;
            stringBuilder.append(",");
        }
    }

    public static StringBuilder b() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder;
    }
}
