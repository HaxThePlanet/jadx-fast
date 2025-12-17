package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008=\n\u0002\u0010\u0000\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0087\u0008\u0018\u0000 d2\u00020\u0001:\u0005defghBç\u0001\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u0012\u000e\u0008\u0002\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c\u0012\u000e\u0008\u0002\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000c\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\u0013\u001a\u00020\n\u0012\u000e\u0008\u0002\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u000c\u0012\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0017\u0012\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u0008\u0012\n\u0008\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u0003\u0012\u000e\u0008\u0002\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000c\u0012\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u001f\u001a\u00020\n¢\u0006\u0002\u0010 J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0008HÆ\u0003J\t\u0010B\u001a\u00020\nHÆ\u0003J\u000f\u0010C\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u000cHÆ\u0003J\t\u0010D\u001a\u00020\u0017HÆ\u0003J\t\u0010E\u001a\u00020\u0008HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\t\u0010G\u001a\u00020\u0008HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\u000f\u0010I\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000cHÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\nHÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0008HÆ\u0003J\t\u0010P\u001a\u00020\nHÆ\u0003J\u000f\u0010Q\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000cHÆ\u0003J\u000f\u0010R\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000cHÆ\u0003J\t\u0010S\u001a\u00020\u0011HÆ\u0003Jë\u0001\u0010T\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u000e\u0008\u0002\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c2\u000e\u0008\u0002\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000c2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u0013\u001a\u00020\n2\u000e\u0008\u0002\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u000c2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00082\n\u0008\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000c2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u001f\u001a\u00020\nHÆ\u0001J\t\u0010U\u001a\u00020\nHÖ\u0001J\u0013\u0010V\u001a\u00020\u00082\u0008\u0010W\u001a\u0004\u0018\u00010XHÖ\u0003J\t\u0010Y\u001a\u00020\nHÖ\u0001J\u0006\u0010Z\u001a\u00020\u0008J\u0006\u0010[\u001a\u00020\u0008J\u0006\u0010\\\u001a\u00020\u0008J\u0006\u0010]\u001a\u00020\u0008J\t\u0010^\u001a\u00020\u0003HÖ\u0001J\u0019\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010$R\u0011\u0010\u001b\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010$R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010$R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008)\u0010*\"\u0004\u0008+\u0010,R\u0011\u0010\u0018\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010&R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010$R\u001a\u0010\u0007\u001a\u00020\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008/\u0010&\"\u0004\u00080\u00101R\u0011\u0010\u0012\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u00082\u0010&R\u0011\u0010\u001e\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u0010$R\u0011\u0010\u0013\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u00084\u0010*R\u0017\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u00085\u00106R\u0017\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u00087\u00106R\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00088\u0010$R\u0017\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u00089\u00106R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008:\u0010;R\u0017\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008<\u00106R\u0011\u0010\u001f\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008=\u0010*R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0008\n\u0000\u001a\u0004\u0008>\u0010?¨\u0006i", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "Landroid/os/Parcelable;", "id", "", "name", "description", "imageUrl", "newContent", "", "knowledge", "", "trickSteps", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem$TrickStep;", "videoSteps", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem$VideoStep;", "videoId", "", "ratingBarVisible", "sortOrder", "tags", "Lapp/dogo/com/dogo_android/repository/domain/LibraryTag;", "category", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem$TrickCategory;", "locked", "vimeoData", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem$VimeoData;", "hasVariations", "variationId", "variationTips", "shortDescription", "videoTimeLimit", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/util/List;Ljava/util/List;JZILjava/util/List;Lapp/dogo/com/dogo_android/repository/domain/TrickItem$TrickCategory;ZLapp/dogo/com/dogo_android/repository/domain/TrickItem$VimeoData;ZLjava/lang/String;Ljava/util/List;Ljava/lang/String;I)V", "getCategory", "()Lapp/dogo/com/dogo_android/repository/domain/TrickItem$TrickCategory;", "getDescription", "()Ljava/lang/String;", "getHasVariations", "()Z", "getId", "getImageUrl", "getKnowledge", "()I", "setKnowledge", "(I)V", "getLocked", "getName", "getNewContent", "setNewContent", "(Z)V", "getRatingBarVisible", "getShortDescription", "getSortOrder", "getTags", "()Ljava/util/List;", "getTrickSteps", "getVariationId", "getVariationTips", "getVideoId", "()J", "getVideoSteps", "getVideoTimeLimit", "getVimeoData", "()Lapp/dogo/com/dogo_android/repository/domain/TrickItem$VimeoData;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "isMastered", "isNotRatedByUser", "isRatedByUser", "isVariation", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "TrickCategory", "TrickStep", "VideoStep", "VimeoData", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TrickItem implements Parcelable {

    public static final String CLICKER_TRICK_ID = "id_clicker";
    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.TrickItem> CREATOR = null;
    public static final app.dogo.com.dogo_android.repository.domain.TrickItem.Companion Companion = null;
    public static final int MIN_KNOWLEDGE_REACHED = 4;
    private final app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory category;
    private final String description;
    private final boolean hasVariations;
    private final String id;
    private final String imageUrl;
    private int knowledge;
    private final boolean locked;
    private final String name;
    private boolean newContent;
    private final boolean ratingBarVisible;
    private final String shortDescription;
    private final int sortOrder;
    private final List<app.dogo.com.dogo_android.repository.domain.LibraryTag> tags;
    private final List<app.dogo.com.dogo_android.repository.domain.TrickItem.TrickStep> trickSteps;
    private final String variationId;
    private final List<String> variationTips;
    private final long videoId;
    private final List<app.dogo.com.dogo_android.repository.domain.TrickItem.VideoStep> videoSteps;
    private final int videoTimeLimit;
    private final app.dogo.com.dogo_android.repository.domain.TrickItem.VimeoData vimeoData;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/TrickItem$Companion;", "", "()V", "CLICKER_TRICK_ID", "", "MIN_KNOWLEDGE_REACHED", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public Companion(g g) {
            super();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.TrickItem> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.TrickItem createFromParcel(Parcel parcel) {
            int i6;
            int i3;
            Object fromParcel4;
            Object fromParcel;
            int i2;
            Object fromParcel3;
            int i;
            Object fromParcel2;
            int i4;
            int i7;
            int i5;
            Object obj = parcel;
            n.f(obj, "parcel");
            i6 = parcel.readInt() != 0 ? 1 : 0;
            int int6 = parcel.readInt();
            ArrayList arrayList = new ArrayList(int6);
            i2 = 0;
            while (i2 != int6) {
                arrayList.add(TrickItem.TrickStep.CREATOR.createFromParcel(obj));
                i2++;
            }
            int int7 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(int7);
            i = 0;
            while (i != int7) {
                arrayList2.add(TrickItem.VideoStep.CREATOR.createFromParcel(obj));
                i++;
            }
            long long = parcel.readLong();
            i4 = parcel.readInt() != 0 ? 1 : 0;
            int int9 = parcel.readInt();
            ArrayList arrayList3 = new ArrayList(int9);
            i3 = 0;
            while (i3 != int9) {
                arrayList3.add(LibraryTag.CREATOR.createFromParcel(obj));
                i3++;
            }
            i7 = parcel.readInt() != 0 ? 1 : 0;
            if (parcel.readInt() == 0) {
                fromParcel4 = 0;
            } else {
                fromParcel4 = TrickItem.VimeoData.CREATOR.createFromParcel(obj);
            }
            i5 = parcel.readInt() != 0 ? 1 : 0;
            super(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), i6, parcel.readInt(), arrayList, arrayList2, long, long, i4, parcel.readInt(), arrayList3, (TrickItem.TrickCategory)TrickItem.TrickCategory.CREATOR.createFromParcel(obj), i7, (TrickItem.VimeoData)fromParcel4, i5, parcel.readString(), parcel.createStringArrayList(), parcel.readString(), parcel.readInt());
            return trickItem;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.TrickItem[] newArray(int i) {
            return new TrickItem[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0019\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000c\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/TrickItem$TrickCategory;", "Landroid/os/Parcelable;", "id", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TrickCategory implements Parcelable {

        public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory> CREATOR = null;
        public static final app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory.Companion Companion = null;
        public static final String GAME_CATEGORY_ID = "id_games";
        public static final String SKILL_CATEGORY_ID = "id_skills";
        public static final String TRICK_CATEGORY_ID = "id_tricks";
        private final String id;
        private final String name;
        static {
            TrickItem.TrickCategory.Companion companion = new TrickItem.TrickCategory.Companion(0);
            TrickItem.TrickCategory.Companion = companion;
            TrickItem.TrickCategory.Creator creator = new TrickItem.TrickCategory.Creator();
            TrickItem.TrickCategory.CREATOR = creator;
        }

        public TrickCategory() {
            final int i = 0;
            super(i, i, 3, i);
        }

        public TrickCategory(String string, String string2) {
            n.f(string, "id");
            n.f(string2, "name");
            super();
            this.id = string;
            this.name = string2;
        }

        public TrickCategory(String string, String string2, int i3, g g4) {
            String obj2;
            String obj3;
            final String str = "";
            obj2 = i3 & 1 != 0 ? str : obj2;
            obj3 = i3 &= 2 != 0 ? str : obj3;
            super(obj2, obj3);
        }

        public static app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory copy$default(app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory trickItem$TrickCategory, String string2, String string3, int i4, Object object5) {
            String obj1;
            String obj2;
            if (i4 & 1 != 0) {
                obj1 = trickCategory.id;
            }
            if (i4 &= 2 != 0) {
                obj2 = trickCategory.name;
            }
            return trickCategory.copy(obj1, obj2);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.id;
        }

        @Override // android.os.Parcelable
        public final String component2() {
            return this.name;
        }

        @Override // android.os.Parcelable
        public final app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory copy(String string, String string2) {
            n.f(string, "id");
            n.f(string2, "name");
            TrickItem.TrickCategory trickCategory = new TrickItem.TrickCategory(string, string2);
            return trickCategory;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof TrickItem.TrickCategory) {
                return i2;
            }
            if (!n.b(this.id, object.id)) {
                return i2;
            }
            if (!n.b(this.name, object.name)) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final String getId() {
            return this.id;
        }

        @Override // android.os.Parcelable
        public final String getName() {
            return this.name;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            return i2 += i4;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TrickCategory(id=");
            stringBuilder.append(this.id);
            stringBuilder.append(", name=");
            stringBuilder.append(this.name);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeString(this.id);
            parcel.writeString(this.name);
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0019\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000c\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0019", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/TrickItem$TrickStep;", "Landroid/os/Parcelable;", "description", "", "image", "(Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getImage", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TrickStep implements Parcelable {

        public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.TrickItem.TrickStep> CREATOR;
        private final String description;
        private final String image;
        static {
            TrickItem.TrickStep.Creator creator = new TrickItem.TrickStep.Creator();
            TrickItem.TrickStep.CREATOR = creator;
        }

        public TrickStep() {
            final int i = 0;
            super(i, i, 3, i);
        }

        public TrickStep(String string, String string2) {
            n.f(string, "description");
            n.f(string2, "image");
            super();
            this.description = string;
            this.image = string2;
        }

        public TrickStep(String string, String string2, int i3, g g4) {
            String obj2;
            String obj3;
            final String str = "";
            obj2 = i3 & 1 != 0 ? str : obj2;
            obj3 = i3 &= 2 != 0 ? str : obj3;
            super(obj2, obj3);
        }

        public static app.dogo.com.dogo_android.repository.domain.TrickItem.TrickStep copy$default(app.dogo.com.dogo_android.repository.domain.TrickItem.TrickStep trickItem$TrickStep, String string2, String string3, int i4, Object object5) {
            String obj1;
            String obj2;
            if (i4 & 1 != 0) {
                obj1 = trickStep.description;
            }
            if (i4 &= 2 != 0) {
                obj2 = trickStep.image;
            }
            return trickStep.copy(obj1, obj2);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.description;
        }

        @Override // android.os.Parcelable
        public final String component2() {
            return this.image;
        }

        @Override // android.os.Parcelable
        public final app.dogo.com.dogo_android.repository.domain.TrickItem.TrickStep copy(String string, String string2) {
            n.f(string, "description");
            n.f(string2, "image");
            TrickItem.TrickStep trickStep = new TrickItem.TrickStep(string, string2);
            return trickStep;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof TrickItem.TrickStep) {
                return i2;
            }
            if (!n.b(this.description, object.description)) {
                return i2;
            }
            if (!n.b(this.image, object.image)) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final String getDescription() {
            return this.description;
        }

        @Override // android.os.Parcelable
        public final String getImage() {
            return this.image;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            return i2 += i4;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TrickStep(description=");
            stringBuilder.append(this.description);
            stringBuilder.append(", image=");
            stringBuilder.append(this.image);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeString(this.description);
            parcel.writeString(this.image);
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB#\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000b¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/TrickItem$VideoStep;", "Landroid/os/Parcelable;", "description", "", "startTimeSeconds", "", "endTimeSeconds", "(Ljava/lang/String;II)V", "getDescription", "()Ljava/lang/String;", "getEndTimeSeconds", "()I", "getStartTimeSeconds", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class VideoStep implements Parcelable {

        public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.TrickItem.VideoStep> CREATOR = null;
        public static final app.dogo.com.dogo_android.repository.domain.TrickItem.VideoStep.Companion Companion = null;
        public static final int TILL_THE_VIDEO_END = -1;
        private final String description;
        private final int endTimeSeconds;
        private final int startTimeSeconds;
        static {
            TrickItem.VideoStep.Companion companion = new TrickItem.VideoStep.Companion(0);
            TrickItem.VideoStep.Companion = companion;
            TrickItem.VideoStep.Creator creator = new TrickItem.VideoStep.Creator();
            TrickItem.VideoStep.CREATOR = creator;
        }

        public VideoStep() {
            super(0, 0, 0, 7, 0);
        }

        public VideoStep(String string, int i2, int i3) {
            n.f(string, "description");
            super();
            this.description = string;
            this.startTimeSeconds = i2;
            this.endTimeSeconds = i3;
        }

        public VideoStep(String string, int i2, int i3, int i4, g g5) {
            String obj2;
            int obj3;
            int obj4;
            obj2 = i4 & 1 != 0 ? "" : obj2;
            final int i = 0;
            obj3 = i4 & 2 != 0 ? i : obj3;
            obj4 = i4 &= 4 != 0 ? i : obj4;
            super(obj2, obj3, obj4);
        }

        public static app.dogo.com.dogo_android.repository.domain.TrickItem.VideoStep copy$default(app.dogo.com.dogo_android.repository.domain.TrickItem.VideoStep trickItem$VideoStep, String string2, int i3, int i4, int i5, Object object6) {
            String obj1;
            int obj2;
            int obj3;
            if (i5 & 1 != 0) {
                obj1 = videoStep.description;
            }
            if (i5 & 2 != 0) {
                obj2 = videoStep.startTimeSeconds;
            }
            if (i5 &= 4 != 0) {
                obj3 = videoStep.endTimeSeconds;
            }
            return videoStep.copy(obj1, obj2, obj3);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.description;
        }

        @Override // android.os.Parcelable
        public final int component2() {
            return this.startTimeSeconds;
        }

        @Override // android.os.Parcelable
        public final int component3() {
            return this.endTimeSeconds;
        }

        @Override // android.os.Parcelable
        public final app.dogo.com.dogo_android.repository.domain.TrickItem.VideoStep copy(String string, int i2, int i3) {
            n.f(string, "description");
            TrickItem.VideoStep videoStep = new TrickItem.VideoStep(string, i2, i3);
            return videoStep;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof TrickItem.VideoStep) {
                return i2;
            }
            if (!n.b(this.description, object.description)) {
                return i2;
            }
            if (this.startTimeSeconds != object.startTimeSeconds) {
                return i2;
            }
            if (this.endTimeSeconds != object.endTimeSeconds) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final String getDescription() {
            return this.description;
        }

        @Override // android.os.Parcelable
        public final int getEndTimeSeconds() {
            return this.endTimeSeconds;
        }

        @Override // android.os.Parcelable
        public final int getStartTimeSeconds() {
            return this.startTimeSeconds;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            return i4 += i7;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("VideoStep(description=");
            stringBuilder.append(this.description);
            stringBuilder.append(", startTimeSeconds=");
            stringBuilder.append(this.startTimeSeconds);
            stringBuilder.append(", endTimeSeconds=");
            stringBuilder.append(this.endTimeSeconds);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeString(this.description);
            parcel.writeInt(this.startTimeSeconds);
            parcel.writeInt(this.endTimeSeconds);
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0019\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000c\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0019", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/TrickItem$VimeoData;", "Landroid/os/Parcelable;", "videoUrl", "", "imageUrl", "(Ljava/lang/String;Ljava/lang/String;)V", "getImageUrl", "()Ljava/lang/String;", "getVideoUrl", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class VimeoData implements Parcelable {

        public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.TrickItem.VimeoData> CREATOR;
        private final String imageUrl;
        private final String videoUrl;
        static {
            TrickItem.VimeoData.Creator creator = new TrickItem.VimeoData.Creator();
            TrickItem.VimeoData.CREATOR = creator;
        }

        public VimeoData() {
            final int i = 0;
            super(i, i, 3, i);
        }

        public VimeoData(String string, String string2) {
            n.f(string, "videoUrl");
            n.f(string2, "imageUrl");
            super();
            this.videoUrl = string;
            this.imageUrl = string2;
        }

        public VimeoData(String string, String string2, int i3, g g4) {
            String obj2;
            String obj3;
            final String str = "";
            obj2 = i3 & 1 != 0 ? str : obj2;
            obj3 = i3 &= 2 != 0 ? str : obj3;
            super(obj2, obj3);
        }

        public static app.dogo.com.dogo_android.repository.domain.TrickItem.VimeoData copy$default(app.dogo.com.dogo_android.repository.domain.TrickItem.VimeoData trickItem$VimeoData, String string2, String string3, int i4, Object object5) {
            String obj1;
            String obj2;
            if (i4 & 1 != 0) {
                obj1 = vimeoData.videoUrl;
            }
            if (i4 &= 2 != 0) {
                obj2 = vimeoData.imageUrl;
            }
            return vimeoData.copy(obj1, obj2);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.videoUrl;
        }

        @Override // android.os.Parcelable
        public final String component2() {
            return this.imageUrl;
        }

        @Override // android.os.Parcelable
        public final app.dogo.com.dogo_android.repository.domain.TrickItem.VimeoData copy(String string, String string2) {
            n.f(string, "videoUrl");
            n.f(string2, "imageUrl");
            TrickItem.VimeoData vimeoData = new TrickItem.VimeoData(string, string2);
            return vimeoData;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (object instanceof TrickItem.VimeoData == null) {
                return i2;
            }
            if (!n.b(this.videoUrl, object.videoUrl)) {
                return i2;
            }
            if (!n.b(this.imageUrl, object.imageUrl)) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final String getImageUrl() {
            return this.imageUrl;
        }

        @Override // android.os.Parcelable
        public final String getVideoUrl() {
            return this.videoUrl;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            return i2 += i4;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("VimeoData(videoUrl=");
            stringBuilder.append(this.videoUrl);
            stringBuilder.append(", imageUrl=");
            stringBuilder.append(this.imageUrl);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeString(this.videoUrl);
            parcel.writeString(this.imageUrl);
        }
    }
    static {
        TrickItem.Companion companion = new TrickItem.Companion(0);
        TrickItem.Companion = companion;
        TrickItem.Creator creator = new TrickItem.Creator();
        TrickItem.CREATOR = creator;
    }

    public TrickItem() {
        super(0, 0, 0, 0, 0, 0, 0, 0, 0, obj10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1048575, 0);
    }

    public TrickItem(String string, String string2, String string3, String string4, boolean z5, int i6, List<app.dogo.com.dogo_android.repository.domain.TrickItem.TrickStep> list7, List<app.dogo.com.dogo_android.repository.domain.TrickItem.VideoStep> list8, long l9, boolean z10, int i11, List<app.dogo.com.dogo_android.repository.domain.LibraryTag> list12, app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory trickItem$TrickCategory13, boolean z14, app.dogo.com.dogo_android.repository.domain.TrickItem.VimeoData trickItem$VimeoData15, boolean z16, String string17, List<String> list18, String string19, int i20) {
        final Object obj = this;
        final Object obj2 = string3;
        final Object obj3 = string4;
        final Object obj4 = list7;
        final Object obj5 = list8;
        final Object obj6 = trickCategory13;
        final Object obj7 = z14;
        final Object obj8 = list18;
        final Object obj9 = string19;
        final Object obj10 = i20;
        n.f(string, "id");
        n.f(string2, "name");
        n.f(obj2, "description");
        n.f(obj3, "imageUrl");
        n.f(obj4, "trickSteps");
        n.f(obj5, "videoSteps");
        n.f(obj6, "tags");
        n.f(obj7, "category");
        n.f(obj8, "variationId");
        n.f(obj9, "variationTips");
        n.f(obj10, "shortDescription");
        super();
        obj.id = string;
        obj.name = string2;
        obj.description = obj2;
        obj.imageUrl = obj3;
        obj.newContent = z5;
        obj.knowledge = i6;
        obj.trickSteps = obj4;
        obj.videoSteps = obj5;
        obj.videoId = l9;
        obj.ratingBarVisible = i11;
        obj.sortOrder = list12;
        obj.tags = obj6;
        obj.category = obj7;
        obj.locked = vimeoData15;
        obj.vimeoData = z16;
        obj.hasVariations = string17;
        obj.variationId = obj8;
        obj.variationTips = obj9;
        obj.shortDescription = obj10;
        obj.videoTimeLimit = obj34;
    }

    public TrickItem(String string, String string2, String string3, String string4, boolean z5, int i6, List list7, List list8, long l9, boolean z10, int i11, List list12, app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory trickItem$TrickCategory13, boolean z14, app.dogo.com.dogo_android.repository.domain.TrickItem.VimeoData trickItem$VimeoData15, boolean z16, String string17, List list18, String string19, int i20, int i21, g g22) {
        int i4;
        String str5;
        int i;
        String str6;
        String str4;
        String str3;
        int i10;
        app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory trickCategory;
        int i9;
        List list;
        List list4;
        int i7;
        int i5;
        int i8;
        List list3;
        int i2;
        List list2;
        int i3;
        String str;
        List list5;
        String str2;
        int i12 = g22;
        String str7 = "";
        str5 = i12 & 1 != 0 ? str7 : string;
        str6 = i12 & 2 != 0 ? str7 : string2;
        str4 = i12 & 4 != 0 ? str7 : string3;
        str3 = i12 & 8 != 0 ? str7 : string4;
        i10 = i12 & 16 != 0 ? 0 : z5;
        i9 = i12 & 32 != 0 ? 0 : i6;
        if (i12 & 64 != 0) {
            list = p.g();
        } else {
            list = list7;
        }
        if (i12 & 128 != 0) {
            list4 = p.g();
        } else {
            list4 = list8;
        }
        i7 = i12 & 256 != 0 ? 0 : l9;
        i5 = i12 & 512 != 0 ? 0 : i11;
        i8 = i12 & 1024 != 0 ? 0x7fffffff /* Unknown resource */ : list12;
        if (i12 & 2048 != 0) {
            list3 = p.g();
        } else {
            list3 = trickCategory13;
        }
        final String obj45 = str7;
        int i15 = 0;
        if (i12 & 4096 != 0) {
            list2 = list3;
            trickCategory = new TrickItem.TrickCategory(i15, i15, 3, i15);
        } else {
            list2 = list3;
            trickCategory = z14;
        }
        i2 = i12 & 8192 != 0 ? 0 : vimeoData15;
        i = i12 & 16384 != 0 ? 0 : z16;
        i3 = i12 & i32 != 0 ? 0 : string17;
        str = i12 & i34 != 0 ? obj45 : list18;
        if (i12 & i36 != 0) {
            list5 = p.g();
        } else {
            list5 = string19;
        }
        str2 = i12 & i38 != 0 ? obj45 : i20;
        i4 = i12 &= i40 != 0 ? 30 : i21;
        super(str5, str6, str4, str3, i10, i9, list, list4, i7, i11, i5, i8, list2, trickCategory, i2, i, i3, str, list5, str2, i4);
    }

    public static app.dogo.com.dogo_android.repository.domain.TrickItem copy$default(app.dogo.com.dogo_android.repository.domain.TrickItem trickItem, String string2, String string3, String string4, String string5, boolean z6, int i7, List list8, List list9, long l10, boolean z11, int i12, List list13, app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory trickItem$TrickCategory14, boolean z15, app.dogo.com.dogo_android.repository.domain.TrickItem.VimeoData trickItem$VimeoData16, boolean z17, String string18, List list19, String string20, int i21, int i22, Object object23) {
        int videoTimeLimit;
        String str;
        String name;
        String description;
        String imageUrl;
        boolean newContent;
        int knowledge;
        List trickSteps;
        List videoSteps;
        long videoId;
        boolean ratingBarVisible;
        int sortOrder;
        List tags;
        app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory category;
        boolean locked;
        app.dogo.com.dogo_android.repository.domain.TrickItem.VimeoData vimeoData;
        boolean hasVariations;
        String variationId;
        List variationTips;
        String shortDescription;
        Object obj = trickItem;
        int i = object23;
        str = i & 1 != 0 ? obj.id : string2;
        name = i & 2 != 0 ? obj.name : string3;
        description = i & 4 != 0 ? obj.description : string4;
        imageUrl = i & 8 != 0 ? obj.imageUrl : string5;
        newContent = i & 16 != 0 ? obj.newContent : z6;
        knowledge = i & 32 != 0 ? obj.knowledge : i7;
        trickSteps = i & 64 != 0 ? obj.trickSteps : list8;
        videoSteps = i & 128 != 0 ? obj.videoSteps : list9;
        videoId = i & 256 != 0 ? obj.videoId : l10;
        ratingBarVisible = i & 512 != 0 ? obj.ratingBarVisible : i12;
        sortOrder = i & 1024 != 0 ? obj.sortOrder : list13;
        tags = i & 2048 != 0 ? obj.tags : trickCategory14;
        category = i & 4096 != 0 ? obj.category : z15;
        locked = i & 8192 != 0 ? obj.locked : vimeoData16;
        vimeoData = i & 16384 != 0 ? obj.vimeoData : z17;
        hasVariations = i & i20 != 0 ? obj.hasVariations : string18;
        variationId = i & i24 != 0 ? obj.variationId : list19;
        variationTips = i & i26 != 0 ? obj.variationTips : string20;
        shortDescription = i & i28 != 0 ? obj.shortDescription : i21;
        videoTimeLimit = i &= i30 != 0 ? obj.videoTimeLimit : i22;
        return trickItem.copy(str, name, description, imageUrl, newContent, knowledge, trickSteps, videoSteps, videoId, z11, ratingBarVisible, sortOrder, tags, category, locked, vimeoData, hasVariations, variationId, variationTips, shortDescription);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public final boolean component10() {
        return this.ratingBarVisible;
    }

    @Override // android.os.Parcelable
    public final int component11() {
        return this.sortOrder;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.LibraryTag> component12() {
        return this.tags;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory component13() {
        return this.category;
    }

    @Override // android.os.Parcelable
    public final boolean component14() {
        return this.locked;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.TrickItem.VimeoData component15() {
        return this.vimeoData;
    }

    @Override // android.os.Parcelable
    public final boolean component16() {
        return this.hasVariations;
    }

    @Override // android.os.Parcelable
    public final String component17() {
        return this.variationId;
    }

    public final List<String> component18() {
        return this.variationTips;
    }

    @Override // android.os.Parcelable
    public final String component19() {
        return this.shortDescription;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public final int component20() {
        return this.videoTimeLimit;
    }

    @Override // android.os.Parcelable
    public final String component3() {
        return this.description;
    }

    @Override // android.os.Parcelable
    public final String component4() {
        return this.imageUrl;
    }

    @Override // android.os.Parcelable
    public final boolean component5() {
        return this.newContent;
    }

    @Override // android.os.Parcelable
    public final int component6() {
        return this.knowledge;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.TrickItem.TrickStep> component7() {
        return this.trickSteps;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.TrickItem.VideoStep> component8() {
        return this.videoSteps;
    }

    @Override // android.os.Parcelable
    public final long component9() {
        return this.videoId;
    }

    public final app.dogo.com.dogo_android.repository.domain.TrickItem copy(String string, String string2, String string3, String string4, boolean z5, int i6, List<app.dogo.com.dogo_android.repository.domain.TrickItem.TrickStep> list7, List<app.dogo.com.dogo_android.repository.domain.TrickItem.VideoStep> list8, long l9, boolean z10, int i11, List<app.dogo.com.dogo_android.repository.domain.LibraryTag> list12, app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory trickItem$TrickCategory13, boolean z14, app.dogo.com.dogo_android.repository.domain.TrickItem.VimeoData trickItem$VimeoData15, boolean z16, String string17, List<String> list18, String string19, int i20) {
        Object obj = string;
        n.f(obj, "id");
        n.f(string2, "name");
        n.f(string3, "description");
        n.f(string4, "imageUrl");
        n.f(list7, "trickSteps");
        n.f(list8, "videoSteps");
        n.f(trickCategory13, "tags");
        n.f(z14, "category");
        n.f(list18, "variationId");
        n.f(string19, "variationTips");
        n.f(i20, "shortDescription");
        super(obj, string2, string3, string4, z5, i6, list7, list8, l9, obj10, i11, list12, trickCategory13, z14, vimeoData15, z16, string17, list18, string19, i20, obj45);
        return trickItem2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof TrickItem) {
            return i2;
        }
        if (!n.b(this.id, object.id)) {
            return i2;
        }
        if (!n.b(this.name, object.name)) {
            return i2;
        }
        if (!n.b(this.description, object.description)) {
            return i2;
        }
        if (!n.b(this.imageUrl, object.imageUrl)) {
            return i2;
        }
        if (this.newContent != object.newContent) {
            return i2;
        }
        if (this.knowledge != object.knowledge) {
            return i2;
        }
        if (!n.b(this.trickSteps, object.trickSteps)) {
            return i2;
        }
        if (!n.b(this.videoSteps, object.videoSteps)) {
            return i2;
        }
        if (Long.compare(videoId, videoId2) != 0) {
            return i2;
        }
        if (this.ratingBarVisible != object.ratingBarVisible) {
            return i2;
        }
        if (this.sortOrder != object.sortOrder) {
            return i2;
        }
        if (!n.b(this.tags, object.tags)) {
            return i2;
        }
        if (!n.b(this.category, object.category)) {
            return i2;
        }
        if (this.locked != object.locked) {
            return i2;
        }
        if (!n.b(this.vimeoData, object.vimeoData)) {
            return i2;
        }
        if (this.hasVariations != object.hasVariations) {
            return i2;
        }
        if (!n.b(this.variationId, object.variationId)) {
            return i2;
        }
        if (!n.b(this.variationTips, object.variationTips)) {
            return i2;
        }
        if (!n.b(this.shortDescription, object.shortDescription)) {
            return i2;
        }
        if (this.videoTimeLimit != object.videoTimeLimit) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory getCategory() {
        return this.category;
    }

    @Override // android.os.Parcelable
    public final String getDescription() {
        return this.description;
    }

    @Override // android.os.Parcelable
    public final boolean getHasVariations() {
        return this.hasVariations;
    }

    @Override // android.os.Parcelable
    public final String getId() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Override // android.os.Parcelable
    public final int getKnowledge() {
        return this.knowledge;
    }

    @Override // android.os.Parcelable
    public final boolean getLocked() {
        return this.locked;
    }

    @Override // android.os.Parcelable
    public final String getName() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public final boolean getNewContent() {
        return this.newContent;
    }

    @Override // android.os.Parcelable
    public final boolean getRatingBarVisible() {
        return this.ratingBarVisible;
    }

    @Override // android.os.Parcelable
    public final String getShortDescription() {
        return this.shortDescription;
    }

    @Override // android.os.Parcelable
    public final int getSortOrder() {
        return this.sortOrder;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.LibraryTag> getTags() {
        return this.tags;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.TrickItem.TrickStep> getTrickSteps() {
        return this.trickSteps;
    }

    @Override // android.os.Parcelable
    public final String getVariationId() {
        return this.variationId;
    }

    public final List<String> getVariationTips() {
        return this.variationTips;
    }

    @Override // android.os.Parcelable
    public final long getVideoId() {
        return this.videoId;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.TrickItem.VideoStep> getVideoSteps() {
        return this.videoSteps;
    }

    @Override // android.os.Parcelable
    public final int getVideoTimeLimit() {
        return this.videoTimeLimit;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.TrickItem.VimeoData getVimeoData() {
        return this.vimeoData;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        boolean newContent;
        boolean ratingBarVisible;
        boolean locked;
        int i;
        boolean i2;
        i2 = 1;
        if (this.newContent) {
            newContent = i2;
        }
        if (this.ratingBarVisible) {
            ratingBarVisible = i2;
        }
        if (this.locked) {
            locked = i2;
        }
        app.dogo.com.dogo_android.repository.domain.TrickItem.VimeoData vimeoData = this.vimeoData;
        if (vimeoData == null) {
            i = 0;
        } else {
            i = vimeoData.hashCode();
        }
        boolean hasVariations = this.hasVariations;
        if (hasVariations) {
        } else {
            i2 = hasVariations;
        }
        return i40 += i55;
    }

    @Override // android.os.Parcelable
    public final boolean isMastered() {
        int i;
        i = this.knowledge >= 4 ? 1 : 0;
        return i;
    }

    @Override // android.os.Parcelable
    public final boolean isNotRatedByUser() {
        int i;
        i = this.knowledge == 0 ? 1 : 0;
        return i;
    }

    @Override // android.os.Parcelable
    public final boolean isRatedByUser() {
        int i;
        i = this.knowledge > 0 ? 1 : 0;
        return i;
    }

    @Override // android.os.Parcelable
    public final boolean isVariation() {
        return z ^= 1;
    }

    @Override // android.os.Parcelable
    public final void setKnowledge(int i) {
        this.knowledge = i;
    }

    @Override // android.os.Parcelable
    public final void setNewContent(boolean z) {
        this.newContent = z;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrickItem(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", description=");
        stringBuilder.append(this.description);
        stringBuilder.append(", imageUrl=");
        stringBuilder.append(this.imageUrl);
        stringBuilder.append(", newContent=");
        stringBuilder.append(this.newContent);
        stringBuilder.append(", knowledge=");
        stringBuilder.append(this.knowledge);
        stringBuilder.append(", trickSteps=");
        stringBuilder.append(this.trickSteps);
        stringBuilder.append(", videoSteps=");
        stringBuilder.append(this.videoSteps);
        stringBuilder.append(", videoId=");
        stringBuilder.append(this.videoId);
        stringBuilder.append(", ratingBarVisible=");
        stringBuilder.append(this.ratingBarVisible);
        stringBuilder.append(", sortOrder=");
        stringBuilder.append(this.sortOrder);
        stringBuilder.append(", tags=");
        stringBuilder.append(this.tags);
        stringBuilder.append(", category=");
        stringBuilder.append(this.category);
        stringBuilder.append(", locked=");
        stringBuilder.append(this.locked);
        stringBuilder.append(", vimeoData=");
        stringBuilder.append(this.vimeoData);
        stringBuilder.append(", hasVariations=");
        stringBuilder.append(this.hasVariations);
        stringBuilder.append(", variationId=");
        stringBuilder.append(this.variationId);
        stringBuilder.append(", variationTips=");
        stringBuilder.append(this.variationTips);
        stringBuilder.append(", shortDescription=");
        stringBuilder.append(this.shortDescription);
        stringBuilder.append(", videoTimeLimit=");
        stringBuilder.append(this.videoTimeLimit);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int size2;
        int size3;
        int size;
        int next;
        int obj4;
        n.f(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeString(this.imageUrl);
        parcel.writeInt(this.newContent);
        parcel.writeInt(this.knowledge);
        List trickSteps = this.trickSteps;
        parcel.writeInt(trickSteps.size());
        Iterator iterator = trickSteps.iterator();
        for (TrickItem.TrickStep size2 : iterator) {
            size2.writeToParcel(parcel, i2);
        }
        List videoSteps = this.videoSteps;
        parcel.writeInt(videoSteps.size());
        Iterator iterator2 = videoSteps.iterator();
        boolean next3 = iterator2.hasNext();
        for (TrickItem.VideoStep size3 : iterator2) {
            size3.writeToParcel(parcel, i2);
            next3 = iterator2.hasNext();
        }
        parcel.writeLong(this.videoId);
        parcel.writeInt(this.ratingBarVisible);
        parcel.writeInt(this.sortOrder);
        List tags = this.tags;
        parcel.writeInt(tags.size());
        Iterator iterator3 = tags.iterator();
        for (LibraryTag size : iterator3) {
            size.writeToParcel(parcel, i2);
        }
        this.category.writeToParcel(parcel, i2);
        parcel.writeInt(this.locked);
        app.dogo.com.dogo_android.repository.domain.TrickItem.VimeoData vimeoData = this.vimeoData;
        if (vimeoData == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            vimeoData.writeToParcel(parcel, i2);
        }
        parcel.writeInt(this.hasVariations);
        parcel.writeString(this.variationId);
        parcel.writeStringList(this.variationTips);
        parcel.writeString(this.shortDescription);
        parcel.writeInt(this.videoTimeLimit);
    }
}
