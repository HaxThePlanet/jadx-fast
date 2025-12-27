package app.dogo.com.dogo_android.model;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentId;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: ChallengeNotificationModel.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u000b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0008:\u0008\u0086\u0008\u0018\u00002\u00020\u0001:\u0002RSBå\u0001\u0012\u0010\u0008\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r\u0012\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0008\u0012\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0008\u0012\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0008\u0012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\n\u0012\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0008\u0012\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0008\u0012\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0008\u0012\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0008\u0012\u0008\u0008\u0002\u0010\u0016\u001a\u00020\r\u0012\n\u0008\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0008\u0012\u0016\u0008\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019\u0012\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u0008¢\u0006\u0002\u0010\u001cJ\u0011\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010;\u001a\u00020\nHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0008HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0008HÆ\u0003J\t\u0010>\u001a\u00020\u0008HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0008HÆ\u0003J\t\u0010@\u001a\u00020\rHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0008HÆ\u0003J\u0017\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019HÆ\u0003J\t\u0010C\u001a\u00020\u0008HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0008HÆ\u0003J\t\u0010F\u001a\u00020\nHÆ\u0003J\u0010\u0010G\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00103J\u0010\u0010H\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00106J\u000b\u0010I\u001a\u0004\u0018\u00010\u0008HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0008HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0008HÆ\u0003Jî\u0001\u0010L\u001a\u00020\u00002\u0010\u0008\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r2\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00082\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00082\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00082\u0008\u0008\u0002\u0010\u0011\u001a\u00020\n2\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00082\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00082\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00082\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00082\u0008\u0008\u0002\u0010\u0016\u001a\u00020\r2\n\u0008\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00082\u0016\u0008\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u0008HÆ\u0001¢\u0006\u0002\u0010MJ\u0013\u0010N\u001a\u00020\n2\u0008\u0010O\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010P\u001a\u00020\rHÖ\u0001J\t\u0010Q\u001a\u00020\u0008HÖ\u0001R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\u001eR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\"\u0010\u001e\"\u0004\u0008#\u0010$R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010\u001eR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010\u001eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010\u001eR\u0016\u0010\u001b\u001a\u00020\u00088\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010\u001eR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010\u001eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010\u001eR\u001f\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010,R\u0011\u0010\u0014\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010\u001eR\u0011\u0010\u0011\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010/R\u0011\u0010\u0016\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u00080\u00101R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u00082\u0010/R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u00104\u001a\u0004\u0008\u000b\u00103R\u0015\u0010\u000c\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u00107\u001a\u0004\u00085\u00106R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u00088\u00109¨\u0006T", d2 = {"Lapp/dogo/com/dogo_android/model/ChallengeNotificationModel;", "", "comments", "", "Lapp/dogo/com/dogo_android/model/ChallengeNotificationModel$MiniCommentObject;", "sortingDate", "Lcom/google/firebase/Timestamp;", "entryImageUrl_320", "", "following", "", "isActive", "newEntryVotes", "", "entryCountry", "entryDogName", "entryImageUrl", "entryPublished", "entryDogId", "challengeId", "entryOwnerUserId", "entryComment", "entryVotes", "entryDogAvatarUrl", "entryImages", "", "Lapp/dogo/com/dogo_android/model/ChallengeNotificationModel$EntryImageObject;", "entryId", "(Ljava/util/List;Lcom/google/firebase/Timestamp;Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "getChallengeId", "()Ljava/lang/String;", "getComments", "()Ljava/util/List;", "getEntryComment", "getEntryCountry", "setEntryCountry", "(Ljava/lang/String;)V", "getEntryDogAvatarUrl", "getEntryDogId", "getEntryDogName", "getEntryId", "getEntryImageUrl", "getEntryImageUrl_320", "getEntryImages", "()Ljava/util/Map;", "getEntryOwnerUserId", "getEntryPublished", "()Z", "getEntryVotes", "()I", "getFollowing", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNewEntryVotes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSortingDate", "()Lcom/google/firebase/Timestamp;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/List;Lcom/google/firebase/Timestamp;Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/Map;Ljava/lang/String;)Lapp/dogo/com/dogo_android/model/ChallengeNotificationModel;", "equals", "other", "hashCode", "toString", "EntryImageObject", "MiniCommentObject", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ChallengeNotificationModel {

    private final String challengeId;
    private final List<ChallengeNotificationModel.MiniCommentObject> comments;
    private final String entryComment;
    private String entryCountry;
    private final String entryDogAvatarUrl;
    private final String entryDogId;
    private final String entryDogName;
    @DocumentId
    private final String entryId;
    private final String entryImageUrl;
    private final String entryImageUrl_320;
    private final Map<String, ChallengeNotificationModel.EntryImageObject> entryImages;
    private final String entryOwnerUserId;
    private final boolean entryPublished;
    private final int entryVotes;
    private final boolean following;
    private final Boolean isActive;
    private final Integer newEntryVotes;
    private final Timestamp sortingDate;

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0019\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001BW\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\rHÆ\u0003J[\u0010#\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\rHÆ\u0001J\u0013\u0010$\u001a\u00020\r2\u0008\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u000c\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0014R\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001a¨\u0006)", d2 = {"Lapp/dogo/com/dogo_android/model/ChallengeNotificationModel$EntryImageObject;", "", "imageId", "", "createdAt", "Lcom/google/firebase/Timestamp;", "imageUrl_320", "imageUrl_640", "imageUrl_1280", "imageUrl", "votes", "", "featured", "", "(Ljava/lang/String;Lcom/google/firebase/Timestamp;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZ)V", "getCreatedAt", "()Lcom/google/firebase/Timestamp;", "getFeatured", "()Z", "getImageId", "()Ljava/lang/String;", "getImageUrl", "getImageUrl_1280", "getImageUrl_320", "getImageUrl_640", "getVotes", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class EntryImageObject {

        private final Timestamp createdAt;
        private final boolean featured;
        private final String imageId;
        private final String imageUrl;
        private final String imageUrl_1280;
        private final String imageUrl_320;
        private final String imageUrl_640;
        private final long votes;
        public EntryImageObject(String str, Timestamp timestamp, String str2, String str3, String str4, String str5, long j, boolean z) {
            n.f(str, "imageId");
            n.f(str2, "imageUrl_320");
            n.f(str3, "imageUrl_640");
            n.f(str4, "imageUrl_1280");
            n.f(str5, "imageUrl");
            super();
            this.imageId = str;
            this.createdAt = timestamp;
            this.imageUrl_320 = str2;
            this.imageUrl_640 = str3;
            this.imageUrl_1280 = str4;
            this.imageUrl = str5;
            this.votes = j;
            this.featured = z;
        }

        public final Timestamp getCreatedAt() {
            return this.createdAt;
        }

        public final boolean getFeatured() {
            return this.featured;
        }

        public final String getImageId() {
            return this.imageId;
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final String getImageUrl_1280() {
            return this.imageUrl_1280;
        }

        public final String getImageUrl_320() {
            return this.imageUrl_320;
        }

        public final String getImageUrl_640() {
            return this.imageUrl_640;
        }

        public final long getVotes() {
            return this.votes;
        }

        public /* synthetic */ EntryImageObject(String str, Timestamp timestamp, String str2, String str3, String str4, String str5, long j, boolean z, int i, g gVar) {
            int timestamp22 = 0;
            int j72 = 0;
            int gVar102 = i;
            str2 = "";
            String r1 = gVar102 & 1 != 0 ? str2 : str;
            int r3 = gVar102 & 2 != 0 ? 0 : timestamp;
            String r4 = str2;
            String r5 = gVar102 & 8 != 0 ? str2 : str3;
            String r6 = gVar102 & 16 != 0 ? str2 : str4;
            if (gVar102 & 32 == 0) {
                str2 = str5;
            }
            int r7 = gVar102 & 64 != 0 ? 0 : j;
            int r0 = gVar102 & 128 != 0 ? 0 : z;
            this(str2, timestamp22, str2, str2, str2, str2, j72, z, (gVar102 & 128 != 0 ? 0 : z));
        }

        public EntryImageObject() {
            this(null, null, null, null, null, null, 0L, z, 0, 255, 0);
        }

        public static /* synthetic */ ChallengeNotificationModel.EntryImageObject copy$default(ChallengeNotificationModel.EntryImageObject entryImageObject, String str, Timestamp timestamp, String str2, String str3, String str4, String str5, long j, boolean z, int i, Object object) {
            boolean i102;
            String str22;
            Timestamp timestamp32;
            String str42;
            String str52;
            String str62;
            String str72;
            long j82;
            Object entryImageObject2 = entryImageObject;
            int object112 = i;
            String r2 = object112 & 1 != 0 ? entryImageObject2.imageId : str;
            Timestamp r3 = object112 & 2 != 0 ? entryImageObject2.createdAt : timestamp;
            String r4 = object112 & 4 != 0 ? entryImageObject2.imageUrl_320 : str2;
            String r5 = object112 & 8 != 0 ? entryImageObject2.imageUrl_640 : str3;
            String r6 = object112 & 16 != 0 ? entryImageObject2.imageUrl_1280 : str4;
            String r7 = object112 & 32 != 0 ? entryImageObject2.imageUrl : str5;
            long r8 = object112 & 64 != 0 ? entryImageObject2.votes : j;
            boolean r1 = object112 & 128 != 0 ? entryImageObject2.featured : z;
            return entryImageObject.copy(str22, timestamp32, str42, str52, str62, str72, j82, r18, (object112 & 128 != 0 ? entryImageObject2.featured : z));
        }

        /* operator */ public final String component1() {
            return this.imageId;
        }

        /* operator */ public final Timestamp component2() {
            return this.createdAt;
        }

        /* operator */ public final String component3() {
            return this.imageUrl_320;
        }

        /* operator */ public final String component4() {
            return this.imageUrl_640;
        }

        /* operator */ public final String component5() {
            return this.imageUrl_1280;
        }

        /* operator */ public final String component6() {
            return this.imageUrl;
        }

        /* operator */ public final long component7() {
            return this.votes;
        }

        /* operator */ public final boolean component8() {
            return this.featured;
        }

        public final ChallengeNotificationModel.EntryImageObject copy(String imageId, Timestamp createdAt, String imageUrl_320, String imageUrl_640, String imageUrl_1280, String imageUrl, long votes, boolean featured) {
            n.f(imageId, "imageId");
            n.f(imageUrl_320, "imageUrl_320");
            n.f(imageUrl_640, "imageUrl_640");
            final Object imageUrl_12802 = imageUrl_1280;
            n.f(imageUrl_12802, "imageUrl_1280");
            final Object imageUrl2 = imageUrl;
            n.f(imageUrl2, "imageUrl");
            ChallengeNotificationModel_EntryImageObject challengeNotificationModel_EntryImageObject = new ChallengeNotificationModel_EntryImageObject(imageId, createdAt, imageUrl_320, imageUrl_640, imageUrl_12802, imageUrl2, votes, z, featured);
            return challengeNotificationModel_EntryImageObject;
        }

        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z9 = false;
            if (!(other instanceof ChallengeNotificationModel_EntryImageObject)) {
                return false;
            }
            if (!n.b(this.imageId, other.imageId)) {
                return false;
            }
            if (!n.b(this.createdAt, other.createdAt)) {
                return false;
            }
            if (!n.b(this.imageUrl_320, other.imageUrl_320)) {
                return false;
            }
            if (!n.b(this.imageUrl_640, other.imageUrl_640)) {
                return false;
            }
            if (!n.b(this.imageUrl_1280, other.imageUrl_1280)) {
                return false;
            }
            if (!n.b(this.imageUrl, other.imageUrl)) {
                return false;
            }
            if (this.votes != other.votes) {
                return false;
            }
            return this.featured != other.featured ? z9 : z;
        }

        public int hashCode() {
            int i = 0;
            boolean featured2 = true;
            if (this.createdAt == null) {
                i = 0;
            } else {
                i = this.createdAt.hashCode();
            }
            if (this.featured) {
                int i22 = 1;
            }
            return (this.imageId.hashCode() * 31) + i * 31 + this.imageUrl_320.hashCode() * 31 + this.imageUrl_640.hashCode() * 31 + this.imageUrl_1280.hashCode() * 31 + this.imageUrl.hashCode() * 31 + Long.hashCode(this.votes) * 31 + featured2;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "EntryImageObject(imageId=";
            String str3 = ", createdAt=";
            String str4 = ", imageUrl_320=";
            String str5 = ", imageUrl_640=";
            String str6 = ", imageUrl_1280=";
            String str7 = ", imageUrl=";
            String str8 = ", votes=";
            String str9 = ", featured=";
            str = str2 + this.imageId + str3 + this.createdAt + str4 + this.imageUrl_320 + str5 + this.imageUrl_640 + str6 + this.imageUrl_1280 + str7 + this.imageUrl + str8 + this.votes + str9 + this.featured + 41;
            return str;
        }
    }

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008#\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0011HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u000bHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u008d\u0001\u0010/\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00052\u0008\u0008\u0002\u0010\t\u001a\u00020\u00052\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0013\u00100\u001a\u00020\u000b2\u0008\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0011HÖ\u0001J\t\u00103\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0016R\u0011\u0010\u0008\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR\u0013\u0010\u000c\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u0016R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u0016R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u0016R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"¨\u00064", d2 = {"Lapp/dogo/com/dogo_android/model/ChallengeNotificationModel$MiniCommentObject;", "", "date", "Lcom/google/firebase/Timestamp;", "dogAvatarUrl", "", "dogId", "dogName", "id", "message", "published", "", "replyDogId", "replyDogName", "replyUserId", "userId", "votes", "", "(Lcom/google/firebase/Timestamp;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getDate", "()Lcom/google/firebase/Timestamp;", "getDogAvatarUrl", "()Ljava/lang/String;", "getDogId", "getDogName", "getId", "getMessage", "getPublished", "()Z", "getReplyDogId", "getReplyDogName", "getReplyUserId", "getUserId", "getVotes", "()I", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class MiniCommentObject {

        private final Timestamp date;
        private final String dogAvatarUrl;
        private final String dogId;
        private final String dogName;
        private final String id;
        private final String message;
        private final boolean published;
        private final String replyDogId;
        private final String replyDogName;
        private final String replyUserId;
        private final String userId;
        private final int votes;
        public MiniCommentObject(Timestamp timestamp, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, String str8, String str9, int i) {
            n.f(str2, "dogId");
            n.f(str4, "id");
            n.f(str5, "message");
            n.f(str9, "userId");
            super();
            this.date = timestamp;
            this.dogAvatarUrl = str;
            this.dogId = str2;
            this.dogName = str3;
            this.id = str4;
            this.message = str5;
            this.published = z;
            this.replyDogId = str6;
            this.replyDogName = str7;
            this.replyUserId = str8;
            this.userId = str9;
            this.votes = i;
        }

        public final Timestamp getDate() {
            return this.date;
        }

        public final String getDogAvatarUrl() {
            return this.dogAvatarUrl;
        }

        public final String getDogId() {
            return this.dogId;
        }

        public final String getDogName() {
            return this.dogName;
        }

        public final String getId() {
            return this.id;
        }

        public final String getMessage() {
            return this.message;
        }

        public final boolean getPublished() {
            return this.published;
        }

        public final String getReplyDogId() {
            return this.replyDogId;
        }

        public final String getReplyDogName() {
            return this.replyDogName;
        }

        public final String getReplyUserId() {
            return this.replyUserId;
        }

        public final String getUserId() {
            return this.userId;
        }

        public final int getVotes() {
            return this.votes;
        }

        public /* synthetic */ MiniCommentObject(Timestamp timestamp, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, String str8, String str9, int i, int i2, g gVar) {
            int timestamp2;
            String str22;
            int z72;
            int i132 = i2;
            timestamp2 = 0;
            int r1 = i132 & 1 != 0 ? timestamp2 : timestamp;
            str22 = "";
            String r3 = i132 & 2 != 0 ? str22 : str;
            String r5 = i132 & 4 != 0 ? str22 : str2;
            int r6 = i132 & 8 != 0 ? timestamp2 : str3;
            String r7 = i132 & 16 != 0 ? str22 : str4;
            String r8 = i132 & 32 != 0 ? str22 : str5;
            z72 = 0;
            int r9 = i132 & 64 != 0 ? 0 : z;
            int r11 = i132 & 128 != 0 ? timestamp2 : str6;
            int r12 = i132 & 256 != 0 ? timestamp2 : str7;
            if (i132 & 512 == 0) {
                timestamp2 = str8;
            }
            if (i132 & 1024 == 0) {
                str22 = str9;
            }
            if (i132 & 2048 == 0) {
                z72 = i;
            }
            this(timestamp2, str22, str22, timestamp2, str22, str22, z72, timestamp2, timestamp2, timestamp2, str22, z72);
        }

        public MiniCommentObject() {
            this(null, null, null, null, null, null, false, null, null, null, null, 0, 4095, null);
        }

        public static /* synthetic */ ChallengeNotificationModel.MiniCommentObject copy$default(ChallengeNotificationModel.MiniCommentObject miniCommentObject, Timestamp timestamp, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, String str8, String str9, int i, int i2, Object object) {
            int i132;
            Timestamp timestamp22;
            String str32;
            String str42;
            String str52;
            String str62;
            String str72;
            boolean z82;
            String str92;
            String str102;
            String str112;
            String str122;
            Object miniCommentObject2 = miniCommentObject;
            int i142 = i2;
            Timestamp r2 = i142 & 1 != 0 ? miniCommentObject2.date : timestamp;
            String r3 = i142 & 2 != 0 ? miniCommentObject2.dogAvatarUrl : str;
            String r4 = i142 & 4 != 0 ? miniCommentObject2.dogId : str2;
            String r5 = i142 & 8 != 0 ? miniCommentObject2.dogName : str3;
            String r6 = i142 & 16 != 0 ? miniCommentObject2.id : str4;
            String r7 = i142 & 32 != 0 ? miniCommentObject2.message : str5;
            boolean r8 = i142 & 64 != 0 ? miniCommentObject2.published : z;
            String r9 = i142 & 128 != 0 ? miniCommentObject2.replyDogId : str6;
            String r10 = i142 & 256 != 0 ? miniCommentObject2.replyDogName : str7;
            String r11 = i142 & 512 != 0 ? miniCommentObject2.replyUserId : str8;
            String r12 = i142 & 1024 != 0 ? miniCommentObject2.userId : str9;
            int r1 = i142 & 2048 != 0 ? miniCommentObject2.votes : i;
            return miniCommentObject.copy(timestamp22, str32, str42, str52, str62, str72, z82, str92, str102, str112, str122, (i142 & 2048 != 0 ? miniCommentObject2.votes : i));
        }

        /* operator */ public final Timestamp component1() {
            return this.date;
        }

        /* operator */ public final String component10() {
            return this.replyUserId;
        }

        /* operator */ public final String component11() {
            return this.userId;
        }

        /* operator */ public final int component12() {
            return this.votes;
        }

        /* operator */ public final String component2() {
            return this.dogAvatarUrl;
        }

        /* operator */ public final String component3() {
            return this.dogId;
        }

        /* operator */ public final String component4() {
            return this.dogName;
        }

        /* operator */ public final String component5() {
            return this.id;
        }

        /* operator */ public final String component6() {
            return this.message;
        }

        /* operator */ public final boolean component7() {
            return this.published;
        }

        /* operator */ public final String component8() {
            return this.replyDogId;
        }

        /* operator */ public final String component9() {
            return this.replyDogName;
        }

        public final ChallengeNotificationModel.MiniCommentObject copy(Timestamp date, String dogAvatarUrl, String dogId, String dogName, String id, String message, boolean published, String replyDogId, String replyDogName, String replyUserId, String userId, int votes) {
            final Object dogId2 = dogId;
            n.f(dogId2, "dogId");
            final Object id2 = id;
            n.f(id2, "id");
            final Object message2 = message;
            n.f(message2, "message");
            final Object userId2 = userId;
            n.f(userId2, "userId");
            ChallengeNotificationModel_MiniCommentObject challengeNotificationModel_MiniCommentObject = new ChallengeNotificationModel_MiniCommentObject(date, dogAvatarUrl, dogId2, dogName, id2, message2, published, replyDogId, replyDogName, replyUserId, userId2, votes);
            return challengeNotificationModel_MiniCommentObject;
        }

        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z13 = false;
            if (!(other instanceof ChallengeNotificationModel_MiniCommentObject)) {
                return false;
            }
            if (!n.b(this.date, other.date)) {
                return false;
            }
            if (!n.b(this.dogAvatarUrl, other.dogAvatarUrl)) {
                return false;
            }
            if (!n.b(this.dogId, other.dogId)) {
                return false;
            }
            if (!n.b(this.dogName, other.dogName)) {
                return false;
            }
            if (!n.b(this.id, other.id)) {
                return false;
            }
            if (!n.b(this.message, other.message)) {
                return false;
            }
            if (this.published != other.published) {
                return false;
            }
            if (!n.b(this.replyDogId, other.replyDogId)) {
                return false;
            }
            if (!n.b(this.replyDogName, other.replyDogName)) {
                return false;
            }
            if (!n.b(this.replyUserId, other.replyUserId)) {
                return false;
            }
            if (!n.b(this.userId, other.userId)) {
                return false;
            }
            return this.votes != other.votes ? z13 : z;
        }

        public int hashCode() {
            int i;
            boolean published2 = true;
            i = 0;
            if (this.date == null) {
            } else {
                i = this.date.hashCode();
            }
            if (this.dogAvatarUrl == null) {
            } else {
                i = this.dogAvatarUrl.hashCode();
            }
            if (this.dogName == null) {
            } else {
                i = this.dogName.hashCode();
            }
            if (this.published) {
                int i29 = 1;
            }
            if (this.replyDogId == null) {
            } else {
                i = this.replyDogId.hashCode();
            }
            if (this.replyDogName == null) {
            } else {
                i = this.replyDogName.hashCode();
            }
            if (this.replyUserId != null) {
                i = this.replyUserId.hashCode();
            }
            return (i * 31) + i * 31 + this.dogId.hashCode() * 31 + i * 31 + this.id.hashCode() * 31 + this.message.hashCode() * 31 + published2 * 31 + i * 31 + i * 31 + i * 31 + this.userId.hashCode() * 31 + Integer.hashCode(this.votes);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "MiniCommentObject(date=";
            String str3 = ", dogAvatarUrl=";
            String str4 = ", dogId=";
            String str5 = ", dogName=";
            String str6 = ", id=";
            String str7 = ", message=";
            String str8 = ", published=";
            String str9 = ", replyDogId=";
            String str10 = ", replyDogName=";
            String str11 = ", replyUserId=";
            String str12 = ", userId=";
            String str13 = ", votes=";
            str = str2 + this.date + str3 + this.dogAvatarUrl + str4 + this.dogId + str5 + this.dogName + str6 + this.id + str7 + this.message + str8 + this.published + str9 + this.replyDogId + str10 + this.replyDogName + str11 + this.replyUserId + str12 + this.userId + str13 + this.votes + 41;
            return str;
        }
    }
    public ChallengeNotificationModel(List<ChallengeNotificationModel.MiniCommentObject> list, Timestamp timestamp, String str, boolean z, Boolean boolean, Integer integer, String str2, String str3, String str4, boolean z2, String str5, String str6, String str7, String str8, int i, String str9, Map<String, ChallengeNotificationModel.EntryImageObject> map, String str10) {
        final Object list3 = this;
        Object str132 = str7;
        final Object str182 = str10;
        n.f(str132, "entryOwnerUserId");
        n.f(str182, "entryId");
        super();
        list3.comments = list;
        list3.sortingDate = timestamp;
        list3.entryImageUrl_320 = str;
        list3.following = z;
        list3.isActive = boolean;
        list3.newEntryVotes = integer;
        list3.entryCountry = str2;
        list3.entryDogName = str3;
        list3.entryImageUrl = str4;
        list3.entryPublished = z2;
        list3.entryDogId = str5;
        list3.challengeId = str6;
        list3.entryOwnerUserId = str132;
        list3.entryComment = str8;
        list3.entryVotes = i;
        list3.entryDogAvatarUrl = str9;
        list3.entryImages = map;
        list3.entryId = str182;
    }

    public final String getChallengeId() {
        return this.challengeId;
    }

    public final List<ChallengeNotificationModel.MiniCommentObject> getComments() {
        return this.comments;
    }

    public final String getEntryComment() {
        return this.entryComment;
    }

    public final String getEntryCountry() {
        return this.entryCountry;
    }

    public final String getEntryDogAvatarUrl() {
        return this.entryDogAvatarUrl;
    }

    public final String getEntryDogId() {
        return this.entryDogId;
    }

    public final String getEntryDogName() {
        return this.entryDogName;
    }

    public final String getEntryId() {
        return this.entryId;
    }

    public final String getEntryImageUrl() {
        return this.entryImageUrl;
    }

    public final String getEntryImageUrl_320() {
        return this.entryImageUrl_320;
    }

    public final Map<String, ChallengeNotificationModel.EntryImageObject> getEntryImages() {
        return this.entryImages;
    }

    public final String getEntryOwnerUserId() {
        return this.entryOwnerUserId;
    }

    public final boolean getEntryPublished() {
        return this.entryPublished;
    }

    public final int getEntryVotes() {
        return this.entryVotes;
    }

    public final boolean getFollowing() {
        return this.following;
    }

    public final Integer getNewEntryVotes() {
        return this.newEntryVotes;
    }

    public final Timestamp getSortingDate() {
        return this.sortingDate;
    }

    public final Boolean isActive() {
        return this.isActive;
    }

    public final void setEntryCountry(String str) {
        this.entryCountry = str;
    }

    public /* synthetic */ ChallengeNotificationModel(List list, Timestamp timestamp, String str, boolean z, Boolean boolean, Integer integer, String str2, String str3, String str4, boolean z2, String str5, String str6, String str7, String str8, int i, String str9, Map map, String str10, int i2, g gVar) {
        int list2 = 0;
        int str142 = 0;
        int timestamp22 = 0;
        int str32 = 0;
        int z42;
        int i152 = 0;
        Boolean boolean52;
        Integer integer62;
        int str72 = 0;
        int str82 = 0;
        int str92 = 0;
        int str112 = 0;
        int str122 = 0;
        String str132;
        int str162 = 0;
        int map172 = 0;
        int i192 = i2;
        int r1 = i192 & 1 != 0 ? 0 : list;
        int r3 = i192 & 2 != 0 ? 0 : timestamp;
        int r4 = i192 & 4 != 0 ? 0 : str;
        z42 = 0;
        int r5 = i192 & 8 != 0 ? z42 : z;
        Boolean r7 = i192 & 16 != 0 ? Boolean.FALSE : boolean;
        if (i192 & 32 != 0) {
            integer62 = 0;
        } else {
            integer62 = integer;
        }
        int r9 = i192 & 64 != 0 ? 0 : str2;
        int r10 = i192 & 128 != 0 ? 0 : str3;
        int r11 = i192 & 256 != 0 ? 0 : str4;
        int r12 = i192 & 512 != 0 ? z42 : z2;
        int r13 = i192 & 1024 != 0 ? 0 : str5;
        int r14 = i192 & 2048 != 0 ? 0 : str6;
        str132 = "";
        String r15 = i192 & 4096 != 0 ? "" : str7;
        int r2 = i192 & 8192 != 0 ? 0 : str8;
        int r6 = i192 & 16384 != 0 ? 0 : i;
        int r17 = i192 & 32768 != 0 ? 0 : str9;
        int r18 = i192 & 65536 != 0 ? 0 : map;
        if (i192 & 131072 == 0) {
            str132 = str10;
        }
        this(list2, timestamp22, str32, z42, boolean52, integer62, str72, str82, str92, z42, str112, str122, str132, str142, i152, str162, map172, str132);
    }

    public ChallengeNotificationModel() {
        this(null, null, null, false, null, null, null, null, null, false, null, null, null, null, 0, null, null, null, 262143, null);
    }

    public static /* synthetic */ ChallengeNotificationModel copy$default(ChallengeNotificationModel challengeNotificationModel, List list, Timestamp timestamp, String str, boolean z, Boolean boolean, Integer integer, String str2, String str3, String str4, boolean z2, String str5, String str6, String str7, String str8, int i, String str9, Map map, String str10, int i2, Object object) {
        String str192;
        List list22;
        Timestamp timestamp32;
        String str42;
        boolean z52;
        Boolean boolean62;
        Integer integer72;
        String str82;
        String str92;
        String str102;
        boolean z112;
        String str122;
        String str132;
        String str142;
        String str152;
        int i162;
        String str172;
        Map map182;
        Object challengeNotificationModel2 = challengeNotificationModel;
        int i202 = i2;
        List r2 = i202 & 1 != 0 ? challengeNotificationModel2.comments : list;
        Timestamp r3 = i202 & 2 != 0 ? challengeNotificationModel2.sortingDate : timestamp;
        String r4 = i202 & 4 != 0 ? challengeNotificationModel2.entryImageUrl_320 : str;
        boolean r5 = i202 & 8 != 0 ? challengeNotificationModel2.following : z;
        Boolean r6 = i202 & 16 != 0 ? challengeNotificationModel2.isActive : boolean;
        Integer r7 = i202 & 32 != 0 ? challengeNotificationModel2.newEntryVotes : integer;
        String r8 = i202 & 64 != 0 ? challengeNotificationModel2.entryCountry : str2;
        String r9 = i202 & 128 != 0 ? challengeNotificationModel2.entryDogName : str3;
        String r10 = i202 & 256 != 0 ? challengeNotificationModel2.entryImageUrl : str4;
        boolean r11 = i202 & 512 != 0 ? challengeNotificationModel2.entryPublished : z2;
        String r12 = i202 & 1024 != 0 ? challengeNotificationModel2.entryDogId : str5;
        String r13 = i202 & 2048 != 0 ? challengeNotificationModel2.challengeId : str6;
        String r14 = i202 & 4096 != 0 ? challengeNotificationModel2.entryOwnerUserId : str7;
        String r15 = i202 & 8192 != 0 ? challengeNotificationModel2.entryComment : str8;
        r15 = i202 & 16384 != 0 ? challengeNotificationModel2.entryVotes : i;
        r15 = i202 & 32768 != 0 ? challengeNotificationModel2.entryDogAvatarUrl : str9;
        r15 = i202 & 65536 != 0 ? challengeNotificationModel2.entryImages : map;
        String r1 = i202 & 131072 != 0 ? challengeNotificationModel2.entryId : str10;
        return challengeNotificationModel.copy(list22, timestamp32, str42, z52, boolean62, integer72, str82, str92, str102, z112, str122, str132, str142, (i202 & 8192 != 0 ? challengeNotificationModel2.entryComment : str8), (i202 & 16384 != 0 ? challengeNotificationModel2.entryVotes : i), (i202 & 32768 != 0 ? challengeNotificationModel2.entryDogAvatarUrl : str9), map182, (i202 & 131072 != 0 ? challengeNotificationModel2.entryId : str10));
    }

    /* operator */ public final List<ChallengeNotificationModel.MiniCommentObject> component1() {
        return this.comments;
    }

    /* operator */ public final boolean component10() {
        return this.entryPublished;
    }

    /* operator */ public final String component11() {
        return this.entryDogId;
    }

    /* operator */ public final String component12() {
        return this.challengeId;
    }

    /* operator */ public final String component13() {
        return this.entryOwnerUserId;
    }

    /* operator */ public final String component14() {
        return this.entryComment;
    }

    /* operator */ public final int component15() {
        return this.entryVotes;
    }

    /* operator */ public final String component16() {
        return this.entryDogAvatarUrl;
    }

    /* operator */ public final Map<String, ChallengeNotificationModel.EntryImageObject> component17() {
        return this.entryImages;
    }

    /* operator */ public final String component18() {
        return this.entryId;
    }

    /* operator */ public final Timestamp component2() {
        return this.sortingDate;
    }

    /* operator */ public final String component3() {
        return this.entryImageUrl_320;
    }

    /* operator */ public final boolean component4() {
        return this.following;
    }

    /* operator */ public final Boolean component5() {
        return this.isActive;
    }

    /* operator */ public final Integer component6() {
        return this.newEntryVotes;
    }

    /* operator */ public final String component7() {
        return this.entryCountry;
    }

    /* operator */ public final String component8() {
        return this.entryDogName;
    }

    /* operator */ public final String component9() {
        return this.entryImageUrl;
    }

    public final ChallengeNotificationModel copy(List<ChallengeNotificationModel.MiniCommentObject> comments, Timestamp sortingDate, String entryImageUrl_320, boolean following, Boolean isActive, Integer newEntryVotes, String entryCountry, String entryDogName, String entryImageUrl, boolean entryPublished, String entryDogId, String challengeId, String entryOwnerUserId, String entryComment, int entryVotes, String entryDogAvatarUrl, Map<String, ChallengeNotificationModel.EntryImageObject> entryImages, String entryId) {
        n.f(entryOwnerUserId, "entryOwnerUserId");
        n.f(entryId, "entryId");
        ChallengeNotificationModel challengeNotificationModel = new ChallengeNotificationModel(comments, sortingDate, entryImageUrl_320, following, isActive, newEntryVotes, entryCountry, entryDogName, entryImageUrl, entryPublished, entryDogId, challengeId, entryOwnerUserId, entryComment, entryVotes, entryDogAvatarUrl, entryImages, entryId);
        return challengeNotificationModel;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z17 = false;
        if (!(other instanceof ChallengeNotificationModel)) {
            return false;
        }
        if (!n.b(this.comments, other.comments)) {
            return false;
        }
        if (!n.b(this.sortingDate, other.sortingDate)) {
            return false;
        }
        if (!n.b(this.entryImageUrl_320, other.entryImageUrl_320)) {
            return false;
        }
        if (this.following != other.following) {
            return false;
        }
        if (!n.b(this.isActive, other.isActive)) {
            return false;
        }
        if (!n.b(this.newEntryVotes, other.newEntryVotes)) {
            return false;
        }
        if (!n.b(this.entryCountry, other.entryCountry)) {
            return false;
        }
        if (!n.b(this.entryDogName, other.entryDogName)) {
            return false;
        }
        if (!n.b(this.entryImageUrl, other.entryImageUrl)) {
            return false;
        }
        if (this.entryPublished != other.entryPublished) {
            return false;
        }
        if (!n.b(this.entryDogId, other.entryDogId)) {
            return false;
        }
        if (!n.b(this.challengeId, other.challengeId)) {
            return false;
        }
        if (!n.b(this.entryOwnerUserId, other.entryOwnerUserId)) {
            return false;
        }
        if (!n.b(this.entryComment, other.entryComment)) {
            return false;
        }
        if (this.entryVotes != other.entryVotes) {
            return false;
        }
        if (!n.b(this.entryDogAvatarUrl, other.entryDogAvatarUrl)) {
            return false;
        }
        if (!n.b(this.entryImages, other.entryImages)) {
            return false;
        }
        return !n.b(this.entryId, other.entryId) ? z17 : z;
    }

    public int hashCode() {
        int i;
        boolean following2;
        boolean entryPublished2 = true;
        i = 0;
        if (this.comments == null) {
        } else {
            i = this.comments.hashCode();
        }
        if (this.sortingDate == null) {
        } else {
            i = this.sortingDate.hashCode();
        }
        if (this.entryImageUrl_320 == null) {
        } else {
            i = this.entryImageUrl_320.hashCode();
        }
        if (this.following) {
        }
        if (this.isActive == null) {
        } else {
            i = this.isActive.hashCode();
        }
        if (this.newEntryVotes == null) {
        } else {
            i = this.newEntryVotes.hashCode();
        }
        if (this.entryCountry == null) {
        } else {
            i = this.entryCountry.hashCode();
        }
        if (this.entryDogName == null) {
        } else {
            i = this.entryDogName.hashCode();
        }
        if (this.entryImageUrl == null) {
        } else {
            i = this.entryImageUrl.hashCode();
        }
        if (!(this.entryPublished)) {
        }
        if (this.entryDogId == null) {
        } else {
            i = this.entryDogId.hashCode();
        }
        if (this.challengeId == null) {
        } else {
            i = this.challengeId.hashCode();
        }
        if (this.entryComment == null) {
        } else {
            i = this.entryComment.hashCode();
        }
        if (this.entryDogAvatarUrl == null) {
        } else {
            i = this.entryDogAvatarUrl.hashCode();
        }
        if (this.entryImages != null) {
            i = this.entryImages.hashCode();
        }
        return (i * 31) + i * 31 + i * 31 + following2 * 31 + i * 31 + i * 31 + i * 31 + i * 31 + i * 31 + entryPublished2 * 31 + i * 31 + i * 31 + this.entryOwnerUserId.hashCode() * 31 + i * 31 + Integer.hashCode(this.entryVotes) * 31 + i * 31 + i * 31 + this.entryId.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ChallengeNotificationModel(comments=";
        String str3 = ", sortingDate=";
        String str4 = ", entryImageUrl_320=";
        String str5 = ", following=";
        String str6 = ", isActive=";
        String str7 = ", newEntryVotes=";
        String str8 = ", entryCountry=";
        String str9 = ", entryDogName=";
        String str10 = ", entryImageUrl=";
        String str11 = ", entryPublished=";
        String str12 = ", entryDogId=";
        String str13 = ", challengeId=";
        String str14 = ", entryOwnerUserId=";
        String str15 = ", entryComment=";
        String str16 = ", entryVotes=";
        String str17 = ", entryDogAvatarUrl=";
        String str18 = ", entryImages=";
        String str19 = ", entryId=";
        str = str2 + this.comments + str3 + this.sortingDate + str4 + this.entryImageUrl_320 + str5 + this.following + str6 + this.isActive + str7 + this.newEntryVotes + str8 + this.entryCountry + str9 + this.entryDogName + str10 + this.entryImageUrl + str11 + this.entryPublished + str12 + this.entryDogId + str13 + this.challengeId + str14 + this.entryOwnerUserId + str15 + this.entryComment + str16 + this.entryVotes + str17 + this.entryDogAvatarUrl + str18 + this.entryImages + str19 + this.entryId + 41;
        return str;
    }
}
