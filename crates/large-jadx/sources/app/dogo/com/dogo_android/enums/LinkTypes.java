package app.dogo.com.dogo_android.k;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: LinkTypes.kt */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0010\u0008\u0086\u0001\u0018\u0000 \u00122\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000ej\u0002\u0008\u000fj\u0002\u0008\u0010j\u0002\u0008\u0011¨\u0006\u0013", d2 = {"Lapp/dogo/com/dogo_android/enums/LinkTypes;", "", "typeString", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTypeString", "()Ljava/lang/String;", "setTypeString", "(Ljava/lang/String;)V", "ENTRY_COMMENT", "NEW_PHOTO_UPLOAD_READY", "CHALLENGE_SHARE", "CHALLENGE_START", "CHALLENGE_WELCOME", "RECAP_NOTIFICATION", "INTERACTION_REMINDER", "SPECIAL_OFFER_NOTIFICATION", "UNKNOWN", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: k, reason: from kotlin metadata */
public enum LinkTypes {

    CHALLENGE_SHARE,
    CHALLENGE_START,
    CHALLENGE_WELCOME,
    ENTRY_COMMENT,
    INTERACTION_REMINDER,
    NEW_PHOTO_UPLOAD_READY,
    RECAP_NOTIFICATION,
    SPECIAL_OFFER_NOTIFICATION,
    UNKNOWN;

    private String typeString;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/enums/LinkTypes$Companion;", "", "()V", "parseTypeFromString", "Lapp/dogo/com/dogo_android/enums/LinkTypes;", "typeString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        /* renamed from: a, reason: from kotlin metadata */
        public final k parseTypeFromString(String typeString) {
            int i = 0;
            if (typeString == null) {
                return LinkTypes.UNKNOWN;
            }
            final app.dogo.com.dogo_android.k.k[] values = LinkTypes.values();
            i = 0;
            for (app.dogo.com.dogo_android.k.k kVar : values) {
                if (n.b(kVar.getTypeString(), typeString)) {
                    return kVar;
                }
            }
            return LinkTypes.UNKNOWN;
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }
    @Override // java.lang.Enum
    public final String getTypeString() {
        return this.typeString;
    }

    @Override // java.lang.Enum
    public final void setTypeString(String str) {
        n.f(str, "<set-?>");
        this.typeString = str;
    }

    private static final /* synthetic */ k[] $values() {
        app.dogo.com.dogo_android.k.k[] arr = new k[9];
        return new k[] { LinkTypes.ENTRY_COMMENT, LinkTypes.NEW_PHOTO_UPLOAD_READY, LinkTypes.CHALLENGE_SHARE, LinkTypes.CHALLENGE_START, LinkTypes.CHALLENGE_WELCOME, LinkTypes.RECAP_NOTIFICATION, LinkTypes.INTERACTION_REMINDER, LinkTypes.SPECIAL_OFFER_NOTIFICATION, LinkTypes.UNKNOWN };
    }
}
