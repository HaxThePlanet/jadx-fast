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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\"\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0002\u0008\u0010\u0018\u0000 o2\u00020\u00012\u00020\u0002:\u0002opB\u0007\u0008\u0016¢\u0006\u0002\u0010\u0003BA\u0008\u0016\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0008\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000cB\u000f\u0008\u0014\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fB1\u0008\u0012\u0012\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\u0010\u0014J\u0008\u0010X\u001a\u00020WH\u0016J\u0013\u0010Y\u001a\u0002042\u0008\u0010Z\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\u0012\u0010[\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0011J\u0008\u0010\\\u001a\u0004\u0018\u00010\u0005J\u0006\u0010]\u001a\u00020WJ\u0010\u0010^\u001a\u0002042\u0006\u0010\u0004\u001a\u00020\u0005H\u0007J\u0010\u0010_\u001a\u0002042\u0006\u0010\u0004\u001a\u00020\u0005H\u0007J\u0010\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u000204H\u0007J\u0010\u0010c\u001a\u00020a2\u0006\u0010d\u001a\u00020\u0005H\u0016J\u0012\u0010e\u001a\u00020a2\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007J\u0016\u0010f\u001a\u00020a2\u0006\u0010B\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\u0005J\u0010\u0010h\u001a\u00020a2\u0008\u0010B\u001a\u0004\u0018\u00010\u0005J\u0010\u0010i\u001a\u00020a2\u0006\u0010j\u001a\u00020\u0000H\u0007J\u000e\u0010k\u001a\u00020a2\u0006\u0010V\u001a\u00020WJ\u0018\u0010l\u001a\u00020a2\u0006\u0010m\u001a\u00020\u000e2\u0006\u0010n\u001a\u00020WH\u0016R \u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001aR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001b\u0010\u001c\"\u0004\u0008\u001d\u0010\u001eR$\u0010!\u001a\u0004\u0018\u00010 2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 8\u0006@BX\u0087\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R$\u0010$\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u00058G@BX\u0087\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010\u001cR\"\u0010&\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010\u001cR\u001a\u0010(\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\u0008)\u0010\u001c\"\u0004\u0008*\u0010\u001eR\"\u0010+\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010\u001cR*\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u00058G@GX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008-\u0010\u001c\"\u0004\u0008.\u0010\u001eR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008/\u0010\u001c\"\u0004\u00080\u0010\u001eR\u001c\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005028\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0011\u00103\u001a\u0002048F¢\u0006\u0006\u001a\u0004\u00083\u00105R\u0011\u00106\u001a\u0002048F¢\u0006\u0006\u001a\u0004\u00086\u00105R\u0011\u00107\u001a\u0002048F¢\u0006\u0006\u001a\u0004\u00087\u00105R \u00108\u001a\u0002042\u0006\u0010\u001f\u001a\u0002048G@BX\u0087\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u00088\u00105R\u0011\u00109\u001a\u0002048G¢\u0006\u0006\u001a\u0004\u00089\u00105R&\u0010:\u001a\u0002042\u0006\u0010\u001f\u001a\u0002048G@GX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008:\u00105\"\u0004\u0008;\u0010<R\u001a\u0010=\u001a\u000204X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008=\u00105\"\u0004\u0008>\u0010<R\u0011\u0010?\u001a\u0002048G¢\u0006\u0006\u001a\u0004\u0008?\u00105R&\u0010@\u001a\u0002042\u0006\u0010\u001f\u001a\u0002048G@GX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008@\u00105\"\u0004\u0008A\u0010<R\u0010\u0010B\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010C\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008D\u0010\u001c\"\u0004\u0008E\u0010\u001eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008F\u0010\u001c\"\u0004\u0008G\u0010\u001eR\u001c\u0010H\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008I\u0010\u001c\"\u0004\u0008J\u0010\u001eR\u001c\u0010K\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008L\u0010\u001c\"\u0004\u0008M\u0010\u001eR\u001c\u0010N\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008O\u0010\u001c\"\u0004\u0008P\u0010\u001eR*\u0010Q\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u00058G@GX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008R\u0010\u001c\"\u0004\u0008S\u0010\u001eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008T\u0010\u001c\"\u0004\u0008U\u0010\u001eR\u000e\u0010V\u001a\u00020WX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006q", d2 = {"Lapp/dogo/com/dogo_android/model/ChallengeComment;", "Lapp/dogo/com/dogo_android/util/base_classes/FirestoreCustomObject;", "Landroid/os/Parcelable;", "()V", "userId", "", "message", "entryId", "dog", "Lapp/dogo/com/dogo_android/model/DogProfileModel;", "challengeId", "entryOwnerUserId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/model/DogProfileModel;Ljava/lang/String;Ljava/lang/String;)V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "commentData", "", "", "entryData", "(Ljava/util/Map;Ljava/util/Map;)V", "badges", "", "getBadges", "()Ljava/util/List;", "setBadges", "(Ljava/util/List;)V", "getChallengeId", "()Ljava/lang/String;", "setChallengeId", "(Ljava/lang/String;)V", "<set-?>", "Lcom/google/firebase/Timestamp;", "date", "getDate", "()Lcom/google/firebase/Timestamp;", "documentId", "getDocumentId", "dogAvatarUrl", "getDogAvatarUrl", "dogId", "getDogId", "setDogId", "dogName", "getDogName", "getEntryId", "setEntryId", "getEntryOwnerUserId", "setEntryOwnerUserId", "entryTranslations", "", "isAuthorAdmin", "", "()Z", "isAuthorAmbassador", "isAuthorPremium", "isCaption", "isCommentValid", "isHasUserLiked", "setHasUserLiked", "(Z)V", "isPublished", "setPublished", "isSpam", "isTranslatePressed", "setTranslatePressed", "locale", "marked", "getMarked", "setMarked", "getMessage", "setMessage", "replyDogId", "getReplyDogId", "setReplyDogId", "replyTagName", "getReplyTagName", "setReplyTagName", "replyUserId", "getReplyUserId", "setReplyUserId", "translatedComment", "getTranslatedComment", "setTranslatedComment", "getUserId", "setUserId", "votes", "", "describeContents", "equals", "other", "getEntryTranslations", "getLocale", "getVotes", "isCommentAuthor", "isEntryAuthor", "setCaptionFlag", "", "bool", "setDocumentId", "id", "setEntryAuthor", "setEntryTranslations", "translation", "setLocale", "setReplyTarget", "replyTarget", "setVotes", "writeToParcel", "dest", "flags", "Companion", "MarkTypes", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ChallengeComment implements t, Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.model.ChallengeComment> CREATOR;
    public static final app.dogo.com.dogo_android.model.ChallengeComment.Companion Companion;
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
        public Companion(g g) {
            super();
        }

        @Exclude
        public final app.dogo.com.dogo_android.model.ChallengeComment commentParser(Map<String, ? extends Object> map, Map<String, ? extends Object> map2) {
            boolean challengeComment;
            Object[] strArr;
            int i;
            String str;
            n.f(map, "commentData");
            n.f(map2, "entryData");
            List list = Arrays.asList(Arrays.copyOf(/* result */, 4));
            n.e(list, "asList(*mandatoryCommentArray)");
            strArr = Arrays.asList(Arrays.copyOf(/* result */, 3));
            n.e(strArr, "asList(*mandatoryEntryArray)");
            if (map.keySet().containsAll(list) && map2.keySet().containsAll(strArr)) {
                strArr = Arrays.asList(Arrays.copyOf(strArr, 3));
                n.e(strArr, "asList(*mandatoryEntryArray)");
                if (map2.keySet().containsAll(strArr)) {
                    challengeComment = new ChallengeComment(map, map2, 0);
                    i = challengeComment;
                }
            }
            return i;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0007\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008j\u0002\u0008\t¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/model/ChallengeComment$MarkTypes;", "", "identifier", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getIdentifier", "()Ljava/lang/String;", "setIdentifier", "(Ljava/lang/String;)V", "SPAM", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum MarkTypes {

        SPAM("spam");

        private String identifier;
        private static final app.dogo.com.dogo_android.model.ChallengeComment.MarkTypes[] $values() {
            app.dogo.com.dogo_android.model.ChallengeComment.MarkTypes[] arr = new ChallengeComment.MarkTypes[1];
            return arr;
        }

        @Override // java.lang.Enum
        public final String getIdentifier() {
            return this.identifier;
        }

        @Override // java.lang.Enum
        public final void setIdentifier(String string) {
            n.f(string, "<set-?>");
            this.identifier = string;
        }
    }
    static {
        ChallengeComment.Companion companion = new ChallengeComment.Companion(0);
        ChallengeComment.Companion = companion;
        ChallengeComment.Companion.CREATOR.1 anon = new ChallengeComment.Companion.CREATOR.1();
        ChallengeComment.CREATOR = anon;
    }

    public ChallengeComment() {
        super();
        ArrayList arrayList = new ArrayList();
        this.badges = arrayList;
        HashMap hashMap = new HashMap();
        this.entryTranslations = hashMap;
    }

    protected ChallengeComment(Parcel parcel) {
        int i3;
        int i;
        int i2;
        n.f(parcel, "in");
        super();
        ArrayList arrayList = new ArrayList();
        this.badges = arrayList;
        HashMap hashMap = new HashMap();
        this.entryTranslations = hashMap;
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
        i2 = 1;
        final int i4 = 0;
        i3 = parcel.readByte() != 0 ? i2 : i4;
        this.isHasUserLiked = i3;
        i = parcel.readByte() != 0 ? i2 : i4;
        this.isPublished = i;
        this.date = (Timestamp)parcel.readParcelable(Timestamp.class.getClassLoader());
        this.documentId = parcel.readString();
        if (parcel.readByte() != 0) {
        } else {
            i2 = i4;
        }
        this.isCaption = i2;
        this.entryOwnerUserId = parcel.readString();
        this.locale = parcel.readString();
    }

    public ChallengeComment(String string, String string2, String string3, app.dogo.com.dogo_android.model.DogProfileModel dogProfileModel4, String string5, String string6) {
        n.f(dogProfileModel4, "dog");
        super();
        ArrayList arrayList = new ArrayList();
        this.badges = arrayList;
        HashMap hashMap = new HashMap();
        this.entryTranslations = hashMap;
        this.userId = string;
        this.entryId = string3;
        this.message = string2;
        setDogId(dogProfileModel4.getId());
        this.dogAvatarUrl = dogProfileModel4.getAvatar();
        this.dogName = dogProfileModel4.getName();
        this.challengeId = string5;
        this.entryOwnerUserId = string6;
    }

    private ChallengeComment(Map<String, ? extends Object> map, Map<String, ? extends Object> map2) {
        Object timestamp;
        int i;
        Object obj;
        String booleanValue;
        String str;
        Date date;
        Object str2;
        int intValue;
        super();
        ArrayList arrayList = new ArrayList();
        this.badges = arrayList;
        HashMap hashMap = new HashMap();
        this.entryTranslations = hashMap;
        this.dogAvatarUrl = (String)map.get("dogAvatarUrl");
        str = "votes";
        if (map.get("date") != null) {
            timestamp = map.get(str);
        } else {
            date = new Date();
            timestamp = new Timestamp(date);
        }
        this.date = timestamp;
        Object obj4 = map.get("dogId");
        String str13 = "null cannot be cast to non-null type kotlin.String";
        Objects.requireNonNull(obj4, str13);
        setDogId((String)obj4);
        Object obj5 = map.get("dogName");
        Objects.requireNonNull(obj5, str13);
        this.dogName = (String)obj5;
        Object obj6 = map.get("id");
        Objects.requireNonNull(obj6, str13);
        this.documentId = (String)obj6;
        this.message = (String)map.get("message");
        booleanValue = "published";
        Object obj11 = map.get(booleanValue);
        Objects.requireNonNull(obj11, "null cannot be cast to non-null type kotlin.Boolean");
        if (map.get(booleanValue) != null && (Boolean)obj11.booleanValue()) {
            obj11 = map.get(booleanValue);
            Objects.requireNonNull(obj11, "null cannot be cast to non-null type kotlin.Boolean");
            i = (Boolean)obj11.booleanValue() ? 1 : intValue;
        } else {
        }
        this.isPublished = i;
        this.userId = (String)map.get("userId");
        if (map.get(str) != null) {
            obj = map.get(str);
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Int");
            intValue = (Integer)obj.intValue();
        }
        this.votes = intValue;
        this.replyDogId = (String)map.get("replyDogId");
        this.replyTagName = (String)map.get("replyTagName");
        this.replyUserId = (String)map.get("replyUserId");
        this.entryOwnerUserId = (String)map2.get("entryOwnerUserId");
        this.challengeId = (String)map2.get("challengeId");
        obj6 = map2.get("entryId");
        Objects.requireNonNull(obj6, str13);
        this.entryId = (String)obj6;
    }

    public ChallengeComment(Map map, Map map2, g g3) {
        super(map, map2);
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public boolean equals(Object object) {
        boolean date;
        int i;
        String entryId;
        Object obj4;
        i = 0;
        if (object instanceof ChallengeComment && n.b(this.userId, object.userId) && n.b(this.message, object.message) && n.b(this.entryId, object.entryId) && n.b(getDogId(), (ChallengeComment)object.getDogId())) {
            if (n.b(this.userId, object.userId)) {
                if (n.b(this.message, object.message)) {
                    if (n.b(this.entryId, object.entryId)) {
                        if (n.b(getDogId(), (ChallengeComment)object.getDogId())) {
                            obj4 = object.date;
                            if (obj4 != null) {
                                if (this.date == obj4) {
                                    i = 1;
                                }
                            } else {
                            }
                        }
                    }
                }
            }
        }
        return i;
    }

    public final List<String> getBadges() {
        return this.badges;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final String getChallengeId() {
        return this.challengeId;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final Timestamp getDate() {
        return this.date;
    }

    @Exclude
    public final String getDocumentId() {
        return this.documentId;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final String getDogAvatarUrl() {
        return this.dogAvatarUrl;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final String getDogId() {
        String dogId = this.dogId;
        if (dogId == null) {
        } else {
            return dogId;
        }
        n.w("dogId");
        throw 0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final String getDogName() {
        return this.dogName;
    }

    @Exclude
    public final String getEntryId() {
        return this.entryId;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final String getEntryOwnerUserId() {
        return this.entryOwnerUserId;
    }

    public final Map<String, String> getEntryTranslations() {
        return this.entryTranslations;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final String getLocale() {
        return this.locale;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final String getMarked() {
        return this.marked;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final String getMessage() {
        return this.message;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final String getReplyDogId() {
        return this.replyDogId;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final String getReplyTagName() {
        return this.replyTagName;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final String getReplyUserId() {
        return this.replyUserId;
    }

    @Exclude
    public final String getTranslatedComment() {
        return this.translatedComment;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final String getUserId() {
        return this.userId;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final int getVotes() {
        return this.votes;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final boolean isAuthorAdmin() {
        return n.b(j1.s(this), "admin");
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final boolean isAuthorAmbassador() {
        return n.b(j1.s(this), "ambassador");
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final boolean isAuthorPremium() {
        return n.b(j1.s(this), "premium");
    }

    @Exclude
    public final boolean isCaption() {
        return this.isCaption;
    }

    @Exclude
    public final boolean isCommentAuthor(String string) {
        n.f(string, "userId");
        return n.b(this.userId, string);
    }

    @Exclude
    public final boolean isCommentValid() {
        String entryOwnerUserId;
        int i;
        entryOwnerUserId = this.userId;
        final int i2 = 0;
        if (entryOwnerUserId != null) {
            n.d(entryOwnerUserId);
            entryOwnerUserId = entryOwnerUserId.length() == 0 ? i : i2;
            if (entryOwnerUserId == 0 && this.message != null && this.challengeId != null && this.entryOwnerUserId != null) {
                if (this.message != null) {
                    if (this.challengeId != null) {
                        if (this.entryOwnerUserId != null) {
                        } else {
                            i = i2;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Exclude
    public final boolean isEntryAuthor(String string) {
        n.f(string, "userId");
        return n.b(string, this.entryOwnerUserId);
    }

    @Exclude
    public final boolean isHasUserLiked() {
        return this.isHasUserLiked;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final boolean isPublished() {
        return this.isPublished;
    }

    @Exclude
    public final boolean isSpam() {
        boolean isPublished;
        int i;
        String identifier;
        if (!this.isPublished && n.b(this.marked, ChallengeComment.MarkTypes.SPAM.getIdentifier())) {
            i = n.b(this.marked, ChallengeComment.MarkTypes.SPAM.getIdentifier()) ? 1 : 0;
        } else {
        }
        return i;
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
    public final void setCaptionFlag(boolean z) {
        this.isCaption = z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setChallengeId(String string) {
        this.challengeId = string;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public void setDocumentId(String string) {
        n.f(string, "id");
        this.documentId = string;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setDogId(String string) {
        n.f(string, "<set-?>");
        this.dogId = string;
    }

    @Exclude
    public final void setEntryAuthor(String string) {
        this.entryOwnerUserId = string;
    }

    @Exclude
    public final void setEntryId(String string) {
        this.entryId = string;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setEntryOwnerUserId(String string) {
        this.entryOwnerUserId = string;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setEntryTranslations(String string, String string2) {
        n.f(string, "locale");
        n.f(string2, "translation");
        this.entryTranslations.put(string, string2);
    }

    @Exclude
    public final void setHasUserLiked(boolean z) {
        this.isHasUserLiked = z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setLocale(String string) {
        String str;
        boolean z;
        str = "en";
        if (string != null && n.b(string, str)) {
            str = "en";
            if (n.b(string, str)) {
                this.locale = str;
            } else {
                this.locale = string;
            }
        } else {
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setMarked(String string) {
        this.marked = string;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setMessage(String string) {
        this.message = string;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setPublished(boolean z) {
        this.isPublished = z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setReplyDogId(String string) {
        this.replyDogId = string;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setReplyTagName(String string) {
        this.replyTagName = string;
    }

    @Exclude
    public final void setReplyTarget(app.dogo.com.dogo_android.model.ChallengeComment challengeComment) {
        n.f(challengeComment, "replyTarget");
        this.replyDogId = challengeComment.getDogId();
        this.replyTagName = challengeComment.dogName;
        this.replyUserId = challengeComment.userId;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setReplyUserId(String string) {
        this.replyUserId = string;
    }

    @Exclude
    public final void setTranslatePressed(boolean z) {
        this.isTranslatePressed = z;
    }

    @Exclude
    public final void setTranslatedComment(String string) {
        this.translatedComment = string;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setUserId(String string) {
        this.userId = string;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setVotes(int i) {
        int obj1;
        if (i < 0) {
            obj1 = 0;
        }
        this.votes = obj1;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "dest");
        parcel.writeString(this.dogAvatarUrl);
        parcel.writeString(getDogId());
        parcel.writeString(this.dogName);
        parcel.writeString(this.userId);
        parcel.writeString(this.replyTagName);
        parcel.writeString(this.message);
        parcel.writeString(this.replyUserId);
        parcel.writeString(this.replyDogId);
        parcel.writeString(this.challengeId);
        parcel.writeInt(this.votes);
        parcel.writeString(this.entryId);
        parcel.writeByte((byte)isHasUserLiked);
        parcel.writeByte((byte)isPublished);
        parcel.writeParcelable(this.date, i2);
        parcel.writeString(this.documentId);
        parcel.writeByte((byte)obj3);
        parcel.writeString(this.entryOwnerUserId);
        parcel.writeString(this.locale);
    }
}
