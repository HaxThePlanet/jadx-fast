package app.dogo.com.dogo_android.model;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentId;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u000b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0008:\u0008\u0086\u0008\u0018\u00002\u00020\u0001:\u0002RSBå\u0001\u0012\u0010\u0008\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r\u0012\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0008\u0012\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0008\u0012\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0008\u0012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\n\u0012\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0008\u0012\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0008\u0012\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0008\u0012\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0008\u0012\u0008\u0008\u0002\u0010\u0016\u001a\u00020\r\u0012\n\u0008\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0008\u0012\u0016\u0008\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019\u0012\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u0008¢\u0006\u0002\u0010\u001cJ\u0011\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010;\u001a\u00020\nHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0008HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0008HÆ\u0003J\t\u0010>\u001a\u00020\u0008HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0008HÆ\u0003J\t\u0010@\u001a\u00020\rHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0008HÆ\u0003J\u0017\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019HÆ\u0003J\t\u0010C\u001a\u00020\u0008HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0008HÆ\u0003J\t\u0010F\u001a\u00020\nHÆ\u0003J\u0010\u0010G\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00103J\u0010\u0010H\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00106J\u000b\u0010I\u001a\u0004\u0018\u00010\u0008HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0008HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0008HÆ\u0003Jî\u0001\u0010L\u001a\u00020\u00002\u0010\u0008\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r2\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00082\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00082\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00082\u0008\u0008\u0002\u0010\u0011\u001a\u00020\n2\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00082\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00082\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00082\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00082\u0008\u0008\u0002\u0010\u0016\u001a\u00020\r2\n\u0008\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00082\u0016\u0008\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u0008HÆ\u0001¢\u0006\u0002\u0010MJ\u0013\u0010N\u001a\u00020\n2\u0008\u0010O\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010P\u001a\u00020\rHÖ\u0001J\t\u0010Q\u001a\u00020\u0008HÖ\u0001R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\u001eR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\"\u0010\u001e\"\u0004\u0008#\u0010$R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010\u001eR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010\u001eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010\u001eR\u0016\u0010\u001b\u001a\u00020\u00088\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010\u001eR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010\u001eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010\u001eR\u001f\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010,R\u0011\u0010\u0014\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010\u001eR\u0011\u0010\u0011\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010/R\u0011\u0010\u0016\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u00080\u00101R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u00082\u0010/R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u00104\u001a\u0004\u0008\u000b\u00103R\u0015\u0010\u000c\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u00107\u001a\u0004\u00085\u00106R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u00088\u00109¨\u0006T", d2 = {"Lapp/dogo/com/dogo_android/model/ChallengeNotificationModel;", "", "comments", "", "Lapp/dogo/com/dogo_android/model/ChallengeNotificationModel$MiniCommentObject;", "sortingDate", "Lcom/google/firebase/Timestamp;", "entryImageUrl_320", "", "following", "", "isActive", "newEntryVotes", "", "entryCountry", "entryDogName", "entryImageUrl", "entryPublished", "entryDogId", "challengeId", "entryOwnerUserId", "entryComment", "entryVotes", "entryDogAvatarUrl", "entryImages", "", "Lapp/dogo/com/dogo_android/model/ChallengeNotificationModel$EntryImageObject;", "entryId", "(Ljava/util/List;Lcom/google/firebase/Timestamp;Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "getChallengeId", "()Ljava/lang/String;", "getComments", "()Ljava/util/List;", "getEntryComment", "getEntryCountry", "setEntryCountry", "(Ljava/lang/String;)V", "getEntryDogAvatarUrl", "getEntryDogId", "getEntryDogName", "getEntryId", "getEntryImageUrl", "getEntryImageUrl_320", "getEntryImages", "()Ljava/util/Map;", "getEntryOwnerUserId", "getEntryPublished", "()Z", "getEntryVotes", "()I", "getFollowing", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNewEntryVotes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSortingDate", "()Lcom/google/firebase/Timestamp;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/List;Lcom/google/firebase/Timestamp;Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/Map;Ljava/lang/String;)Lapp/dogo/com/dogo_android/model/ChallengeNotificationModel;", "equals", "other", "hashCode", "toString", "EntryImageObject", "MiniCommentObject", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ChallengeNotificationModel {

    private final String challengeId;
    private final List<app.dogo.com.dogo_android.model.ChallengeNotificationModel.MiniCommentObject> comments;
    private final String entryComment;
    private String entryCountry;
    private final String entryDogAvatarUrl;
    private final String entryDogId;
    private final String entryDogName;
    @DocumentId
    private final String entryId;
    private final String entryImageUrl;
    private final String entryImageUrl_320;
    private final Map<String, app.dogo.com.dogo_android.model.ChallengeNotificationModel.EntryImageObject> entryImages;
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
        public EntryImageObject() {
            super(0, 0, 0, 0, 0, 0, 0, obj8, 0, 255, 0);
        }

        public EntryImageObject(String string, Timestamp timestamp2, String string3, String string4, String string5, String string6, long l7, boolean z8) {
            n.f(string, "imageId");
            n.f(string3, "imageUrl_320");
            n.f(string4, "imageUrl_640");
            n.f(string5, "imageUrl_1280");
            n.f(string6, "imageUrl");
            super();
            this.imageId = string;
            this.createdAt = timestamp2;
            this.imageUrl_320 = string3;
            this.imageUrl_640 = string4;
            this.imageUrl_1280 = string5;
            this.imageUrl = string6;
            this.votes = l7;
            this.featured = obj10;
        }

        public EntryImageObject(String string, Timestamp timestamp2, String string3, String string4, String string5, String string6, long l7, boolean z8, int i9, g g10) {
            int i3;
            String str4;
            String str2;
            int i2;
            String str5;
            String str;
            String str3;
            int i;
            int i4 = g10;
            str2 = "";
            str4 = i4 & 1 != 0 ? str2 : string;
            i2 = i4 & 2 != 0 ? 0 : timestamp2;
            str5 = i4 & 4 != 0 ? str2 : string3;
            str = i4 & 8 != 0 ? str2 : string4;
            str3 = i4 & 16 != 0 ? str2 : string5;
            if (i4 & 32 != 0) {
            } else {
                str2 = string6;
            }
            i = i4 & 64 != 0 ? 0 : l7;
            i3 = i4 &= 128 != 0 ? 0 : i9;
            super(str4, i2, str5, str, str3, str2, i, i9, i3);
        }

        public static app.dogo.com.dogo_android.model.ChallengeNotificationModel.EntryImageObject copy$default(app.dogo.com.dogo_android.model.ChallengeNotificationModel.EntryImageObject challengeNotificationModel$EntryImageObject, String string2, Timestamp timestamp3, String string4, String string5, String string6, String string7, long l8, boolean z9, int i10, Object object11) {
            boolean featured;
            String imageId;
            Timestamp createdAt;
            String str3;
            String str;
            String str2;
            String imageUrl;
            long votes;
            Object obj = entryImageObject;
            int i = object11;
            imageId = i & 1 != 0 ? obj.imageId : string2;
            createdAt = i & 2 != 0 ? obj.createdAt : timestamp3;
            str3 = i & 4 != 0 ? obj.imageUrl_320 : string4;
            str = i & 8 != 0 ? obj.imageUrl_640 : string5;
            str2 = i & 16 != 0 ? obj.imageUrl_1280 : string6;
            imageUrl = i & 32 != 0 ? obj.imageUrl : string7;
            votes = i & 64 != 0 ? obj.votes : l8;
            featured = i &= 128 != 0 ? obj.featured : i10;
            return entryImageObject.copy(imageId, createdAt, str3, str, str2, imageUrl, votes, z9);
        }

        public final String component1() {
            return this.imageId;
        }

        public final Timestamp component2() {
            return this.createdAt;
        }

        public final String component3() {
            return this.imageUrl_320;
        }

        public final String component4() {
            return this.imageUrl_640;
        }

        public final String component5() {
            return this.imageUrl_1280;
        }

        public final String component6() {
            return this.imageUrl;
        }

        public final long component7() {
            return this.votes;
        }

        public final boolean component8() {
            return this.featured;
        }

        public final app.dogo.com.dogo_android.model.ChallengeNotificationModel.EntryImageObject copy(String string, Timestamp timestamp2, String string3, String string4, String string5, String string6, long l7, boolean z8) {
            n.f(string, "imageId");
            n.f(string3, "imageUrl_320");
            n.f(string4, "imageUrl_640");
            final Object obj = string5;
            n.f(obj, "imageUrl_1280");
            final Object obj2 = string6;
            n.f(obj2, "imageUrl");
            super(string, timestamp2, string3, string4, obj, obj2, l7, obj9, obj20);
            return entryImageObject;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (object instanceof ChallengeNotificationModel.EntryImageObject == null) {
                return i2;
            }
            if (!n.b(this.imageId, object.imageId)) {
                return i2;
            }
            if (!n.b(this.createdAt, object.createdAt)) {
                return i2;
            }
            if (!n.b(this.imageUrl_320, object.imageUrl_320)) {
                return i2;
            }
            if (!n.b(this.imageUrl_640, object.imageUrl_640)) {
                return i2;
            }
            if (!n.b(this.imageUrl_1280, object.imageUrl_1280)) {
                return i2;
            }
            if (!n.b(this.imageUrl, object.imageUrl)) {
                return i2;
            }
            if (Long.compare(votes, votes2) != 0) {
                return i2;
            }
            if (this.featured != object.featured) {
                return i2;
            }
            return i;
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

        public int hashCode() {
            int i;
            boolean featured;
            Timestamp createdAt = this.createdAt;
            if (createdAt == null) {
                i = 0;
            } else {
                i = createdAt.hashCode();
            }
            if (this.featured) {
                featured = 1;
            }
            return i15 += featured;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("EntryImageObject(imageId=");
            stringBuilder.append(this.imageId);
            stringBuilder.append(", createdAt=");
            stringBuilder.append(this.createdAt);
            stringBuilder.append(", imageUrl_320=");
            stringBuilder.append(this.imageUrl_320);
            stringBuilder.append(", imageUrl_640=");
            stringBuilder.append(this.imageUrl_640);
            stringBuilder.append(", imageUrl_1280=");
            stringBuilder.append(this.imageUrl_1280);
            stringBuilder.append(", imageUrl=");
            stringBuilder.append(this.imageUrl);
            stringBuilder.append(", votes=");
            stringBuilder.append(this.votes);
            stringBuilder.append(", featured=");
            stringBuilder.append(this.featured);
            stringBuilder.append(')');
            return stringBuilder.toString();
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
        public MiniCommentObject() {
            super(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4095, 0);
        }

        public MiniCommentObject(Timestamp timestamp, String string2, String string3, String string4, String string5, String string6, boolean z7, String string8, String string9, String string10, String string11, int i12) {
            n.f(string3, "dogId");
            n.f(string5, "id");
            n.f(string6, "message");
            n.f(string11, "userId");
            super();
            this.date = timestamp;
            this.dogAvatarUrl = string2;
            this.dogId = string3;
            this.dogName = string4;
            this.id = string5;
            this.message = string6;
            this.published = z7;
            this.replyDogId = string8;
            this.replyDogName = string9;
            this.replyUserId = string10;
            this.userId = string11;
            this.votes = i12;
        }

        public MiniCommentObject(Timestamp timestamp, String string2, String string3, String string4, String string5, String string6, boolean z7, String string8, String string9, String string10, String string11, int i12, int i13, g g14) {
            int i2;
            int i6;
            String str;
            String str5;
            String str2;
            int i4;
            String str4;
            String str3;
            int i;
            int i7;
            int i3;
            int i5;
            int i8 = i13;
            i6 = 0;
            i2 = i8 & 1 != 0 ? i6 : timestamp;
            str5 = "";
            str = i8 & 2 != 0 ? str5 : string2;
            str2 = i8 & 4 != 0 ? str5 : string3;
            i4 = i8 & 8 != 0 ? i6 : string4;
            str4 = i8 & 16 != 0 ? str5 : string5;
            str3 = i8 & 32 != 0 ? str5 : string6;
            i = i8 & 64 != 0 ? i7 : z7;
            i3 = i8 & 128 != 0 ? i6 : string8;
            i5 = i8 & 256 != 0 ? i6 : string9;
            if (i8 & 512 != 0) {
            } else {
                i6 = string10;
            }
            if (i8 & 1024 != 0) {
            } else {
                str5 = string11;
            }
            if (i8 &= 2048 != 0) {
            } else {
                i7 = i12;
            }
            super(i2, str, str2, i4, str4, str3, i, i3, i5, i6, str5, i7);
        }

        public static app.dogo.com.dogo_android.model.ChallengeNotificationModel.MiniCommentObject copy$default(app.dogo.com.dogo_android.model.ChallengeNotificationModel.MiniCommentObject challengeNotificationModel$MiniCommentObject, Timestamp timestamp2, String string3, String string4, String string5, String string6, String string7, boolean z8, String string9, String string10, String string11, String string12, int i13, int i14, Object object15) {
            int votes;
            Timestamp date;
            String dogAvatarUrl;
            String dogId;
            String dogName;
            String str;
            String message;
            boolean published;
            String replyDogId;
            String replyDogName;
            String replyUserId;
            String userId;
            Object obj = miniCommentObject;
            int i = i14;
            date = i & 1 != 0 ? obj.date : timestamp2;
            dogAvatarUrl = i & 2 != 0 ? obj.dogAvatarUrl : string3;
            dogId = i & 4 != 0 ? obj.dogId : string4;
            dogName = i & 8 != 0 ? obj.dogName : string5;
            str = i & 16 != 0 ? obj.id : string6;
            message = i & 32 != 0 ? obj.message : string7;
            published = i & 64 != 0 ? obj.published : z8;
            replyDogId = i & 128 != 0 ? obj.replyDogId : string9;
            replyDogName = i & 256 != 0 ? obj.replyDogName : string10;
            replyUserId = i & 512 != 0 ? obj.replyUserId : string11;
            userId = i & 1024 != 0 ? obj.userId : string12;
            votes = i &= 2048 != 0 ? obj.votes : i13;
            return miniCommentObject.copy(date, dogAvatarUrl, dogId, dogName, str, message, published, replyDogId, replyDogName, replyUserId, userId, votes);
        }

        public final Timestamp component1() {
            return this.date;
        }

        public final String component10() {
            return this.replyUserId;
        }

        public final String component11() {
            return this.userId;
        }

        public final int component12() {
            return this.votes;
        }

        public final String component2() {
            return this.dogAvatarUrl;
        }

        public final String component3() {
            return this.dogId;
        }

        public final String component4() {
            return this.dogName;
        }

        public final String component5() {
            return this.id;
        }

        public final String component6() {
            return this.message;
        }

        public final boolean component7() {
            return this.published;
        }

        public final String component8() {
            return this.replyDogId;
        }

        public final String component9() {
            return this.replyDogName;
        }

        public final app.dogo.com.dogo_android.model.ChallengeNotificationModel.MiniCommentObject copy(Timestamp timestamp, String string2, String string3, String string4, String string5, String string6, boolean z7, String string8, String string9, String string10, String string11, int i12) {
            final Object obj = string3;
            n.f(obj, "dogId");
            final Object obj2 = string5;
            n.f(obj2, "id");
            final Object obj3 = string6;
            n.f(obj3, "message");
            final Object obj4 = string11;
            n.f(obj4, "userId");
            super(timestamp, string2, obj, string4, obj2, obj3, z7, string8, string9, string10, obj4, i12);
            return miniCommentObject;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (object instanceof ChallengeNotificationModel.MiniCommentObject == null) {
                return i2;
            }
            if (!n.b(this.date, object.date)) {
                return i2;
            }
            if (!n.b(this.dogAvatarUrl, object.dogAvatarUrl)) {
                return i2;
            }
            if (!n.b(this.dogId, object.dogId)) {
                return i2;
            }
            if (!n.b(this.dogName, object.dogName)) {
                return i2;
            }
            if (!n.b(this.id, object.id)) {
                return i2;
            }
            if (!n.b(this.message, object.message)) {
                return i2;
            }
            if (this.published != object.published) {
                return i2;
            }
            if (!n.b(this.replyDogId, object.replyDogId)) {
                return i2;
            }
            if (!n.b(this.replyDogName, object.replyDogName)) {
                return i2;
            }
            if (!n.b(this.replyUserId, object.replyUserId)) {
                return i2;
            }
            if (!n.b(this.userId, object.userId)) {
                return i2;
            }
            if (this.votes != object.votes) {
                return i2;
            }
            return i;
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

        public int hashCode() {
            int i;
            int i6;
            int i2;
            int i3;
            boolean published;
            int i4;
            int i5;
            Timestamp date = this.date;
            i6 = 0;
            if (date == null) {
                i = i6;
            } else {
                i = date.hashCode();
            }
            String dogAvatarUrl = this.dogAvatarUrl;
            if (dogAvatarUrl == null) {
                i2 = i6;
            } else {
                i2 = dogAvatarUrl.hashCode();
            }
            String dogName = this.dogName;
            if (dogName == null) {
                i3 = i6;
            } else {
                i3 = dogName.hashCode();
            }
            if (this.published) {
                published = 1;
            }
            String replyDogId = this.replyDogId;
            if (replyDogId == null) {
                i4 = i6;
            } else {
                i4 = replyDogId.hashCode();
            }
            String replyDogName = this.replyDogName;
            if (replyDogName == null) {
                i5 = i6;
            } else {
                i5 = replyDogName.hashCode();
            }
            String replyUserId = this.replyUserId;
            if (replyUserId == null) {
            } else {
                i6 = replyUserId.hashCode();
            }
            return i27 += i30;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("MiniCommentObject(date=");
            stringBuilder.append(this.date);
            stringBuilder.append(", dogAvatarUrl=");
            stringBuilder.append(this.dogAvatarUrl);
            stringBuilder.append(", dogId=");
            stringBuilder.append(this.dogId);
            stringBuilder.append(", dogName=");
            stringBuilder.append(this.dogName);
            stringBuilder.append(", id=");
            stringBuilder.append(this.id);
            stringBuilder.append(", message=");
            stringBuilder.append(this.message);
            stringBuilder.append(", published=");
            stringBuilder.append(this.published);
            stringBuilder.append(", replyDogId=");
            stringBuilder.append(this.replyDogId);
            stringBuilder.append(", replyDogName=");
            stringBuilder.append(this.replyDogName);
            stringBuilder.append(", replyUserId=");
            stringBuilder.append(this.replyUserId);
            stringBuilder.append(", userId=");
            stringBuilder.append(this.userId);
            stringBuilder.append(", votes=");
            stringBuilder.append(this.votes);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }
    public ChallengeNotificationModel() {
        super(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 262143, 0);
    }

    public ChallengeNotificationModel(List<app.dogo.com.dogo_android.model.ChallengeNotificationModel.MiniCommentObject> list, Timestamp timestamp2, String string3, boolean z4, Boolean boolean5, Integer integer6, String string7, String string8, String string9, boolean z10, String string11, String string12, String string13, String string14, int i15, String string16, Map<String, app.dogo.com.dogo_android.model.ChallengeNotificationModel.EntryImageObject> map17, String string18) {
        final Object obj = this;
        Object obj2 = string13;
        final Object obj3 = string18;
        n.f(obj2, "entryOwnerUserId");
        n.f(obj3, "entryId");
        super();
        obj.comments = list;
        obj.sortingDate = timestamp2;
        obj.entryImageUrl_320 = string3;
        obj.following = z4;
        obj.isActive = boolean5;
        obj.newEntryVotes = integer6;
        obj.entryCountry = string7;
        obj.entryDogName = string8;
        obj.entryImageUrl = string9;
        obj.entryPublished = z10;
        obj.entryDogId = string11;
        obj.challengeId = string12;
        obj.entryOwnerUserId = obj2;
        obj.entryComment = string14;
        obj.entryVotes = i15;
        obj.entryDogAvatarUrl = string16;
        obj.entryImages = map17;
        obj.entryId = obj3;
    }

    public ChallengeNotificationModel(List list, Timestamp timestamp2, String string3, boolean z4, Boolean boolean5, Integer integer6, String string7, String string8, String string9, boolean z10, String string11, String string12, String string13, String string14, int i15, String string16, Map map17, String string18, int i19, g g20) {
        int i14;
        int i13;
        int i5;
        int i4;
        int i2;
        int i10;
        Boolean fALSE;
        Integer valueOf;
        int i7;
        int i8;
        int i3;
        int i;
        int i11;
        int i12;
        String str2;
        String str;
        int i6;
        int i9;
        int i16 = i19;
        i14 = i16 & 1 != 0 ? 0 : list;
        i5 = i16 & 2 != 0 ? 0 : timestamp2;
        i4 = i16 & 4 != 0 ? 0 : string3;
        int i24 = 0;
        i2 = i16 & 8 != 0 ? i24 : z4;
        fALSE = i16 & 16 != 0 ? Boolean.FALSE : boolean5;
        if (i16 & 32 != 0) {
            valueOf = Integer.valueOf(i24);
        } else {
            valueOf = integer6;
        }
        i7 = i16 & 64 != 0 ? 0 : string7;
        i8 = i16 & 128 != 0 ? 0 : string8;
        i3 = i16 & 256 != 0 ? 0 : string9;
        i = i16 & 512 != 0 ? i24 : z10;
        i11 = i16 & 1024 != 0 ? 0 : string11;
        i12 = i16 & 2048 != 0 ? 0 : string12;
        str2 = i16 & 4096 != 0 ? str : string13;
        i13 = i16 & 8192 != 0 ? 0 : string14;
        i10 = i16 & 16384 != 0 ? 0 : i15;
        i6 = i16 & i35 != 0 ? 0 : string16;
        i9 = i16 & i37 != 0 ? 0 : map17;
        if (i16 &= i39 != 0) {
        } else {
            str = string18;
        }
        super(i14, i5, i4, i2, fALSE, valueOf, i7, i8, i3, i, i11, i12, str2, i13, i10, i6, i9, str);
    }

    public static app.dogo.com.dogo_android.model.ChallengeNotificationModel copy$default(app.dogo.com.dogo_android.model.ChallengeNotificationModel challengeNotificationModel, List list2, Timestamp timestamp3, String string4, boolean z5, Boolean boolean6, Integer integer7, String string8, String string9, String string10, boolean z11, String string12, String string13, String string14, String string15, int i16, String string17, Map map18, String string19, int i20, Object object21) {
        String entryId;
        List comments;
        Timestamp sortingDate;
        String str;
        boolean following;
        Boolean isActive;
        Integer newEntryVotes;
        String entryCountry;
        String entryDogName;
        String entryImageUrl;
        boolean entryPublished;
        String entryDogId;
        String challengeId;
        String entryOwnerUserId;
        String entryComment;
        int entryVotes;
        String entryDogAvatarUrl;
        Map entryImages;
        Object obj = challengeNotificationModel;
        int i = i20;
        comments = i & 1 != 0 ? obj.comments : list2;
        sortingDate = i & 2 != 0 ? obj.sortingDate : timestamp3;
        str = i & 4 != 0 ? obj.entryImageUrl_320 : string4;
        following = i & 8 != 0 ? obj.following : z5;
        isActive = i & 16 != 0 ? obj.isActive : boolean6;
        newEntryVotes = i & 32 != 0 ? obj.newEntryVotes : integer7;
        entryCountry = i & 64 != 0 ? obj.entryCountry : string8;
        entryDogName = i & 128 != 0 ? obj.entryDogName : string9;
        entryImageUrl = i & 256 != 0 ? obj.entryImageUrl : string10;
        entryPublished = i & 512 != 0 ? obj.entryPublished : z11;
        entryDogId = i & 1024 != 0 ? obj.entryDogId : string12;
        challengeId = i & 2048 != 0 ? obj.challengeId : string13;
        entryOwnerUserId = i & 4096 != 0 ? obj.entryOwnerUserId : string14;
        entryComment = i & 8192 != 0 ? obj.entryComment : string15;
        entryVotes = i & 16384 != 0 ? obj.entryVotes : i16;
        entryDogAvatarUrl = i & i19 != 0 ? obj.entryDogAvatarUrl : string17;
        entryImages = i & i22 != 0 ? obj.entryImages : map18;
        entryId = i &= i24 != 0 ? obj.entryId : string19;
        return challengeNotificationModel.copy(comments, sortingDate, str, following, isActive, newEntryVotes, entryCountry, entryDogName, entryImageUrl, entryPublished, entryDogId, challengeId, entryOwnerUserId, entryComment, entryVotes, entryDogAvatarUrl, entryImages, entryId);
    }

    public final List<app.dogo.com.dogo_android.model.ChallengeNotificationModel.MiniCommentObject> component1() {
        return this.comments;
    }

    public final boolean component10() {
        return this.entryPublished;
    }

    public final String component11() {
        return this.entryDogId;
    }

    public final String component12() {
        return this.challengeId;
    }

    public final String component13() {
        return this.entryOwnerUserId;
    }

    public final String component14() {
        return this.entryComment;
    }

    public final int component15() {
        return this.entryVotes;
    }

    public final String component16() {
        return this.entryDogAvatarUrl;
    }

    public final Map<String, app.dogo.com.dogo_android.model.ChallengeNotificationModel.EntryImageObject> component17() {
        return this.entryImages;
    }

    public final String component18() {
        return this.entryId;
    }

    public final Timestamp component2() {
        return this.sortingDate;
    }

    public final String component3() {
        return this.entryImageUrl_320;
    }

    public final boolean component4() {
        return this.following;
    }

    public final Boolean component5() {
        return this.isActive;
    }

    public final Integer component6() {
        return this.newEntryVotes;
    }

    public final String component7() {
        return this.entryCountry;
    }

    public final String component8() {
        return this.entryDogName;
    }

    public final String component9() {
        return this.entryImageUrl;
    }

    public final app.dogo.com.dogo_android.model.ChallengeNotificationModel copy(List<app.dogo.com.dogo_android.model.ChallengeNotificationModel.MiniCommentObject> list, Timestamp timestamp2, String string3, boolean z4, Boolean boolean5, Integer integer6, String string7, String string8, String string9, boolean z10, String string11, String string12, String string13, String string14, int i15, String string16, Map<String, app.dogo.com.dogo_android.model.ChallengeNotificationModel.EntryImageObject> map17, String string18) {
        List list2 = list;
        n.f(string13, "entryOwnerUserId");
        n.f(string18, "entryId");
        super(list, timestamp2, string3, z4, boolean5, integer6, string7, string8, string9, z10, string11, string12, string13, string14, i15, string16, map17, string18);
        return challengeNotificationModel2;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ChallengeNotificationModel) {
            return i2;
        }
        if (!n.b(this.comments, object.comments)) {
            return i2;
        }
        if (!n.b(this.sortingDate, object.sortingDate)) {
            return i2;
        }
        if (!n.b(this.entryImageUrl_320, object.entryImageUrl_320)) {
            return i2;
        }
        if (this.following != object.following) {
            return i2;
        }
        if (!n.b(this.isActive, object.isActive)) {
            return i2;
        }
        if (!n.b(this.newEntryVotes, object.newEntryVotes)) {
            return i2;
        }
        if (!n.b(this.entryCountry, object.entryCountry)) {
            return i2;
        }
        if (!n.b(this.entryDogName, object.entryDogName)) {
            return i2;
        }
        if (!n.b(this.entryImageUrl, object.entryImageUrl)) {
            return i2;
        }
        if (this.entryPublished != object.entryPublished) {
            return i2;
        }
        if (!n.b(this.entryDogId, object.entryDogId)) {
            return i2;
        }
        if (!n.b(this.challengeId, object.challengeId)) {
            return i2;
        }
        if (!n.b(this.entryOwnerUserId, object.entryOwnerUserId)) {
            return i2;
        }
        if (!n.b(this.entryComment, object.entryComment)) {
            return i2;
        }
        if (this.entryVotes != object.entryVotes) {
            return i2;
        }
        if (!n.b(this.entryDogAvatarUrl, object.entryDogAvatarUrl)) {
            return i2;
        }
        if (!n.b(this.entryImages, object.entryImages)) {
            return i2;
        }
        if (!n.b(this.entryId, object.entryId)) {
            return i2;
        }
        return i;
    }

    public final String getChallengeId() {
        return this.challengeId;
    }

    public final List<app.dogo.com.dogo_android.model.ChallengeNotificationModel.MiniCommentObject> getComments() {
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

    public final Map<String, app.dogo.com.dogo_android.model.ChallengeNotificationModel.EntryImageObject> getEntryImages() {
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

    public int hashCode() {
        int i4;
        int i12;
        int i9;
        int i5;
        boolean following;
        int i2;
        int i6;
        int i7;
        int i3;
        int i10;
        int i11;
        int i13;
        int i8;
        int i;
        boolean i14;
        List comments = this.comments;
        i12 = 0;
        if (comments == null) {
            i4 = i12;
        } else {
            i4 = comments.hashCode();
        }
        Timestamp sortingDate = this.sortingDate;
        if (sortingDate == null) {
            i9 = i12;
        } else {
            i9 = sortingDate.hashCode();
        }
        String entryImageUrl_320 = this.entryImageUrl_320;
        if (entryImageUrl_320 == null) {
            i5 = i12;
        } else {
            i5 = entryImageUrl_320.hashCode();
        }
        if (this.following) {
            following = i14;
        }
        Boolean isActive = this.isActive;
        if (isActive == null) {
            i2 = i12;
        } else {
            i2 = isActive.hashCode();
        }
        Integer newEntryVotes = this.newEntryVotes;
        if (newEntryVotes == null) {
            i6 = i12;
        } else {
            i6 = newEntryVotes.hashCode();
        }
        String entryCountry = this.entryCountry;
        if (entryCountry == null) {
            i7 = i12;
        } else {
            i7 = entryCountry.hashCode();
        }
        String entryDogName = this.entryDogName;
        if (entryDogName == null) {
            i3 = i12;
        } else {
            i3 = entryDogName.hashCode();
        }
        String entryImageUrl = this.entryImageUrl;
        if (entryImageUrl == null) {
            i10 = i12;
        } else {
            i10 = entryImageUrl.hashCode();
        }
        boolean entryPublished = this.entryPublished;
        if (entryPublished) {
        } else {
            i14 = entryPublished;
        }
        String entryDogId = this.entryDogId;
        if (entryDogId == null) {
            i11 = i12;
        } else {
            i11 = entryDogId.hashCode();
        }
        String challengeId = this.challengeId;
        if (challengeId == null) {
            i13 = i12;
        } else {
            i13 = challengeId.hashCode();
        }
        String entryComment = this.entryComment;
        if (entryComment == null) {
            i8 = i12;
        } else {
            i8 = entryComment.hashCode();
        }
        String entryDogAvatarUrl = this.entryDogAvatarUrl;
        if (entryDogAvatarUrl == null) {
            i = i12;
        } else {
            i = entryDogAvatarUrl.hashCode();
        }
        Map entryImages = this.entryImages;
        if (entryImages == null) {
        } else {
            i12 = entryImages.hashCode();
        }
        return i47 += i49;
    }

    public final Boolean isActive() {
        return this.isActive;
    }

    public final void setEntryCountry(String string) {
        this.entryCountry = string;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChallengeNotificationModel(comments=");
        stringBuilder.append(this.comments);
        stringBuilder.append(", sortingDate=");
        stringBuilder.append(this.sortingDate);
        stringBuilder.append(", entryImageUrl_320=");
        stringBuilder.append(this.entryImageUrl_320);
        stringBuilder.append(", following=");
        stringBuilder.append(this.following);
        stringBuilder.append(", isActive=");
        stringBuilder.append(this.isActive);
        stringBuilder.append(", newEntryVotes=");
        stringBuilder.append(this.newEntryVotes);
        stringBuilder.append(", entryCountry=");
        stringBuilder.append(this.entryCountry);
        stringBuilder.append(", entryDogName=");
        stringBuilder.append(this.entryDogName);
        stringBuilder.append(", entryImageUrl=");
        stringBuilder.append(this.entryImageUrl);
        stringBuilder.append(", entryPublished=");
        stringBuilder.append(this.entryPublished);
        stringBuilder.append(", entryDogId=");
        stringBuilder.append(this.entryDogId);
        stringBuilder.append(", challengeId=");
        stringBuilder.append(this.challengeId);
        stringBuilder.append(", entryOwnerUserId=");
        stringBuilder.append(this.entryOwnerUserId);
        stringBuilder.append(", entryComment=");
        stringBuilder.append(this.entryComment);
        stringBuilder.append(", entryVotes=");
        stringBuilder.append(this.entryVotes);
        stringBuilder.append(", entryDogAvatarUrl=");
        stringBuilder.append(this.entryDogAvatarUrl);
        stringBuilder.append(", entryImages=");
        stringBuilder.append(this.entryImages);
        stringBuilder.append(", entryId=");
        stringBuilder.append(this.entryId);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
