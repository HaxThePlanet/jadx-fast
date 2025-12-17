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
import app.dogo.com.dogo_android.util.n0.u;
import app.dogo.com.dogo_android.v.c;
import app.dogo.com.dogo_android.w.h1;
import app.dogo.com.dogo_android.w.i1;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q1;
import app.dogo.com.dogo_android.w.u;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.w.v2;
import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.g;
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
import f.d.a.a;
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
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.u;
import kotlin.y.p;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0082\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0010!\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010$\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008$\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u0000 ¡\u00012\u00020\u0001:\u0006¡\u0001¢\u0001£\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u001e\u0010#\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u00162\u0008\u0010$\u001a\u0004\u0018\u00010\u000b2\u0006\u0010%\u001a\u00020&J\"\u0010'\u001a\u00060(R\u00020\u00002\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+J\"\u0010-\u001a\u00060(R\u00020\u00002\u0006\u0010.\u001a\u00020/2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+JN\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000b2\u0006\u00103\u001a\u00020&2\u0008\u00104\u001a\u0004\u0018\u00010\u000b2\u0008\u00105\u001a\u0004\u0018\u00010\u000b2\u0006\u00106\u001a\u0002072\u0012\u00108\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020:0\u001609J\u0016\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020+J\u001e\u0010@\u001a\u00020<2\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000bJ\u000e\u0010B\u001a\u00020<2\u0006\u0010C\u001a\u00020:J\u0010\u0010D\u001a\u00020<2\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010D\u001a\u00020<2\u0006\u0010G\u001a\u00020HH\u0002J\u0016\u0010I\u001a\u0008\u0012\u0004\u0012\u00020K0J2\u0008\u0010$\u001a\u0004\u0018\u00010\u000bJ.\u0010L\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020M0\u00160J2\u0008\u0010N\u001a\u0004\u0018\u00010\u000b2\u0008\u0010O\u001a\u0004\u0018\u00010\u000b2\u0006\u0010P\u001a\u00020&J\"\u0010Q\u001a\u00020/2\u0006\u0010N\u001a\u00020\u000b2\u0008\u0010O\u001a\u0004\u0018\u00010\u000b2\u0006\u0010P\u001a\u00020&H\u0002J\u0016\u0010R\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010>0J2\u0006\u0010)\u001a\u00020\u000bJ \u0010S\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010M0J2\u0006\u00105\u001a\u00020\u000b2\u0008\u0010N\u001a\u0004\u0018\u00010\u000bJ(\u0010T\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010U0J2\u0006\u0010)\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000bJ\u0014\u0010V\u001a\u0008\u0012\u0004\u0012\u00020\u000b0J2\u0006\u0010W\u001a\u00020FJ&\u0010X\u001a\u0002012\u0006\u0010A\u001a\u00020\u000b2\u0008\u00105\u001a\u0004\u0018\u00010\u000b2\u000c\u0010Y\u001a\u0008\u0012\u0004\u0012\u00020K0ZJ(\u0010X\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010>0\u00160J2\u0008\u0010A\u001a\u0004\u0018\u00010\u000b2\u0008\u00105\u001a\u0004\u0018\u00010\u000bJ>\u0010[\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020&0U0U0J2\u0006\u00102\u001a\u00020\u000b2\u0008\u00105\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\\\u001a\u00020&J2\u0010]\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020&0U0J2\u0006\u00102\u001a\u00020\u000b2\u0008\u0010)\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\\\u001a\u00020&J\u0016\u0010^\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010_\u001a\u00020\u000bJ\u001a\u0010`\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020b0\u00160a2\u0006\u0010$\u001a\u00020\u000bJ\u000e\u0010c\u001a\u00020d2\u0006\u0010E\u001a\u00020FJ \u0010e\u001a\u00020<2\u0006\u0010E\u001a\u00020F2\u0010\u0010Y\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010g\u0018\u00010fJ\u000e\u0010h\u001a\u00020H2\u0006\u0010E\u001a\u00020FJ\u0012\u0010i\u001a\u00060jR\u00020\u00002\u0006\u0010E\u001a\u00020FJ\"\u0010k\u001a\u00020/2\u0008\u00102\u001a\u0004\u0018\u00010\u000b2\u0008\u00105\u001a\u0004\u0018\u00010\u000b2\u0006\u0010l\u001a\u00020+J\u000e\u0010m\u001a\u00020<2\u0006\u0010C\u001a\u00020:J\u001e\u0010n\u001a\u00020&2\u0006\u0010o\u001a\u00020:2\u0006\u0010p\u001a\u00020\u000b2\u0006\u00103\u001a\u00020&J\u0016\u0010q\u001a\u00020&2\u0006\u0010$\u001a\u00020\u000b2\u0006\u00103\u001a\u00020&J\u001e\u0010r\u001a\u00020&2\u0006\u0010o\u001a\u00020>2\u0006\u0010p\u001a\u00020\u000b2\u0006\u00103\u001a\u00020&J,\u0010s\u001a\u00020:2\u0006\u0010t\u001a\u00020g2\u0008\u0010u\u001a\u0004\u0018\u00010\u000b2\u0008\u0010)\u001a\u0004\u0018\u00010\u000b2\u0008\u00105\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010v\u001a\u00020<J\u0006\u0010w\u001a\u00020<J \u0010x\u001a\u00020<2\u0006\u0010)\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0008\u0010y\u001a\u0004\u0018\u00010\u000bJ$\u0010z\u001a\u00020<2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010{\u001a\u00020\u000b2\u000c\u0010|\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u0016J(\u0010}\u001a\u00020<2\u0006\u0010~\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000b2\u0008\u0010y\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u007f\u001a\u00020<2\u0006\u0010)\u001a\u00020\u000bJ\u0010\u0010\u0080\u0001\u001a\u00020<2\u0007\u0010\u0081\u0001\u001a\u00020\u000bJ\u0011\u0010\u0082\u0001\u001a\u00020<2\u0006\u0010~\u001a\u00020\u000bH\u0002J\u0011\u0010\u0083\u0001\u001a\u00020<2\u0006\u0010$\u001a\u00020\u000bH\u0002J\u0011\u0010\u0084\u0001\u001a\u00020<2\u0006\u0010)\u001a\u00020\u000bH\u0002J%\u0010\u0085\u0001\u001a\u0002012\u0006\u00102\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+2\u000c\u0010Y\u001a\u0008\u0012\u0004\u0012\u00020K0ZJ%\u0010\u0086\u0001\u001a\u0002012\u0006\u00102\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+2\u000c\u0010Y\u001a\u0008\u0012\u0004\u0012\u00020K0ZJ#\u0010\u0087\u0001\u001a\u00020<2\u0006\u00102\u001a\u00020\u000b2\u0007\u0010\u0088\u0001\u001a\u00020>2\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u000bJ\u0017\u0010\u008a\u0001\u001a\u00020<2\u0006\u0010=\u001a\u00020:2\u0006\u00102\u001a\u00020\u000bJ \u0010\u008b\u0001\u001a\u00020<2\u0006\u00102\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000b2\u0007\u0010\u008c\u0001\u001a\u00020&J\u0017\u0010\u008d\u0001\u001a\u00020<2\u0006\u00102\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000bJL\u0010\u008e\u0001\u001a\t\u0012\u0005\u0012\u00030\u008f\u00010J2\u0006\u0010E\u001a\u00020F2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u00012\u0018\u0010\u0092\u0001\u001a\r\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u00010\u0093\u0001\"\u0004\u0018\u00010\u0001¢\u0006\u0003\u0010\u0094\u0001J\u000f\u0010\u0095\u0001\u001a\u00020<2\u0006\u0010=\u001a\u00020:JB\u0010\u0096\u0001\u001a\u00020<2\u0006\u00102\u001a\u00020\u000b2\u0007\u0010\u0088\u0001\u001a\u00020>2\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u000b2\u0007\u0010\u0098\u0001\u001a\u00020\u000b2\t\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u000bJ!\u0010\u009a\u0001\u001a\u00020<2\u0006\u0010=\u001a\u00020:2\u0006\u00102\u001a\u00020\u000b2\u0008\u0010\u009b\u0001\u001a\u00030\u009c\u0001J-\u0010\u009d\u0001\u001a\t\u0012\u0005\u0012\u00030\u008f\u00010J2\u0006\u0010E\u001a\u00020F2\n\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u00012\u0007\u0010 \u0001\u001a\u00020&H\u0002J8\u0010\u009d\u0001\u001a\t\u0012\u0005\u0012\u00030\u008f\u00010J2\u0006\u0010E\u001a\u00020F2\u0017\u0010\u009e\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010U2\u0007\u0010 \u0001\u001a\u00020&R\u0018\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R \u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0012\u0010\u000e\"\u0004\u0008\u0013\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000b0\u00160\u0015¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006¤\u0001", d2 = {"Lapp/dogo/com/dogo_android/service/FirestoreService;", "", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "fbDatabase", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "sharedPreferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "(Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/UserLocalCacheService;Lapp/dogo/com/dogo_android/service/PreferenceService;)V", "adminList", "", "", "ambassadorDogsList", "getAmbassadorDogsList", "()Ljava/util/Set;", "setAmbassadorDogsList", "(Ljava/util/Set;)V", "ambassadorList", "getAmbassadorList", "setAmbassadorList", "removeEntryEvent", "Lcom/hadilq/liveevent/LiveEvent;", "", "getRemoveEntryEvent", "()Lcom/hadilq/liveevent/LiveEvent;", "reportedCommentIds", "", "reportedDogIds", "reportedEntryIds", "rootDatabase", "Lcom/google/firebase/firestore/FirebaseFirestore;", "getSharedPreferenceService", "()Lapp/dogo/com/dogo_android/service/PreferenceService;", "timeUtil", "Lapp/dogo/com/dogo_android/service/Utilities;", "buildBadgeList", "dogId", "isPremium", "", "buildCommentPager", "Lapp/dogo/com/dogo_android/service/FirestoreService$FirestorePager;", "entryId", "limit", "", "pageType", "buildFirestorePager", "query", "Lcom/google/firebase/firestore/Query;", "buildNewCommentListener", "Lcom/google/firebase/firestore/ListenerRegistration;", "userId", "isAdmin", "entryAuthorId", "challengeId", "startPointTimestamp", "", "callback", "Lapp/dogo/com/dogo_android/util/recycle_views/SimpleObjectCallback;", "Lapp/dogo/com/dogo_android/model/ChallengeComment;", "deleteChallengeEntriesPhoto", "", "model", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "photoPosition", "deleteChallengeEntry", "uid", "deleteComment", "comment", "deleteDocument", "path", "Lapp/dogo/com/dogo_android/enums/FirestorePath;", "document", "Lcom/google/firebase/firestore/DocumentReference;", "fetchAllChallengeEntriesForDog", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/firebase/firestore/QuerySnapshot;", "fetchAllChallenges", "Lapp/dogo/com/dogo_android/model/ChallengeModel;", "locale", "location", "userAdmin", "fetchAllChallengesQuery", "fetchChallengeEntry", "fetchChallengeModel", "fetchLikeListForEntriesComments", "", "fetchTranslationText", "localeDataPath", "fetchUserEntries", "listener", "Lcom/google/firebase/firestore/EventListener;", "fetchUserLikeListForChallenge", "cached", "fetchUserLikeListForEntry", "generateExamId", "trickId", "getAllDogExams", "Lio/reactivex/Single;", "Lapp/dogo/com/dogo_android/model/ExamModel;", "getCollectionReference", "Lcom/google/firebase/firestore/CollectionReference;", "getDocument", "Lcom/google/android/gms/tasks/OnCompleteListener;", "Lcom/google/firebase/firestore/DocumentSnapshot;", "getDocumentReference", "getQuery", "Lapp/dogo/com/dogo_android/service/FirestoreService$QueryBuilder;", "getUserEntriesQuery", "maxEntries", "hideComment", "isCommentReported", "item", "currentUserId", "isDogReported", "isEntryReported", "parseComment", "doc", "entryAuthor", "refreshAdminList", "refreshAmbassadorDogsList", "reportChallengeEntry", "reportReason", "reportChallengeProfile", "reporterUserId", "entryIds", "reportComment", "commentId", "revertPhotoUploadState", "rollBackEntry48Hours", "documentId", "saveReportedCommentId", "saveReportedDogId", "saveReportedEntryId", "startListeningToArchivedNotificationBranch", "startListeningToFollowedNotificationBranch", "unvoteChallengeEntry", "entry", "photoId", "unvoteEntryComment", "updateChatNotificationFollowState", "followState", "updateChatNotificationState", "updateDocument", "Ljava/lang/Void;", "field", "value", "moreFieldsAndValues", "", "(Lapp/dogo/com/dogo_android/enums/FirestorePath;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Lcom/google/android/gms/tasks/Task;", "uploadComment", "upvoteChallengeEntry", "userEntryId", "currentDogId", "appInstallationId", "upvoteEntryComment", "currentDog", "Lapp/dogo/com/dogo_android/model/DogProfileModel;", "writeToDocument", "data", "Lapp/dogo/com/dogo_android/util/base_classes/FirestoreCustomObject;", "merge", "Companion", "FirestorePager", "QueryBuilder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class m2 {

    public static final app.dogo.com.dogo_android.service.m2.a Companion;
    private final app.dogo.com.dogo_android.service.p2 a;
    private final FirebaseFirestore b;
    private final o3 c;
    private final app.dogo.com.dogo_android.service.u2 d;
    private final app.dogo.com.dogo_android.service.v2 e;
    public Set<String> f;
    private Set<String> g;
    private Set<String> h;
    private final a<List<String>> i;
    private final List<String> j;
    private final List<String> k;
    private final List<String> l;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/service/FirestoreService$Companion;", "", "()V", "PAGE_TYPE_FULL_LIST", "", "PAGE_TYPE_PAGED_LIST", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0004\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011J\u0016\u0010\u0013\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011J\u0006\u0010\u0014\u001a\u00020\u000cJ\u001e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017", d2 = {"Lapp/dogo/com/dogo_android/service/FirestoreService$FirestorePager;", "", "query", "Lcom/google/firebase/firestore/Query;", "limit", "", "pageType", "queryWithLimit", "limitSum", "newestTime", "", "reachedEnd", "", "(Lapp/dogo/com/dogo_android/service/FirestoreService;Lcom/google/firebase/firestore/Query;IILcom/google/firebase/firestore/Query;IJZ)V", "addNewDocuments", "", "listener", "Lcom/google/android/gms/tasks/OnSuccessListener;", "Lcom/google/firebase/firestore/QuerySnapshot;", "fetchNextPage", "hasReachedEnd", "reinitPager", "resetPosition", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b {

        private Query a;
        private int b;
        private int c;
        private Query d;
        private int e;
        private long f;
        private boolean g;
        public b(app.dogo.com.dogo_android.service.m2 m2, Query query2, int i3, int i4, Query query5, int i6, long l7, boolean z8) {
            n.f(m2, "this$0");
            n.f(query2, "query");
            n.f(query5, "queryWithLimit");
            super();
            this.a = query2;
            this.b = i3;
            this.c = i4;
            this.d = query5;
            this.e = i6;
            this.f = l7;
            this.g = obj10;
        }

        public b(app.dogo.com.dogo_android.service.m2 m2, Query query2, int i3, int i4, Query query5, int i6, long l7, boolean z8, int i9, g g10) {
            int i5;
            Query limit;
            int i8;
            int i2;
            String str;
            Query query3;
            Query query;
            int i10;
            int i7;
            int i;
            if (g10 & 8 != 0) {
                query3 = query2;
                limit = query2.limit((long)i5);
                n.e(limit, "class FirestorePager(\n        private var query: Query,\n        private var limit: Int,\n        private var pageType: Int,\n        private var queryWithLimit: Query = query.limit(limit.toLong()),\n        private var limitSum: Int = limit,\n        private var newestTime: Long = 0,\n        private var reachedEnd: Boolean = false\n    ) {\n        fun addNewDocuments(listener: OnSuccessListener<QuerySnapshot?>) {\n            query.endBefore(Date(newestTime)).limit((limit + 1).toLong()).get().addOnCompleteListener { task: Task<QuerySnapshot?> ->\n                val documentSnapshots = task.result\n                newestTime = Calendar.getInstance().timeInMillis\n                listener.onSuccess(documentSnapshots)\n            }\n        }\n\n        fun fetchNextPage(listener: OnSuccessListener<QuerySnapshot?>) {\n            queryWithLimit.get().addOnCompleteListener { task: Task<QuerySnapshot> ->\n                if (task.isSuccessful) {\n                    val documentSnapshots = task.result\n                    if (pageType == PAGE_TYPE_PAGED_LIST) {\n                        if (documentSnapshots.documents.isNotEmpty()) {\n                            if (newestTime == 0L) {\n                                newestTime = Calendar.getInstance().timeInMillis\n                            }\n                            for (cursor in documentSnapshots.size() - 1 downTo 0) {\n                                if (!documentSnapshots.documents[cursor].metadata.hasPendingWrites()) {\n                                    val lastVisible = documentSnapshots.documents[cursor]\n                                    queryWithLimit = query.startAfter(lastVisible).limit(limit.toLong())\n                                    break\n                                }\n                            }\n                        }\n                        reachedEnd = documentSnapshots.isEmpty\n                    } else {\n                        reachedEnd = limitSum > documentSnapshots.size()\n                        limitSum += limit\n                        queryWithLimit = query.limit(limitSum.toLong())\n                    }\n                    listener.onSuccess(documentSnapshots)\n                } else {\n                    Timber.e(task.exception)\n                }\n            }\n        }\n\n        fun reinitPager(query: Query, limit: Int, pageType: Int) {\n            this.pageType = pageType\n            this.query = query\n            this.queryWithLimit = query.limit(limit.toLong())\n            this.limit = limit\n            this.limitSum = limit\n            this.newestTime = 0\n            this.reachedEnd = false\n        }\n\n        fun resetPosition() {\n            this.limitSum = limit\n            this.queryWithLimit = query.limit(limit.toLong())\n            this.reachedEnd = false\n        }\n\n        fun hasReachedEnd(): Boolean {\n            return reachedEnd\n        }\n    }");
                query = limit;
            } else {
                query3 = query2;
                i5 = i3;
                query = query5;
            }
            i10 = g10 & 16 != 0 ? i5 : i6;
            i7 = g10 & 32 != 0 ? i8 : l7;
            i = g10 & 64 != 0 ? i2 : i9;
            super(m2, query2, i3, i4, query, i10, i7, obj9, i);
        }

        private static final void b(app.dogo.com.dogo_android.service.m2.b m2$b, g g2, j j3) {
            n.f(b, "this$0");
            n.f(g2, "$listener");
            n.f(j3, "task");
            b.f = Calendar.getInstance().getTimeInMillis();
            g2.onSuccess((QuerySnapshot)j3.getResult());
        }

        private static final void d(app.dogo.com.dogo_android.service.m2.b m2$b, g g2, j j3) {
            int limit;
            int instance;
            Query successful;
            int str;
            String pendingWrites;
            int i;
            Object obj6;
            Object obj8;
            n.f(b, "this$0");
            n.f(g2, "$listener");
            n.f(j3, "task");
            if (j3.isSuccessful()) {
                obj8 = j3.getResult();
                str = 1;
                if (b.c == 0) {
                    List documents = (QuerySnapshot)obj8.getDocuments();
                    n.e(documents, "documentSnapshots.documents");
                    if (empty ^= str != 0 && Long.compare(pendingWrites, i) == 0) {
                        if (Long.compare(pendingWrites, i) == 0) {
                            b.f = Calendar.getInstance().getTimeInMillis();
                        }
                        if (size -= str >= 0) {
                        }
                    }
                    b.g = obj8.isEmpty();
                } else {
                    if (b.e > obj8.size()) {
                    } else {
                        str = 0;
                    }
                    b.g = str;
                    i4 += i6;
                    b.e = i5;
                    successful = b.a.limit((long)i5);
                    n.e(successful, "query.limit(limitSum.toLong())");
                    b.d = successful;
                }
                g2.onSuccess(obj8);
            } else {
                a.d(j3.getException());
            }
        }

        public static void f(app.dogo.com.dogo_android.service.m2.b m2$b, g g2, j j3) {
            m2.b.d(b, g2, j3);
        }

        public static void g(app.dogo.com.dogo_android.service.m2.b m2$b, g g2, j j3) {
            m2.b.b(b, g2, j3);
        }

        public final void a(g<QuerySnapshot> g) {
            n.f(g, "listener");
            int i = 1;
            Object[] arr = new Object[i];
            Date date = new Date(this.f, obj5);
            arr[0] = date;
            i2 += i;
            a1 a1Var = new a1(this, g);
            this.a.endBefore(arr).limit((long)i3).get().addOnCompleteListener(a1Var);
        }

        public final void c(g<QuerySnapshot> g) {
            n.f(g, "listener");
            z0 z0Var = new z0(this, g);
            this.d.get().addOnCompleteListener(z0Var);
        }

        public final boolean e() {
            return this.g;
        }

        public final void h(Query query, int i2, int i3) {
            n.f(query, "query");
            this.c = i3;
            this.a = query;
            Query obj3 = query.limit((long)i2);
            n.e(obj3, "query.limit(limit.toLong())");
            this.d = obj3;
            this.b = i2;
            this.e = i2;
            this.f = 0;
            this.g = false;
        }

        public final void i() {
            int i = this.b;
            this.e = i;
            Query limit = this.a.limit((long)i);
            n.e(limit, "query.limit(limit.toLong())");
            this.d = limit;
            this.g = false;
        }
    }

    @Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\u0012\u0010\u0008\u001a\u00060\u0000R\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0012\u0010\u000c\u001a\u00060\u0000R\u00020\t2\u0006\u0010\r\u001a\u00020\u000bJ\u0012\u0010\u000e\u001a\u00060\u0000R\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010J\u001a\u0010\u0011\u001a\u00060\u0000R\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014J\u0012\u0010\u0015\u001a\u00060\u0000R\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017J\u0012\u0010\u0018\u001a\u00060\u0000R\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014J\u0012\u0010\u0019\u001a\u00060\u0000R\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014J\u0012\u0010\u001a\u001a\u00060\u0000R\u00020\t2\u0006\u0010\u001b\u001a\u00020\u000bJ\n\u0010\u001c\u001a\u00060\u0000R\u00020\tJ\u0012\u0010\u001d\u001a\u00060\u0000R\u00020\t2\u0006\u0010\u0012\u001a\u00020\u001eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/service/FirestoreService$QueryBuilder;", "", "path", "Lapp/dogo/com/dogo_android/enums/FirestorePath;", "(Lapp/dogo/com/dogo_android/service/FirestoreService;Lapp/dogo/com/dogo_android/enums/FirestorePath;)V", "query", "Lcom/google/firebase/firestore/Query;", "build", "forAuthor", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "author", "", "forChallenge", "challengeId", "limitTo", "limit", "", "orderBy", "value", "order", "Lcom/google/firebase/firestore/Query$Direction;", "publishedAfter", "timestamp", "Ljava/util/Date;", "sortByDate", "sortByLikes", "whereIsCountry", "country", "whereIsFeatured", "wherePublished", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class c {

        private Query a;
        final app.dogo.com.dogo_android.service.m2 b;
        public c(app.dogo.com.dogo_android.service.m2 m2, f f2) {
            n.f(m2, "this$0");
            n.f(f2, "path");
            this.b = m2;
            super();
            this.a = m2.I(f2);
        }

        public final Query a() {
            return this.a;
        }

        public final app.dogo.com.dogo_android.service.m2.c b(String string) {
            String str = "author";
            n.f(string, str);
            final Query obj3 = this.a.whereEqualTo(str, string);
            n.e(obj3, "query.whereEqualTo(\"author\", author)");
            this.a = obj3;
            return this;
        }

        public final app.dogo.com.dogo_android.service.m2.c c(String string) {
            String str = "challengeId";
            n.f(string, str);
            final Query obj3 = this.a.whereEqualTo(str, string);
            n.e(obj3, "query.whereEqualTo(\"challengeId\", challengeId)");
            this.a = obj3;
            return this;
        }

        public final app.dogo.com.dogo_android.service.m2.c d(long l) {
            final Query obj2 = this.a.limit(l);
            n.e(obj2, "query.limit(limit)");
            this.a = obj2;
            return this;
        }

        public final app.dogo.com.dogo_android.service.m2.c e(String string, Query.Direction query$Direction2) {
            n.f(string, "value");
            n.f(direction2, "order");
            final Query obj2 = this.a.orderBy(string, direction2);
            n.e(obj2, "query.orderBy(value, order)");
            this.a = obj2;
            return this;
        }

        public final app.dogo.com.dogo_android.service.m2.c f(Date date) {
            n.f(date, "timestamp");
            final Query obj3 = this.a.whereGreaterThan("date", date);
            n.e(obj3, "query.whereGreaterThan(\"date\", timestamp)");
            this.a = obj3;
            return this;
        }

        public final app.dogo.com.dogo_android.service.m2.c g(Query.Direction query$Direction) {
            n.f(direction, "order");
            final Query obj3 = this.a.orderBy("date", direction);
            n.e(obj3, "query.orderBy(\"date\", order)");
            this.a = obj3;
            return this;
        }

        public final app.dogo.com.dogo_android.service.m2.c h(Query.Direction query$Direction) {
            n.f(direction, "order");
            final Query obj3 = this.a.orderBy("votes", direction);
            n.e(obj3, "query.orderBy(\"votes\", order)");
            this.a = obj3;
            return this;
        }

        public final app.dogo.com.dogo_android.service.m2.c i(String string) {
            String str = "country";
            n.f(string, str);
            String obj4 = string.toLowerCase();
            n.e(obj4, "(this as java.lang.String).toLowerCase()");
            obj4 = this.a.whereEqualTo(str, obj4);
            n.e(obj4, "query.whereEqualTo(\"country\", country.toLowerCase())");
            this.a = obj4;
            return this;
        }

        public final app.dogo.com.dogo_android.service.m2.c j() {
            Query whereEqualTo = this.a.whereEqualTo("featured", Boolean.TRUE);
            n.e(whereEqualTo, "query.whereEqualTo(\"featured\", true)");
            this.a = whereEqualTo;
            return this;
        }

        public final app.dogo.com.dogo_android.service.m2.c k(boolean z) {
            Query obj3 = this.a.whereEqualTo("published", Boolean.valueOf(z));
            n.e(obj3, "query.whereEqualTo(\"published\", value)");
            this.a = obj3;
            return this;
        }
    }
    static {
        m2.a aVar = new m2.a(0);
        m2.Companion = aVar;
    }

    public m2(o3 o3, app.dogo.com.dogo_android.service.u2 u22, app.dogo.com.dogo_android.service.p2 p23) {
        n.f(o3, "tracker");
        n.f(u22, "fbDatabase");
        n.f(p23, "sharedPreferenceService");
        super();
        this.a = p23;
        FirebaseFirestore instance = FirebaseFirestore.getInstance();
        n.e(instance, "getInstance()");
        this.b = instance;
        this.e = App.Companion.t();
        HashSet hashSet = new HashSet();
        this.f = hashSet;
        HashSet hashSet2 = new HashSet();
        this.g = hashSet2;
        HashSet hashSet3 = new HashSet();
        this.h = hashSet3;
        a aVar = new a();
        this.i = aVar;
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.k = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        this.l = arrayList3;
        FirebaseFirestoreSettings.Builder builder = new FirebaseFirestoreSettings.Builder();
        com.google.firebase.firestore.FirebaseFirestoreSettings build = builder.setCacheSizeBytes(-1).build();
        n.e(build, "Builder()\n            .setCacheSizeBytes(FirebaseFirestoreSettings.CACHE_SIZE_UNLIMITED).build()");
        instance.setFirestoreSettings(build);
        this.c = o3;
        this.d = u22;
        arrayList.addAll(p23.T());
        arrayList3.addAll(p23.U());
        arrayList2.addAll(p23.V());
    }

    private static final List A(j j) {
        String str2;
        Object object;
        String str;
        n.f(j, "querySnapshot");
        ArrayList arrayList = new ArrayList();
        Iterator obj4 = (QuerySnapshot)j.getResult().iterator();
        for (QueryDocumentSnapshot next2 : obj4) {
            object = next2.toObject(ChallengeEntryModel.class);
            n.e(object, "doc.toObject(ChallengeEntryModel::class.java)");
            str2 = next2.getId();
            n.e(str2, "doc.id");
            (ChallengeEntryModel)object.setDocumentId(str2);
            arrayList.add(object);
        }
        return arrayList;
    }

    private static final Map C(j j) {
        String entryId;
        Object hashMap;
        String imageId;
        Boolean tRUE;
        n.f(j, "querySnapshotTask");
        HashMap hashMap2 = new HashMap();
        Iterator obj5 = (QuerySnapshot)j.getResult().getDocuments().iterator();
        while (obj5.hasNext()) {
            Object object = (DocumentSnapshot)obj5.next().toObject(PhotoLikeModel.class);
            n.d((PhotoLikeModel)object);
            if (hashMap2.containsKey(object.getEntryId())) {
            } else {
            }
            hashMap = new HashMap();
            n.d(hashMap);
            hashMap.put(object.getImageId(), Boolean.TRUE);
            hashMap2.put(object.getEntryId(), hashMap);
            hashMap = hashMap2.get(object.getEntryId());
        }
        return hashMap2;
    }

    private static final Map E(j j) {
        String imageId;
        Boolean tRUE;
        n.f(j, "querySnapshotTask");
        HashMap hashMap = new HashMap();
        Iterator obj3 = (QuerySnapshot)j.getResult().getDocuments().iterator();
        for (DocumentSnapshot next2 : obj3) {
            Object object = next2.toObject(PhotoLikeModel.class);
            n.d((PhotoLikeModel)object);
            hashMap.put(object.getImageId(), Boolean.TRUE);
        }
        return hashMap;
    }

    private final j<Void> G0(f f, t t2, boolean z3) {
        j obj1;
        String obj2;
        SetOptions obj3;
        if (z3 == null) {
            n.d(t2);
            n.e(K(f).set(t2), "{\n            getDocumentReference(path).set(data!!)\n        }");
        } else {
            n.d(t2);
            n.e(K(f).set(t2, SetOptions.merge()), "{\n            getDocumentReference(path).set(data!!, SetOptions.merge())\n        }");
        }
        return obj1;
    }

    public static void S(Exception exception) {
        m2.k0(exception);
    }

    public static void T(Exception exception) {
        m2.l(exception);
    }

    public static Map U(j j) {
        return m2.v(j);
    }

    public static String V(j j) {
        return m2.x(j);
    }

    public static void W(app.dogo.com.dogo_android.service.m2 m2, QuerySnapshot querySnapshot2) {
        m2.j0(m2, querySnapshot2);
    }

    public static void X(Exception exception) {
        m2.n0(exception);
    }

    public static void Y(app.dogo.com.dogo_android.service.m2 m2, QuerySnapshot querySnapshot2) {
        m2.m0(m2, querySnapshot2);
    }

    public static void Z(app.dogo.com.dogo_android.service.m2 m2, String string2, String string3, String string4, u u5, String string6, boolean z7, QuerySnapshot querySnapshot8, FirebaseFirestoreException firebaseFirestoreException9) {
        m2.e(m2, string2, string3, string4, u5, string6, z7, querySnapshot8, firebaseFirestoreException9);
    }

    public static ChallengeEntryModel a0(j j) {
        return m2.r(j);
    }

    public static void b0(Void void) {
        m2.k(void);
    }

    public static ChallengeModel c0(j j) {
        return m2.t(j);
    }

    public static List d0(j j) {
        return m2.o(j);
    }

    private static final void e(app.dogo.com.dogo_android.service.m2 m2, String string2, String string3, String string4, u u5, String string6, boolean z7, QuerySnapshot querySnapshot8, FirebaseFirestoreException firebaseFirestoreException9) {
        int i;
        int i2;
        int i3;
        Object next;
        DocumentChange.Type pendingWrites;
        Object type;
        DocumentChange.Type mODIFIED;
        boolean aDDED;
        String str;
        String obj8;
        Object obj9;
        String obj10;
        Iterator obj14;
        ArrayList obj15;
        n.f(m2, "this$0");
        n.f(string3, "$entryId");
        n.f(u5, "$callback");
        n.f(string6, "$userId");
        obj15 = querySnapshot8.getDocumentChanges();
        n.e(obj15, "queryDocumentSnapshots.documentChanges");
        i = 1;
        if (querySnapshot8 != null && obj15 ^= i != 0) {
            obj15 = querySnapshot8.getDocumentChanges();
            n.e(obj15, "queryDocumentSnapshots.documentChanges");
            i = 1;
            if (obj15 ^= i != 0) {
                obj15 = new ArrayList();
                obj14 = querySnapshot8.getDocumentChanges().iterator();
                i2 = 0;
                i3 = i2;
                while (obj14.hasNext()) {
                    next = obj14.next();
                    str = "documentChange.document";
                    if ((DocumentChange)next.getType() == DocumentChange.Type.ADDED) {
                    }
                    if (next.getType() == DocumentChange.Type.MODIFIED && !next.getDocument().getMetadata().hasPendingWrites()) {
                    }
                    if (!next.getDocument().getMetadata().hasPendingWrites()) {
                    }
                    QueryDocumentSnapshot document = next.getDocument();
                    n.e(document, str);
                    next = m2.h0(document, string2, string3, string4);
                    if (!next.isPublished()) {
                    } else {
                    }
                    obj15.add(next);
                    if (next.isSpam()) {
                    }
                    QueryDocumentSnapshot document2 = next.getDocument();
                    n.e(document2, str);
                    type = m2.h0(document2, string2, string3, string4);
                    if (!type.isPublished()) {
                    } else {
                    }
                    obj15.add(type);
                    i3++;
                    if (type.isSpam()) {
                    }
                }
                if (obj8 ^= i != 0) {
                    obj8 = new ArrayList();
                    obj9 = obj15.iterator();
                    while (obj9.hasNext()) {
                        obj10 = obj9.next();
                        obj14 = obj10;
                        if (m2.P((ChallengeComment)obj14, string6, z7) != null) {
                        } else {
                        }
                        obj14 = i;
                        if (obj14 != null) {
                        }
                        obj8.add(obj10);
                        if (n.b(string6, obj14.getEntryOwnerUserId())) {
                        } else {
                        }
                        obj14 = i2;
                    }
                    u5.a(obj8, i3);
                }
            }
        }
    }

    public static List e0(j j) {
        return m2.A(j);
    }

    public static Map f0(j j) {
        return m2.C(j);
    }

    public static Map g0(j j) {
        return m2.E(j);
    }

    private final void i(f f) {
        j(K(f));
    }

    private final void j(DocumentReference documentReference) {
        documentReference.delete().addOnSuccessListener(f1.a).addOnFailureListener(v0.a);
    }

    private static final void j0(app.dogo.com.dogo_android.service.m2 m2, QuerySnapshot querySnapshot2) {
        String str;
        Set set;
        String str2;
        n.f(m2, "this$0");
        n.f(querySnapshot2, "adminQuerySnapshot");
        final Iterator obj4 = querySnapshot2.iterator();
        for (QueryDocumentSnapshot next2 : obj4) {
            str = next2.getId();
            n.e(str, "doc.id");
            m2.f.add(str);
        }
    }

    private static final void k(Void void) {
    }

    private static final void k0(Exception exception) {
        a.d(exception);
    }

    private static final void l(Exception exception) {
    }

    private static final void m0(app.dogo.com.dogo_android.service.m2 m2, QuerySnapshot querySnapshot2) {
        String str;
        Object str2;
        String str3;
        String str4;
        n.f(m2, "this$0");
        n.f(querySnapshot2, "ambassadorQuerySnapshot");
        final Iterator obj5 = querySnapshot2.iterator();
        while (obj5.hasNext()) {
            Object next2 = obj5.next();
            str3 = (QueryDocumentSnapshot)next2.getId();
            n.e(str3, "doc.id");
            m2.H().add(str3);
            str = next2.get("dogFriends");
            if (str != null) {
            }
            m2.G().addAll((List)str);
        }
    }

    private static final void n0(Exception exception) {
        a.d(exception);
    }

    private static final List o(j j) {
        Object object;
        Class<ChallengeModel> contains;
        app.dogo.com.dogo_android.model.ChallengeModel.MediaTypes mediaType;
        n.f(j, "task");
        ArrayList arrayList = new ArrayList();
        Iterator obj4 = (QuerySnapshot)j.getResult().getDocuments().iterator();
        while (obj4.hasNext()) {
            object = (DocumentSnapshot)obj4.next().toObject(ChallengeModel.class);
            if (object != null && ChallengeModel.Companion.getSUPPORTED_ENTRY_TYPES().contains((ChallengeModel)object.getMediaType())) {
            }
            if (ChallengeModel.Companion.getSUPPORTED_ENTRY_TYPES().contains(object.getMediaType())) {
            }
            arrayList.add(object);
        }
        return arrayList;
    }

    private final Query p(String string, String string2, boolean z3) {
        String str;
        String str2;
        Object dESCENDING;
        String str3;
        Query obj7;
        String obj8;
        String obj9;
        obj7 = n2.e(string);
        str2 = "startDate";
        final String str5 = "locale";
        final String str6 = "hasStarted";
        String str7 = "challengeLocales";
        if (App.Companion.n().E()) {
            dESCENDING = Query.Direction.DESCENDING;
            n.e(this.b.collectionGroup(str7).orderBy("hasEnded", Query.Direction.ASCENDING).orderBy("orderPriority", dESCENDING).orderBy(str2, dESCENDING).whereEqualTo(str5, obj7).whereEqualTo(str6, Boolean.TRUE), "{\n            rootDatabase.collectionGroup(\"challengeLocales\")\n                .orderBy(\"hasEnded\", Query.Direction.ASCENDING)\n                .orderBy(\"orderPriority\", Query.Direction.DESCENDING)\n                .orderBy(\"startDate\", Query.Direction.DESCENDING)\n                .whereEqualTo(\"locale\", validatedLocale)\n                .whereEqualTo(\"hasStarted\", true)\n        }");
        } else {
            n.e(this.b.collectionGroup(str7).whereEqualTo(str6, Boolean.TRUE).whereEqualTo(str5, obj7).orderBy(str2, Query.Direction.DESCENDING).whereEqualTo("entryType", "typePhoto"), "{\n            rootDatabase.collectionGroup(\"challengeLocales\")\n                .whereEqualTo(\"hasStarted\", true)\n                .whereEqualTo(\"locale\", validatedLocale)\n                .orderBy(\"startDate\", Query.Direction.DESCENDING)\n                .whereEqualTo(\"entryType\", \"typePhoto\")\n        }");
        }
        if (z3) {
            return obj7;
        }
        if (string2 != null && !n.b(string2, "null")) {
            if (!n.b(string2, "null")) {
                n.e(obj7.whereArrayContains("locations", string2), "{\n            query.whereArrayContains(\"locations\", location)\n        }");
            } else {
                n.e(obj7.whereEqualTo("global", Boolean.TRUE), "{\n            query.whereEqualTo(\"global\", true)\n        }");
            }
        } else {
        }
        return obj7;
    }

    private static final ChallengeEntryModel r(j j) {
        n.f(j, "task");
        Object obj2 = j.getResult();
        Object object = (DocumentSnapshot)obj2.toObject(ChallengeEntryModel.class);
        n.d((ChallengeEntryModel)object);
        obj2 = obj2.getId();
        n.e(obj2, "doc.id");
        object.setDocumentId(obj2);
        return object;
    }

    private static final ChallengeModel t(j j) {
        n.f(j, "task");
        return (ChallengeModel)(DocumentSnapshot)j.getResult().toObject(ChallengeModel.class);
    }

    private final void t0(String string) {
        this.a.p0(string);
        this.j.add(string);
    }

    private final void u0(String string) {
        this.a.r0(string);
        this.l.add(string);
    }

    private static final Map v(j j) {
        boolean exists;
        Object obj2;
        n.f(j, "task");
        HashMap hashMap = new HashMap();
        if ((DocumentSnapshot)j.getResult().exists() && (DocumentSnapshot)j.getResult().getData() != null) {
            if ((DocumentSnapshot)j.getResult().getData() != null) {
                obj2 = (DocumentSnapshot)j.getResult().getData();
                n.d(obj2);
                n.e(obj2, "task.result.data!!");
                hashMap.putAll(obj2);
            }
        }
        return hashMap;
    }

    private final void v0(String string) {
        this.a.s0(string);
        this.k.add(string);
    }

    private static final String x(j j) {
        boolean successful;
        n.f(j, "task");
        Object result = j.getResult();
        n.d(result);
        if (j.isSuccessful() && j.getResult() != null && (DocumentSnapshot)result.exists()) {
            if (j.getResult() != null) {
                result = j.getResult();
                n.d(result);
                if ((DocumentSnapshot)result.exists()) {
                    Object obj1 = j.getResult();
                    n.d(obj1);
                    return (DocumentSnapshot)obj1.getString("text");
                }
            }
        }
        return null;
    }

    public final void A0(String string, String string2, boolean z3) {
        n.f(string, "userId");
        n.f(string2, "entryId");
        HashMap hashMap = new HashMap();
        hashMap.put("following", Boolean.valueOf(z3));
        H0(f.groupChallengeChatMessage.forUserId(string).forEntryId(string2), hashMap, true);
    }

    public final j<Map<String, Map<String, Boolean>>> B(String string, String string2, boolean z3) {
        Object likeDocs;
        Object obj2;
        Object obj3;
        n.f(string, "userId");
        if (string2 != null) {
            n.e(I(f.likeDocs.forUserId(string)).whereEqualTo("challengeId", string2), "query.whereEqualTo(\"challengeId\", challengeId)");
        }
        obj3 = z3 ? Source.CACHE : Source.DEFAULT;
        obj2 = obj2.get(obj3).continueWith(j1.a);
        n.e(obj2, "query[if (cached) Source.CACHE else Source.DEFAULT].continueWith { querySnapshotTask: Task<QuerySnapshot> ->\n            val mainLikeMap: MutableMap<String, MutableMap<String, Boolean>> = HashMap()\n            for (doc in querySnapshotTask.result.documents) {\n                val likeModel = doc.toObject(PhotoLikeModel::class.java)\n                val entryLikeMap = if (mainLikeMap.containsKey(likeModel!!.entryId)) mainLikeMap[likeModel.entryId] else HashMap()\n                entryLikeMap!![likeModel.imageId] = true\n                mainLikeMap[likeModel.entryId] = entryLikeMap\n            }\n            mainLikeMap\n        }");
        return obj2;
    }

    public final void B0(String string, String string2) {
        n.f(string, "userId");
        n.f(string2, "entryId");
        HashMap hashMap = new HashMap();
        hashMap.put("isActive", Boolean.FALSE);
        hashMap.put("newEntryVotes", 0);
        H0(f.groupChallengeChatMessage.forUserId(string).forEntryId(string2), hashMap, true);
    }

    public final j<Void> C0(f f, String string2, Object object3, Object... object4Arr4) {
        n.f(f, "path");
        n.f(object4Arr4, "moreFieldsAndValues");
        n.d(string2);
        j obj2 = K(f).update(string2, object3, Arrays.copyOf(object4Arr4, object4Arr4.length));
        n.e(obj2, "getDocumentReference(path).update(field!!, value, *moreFieldsAndValues)");
        return obj2;
    }

    public final j<Map<String, Boolean>> D(String string, String string2, boolean z3) {
        Source obj3;
        n.f(string, "userId");
        obj3 = z3 ? Source.CACHE : Source.DEFAULT;
        j obj2 = I(f.likeDocs.forUserId(string)).whereEqualTo("entryId", string2).get(obj3).continueWith(k1.a);
        n.e(obj2, "getCollectionReference(FirestorePath.likeDocs.forUserId(userId)).whereEqualTo(\"entryId\", entryId)[if (cached) Source.CACHE else Source.DEFAULT].continueWith { querySnapshotTask: Task<QuerySnapshot> ->\n            val photoLikes: MutableMap<String, Boolean> = HashMap()\n            for (doc in querySnapshotTask.result.documents) {\n                val likeModel = doc.toObject(PhotoLikeModel::class.java)\n                photoLikes[likeModel!!.imageId] = true\n            }\n            photoLikes\n        }");
        return obj2;
    }

    public final void D0(ChallengeComment challengeComment) {
        n.f(challengeComment, "model");
        final String entryId = challengeComment.getEntryId();
        n.d(entryId);
        I(f.comments.forEntryId(entryId)).add(challengeComment);
    }

    public final void E0(String string, ChallengeEntryModel challengeEntryModel2, String string3, String string4, String string5, String string6) {
        String str2;
        Object imageUrl;
        String dogId2;
        Object obj;
        Object imageUrlOf;
        String documentId;
        String str;
        PhotoLikeModel photoLikeModel;
        String dogId;
        Object obj15;
        String obj16;
        String obj17;
        String obj18;
        String obj19;
        String obj20;
        final Object obj2 = this;
        Object obj3 = string;
        Object obj4 = challengeEntryModel2;
        obj = string3;
        Object obj5 = string4;
        final String str9 = string6;
        n.f(string, "userId");
        n.f(obj4, "entry");
        n.f(obj5, "currentDogId");
        final String challengeId = challengeEntryModel2.getChallengeId();
        documentId = challengeEntryModel2.getDocumentId();
        str = str9 == null ? documentId : str9;
        HashMap hashMap = new HashMap();
        final Boolean tRUE = Boolean.TRUE;
        hashMap.put("hasUserLiked", tRUE);
        hashMap.put("date", FieldValue.serverTimestamp());
        hashMap.put("dogId", obj5);
        hashMap.put("appInstallationId", string5);
        if (obj != null) {
            hashMap.put("voterEntryId", obj);
        }
        if (str9 != null) {
            super(string6, documentId, obj4.getImageUrlOf(str9), challengeEntryModel2.getDogId(), challengeId);
            imageUrl = new HashMap();
            imageUrl.put(str9, tRUE);
            hashMap.put("images", imageUrl);
        } else {
            super(documentId, documentId, challengeEntryModel2.getImageUrl(), challengeEntryModel2.getDogId(), challengeId);
        }
        int i = 1;
        G0(f.likedPhotoDocs.forUserId(string).forPhotoId(str), photoLikeModel, i);
        H0(f.entryVoteFromUser.forEntryId(documentId).forUserId(string), hashMap, i);
    }

    public final String F(String string, String string2) {
        n.f(string, "dogId");
        n.f(string2, "trickId");
        String obj3 = this.b.collection("dogs").document(string).collection("exams").document(string2).collection("history").document().getId();
        n.e(obj3, "rootDatabase\n            .collection(\"dogs\")\n            .document(dogId)\n            .collection(\"exams\")\n            .document(trickId)\n            .collection(\"history\")\n            .document().id");
        return obj3;
    }

    public final void F0(ChallengeComment challengeComment, String string2, DogProfileModel dogProfileModel3) {
        n.f(challengeComment, "model");
        String str2 = "userId";
        n.f(string2, str2);
        n.f(dogProfileModel3, "currentDog");
        HashMap hashMap = new HashMap();
        FieldValue serverTimestamp = FieldValue.serverTimestamp();
        n.e(serverTimestamp, "serverTimestamp()");
        hashMap.put("createdAt", serverTimestamp);
        HashMap hashMap2 = new HashMap();
        String documentId2 = challengeComment.getDocumentId();
        n.d(documentId2);
        hashMap2.put(documentId2, Boolean.TRUE);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("commentOwnerUserId", challengeComment.getUserId());
        hashMap3.put("commentOwnerDogId", challengeComment.getDogId());
        hashMap3.put("entryOwnerUserId", challengeComment.getEntryId());
        hashMap3.put("commentText", challengeComment.getMessage());
        hashMap3.put("dogName", dogProfileModel3.getName());
        hashMap3.put("dogId", dogProfileModel3.getId());
        hashMap3.put(str2, string2);
        hashMap3.put("entryId", challengeComment.getEntryId());
        String documentId = challengeComment.getDocumentId();
        n.d(documentId);
        String entryId = challengeComment.getEntryId();
        n.d(entryId);
        H0(f.commentLikes.forCommentId(documentId).forUserId(string2).forEntryId(entryId), hashMap, false);
        String entryId2 = challengeComment.getEntryId();
        n.d(entryId2);
        int i2 = 1;
        H0(f.commentVoteFromUser.forUserId(string2).forEntryId(entryId2), hashMap2, i2);
        String obj7 = challengeComment.getDocumentId();
        n.d(obj7);
        H0(f.commentVoteFromUserExtended.forUserId(string2).forCommentId(obj7), hashMap3, i2);
    }

    public final Set<String> G() {
        return this.g;
    }

    public final Set<String> H() {
        return this.h;
    }

    public final j<Void> H0(f f, Map<String, ? extends Object> map2, boolean z3) {
        j obj2;
        String obj3;
        SetOptions obj4;
        n.f(f, "path");
        if (z3 == null) {
            n.d(map2);
            n.e(K(f).set(map2), "{\n            getDocumentReference(path).set(data!!)\n        }");
        } else {
            n.d(map2);
            n.e(K(f).set(map2, SetOptions.merge()), "{\n            getDocumentReference(path).set(data!!, SetOptions.merge())\n        }");
        }
        return obj2;
    }

    public final CollectionReference I(f f) {
        n.f(f, "path");
        CollectionReference obj2 = this.b.collection(f.getPath());
        n.e(obj2, "rootDatabase.collection(path.path)");
        return obj2;
    }

    public final void J(f f, e<DocumentSnapshot> e2) {
        n.f(f, "path");
        n.d(e2);
        K(f).get().addOnCompleteListener(e2);
    }

    public final DocumentReference K(f f) {
        n.f(f, "path");
        DocumentReference obj2 = this.b.document(f.getPath());
        n.e(obj2, "rootDatabase.document(path.path)");
        return obj2;
    }

    public final app.dogo.com.dogo_android.service.m2.c L(f f) {
        n.f(f, "path");
        m2.c cVar = new m2.c(this, f);
        return cVar;
    }

    public final a<List<String>> M() {
        return this.i;
    }

    public final Query N(String string, String string2, int i3) {
        Query obj3 = I(f.allEntries).whereEqualTo("author", string).whereEqualTo("challengeId", string2).limit((long)i3);
        n.e(obj3, "getCollectionReference(FirestorePath.allEntries).whereEqualTo(\"author\", userId).whereEqualTo(\"challengeId\", challengeId).limit(maxEntries.toLong())");
        return obj3;
    }

    public final void O(ChallengeComment challengeComment) {
        n.f(challengeComment, "comment");
        HashMap hashMap = new HashMap();
        hashMap.put("published", Boolean.FALSE);
        hashMap.put("marked", "spam");
        String entryId = challengeComment.getEntryId();
        n.d(entryId);
        String obj4 = challengeComment.getDocumentId();
        n.d(obj4);
        K(f.comment.forEntryId(entryId).forCommentId(obj4)).update(hashMap);
    }

    public final boolean P(ChallengeComment challengeComment, String string2, boolean z3) {
        String dogId;
        String documentId;
        int obj3;
        boolean obj5;
        n.f(challengeComment, "item");
        n.f(string2, "currentUserId");
        if (!z3) {
            if (!p.N(this.j, challengeComment.getDocumentId())) {
                if (Q(challengeComment.getDogId(), z3) && !challengeComment.isEntryAuthor(string2) && !challengeComment.isCommentAuthor(string2)) {
                    if (!challengeComment.isEntryAuthor(string2)) {
                        obj3 = !challengeComment.isCommentAuthor(string2) ? 1 : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    public final boolean Q(String string, boolean z2) {
        int obj2;
        Map obj3;
        n.f(string, "dogId");
        if (!z2 && this.l.contains(string) && !this.d.A().m().containsKey(string)) {
            if (this.l.contains(string)) {
                obj2 = !this.d.A().m().containsKey(string) ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj2;
    }

    public final boolean R(ChallengeEntryModel challengeEntryModel, String string2, boolean z3) {
        String dogId;
        String documentId;
        Object obj3;
        boolean obj5;
        n.f(challengeEntryModel, "item");
        n.f(string2, "currentUserId");
        if (!z3) {
            if (!this.k.contains(challengeEntryModel.getDocumentId())) {
                if (challengeEntryModel.getDogId() == null) {
                    dogId = "";
                }
                if (Q(dogId, z3) && challengeEntryModel.getAuthor() != string2) {
                    obj3 = challengeEntryModel.getAuthor() != string2 ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    public final List<String> a(String string, boolean z2) {
        boolean obj3;
        ArrayList arrayList = new ArrayList();
        if (p.N(this.g, string)) {
            arrayList.add("ambassador");
        }
        if (z2) {
            arrayList.add("premium");
        }
        return arrayList;
    }

    public final app.dogo.com.dogo_android.service.m2.b b(String string, int i2, int i3) {
        n.f(string, "entryId");
        Query obj3 = I(f.comments.forEntryId(string)).orderBy("date", Query.Direction.DESCENDING);
        n.e(obj3, "getCollectionReference(FirestorePath.comments.forEntryId(entryId)).orderBy(\"date\", Query.Direction.DESCENDING)");
        return c(obj3, i2, i3);
    }

    public final app.dogo.com.dogo_android.service.m2.b c(Query query, int i2, int i3) {
        n.f(query, "query");
        super(this, query, i2, i3, 0, 0, 0, obj9, 0, 120, 0);
        return bVar;
    }

    public final ListenerRegistration d(String string, String string2, boolean z3, String string4, String string5, long l6, u<List<ChallengeComment>> u7) {
        n.f(string, "userId");
        n.f(string2, "entryId");
        final Object obj = obj19;
        n.f(obj, "callback");
        Date date = new Date(l6, obj2);
        final app.dogo.com.dogo_android.service.m2 m2Var2 = this;
        String str6 = "date";
        final Query orderBy = I(f.comments.forEntryId(string2)).whereGreaterThan(str6, date).orderBy(str6, Query.Direction.DESCENDING);
        n.e(orderBy, "getCollectionReference(FirestorePath.comments.forEntryId(entryId))\n            .whereGreaterThan(\"date\", datePoint).orderBy(\"date\", Query.Direction.DESCENDING)");
        super(this, string4, string2, string5, obj, string, z3);
        ListenerRegistration snapshotListener = orderBy.addSnapshotListener(d1Var2);
        n.e(snapshotListener, "query.addSnapshotListener { queryDocumentSnapshots: QuerySnapshot?, e: FirebaseFirestoreException? ->\n            var newDocCount = 0\n            if (queryDocumentSnapshots != null && queryDocumentSnapshots.documentChanges.isNotEmpty()) {\n                val commentList: MutableList<ChallengeComment> = arrayListOf()\n                for (documentChange in queryDocumentSnapshots.documentChanges) {\n                    // new comment comming from the database\n                    if (documentChange.type == DocumentChange.Type.ADDED) {\n                        val document: DocumentSnapshot = documentChange.document\n                        val model = parseComment(document, entryAuthorId, entryId, challengeId)\n                        if (model.isPublished || model.isSpam) {\n                            commentList.add(model)\n                            newDocCount++\n                        }\n                    }\n                    // user comment update\n                    if (documentChange.type == DocumentChange.Type.MODIFIED && !documentChange.document.metadata.hasPendingWrites()) {\n                        val document: DocumentSnapshot = documentChange.document\n                        val model = parseComment(document, entryAuthorId, entryId, challengeId)\n                        if (model.isPublished || model.isSpam) {\n                            commentList.add(model)\n                        }\n                    }\n                }\n                if (commentList.isNotEmpty()) {\n                    callback.onObjectCallback(commentList.filter { !isCommentReported(it, userId, isAdmin) || userId == it.entryOwnerUserId }, newDocCount)\n                }\n            }\n        }");
        return snapshotListener;
    }

    public final void f(ChallengeEntryModel challengeEntryModel, int i2) {
        boolean photoCreationTimestamp;
        String str;
        n.f(challengeEntryModel, "model");
        HashMap hashMap = new HashMap();
        if (challengeEntryModel.isLatestPhoto(i2)) {
            hashMap.put("date", challengeEntryModel.getPhotoCreationTimestamp(1));
        }
        hashMap.put(n.o("images.", challengeEntryModel.getImageIdAt(i2)), FieldValue.delete());
        hashMap.put("updatedAt", FieldValue.serverTimestamp());
        K(f.entry.forEntryId(challengeEntryModel.getDocumentId())).update(hashMap);
        challengeEntryModel.removePhoto(i2);
    }

    public final void g(String string, String string2, String string3) {
        n.f(string, "uid");
        n.f(string2, "entryId");
        n.f(string3, "challengeId");
        f obj5 = f.entry;
        C0(obj5.forEntryId(string2), "isBeingDeleted", Boolean.TRUE, new Object[0]);
        i(obj5.forEntryId(string2));
        this.d.U(string3);
        this.c.c(u.u);
    }

    public final void h(ChallengeComment challengeComment) {
        n.f(challengeComment, "comment");
        final String entryId = challengeComment.getEntryId();
        n.d(entryId);
        String obj3 = challengeComment.getDocumentId();
        n.d(obj3);
        K(f.comment.forEntryId(entryId).forCommentId(obj3)).delete();
    }

    public final ChallengeComment h0(DocumentSnapshot documentSnapshot, String string2, String string3, String string4) {
        n.f(documentSnapshot, "doc");
        Object object = documentSnapshot.toObject(ChallengeComment.class);
        n.d((ChallengeComment)object);
        final String obj3 = documentSnapshot.getId();
        n.e(obj3, "doc.id");
        object.setDocumentId(obj3);
        object.setEntryAuthor(string2);
        object.setEntryId(string3);
        object.setChallengeId(string4);
        return object;
    }

    public final void i0() {
        y0 y0Var = new y0(this);
        I(f.admins).get().addOnSuccessListener(y0Var).addOnFailureListener(u0.a);
    }

    public final void l0() {
        c1 c1Var = new c1(this);
        I(f.ambassadors).get().addOnSuccessListener(c1Var).addOnFailureListener(b1.a);
    }

    public final j<QuerySnapshot> m(String string) {
        j obj3 = I(f.allEntries).whereEqualTo("dogId", string).whereEqualTo("published", Boolean.TRUE).orderBy("date", Query.Direction.DESCENDING).get();
        n.e(obj3, "getCollectionReference(FirestorePath.allEntries)\n            .whereEqualTo(\"dogId\", dogId)\n            .whereEqualTo(\"published\", true)\n            .orderBy(\"date\", Query.Direction.DESCENDING)\n            .get()");
        return obj3;
    }

    public final j<List<ChallengeModel>> n(String string, String string2, boolean z3) {
        j obj1 = p(n2.e(string), string2, z3).get().continueWith(h1.a);
        n.e(obj1, "fetchAllChallengesQuery(validatedLocale, location, userAdmin).get().continueWith { task: Task<QuerySnapshot> ->\n            val challenges: MutableList<ChallengeModel> = ArrayList()\n            for (doc in task.result.documents) {\n                val challengeModel = doc.toObject(ChallengeModel::class.java)\n                if (challengeModel != null && ChallengeModel.SUPPORTED_ENTRY_TYPES.contains(challengeModel.mediaType)) {\n                    challenges.add(challengeModel)\n                }\n            }\n            challenges\n        }");
        return obj1;
    }

    public final void o0(String string, String string2, String string3) {
        String obj6;
        n.f(string, "entryId");
        n.f(string2, "userId");
        HashMap hashMap = new HashMap();
        FieldValue serverTimestamp = FieldValue.serverTimestamp();
        n.e(serverTimestamp, "serverTimestamp()");
        hashMap.put("date", serverTimestamp);
        if (string3 == null) {
            obj6 = "";
        }
        hashMap.put("reason", obj6);
        H0(f.entryReport.forEntryId(string).forUserId(string2), hashMap, false);
        i1 i1Var = new i1();
        this.c.d(u.v.d(u.a(i1Var, string)));
        v0(string);
        this.i.postValue(p.b(string));
    }

    public final void p0(String string, String string2, List<String> list3) {
        final String str = "dogId";
        n.f(string, str);
        final String str2 = "reporterUserId";
        n.f(string2, str2);
        n.f(list3, "entryIds");
        h1 h1Var = new h1();
        kotlin.o oVar = u.a(h1Var, string);
        this.c.d(u.a.d(oVar));
        HashMap hashMap = new HashMap();
        hashMap.put("timestamp", Long.valueOf(this.e.g()));
        hashMap.put(str, string);
        hashMap.put(str2, string2);
        I(f.challengeProfileReport).add(hashMap);
        u0(string);
        this.i.postValue(list3);
    }

    public final j<ChallengeEntryModel> q(String string) {
        n.f(string, "entryId");
        j obj2 = K(f.entry.forEntryId(string)).get().continueWith(e1.a);
        n.e(obj2, "getDocumentReference(FirestorePath.entry.forEntryId(entryId)).get().continueWith { task: Task<DocumentSnapshot> ->\n            val doc = task.result\n            val model = doc.toObject(ChallengeEntryModel::class.java)\n            model!!.setDocumentId(doc.id)\n            model\n        }");
        return obj2;
    }

    public final void q0(String string, String string2, String string3, String string4) {
        String obj8;
        n.f(string, "commentId");
        n.f(string2, "userId");
        n.f(string3, "entryId");
        q1 q1Var = new q1();
        i1 i1Var = new i1();
        this.c.d(u.f.d(u.a(q1Var, string), u.a(i1Var, string3)));
        HashMap hashMap = new HashMap();
        FieldValue serverTimestamp = FieldValue.serverTimestamp();
        n.e(serverTimestamp, "serverTimestamp()");
        hashMap.put("date", serverTimestamp);
        if (string4 == null) {
            obj8 = "";
        }
        hashMap.put("reason", obj8);
        K(f.commentReports.forCommentId(string).forUserId(string2).forEntryId(string3)).set(hashMap);
        t0(string);
    }

    public final void r0(String string) {
        n.f(string, "entryId");
        int i = 0;
        K(f.entry.forEntryId(string)).update("uploadStatus", Integer.valueOf(i), new Object[i]);
    }

    public final j<ChallengeModel> s(String string, String string2) {
        n.f(string, "challengeId");
        j obj2 = K(f.localisedChallenges.forChallengeId(string).forLocale(n2.e(string2))).get().continueWith(g1.a);
        n.e(obj2, "getDocumentReference(FirestorePath.localisedChallenges.forChallengeId(challengeId).forLocale(validatedLocale)).get().continueWith { task: Task<DocumentSnapshot> -> task.result.toObject(ChallengeModel::class.java) }");
        return obj2;
    }

    public final void s0(String string) {
        n.f(string, "documentId");
        Date date = new Date(currentTimeMillis -= i3, obj2);
        K(f.entry.forEntryId(string)).update("date", date, new Object[0]);
    }

    public final j<Map<String, Object>> u(String string, String string2) {
        n.f(string, "entryId");
        n.f(string2, "userId");
        j obj2 = K(f.commentVoteFromUser.forUserId(string2).forEntryId(string)).get().continueWith(w0.a);
        n.e(obj2, "getDocumentReference(FirestorePath.commentVoteFromUser.forUserId(userId).forEntryId(entryId)).get().continueWith { task: Task<DocumentSnapshot> ->\n            val likedEntries: MutableMap<String, Any> = HashMap()\n            if (task.result.exists() && task.result.data != null) {\n                likedEntries.putAll(task.result.data!!)\n            }\n            likedEntries\n        }");
        return obj2;
    }

    public final j<String> w(f f) {
        n.f(f, "localeDataPath");
        j obj2 = K(f).get().continueWith(x0.a);
        n.e(obj2, "getDocumentReference(localeDataPath).get()\n            .continueWith { task: Task<DocumentSnapshot?> ->\n                if (task.isSuccessful && task.result != null && task.result!!.exists()) {\n                    return@continueWith task.result!!.getString(\"text\")\n                } else {\n                    return@continueWith null\n                }\n            }");
        return obj2;
    }

    public final ListenerRegistration w0(String string, int i2, EventListener<QuerySnapshot> eventListener3) {
        n.f(string, "userId");
        n.f(eventListener3, "listener");
        ListenerRegistration obj3 = I(f.allGroupChallengeChat.forUserId(string)).limit((long)i2).orderBy("sortingDate", Query.Direction.DESCENDING).whereEqualTo("following", Boolean.FALSE).whereEqualTo("entryPublished", Boolean.TRUE).whereEqualTo("notificationType", "challengesComment").addSnapshotListener(eventListener3);
        n.e(obj3, "getCollectionReference(FirestorePath.allGroupChallengeChat.forUserId(userId))\n            .limit(limit.toLong())\n            .orderBy(\"sortingDate\", Query.Direction.DESCENDING)\n            .whereEqualTo(\"following\", false)\n            .whereEqualTo(\"entryPublished\", true)\n            .whereEqualTo(\"notificationType\", \"challengesComment\")\n            .addSnapshotListener(listener)");
        return obj3;
    }

    public final ListenerRegistration x0(String string, int i2, EventListener<QuerySnapshot> eventListener3) {
        n.f(string, "userId");
        n.f(eventListener3, "listener");
        Boolean obj4 = Boolean.TRUE;
        ListenerRegistration obj3 = I(f.allGroupChallengeChat.forUserId(string)).limit((long)i2).orderBy("sortingDate", Query.Direction.DESCENDING).whereEqualTo("following", obj4).whereEqualTo("entryPublished", obj4).whereEqualTo("notificationType", "challengesComment").addSnapshotListener(eventListener3);
        n.e(obj3, "getCollectionReference(FirestorePath.allGroupChallengeChat.forUserId(userId))\n            .limit(limit.toLong())\n            .orderBy(\"sortingDate\", Query.Direction.DESCENDING)\n            .whereEqualTo(\"following\", true)\n            .whereEqualTo(\"entryPublished\", true)\n            .whereEqualTo(\"notificationType\", \"challengesComment\")\n            .addSnapshotListener(listener)");
        return obj3;
    }

    public final j<List<ChallengeEntryModel>> y(String string, String string2) {
        j obj3 = I(f.allEntries).whereEqualTo("author", string).whereEqualTo("challengeId", string2).get().continueWith(i1.a);
        n.e(obj3, "getCollectionReference(FirestorePath.allEntries)\n            .whereEqualTo(\"author\", uid)\n            .whereEqualTo(\"challengeId\", challengeId)\n            .get().continueWith { querySnapshot: Task<QuerySnapshot> ->\n                val userEntryList: MutableList<ChallengeEntryModel?> = ArrayList()\n                for (doc in querySnapshot.result) {\n                    val model = doc.toObject(ChallengeEntryModel::class.java)\n                    model.setDocumentId(doc.id)\n                    userEntryList.add(model)\n                }\n                userEntryList\n            }");
        return obj3;
    }

    public final void y0(String string, ChallengeEntryModel challengeEntryModel2, String string3) {
        Object likedPhotoDocs;
        Boolean fALSE;
        String obj5;
        Object obj6;
        n.f(string, "userId");
        n.f(challengeEntryModel2, "entry");
        f forUserId = f.entryVoteFromUser.forEntryId(challengeEntryModel2.getDocumentId()).forUserId(string);
        if (string3 == null) {
        } else {
            obj5 = string3;
        }
        if (string3 != null) {
            obj5 = new HashMap();
            likedPhotoDocs = new HashMap();
            likedPhotoDocs.put(string3, Boolean.FALSE);
            obj5.put("images", likedPhotoDocs);
            H0(forUserId, obj5, true);
        } else {
            i(forUserId);
        }
        i(f.likedPhotoDocs.forUserId(string).forPhotoId(obj5));
    }

    public final ListenerRegistration z(String string, String string2, EventListener<QuerySnapshot> eventListener3) {
        n.f(string, "uid");
        n.f(eventListener3, "listener");
        app.dogo.com.dogo_android.service.m2.c cVar = L(f.allEntries);
        cVar.b(string);
        if (string2 != null) {
            cVar.c(string2);
        }
        ListenerRegistration obj2 = cVar.a().addSnapshotListener(eventListener3);
        n.e(obj2, "queryBuilder.build().addSnapshotListener(listener)");
        return obj2;
    }

    public final void z0(ChallengeComment challengeComment, String string2) {
        n.f(challengeComment, "model");
        n.f(string2, "userId");
        HashMap hashMap = new HashMap();
        String documentId = challengeComment.getDocumentId();
        n.d(documentId);
        FieldValue delete = FieldValue.delete();
        n.e(delete, "delete()");
        hashMap.put(documentId, delete);
        String obj5 = challengeComment.getEntryId();
        n.d(obj5);
        i(f.commentLikes.forCommentId(documentId).forUserId(string2).forEntryId(obj5));
        H0(f.commentVoteFromUser.forUserId(string2).forEntryId(obj5), hashMap, true);
    }
}
