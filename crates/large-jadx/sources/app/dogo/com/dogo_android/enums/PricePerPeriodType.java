package app.dogo.com.dogo_android.k;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: PricePerPeriodType.kt */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0008\u0008\u0086\u0001\u0018\u0000 \n2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\t¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/enums/PricePerPeriodType;", "", "tag", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTag", "()Ljava/lang/String;", "DAY", "WEEK", "MONTH", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: n, reason: from kotlin metadata */
public enum PricePerPeriodType {

    DAY,
    MONTH,
    WEEK;

    private final String tag;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/enums/PricePerPeriodType$Companion;", "", "()V", "getType", "Lapp/dogo/com/dogo_android/enums/PricePerPeriodType;", "tag", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        /* renamed from: a, reason: from kotlin metadata */
        public final n getType(String tag) {
            int i = 0;
            int i2 = 0;
            boolean z;
            final app.dogo.com.dogo_android.k.n[] values = PricePerPeriodType.values();
            i = 0;
            for (app.dogo.com.dogo_android.k.n nVar : values) {
                if (n.b(nVar.getTag(), tag)) {
                    break;
                }
            }
            i2 = 0;
            return i2;
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }
    @Override // java.lang.Enum
    public final String getTag() {
        return this.tag;
    }

    private static final /* synthetic */ n[] $values() {
        app.dogo.com.dogo_android.k.n[] arr = new n[3];
        return new n[] { PricePerPeriodType.DAY, PricePerPeriodType.WEEK, PricePerPeriodType.MONTH };
    }
}
