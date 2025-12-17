package app.dogo.com.dogo_android.k;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0010\u0008\u0086\u0001\u0018\u0000 \u00122\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000ej\u0002\u0008\u000fj\u0002\u0008\u0010j\u0002\u0008\u0011¨\u0006\u0013", d2 = {"Lapp/dogo/com/dogo_android/enums/LinkTypes;", "", "typeString", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTypeString", "()Ljava/lang/String;", "setTypeString", "(Ljava/lang/String;)V", "ENTRY_COMMENT", "NEW_PHOTO_UPLOAD_READY", "CHALLENGE_SHARE", "CHALLENGE_START", "CHALLENGE_WELCOME", "RECAP_NOTIFICATION", "INTERACTION_REMINDER", "SPECIAL_OFFER_NOTIFICATION", "UNKNOWN", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum k {

    ENTRY_COMMENT("entryComment"),
    NEW_PHOTO_UPLOAD_READY("entryComment"),
    CHALLENGE_SHARE("entryComment"),
    CHALLENGE_START("entryComment"),
    CHALLENGE_WELCOME("entryComment"),
    RECAP_NOTIFICATION("entryComment"),
    INTERACTION_REMINDER("entryComment"),
    SPECIAL_OFFER_NOTIFICATION("entryComment"),
    UNKNOWN("entryComment");

    private String typeString;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/enums/LinkTypes$Companion;", "", "()V", "parseTypeFromString", "Lapp/dogo/com/dogo_android/enums/LinkTypes;", "typeString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }

        public final app.dogo.com.dogo_android.k.k a(String string) {
            int i;
            app.dogo.com.dogo_android.k.k kVar;
            boolean z;
            if (string == null) {
                return k.UNKNOWN;
            }
            final app.dogo.com.dogo_android.k.k[] values = k.values();
            i = 0;
            while (i < values.length) {
                kVar = values[i];
                i++;
            }
            return k.UNKNOWN;
        }
    }
    private static final app.dogo.com.dogo_android.k.k[] $values() {
        app.dogo.com.dogo_android.k.k[] arr = new k[9];
        return arr;
    }

    @Override // java.lang.Enum
    public final String getTypeString() {
        return this.typeString;
    }

    @Override // java.lang.Enum
    public final void setTypeString(String string) {
        n.f(string, "<set-?>");
        this.typeString = string;
    }
}
