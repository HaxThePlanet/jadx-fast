package app.dogo.com.dogo_android.d.c.j;

import app.dogo.com.dogo_android.model.ChallengeNotificationModel;
import app.dogo.com.dogo_android.model.ChallengeNotificationModel.EntryImageObject;
import app.dogo.com.dogo_android.model.ChallengeNotificationModel.MiniCommentObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.z.a;

/* compiled from: ChallengeNotificationItemModel.kt */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\u0008J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u0005J\u0006\u0010\u0012\u001a\u00020\u0005J\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0014\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u0005J\u0010\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0002J\u0010\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\nH\u0002J\u0006\u0010\u0019\u001a\u00020\u0005J\u0006\u0010\u001a\u001a\u00020\u0005J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\u001cJ\u0006\u0010\u001f\u001a\u00020\u001cJ\u0006\u0010 \u001a\u00020\u001cJ\u000e\u0010!\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u0003R\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000c\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/challenge/notificationcenter/notificationlist/ChallengeNotificationItemModel;", "", "model", "Lapp/dogo/com/dogo_android/model/ChallengeNotificationModel;", "userId", "", "ambassadorList", "", "(Lapp/dogo/com/dogo_android/model/ChallengeNotificationModel;Ljava/lang/String;Ljava/util/Set;)V", "orderedEntryImages", "", "Lapp/dogo/com/dogo_android/model/ChallengeNotificationModel$EntryImageObject;", "orderedUniqueComments", "Lapp/dogo/com/dogo_android/model/ChallengeNotificationModel$MiniCommentObject;", "getAdditionalVotes", "", "getAdditionalVotesString", "getCommenterDogNamesList", "getFirstDogAvatar", "getLastCommentDogName", "getModel", "getMostRecentCommentMessage", "getMostRecentEntryImage", "getOrderedEntryImages", "getOrderedUniqueComments", "getSecondDogAvatar", "getVotes", "isLastCommentReplyToUser", "", "isMostRecentCommentAnAmbassadorDog", "isMultipleDogsMode", "isNotificationActive", "isUserEntriesAuthor", "setModel", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: b, reason: from kotlin metadata */
public final class ChallengeNotificationItemModel {

