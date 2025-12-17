package app.dogo.com.dogo_android.d.b;

import android.net.Uri;
import android.os.Bundle;
import androidx.databinding.a;
import androidx.databinding.h;
import androidx.databinding.h.a;
import androidx.databinding.i;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.k.h;
import app.dogo.com.dogo_android.k.q;
import app.dogo.com.dogo_android.model.ChallengeComment;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.model.ChallengeModel;
import app.dogo.com.dogo_android.model.DogProfileModel;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.s.a.n3;
import app.dogo.com.dogo_android.s.b.a1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.m2;
import app.dogo.com.dogo_android.service.m2.b;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.q2;
import app.dogo.com.dogo_android.service.s2;
import app.dogo.com.dogo_android.service.s2.a;
import app.dogo.com.dogo_android.service.t2;
import app.dogo.com.dogo_android.service.u2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.f;
import app.dogo.com.dogo_android.util.l;
import app.dogo.com.dogo_android.v.c;
import app.dogo.com.dogo_android.w.c1;
import app.dogo.com.dogo_android.w.i1;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.w.t;
import app.dogo.com.dogo_android.w.u;
import app.dogo.com.dogo_android.w.v2;
import app.dogo.com.dogo_android.w.w2;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.m;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentChange.Type;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QuerySnapshot;
import f.d.a.a;
import i.b.a0;
import i.b.b;
import i.b.c0;
import i.b.g0;
import i.b.j0.a;
import i.b.r0.a;
import i.b.s0.a;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.k0.l;
import kotlin.w;
import kotlin.y.p;
import kotlin.z.a;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0090\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0012\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010\u001cJ\u000e\u0010y\u001a\u0008\u0012\u0004\u0012\u00020\"0zH\u0002J\u000e\u0010{\u001a\u00020|2\u0006\u0010}\u001a\u00020mJ\u0006\u0010~\u001a\u00020|J\u001a\u0010\u007f\u001a\u00020\"2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010 2\u0007\u0010\u0081\u0001\u001a\u00020AJ\u0007\u0010\u0082\u0001\u001a\u00020|J\u0007\u0010\u0083\u0001\u001a\u00020|J\u001d\u0010\u0084\u0001\u001a\u00020\"2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010 2\t\u0010\u0086\u0001\u001a\u0004\u0018\u000102J\u001d\u0010\u0087\u0001\u001a\u00020\"2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010 2\t\u0010\u0088\u0001\u001a\u0004\u0018\u000102J\u000f\u0010\u0089\u0001\u001a\u0008\u0012\u0004\u0012\u00020 0zH\u0002J\u000f\u0010\u008a\u0001\u001a\u0008\u0012\u0004\u0012\u00020\"0zH\u0002J\r\u0010\u008b\u0001\u001a\u0008\u0012\u0004\u0012\u00020-0,J\u000b\u0010\u008c\u0001\u001a\u0004\u0018\u00010;H\u0002J\u0011\u0010\u008d\u0001\u001a\n\u0012\u0005\u0012\u00030\u008f\u00010\u008e\u0001H\u0002J\u0007\u0010\u0090\u0001\u001a\u00020\"J\u0010\u0010\u0091\u0001\u001a\u00020\"2\u0007\u0010\u0080\u0001\u001a\u00020-J\u0010\u0010\u0092\u0001\u001a\u00020\"2\u0007\u0010\u0080\u0001\u001a\u00020-J\u0007\u0010\u0093\u0001\u001a\u00020\"J\u0010\u0010\u0094\u0001\u001a\u00020\"2\u0007\u0010\u0080\u0001\u001a\u00020 J\u0007\u0010\u0095\u0001\u001a\u00020\"J\u0007\u0010\u0096\u0001\u001a\u00020|J\u0007\u0010\u0097\u0001\u001a\u00020|J\u0007\u0010\u0098\u0001\u001a\u00020|J\u001b\u0010\u0099\u0001\u001a\u00020|2\u0007\u0010\u0080\u0001\u001a\u00020-2\t\u0010\u009a\u0001\u001a\u0004\u0018\u000102J\u001b\u0010\u009b\u0001\u001a\u00020|2\u0007\u0010\u009c\u0001\u001a\u0002022\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010-J\u0013\u0010\u009e\u0001\u001a\u00020\"2\n\u0010\u009f\u0001\u001a\u0005\u0018\u00010 \u0001J!\u0010¡\u0001\u001a\n\u0012\u0005\u0012\u00030£\u00010¢\u00012\u0007\u0010¤\u0001\u001a\u0002022\u0007\u0010¥\u0001\u001a\u000202J\u0010\u0010¦\u0001\u001a\u00020\"2\u0007\u0010\u0080\u0001\u001a\u00020-J\u0007\u0010§\u0001\u001a\u00020|J\u0012\u0010¨\u0001\u001a\u00020|2\t\u0010©\u0001\u001a\u0004\u0018\u000102R\u001a\u0010\u001d\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020 0\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010(\u001a\u0004\u0018\u00010'2\u0008\u0010&\u001a\u0004\u0018\u00010'@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010*R\u001d\u0010+\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020-0,0\u001e¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010/R(\u00100\u001a\u0010\u0012\u000c\u0012\n 3*\u0004\u0018\u0001020201X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00084\u00105\"\u0004\u00086\u00107R\u0014\u00108\u001a\u0008\u0018\u000109R\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010<\u001a\u0002028F¢\u0006\u0006\u001a\u0004\u0008=\u0010>R\u0010\u0010?\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010@\u001a\u00020A8F¢\u0006\u0006\u001a\u0004\u0008B\u0010CR\u0013\u0010D\u001a\u0004\u0018\u0001028F¢\u0006\u0006\u001a\u0004\u0008E\u0010>R\u0017\u0010F\u001a\u0008\u0012\u0004\u0012\u00020\"0G¢\u0006\u0008\n\u0000\u001a\u0004\u0008H\u0010IR\u001d\u0010J\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020 0\u001f0K¢\u0006\u0008\n\u0000\u001a\u0004\u0008L\u0010MR\u0010\u0010N\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010O\u001a\u0004\u0018\u00010 2\u0008\u0010&\u001a\u0004\u0018\u00010 @BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008P\u0010QR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010T\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\u0008T\u0010UR\u001e\u0010V\u001a\u00020\"2\u0006\u0010&\u001a\u00020\"@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008V\u0010UR\u001e\u0010W\u001a\u00020\"2\u0006\u0010&\u001a\u00020\"@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008W\u0010UR\u0011\u0010X\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\u0008X\u0010UR\u001a\u0010Y\u001a\u00020AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008Z\u0010C\"\u0004\u0008[\u0010\\R\u001c\u0010]\u001a\u0010\u0012\u0004\u0012\u000202\u0012\u0006\u0012\u0004\u0018\u00010_0^X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010a\u001a\u0008\u0012\u0004\u0012\u00020\"0G¢\u0006\u0008\n\u0000\u001a\u0004\u0008b\u0010IR\u0017\u0010c\u001a\u0008\u0012\u0004\u0012\u0002020,8F¢\u0006\u0006\u001a\u0004\u0008d\u0010eR\u001d\u0010f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020-0,0\u001e¢\u0006\u0008\n\u0000\u001a\u0004\u0008g\u0010/R\u0010\u0010h\u001a\u0004\u0018\u00010iX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010j\u001a\u0008\u0012\u0004\u0012\u00020\"0\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010k\u001a\u0008\u0012\u0004\u0012\u00020-0lX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010n\u001a\u00020m2\u0006\u0010&\u001a\u00020m@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008o\u0010pR\u0017\u0010q\u001a\u0008\u0012\u0004\u0012\u0002020\u001e¢\u0006\u0008\n\u0000\u001a\u0004\u0008r\u0010/R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010s\u001a\u0004\u0018\u00010t8G¢\u0006\u0006\u001a\u0004\u0008u\u0010vR\u0010\u0010w\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010x\u001a\u0004\u0018\u00010iX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006ª\u0001", d2 = {"Lapp/dogo/com/dogo_android/challenge/comments/ChallengeCommentsViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "userLocalCacheService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "storageService", "Lapp/dogo/com/dogo_android/service/StorageService;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "challengeLocalRepository", "Lapp/dogo/com/dogo_android/repository/local/ChallengeLocalRepository;", "stateManager", "Lapp/dogo/com/dogo_android/service/StateManager;", "rateItService", "Lapp/dogo/com/dogo_android/service/RateItService;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/UserLocalCacheService;Lapp/dogo/com/dogo_android/service/FirestoreService;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/StorageService;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/repository/local/ChallengeLocalRepository;Lapp/dogo/com/dogo_android/service/StateManager;Lapp/dogo/com/dogo_android/service/RateItService;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "_entryDataResults", "Lcom/hadilq/liveevent/LiveEvent;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "alreadyScrollToDeeplink", "", "baseEntryLayoutHelper", "Lapp/dogo/com/dogo_android/util/BaseEntryLayoutHelper;", "challengeFetched", "<set-?>", "Lapp/dogo/com/dogo_android/model/ChallengeModel;", "challengeModel", "getChallengeModel", "()Lapp/dogo/com/dogo_android/model/ChallengeModel;", "commentFetcher", "", "Lapp/dogo/com/dogo_android/model/ChallengeComment;", "getCommentFetcher", "()Lcom/hadilq/liveevent/LiveEvent;", "commentField", "Landroidx/databinding/ObservableField;", "", "kotlin.jvm.PlatformType", "getCommentField", "()Landroidx/databinding/ObservableField;", "setCommentField", "(Landroidx/databinding/ObservableField;)V", "commentPager", "Lapp/dogo/com/dogo_android/service/FirestoreService$FirestorePager;", "currentDog", "Lapp/dogo/com/dogo_android/model/DogProfileModel;", "currentDogId", "getCurrentDogId", "()Ljava/lang/String;", "deeplinkCommentId", "dogCount", "", "getDogCount", "()I", "emptyDogId", "getEmptyDogId", "endOfListNotifier", "Landroidx/lifecycle/MutableLiveData;", "getEndOfListNotifier", "()Landroidx/lifecycle/MutableLiveData;", "entryDataResults", "Landroidx/lifecycle/LiveData;", "getEntryDataResults", "()Landroidx/lifecycle/LiveData;", "entryId", "entryModel", "getEntryModel", "()Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "firstLaunch", "hasPremiumBadge", "isCurrentDogEmpty", "()Z", "isEntryFetched", "isLikesFetched", "isUserSignedIn", "lastSavedPosition", "getLastSavedPosition", "setLastSavedPosition", "(I)V", "likeList", "", "", "listEndReached", "listUpdateNotifier", "getListUpdateNotifier", "markedCommentIds", "getMarkedCommentIds", "()Ljava/util/List;", "newCommentFetcher", "getNewCommentFetcher", "newCommentListener", "Lcom/google/firebase/firestore/ListenerRegistration;", "premiumState", "savedList", "", "", "savedTimestamp", "getSavedTimestamp", "()J", "scrollToComment", "getScrollToComment", "userDogAvatarUri", "Landroid/net/Uri;", "getUserDogAvatarUri", "()Landroid/net/Uri;", "userEntryId", "userEntryListener", "addDogIfNeededAndSetLocalDog", "Lio/reactivex/Single;", "attachNewCommentListener", "", "startPointTimeStamp", "attachUserEntryListener", "deleteEntry", "model", "photoPosition", "detachNewCommentListener", "detachUserEntryListener", "detectDoubleClick", "mod", "id", "detectSimpleClick", "photoId", "fetchEntryData", "fillCacheIfNeededAndSetLocalDog", "getCachedList", "getCurrentDogOrNull", "getUserEntryListener", "Lcom/google/firebase/firestore/EventListener;", "Lcom/google/firebase/firestore/QuerySnapshot;", "isAdmin", "isCommentAuthor", "isEntryAuthor", "isEntryReported", "isEntryUsers", "isPremium", "loadCurrentDog", "loadEntryData", "loadMoreComments", "onCommentDelete", "parentTag", "onSendClick", "string", "replyTarget", "setArguments", "arguments", "Landroid/os/Bundle;", "setupCommentListData", "Lcom/google/android/gms/tasks/Task;", "Ljava/lang/Void;", "challengeEntryId", "challengeId", "shouldRemoveMessage", "tryToScrollToDeeplink", "updateCurrentDogSelection", "dogId", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class x extends r {

    private final u2 A;
    private final m2 B;
    private final h2 C;
    private final v2 D;
    private final n3 E;
    private final o3 F;
    private final t2 G;
    private final p2 H;
    private final a1 I;
    private final s2 J;
    private final q2 K;
    private final j2 L;
    private final a<y<ChallengeEntryModel>> M;
    private final LiveData<y<ChallengeEntryModel>> N;
    private y<Boolean> O;
    private m2.b P;
    private ListenerRegistration Q;
    private ListenerRegistration R;
    private i<String> S;
    private final a<List<ChallengeComment>> T;
    private final a<List<ChallengeComment>> U;
    private final x<Boolean> V;
    private final x<Boolean> W;
    private final List<ChallengeComment> X;
    private final Map<String, Object> Y;
    private String Z;
    private ChallengeEntryModel a0;
    private ChallengeModel b0;
    private DogProfileModel c0;
    private String d0;
    private int e0;
    private long f0;
    private boolean g0;
    private boolean h0;
    private boolean i0;
    private boolean j0;
    private boolean k0 = true;
    private String l0;
    private boolean m0;
    private final a<String> n0;
    private final f o0;
    private boolean p0;
    private final p1 z;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class b {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[DocumentChange.Type.ADDED.ordinal()] = 1;
            iArr[DocumentChange.Type.MODIFIED.ordinal()] = 2;
            iArr[DocumentChange.Type.REMOVED.ordinal()] = 3;
            x.b.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 5, 1})
    public static final class d implements Comparator {
        public final int compare(T t, T t2) {
            long seconds;
            long seconds2;
            Timestamp obj6 = (ChallengeComment)t2.getDate();
            if (obj6 == null) {
                seconds2 = seconds;
            } else {
                seconds2 = obj6.getSeconds();
            }
            Timestamp obj5 = (ChallengeComment)t.getDate();
            if (obj5 == null) {
            } else {
                seconds = obj5.getSeconds();
            }
            return a.c(Long.valueOf(seconds2), Long.valueOf(seconds));
        }
    }

    @Metadata(d1 = "\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0008", d2 = {"app/dogo/com/dogo_android/challenge/comments/ChallengeCommentsViewModel$1", "Landroidx/databinding/Observable$OnPropertyChangedCallback;", "onPropertyChanged", "", "observable", "Landroidx/databinding/Observable;", "i", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends h.a {

        final app.dogo.com.dogo_android.d.b.x a;
        a(app.dogo.com.dogo_android.d.b.x x) {
            this.a = x;
            super();
        }

        @Override // androidx.databinding.h$a
        public void d(h h, int i2) {
            n.f(h, "observable");
            this.a.l(42);
        }
    }

    @Metadata(d1 = "\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\u0008\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t", d2 = {"app/dogo/com/dogo_android/challenge/comments/ChallengeCommentsViewModel$baseEntryLayoutHelper$1", "Lapp/dogo/com/dogo_android/util/BaseEntryLayoutHelper;", "onEntryUnvote", "", "entryModel", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "photoId", "", "onEntryUpvote", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends f {

        final app.dogo.com.dogo_android.d.b.x a;
        c(app.dogo.com.dogo_android.d.b.x x) {
            this.a = x;
            super();
        }

        @Override // app.dogo.com.dogo_android.util.f
        public void onEntryUnvote(ChallengeEntryModel challengeEntryModel, String string2) {
            n.f(challengeEntryModel, "entryModel");
            n.f(string2, "photoId");
            this.unVoteLogic(x.y(this.a), x.B(this.a), x.w(this.a).v(), challengeEntryModel, string2);
            this.a.c0().setValue(Boolean.TRUE);
        }

        @Override // app.dogo.com.dogo_android.util.f
        public void onEntryUpvote(ChallengeEntryModel challengeEntryModel, String string2) {
            String str4;
            Object str2;
            Object obj2;
            m2 m2Var;
            q2 q2Var;
            o3 o3Var;
            ChallengeEntryModel challengeEntryModel2;
            String str5;
            String str;
            String str3;
            Object obj;
            Object obj12;
            Object[] obj13;
            n.f(string2, "photoId");
            DogProfileModel dogProfileModel = x.x(this.a);
            if (dogProfileModel == null) {
                str4 = 0;
            } else {
                str4 = dogProfileModel.getId();
            }
            final String str8 = str4;
            if (str8 != null && challengeEntryModel != null) {
                if (challengeEntryModel != null) {
                    this.upvoteLogic(x.y(this.a), x.A(this.a), x.B(this.a), challengeEntryModel, x.w(this.a).v(), x.C(this.a), str8, x.z(this.a).h(), string2);
                    this.a.c0().setValue(Boolean.TRUE);
                } else {
                    obj13 = new StringBuilder();
                    obj13.append("onEntryUpvote error, current dog id is ");
                    obj13.append(str8);
                    obj13.append(", entryModel is ");
                    obj13.append(challengeEntryModel);
                    a.c(obj13.toString(), new Object[0]);
                }
            } else {
            }
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.d.b.x this$0;
        e(app.dogo.com.dogo_android.d.b.x x) {
            this.this$0 = x;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Throwable)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Throwable throwable) {
            n.f(throwable, "it");
            y.a aVar2 = new y.a(throwable);
            x.D(this.this$0).postValue(aVar2);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends p implements l<ChallengeEntryModel, w> {

        final app.dogo.com.dogo_android.d.b.x this$0;
        f(app.dogo.com.dogo_android.d.b.x x) {
            this.this$0 = x;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(ChallengeEntryModel challengeEntryModel) {
            y.c cVar = new y.c(challengeEntryModel);
            x.D(this.this$0).postValue(cVar);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((ChallengeEntryModel)object);
            return w.a;
        }
    }
    public x(p1 p1, u2 u22, m2 m23, h2 h24, v2 v25, n3 n36, o3 o37, t2 t28, p2 p29, a1 a110, s2 s211, q2 q212, j2 j213) {
        n.f(p1, "userRepository");
        n.f(u22, "userLocalCacheService");
        n.f(m23, "firestoreService");
        n.f(h24, "authService");
        n.f(v25, "utilities");
        n.f(n36, "subscribeInteractor");
        n.f(o37, "tracker");
        n.f(t28, "storageService");
        n.f(p29, "preferenceService");
        n.f(a110, "challengeLocalRepository");
        n.f(s211, "stateManager");
        n.f(q212, "rateItService");
        n.f(j213, "connectivityService");
        super();
        this.z = p1;
        this.A = u22;
        this.B = m23;
        this.C = h24;
        this.D = v25;
        this.E = n36;
        this.F = o37;
        this.G = t28;
        this.H = p29;
        this.I = a110;
        this.J = s211;
        this.K = q212;
        this.L = j213;
        a obj2 = new a();
        this.M = obj2;
        this.N = obj2;
        this.O = y.b.a;
        obj2 = new i("");
        this.S = obj2;
        obj2 = new a();
        this.T = obj2;
        obj2 = new a();
        this.U = obj2;
        obj2 = new x();
        this.V = obj2;
        obj2 = new x();
        this.W = obj2;
        obj2 = new ArrayList();
        this.X = obj2;
        obj2 = new HashMap();
        this.Y = obj2;
        obj2 = 1;
        obj2 = new a();
        this.n0 = obj2;
        obj2 = new x.c(this);
        this.o0 = obj2;
        this.c0 = V();
        x.a obj3 = new x.a(this);
        this.S.addOnPropertyChangedCallback(obj3);
        this.f0 = v25.g();
    }

    public static final q2 A(app.dogo.com.dogo_android.d.b.x x) {
        return x.K;
    }

    public static Void A0(app.dogo.com.dogo_android.d.b.x x, j j2) {
        return x.T0(x, j2);
    }

    public static final o3 B(app.dogo.com.dogo_android.d.b.x x) {
        return x.F;
    }

    public static void B0(app.dogo.com.dogo_android.d.b.x x, c0 c02) {
        x.P(x, c02);
    }

    public static final String C(app.dogo.com.dogo_android.d.b.x x) {
        return x.d0;
    }

    public static Boolean C0(app.dogo.com.dogo_android.d.b.x x, DogProfileModel dogProfileModel2, DogProfile dogProfile3) {
        return x.F(x, dogProfileModel2, dogProfile3);
    }

    public static final a D(app.dogo.com.dogo_android.d.b.x x) {
        return x.M;
    }

    public static g0 D0(app.dogo.com.dogo_android.d.b.x x, Boolean boolean2) {
        return x.J0(x, boolean2);
    }

    private final a0<Boolean> E() {
        a0 just;
        String str;
        app.dogo.com.dogo_android.d.b.s sVar;
        int i;
        DogProfileModel dogProfileModel = V();
        if (dogProfileModel == null) {
            i = 0;
            sVar = new s(this, dogProfileModel);
            n.e(p1.d(this.z, i, 1, i).map(sVar), "{\n            userRepository.addNewDog().map {\n                currentDog = dog\n                true\n            }\n        }");
        } else {
            this.c0 = dogProfileModel;
            n.e(a0.just(Boolean.TRUE), "{\n            currentDog = dog\n            Single.just(true)\n        }");
        }
        return just;
    }

    public static w E0(app.dogo.com.dogo_android.d.b.x x, c0 c02, j j3) {
        return x.Q(x, c02, j3);
    }

    private static final Boolean F(app.dogo.com.dogo_android.d.b.x x, DogProfileModel dogProfileModel2, DogProfile dogProfile3) {
        n.f(x, "this$0");
        n.f(dogProfile3, "it");
        x.c0 = dogProfileModel2;
        return Boolean.TRUE;
    }

    private static final boolean H(app.dogo.com.dogo_android.d.b.x x, List list2, int i3) {
        n.f(x, "this$0");
        n.f(list2, "commentList");
        x.e0().setValue(list2);
        Bundle obj3 = new Bundle();
        obj3.putString("id", x.Z);
        obj3.putInt("data", i3);
        x.j(h.MESSAGE_ACTION_COMMENT_COUNT_CHANGE, obj3);
        return 0;
    }

    private static final w H0(app.dogo.com.dogo_android.d.b.x x, Boolean boolean2) {
        n.f(x, "this$0");
        n.f(boolean2, "it");
        y.c cVar = new y.c(boolean2);
        x.O = cVar;
        return w.a;
    }

    private static final g0 I0(app.dogo.com.dogo_android.d.b.x x, w w2) {
        n.f(x, "this$0");
        n.f(w2, "it");
        return x.R();
    }

    private static final g0 J0(app.dogo.com.dogo_android.d.b.x x, Boolean boolean2) {
        a0 obj1;
        String obj2;
        n.f(x, "this$0");
        n.f(boolean2, "it");
        if (x.o0()) {
            obj1 = x.a0();
            n.d(obj1);
            n.e(a0.just(obj1), "just(entryModel!!)");
        } else {
            obj1 = x.O();
        }
        return obj1;
    }

    private static final void L0(app.dogo.com.dogo_android.d.b.x x, QuerySnapshot querySnapshot2) {
        String size;
        boolean z;
        a aVar;
        ChallengeComment tRUE;
        boolean published;
        String author;
        String documentId;
        String challengeId;
        boolean obj8;
        n.f(x, "this$0");
        if (querySnapshot2) {
            ArrayList arrayList = new ArrayList();
            Iterator iterator = querySnapshot2.getDocuments().iterator();
            while (iterator.hasNext()) {
                Object next = iterator.next();
                n.e((DocumentSnapshot)next, "document");
                ChallengeEntryModel challengeEntryModel = x.a0();
                n.d(challengeEntryModel);
                ChallengeEntryModel challengeEntryModel2 = x.a0();
                n.d(challengeEntryModel2);
                ChallengeEntryModel challengeEntryModel3 = x.a0();
                n.d(challengeEntryModel3);
                tRUE = x.B.h0(next, challengeEntryModel.getAuthor(), challengeEntryModel2.getDocumentId(), challengeEntryModel3.getChallengeId());
                if (!tRUE.isPublished()) {
                } else {
                }
                if (!x.B.P(tRUE, x.C.v(), x.C.C())) {
                }
                Map map = x.Y;
                Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
                tRUE.setHasUserLiked(map.containsKey(tRUE.getDocumentId()));
                arrayList.add(tRUE);
                author = 0;
                Iterator iterator2 = x.X.iterator();
                for (ChallengeComment next2 : iterator2) {
                    author++;
                }
                author = -1;
                if (author >= 0) {
                } else {
                }
                x.X.add(tRUE);
                x.X.set(author, tRUE);
                if (n.b((ChallengeComment)iterator2.next().getDocumentId(), tRUE.getDocumentId()) != null) {
                } else {
                }
                author++;
                if (tRUE.isSpam() && !x.B.P(tRUE, x.C.v(), x.C.C())) {
                }
            }
            m2.b bVar = x.P;
            n.d(bVar);
            if (bVar.e() && !x.g0) {
                if (!x.g0) {
                    x.g0 = true;
                    x.Y().setValue(Boolean.TRUE);
                }
            }
            x.U().setValue(arrayList);
            if (arrayList.size() == 0 && !querySnapshot2.isEmpty()) {
                if (!querySnapshot2.isEmpty()) {
                    x.K0();
                }
            }
        }
    }

    private final a0<ChallengeEntryModel> O() {
        r rVar = new r(this);
        a0 create = a0.create(rVar);
        n.e(create, "create { emitter ->\n            firestoreService.fetchChallengeEntry(entryId!!).continueWith { task: Task<ChallengeEntryModel?> ->\n                if (task.isSuccessful) {\n                    entryModel = task.result\n                    isEntryFetched = true\n                    attachUserEntryListener()\n                    entryModel!!.setEntryStateData(stateManager.challengeState.getEntryStateDataFor(entryModel!!.documentId))\n                    emitter.onSuccess(task.result!!)\n                } else {\n                    emitter.onError(task.exception ?: Exception())\n                }\n            }\n        }");
        return create;
    }

    private static final void P(app.dogo.com.dogo_android.d.b.x x, c0 c02) {
        n.f(x, "this$0");
        n.f(c02, "emitter");
        String str3 = x.Z;
        n.d(str3);
        u uVar = new u(x, c02);
        x.B.q(str3).continueWith(uVar);
    }

    private static final w Q(app.dogo.com.dogo_android.d.b.x x, c0 c02, j j3) {
        ChallengeEntryModel successful;
        s2.a aVar;
        Object obj2;
        n.f(x, "this$0");
        n.f(c02, "$emitter");
        n.f(j3, "task");
        if (j3.isSuccessful()) {
            x.a0 = (ChallengeEntryModel)j3.getResult();
            x.h0 = true;
            x.I();
            successful = x.a0();
            n.d(successful);
            obj2 = x.a0();
            n.d(obj2);
            successful.setEntryStateData(s2Var.a.b(obj2.getDocumentId()));
            obj2 = j3.getResult();
            n.d(obj2);
            c02.onSuccess(obj2);
        } else {
            if (j3.getException() == null) {
                obj2 = new Exception();
            }
            c02.onError(obj2);
        }
        return w.a;
    }

    private final a0<Boolean> R() {
        a0 just;
        String str;
        DogProfileModel dogProfileModel = V();
        if (dogProfileModel == null) {
            n.e(this.z.r().d(E()), "{\n            userRepository.fillCacheFromRoom().andThen(addDogIfNeededAndSetLocalDog())\n        }");
        } else {
            this.c0 = dogProfileModel;
            n.e(a0.just(Boolean.TRUE), "{\n            currentDog = dog\n            Single.just(true)\n        }");
        }
        return just;
    }

    private static final Void R0(app.dogo.com.dogo_android.d.b.x x, j j2) {
        n.f(x, "this$0");
        n.f(j2, "task");
        x.j0 = true;
        x.b0 = (ChallengeModel)j2.getResult();
        return null;
    }

    private static final Void S0(app.dogo.com.dogo_android.d.b.x x, j j2) {
        n.f(x, "this$0");
        n.f(j2, "task");
        Object obj2 = j2.getResult();
        n.d(obj2);
        x.Y.putAll((Map)obj2);
        x.i0 = true;
        return null;
    }

    private static final Void T0(app.dogo.com.dogo_android.d.b.x x, j j2) {
        n.f(x, "this$0");
        n.f(j2, "task");
        String obj1 = x.Z;
        n.d(obj1);
        s2Var.a.c().c(obj1, (Map)j2.getResult());
        return null;
    }

    private final DogProfileModel V() {
        return this.A.A().l(this.A.A().f(), this.C.v());
    }

    private final EventListener<QuerySnapshot> i0() {
        j jVar = new j(this);
        return jVar;
    }

    private static final void j0(app.dogo.com.dogo_android.d.b.x x, QuerySnapshot querySnapshot2, FirebaseFirestoreException firebaseFirestoreException3) {
        int i;
        int i2;
        Iterator obj3;
        String obj4;
        n.f(x, "this$0");
        if (querySnapshot2 != null) {
            obj3 = querySnapshot2.getDocumentChanges().iterator();
            for (DocumentChange obj4 : obj3) {
                i = x.b.a[obj4.getType().ordinal()];
                obj4 = obj4.getDocument().getId();
                x.d0 = obj4;
                obj4 = 0;
            }
        }
    }

    public static void t0(app.dogo.com.dogo_android.d.b.x x, QuerySnapshot querySnapshot2, FirebaseFirestoreException firebaseFirestoreException3) {
        x.j0(x, querySnapshot2, firebaseFirestoreException3);
    }

    public static Void u0(app.dogo.com.dogo_android.d.b.x x, j j2) {
        return x.S0(x, j2);
    }

    public static g0 v0(app.dogo.com.dogo_android.d.b.x x, w w2) {
        return x.I0(x, w2);
    }

    public static final h2 w(app.dogo.com.dogo_android.d.b.x x) {
        return x.C;
    }

    public static Void w0(app.dogo.com.dogo_android.d.b.x x, j j2) {
        return x.R0(x, j2);
    }

    public static final DogProfileModel x(app.dogo.com.dogo_android.d.b.x x) {
        return x.c0;
    }

    public static void x0(app.dogo.com.dogo_android.d.b.x x, QuerySnapshot querySnapshot2) {
        x.L0(x, querySnapshot2);
    }

    public static final m2 y(app.dogo.com.dogo_android.d.b.x x) {
        return x.B;
    }

    public static boolean y0(app.dogo.com.dogo_android.d.b.x x, List list2, int i3) {
        return x.H(x, list2, i3);
    }

    public static final p2 z(app.dogo.com.dogo_android.d.b.x x) {
        return x.H;
    }

    public static w z0(app.dogo.com.dogo_android.d.b.x x, Boolean boolean2) {
        return x.H0(x, boolean2);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void F0() {
        this.c0 = V();
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void G(long l) {
        boolean z;
        m2 m2Var;
        String str;
        String documentId;
        boolean z2;
        String author;
        String challengeId;
        long l2;
        app.dogo.com.dogo_android.d.b.o oVar;
        ListenerRegistration obj11;
        if (this.i0 && this.h0) {
            if (this.h0) {
                if (this.Q != null) {
                } else {
                    oVar = new o(this);
                    ChallengeEntryModel challengeEntryModel = this.a0;
                    n.d(challengeEntryModel);
                    ChallengeEntryModel challengeEntryModel2 = this.a0;
                    n.d(challengeEntryModel2);
                    z = this.a0;
                    n.d(z);
                    this.Q = this.B.d(this.C.v(), challengeEntryModel.getDocumentId(), this.C.C(), challengeEntryModel2.getAuthor(), z.getChallengeId(), l, obj8);
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void G0() {
        Object disposable;
        Object aVar;
        Object unknownHostException;
        app.dogo.com.dogo_android.d.b.x.f fVar;
        this.M.postValue(y.b.a);
        if (!this.L.a()) {
            this.F.s("challenges_entry_comments");
            unknownHostException = new UnknownHostException();
            aVar = new y.a(unknownHostException);
            this.M.postValue(aVar);
        } else {
            p pVar = new p(this);
            l lVar = new l(this);
            t tVar = new t(this);
            a0 subscribeOn = this.E.q().map(pVar).flatMap(lVar).flatMap(tVar).observeOn(a.b()).subscribeOn(a.b());
            n.e(subscribeOn, "subscribeInteractor.revenueCatSubscribed()\n                    .map { premiumState = LoadResult.Success(it) }\n                    .flatMap {\n                        fillCacheIfNeededAndSetLocalDog()\n                    }\n                    .flatMap { if (isEntryFetched) Single.just(entryModel!!) else fetchEntryData() }\n                    .observeOn(Schedulers.io())\n                    .subscribeOn(Schedulers.io())");
            unknownHostException = new x.e(this);
            fVar = new x.f(this);
            getDisposable().b(a.g(subscribeOn, unknownHostException, fVar));
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void I() {
        Object challengeEntryModel;
        String str;
        String challengeId;
        EventListener list;
        if (this.a0 != null) {
            if (this.R != null) {
            } else {
                ChallengeEntryModel challengeEntryModel2 = this.a0;
                n.d(challengeEntryModel2);
                this.R = this.B.z(this.C.v(), challengeEntryModel2.getChallengeId(), i0());
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean J(ChallengeEntryModel challengeEntryModel, int i2) {
        return this.o0.onDeleteRequest(this.B, this.F, challengeEntryModel, this.C.v(), i2);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void K() {
        ListenerRegistration list;
        list = this.Q;
        if (list != null) {
            n.d(list);
            list.remove();
            this.Q = 0;
            this.f0 = this.D.g();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void K0() {
        boolean nVar;
        m2.b bVar;
        if (this.i0) {
            if (!this.h0) {
            } else {
                nVar = new n(this);
                bVar = this.P;
                n.d(bVar);
                bVar.c(nVar);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void L() {
        ListenerRegistration list;
        list = this.R;
        if (list != null) {
            n.d(list);
            list.remove();
            this.R = 0;
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean M(ChallengeEntryModel challengeEntryModel, String string2) {
        return this.o0.onSimpleLikeClick(System.currentTimeMillis(), obj2, challengeEntryModel);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void M0(ChallengeComment challengeComment, String string2) {
        m2 obj10;
        n.f(challengeComment, "model");
        i1 i1Var = new i1();
        c1 c1Var = new c1();
        r2 r2Var = new r2();
        this.F.d(u.e.c(i1Var, challengeComment.getDocumentId(), c1Var, challengeComment.getChallengeId(), r2Var, y.Companion.a(string2)));
        if (U0(challengeComment)) {
            this.B.h(challengeComment);
        } else {
            this.B.O(challengeComment);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean N(ChallengeEntryModel challengeEntryModel, String string2) {
        return this.o0.onToggleLikeClick(System.currentTimeMillis(), obj2, challengeEntryModel);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void N0(String string, ChallengeComment challengeComment2) {
        int challengeId;
        int tag;
        Object author;
        Object dogProfileModel;
        String str;
        i1 i1Var;
        String str2;
        c1 c1Var;
        int i;
        r2 r2Var;
        int i2;
        ChallengeComment challengeComment;
        Object[] obj11;
        Object obj12;
        n.f(string, "string");
        ChallengeEntryModel challengeEntryModel = this.a0;
        tag = 0;
        if (challengeEntryModel == null) {
            challengeId = tag;
        } else {
            challengeId = challengeEntryModel.getChallengeId();
        }
        author = this.a0;
        if (author == null) {
            i2 = tag;
        } else {
            i2 = author;
        }
        if (challengeId == 0) {
            if (i2 != 0) {
                DogProfileModel dogProfileModel2 = this.c0;
                n.d(dogProfileModel2);
                super(this.C.v(), string, this.Z, dogProfileModel2, challengeId, i2);
                dogProfileModel = this.c0;
                str = "";
                if (dogProfileModel == null) {
                } else {
                    dogProfileModel = dogProfileModel.getId();
                    if (dogProfileModel == null) {
                    } else {
                        str = dogProfileModel;
                    }
                }
                challengeComment.setBadges(this.B.a(str, this.p0));
                if (challengeComment2 != null) {
                    challengeComment.setReplyTarget(challengeComment2);
                }
                this.B.D0(challengeComment);
                obj11 = new ArrayList();
                obj11.add(challengeComment);
                this.U.setValue(obj11);
                i1Var = new i1();
                c1Var = new c1();
                r2Var = new r2();
                q qVar = this.w;
                if (qVar == null) {
                } else {
                    tag = qVar.getTag();
                }
                this.F.d(u.d.c(i1Var, this.Z, c1Var, challengeId, r2Var, y.Companion.a(tag)));
                obj11 = new Bundle();
                obj11.putString("id", this.Z);
                j(h.MESSAGE_ACTION_NEW_COMMENT_POSTED, obj11);
            } else {
                a.c("onSendClick error, challengeId or author is null", new Object[0]);
            }
        } else {
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean O0(Bundle bundle) {
        boolean z;
        int i;
        String challengeId;
        Object str2;
        i1 i1Var;
        String str;
        c1 c1Var;
        Object obj8;
        final int i2 = 1;
        if (!this.k0 && this.h0) {
            if (this.h0) {
                return i2;
            }
        }
        i = 0;
        if (bundle == null) {
            return i;
        }
        this.k0 = i;
        this.Z = bundle.getString("entryId");
        this.l0 = bundle.getString("commentId");
        this.a0 = (ChallengeEntryModel)bundle.getParcelable("entryModel");
        challengeId = bundle.getString("challengeId");
        if (this.Z != null && challengeId != null && bundle.getString("linkType") != null) {
            if (challengeId != null) {
                if (bundle.getString("linkType") != null) {
                    i1Var = new i1();
                    c1Var = new c1();
                    this.F.d(t.c.c(i1Var, this.Z, c1Var, challengeId));
                }
            }
        }
        if (this.Z == null && this.a0 == null) {
            if (this.a0 == null) {
                return i;
            }
        }
        obj8 = this.a0;
        if (obj8 != null) {
            n.d(obj8);
            ChallengeEntryModel challengeEntryModel = this.a0;
            n.d(challengeEntryModel);
            obj8.setEntryStateData(s2Var.a.b(challengeEntryModel.getDocumentId()));
            obj8 = this.a0;
            n.d(obj8);
            this.Z = obj8.getDocumentId();
            obj8 = this.a0;
            n.d(obj8);
            challengeId = obj8.getChallengeId();
            this.h0 = i2;
        }
        obj8 = this.I.a(challengeId);
        this.b0 = obj8;
        if (obj8 != null) {
            this.j0 = i2;
        }
        return i2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void P0(int i) {
        this.e0 = i;
    }

    public final j<Void> Q0(String string, String string2) {
        boolean str;
        String str2;
        Object obj7;
        n.f(string, "challengeEntryId");
        n.f(string2, "challengeId");
        ArrayList arrayList = new ArrayList();
        k kVar = new k(this);
        j continueWith = this.B.u(string, this.C.v()).continueWith(kVar);
        n.e(continueWith, "firestoreService.fetchLikeListForEntriesComments(challengeEntryId, authService.currentUserId).continueWith<Void?> { task: Task<Map<String, Any>> ->\n            likeList.putAll(task.result!!)\n            isLikesFetched = true\n            null\n        }");
        arrayList.add(continueWith);
        final int i = 0;
        q qVar = new q(this);
        j continueWith2 = this.B.D(this.C.v(), this.Z, i).continueWith(qVar);
        n.e(continueWith2, "firestoreService.fetchUserLikeListForEntry(authService.currentUserId, entryId, false).continueWith<Void?> { task: Task<Map<String, Boolean>> ->\n            stateManager.challengeState.entryStateDataHolder.updateEntryStateData(entryId!!, task.result)\n            null\n        }");
        arrayList.add(continueWith2);
        if (!this.j0) {
            m mVar = new m(this);
            obj7 = this.B.s(string2, this.H.W()).continueWith(mVar);
            n.e(obj7, "firestoreService.fetchChallengeModel(challengeId, preferenceService.selectedLocale).continueWith<Void?> { task: Task<ChallengeModel?> ->\n                challengeFetched = true\n                challengeModel = task.result\n                null\n            }");
            arrayList.add(obj7);
        }
        obj7 = this.l0 != null ? 1000 : 40;
        this.P = this.B.b(string, obj7, i);
        j obj6 = m.f(arrayList);
        n.e(obj6, "whenAll(taskList)");
        return obj6;
    }

    public final List<ChallengeComment> S() {
        Object next;
        int i;
        m2 m2Var;
        String str;
        boolean z;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.X.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (z2 ^= 1 != 0) {
            }
            arrayList.add(next);
        }
        x.d dVar = new x.d();
        return p.D0(arrayList, dVar);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final ChallengeModel T() {
        return this.b0;
    }

    public final a<List<ChallengeComment>> U() {
        return this.T;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean U0(ChallengeComment challengeComment) {
        String z;
        int i;
        boolean obj4;
        n.f(challengeComment, "model");
        final int i2 = 1;
        if (n.b(challengeComment.getUserId(), this.C.v())) {
            z = this.C.v().length() > 0 ? i2 : i;
            if (z == 0) {
                if (challengeComment.isEntryAuthor(this.C.v())) {
                    i = i2;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void V0() {
        boolean z;
        final String str = this.l0;
        if (str != null && !this.m0) {
            if (!this.m0) {
                this.m0 = true;
                this.n0.postValue(str);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final int W() {
        return this.A.A().j();
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void W0(String string) {
        DogProfileModel obj2;
        if (z ^= 1 != 0 && string != null) {
            if (string != null) {
                this.c0 = V();
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final String X() {
        return this.A.A().n();
    }

    public final x<Boolean> Y() {
        return this.V;
    }

    public final LiveData<y<ChallengeEntryModel>> Z() {
        return this.N;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final ChallengeEntryModel a0() {
        return this.a0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final int b0() {
        return this.e0;
    }

    public final x<Boolean> c0() {
        return this.W;
    }

    public final List<String> d0() {
        List list;
        String str = this.l0;
        if (str != null) {
            n.d(str);
            list = p.b(str);
        } else {
            list = p.g();
        }
        return list;
    }

    public final a<List<ChallengeComment>> e0() {
        return this.U;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final long f0() {
        return this.f0;
    }

    public final a<String> g0() {
        return this.n0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final Uri h0() {
        Object str;
        String i;
        t2 t2Var;
        str = this.c0;
        i = 0;
        if (str != null) {
            if (str == null) {
            } else {
                i = str.getId();
            }
            n.d(i);
            i = this.G.h(i, "avatar.jpg");
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean isUserSignedIn() {
        return this.C.D();
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean k0() {
        return this.C.C();
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean l0(ChallengeComment challengeComment) {
        n.f(challengeComment, "model");
        return challengeComment.isCommentAuthor(this.C.v());
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean m0() {
        String length;
        int i;
        DogProfileModel dogProfileModel = this.c0;
        if (dogProfileModel == null) {
            length = 0;
        } else {
            length = dogProfileModel.getName();
        }
        if (length != null) {
            if (length.length() == 0) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean n0(ChallengeComment challengeComment) {
        n.f(challengeComment, "model");
        return challengeComment.isEntryAuthor(this.C.v());
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean o0() {
        return this.h0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean p0() {
        boolean z;
        m2 m2Var;
        String str;
        boolean z2;
        ChallengeEntryModel challengeEntryModel = this.a0;
        if (challengeEntryModel != null) {
            z = this.B.R(challengeEntryModel, this.C.v(), this.C.C());
        } else {
            z = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean q0(ChallengeEntryModel challengeEntryModel) {
        n.f(challengeEntryModel, "model");
        return n.b(this.C.v(), challengeEntryModel.getAuthor());
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean r0() {
        return this.i0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean s0() {
        y booleanValue;
        int i;
        booleanValue = this.O;
        if (booleanValue instanceof y.c && (Boolean)(y.c)booleanValue.a().booleanValue()) {
            i = (Boolean)(y.c)booleanValue.a().booleanValue() ? 1 : 0;
        } else {
        }
        return i;
    }
}
