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

/* compiled from: TrickItem.kt */
@Metadata(d1 = "\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008=\n\u0002\u0010\u0000\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0087\u0008\u0018\u0000 d2\u00020\u0001:\u0005defghBç\u0001\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u0012\u000e\u0008\u0002\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c\u0012\u000e\u0008\u0002\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000c\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\u0013\u001a\u00020\n\u0012\u000e\u0008\u0002\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u000c\u0012\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0017\u0012\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u0008\u0012\n\u0008\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u0003\u0012\u000e\u0008\u0002\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000c\u0012\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u001f\u001a\u00020\n¢\u0006\u0002\u0010 J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0008HÆ\u0003J\t\u0010B\u001a\u00020\nHÆ\u0003J\u000f\u0010C\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u000cHÆ\u0003J\t\u0010D\u001a\u00020\u0017HÆ\u0003J\t\u0010E\u001a\u00020\u0008HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\t\u0010G\u001a\u00020\u0008HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\u000f\u0010I\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000cHÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\nHÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0008HÆ\u0003J\t\u0010P\u001a\u00020\nHÆ\u0003J\u000f\u0010Q\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000cHÆ\u0003J\u000f\u0010R\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000cHÆ\u0003J\t\u0010S\u001a\u00020\u0011HÆ\u0003Jë\u0001\u0010T\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u000e\u0008\u0002\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c2\u000e\u0008\u0002\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000c2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u0013\u001a\u00020\n2\u000e\u0008\u0002\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u000c2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00082\n\u0008\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000c2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u001f\u001a\u00020\nHÆ\u0001J\t\u0010U\u001a\u00020\nHÖ\u0001J\u0013\u0010V\u001a\u00020\u00082\u0008\u0010W\u001a\u0004\u0018\u00010XHÖ\u0003J\t\u0010Y\u001a\u00020\nHÖ\u0001J\u0006\u0010Z\u001a\u00020\u0008J\u0006\u0010[\u001a\u00020\u0008J\u0006\u0010\\\u001a\u00020\u0008J\u0006\u0010]\u001a\u00020\u0008J\t\u0010^\u001a\u00020\u0003HÖ\u0001J\u0019\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010$R\u0011\u0010\u001b\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010$R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010$R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008)\u0010*\"\u0004\u0008+\u0010,R\u0011\u0010\u0018\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010&R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010$R\u001a\u0010\u0007\u001a\u00020\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008/\u0010&\"\u0004\u00080\u00101R\u0011\u0010\u0012\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u00082\u0010&R\u0011\u0010\u001e\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u0010$R\u0011\u0010\u0013\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u00084\u0010*R\u0017\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u00085\u00106R\u0017\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u00087\u00106R\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00088\u0010$R\u0017\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u00089\u00106R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008:\u0010;R\u0017\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008<\u00106R\u0011\u0010\u001f\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008=\u0010*R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0008\n\u0000\u001a\u0004\u0008>\u0010?¨\u0006i", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "Landroid/os/Parcelable;", "id", "", "name", "description", "imageUrl", "newContent", "", "knowledge", "", "trickSteps", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem$TrickStep;", "videoSteps", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem$VideoStep;", "videoId", "", "ratingBarVisible", "sortOrder", "tags", "Lapp/dogo/com/dogo_android/repository/domain/LibraryTag;", "category", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem$TrickCategory;", "locked", "vimeoData", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem$VimeoData;", "hasVariations", "variationId", "variationTips", "shortDescription", "videoTimeLimit", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/util/List;Ljava/util/List;JZILjava/util/List;Lapp/dogo/com/dogo_android/repository/domain/TrickItem$TrickCategory;ZLapp/dogo/com/dogo_android/repository/domain/TrickItem$VimeoData;ZLjava/lang/String;Ljava/util/List;Ljava/lang/String;I)V", "getCategory", "()Lapp/dogo/com/dogo_android/repository/domain/TrickItem$TrickCategory;", "getDescription", "()Ljava/lang/String;", "getHasVariations", "()Z", "getId", "getImageUrl", "getKnowledge", "()I", "setKnowledge", "(I)V", "getLocked", "getName", "getNewContent", "setNewContent", "(Z)V", "getRatingBarVisible", "getShortDescription", "getSortOrder", "getTags", "()Ljava/util/List;", "getTrickSteps", "getVariationId", "getVariationTips", "getVideoId", "()J", "getVideoSteps", "getVideoTimeLimit", "getVimeoData", "()Lapp/dogo/com/dogo_android/repository/domain/TrickItem$VimeoData;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "isMastered", "isNotRatedByUser", "isRatedByUser", "isVariation", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "TrickCategory", "TrickStep", "VideoStep", "VimeoData", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class TrickItem implements Parcelable {

    public static final String CLICKER_TRICK_ID = "id_clicker";
    public static final Parcelable.Creator<TrickItem> CREATOR = null;
    /* renamed from: Companion, reason: from kotlin metadata */
    public static final TrickItem.Companion INSTANCE = null;
    public static final int MIN_KNOWLEDGE_REACHED = 4;
    private final TrickItem.TrickCategory category;
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
    private final List<LibraryTag> tags;
    private final List<TrickItem.TrickStep> trickSteps;
    private final String variationId;
    private final List<String> variationTips;
    private final long videoId;
    private final List<TrickItem.VideoStep> videoSteps;
    private final int videoTimeLimit;
    private final TrickItem.VimeoData vimeoData;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/TrickItem$Companion;", "", "()V", "CLICKER_TRICK_ID", "", "MIN_KNOWLEDGE_REACHED", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
            super();
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TrickItem> {
        @Override // android.os.Parcelable$Creator
        public final TrickItem createFromParcel(Parcel parcel) {
            int i = 1;
            int i2 = 0;
            Object fromParcel2 = null;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 1;
            Object parcel2 = parcel;
            n.f(parcel2, "parcel");
            int r1 = parcel.readInt() != 0 ? 1 : 0;
            int _int7 = parcel.readInt();
            ArrayList arrayList = new ArrayList(_int7);
            i3 = 0;
            while (i3 != _int7) {
                arrayList.add(TrickItem_TrickStep.CREATOR.createFromParcel(parcel2));
                i3 = i3 + 1;
            }
            int _int8 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(_int8);
            i4 = 0;
            while (TrickItem_TrickStep.CREATOR != _int8) {
                arrayList2.add(TrickItem_VideoStep.CREATOR.createFromParcel(parcel2));
                i4 = i4 + 1;
            }
            long _long = parcel.readLong();
            int r14 = parcel.readInt() != 0 ? 1 : 0;
            int _int10 = parcel.readInt();
            ArrayList arrayList3 = new ArrayList(_int10);
            i2 = 0;
            while (i2 != _int10) {
                arrayList3.add(LibraryTag.CREATOR.createFromParcel(parcel2));
                i2 = i2 + 1;
            }
            int r24 = parcel.readInt() != 0 ? 1 : 0;
            if (parcel.readInt() == 0) {
                int i8 = 0;
            } else {
                fromParcel2 = TrickItem_VimeoData.CREATOR.createFromParcel(parcel2);
            }
            int r26 = parcel.readInt() != 0 ? 1 : 0;
            TrickItem trickItem = new TrickItem(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), i, parcel.readInt(), arrayList, arrayList2, _long, _long, i5, parcel.readInt(), arrayList3, (TrickItem_TrickCategory)fromParcel, i6, (TrickItem_VimeoData)fromParcel2, (parcel.readInt() != 0 ? 1 : 0), parcel.readString(), parcel.createStringArrayList(), parcel.readString(), parcel.readInt());
            return trickItem;
        }

        @Override // android.os.Parcelable$Creator
        public final TrickItem[] newArray(int i) {
            return new TrickItem[i];
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0019\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000c\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/TrickItem$TrickCategory;", "Landroid/os/Parcelable;", "id", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TrickCategory implements Parcelable {

        public static final Parcelable.Creator<TrickItem.TrickCategory> CREATOR = null;
        /* renamed from: Companion, reason: from kotlin metadata */
        public static final TrickItem.TrickCategory.Companion INSTANCE = null;
        public static final String GAME_CATEGORY_ID = "id_games";
        public static final String SKILL_CATEGORY_ID = "id_skills";
        public static final String TRICK_CATEGORY_ID = "id_tricks";
        private final String id;
        private final String name;
        public TrickCategory(String str, String str2) {
            n.f(str, "id");
            n.f(str2, "name");
            super();
            this.id = str;
            this.name = str2;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public /* synthetic */ TrickCategory(String str, String str2, int i, g gVar) {
            String str3;
            str3 = "";
            str3 = i & 1 != 0 ? str3 : str3;
            str3 = i & 2 != 0 ? str3 : str3;
            this(str3, str3);
        }

        static {
            TrickItem_TrickCategory.INSTANCE = new TrickItem_TrickCategory_Companion(null);
            TrickItem_TrickCategory.CREATOR = new TrickItem.TrickCategory.Creator();
        }

        public TrickCategory() {
            final String str = null;
            this(str, str, 3, str);
        }

        public static /* synthetic */ TrickItem.TrickCategory copy$default(TrickItem.TrickCategory trickCategory, String str, String str2, int i, Object object) {
            String id2;
            String name2;
            if (i & 1 != 0) {
            }
            if (i & 2 != 0) {
            }
            return trickCategory.copy(id2, name2);
        }

        /* operator */ public final String component1() {
            return this.id;
        }

        /* operator */ public final String component2() {
            return this.name;
        }

        public final TrickItem.TrickCategory copy(String id, String name) {
            n.f(id, "id");
            n.f(name, "name");
            return new TrickItem_TrickCategory(id, name);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z4 = false;
            if (!(other instanceof TrickItem_TrickCategory)) {
                return false;
            }
            if (!n.b(this.id, other.id)) {
                return false;
            }
            return !n.b(this.name, other.name) ? z4 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (this.id.hashCode() * 31) + this.name.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "TrickCategory(id=";
            String str3 = ", name=";
            str = str2 + this.id + str3 + this.name + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeString(this.id);
            parcel.writeString(this.name);
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0019\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000c\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0019", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/TrickItem$TrickStep;", "Landroid/os/Parcelable;", "description", "", "image", "(Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getImage", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TrickStep implements Parcelable {

        public static final Parcelable.Creator<TrickItem.TrickStep> CREATOR = new TrickItem$TrickStep$Creator<>();
        private final String description;
        private final String image;
        public TrickStep(String str, String str2) {
            n.f(str, "description");
            n.f(str2, "image");
            super();
            this.description = str;
            this.image = str2;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getImage() {
            return this.image;
        }

        public /* synthetic */ TrickStep(String str, String str2, int i, g gVar) {
            String str3;
            str3 = "";
            str3 = i & 1 != 0 ? str3 : str3;
            str3 = i & 2 != 0 ? str3 : str3;
            this(str3, str3);
        }


        public TrickStep() {
            final String str = null;
            this(str, str, 3, str);
        }

        public static /* synthetic */ TrickItem.TrickStep copy$default(TrickItem.TrickStep trickStep, String str, String str2, int i, Object object) {
            String description2;
            String image2;
            if (i & 1 != 0) {
            }
            if (i & 2 != 0) {
            }
            return trickStep.copy(description2, image2);
        }

        /* operator */ public final String component1() {
            return this.description;
        }

        /* operator */ public final String component2() {
            return this.image;
        }

        public final TrickItem.TrickStep copy(String description, String image) {
            n.f(description, "description");
            n.f(image, "image");
            return new TrickItem_TrickStep(description, image);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z4 = false;
            if (!(other instanceof TrickItem_TrickStep)) {
                return false;
            }
            if (!n.b(this.description, other.description)) {
                return false;
            }
            return !n.b(this.image, other.image) ? z4 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (this.description.hashCode() * 31) + this.image.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "TrickStep(description=";
            String str3 = ", image=";
            str = str2 + this.description + str3 + this.image + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeString(this.description);
            parcel.writeString(this.image);
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB#\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000b¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/TrickItem$VideoStep;", "Landroid/os/Parcelable;", "description", "", "startTimeSeconds", "", "endTimeSeconds", "(Ljava/lang/String;II)V", "getDescription", "()Ljava/lang/String;", "getEndTimeSeconds", "()I", "getStartTimeSeconds", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class VideoStep implements Parcelable {

        public static final Parcelable.Creator<TrickItem.VideoStep> CREATOR = null;
        /* renamed from: Companion, reason: from kotlin metadata */
        public static final TrickItem.VideoStep.Companion INSTANCE = null;
        public static final int TILL_THE_VIDEO_END = -1;
        private final String description;
        private final int endTimeSeconds;
        private final int startTimeSeconds;
        public VideoStep(String str, int i, int i2) {
            n.f(str, "description");
            super();
            this.description = str;
            this.startTimeSeconds = i;
            this.endTimeSeconds = i2;
        }

        public final String getDescription() {
            return this.description;
        }

        public final int getEndTimeSeconds() {
            return this.endTimeSeconds;
        }

        public final int getStartTimeSeconds() {
            return this.startTimeSeconds;
        }

        public /* synthetic */ VideoStep(String str, int i, int i2, int i3, g gVar) {
            String str2;
            if (i3 & 1 != 0) {
                str2 = "";
            }
            i = 0;
            i = i3 & 2 != 0 ? i : i;
            i = i3 & 4 != 0 ? i : i;
            this(str2, i, i);
        }

        static {
            TrickItem_VideoStep.INSTANCE = new TrickItem_VideoStep_Companion(null);
            TrickItem_VideoStep.CREATOR = new TrickItem.VideoStep.Creator();
        }

        public VideoStep() {
            this(null, 0, 0, 7, null);
        }

        public static /* synthetic */ TrickItem.VideoStep copy$default(TrickItem.VideoStep videoStep, String str, int i, int i2, int i3, Object object) {
            String description2;
            int startTimeSeconds2;
            int endTimeSeconds2;
            if (i3 & 1 != 0) {
            }
            if (i3 & 2 != 0) {
            }
            if (i3 & 4 != 0) {
            }
            return videoStep.copy(description2, startTimeSeconds2, endTimeSeconds2);
        }

        /* operator */ public final String component1() {
            return this.description;
        }

        /* operator */ public final int component2() {
            return this.startTimeSeconds;
        }

        /* operator */ public final int component3() {
            return this.endTimeSeconds;
        }

        public final TrickItem.VideoStep copy(String description, int startTimeSeconds, int endTimeSeconds) {
            n.f(description, "description");
            return new TrickItem_VideoStep(description, startTimeSeconds, endTimeSeconds);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z4 = false;
            if (!(other instanceof TrickItem_VideoStep)) {
                return false;
            }
            if (!n.b(this.description, other.description)) {
                return false;
            }
            if (this.startTimeSeconds != other.startTimeSeconds) {
                return false;
            }
            return this.endTimeSeconds != other.endTimeSeconds ? z4 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (this.description.hashCode() * 31) + Integer.hashCode(this.startTimeSeconds) * 31 + Integer.hashCode(this.endTimeSeconds);
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "VideoStep(description=";
            String str3 = ", startTimeSeconds=";
            String str4 = ", endTimeSeconds=";
            str = str2 + this.description + str3 + this.startTimeSeconds + str4 + this.endTimeSeconds + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeString(this.description);
            parcel.writeInt(this.startTimeSeconds);
            parcel.writeInt(this.endTimeSeconds);
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0019\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000c\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0019", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/TrickItem$VimeoData;", "Landroid/os/Parcelable;", "videoUrl", "", "imageUrl", "(Ljava/lang/String;Ljava/lang/String;)V", "getImageUrl", "()Ljava/lang/String;", "getVideoUrl", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class VimeoData implements Parcelable {

        public static final Parcelable.Creator<TrickItem.VimeoData> CREATOR = new TrickItem$VimeoData$Creator<>();
        private final String imageUrl;
        private final String videoUrl;
        public VimeoData(String str, String str2) {
            n.f(str, "videoUrl");
            n.f(str2, "imageUrl");
            super();
            this.videoUrl = str;
            this.imageUrl = str2;
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final String getVideoUrl() {
            return this.videoUrl;
        }

        public /* synthetic */ VimeoData(String str, String str2, int i, g gVar) {
            String str3;
            str3 = "";
            str3 = i & 1 != 0 ? str3 : str3;
            str3 = i & 2 != 0 ? str3 : str3;
            this(str3, str3);
        }


        public VimeoData() {
            final String str = null;
            this(str, str, 3, str);
        }

        public static /* synthetic */ TrickItem.VimeoData copy$default(TrickItem.VimeoData vimeoData, String str, String str2, int i, Object object) {
            String videoUrl2;
            String imageUrl2;
            if (i & 1 != 0) {
            }
            if (i & 2 != 0) {
            }
            return vimeoData.copy(videoUrl2, imageUrl2);
        }

        /* operator */ public final String component1() {
            return this.videoUrl;
        }

        /* operator */ public final String component2() {
            return this.imageUrl;
        }

        public final TrickItem.VimeoData copy(String videoUrl, String imageUrl) {
            n.f(videoUrl, "videoUrl");
            n.f(imageUrl, "imageUrl");
            return new TrickItem_VimeoData(videoUrl, imageUrl);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z4 = false;
            if (!(other instanceof TrickItem_VimeoData)) {
                return false;
            }
            if (!n.b(this.videoUrl, other.videoUrl)) {
                return false;
            }
            return !n.b(this.imageUrl, other.imageUrl) ? z4 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (this.videoUrl.hashCode() * 31) + this.imageUrl.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "VimeoData(videoUrl=";
            String str3 = ", imageUrl=";
            str = str2 + this.videoUrl + str3 + this.imageUrl + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeString(this.videoUrl);
            parcel.writeString(this.imageUrl);
        }
    }
    public TrickItem(String str, String str2, String str3, String str4, boolean z, int i, List<TrickItem.TrickStep> list, List<TrickItem.VideoStep> list2, long j, boolean z2, int i2, List<LibraryTag> list3, TrickItem.TrickCategory trickCategory, boolean z3, TrickItem.VimeoData vimeoData, boolean z4, String str5, List<String> list4, String str6, int i3) {
        final Object str62 = this;
        final Object str32 = str3;
        final Object str42 = str4;
        final Object list72 = list;
        final Object list82 = list2;
        final Object trickCategory132 = list3;
        final Object z142 = trickCategory;
        final Object list182 = str5;
        final Object str192 = list4;
        final Object i202 = str6;
        n.f(str, "id");
        n.f(str2, "name");
        n.f(str32, "description");
        n.f(str42, "imageUrl");
        n.f(list72, "trickSteps");
        n.f(list82, "videoSteps");
        n.f(trickCategory132, "tags");
        n.f(z142, "category");
        n.f(list182, "variationId");
        n.f(str192, "variationTips");
        n.f(i202, "shortDescription");
        super();
        str62.id = str;
        str62.name = str2;
        str62.description = str32;
        str62.imageUrl = str42;
        str62.newContent = z;
        str62.knowledge = i;
        str62.trickSteps = list72;
        str62.videoSteps = list82;
        str62.videoId = j;
        str62.ratingBarVisible = z2;
        str62.sortOrder = i2;
        str62.tags = trickCategory132;
        str62.category = z142;
        str62.locked = z3;
        str62.vimeoData = vimeoData;
        str62.hasVariations = z4;
        str62.variationId = list182;
        str62.variationTips = str192;
        str62.shortDescription = i202;
        str62.videoTimeLimit = i3;
    }

    public final TrickItem.TrickCategory getCategory() {
        return this.category;
    }

    public final String getDescription() {
        return this.description;
    }

    public final boolean getHasVariations() {
        return this.hasVariations;
    }

    public final String getId() {
        return this.id;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final int getKnowledge() {
        return this.knowledge;
    }

    public final boolean getLocked() {
        return this.locked;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getNewContent() {
        return this.newContent;
    }

    public final boolean getRatingBarVisible() {
        return this.ratingBarVisible;
    }

    public final String getShortDescription() {
        return this.shortDescription;
    }

    public final int getSortOrder() {
        return this.sortOrder;
    }

    public final List<LibraryTag> getTags() {
        return this.tags;
    }

    public final List<TrickItem.TrickStep> getTrickSteps() {
        return this.trickSteps;
    }

    public final String getVariationId() {
        return this.variationId;
    }

    public final List<String> getVariationTips() {
        return this.variationTips;
    }

    public final long getVideoId() {
        return this.videoId;
    }

    public final List<TrickItem.VideoStep> getVideoSteps() {
        return this.videoSteps;
    }

    public final int getVideoTimeLimit() {
        return this.videoTimeLimit;
    }

    public final TrickItem.VimeoData getVimeoData() {
        return this.vimeoData;
    }

    public final boolean isMastered() {
        boolean z = true;
        int r0 = this.knowledge >= 4 ? 1 : 0;
        return (this.knowledge >= 4 ? 1 : 0);
    }

    public final boolean isNotRatedByUser() {
        boolean z = true;
        int r0 = this.knowledge == 0 ? 1 : 0;
        return (this.knowledge == 0 ? 1 : 0);
    }

    public final boolean isRatedByUser() {
        boolean z = true;
        int r0 = this.knowledge > 0 ? 1 : 0;
        return (this.knowledge > 0 ? 1 : 0);
    }

    public final boolean isVariation() {
        return !l.z(this.variationId);
    }

    public final void setKnowledge(int i) {
        this.knowledge = i;
    }

    public final void setNewContent(boolean z) {
        this.newContent = z;
    }

    public /* synthetic */ TrickItem(String str, String str2, String str3, String str4, boolean z, int i, List list, List list2, long j, boolean z2, int i2, List list3, TrickItem.TrickCategory trickCategory, boolean z3, TrickItem.VimeoData vimeoData, boolean z4, String str5, List list4, String str6, int i3, int i4, g gVar) {
        int i212 = 30;
        int z162 = 0;
        int z52 = 0;
        app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory z142;
        int i62 = 0;
        List list72;
        List list82;
        int j92 = 0;
        boolean i112 = false;
        int list122 = 2147483647;
        List trickCategory132;
        int vimeoData152 = 0;
        int str172 = 0;
        List str192;
        int gVar222 = i4;
        str5 = "";
        String r1 = gVar222 & 1 != 0 ? str5 : str;
        String r3 = gVar222 & 2 != 0 ? str5 : str2;
        String r4 = gVar222 & 4 != 0 ? str5 : str3;
        String r5 = gVar222 & 8 != 0 ? str5 : str4;
        int r6 = gVar222 & 16 != 0 ? 0 : z;
        int r8 = gVar222 & 32 != 0 ? 0 : i;
        if (gVar222 & 64 != 0) {
            list72 = p.g();
        } else {
            list72 = list;
        }
        if (gVar222 & 128 != 0) {
            list82 = p.g();
        } else {
            list82 = list2;
        }
        int r11 = gVar222 & 256 != 0 ? 0 : j;
        int r13 = gVar222 & 512 != 0 ? 0 : z2;
        int r14 = gVar222 & 1024 != 0 ? 0x7fffffff /* Unknown resource */ : i2;
        if (gVar222 & 2048 != 0) {
            trickCategory132 = p.g();
        } else {
            trickCategory132 = list3;
        }
        str6 = null;
        if (gVar222 & 4096 != 0) {
            i = 3;
            z142 = new TrickItem_TrickCategory(str6, str6, i, str6);
        } else {
            z142 = trickCategory;
        }
        int r15 = gVar222 & 8192 != 0 ? 0 : z3;
        int r2 = gVar222 & 16384 != 0 ? 0 : vimeoData;
        int r17 = gVar222 & 32768 != 0 ? 0 : z4;
        String r18 = str5;
        if (gVar222 & 131072 != 0) {
            str192 = p.g();
        } else {
            str192 = list4;
        }
        String r20 = gVar222 & 262144 != 0 ? str5 : str6;
        int r0 = gVar222 & 524288 != 0 ? 30 : i3;
        this(str5, str5, str5, str5, z52, i62, list72, list82, j92, z2, i112, list122, trickCategory132, z142, vimeoData152, z162, str172, str5, str192, str5, (gVar222 & 524288 != 0 ? 30 : i3));
    }

    static {
        TrickItem.INSTANCE = new TrickItem_Companion(null);
        TrickItem.CREATOR = new TrickItem.Creator();
    }

    public TrickItem() {
        this(null, null, null, null, false, 0, null, null, 0L, z, 0, null, null, false, null, false, null, null, null, 0, 0, 1048575, 0);
    }

    public static /* synthetic */ TrickItem copy$default(TrickItem trickItem, String str, String str2, String str3, String str4, boolean z, int i, List list, List list2, long j, boolean z2, int i2, List list3, TrickItem.TrickCategory trickCategory, boolean z3, TrickItem.VimeoData vimeoData, boolean z4, String str5, List list4, String str6, int i3, int i4, Object object) {
        int i222;
        String str22;
        String str32;
        String str42;
        String str52;
        boolean z62;
        int i72;
        List list82;
        List list92;
        long j102;
        boolean i122;
        int list132;
        List trickCategory142;
        app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory z152;
        boolean vimeoData162;
        app.dogo.com.dogo_android.repository.domain.TrickItem.VimeoData z172;
        boolean str182;
        String list192;
        List str202;
        String i212;
        Object trickItem2 = trickItem;
        int object232 = i4;
        String r2 = object232 & 1 != 0 ? trickItem2.id : str;
        String r3 = object232 & 2 != 0 ? trickItem2.name : str2;
        String r4 = object232 & 4 != 0 ? trickItem2.description : str3;
        String r5 = object232 & 8 != 0 ? trickItem2.imageUrl : str4;
        boolean r6 = object232 & 16 != 0 ? trickItem2.newContent : z;
        int r7 = object232 & 32 != 0 ? trickItem2.knowledge : i;
        List r8 = object232 & 64 != 0 ? trickItem2.trickSteps : list;
        List r9 = object232 & 128 != 0 ? trickItem2.videoSteps : list2;
        long r10 = object232 & 256 != 0 ? trickItem2.videoId : j;
        boolean r12 = object232 & 512 != 0 ? trickItem2.ratingBarVisible : z2;
        int r13 = object232 & 1024 != 0 ? trickItem2.sortOrder : i2;
        List r14 = object232 & 2048 != 0 ? trickItem2.tags : list3;
        app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory r15 = object232 & 4096 != 0 ? trickItem2.category : trickCategory;
        r15 = object232 & 8192 != 0 ? trickItem2.locked : z3;
        r15 = object232 & 16384 != 0 ? trickItem2.vimeoData : vimeoData;
        r15 = object232 & 32768 != 0 ? trickItem2.hasVariations : z4;
        r15 = object232 & 65536 != 0 ? trickItem2.variationId : str5;
        r15 = object232 & 131072 != 0 ? trickItem2.variationTips : list4;
        r15 = object232 & 262144 != 0 ? trickItem2.shortDescription : str6;
        int r1 = object232 & 524288 != 0 ? trickItem2.videoTimeLimit : i3;
        return trickItem.copy(str22, str32, str42, str52, z62, i72, list82, list92, j102, r27, i122, list132, trickCategory142, (object232 & 4096 != 0 ? trickItem2.category : trickCategory), (object232 & 8192 != 0 ? trickItem2.locked : z3), (object232 & 16384 != 0 ? trickItem2.vimeoData : vimeoData), (object232 & 32768 != 0 ? trickItem2.hasVariations : z4), (object232 & 65536 != 0 ? trickItem2.variationId : str5), (object232 & 131072 != 0 ? trickItem2.variationTips : list4), i212, (object232 & 524288 != 0 ? trickItem2.videoTimeLimit : i3));
    }

    /* operator */ public final String component1() {
        return this.id;
    }

    /* operator */ public final boolean component10() {
        return this.ratingBarVisible;
    }

    /* operator */ public final int component11() {
        return this.sortOrder;
    }

    /* operator */ public final List<LibraryTag> component12() {
        return this.tags;
    }

    /* operator */ public final TrickItem.TrickCategory component13() {
        return this.category;
    }

    /* operator */ public final boolean component14() {
        return this.locked;
    }

    /* operator */ public final TrickItem.VimeoData component15() {
        return this.vimeoData;
    }

    /* operator */ public final boolean component16() {
        return this.hasVariations;
    }

    /* operator */ public final String component17() {
        return this.variationId;
    }

    /* operator */ public final List<String> component18() {
        return this.variationTips;
    }

    /* operator */ public final String component19() {
        return this.shortDescription;
    }

    /* operator */ public final String component2() {
        return this.name;
    }

    /* operator */ public final int component20() {
        return this.videoTimeLimit;
    }

    /* operator */ public final String component3() {
        return this.description;
    }

    /* operator */ public final String component4() {
        return this.imageUrl;
    }

    /* operator */ public final boolean component5() {
        return this.newContent;
    }

    /* operator */ public final int component6() {
        return this.knowledge;
    }

    /* operator */ public final List<TrickItem.TrickStep> component7() {
        return this.trickSteps;
    }

    /* operator */ public final List<TrickItem.VideoStep> component8() {
        return this.videoSteps;
    }

    /* operator */ public final long component9() {
        return this.videoId;
    }

    public final TrickItem copy(String id, String name, String description, String imageUrl, boolean newContent, int knowledge, List<TrickItem.TrickStep> trickSteps, List<TrickItem.VideoStep> videoSteps, long videoId, boolean ratingBarVisible, int sortOrder, List<LibraryTag> tags, TrickItem.TrickCategory category, boolean locked, TrickItem.VimeoData vimeoData, boolean hasVariations, String variationId, List<String> variationTips, String shortDescription, int videoTimeLimit) {
        Object id2 = id;
        n.f(id2, "id");
        n.f(name, "name");
        n.f(description, "description");
        n.f(imageUrl, "imageUrl");
        n.f(trickSteps, "trickSteps");
        n.f(videoSteps, "videoSteps");
        n.f(tags, "tags");
        n.f(category, "category");
        n.f(variationId, "variationId");
        n.f(variationTips, "variationTips");
        n.f(shortDescription, "shortDescription");
        TrickItem trickItem = new TrickItem(id2, name, description, imageUrl, newContent, knowledge, trickSteps, videoSteps, videoId, z, ratingBarVisible, sortOrder, tags, category, locked, vimeoData, hasVariations, variationId, variationTips, shortDescription, videoTimeLimit);
        return trickItem;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z15 = false;
        if (!(other instanceof TrickItem)) {
            return false;
        }
        if (!n.b(this.id, other.id)) {
            return false;
        }
        if (!n.b(this.name, other.name)) {
            return false;
        }
        if (!n.b(this.description, other.description)) {
            return false;
        }
        if (!n.b(this.imageUrl, other.imageUrl)) {
            return false;
        }
        if (this.newContent != other.newContent) {
            return false;
        }
        if (this.knowledge != other.knowledge) {
            return false;
        }
        if (!n.b(this.trickSteps, other.trickSteps)) {
            return false;
        }
        if (!n.b(this.videoSteps, other.videoSteps)) {
            return false;
        }
        if (this.videoId != other.videoId) {
            return false;
        }
        if (this.ratingBarVisible != other.ratingBarVisible) {
            return false;
        }
        if (this.sortOrder != other.sortOrder) {
            return false;
        }
        if (!n.b(this.tags, other.tags)) {
            return false;
        }
        if (!n.b(this.category, other.category)) {
            return false;
        }
        if (this.locked != other.locked) {
            return false;
        }
        if (!n.b(this.vimeoData, other.vimeoData)) {
            return false;
        }
        if (this.hasVariations != other.hasVariations) {
            return false;
        }
        if (!n.b(this.variationId, other.variationId)) {
            return false;
        }
        if (!n.b(this.variationTips, other.variationTips)) {
            return false;
        }
        if (!n.b(this.shortDescription, other.shortDescription)) {
            return false;
        }
        return this.videoTimeLimit != other.videoTimeLimit ? z15 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        boolean newContent2;
        boolean ratingBarVisible2;
        boolean locked2;
        int i2 = 0;
        boolean hasVariations2 = true;
        int i = 1;
        if (this.newContent) {
        }
        if (this.ratingBarVisible) {
        }
        if (this.locked) {
        }
        if (this.vimeoData == null) {
            i2 = 0;
        } else {
            i2 = this.vimeoData.hashCode();
        }
        if (!(this.hasVariations)) {
        }
        return (this.id.hashCode() * 31) + this.name.hashCode() * 31 + this.description.hashCode() * 31 + this.imageUrl.hashCode() * 31 + newContent2 * 31 + Integer.hashCode(this.knowledge) * 31 + this.trickSteps.hashCode() * 31 + this.videoSteps.hashCode() * 31 + Long.hashCode(this.videoId) * 31 + ratingBarVisible2 * 31 + Integer.hashCode(this.sortOrder) * 31 + this.tags.hashCode() * 31 + this.category.hashCode() * 31 + locked2 * 31 + i2 * 31 + hasVariations2 * 31 + this.variationId.hashCode() * 31 + this.variationTips.hashCode() * 31 + this.shortDescription.hashCode() * 31 + Integer.hashCode(this.videoTimeLimit);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "TrickItem(id=";
        String str3 = ", name=";
        String str4 = ", description=";
        String str5 = ", imageUrl=";
        String str6 = ", newContent=";
        String str7 = ", knowledge=";
        String str8 = ", trickSteps=";
        String str9 = ", videoSteps=";
        String str10 = ", videoId=";
        String str11 = ", ratingBarVisible=";
        String str12 = ", sortOrder=";
        String str13 = ", tags=";
        String str14 = ", category=";
        String str15 = ", locked=";
        String str16 = ", vimeoData=";
        String str17 = ", hasVariations=";
        String str18 = ", variationId=";
        String str19 = ", variationTips=";
        String str20 = ", shortDescription=";
        String str21 = ", videoTimeLimit=";
        str = str2 + this.id + str3 + this.name + str4 + this.description + str5 + this.imageUrl + str6 + this.newContent + str7 + this.knowledge + str8 + this.trickSteps + str9 + this.videoSteps + str10 + this.videoId + str11 + this.ratingBarVisible + str12 + this.sortOrder + str13 + this.tags + str14 + this.category + str15 + this.locked + str16 + this.vimeoData + str17 + this.hasVariations + str18 + this.variationId + str19 + this.variationTips + str20 + this.shortDescription + str21 + this.videoTimeLimit + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeString(this.imageUrl);
        parcel.writeInt(this.newContent);
        parcel.writeInt(this.knowledge);
        parcel.writeInt(this.trickSteps.size());
        Iterator it = this.trickSteps.iterator();
        while (it.hasNext()) {
            (TrickItem_TrickStep)it.next().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.videoSteps.size());
        Iterator it2 = this.videoSteps.iterator();
        boolean hasNext2 = it2.hasNext();
        while (hasNext2) {
            (TrickItem_VideoStep)it2.next().writeToParcel(parcel, flags);
            hasNext2 = it2.hasNext();
        }
        parcel.writeLong(this.videoId);
        parcel.writeInt(this.ratingBarVisible);
        parcel.writeInt(this.sortOrder);
        parcel.writeInt(this.tags.size());
        Iterator it3 = this.tags.iterator();
        while (it3.hasNext()) {
            (LibraryTag)it3.next().writeToParcel(parcel, flags);
        }
        this.category.writeToParcel(parcel, flags);
        parcel.writeInt(this.locked);
        if (this.vimeoData == null) {
            int i2 = 0;
            parcel.writeInt(i2);
        } else {
            int i = 1;
            parcel.writeInt(i);
            this.vimeoData.writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.hasVariations);
        parcel.writeString(this.variationId);
        parcel.writeStringList(this.variationTips);
        parcel.writeString(this.shortDescription);
        parcel.writeInt(this.videoTimeLimit);
    }
}