    /* renamed from: a, reason: from kotlin metadata */
    private final String ambassadorList;
    /* renamed from: b, reason: from kotlin metadata */
    private final Set<String> model;
    /* renamed from: c, reason: from kotlin metadata */
    private ChallengeNotificationModel orderedEntryImages;
    /* renamed from: d, reason: from kotlin metadata */
    private List<ChallengeNotificationModel.EntryImageObject> orderedUniqueComments;
    /* renamed from: e, reason: from kotlin metadata */
    private List<ChallengeNotificationModel.MiniCommentObject> userId;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 5, 1})
    public static final class b<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return a.c(t2.getCreatedAt(), t.getCreatedAt());
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/model/ChallengeNotificationModel$MiniCommentObject;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends kotlin.d0.d.p implements l<ChallengeNotificationModel.MiniCommentObject, java.lang.CharSequence> {

        public static final b.a a = new b$a();
        @Override // kotlin.d0.d.p
        public final java.lang.CharSequence a(ChallengeNotificationModel.MiniCommentObject miniCommentObject) {
            n.f(miniCommentObject, "it");
            final String dogName = miniCommentObject.getDogName();
            n.d(dogName);
            return dogName;
        }


        a() {
            super(1);
        }
    }
    public b(ChallengeNotificationModel challengeNotificationModel, String str, Set<String> set) {
        n.f(challengeNotificationModel, "model");
        n.f(str, "userId");
        n.f(set, "ambassadorList");
        super();
        this.ambassadorList = str;
        this.model = set;
        this.orderedEntryImages = challengeNotificationModel;
        this.orderedUniqueComments = getAdditionalVotes();
        this.userId = j();
    }

    /* renamed from: i, reason: from kotlin metadata */
    private final List<ChallengeNotificationModel.EntryImageObject> getAdditionalVotes() {
        int i = 0;
        Map entryImages = this.orderedEntryImages.getEntryImages();
        i = 0;
        if (entryImages != null) {
            Collection values = entryImages.values();
            if (values != null) {
                List list = p.D0(values, new app.dogo.com.dogo_android.challenge.notificationcenter.notificationlist.b.b());
            }
        }
        return i;
    }

    private final List<ChallengeNotificationModel.MiniCommentObject> j() {
        int i = 0;
        boolean z;
        List comments = this.orderedEntryImages.getComments();
        i = 0;
        if (comments != null) {
            comments = p.x0(comments);
            if (comments != null) {
                Iterator it = comments.iterator();
                while (it.hasNext()) {
                    Object item = it.next();
                }
            }
        }
        return i;
    }

    public final int a() {
        int value = 0;
        Integer newEntryVotes = this.orderedEntryImages.getNewEntryVotes();
        if (newEntryVotes == null) {
            value = 0;
        } else {
            value = newEntryVotes.intValue();
        }
        return value;
    }

    public final String b() {
        int value = 0;
        String str;
        Integer newEntryVotes = this.orderedEntryImages.getNewEntryVotes();
        if (newEntryVotes == null) {
            value = 0;
        } else {
            value = newEntryVotes.intValue();
        }
        if (this.orderedEntryImages > 0) {
            str2 = "+";
            str = n.o(str2, this.orderedEntryImages.getNewEntryVotes());
        } else {
            str = "";
        }
        return str;
    }

    public final String c() {
        String str;
        int i2 = 0;
        str = "";
        if (this.userId != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.userId.iterator();
            while (it.hasNext()) {
                Object item = it.next();
                String dogName = (ChallengeNotificationModel_MiniCommentObject)item.getDogName();
                i2 = 1;
                i = i2 ^ i2;
            }
            java.lang.CharSequence charSequence = null;
            java.lang.CharSequence charSequence2 = null;
            java.lang.CharSequence charSequence3 = null;
            int i3 = 0;
            java.lang.CharSequence charSequence4 = null;
            int i4 = 31;
            Object obj = null;
            str = p.h0(arrayList, charSequence, charSequence2, charSequence3, i3, charSequence4, app.dogo.com.dogo_android.challenge.notificationcenter.notificationlist.b.a.a, i4, obj);
            if (str != null) {
            }
        }
        return str;
    }

    public final String d() {
        String dogAvatarUrl;
        dogAvatarUrl = "";
        if (this.userId != null) {
            int i = 0;
            Object obj = p.a0(this.userId, i);
            if (obj != null) {
                dogAvatarUrl = obj.getDogAvatarUrl();
                if (dogAvatarUrl != null) {
                }
            }
        }
        return dogAvatarUrl;
    }

    public final String e() {
        int i = 0;
        i = 0;
        if (this.userId != null) {
            int i2 = 0;
            Object obj = p.a0(this.userId, i2);
            if (obj != null) {
                String dogName = obj.getDogName();
            }
        }
        return i;
    }

    public final ChallengeNotificationModel f() {
        return this.orderedEntryImages;
    }

    public final String g() {
        String message;
        message = "";
        if (this.userId != null) {
            int i = 0;
            Object obj = p.a0(this.userId, i);
            if (obj != null) {
                message = obj.getMessage();
                if (message != null) {
                }
            }
        }
        return message;
    }

    public final String h() {
        Object obj;
        int i = 0;
        i = 0;
        if (this.orderedUniqueComments != null) {
            int i2 = 0;
            obj = p.a0(this.orderedUniqueComments, i2);
            if (obj != null) {
                String imageUrl_320 = obj.getImageUrl_320();
            }
        }
        if (i == 0) {
            if (this.orderedEntryImages.getEntryImageUrl_320() == null) {
                String str = "";
            }
        }
        return i;
    }

    public final String k() {
        int size = 0;
        String dogAvatarUrl;
        if (this.userId == null) {
            size = 0;
        } else {
            size = this.userId.size();
        }
        final int i = 1;
        dogAvatarUrl = "";
        return dogAvatarUrl;
    }

    public final String l() {
        return String.valueOf(this.orderedEntryImages.getEntryVotes());
    }

    public final boolean m() {
        String replyUserId = null;
        int i2 = 0;
        if (this.userId != null) {
            int i = 0;
            Object obj = p.a0(this.userId, i);
            if (obj != null) {
                replyUserId = obj.getReplyUserId();
            }
        }
        return n.b(replyUserId, this.ambassadorList);
    }

    public final boolean n() {
        String dogId = null;
        int i2 = 0;
        if (this.userId != null) {
            int i = 0;
            Object obj = p.a0(this.userId, i);
            if (obj != null) {
                dogId = obj.getDogId();
            }
        }
        return p.N(this.model, dogId);
    }

    public final boolean o() {
        int size;
        boolean z2 = false;
        int i;
        size = 0;
        size = 1;
        if (this.userId == null) {
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.userId.iterator();
            while (it.hasNext()) {
                Object item = it.next();
                String dogAvatarUrl = (ChallengeNotificationModel_MiniCommentObject)item.getDogAvatarUrl();
                i = size ^ size;
            }
            size = arrayList.size();
        }
        if (this.userId > size && !this.m()) {
        }
        return z2;
    }

    public final boolean p() {
        boolean booleanValue = false;
        Boolean active = this.orderedEntryImages.isActive();
        if (active == null) {
            int i = 0;
        } else {
            booleanValue = active.booleanValue();
        }
        return booleanValue;
    }

    public final boolean q() {
        return n.b(this.orderedEntryImages.getEntryOwnerUserId(), this.ambassadorList);
    }
}
