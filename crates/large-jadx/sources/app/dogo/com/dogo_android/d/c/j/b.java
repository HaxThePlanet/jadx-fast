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
import kotlin.d0.d.p;
import kotlin.y.p;
import kotlin.z.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\u0008J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u0005J\u0006\u0010\u0012\u001a\u00020\u0005J\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0014\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u0005J\u0010\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0002J\u0010\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\nH\u0002J\u0006\u0010\u0019\u001a\u00020\u0005J\u0006\u0010\u001a\u001a\u00020\u0005J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\u001cJ\u0006\u0010\u001f\u001a\u00020\u001cJ\u0006\u0010 \u001a\u00020\u001cJ\u000e\u0010!\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u0003R\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000c\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/challenge/notificationcenter/notificationlist/ChallengeNotificationItemModel;", "", "model", "Lapp/dogo/com/dogo_android/model/ChallengeNotificationModel;", "userId", "", "ambassadorList", "", "(Lapp/dogo/com/dogo_android/model/ChallengeNotificationModel;Ljava/lang/String;Ljava/util/Set;)V", "orderedEntryImages", "", "Lapp/dogo/com/dogo_android/model/ChallengeNotificationModel$EntryImageObject;", "orderedUniqueComments", "Lapp/dogo/com/dogo_android/model/ChallengeNotificationModel$MiniCommentObject;", "getAdditionalVotes", "", "getAdditionalVotesString", "getCommenterDogNamesList", "getFirstDogAvatar", "getLastCommentDogName", "getModel", "getMostRecentCommentMessage", "getMostRecentEntryImage", "getOrderedEntryImages", "getOrderedUniqueComments", "getSecondDogAvatar", "getVotes", "isLastCommentReplyToUser", "", "isMostRecentCommentAnAmbassadorDog", "isMultipleDogsMode", "isNotificationActive", "isUserEntriesAuthor", "setModel", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class b {

    private final String a;
    private final Set<String> b;
    private ChallengeNotificationModel c;
    private List<ChallengeNotificationModel.EntryImageObject> d;
    private List<ChallengeNotificationModel.MiniCommentObject> e;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 5, 1})
    public static final class b implements Comparator {
        public final int compare(T t, T t2) {
            return a.c((ChallengeNotificationModel.EntryImageObject)t2.getCreatedAt(), (ChallengeNotificationModel.EntryImageObject)t.getCreatedAt());
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/model/ChallengeNotificationModel$MiniCommentObject;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<ChallengeNotificationModel.MiniCommentObject, java.lang.CharSequence> {

        public static final app.dogo.com.dogo_android.d.c.j.b.a a;
        static {
            b.a aVar = new b.a();
            b.a.a = aVar;
        }

        a() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final java.lang.CharSequence a(ChallengeNotificationModel.MiniCommentObject challengeNotificationModel$MiniCommentObject) {
            n.f(miniCommentObject, "it");
            final String obj2 = miniCommentObject.getDogName();
            n.d(obj2);
            return obj2;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((ChallengeNotificationModel.MiniCommentObject)object);
        }
    }
    public b(ChallengeNotificationModel challengeNotificationModel, String string2, Set<String> set3) {
        n.f(challengeNotificationModel, "model");
        n.f(string2, "userId");
        n.f(set3, "ambassadorList");
        super();
        this.a = string2;
        this.b = set3;
        this.c = challengeNotificationModel;
        this.d = i();
        this.e = j();
    }

    private final List<ChallengeNotificationModel.EntryImageObject> i() {
        Object entryImages;
        int i;
        entryImages = this.c.getEntryImages();
        i = 0;
        if (entryImages == null) {
        } else {
            entryImages = entryImages.values();
            if (entryImages == null) {
            } else {
                b.b bVar = new b.b();
                i = p.D0(entryImages, bVar);
            }
        }
        return i;
    }

    private final List<ChallengeNotificationModel.MiniCommentObject> j() {
        Object comments;
        int arrayList;
        boolean next;
        boolean z;
        HashSet hashSet = new HashSet();
        comments = this.c.getComments();
        arrayList = 0;
        if (comments == null) {
        } else {
            comments = p.x0(comments);
            if (comments == null) {
            } else {
                arrayList = new ArrayList();
                comments = comments.iterator();
                while (comments.hasNext()) {
                    next = comments.next();
                    if (hashSet.add((ChallengeNotificationModel.MiniCommentObject)next.getDogId())) {
                    }
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public final int a() {
        int intValue;
        Integer newEntryVotes = this.c.getNewEntryVotes();
        if (newEntryVotes == null) {
            intValue = 0;
        } else {
            intValue = newEntryVotes.intValue();
        }
        return intValue;
    }

    public final String b() {
        int intValue;
        String str2;
        String str;
        Integer newEntryVotes = this.c.getNewEntryVotes();
        if (newEntryVotes == null) {
            intValue = 0;
        } else {
            intValue = newEntryVotes.intValue();
        }
        if (intValue > 0) {
            str2 = n.o("+", this.c.getNewEntryVotes());
        } else {
            str2 = "";
        }
        return str2;
    }

    public final String c() {
        Object list;
        String str;
        ArrayList arrayList;
        int next;
        int i4;
        int i2;
        String dogName;
        int i6;
        int i3;
        int i7;
        app.dogo.com.dogo_android.d.c.j.b.a aVar;
        int i5;
        int i;
        list = this.e;
        str = "";
        if (list == null) {
        } else {
            arrayList = new ArrayList();
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                dogName = (ChallengeNotificationModel.MiniCommentObject)next.getDogName();
                i6 = 1;
                if (dogName != null) {
                } else {
                }
                i2 = i6;
                if (i2 ^= i6 != 0) {
                }
                arrayList.add(next);
                if (dogName.length() == 0) {
                } else {
                }
                i2 = 0;
            }
            list = p.h0(arrayList, 0, 0, 0, 0, 0, b.a.a, 31, 0);
            if (list == null) {
            } else {
                str = list;
            }
        }
        return str;
    }

    public final String d() {
        Object dogAvatarUrl;
        String str;
        int i;
        dogAvatarUrl = this.e;
        str = "";
        if (dogAvatarUrl == null) {
        } else {
            dogAvatarUrl = p.a0(dogAvatarUrl, 0);
            if ((ChallengeNotificationModel.MiniCommentObject)dogAvatarUrl == null) {
            } else {
                dogAvatarUrl = (ChallengeNotificationModel.MiniCommentObject)dogAvatarUrl.getDogAvatarUrl();
                if (dogAvatarUrl == null) {
                } else {
                    str = dogAvatarUrl;
                }
            }
        }
        return str;
    }

    public final String e() {
        Object list;
        int dogName;
        int i;
        list = this.e;
        dogName = 0;
        if (list == null) {
        } else {
            list = p.a0(list, 0);
            if ((ChallengeNotificationModel.MiniCommentObject)list == null) {
            } else {
                dogName = (ChallengeNotificationModel.MiniCommentObject)list.getDogName();
            }
        }
        return dogName;
    }

    public final ChallengeNotificationModel f() {
        return this.c;
    }

    public final String g() {
        Object message;
        String str;
        int i;
        message = this.e;
        str = "";
        if (message == null) {
        } else {
            message = p.a0(message, 0);
            if ((ChallengeNotificationModel.MiniCommentObject)message == null) {
            } else {
                message = (ChallengeNotificationModel.MiniCommentObject)message.getMessage();
                if (message == null) {
                } else {
                    str = message;
                }
            }
        }
        return str;
    }

    public final String h() {
        Object list;
        int str;
        int i;
        list = this.d;
        str = 0;
        if (list == null) {
        } else {
            list = p.a0(list, 0);
            if ((ChallengeNotificationModel.EntryImageObject)list == null) {
            } else {
                str = (ChallengeNotificationModel.EntryImageObject)list.getImageUrl_320();
            }
        }
        if (str == null && this.c.getEntryImageUrl_320() == null) {
            if (this.c.getEntryImageUrl_320() == null) {
                str = "";
            }
        }
        return str;
    }

    public final String k() {
        int dogAvatarUrl;
        String str;
        List list = this.e;
        if (list == null) {
            dogAvatarUrl = 0;
        } else {
            dogAvatarUrl = list.size();
        }
        final int i = 1;
        str = "";
        if (dogAvatarUrl > i) {
            dogAvatarUrl = this.e;
            if (dogAvatarUrl == null) {
            } else {
                dogAvatarUrl = p.a0(dogAvatarUrl, i);
                if ((ChallengeNotificationModel.MiniCommentObject)dogAvatarUrl == null) {
                } else {
                    dogAvatarUrl = (ChallengeNotificationModel.MiniCommentObject)dogAvatarUrl.getDogAvatarUrl();
                    if (dogAvatarUrl == null) {
                    } else {
                        str = dogAvatarUrl;
                    }
                }
            }
        }
        return str;
    }

    public final String l() {
        return String.valueOf(this.c.getEntryVotes());
    }

    public final boolean m() {
        Object list;
        int replyUserId;
        int i;
        list = this.e;
        replyUserId = 0;
        if (list == null) {
        } else {
            list = p.a0(list, 0);
            if ((ChallengeNotificationModel.MiniCommentObject)list == null) {
            } else {
                replyUserId = (ChallengeNotificationModel.MiniCommentObject)list.getReplyUserId();
            }
        }
        return n.b(replyUserId, this.a);
    }

    public final boolean n() {
        Object list;
        int dogId;
        int i;
        list = this.e;
        dogId = 0;
        if (list == null) {
        } else {
            list = p.a0(list, 0);
            if ((ChallengeNotificationModel.MiniCommentObject)list == null) {
            } else {
                dogId = (ChallengeNotificationModel.MiniCommentObject)list.getDogId();
            }
        }
        return p.N(this.b, dogId);
    }

    public final boolean o() {
        int size;
        int i3;
        ArrayList arrayList;
        boolean next;
        int i;
        int i2;
        String dogAvatarUrl;
        List list = this.e;
        i3 = 0;
        final int i4 = 1;
        if (list == null) {
            size = i3;
        } else {
            arrayList = new ArrayList();
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                dogAvatarUrl = (ChallengeNotificationModel.MiniCommentObject)next.getDogAvatarUrl();
                if (dogAvatarUrl != null) {
                } else {
                }
                i2 = i4;
                if (i2 ^= i4 != 0) {
                }
                arrayList.add(next);
                if (dogAvatarUrl.length() == 0) {
                } else {
                }
                i2 = i3;
            }
            size = arrayList.size();
        }
        if (size > i4 && !m()) {
            if (!m()) {
                i3 = i4;
            }
        }
        return i3;
    }

    public final boolean p() {
        int booleanValue;
        Boolean active = this.c.isActive();
        if (active == null) {
            booleanValue = 0;
        } else {
            booleanValue = active.booleanValue();
        }
        return booleanValue;
    }

    public final boolean q() {
        return n.b(this.c.getEntryOwnerUserId(), this.a);
    }
}
