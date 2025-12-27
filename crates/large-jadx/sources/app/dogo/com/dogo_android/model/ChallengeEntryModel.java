package app.dogo.com.dogo_android.model;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
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

/* compiled from: ChallengeEntryModel.kt */
@Metadata(d1 = "\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010 \n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0008\r\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u001b\n\u0002\u0010\t\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0010\u0002\n\u0002\u0008(\u0018\u0000 ±\u00012\u00020\u00012\u00020\u0002:\u0004±\u0001²\u0001B\u0007\u0008\u0016¢\u0006\u0002\u0010\u0003B\u001d\u0008\u0012\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005¢\u0006\u0002\u0010\u0008B\u000f\u0008\u0014\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020pJ\u0008\u0010r\u001a\u00020 H\u0016J\u0006\u0010s\u001a\u00020 J\u0008\u0010t\u001a\u0004\u0018\u00010\u0006J\n\u0010u\u001a\u0004\u0018\u000103H\u0007J\u0014\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u0007J\u0006\u0010w\u001a\u00020 J\u001a\u0010x\u001a\u0004\u0018\u00010\u00062\u0006\u0010y\u001a\u00020z2\u0006\u0010{\u001a\u00020 H\u0007J\u0010\u0010|\u001a\u0004\u0018\u00010\u00062\u0006\u0010}\u001a\u00020 J\u0008\u0010~\u001a\u0004\u0018\u00010\u0006J\u0010\u0010~\u001a\u0004\u0018\u00010\u00062\u0006\u0010y\u001a\u00020zJ\u0011\u0010\u007f\u001a\u0004\u0018\u00010\u00062\u0007\u0010\u0080\u0001\u001a\u00020\u0006J\u000f\u0010\u0081\u0001\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010\u0012J\u0007\u0010\u0082\u0001\u001a\u00020\u0018J\u0012\u0010\u0083\u0001\u001a\u00020\u00182\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0006J\u0011\u0010\u0084\u0001\u001a\u00020\u00182\u0006\u0010{\u001a\u00020 H\u0007J\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0006J\u0011\u0010\u0086\u0001\u001a\u0004\u0018\u00010%2\u0006\u0010{\u001a\u00020 J\u0007\u0010\u0087\u0001\u001a\u00020 J\t\u0010\u0088\u0001\u001a\u00020\u0018H\u0007J\t\u0010\u0089\u0001\u001a\u00020\u0018H\u0007J\u0013\u0010\u008a\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u008c\u0001\u001a\u00020 H\u0007J\u000f\u0010\u008d\u0001\u001a\u00020\u00182\u0006\u0010{\u001a\u00020 J\u000f\u0010\u008e\u0001\u001a\u00020\u00182\u0006\u0010}\u001a\u00020 J\u0012\u0010\u008f\u0001\u001a\u00020\u00182\u0007\u0010\u0090\u0001\u001a\u00020pH\u0007J\u0012\u0010\u0091\u0001\u001a\u00020\u00182\u0007\u0010\u0090\u0001\u001a\u00020pH\u0007J\t\u0010\u0092\u0001\u001a\u00020TH\u0007J\u0010\u0010\u0093\u0001\u001a\u00030\u008b\u00012\u0006\u0010}\u001a\u00020 J\u0011\u0010\u0094\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u0095\u0001\u001a\u00020\u0018J\u0010\u0010\u0096\u0001\u001a\u00030\u008b\u00012\u0006\u0010\u001f\u001a\u00020 J\u0012\u0010\u0097\u0001\u001a\u00030\u008b\u00012\u0006\u0010)\u001a\u00020\u0006H\u0016J\u0012\u0010\u0098\u0001\u001a\u00030\u008b\u00012\u0008\u0010+\u001a\u0004\u0018\u00010\u0006J\u0011\u0010\u0099\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u009a\u0001\u001a\u00020\u0018J\u0012\u0010\u009b\u0001\u001a\u00030\u008b\u00012\u0008\u00102\u001a\u0004\u0018\u000103J\u0012\u0010\u009c\u0001\u001a\u00030\u008b\u00012\u0006\u00104\u001a\u000205H\u0007J\u001b\u0010\u009d\u0001\u001a\u00030\u008b\u00012\u0006\u0010W\u001a\u00020\u00062\u0007\u0010\u009e\u0001\u001a\u00020\u0006H\u0007J\u0010\u0010\u009f\u0001\u001a\u00030\u008b\u00012\u0006\u00108\u001a\u00020 J\u0018\u0010 \u0001\u001a\u00030\u008b\u00012\u0006\u00109\u001a\u00020\u00182\u0006\u0010{\u001a\u00020 J1\u0010¡\u0001\u001a\u00030\u008b\u00012'\u0010¢\u0001\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u0018\u00010\u0005J\u0011\u0010£\u0001\u001a\u00030\u008b\u00012\u0007\u0010¤\u0001\u001a\u00020\u0018J\u001c\u0010¥\u0001\u001a\u00030\u008b\u00012\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00062\u0007\u0010¦\u0001\u001a\u00020\u0018J\u0012\u0010§\u0001\u001a\u00030\u008b\u00012\u0008\u0010W\u001a\u0004\u0018\u00010\u0006J\u0010\u0010¨\u0001\u001a\u00030\u008b\u00012\u0006\u0010f\u001a\u00020\u0018J!\u0010©\u0001\u001a\u00030\u008b\u00012\u0017\u0010ª\u0001\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0005J\u0010\u0010«\u0001\u001a\u00030\u008b\u00012\u0006\u0010k\u001a\u00020 J\u0013\u0010¬\u0001\u001a\u00030\u008b\u00012\u0007\u0010­\u0001\u001a\u00020 H\u0007J\u001c\u0010®\u0001\u001a\u00030\u008b\u00012\u0007\u0010¯\u0001\u001a\u00020\n2\u0007\u0010°\u0001\u001a\u00020 H\u0016R\u001c\u0010\u000c\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R \u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014\"\u0004\u0008\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001a\u0010\u000e\"\u0004\u0008\u001b\u0010\u0010R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001d\u0010\u000e\"\u0004\u0008\u001e\u0010\u0010R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\"\u0010\u000e\"\u0004\u0008#\u0010\u0010R$\u0010&\u001a\u0004\u0018\u00010%2\u0008\u0010$\u001a\u0004\u0018\u00010%8\u0006@BX\u0087\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010(R \u0010)\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00068G@BX\u0086.¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010\u000eR\u0010\u0010+\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010,\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008-\u0010\u000e\"\u0004\u0008.\u0010\u0010R\u001c\u0010/\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00080\u0010\u000e\"\u0004\u00081\u0010\u0010R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006078\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010:\u001a\u00020 8G¢\u0006\u0006\u001a\u0004\u0008;\u0010<R\u0010\u0010=\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010>\u001a\u0004\u0018\u00010\u00062\u0008\u0010$\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008?\u0010\u000eR\"\u0010@\u001a\u0004\u0018\u00010\u00062\u0008\u0010$\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008A\u0010\u000eR\"\u0010B\u001a\u0004\u0018\u00010\u00062\u0008\u0010$\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008C\u0010\u000eR\u0016\u0010D\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010G\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\u0008G\u0010HR\u0011\u0010I\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\u0008I\u0010HR\u0011\u0010J\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\u0008J\u0010HR\u000e\u0010K\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010L\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u00188G@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008L\u0010HR\u0011\u0010M\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\u0008M\u0010HR\u001c\u0010N\u001a\u00020\u00188GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008N\u0010H\"\u0004\u0008O\u0010PR\u001c\u0010Q\u001a\u00020\u00188GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008Q\u0010H\"\u0004\u0008R\u0010PR\u0011\u0010S\u001a\u00020T8F¢\u0006\u0006\u001a\u0004\u0008U\u0010VR\u0010\u0010W\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010X\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008Y\u0010H\"\u0004\u0008Z\u0010PR\u001e\u0010[\u001a\u0004\u0018\u00010\u00068GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\\\u0010\u000e\"\u0004\u0008]\u0010\u0010R\u001c\u0010^\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008_\u0010(\"\u0004\u0008`\u0010aR$\u0010b\u001a\u00020 2\u0006\u0010$\u001a\u00020 @GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008c\u0010<\"\u0004\u0008d\u0010eR\u000e\u0010f\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010g\u001a\u00020 2\u0006\u0010$\u001a\u00020 @BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008h\u0010<R\u0011\u0010i\u001a\u00020\u00068G¢\u0006\u0006\u001a\u0004\u0008j\u0010\u000eR\u000e\u0010k\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010l\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008m\u0010<\"\u0004\u0008n\u0010e¨\u0006³\u0001", d2 = {"Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "Lapp/dogo/com/dogo_android/util/base_classes/FirestoreCustomObject;", "Landroid/os/Parcelable;", "()V", "entryData", "", "", "", "(Ljava/util/Map;)V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "author", "getAuthor", "()Ljava/lang/String;", "setAuthor", "(Ljava/lang/String;)V", "badges", "", "getBadges", "()Ljava/util/List;", "setBadges", "(Ljava/util/List;)V", "challengeEnded", "", "challengeId", "getChallengeId", "setChallengeId", "comment", "getComment", "setComment", "commentCount", "", "country", "getCountry", "setCountry", "<set-?>", "Lcom/google/firebase/Timestamp;", "date", "getDate", "()Lcom/google/firebase/Timestamp;", "documentId", "getDocumentId", "dogAvatarUrl", "dogId", "getDogId", "setDogId", "dogName", "getDogName", "setDogName", "dogProfile", "Lapp/dogo/com/dogo_android/model/DogProfileModel;", "entryStateData", "Lapp/dogo/com/dogo_android/util/EntryStateDataHolder$EntryStateData;", "entryTranslations", "", "extraVotes", "featured", "imageCount", "getImageCount", "()I", "imageUrl", "imageUrl_1280", "getImageUrl_1280", "imageUrl_320", "getImageUrl_320", "imageUrl_640", "getImageUrl_640", "images", "", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel$MiniEntryModel;", "isAuthorAdmin", "()Z", "isAuthorAmbassador", "isAuthorPremium", "isBeingDeleted", "isDogFetch", "isLastPhoto", "isTranslatePressed", "setTranslatePressed", "(Z)V", "isUploadFailed", "setUploadFailed", "liteDogProfile", "Lapp/dogo/com/dogo_android/model/LiteDogProfile;", "getLiteDogProfile", "()Lapp/dogo/com/dogo_android/model/LiteDogProfile;", "locale", "published", "getPublished", "setPublished", "translatedCaption", "getTranslatedCaption", "setTranslatedCaption", "updatedAt", "getUpdatedAt", "setUpdatedAt", "(Lcom/google/firebase/Timestamp;)V", "uploadStatus", "getUploadStatus", "setUploadStatus", "(I)V", "userLiked", "viewCount", "getViewCount", "voteString", "getVoteString", "votes", "votesRank", "getVotesRank", "setVotesRank", "computeTimeTillAdditionalUploadInMillis", "", "currentTimeMillis", "describeContents", "getCommentCount", "getDogAvatarUrl", "getDogProfile", "getEntryTranslations", "getExtraVotes", "getImageAt", "resources", "Landroid/content/res/Resources;", "position", "getImageIdAt", "photoPosition", "getImageUrl", "getImageUrlOf", "photoId", "getImages", "getIsBeingDeleted", "getLikeStateForImage", "getLikeStateForImageAt", "getLocale", "getPhotoCreationTimestamp", "getVotes", "hasChallengeEnded", "hasUserLiked", "incrementVotes", "", "incrementValue", "isFeatured", "isLatestPhoto", "isPhotoUploading", "currentTimeInMillis", "isUploadStatusReadyToUpload", "parseLiteDogProfile", "removePhoto", "setChallengeEnded", "state", "setCommentCount", "setDocumentId", "setDogAvatarUrl", "setDogFetchFlag", "dogFetch", "setDogProfile", "setEntryStateData", "setEntryTranslations", "translation", "setExtraVotes", "setFeatured", "setImages", "remoteImages", "setIsBeingDeleted", "flag", "setLikeStateForImage", "likeState", "setLocale", "setUserLiked", "setUserLikedPhotos", "photoLikeStateMap", "setVotes", "updateCommentCount", "changedBy", "writeToParcel", "dest", "flags", "Companion", "MiniEntryModel", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ChallengeEntryModel implements t, Parcelable {

    public static final Parcelable.Creator<ChallengeEntryModel> CREATOR = new ChallengeEntryModel$Companion$CREATOR$1<>();
    /* renamed from: Companion, reason: from kotlin metadata */
    public static final ChallengeEntryModel.Companion INSTANCE = new ChallengeEntryModel$Companion(0);
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
    private DogProfileModel dogProfile;
    private l.a entryStateData;
    @Exclude
    private final Map<String, String> entryTranslations;
    private int extraVotes;
    private boolean featured;
    private String imageUrl;
    private String imageUrl_1280;
    private String imageUrl_320;
    private String imageUrl_640;
    private List<ChallengeEntryModel.MiniEntryModel> images;
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
        private Companion() {
            super();
        }

        public final ChallengeEntryModel parseChallengeEntry(Map<String, ? extends Object> entryData) {
            g gVar = null;
            n.f(entryData, "entryData");
            List list = Arrays.asList(Arrays.copyOf(new String[] { "author", "challengeId", "imageUrl", "dogId", "entryId" }, 5));
            n.e(list, "asList(*mandatoryFields)");
            gVar = null;
            if (entryData.keySet().containsAll(list)) {
            }
            return gVar;
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u0000 ,2\u00020\u00012\u0008\u0012\u0004\u0012\u00020\u00000\u0002:\u0001,B\u001f\u0008\u0016\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\u0010\u0007B\u000f\u0008\u0014\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0011\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0000H\u0096\u0002J\u0008\u0010%\u001a\u00020#H\u0016J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010&\u001a\u00020'J\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020#H\u0016R\"\u0010\r\u001a\u0004\u0018\u00010\u000c2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000c@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014R\"\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0012R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0012R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001b\u0010\u001d\"\u0004\u0008\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-", d2 = {"Lapp/dogo/com/dogo_android/model/ChallengeEntryModel$MiniEntryModel;", "Landroid/os/Parcelable;", "", "map", "", "", "", "(Ljava/util/Map;)V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "<set-?>", "Lcom/google/firebase/Timestamp;", "createdAt", "getCreatedAt", "()Lcom/google/firebase/Timestamp;", "imageId", "getImageId", "()Ljava/lang/String;", "setImageId", "(Ljava/lang/String;)V", "imageUrl", "getImageUrl", "imageUrl_1280", "imageUrl_320", "getImageUrl_320", "imageUrl_640", "isFeatured", "", "()Z", "setFeatured", "(Z)V", "votes", "", "compareTo", "", "other", "describeContents", "resources", "Landroid/content/res/Resources;", "writeToParcel", "", "dest", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class MiniEntryModel implements Parcelable, Comparable<ChallengeEntryModel.MiniEntryModel> {

        public static final Parcelable.Creator<ChallengeEntryModel.MiniEntryModel> CREATOR = new ChallengeEntryModel$MiniEntryModel$Companion$CREATOR$1<>();
        /* renamed from: Companion, reason: from kotlin metadata */
        public static final ChallengeEntryModel.MiniEntryModel.Companion INSTANCE = new ChallengeEntryModel$MiniEntryModel$Companion(0);
        private Timestamp createdAt;
        private String imageId;
        private String imageUrl;
        private String imageUrl_1280;
        private String imageUrl_320;
        private String imageUrl_640;
        private boolean isFeatured = false;
        private long votes;

        public MiniEntryModel(Map<String, ? extends Object> map) {
            n.f(map, "map");
            super();
            this.imageUrl_320 = (String)map.get("imageUrl_320");
            this.imageUrl_640 = (String)map.get("imageUrl_640");
            this.imageUrl_1280 = (String)map.get("imageUrl_1280");
            this.imageUrl = (String)map.get("imageUrl");
            Object value5 = map.get("votes");
            n.d(value5);
            this.votes = value5.longValue();
            this.imageId = (String)map.get("imageId");
            this.createdAt = (Timestamp)map.get("createdAt");
            str = "featured";
            if (map.get(str) != null) {
                map = n.b(map.get(str), Boolean.TRUE) ? 1 : 0;
            }
        }

        public final Timestamp getCreatedAt() {
            return this.createdAt;
        }

        public final String getImageId() {
            return this.imageId;
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final String getImageUrl_320() {
            return this.imageUrl_320;
        }

        public final boolean isFeatured() {
            return this.isFeatured;
        }

        public final void setFeatured(boolean z) {
            this.isFeatured = z;
        }

        public final void setImageId(String str) {
            this.imageId = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            n.f(dest, "dest");
            dest.writeString(this.imageUrl_320);
            dest.writeString(this.imageUrl_640);
            dest.writeString(this.imageUrl_1280);
            dest.writeString(this.imageUrl);
            dest.writeLong(this.votes);
            dest.writeString(this.imageId);
            dest.writeParcelable(this.createdAt, flags);
            dest.writeByte(this.isFeatured != 0 ? 1 : 0);
        }

        @Override // java.lang.Comparable
        /* operator */ public int compareTo(ChallengeEntryModel.MiniEntryModel other) {
            int i = -1;
            n.f(other, "other");
            if (other.createdAt == null && this.createdAt == null) {
                return 0;
            }
            if (other.createdAt == null) {
                return 1;
            }
            i = -1;
            if (this.createdAt != null) {
                n.d(this.createdAt);
                n.d(other.createdAt);
                i = -1 * this.createdAt.compareTo(other.createdAt);
            }
            return i;
        }

        public final String getImageUrl(Resources resources) {
            String str;
            n.f(resources, "resources");
            float f2 = (float)resources.getDisplayMetrics().widthPixels;
            if (f2 < 1135869952) {
            } else {
                float f = 720f;
                resources = this.imageUrl_320 < f ? this.imageUrl_640 : this.imageUrl_1280;
            }
            return (this.imageUrl_320 < f ? this.imageUrl_640 : this.imageUrl_1280);
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
            parcel = parcel.readByte() != 0 ? 1 : 0;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }
    }

    public ChallengeEntryModel() {
        super();
        this.images = new ArrayList();
        this.badges = new ArrayList();
        this.entryTranslations = new HashMap();
    }

    public final long computeTimeTillAdditionalUploadInMillis(long currentTimeMillis) {
        long threshold;
        if (this.date != null) {
            n.d(this.date);
            threshold = (this.date.getSeconds() * (long)1000) + Utilities_TimeUnit.DAYS.getThreshold() - currentTimeMillis;
        } else {
            threshold = Utilities_TimeUnit.DAYS.getThreshold();
        }
        return threshold;
    }

    public final String getAuthor() {
        return this.author;
    }

    public final List<String> getBadges() {
        return this.badges;
    }

    public final String getChallengeId() {
        return this.challengeId;
    }

    public final String getComment() {
        return this.comment;
    }

    public final int getCommentCount() {
        int commentCount2;
        if (this.entryStateData != null) {
            n.d(this.entryStateData);
            commentCount2 = this.entryStateData.a();
        } else {
        }
        return commentCount2;
    }

    public final String getCountry() {
        return this.country;
    }

    public final Timestamp getDate() {
        return this.date;
    }

    @Exclude
    public final String getDocumentId() {
        if (this.documentId == null) {
            n.w("documentId");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            return this.documentId;
        }
    }

    public final String getDogAvatarUrl() {
        String str = null;
        if (this.dogAvatarUrl != null) {
            n.d(this.dogAvatarUrl);
            boolean z = false;
            int i = 4;
            Object obj = null;
            str2 = "avatar.jpg";
            str3 = "avatar_60.jpg";
            str = l.G(this.dogAvatarUrl, str2, str3, z, i, obj);
        } else {
            int i2 = 0;
        }
        return str;
    }

    public final String getDogId() {
        return this.dogId;
    }

    public final String getDogName() {
        return this.dogName;
    }

    @Exclude
    public final DogProfileModel getDogProfile() {
        return this.dogProfile;
    }

    @Exclude
    public final Map<String, String> getEntryTranslations() {
        return this.entryTranslations;
    }

    public final int getExtraVotes() {
        int votes2;
        if (this.entryStateData != null) {
            n.d(this.entryStateData);
            votes2 = this.entryStateData.b();
        } else {
        }
        return votes2;
    }

    @Exclude
    public final String getImageAt(Resources resources, int position) {
        int i = 0;
        n.f(resources, "resources");
        List images = getImages();
        return getImageUrl(resources);
    }

    @Exclude
    public final int getImageCount() {
        int size = 1;
        List images = getImages();
        if (images == null || images.isEmpty()) {
            int r0 = this.imageUrl_1280 == null ? 0 : 1;
        }
        return (this.imageUrl_1280 == null ? 0 : 1);
    }

    public final String getImageIdAt(int photoPosition) {
        int i = 0;
        n.d(this.images);
        if (this.images.isEmpty()) {
            i = 0;
        } else {
            n.d(this.images);
            String imageId = (ChallengeEntryModel_MiniEntryModel)this.images.get(photoPosition).getImageId();
        }
        return i;
    }

    public final String getImageUrl() {
        String imageUrl;
        Resources resources = App.INSTANCE.b().getResources();
        n.e(resources, "appContext.resources");
        if (getImageUrl(resources) == null) {
        }
        return imageUrl;
    }

    public final String getImageUrlOf(String photoId) {
        String str;
        n.f(photoId, "photoId");
        n.d(this.images);
        Iterator it = this.images.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            if (n.b(photoId, item.getImageId())) {
                return item.getImageUrl();
            }
        }
        return null;
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

    public final List<ChallengeEntryModel.MiniEntryModel> getImages() {
        return this.images;
    }

    public final boolean getIsBeingDeleted() {
        return this.isBeingDeleted;
    }

    public final boolean getLikeStateForImage(String photoId) {
        boolean userLiked = true;
        if (photoId == null) {
            userLiked = hasUserLiked();
        } else {
            if (this.entryStateData != null) {
                n.d(this.entryStateData);
                photoId = this.entryStateData.isPhotoLiked(photoId) ? 1 : 0;
            }
        }
        return (this.entryStateData.isPhotoLiked(photoId) ? 1 : 0);
    }

    @Exclude
    public final boolean getLikeStateForImageAt(int position) {
        boolean userLiked = true;
        n.d(this.images);
        if (this.images.isEmpty()) {
            userLiked = hasUserLiked();
        } else {
            if (this.entryStateData != null) {
                n.d(this.entryStateData);
                position = this.entryStateData.isPhotoLiked(getImageIdAt(position)) ? 1 : 0;
            }
        }
        return (this.entryStateData.isPhotoLiked(getImageIdAt(position)) ? 1 : 0);
    }

    public final LiteDogProfile getLiteDogProfile() {
        return new LiteDogProfile(this.dogName, this.dogAvatarUrl, this.dogId);
    }

    public final String getLocale() {
        return this.locale;
    }

    public final Timestamp getPhotoCreationTimestamp(int position) {
        n.d(this.images);
        return (ChallengeEntryModel_MiniEntryModel)this.images.get(position).getCreatedAt();
    }

    public final boolean getPublished() {
        return this.published;
    }

    @Exclude
    public final String getTranslatedCaption() {
        return this.translatedCaption;
    }

    public final Timestamp getUpdatedAt() {
        return this.updatedAt;
    }

    public final int getUploadStatus() {
        return this.uploadStatus;
    }

    public final int getViewCount() {
        return this.viewCount;
    }

    @Exclude
    public final String getVoteString() {
        return String.valueOf(this.votes);
    }

    public final int getVotes() {
        int votes2;
        if (this.entryStateData != null) {
            n.d(this.entryStateData);
            votes2 = this.entryStateData.b();
        } else {
        }
        return votes2;
    }

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
    public final void incrementVotes(int incrementValue) {
        this.votes += incrementValue;
        n.d(this.entryStateData);
        this.entryStateData.f(this.votes + this.extraVotes);
    }

    public final boolean isAuthorAdmin() {
        return n.b(app.dogo.com.dogo_android.util.extensionfunction.j1.t(this), "admin");
    }

    public final boolean isAuthorAmbassador() {
        return n.b(app.dogo.com.dogo_android.util.extensionfunction.j1.t(this), "ambassador");
    }

    public final boolean isAuthorPremium() {
        return n.b(app.dogo.com.dogo_android.util.extensionfunction.j1.t(this), "premium");
    }

    @Exclude
    public final boolean isDogFetch() {
        return this.isDogFetch;
    }

    public final boolean isFeatured(int position) {
        boolean empty;
        boolean featured;
        n.d(this.images);
        if (!this.images.isEmpty()) {
            n.d(this.images);
            if (this.images.size() <= position) {
            } else {
                n.d(this.images);
                featured = (ChallengeEntryModel_MiniEntryModel)this.images.get(position).isFeatured();
            }
        }
        return featured;
    }

    public final boolean isLastPhoto() {
        boolean z = true;
        if (this.images != null) {
            n.d(this.images);
            if (!this.images.isEmpty()) {
                n.d(this.images);
                if (this.images.size() != 1) {
                    int i2 = 0;
                }
            }
        }
        return z;
    }

    public final boolean isLatestPhoto(int photoPosition) {
        boolean z = false;
        photoPosition = this.images != null && photoPosition == 0 ? 1 : 0;
        return (this.images != null && photoPosition == 0 ? 1 : 0);
    }

    @Exclude
    public final boolean isPhotoUploading(long currentTimeInMillis) {
        long currentTimeInMillis2;
        long l = 15;
        boolean z = false;
        TimeUnit mINUTES2;
        int cmp;
        if (this.updatedAt != null) {
            n.d(this.updatedAt);
            l2 = (long)1000;
            currentTimeInMillis2 = this.updatedAt.getSeconds() * l2;
        } else {
            currentTimeInMillis2 = currentTimeInMillis;
        }
        if (this.uploadStatus == 1) {
            currentTimeInMillis -= currentTimeInMillis2;
            l = 15L;
            currentTimeInMillis2 = TimeUnit.MILLISECONDS.convert(l, TimeUnit.MINUTES);
            if (l3 > currentTimeInMillis2) {
                int i3 = 0;
            }
        }
        return z;
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
    public final boolean isUploadStatusReadyToUpload(long currentTimeInMillis) {
        long currentTimeInMillis2;
        boolean z = true;
        if (this.updatedAt != null) {
            n.d(this.updatedAt);
            l2 = (long)1000;
            currentTimeInMillis2 = this.updatedAt.getSeconds() * l2;
        } else {
            currentTimeInMillis2 = currentTimeInMillis;
        }
        if (this.uploadStatus == 1) {
            currentTimeInMillis -= currentTimeInMillis2;
            long l = 24L;
            currentTimeInMillis2 = TimeUnit.MILLISECONDS.convert(l, TimeUnit.HOURS);
            if (l3 < currentTimeInMillis2) {
                int i3 = 0;
            }
        }
        return z;
    }

    @Exclude
    public final LiteDogProfile parseLiteDogProfile() {
        return new LiteDogProfile(this.dogName, this.dogAvatarUrl, this.dogId);
    }

    public final void removePhoto(int photoPosition) {
        n.d(this.images);
        this.images.remove(photoPosition);
    }

    public final void setAuthor(String str) {
        this.author = str;
    }

    public final void setBadges(List<String> list) {
        n.f(list, "<set-?>");
        this.badges = list;
    }

    public final void setChallengeEnded(boolean state) {
        this.challengeEnded = state;
    }

    public final void setChallengeId(String str) {
        this.challengeId = str;
    }

    public final void setComment(String str) {
        this.comment = str;
    }

    public final void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
        if (this.entryStateData != null) {
            n.d(this.entryStateData);
            this.entryStateData.updatePhotoLikes(commentCount);
        }
    }

    public final void setCountry(String str) {
        this.country = str;
    }

    public void setDocumentId(String documentId) {
        n.f(documentId, "documentId");
        this.documentId = documentId;
    }

    public final void setDogAvatarUrl(String dogAvatarUrl) {
        this.dogAvatarUrl = dogAvatarUrl;
    }

    public final void setDogFetchFlag(boolean dogFetch) {
        this.isDogFetch = dogFetch;
    }

    public final void setDogId(String str) {
        this.dogId = str;
    }

    public final void setDogName(String str) {
        this.dogName = str;
    }

    public final void setDogProfile(DogProfileModel dogProfile) {
        int i = 0;
        this.dogProfile = dogProfile;
        if (dogProfile == null) {
            i = 0;
        } else {
            String name = dogProfile.getName();
        }
        this.dogName = i;
    }

    @Exclude
    public final void setEntryStateData(l.a entryStateData) {
        n.f(entryStateData, "entryStateData");
        this.entryStateData = entryStateData;
        entryStateData.f(this.votes + this.extraVotes);
        entryStateData.updatePhotoLikes(this.commentCount);
    }

    @Exclude
    public final void setEntryTranslations(String locale, String translation) {
        n.f(locale, "locale");
        n.f(translation, "translation");
        this.entryTranslations.put(locale, translation);
    }

    public final void setExtraVotes(int extraVotes) {
        this.extraVotes = extraVotes;
        if (this.entryStateData != null) {
            n.d(this.entryStateData);
            i = this.votes + extraVotes;
            this.entryStateData.f(i);
        }
    }

    public final void setFeatured(boolean featured, int position) {
        n.d(this.images);
        if (this.images.isEmpty()) {
            this.featured = featured;
        } else {
            n.d(this.images);
            (ChallengeEntryModel_MiniEntryModel)this.images.get(position).setFeatured(featured);
        }
    }

    public final void setImages(Map<String, ? extends Map<String, ? extends Object>> remoteImages) {
        app.dogo.com.dogo_android.model.ChallengeEntryModel.MiniEntryModel challengeEntryModel_MiniEntryModel;
        String obj2;
        if (remoteImages != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = remoteImages.values().iterator();
            while (it.hasNext()) {
                try {
                    arrayList.add(new ChallengeEntryModel_MiniEntryModel((Map)it.next()));
                } catch (Exception e) {
                    Log.e("challenge_entry_model", "failed to parse photo", e);
                }
            }
            Collections.sort(arrayList);
            n.d(this.images);
            this.images.addAll(arrayList);
        }
    }

    public final void setIsBeingDeleted(boolean flag) {
        this.isBeingDeleted = flag;
    }

    public final void setLikeStateForImage(String photoId, boolean likeState) {
        if (photoId == null) {
            setUserLiked(likeState);
        } else {
            if (this.entryStateData != null) {
                this.entryStateData.setPhotoLike(photoId, likeState);
            }
        }
    }

    public final void setLocale(String locale) {
        boolean z;
        if (locale != null) {
            if (n.b(locale, "en")) {
                str = "en-US";
                this.locale = str;
            } else {
                this.locale = locale;
            }
        }
    }

    public final void setPublished(boolean z) {
        this.published = z;
    }

    public final void setTranslatePressed(boolean z) {
        this.isTranslatePressed = z;
    }

    public final void setTranslatedCaption(String str) {
        this.translatedCaption = str;
    }

    public final void setUpdatedAt(Timestamp timestamp) {
        this.updatedAt = timestamp;
    }

    public final void setUploadFailed(boolean z) {
        this.isUploadFailed = z;
    }

    @Exclude
    public final void setUploadStatus(int i) {
        this.uploadStatus = i;
    }

    public final void setUserLiked(boolean userLiked) {
        this.userLiked = userLiked;
    }

    public final void setUserLikedPhotos(Map<String, Boolean> photoLikeStateMap) {
        if (photoLikeStateMap == null) {
            return;
        }
        Iterator it = photoLikeStateMap.entrySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            setLikeStateForImage((String)item.getKey(), (Boolean)item.getValue().booleanValue());
        }
    }

    public final void setVotes(int votes) {
        this.votes = votes;
        if (this.entryStateData != null) {
            n.d(this.entryStateData);
            i = votes + this.extraVotes;
            this.entryStateData.f(i);
        }
    }

    public final void setVotesRank(int i) {
        this.votesRank = i;
    }

    @Exclude
    public final void updateCommentCount(int changedBy) {
        int commentCount2 = 0;
        this.commentCount += changedBy;
        if (this.commentCount < 0) {
            commentCount2 = 0;
        }
        this.commentCount = commentCount2;
        if (this.entryStateData != null) {
            n.d(this.entryStateData);
            this.entryStateData.updatePhotoLikes(this.commentCount);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        n.f(dest, "dest");
        dest.writeInt(this.votes);
        dest.writeInt(this.extraVotes);
        dest.writeString(this.dogAvatarUrl);
        dest.writeString(this.author);
        dest.writeString(this.challengeId);
        dest.writeString(this.imageUrl);
        dest.writeString(this.imageUrl_320);
        dest.writeString(this.imageUrl_640);
        dest.writeString(this.imageUrl_1280);
        dest.writeByte(this.published != 0 ? 1 : 0);
        dest.writeByte(this.isBeingDeleted != 0 ? 1 : 0);
        dest.writeString(this.dogId);
        dest.writeByte(this.featured != 0 ? 1 : 0);
        dest.writeInt(this.viewCount);
        dest.writeInt(this.commentCount);
        dest.writeString(this.comment);
        dest.writeString(this.dogName);
        dest.writeString(this.locale);
        dest.writeTypedList(this.images);
        dest.writeParcelable(this.date, flags);
        dest.writeInt(this.uploadStatus);
        dest.writeByte(this.isTranslatePressed != 0 ? 1 : 0);
        dest.writeString(this.translatedCaption);
        dest.writeParcelable(this.dogProfile, flags);
        dest.writeByte(this.isDogFetch != 0 ? 1 : 0);
        dest.writeString(getDocumentId());
        dest.writeByte(this.userLiked != 0 ? 1 : 0);
        dest.writeByte(this.isUploadFailed != 0 ? 1 : 0);
        dest.writeByte(this.challengeEnded != 0 ? 1 : 0);
        dest.writeInt(this.votesRank);
        dest.writeString(this.country);
    }

    public final String getImageUrl(Resources resources) {
        String str;
        n.f(resources, "resources");
        float f2 = (float)resources.getDisplayMetrics().widthPixels;
        if (f2 < 1135869952) {
        } else {
            float f = 720f;
            resources = this.imageUrl_320 < f ? this.imageUrl_640 : this.imageUrl_1280;
        }
        return (this.imageUrl_320 < f ? this.imageUrl_640 : this.imageUrl_1280);
    }

    private ChallengeEntryModel(Map<String, ? extends Object> map) {
        int value;
        super();
        this.images = new ArrayList();
        this.badges = new ArrayList();
        this.entryTranslations = new HashMap();
        String str2 = "votes";
        final String str20 = "null cannot be cast to non-null type kotlin.Int";
        value = 0;
        if (map.get(str2) != null) {
            Object value17 = map.get(str2);
            Objects.requireNonNull(value17, "null cannot be cast to non-null type kotlin.Int");
            value = value17.intValue();
        } else {
        }
        this.votes = value;
        String str3 = "extraVotes";
        if (map.get(str3) != null) {
            Object value16 = map.get(str3);
            Objects.requireNonNull(value16, "null cannot be cast to non-null type kotlin.Int");
            value = value16.intValue();
        } else {
        }
        this.extraVotes = value;
        this.dogAvatarUrl = (String)map.get("dogAvatarUrl");
        this.author = (String)map.get("author");
        this.challengeId = (String)map.get("challengeId");
        this.imageUrl = (String)map.get("imageUrl");
        this.imageUrl_320 = (String)map.get("imageUrl_320");
        this.imageUrl_640 = (String)map.get("imageUrl_640");
        this.imageUrl_1280 = (String)map.get("imageUrl_1280");
        str = "published";
        value = map.get(str) != null && value10.booleanValue() ? 1 : value;
        this.published = value;
        this.dogId = (String)map.get("dogId");
        this.comment = (String)map.get("comment");
        this.dogName = (String)map.get("dogName");
        Object value14 = map.get("entryId");
        Objects.requireNonNull(value14, "null cannot be cast to non-null type kotlin.String");
        this.documentId = value14;
        this.country = (String)map.get("country");
        try {
            Object value20 = map.get("images");
            List list = g0.b(value20);
            Objects.requireNonNull(list);
            this.images = list;
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<app.dogo.com.dogo_android.model.ChallengeEntryModel.MiniEntryModel>");
        } catch (java.lang.NullPointerException unused) {
            map = new ArrayList();
            this.images = map;
        }
    }

    protected ChallengeEntryModel(Parcel parcel) {
        int i;
        n.f(parcel, "in");
        super();
        this.images = new ArrayList();
        this.badges = new ArrayList();
        this.entryTranslations = new HashMap();
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
        i = 0;
        int r0 = i;
        this.published = i;
        r0 = i;
        this.isBeingDeleted = i;
        this.dogId = i;
        r0 = i;
        this.featured = i;
        this.viewCount = i;
        this.commentCount = i;
        this.comment = i;
        this.dogName = i;
        this.locale = i;
        this.images = i;
        this.date = (Timestamp)i;
        this.uploadStatus = i;
        r0 = i;
        this.isTranslatePressed = i;
        this.translatedCaption = i;
        this.dogProfile = (DogProfileModel)i;
        r0 = i;
        this.isDogFetch = i;
        r0 = parcel.readString();
        Objects.requireNonNull(r0);
        this.documentId = r0;
        r0 = i;
        this.userLiked = i;
        r0 = i;
        this.isUploadFailed = i;
        if (parcel.readByte() == 0) {
        }
        this.challengeEnded = i;
        this.votesRank = parcel.readInt();
        this.country = parcel.readString();
    }

    public /* synthetic */ ChallengeEntryModel(Map map, g gVar) {
        this(map);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
