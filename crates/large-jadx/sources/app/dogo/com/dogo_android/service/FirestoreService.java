package app.dogo.com.dogo_android.service;

import androidx.lifecycle.x;
import app.dogo.com.dogo_android.k.f;
import app.dogo.com.dogo_android.model.ChallengeComment;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.model.ChallengeModel;
import app.dogo.com.dogo_android.model.ChallengeModel.Companion;
import app.dogo.com.dogo_android.model.DogProfileModel;
import app.dogo.com.dogo_android.model.PhotoLikeModel;
import app.dogo.com.dogo_android.util.e0.t;
import app.dogo.com.dogo_android.v.c;
import app.dogo.com.dogo_android.w.h1;
import app.dogo.com.dogo_android.w.i1;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q1;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.w.v2;
import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentChange.Type;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirebaseFirestoreSettings.Builder;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.Query.Direction;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.firestore.SnapshotMetadata;
import com.google.firebase.firestore.Source;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: FirestoreService.kt */
@Metadata(d1 = "\u0000\u0082\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0010!\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010$\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008$\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u0000 ¡\u00012\u00020\u0001:\u0006¡\u0001¢\u0001£\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u001e\u0010#\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u00162\u0008\u0010$\u001a\u0004\u0018\u00010\u000b2\u0006\u0010%\u001a\u00020&J\"\u0010'\u001a\u00060(R\u00020\u00002\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+J\"\u0010-\u001a\u00060(R\u00020\u00002\u0006\u0010.\u001a\u00020/2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+JN\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000b2\u0006\u00103\u001a\u00020&2\u0008\u00104\u001a\u0004\u0018\u00010\u000b2\u0008\u00105\u001a\u0004\u0018\u00010\u000b2\u0006\u00106\u001a\u0002072\u0012\u00108\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020:0\u001609J\u0016\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020+J\u001e\u0010@\u001a\u00020<2\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000bJ\u000e\u0010B\u001a\u00020<2\u0006\u0010C\u001a\u00020:J\u0010\u0010D\u001a\u00020<2\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010D\u001a\u00020<2\u0006\u0010G\u001a\u00020HH\u0002J\u0016\u0010I\u001a\u0008\u0012\u0004\u0012\u00020K0J2\u0008\u0010$\u001a\u0004\u0018\u00010\u000bJ.\u0010L\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020M0\u00160J2\u0008\u0010N\u001a\u0004\u0018\u00010\u000b2\u0008\u0010O\u001a\u0004\u0018\u00010\u000b2\u0006\u0010P\u001a\u00020&J\"\u0010Q\u001a\u00020/2\u0006\u0010N\u001a\u00020\u000b2\u0008\u0010O\u001a\u0004\u0018\u00010\u000b2\u0006\u0010P\u001a\u00020&H\u0002J\u0016\u0010R\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010>0J2\u0006\u0010)\u001a\u00020\u000bJ \u0010S\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010M0J2\u0006\u00105\u001a\u00020\u000b2\u0008\u0010N\u001a\u0004\u0018\u00010\u000bJ(\u0010T\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010U0J2\u0006\u0010)\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000bJ\u0014\u0010V\u001a\u0008\u0012\u0004\u0012\u00020\u000b0J2\u0006\u0010W\u001a\u00020FJ&\u0010X\u001a\u0002012\u0006\u0010A\u001a\u00020\u000b2\u0008\u00105\u001a\u0004\u0018\u00010\u000b2\u000c\u0010Y\u001a\u0008\u0012\u0004\u0012\u00020K0ZJ(\u0010X\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010>0\u00160J2\u0008\u0010A\u001a\u0004\u0018\u00010\u000b2\u0008\u00105\u001a\u0004\u0018\u00010\u000bJ>\u0010[\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020&0U0U0J2\u0006\u00102\u001a\u00020\u000b2\u0008\u00105\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\\\u001a\u00020&J2\u0010]\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020&0U0J2\u0006\u00102\u001a\u00020\u000b2\u0008\u0010)\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\\\u001a\u00020&J\u0016\u0010^\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010_\u001a\u00020\u000bJ\u001a\u0010`\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020b0\u00160a2\u0006\u0010$\u001a\u00020\u000bJ\u000e\u0010c\u001a\u00020d2\u0006\u0010E\u001a\u00020FJ \u0010e\u001a\u00020<2\u0006\u0010E\u001a\u00020F2\u0010\u0010Y\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010g\u0018\u00010fJ\u000e\u0010h\u001a\u00020H2\u0006\u0010E\u001a\u00020FJ\u0012\u0010i\u001a\u00060jR\u00020\u00002\u0006\u0010E\u001a\u00020FJ\"\u0010k\u001a\u00020/2\u0008\u00102\u001a\u0004\u0018\u00010\u000b2\u0008\u00105\u001a\u0004\u0018\u00010\u000b2\u0006\u0010l\u001a\u00020+J\u000e\u0010m\u001a\u00020<2\u0006\u0010C\u001a\u00020:J\u001e\u0010n\u001a\u00020&2\u0006\u0010o\u001a\u00020:2\u0006\u0010p\u001a\u00020\u000b2\u0006\u00103\u001a\u00020&J\u0016\u0010q\u001a\u00020&2\u0006\u0010$\u001a\u00020\u000b2\u0006\u00103\u001a\u00020&J\u001e\u0010r\u001a\u00020&2\u0006\u0010o\u001a\u00020>2\u0006\u0010p\u001a\u00020\u000b2\u0006\u00103\u001a\u00020&J,\u0010s\u001a\u00020:2\u0006\u0010t\u001a\u00020g2\u0008\u0010u\u001a\u0004\u0018\u00010\u000b2\u0008\u0010)\u001a\u0004\u0018\u00010\u000b2\u0008\u00105\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010v\u001a\u00020<J\u0006\u0010w\u001a\u00020<J \u0010x\u001a\u00020<2\u0006\u0010)\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0008\u0010y\u001a\u0004\u0018\u00010\u000bJ$\u0010z\u001a\u00020<2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010{\u001a\u00020\u000b2\u000c\u0010|\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u0016J(\u0010}\u001a\u00020<2\u0006\u0010~\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000b2\u0008\u0010y\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u007f\u001a\u00020<2\u0006\u0010)\u001a\u00020\u000bJ\u0010\u0010\u0080\u0001\u001a\u00020<2\u0007\u0010\u0081\u0001\u001a\u00020\u000bJ\u0011\u0010\u0082\u0001\u001a\u00020<2\u0006\u0010~\u001a\u00020\u000bH\u0002J\u0011\u0010\u0083\u0001\u001a\u00020<2\u0006\u0010$\u001a\u00020\u000bH\u0002J\u0011\u0010\u0084\u0001\u001a\u00020<2\u0006\u0010)\u001a\u00020\u000bH\u0002J%\u0010\u0085\u0001\u001a\u0002012\u0006\u00102\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+2\u000c\u0010Y\u001a\u0008\u0012\u0004\u0012\u00020K0ZJ%\u0010\u0086\u0001\u001a\u0002012\u0006\u00102\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+2\u000c\u0010Y\u001a\u0008\u0012\u0004\u0012\u00020K0ZJ#\u0010\u0087\u0001\u001a\u00020<2\u0006\u00102\u001a\u00020\u000b2\u0007\u0010\u0088\u0001\u001a\u00020>2\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u000bJ\u0017\u0010\u008a\u0001\u001a\u00020<2\u0006\u0010=\u001a\u00020:2\u0006\u00102\u001a\u00020\u000bJ \u0010\u008b\u0001\u001a\u00020<2\u0006\u00102\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000b2\u0007\u0010\u008c\u0001\u001a\u00020&J\u0017\u0010\u008d\u0001\u001a\u00020<2\u0006\u00102\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000bJL\u0010\u008e\u0001\u001a\t\u0012\u0005\u0012\u00030\u008f\u00010J2\u0006\u0010E\u001a\u00020F2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u00012\u0018\u0010\u0092\u0001\u001a\r\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u00010\u0093\u0001\"\u0004\u0018\u00010\u0001¢\u0006\u0003\u0010\u0094\u0001J\u000f\u0010\u0095\u0001\u001a\u00020<2\u0006\u0010=\u001a\u00020:JB\u0010\u0096\u0001\u001a\u00020<2\u0006\u00102\u001a\u00020\u000b2\u0007\u0010\u0088\u0001\u001a\u00020>2\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u000b2\u0007\u0010\u0098\u0001\u001a\u00020\u000b2\t\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u000bJ!\u0010\u009a\u0001\u001a\u00020<2\u0006\u0010=\u001a\u00020:2\u0006\u00102\u001a\u00020\u000b2\u0008\u0010\u009b\u0001\u001a\u00030\u009c\u0001J-\u0010\u009d\u0001\u001a\t\u0012\u0005\u0012\u00030\u008f\u00010J2\u0006\u0010E\u001a\u00020F2\n\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u00012\u0007\u0010 \u0001\u001a\u00020&H\u0002J8\u0010\u009d\u0001\u001a\t\u0012\u0005\u0012\u00030\u008f\u00010J2\u0006\u0010E\u001a\u00020F2\u0017\u0010\u009e\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010U2\u0007\u0010 \u0001\u001a\u00020&R\u0018\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R \u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0012\u0010\u000e\"\u0004\u0008\u0013\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000b0\u00160\u0015¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006¤\u0001", d2 = {"Lapp/dogo/com/dogo_android/service/FirestoreService;", "", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "fbDatabase", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "sharedPreferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "(Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/UserLocalCacheService;Lapp/dogo/com/dogo_android/service/PreferenceService;)V", "adminList", "", "", "ambassadorDogsList", "getAmbassadorDogsList", "()Ljava/util/Set;", "setAmbassadorDogsList", "(Ljava/util/Set;)V", "ambassadorList", "getAmbassadorList", "setAmbassadorList", "removeEntryEvent", "Lcom/hadilq/liveevent/LiveEvent;", "", "getRemoveEntryEvent", "()Lcom/hadilq/liveevent/LiveEvent;", "reportedCommentIds", "", "reportedDogIds", "reportedEntryIds", "rootDatabase", "Lcom/google/firebase/firestore/FirebaseFirestore;", "getSharedPreferenceService", "()Lapp/dogo/com/dogo_android/service/PreferenceService;", "timeUtil", "Lapp/dogo/com/dogo_android/service/Utilities;", "buildBadgeList", "dogId", "isPremium", "", "buildCommentPager", "Lapp/dogo/com/dogo_android/service/FirestoreService$FirestorePager;", "entryId", "limit", "", "pageType", "buildFirestorePager", "query", "Lcom/google/firebase/firestore/Query;", "buildNewCommentListener", "Lcom/google/firebase/firestore/ListenerRegistration;", "userId", "isAdmin", "entryAuthorId", "challengeId", "startPointTimestamp", "", "callback", "Lapp/dogo/com/dogo_android/util/recycle_views/SimpleObjectCallback;", "Lapp/dogo/com/dogo_android/model/ChallengeComment;", "deleteChallengeEntriesPhoto", "", "model", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "photoPosition", "deleteChallengeEntry", "uid", "deleteComment", "comment", "deleteDocument", "path", "Lapp/dogo/com/dogo_android/enums/FirestorePath;", "document", "Lcom/google/firebase/firestore/DocumentReference;", "fetchAllChallengeEntriesForDog", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/firebase/firestore/QuerySnapshot;", "fetchAllChallenges", "Lapp/dogo/com/dogo_android/model/ChallengeModel;", "locale", "location", "userAdmin", "fetchAllChallengesQuery", "fetchChallengeEntry", "fetchChallengeModel", "fetchLikeListForEntriesComments", "", "fetchTranslationText", "localeDataPath", "fetchUserEntries", "listener", "Lcom/google/firebase/firestore/EventListener;", "fetchUserLikeListForChallenge", "cached", "fetchUserLikeListForEntry", "generateExamId", "trickId", "getAllDogExams", "Lio/reactivex/Single;", "Lapp/dogo/com/dogo_android/model/ExamModel;", "getCollectionReference", "Lcom/google/firebase/firestore/CollectionReference;", "getDocument", "Lcom/google/android/gms/tasks/OnCompleteListener;", "Lcom/google/firebase/firestore/DocumentSnapshot;", "getDocumentReference", "getQuery", "Lapp/dogo/com/dogo_android/service/FirestoreService$QueryBuilder;", "getUserEntriesQuery", "maxEntries", "hideComment", "isCommentReported", "item", "currentUserId", "isDogReported", "isEntryReported", "parseComment", "doc", "entryAuthor", "refreshAdminList", "refreshAmbassadorDogsList", "reportChallengeEntry", "reportReason", "reportChallengeProfile", "reporterUserId", "entryIds", "reportComment", "commentId", "revertPhotoUploadState", "rollBackEntry48Hours", "documentId", "saveReportedCommentId", "saveReportedDogId", "saveReportedEntryId", "startListeningToArchivedNotificationBranch", "startListeningToFollowedNotificationBranch", "unvoteChallengeEntry", "entry", "photoId", "unvoteEntryComment", "updateChatNotificationFollowState", "followState", "updateChatNotificationState", "updateDocument", "Ljava/lang/Void;", "field", "value", "moreFieldsAndValues", "", "(Lapp/dogo/com/dogo_android/enums/FirestorePath;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Lcom/google/android/gms/tasks/Task;", "uploadComment", "upvoteChallengeEntry", "userEntryId", "currentDogId", "appInstallationId", "upvoteEntryComment", "currentDog", "Lapp/dogo/com/dogo_android/model/DogProfileModel;", "writeToDocument", "data", "Lapp/dogo/com/dogo_android/util/base_classes/FirestoreCustomObject;", "merge", "Companion", "FirestorePager", "QueryBuilder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: m2, reason: from kotlin metadata */
public final class FirestoreService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final m2.a INSTANCE = new m2$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private final p2 adminList;
    private final FirebaseFirestore b;
    private final o3 c;
    /* renamed from: d, reason: from kotlin metadata */
    private final u2 fbDatabase;
    private final v2 e;
    /* renamed from: f, reason: from kotlin metadata */
    public Set<String> reportedCommentIds = new HashSet<>();
    /* renamed from: g, reason: from kotlin metadata */
    private Set<String> reportedDogIds = new HashSet<>();
    /* renamed from: h, reason: from kotlin metadata */
    private Set<String> reportedEntryIds = new HashSet<>();
    /* renamed from: i, reason: from kotlin metadata */
    private final f.d.a.a<List<String>> rootDatabase = new a<>();
    private final List<String> j = new ArrayList<>();
    /* renamed from: k, reason: from kotlin metadata */
    private final List<String> timeUtil = new ArrayList<>();
    /* renamed from: l, reason: from kotlin metadata */
    private final List<String> tracker = new ArrayList<>();

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/service/FirestoreService$Companion;", "", "()V", "PAGE_TYPE_FULL_LIST", "", "PAGE_TYPE_PAGED_LIST", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(kotlin.d0.d.g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0004\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011J\u0016\u0010\u0013\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011J\u0006\u0010\u0014\u001a\u00020\u000cJ\u001e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017", d2 = {"Lapp/dogo/com/dogo_android/service/FirestoreService$FirestorePager;", "", "query", "Lcom/google/firebase/firestore/Query;", "limit", "", "pageType", "queryWithLimit", "limitSum", "newestTime", "", "reachedEnd", "", "(Lapp/dogo/com/dogo_android/service/FirestoreService;Lcom/google/firebase/firestore/Query;IILcom/google/firebase/firestore/Query;IJZ)V", "addNewDocuments", "", "listener", "Lcom/google/android/gms/tasks/OnSuccessListener;", "Lcom/google/firebase/firestore/QuerySnapshot;", "fetchNextPage", "hasReachedEnd", "reinitPager", "resetPosition", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b {

        /* renamed from: a, reason: from kotlin metadata */
        private Query limit;
        /* renamed from: b, reason: from kotlin metadata */
        private int limitSum;
        /* renamed from: c, reason: from kotlin metadata */
        private int newestTime;
        /* renamed from: d, reason: from kotlin metadata */
        private Query pageType;
        /* renamed from: e, reason: from kotlin metadata */
        private int query;
        /* renamed from: f, reason: from kotlin metadata */
        private long queryWithLimit;
        /* renamed from: g, reason: from kotlin metadata */
        private boolean reachedEnd;
        public b(Query query, int i, int i2, Query query2, int i3, long j, boolean z) {
            n.f(m2Var, "this$0");
            n.f(query, "query");
            n.f(query2, "queryWithLimit");
            super();
            this.limit = query;
            this.limitSum = i;
            this.newestTime = i2;
            this.pageType = query2;
            this.query = i3;
            this.queryWithLimit = j;
            this.reachedEnd = z;
        }

        /* renamed from: b, reason: from kotlin metadata */
        private static final void reinitPager(m2.b query, com.google.android.gms.tasks.g limit, j pageType) {
            n.f(query, "this$0");
            n.f(limit, "$listener");
            n.f(pageType, "task");
            query.queryWithLimit = Calendar.getInstance().getTimeInMillis();
            limit.onSuccess((QuerySnapshot)pageType.getResult());
        }

        private static final void d(m2.b bVar, com.google.android.gms.tasks.g gVar, j jVar) {
            int i;
            Query limit;
            String str;
            String str2;
            long timeInMillis;
            long l;
            long l2 = 0;
            n.f(bVar, "this$0");
            n.f(gVar, "$listener");
            n.f(jVar, "task");
            if (jVar.isSuccessful()) {
                Object result = jVar.getResult();
                i = 1;
                if (bVar.newestTime == 0) {
                    List documents = result.getDocuments();
                    str2 = "documentSnapshots.documents";
                    n.e(documents, str2);
                    i = documents.isEmpty() ^ i;
                    if (documents.isEmpty() ^ i) {
                        l2 = 0L;
                        if (bVar.queryWithLimit == l2) {
                            bVar.queryWithLimit = Calendar.getInstance().getTimeInMillis();
                        }
                        i = result.size() - i;
                        if (result.size() - i >= 0) {
                            i = i - 1;
                            boolean pendingWrites = (DocumentSnapshot)result.getDocuments().get(i).getMetadata().hasPendingWrites();
                            while (!pendingWrites) {
                                if (i < 0) {
                                    break;
                                }
                            }
                            Query limit2 = bVar.limit.startAfter((DocumentSnapshot)result.getDocuments().get(i)).limit((long)bVar.limitSum);
                            n.e(limit2, "query.startAfter(lastVisible).limit(limit.toLong())");
                            bVar.pageType = limit2;
                        }
                    }
                    bVar.reachedEnd = result.isEmpty();
                } else {
                    if (bVar.query <= result.size()) {
                        i = 0;
                    }
                    bVar.reachedEnd = i;
                    bVar.query += limitSum2;
                    l = (long)i2;
                    limit = bVar.limit.limit(l);
                    str = "query.limit(limitSum.toLong())";
                    n.e(limit, str);
                    bVar.pageType = limit;
                }
                gVar.onSuccess(result);
            } else {
                a.d(jVar.getException());
            }
        }

        /* renamed from: a, reason: from kotlin metadata */
        public final void addNewDocuments(com.google.android.gms.tasks.g<QuerySnapshot> listener) {
            n.f(listener, "listener");
            int i = 1;
            Object[] arr = new Object[i];
            arr[0] = new Date(this.queryWithLimit, r5);
            int i2 = this.limitSum + i;
            this.limit.endBefore(arr).limit((long)i2).get().addOnCompleteListener(new a1(this, listener));
        }

        /* renamed from: c, reason: from kotlin metadata */
        public final void fetchNextPage(com.google.android.gms.tasks.g<QuerySnapshot> listener) {
            n.f(listener, "listener");
            this.pageType.get().addOnCompleteListener(new z0(this, listener));
        }

        /* renamed from: e, reason: from kotlin metadata */
        public final boolean hasReachedEnd() {
            return this.reachedEnd;
        }

        public final void h(Query query, int i, int i2) {
            n.f(query, "query");
            this.newestTime = i2;
            this.limit = query;
            Query limit = query.limit((long)i);
            n.e(limit, "query.limit(limit.toLong())");
            this.pageType = limit;
            this.limitSum = i;
            this.query = i;
            this.queryWithLimit = 0L;
            this.reachedEnd = false;
        }

        public final void i() {
            this.query = this.limitSum;
            Query limit = this.limit.limit((long)limitSum2);
            n.e(limit, "query.limit(limit.toLong())");
            this.pageType = limit;
            this.reachedEnd = false;
        }

        public /* synthetic */ b(Query query, int i, int i2, Query query2, int i3, long j, boolean z, int i4, kotlin.d0.d.g gVar) {
            int i32;
            Query query52;
            int j72;
            int i92;
            if (i4 & 8 != 0) {
                query22 = query;
                query52 = query.limit((long)i);
                str = "class FirestorePager(\n        private var query: Query,\n        private var limit: Int,\n        private var pageType: Int,\n        private var queryWithLimit: Query = query.limit(limit.toLong()),\n        private var limitSum: Int = limit,\n        private var newestTime: Long = 0,\n        private var reachedEnd: Boolean = false\n    ) {\n        fun addNewDocuments(listener: OnSuccessListener<QuerySnapshot?>) {\n            query.endBefore(Date(newestTime)).limit((limit + 1).toLong()).get().addOnCompleteListener { task: Task<QuerySnapshot?> ->\n                val documentSnapshots = task.result\n                newestTime = Calendar.getInstance().timeInMillis\n                listener.onSuccess(documentSnapshots)\n            }\n        }\n\n        fun fetchNextPage(listener: OnSuccessListener<QuerySnapshot?>) {\n            queryWithLimit.get().addOnCompleteListener { task: Task<QuerySnapshot> ->\n                if (task.isSuccessful) {\n                    val documentSnapshots = task.result\n                    if (pageType == PAGE_TYPE_PAGED_LIST) {\n                        if (documentSnapshots.documents.isNotEmpty()) {\n                            if (newestTime == 0L) {\n                                newestTime = Calendar.getInstance().timeInMillis\n                            }\n                            for (cursor in documentSnapshots.size() - 1 downTo 0) {\n                                if (!documentSnapshots.documents[cursor].metadata.hasPendingWrites()) {\n                                    val lastVisible = documentSnapshots.documents[cursor]\n                                    queryWithLimit = query.startAfter(lastVisible).limit(limit.toLong())\n                                    break\n                                }\n                            }\n                        }\n                        reachedEnd = documentSnapshots.isEmpty\n                    } else {\n                        reachedEnd = limitSum > documentSnapshots.size()\n                        limitSum += limit\n                        queryWithLimit = query.limit(limitSum.toLong())\n                    }\n                    listener.onSuccess(documentSnapshots)\n                } else {\n                    Timber.e(task.exception)\n                }\n            }\n        }\n\n        fun reinitPager(query: Query, limit: Int, pageType: Int) {\n            this.pageType = pageType\n            this.query = query\n            this.queryWithLimit = query.limit(limit.toLong())\n            this.limit = limit\n            this.limitSum = limit\n            this.newestTime = 0\n            this.reachedEnd = false\n        }\n\n        fun resetPosition() {\n            this.limitSum = limit\n            this.queryWithLimit = query.limit(limit.toLong())\n            this.reachedEnd = false\n        }\n\n        fun hasReachedEnd(): Boolean {\n            return reachedEnd\n        }\n    }";
                n.e(query52, str);
            } else {
                query22 = query;
                i32 = i;
                query52 = query2;
            }
            int r7 = i4 & 16 != 0 ? i32 : i3;
            j72 = i4 & 32;
            j72 = i4 & 32 != 0 ? j72 : j;
            i92 = i4 & 64;
            i92 = i4 & 64 != 0 ? i92 : z;
            this(m2Var, query, i, i2, query52, i32, j72, z, i92);
        }

        public static /* synthetic */ void f(m2.b bVar, com.google.android.gms.tasks.g gVar, j jVar) {
            FirestoreService_FirestorePager.d(bVar, gVar, jVar);
        }

        public static /* synthetic */ void g(m2.b bVar, com.google.android.gms.tasks.g gVar, j jVar) {
            FirestoreService_FirestorePager.reinitPager(bVar, gVar, jVar);
        }
    }

    @Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\u0012\u0010\u0008\u001a\u00060\u0000R\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0012\u0010\u000c\u001a\u00060\u0000R\u00020\t2\u0006\u0010\r\u001a\u00020\u000bJ\u0012\u0010\u000e\u001a\u00060\u0000R\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010J\u001a\u0010\u0011\u001a\u00060\u0000R\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014J\u0012\u0010\u0015\u001a\u00060\u0000R\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017J\u0012\u0010\u0018\u001a\u00060\u0000R\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014J\u0012\u0010\u0019\u001a\u00060\u0000R\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014J\u0012\u0010\u001a\u001a\u00060\u0000R\u00020\t2\u0006\u0010\u001b\u001a\u00020\u000bJ\n\u0010\u001c\u001a\u00060\u0000R\u00020\tJ\u0012\u0010\u001d\u001a\u00060\u0000R\u00020\t2\u0006\u0010\u0012\u001a\u00020\u001eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/service/FirestoreService$QueryBuilder;", "", "path", "Lapp/dogo/com/dogo_android/enums/FirestorePath;", "(Lapp/dogo/com/dogo_android/service/FirestoreService;Lapp/dogo/com/dogo_android/enums/FirestorePath;)V", "query", "Lcom/google/firebase/firestore/Query;", "build", "forAuthor", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "author", "", "forChallenge", "challengeId", "limitTo", "limit", "", "orderBy", "value", "order", "Lcom/google/firebase/firestore/Query$Direction;", "publishedAfter", "timestamp", "Ljava/util/Date;", "sortByDate", "sortByLikes", "whereIsCountry", "country", "whereIsFeatured", "wherePublished", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class c {

        /* renamed from: a, reason: from kotlin metadata */
        private Query query;
        final /* synthetic */ m2 b;
        public c(f fVar) {
            n.f(m2Var, "this$0");
            n.f(fVar, "path");
            this.b = m2Var;
            super();
            this.query = m2Var.I(fVar);
        }

        /* renamed from: a, reason: from kotlin metadata */
        public final Query build() {
            return this.query;
        }

        /* renamed from: b, reason: from kotlin metadata */
        public final m2.c forAuthor(String author) {
            String str = "author";
            n.f(author, str);
            final Query whereEqualTo = this.query.whereEqualTo(str, author);
            n.e(whereEqualTo, "query.whereEqualTo(\"author\", author)");
            this.query = whereEqualTo;
            return this;
        }

        /* renamed from: c, reason: from kotlin metadata */
        public final m2.c forChallenge(String challengeId) {
            String str = "challengeId";
            n.f(challengeId, str);
            final Query whereEqualTo = this.query.whereEqualTo(str, challengeId);
            n.e(whereEqualTo, "query.whereEqualTo(\"challengeId\", challengeId)");
            this.query = whereEqualTo;
            return this;
        }

        /* renamed from: d, reason: from kotlin metadata */
        public final m2.c limitTo(long limit) {
            final Query limit2 = this.query.limit(limit);
            n.e(limit2, "query.limit(limit)");
            this.query = limit2;
            return this;
        }

        /* renamed from: e, reason: from kotlin metadata */
        public final m2.c orderBy(String value, Query.Direction order) {
            n.f(value, "value");
            n.f(order, "order");
            final Query orderBy = this.query.orderBy(value, order);
            n.e(orderBy, "query.orderBy(value, order)");
            this.query = orderBy;
            return this;
        }

        /* renamed from: f, reason: from kotlin metadata */
        public final m2.c publishedAfter(Date timestamp) {
            n.f(timestamp, "timestamp");
            final Query whereGreaterThan = this.query.whereGreaterThan("date", timestamp);
            n.e(whereGreaterThan, "query.whereGreaterThan(\"date\", timestamp)");
            this.query = whereGreaterThan;
            return this;
        }

        /* renamed from: g, reason: from kotlin metadata */
        public final m2.c sortByDate(Query.Direction order) {
            n.f(order, "order");
            final Query orderBy = this.query.orderBy("date", order);
            n.e(orderBy, "query.orderBy(\"date\", order)");
            this.query = orderBy;
            return this;
        }

        /* renamed from: h, reason: from kotlin metadata */
        public final m2.c sortByLikes(Query.Direction order) {
            n.f(order, "order");
            final Query orderBy = this.query.orderBy("votes", order);
            n.e(orderBy, "query.orderBy(\"votes\", order)");
            this.query = orderBy;
            return this;
        }

        /* renamed from: i, reason: from kotlin metadata */
        public final m2.c whereIsCountry(String country) {
            String str = "country";
            n.f(country, str);
            String str4 = country.toLowerCase();
            n.e(str4, "(this as java.lang.String).toLowerCase()");
            Query whereEqualTo = this.query.whereEqualTo(str, str4);
            n.e(whereEqualTo, "query.whereEqualTo(\"country\", country.toLowerCase())");
            this.query = whereEqualTo;
            return this;
        }

        public final m2.c j() {
            Query whereEqualTo = this.query.whereEqualTo("featured", Boolean.TRUE);
            n.e(whereEqualTo, "query.whereEqualTo(\"featured\", true)");
            this.query = whereEqualTo;
            return this;
        }

        /* renamed from: k, reason: from kotlin metadata */
        public final m2.c wherePublished(boolean value) {
            Query whereEqualTo = this.query.whereEqualTo("published", Boolean.valueOf(value));
            n.e(whereEqualTo, "query.whereEqualTo(\"published\", value)");
            this.query = whereEqualTo;
            return this;
        }
    }
    public m2(o3 o3Var, u2 u2Var, p2 p2Var) {
        n.f(o3Var, "tracker");
        n.f(u2Var, "fbDatabase");
        n.f(p2Var, "sharedPreferenceService");
        super();
        this.adminList = p2Var;
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        n.e(firebaseFirestore, "getInstance()");
        this.b = firebaseFirestore;
        this.e = App.INSTANCE.t();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        f.d.a.a aVar = new a();
        com.google.firebase.firestore.FirebaseFirestoreSettings builder2 = new FirebaseFirestoreSettings.Builder().setCacheSizeBytes(-1L).build();
        n.e(builder2, "Builder()\n            .setCacheSizeBytes(FirebaseFirestoreSettings.CACHE_SIZE_UNLIMITED).build()");
        firebaseFirestore.setFirestoreSettings(builder2);
        this.c = o3Var;
        this.fbDatabase = u2Var;
        new ArrayList().addAll(p2Var.T());
        new ArrayList().addAll(p2Var.U());
        new ArrayList().addAll(p2Var.V());
    }

    /* renamed from: A, reason: from kotlin metadata */
    private static final List deleteComment(j comment) {
        n.f(comment, "querySnapshot");
        ArrayList arrayList = new ArrayList();
        Iterator it = (QuerySnapshot)comment.getResult().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            Object object = item.toObject(ChallengeEntryModel.class);
            n.e(object, "doc.toObject(ChallengeEntryModel::class.java)");
            String str = item.getId();
            str2 = "doc.id";
            n.e(str, str2);
            object.setDocumentId(str);
            arrayList.add(object);
        }
        return arrayList;
    }

    /* renamed from: C, reason: from kotlin metadata */
    private static final Map deleteDocument(j path) {
        Object value;
        n.f(path, "querySnapshotTask");
        HashMap hashMap = new HashMap();
        Iterator it = (QuerySnapshot)path.getResult().getDocuments().iterator();
        while (it.hasNext()) {
            Object object = (DocumentSnapshot)it.next().toObject(PhotoLikeModel.class);
            n.d(object);
            n.d(value);
            value.put(object.getImageId(), Boolean.TRUE);
            hashMap.put(object.getEntryId(), value);
        }
        return hashMap;
    }

    /* renamed from: E, reason: from kotlin metadata */
    private static final Map deleteDocument(j document) {
        n.f(document, "querySnapshotTask");
        HashMap hashMap = new HashMap();
        Iterator it = (QuerySnapshot)document.getResult().getDocuments().iterator();
        while (it.hasNext()) {
            Object object = (DocumentSnapshot)it.next().toObject(PhotoLikeModel.class);
            n.d(object);
            hashMap.put(object.getImageId(), Boolean.TRUE);
        }
        return hashMap;
    }

    /* renamed from: G0, reason: from kotlin metadata */
    private final j<Void> buildCommentPager(f entryId, t limit, boolean pageType) {
        j jVar;
        if (!pageType) {
            n.d(limit);
            str = "{\n            getDocumentReference(path).set(data!!)\n        }";
            n.e(K(entryId).set(limit), str);
        } else {
            n.d(limit);
            str = "{\n            getDocumentReference(path).set(data!!, SetOptions.merge())\n        }";
            n.e(K(entryId).set(limit, SetOptions.merge()), str);
        }
        return jVar;
    }

    private static final void e(m2 m2Var, String str, String str2, String str3, app.dogo.com.dogo_android.util.n0.u uVar, String str4, boolean z, QuerySnapshot querySnapshot, FirebaseFirestoreException exc) {
        int i2;
        DocumentChange.Type type;
        DocumentChange.Type mODIFIED2;
        boolean published;
        Iterator it2;
        ArrayList arrayList;
        n.f(m2Var, "this$0");
        n.f(str2, "$entryId");
        n.f(uVar, "$callback");
        str5 = "$userId";
        n.f(str4, str5);
        if (querySnapshot != null) {
            List documentChanges2 = querySnapshot.getDocumentChanges();
            n.e(documentChanges2, "queryDocumentSnapshots.documentChanges");
            int i = 1;
            if (documentChanges2.isEmpty() ^ i) {
                arrayList = new ArrayList();
                it2 = querySnapshot.getDocumentChanges().iterator();
                i2 = 0;
                while (it2.hasNext()) {
                    Object item = it2.next();
                    str = "documentChange.document";
                }
                i3 = arrayList.isEmpty() ^ i;
                if (arrayList.isEmpty() ^ i) {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Object item2 = it.next();
                        str42 = item2;
                    }
                    uVar.a(arrayList2, i2);
                }
            }
        }
    }

    /* renamed from: i, reason: from kotlin metadata */
    private final void saveReportedEntryId(f entryId) {
        uploadComment(K(entryId));
    }

    /* renamed from: j, reason: from kotlin metadata */
    private final void uploadComment(DocumentReference model) {
        model.delete().addOnSuccessListener(f1.a).addOnFailureListener(v0.a);
    }

    /* renamed from: j0, reason: from kotlin metadata */
    private static final void fetchChallengeModel(m2 challengeId, QuerySnapshot locale) {
        n.f(challengeId, "this$0");
        str = "adminQuerySnapshot";
        n.f(locale, str);
        final Iterator it = locale.iterator();
        while (it.hasNext()) {
            String str = (QueryDocumentSnapshot)it.next().getId();
            str2 = "doc.id";
            n.e(str, str2);
            challengeId.reportedCommentIds.add(str);
        }
    }

    private static final void k0(Exception exc) {
        a.d(exc);
    }

    /* renamed from: m0, reason: from kotlin metadata */
    private static final void fetchLikeListForEntriesComments(m2 entryId, QuerySnapshot userId) {
        n.f(entryId, "this$0");
        str = "ambassadorQuerySnapshot";
        n.f(userId, str);
        final Iterator it = userId.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            String str3 = item.getId();
            str4 = "doc.id";
            n.e(str3, str4);
            entryId.H().add(str3);
            str2 = "dogFriends";
            String str = item.get(str2);
        }
    }

    private static final void n0(Exception exc) {
        a.d(exc);
    }

    private static final List o(j jVar) {
        app.dogo.com.dogo_android.model.ChallengeModel.MediaTypes mediaType;
        n.f(jVar, "task");
        ArrayList arrayList = new ArrayList();
        Iterator it = (QuerySnapshot)jVar.getResult().getDocuments().iterator();
        while (it.hasNext()) {
            cls = ChallengeModel.class;
            Object object = (DocumentSnapshot)it.next().toObject(cls);
        }
        return arrayList;
    }

    /* renamed from: p, reason: from kotlin metadata */
    private final Query buildFirestorePager(String query, String limit, boolean pageType) {
        Query whereEqualTo;
        Query whereArrayContains;
        String str11 = LocaleService.e(query);
        str2 = "startDate";
        final String str7 = "locale";
        final String str8 = "hasStarted";
        String str9 = "challengeLocales";
        if (App.INSTANCE.n().E()) {
            Query.Direction dESCENDING22 = Query.Direction.DESCENDING;
            str3 = "orderPriority";
            str = "{\n            rootDatabase.collectionGroup(\"challengeLocales\")\n                .orderBy(\"hasEnded\", Query.Direction.ASCENDING)\n                .orderBy(\"orderPriority\", Query.Direction.DESCENDING)\n                .orderBy(\"startDate\", Query.Direction.DESCENDING)\n                .whereEqualTo(\"locale\", validatedLocale)\n                .whereEqualTo(\"hasStarted\", true)\n        }";
            n.e(this.b.collectionGroup(str9).orderBy("hasEnded", Query.Direction.ASCENDING).orderBy(str3, dESCENDING22).orderBy(str2, dESCENDING22).whereEqualTo(str7, str11).whereEqualTo(str8, Boolean.TRUE), str);
        } else {
            str2 = "typePhoto";
            str = "{\n            rootDatabase.collectionGroup(\"challengeLocales\")\n                .whereEqualTo(\"hasStarted\", true)\n                .whereEqualTo(\"locale\", validatedLocale)\n                .orderBy(\"startDate\", Query.Direction.DESCENDING)\n                .whereEqualTo(\"entryType\", \"typePhoto\")\n        }";
            n.e(this.b.collectionGroup(str9).whereEqualTo(str8, Boolean.TRUE).whereEqualTo(str7, str11).orderBy(str2, Query.Direction.DESCENDING).whereEqualTo("entryType", str2), str);
        }
        if (pageType) {
            return whereEqualTo;
        }
        if (limit != null) {
            if (!n.b(limit, "null")) {
                str5 = "locations";
                str4 = "{\n            query.whereArrayContains(\"locations\", location)\n        }";
                n.e(whereEqualTo.whereArrayContains(str5, limit), str4);
            } else {
                str5 = "global";
                str4 = "{\n            query.whereEqualTo(\"global\", true)\n        }";
                n.e(whereEqualTo.whereEqualTo(str5, Boolean.TRUE), str4);
            }
        }
        return whereArrayContains;
    }

    private static final ChallengeEntryModel r(j jVar) {
        n.f(jVar, "task");
        Object result = jVar.getResult();
        Object object = result.toObject(ChallengeEntryModel.class);
        n.d(object);
        String id = result.getId();
        n.e(id, "doc.id");
        object.setDocumentId(id);
        return object;
    }

    private static final ChallengeModel t(j jVar) {
        n.f(jVar, "task");
        return (ChallengeModel)(DocumentSnapshot)jVar.getResult().toObject(ChallengeModel.class);
    }

    private final void t0(String str) {
        this.adminList.p0(str);
        this.j.add(str);
    }

    private final void u0(String str) {
        this.adminList.r0(str);
        this.tracker.add(str);
    }

    private static final Map v(j jVar) {
        n.f(jVar, "task");
        HashMap hashMap = new HashMap();
        if ((DocumentSnapshot)jVar.getResult().exists()) {
            if ((DocumentSnapshot)jVar.getResult().getData() != null) {
                Map data = (DocumentSnapshot)jVar.getResult().getData();
                n.d(data);
                n.e(data, "task.result.data!!");
                hashMap.putAll(data);
            }
        }
        return hashMap;
    }

    private final void v0(String str) {
        this.adminList.s0(str);
        this.timeUtil.add(str);
    }

    private static final String x(j jVar) {
        n.f(jVar, "task");
        if (jVar.isSuccessful() && jVar.getResult() != null) {
            Object result2 = jVar.getResult();
            n.d(result2);
            if (result2.exists()) {
                Object result3 = jVar.getResult();
                n.d(result3);
                return result3.getString("text");
            }
        }
        return null;
    }

    /* renamed from: A0, reason: from kotlin metadata */
    public final void deleteChallengeEntry(String uid, String entryId, boolean challengeId) {
        n.f(uid, "userId");
        n.f(entryId, "entryId");
        HashMap hashMap = new HashMap();
        hashMap.put("following", Boolean.valueOf(challengeId));
        fetchUserLikeListForChallenge(FirestorePath.groupChallengeChatMessage.forUserId(uid).forEntryId(entryId), hashMap, true);
    }

    /* renamed from: B, reason: from kotlin metadata */
    public final j<Map<String, Map<String, Boolean>>> fetchAllChallenges(String locale, String location, boolean userAdmin) {
        CollectionReference collectionReference;
        Source cACHE2;
        n.f(locale, "userId");
        if (location != null) {
            str = "query.whereEqualTo(\"challengeId\", challengeId)";
            n.e(I(FirestorePath.likeDocs.forUserId(locale)).whereEqualTo("challengeId", location), str);
        }
        location = userAdmin ? Source.CACHE : Source.DEFAULT;
        j continueWith = collectionReference.get((userAdmin ? Source.CACHE : Source.DEFAULT)).continueWith((userAdmin ? Source.CACHE : Source.DEFAULT));
        n.e(continueWith, (userAdmin ? Source.CACHE : Source.DEFAULT));
        return continueWith;
    }

    /* renamed from: B0, reason: from kotlin metadata */
    public final void fetchUserEntries(String uid, String challengeId) {
        n.f(uid, "userId");
        n.f(challengeId, "entryId");
        HashMap hashMap = new HashMap();
        hashMap.put("isActive", Boolean.FALSE);
        hashMap.put("newEntryVotes", null);
        fetchUserLikeListForChallenge(FirestorePath.groupChallengeChatMessage.forUserId(uid).forEntryId(challengeId), hashMap, true);
    }

    /* renamed from: C0, reason: from kotlin metadata */
    public final j<Void> parseComment(f doc, String entryAuthor, Object entryId, Object... challengeId) {
        n.f(doc, "path");
        n.f(challengeId, "moreFieldsAndValues");
        n.d(entryAuthor);
        j update = K(doc).update(entryAuthor, entryId, Arrays.copyOf(challengeId, challengeId.length));
        n.e(update, "getDocumentReference(path).update(field!!, value, *moreFieldsAndValues)");
        return update;
    }

    /* renamed from: D, reason: from kotlin metadata */
    public final j<Map<String, Boolean>> fetchAllChallengesQuery(String locale, String location, boolean userAdmin) {
        Source cACHE2;
        n.f(locale, "userId");
        location = userAdmin ? Source.CACHE : Source.DEFAULT;
        j continueWith = I(FirestorePath.likeDocs.forUserId(locale)).whereEqualTo("entryId", location).get((userAdmin ? Source.CACHE : Source.DEFAULT)).continueWith((userAdmin ? Source.CACHE : Source.DEFAULT));
        n.e(continueWith, (userAdmin ? Source.CACHE : Source.DEFAULT));
        return continueWith;
    }

    public final void D0(ChallengeComment challengeComment) {
        n.f(challengeComment, "model");
        final String entryId = challengeComment.getEntryId();
        n.d(entryId);
        I(FirestorePath.comments.forEntryId(entryId)).add(challengeComment);
    }

    /* renamed from: E0, reason: from kotlin metadata */
    public final void upvoteChallengeEntry(String userId, ChallengeEntryModel entry, String userEntryId, String currentDogId, String appInstallationId, String photoId) {
        String photoId2;
        PhotoLikeModel photoLikeModel;
        Object entry2 = entry;
        userEntryId2 = userEntryId;
        Object currentDogId2 = currentDogId;
        photoId2 = photoId;
        n.f(userId, "userId");
        n.f(entry2, "entry");
        n.f(currentDogId2, "currentDogId");
        final String challengeId = entry.getChallengeId();
        photoId2 = entry.getDocumentId();
        String r9 = photoId2;
        final HashMap hashMap2 = new HashMap();
        final Boolean tRUE2 = Boolean.TRUE;
        hashMap2.put("hasUserLiked", Boolean.TRUE);
        hashMap2.put("date", FieldValue.serverTimestamp());
        hashMap2.put("dogId", currentDogId2);
        str = "appInstallationId";
        hashMap2.put("appInstallationId", appInstallationId);
        if (userEntryId2 != null) {
            str = "voterEntryId";
            hashMap2.put(str, userEntryId2);
        }
        if (photoId2 != null) {
            photoLikeModel = new PhotoLikeModel(photoId, photoId2, entry2.getImageUrlOf(photoId2), photoId2, challengeId);
            HashMap hashMap = new HashMap();
            hashMap.put(photoId2, Boolean.TRUE);
            dogId = "images";
            hashMap2.put(dogId, hashMap);
        } else {
            photoLikeModel = new PhotoLikeModel(photoId2, photoId2, imageUrl, dogId, challengeId);
        }
        boolean z = true;
        buildCommentPager(FirestorePath.likedPhotoDocs.forUserId(userId).forPhotoId(photoId2), photoLikeModel, z);
        fetchUserLikeListForChallenge(FirestorePath.entryVoteFromUser.forEntryId(photoId2).forUserId(userId), hashMap2, z);
    }

    /* renamed from: F, reason: from kotlin metadata */
    public final String generateExamId(String dogId, String trickId) {
        n.f(dogId, "dogId");
        n.f(trickId, "trickId");
        String id = this.b.collection("dogs").document(dogId).collection("exams").document(trickId).collection("history").document().getId();
        n.e(id, "rootDatabase\n            .collection(\"dogs\")\n            .document(dogId)\n            .collection(\"exams\")\n            .document(trickId)\n            .collection(\"history\")\n            .document().id");
        return id;
    }

    /* renamed from: F0, reason: from kotlin metadata */
    public final void fetchUserEntries(ChallengeComment uid, String challengeId, DogProfileModel listener) {
        n.f(uid, "model");
        String str2 = "userId";
        n.f(challengeId, str2);
        n.f(listener, "currentDog");
        HashMap hashMap = new HashMap();
        FieldValue serverTimestamp = FieldValue.serverTimestamp();
        n.e(serverTimestamp, "serverTimestamp()");
        hashMap.put("createdAt", serverTimestamp);
        HashMap hashMap2 = new HashMap();
        String documentId2 = uid.getDocumentId();
        n.d(documentId2);
        hashMap2.put(documentId2, Boolean.TRUE);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("commentOwnerUserId", uid.getUserId());
        hashMap3.put("commentOwnerDogId", uid.getDogId());
        hashMap3.put("entryOwnerUserId", uid.getEntryId());
        hashMap3.put("commentText", uid.getMessage());
        hashMap3.put("dogName", listener.getName());
        hashMap3.put("dogId", listener.getId());
        hashMap3.put(str2, challengeId);
        hashMap3.put("entryId", uid.getEntryId());
        String documentId = uid.getDocumentId();
        n.d(documentId);
        String entryId = uid.getEntryId();
        n.d(entryId);
        fetchUserLikeListForChallenge(FirestorePath.commentLikes.forCommentId(documentId).forUserId(challengeId).forEntryId(entryId), hashMap, false);
        String entryId2 = uid.getEntryId();
        n.d(entryId2);
        boolean z = true;
        fetchUserLikeListForChallenge(FirestorePath.commentVoteFromUser.forUserId(challengeId).forEntryId(entryId2), hashMap2, z);
        String documentId3 = uid.getDocumentId();
        n.d(documentId3);
        fetchUserLikeListForChallenge(FirestorePath.commentVoteFromUserExtended.forUserId(challengeId).forCommentId(documentId3), hashMap3, z);
    }

    /* renamed from: G, reason: from kotlin metadata */
    public final Set<String> refreshAdminList() {
        return this.reportedDogIds;
    }

    public final Set<String> H() {
        return this.reportedEntryIds;
    }

    /* renamed from: H0, reason: from kotlin metadata */
    public final j<Void> fetchUserLikeListForChallenge(f userId, Map<String, ? extends Object> challengeId, boolean cached) {
        j jVar;
        n.f(userId, "path");
        if (!cached) {
            n.d(challengeId);
            str = "{\n            getDocumentReference(path).set(data!!)\n        }";
            n.e(K(userId).set(challengeId), str);
        } else {
            n.d(challengeId);
            str = "{\n            getDocumentReference(path).set(data!!, SetOptions.merge())\n        }";
            n.e(K(userId).set(challengeId, SetOptions.merge()), str);
        }
        return jVar;
    }

    public final CollectionReference I(f fVar) {
        n.f(fVar, "path");
        CollectionReference collection = this.b.collection(fVar.getPath());
        n.e(collection, "rootDatabase.collection(path.path)");
        return collection;
    }

    /* renamed from: J, reason: from kotlin metadata */
    public final void getDocument(f path, e<DocumentSnapshot> listener) {
        n.f(path, "path");
        n.d(listener);
        K(path).get().addOnCompleteListener(listener);
    }

    public final DocumentReference K(f fVar) {
        n.f(fVar, "path");
        DocumentReference document = this.b.document(fVar.getPath());
        n.e(document, "rootDatabase.document(path.path)");
        return document;
    }

    public final m2.c L(f fVar) {
        n.f(fVar, "path");
        return new FirestoreService_QueryBuilder(this, fVar);
    }

    public final f.d.a.a<List<String>> M() {
        return this.rootDatabase;
    }

    /* renamed from: N, reason: from kotlin metadata */
    public final Query fetchUserLikeListForEntry(String userId, String entryId, int cached) {
        Query limit = I(FirestorePath.allEntries).whereEqualTo("author", userId).whereEqualTo("challengeId", entryId).limit((long)cached);
        n.e(limit, "getCollectionReference(FirestorePath.allEntries).whereEqualTo(\"author\", userId).whereEqualTo(\"challengeId\", challengeId).limit(maxEntries.toLong())");
        return limit;
    }

    public final void O(ChallengeComment challengeComment) {
        n.f(challengeComment, "comment");
        HashMap hashMap = new HashMap();
        hashMap.put("published", Boolean.FALSE);
        hashMap.put("marked", "spam");
        String entryId = challengeComment.getEntryId();
        n.d(entryId);
        String documentId = challengeComment.getDocumentId();
        n.d(documentId);
        K(FirestorePath.comment.forEntryId(entryId).forCommentId(documentId)).update(hashMap);
    }

    /* renamed from: P, reason: from kotlin metadata */
    public final boolean getUserEntriesQuery(ChallengeComment userId, String challengeId, boolean maxEntries) {
        String dogId;
        boolean z;
        String documentId;
        boolean z2 = false;
        boolean entryAuthor;
        n.f(userId, "item");
        dogId = "currentUserId";
        n.f(challengeId, dogId);
        if (!maxEntries) {
            if (!p.N(this.j, userId.getDocumentId())) {
                userId = isDogReported(userId.getDogId(), maxEntries) && !userId.isEntryAuthor(challengeId) && !userId.isCommentAuthor(challengeId) ? 1 : 0;
            }
        }
        return (isDogReported(userId.getDogId(), maxEntries) && !userId.isEntryAuthor(challengeId) && !userId.isCommentAuthor(challengeId) ? 1 : 0);
    }

    /* renamed from: Q, reason: from kotlin metadata */
    public final boolean isDogReported(String dogId, boolean isAdmin) {
        boolean z = true;
        boolean contains;
        n.f(dogId, "dogId");
        if (!isAdmin) {
            if (this.tracker.contains(dogId)) {
                dogId = !this.fbDatabase.A().m().containsKey(dogId) ? 1 : 0;
            }
        }
        return (!this.fbDatabase.A().m().containsKey(dogId) ? 1 : 0);
    }

    /* renamed from: R, reason: from kotlin metadata */
    public final boolean isCommentReported(ChallengeEntryModel item, String currentUserId, boolean isAdmin) {
        String dogId;
        boolean contains;
        String documentId;
        boolean z = false;
        boolean dogReported;
        n.f(item, "item");
        dogId = "currentUserId";
        n.f(currentUserId, dogId);
        if (!isAdmin) {
            if (!this.timeUtil.contains(item.getDocumentId())) {
                if (item.getDogId() == null) {
                    dogId = "";
                }
                item = isDogReported(dogId, isAdmin) && item.getAuthor() != currentUserId ? 1 : 0;
            }
        }
        return (isDogReported(dogId, isAdmin) && item.getAuthor() != currentUserId ? 1 : 0);
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final List<String> unvoteEntryComment(String model, boolean userId) {
        boolean z;
        final ArrayList arrayList = new ArrayList();
        if (p.N(this.reportedDogIds, model)) {
            arrayList.add("ambassador");
        }
        if (userId) {
            arrayList.add("premium");
        }
        return arrayList;
    }

    /* renamed from: b, reason: from kotlin metadata */
    public final m2.b isEntryReported(String item, int currentUserId, int isAdmin) {
        n.f(item, "entryId");
        Query orderBy = I(FirestorePath.comments.forEntryId(item)).orderBy("date", Query.Direction.DESCENDING);
        n.e(orderBy, "getCollectionReference(FirestorePath.comments.forEntryId(entryId)).orderBy(\"date\", Query.Direction.DESCENDING)");
        return reportChallengeEntry(orderBy, currentUserId, isAdmin);
    }

    /* renamed from: c, reason: from kotlin metadata */
    public final m2.b reportChallengeEntry(Query entryId, int userId, int reportReason) {
        n.f(entryId, "query");
        FirestoreService_FirestorePager firestoreService_FirestorePager = new FirestoreService_FirestorePager(this, entryId, userId, reportReason, null, 0, 0L, z, 0, 120, 0);
        return firestoreService_FirestorePager;
    }

    /* renamed from: d, reason: from kotlin metadata */
    public final ListenerRegistration buildNewCommentListener(String userId, String entryId, boolean isAdmin, String entryAuthorId, String challengeId, long startPointTimestamp, app.dogo.com.dogo_android.util.n0.u<List<ChallengeComment>> callback) {
        n.f(userId, "userId");
        n.f(entryId, "entryId");
        final Object obj = callback;
        n.f(obj, "callback");
        String str6 = "date";
        final Query orderBy = I(FirestorePath.comments.forEntryId(entryId)).whereGreaterThan(str6, new Date(startPointTimestamp, r2)).orderBy(str6, Query.Direction.DESCENDING);
        n.e(orderBy, "getCollectionReference(FirestorePath.comments.forEntryId(entryId))\n            .whereGreaterThan(\"date\", datePoint).orderBy(\"date\", Query.Direction.DESCENDING)");
        d1 d1Var = new d1(this, entryAuthorId, entryId, challengeId, obj, userId, isAdmin);
        ListenerRegistration snapshotListener = orderBy.addSnapshotListener(d1Var);
        n.e(snapshotListener, "query.addSnapshotListener { queryDocumentSnapshots: QuerySnapshot?, e: FirebaseFirestoreException? ->\n            var newDocCount = 0\n            if (queryDocumentSnapshots != null && queryDocumentSnapshots.documentChanges.isNotEmpty()) {\n                val commentList: MutableList<ChallengeComment> = arrayListOf()\n                for (documentChange in queryDocumentSnapshots.documentChanges) {\n                    // new comment comming from the database\n                    if (documentChange.type == DocumentChange.Type.ADDED) {\n                        val document: DocumentSnapshot = documentChange.document\n                        val model = parseComment(document, entryAuthorId, entryId, challengeId)\n                        if (model.isPublished || model.isSpam) {\n                            commentList.add(model)\n                            newDocCount++\n                        }\n                    }\n                    // user comment update\n                    if (documentChange.type == DocumentChange.Type.MODIFIED && !documentChange.document.metadata.hasPendingWrites()) {\n                        val document: DocumentSnapshot = documentChange.document\n                        val model = parseComment(document, entryAuthorId, entryId, challengeId)\n                        if (model.isPublished || model.isSpam) {\n                            commentList.add(model)\n                        }\n                    }\n                }\n                if (commentList.isNotEmpty()) {\n                    callback.onObjectCallback(commentList.filter { !isCommentReported(it, userId, isAdmin) || userId == it.entryOwnerUserId }, newDocCount)\n                }\n            }\n        }");
        return snapshotListener;
    }

    /* renamed from: f, reason: from kotlin metadata */
    public final void updateChatNotificationState(ChallengeEntryModel userId, int entryId) {
        n.f(userId, "model");
        HashMap hashMap = new HashMap();
        if (userId.isLatestPhoto(entryId)) {
            str = "date";
            hashMap.put(str, userId.getPhotoCreationTimestamp(1));
        }
        hashMap.put(n.o("images.", userId.getImageIdAt(entryId)), FieldValue.delete());
        hashMap.put("updatedAt", FieldValue.serverTimestamp());
        K(FirestorePath.entry.forEntryId(userId.getDocumentId())).update(hashMap);
        userId.removePhoto(entryId);
    }

    /* renamed from: g, reason: from kotlin metadata */
    public final void reportChallengeProfile(String dogId, String reporterUserId, String entryIds) {
        n.f(dogId, "uid");
        n.f(reporterUserId, "entryId");
        n.f(entryIds, "challengeId");
        f entry2 = FirestorePath.entry;
        parseComment(entry2.forEntryId(reporterUserId), "isBeingDeleted", Boolean.TRUE, new Object[0]);
        saveReportedEntryId(entry2.forEntryId(reporterUserId));
        this.fbDatabase.U(entryIds);
        this.c.logEvent(E_Challenges.u);
    }

    public final void h(ChallengeComment challengeComment) {
        n.f(challengeComment, "comment");
        final String entryId = challengeComment.getEntryId();
        n.d(entryId);
        String documentId = challengeComment.getDocumentId();
        n.d(documentId);
        K(FirestorePath.comment.forEntryId(entryId).forCommentId(documentId)).delete();
    }

    /* renamed from: h0, reason: from kotlin metadata */
    public final ChallengeComment reportComment(DocumentSnapshot commentId, String userId, String entryId, String reportReason) {
        n.f(commentId, "doc");
        Object object = commentId.toObject(ChallengeComment.class);
        n.d(object);
        final String id = commentId.getId();
        n.e(id, "doc.id");
        object.setDocumentId(id);
        object.setEntryAuthor(userId);
        object.setEntryId(entryId);
        object.setChallengeId(reportReason);
        return object;
    }

    public final void i0() {
        I(FirestorePath.admins).get().addOnSuccessListener(new y0(this)).addOnFailureListener(u0.a);
    }

    public final void l0() {
        I(FirestorePath.ambassadors).get().addOnSuccessListener(new c1(this)).addOnFailureListener(b1.a);
    }

    public final j<QuerySnapshot> m(String str) {
        j jVar = I(FirestorePath.allEntries).whereEqualTo("dogId", str).whereEqualTo("published", Boolean.TRUE).orderBy("date", Query.Direction.DESCENDING).get();
        n.e(jVar, "getCollectionReference(FirestorePath.allEntries)\n            .whereEqualTo(\"dogId\", dogId)\n            .whereEqualTo(\"published\", true)\n            .orderBy(\"date\", Query.Direction.DESCENDING)\n            .get()");
        return jVar;
    }

    /* renamed from: n, reason: from kotlin metadata */
    public final j<List<ChallengeModel>> startListeningToArchivedNotificationBranch(String userId, String limit, boolean listener) {
        j continueWith = buildFirestorePager(LocaleService.e(userId), limit, listener).get().continueWith(h1.a);
        n.e(continueWith, "fetchAllChallengesQuery(validatedLocale, location, userAdmin).get().continueWith { task: Task<QuerySnapshot> ->\n            val challenges: MutableList<ChallengeModel> = ArrayList()\n            for (doc in task.result.documents) {\n                val challengeModel = doc.toObject(ChallengeModel::class.java)\n                if (challengeModel != null && ChallengeModel.SUPPORTED_ENTRY_TYPES.contains(challengeModel.mediaType)) {\n                    challenges.add(challengeModel)\n                }\n            }\n            challenges\n        }");
        return continueWith;
    }

    /* renamed from: o0, reason: from kotlin metadata */
    public final void startListeningToFollowedNotificationBranch(String userId, String limit, String listener) {
        String str;
        n.f(userId, "entryId");
        n.f(limit, "userId");
        HashMap hashMap = new HashMap();
        FieldValue serverTimestamp = FieldValue.serverTimestamp();
        n.e(serverTimestamp, "serverTimestamp()");
        hashMap.put("date", serverTimestamp);
        if (listener == null) {
            str = "";
        }
        hashMap.put("reason", str);
        fetchUserLikeListForChallenge(FirestorePath.entryReport.forEntryId(userId).forUserId(limit), hashMap, false);
        this.c.logEvent(E_Challenges.v.withParameters(u.a(new EP_EntryId(), userId)));
        v0(userId);
        this.rootDatabase.postValue(p.b(userId));
    }

    /* renamed from: p0, reason: from kotlin metadata */
    public final void unvoteChallengeEntry(String userId, String entry, List<String> photoId) {
        final String str = "dogId";
        n.f(userId, str);
        final String str2 = "reporterUserId";
        n.f(entry, str2);
        n.f(photoId, "entryIds");
        kotlin.o oVar = u.a(new EP_DogId(), userId);
        this.c.logEvent(E_Challenges.a.withParameters(oVar));
        HashMap hashMap = new HashMap();
        hashMap.put("timestamp", Long.valueOf(this.e.g()));
        hashMap.put(str, userId);
        hashMap.put(str2, entry);
        I(FirestorePath.challengeProfileReport).add(hashMap);
        u0(userId);
        this.rootDatabase.postValue(photoId);
    }

    public final j<ChallengeEntryModel> q(String str) {
        n.f(str, "entryId");
        j continueWith = K(FirestorePath.entry.forEntryId(str)).get().continueWith(e1.a);
        n.e(continueWith, "getDocumentReference(FirestorePath.entry.forEntryId(entryId)).get().continueWith { task: Task<DocumentSnapshot> ->\n            val doc = task.result\n            val model = doc.toObject(ChallengeEntryModel::class.java)\n            model!!.setDocumentId(doc.id)\n            model\n        }");
        return continueWith;
    }

    /* renamed from: q0, reason: from kotlin metadata */
    public final void updateDocument(String path, String field, String value, String moreFieldsAndValues) {
        String str;
        n.f(path, "commentId");
        n.f(field, "userId");
        n.f(value, "entryId");
        this.c.logEvent(E_Challenges.f.withParameters(u.a(new EP_Id(), path), u.a(new EP_EntryId(), value)));
        HashMap hashMap = new HashMap();
        FieldValue serverTimestamp = FieldValue.serverTimestamp();
        n.e(serverTimestamp, "serverTimestamp()");
        hashMap.put("date", serverTimestamp);
        if (moreFieldsAndValues == null) {
            str = "";
        }
        hashMap.put("reason", str);
        K(FirestorePath.commentReports.forCommentId(path).forUserId(field).forEntryId(value)).set(hashMap);
        t0(path);
    }

    public final void r0(String str) {
        n.f(str, "entryId");
        int i = 0;
        K(FirestorePath.entry.forEntryId(str)).update("uploadStatus", Integer.valueOf(i), new Object[i]);
    }

    public final j<ChallengeModel> s(String str, String str2) {
        n.f(str, "challengeId");
        j continueWith = K(FirestorePath.localisedChallenges.forChallengeId(str).forLocale(LocaleService.e(str2))).get().continueWith(g1.a);
        n.e(continueWith, "getDocumentReference(FirestorePath.localisedChallenges.forChallengeId(challengeId).forLocale(validatedLocale)).get().continueWith { task: Task<DocumentSnapshot> -> task.result.toObject(ChallengeModel::class.java) }");
        return continueWith;
    }

    public final void s0(String str) {
        n.f(str, "documentId");
        K(FirestorePath.entry.forEntryId(str)).update("date", new Date(System.currentTimeMillis() - (Utilities_TimeUnit.DAYS.getThreshold() * (long)2), r2), new Object[0]);
    }

    public final j<Map<String, Object>> u(String str, String str2) {
        n.f(str, "entryId");
        n.f(str2, "userId");
        j continueWith = K(FirestorePath.commentVoteFromUser.forUserId(str2).forEntryId(str)).get().continueWith(w0.a);
        n.e(continueWith, "getDocumentReference(FirestorePath.commentVoteFromUser.forUserId(userId).forEntryId(entryId)).get().continueWith { task: Task<DocumentSnapshot> ->\n            val likedEntries: MutableMap<String, Any> = HashMap()\n            if (task.result.exists() && task.result.data != null) {\n                likedEntries.putAll(task.result.data!!)\n            }\n            likedEntries\n        }");
        return continueWith;
    }

    public final j<String> w(f fVar) {
        n.f(fVar, "localeDataPath");
        j continueWith = K(fVar).get().continueWith(x0.a);
        n.e(continueWith, "getDocumentReference(localeDataPath).get()\n            .continueWith { task: Task<DocumentSnapshot?> ->\n                if (task.isSuccessful && task.result != null && task.result!!.exists()) {\n                    return@continueWith task.result!!.getString(\"text\")\n                } else {\n                    return@continueWith null\n                }\n            }");
        return continueWith;
    }

    /* renamed from: w0, reason: from kotlin metadata */
    public final ListenerRegistration updateChatNotificationFollowState(String userId, int entryId, EventListener<QuerySnapshot> followState) {
        n.f(userId, "userId");
        n.f(followState, "listener");
        ListenerRegistration snapshotListener = I(FirestorePath.allGroupChallengeChat.forUserId(userId)).limit((long)entryId).orderBy("sortingDate", Query.Direction.DESCENDING).whereEqualTo("following", Boolean.FALSE).whereEqualTo("entryPublished", Boolean.TRUE).whereEqualTo("notificationType", "challengesComment").addSnapshotListener(followState);
        n.e(snapshotListener, "getCollectionReference(FirestorePath.allGroupChallengeChat.forUserId(userId))\n            .limit(limit.toLong())\n            .orderBy(\"sortingDate\", Query.Direction.DESCENDING)\n            .whereEqualTo(\"following\", false)\n            .whereEqualTo(\"entryPublished\", true)\n            .whereEqualTo(\"notificationType\", \"challengesComment\")\n            .addSnapshotListener(listener)");
        return snapshotListener;
    }

    /* renamed from: x0, reason: from kotlin metadata */
    public final ListenerRegistration upvoteEntryComment(String model, int userId, EventListener<QuerySnapshot> currentDog) {
        n.f(model, "userId");
        n.f(currentDog, "listener");
        Boolean tRUE2 = Boolean.TRUE;
        ListenerRegistration snapshotListener = I(FirestorePath.allGroupChallengeChat.forUserId(model)).limit((long)userId).orderBy("sortingDate", Query.Direction.DESCENDING).whereEqualTo("following", tRUE2).whereEqualTo("entryPublished", tRUE2).whereEqualTo("notificationType", "challengesComment").addSnapshotListener(currentDog);
        n.e(snapshotListener, "getCollectionReference(FirestorePath.allGroupChallengeChat.forUserId(userId))\n            .limit(limit.toLong())\n            .orderBy(\"sortingDate\", Query.Direction.DESCENDING)\n            .whereEqualTo(\"following\", true)\n            .whereEqualTo(\"entryPublished\", true)\n            .whereEqualTo(\"notificationType\", \"challengesComment\")\n            .addSnapshotListener(listener)");
        return snapshotListener;
    }

    public final j<List<ChallengeEntryModel>> y(String str, String str2) {
        j continueWith = I(FirestorePath.allEntries).whereEqualTo("author", str).whereEqualTo("challengeId", str2).get().continueWith(i1.a);
        n.e(continueWith, "getCollectionReference(FirestorePath.allEntries)\n            .whereEqualTo(\"author\", uid)\n            .whereEqualTo(\"challengeId\", challengeId)\n            .get().continueWith { querySnapshot: Task<QuerySnapshot> ->\n                val userEntryList: MutableList<ChallengeEntryModel?> = ArrayList()\n                for (doc in querySnapshot.result) {\n                    val model = doc.toObject(ChallengeEntryModel::class.java)\n                    model.setDocumentId(doc.id)\n                    userEntryList.add(model)\n                }\n                userEntryList\n            }");
        return continueWith;
    }

    /* renamed from: y0, reason: from kotlin metadata */
    public final void writeToDocument(String path, ChallengeEntryModel data, String merge) {
        String documentId;
        n.f(path, "userId");
        n.f(data, "entry");
        f forUserId = FirestorePath.entryVoteFromUser.forEntryId(data.getDocumentId()).forUserId(path);
        if (merge != null) {
            Object merge2 = merge;
        }
        if (merge != null) {
            HashMap hashMap2 = new HashMap();
            HashMap hashMap = new HashMap();
            hashMap.put(merge, Boolean.FALSE);
            hashMap2.put("images", hashMap);
            boolean z = true;
            fetchUserLikeListForChallenge(forUserId, hashMap2, z);
        } else {
            saveReportedEntryId(forUserId);
        }
        saveReportedEntryId(FirestorePath.likedPhotoDocs.forUserId(path).forPhotoId(documentId));
    }

    /* renamed from: z, reason: from kotlin metadata */
    public final ListenerRegistration writeToDocument(String path, String data, EventListener<QuerySnapshot> merge) {
        n.f(path, "uid");
        n.f(merge, "listener");
        app.dogo.com.dogo_android.service.m2.c cVar = L(FirestorePath.allEntries);
        cVar.forAuthor(path);
        if (data != null) {
            cVar.forChallenge(data);
        }
        ListenerRegistration snapshotListener = cVar.build().addSnapshotListener(merge);
        n.e(snapshotListener, "queryBuilder.build().addSnapshotListener(listener)");
        return snapshotListener;
    }

    public final void z0(ChallengeComment challengeComment, String str) {
        n.f(challengeComment, "model");
        n.f(str, "userId");
        HashMap hashMap = new HashMap();
        String documentId = challengeComment.getDocumentId();
        n.d(documentId);
        FieldValue delete = FieldValue.delete();
        n.e(delete, "delete()");
        hashMap.put(documentId, delete);
        String entryId = challengeComment.getEntryId();
        n.d(entryId);
        saveReportedEntryId(FirestorePath.commentLikes.forCommentId(documentId).forUserId(str).forEntryId(entryId));
        fetchUserLikeListForChallenge(FirestorePath.commentVoteFromUser.forUserId(str).forEntryId(entryId), hashMap, true);
    }


    /* renamed from: S, reason: from kotlin metadata */
    public static /* synthetic */ void fetchAllChallengeEntriesForDog(Exception dogId) {
        FirestoreService.k0(dogId);
    }

    /* renamed from: T, reason: from kotlin metadata */
    public static /* synthetic */ void fetchChallengeEntry(Exception entryId) {
        FirestoreService.l(entryId);
    }

    /* renamed from: U, reason: from kotlin metadata */
    public static /* synthetic */ Map fetchTranslationText(j localeDataPath) {
        return FirestoreService.v(localeDataPath);
    }

    /* renamed from: V, reason: from kotlin metadata */
    public static /* synthetic */ String getAllDogExams(j dogId) {
        return FirestoreService.x(dogId);
    }

    /* renamed from: W, reason: from kotlin metadata */
    public static /* synthetic */ void buildBadgeList(m2 dogId, QuerySnapshot isPremium) {
        FirestoreService.fetchChallengeModel(dogId, isPremium);
    }

    /* renamed from: X, reason: from kotlin metadata */
    public static /* synthetic */ void getCollectionReference(Exception path) {
        FirestoreService.n0(path);
    }

    /* renamed from: Y, reason: from kotlin metadata */
    public static /* synthetic */ void deleteChallengeEntriesPhoto(m2 model, QuerySnapshot photoPosition) {
        FirestoreService.fetchLikeListForEntriesComments(model, photoPosition);
    }

    public static /* synthetic */ void Z(m2 m2Var, String str, String str2, String str3, app.dogo.com.dogo_android.util.n0.u uVar, String str4, boolean z, QuerySnapshot querySnapshot, FirebaseFirestoreException exc) {
        FirestoreService.e(m2Var, str, str2, str3, uVar, str4, z, querySnapshot, exc);
    }

    /* renamed from: a0, reason: from kotlin metadata */
    public static /* synthetic */ ChallengeEntryModel getDocumentReference(j path) {
        return FirestoreService.r(path);
    }

    /* renamed from: b0, reason: from kotlin metadata */
    public static /* synthetic */ void getQuery(Void path) {
        FirestoreService.k(path);
    }

    /* renamed from: c0, reason: from kotlin metadata */
    public static /* synthetic */ ChallengeModel hideComment(j comment) {
        return FirestoreService.t(comment);
    }

    /* renamed from: d0, reason: from kotlin metadata */
    public static /* synthetic */ List revertPhotoUploadState(j entryId) {
        return FirestoreService.o(entryId);
    }

    /* renamed from: e0, reason: from kotlin metadata */
    public static /* synthetic */ List rollBackEntry48Hours(j documentId) {
        return FirestoreService.deleteComment(documentId);
    }

    /* renamed from: f0, reason: from kotlin metadata */
    public static /* synthetic */ Map saveReportedCommentId(j commentId) {
        return FirestoreService.deleteDocument(commentId);
    }

    /* renamed from: g0, reason: from kotlin metadata */
    public static /* synthetic */ Map saveReportedDogId(j dogId) {
        return FirestoreService.deleteDocument(dogId);
    }

    private static final void k(Void void) {
    }

    private static final void l(Exception exc) {
    }
}
