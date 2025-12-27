package app.dogo.com.dogo_android.d.b;

import android.net.Uri;
import android.os.Bundle;
import androidx.databinding.h.a;
import androidx.databinding.i;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
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
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.f;
import app.dogo.com.dogo_android.v.c;
import app.dogo.com.dogo_android.w.c1;
import app.dogo.com.dogo_android.w.i1;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.w.t;
import app.dogo.com.dogo_android.w.u;
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
import i.b.a0;
import i.b.b;
import i.b.c0;
import i.b.g0;
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
import kotlin.d0.d.n;
import kotlin.w;

/* compiled from: ChallengeCommentsViewModel.kt */
@Metadata(d1 = "\u0000\u0090\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0012\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010\u001cJ\u000e\u0010y\u001a\u0008\u0012\u0004\u0012\u00020\"0zH\u0002J\u000e\u0010{\u001a\u00020|2\u0006\u0010}\u001a\u00020mJ\u0006\u0010~\u001a\u00020|J\u001a\u0010\u007f\u001a\u00020\"2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010 2\u0007\u0010\u0081\u0001\u001a\u00020AJ\u0007\u0010\u0082\u0001\u001a\u00020|J\u0007\u0010\u0083\u0001\u001a\u00020|J\u001d\u0010\u0084\u0001\u001a\u00020\"2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010 2\t\u0010\u0086\u0001\u001a\u0004\u0018\u000102J\u001d\u0010\u0087\u0001\u001a\u00020\"2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010 2\t\u0010\u0088\u0001\u001a\u0004\u0018\u000102J\u000f\u0010\u0089\u0001\u001a\u0008\u0012\u0004\u0012\u00020 0zH\u0002J\u000f\u0010\u008a\u0001\u001a\u0008\u0012\u0004\u0012\u00020\"0zH\u0002J\r\u0010\u008b\u0001\u001a\u0008\u0012\u0004\u0012\u00020-0,J\u000b\u0010\u008c\u0001\u001a\u0004\u0018\u00010;H\u0002J\u0011\u0010\u008d\u0001\u001a\n\u0012\u0005\u0012\u00030\u008f\u00010\u008e\u0001H\u0002J\u0007\u0010\u0090\u0001\u001a\u00020\"J\u0010\u0010\u0091\u0001\u001a\u00020\"2\u0007\u0010\u0080\u0001\u001a\u00020-J\u0010\u0010\u0092\u0001\u001a\u00020\"2\u0007\u0010\u0080\u0001\u001a\u00020-J\u0007\u0010\u0093\u0001\u001a\u00020\"J\u0010\u0010\u0094\u0001\u001a\u00020\"2\u0007\u0010\u0080\u0001\u001a\u00020 J\u0007\u0010\u0095\u0001\u001a\u00020\"J\u0007\u0010\u0096\u0001\u001a\u00020|J\u0007\u0010\u0097\u0001\u001a\u00020|J\u0007\u0010\u0098\u0001\u001a\u00020|J\u001b\u0010\u0099\u0001\u001a\u00020|2\u0007\u0010\u0080\u0001\u001a\u00020-2\t\u0010\u009a\u0001\u001a\u0004\u0018\u000102J\u001b\u0010\u009b\u0001\u001a\u00020|2\u0007\u0010\u009c\u0001\u001a\u0002022\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010-J\u0013\u0010\u009e\u0001\u001a\u00020\"2\n\u0010\u009f\u0001\u001a\u0005\u0018\u00010 \u0001J!\u0010¡\u0001\u001a\n\u0012\u0005\u0012\u00030£\u00010¢\u00012\u0007\u0010¤\u0001\u001a\u0002022\u0007\u0010¥\u0001\u001a\u000202J\u0010\u0010¦\u0001\u001a\u00020\"2\u0007\u0010\u0080\u0001\u001a\u00020-J\u0007\u0010§\u0001\u001a\u00020|J\u0012\u0010¨\u0001\u001a\u00020|2\t\u0010©\u0001\u001a\u0004\u0018\u000102R\u001a\u0010\u001d\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020 0\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010(\u001a\u0004\u0018\u00010'2\u0008\u0010&\u001a\u0004\u0018\u00010'@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010*R\u001d\u0010+\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020-0,0\u001e¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010/R(\u00100\u001a\u0010\u0012\u000c\u0012\n 3*\u0004\u0018\u0001020201X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00084\u00105\"\u0004\u00086\u00107R\u0014\u00108\u001a\u0008\u0018\u000109R\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010<\u001a\u0002028F¢\u0006\u0006\u001a\u0004\u0008=\u0010>R\u0010\u0010?\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010@\u001a\u00020A8F¢\u0006\u0006\u001a\u0004\u0008B\u0010CR\u0013\u0010D\u001a\u0004\u0018\u0001028F¢\u0006\u0006\u001a\u0004\u0008E\u0010>R\u0017\u0010F\u001a\u0008\u0012\u0004\u0012\u00020\"0G¢\u0006\u0008\n\u0000\u001a\u0004\u0008H\u0010IR\u001d\u0010J\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020 0\u001f0K¢\u0006\u0008\n\u0000\u001a\u0004\u0008L\u0010MR\u0010\u0010N\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010O\u001a\u0004\u0018\u00010 2\u0008\u0010&\u001a\u0004\u0018\u00010 @BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008P\u0010QR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010T\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\u0008T\u0010UR\u001e\u0010V\u001a\u00020\"2\u0006\u0010&\u001a\u00020\"@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008V\u0010UR\u001e\u0010W\u001a\u00020\"2\u0006\u0010&\u001a\u00020\"@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008W\u0010UR\u0011\u0010X\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\u0008X\u0010UR\u001a\u0010Y\u001a\u00020AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008Z\u0010C\"\u0004\u0008[\u0010\\R\u001c\u0010]\u001a\u0010\u0012\u0004\u0012\u000202\u0012\u0006\u0012\u0004\u0018\u00010_0^X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010a\u001a\u0008\u0012\u0004\u0012\u00020\"0G¢\u0006\u0008\n\u0000\u001a\u0004\u0008b\u0010IR\u0017\u0010c\u001a\u0008\u0012\u0004\u0012\u0002020,8F¢\u0006\u0006\u001a\u0004\u0008d\u0010eR\u001d\u0010f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020-0,0\u001e¢\u0006\u0008\n\u0000\u001a\u0004\u0008g\u0010/R\u0010\u0010h\u001a\u0004\u0018\u00010iX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010j\u001a\u0008\u0012\u0004\u0012\u00020\"0\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010k\u001a\u0008\u0012\u0004\u0012\u00020-0lX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010n\u001a\u00020m2\u0006\u0010&\u001a\u00020m@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008o\u0010pR\u0017\u0010q\u001a\u0008\u0012\u0004\u0012\u0002020\u001e¢\u0006\u0008\n\u0000\u001a\u0004\u0008r\u0010/R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010s\u001a\u0004\u0018\u00010t8G¢\u0006\u0006\u001a\u0004\u0008u\u0010vR\u0010\u0010w\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010x\u001a\u0004\u0018\u00010iX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006ª\u0001", d2 = {"Lapp/dogo/com/dogo_android/challenge/comments/ChallengeCommentsViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "userLocalCacheService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "storageService", "Lapp/dogo/com/dogo_android/service/StorageService;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "challengeLocalRepository", "Lapp/dogo/com/dogo_android/repository/local/ChallengeLocalRepository;", "stateManager", "Lapp/dogo/com/dogo_android/service/StateManager;", "rateItService", "Lapp/dogo/com/dogo_android/service/RateItService;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/UserLocalCacheService;Lapp/dogo/com/dogo_android/service/FirestoreService;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/StorageService;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/repository/local/ChallengeLocalRepository;Lapp/dogo/com/dogo_android/service/StateManager;Lapp/dogo/com/dogo_android/service/RateItService;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "_entryDataResults", "Lcom/hadilq/liveevent/LiveEvent;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "alreadyScrollToDeeplink", "", "baseEntryLayoutHelper", "Lapp/dogo/com/dogo_android/util/BaseEntryLayoutHelper;", "challengeFetched", "<set-?>", "Lapp/dogo/com/dogo_android/model/ChallengeModel;", "challengeModel", "getChallengeModel", "()Lapp/dogo/com/dogo_android/model/ChallengeModel;", "commentFetcher", "", "Lapp/dogo/com/dogo_android/model/ChallengeComment;", "getCommentFetcher", "()Lcom/hadilq/liveevent/LiveEvent;", "commentField", "Landroidx/databinding/ObservableField;", "", "kotlin.jvm.PlatformType", "getCommentField", "()Landroidx/databinding/ObservableField;", "setCommentField", "(Landroidx/databinding/ObservableField;)V", "commentPager", "Lapp/dogo/com/dogo_android/service/FirestoreService$FirestorePager;", "currentDog", "Lapp/dogo/com/dogo_android/model/DogProfileModel;", "currentDogId", "getCurrentDogId", "()Ljava/lang/String;", "deeplinkCommentId", "dogCount", "", "getDogCount", "()I", "emptyDogId", "getEmptyDogId", "endOfListNotifier", "Landroidx/lifecycle/MutableLiveData;", "getEndOfListNotifier", "()Landroidx/lifecycle/MutableLiveData;", "entryDataResults", "Landroidx/lifecycle/LiveData;", "getEntryDataResults", "()Landroidx/lifecycle/LiveData;", "entryId", "entryModel", "getEntryModel", "()Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "firstLaunch", "hasPremiumBadge", "isCurrentDogEmpty", "()Z", "isEntryFetched", "isLikesFetched", "isUserSignedIn", "lastSavedPosition", "getLastSavedPosition", "setLastSavedPosition", "(I)V", "likeList", "", "", "listEndReached", "listUpdateNotifier", "getListUpdateNotifier", "markedCommentIds", "getMarkedCommentIds", "()Ljava/util/List;", "newCommentFetcher", "getNewCommentFetcher", "newCommentListener", "Lcom/google/firebase/firestore/ListenerRegistration;", "premiumState", "savedList", "", "", "savedTimestamp", "getSavedTimestamp", "()J", "scrollToComment", "getScrollToComment", "userDogAvatarUri", "Landroid/net/Uri;", "getUserDogAvatarUri", "()Landroid/net/Uri;", "userEntryId", "userEntryListener", "addDogIfNeededAndSetLocalDog", "Lio/reactivex/Single;", "attachNewCommentListener", "", "startPointTimeStamp", "attachUserEntryListener", "deleteEntry", "model", "photoPosition", "detachNewCommentListener", "detachUserEntryListener", "detectDoubleClick", "mod", "id", "detectSimpleClick", "photoId", "fetchEntryData", "fillCacheIfNeededAndSetLocalDog", "getCachedList", "getCurrentDogOrNull", "getUserEntryListener", "Lcom/google/firebase/firestore/EventListener;", "Lcom/google/firebase/firestore/QuerySnapshot;", "isAdmin", "isCommentAuthor", "isEntryAuthor", "isEntryReported", "isEntryUsers", "isPremium", "loadCurrentDog", "loadEntryData", "loadMoreComments", "onCommentDelete", "parentTag", "onSendClick", "string", "replyTarget", "setArguments", "arguments", "Landroid/os/Bundle;", "setupCommentListData", "Lcom/google/android/gms/tasks/Task;", "Ljava/lang/Void;", "challengeEntryId", "challengeId", "shouldRemoveMessage", "tryToScrollToDeeplink", "updateCurrentDogSelection", "dogId", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: x, reason: from kotlin metadata */
public final class ChallengeCommentsViewModel extends r {

    /* renamed from: A, reason: from kotlin metadata */
    private final u2 alreadyScrollToDeeplink;
    /* renamed from: B, reason: from kotlin metadata */
    private final m2 authService;
    /* renamed from: C, reason: from kotlin metadata */
    private final h2 baseEntryLayoutHelper;
    /* renamed from: D, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.service.v2 challengeFetched;
    /* renamed from: E, reason: from kotlin metadata */
    private final n3 challengeLocalRepository;
    private final o3 F;
    private final t2 G;
    private final p2 H;
    /* renamed from: I, reason: from kotlin metadata */
    private final a1 commentPager;
    /* renamed from: J, reason: from kotlin metadata */
    private final s2 connectivityService;
    /* renamed from: K, reason: from kotlin metadata */
    private final q2 currentDog;
    private final j2 L;
    /* renamed from: M, reason: from kotlin metadata */
    private final f.d.a.a<y<ChallengeEntryModel>> deeplinkCommentId = new a<>();
    private final LiveData<y<ChallengeEntryModel>> N = new a<>();
    private y<Boolean> O;
    private m2.b P;
    private ListenerRegistration Q;
    /* renamed from: R, reason: from kotlin metadata */
    private ListenerRegistration entryId;
    private i<String> S = new i<>("");
    /* renamed from: T, reason: from kotlin metadata */
    private final f.d.a.a<List<ChallengeComment>> firestoreService = new a<>();
    /* renamed from: U, reason: from kotlin metadata */
    private final f.d.a.a<List<ChallengeComment>> firstLaunch = new a<>();
    /* renamed from: V, reason: from kotlin metadata */
    private final x<Boolean> hasPremiumBadge = new x<>();
    private final x<Boolean> W = new x<>();
    private final List<ChallengeComment> X = new ArrayList<>();
    private final Map<String, Object> Y = new HashMap<>();
    private String Z;
    private ChallengeEntryModel a0;
    /* renamed from: b0, reason: from kotlin metadata */
    private ChallengeModel likeList;
    /* renamed from: c0, reason: from kotlin metadata */
    private DogProfileModel listEndReached;
    private String d0;
    private int e0;
    private long f0;
    /* renamed from: g0, reason: from kotlin metadata */
    private boolean newCommentListener;
    /* renamed from: h0, reason: from kotlin metadata */
    private boolean preferenceService;
    /* renamed from: i0, reason: from kotlin metadata */
    private boolean premiumState;
    /* renamed from: j0, reason: from kotlin metadata */
    private boolean rateItService;
    /* renamed from: k0, reason: from kotlin metadata */
    private boolean savedList = true;
    private String l0;
    private boolean m0;
    /* renamed from: n0, reason: from kotlin metadata */
    private final f.d.a.a<String> stateManager = new a<>();
    /* renamed from: o0, reason: from kotlin metadata */
    private final f storageService = new x$c();
    /* renamed from: p0, reason: from kotlin metadata */
    private boolean subscribeInteractor;
    /* renamed from: z, reason: from kotlin metadata */
    private final p1 tracker;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class b {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[DocumentChange.Type.values().length];
            iArr[DocumentChange.Type.ADDED.ordinal()] = 1;
            iArr[DocumentChange.Type.MODIFIED.ordinal()] = 2;
            iArr[DocumentChange.Type.REMOVED.ordinal()] = 3;
            app.dogo.com.dogo_android.challenge.comments.x.b.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 5, 1})
    public static final class d<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            long seconds = 9223372036854775807L;
            Timestamp date2 = t2.getDate();
            seconds = Long.MAX_VALUE;
            if (date2 == null) {
            } else {
                seconds = date2.getSeconds();
            }
            Timestamp date = t.getDate();
            if (date != null) {
                seconds = date.getSeconds();
            }
            return a.c(Long.valueOf(seconds), Long.valueOf(seconds));
        }
    }

    @Metadata(d1 = "\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0008", d2 = {"app/dogo/com/dogo_android/challenge/comments/ChallengeCommentsViewModel$1", "Landroidx/databinding/Observable$OnPropertyChangedCallback;", "onPropertyChanged", "", "observable", "Landroidx/databinding/Observable;", "i", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends h.a {

        final /* synthetic */ x a;
        a() {
            this.a = xVar;
            super();
        }

        @Override // androidx.databinding.h$a
        /* renamed from: d, reason: from kotlin metadata */
        public void onPropertyChanged(androidx.databinding.h observable, int i) {
            n.f(observable, "observable");
            this.a.notifyChange(42);
        }
    }

    @Metadata(d1 = "\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\u0008\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t", d2 = {"app/dogo/com/dogo_android/challenge/comments/ChallengeCommentsViewModel$baseEntryLayoutHelper$1", "Lapp/dogo/com/dogo_android/util/BaseEntryLayoutHelper;", "onEntryUnvote", "", "entryModel", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "photoId", "", "onEntryUpvote", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends f {

        final /* synthetic */ x a;
        c() {
            this.a = xVar;
            super();
        }

        @Override // app.dogo.com.dogo_android.util.f
        public void onEntryUnvote(ChallengeEntryModel entryModel, String photoId) {
            n.f(entryModel, "entryModel");
            n.f(photoId, "photoId");
            this.unVoteLogic(this.a.authService, this.a.F, this.a.baseEntryLayoutHelper.v(), entryModel, photoId);
            this.a.c0().setValue(Boolean.TRUE);
        }

        @Override // app.dogo.com.dogo_android.util.f
        public void onEntryUpvote(ChallengeEntryModel entryModel, String photoId) {
            String str = null;
            n.f(photoId, "photoId");
            DogProfileModel removeMessage = this.a.listEndReached;
            if (removeMessage == null) {
                int i = 0;
            } else {
                str = removeMessage.getId();
            }
            if (str == null || entryModel == null) {
                StringBuilder stringBuilder = new StringBuilder();
                String str7 = "onEntryUpvote error, current dog id is ";
                str2 = ", entryModel is ";
                str5 = str7 + str + str2 + entryModel;
                a.c(str5, new Object[0]);
            } else {
                this.upvoteLogic(this.a.authService, this.a.currentDog, this.a.F, entryModel, this.a.baseEntryLayoutHelper.v(), this.a.d0, str, this.a.H.h(), photoId);
                this.a.c0().setValue(Boolean.TRUE);
            }
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends kotlin.d0.d.p implements kotlin.d0.c.l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            x.this.deeplinkCommentId.postValue(new LoadResult_Error(th));
        }

        e() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends kotlin.d0.d.p implements kotlin.d0.c.l<ChallengeEntryModel, w> {
        @Override // kotlin.d0.d.p
        public final void a(ChallengeEntryModel challengeEntryModel) {
            x.this.deeplinkCommentId.postValue(new LoadResult_Success(challengeEntryModel));
        }

        f() {
            super(1);
        }
    }
    public x(p1 p1Var, u2 u2Var, m2 m2Var, h2 h2Var, app.dogo.com.dogo_android.service.v2 v2Var, n3 n3Var, o3 o3Var, t2 t2Var, p2 p2Var, a1 a1Var, s2 s2Var, q2 q2Var, j2 j2Var) {
        n.f(p1Var, "userRepository");
        n.f(u2Var, "userLocalCacheService");
        n.f(m2Var, "firestoreService");
        n.f(h2Var, "authService");
        n.f(v2Var, "utilities");
        n.f(n3Var, "subscribeInteractor");
        n.f(o3Var, "tracker");
        n.f(t2Var, "storageService");
        n.f(p2Var, "preferenceService");
        n.f(a1Var, "challengeLocalRepository");
        n.f(s2Var, "stateManager");
        n.f(q2Var, "rateItService");
        n.f(j2Var, "connectivityService");
        super();
        this.tracker = p1Var;
        this.alreadyScrollToDeeplink = u2Var;
        this.authService = m2Var;
        this.baseEntryLayoutHelper = h2Var;
        this.challengeFetched = v2Var;
        this.challengeLocalRepository = n3Var;
        this.F = o3Var;
        this.G = t2Var;
        this.H = p2Var;
        this.commentPager = a1Var;
        this.connectivityService = s2Var;
        this.currentDog = q2Var;
        this.L = j2Var;
        f.d.a.a aVar = new a();
        this.O = LoadResult_Loading.a;
        i iVar = new i("");
        f.d.a.a aVar2 = new a();
        f.d.a.a aVar3 = new a();
        x xVar = new x();
        x xVar2 = new x();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        f.d.a.a aVar4 = new a();
        app.dogo.com.dogo_android.d.b.x.c challengeCommentsViewModel_baseEntryLayoutHelper_1 = new ChallengeCommentsViewModel_baseEntryLayoutHelper_1(this);
        this.listEndReached = V();
        this.S.addOnPropertyChangedCallback(new ChallengeCommentsViewModel_1(this));
        this.f0 = v2Var.g();
    }

    /* renamed from: A, reason: from kotlin metadata */
    public static final /* synthetic */ q2 attachNewCommentListener(x startPointTimeStamp) {
        return startPointTimeStamp.currentDog;
    }

    /* renamed from: B, reason: from kotlin metadata */
    public static final /* synthetic */ o3 isCommentAuthor(x model) {
        return model.F;
    }

    /* renamed from: C, reason: from kotlin metadata */
    public static final /* synthetic */ String isEntryAuthor(x model) {
        return model.d0;
    }

    /* renamed from: D, reason: from kotlin metadata */
    public static final /* synthetic */ f.d.a.a isEntryUsers(x model) {
        return model.deeplinkCommentId;
    }

    /* renamed from: E, reason: from kotlin metadata */
    private final a0<Boolean> addDogIfNeededAndSetLocalDog() {
        a0 just;
        DogProfileModel dogProfileModel = V();
        if (dogProfileModel == null) {
            String str2 = null;
            str = "{\n            userRepository.addNewDog().map {\n                currentDog = dog\n                true\n            }\n        }";
            n.e(UserRepository.d(this.tracker, str2, 1, str2).map(new app.dogo.com.dogo_android.challenge.comments.s(this, dogProfileModel)), str);
        } else {
            this.listEndReached = dogProfileModel;
            str = "{\n            currentDog = dog\n            Single.just(true)\n        }";
            n.e(a0.just(Boolean.TRUE), str);
        }
        return just;
    }

    private static final Boolean F(x xVar, DogProfileModel dogProfileModel, DogProfile dogProfile) {
        n.f(xVar, "this$0");
        n.f(dogProfile, "it");
        xVar.listEndReached = dogProfileModel;
        return Boolean.TRUE;
    }

    private static final boolean H(x xVar, List list, int i) {
        n.f(xVar, "this$0");
        n.f(list, "commentList");
        xVar.e0().setValue(list);
        final Bundle bundle = new Bundle();
        bundle.putString("id", xVar.Z);
        bundle.putInt("data", i);
        xVar.emitMessage(FragmentMessageAction.MESSAGE_ACTION_COMMENT_COUNT_CHANGE, bundle);
        return false;
    }

    /* renamed from: H0, reason: from kotlin metadata */
    private static final w onCommentDelete(x model, Boolean parentTag) {
        n.f(model, "this$0");
        n.f(parentTag, "it");
        model.O = new LoadResult_Success(parentTag);
        return w.a;
    }

    /* renamed from: I0, reason: from kotlin metadata */
    private static final g0 onSendClick(x string, w replyTarget) {
        n.f(string, "this$0");
        n.f(replyTarget, "it");
        return string.R();
    }

    /* renamed from: J0, reason: from kotlin metadata */
    private static final g0 setupCommentListData(x challengeEntryId, Boolean challengeId) {
        a0 just;
        n.f(challengeEntryId, "this$0");
        n.f(challengeId, "it");
        if (challengeEntryId.o0()) {
            ChallengeEntryModel challengeEntryModel = challengeEntryId.a0();
            n.d(challengeEntryModel);
            str = "just(entryModel!!)";
            n.e(a0.just(challengeEntryModel), str);
        } else {
            just = challengeEntryId.O();
        }
        return just;
    }

    private static final void L0(x xVar, QuerySnapshot querySnapshot) {
        boolean hasNext;
        boolean userEntriesQuery;
        String author;
        int i = 0;
        String documentId;
        String challengeId;
        str = "this$0";
        n.f(xVar, str);
        if (querySnapshot != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = querySnapshot.getDocuments().iterator();
            while (it.hasNext()) {
                Object item = it.next();
                n.e(item, "document");
                ChallengeEntryModel challengeEntryModel = xVar.a0();
                n.d(challengeEntryModel);
                ChallengeEntryModel challengeEntryModel2 = xVar.a0();
                n.d(challengeEntryModel2);
                ChallengeEntryModel challengeEntryModel3 = xVar.a0();
                n.d(challengeEntryModel3);
                ChallengeComment reportComment = xVar.authService.reportComment(item, challengeEntryModel.getAuthor(), challengeEntryModel2.getDocumentId(), challengeEntryModel3.getChallengeId());
            }
            n.d(xVar.P);
            if (xVar.P.hasReachedEnd() && xVar.newCommentListener == null) {
                xVar.newCommentListener = true;
                xVar.Y().setValue(Boolean.TRUE);
            }
            xVar.U().setValue(arrayList);
            if (arrayList.size() == 0 && !querySnapshot.isEmpty()) {
                xVar.K0();
            }
        }
    }

    private final a0<ChallengeEntryModel> O() {
        a0 a0Var = a0.create(new app.dogo.com.dogo_android.challenge.comments.r(this));
        n.e(a0Var, "create { emitter ->\n            firestoreService.fetchChallengeEntry(entryId!!).continueWith { task: Task<ChallengeEntryModel?> ->\n                if (task.isSuccessful) {\n                    entryModel = task.result\n                    isEntryFetched = true\n                    attachUserEntryListener()\n                    entryModel!!.setEntryStateData(stateManager.challengeState.getEntryStateDataFor(entryModel!!.documentId))\n                    emitter.onSuccess(task.result!!)\n                } else {\n                    emitter.onError(task.exception ?: Exception())\n                }\n            }\n        }");
        return a0Var;
    }

    private static final void P(x xVar, c0 c0Var) {
        n.f(xVar, "this$0");
        n.f(c0Var, "emitter");
        n.d(xVar.Z);
        xVar.authService.q(xVar.Z).continueWith(new app.dogo.com.dogo_android.challenge.comments.u(xVar, c0Var));
    }

    private static final w Q(x xVar, c0 c0Var, j jVar) {
        Exception exception;
        n.f(xVar, "this$0");
        n.f(c0Var, "$emitter");
        n.f(jVar, "task");
        if (jVar.isSuccessful()) {
            xVar.a0 = (ChallengeEntryModel)jVar.getResult();
            xVar.preferenceService = true;
            xVar.I();
            ChallengeEntryModel challengeEntryModel = xVar.a0();
            n.d(challengeEntryModel);
            ChallengeEntryModel challengeEntryModel2 = xVar.a0();
            n.d(challengeEntryModel2);
            challengeEntryModel.setEntryStateData(xVar.connectivityService.a.b(challengeEntryModel2.getDocumentId()));
            Object result = jVar.getResult();
            n.d(result);
            c0Var.onSuccess(result);
        } else {
            if (jVar.getException() == null) {
                exception = new Exception();
            }
            c0Var.onError(exception);
        }
        return w.a;
    }

    private final a0<Boolean> R() {
        a0 just;
        DogProfileModel dogProfileModel = V();
        if (dogProfileModel == null) {
            str = "{\n            userRepository.fillCacheFromRoom().andThen(addDogIfNeededAndSetLocalDog())\n        }";
            n.e(this.tracker.r().d(addDogIfNeededAndSetLocalDog()), str);
        } else {
            this.listEndReached = dogProfileModel;
            str = "{\n            currentDog = dog\n            Single.just(true)\n        }";
            n.e(a0.just(Boolean.TRUE), str);
        }
        return just;
    }

    private static final Void R0(x xVar, j jVar) {
        n.f(xVar, "this$0");
        n.f(jVar, "task");
        xVar.rateItService = true;
        xVar.likeList = (ChallengeModel)jVar.getResult();
        return null;
    }

    private static final Void S0(x xVar, j jVar) {
        n.f(xVar, "this$0");
        n.f(jVar, "task");
        Object result = jVar.getResult();
        n.d(result);
        xVar.Y.putAll(result);
        xVar.premiumState = true;
        return null;
    }

    private static final Void T0(x xVar, j jVar) {
        n.f(xVar, "this$0");
        n.f(jVar, "task");
        n.d(xVar.Z);
        xVar.connectivityService.a.c().setEntryCommentCount(xVar.Z, (Map)jVar.getResult());
        return null;
    }

    private final DogProfileModel V() {
        return this.alreadyScrollToDeeplink.A().getDogProfileModel(this.alreadyScrollToDeeplink.A().f(), this.baseEntryLayoutHelper.v());
    }

    private final EventListener<QuerySnapshot> i0() {
        return new app.dogo.com.dogo_android.challenge.comments.j(this);
    }

    private static final void j0(x xVar, QuerySnapshot querySnapshot, FirebaseFirestoreException exc) throws NoWhenBranchMatchedException {
        int i;
        int i2;
        String str = null;
        str = "this$0";
        n.f(xVar, str);
        if (querySnapshot != null) {
            Iterator it = querySnapshot.getDocumentChanges().iterator();
            while (it.hasNext()) {
                Object item = it.next();
                i = app.dogo.com.dogo_android.challenge.comments.x.b.a[item.getType().ordinal()];
                i2 = 1;
                if (i != 1 && i != 2) {
                    i2 = 2;
                }
            }
        }
    }

    /* renamed from: w, reason: from kotlin metadata */
    public static final /* synthetic */ h2 setArguments(x arguments) {
        return arguments.baseEntryLayoutHelper;
    }

    /* renamed from: x, reason: from kotlin metadata */
    public static final /* synthetic */ DogProfileModel shouldRemoveMessage(x model) {
        return model.listEndReached;
    }

    /* renamed from: y, reason: from kotlin metadata */
    public static final /* synthetic */ m2 updateCurrentDogSelection(x dogId) {
        return dogId.authService;
    }

    public static final /* synthetic */ p2 z(x xVar) {
        return xVar.H;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void F0() {
        this.listEndReached = V();
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void G(long j) {
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void G0() {
        this.deeplinkCommentId.postValue(LoadResult_Loading.a);
        if (!this.L.getActiveNetworkType()) {
            this.F.setTrainingReminderUserProperties("challenges_entry_comments");
            this.deeplinkCommentId.postValue(new LoadResult_Error(new UnknownHostException()));
        } else {
            a0 observable2 = this.challengeLocalRepository.q().map(new app.dogo.com.dogo_android.challenge.comments.p(this)).flatMap(new app.dogo.com.dogo_android.challenge.comments.l(this)).flatMap(new app.dogo.com.dogo_android.challenge.comments.t(this)).observeOn(a.b()).subscribeOn(a.b());
            n.e(observable2, "subscribeInteractor.revenueCatSubscribed()\n                    .map { premiumState = LoadResult.Success(it) }\n                    .flatMap {\n                        fillCacheIfNeededAndSetLocalDog()\n                    }\n                    .flatMap { if (isEntryFetched) Single.just(entryModel!!) else fetchEntryData() }\n                    .observeOn(Schedulers.io())\n                    .subscribeOn(Schedulers.io())");
            getDisposable().b(a.g(observable2, new app.dogo.com.dogo_android.challenge.comments.x.e(this), new app.dogo.com.dogo_android.challenge.comments.x.f(this)));
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void I() {
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean J(ChallengeEntryModel challengeEntryModel, int i) {
        return this.storageService.onDeleteRequest(this.authService, this.F, challengeEntryModel, this.baseEntryLayoutHelper.v(), i);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void K() {
        if (this.Q != null) {
            n.d(this.Q);
            this.Q.remove();
            this.Q = null;
            this.f0 = this.challengeFetched.g();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void K0() {
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void L() {
        if (this.entryId != null) {
            n.d(this.entryId);
            this.entryId.remove();
            ListenerRegistration entryId2 = null;
            this.entryId = entryId2;
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean M(ChallengeEntryModel challengeEntryModel, String str) {
        return this.storageService.onSimpleLikeClick(System.currentTimeMillis(), challengeEntryModel, str);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void M0(ChallengeComment challengeComment, String str) {
        n.f(challengeComment, "model");
        this.F.logEvent(E_Challenges.e.c(new EP_EntryId(), challengeComment.getDocumentId(), new EP_ChallengeId(), challengeComment.getChallengeId(), new EP_ViewSource(), CommentSource.INSTANCE.commentSourceParser(str)));
        if (U0(challengeComment)) {
            this.authService.h(challengeComment);
        } else {
            this.authService.O(challengeComment);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean N(ChallengeEntryModel challengeEntryModel, String str) {
        return this.storageService.onToggleLikeClick(System.currentTimeMillis(), challengeEntryModel, str);
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void N0(String str, ChallengeComment challengeComment) {
        int i;
        String tag = null;
        ChallengeEntryModel challengeEntryModel;
        String str2;
        String author;
        n.f(str, "string");
        i = 0;
        if (this.a0 == null) {
        } else {
            String challengeId = this.a0.getChallengeId();
        }
        i = this.a0 == null ? i : author;
        if (this.a0 != 0 || author != null) {
            n.d(this.listEndReached);
            challengeComment = new ChallengeComment(this.baseEntryLayoutHelper.v(), str, this.Z, listEndReached22, i, author);
            str2 = "";
            if (this.listEndReached != null) {
                str2 = this.listEndReached.getId();
                if (str2 != null) {
                }
            }
            challengeComment.setBadges(this.authService.unvoteEntryComment(str2, this.subscribeInteractor));
            if (challengeComment != null) {
                challengeComment.setReplyTarget(challengeComment);
            }
            this.authService.D0(challengeComment);
            ArrayList arrayList = new ArrayList();
            arrayList.add(challengeComment);
            this.firstLaunch.setValue(arrayList);
            if (this.registry != null) {
                tag = this.registry.getTag();
            }
            this.F.logEvent(E_Challenges.d.c(new EP_EntryId(), this.Z, new EP_ChallengeId(), i, new EP_ViewSource(), CommentSource.INSTANCE.commentSourceParser(tag)));
            Bundle bundle = new Bundle();
            bundle.putString("id", this.Z);
            emitMessage(FragmentMessageAction.MESSAGE_ACTION_NEW_COMMENT_POSTED, bundle);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean O0(Bundle bundle) {
        String challengeId;
        final boolean z2 = true;
        if (this.savedList == null && this.preferenceService != null) {
            return true;
        }
        boolean z = false;
        if (bundle == null) {
            return false;
        }
        this.savedList = z;
        this.Z = bundle.getString("entryId");
        this.l0 = bundle.getString("commentId");
        this.a0 = (ChallengeEntryModel)bundle.getParcelable("entryModel");
        challengeId = bundle.getString("challengeId");
        if (this.Z != null && challengeId != null && bundle.getString("linkType") != null) {
            this.F.logEvent(E_ChallengeSharing.c.c(new EP_EntryId(), this.Z, new EP_ChallengeId(), challengeId));
        }
        if (this.Z == null && this.a0 == null) {
            return false;
        }
        if (this.a0 != null) {
            n.d(this.a0);
            n.d(this.a0);
            this.a0.setEntryStateData(this.connectivityService.a.b(this.a0.getDocumentId()));
            n.d(this.a0);
            this.Z = this.a0.getDocumentId();
            n.d(this.a0);
            challengeId = this.a0.getChallengeId();
            this.preferenceService = z2;
        }
        ChallengeModel challenge = this.commentPager.getChallenge(challengeId);
        this.likeList = challenge;
        if (challenge != null) {
            this.rateItService = z2;
        }
        return true;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void P0(int i) {
        this.e0 = i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final j<Void> Q0(String str, String str2) {
        int i = 1000;
        n.f(str, "challengeEntryId");
        n.f(str2, "challengeId");
        ArrayList arrayList = new ArrayList();
        j continueWith2 = this.authService.u(str, this.baseEntryLayoutHelper.v()).continueWith(new app.dogo.com.dogo_android.challenge.comments.k(this));
        n.e(continueWith2, "firestoreService.fetchLikeListForEntriesComments(challengeEntryId, authService.currentUserId).continueWith<Void?> { task: Task<Map<String, Any>> ->\n            likeList.putAll(task.result!!)\n            isLikesFetched = true\n            null\n        }");
        arrayList.add(continueWith2);
        final boolean z = false;
        j continueWith3 = this.authService.fetchAllChallengesQuery(this.baseEntryLayoutHelper.v(), this.Z, z).continueWith(new app.dogo.com.dogo_android.challenge.comments.q(this));
        str3 = "firestoreService.fetchUserLikeListForEntry(authService.currentUserId, entryId, false).continueWith<Void?> { task: Task<Map<String, Boolean>> ->\n            stateManager.challengeState.entryStateDataHolder.updateEntryStateData(entryId!!, task.result)\n            null\n        }";
        n.e(continueWith3, str3);
        arrayList.add(continueWith3);
        if (this.rateItService == null) {
            j continueWith = this.authService.s(str2, this.H.W()).continueWith(new app.dogo.com.dogo_android.challenge.comments.m(this));
            n.e(continueWith, "firestoreService.fetchChallengeModel(challengeId, preferenceService.selectedLocale).continueWith<Void?> { task: Task<ChallengeModel?> ->\n                challengeFetched = true\n                challengeModel = task.result\n                null\n            }");
            arrayList.add(continueWith);
        }
        str2 = this.l0 != null ? 1000 : 40;
        this.P = this.authService.isEntryReported(str, (this.l0 != null ? 1000 : 40), z);
        j jVar2 = m.f(arrayList);
        n.e(jVar2, (this.l0 != null ? 1000 : 40));
        return jVar2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final List<ChallengeComment> S() {
        final ArrayList arrayList = new ArrayList();
        Iterator it = this.X.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            i = !(this.authService.getUserEntriesQuery((ChallengeComment)item, this.baseEntryLayoutHelper.v(), this.baseEntryLayoutHelper.C()));
        }
        return p.D0(arrayList, new app.dogo.com.dogo_android.challenge.comments.x.d());
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final ChallengeModel T() {
        return this.likeList;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final f.d.a.a<List<ChallengeComment>> U() {
        return this.firestoreService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean U0(ChallengeComment challengeComment) {
        String str;
        int i;
        boolean z2 = false;
        boolean entryAuthor;
        n.f(challengeComment, "model");
        i = 1;
        if (n.b(challengeComment.getUserId(), this.baseEntryLayoutHelper.v())) {
            int r0 = this.baseEntryLayoutHelper.v().length() > 0 ? i : 0;
            if (this.baseEntryLayoutHelper == 0) {
                if (challengeComment.isEntryAuthor(this.baseEntryLayoutHelper.v())) {
                }
            }
        }
        return z2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void V0() {
        if (this.l0 != null && !this.m0) {
            this.m0 = true;
            this.stateManager.postValue(this.l0);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final int W() {
        return this.alreadyScrollToDeeplink.A().j();
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final void W0(String str) {
        if (!l.z(this.baseEntryLayoutHelper.v()) != 0 && str != null) {
            this.listEndReached = V();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final String X() {
        return this.alreadyScrollToDeeplink.A().n();
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final x<Boolean> Y() {
        return this.hasPremiumBadge;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
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

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final x<Boolean> c0() {
        return this.W;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final List<String> d0() {
        List list;
        if (this.l0 != null) {
            n.d(this.l0);
            list = p.b(this.l0);
        } else {
            list = p.g();
        }
        return list;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final f.d.a.a<List<ChallengeComment>> e0() {
        return this.firstLaunch;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final long f0() {
        return this.f0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final f.d.a.a<String> g0() {
        return this.stateManager;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final Uri h0() {
        String str = null;
        int i = 0;
        i = 0;
        if (this.listEndReached != null && this.listEndReached == null) {
            n.d(str);
            Uri uri = this.G.h(str, "avatar.jpg");
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean isUserSignedIn() {
        return this.baseEntryLayoutHelper.D();
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean k0() {
        return this.baseEntryLayoutHelper.C();
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean l0(ChallengeComment challengeComment) {
        n.f(challengeComment, "model");
        return challengeComment.isCommentAuthor(this.baseEntryLayoutHelper.v());
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean m0() {
        String name = null;
        boolean z = true;
        if (this.listEndReached == null) {
            int i3 = 0;
        } else {
            name = this.listEndReached.getName();
        }
        if (this.listEndReached == null || this.listEndReached.length() == 0) {
            int i = 1;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean n0(ChallengeComment challengeComment) {
        n.f(challengeComment, "model");
        return challengeComment.isEntryAuthor(this.baseEntryLayoutHelper.v());
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean o0() {
        return this.preferenceService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean p0() {
        boolean commentReported = false;
        if (this.a0 != null) {
            commentReported = this.authService.isCommentReported(this.a0, this.baseEntryLayoutHelper.v(), this.baseEntryLayoutHelper.C());
        } else {
            int i = 0;
        }
        return commentReported;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean q0(ChallengeEntryModel challengeEntryModel) {
        n.f(challengeEntryModel, "model");
        return n.b(this.baseEntryLayoutHelper.v(), challengeEntryModel.getAuthor());
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean r0() {
        return this.premiumState;
    }

    @Override // app.dogo.com.dogo_android.util.e0.r
    public final boolean s0() {
        boolean z = false;
        if (yVar instanceof LoadResult_Success) {
            int r0 = (Boolean)yVar.component1().booleanValue() ? 1 : 0;
        }
        return ((Boolean)yVar.component1().booleanValue() ? 1 : 0);
    }

    /* renamed from: A0, reason: from kotlin metadata */
    public static /* synthetic */ Void deleteEntry(x model, j photoPosition) {
        return ChallengeCommentsViewModel.T0(model, photoPosition);
    }

    /* renamed from: B0, reason: from kotlin metadata */
    public static /* synthetic */ void detectDoubleClick(x mod, c0 id) {
        ChallengeCommentsViewModel.P(mod, id);
    }

    public static /* synthetic */ Boolean C0(x xVar, DogProfileModel dogProfileModel, DogProfile dogProfile) {
        return ChallengeCommentsViewModel.F(xVar, dogProfileModel, dogProfile);
    }

    /* renamed from: D0, reason: from kotlin metadata */
    public static /* synthetic */ g0 detectSimpleClick(x model, Boolean photoId) {
        return ChallengeCommentsViewModel.setupCommentListData(model, photoId);
    }

    public static /* synthetic */ w E0(x xVar, c0 c0Var, j jVar) {
        return ChallengeCommentsViewModel.Q(xVar, c0Var, jVar);
    }

    public static /* synthetic */ void t0(x xVar, QuerySnapshot querySnapshot, FirebaseFirestoreException exc) {
        ChallengeCommentsViewModel.j0(xVar, querySnapshot, exc);
    }

    public static /* synthetic */ Void u0(x xVar, j jVar) {
        return ChallengeCommentsViewModel.S0(xVar, jVar);
    }

    public static /* synthetic */ g0 v0(x xVar, w wVar) {
        return ChallengeCommentsViewModel.onSendClick(xVar, wVar);
    }

    public static /* synthetic */ Void w0(x xVar, j jVar) {
        return ChallengeCommentsViewModel.R0(xVar, jVar);
    }

    public static /* synthetic */ void x0(x xVar, QuerySnapshot querySnapshot) {
        ChallengeCommentsViewModel.L0(xVar, querySnapshot);
    }

    public static /* synthetic */ boolean y0(x xVar, List list, int i) {
        return ChallengeCommentsViewModel.H(xVar, list, i);
    }

    public static /* synthetic */ w z0(x xVar, Boolean boolean) {
        return ChallengeCommentsViewModel.onCommentDelete(xVar, boolean);
    }
}
