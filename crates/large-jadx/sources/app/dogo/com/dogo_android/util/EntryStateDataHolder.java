package app.dogo.com.dogo_android.util;

import app.dogo.com.dogo_android.util.n0.t;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: EntryStateDataHolder.kt */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010$\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001:\u0001\u001fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\u000cJ\u0011\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0007H\u0086\u0002J\u0010\u0010\u000f\u001a\u00020\u00082\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u000e\u0010\u0010\u001a\u00020\u00082\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0007J\u0016\u0010\u0013\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0015J\u001e\u0010\u0018\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\nJ\u001e\u0010\u001a\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015J$\u0010\u001a\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u00072\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\u001cJ0\u0010\u001a\u001a\u00020\u000c2 \u0010\u001d\u001a\u001c\u0012\u0004\u0012\u00020\u0007\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\u001c0\u001c2\u0006\u0010\u001e\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/util/EntryStateDataHolder;", "", "callback", "Lapp/dogo/com/dogo_android/util/recycle_views/ListRefresher;", "(Lapp/dogo/com/dogo_android/util/recycle_views/ListRefresher;)V", "entryDataStateMap", "", "", "Lapp/dogo/com/dogo_android/util/EntryStateDataHolder$EntryStateData;", "globalPhotoLikeMap", "", "clear", "", "contains", "entryId", "createNewEntryStateDataEntity", "getEntryStateData", "getPhotoLikeState", "photoId", "setEntryCommentCount", "commentCount", "", "setEntryVoteCount", "voteCount", "setPhotoLike", "likeState", "updateEntryStateData", "photoLikes", "", "entryPhotoLikedMap", "cached", "EntryStateData", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: l, reason: from kotlin metadata */
public final class EntryStateDataHolder {

    /* renamed from: a, reason: from kotlin metadata */
    private final t callback;
    /* renamed from: b, reason: from kotlin metadata */
    private final Map<String, l.a> entryDataStateMap = new HashMap<>();
    /* renamed from: c, reason: from kotlin metadata */
    private final Map<String, Boolean> globalPhotoLikeMap = new HashMap<>();

    @Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010%\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0019\u001a\u00020\t2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0003J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\tJ\u001c\u0010\u001f\u001a\u00020\u001c2\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\u0008R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u00088BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000c\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0017\u0010\u000f\"\u0004\u0008\u0018\u0010\u0011¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/util/EntryStateDataHolder$EntryStateData;", "", "id", "", "callback", "Lapp/dogo/com/dogo_android/util/recycle_views/ListRefresher;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/util/recycle_views/ListRefresher;)V", "allPhotoLikes", "", "", "getAllPhotoLikes", "()Ljava/util/Map;", "commentCount", "", "getCommentCount", "()I", "setCommentCount", "(I)V", "getId", "()Ljava/lang/String;", "photoLikes", "", "voteCount", "getVoteCount", "setVoteCount", "isPhotoLiked", "entryId", "setPhotoLike", "", "photoId", "likeState", "updatePhotoLikes", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {

        private final t a;
        /* renamed from: b, reason: from kotlin metadata */
        private final Map<String, Boolean> callback = new HashMap<>();
        /* renamed from: c, reason: from kotlin metadata */
        private int commentCount;
        /* renamed from: d, reason: from kotlin metadata */
        private int photoLikes;
        public a(String str, t tVar) {
            n.f(str, "id");
            n.f(tVar, "callback");
            super();
            this.a = tVar;
            HashMap hashMap = new HashMap();
            tVar.a();
        }

        public final int a() {
            return this.photoLikes;
        }

        public final int b() {
            return this.commentCount;
        }

        /* renamed from: c, reason: from kotlin metadata */
        public final boolean isPhotoLiked(String entryId) {
            boolean key;
            boolean z = false;
            Objects.requireNonNull(this.callback, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
            if (this.callback.containsKey(entryId)) {
                Object value = this.callback.get(entryId);
                n.d(value);
                entryId = value.booleanValue() ? 1 : 0;
            }
            return (value.booleanValue() ? 1 : 0);
        }

        /* renamed from: d, reason: from kotlin metadata */
        public final void updatePhotoLikes(int photoLikes) {
            this.photoLikes = photoLikes;
            this.a.a();
        }

        /* renamed from: e, reason: from kotlin metadata */
        public final void setPhotoLike(String photoId, boolean likeState) {
            n.f(photoId, "photoId");
            this.callback.put(photoId, Boolean.valueOf(likeState));
            this.a.a();
        }

        public final void f(int i) {
            this.commentCount = i;
            this.a.a();
        }

        public final void g(Map<String, Boolean> map) {
            n.d(map);
            this.callback.putAll(map);
            this.a.a();
        }
    }
    public l(t tVar) {
        n.f(tVar, "callback");
        super();
        this.callback = tVar;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
    }

    /* renamed from: a, reason: from kotlin metadata */
    /* operator */ private final l.a contains(String entryId) {
        final app.dogo.com.dogo_android.util.l.a entryStateDataHolder_EntryStateData = new EntryStateDataHolder_EntryStateData(entryId, this.callback);
        this.entryDataStateMap.put(entryId, entryStateDataHolder_EntryStateData);
        return entryStateDataHolder_EntryStateData;
    }

    /* renamed from: b, reason: from kotlin metadata */
    public final l.a createNewEntryStateDataEntity(String entryId) {
        Object value;
        n.f(entryId, "entryId");
        if (this.entryDataStateMap.containsKey(entryId)) {
            n.d(this.entryDataStateMap.get(entryId));
        } else {
            app.dogo.com.dogo_android.util.l.a contains = contains(entryId);
        }
        return value;
    }

    /* renamed from: c, reason: from kotlin metadata */
    public final void setEntryCommentCount(String entryId, Map<String, Boolean> commentCount) {
        n.f(entryId, "entryId");
        app.dogo.com.dogo_android.util.l.a newEntryStateDataEntity = createNewEntryStateDataEntity(entryId);
        n.d(newEntryStateDataEntity);
        newEntryStateDataEntity.g(commentCount);
        n.d(commentCount);
        this.globalPhotoLikeMap.putAll(commentCount);
    }

    /* renamed from: d, reason: from kotlin metadata */
    public final void setEntryVoteCount(Map<String, ? extends Map<String, Boolean>> entryId, boolean voteCount) {
        boolean key2;
        value = "entryPhotoLikedMap";
        n.f(entryId, value);
        Iterator it = entryId.entrySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            Object key = item.getKey();
        }
    }
}
