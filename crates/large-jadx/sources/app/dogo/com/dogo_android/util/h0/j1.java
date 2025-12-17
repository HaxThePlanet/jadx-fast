package app.dogo.com.dogo_android.util.h0;

import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.Context;
import android.content.res.Resources;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.a;
import androidx.core.os.e;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.fragment.app.n;
import androidx.fragment.app.n.k;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.viewpager2.widget.ViewPager2;
import app.dogo.android.persistencedb.room.entity.BreedEntity;
import app.dogo.com.dogo_android.model.ChallengeComment;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.model.ChallengeEntryModel.Companion;
import app.dogo.com.dogo_android.model.ChallengeEntryModel.MiniEntryModel;
import app.dogo.com.dogo_android.model.ChallengeEntryVoter;
import app.dogo.com.dogo_android.model.ChallengeNotificationModel;
import app.dogo.com.dogo_android.model.ChallengeNotificationModel.EntryImageObject;
import app.dogo.com.dogo_android.model.DogProfileModel;
import app.dogo.com.dogo_android.model.Exam;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable;
import app.dogo.com.dogo_android.model.survey.SurveyAnswerModel;
import app.dogo.com.dogo_android.model.survey.SurveyQuestionModel;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.LessonModel;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.ModuleModel;
import app.dogo.com.dogo_android.model.trainingprogram.TrickModel;
import app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickCategory;
import app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickStep;
import app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickTag;
import app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickVideoStep;
import app.dogo.com.dogo_android.repository.domain.BitingProgramProgress;
import app.dogo.com.dogo_android.repository.domain.DogBreed;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.LibraryTag;
import app.dogo.com.dogo_android.repository.domain.ModuleCompletionSummary;
import app.dogo.com.dogo_android.repository.domain.ProgramCompletionSummary;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem.State;
import app.dogo.com.dogo_android.repository.domain.ProgramExam;
import app.dogo.com.dogo_android.repository.domain.ProgramExam.Status;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem;
import app.dogo.com.dogo_android.repository.domain.ProgramOverview;
import app.dogo.com.dogo_android.repository.domain.PublicDogProfile;
import app.dogo.com.dogo_android.repository.domain.SpecialOfferCoupon;
import app.dogo.com.dogo_android.repository.domain.SpecialOfferRemoteConfig;
import app.dogo.com.dogo_android.repository.domain.SurveyAnswer;
import app.dogo.com.dogo_android.repository.domain.SurveyQuestion;
import app.dogo.com.dogo_android.repository.domain.TrainingSession;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory;
import app.dogo.com.dogo_android.repository.domain.TrickItem.TrickStep;
import app.dogo.com.dogo_android.repository.domain.TrickItem.VideoStep;
import app.dogo.com.dogo_android.s.b.b1;
import app.dogo.com.dogo_android.s.b.b1.a;
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.n2.a;
import app.dogo.com.dogo_android.service.u2;
import app.dogo.com.dogo_android.subscription.DogoSkuDetails;
import app.dogo.com.dogo_android.subscription.DogoSkuDetails.Companion;
import app.dogo.com.dogo_android.util.exceptions.CustomExceptions.DataNotFound;
import app.dogo.com.dogo_android.util.l0.b;
import app.dogo.com.dogo_android.view.main_screen.h;
import app.dogo.com.dogo_android.w.a0;
import app.dogo.com.dogo_android.w.a3;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q2;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.externalmodel.model.TrainingReminderModel.Weekdays;
import app.dogo.externalmodel.model.responses.ProgramProgress;
import app.dogo.externalmodel.model.responses.ProgramProgress.ExamSubmission;
import app.dogo.externalmodel.model.responses.ProgramProgress.LessonProgress;
import app.dogo.externalmodel.model.responses.ProgramProgress.ModuleProgress;
import app.dogo.externalmodel.model.responses.ProgramProgress.ProgramExamStatus;
import com.android.billingclient.api.SkuDetails;
import com.facebook.e0.g;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.m;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.Source;
import com.google.firebase.inappmessaging.model.CardMessage;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.gson.Gson;
import com.revenuecat.purchases.EntitlementInfo;
import com.revenuecat.purchases.EntitlementInfos;
import com.revenuecat.purchases.ListenerConversionsKt;
import com.revenuecat.purchases.PackageType;
import com.revenuecat.purchases.PurchaserInfo;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesError;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;
import d.h.l.d;
import d.h.l.u.f;
import i.b.a0;
import i.b.b;
import i.b.c;
import i.b.c0;
import i.b.i0.b.a;
import i.b.j0.a;
import i.b.r0.a;
import i.b.s0.a;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h0.g;
import kotlin.k0.f;
import kotlin.k0.h;
import kotlin.k0.j;
import kotlin.k0.l;
import kotlin.u;
import kotlin.w;
import kotlin.y.h0;
import kotlin.y.p;
import kotlin.z.a;
import n.a.a;
import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.b;
import nl.dionsegijn.konfetti.e.b.a;
import nl.dionsegijn.konfetti.e.b.c;
import nl.dionsegijn.konfetti.e.c;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Ì\u0004\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0008\u0004\n\u0002\u0010\u001c\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a\u0008\u0010\t\u001a\u00020\nH\u0002\u001a\u000e\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u0001\u001a\n\u0010\u000e\u001a\u00020\u000f*\u00020\u0010\u001aP\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u001a2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u000c2\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u001a*\u0010\u001f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\"0!0 \"\u0004\u0008\u0000\u0010\"*\u00020#2\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u0002H\"0%\u001a\n\u0010&\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010'\u001a\u00020\u000f*\u00020(\u001a\u0012\u0010)\u001a\u00020\u0017*\u00020(2\u0006\u0010*\u001a\u00020\u0001\u001a,\u0010+\u001a\u0008\u0012\u0004\u0012\u0002H\"0 \"\u0004\u0008\u0000\u0010\"*\u00020,2\u0006\u0010-\u001a\u00020.2\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u0002H\"0%\u001a$\u0010+\u001a\u0008\u0012\u0004\u0012\u0002H\"0 \"\u0004\u0008\u0000\u0010\"*\u00020,2\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u0002H\"0%\u001a2\u0010+\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\"0!0 \"\u0004\u0008\u0000\u0010\"*\u00020#2\u0006\u0010-\u001a\u00020.2\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u0002H\"0%\u001a*\u0010+\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\"0!0 \"\u0004\u0008\u0000\u0010\"*\u00020#2\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u0002H\"0%\u001a\n\u0010/\u001a\u00020\u000f*\u00020(\u001a6\u00100\u001a\u00020\u000f*\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00012\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u000f08\u001a0\u0010:\u001a\u000e\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u0002H=0;\"\u0004\u0008\u0000\u0010<\"\u0004\u0008\u0001\u0010=*\u0010\u0012\u0004\u0012\u0002H<\u0012\u0006\u0012\u0004\u0018\u0001H=0;\u001a>\u0010>\u001a\u0008\u0012\u0004\u0012\u0002H?0!\"\u0004\u0008\u0000\u0010\"\"\u0004\u0008\u0001\u0010?*\u0008\u0012\u0004\u0012\u0002H\"0@2\u001a\u0010A\u001a\u0016\u0012\u0004\u0012\u0002H\"\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H?0@08\u001a\u001a\u0010B\u001a\u00020C*\u00020C2\u0006\u0010D\u001a\u00020\u00012\u0006\u0010E\u001a\u00020\u0001\u001a\n\u0010F\u001a\u00020\u0001*\u00020G\u001a\n\u0010F\u001a\u00020\u0001*\u00020H\u001a\n\u0010F\u001a\u00020\u0001*\u00020I\u001a\n\u0010J\u001a\u00020\u0001*\u00020K\u001a\n\u0010L\u001a\u00020\u0001*\u00020K\u001a\n\u0010M\u001a\u00020N*\u00020\u0006\u001a\n\u0010O\u001a\u00020P*\u00020Q\u001a\u0010\u0010R\u001a\u0008\u0012\u0004\u0012\u00020S0!*\u00020T\u001a$\u0010U\u001a\u00020V*\u00020W2\u0008\u0010X\u001a\u0004\u0018\u00010Y2\u0006\u0010Z\u001a\u00020\u00012\u0006\u0010[\u001a\u00020\\\u001a\u000c\u0010]\u001a\u00020\u000c*\u0004\u0018\u00010^\u001a\u0011\u0010_\u001a\u0004\u0018\u00010\u0005*\u00020^¢\u0006\u0002\u0010`\u001a\n\u0010a\u001a\u00020\u000c*\u00020\u0012\u001a\n\u0010a\u001a\u00020\u000c*\u00020b\u001a\u001a\u0010c\u001a\u00020d*\u00020e2\u0006\u0010f\u001a\u00020\u00012\u0006\u0010[\u001a\u00020\\\u001a$\u0010c\u001a\u00020d*\u00020\u00132\u0008\u0010g\u001a\u0004\u0018\u00010h2\u0006\u0010f\u001a\u00020\u00012\u0006\u0010[\u001a\u00020\\\u001a\u0011\u0010i\u001a\u0004\u0018\u00010\u0005*\u00020j¢\u0006\u0002\u0010k\u001a\u0011\u0010l\u001a\u0004\u0018\u00010\u001a*\u00020j¢\u0006\u0002\u0010m\u001a\n\u0010n\u001a\u00020\u000c*\u00020o\u001a\u000c\u0010p\u001a\u00020\u000c*\u0004\u0018\u00010^\u001a\u001a\u0010q\u001a\u00020\u0001*\u00020\u00012\u0006\u0010r\u001a\u00020\u00012\u0006\u0010s\u001a\u00020t\u001a\n\u0010u\u001a\u00020\u0017*\u00020\u0001\u001a\n\u0010v\u001a\u00020\u0017*\u00020w\u001a\u0010\u0010x\u001a\u00020\u0017*\u0008\u0012\u0004\u0012\u00020S0!\u001a\n\u0010y\u001a\u00020\u0017*\u00020w\u001a\n\u0010z\u001a\u00020\u0017*\u00020{\u001a\n\u0010|\u001a\u00020\u0017*\u00020{\u001a\u0010\u0010}\u001a\u0008\u0012\u0004\u0012\u00020\u00170 *\u00020~\u001a\u001c\u0010\u007f\u001a\t\u0012\u0005\u0012\u00030\u0080\u00010 *\u00030\u0081\u00012\u0008\u0010\u0082\u0001\u001a\u00030\u0083\u0001\u001a\u0018\u0010\u0084\u0001\u001a\u00020\u000f*\u00030\u0085\u00012\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u0001\u001a\u000e\u0010\u0088\u0001\u001a\u0004\u0018\u00010H*\u00030\u0089\u0001\u001a'\u0010\u008a\u0001\u001a\u00030\u008b\u0001*\u00020b2\u0007\u0010\u008c\u0001\u001a\u0002092\u0007\u0010\u008d\u0001\u001a\u00020\u00012\u0007\u0010\u008e\u0001\u001a\u00020\u0001\u001a\u000b\u0010\u008f\u0001\u001a\u00020\u000c*\u00020\u0006\u001a\u001f\u0010\u0090\u0001\u001a\u00030\u0091\u0001*\u00030\u0092\u00012\u0007\u0010\u0093\u0001\u001a\u00020\u000c2\u0007\u0010\u0094\u0001\u001a\u00020\u000c\u001a\r\u0010\u0095\u0001\u001a\u00030\u0096\u0001*\u00030\u0097\u0001\u001a\u0012\u0010\u0098\u0001\u001a\t\u0012\u0005\u0012\u00030\u0099\u00010!*\u00020\u0001\u001a\r\u0010\u009a\u0001\u001a\u00030\u009b\u0001*\u00030\u0097\u0001\u001a\u001c\u0010\u009c\u0001\u001a\t\u0012\u0004\u0012\u00020\u00010\u009d\u0001*\u00030\u009e\u00012\u0007\u0010\u009f\u0001\u001a\u00020\u0017\u001a[\u0010 \u0001\u001a\u00020\u000f\"\u0004\u0008\u0000\u0010\"*\t\u0012\u0004\u0012\u0002H\"0¡\u00012\u0008\u0010¢\u0001\u001a\u00030£\u00012'\u0010¤\u0001\u001a\"\u0012\u0018\u0012\u0016\u0018\u0001H\"¢\u0006\u000f\u0008¥\u0001\u0012\n\u0008¦\u0001\u0012\u0005\u0008\u0008(§\u0001\u0012\u0004\u0012\u00020\u0017082\u000e\u0010¨\u0001\u001a\t\u0012\u0004\u0012\u0002H\"0©\u0001\u001a\u000b\u0010ª\u0001\u001a\u00020\u0001*\u00020\u0001\u001a5\u0010«\u0001\u001a\u0008\u0012\u0004\u0012\u0002H\"0!\"\u0004\u0008\u0000\u0010\"*\u0008\u0012\u0004\u0012\u0002H\"0!2\u0007\u0010¬\u0001\u001a\u0002H\"2\u0007\u0010­\u0001\u001a\u0002H\"¢\u0006\u0003\u0010®\u0001\u001a\u000b\u0010¯\u0001\u001a\u00020\u0001*\u00020\u0001\u001a\u0013\u0010°\u0001\u001a\u0004\u0018\u00010\u000c*\u00020\u0001¢\u0006\u0003\u0010±\u0001\u001a(\u0010²\u0001\u001a\u00020\u000f*\u00030³\u00012\u0008\u0010´\u0001\u001a\u00030µ\u00012\u0007\u0010\u0093\u0001\u001a\u00020\u000c2\u0007\u0010¶\u0001\u001a\u00020\u000c\u001a\u0016\u0010·\u0001\u001a\u00030¸\u0001*\u00030¸\u00012\u0007\u0010¹\u0001\u001a\u00020\u000c\u001a\u0015\u0010º\u0001\u001a\u00020\u000f*\u00020\u00102\u0008\u0010»\u0001\u001a\u00030¼\u0001\u001a\u001f\u0010½\u0001\u001a\u00020\u000f*\u00030¾\u00012\u0008\u0010¿\u0001\u001a\u00030À\u00012\u0007\u00107\u001a\u00030Á\u0001\u001a%\u0010Â\u0001\u001a\t\u0012\u0004\u0012\u00020S0Ã\u0001*\u0008\u0012\u0004\u0012\u00020S0!2\u000b\u0008\u0002\u0010Ä\u0001\u001a\u0004\u0018\u00010S\u001a\u0011\u0010Å\u0001\u001a\u00020\u0017*\u00080Æ\u0001j\u0003`Ç\u0001\u001a\u000c\u0010È\u0001\u001a\u00020\u000f*\u00030É\u0001\u001a\u000c\u0010Ê\u0001\u001a\u00020\u000f*\u00030É\u0001\u001a\u0014\u0010Ë\u0001\u001a\u00030Ì\u0001*\n\u0012\u0005\u0012\u00030Í\u00010\u009d\u0001\u001a\r\u0010Î\u0001\u001a\u00030Ï\u0001*\u00030Ð\u0001\u001a\u001d\u0010Ñ\u0001\u001a\t\u0012\u0005\u0012\u00030Ò\u00010!*\u00020\u00132\t\u0010Ó\u0001\u001a\u0004\u0018\u00010h\u001a\u0015\u0010Ô\u0001\u001a\u00020\u0001*\u00020\u001a2\u0008\u0010Õ\u0001\u001a\u00030Ö\u0001\u001a\u0018\u0010×\u0001\u001a\u0008\u0012\u0004\u0012\u00020\u00010 *\t\u0012\u0004\u0012\u00020\u00010\u009d\u0001\u001a\u0013\u0010×\u0001\u001a\t\u0012\u0005\u0012\u00030Ø\u00010 *\u00030Ù\u0001\u001a9\u0010Ú\u0001\u001a\u00020S*\u00030Û\u00012\t\u0010Ü\u0001\u001a\u0004\u0018\u00010\u000c2\u000f\u0008\u0002\u0010Ý\u0001\u001a\u0008\u0012\u0004\u0012\u00020\u00010!2\t\u0008\u0002\u0010Þ\u0001\u001a\u00020\u0017¢\u0006\u0003\u0010ß\u0001\u001a\u0013\u0010à\u0001\u001a\u00030á\u0001*\t\u0012\u0004\u0012\u00020\u00170Ã\u0001\u001a\u0015\u0010â\u0001\u001a\u00020\u0001*\u00020\u00012\u0008\u0010ã\u0001\u001a\u00030ä\u0001\u001a\u0015\u0010â\u0001\u001a\u00020\u0001*\u00020\u00012\u0008\u0010Õ\u0001\u001a\u00030Ö\u0001\u001a\u000b\u0010å\u0001\u001a\u00020\u0017*\u00020{\u001a\u000b\u0010æ\u0001\u001a\u00020\u0017*\u00020{\u001a\u000b\u0010ç\u0001\u001a\u00020\u0017*\u00020{\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006è\u0001", d2 = {"ACTIVITY_NOT_ATTACHED", "", "NAVIGATION_AFTER_SAVE_INSTANCE", "NAVIGATION_PARENT", "priceAmount", "", "Lcom/android/billingclient/api/SkuDetails;", "getPriceAmount", "(Lcom/android/billingclient/api/SkuDetails;)D", "getLocaleWithJapanTempFix", "Ljava/util/Locale;", "getPercent", "", "sku", "bottomConfettiExplosion", "", "Lnl/dionsegijn/konfetti/KonfettiView;", "buildProgramDescriptionItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;", "status", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem$State;", "specialImageForRecommended", "", "shouldOpenProgramOverview", "programStartTimeMs", "", "isSpecial", "programFit", "overview", "Lapp/dogo/com/dogo_android/repository/domain/ProgramOverview;", "cachedFirstContentFetch", "Lio/reactivex/Single;", "", "T", "Lcom/google/firebase/firestore/Query;", "objectClass", "Ljava/lang/Class;", "capitalizeSentences", "clearBackstack", "Landroidx/fragment/app/FragmentManager;", "containsTag", "tag", "createSingle", "Lcom/google/firebase/firestore/DocumentReference;", "source", "Lcom/google/firebase/firestore/Source;", "dismissAllDialogs", "fetchDogProfile", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntryPhotoBaseObservable;", "userLocalCacheService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "dogId", "callback", "Lkotlin/Function1;", "Lapp/dogo/com/dogo_android/model/DogProfileModel;", "filterNotNullValues", "", "K", "V", "flatMapNotNull", "R", "", "transform", "forPair", "Landroid/os/Bundle;", "key", "value", "getActiveTag", "Lapp/dogo/com/dogo_android/model/ChallengeComment;", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "Lapp/dogo/com/dogo_android/model/ChallengeEntryVoter;", "getBirthdayDateString", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "getBreedName", "getCurrencyFormatter", "Ljava/text/NumberFormat;", "getCustomDogoType", "Lapp/dogo/com/dogo_android/view/main_screen/FiamType;", "Lcom/google/firebase/inappmessaging/model/CardMessage;", "getLessonsNewTricks", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "getModuleCompletionSummary", "Lapp/dogo/com/dogo_android/repository/domain/ModuleCompletionSummary;", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel$ModuleModel;", "moduleProgressModel", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$ModuleProgress;", "currentModuleId", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "getPercentDiscount", "Lapp/dogo/com/dogo_android/subscription/DogoSkuDetails;", "getPricePerDay", "(Lapp/dogo/com/dogo_android/subscription/DogoSkuDetails;)Ljava/lang/Double;", "getPrimaryOrderPriority", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "getProgramCompletionSummary", "Lapp/dogo/com/dogo_android/repository/domain/ProgramCompletionSummary;", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramAndProgressModel;", "currentLessonId", "programProgressModel", "Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "getTextAsDoubleOrNull", "Landroid/widget/EditText;", "(Landroid/widget/EditText;)Ljava/lang/Double;", "getTextAsLongOrNull", "(Landroid/widget/EditText;)Ljava/lang/Long;", "getTopPosition", "Lcom/yuyakaido/android/cardstackview/CardStackView;", "getTrialDays", "insertDogName", "dogName", "locale", "Lapp/dogo/com/dogo_android/service/LocaleService$SupportedLocales;", "isAnonymous", "isEmpty", "Lapp/dogo/com/dogo_android/repository/domain/TrainingSession;", "isIntermediateTraining", "isNotEmpty", "isPremiumActive", "Lcom/revenuecat/purchases/PurchaserInfo;", "isPremiumNotActive", "isUserEligibleForFreeTrailByRegexCheck", "Lcom/revenuecat/purchases/Purchases;", "linkWithCredentialSingle", "Lcom/google/firebase/auth/AuthResult;", "Lcom/google/firebase/auth/FirebaseUser;", "lastCredential", "Lcom/google/firebase/auth/AuthCredential;", "logEvent", "Lcom/facebook/appevents/AppEventsLogger;", "fbEvent", "Lapp/dogo/com/dogo_android/tracking/FBEvent;", "parseEntryModel", "Lapp/dogo/com/dogo_android/model/ChallengeNotificationModel;", "parseExam", "Lapp/dogo/com/dogo_android/model/Exam;", "dogProfileModel", "userId", "userLocale", "parseFreeTrialPeriodToDays", "parseItem", "Lapp/dogo/com/dogo_android/repository/domain/SurveyQuestion;", "Lapp/dogo/com/dogo_android/model/survey/SurveyQuestionModel;", "position", "total", "parseProgramExamStatus", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam$Status;", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$ExamSubmission;", "parseSpecialOffers", "Lapp/dogo/com/dogo_android/repository/domain/SpecialOfferCoupon;", "parseStatus", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$ProgramExamStatus;", "refreshIdToken", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/firebase/auth/FirebaseAuth;", "forceUpdate", "removableObserve", "Landroidx/lifecycle/LiveData;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "removeObserverPredicate", "Lkotlin/ParameterName;", "name", "results", "observer", "Landroidx/lifecycle/Observer;", "removeSpecialSymbolsForCoupon", "replace", "newValue", "oldValue", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/List;", "returnEmptyIfAnonymousNameFound", "safeParseToInt", "(Ljava/lang/String;)Ljava/lang/Integer;", "scrollToPositionMiddleInsideNestedView", "Landroidx/recyclerview/widget/RecyclerView;", "nestedScrollView", "Landroidx/core/widget/NestedScrollView;", "scrollDuration", "setMaxLines", "Lcom/google/android/material/snackbar/Snackbar;", "numberOfLines", "setUpOnbaordingConfetti", "width", "", "setupTouchListener", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "Lapp/dogo/com/dogo_android/util/listeners/ViewPagerListener;", "setupTrickListForIntermediateTraining", "", "selectedTrick", "shouldLogAsWarning", "Ljava/lang/Exception;", "Lkotlin/Exception;", "smoothNextItem", "Landroidx/viewpager2/widget/ViewPager2;", "smoothReverseItem", "toCompletable", "Lio/reactivex/Completable;", "Ljava/lang/Void;", "toDogBreed", "Lapp/dogo/com/dogo_android/repository/domain/DogBreed;", "Lapp/dogo/android/persistencedb/room/entity/BreedEntity;", "toFlatLessonData", "Lapp/dogo/com/dogo_android/model/trainingprogram/LessonAndProgressModel;", "progressModel", "toIntervalString", "resources", "Landroid/content/res/Resources;", "toSingle", "Lcom/google/firebase/database/DataSnapshot;", "Lcom/google/firebase/database/DatabaseReference;", "toTrickItem", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel;", "knowledge", "lockedTricks", "isUserSubscribed", "(Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel;Ljava/lang/Integer;Ljava/util/List;Z)Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "toWeekdays", "Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;", "translateIfAnonymousNameFound", "context", "Landroid/content/Context;", "userCancelledSubscription", "userHaveLifetimeSubscription", "userWillRenewSubscription", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class j1 {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class a {

        public static final int[] a;
        public static final int[] b;
        public static final int[] c;
        public static final int[] d;
        static {
            int[] iArr = new int[values.length];
            final int i = 1;
            iArr[ProgramProgress.ProgramExamStatus.LOCKED.ordinal()] = i;
            final int i2 = 2;
            iArr[ProgramProgress.ProgramExamStatus.READY.ordinal()] = i2;
            final int i3 = 3;
            iArr[ProgramProgress.ProgramExamStatus.UPLOADING.ordinal()] = i3;
            final int i4 = 4;
            iArr[ProgramProgress.ProgramExamStatus.PENDING.ordinal()] = i4;
            final int i5 = 5;
            iArr[ProgramProgress.ProgramExamStatus.PASSED.ordinal()] = i5;
            final int i6 = 6;
            iArr[ProgramProgress.ProgramExamStatus.APPROVED.ordinal()] = i6;
            final int i7 = 7;
            iArr[ProgramProgress.ProgramExamStatus.REJECTED.ordinal()] = i7;
            j1.a.a = iArr;
            int[] iArr2 = new int[values2.length];
            iArr2[ProgramExam.Status.LOCKED.ordinal()] = i;
            iArr2[ProgramExam.Status.UNAVAILABLE_HEADER.ordinal()] = i2;
            iArr2[ProgramExam.Status.PREMIUM_LOCKED.ordinal()] = i3;
            iArr2[ProgramExam.Status.READY.ordinal()] = i4;
            iArr2[ProgramExam.Status.PENDING.ordinal()] = i5;
            iArr2[ProgramExam.Status.REJECTED.ordinal()] = i6;
            iArr2[ProgramExam.Status.APPROVED.ordinal()] = i7;
            iArr2[ProgramExam.Status.AVAILABLE_HEADER.ordinal()] = 8;
            iArr2[ProgramExam.Status.PROGRESS_HEADER.ordinal()] = 9;
            iArr2[ProgramExam.Status.CERTIFICATE_HEADER.ordinal()] = 10;
            j1.a.b = iArr2;
            int[] iArr3 = new int[values3.length];
            iArr3[ProgramDescriptionItem.State.HEADER.ordinal()] = i;
            iArr3[ProgramDescriptionItem.State.RECOMMENDED_BIG.ordinal()] = i2;
            iArr3[ProgramDescriptionItem.State.IN_PROGRESS.ordinal()] = i3;
            iArr3[ProgramDescriptionItem.State.RECOMMENDED.ordinal()] = i4;
            iArr3[ProgramDescriptionItem.State.NOT_STARTED.ordinal()] = i5;
            iArr3[ProgramDescriptionItem.State.COMPLETED.ordinal()] = i6;
            iArr3[ProgramDescriptionItem.State.COMING_SOON.ordinal()] = i7;
            j1.a.c = iArr3;
            int[] iArr4 = new int[values4.length];
            iArr4[n2.a.ENGLISH.ordinal()] = i;
            iArr4[n2.a.GERMAN.ordinal()] = i2;
            iArr4[n2.a.SPANISH.ordinal()] = i3;
            iArr4[n2.a.FRENCH.ordinal()] = i4;
            iArr4[n2.a.PORTUGUESE.ordinal()] = i5;
            iArr4[n2.a.DUTCH.ordinal()] = i6;
            iArr4[n2.a.SWEDISH.ordinal()] = i7;
            j1.a.d = iArr4;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 5, 1})
    public static final class f implements Comparator {
        public final int compare(T t, T t2) {
            return a.c((ChallengeNotificationModel.EntryImageObject)t2.getCreatedAt(), (ChallengeNotificationModel.EntryImageObject)t.getCreatedAt());
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/com/dogo_android/util/extensionfunction/ExtensionsKt$setupTouchListener$tapGestureDetector$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onSingleTapUp", "", "e", "Landroid/view/MotionEvent;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class h extends GestureDetector.SimpleOnGestureListener {

        final b a;
        h(b b) {
            this.a = b;
            super();
        }

        @Override // android.view.GestureDetector$SimpleOnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            n.f(motionEvent, "e");
            this.a.f();
            return 1;
        }
    }

    @Metadata(d1 = "\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0005¨\u0006\u0006", d2 = {"app/dogo/com/dogo_android/util/extensionfunction/ExtensionsKt$removableObserve$1", "Landroidx/lifecycle/Observer;", "onChanged", "", "t", "(Ljava/lang/Object;)V", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class g implements y<T> {

        final y<T> a;
        final l<T, Boolean> b;
        final LiveData<T> c;
        g(y<T> y, l<? super T, Boolean> l2, LiveData<T> liveData3) {
            this.a = y;
            this.b = l2;
            this.c = liveData3;
            super();
        }

        public void onChanged(T t) {
            boolean obj2;
            this.a.onChanged(t);
            if ((Boolean)this.b.invoke(t).booleanValue()) {
                this.c.removeObserver(this);
            }
        }
    }

    @Metadata(d1 = "\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t", d2 = {"app/dogo/com/dogo_android/util/extensionfunction/ExtensionsKt$toSingle$1$1", "Lcom/google/firebase/database/ValueEventListener;", "onCancelled", "", "databaseError", "Lcom/google/firebase/database/DatabaseError;", "onDataChange", "dataSnapshot", "Lcom/google/firebase/database/DataSnapshot;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class i implements ValueEventListener {

        final c0<DataSnapshot> a;
        final DatabaseReference b;
        i(c0<DataSnapshot> c0, DatabaseReference databaseReference2) {
            this.a = c0;
            this.b = databaseReference2;
            super();
        }

        @Override // com.google.firebase.database.ValueEventListener
        public void onCancelled(DatabaseError databaseError) {
            n.f(databaseError, "databaseError");
            this.b.removeEventListener(this);
            final com.google.firebase.database.DatabaseException obj2 = databaseError.toException();
            n.e(obj2, "databaseError.toException()");
            a.d(obj2);
            this.a.a(obj2);
        }

        @Override // com.google.firebase.database.ValueEventListener
        public void onDataChange(DataSnapshot dataSnapshot) {
            n.f(dataSnapshot, "dataSnapshot");
            this.a.onSuccess(dataSnapshot);
            this.b.removeEventListener(this);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<Throwable, w> {

        final l<DogProfileModel, w> $callback;
        final String $dogId;
        b(l<? super DogProfileModel, w> l, String string2) {
            this.$callback = l;
            this.$dogId = string2;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Throwable)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Throwable throwable) {
            Object obj = this;
            n.f(throwable, "it");
            a.d(throwable);
            super(0, 0, 0, 0, 0, 0, 0, obj.$dogId, 0, 0, 0, 1919, 0);
            obj.$callback.invoke(dogProfileModel3);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/repository/domain/PublicDogProfile;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements l<PublicDogProfile, w> {

        final l<DogProfileModel, w> $callback;
        c(l<? super DogProfileModel, w> l) {
            this.$callback = l;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(PublicDogProfile publicDogProfile) {
            this.$callback.invoke(publicDogProfile.toDogModel());
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((PublicDogProfile)object);
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "error", "Lcom/revenuecat/purchases/PurchasesError;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements l<PurchasesError, w> {

        final c0<Boolean> $emitter;
        d(c0<Boolean> c0) {
            this.$emitter = c0;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((PurchasesError)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(PurchasesError purchasesError) {
            n.f(purchasesError, "error");
            a.c(String.valueOf(purchasesError), new Object[0]);
            this.$emitter.onSuccess(Boolean.FALSE);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "purchaserInfo", "Lcom/revenuecat/purchases/PurchaserInfo;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements l<PurchaserInfo, w> {

        final c0<Boolean> $emitter;
        e(c0<Boolean> c0) {
            this.$emitter = c0;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((PurchaserInfo)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(PurchaserInfo purchaserInfo) {
            boolean empty;
            int i;
            int i3;
            int i2;
            String str;
            Object obj7;
            n.f(purchaserInfo, "purchaserInfo");
            obj7 = purchaserInfo.getAllPurchasedSkus();
            if (obj7 instanceof Collection != null && obj7.isEmpty()) {
                if (obj7.isEmpty()) {
                    i = i4;
                } else {
                    obj7 = obj7.iterator();
                    while (obj7.hasNext()) {
                        if (!l.R((String)obj7.next(), "freetrial", false, 2, 0)) {
                            break;
                        }
                    }
                }
            } else {
            }
            this.$emitter.onSuccess(Boolean.valueOf(i));
        }
    }
    private static final Locale A() {
        Locale jAPAN;
        if (n.b(e.d().c(0).getLanguage(), "ja")) {
            jAPAN = Locale.JAPAN;
        }
        n.e(jAPAN, "default");
        return jAPAN;
    }

    public static final Snackbar A0(Snackbar snackbar, int i2) {
        n.f(snackbar, "<this>");
        View viewById = snackbar.F().findViewById(2131363246);
        Objects.requireNonNull(viewById, "null cannot be cast to non-null type android.widget.TextView");
        (TextView)viewById.setMaxLines(i2);
        return snackbar;
    }

    public static final ModuleCompletionSummary B(ProgramModel.ModuleModel programModel$ModuleModel, ProgramProgress.ModuleProgress programProgress$ModuleProgress2, String string3, j1 j14) {
        Object next;
        int i3;
        int i2;
        int passed;
        Iterator iterator;
        boolean next2;
        boolean z;
        int i;
        String str;
        n.f(moduleModel, "<this>");
        n.f(string3, "currentModuleId");
        n.f(j14, "programRepository");
        ArrayList arrayList = new ArrayList();
        Iterator obj14 = moduleModel.getLessons().iterator();
        while (obj14.hasNext()) {
            next = obj14.next();
            if (moduleProgress2 == null) {
            } else {
            }
            iterator = moduleProgress2.getLessons();
            if (iterator == null) {
            } else {
            }
            iterator = iterator.iterator();
            while (iterator.hasNext()) {
                next2 = iterator.next();
                Object obj2 = next2;
                if ((ProgramProgress.LessonProgress)obj2 == null) {
                } else {
                }
                i = (ProgramProgress.LessonProgress)obj2.getId();
                if (n.b(i, (ProgramModel.LessonModel)next.getId())) {
                    break loop_7;
                } else {
                }
                i = passed;
            }
            if (passed == 0) {
            } else {
            }
            if (passed.isPassed() != 1) {
            }
            i3 = i2;
            if (i3 != 0) {
            }
            arrayList.add(next);
            next2 = iterator.next();
            obj2 = next2;
            if ((ProgramProgress.LessonProgress)obj2 == null) {
            } else {
            }
            i = (ProgramProgress.LessonProgress)obj2.getId();
            if (n.b(i, obj.getId())) {
            } else {
            }
            passed = next2;
            i = passed;
        }
        super(moduleModel.getId(), moduleModel.getLessons().size(), arrayList.size(), obj11 + 1, n.b(moduleModel.getId(), string3));
        return obj11;
    }

    public static final void B0(KonfettiView konfettiView, float f2) {
        n.f(konfettiView, "<this>");
        b bVar = konfettiView.a();
        int i = 1;
        int[] iArr = new int[i];
        int i5 = 0;
        iArr[i5] = a.d(konfettiView.getContext(), 2131100336);
        bVar.a(iArr);
        bVar.h(0, obj5);
        bVar.k(1084227584, 1094713344);
        bVar.i(i);
        bVar.l(4000);
        nl.dionsegijn.konfetti.e.b[] obj8 = new b[i];
        obj8[i5] = b.c.b;
        bVar.b(obj8);
        obj8 = new c[i];
        int i3 = 12;
        c cVar = new c(i3, 1140457472);
        obj8[i5] = cVar;
        bVar.c(obj8);
        int obj9 = -1035468800;
        bVar.j(obj9, Float.valueOf(f2 += obj8), obj9, Float.valueOf(obj9));
        bVar.o(100, Long.MAX_VALUE);
    }

    public static final int C(String string) {
        int int;
        String value;
        String str;
        String str2;
        int i3;
        int i;
        int i2;
        Object obj10;
        n.f(string, "sku");
        h hVar = new h("\\d*pc");
        obj10 = h.b(hVar, string, 0, 2, 0);
        if (obj10 == null) {
        } else {
            value = obj10.getValue();
        }
        final String str5 = value;
        if (str5 == null) {
        } else {
            obj10 = l.G(str5, "pc", "", false, 4, 0);
            if (obj10 == null) {
            } else {
                int = Integer.parseInt(obj10);
            }
        }
        return int;
    }

    public static final void C0(RecyclerView.e0 recyclerView$e0, View view2, b b3) {
        n.f(e0, "<this>");
        n.f(view2, "view");
        n.f(b3, "callback");
        j1.h hVar = new j1.h(b3);
        d obj2 = new d(view2.getContext(), hVar);
        p0 obj4 = new p0(obj2);
        view2.setOnTouchListener(obj4);
    }

    public static final double D(SkuDetails skuDetails) {
        n.f(skuDetails, "<this>");
        return d /= l2;
    }

    private static final boolean D0(d d, View view2, MotionEvent motionEvent3) {
        n.f(d, "$tapGestureDetector");
        n.f(view2, "touchView");
        d.a(motionEvent3);
        view2.performClick();
        return 1;
    }

    public static final Double E(DogoSkuDetails dogoSkuDetails) {
        String originalJson;
        PackageType subscriptionPeriod;
        PackageType lIFETIME;
        n.f(dogoSkuDetails, "<this>");
        if (dogoSkuDetails.getOriginalJson() == null) {
            originalJson = "";
        }
        SkuDetails skuDetails = new SkuDetails(originalJson);
        subscriptionPeriod = dogoSkuDetails.getSubscriptionPeriod();
        if (dogoSkuDetails.getSubscriptionPeriod() != PackageType.LIFETIME && dogoSkuDetails.getSubscriptionPeriod() != PackageType.UNKNOWN && subscriptionPeriod == PackageType.CUSTOM) {
            if (dogoSkuDetails.getSubscriptionPeriod() != PackageType.UNKNOWN) {
                subscriptionPeriod = dogoSkuDetails.getSubscriptionPeriod();
                if (subscriptionPeriod == PackageType.CUSTOM) {
                }
                return Double.valueOf(i /= d2);
            }
        }
        return null;
    }

    public static final List<TrickItem> E0(List<TrickItem> list, TrickItem trickItem2) {
        ArrayList arrayList;
        boolean next;
        int i;
        Object obj;
        boolean notRatedByUser;
        List obj4;
        Object obj5;
        n.f(list, "<this>");
        if (j1.N(list)) {
            arrayList = new ArrayList();
            obj4 = list.iterator();
            while (obj4.hasNext()) {
                next = obj4.next();
                obj = next;
                if ((TrickItem)obj.getNewContent() && !obj.isNotRatedByUser()) {
                } else {
                }
                i = 1;
                if (i != 0) {
                }
                arrayList.add(next);
                if (!obj.isNotRatedByUser()) {
                } else {
                }
                if (trickItem2 == null) {
                } else {
                }
                notRatedByUser = trickItem2.getId();
                if (n.b(obj.getId(), notRatedByUser)) {
                } else {
                }
                i = 0;
                notRatedByUser = 0;
            }
            obj4 = p.N0(arrayList);
        } else {
            obj4 = p.N0(list);
        }
        if (trickItem2 != null) {
            Collections.rotate(obj4, -obj5);
        }
        return obj4;
    }

    public static final int F(ProgramDescriptionItem programDescriptionItem) {
        int i;
        n.f(programDescriptionItem, "<this>");
        i = 1;
        switch (obj1) {
            case 1:
                i = 0;
                return i;
            case 2:
                return i;
            case 3:
                i = 2;
                return i;
            case 4:
                i = 3;
                return i;
            case 5:
                i = 4;
                return i;
            case 6:
                i = 5;
                return i;
            default:
                NoWhenBranchMatchedException obj1 = new NoWhenBranchMatchedException();
                throw obj1;
        }
    }

    public static final boolean F0(Exception exception) {
        int i;
        boolean i2;
        n.f(exception, "<this>");
        i = exception instanceof DogExceptions.NameIsTooShort ? i2 : exception instanceof DogExceptions.NameIsTooLong;
        if (i != 0) {
        } else {
            i2 = exception instanceof UnknownHostException;
        }
        return i2;
    }

    public static final int G(ProgramExam programExam) {
        int obj1;
        n.f(programExam, "<this>");
        switch (obj1) {
            case 1:
                obj1 = 0;
                break;
            case 2:
                obj1 = 1;
                break;
            case 3:
                obj1 = 2;
                break;
            case 4:
                obj1 = 3;
                break;
            case 5:
                obj1 = 4;
                break;
            case 6:
                obj1 = 5;
                break;
            case 7:
                obj1 = 6;
                break;
            case 8:
                obj1 = 7;
                break;
            case 9:
                obj1 = 8;
                break;
            default:
                obj1 = new NoWhenBranchMatchedException();
                throw obj1;
        }
        return obj1;
    }

    public static final void G0(ViewPager2 viewPager2) {
        n.f(viewPager2, "<this>");
        final int i2 = 1;
        viewPager2.k(currentItem += i2, i2);
    }

    public static final ProgramCompletionSummary H(ProgramModel programModel, ProgramProgress programProgress2, String string3, j1 j14) {
        Object next;
        int i;
        List iterator2;
        int i2;
        boolean iterator;
        int next2;
        boolean z;
        String str;
        String str2;
        String obj10;
        n.f(programModel, "<this>");
        n.f(string3, "currentLessonId");
        n.f(j14, "programRepository");
        Iterator iterator3 = programModel.getModules().iterator();
        i = 0;
        while (iterator3.hasNext()) {
            iterator2 = (ProgramModel.ModuleModel)iterator3.next().getLessons();
            next2 = 0;
            if (iterator2 instanceof Collection != null && iterator2.isEmpty()) {
            } else {
            }
            iterator2 = iterator2.iterator();
            while (iterator2.hasNext()) {
                if (n.b((ProgramModel.LessonModel)iterator2.next().getId(), string3)) {
                    break loop_6;
                } else {
                }
            }
            i = 0;
            if (n.b((ProgramModel.LessonModel)iterator2.next().getId(), string3)) {
            } else {
            }
            next2 = 1;
            if (iterator2.isEmpty()) {
            } else {
            }
        }
        next = i;
        if ((ProgramModel.ModuleModel)next == null) {
            obj10 = i;
        } else {
            obj10 = (ProgramModel.ModuleModel)next.getId();
        }
        if (obj10 == null) {
            obj10 = p.Z(programModel.getModules());
            if ((ProgramModel.ModuleModel)obj10 == null) {
                obj10 = str6;
            } else {
            }
        }
        List modules2 = programModel.getModules();
        ArrayList arrayList = new ArrayList(p.r(modules2, 10));
        Iterator iterator4 = modules2.iterator();
        while (iterator4.hasNext()) {
            Object next5 = iterator4.next();
            if (programProgress2 == null) {
            } else {
            }
            iterator = programProgress2.getModules();
            if (iterator == null) {
            } else {
            }
            iterator = iterator.iterator();
            while (iterator.hasNext()) {
                int i4 = next2;
                if ((ProgramProgress.ModuleProgress)i4 == 0) {
                } else {
                }
                str = (ProgramProgress.ModuleProgress)i4.getId();
                str = i;
            }
            next2 = i;
            arrayList.add(j1.B(next5, next2, obj10, j14));
            i4 = next2;
            if ((ProgramProgress.ModuleProgress)i4 == 0) {
            } else {
            }
            str = (ProgramProgress.ModuleProgress)i4.getId();
            if (n.b(str, next5.getId())) {
            } else {
            }
            str = i;
            next2 = i;
        }
        ProgramCompletionSummary obj9 = new ProgramCompletionSummary(arrayList, programModel.getCardBackgroundColor());
        return obj9;
    }

    public static final void H0(ViewPager2 viewPager2) {
        n.f(viewPager2, "<this>");
        final int i2 = 1;
        viewPager2.k(currentItem -= i2, i2);
    }

    public static final Double I(EditText editText) {
        n.f(editText, "<this>");
        return l.j(editText.getText().toString());
    }

    public static final b I0(j<Void> j) {
        n.f(j, "<this>");
        x0 x0Var = new x0(j);
        final b obj1 = b.g(x0Var);
        n.e(obj1, "create { emitter ->\n        this.addOnCompleteListener { task ->\n            if (task.isSuccessful) {\n                emitter.onComplete()\n            } else {\n                emitter.onError(task.exception ?: Exception(\"void task failed\"))\n            }\n        }\n    }");
        return obj1;
    }

    public static final Long J(EditText editText) {
        n.f(editText, "<this>");
        return l.o(editText.getText().toString());
    }

    private static final void J0(j j, c c2) {
        n.f(j, "$this_toCompletable");
        n.f(c2, "emitter");
        o0 o0Var = new o0(c2);
        j.addOnCompleteListener(o0Var);
    }

    public static final int K(CardStackView cardStackView) {
        androidx.recyclerview.widget.RecyclerView.p obj1;
        n.f(cardStackView, "<this>");
        if (obj1 instanceof CardStackLayoutManager != null) {
        } else {
            obj1 = 0;
        }
        if (obj1 == null) {
            obj1 = 0;
        } else {
            obj1 = obj1.n2();
        }
        return obj1;
    }

    private static final void K0(c c, j j2) {
        boolean successful;
        Exception obj2;
        n.f(c, "$emitter");
        if (j2.isSuccessful()) {
            c.onComplete();
        } else {
            if (j2.getException() == null) {
                obj2 = new Exception("void task failed");
            }
            c.onError(obj2);
        }
    }

    public static final String L(String string, String string2, n2.a n2$a3) {
        int[] iGNORE_CASE;
        h hVar;
        Object obj2;
        String obj4;
        n.f(string, "<this>");
        n.f(string2, "dogName");
        n.f(a3, "locale");
        switch (obj4) {
            case 1:
                obj4 = "the dog|your dog";
                break;
            case 2:
                obj4 = "dein Hund|deinem Hund|deinen Hund|der Hund|des Hundes|den Hund";
                break;
            case 3:
                obj4 = "el perro|al perro|tu perro|del perro";
                break;
            case 4:
                obj4 = "ton chien|au chie|le chien|du chien";
                break;
            case 5:
                obj4 = "o seu cachorro|o cachorro";
                break;
            case 6:
                obj4 = "jouw hond|je hond";
                break;
            case 7:
                obj4 = "din hund";
                break;
            default:
                obj4 = 0;
        }
        if (obj4 != null) {
            hVar = new h(obj4, j.IGNORE_CASE);
            obj2 = hVar.e(string, string2);
        }
        return obj2;
    }

    public static final DogBreed L0(BreedEntity breedEntity) {
        n.f(breedEntity, "<this>");
        String obj7 = breedEntity.getTitle();
        Objects.requireNonNull(obj7, "null cannot be cast to non-null type kotlin.CharSequence");
        super(breedEntity.getBreedId(), l.a1(obj7).toString(), 0, 4, 0);
        return dogBreed;
    }

    public static final boolean M(String string) {
        boolean equals;
        int i;
        u2 u2Var;
        Object q2Var;
        Object obj4;
        n.f(string, "<this>");
        i = 1;
        switch (string) {
            case "Anonimas":
                q2Var = new q2();
                App.Companion.r().d(a0.e.d(u.a(q2Var, string)));
                i = 0;
                break;
            case "Anonimowy":
                q2Var = new q2();
                App.Companion.r().d(a0.e.d(u.a(q2Var, string)));
                i = 0;
                break;
            case "Anonymous":
                i = 0;
                break;
            case "匿名":
                q2Var = new q2();
                App.Companion.r().d(a0.e.d(u.a(q2Var, string)));
                i = 0;
                break;
            case "名前なし":
                q2Var = new q2();
                App.Companion.r().d(a0.e.d(u.a(q2Var, string)));
                i = 0;
                break;
            case "Anoniem":
                q2Var = new q2();
                App.Companion.r().d(a0.e.d(u.a(q2Var, string)));
                i = 0;
                break;
            case "Anonimo":
                q2Var = new q2();
                App.Companion.r().d(a0.e.d(u.a(q2Var, string)));
                i = 0;
                break;
            case "Anonyme":
                q2Var = new q2();
                App.Companion.r().d(a0.e.d(u.a(q2Var, string)));
                i = 0;
                break;
            case "Anónimo":
                q2Var = new q2();
                App.Companion.r().d(a0.e.d(u.a(q2Var, string)));
                i = 0;
                break;
            case "Anonym":
                q2Var = new q2();
                App.Companion.r().d(a0.e.d(u.a(q2Var, string)));
                i = 0;
                break;
            case "Анонимный":
                q2Var = new q2();
                App.Companion.r().d(a0.e.d(u.a(q2Var, string)));
                i = 0;
                break;
            default:
                i = 0;
        }
        return i;
    }

    public static final String M0(long l, Resources resources2) {
        Object[] arr;
        Integer valueOf;
        String obj3;
        String obj4;
        n.f(obj5, "resources");
        int i2 = 0;
        int i3 = 1;
        if (Long.compare(l, millis) < 0) {
            obj3 = (int)obj3;
            arr = new Object[i3];
            arr[i2] = Integer.valueOf(obj3);
            n.e(obj5.getQuantityString(2131755025, obj3, arr), "{\n        val minutes = TimeUnit.MILLISECONDS.toMinutes(this).toInt()\n        resources.getQuantityString(\n            R.plurals.time_placeholder_min,\n            minutes,\n            minutes\n        )\n    }");
        } else {
            obj3 = (int)obj3;
            arr = new Object[i3];
            arr[i2] = Integer.valueOf(obj3);
            n.e(obj5.getQuantityString(2131755024, obj3, arr), "{\n        val hours = TimeUnit.MILLISECONDS.toHours(this).toInt()\n        resources.getQuantityString(\n            R.plurals.time_placeholder_hour,\n            hours,\n            hours\n        )\n    }");
        }
        return obj3;
    }

    public static final boolean N(List<TrickItem> list) {
        boolean empty;
        Object ratedByUser;
        int i;
        boolean newContent2;
        boolean next;
        Object notRatedByUser;
        boolean newContent;
        Object obj6;
        n.f(list, "<this>");
        i = 1;
        final int i2 = 0;
        if (list.size() > i) {
            empty = list instanceof Collection;
            if (empty && list.isEmpty()) {
                if (list.isEmpty()) {
                    newContent2 = i2;
                } else {
                    newContent2 = list.iterator();
                    while (newContent2.hasNext()) {
                        notRatedByUser = newContent2.next();
                        if ((TrickItem)notRatedByUser.getNewContent() && notRatedByUser.isNotRatedByUser()) {
                        } else {
                        }
                        next = i2;
                        if (notRatedByUser.isNotRatedByUser()) {
                        } else {
                        }
                        next = i;
                    }
                }
            } else {
            }
            if (newContent2 != 0) {
                if (empty && list.isEmpty()) {
                    if (list.isEmpty()) {
                        obj6 = i2;
                    } else {
                        obj6 = list.iterator();
                        while (obj6.hasNext()) {
                            ratedByUser = obj6.next();
                            if ((TrickItem)ratedByUser.getNewContent() != 0 && ratedByUser.isRatedByUser()) {
                            } else {
                            }
                            empty = i2;
                            if (ratedByUser.isRatedByUser()) {
                            } else {
                            }
                            empty = i;
                        }
                    }
                } else {
                }
                if (obj6 != null) {
                } else {
                    i = i2;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public static final a0<String> N0(j<String> j) {
        n.f(j, "<this>");
        q0 q0Var = new q0(j);
        final a0 obj1 = a0.create(q0Var);
        n.e(obj1, "create { emitter ->\n        this.addOnCompleteListener { task ->\n            if (task.isSuccessful) {\n                emitter.onSuccess(task.result ?: \"\")\n            } else {\n                emitter.onError(task.exception ?: Exception(\"String task failed\"))\n            }\n        }\n    }");
        return obj1;
    }

    public static final boolean O(PurchaserInfo purchaserInfo) {
        int i;
        EntitlementInfo obj2;
        n.f(purchaserInfo, "<this>");
        obj2 = purchaserInfo.getEntitlements().get("premium");
        i = 0;
        final int i2 = 1;
        if (obj2 == null) {
        } else {
            if (obj2.isActive() == i2) {
                i = i2;
            }
        }
        return i;
    }

    public static final a0<DataSnapshot> O0(DatabaseReference databaseReference) {
        n.f(databaseReference, "<this>");
        u0 u0Var = new u0(databaseReference);
        final a0 obj1 = a0.create(u0Var);
        n.e(obj1, "create { emitter ->\n        addValueEventListener(object : ValueEventListener {\n            override fun onDataChange(dataSnapshot: DataSnapshot) {\n                emitter.onSuccess(dataSnapshot)\n                removeEventListener(this)\n            }\n\n            override fun onCancelled(databaseError: DatabaseError) {\n                removeEventListener(this)\n                val exception = databaseError.toException()\n                Timber.e(exception)\n                @Suppress(\"UnstableApiUsage\")\n                emitter.tryOnError(exception)\n            }\n        })\n    }");
        return obj1;
    }

    public static final boolean P(PurchaserInfo purchaserInfo) {
        n.f(purchaserInfo, "<this>");
        return obj1 ^= 1;
    }

    private static final void P0(DatabaseReference databaseReference, c0 c02) {
        n.f(databaseReference, "$this_toSingle");
        n.f(c02, "emitter");
        j1.i iVar = new j1.i(c02, databaseReference);
        databaseReference.addValueEventListener(iVar);
    }

    public static final a0<Boolean> Q(Purchases purchases) {
        n.f(purchases, "<this>");
        z0 z0Var = new z0(purchases);
        final a0 obj1 = a0.create(z0Var);
        n.e(obj1, "create { emitter ->\n        getPurchaserInfoWith({ error ->\n            Timber.e(\"$error\")\n            emitter.onSuccess(false)\n        }) { purchaserInfo ->\n            val isFreeTrailAvailable = purchaserInfo.allPurchasedSkus.none { it.contains(\"freetrial\") }\n            emitter.onSuccess(isFreeTrailAvailable)\n        }\n    }");
        return obj1;
    }

    private static final void Q0(j j, c0 c02) {
        n.f(j, "$this_toSingle");
        n.f(c02, "emitter");
        r0 r0Var = new r0(c02);
        j.addOnCompleteListener(r0Var);
    }

    private static final void R(Purchases purchases, c0 c02) {
        n.f(purchases, "$this_isUserEligibleForFreeTrailByRegexCheck");
        n.f(c02, "emitter");
        j1.d dVar = new j1.d(c02);
        j1.e eVar = new j1.e(c02);
        ListenerConversionsKt.getPurchaserInfoWith(purchases, dVar, eVar);
    }

    private static final void R0(c0 c0, j j2) {
        boolean successful;
        Object obj2;
        n.f(c0, "$emitter");
        if (j2.isSuccessful()) {
            if ((String)j2.getResult() == null) {
                obj2 = "";
            }
            c0.onSuccess(obj2);
        } else {
            if (j2.getException() == null) {
                obj2 = new Exception("String task failed");
            }
            c0.onError(obj2);
        }
    }

    public static void S(RecyclerView recyclerView, int i2, int i3, NestedScrollView nestedScrollView4, int i5) {
        j1.z0(recyclerView, i2, i3, nestedScrollView4, i5);
    }

    public static final TrickItem S0(TrickModel trickModel, Integer integer2, List<String> list3, boolean z4) {
        int intValue2;
        int iterator;
        String examInstructions;
        int intValue;
        long long2;
        int libraryTag;
        long long;
        int i2;
        Object arrayList;
        int description;
        int image;
        int startTime;
        int startTime2;
        int i;
        TrickItem.VideoStep videoStep;
        String text;
        int trickStep;
        int i5;
        int i6;
        int i7;
        String name;
        String str;
        int i3;
        int i4;
        Object obj = list3;
        n.f(trickModel, "<this>");
        n.f(obj, "lockedTricks");
        String videoId = trickModel.getVideoId();
        long2 = 0;
        if (videoId == null) {
            long = long2;
        } else {
            long = Long.parseLong(videoId);
        }
        i2 = 0;
        int i9 = 10;
        if (Long.compare(long, long2) != 0) {
            List videoSteps = trickModel.getVideoSteps();
            arrayList = new ArrayList(p.r(videoSteps, i9));
            iterator = videoSteps.iterator();
            image = i2;
            for (Object next5 : iterator) {
                i = image + 1;
                if (image == p.i(trickModel.getVideoSteps())) {
                } else {
                }
                startTime = (TrickModel.TrickVideoStep)trickModel.getVideoSteps().get(i).getStartTime();
                videoStep = new TrickItem.VideoStep((TrickModel.TrickVideoStep)next5.getText(), next5.getStartTime(), startTime);
                arrayList.add(videoStep);
                image = i;
                startTime = -1;
            }
        } else {
            arrayList = p.g();
        }
        if (trickModel.getExamInstructions() == null && trickModel.getDescription() == null) {
            if (trickModel.getDescription() == null) {
                examInstructions = "";
            }
        }
        if (integer2 == null) {
            i5 = i2;
        } else {
            i5 = examInstructions;
        }
        List trickSteps = trickModel.getTrickSteps();
        ArrayList arrayList3 = new ArrayList(p.r(trickSteps, i9));
        Iterator iterator2 = trickSteps.iterator();
        for (TrickModel.TrickStep next4 : iterator2) {
            trickStep = new TrickItem.TrickStep(next4.getDescription(), next4.getImage());
            arrayList3.add(trickStep);
        }
        String videoId2 = trickModel.getVideoId();
        if (videoId2 == null) {
        } else {
            long2 = Long.parseLong(videoId2);
        }
        Integer sortOrder = trickModel.getSortOrder();
        if (sortOrder == null) {
            intValue = Integer.MAX_VALUE;
        } else {
            intValue = sortOrder.intValue();
        }
        List tags = trickModel.getTags();
        ArrayList arrayList2 = new ArrayList(p.r(tags, i9));
        Iterator iterator3 = tags.iterator();
        for (TrickModel.TrickTag next2 : iterator3) {
            super(0, next2.getName(), next2.getId(), 1, 0);
            arrayList2.add(libraryTag);
        }
        TrickItem.TrickCategory trickCategory = new TrickItem.TrickCategory(trickModel.getCategory().getId(), trickModel.getCategory().getName());
        if (obj.contains(trickModel.getId()) && !z4) {
            if (!z4) {
                i2 = 1;
            }
        }
        Integer examTimeLimit = trickModel.getExamTimeLimit();
        if (examTimeLimit == null) {
            intValue2 = 30;
        } else {
            intValue2 = examTimeLimit.intValue();
        }
        super(trickModel.getId(), trickModel.getName(), examInstructions, trickModel.getImage(), 0, i5, arrayList3, arrayList, long2, obj18, trickModel.getHasProgress(), intValue, arrayList2, trickCategory, i2, 0, 0, 0, 0, 0, intValue2, 507904, 0);
        return trickItem;
    }

    public static void T(Query query, Source source2, Class class3, c0 c04) {
        j1.k(query, source2, class3, c04);
    }

    public static TrickItem T0(TrickModel trickModel, Integer integer2, List list3, boolean z4, int i5, Object object6) {
        List obj2;
        int obj3;
        if (i5 & 2 != 0) {
            obj2 = p.g();
        }
        if (i5 &= 4 != 0) {
            obj3 = 1;
        }
        return j1.S0(trickModel, integer2, obj2, obj3);
    }

    public static void U(c c, j j2) {
        j1.K0(c, j2);
    }

    public static final TrainingReminderModel.Weekdays U0(List<Boolean> list) {
        n.f(list, "<this>");
        super((Boolean)list.get(0).booleanValue(), (Boolean)list.get(1).booleanValue(), (Boolean)list.get(2).booleanValue(), (Boolean)list.get(3).booleanValue(), (Boolean)list.get(4).booleanValue(), (Boolean)list.get(5).booleanValue(), (Boolean)list.get(6).booleanValue());
        return weekdays;
    }

    public static boolean V(d d, View view2, MotionEvent motionEvent3) {
        return j1.D0(d, view2, motionEvent3);
    }

    public static final String V0(String string, Context context2) {
        n.f(string, "<this>");
        n.f(context2, "context");
        final Resources obj2 = context2.getResources();
        n.e(obj2, "context.resources");
        return j1.W0(string, obj2);
    }

    public static void W(j j, c0 c02) {
        j1.Q0(j, c02);
    }

    public static final String W0(String string, Resources resources2) {
        Object obj1;
        Object obj2;
        n.f(string, "<this>");
        n.f(resources2, "resources");
        if (j1.M(string)) {
            n.e(resources2.getString(2131886675), "{\n        resources.getString(R.string.general_anonymous)\n    }");
        }
        return obj1;
    }

    public static void X(c0 c0, j j2) {
        j1.R0(c0, j2);
    }

    public static final boolean X0(PurchaserInfo purchaserInfo) {
        Object obj1;
        n.f(purchaserInfo, "<this>");
        if (!j1.Z0(purchaserInfo) && !j1.Y0(purchaserInfo)) {
            obj1 = !j1.Y0(purchaserInfo) ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public static void Y(DocumentReference documentReference, Source source2, Class class3, c0 c04) {
        j1.m(documentReference, source2, class3, c04);
    }

    public static final boolean Y0(PurchaserInfo purchaserInfo) {
        int obj1;
        n.f(purchaserInfo, "<this>");
        obj1 = purchaserInfo.getEntitlements().get("premium");
        if (obj1 == null) {
            obj1 = 0;
        } else {
            obj1 = obj1.getExpirationDate();
        }
        obj1 = obj1 == null ? 1 : 0;
        return obj1;
    }

    public static void Z(Class class, c0 c02, DocumentReference documentReference3, j j4) {
        j1.n(class, c02, documentReference3, j4);
    }

    public static final boolean Z0(PurchaserInfo purchaserInfo) {
        int i;
        EntitlementInfo obj2;
        n.f(purchaserInfo, "<this>");
        obj2 = purchaserInfo.getEntitlements().get("premium");
        i = 0;
        final int i2 = 1;
        if (obj2 == null) {
        } else {
            if (obj2.getWillRenew() == i2) {
                i = i2;
            }
        }
        return i;
    }

    public static final void a(KonfettiView konfettiView) {
        n.f(konfettiView, "<this>");
        b bVar = konfettiView.a();
        int i = 2;
        int[] iArr = new int[i];
        int i9 = 2131099848;
        final int i12 = 0;
        final int i13 = 0;
        iArr[i13] = konfettiView.getResources().getColor(i9, i12);
        final int i14 = 2131099849;
        int color2 = konfettiView.getResources().getColor(i14, i12);
        final int i15 = 1;
        iArr[i15] = color2;
        bVar.a(iArr);
        final long l = 4645023210981556224L;
        bVar.h(0, color2);
        bVar.k(1101004800, 1106247680);
        bVar.i(i15);
        bVar.l(6000);
        nl.dionsegijn.konfetti.e.b[] arr3 = new b[i];
        final b.a aVar = b.a.c;
        arr3[i13] = aVar;
        final b.c cVar3 = b.c.b;
        arr3[i15] = cVar3;
        bVar.b(arr3);
        c[] arr4 = new c[i15];
        int i18 = 18;
        c cVar2 = new c(i18, 1140457472);
        arr4[i13] = cVar2;
        bVar.c(arr4);
        bVar.j((float)width, Float.valueOf((float)width2), (float)height4, Float.valueOf((float)height2));
        int i5 = 100;
        bVar.d(i5);
        b bVar2 = konfettiView.a();
        int[] iArr2 = new int[i];
        iArr2[i13] = konfettiView.getResources().getColor(i9, i12);
        int color4 = konfettiView.getResources().getColor(i14, i12);
        iArr2[i15] = color4;
        bVar2.a(iArr2);
        bVar2.h(0, color4);
        int i10 = 1101004800;
        bVar2.k(i10, 1106247680);
        bVar2.i(i15);
        bVar2.l(6000);
        nl.dionsegijn.konfetti.e.b[] arr = new b[i];
        arr[i13] = aVar;
        arr[i15] = cVar3;
        bVar2.b(arr);
        c[] arr2 = new c[i15];
        c cVar = new c(i18, 1140457472);
        arr2[i13] = cVar;
        bVar2.c(arr2);
        int i2 = 0;
        bVar2.j(i2, Float.valueOf(i2), (float)height3, Float.valueOf((float)height));
        bVar2.d(i5);
    }

    public static void a0(DatabaseReference databaseReference, c0 c02) {
        j1.P0(databaseReference, c02);
    }

    public static final ProgramDescriptionItem b(ProgramModel programModel, ProgramDescriptionItem.State programDescriptionItem$State2, boolean z3, boolean z4, long l5, boolean z6, int i7, ProgramOverview programOverview8) {
        String centeredImage;
        List lessons;
        boolean values;
        List exams;
        Object obj2 = state2;
        n.f(programModel, "<this>");
        n.f(obj2, "status");
        if (obj2 == ProgramDescriptionItem.State.RECOMMENDED_BIG && z3) {
            if (z3) {
                centeredImage = programModel.getCenteredImage();
            } else {
                centeredImage = programModel.getImage();
            }
        } else {
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator iterator = programModel.getModules().iterator();
        for (ProgramModel.ModuleModel next3 : iterator) {
            p.y(arrayList3, next3.getLessons());
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator3 = arrayList3.iterator();
        for (ProgramModel.LessonModel next2 : iterator3) {
            p.y(arrayList, next2.getTricks().values());
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator iterator2 = programModel.getModules().iterator();
        for (ProgramModel.ModuleModel next5 : iterator2) {
            p.y(arrayList2, next5.getExams());
        }
        super(programModel.getId(), programModel.getName(), centeredImage, programModel.getCardBackgroundColor(), programModel.getModules().size(), arrayList.size(), state2, arrayList2.size(), programModel.getNumberOfEnrolledUsers(), programOverview8, programModel.getDogSkillsHighlights(), z4, l5, obj14, i7, obj26);
        return programDescriptionItem2;
    }

    public static String b0(j j) {
        return j1.t0(j);
    }

    public static ProgramDescriptionItem c(ProgramModel programModel, ProgramDescriptionItem.State programDescriptionItem$State2, boolean z3, boolean z4, long l5, boolean z6, int i7, ProgramOverview programOverview8, int i9, Object object10) {
        int i2;
        int i5;
        int i;
        int i6;
        int i3;
        int i4;
        i2 = object10 & 2 != 0 ? 1 : z3;
        i = 0;
        i5 = object10 & 4 != 0 ? i : z4;
        i6 = object10 & 8 != 0 ? 0 : l5;
        i3 = object10 & 16 != 0 ? i : i7;
        if (object10 & 32 != 0) {
        } else {
            i = programOverview8;
        }
        i4 = object10 & 64 != 0 ? 0 : i9;
        return j1.b(programModel, state2, i2, i5, i6, programOverview8, i3, i);
    }

    public static void c0(Class class, c0 c02, Query query3, j j4) {
        j1.l(class, c02, query3, j4);
    }

    public static final String d(String string) {
        int i2;
        int i3;
        char charAt;
        int i;
        n.f(string, "<this>");
        StringBuilder stringBuilder = new StringBuilder(string);
        int obj6 = 0;
        final int i4 = 1;
        i2 = obj6;
        i3 = i4;
        while (i2 < stringBuilder.length()) {
            if (stringBuilder.charAt(i2) != 46 && stringBuilder.charAt(i2) != 63) {
            } else {
            }
            i3 = i4;
            i2++;
            if (stringBuilder.charAt(i2) != 63) {
            } else {
            }
            if (stringBuilder.charAt(i2) == 33) {
            } else {
            }
            if (i3 != 0 && !Character.isWhitespace(stringBuilder.charAt(i2))) {
            }
            if (!Character.isWhitespace(stringBuilder.charAt(i2))) {
            }
            stringBuilder.setCharAt(i2, Character.toUpperCase(stringBuilder.charAt(i2)));
            i3 = obj6;
        }
        obj6 = stringBuilder.toString();
        n.e(obj6, "sb.toString()");
        return obj6;
    }

    public static void d0(j j, c c2) {
        j1.J0(j, c2);
    }

    public static final void e(n n) {
        int i;
        n.f(n, "<this>");
        int i2 = n.p0();
        if (i2 > 0) {
            i = 0;
            n.Z0();
            while (i++ >= i2) {
                n.Z0();
            }
        }
        j1.o(n);
    }

    public static void e0(c0 c0, j j2) {
        j1.j0(c0, j2);
    }

    public static final boolean f(n n, String string2) {
        boolean iterator;
        int i;
        int name;
        String str;
        Iterator obj5;
        n.f(n, "<this>");
        n.f(string2, "tag");
        kotlin.h0.f fVar = g.l(0, n.p0());
        ArrayList arrayList = new ArrayList(p.r(fVar, 10));
        iterator = fVar.iterator();
        while (iterator.hasNext()) {
            n.k kVar = n.o0((h0)iterator.d());
            n.e(kVar, "getBackStackEntryAt(it)");
            arrayList.add(kVar.getName());
        }
        if (arrayList.isEmpty()) {
        } else {
            obj5 = arrayList.iterator();
            while (obj5.hasNext()) {
                if (n.b((String)obj5.next(), string2) != null) {
                    break;
                } else {
                }
            }
        }
        return i;
    }

    public static void f0(Purchases purchases, c0 c02) {
        j1.R(purchases, c02);
    }

    public static final <T> a0<T> g(DocumentReference documentReference, Source source2, Class<T> class3) {
        n.f(documentReference, "<this>");
        n.f(source2, "source");
        n.f(class3, "objectClass");
        s0 s0Var = new s0(documentReference, source2, class3);
        final a0 obj1 = a0.create(s0Var);
        n.e(obj1, "create { emitter ->\n        this.get(source).addOnCompleteListener { task ->\n            if (task.isSuccessful) {\n                val result = task.result?.toObject(objectClass)\n                if (result != null) {\n                    emitter.onSuccess(result)\n                } else {\n                    @Suppress(\"UnstableApiUsage\")\n                    emitter.tryOnError(CustomExceptions.DataNotFound(\"No document found\"))\n                }\n            } else {\n                val exception = task.exception ?: Exception(\"failed to fetch query : $this\")\n                Timber.e(exception)\n                @Suppress(\"UnstableApiUsage\")\n                emitter.tryOnError(exception)\n            }\n        }\n    }");
        return obj1;
    }

    public static void g0(FirebaseUser firebaseUser, AuthCredential authCredential2, c0 c03) {
        j1.i0(firebaseUser, authCredential2, c03);
    }

    public static final <T> a0<T> h(DocumentReference documentReference, Class<T> class2) {
        n.f(documentReference, "<this>");
        n.f(class2, "objectClass");
        return j1.g(documentReference, Source.DEFAULT, class2);
    }

    public static final a0<AuthResult> h0(FirebaseUser firebaseUser, AuthCredential authCredential2) {
        n.f(firebaseUser, "<this>");
        n.f(authCredential2, "lastCredential");
        a1 a1Var = new a1(firebaseUser, authCredential2);
        final a0 obj1 = a0.create(a1Var);
        n.e(obj1, "create { emitter ->\n        linkWithCredential(lastCredential).addOnCompleteListener { task: Task<AuthResult> ->\n            if (task.isSuccessful && task.result != null) {\n                emitter.onSuccess(task.result)\n            } else {\n                Timber.e(task.exception, \"auth, error while linking\")\n                emitter.tryOnError(task.exception ?: Throwable(\"auth, error while linking\"))\n            }\n        }\n    }");
        return obj1;
    }

    public static final <T> a0<List<T>> i(Query query, Source source2, Class<T> class3) {
        n.f(query, "<this>");
        n.f(source2, "source");
        n.f(class3, "objectClass");
        n0 n0Var = new n0(query, source2, class3);
        final a0 obj1 = a0.create(n0Var);
        n.e(obj1, "create { emitter ->\n        this.get(source)\n            .addOnCompleteListener { task ->\n                if (task.isSuccessful) {\n                    val result = task.result?.toObjects(objectClass)!!\n                    emitter.onSuccess(result)\n                } else {\n                    val exception = task.exception ?: Exception(\"failed to fetch query : $this\")\n                    Timber.e(exception)\n                    @Suppress(\"UnstableApiUsage\")\n                    emitter.tryOnError(exception)\n                }\n            }\n    }");
        return obj1;
    }

    private static final void i0(FirebaseUser firebaseUser, AuthCredential authCredential2, c0 c03) {
        n.f(firebaseUser, "$this_linkWithCredentialSingle");
        n.f(authCredential2, "$lastCredential");
        n.f(c03, "emitter");
        y0 obj2 = new y0(c03);
        firebaseUser.linkWithCredential(authCredential2).addOnCompleteListener(obj2);
    }

    public static final <T> a0<List<T>> j(Query query, Class<T> class2) {
        n.f(query, "<this>");
        n.f(class2, "objectClass");
        return j1.i(query, Source.DEFAULT, class2);
    }

    private static final void j0(c0 c0, j j2) {
        boolean successful;
        Object[] arr;
        String str;
        Throwable obj4;
        n.f(c0, "$emitter");
        n.f(j2, "task");
        if (j2.isSuccessful() && j2.getResult() != null) {
            if (j2.getResult() != null) {
                c0.onSuccess(j2.getResult());
            } else {
                str = "auth, error while linking";
                a.e(j2.getException(), str, new Object[0]);
                if (j2.getException() == null) {
                    obj4 = new Throwable(str);
                }
                c0.a(obj4);
            }
        } else {
        }
    }

    private static final void k(Query query, Source source2, Class class3, c0 c04) {
        n.f(query, "$this_createSingle");
        n.f(source2, "$source");
        n.f(class3, "$objectClass");
        n.f(c04, "emitter");
        w0 w0Var = new w0(class3, c04, query);
        query.get(source2).addOnCompleteListener(w0Var);
    }

    public static final void k0(g g, a3 a32) {
        Object str;
        Object num;
        double doubleValue;
        Object obj4;
        n.f(g, "<this>");
        if (a32 == null) {
        }
        if (a32.h() != null && a32.g() != null) {
            if (a32.g() != null) {
                g.e(a32.f(), a32.h().doubleValue(), obj2);
            } else {
                if (a32.h() != null) {
                    g.d(a32.f(), a32.h().doubleValue());
                } else {
                    if (a32.g() != null) {
                        g.f(a32.f(), a32.g());
                    } else {
                        g.c(a32.f());
                    }
                }
            }
        } else {
        }
    }

    private static final void l(Class class, c0 c02, Query query3, j j4) {
        Exception obj1;
        Object obj3;
        String obj4;
        n.f(class, "$objectClass");
        n.f(c02, "$emitter");
        n.f(query3, "$this_createSingle");
        if (j4.isSuccessful()) {
            obj3 = j4.getResult();
            if ((QuerySnapshot)obj3 == null) {
                obj1 = 0;
            } else {
                obj1 = (QuerySnapshot)obj3.toObjects(class);
            }
            n.d(obj1);
            n.e(obj1, "task.result?.toObjects(objectClass)!!");
            c02.onSuccess(obj1);
        } else {
            if (j4.getException() == null) {
                obj1 = new Exception(n.o("failed to fetch query : ", query3));
            }
            a.d(obj1);
            c02.a(obj1);
        }
    }

    public static final ChallengeEntryModel l0(ChallengeNotificationModel challengeNotificationModel) {
        Object entryImages;
        int arrayList;
        int miniEntryModel;
        boolean fVar;
        HashMap hashMap;
        String str;
        long str2;
        n.f(challengeNotificationModel, "<this>");
        entryImages = challengeNotificationModel.getEntryImages();
        String str4 = "votes";
        String str6 = "imageUrl_320";
        String str7 = "imageUrl_640";
        String str13 = "imageUrl_1280";
        String str14 = "imageUrl";
        arrayList = 0;
        if (entryImages == null) {
        } else {
            entryImages = entryImages.values();
            if (entryImages == null) {
            } else {
                fVar = new j1.f();
                entryImages = p.D0(entryImages, fVar);
                if (entryImages == null) {
                } else {
                    arrayList = new ArrayList(p.r(entryImages, 10));
                    entryImages = entryImages.iterator();
                    for (ChallengeNotificationModel.EntryImageObject next : entryImages) {
                        hashMap = new HashMap();
                        hashMap.put(str6, next.getImageUrl_320());
                        hashMap.put(str7, next.getImageUrl_640());
                        hashMap.put(str13, next.getImageUrl_1280());
                        hashMap.put(str14, next.getImageUrl());
                        hashMap.put(str4, Long.valueOf(next.getVotes()));
                        hashMap.put("imageId", next.getImageId());
                        hashMap.put("createdAt", next.getCreatedAt());
                        hashMap.put("featured", Boolean.valueOf(next.getFeatured()));
                        miniEntryModel = new ChallengeEntryModel.MiniEntryModel(hashMap);
                        arrayList.add(miniEntryModel);
                    }
                }
            }
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("entryId", challengeNotificationModel.getEntryId());
        hashMap2.put("dogName", challengeNotificationModel.getEntryDogName());
        hashMap2.put(str14, challengeNotificationModel.getEntryImageUrl());
        hashMap2.put(str13, challengeNotificationModel.getEntryImageUrl());
        hashMap2.put(str7, challengeNotificationModel.getEntryImageUrl());
        hashMap2.put(str6, challengeNotificationModel.getEntryImageUrl_320());
        hashMap2.put("published", Boolean.valueOf(challengeNotificationModel.getEntryPublished()));
        hashMap2.put("dogId", challengeNotificationModel.getEntryDogId());
        hashMap2.put("challengeId", challengeNotificationModel.getChallengeId());
        hashMap2.put("author", challengeNotificationModel.getEntryOwnerUserId());
        hashMap2.put("comment", challengeNotificationModel.getEntryComment());
        hashMap2.put(str4, Integer.valueOf(challengeNotificationModel.getEntryVotes()));
        hashMap2.put("dogAvatarUrl", challengeNotificationModel.getEntryDogAvatarUrl());
        hashMap2.put("images", arrayList);
        return ChallengeEntryModel.Companion.parseChallengeEntry(hashMap2);
    }

    private static final void m(DocumentReference documentReference, Source source2, Class class3, c0 c04) {
        n.f(documentReference, "$this_createSingle");
        n.f(source2, "$source");
        n.f(class3, "$objectClass");
        n.f(c04, "emitter");
        t0 t0Var = new t0(class3, c04, documentReference);
        documentReference.get(source2).addOnCompleteListener(t0Var);
    }

    public static final Exam m0(ProgramExam programExam, DogProfileModel dogProfileModel2, String string3, String string4) {
        n.f(programExam, "<this>");
        n.f(dogProfileModel2, "dogProfileModel");
        n.f(string3, "userId");
        n.f(string4, "userLocale");
        super(programExam.getTrickId(), dogProfileModel2.getId(), dogProfileModel2.getName(), dogProfileModel2.getAvatar(), dogProfileModel2.getGender(), string3, string4, programExam.getDescription(), programExam.getExamTimeLimit(), programExam.getVideoUrl());
        return exam;
    }

    private static final void n(Class class, c0 c02, DocumentReference documentReference3, j j4) {
        Exception obj1;
        Object obj3;
        String obj4;
        n.f(class, "$objectClass");
        n.f(c02, "$emitter");
        n.f(documentReference3, "$this_createSingle");
        if (j4.isSuccessful()) {
            obj3 = j4.getResult();
            if ((DocumentSnapshot)obj3 == null) {
                obj1 = 0;
            } else {
                obj1 = (DocumentSnapshot)obj3.toObject(class);
            }
            if (obj1 != null) {
                c02.onSuccess(obj1);
            } else {
                obj1 = new CustomExceptions.DataNotFound("No document found");
                c02.a(obj1);
            }
        } else {
            if (j4.getException() == null) {
                obj1 = new Exception(n.o("failed to fetch query : ", documentReference3));
            }
            a.d(obj1);
            c02.a(obj1);
        }
    }

    public static final int n0(SkuDetails skuDetails) {
        n.f(skuDetails, "<this>");
        String obj2 = skuDetails.b();
        n.e(obj2, "freeTrialPeriod");
        return DogoSkuDetails.Companion.parsePeriodInDays(obj2);
    }

    public static final void o(n n) {
        String childFragmentManager;
        String str;
        boolean obj;
        n.f(n, "<this>");
        Iterator obj2 = n.v0().iterator();
        while (obj2.hasNext()) {
            Object next2 = obj2.next();
            if (next2 instanceof d) {
            }
            childFragmentManager = (Fragment)next2.getChildFragmentManager();
            n.e(childFragmentManager, "fragment.childFragmentManager");
            j1.o(childFragmentManager);
            (d)next2.dismissAllowingStateLoss();
        }
    }

    public static final SurveyQuestion o0(SurveyQuestionModel surveyQuestionModel, int i2, int i3) {
        Object text;
        Object text2;
        int text4;
        int text3;
        SurveyAnswer surveyAnswer;
        Object str3;
        String str2;
        Object str;
        n.f(surveyQuestionModel, "<this>");
        List answers = surveyQuestionModel.getAnswers();
        ArrayList arrayList = new ArrayList(p.r(answers, 10));
        Iterator iterator = answers.iterator();
        for (SurveyAnswerModel next2 : iterator) {
            surveyAnswer = new SurveyAnswer(next2.getId(), next2.getText());
            arrayList.add(surveyAnswer);
        }
        text = p.a0(surveyQuestionModel.getAnswers(), 0);
        String str5 = "";
        if ((SurveyAnswerModel)text == null) {
            str3 = str5;
        } else {
        }
        text2 = p.a0(surveyQuestionModel.getAnswers(), 1);
        if ((SurveyAnswerModel)text2 == null) {
            str = str5;
        } else {
        }
        Object obj = p.a0(surveyQuestionModel.getAnswers(), 2);
        if ((SurveyAnswerModel)obj == null) {
            text4 = 0;
        } else {
            text4 = (SurveyAnswerModel)obj.getText();
        }
        super(surveyQuestionModel.getId(), arrayList, str3, str, text4, surveyQuestionModel.getText(), i3, i2);
        return obj10;
    }

    public static final void p(EntryPhotoBaseObservable entryPhotoBaseObservable, u2 u22, a a3, String string4, l<? super DogProfileModel, w> l5) {
        n.f(entryPhotoBaseObservable, "<this>");
        n.f(u22, "userLocalCacheService");
        n.f(a3, "disposable");
        n.f(string4, "dogId");
        n.f(l5, "callback");
        a0 obj1 = u22.y(string4).subscribeOn(a.b()).observeOn(a.a());
        n.e(obj1, "userLocalCacheService.getPublicDogProfile(dogId)\n            .subscribeOn(Schedulers.io())\n            .observeOn(AndroidSchedulers.mainThread())");
        j1.b obj2 = new j1.b(l5, string4);
        j1.c obj4 = new j1.c(l5);
        a3.b(a.g(obj1, obj2, obj4));
    }

    public static final ProgramExam.Status p0(ProgramProgress.ExamSubmission programProgress$ExamSubmission) {
        ProgramExam.Status obj1;
        n.f(examSubmission, "<this>");
        switch (obj1) {
            case 1:
                obj1 = ProgramExam.Status.LOCKED;
                break;
            case 2:
                obj1 = ProgramExam.Status.READY;
                break;
            case 3:
                obj1 = ProgramExam.Status.PENDING;
                break;
            case 4:
                obj1 = ProgramExam.Status.APPROVED;
                break;
            case 5:
                obj1 = ProgramExam.Status.REJECTED;
                break;
            default:
                obj1 = new NoWhenBranchMatchedException();
                throw obj1;
        }
        return obj1;
    }

    public static final <K, V> Map<K, V> q(Map<K, ? extends V> map) {
        Object value;
        int key;
        n.f(map, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator obj3 = map.entrySet().iterator();
        while (obj3.hasNext()) {
            value = obj3.next();
            if ((Map.Entry)value.getValue() != null) {
            } else {
            }
            key = 0;
            if (key != null) {
            }
            linkedHashMap.put(value.getKey(), value.getValue());
            key = 1;
        }
        return linkedHashMap;
    }

    public static final List<SpecialOfferCoupon> q0(String string) {
        int obj2;
        n.f(string, "<this>");
        Gson gson = new Gson();
        obj2 = gson.fromJson(string, SpecialOfferRemoteConfig.class);
        if ((SpecialOfferRemoteConfig)obj2 == null) {
            obj2 = 0;
        } else {
            obj2 = (SpecialOfferRemoteConfig)obj2.getOffers();
        }
        if (obj2 == null) {
            obj2 = p.g();
        }
        return obj2;
    }

    public static final <T, R> List<R> r(Iterable<? extends T> iterable, l<? super T, ? extends Iterable<? extends R>> l2) {
        Object invoke;
        n.f(iterable, "<this>");
        n.f(l2, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator obj2 = iterable.iterator();
        for (Object next2 : obj2) {
            p.y(arrayList, (Iterable)l2.invoke(next2));
        }
        return p.U(arrayList);
    }

    public static final ProgramProgress.ProgramExamStatus r0(ProgramProgress.ExamSubmission programProgress$ExamSubmission) {
        int i;
        ProgramProgress.ProgramExamStatus programExamStatus;
        boolean z;
        String examStatus;
        n.f(examSubmission, "<this>");
        ProgramProgress.ProgramExamStatus[] values = ProgramProgress.ProgramExamStatus.values();
        i = 0;
        while (i < values.length) {
            programExamStatus = values[i];
            i++;
        }
        return ProgramProgress.ProgramExamStatus.LOCKED;
    }

    public static final String s(ChallengeComment challengeComment) {
        String next;
        boolean contains;
        Set set;
        n.f(challengeComment, "<this>");
        Iterator obj3 = challengeComment.getBadges().iterator();
        for (Object next : obj3) {
        }
        next = 0;
        if ((String)next == null) {
            next = "";
        }
        return next;
    }

    public static final j<String> s0(FirebaseAuth firebaseAuth, boolean z2) {
        j obj1;
        Object obj2;
        n.f(firebaseAuth, "<this>");
        obj1 = firebaseAuth.getCurrentUser();
        if (obj1 != null) {
            obj1 = obj1.getIdToken(z2).continueWith(v0.a);
        } else {
            a.f("Current User is Null", new Object[0]);
            obj1 = m.e("");
        }
        n.e(obj1, "currentUser.let {\n        if (it != null) {\n            it.getIdToken(forceUpdate).continueWith { task ->\n                val fireAuthTokenJWT = task.takeIf { task.isSuccessful }?.result?.token\n                if (fireAuthTokenJWT != null) {\n                    if (BuildConfig.DEBUG) {\n                        Timber.d(\"Firebase Auth IdToken: $fireAuthTokenJWT\")\n                    }\n                    fireAuthTokenJWT\n                } else {\n                    Timber.i(\"Firebase Auth IdToken is null. Caused By ${task.exception?.message}\")\n                    \"\"\n                }\n            }\n        } else {\n            Timber.i(\"Current User is Null\")\n            Tasks.forResult(\"\")\n        }\n    }");
        return obj1;
    }

    public static final String t(ChallengeEntryModel challengeEntryModel) {
        String next;
        boolean contains;
        Set set;
        n.f(challengeEntryModel, "<this>");
        Iterator obj3 = challengeEntryModel.getBadges().iterator();
        for (Object next : obj3) {
        }
        next = 0;
        if ((String)next == null) {
            next = "";
        }
        return next;
    }

    private static final String t0(j j) {
        int result;
        int token;
        int message;
        String obj2;
        message = 0;
        result = j.isSuccessful() ? j : message;
        if (result == null) {
            token = message;
        } else {
        }
        if (token != null) {
        } else {
            obj2 = j.getException();
            if (obj2 == null) {
            } else {
                message = obj2.getMessage();
            }
            a.f(n.o("Firebase Auth IdToken is null. Caused By ", message), new Object[0]);
            token = "";
        }
        return token;
    }

    public static final String u(ChallengeEntryVoter challengeEntryVoter) {
        String next;
        boolean contains;
        Set set;
        n.f(challengeEntryVoter, "<this>");
        Iterator obj3 = challengeEntryVoter.getBadges().iterator();
        for (Object next : obj3) {
        }
        next = 0;
        if ((String)next == null) {
            next = "";
        }
        return next;
    }

    public static final <T> void u0(LiveData<T> liveData, q q2, l<? super T, Boolean> l3, y<T> y4) {
        n.f(liveData, "<this>");
        n.f(q2, "lifecycleOwner");
        n.f(l3, "removeObserverPredicate");
        n.f(y4, "observer");
        j1.g gVar = new j1.g(y4, l3, liveData);
        liveData.observe(q2, gVar);
    }

    public static final String v(DogProfile dogProfile) {
        Object birthday;
        Date date;
        long longValue;
        String obj4;
        n.f(dogProfile, "<this>");
        if (dogProfile.getBirthday() != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM d, yyyy", Locale.getDefault());
            date = new Date(dogProfile.getBirthday().longValue(), obj3);
            n.e(simpleDateFormat.format(date), "{\n        val format = SimpleDateFormat(\"MMMM d, yyyy\", Locale.getDefault())\n        format.format(Date(birthday))\n    }");
        } else {
            obj4 = "";
        }
        return obj4;
    }

    public static final String v0(String string) {
        n.f(string, "<this>");
        h hVar = new h("[\\[\\]\\.\\#\\$]");
        String obj2 = hVar.e(string, "");
        Objects.requireNonNull(obj2, "null cannot be cast to non-null type java.lang.String");
        obj2 = obj2.toUpperCase();
        n.e(obj2, "(this as java.lang.String).toUpperCase()");
        return obj2;
    }

    public static final String w(DogProfile dogProfile) {
        String customBreed;
        String obj1;
        n.f(dogProfile, "<this>");
        if (dogProfile.getBreedId() == null && dogProfile.getCustomBreed() != null) {
            if (dogProfile.getCustomBreed() != null) {
                obj1 = dogProfile.getCustomBreed();
            } else {
                obj1 = dogProfile.getBreedTitle();
            }
        } else {
        }
        return obj1;
    }

    public static final String w0(String string) {
        Object obj1;
        n.f(string, "<this>");
        if (j1.M(string)) {
            obj1 = "";
        }
        return obj1;
    }

    public static final NumberFormat x(SkuDetails skuDetails) {
        n.f(skuDetails, "<this>");
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(j1.A());
        currencyInstance.setCurrency(Currency.getInstance(skuDetails.m()));
        n.e(currencyInstance, "currencyInstance");
        return currencyInstance;
    }

    public static final Integer x0(String string) {
        n.f(string, "<this>");
        return Integer.valueOf(Integer.parseInt(string));
    }

    public static final h y(CardMessage cardMessage) {
        String str;
        Object obj2;
        n.f(cardMessage, "<this>");
        obj2 = cardMessage.getData();
        if (obj2 == null) {
            obj2 = 0;
        } else {
            obj2 = obj2.get("type");
        }
        if (obj2 != null) {
        } else {
            try {
                obj2 = "";
                Locale uS = Locale.US;
                n.e(uS, "US");
                if (obj2 == null) {
                } else {
                }
                obj2 = obj2.toUpperCase(uS);
                n.e(obj2, "(this as java.lang.String).toUpperCase(locale)");
                obj2 = h.valueOf(obj2);
                obj2 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
                throw obj2;
                cardMessage = h.NOT_FOUND;
                return obj2;
            }
        }
    }

    public static final void y0(RecyclerView recyclerView, NestedScrollView nestedScrollView2, int i3, int i4) {
        n.f(recyclerView, "<this>");
        n.f(nestedScrollView2, "nestedScrollView");
        int i = 0;
        recyclerView.getRootView().measure(i, i);
        super(recyclerView, i3, recyclerView.getRootView().getHeight(), nestedScrollView2, i4);
        recyclerView.post(m0Var);
    }

    public static final List<TrickItem> z(ProgramLessonItem programLessonItem) {
        Object next;
        boolean newContent;
        n.f(programLessonItem, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator obj3 = programLessonItem.getTrainingSession().getTrainingTricksList().iterator();
        while (obj3.hasNext()) {
            next = obj3.next();
            if ((TrickItem)next.getNewContent()) {
            }
            arrayList.add(next);
        }
        return arrayList;
    }

    private static final void z0(RecyclerView recyclerView, int i2, int i3, NestedScrollView nestedScrollView4, int i5) {
        int childCount;
        Object obj1;
        int obj2;
        int obj3;
        n.f(recyclerView, "$this_scrollToPositionMiddleInsideNestedView");
        n.f(nestedScrollView4, "$nestedScrollView");
        f += obj1;
        if (recyclerView.getChildCount() > i2 && Float.compare(childCount, obj1) > 0) {
            f += obj1;
            if (Float.compare(childCount, obj1) > 0) {
                nestedScrollView4.H(0, (int)childCount, i5);
            }
        }
    }
}
