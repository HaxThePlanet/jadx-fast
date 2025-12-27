package app.dogo.com.dogo_android.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.com.dogo_android.util.e0.t;
import app.dogo.com.dogo_android.util.h0.j1;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.Exclude;
import com.google.firebase.firestore.ServerTimestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: ChallengeComment.kt */
@Metadata(d1 = "\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\"\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0002\u0008\u0010\u0018\u0000 o2\u00020\u00012\u00020\u0002:\u0002opB\u0007\u0008\u0016¢\u0006\u0002\u0010\u0003BA\u0008\u0016\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0008\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000cB\u000f\u0008\u0014\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fB1\u0008\u0012\u0012\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\u0010\u0014J\u0008\u0010X\u001a\u00020WH\u0016J\u0013\u0010Y\u001a\u0002042\u0008\u0010Z\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\u0012\u0010[\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0011J\u0008\u0010\\\u001a\u0004\u0018\u00010\u0005J\u0006\u0010]\u001a\u00020WJ\u0010\u0010^\u001a\u0002042\u0006\u0010\u0004\u001a\u00020\u0005H\u0007J\u0010\u0010_\u001a\u0002042\u0006\u0010\u0004\u001a\u00020\u0005H\u0007J\u0010\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u000204H\u0007J\u0010\u0010c\u001a\u00020a2\u0006\u0010d\u001a\u00020\u0005H\u0016J\u0012\u0010e\u001a\u00020a2\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007J\u0016\u0010f\u001a\u00020a2\u0006\u0010B\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\u0005J\u0010\u0010h\u001a\u00020a2\u0008\u0010B\u001a\u0004\u0018\u00010\u0005J\u0010\u0010i\u001a\u00020a2\u0006\u0010j\u001a\u00020\u0000H\u0007J\u000e\u0010k\u001a\u00020a2\u0006\u0010V\u001a\u00020WJ\u0018\u0010l\u001a\u00020a2\u0006\u0010m\u001a\u00020\u000e2\u0006\u0010n\u001a\u00020WH\u0016R \u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001aR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001b\u0010\u001c\"\u0004\u0008\u001d\u0010\u001eR$\u0010!\u001a\u0004\u0018\u00010 2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 8\u0006@BX\u0087\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R$\u0010$\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u00058G@BX\u0087\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010\u001cR\"\u0010&\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010\u001cR\u001a\u0010(\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\u0008)\u0010\u001c\"\u0004\u0008*\u0010\u001eR\"\u0010+\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010\u001cR*\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u00058G@GX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008-\u0010\u001c\"\u0004\u0008.\u0010\u001eR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008/\u0010\u001c\"\u0004\u00080\u0010\u001eR\u001c\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005028\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0011\u00103\u001a\u0002048F¢\u0006\u0006\u001a\u0004\u00083\u00105R\u0011\u00106\u001a\u0002048F¢\u0006\u0006\u001a\u0004\u00086\u00105R\u0011\u00107\u001a\u0002048F¢\u0006\u0006\u001a\u0004\u00087\u00105R \u00108\u001a\u0002042\u0006\u0010\u001f\u001a\u0002048G@BX\u0087\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u00088\u00105R\u0011\u00109\u001a\u0002048G¢\u0006\u0006\u001a\u0004\u00089\u00105R&\u0010:\u001a\u0002042\u0006\u0010\u001f\u001a\u0002048G@GX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008:\u00105\"\u0004\u0008;\u0010<R\u001a\u0010=\u001a\u000204X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008=\u00105\"\u0004\u0008>\u0010<R\u0011\u0010?\u001a\u0002048G¢\u0006\u0006\u001a\u0004\u0008?\u00105R&\u0010@\u001a\u0002042\u0006\u0010\u001f\u001a\u0002048G@GX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008@\u00105\"\u0004\u0008A\u0010<R\u0010\u0010B\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010C\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008D\u0010\u001c\"\u0004\u0008E\u0010\u001eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008F\u0010\u001c\"\u0004\u0008G\u0010\u001eR\u001c\u0010H\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008I\u0010\u001c\"\u0004\u0008J\u0010\u001eR\u001c\u0010K\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008L\u0010\u001c\"\u0004\u0008M\u0010\u001eR\u001c\u0010N\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008O\u0010\u001c\"\u0004\u0008P\u0010\u001eR*\u0010Q\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u00058G@GX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008R\u0010\u001c\"\u0004\u0008S\u0010\u001eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008T\u0010\u001c\"\u0004\u0008U\u0010\u001eR\u000e\u0010V\u001a\u00020WX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006q", d2 = {"Lapp/dogo/com/dogo_android/model/ChallengeComment;", "Lapp/dogo/com/dogo_android/util/base_classes/FirestoreCustomObject;", "Landroid/os/Parcelable;", "()V", "userId", "", "message", "entryId", "dog", "Lapp/dogo/com/dogo_android/model/DogProfileModel;", "challengeId", "entryOwnerUserId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/model/DogProfileModel;Ljava/lang/String;Ljava/lang/String;)V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "commentData", "", "", "entryData", "(Ljava/util/Map;Ljava/util/Map;)V", "badges", "", "getBadges", "()Ljava/util/List;", "setBadges", "(Ljava/util/List;)V", "getChallengeId", "()Ljava/lang/String;", "setChallengeId", "(Ljava/lang/String;)V", "<set-?>", "Lcom/google/firebase/Timestamp;", "date", "getDate", "()Lcom/google/firebase/Timestamp;", "documentId", "getDocumentId", "dogAvatarUrl", "getDogAvatarUrl", "dogId", "getDogId", "setDogId", "dogName", "getDogName", "getEntryId", "setEntryId", "getEntryOwnerUserId", "setEntryOwnerUserId", "entryTranslations", "", "isAuthorAdmin", "", "()Z", "isAuthorAmbassador", "isAuthorPremium", "isCaption", "isCommentValid", "isHasUserLiked", "setHasUserLiked", "(Z)V", "isPublished", "setPublished", "isSpam", "isTranslatePressed", "setTranslatePressed", "locale", "marked", "getMarked", "setMarked", "getMessage", "setMessage", "replyDogId", "getReplyDogId", "setReplyDogId", "replyTagName", "getReplyTagName", "setReplyTagName", "replyUserId", "getReplyUserId", "setReplyUserId", "translatedComment", "getTranslatedComment", "setTranslatedComment", "getUserId", "setUserId", "votes", "", "describeContents", "equals", "other", "getEntryTranslations", "getLocale", "getVotes", "isCommentAuthor", "isEntryAuthor", "setCaptionFlag", "", "bool", "setDocumentId", "id", "setEntryAuthor", "setEntryTranslations", "translation", "setLocale", "setReplyTarget", "replyTarget", "setVotes", "writeToParcel", "dest", "flags", "Companion", "MarkTypes", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ChallengeComment implements t, Parcelable {

    public static final Parcelable.Creator<ChallengeComment> CREATOR = new ChallengeComment$Companion$CREATOR$1<>();
    /* renamed from: Companion, reason: from kotlin metadata */
    public static final ChallengeComment.Companion INSTANCE = new ChallengeComment$Companion(0);
    private List<String> badges;
    private String challengeId;
    @ServerTimestamp
    private Timestamp date;
    @Exclude
    private String documentId;
    private String dogAvatarUrl;
    public String dogId;
    private String dogName;
    @Exclude
    private String entryId;
    private String entryOwnerUserId;
    @Exclude
    private final Map<String, String> entryTranslations;
    @Exclude
    private boolean isCaption;
    @Exclude
    private boolean isHasUserLiked;
    private boolean isPublished;
    @Exclude
    private boolean isTranslatePressed;
    private String locale;
    private String marked;
    private String message;
    private String replyDogId;
    private String replyTagName;
    private String replyUserId;
    @Exclude
    private String translatedComment;
    private String userId;
    private int votes;

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00082\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0008H\u0007R\u0016\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/model/ChallengeComment$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lapp/dogo/com/dogo_android/model/ChallengeComment;", "commentParser", "commentData", "", "", "entryData", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
            super();
        }

        @Exclude
        public final ChallengeComment commentParser(Map<String, ? extends Object> commentData, Map<String, ? extends Object> entryData) {
            g gVar = null;
            n.f(commentData, "commentData");
            n.f(entryData, "entryData");
            List list = Arrays.asList(Arrays.copyOf(new String[] { "dogId", "id", "message", "userId" }, 4));
            str = "asList(*mandatoryCommentArray)";
            n.e(list, str);
            gVar = null;
            if (commentData.keySet().containsAll(list)) {
                List list2 = Arrays.asList(Arrays.copyOf(new String[] { "challengeId", "entryOwnerUserId", "entryId" }, 3));
                str = "asList(*mandatoryEntryArray)";
                n.e(list2, str);
                if (entryData.keySet().containsAll(list2)) {
                }
            }
            return gVar;
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0007\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008j\u0002\u0008\t¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/model/ChallengeComment$MarkTypes;", "", "identifier", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getIdentifier", "()Ljava/lang/String;", "setIdentifier", "(Ljava/lang/String;)V", "SPAM", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum MarkTypes {

        SPAM;

        private String identifier;
        @Override // java.lang.Enum
        public final String getIdentifier() {
            return this.identifier;
        }

        @Override // java.lang.Enum
        public final void setIdentifier(String str) {
            n.f(str, "<set-?>");
            this.identifier = str;
        }

        private static final /* synthetic */ ChallengeComment.MarkTypes[] $values() {
            app.dogo.com.dogo_android.model.ChallengeComment.MarkTypes[] arr = new ChallengeComment.MarkTypes[1];
            return new ChallengeComment.MarkTypes[] { ChallengeComment_MarkTypes.SPAM };
        }
    }

    public ChallengeComment() {
        super();
        this.badges = new ArrayList();
        this.entryTranslations = new HashMap();
    }

    @Override // java.lang.Object
    /* operator */ public boolean equals(Object other) {
        boolean z;
        boolean z2 = false;
        z = other instanceof ChallengeComment;
        int i = 0;
        if (other instanceof ChallengeComment) {
            if (n.b(this.userId, other.userId)) {
                if (n.b(this.message, other.message)) {
                    if (n.b(this.entryId, other.entryId)) {
                        if (n.b(getDogId(), other.getDogId()) && other.date != null && this.date == other.date) {
                            int i2 = 1;
                        }
                    }
                }
            }
        }
        return z2;
    }

    public final List<String> getBadges() {
        return this.badges;
    }

    public final String getChallengeId() {
        return this.challengeId;
    }

    public final Timestamp getDate() {
        return this.date;
    }

    @Exclude
    public final String getDocumentId() {
        return this.documentId;
    }

    public final String getDogAvatarUrl() {
        return this.dogAvatarUrl;
    }

    public final String getDogId() {
        if (this.dogId == null) {
            n.w("dogId");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            return this.dogId;
        }
    }

    public final String getDogName() {
        return this.dogName;
    }

    @Exclude
    public final String getEntryId() {
        return this.entryId;
    }

    public final String getEntryOwnerUserId() {
        return this.entryOwnerUserId;
    }

    public final Map<String, String> getEntryTranslations() {
        return this.entryTranslations;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getMarked() {
        return this.marked;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getReplyDogId() {
        return this.replyDogId;
    }

    public final String getReplyTagName() {
        return this.replyTagName;
    }

    public final String getReplyUserId() {
        return this.replyUserId;
    }

    @Exclude
    public final String getTranslatedComment() {
        return this.translatedComment;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final int getVotes() {
        return this.votes;
    }

    public final boolean isAuthorAdmin() {
        return n.b(app.dogo.com.dogo_android.util.extensionfunction.j1.s(this), "admin");
    }

    public final boolean isAuthorAmbassador() {
        return n.b(app.dogo.com.dogo_android.util.extensionfunction.j1.s(this), "ambassador");
    }

    public final boolean isAuthorPremium() {
        return n.b(app.dogo.com.dogo_android.util.extensionfunction.j1.s(this), "premium");
    }

    @Exclude
    public final boolean isCaption() {
        return this.isCaption;
    }

    @Exclude
    public final boolean isCommentAuthor(String userId) {
        n.f(userId, "userId");
        return n.b(this.userId, userId);
    }

    @Exclude
    public final boolean isCommentValid() {
        String userId2;
        int i;
        boolean z = true;
        i = 0;
        if (this.userId != null) {
            n.d(this.userId);
            int r0 = this.userId.length() == 0 ? 1 : i;
            if (this.userId != 0 || this.message == null || this.challengeId == null || this.entryOwnerUserId == null) {
            }
        }
        return z;
    }

    @Exclude
    public final boolean isEntryAuthor(String userId) {
        n.f(userId, "userId");
        return n.b(userId, this.entryOwnerUserId);
    }

    @Exclude
    public final boolean isHasUserLiked() {
        return this.isHasUserLiked;
    }

    public final boolean isPublished() {
        return this.isPublished;
    }

    @Exclude
    public final boolean isSpam() {
        boolean z = false;
        String identifier;
        if (!this.isPublished) {
            int r0 = n.b(this.marked, ChallengeComment_MarkTypes.SPAM.getIdentifier()) ? 1 : 0;
        }
        return (n.b(this.marked, ChallengeComment_MarkTypes.SPAM.getIdentifier()) ? 1 : 0);
    }

    @Exclude
    public final boolean isTranslatePressed() {
        return this.isTranslatePressed;
    }

    public final void setBadges(List<String> list) {
        n.f(list, "<set-?>");
        this.badges = list;
    }

    @Exclude
    public final void setCaptionFlag(boolean bool) {
        this.isCaption = bool;
    }

    public final void setChallengeId(String str) {
        this.challengeId = str;
    }

    public void setDocumentId(String id) {
        n.f(id, "id");
        this.documentId = id;
    }

    public final void setDogId(String str) {
        n.f(str, "<set-?>");
        this.dogId = str;
    }

    @Exclude
    public final void setEntryAuthor(String userId) {
        this.entryOwnerUserId = userId;
    }

    @Exclude
    public final void setEntryId(String str) {
        this.entryId = str;
    }

    public final void setEntryOwnerUserId(String str) {
        this.entryOwnerUserId = str;
    }

    public final void setEntryTranslations(String locale, String translation) {
        n.f(locale, "locale");
        n.f(translation, "translation");
        this.entryTranslations.put(locale, translation);
    }

    @Exclude
    public final void setHasUserLiked(boolean z) {
        this.isHasUserLiked = z;
    }

    public final void setLocale(String locale) {
        String str;
        boolean z;
        if (locale != null) {
            str = "en";
            if (n.b(locale, str)) {
                this.locale = str;
            } else {
                this.locale = locale;
            }
        }
    }

    public final void setMarked(String str) {
        this.marked = str;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final void setPublished(boolean z) {
        this.isPublished = z;
    }

    public final void setReplyDogId(String str) {
        this.replyDogId = str;
    }

    public final void setReplyTagName(String str) {
        this.replyTagName = str;
    }

    @Exclude
    public final void setReplyTarget(ChallengeComment replyTarget) {
        n.f(replyTarget, "replyTarget");
        this.replyDogId = replyTarget.getDogId();
        this.replyTagName = replyTarget.dogName;
        this.replyUserId = replyTarget.userId;
    }

    public final void setReplyUserId(String str) {
        this.replyUserId = str;
    }

    @Exclude
    public final void setTranslatePressed(boolean z) {
        this.isTranslatePressed = z;
    }

    @Exclude
    public final void setTranslatedComment(String str) {
        this.translatedComment = str;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public final void setVotes(int votes) {
        int i = 0;
        if (votes < 0) {
            i = 0;
        }
        this.votes = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        n.f(dest, "dest");
        dest.writeString(this.dogAvatarUrl);
        dest.writeString(getDogId());
        dest.writeString(this.dogName);
        dest.writeString(this.userId);
        dest.writeString(this.replyTagName);
        dest.writeString(this.message);
        dest.writeString(this.replyUserId);
        dest.writeString(this.replyDogId);
        dest.writeString(this.challengeId);
        dest.writeInt(this.votes);
        dest.writeString(this.entryId);
        dest.writeByte(this.isHasUserLiked != 0 ? 1 : 0);
        dest.writeByte(this.isPublished != 0 ? 1 : 0);
        dest.writeParcelable(this.date, flags);
        dest.writeString(this.documentId);
        dest.writeByte(this.isCaption != 0 ? 1 : 0);
        dest.writeString(this.entryOwnerUserId);
        dest.writeString(this.locale);
    }

    public ChallengeComment(String str, String str2, String str3, DogProfileModel dogProfileModel, String str4, String str5) {
        n.f(dogProfileModel, "dog");
        super();
        this.badges = new ArrayList();
        this.entryTranslations = new HashMap();
        this.userId = str;
        this.entryId = str3;
        this.message = str2;
        setDogId(dogProfileModel.getId());
        this.dogAvatarUrl = dogProfileModel.getAvatar();
        this.dogName = dogProfileModel.getName();
        this.challengeId = str4;
        this.entryOwnerUserId = str5;
    }

    protected ChallengeComment(Parcel parcel) {
        int i;
        n.f(parcel, "in");
        super();
        this.badges = new ArrayList();
        this.entryTranslations = new HashMap();
        this.dogAvatarUrl = parcel.readString();
        String string2 = parcel.readString();
        Objects.requireNonNull(string2);
        setDogId(string2);
        String string3 = parcel.readString();
        Objects.requireNonNull(string3);
        this.dogName = string3;
        this.userId = parcel.readString();
        this.replyTagName = parcel.readString();
        this.message = parcel.readString();
        this.replyUserId = parcel.readString();
        this.replyDogId = parcel.readString();
        this.challengeId = parcel.readString();
        this.votes = parcel.readInt();
        String string10 = parcel.readString();
        Objects.requireNonNull(string10);
        this.entryId = string10;
        i = 1;
        i = 0;
        int r0 = i;
        this.isHasUserLiked = i;
        r0 = i;
        this.isPublished = i;
        this.date = (Timestamp)i;
        this.documentId = i;
        if (parcel.readByte() == 0) {
        }
        this.isCaption = i;
        this.entryOwnerUserId = parcel.readString();
        this.locale = parcel.readString();
    }

    private ChallengeComment(Map<String, ? extends Object> map, Map<String, ? extends Object> map2) {
        Timestamp timestamp;
        int value = 1;
        Object value3;
        super();
        this.badges = new ArrayList();
        this.entryTranslations = new HashMap();
        this.dogAvatarUrl = (String)map.get("dogAvatarUrl");
        str2 = "votes";
        if (map.get("date") != null) {
            Object value14 = map.get(str2);
        } else {
            timestamp = new Timestamp(new Date());
        }
        this.date = timestamp;
        Object value6 = map.get("dogId");
        String str13 = "null cannot be cast to non-null type kotlin.String";
        Objects.requireNonNull(value6, str13);
        setDogId(value6);
        Object value7 = map.get("dogName");
        Objects.requireNonNull(value7, str13);
        this.dogName = value7;
        Object value8 = map.get("id");
        Objects.requireNonNull(value8, str13);
        this.documentId = value8;
        this.message = (String)map.get("message");
        str = "published";
        value = 0;
        if (map.get(str) != null) {
            Object value13 = map.get(str);
            Objects.requireNonNull(value13, "null cannot be cast to non-null type kotlin.Boolean");
            int r0 = value13.booleanValue() ? 1 : 0;
        }
        this.isPublished = (value13.booleanValue() ? 1 : 0);
        this.userId = (String)(value13.booleanValue() ? 1 : 0);
        if (map.get(str2) != null) {
            Object value2 = map.get(str2);
            str2 = "null cannot be cast to non-null type kotlin.Int";
            Objects.requireNonNull(value2, str2);
            value = value2.intValue();
        }
        this.votes = value;
        this.replyDogId = (String)map.get("replyDogId");
        this.replyTagName = (String)map.get("replyTagName");
        this.replyUserId = (String)map.get("replyUserId");
        this.entryOwnerUserId = (String)map2.get("entryOwnerUserId");
        this.challengeId = (String)map2.get("challengeId");
        Object value18 = map2.get("entryId");
        Objects.requireNonNull(value18, "null cannot be cast to non-null type kotlin.String");
        this.entryId = value18;
    }

    public /* synthetic */ ChallengeComment(Map map, Map map2, g gVar) {
        this(map, map2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
