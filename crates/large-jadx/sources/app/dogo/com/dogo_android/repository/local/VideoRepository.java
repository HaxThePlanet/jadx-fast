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
import kotlin.b0.i;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.h;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.m0;
import n.a.a;
import okhttp3.CacheControl;
import okhttp3.CacheControl.Builder;

/* compiled from: VideoRepository.kt */
@Metadata(d1 = "\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u0000  2\u00020\u0001:\u0001 B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ#\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J.\u0010\u000b\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u001f\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\u00020\u000c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/repository/local/VideoRepository;", "", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "preferences", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "vimeo", "Lcom/vimeo/networking/VimeoClient;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/google/firebase/firestore/FirebaseFirestore;Lapp/dogo/com/dogo_android/service/PreferenceService;Lcom/vimeo/networking/VimeoClient;Lkotlinx/coroutines/CoroutineDispatcher;)V", "fetchVimeoVideo", "Lapp/dogo/com/dogo_android/model/goodexamples/VimeoVideoModel;", "videoContentId", "", "imageWidth", "", "(JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "continuation", "Lkotlin/coroutines/Continuation;", "tryForceCache", "", "getGoodVideoTricks", "", "Lapp/dogo/com/dogo_android/model/goodexamples/GoodTrickExampleModel;", "trickId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "videoToVideoModel", "video", "Lapp/dogo/com/dogo_android/repository/domain/SimpleVimeoVideo;", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: q1, reason: from kotlin metadata */
public final class VideoRepository {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final q1.a INSTANCE = new q1$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private final FirebaseFirestore dispatcher;
    /* renamed from: b, reason: from kotlin metadata */
    private final p2 firestore;
    /* renamed from: c, reason: from kotlin metadata */
    private final VimeoClient preferences;
    /* renamed from: d, reason: from kotlin metadata */
    private final h0 vimeo;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/repository/local/VideoRepository$Companion;", "", "()V", "LOCALE", "", "THUMB_SIZE", "", "TRICK_ID", "VIDEO_PREFIX", "VIDEO_QUALITY", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u0002H\u0016¨\u0006\t", d2 = {"app/dogo/com/dogo_android/repository/local/VideoRepository$fetchVimeoVideo$3", "Lcom/vimeo/networking/callbacks/ModelCallback;", "Lapp/dogo/com/dogo_android/repository/domain/SimpleVimeoVideo;", "failure", "", "error", "Lcom/vimeo/networking/model/error/VimeoError;", "success", "video", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends ModelCallback<SimpleVimeoVideo> {

        final /* synthetic */ kotlin.b0.d<VimeoVideoModel> a;
        final /* synthetic */ q1 b;
        final /* synthetic */ int c;
        final /* synthetic */ boolean v;
        final /* synthetic */ long w;
        b(kotlin.b0.d<? super VimeoVideoModel> dVar, q1 q1Var, int i, boolean z, long j, Class<SimpleVimeoVideo> cls) {
            this.a = dVar;
            this.b = q1Var;
            this.c = i;
            this.v = z;
            this.w = j;
            super(cls);
        }

        @Override // com.vimeo.networking.callbacks.ModelCallback
        /* renamed from: a, reason: from kotlin metadata */
        public void failure(SimpleVimeoVideo error) {
            n.f(error, "video");
            final VimeoVideoModel vimeoVideoModel = this.b.fetchVimeoVideo(error, this.c);
            Result.a(vimeoVideoModel);
            this.a.resumeWith(vimeoVideoModel);
        }

        @Override // com.vimeo.networking.callbacks.ModelCallback
        public void failure(VimeoError th) {
            n.f(th, "error");
            if (this.v) {
                if (th.getHttpStatusCode() == 504) {
                    boolean z2 = false;
                    this.b.fetchVimeoVideo(this.w, l2, this.c, this.a, z2);
                } else {
                    a.d(new Exception(th.getErrorMessage(), th));
                    Object obj = q.a(new Exception(th.getErrorMessage(), th));
                    Result.a(obj);
                    this.a.resumeWith(obj);
                }
            }
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.VideoRepository", f = "VideoRepository.kt", l = 36, m = "getGoodVideoTricks")
    static final class c extends kotlin.b0.k.a.d {

        int label;
        /* synthetic */ Object result;
        c(kotlin.b0.d<? super q1.c> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return q1.this.videoToVideoModel(null, this);
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001*\u00020\u0004H\u008a@", d2 = {"<anonymous>", "", "Lapp/dogo/com/dogo_android/model/goodexamples/GoodTrickExampleModel;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.VideoRepository$getGoodVideoTricks$2", f = "VideoRepository.kt", l = {}, m = "invokeSuspend")
    static final class d extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, kotlin.b0.d<? super List<? extends GoodTrickExampleModel>>, Object> {

        final /* synthetic */ String $trickId;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            b.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(object);
                Query whereEqualTo2 = q1.this.dispatcher.collectionGroup("trickExampleVideoTranslations").whereEqualTo("locale", LocaleService.supportedLocales.getLocaleString(q1.this.firestore.W())).whereEqualTo("trickId", this.$trickId);
                n.e(whereEqualTo2, "firestore.collectionGroup(\"trickExampleVideoTranslations\")\n                .whereEqualTo(LOCALE, correctedLocale)\n                .whereEqualTo(TRICK_ID, trickId)");
                return app.dogo.com.dogo_android.util.extensionfunction.j1.j(whereEqualTo2, GoodTrickExampleModel.class).blockingGet();
            }
        }

        d(String str, kotlin.b0.d<? super q1.d> dVar) {
            this.$trickId = str;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, kotlin.b0.d<? super List<GoodTrickExampleModel>> dVar) {
            return (app.dogo.com.dogo_android.repository.local.q1.d)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<w> create(Object object, kotlin.b0.d<?> dVar) {
            return new app.dogo.com.dogo_android.repository.local.q1.d(q1.this, this.$trickId, dVar);
        }
    }
    public q1(FirebaseFirestore firebaseFirestore, p2 p2Var, VimeoClient vimeoClient, h0 h0Var) {
        n.f(firebaseFirestore, "firestore");
        n.f(p2Var, "preferences");
        n.f(vimeoClient, "vimeo");
        n.f(h0Var, "dispatcher");
        super();
        this.dispatcher = firebaseFirestore;
        this.firestore = p2Var;
        this.preferences = vimeoClient;
        this.vimeo = h0Var;
    }

    public static final /* synthetic */ void a(q1 q1Var, long j, int i, kotlin.b0.d dVar, boolean z) {
        q1Var.fetchVimeoVideo(j, i, dVar, z);
    }

    /* renamed from: b, reason: from kotlin metadata */
    /* suspend */ public static final /* synthetic */ FirebaseFirestore getGoodVideoTricks(q1 trickId) {
        return trickId.dispatcher;
    }

    public static final /* synthetic */ p2 c(q1 q1Var) {
        return q1Var.firestore;
    }

    public static final /* synthetic */ VimeoVideoModel d(q1 q1Var, SimpleVimeoVideo simpleVimeoVideo, int i) {
        return q1Var.fetchVimeoVideo(simpleVimeoVideo, i);
    }

    /* renamed from: f, reason: from kotlin metadata */
    private final void fetchVimeoVideo(long videoContentId, int imageWidth, kotlin.b0.d<? super VimeoVideoModel> continuation, boolean tryForceCache) throws NoWhenBranchMatchedException {
        CacheControl cacheControl_Builder;
        int i3 = tryForceCache;
        if (i3 == 0) {
            cacheControl_Builder = CacheControl.FORCE_NETWORK;
            VideoRepository_fetchVimeoVideo_3 videoRepository_fetchVimeoVideo_3 = new VideoRepository_fetchVimeoVideo_3(continuation, this, imageWidth, tryForceCache, videoContentId, cls, SimpleVimeoVideo.class);
            preferences2.fetchContent(str, cacheControl_Builder, videoRepository_fetchVimeoVideo_3, null, null, "files,pictures");
            return;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ Object g(q1 q1Var, long j, int i, kotlin.b0.d dVar, int i2, Object object) {
        if (i2 & 2 != 0) {
            i = 640;
        }
        return q1Var.e(j, dVar, dVar);
    }

    /* renamed from: i, reason: from kotlin metadata */
    /* suspend */ private final VimeoVideoModel fetchVimeoVideo(SimpleVimeoVideo videoContentId, int imageWidth) {
        String imageWidth2;
        int i = 0;
        boolean z;
        Object obj;
        List files = videoContentId.getFiles();
        i = 0;
        int r0 = i;
        SimpleVimeoVideo.PictureFiles pictures = videoContentId.getPictures();
        if (pictures != null) {
            java.util.ArrayList sizes = pictures.getSizes();
            if (sizes != null) {
                Iterator it = sizes.iterator();
                while (it.hasNext()) {
                    Integer width = (SimpleVimeoVideo_PictureFiles_PictureFile)item2.getWidth();
                    if (z) {
                        break;
                    }
                }
                if (i != null) {
                    String link = i.getLink();
                }
            }
        }
        imageWidth2 = "";
        if (imageWidth2 == null) {
        }
        if (i == 0) {
        }
        VimeoVideoModel vimeoVideoModel = new VimeoVideoModel(imageWidth2, imageWidth2);
        return vimeoVideoModel;
    }

    public final Object e(long j, int i, kotlin.b0.d<? super VimeoVideoModel> dVar) {
        final i safeContinuation = new SafeContinuation(b.c(dVar));
        this.fetchVimeoVideo(j, i, safeContinuation, true);
        final Object obj = safeContinuation.b();
        if (obj == b.d()) {
            h.c(dVar);
        }
        return obj;
    }

    /* renamed from: h, reason: from kotlin metadata */
    public final Object videoToVideoModel(String video, kotlin.b0.d<? super List<GoodTrickExampleModel>> imageWidth) {
        Object imageWidth2;
        int label2;
        int i = -2147483648;
        int i2;
        Object result2;
        z = imageWidth instanceof app.dogo.com.dogo_android.repository.local.q1.c;
        if (imageWidth instanceof app.dogo.com.dogo_android.repository.local.q1.c) {
            imageWidth2 = imageWidth;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                imageWidth2.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.q1.c cVar = new app.dogo.com.dogo_android.repository.local.q1.c(this, imageWidth);
            }
        }
        Object obj = b.d();
        int i3 = 1;
        if (imageWidth2.label != 0 && imageWidth2.label == i3) {
            q.b(imageWidth2.result);
            n.e(result2, "suspend fun getGoodVideoTricks(trickId: String): List<GoodTrickExampleModel> {\n        return withContext(dispatcher) {\n            val locale = preferences.selectedLocale\n            val correctedLocale = LocaleService.getLanguageFromLocaleString(locale)\n            firestore.collectionGroup(\"trickExampleVideoTranslations\")\n                .whereEqualTo(LOCALE, correctedLocale)\n                .whereEqualTo(TRICK_ID, trickId)\n                .createSingle(GoodTrickExampleModel::class.java)\n                .blockingGet()\n        }\n    }");
            return result2;
        }
        q.b(imageWidth2.result);
        kotlin.b0.d dVar = null;
        imageWidth2.label = i3;
        if (kotlinx.coroutines.internal.k.e(this.vimeo, new app.dogo.com.dogo_android.repository.local.q1.d(this, video, dVar), imageWidth2) == obj) {
            return obj;
        }
    }

    public /* synthetic */ q1(FirebaseFirestore firebaseFirestore, p2 p2Var, VimeoClient vimeoClient, h0 h0Var, int i, g gVar) {
        if (i & 8 != 0) {
            h0Var = Dispatchers.b();
        }
        this(firebaseFirestore, p2Var, vimeoClient, h0Var);
    }

}
