package app.dogo.com.dogo_android.s.b;

import app.dogo.com.dogo_android.model.goodexamples.GoodTrickExampleModel;
import app.dogo.com.dogo_android.model.goodexamples.VimeoVideoModel;
import app.dogo.com.dogo_android.repository.domain.SimpleVimeoVideo;
import app.dogo.com.dogo_android.repository.domain.SimpleVimeoVideo.PictureFiles;
import app.dogo.com.dogo_android.repository.domain.SimpleVimeoVideo.PictureFiles.PictureFile;
import app.dogo.com.dogo_android.repository.domain.SimpleVimeoVideo.VideoFile;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.h0.j1;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.vimeo.networking.VimeoClient;
import com.vimeo.networking.callbacks.ModelCallback;
import com.vimeo.networking.model.error.VimeoError;
import i.b.a0;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.b0.d;
import kotlin.b0.i;
import kotlin.b0.j.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.h;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.p;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;
import n.a.a;
import okhttp3.CacheControl;
import okhttp3.CacheControl.Builder;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u0000  2\u00020\u0001:\u0001 B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ#\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J.\u0010\u000b\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u001f\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\u00020\u000c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/repository/local/VideoRepository;", "", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "preferences", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "vimeo", "Lcom/vimeo/networking/VimeoClient;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/google/firebase/firestore/FirebaseFirestore;Lapp/dogo/com/dogo_android/service/PreferenceService;Lcom/vimeo/networking/VimeoClient;Lkotlinx/coroutines/CoroutineDispatcher;)V", "fetchVimeoVideo", "Lapp/dogo/com/dogo_android/model/goodexamples/VimeoVideoModel;", "videoContentId", "", "imageWidth", "", "(JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "continuation", "Lkotlin/coroutines/Continuation;", "tryForceCache", "", "getGoodVideoTricks", "", "Lapp/dogo/com/dogo_android/model/goodexamples/GoodTrickExampleModel;", "trickId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "videoToVideoModel", "video", "Lapp/dogo/com/dogo_android/repository/domain/SimpleVimeoVideo;", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class q1 {

    public static final app.dogo.com.dogo_android.s.b.q1.a Companion;
    private final FirebaseFirestore a;
    private final p2 b;
    private final VimeoClient c;
    private final h0 d;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/repository/local/VideoRepository$Companion;", "", "()V", "LOCALE", "", "THUMB_SIZE", "", "TRICK_ID", "VIDEO_PREFIX", "VIDEO_QUALITY", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u0002H\u0016¨\u0006\t", d2 = {"app/dogo/com/dogo_android/repository/local/VideoRepository$fetchVimeoVideo$3", "Lcom/vimeo/networking/callbacks/ModelCallback;", "Lapp/dogo/com/dogo_android/repository/domain/SimpleVimeoVideo;", "failure", "", "error", "Lcom/vimeo/networking/model/error/VimeoError;", "success", "video", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends ModelCallback<SimpleVimeoVideo> {

        final d<VimeoVideoModel> a;
        final app.dogo.com.dogo_android.s.b.q1 b;
        final int c;
        final boolean v;
        final long w;
        b(d<? super VimeoVideoModel> d, app.dogo.com.dogo_android.s.b.q1 q12, int i3, boolean z4, long l5, Class<SimpleVimeoVideo> class6) {
            this.a = d;
            this.b = q12;
            this.c = i3;
            this.v = z4;
            this.w = l5;
            super(obj7);
        }

        @Override // com.vimeo.networking.callbacks.ModelCallback
        public void a(SimpleVimeoVideo simpleVimeoVideo) {
            n.f(simpleVimeoVideo, "video");
            final VimeoVideoModel obj4 = q1.d(this.b, simpleVimeoVideo, this.c);
            kotlin.p.a aVar = p.a;
            p.a(obj4);
            this.a.resumeWith(obj4);
        }

        @Override // com.vimeo.networking.callbacks.ModelCallback
        public void failure(VimeoError vimeoError) {
            boolean httpStatusCode;
            int exception;
            Object errorMessage;
            long l;
            int i;
            d dVar;
            int i2;
            Object obj9;
            n.f(vimeoError, "error");
            if (this.v && vimeoError.getHttpStatusCode() == 504) {
                if (vimeoError.getHttpStatusCode() == 504) {
                    q1.a(this.b, this.w, obj4, this.c, this.a);
                } else {
                    Exception exception2 = new Exception(vimeoError.getErrorMessage(), vimeoError);
                    a.d(exception2);
                    exception = new Exception(vimeoError.getErrorMessage(), vimeoError);
                    obj9 = p.a;
                    obj9 = q.a(exception);
                    p.a(obj9);
                    this.a.resumeWith(obj9);
                }
            } else {
            }
        }

        @Override // com.vimeo.networking.callbacks.ModelCallback
        public void success(Object object) {
            a((SimpleVimeoVideo)object);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.VideoRepository", f = "VideoRepository.kt", l = 36, m = "getGoodVideoTricks")
    static final class c extends d {

        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.q1 this$0;
        c(app.dogo.com.dogo_android.s.b.q1 q1, d<? super app.dogo.com.dogo_android.s.b.q1.c> d2) {
            this.this$0 = q1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.h(0, this);
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001*\u00020\u0004H\u008a@", d2 = {"<anonymous>", "", "Lapp/dogo/com/dogo_android/model/goodexamples/GoodTrickExampleModel;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.VideoRepository$getGoodVideoTricks$2", f = "VideoRepository.kt", l = {}, m = "invokeSuspend")
    static final class d extends k implements p<m0, d<? super List<? extends GoodTrickExampleModel>>, Object> {

        final String $trickId;
        int label;
        final app.dogo.com.dogo_android.s.b.q1 this$0;
        d(app.dogo.com.dogo_android.s.b.q1 q1, String string2, d<? super app.dogo.com.dogo_android.s.b.q1.d> d3) {
            this.this$0 = q1;
            this.$trickId = string2;
            super(2, d3);
        }

        public final Object c(m0 m0, d<? super List<GoodTrickExampleModel>> d2) {
            return (q1.d)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            q1.d obj3 = new q1.d(this.this$0, this.$trickId, d2);
            return obj3;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            b.d();
            if (this.label != 0) {
            } else {
                q.b(object);
                Query obj3 = q1.b(this.this$0).collectionGroup("trickExampleVideoTranslations").whereEqualTo("locale", n2.a.a(q1.c(this.this$0).W())).whereEqualTo("trickId", this.$trickId);
                n.e(obj3, "firestore.collectionGroup(\"trickExampleVideoTranslations\")\n                .whereEqualTo(LOCALE, correctedLocale)\n                .whereEqualTo(TRICK_ID, trickId)");
                return j1.j(obj3, GoodTrickExampleModel.class).blockingGet();
            }
            obj3 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj3;
        }
    }
    static {
        q1.a aVar = new q1.a(0);
        q1.Companion = aVar;
    }

    public q1(FirebaseFirestore firebaseFirestore, p2 p22, VimeoClient vimeoClient3, h0 h04) {
        n.f(firebaseFirestore, "firestore");
        n.f(p22, "preferences");
        n.f(vimeoClient3, "vimeo");
        n.f(h04, "dispatcher");
        super();
        this.a = firebaseFirestore;
        this.b = p22;
        this.c = vimeoClient3;
        this.d = h04;
    }

    public q1(FirebaseFirestore firebaseFirestore, p2 p22, VimeoClient vimeoClient3, h0 h04, int i5, g g6) {
        h0 obj4;
        if (i5 &= 8 != 0) {
            obj4 = c1.b();
        }
        super(firebaseFirestore, p22, vimeoClient3, obj4);
    }

    public static final void a(app.dogo.com.dogo_android.s.b.q1 q1, long l2, int i3, d d4, boolean z5) {
        q1.f(l2, i3, d4, z5);
    }

    public static final FirebaseFirestore b(app.dogo.com.dogo_android.s.b.q1 q1) {
        return q1.a;
    }

    public static final p2 c(app.dogo.com.dogo_android.s.b.q1 q1) {
        return q1.b;
    }

    public static final VimeoVideoModel d(app.dogo.com.dogo_android.s.b.q1 q1, SimpleVimeoVideo simpleVimeoVideo2, int i3) {
        return q1.i(simpleVimeoVideo2, i3);
    }

    private final void f(long l, int i2, d<? super VimeoVideoModel> d3, boolean z4) {
        CacheControl fORCE_NETWORK;
        TimeUnit dAYS;
        int i;
        int i5 = obj18;
        if (i5 == 0) {
            fORCE_NETWORK = CacheControl.FORCE_NETWORK;
            super(z4, this, d3, obj18, l, obj6, SimpleVimeoVideo.class);
            obj3.c.fetchContent(n.o("videos/", Long.valueOf(l)), fORCE_NETWORK, bVar3, 0, 0, "files,pictures");
        } else {
        }
        Object obj2 = this;
        NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
        throw noWhenBranchMatchedException;
    }

    public static Object g(app.dogo.com.dogo_android.s.b.q1 q1, long l2, int i3, d d4, int i5, Object object6) {
        int obj3;
        if (object6 &= 2 != 0) {
            obj3 = 640;
        }
        return q1.e(l2, i3, obj3);
    }

    private final VimeoVideoModel i(SimpleVimeoVideo simpleVimeoVideo, int i2) {
        List iterator;
        String link2;
        int link;
        int next;
        boolean z;
        int intValue;
        String str;
        Object obj6;
        iterator = simpleVimeoVideo.getFiles();
        link = 0;
        if (iterator == null) {
            link2 = link;
        } else {
            iterator = iterator.iterator();
            for (Object next : iterator) {
            }
            next = link;
            if ((SimpleVimeoVideo.VideoFile)next == null) {
            } else {
                link2 = (SimpleVimeoVideo.VideoFile)next.getLink();
            }
        }
        obj6 = simpleVimeoVideo.getPictures();
        if (obj6 == null) {
        } else {
            obj6 = obj6.getSizes();
            if (obj6 == null) {
            } else {
                obj6 = obj6.iterator();
                while (obj6.hasNext()) {
                    intValue = (SimpleVimeoVideo.PictureFiles.PictureFile)obj6.next().getWidth();
                    if (intValue == null) {
                    } else {
                    }
                    if (intValue.intValue() == i2) {
                    } else {
                    }
                    z = 0;
                    z = 1;
                }
                next = link;
                if ((SimpleVimeoVideo.PictureFiles.PictureFile)next == null) {
                } else {
                    link = (SimpleVimeoVideo.PictureFiles.PictureFile)next.getLink();
                }
            }
        }
        final String obj7 = "";
        if (link2 == null) {
            link2 = obj7;
        }
        if (link == 0) {
            link = obj7;
        }
        obj6 = new VimeoVideoModel(link2, link);
        return obj6;
    }

    public final Object e(long l, int i2, d<? super VimeoVideoModel> d3) {
        i iVar2 = new i(b.c(obj11));
        this.f(l, obj2, d3, iVar2);
        final Object obj8 = iVar2.b();
        if (obj8 == b.d()) {
            h.c(obj11);
        }
        return obj8;
    }

    public final Object h(String string, d<? super List<GoodTrickExampleModel>> d2) {
        boolean cVar;
        int label;
        int i;
        int dVar;
        int i2;
        int i3;
        Object obj7;
        cVar = d2;
        label = cVar.label;
        i = Integer.MIN_VALUE;
        if (d2 instanceof q1.c && label & i != 0) {
            cVar = d2;
            label = cVar.label;
            i = Integer.MIN_VALUE;
            if (label & i != 0) {
                cVar.label = label -= i;
            } else {
                cVar = new q1.c(this, d2);
            }
        } else {
        }
        obj7 = cVar.result;
        Object obj = b.d();
        dVar = cVar.label;
        int i4 = 1;
        if (dVar != 0) {
            if (dVar != i4) {
            } else {
                q.b(obj7);
                n.e(obj7, "suspend fun getGoodVideoTricks(trickId: String): List<GoodTrickExampleModel> {\n        return withContext(dispatcher) {\n            val locale = preferences.selectedLocale\n            val correctedLocale = LocaleService.getLanguageFromLocaleString(locale)\n            firestore.collectionGroup(\"trickExampleVideoTranslations\")\n                .whereEqualTo(LOCALE, correctedLocale)\n                .whereEqualTo(TRICK_ID, trickId)\n                .createSingle(GoodTrickExampleModel::class.java)\n                .blockingGet()\n        }\n    }");
                return obj7;
            }
            IllegalStateException obj6 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj6;
        }
        q.b(obj7);
        dVar = new q1.d(this, string, 0);
        cVar.label = i4;
        if (k.e(this.d, dVar, cVar) == obj) {
            return obj;
        }
    }
}
