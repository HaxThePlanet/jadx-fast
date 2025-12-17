package app.dogo.com.dogo_android.model;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.v2.b;
import app.dogo.com.dogo_android.util.e0.t;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.l.a;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.Exclude;
import com.google.firebase.firestore.ServerTimestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.g0;
import kotlin.d0.d.n;
import kotlin.k0.l;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010 \n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0008\r\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u001b\n\u0002\u0010\t\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0010\u0002\n\u0002\u0008(\u0018\u0000 ±\u00012\u00020\u00012\u00020\u0002:\u0004±\u0001²\u0001B\u0007\u0008\u0016¢\u0006\u0002\u0010\u0003B\u001d\u0008\u0012\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005¢\u0006\u0002\u0010\u0008B\u000f\u0008\u0014\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020pJ\u0008\u0010r\u001a\u00020 H\u0016J\u0006\u0010s\u001a\u00020 J\u0008\u0010t\u001a\u0004\u0018\u00010\u0006J\n\u0010u\u001a\u0004\u0018\u000103H\u0007J\u0014\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u0007J\u0006\u0010w\u001a\u00020 J\u001a\u0010x\u001a\u0004\u0018\u00010\u00062\u0006\u0010y\u001a\u00020z2\u0006\u0010{\u001a\u00020 H\u0007J\u0010\u0010|\u001a\u0004\u0018\u00010\u00062\u0006\u0010}\u001a\u00020 J\u0008\u0010~\u001a\u0004\u0018\u00010\u0006J\u0010\u0010~\u001a\u0004\u0018\u00010\u00062\u0006\u0010y\u001a\u00020zJ\u0011\u0010\u007f\u001a\u0004\u0018\u00010\u00062\u0007\u0010\u0080\u0001\u001a\u00020\u0006J\u000f\u0010\u0081\u0001\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010\u0012J\u0007\u0010\u0082\u0001\u001a\u00020\u0018J\u0012\u0010\u0083\u0001\u001a\u00020\u00182\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0006J\u0011\u0010\u0084\u0001\u001a\u00020\u00182\u0006\u0010{\u001a\u00020 H\u0007J\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0006J\u0011\u0010\u0086\u0001\u001a\u0004\u0018\u00010%2\u0006\u0010{\u001a\u00020 J\u0007\u0010\u0087\u0001\u001a\u00020 J\t\u0010\u0088\u0001\u001a\u00020\u0018H\u0007J\t\u0010\u0089\u0001\u001a\u00020\u0018H\u0007J\u0013\u0010\u008a\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u008c\u0001\u001a\u00020 H\u0007J\u000f\u0010\u008d\u0001\u001a\u00020\u00182\u0006\u0010{\u001a\u00020 J\u000f\u0010\u008e\u0001\u001a\u00020\u00182\u0006\u0010}\u001a\u00020 J\u0012\u0010\u008f\u0001\u001a\u00020\u00182\u0007\u0010\u0090\u0001\u001a\u00020pH\u0007J\u0012\u0010\u0091\u0001\u001a\u00020\u00182\u0007\u0010\u0090\u0001\u001a\u00020pH\u0007J\t\u0010\u0092\u0001\u001a\u00020TH\u0007J\u0010\u0010\u0093\u0001\u001a\u00030\u008b\u00012\u0006\u0010}\u001a\u00020 J\u0011\u0010\u0094\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u0095\u0001\u001a\u00020\u0018J\u0010\u0010\u0096\u0001\u001a\u00030\u008b\u00012\u0006\u0010\u001f\u001a\u00020 J\u0012\u0010\u0097\u0001\u001a\u00030\u008b\u00012\u0006\u0010)\u001a\u00020\u0006H\u0016J\u0012\u0010\u0098\u0001\u001a\u00030\u008b\u00012\u0008\u0010+\u001a\u0004\u0018\u00010\u0006J\u0011\u0010\u0099\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u009a\u0001\u001a\u00020\u0018J\u0012\u0010\u009b\u0001\u001a\u00030\u008b\u00012\u0008\u00102\u001a\u0004\u0018\u000103J\u0012\u0010\u009c\u0001\u001a\u00030\u008b\u00012\u0006\u00104\u001a\u000205H\u0007J\u001b\u0010\u009d\u0001\u001a\u00030\u008b\u00012\u0006\u0010W\u001a\u00020\u00062\u0007\u0010\u009e\u0001\u001a\u00020\u0006H\u0007J\u0010\u0010\u009f\u0001\u001a\u00030\u008b\u00012\u0006\u00108\u001a\u00020 J\u0018\u0010 \u0001\u001a\u00030\u008b\u00012\u0006\u00109\u001a\u00020\u00182\u0006\u0010{\u001a\u00020 J1\u0010¡\u0001\u001a\u00030\u008b\u00012'\u0010¢\u0001\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u0018\u00010\u0005J\u0011\u0010£\u0001\u001a\u00030\u008b\u00012\u0007\u0010¤\u0001\u001a\u00020\u0018J\u001c\u0010¥\u0001\u001a\u00030\u008b\u00012\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00062\u0007\u0010¦\u0001\u001a\u00020\u0018J\u0012\u0010§\u0001\u001a\u00030\u008b\u00012\u0008\u0010W\u001a\u0004\u0018\u00010\u0006J\u0010\u0010¨\u0001\u001a\u00030\u008b\u00012\u0006\u0010f\u001a\u00020\u0018J!\u0010©\u0001\u001a\u00030\u008b\u00012\u0017\u0010ª\u0001\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0005J\u0010\u0010«\u0001\u001a\u00030\u008b\u00012\u0006\u0010k\u001a\u00020 J\u0013\u0010¬\u0001\u001a\u00030\u008b\u00012\u0007\u0010­\u0001\u001a\u00020 H\u0007J\u001c\u0010®\u0001\u001a\u00030\u008b\u00012\u0007\u0010¯\u0001\u001a\u00020\n2\u0007\u0010°\u0001\u001a\u00020 H\u0016R\u001c\u0010\u000c\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R \u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014\"\u0004\u0008\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001a\u0010\u000e\"\u0004\u0008\u001b\u0010\u0010R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001d\u0010\u000e\"\u0004\u0008\u001e\u0010\u0010R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\"\u0010\u000e\"\u0004\u0008#\u0010\u0010R$\u0010&\u001a\u0004\u0018\u00010%2\u0008\u0010$\u001a\u0004\u0018\u00010%8\u0006@BX\u0087\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010(R \u0010)\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00068G@BX\u0086.¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010\u000eR\u0010\u0010+\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010,\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008-\u0010\u000e\"\u0004\u0008.\u0010\u0010R\u001c\u0010/\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00080\u0010\u000e\"\u0004\u00081\u0010\u0010R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006078\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010:\u001a\u00020 8G¢\u0006\u0006\u001a\u0004\u0008;\u0010<R\u0010\u0010=\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010>\u001a\u0004\u0018\u00010\u00062\u0008\u0010$\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008?\u0010\u000eR\"\u0010@\u001a\u0004\u0018\u00010\u00062\u0008\u0010$\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008A\u0010\u000eR\"\u0010B\u001a\u0004\u0018\u00010\u00062\u0008\u0010$\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008C\u0010\u000eR\u0016\u0010D\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010G\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\u0008G\u0010HR\u0011\u0010I\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\u0008I\u0010HR\u0011\u0010J\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\u0008J\u0010HR\u000e\u0010K\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010L\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u00188G@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008L\u0010HR\u0011\u0010M\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\u0008M\u0010HR\u001c\u0010N\u001a\u00020\u00188GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008N\u0010H\"\u0004\u0008O\u0010PR\u001c\u0010Q\u001a\u00020\u00188GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008Q\u0010H\"\u0004\u0008R\u0010PR\u0011\u0010S\u001a\u00020T8F¢\u0006\u0006\u001a\u0004\u0008U\u0010VR\u0010\u0010W\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010X\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008Y\u0010H\"\u0004\u0008Z\u0010PR\u001e\u0010[\u001a\u0004\u0018\u00010\u00068GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\\\u0010\u000e\"\u0004\u0008]\u0010\u0010R\u001c\u0010^\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008_\u0010(\"\u0004\u0008`\u0010aR$\u0010b\u001a\u00020 2\u0006\u0010$\u001a\u00020 @GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008c\u0010<\"\u0004\u0008d\u0010eR\u000e\u0010f\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010g\u001a\u00020 2\u0006\u0010$\u001a\u00020 @BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008h\u0010<R\u0011\u0010i\u001a\u00020\u00068G¢\u0006\u0006\u001a\u0004\u0008j\u0010\u000eR\u000e\u0010k\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010l\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008m\u0010<\"\u0004\u0008n\u0010e¨\u0006³\u0001", d2 = {"Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "Lapp/dogo/com/dogo_android/util/base_classes/FirestoreCustomObject;", "Landroid/os/Parcelable;", "()V", "entryData", "", "", "", "(Ljava/util/Map;)V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "author", "getAuthor", "()Ljava/lang/String;", "setAuthor", "(Ljava/lang/String;)V", "badges", "", "getBadges", "()Ljava/util/List;", "setBadges", "(Ljava/util/List;)V", "challengeEnded", "", "challengeId", "getChallengeId", "setChallengeId", "comment", "getComment", "setComment", "commentCount", "", "country", "getCountry", "setCountry", "<set-?>", "Lcom/google/firebase/Timestamp;", "date", "getDate", "()Lcom/google/firebase/Timestamp;", "documentId", "getDocumentId", "dogAvatarUrl", "dogId", "getDogId", "setDogId", "dogName", "getDogName", "setDogName", "dogProfile", "Lapp/dogo/com/dogo_android/model/DogProfileModel;", "entryStateData", "Lapp/dogo/com/dogo_android/util/EntryStateDataHolder$EntryStateData;", "entryTranslations", "", "extraVotes", "featured", "imageCount", "getImageCount", "()I", "imageUrl", "imageUrl_1280", "getImageUrl_1280", "imageUrl_320", "getImageUrl_320", "imageUrl_640", "getImageUrl_640", "images", "", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel$MiniEntryModel;", "isAuthorAdmin", "()Z", "isAuthorAmbassador", "isAuthorPremium", "isBeingDeleted", "isDogFetch", "isLastPhoto", "isTranslatePressed", "setTranslatePressed", "(Z)V", "isUploadFailed", "setUploadFailed", "liteDogProfile", "Lapp/dogo/com/dogo_android/model/LiteDogProfile;", "getLiteDogProfile", "()Lapp/dogo/com/dogo_android/model/LiteDogProfile;", "locale", "published", "getPublished", "setPublished", "translatedCaption", "getTranslatedCaption", "setTranslatedCaption", "updatedAt", "getUpdatedAt", "setUpdatedAt", "(Lcom/google/firebase/Timestamp;)V", "uploadStatus", "getUploadStatus", "setUploadStatus", "(I)V", "userLiked", "viewCount", "getViewCount", "voteString", "getVoteString", "votes", "votesRank", "getVotesRank", "setVotesRank", "computeTimeTillAdditionalUploadInMillis", "", "currentTimeMillis", "describeContents", "getCommentCount", "getDogAvatarUrl", "getDogProfile", "getEntryTranslations", "getExtraVotes", "getImageAt", "resources", "Landroid/content/res/Resources;", "position", "getImageIdAt", "photoPosition", "getImageUrl", "getImageUrlOf", "photoId", "getImages", "getIsBeingDeleted", "getLikeStateForImage", "getLikeStateForImageAt", "getLocale", "getPhotoCreationTimestamp", "getVotes", "hasChallengeEnded", "hasUserLiked", "incrementVotes", "", "incrementValue", "isFeatured", "isLatestPhoto", "isPhotoUploading", "currentTimeInMillis", "isUploadStatusReadyToUpload", "parseLiteDogProfile", "removePhoto", "setChallengeEnded", "state", "setCommentCount", "setDocumentId", "setDogAvatarUrl", "setDogFetchFlag", "dogFetch", "setDogProfile", "setEntryStateData", "setEntryTranslations", "translation", "setExtraVotes", "setFeatured", "setImages", "remoteImages", "setIsBeingDeleted", "flag", "setLikeStateForImage", "likeState", "setLocale", "setUserLiked", "setUserLikedPhotos", "photoLikeStateMap", "setVotes", "updateCommentCount", "changedBy", "writeToParcel", "dest", "flags", "Companion", "MiniEntryModel", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ChallengeEntryModel implements t, Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.model.ChallengeEntryModel> CREATOR;
    public static final app.dogo.com.dogo_android.model.ChallengeEntryModel.Companion Companion;
    private String author;
    private List<String> badges;
    private boolean challengeEnded;
    private String challengeId;
    private String comment;
    private int commentCount;
    private String country;
    @ServerTimestamp
    private Timestamp date;
    private String documentId;
    private String dogAvatarUrl;
    private String dogId;
    private String dogName;
    private app.dogo.com.dogo_android.model.DogProfileModel dogProfile;
    private l.a entryStateData;
    @Exclude
    private final Map<String, String> entryTranslations;
    private int extraVotes;
    private boolean featured;
    private String imageUrl;
    private String imageUrl_1280;
    private String imageUrl_320;
    private String imageUrl_640;
    private List<app.dogo.com.dogo_android.model.ChallengeEntryModel.MiniEntryModel> images;
    private boolean isBeingDeleted;
    private boolean isDogFetch;
    private boolean isTranslatePressed;
    private boolean isUploadFailed;
    private String locale;
    private boolean published;
    private String translatedCaption;
    private Timestamp updatedAt;
    private int uploadStatus;
    private boolean userLiked;
    private int viewCount;
    private int votes;
    private int votesRank;

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0008R\u0016\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/model/ChallengeEntryModel$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "parseChallengeEntry", "entryData", "", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final app.dogo.com.dogo_android.model.ChallengeEntryModel parseChallengeEntry(Map<String, ? extends Object> map) {
            boolean challengeEntryModel;
            int i;
            n.f(map, "entryData");
            List list = Arrays.asList(Arrays.copyOf(/* result */, 5));
            n.e(list, "asList(*mandatoryFields)");
            if (map.keySet().containsAll(list)) {
                challengeEntryModel = new ChallengeEntryModel(map, 0);
                i = challengeEntryModel;
            }
            return i;
        }
    }

    @Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u0000 ,2\u00020\u00012\u0008\u0012\u0004\u0012\u00020\u00000\u0002:\u0001,B\u001f\u0008\u0016\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\u0010\u0007B\u000f\u0008\u0014\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0011\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0000H\u0096\u0002J\u0008\u0010%\u001a\u00020#H\u0016J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010&\u001a\u00020'J\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020#H\u0016R\"\u0010\r\u001a\u0004\u0018\u00010\u000c2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000c@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014R\"\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0012R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0012R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001b\u0010\u001d\"\u0004\u0008\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-", d2 = {"Lapp/dogo/com/dogo_android/model/ChallengeEntryModel$MiniEntryModel;", "Landroid/os/Parcelable;", "", "map", "", "", "", "(Ljava/util/Map;)V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "<set-?>", "Lcom/google/firebase/Timestamp;", "createdAt", "getCreatedAt", "()Lcom/google/firebase/Timestamp;", "imageId", "getImageId", "()Ljava/lang/String;", "setImageId", "(Ljava/lang/String;)V", "imageUrl", "getImageUrl", "imageUrl_1280", "imageUrl_320", "getImageUrl_320", "imageUrl_640", "isFeatured", "", "()Z", "setFeatured", "(Z)V", "votes", "", "compareTo", "", "other", "describeContents", "resources", "Landroid/content/res/Resources;", "writeToParcel", "", "dest", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class MiniEntryModel implements Parcelable, Comparable<app.dogo.com.dogo_android.model.ChallengeEntryModel.MiniEntryModel> {

        public static final Parcelable.Creator<app.dogo.com.dogo_android.model.ChallengeEntryModel.MiniEntryModel> CREATOR;
        public static final app.dogo.com.dogo_android.model.ChallengeEntryModel.MiniEntryModel.Companion Companion;
        private Timestamp createdAt;
        private String imageId;
        private String imageUrl;
        private String imageUrl_1280;
        private String imageUrl_320;
        private String imageUrl_640;
        private boolean isFeatured = false;
        private long votes;
        static {
            ChallengeEntryModel.MiniEntryModel.Companion companion = new ChallengeEntryModel.MiniEntryModel.Companion(0);
            ChallengeEntryModel.MiniEntryModel.Companion = companion;
            ChallengeEntryModel.MiniEntryModel.Companion.CREATOR.1 anon = new ChallengeEntryModel.MiniEntryModel.Companion.CREATOR.1();
            ChallengeEntryModel.MiniEntryModel.CREATOR = anon;
        }

        protected MiniEntryModel(Parcel parcel) {
            n.f(parcel, "in");
            super();
            this.imageUrl_320 = parcel.readString();
            this.imageUrl_640 = parcel.readString();
            this.imageUrl_1280 = parcel.readString();
            this.imageUrl = parcel.readString();
            this.votes = parcel.readLong();
            this.imageId = parcel.readString();
            this.createdAt = (Timestamp)parcel.readParcelable(Timestamp.class.getClassLoader());
            int obj3 = parcel.readByte() != 0 ? 1 : obj3;
            obj3 = 0;
        }

        public MiniEntryModel(Map<String, ? extends Object> map) {
            Object tRUE;
            Object obj3;
            n.f(map, "map");
            super();
            this.imageUrl_320 = (String)map.get("imageUrl_320");
            this.imageUrl_640 = (String)map.get("imageUrl_640");
            this.imageUrl_1280 = (String)map.get("imageUrl_1280");
            this.imageUrl = (String)map.get("imageUrl");
            Object obj5 = map.get("votes");
            n.d((Long)obj5);
            this.votes = obj5.longValue();
            this.imageId = (String)map.get("imageId");
            this.createdAt = (Timestamp)map.get("createdAt");
            tRUE = "featured";
            if (map.get(tRUE) != null && n.b(map.get(tRUE), Boolean.TRUE)) {
                obj3 = n.b(map.get(tRUE), Boolean.TRUE) ? 1 : obj3;
            }
            obj3 = 0;
        }

        @Override // android.os.Parcelable
        public int compareTo(app.dogo.com.dogo_android.model.ChallengeEntryModel.MiniEntryModel challengeEntryModel$MiniEntryModel) {
            Timestamp createdAt;
            int i;
            int obj3;
            n.f(miniEntryModel, "other");
            Timestamp createdAt2 = miniEntryModel.createdAt;
            if (createdAt2 == null && this.createdAt == null) {
                if (this.createdAt == null) {
                    return 0;
                }
            }
            if (createdAt2 == null) {
                return 1;
            }
            Timestamp createdAt3 = this.createdAt;
            if (createdAt3 == null) {
            } else {
                n.d(createdAt3);
                obj3 = miniEntryModel.createdAt;
                n.d(obj3);
                i *= obj3;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public int compareTo(Object object) {
            return compareTo((ChallengeEntryModel.MiniEntryModel)object);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final Timestamp getCreatedAt() {
            return this.createdAt;
        }

        @Override // android.os.Parcelable
        public final String getImageId() {
            return this.imageId;
        }

        @Override // android.os.Parcelable
        public final String getImageUrl() {
            return this.imageUrl;
        }

        @Override // android.os.Parcelable
        public final String getImageUrl(Resources resources) {
            int cmp;
            String obj2;
            n.f(resources, "resources");
            obj2 = (float)obj2;
            obj2 = Float.compare(obj2, i) < 0 ? this.imageUrl_320 : obj2 < 0 ? this.imageUrl_640 : this.imageUrl_1280;
            return obj2;
        }

        @Override // android.os.Parcelable
        public final String getImageUrl_320() {
            return this.imageUrl_320;
        }

        @Override // android.os.Parcelable
        public final boolean isFeatured() {
            return this.isFeatured;
        }

        @Override // android.os.Parcelable
        public final void setFeatured(boolean z) {
            this.isFeatured = z;
        }

        @Override // android.os.Parcelable
        public final void setImageId(String string) {
            this.imageId = string;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "dest");
            parcel.writeString(this.imageUrl_320);
            parcel.writeString(this.imageUrl_640);
            parcel.writeString(this.imageUrl_1280);
            parcel.writeString(this.imageUrl);
            parcel.writeLong(this.votes);
            parcel.writeString(this.imageId);
            parcel.writeParcelable(this.createdAt, i2);
            parcel.writeByte((byte)obj4);
        }
    }
    static {
        ChallengeEntryModel.Companion companion = new ChallengeEntryModel.Companion(0);
        ChallengeEntryModel.Companion = companion;
        ChallengeEntryModel.Companion.CREATOR.1 anon = new ChallengeEntryModel.Companion.CREATOR.1();
        ChallengeEntryModel.CREATOR = anon;
    }

    public ChallengeEntryModel() {
        super();
        ArrayList arrayList = new ArrayList();
        this.images = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.badges = arrayList2;
        HashMap hashMap = new HashMap();
        this.entryTranslations = hashMap;
    }

    protected ChallengeEntryModel(Parcel parcel) {
        int i7;
        int i4;
        int i6;
        int i3;
        int i5;
        int i2;
        int i8;
        int i;
        n.f(parcel, "in");
        super();
        ArrayList arrayList = new ArrayList();
        this.images = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.badges = arrayList2;
        HashMap hashMap = new HashMap();
        this.entryTranslations = hashMap;
        this.votes = parcel.readInt();
        this.extraVotes = parcel.readInt();
        this.dogAvatarUrl = parcel.readString();
        this.author = parcel.readString();
        this.challengeId = parcel.readString();
        this.imageUrl = parcel.readString();
        this.imageUrl_320 = parcel.readString();
        this.imageUrl_640 = parcel.readString();
        this.imageUrl_1280 = parcel.readString();
        i = 1;
        final int i9 = 0;
        i7 = parcel.readByte() != 0 ? i : i9;
        this.published = i7;
        i4 = parcel.readByte() != 0 ? i : i9;
        this.isBeingDeleted = i4;
        this.dogId = parcel.readString();
        i6 = parcel.readByte() != 0 ? i : i9;
        this.featured = i6;
        this.viewCount = parcel.readInt();
        this.commentCount = parcel.readInt();
        this.comment = parcel.readString();
        this.dogName = parcel.readString();
        this.locale = parcel.readString();
        this.images = parcel.createTypedArrayList(ChallengeEntryModel.MiniEntryModel.CREATOR);
        this.date = (Timestamp)parcel.readParcelable(Timestamp.class.getClassLoader());
        this.uploadStatus = parcel.readInt();
        i3 = parcel.readByte() != 0 ? i : i9;
        this.isTranslatePressed = i3;
        this.translatedCaption = parcel.readString();
        this.dogProfile = (DogProfileModel)parcel.readParcelable(DogProfileModel.class.getClassLoader());
        i5 = parcel.readByte() != 0 ? i : i9;
        this.isDogFetch = i5;
        String string13 = parcel.readString();
        Objects.requireNonNull(string13);
        this.documentId = string13;
        i2 = parcel.readByte() != 0 ? i : i9;
        this.userLiked = i2;
        i8 = parcel.readByte() != 0 ? i : i9;
        this.isUploadFailed = i8;
        if (parcel.readByte() != 0) {
        } else {
            i = i9;
        }
        this.challengeEnded = i;
        this.votesRank = parcel.readInt();
        this.country = parcel.readString();
    }

    private ChallengeEntryModel(Map<String, ? extends Object> map) {
        int intValue;
        int intValue2;
        String booleanValue;
        Object str;
        int i;
        List obj5;
        super();
        ArrayList arrayList = new ArrayList();
        this.images = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.badges = arrayList2;
        HashMap hashMap = new HashMap();
        this.entryTranslations = hashMap;
        String str2 = "votes";
        final String str19 = "null cannot be cast to non-null type kotlin.Int";
        i = 0;
        if (map.get(str2) != null) {
            Object obj15 = map.get(str2);
            Objects.requireNonNull(obj15, str19);
            intValue = (Integer)obj15.intValue();
        } else {
            intValue = i;
        }
        this.votes = intValue;
        String str3 = "extraVotes";
        if (map.get(str3) != null) {
            Object obj14 = map.get(str3);
            Objects.requireNonNull(obj14, str19);
            intValue2 = (Integer)obj14.intValue();
        } else {
            intValue2 = i;
        }
        this.extraVotes = intValue2;
        this.dogAvatarUrl = (String)map.get("dogAvatarUrl");
        this.author = (String)map.get("author");
        this.challengeId = (String)map.get("challengeId");
        this.imageUrl = (String)map.get("imageUrl");
        this.imageUrl_320 = (String)map.get("imageUrl_320");
        this.imageUrl_640 = (String)map.get("imageUrl_640");
        this.imageUrl_1280 = (String)map.get("imageUrl_1280");
        booleanValue = "published";
        Object obj8 = map.get(booleanValue);
        Objects.requireNonNull(obj8, "null cannot be cast to non-null type kotlin.Boolean");
        if (map.get(booleanValue) != null && (Boolean)obj8.booleanValue()) {
            obj8 = map.get(booleanValue);
            Objects.requireNonNull(obj8, "null cannot be cast to non-null type kotlin.Boolean");
            i = (Boolean)obj8.booleanValue() ? 1 : i;
        }
        this.published = i;
        this.dogId = (String)map.get("dogId");
        this.comment = (String)map.get("comment");
        this.dogName = (String)map.get("dogName");
        Object obj12 = map.get("entryId");
        Objects.requireNonNull(obj12, "null cannot be cast to non-null type kotlin.String");
        this.documentId = (String)obj12;
        this.country = (String)map.get("country");
        obj5 = map.get("images");
        if (obj5 == null) {
        } else {
            obj5 = g0.b(obj5);
            Objects.requireNonNull(obj5);
            this.images = (List)obj5;
        }
        obj5 = new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<app.dogo.com.dogo_android.model.ChallengeEntryModel.MiniEntryModel>");
        throw obj5;
    }

    public ChallengeEntryModel(Map map, g g2) {
        super(map);
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final long computeTimeTillAdditionalUploadInMillis(long l) {
        int threshold;
        long threshold2;
        int obj5;
        Timestamp date = this.date;
        if (date != null) {
            n.d(date);
            i2 -= l;
        } else {
            threshold = v2.b.DAYS.getThreshold();
        }
        return threshold;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final String getAuthor() {
        return this.author;
    }

    public final List<String> getBadges() {
        return this.badges;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final String getChallengeId() {
        return this.challengeId;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final String getComment() {
        return this.comment;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final int getCommentCount() {
        int commentCount;
        l.a entryStateData = this.entryStateData;
        if (entryStateData != null) {
            n.d(entryStateData);
            commentCount = entryStateData.a();
        } else {
            commentCount = this.commentCount;
        }
        return commentCount;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final String getCountry() {
        return this.country;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final Timestamp getDate() {
        return this.date;
    }

    @Exclude
    public final String getDocumentId() {
        String documentId = this.documentId;
        if (documentId == null) {
        } else {
            return documentId;
        }
        n.w("documentId");
        throw 0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final String getDogAvatarUrl() {
        String str;
        String str2;
        String str3;
        int i;
        int i2;
        int i3;
        String dogAvatarUrl = this.dogAvatarUrl;
        if (dogAvatarUrl != null) {
            n.d(dogAvatarUrl);
            str = l.G(dogAvatarUrl, "avatar.jpg", "avatar_60.jpg", false, 4, 0);
        } else {
            str = 0;
        }
        return str;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final String getDogId() {
        return this.dogId;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final String getDogName() {
        return this.dogName;
    }

    @Exclude
    public final app.dogo.com.dogo_android.model.DogProfileModel getDogProfile() {
        return this.dogProfile;
    }

    @Exclude
    public final Map<String, String> getEntryTranslations() {
        return this.entryTranslations;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final int getExtraVotes() {
        int votes;
        l.a entryStateData = this.entryStateData;
        if (entryStateData != null) {
            n.d(entryStateData);
            votes = entryStateData.b();
        } else {
            votes = this.votes;
        }
        return votes;
    }

    @Exclude
    public final String getImageAt(Resources resources, int i2) {
        boolean empty;
        int obj3;
        int obj4;
        n.f(resources, "resources");
        List images = getImages();
        if (images != null) {
            if (images.isEmpty()) {
            } else {
                if (i2 < images.size()) {
                    obj3 = (ChallengeEntryModel.MiniEntryModel)images.get(i2).getImageUrl(resources);
                } else {
                    obj3 = 0;
                }
            }
            return obj3;
        }
        return getImageUrl(resources);
    }

    @Exclude
    public final int getImageCount() {
        int size;
        List images;
        images = getImages();
        if (images != null) {
            if (images.isEmpty()) {
                size = this.imageUrl_1280 == null ? 0 : 1;
            } else {
                List images2 = getImages();
                n.d(images2);
                size = images2.size();
            }
        } else {
        }
        return size;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final String getImageIdAt(int i) {
        boolean images;
        int obj2;
        List images2 = this.images;
        n.d(images2);
        if (images2.isEmpty()) {
            obj2 = 0;
        } else {
            images = this.images;
            n.d(images);
            obj2 = (ChallengeEntryModel.MiniEntryModel)images.get(i).getImageId();
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final String getImageUrl() {
        String imageUrl;
        Resources resources = App.Companion.b().getResources();
        n.e(resources, "appContext.resources");
        if (getImageUrl(resources) == null) {
            imageUrl = this.imageUrl;
        }
        return imageUrl;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final String getImageUrl(Resources resources) {
        int cmp;
        String obj2;
        n.f(resources, "resources");
        obj2 = (float)obj2;
        obj2 = Float.compare(obj2, i) < 0 ? this.imageUrl_320 : obj2 < 0 ? this.imageUrl_640 : this.imageUrl_1280;
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final String getImageUrlOf(String string) {
        Object imageId;
        boolean z;
        String str;
        n.f(string, "photoId");
        List images = this.images;
        n.d(images);
        Iterator iterator = images.iterator();
        for (ChallengeEntryModel.MiniEntryModel next2 : iterator) {
            if (next2.getImageId() == null) {
            }
            imageId = new Exception(n.o("null image id for entry : ", getDocumentId()));
            a.d(imageId);
        }
        return null;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final String getImageUrl_1280() {
        return this.imageUrl_1280;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final String getImageUrl_320() {
        return this.imageUrl_320;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final String getImageUrl_640() {
        return this.imageUrl_640;
    }

    public final List<app.dogo.com.dogo_android.model.ChallengeEntryModel.MiniEntryModel> getImages() {
        return this.images;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final boolean getIsBeingDeleted() {
        return this.isBeingDeleted;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final boolean getLikeStateForImage(String string) {
        l.a entryStateData;
        boolean obj2;
        if (string == null) {
            obj2 = hasUserLiked();
        } else {
            entryStateData = this.entryStateData;
            n.d(entryStateData);
            if (entryStateData != null && entryStateData.c(string)) {
                n.d(entryStateData);
                obj2 = entryStateData.c(string) ? 1 : 0;
            } else {
            }
        }
        return obj2;
    }

    @Exclude
    public final boolean getLikeStateForImageAt(int i) {
        boolean entryStateData;
        boolean obj2;
        List images = this.images;
        n.d(images);
        if (images.isEmpty()) {
            obj2 = hasUserLiked();
        } else {
            entryStateData = this.entryStateData;
            n.d(entryStateData);
            if (entryStateData != null && entryStateData.c(getImageIdAt(i))) {
                n.d(entryStateData);
                obj2 = entryStateData.c(getImageIdAt(i)) ? 1 : 0;
            } else {
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final app.dogo.com.dogo_android.model.LiteDogProfile getLiteDogProfile() {
        LiteDogProfile liteDogProfile = new LiteDogProfile(this.dogName, this.dogAvatarUrl, this.dogId);
        return liteDogProfile;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final String getLocale() {
        return this.locale;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final Timestamp getPhotoCreationTimestamp(int i) {
        final List images = this.images;
        n.d(images);
        return (ChallengeEntryModel.MiniEntryModel)images.get(i).getCreatedAt();
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final boolean getPublished() {
        return this.published;
    }

    @Exclude
    public final String getTranslatedCaption() {
        return this.translatedCaption;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final Timestamp getUpdatedAt() {
        return this.updatedAt;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final int getUploadStatus() {
        return this.uploadStatus;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final int getViewCount() {
        return this.viewCount;
    }

    @Exclude
    public final String getVoteString() {
        return String.valueOf(this.votes);
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final int getVotes() {
        int votes;
        l.a entryStateData = this.entryStateData;
        if (entryStateData != null) {
            n.d(entryStateData);
            votes = entryStateData.b();
        } else {
            votes = this.votes;
        }
        return votes;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final int getVotesRank() {
        return this.votesRank;
    }

    @Exclude
    public final boolean hasChallengeEnded() {
        return this.challengeEnded;
    }

    @Exclude
    public final boolean hasUserLiked() {
        return this.userLiked;
    }

    @Exclude
    public final void incrementVotes(int i) {
        this.votes = votes += i;
        final l.a obj3 = this.entryStateData;
        n.d(obj3);
        obj3.f(votes2 += extraVotes);
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final boolean isAuthorAdmin() {
        return n.b(j1.t(this), "admin");
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final boolean isAuthorAmbassador() {
        return n.b(j1.t(this), "ambassador");
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final boolean isAuthorPremium() {
        return n.b(j1.t(this), "premium");
    }

    @Exclude
    public final boolean isDogFetch() {
        return this.isDogFetch;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final boolean isFeatured(int i) {
        List images;
        boolean obj2;
        List images2 = this.images;
        n.d(images2);
        if (!images2.isEmpty()) {
            List images3 = this.images;
            n.d(images3);
            if (images3.size() <= i) {
                obj2 = this.featured;
            } else {
                images = this.images;
                n.d(images);
                obj2 = (ChallengeEntryModel.MiniEntryModel)images.get(i).isFeatured();
            }
        } else {
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final boolean isLastPhoto() {
        List images;
        int i;
        images = this.images;
        n.d(images);
        if (images != null && !images.isEmpty()) {
            n.d(images);
            if (!images.isEmpty()) {
                List images2 = this.images;
                n.d(images2);
                if (images2.size() == 1) {
                } else {
                    i = 0;
                }
            }
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final boolean isLatestPhoto(int i) {
        int obj2;
        if (this.images != null && i == 0) {
            obj2 = i == 0 ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Exclude
    public final boolean isPhotoUploading(long l) {
        int convert;
        int i;
        long l2;
        int i2;
        TimeUnit mINUTES;
        int obj6;
        Timestamp updatedAt = this.updatedAt;
        if (updatedAt != null) {
            n.d(updatedAt);
            seconds *= l2;
        } else {
            convert = l;
        }
        int uploadStatus = this.uploadStatus;
        if (uploadStatus == 1 && Long.compare(obj6, convert) <= 0) {
            if (Long.compare(obj6, convert) <= 0) {
            } else {
                i2 = 0;
            }
        } else {
        }
        return i2;
    }

    @Exclude
    public final boolean isTranslatePressed() {
        return this.isTranslatePressed;
    }

    @Exclude
    public final boolean isUploadFailed() {
        return this.isUploadFailed;
    }

    @Exclude
    public final boolean isUploadStatusReadyToUpload(long l) {
        int convert;
        int i;
        long l2;
        int i2;
        TimeUnit hOURS;
        int obj6;
        Timestamp updatedAt = this.updatedAt;
        if (updatedAt != null) {
            n.d(updatedAt);
            seconds *= l2;
        } else {
            convert = l;
        }
        int uploadStatus = this.uploadStatus;
        if (uploadStatus == 1) {
            if (Long.compare(obj6, convert) >= 0) {
            } else {
                i2 = 0;
            }
        }
        return i2;
    }

    @Exclude
    public final app.dogo.com.dogo_android.model.LiteDogProfile parseLiteDogProfile() {
        LiteDogProfile liteDogProfile = new LiteDogProfile(this.dogName, this.dogAvatarUrl, this.dogId);
        return liteDogProfile;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void removePhoto(int i) {
        final List images = this.images;
        n.d(images);
        images.remove(i);
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setAuthor(String string) {
        this.author = string;
    }

    public final void setBadges(List<String> list) {
        n.f(list, "<set-?>");
        this.badges = list;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setChallengeEnded(boolean z) {
        this.challengeEnded = z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setChallengeId(String string) {
        this.challengeId = string;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setComment(String string) {
        this.comment = string;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setCommentCount(int i) {
        this.commentCount = i;
        final l.a entryStateData = this.entryStateData;
        if (entryStateData != null) {
            n.d(entryStateData);
            entryStateData.d(i);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setCountry(String string) {
        this.country = string;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public void setDocumentId(String string) {
        n.f(string, "documentId");
        this.documentId = string;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setDogAvatarUrl(String string) {
        this.dogAvatarUrl = string;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setDogFetchFlag(boolean z) {
        this.isDogFetch = z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setDogId(String string) {
        this.dogId = string;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setDogName(String string) {
        this.dogName = string;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setDogProfile(app.dogo.com.dogo_android.model.DogProfileModel dogProfileModel) {
        int obj1;
        this.dogProfile = dogProfileModel;
        if (dogProfileModel == null) {
            obj1 = 0;
        } else {
            obj1 = dogProfileModel.getName();
        }
        this.dogName = obj1;
    }

    @Exclude
    public final void setEntryStateData(l.a l$a) {
        n.f(a, "entryStateData");
        this.entryStateData = a;
        a.f(votes += extraVotes);
        a.d(this.commentCount);
    }

    @Exclude
    public final void setEntryTranslations(String string, String string2) {
        n.f(string, "locale");
        n.f(string2, "translation");
        this.entryTranslations.put(string, string2);
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setExtraVotes(int i) {
        int i2;
        this.extraVotes = i;
        final l.a entryStateData = this.entryStateData;
        if (entryStateData != null) {
            n.d(entryStateData);
            entryStateData.f(votes += i);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setFeatured(boolean z, int i2) {
        boolean images;
        int obj3;
        List images2 = this.images;
        n.d(images2);
        if (images2.isEmpty()) {
            this.featured = z;
        } else {
            images = this.images;
            n.d(images);
            (ChallengeEntryModel.MiniEntryModel)images.get(i2).setFeatured(z);
        }
    }

    public final void setImages(Map<String, ? extends Map<String, ? extends Object>> map) {
        ArrayList arrayList;
        Object next;
        Object miniEntryModel;
        String str;
        List obj5;
        if (map != null) {
            arrayList = new ArrayList();
            obj5 = map.values().iterator();
            for (Map next : obj5) {
                miniEntryModel = new ChallengeEntryModel.MiniEntryModel(next);
                arrayList.add(miniEntryModel);
            }
            Collections.sort(arrayList);
            obj5 = this.images;
            n.d(obj5);
            obj5.addAll(arrayList);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setIsBeingDeleted(boolean z) {
        this.isBeingDeleted = z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setLikeStateForImage(String string, boolean z2) {
        l.a entryStateData;
        if (string == null) {
            setUserLiked(z2);
        } else {
            entryStateData = this.entryStateData;
            if (entryStateData == null) {
            } else {
                entryStateData.e(string, z2);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setLocale(String string) {
        boolean z;
        Object obj2;
        if (string != null && n.b(string, "en")) {
            if (n.b(string, "en")) {
                this.locale = "en-US";
            } else {
                this.locale = string;
            }
        } else {
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setPublished(boolean z) {
        this.published = z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setTranslatePressed(boolean z) {
        this.isTranslatePressed = z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setTranslatedCaption(String string) {
        this.translatedCaption = string;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setUpdatedAt(Timestamp timestamp) {
        this.updatedAt = timestamp;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setUploadFailed(boolean z) {
        this.isUploadFailed = z;
    }

    @Exclude
    public final void setUploadStatus(int i) {
        this.uploadStatus = i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setUserLiked(boolean z) {
        this.userLiked = z;
    }

    public final void setUserLikedPhotos(Map<String, Boolean> map) {
        boolean booleanValue;
        Object key;
        if (map == null) {
        }
        Iterator obj3 = map.entrySet().iterator();
        for (Map.Entry next2 : obj3) {
            setLikeStateForImage((String)next2.getKey(), (Boolean)next2.getValue().booleanValue());
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setVotes(int i) {
        int extraVotes;
        int obj3;
        this.votes = i;
        final l.a entryStateData = this.entryStateData;
        if (entryStateData != null) {
            n.d(entryStateData);
            entryStateData.f(i += extraVotes);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public final void setVotesRank(int i) {
        this.votesRank = i;
    }

    @Exclude
    public final void updateCommentCount(int i) {
        int commentCount;
        commentCount2 += i;
        this.commentCount = commentCount;
        if (commentCount < 0) {
            commentCount = 0;
        }
        this.commentCount = commentCount;
        final l.a obj2 = this.entryStateData;
        if (obj2 != null) {
            n.d(obj2);
            obj2.d(this.commentCount);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.t
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "dest");
        parcel.writeInt(this.votes);
        parcel.writeInt(this.extraVotes);
        parcel.writeString(this.dogAvatarUrl);
        parcel.writeString(this.author);
        parcel.writeString(this.challengeId);
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.imageUrl_320);
        parcel.writeString(this.imageUrl_640);
        parcel.writeString(this.imageUrl_1280);
        parcel.writeByte((byte)published);
        parcel.writeByte((byte)isBeingDeleted);
        parcel.writeString(this.dogId);
        parcel.writeByte((byte)featured);
        parcel.writeInt(this.viewCount);
        parcel.writeInt(this.commentCount);
        parcel.writeString(this.comment);
        parcel.writeString(this.dogName);
        parcel.writeString(this.locale);
        parcel.writeTypedList(this.images);
        parcel.writeParcelable(this.date, i2);
        parcel.writeInt(this.uploadStatus);
        parcel.writeByte((byte)isTranslatePressed);
        parcel.writeString(this.translatedCaption);
        parcel.writeParcelable(this.dogProfile, i2);
        parcel.writeByte((byte)obj3);
        parcel.writeString(getDocumentId());
        parcel.writeByte((byte)obj3);
        parcel.writeByte((byte)obj3);
        parcel.writeByte((byte)obj3);
        parcel.writeInt(this.votesRank);
        parcel.writeString(this.country);
    }
}
