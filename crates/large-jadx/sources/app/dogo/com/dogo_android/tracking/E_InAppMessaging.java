package app.dogo.com.dogo_android.w;

import kotlin.Metadata;
import kotlin.o;

/* compiled from: Events.kt */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0008\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Lapp/dogo/com/dogo_android/tracking/E$InAppMessaging;", "", "()V", "NegativeFeedbackScore", "Lapp/dogo/com/dogo_android/tracking/Event3;", "Lapp/dogo/com/dogo_android/tracking/EP$FeedbackScore;", "Lapp/dogo/com/dogo_android/tracking/EP$CampaignId;", "Lapp/dogo/com/dogo_android/tracking/EP$CampaignName;", "NormalFeedbackScore", "PositiveFeedbackScore", "ZendeskTicketCreated", "Lapp/dogo/com/dogo_android/tracking/Event0;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: c0, reason: from kotlin metadata */
public final class E_InAppMessaging {

    public static final w2<n1, z0, a1> a;
    public static final w2<n1, z0, a1> b;
    public static final w2<n1, z0, a1> c;
    public static final t2 d;
    static {
        app.dogo.com.dogo_android.w.s2.a companion2 = Event.Companion;
        E_InAppMessaging.a = companion2.a("feedback_score_submitted_positive").d(new EP_FeedbackScore(), new EP_CampaignId(), new EP_CampaignName()).withFacebookEvent(app.dogo.com.dogo_android.tracking.d.a);
        E_InAppMessaging.b = companion2.a("feedback_score_submitted_neutral").d(new EP_FeedbackScore(), new EP_CampaignId(), new EP_CampaignName()).withFacebookEvent(app.dogo.com.dogo_android.tracking.f.a);
        E_InAppMessaging.c = companion2.a("feedback_score_submitted_negative").d(new EP_FeedbackScore(), new EP_CampaignId(), new EP_CampaignName()).withFacebookEvent(app.dogo.com.dogo_android.tracking.e.a);
        E_InAppMessaging.d = companion2.a("zendesk_ticket_created");
    }

    private static final a3 a(o oVar, o oVar2, o oVar3) {
        String oVar22;
        int i = 0;
        int value = 0;
        Object obj2 = oVar2.d();
        oVar22 = "";
        if (obj2 != null) {
            oVar22 = obj2.toString();
            if (oVar22 != null) {
            }
        }
        oVar = oVar.d() instanceof Integer ? (Integer)oVar.d() : 0;
        if (i == 0) {
            value = 0;
        } else {
            value = i.intValue();
        }
        return FBEvent.INSTANCE.rated(oVar22, value);
    }

    private static final a3 b(o oVar, o oVar2, o oVar3) {
        String oVar22;
        int i = 0;
        int value = 0;
        Object obj2 = oVar2.d();
        oVar22 = "";
        if (obj2 != null) {
            oVar22 = obj2.toString();
            if (oVar22 != null) {
            }
        }
        oVar = oVar.d() instanceof Integer ? (Integer)oVar.d() : 0;
        if (i == 0) {
            value = 0;
        } else {
            value = i.intValue();
        }
        return FBEvent.INSTANCE.rated(oVar22, value);
    }

    private static final a3 c(o oVar, o oVar2, o oVar3) {
        String oVar22;
        int i = 0;
        int value = 0;
        Object obj2 = oVar2.d();
        oVar22 = "";
        if (obj2 != null) {
            oVar22 = obj2.toString();
            if (oVar22 != null) {
            }
        }
        oVar = oVar.d() instanceof Integer ? (Integer)oVar.d() : 0;
        if (i == 0) {
            value = 0;
        } else {
            value = i.intValue();
        }
        return FBEvent.INSTANCE.rated(oVar22, value);
    }

    public static /* synthetic */ a3 d(o oVar, o oVar2, o oVar3) {
        return E_InAppMessaging.c(oVar, oVar2, oVar3);
    }

    public static /* synthetic */ a3 e(o oVar, o oVar2, o oVar3) {
        return E_InAppMessaging.a(oVar, oVar2, oVar3);
    }

    public static /* synthetic */ a3 f(o oVar, o oVar2, o oVar3) {
        return E_InAppMessaging.b(oVar, oVar2, oVar3);
    }
}
