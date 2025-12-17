package app.dogo.com.dogo_android.k;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0010\u0008\u0086\u0001\u0018\u0000 \u00142\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\u001f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0004\u0010\u0008R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000ej\u0002\u0008\u000fj\u0002\u0008\u0010j\u0002\u0008\u0011j\u0002\u0008\u0012j\u0002\u0008\u0013¨\u0006\u0015", d2 = {"Lapp/dogo/com/dogo_android/enums/DogLogTypes;", "", "tagId", "", "isAccident", "", "isSuccess", "(Ljava/lang/String;ILjava/lang/String;ZZ)V", "()Z", "getTagId", "()Ljava/lang/String;", "PEE", "POOP", "EAT", "DRINK", "SLEEP", "WALK", "ACCIDENT_PEE", "ACCIDENT_POOP", "UNKNOWN_TYPE", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum e {

    PEE("pee", false, true),
    PEE("pee", false, true),
    PEE("pee", false, true),
    PEE("pee", false, true),
    PEE("pee", false, true),
    PEE("pee", false, true),
    PEE("pee", false, true),
    PEE("pee", false, true);

    private final boolean isAccident;
    private final boolean isSuccess;
    private final String tagId;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/enums/DogLogTypes$Companion;", "", "()V", "fromString", "Lapp/dogo/com/dogo_android/enums/DogLogTypes;", "tagId", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }

        public final app.dogo.com.dogo_android.k.e a(String string) {
            int i;
            app.dogo.com.dogo_android.k.e uNKNOWN_TYPE;
            boolean z;
            n.f(string, "tagId");
            app.dogo.com.dogo_android.k.e[] values = e.values();
            i = 0;
            while (i < values.length) {
                i++;
            }
            uNKNOWN_TYPE = 0;
            if (uNKNOWN_TYPE == null) {
                uNKNOWN_TYPE = e.UNKNOWN_TYPE;
            }
            return uNKNOWN_TYPE;
        }
    }
    private static final app.dogo.com.dogo_android.k.e[] $values() {
        app.dogo.com.dogo_android.k.e[] arr = new e[9];
        return arr;
    }

    public static final app.dogo.com.dogo_android.k.e fromString(String string) {
        return e.Companion.a(string);
    }

    @Override // java.lang.Enum
    public final String getTagId() {
        return this.tagId;
    }

    @Override // java.lang.Enum
    public final boolean isAccident() {
        return this.isAccident;
    }

    @Override // java.lang.Enum
    public final boolean isSuccess() {
        return this.isSuccess;
    }
}
