package app.dogo.com.dogo_android.s.b;

import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.y.q0;

/* compiled from: ChallengeRepository.kt */
@Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004", d2 = {"Lapp/dogo/com/dogo_android/repository/local/ChallengeRepository;", "", "()V", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: b1, reason: from kotlin metadata */
public final class ChallengeRepository {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final b1.a INSTANCE = new b1$a(0);
    private static final Set<String> a;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\"\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/repository/local/ChallengeRepository$Companion;", "", "()V", "BADGE_ADMIN", "", "BADGE_AMBASSADOR", "BADGE_PREMIUM", "possibleBadgeList", "", "getPossibleBadgeList", "()Ljava/util/Set;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public final Set<String> a() {
            return ChallengeRepository.a;
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }
    static {
        ChallengeRepository.a = q0.g(new String[] { "ambassador", "admin", "premium" });
    }

    public static final /* synthetic */ Set a() {
        return ChallengeRepository.a;
    }
}
