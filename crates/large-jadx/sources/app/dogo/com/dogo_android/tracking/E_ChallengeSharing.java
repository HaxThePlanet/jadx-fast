package app.dogo.com.dogo_android.w;

import kotlin.Metadata;

/* compiled from: Events.kt */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/tracking/E$ChallengeSharing;", "", "()V", "OpenSharedLink", "Lapp/dogo/com/dogo_android/tracking/Event2;", "Lapp/dogo/com/dogo_android/tracking/EP$EntryId;", "Lapp/dogo/com/dogo_android/tracking/EP$ChallengeId;", "ShareInstagram", "SharePhoto", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: t, reason: from kotlin metadata */
public final class E_ChallengeSharing {

    public static final v2<i1, c1> a;
    public static final v2<i1, c1> b;
    public static final v2<i1, c1> c;
    static {
        app.dogo.com.dogo_android.w.s2.a iNSTANCE2 = Event.INSTANCE;
        E_ChallengeSharing.a = iNSTANCE2.of("shared_challenge_photo").c(new EP_EntryId(), new EP_ChallengeId());
        E_ChallengeSharing.b = iNSTANCE2.of("shared_challenge_photo_on_instagram").c(new EP_EntryId(), new EP_ChallengeId());
        E_ChallengeSharing.c = iNSTANCE2.of("shared_challenge_photo_opened").c(new EP_EntryId(), new EP_ChallengeId());
    }
}
