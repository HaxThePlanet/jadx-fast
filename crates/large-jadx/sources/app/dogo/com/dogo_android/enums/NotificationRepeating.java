package app.dogo.com.dogo_android.k;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: NotificationRepeating.kt */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\r\u0008\u0086\u0001\u0018\u0000 \u000f2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000e¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/enums/NotificationRepeating;", "", "tag", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTag", "()Ljava/lang/String;", "Daily", "Weekly", "Monthly", "Yearly", "Once", "Temp", "FewTimesADay", "Unknown", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: l, reason: from kotlin metadata */
public enum NotificationRepeating {

    Daily,
    FewTimesADay,
    Monthly,
    Once,
    Temp,
    Unknown,
    Weekly,
    Yearly;

    private final String tag;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/enums/NotificationRepeating$Companion;", "", "()V", "getEnum", "Lapp/dogo/com/dogo_android/enums/NotificationRepeating;", "tag", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        /* renamed from: a, reason: from kotlin metadata */
        public final l getEnum(String tag) {
            int i = 0;
            app.dogo.com.dogo_android.k.l unknown2 = null;
            boolean z;
            n.f(tag, "tag");
            app.dogo.com.dogo_android.k.l[] values = NotificationRepeating.values();
            i = 0;
            for (app.dogo.com.dogo_android.k.l unknown2 : values) {
                if (n.b(unknown2.getTag(), tag)) {
                    break;
                }
            }
            int i2 = 0;
            if (unknown2 == null) {
                unknown2 = NotificationRepeating.Unknown;
            }
            return unknown2;
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }
    @Override // java.lang.Enum
    public final String getTag() {
        return this.tag;
    }

    private static final /* synthetic */ l[] $values() {
        app.dogo.com.dogo_android.k.l[] arr = new l[8];
        return new l[] { NotificationRepeating.Daily, NotificationRepeating.Weekly, NotificationRepeating.Monthly, NotificationRepeating.Yearly, NotificationRepeating.Once, NotificationRepeating.Temp, NotificationRepeating.FewTimesADay, NotificationRepeating.Unknown };
    }
}
