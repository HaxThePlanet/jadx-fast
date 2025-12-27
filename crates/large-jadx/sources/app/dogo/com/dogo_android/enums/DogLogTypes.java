package app.dogo.com.dogo_android.k;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: DogLogTypes.kt */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0010\u0008\u0086\u0001\u0018\u0000 \u00142\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\u001f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0004\u0010\u0008R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000ej\u0002\u0008\u000fj\u0002\u0008\u0010j\u0002\u0008\u0011j\u0002\u0008\u0012j\u0002\u0008\u0013¨\u0006\u0015", d2 = {"Lapp/dogo/com/dogo_android/enums/DogLogTypes;", "", "tagId", "", "isAccident", "", "isSuccess", "(Ljava/lang/String;ILjava/lang/String;ZZ)V", "()Z", "getTagId", "()Ljava/lang/String;", "PEE", "POOP", "EAT", "DRINK", "SLEEP", "WALK", "ACCIDENT_PEE", "ACCIDENT_POOP", "UNKNOWN_TYPE", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: e, reason: from kotlin metadata */
public enum DogLogTypes {

    PEE("pee", 0, 1),
    PEE("pee", 0, 1),
    PEE("pee", 0, 1),
    PEE("pee", 0, 1),
    PEE("pee", 0, 1),
    PEE("pee", 0, 1),
    PEE("pee", 0, 1),
    PEE("pee", 0, 1);

    private final boolean isAccident;
    private final boolean isSuccess;
    private final String tagId;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/enums/DogLogTypes$Companion;", "", "()V", "fromString", "Lapp/dogo/com/dogo_android/enums/DogLogTypes;", "tagId", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        /* renamed from: a, reason: from kotlin metadata */
        public final e fromString(String tagId) {
            int i = 0;
            app.dogo.com.dogo_android.k.e uNKNOWN_TYPE2 = null;
            boolean z;
            n.f(tagId, "tagId");
            app.dogo.com.dogo_android.k.e[] values = DogLogTypes.values();
            i = 0;
            for (app.dogo.com.dogo_android.k.e uNKNOWN_TYPE2 : values) {
                if (n.b(uNKNOWN_TYPE2.getTagId(), tagId)) {
                    break;
                }
            }
            int i2 = 0;
            if (uNKNOWN_TYPE2 == null) {
                uNKNOWN_TYPE2 = DogLogTypes.UNKNOWN_TYPE;
            }
            return uNKNOWN_TYPE2;
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
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

    private static final /* synthetic */ e[] $values() {
        app.dogo.com.dogo_android.k.e[] arr = new e[9];
        return new e[] { DogLogTypes.PEE, DogLogTypes.POOP, DogLogTypes.EAT, DogLogTypes.DRINK, DogLogTypes.SLEEP, DogLogTypes.WALK, DogLogTypes.ACCIDENT_PEE, DogLogTypes.ACCIDENT_POOP, DogLogTypes.UNKNOWN_TYPE };
    }

    public static final e fromString(String str) {
        return DogLogTypes.INSTANCE.fromString(str);
    }
}
