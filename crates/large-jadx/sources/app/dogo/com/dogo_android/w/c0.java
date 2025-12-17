package app.dogo.com.dogo_android.w;

import kotlin.Metadata;
import kotlin.o;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0008\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Lapp/dogo/com/dogo_android/tracking/E$InAppMessaging;", "", "()V", "NegativeFeedbackScore", "Lapp/dogo/com/dogo_android/tracking/Event3;", "Lapp/dogo/com/dogo_android/tracking/EP$FeedbackScore;", "Lapp/dogo/com/dogo_android/tracking/EP$CampaignId;", "Lapp/dogo/com/dogo_android/tracking/EP$CampaignName;", "NormalFeedbackScore", "PositiveFeedbackScore", "ZendeskTicketCreated", "Lapp/dogo/com/dogo_android/tracking/Event0;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c0 {

    public static final app.dogo.com.dogo_android.w.w2<app.dogo.com.dogo_android.w.n1, app.dogo.com.dogo_android.w.z0, app.dogo.com.dogo_android.w.a1> a;
    public static final app.dogo.com.dogo_android.w.w2<app.dogo.com.dogo_android.w.n1, app.dogo.com.dogo_android.w.z0, app.dogo.com.dogo_android.w.a1> b;
    public static final app.dogo.com.dogo_android.w.w2<app.dogo.com.dogo_android.w.n1, app.dogo.com.dogo_android.w.z0, app.dogo.com.dogo_android.w.a1> c;
    public static final app.dogo.com.dogo_android.w.t2 d;
    static {
        app.dogo.com.dogo_android.w.s2.a companion = s2.Companion;
        n1 n1Var = new n1();
        z0 z0Var = new z0();
        a1 a1Var = new a1();
        c0.a = companion.a("feedback_score_submitted_positive").d(n1Var, z0Var, a1Var).b(d.a);
        n1 n1Var2 = new n1();
        z0 z0Var2 = new z0();
        a1 a1Var2 = new a1();
        c0.b = companion.a("feedback_score_submitted_neutral").d(n1Var2, z0Var2, a1Var2).b(f.a);
        n1 n1Var3 = new n1();
        z0 z0Var3 = new z0();
        a1 a1Var3 = new a1();
        c0.c = companion.a("feedback_score_submitted_negative").d(n1Var3, z0Var3, a1Var3).b(e.a);
        c0.d = companion.a("zendesk_ticket_created");
    }

    private static final app.dogo.com.dogo_android.w.a3 a(o o, o o2, o o3) {
        String str;
        int obj1;
        Object obj2;
        obj2 = o2.d();
        str = "";
        if (obj2 == null) {
        } else {
            obj2 = obj2.toString();
            if (obj2 == null) {
            } else {
                str = obj2;
            }
        }
        if (obj1 instanceof Integer) {
        } else {
            obj1 = 0;
        }
        if (obj1 == null) {
            obj1 = 0;
        } else {
            obj1 = obj1.intValue();
        }
        return a3.Companion.h(str, obj1);
    }

    private static final app.dogo.com.dogo_android.w.a3 b(o o, o o2, o o3) {
        String str;
        int obj1;
        Object obj2;
        obj2 = o2.d();
        str = "";
        if (obj2 == null) {
        } else {
            obj2 = obj2.toString();
            if (obj2 == null) {
            } else {
                str = obj2;
            }
        }
        if (obj1 instanceof Integer) {
        } else {
            obj1 = 0;
        }
        if (obj1 == null) {
            obj1 = 0;
        } else {
            obj1 = obj1.intValue();
        }
        return a3.Companion.h(str, obj1);
    }

    private static final app.dogo.com.dogo_android.w.a3 c(o o, o o2, o o3) {
        String str;
        int obj1;
        Object obj2;
        obj2 = o2.d();
        str = "";
        if (obj2 == null) {
        } else {
            obj2 = obj2.toString();
            if (obj2 == null) {
            } else {
                str = obj2;
            }
        }
        if (obj1 instanceof Integer) {
        } else {
            obj1 = 0;
        }
        if (obj1 == null) {
            obj1 = 0;
        } else {
            obj1 = obj1.intValue();
        }
        return a3.Companion.h(str, obj1);
    }

    public static app.dogo.com.dogo_android.w.a3 d(o o, o o2, o o3) {
        return c0.c(o, o2, o3);
    }

    public static app.dogo.com.dogo_android.w.a3 e(o o, o o2, o o3) {
        return c0.a(o, o2, o3);
    }

    public static app.dogo.com.dogo_android.w.a3 f(o o, o o2, o o3) {
        return c0.b(o, o2, o3);
    }
}
