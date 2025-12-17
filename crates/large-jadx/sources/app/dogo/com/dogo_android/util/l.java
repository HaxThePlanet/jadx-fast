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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010$\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001:\u0001\u001fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\u000cJ\u0011\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0007H\u0086\u0002J\u0010\u0010\u000f\u001a\u00020\u00082\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u000e\u0010\u0010\u001a\u00020\u00082\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0007J\u0016\u0010\u0013\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0015J\u001e\u0010\u0018\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\nJ\u001e\u0010\u001a\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015J$\u0010\u001a\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u00072\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\u001cJ0\u0010\u001a\u001a\u00020\u000c2 \u0010\u001d\u001a\u001c\u0012\u0004\u0012\u00020\u0007\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\u001c0\u001c2\u0006\u0010\u001e\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/util/EntryStateDataHolder;", "", "callback", "Lapp/dogo/com/dogo_android/util/recycle_views/ListRefresher;", "(Lapp/dogo/com/dogo_android/util/recycle_views/ListRefresher;)V", "entryDataStateMap", "", "", "Lapp/dogo/com/dogo_android/util/EntryStateDataHolder$EntryStateData;", "globalPhotoLikeMap", "", "clear", "", "contains", "entryId", "createNewEntryStateDataEntity", "getEntryStateData", "getPhotoLikeState", "photoId", "setEntryCommentCount", "commentCount", "", "setEntryVoteCount", "voteCount", "setPhotoLike", "likeState", "updateEntryStateData", "photoLikes", "", "entryPhotoLikedMap", "cached", "EntryStateData", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class l {

    private final t a;
    private final Map<String, app.dogo.com.dogo_android.util.l.a> b;
    private final Map<String, Boolean> c;

    @Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010%\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0019\u001a\u00020\t2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0003J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\tJ\u001c\u0010\u001f\u001a\u00020\u001c2\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\u0008R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u00088BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000c\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0017\u0010\u000f\"\u0004\u0008\u0018\u0010\u0011¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/util/EntryStateDataHolder$EntryStateData;", "", "id", "", "callback", "Lapp/dogo/com/dogo_android/util/recycle_views/ListRefresher;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/util/recycle_views/ListRefresher;)V", "allPhotoLikes", "", "", "getAllPhotoLikes", "()Ljava/util/Map;", "commentCount", "", "getCommentCount", "()I", "setCommentCount", "(I)V", "getId", "()Ljava/lang/String;", "photoLikes", "", "voteCount", "getVoteCount", "setVoteCount", "isPhotoLiked", "entryId", "setPhotoLike", "", "photoId", "likeState", "updatePhotoLikes", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {

        private final t a;
        private final Map<String, Boolean> b;
        private int c;
        private int d;
        public a(String string, t t2) {
            n.f(string, "id");
            n.f(t2, "callback");
            super();
            this.a = t2;
            HashMap obj2 = new HashMap();
            this.b = obj2;
            t2.a();
        }

        public final int a() {
            return this.d;
        }

        public final int b() {
            return this.c;
        }

        public final boolean c(String string) {
            boolean key;
            Object obj3;
            Map map = this.b;
            Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
            obj3 = this.b.get(string);
            n.d(obj3);
            if (map.containsKey(string) && (Boolean)obj3.booleanValue()) {
                obj3 = this.b.get(string);
                n.d(obj3);
                obj3 = (Boolean)obj3.booleanValue() ? 1 : 0;
            } else {
            }
            return obj3;
        }

        public final void d(int i) {
            this.d = i;
            this.a.a();
        }

        public final void e(String string, boolean z2) {
            n.f(string, "photoId");
            this.b.put(string, Boolean.valueOf(z2));
            this.a.a();
        }

        public final void f(int i) {
            this.c = i;
            this.a.a();
        }

        public final void g(Map<String, Boolean> map) {
            n.d(map);
            this.b.putAll(map);
            this.a.a();
        }
    }
    public l(t t) {
        n.f(t, "callback");
        super();
        this.a = t;
        HashMap obj2 = new HashMap();
        this.b = obj2;
        obj2 = new HashMap();
        this.c = obj2;
    }

    private final app.dogo.com.dogo_android.util.l.a a(String string) {
        l.a aVar = new l.a(string, this.a);
        this.b.put(string, aVar);
        return aVar;
    }

    public final app.dogo.com.dogo_android.util.l.a b(String string) {
        Map key;
        Object obj2;
        n.f(string, "entryId");
        if (this.b.containsKey(string)) {
            n.d(this.b.get(string));
        } else {
            obj2 = a(string);
        }
        return obj2;
    }

    public final void c(String string, Map<String, Boolean> map2) {
        n.f(string, "entryId");
        app.dogo.com.dogo_android.util.l.a obj2 = b(string);
        n.d(obj2);
        obj2.g(map2);
        n.d(map2);
        this.c.putAll(map2);
    }

    public final void d(Map<String, ? extends Map<String, Boolean>> map, boolean z2) {
        String value;
        Object key;
        boolean key2;
        n.f(map, "entryPhotoLikedMap");
        Iterator obj4 = map.entrySet().iterator();
        while (obj4.hasNext()) {
            Object next2 = obj4.next();
            key = (Map.Entry)next2.getKey();
            if (z2) {
            } else {
            }
            c((String)key, (Map)next2.getValue());
            if (!this.b.containsKey(key)) {
            }
        }
    }
}
