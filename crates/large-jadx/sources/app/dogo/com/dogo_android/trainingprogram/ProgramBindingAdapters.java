package app.dogo.com.dogo_android.y;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.format.DateFormat;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2.i;
import app.dogo.com.dogo_android.g.s;
import app.dogo.com.dogo_android.h.e5;
import app.dogo.com.dogo_android.h.e6;
import app.dogo.com.dogo_android.h.g6;
import app.dogo.com.dogo_android.h.gm;
import app.dogo.com.dogo_android.h.im;
import app.dogo.com.dogo_android.h.q4;
import app.dogo.com.dogo_android.h.sh;
import app.dogo.com.dogo_android.h.sl;
import app.dogo.com.dogo_android.h.sm;
import app.dogo.com.dogo_android.h.uh;
import app.dogo.com.dogo_android.h.ul;
import app.dogo.com.dogo_android.h.wl;
import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.repository.domain.ArticleWithStatus;
import app.dogo.com.dogo_android.repository.domain.CertificateInfo;
import app.dogo.com.dogo_android.repository.domain.LessonCardItem;
import app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardType;
import app.dogo.com.dogo_android.repository.domain.LessonIntroduction;
import app.dogo.com.dogo_android.repository.domain.LessonIntroduction.CardType;
import app.dogo.com.dogo_android.repository.domain.ModuleCompletionSummary;
import app.dogo.com.dogo_android.repository.domain.PottyRemindersItem;
import app.dogo.com.dogo_android.repository.domain.Program;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem.State;
import app.dogo.com.dogo_android.repository.domain.ProgramExam;
import app.dogo.com.dogo_android.repository.domain.ProgramExam.Status;
import app.dogo.com.dogo_android.repository.domain.ProgramExamList;
import app.dogo.com.dogo_android.repository.domain.ProgramExamSummary;
import app.dogo.com.dogo_android.repository.domain.ProgramLesson;
import app.dogo.com.dogo_android.repository.domain.ProgramLesson.Type;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData;
import app.dogo.com.dogo_android.repository.domain.ProgramOverview;
import app.dogo.com.dogo_android.repository.domain.ProgramQuestion;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.ProgramTasks;
import app.dogo.com.dogo_android.repository.domain.ProgramTasks.Type;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.PottyOverviewCardEnum;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramData;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.repository.domain.TrickItemWithVariations;
import app.dogo.com.dogo_android.u.l.a;
import app.dogo.com.dogo_android.u.m.v;
import app.dogo.com.dogo_android.u.m.v.a;
import app.dogo.com.dogo_android.u.n.j.a;
import app.dogo.com.dogo_android.u.n.o.a;
import app.dogo.com.dogo_android.util.MyAppGlideModule;
import app.dogo.com.dogo_android.util.customview.SegmentedProgressBar;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.x.a;
import app.dogo.com.dogo_android.y.a0.e.c;
import app.dogo.com.dogo_android.y.c0.g;
import app.dogo.com.dogo_android.y.o.q.a;
import app.dogo.com.dogo_android.y.o.u.b;
import app.dogo.com.dogo_android.y.s.i.a;
import app.dogo.com.dogo_android.y.v.d.a;
import app.dogo.com.dogo_android.y.w.k;
import app.dogo.com.dogo_android.y.w.l.b;
import app.dogo.com.dogo_android.y.y.e.a;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.g;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.f0;
import kotlin.j0.h;
import kotlin.y.j0;

/* compiled from: ProgramBindingAdapters.kt */
@Metadata(d1 = "\u0000¤\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008Æ\u0002\u0018\u00002\u00020\u0001:\u0002Ð\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0003J(\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0003J \u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J2\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00192\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J \u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0011\u001a\u00020\"H\u0002J2\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001f0$2\u0006\u0010\u000b\u001a\u00020\u000c2\u000c\u0010%\u001a\u0008\u0012\u0004\u0012\u00020'0&2\u0006\u0010(\u001a\u00020\u0004H\u0002J,\u0010)\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0008\u0010-\u001a\u0004\u0018\u00010\u00042\u0008\u0010.\u001a\u0004\u0018\u00010\u0004H\u0002J\u001e\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u000204J\u0018\u00105\u001a\u00020\n2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002J\u001c\u0010:\u001a\u00020\n2\u0008\u0010;\u001a\u0004\u0018\u00010<2\u0008\u0010=\u001a\u0004\u0018\u00010>H\u0002J \u0010?\u001a\u00020\n2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u0007H\u0002J\u001a\u0010D\u001a\u00020\n*\u00020E2\u000c\u0010F\u001a\u0008\u0012\u0004\u0012\u00020\u00040&H\u0002J\u001a\u0010G\u001a\u00020\n*\u00020E2\u000c\u0010F\u001a\u0008\u0012\u0004\u0012\u00020\u00040&H\u0002J&\u0010H\u001a\u00020\n*\u00020*2\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010J2\u0008\u0010L\u001a\u0004\u0018\u00010\u0004H\u0007J6\u0010M\u001a\u00020\n*\u00020B2\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010J2\u0006\u0010M\u001a\u00020\u00152\u0008\u0010\u0011\u001a\u0004\u0018\u00010\"2\u0006\u0010N\u001a\u00020\u0015H\u0007J\u0016\u0010O\u001a\u00020\n*\u00020B2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0007J\u0016\u0010P\u001a\u00020\n*\u00020\u00152\u0008\u0010Q\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010R\u001a\u00020\n*\u00020>2\u0006\u0010S\u001a\u00020,H\u0007J\u0014\u0010T\u001a\u00020\n*\u00020B2\u0006\u0010U\u001a\u00020\u0007H\u0007J\u0016\u0010V\u001a\u00020\n*\u00020>2\u0008\u0010;\u001a\u0004\u0018\u00010<H\u0007J\u0016\u0010W\u001a\u00020\n*\u00020>2\u0008\u0010;\u001a\u0004\u0018\u00010XH\u0007J\u0014\u0010Y\u001a\u00020\n*\u00020B2\u0006\u0010C\u001a\u00020\u0007H\u0007J\u001e\u0010/\u001a\u00020\n*\u0002012\u0008\u0010Z\u001a\u0004\u0018\u00010[2\u0006\u0010\\\u001a\u000204H\u0007J\u001e\u0010/\u001a\u00020\n*\u0002012\u0008\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010_\u001a\u000204H\u0007J<\u0010`\u001a\u00020\n*\u00020a2\u0008\u0010\u0011\u001a\u0004\u0018\u00010b2\u0006\u0010c\u001a\u00020d2\u000c\u0010F\u001a\u0008\u0012\u0004\u0012\u00020e0&2\u0006\u00103\u001a\u0002042\u0006\u0010f\u001a\u00020gH\u0007J&\u0010h\u001a\u00020\n*\u00020i2\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020j\u0018\u00010J2\u0008\u0010k\u001a\u0004\u0018\u00010lH\u0007J\u0016\u0010m\u001a\u00020\n*\u00020*2\u0008\u0010 \u001a\u0004\u0018\u00010nH\u0007J\u0016\u0010o\u001a\u00020\n*\u00020B2\u0008\u0010 \u001a\u0004\u0018\u00010nH\u0007J\u0016\u0010p\u001a\u00020\n*\u00020*2\u0008\u0010 \u001a\u0004\u0018\u00010eH\u0007J\u0016\u0010q\u001a\u00020\n*\u00020*2\u0008\u0010 \u001a\u0004\u0018\u00010eH\u0007J\u0016\u0010r\u001a\u00020\n*\u00020*2\u0008\u0010 \u001a\u0004\u0018\u00010eH\u0007J\u0016\u0010s\u001a\u00020\n*\u00020*2\u0008\u0010 \u001a\u0004\u0018\u00010eH\u0007J\u001c\u0010t\u001a\u00020\n*\u00020u2\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020j\u0018\u00010JH\u0007J \u0010v\u001a\u00020\n*\u00020i2\u0008\u0010I\u001a\u0004\u0018\u00010j2\u0008\u0010\u0011\u001a\u0004\u0018\u00010wH\u0007J\u001c\u0010v\u001a\u00020\n*\u00020i2\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020x\u0018\u00010&H\u0007J\u001b\u0010y\u001a\u00020\n*\u00020B2\u0008\u0010z\u001a\u0004\u0018\u00010,H\u0007¢\u0006\u0002\u0010{J\u001b\u0010|\u001a\u00020\n*\u00020B2\u0008\u0010}\u001a\u0004\u0018\u00010,H\u0007¢\u0006\u0002\u0010{J\u001e\u0010~\u001a\u00020\n*\u00020\u000c2\u0008\u0010 \u001a\u0004\u0018\u00010<2\u0006\u0010A\u001a\u00020BH\u0007J\u0015\u0010\u007f\u001a\u00020\n*\u00020B2\u0007\u0010\u0080\u0001\u001a\u00020\u0004H\u0007J\u0016\u0010\u0081\u0001\u001a\u00020\n*\u00020B2\u0007\u0010 \u001a\u00030\u0082\u0001H\u0007J.\u0010\u0083\u0001\u001a\u00020\n*\u00020i2\u0014\u0010I\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020x0&\u0018\u00010J2\t\u0010\u0011\u001a\u0005\u0018\u00010\u0084\u0001H\u0007J:\u0010\u0085\u0001\u001a\u00020\n*\u00020i2\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030\u0086\u0001\u0018\u00010J2\t\u0010\u0011\u001a\u0005\u0018\u00010\u0087\u00012\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010,H\u0007¢\u0006\u0003\u0010\u0089\u0001JN\u0010\u008a\u0001\u001a\u00020\n*\u00020i2\u0010\u0010\u008b\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u008c\u0001\u0018\u00010J2\t\u0010\u0011\u001a\u0005\u0018\u00010\u008d\u00012\u0007\u0010\u008e\u0001\u001a\u0002042\u0008\u0010\u008f\u0001\u001a\u00030\u0090\u00012\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010,H\u0007¢\u0006\u0003\u0010\u0091\u0001J8\u0010\u0092\u0001\u001a\u00020\n*\u00020i2\u0015\u0010I\u001a\u0011\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0082\u00010&\u0018\u00010J2\u0007\u0010\u0011\u001a\u00030\u0093\u00012\t\u0008\u0001\u0010\u0094\u0001\u001a\u00020\u0007H\u0007J\u001e\u0010\u0095\u0001\u001a\u00020\n*\u00020B2\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010JH\u0007J\u001e\u0010\u0097\u0001\u001a\u00020\n*\u00020B2\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010JH\u0007J\u001e\u0010\u0098\u0001\u001a\u00020\n*\u00020B2\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010JH\u0007J\u001e\u0010\u0099\u0001\u001a\u00020\n*\u00020i2\u0006\u0010 \u001a\u00020^2\u0007\u0010\u0011\u001a\u00030\u009a\u0001H\u0007J\u0018\u0010\u009b\u0001\u001a\u00020\n*\u00020B2\t\u0010 \u001a\u0005\u0018\u00010\u009c\u0001H\u0007J\u0018\u0010\u009d\u0001\u001a\u00020\n*\u00020B2\t\u0010 \u001a\u0005\u0018\u00010\u009c\u0001H\u0007J#\u0010\u009e\u0001\u001a\u00020\n*\u00020E2\u000c\u0010F\u001a\u0008\u0012\u0004\u0012\u00020\u000f0&2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0016\u0010\u009f\u0001\u001a\u00020\n*\u00020B2\u0007\u0010 \u0001\u001a\u00020\u0007H\u0007J\"\u0010¡\u0001\u001a\u00020\n*\u00030¢\u00012\t\u0010 \u001a\u0005\u0018\u00010£\u00012\u0007\u0010¤\u0001\u001a\u00020\u0007H\u0007J\u0015\u0010¥\u0001\u001a\u00020\n*\u00020B2\u0006\u0010C\u001a\u00020\u0007H\u0007J\u001d\u0010¦\u0001\u001a\u00020\n*\u00020i2\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&H\u0007J\u0017\u0010§\u0001\u001a\u00020\n*\u00020B2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0007J\u001e\u0010¨\u0001\u001a\u00020\n*\u00020E2\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010JH\u0007J;\u0010©\u0001\u001a\u00020\n*\u00020\u00152\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030\u008c\u0001\u0018\u00010J2\t\u0010ª\u0001\u001a\u0004\u0018\u00010,2\n\u0010«\u0001\u001a\u0005\u0018\u00010¬\u0001H\u0007¢\u0006\u0003\u0010­\u0001J'\u0010®\u0001\u001a\u00020\n*\u00020E2\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010J2\u0008\u0010\u0011\u001a\u0004\u0018\u00010\"H\u0007JS\u0010¯\u0001\u001a\u00020\n*\u00020\u00152\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010J2\u0007\u0010°\u0001\u001a\u00020*2\u0007\u0010±\u0001\u001a\u00020B2\u0007\u0010²\u0001\u001a\u00020B2\u0007\u0010³\u0001\u001a\u0002042\u0007\u0010´\u0001\u001a\u00020B2\u0007\u0010µ\u0001\u001a\u000204H\u0007J)\u0010¯\u0001\u001a\u00020\n*\u00020i2\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030¶\u0001\u0018\u00010&2\t\u0010\u0011\u001a\u0005\u0018\u00010·\u0001H\u0007J\u001e\u0010¸\u0001\u001a\u00020\n*\u00020B2\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010JH\u0007J\u001e\u0010¹\u0001\u001a\u00020\n*\u00020B2\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010JH\u0007J\u001e\u0010º\u0001\u001a\u00020\n*\u00020*2\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010JH\u0007J\u001e\u0010»\u0001\u001a\u00020\n*\u00020*2\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010JH\u0007J\u001e\u0010¼\u0001\u001a\u00020\n*\u00020B2\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010JH\u0007J\u001e\u0010½\u0001\u001a\u00020\n*\u00020i2\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010JH\u0007J\u0018\u0010¾\u0001\u001a\u00020\n*\u00020*2\t\u0010¿\u0001\u001a\u0004\u0018\u00010XH\u0007J)\u0010À\u0001\u001a\u00020\n*\u00020i2\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030\u009c\u0001\u0018\u00010&2\t\u0010\u0011\u001a\u0005\u0018\u00010Á\u0001H\u0007J(\u0010Â\u0001\u001a\u00020\n*\u00020i2\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030Ã\u0001\u0018\u00010&2\u0008\u0010\u0011\u001a\u0004\u0018\u00010\"H\u0007J)\u0010Ä\u0001\u001a\u00020\n*\u00020i2\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030£\u0001\u0018\u00010&2\t\u0010\u0011\u001a\u0005\u0018\u00010Å\u0001H\u0007J\u001b\u0010Æ\u0001\u001a\u00020\n*\u0002042\u000c\u0010F\u001a\u0008\u0012\u0004\u0012\u00020\u000f0&H\u0007J\u001d\u0010Ç\u0001\u001a\u00020\n*\u00020B2\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010JH\u0007J\u001e\u0010È\u0001\u001a\u00020\n*\u00020E2\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010JH\u0007J\u001d\u0010È\u0001\u001a\u00020\n*\u00020E2\u000e\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&H\u0007J!\u0010É\u0001\u001a\u00020\n*\u00020*2\t\u0010 \u001a\u0005\u0018\u00010£\u00012\u0007\u0010Ê\u0001\u001a\u00020BH\u0007J-\u0010Ë\u0001\u001a\u00020\n*\u00020i2\u0015\u0010I\u001a\u0011\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030£\u00010&\u0018\u00010J2\u0007\u0010\u0011\u001a\u00030Ì\u0001H\u0007J9\u0010Í\u0001\u001a\u00020\n*\u00020\u00152\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010J2\u0007\u0010Î\u0001\u001a\u00020\u00152\u0008\u0010\u0011\u001a\u0004\u0018\u00010\"2\u0007\u0010Ï\u0001\u001a\u00020,H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006Ñ\u0001", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/ProgramBindingAdapters;", "", "()V", "PROGRAM_IMPULSE_CONTROL_ID", "", "VARIATION_DESCRIPTION_END_MARKER", "VARIATION_DESCRIPTION_MIN_LENGTH", "", "VARIATION_DESCRIPTION_START_MARKER", "addCompleteTaskView", "", "parent", "Landroid/view/ViewGroup;", "index", "task", "Lapp/dogo/com/dogo_android/repository/domain/ProgramTasks;", "addIncompleteTaskView", "callback", "Lapp/dogo/com/dogo_android/trainingprogram/tasklist/TaskListCallback;", "animateColorValue", "view", "Landroid/view/View;", "initial", "newColor", "cleanHtmlTagsAndFindHighlightIndex", "Lkotlin/Triple;", "baseString", "startIndex", "endIndex", "configureBinding", "binding", "Landroidx/databinding/ViewDataBinding;", "item", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem;", "Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramOverviewCallback;", "getBindings", "", "orderList", "", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$PottyOverviewCardEnum;", "programId", "loadCertificate", "Landroid/widget/ImageView;", "isProgramCompleted", "", "placeholderImage", "certificateImage", "setHtmlText", "webView", "Landroid/webkit/WebView;", "text", "button", "Landroid/widget/Button;", "setMarginsForDashboardCard", "layout", "Landroid/widget/LinearLayout$LayoutParams;", "context", "Landroid/content/Context;", "setProgressBar", "examItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "progressBar", "Landroid/widget/ProgressBar;", "setProgressText", "stringResource", "textView", "Landroid/widget/TextView;", "percentage", "inflateProgramOverviewBulletPoints", "Landroid/widget/LinearLayout;", "list", "inflateRecommendedProgramBulletPoints", "loadRealCertificate", "result", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/CertificateInfo;", "placeholder", "readMoreLabel", "clickArea", "removeHighlightSymbols", "setBackgroundColorFromHex", "hexCode", "setBitingProgramProgress", "sectionCompleted", "setCleanDaysText", "cleanDaysCount", "setExamsProgress", "setExamsProgresss", "Lapp/dogo/com/dogo_android/repository/domain/ModuleCompletionSummary;", "setExercisesCompletionText", "article", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "finishButton", "question", "Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion;", "gotItButton", "setIntroductionSlides", "Landroidx/viewpager2/widget/ViewPager2;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonintroduction/LessonIntroductionPagerAdapter$PagerCallback;", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "Lapp/dogo/com/dogo_android/repository/domain/LessonIntroduction;", "topLayout", "Lapp/dogo/com/dogo_android/databinding/CellProgramLessonIntroductionTopBinding;", "setLessonCardAdapter", "Landroidx/recyclerview/widget/RecyclerView;", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "callBacks", "Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter$Callbacks;", "setLessonCardImage", "Lapp/dogo/com/dogo_android/repository/domain/LessonCardItem;", "setLessonCardText", "setLessonExplanationCardClockVisibility", "setLessonExplanationCardElementVisibility", "setLessonExplanationCardImage", "setLessonExplanationCardImageVisibility", "setLessonToolbarText", "Lcom/google/android/material/appbar/MaterialToolbar;", "setLessonTrickCoverAdapter", "Lapp/dogo/com/dogo_android/dashboard/LessonCardCallback;", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "setLockIcon", "showLock", "(Landroid/widget/TextView;Ljava/lang/Boolean;)V", "setModuleProgressBarText", "isCurrent", "setProgramBubbleColor", "setProgramDesciption", "message", "setProgramDescriptionStateText", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "setProgramExamHistoryAdapter", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter$Callbacks;", "setProgramExamListAdapter", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamList;", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$Callbacks;", "shouldScrollToLastUnlocked", "(Landroidx/recyclerview/widget/RecyclerView;Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$Callbacks;Ljava/lang/Boolean;)V", "setProgramLessonPlanAdapter", "program", "Lapp/dogo/com/dogo_android/repository/domain/Program;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$Callbacks;", "upgradeButton", "nestedScrollView", "Landroidx/core/widget/NestedScrollView;", "(Landroidx/recyclerview/widget/RecyclerView;Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$Callbacks;Landroid/widget/Button;Landroidx/core/widget/NestedScrollView;Ljava/lang/Boolean;)V", "setProgramListTab", "Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter$Callbacks;", "headerViewRes", "setProgramOverViewExamCount", "Lapp/dogo/com/dogo_android/repository/domain/ProgramOverview;", "setProgramOverViewSkillCount", "setProgramOverviewSkillCount", "setProgramQuestionAdapter", "Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter$Callbacks;", "setProgramReminderPottyRepeatText", "Lapp/dogo/com/dogo_android/repository/domain/PottyRemindersItem;", "setProgramReminderPottyTimeText", "setProgramTasksAdapter", "setRecommendedProgramEnrolledUsers", "enrolledUsers", "setSegmentKnowledgeColor", "Lapp/dogo/com/dogo_android/util/customview/SegmentedProgressBar;", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "completionThreshold", "setTheoryCompletionText", "setTipsListTab", "setVariationTextHighlight", "setupDogSkillsOverview", "setupOverviewCard", "isCertificateEnabled", "cardBinding", "Lapp/dogo/com/dogo_android/databinding/LayoutProgramOverviewCertificateBinding;", "(Landroid/view/View;Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;Ljava/lang/Boolean;Lapp/dogo/com/dogo_android/databinding/LayoutProgramOverviewCertificateBinding;)V", "setupPottyOverview", "setupPottyProgramOverview", "programIcon", "programName", "enrollmentText", "enrollmentButton", "unEnrollmentText", "unEnrollmentButton", "Lapp/dogo/com/dogo_android/repository/domain/ArticleWithStatus;", "Lapp/dogo/com/dogo_android/specialprograms/potty/PottyArticleListAdapter$Callback;", "setupProgramOverviewAlreadyCompletedNumber", "setupProgramOverviewAverageCompletionTime", "setupProgramOverviewCertificatePreview", "setupProgramOverviewImage", "setupProgramOverviewName", "setupProgramOverviewTrickList", "setupProgramProgressArrow", "moduleProgressSummary", "setupReminderProgramOverview", "Lapp/dogo/com/dogo_android/specialprograms/potty/PottyReminderListAdapter$Callback;", "setupSpecialProgramExerciseOverview", "Lapp/dogo/com/dogo_android/repository/domain/TrickItemWithVariations;", "setupSpecialProgramVariationOverview", "Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramVariationAdapter$Callback;", "setupTaskCompletion", "setupToolbarName", "setupUserSkillsOverview", "setupVariationSymbolIcon", "symbolLabel", "setupVariationUnlockedList", "Lapp/dogo/com/dogo_android/specialprograms/biting/VariationsUnlockedListAdapter$Callback;", "setupZendeskClickArea", "notificationIcon", "isContactUsBadgeEnabled", "CertificateCrop", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: l, reason: from kotlin metadata */
public final class ProgramBindingAdapters {

    /* renamed from: a, reason: from kotlin metadata */
    public static final l PROGRAM_IMPULSE_CONTROL_ID = new l();

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class b {

        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;
        public static final /* synthetic */ int[] d;
        static {
            int[] iArr = new int[SpecialProgramOverviewItem_PottyOverviewCardEnum.values().length];
            final int i = 1;
            iArr[SpecialProgramOverviewItem_PottyOverviewCardEnum.ARTICLE.ordinal()] = i;
            final int i2 = 2;
            iArr[SpecialProgramOverviewItem_PottyOverviewCardEnum.LOGS.ordinal()] = i2;
            final int i3 = 3;
            iArr[SpecialProgramOverviewItem_PottyOverviewCardEnum.REMINDER.ordinal()] = i3;
            final int i4 = 4;
            iArr[SpecialProgramOverviewItem_PottyOverviewCardEnum.PROGRESS.ordinal()] = i4;
            iArr[SpecialProgramOverviewItem_PottyOverviewCardEnum.CERTIFICATE.ordinal()] = 5;
            iArr[SpecialProgramOverviewItem_PottyOverviewCardEnum.EXERCISE.ordinal()] = 6;
            app.dogo.com.dogo_android.trainingprogram.l.b.a = iArr;
            int[] iArr2 = new int[ProgramDescriptionItem_State.values().length];
            iArr2[ProgramDescriptionItem_State.IN_PROGRESS.ordinal()] = i;
            iArr2[ProgramDescriptionItem_State.COMPLETED.ordinal()] = i2;
            iArr2[ProgramDescriptionItem_State.RECOMMENDED.ordinal()] = i3;
            iArr2[ProgramDescriptionItem_State.RECOMMENDED_BIG.ordinal()] = i4;
            app.dogo.com.dogo_android.trainingprogram.l.b.b = iArr2;
            int[] iArr3 = new int[LessonIntroduction_CardType.values().length];
            iArr3[LessonIntroduction_CardType.TRAINING.ordinal()] = i;
            iArr3[LessonIntroduction_CardType.QUESTION.ordinal()] = i2;
            iArr3[LessonIntroduction_CardType.ACTIVITY.ordinal()] = i3;
            iArr3[LessonIntroduction_CardType.LESSON.ordinal()] = i4;
            app.dogo.com.dogo_android.trainingprogram.l.b.c = iArr3;
            int[] iArr4 = new int[LessonCardItem_CardType.values().length];
            iArr4[LessonCardItem_CardType.TRAINING.ordinal()] = i;
            iArr4[LessonCardItem_CardType.TASK.ordinal()] = i2;
            iArr4[LessonCardItem_CardType.QUESTION.ordinal()] = i3;
            iArr4[LessonCardItem_CardType.HEADER.ordinal()] = i4;
            app.dogo.com.dogo_android.trainingprogram.l.b.d = iArr4;
        }
    }

    @Metadata(d1 = "\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0008", d2 = {"app/dogo/com/dogo_android/trainingprogram/ProgramBindingAdapters$setHtmlText$3", "Landroid/webkit/WebViewClient;", "shouldOverrideUrlLoading", "", "view", "Landroid/webkit/WebView;", "url", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d extends WebViewClient {
        d() {
            super();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            n.f(view, "view");
            n.f(url, "url");
            return true;
        }
    }

    @Metadata(d1 = "\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0008", d2 = {"app/dogo/com/dogo_android/trainingprogram/ProgramBindingAdapters$setHtmlText$4", "Landroid/webkit/WebChromeClient;", "onProgressChanged", "", "view", "Landroid/webkit/WebView;", "newProgress", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class e extends WebChromeClient {

        final /* synthetic */ WebView a;
        final /* synthetic */ Button b;
        e(WebView webView, Button button) {
            this.a = webView;
            this.b = button;
            super();
        }

        private static final void b(Button button) {
            n.f(button, "$button");
            button.setVisibility(0);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            int i = 100;
            if (this.a.getProgress() == 100) {
                long l = 100L;
                this.a.postDelayed(new app.dogo.com.dogo_android.trainingprogram.g(this.b), l);
            }
        }

        public static /* synthetic */ void a(Button button) {
            ProgramBindingAdapters_setHtmlText_4.b(button);
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/com/dogo_android/trainingprogram/ProgramBindingAdapters$setIntroductionSlides$1", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageSelected", "", "position", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class f extends ViewPager2.i {

        final /* synthetic */ List<LessonIntroduction> a;
        final /* synthetic */ int b;
        final /* synthetic */ Button c;
        final /* synthetic */ ViewPager2 d;
        final /* synthetic */ e5 e;
        f(List<LessonIntroduction> list, int i, Button button, ViewPager2 viewPager2, e5 e5Var) {
            this.a = list;
            this.b = i;
            this.c = button;
            this.d = viewPager2;
            this.e = e5Var;
            super();
        }

        @Override // androidx.viewpager2.widget.ViewPager2$i
        public void onPageSelected(int position) throws android.content.res.Resources.NotFoundException {
            super.onPageSelected(position);
            Object item = this.a.get(position);
            if (position == this.b) {
                int i = 2131886686;
                this.c.setText(this.d.getContext().getResources().getString(i));
            } else {
                i = 2131886689;
                this.c.setText(this.d.getContext().getResources().getString(i));
            }
            n.e(this.e.S, "topLayout.cardView");
            Drawable background = this.e.S.getBackground();
            Objects.requireNonNull(background, "null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
            ProgramBindingAdapters.PROGRAM_IMPULSE_CONTROL_ID.e(this.e.S, background.getColor(), Color.parseColor(item.getCardBackgroundColor().toString()));
            n.e(this.e.Q, "topLayout.cardImage");
            ProgramBindingAdapters.setupSpecialProgramExerciseOverview(this.e.Q, item);
            n.e(this.e.T, "topLayout.checkmarkImage");
            ProgramBindingAdapters.setupReminderProgramOverview(this.e.T, item);
            n.e(this.e.O, "topLayout.arrow");
            ProgramBindingAdapters.setupReminderProgramOverview(this.e.O, item);
            n.e(this.e.V, "topLayout.imageForFirstCard");
            ProgramBindingAdapters.setupSpecialProgramVariationOverview(this.e.V, item);
            n.e(this.e.U, "topLayout.clockIcon");
            ProgramBindingAdapters.setupPottyProgramOverview(this.e.U, item);
            this.e.R.setText(item.getCardTitle());
            this.e.P.setText(item.getCardDescription());
        }
    }

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0014J\u0010\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/ProgramBindingAdapters$CertificateCrop;", "Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;", "()V", "transform", "Landroid/graphics/Bitmap;", "pool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "toTransform", "outWidth", "", "outHeight", "updateDiskCacheKey", "", "messageDigest", "Ljava/security/MessageDigest;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends com.bumptech.glide.load.resource.bitmap.f {
        @Override // com.bumptech.glide.load.resource.bitmap.f
        /* renamed from: c, reason: from kotlin metadata */
        protected Bitmap transform(com.bumptech.glide.load.engine.z.e pool, Bitmap toTransform, int outWidth, int outHeight) {
            n.f(pool, "pool");
            n.f(toTransform, "toTransform");
            final int i3 = 30;
            Bitmap bitmap = Bitmap.createBitmap(toTransform, i3, i3, toTransform.getWidth() - 60, toTransform.getHeight() - 60);
            n.e(bitmap, "createBitmap(\n                toTransform,\n                30,\n                30,\n                toTransform.width - 60,\n                toTransform.height - 60\n            )");
            return bitmap;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.f
        /* renamed from: a, reason: from kotlin metadata */
        public void updateDiskCacheKey(MessageDigest messageDigest) {
            n.f(messageDigest, "messageDigest");
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "Landroidx/databinding/ViewDataBinding;", "it", "Landroid/view/View;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends kotlin.d0.d.p implements kotlin.d0.c.l<View, ViewDataBinding> {

        public static final l.c a = new l$c();
        @Override // kotlin.d0.d.p
        public final ViewDataBinding a(View view) {
            n.f(view, "it");
            return f.d(view);
        }


        c() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class g extends kotlin.d0.d.p implements kotlin.d0.c.a<kotlin.w> {

        final /* synthetic */ app.dogo.com.dogo_android.g.t $callback;
        final /* synthetic */ ProgramLessonItem $result;
        @Override // kotlin.d0.d.p
        public final void invoke() {
            this.$callback.onExamCardSelected(this.$result);
        }

        g(app.dogo.com.dogo_android.g.t tVar, ProgramLessonItem programLessonItem) {
            this.$callback = tVar;
            this.$result = programLessonItem;
            super(0);
        }
    }
    private l() {
        super();
    }

    /* renamed from: A, reason: from kotlin metadata */
    public static final void setMarginsForDashboardCard(ProgressBar layout, ModuleCompletionSummary context) {
        int passedLessonCount = 0;
        n.f(layout, "<this>");
        passedLessonCount = 0;
        if (context == null) {
        } else {
            passedLessonCount = context.getLessonCount();
        }
        layout.setMax(passedLessonCount);
        if (context != null) {
            passedLessonCount = context.getPassedLessonCount();
        }
        layout.setProgress(passedLessonCount, true);
    }

    /* renamed from: A0, reason: from kotlin metadata */
    public static final void setProgressBar(TextView examItem, app.dogo.com.dogo_android.util.e0.y<ProgramOverview> progressBar) {
        int i = 0;
        n.f(examItem, "<this>");
        progressBar = progressBar instanceof LoadResult_Success ? (oadResult_Success)progressBar : 0;
        if (i != 0) {
            Object component1 = i.component1();
            if (component1 != null) {
                examItem.setText(component1.getProgramName());
            }
        }
    }

    /* renamed from: B, reason: from kotlin metadata */
    public static final void loadRealCertificate(TextView result, int placeholder) {
        n.f(result, "<this>");
        ProgramBindingAdapters.PROGRAM_IMPULSE_CONTROL_ID.l0(2131886590, result, placeholder);
    }

    /* renamed from: B0, reason: from kotlin metadata */
    public static final void setHtmlText(RecyclerView article, app.dogo.com.dogo_android.util.e0.y<ProgramOverview> finishButton) throws android.content.res.Resources.NotFoundException {
        int itemDecorationCount = 0;
        n.f(article, "<this>");
        z = finishButton instanceof LoadResult_Success;
        itemDecorationCount = 0;
        finishButton = finishButton instanceof oadResult_Success ? (oadResult_Success)finishButton : 0;
        if (itemDecorationCount != 0) {
            Object component1 = itemDecorationCount.component1();
            if (component1 != null) {
                if (article.getAdapter() == null) {
                    article.setAdapter(new ProgramOverviewAdapter());
                }
                androidx.recyclerview.widget.RecyclerView.h adapter2 = article.getAdapter();
                z2 = adapter2 instanceof ProgramOverviewAdapter;
                if (adapter2 instanceof ProgramOverviewAdapter) {
                }
                if (itemDecorationCount != 0) {
                    itemDecorationCount.i(component1.getSkillList());
                }
                if (article.getItemDecorationCount() == 0) {
                    article.h(new GridSpacesItemDecoration(article.getResources().getDimensionPixelSize(2131165638)));
                }
            }
        }
    }

    /* renamed from: C, reason: from kotlin metadata */
    public static final void addCompleteTaskView(WebView parent, Article index, Button task) {
        int i = 1;
        String textHtml = null;
        String textHtml2;
        n.f(parent, "<this>");
        n.f(task, "finishButton");
        i = 1;
        i = 0;
        int r0 = i;
        int i3 = 0;
        if (i != 0) {
            textHtml = index.getTextHtml();
        } else {
            if (index != null) {
                textHtml2 = index.getText();
                if (textHtml2 != null) {
                    boolean z = false;
                    int i2 = 4;
                    Object obj = null;
                    str = "\n";
                    str2 = "<br/>";
                    textHtml = l.G(textHtml2, str, str2, z, i2, obj);
                }
            }
        }
        if (textHtml == null) {
            textHtml = "";
        }
        ProgramBindingAdapters.PROGRAM_IMPULSE_CONTROL_ID.E(parent, textHtml, task);
    }

    /* renamed from: C0, reason: from kotlin metadata */
    public static final void setHtmlText(ImageView question, ModuleCompletionSummary gotItButton) {
        int i = 8;
        n.f(question, "<this>");
        if (gotItButton == null) {
            i = 8;
        } else {
            gotItButton = gotItButton.isCurrentModule() ? 0 : 4;
        }
        question.setVisibility((gotItButton.isCurrentModule() ? 0 : 4));
    }

    /* renamed from: D, reason: from kotlin metadata */
    public static final void animateColorValue(WebView view, ProgramQuestion initial, Button newColor) {
        int i = 1;
        String explanationHtml = null;
        String explanationHtml2;
        n.f(view, "<this>");
        n.f(newColor, "gotItButton");
        i = 1;
        i = 0;
        int r0 = i;
        int i3 = 0;
        if (i != 0) {
            explanationHtml = initial.getExplanationHtml();
        } else {
            if (initial != null) {
                explanationHtml2 = initial.getExplanation();
                if (explanationHtml2 != null) {
                    boolean z = false;
                    int i2 = 4;
                    Object obj = null;
                    str = "\n";
                    str2 = "<br/>";
                    explanationHtml = l.G(explanationHtml2, str, str2, z, i2, obj);
                }
            }
        }
        if (explanationHtml == null) {
            explanationHtml = "";
        }
        ProgramBindingAdapters.PROGRAM_IMPULSE_CONTROL_ID.E(view, explanationHtml, newColor);
    }

    /* renamed from: D0, reason: from kotlin metadata */
    public static final void cleanHtmlTagsAndFindHighlightIndex(RecyclerView baseString, List<PottyRemindersItem> startIndex, o.a endIndex) throws android.content.res.Resources.NotFoundException {
        int i = 0;
        str = "<this>";
        n.f(baseString, str);
        if (startIndex != null && endIndex != null && baseString.getAdapter() == null) {
            baseString.setAdapter(new PottyReminderListAdapter(endIndex));
            endIndex = baseString.getAdapter() instanceof PottyReminderListAdapter ? (PottyReminderListAdapter)baseString.getAdapter() : 0;
            if (i != 0) {
                i.j(startIndex);
            }
            if (baseString.getItemDecorationCount() == 0) {
                baseString.h(new VerticalSpaceItemDecoration(baseString.getResources().getDimensionPixelSize(2131165638)));
            }
        }
    }

    /* renamed from: E0, reason: from kotlin metadata */
    public static final void configureBinding(RecyclerView binding, List<TrickItemWithVariations> item, app.dogo.com.dogo_android.u.j callback) throws android.content.res.Resources.NotFoundException {
        int i = 0;
        str = "<this>";
        n.f(binding, str);
        if (item != null && callback != null && binding.getAdapter() == null) {
            binding.setAdapter(new SpecialProgramExercisesAdapter(callback));
            callback = binding.getAdapter() instanceof SpecialProgramExercisesAdapter ? (SpecialProgramExercisesAdapter)binding.getAdapter() : 0;
            if (i != 0) {
                i.j(item);
            }
            if (binding.getItemDecorationCount() == 0) {
                binding.h(new VerticalSpaceItemDecoration(binding.getResources().getDimensionPixelSize(2131165620)));
            }
        }
    }

    /* renamed from: F, reason: from kotlin metadata */
    private static final boolean setLessonCardAdapter(View result, MotionEvent callBacks) {
        boolean z = true;
        result = callBacks.getAction() == 2 ? 1 : 0;
        return (callBacks.getAction() == 2 ? 1 : 0);
    }

    /* renamed from: F0, reason: from kotlin metadata */
    public static final void getBindings(RecyclerView parent, List<TrickItem> orderList, l.a programId) {
        int i = 0;
        str = "<this>";
        n.f(parent, str);
        if (orderList != null && programId != null && parent.getAdapter() == null) {
            parent.setAdapter(new SpecialProgramVariationAdapter(programId));
            programId = parent.getAdapter() instanceof SpecialProgramVariationAdapter ? (SpecialProgramVariationAdapter)parent.getAdapter() : 0;
            if (i != 0) {
                i.j(orderList);
            }
            if (parent.getItemDecorationCount() == 0) {
                Context context = parent.getContext();
                str = "context";
                n.e(context, str);
                parent.h(new SpecialProgramVariationDecoration(context));
            }
        }
    }

    /* renamed from: G0, reason: from kotlin metadata */
    public static final void setLessonTrickCoverAdapter(Button result, List<ProgramTasks> callback) throws android.content.res.Resources.NotFoundException {
        int i = 1;
        ProgramTasks.Type type;
        ProgramTasks.Type cOMPLETED2;
        n.f(result, "<this>");
        n.f(callback, "list");
        int size = callback.size();
        ArrayList arrayList = new ArrayList();
        Iterator it = callback.iterator();
        boolean z2 = true;
        boolean z = false;
        while (it.hasNext()) {
            Object item = it.next();
        }
        int size2 = arrayList.size();
        android.content.res.Resources.Theme theme = null;
        if (size == size2) {
            result.setEnabled(z2);
            result.setText(result.getResources().getString(2131886403));
            size = 2131230878;
            result.setIcon(f.f(result.getResources(), size, theme));
        } else {
            result.setEnabled(z);
            int i2 = 2131886402;
            Object[] arr = new Object[2];
            arr[z] = Integer.valueOf(size2);
            arr[z2] = Integer.valueOf(size);
            result.setText(result.getResources().getString(i2, arr));
            result.setIcon(theme);
        }
    }

    public static final void H(ViewPager2 viewPager2, d.a aVar, TabLayout tabLayout, List<LessonIntroduction> list, Button button, e5 e5Var) {
        n.f(viewPager2, "<this>");
        n.f(tabLayout, "tabLayout");
        n.f(list, "list");
        n.f(button, "button");
        str = "topLayout";
        n.f(e5Var, str);
        if (aVar != null) {
            viewPager2.setAdapter(new LessonIntroductionPagerAdapter(list, aVar));
            new d(tabLayout, viewPager2, app.dogo.com.dogo_android.trainingprogram.b.a).a();
            int i = 3;
            ProgramBindingAdapters_setIntroductionSlides_1 aVar22 = new ProgramBindingAdapters_setIntroductionSlides_1(list, i, button, viewPager2, e5Var);
            viewPager2.h(aVar22);
        }
    }

    /* renamed from: H0, reason: from kotlin metadata */
    public static final void setProgramBubbleColor(TextView item, app.dogo.com.dogo_android.util.e0.y<SpecialProgramOverviewItem> textView) {
        int i = 0;
        n.f(item, "<this>");
        textView = textView instanceof LoadResult_Success ? (oadResult_Success)textView : 0;
        if (i != 0) {
            item.setText((SpecialProgramOverviewItem)i.component1().getProgramData().getProgramTitle());
        }
    }

    /* renamed from: I0, reason: from kotlin metadata */
    public static final void setProgramQuestionAdapter(LinearLayout item, app.dogo.com.dogo_android.util.e0.y<ProgramOverview> callback) {
        int i = 0;
        n.f(item, "<this>");
        callback = callback instanceof LoadResult_Success ? (oadResult_Success)callback : 0;
        if (i != 0) {
            Object component1 = i.component1();
            if (component1 != null) {
                ProgramBindingAdapters.PROGRAM_IMPULSE_CONTROL_ID.j(item, component1.getUserSkillOverview());
            }
        }
    }

    /* renamed from: J, reason: from kotlin metadata */
    public static final void setHtmlText(RecyclerView webView, app.dogo.com.dogo_android.util.e0.y<ProgramLessonItem> text, i.a button) {
        int i = 0;
        n.f(webView, "<this>");
        text = text instanceof LoadResult_Success ? (oadResult_Success)text : 0;
        if (i != 0) {
            Object component1 = i.component1();
            if (component1 != null) {
                webView.setAdapter(new LessonCardAdapter(component1, button));
            }
        }
    }

    /* renamed from: J0, reason: from kotlin metadata */
    public static final void setProgramTasksAdapter(LinearLayout list, List<String> callback) {
        str = "<this>";
        n.f(list, str);
        if (callback != null) {
            ProgramBindingAdapters.PROGRAM_IMPULSE_CONTROL_ID.k(list, callback);
        }
    }

    /* renamed from: K, reason: from kotlin metadata */
    public static final void setSegmentKnowledgeColor(ImageView item, LessonCardItem completionThreshold) {
        LessonCardItem.CardType type;
        int i = -1;
        n.f(item, "<this>");
        android.content.res.Resources.Theme theme = null;
        if (completionThreshold == null) {
            int i2 = theme;
        } else {
            type = completionThreshold.getType();
        }
        if (type == null) {
            i = -1;
        } else {
            i = app.dogo.com.dogo_android.trainingprogram.l.b.d[type.ordinal()];
        }
        if (i == 1) {
            app.dogo.com.dogo_android.util.binding.m.o(item, completionThreshold.getImageUrl());
        } else {
            if (i == 2) {
                i = 2131230825;
                item.setImageDrawable(f.f(item.getResources(), i, theme));
            } else {
                if (i != 3) {
                    i = 2131231300;
                    item.setImageDrawable(f.f(item.getResources(), i, theme));
                } else {
                    i = 2131231276;
                    item.setImageDrawable(f.f(item.getResources(), i, theme));
                }
            }
        }
    }

    /* renamed from: K0, reason: from kotlin metadata */
    public static final void setProgressText(ImageView stringResource, TrickItem textView, TextView percentage) {
        int i = 2131230835;
        int i2 = 1;
        int i3 = 3;
        n.f(stringResource, "<this>");
        str = "symbolLabel";
        n.f(percentage, str);
        if (textView != null) {
            int r0 = textView.getKnowledge() >= 4 ? R.drawable.ic_green_check : R.drawable.arrow_right_green;
            int knowledge = textView.getKnowledge();
            i2 = 1;
            i2 = 0;
            if (1 > knowledge || knowledge > 3) {
            }
            if (i2 != 0) {
                percentage.setVisibility(i2);
            } else {
                knowledge = 8;
                percentage.setVisibility(knowledge);
            }
            BindingAdapters.M(stringResource, Integer.valueOf(i));
        }
    }

    /* renamed from: L, reason: from kotlin metadata */
    public static final void setupPottyOverview(TextView result, LessonCardItem callback) {
        int i = 0;
        int i2 = -1;
        Object obj;
        n.f(result, "<this>");
        if (callback == null) {
            i = 0;
        } else {
            LessonCardItem.CardType type = callback.getType();
        }
        if (i == 0) {
            i2 = -1;
        } else {
            i2 = app.dogo.com.dogo_android.trainingprogram.l.b.d[i.ordinal()];
        }
        int i3 = 1;
        if (i2 == i3) {
            i2 = 2131887609;
            String string = result.getContext().getString(i2);
        } else {
            int i4 = 2;
            if (i2 == 2) {
                i2 = 2131887575;
                String string2 = result.getContext().getString(i2);
            } else {
                i4 = 3;
                if (i2 == 3) {
                    i2 = 2131886438;
                    String string4 = result.getContext().getString(i2);
                } else {
                    i4 = 4;
                    if (i2 != 4) {
                        String str2 = "";
                    } else {
                        i4 = 2131887591;
                        Object[] arr = new Object[i3];
                        int i5 = 0;
                        arr[i5] = Integer.valueOf(callback.getLessonNumber());
                        String string3 = result.getContext().getString(i4, arr);
                    }
                }
            }
        }
        result.setText(obj);
    }

    /* renamed from: L0, reason: from kotlin metadata */
    public static final void setProgramExamListAdapter(RecyclerView result, app.dogo.com.dogo_android.util.e0.y<? extends List<TrickItem>> callback, v.a shouldScrollToLastUnlocked) {
        androidx.recyclerview.widget.RecyclerView.h adapter;
        int i = 0;
        n.f(result, "<this>");
        n.f(shouldScrollToLastUnlocked, "callback");
        z = callback instanceof LoadResult_Success;
        if (callback instanceof oadResult_Success && result.getAdapter() == null) {
            result.setAdapter(new VariationsUnlockedListAdapter(shouldScrollToLastUnlocked));
            z2 = result.getAdapter() instanceof VariationsUnlockedListAdapter;
            result = result.getAdapter() instanceof VariationsUnlockedListAdapter ? (VariationsUnlockedListAdapter)result.getAdapter() : 0;
            if (i != 0) {
                i.j((List)callback.component1());
            }
        }
    }

    /* renamed from: M, reason: from kotlin metadata */
    public static final void setupPottyProgramOverview(ImageView result, LessonIntroduction callback) {
        LessonIntroduction.CardType type = null;
        int i = -1;
        n.f(result, "<this>");
        if (callback == null) {
            int i4 = 0;
        } else {
            type = callback.getType();
        }
        if (type == null) {
            i = -1;
        } else {
            i = app.dogo.com.dogo_android.trainingprogram.l.b.c[type.ordinal()];
        }
        if (i == 1) {
            int i2 = 0;
            result.setVisibility(i2);
        } else {
            i2 = 8;
            result.setVisibility(i2);
        }
    }

    /* renamed from: M0, reason: from kotlin metadata */
    public static final void setIntroductionSlides(View callback, app.dogo.com.dogo_android.util.e0.y<SpecialProgramOverviewItem> tabLayout, View list, app.dogo.com.dogo_android.u.j button, boolean topLayout) {
        int i = 0;
        y.c cVar = null;
        n.f(callback, "<this>");
        n.f(list, "notificationIcon");
        z = tabLayout instanceof LoadResult_Success;
        tabLayout = tabLayout instanceof oadResult_Success ? (oadResult_Success)tabLayout : 0;
        if (cVar != null) {
            i = 0;
            if (!topLayout) {
                if ((SpecialProgramOverviewItem)cVar.component1().getUnreadZendeskMessages() > 0) {
                    i = 1;
                } else {
                }
            }
            if (i == 0) {
                i = 8;
            }
            list.setVisibility(i);
            callback.setOnClickListener(new app.dogo.com.dogo_android.trainingprogram.e(button, cVar));
        }
    }

    /* renamed from: N, reason: from kotlin metadata */
    public static final void setupReminderProgramOverview(ImageView result, LessonIntroduction callback) {
        int i = 4;
        LessonIntroduction.CardType type = null;
        int i2 = -1;
        n.f(result, "<this>");
        if (callback == null) {
            int i3 = 0;
        } else {
            type = callback.getType();
        }
        if (type == null) {
            i2 = -1;
        } else {
            i2 = app.dogo.com.dogo_android.trainingprogram.l.b.c[type.ordinal()];
        }
        i = 4;
        if (i2 != 4) {
            i = 0;
        }
        result.setVisibility(i);
    }

    /* renamed from: N0, reason: from kotlin metadata */
    private static final void setProgramListTab(app.dogo.com.dogo_android.u.j result, y.c callback, View headerViewRes) {
        n.f(callback, "$success");
        if (result != null) {
            result.onHelpCardSelected((SpecialProgramOverviewItem)callback.component1().isUserPremium());
        }
    }

    /* renamed from: O, reason: from kotlin metadata */
    public static final void setupSpecialProgramExerciseOverview(ImageView result, LessonIntroduction callback) {
        LessonIntroduction.CardType type;
        int i2 = -1;
        n.f(result, "<this>");
        Drawable drawable2 = null;
        if (callback == null) {
            int i5 = drawable2;
        } else {
            type = callback.getType();
        }
        if (type == null) {
            i2 = -1;
        } else {
            i2 = app.dogo.com.dogo_android.trainingprogram.l.b.c[type.ordinal()];
        }
        if (i2 == 1) {
            int i = 2131231320;
            result.setImageDrawable(f.f(result.getResources(), i, drawable2));
        } else {
            if (i2 == 2) {
                i = 2131231276;
                result.setImageDrawable(f.f(result.getResources(), i, drawable2));
            } else {
                i = 3;
                if (i2 != 3) {
                    result.setImageDrawable(drawable2);
                } else {
                    i = 2131230825;
                    result.setImageDrawable(f.f(result.getResources(), i, drawable2));
                }
            }
        }
    }

    /* renamed from: P, reason: from kotlin metadata */
    public static final void setupSpecialProgramVariationOverview(ImageView result, LessonIntroduction callback) {
        LessonIntroduction.CardType type = null;
        int i = -1;
        n.f(result, "<this>");
        if (callback == null) {
            int i3 = 0;
        } else {
            type = callback.getType();
        }
        if (type == null) {
            i = -1;
        } else {
            i = app.dogo.com.dogo_android.trainingprogram.l.b.c[type.ordinal()];
        }
        int i2 = 4;
        if (i == i2) {
            i = 0;
            result.setVisibility(i);
        } else {
            result.setVisibility(i2);
        }
    }

    /* renamed from: Q, reason: from kotlin metadata */
    public static final void setupVariationSymbolIcon(MaterialToolbar item, app.dogo.com.dogo_android.util.e0.y<ProgramLessonItem> symbolLabel) {
        int i3 = 0;
        n.f(item, "<this>");
        symbolLabel = symbolLabel instanceof LoadResult_Success ? (oadResult_Success)symbolLabel : 0;
        if (i3 != 0) {
            Object component1 = i3.component1();
            if (component1 != null) {
                int i = 2131887591;
                Object[] arr = new Object[1];
                int i2 = 0;
                arr[i2] = Integer.valueOf(component1.getCurrentLessonPositionData().getLessonNumber());
                item.setTitle(item.getContext().getString(i, arr));
            }
        }
    }

    /* renamed from: R, reason: from kotlin metadata */
    public static final void setupOverviewCard(RecyclerView result, ProgramLessonItem isCertificateEnabled, app.dogo.com.dogo_android.g.t cardBinding) throws android.content.res.Resources.NotFoundException {
        int i = 0;
        int i2 = 2;
        int i3 = 2131165638;
        str = "<this>";
        n.f(result, str);
        if (isCertificateEnabled != null && cardBinding != null) {
            i = 0;
            if (result.getLayoutManager() == null) {
                FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(result.getContext(), 0);
                i2 = 2;
                flexboxLayoutManager.g3(i2);
                result.setLayoutManager(flexboxLayoutManager);
            }
            if (result.getItemDecorationCount() == 0) {
                i3 = 2131165638;
                i2 = (int)result.getResources().getDimension(i3);
                result.h(new LessonCardTrickCoverSpaceItemDecoration(i2));
            }
            List list = app.dogo.com.dogo_android.util.extensionfunction.j1.z(isCertificateEnabled);
            if (list.isEmpty()) {
                i = 8;
            }
            result.setVisibility(i);
            result.setAdapter(new LessonCardTrickCoverGridAdapter(list, new app.dogo.com.dogo_android.trainingprogram.l.g(cardBinding, isCertificateEnabled)));
        }
    }

    /* renamed from: S, reason: from kotlin metadata */
    public static final void setupVariationUnlockedList(RecyclerView result, List<ProgramExam> callback) throws android.content.res.Resources.NotFoundException {
        Context context;
        int i = 0;
        str = "<this>";
        n.f(result, str);
        if (callback != null && result.getLayoutManager() == null) {
            i = 0;
            FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(result.getContext(), i);
            flexboxLayoutManager.g3(i);
            result.setLayoutManager(flexboxLayoutManager);
            if (result.getItemDecorationCount() == 0) {
                i = 2131165631;
                result.h(new LessonCardTrickCoverSpaceItemDecoration((int)result.getResources().getDimension(i)));
            }
            result.setAdapter(new ProgramLessonListExamGridAdapter(callback));
        }
    }

    public static final void T(TextView textView, Boolean boolean) throws android.content.res.Resources.NotFoundException {
        Object obj;
        n.f(textView, "<this>");
        int i = 2131886586;
        if (n.b(boolean, Boolean.TRUE)) {
            String string2 = textView.getResources().getString(i);
            n.e(string2, "resources.getString(R.string.exercise_variations_header)");
            Drawable drawable = a.f(textView.getContext(), 2131231191);
            int i2 = 0;
            if (drawable != null) {
                drawable.setBounds(i2, i2, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            }
            StringBuilder stringBuilder = new StringBuilder();
            String str4 = "lock";
            str = "  ";
            boolean = str4 + str + string2;
            n.d(drawable);
            i = 4;
            int i3 = 17;
            new SpannableString(boolean).setSpan(new ImageSpan(drawable, 1), i2, i, i3);
        } else {
            String string = textView.getResources().getString(i);
        }
        textView.setText(obj);
    }

    private final void U(LinearLayout.LayoutParams layoutParams, Context context) throws android.content.res.Resources.NotFoundException {
        final int i3 = 2131165626;
        layoutParams.setMarginStart((int)context.getResources().getDimension(i3));
        layoutParams.setMarginEnd((int)context.getResources().getDimension(i3));
        layoutParams.bottomMargin = (int)context.getResources().getDimension(i3);
    }

    public static final void V(TextView textView, Boolean boolean) throws android.content.res.Resources.NotFoundException {
        n.f(textView, "<this>");
        android.content.res.Resources.Theme theme = null;
        int i2 = 0;
        if (n.b(boolean, Boolean.TRUE)) {
            textView.setTypeface(Typeface.create("sans-serif-medium", i2));
            int i = 2131099767;
            textView.setTextColor(textView.getResources().getColor(i, theme));
        } else {
            textView.setTypeface(Typeface.create("sans-serif", i2));
            i = 2131099834;
            textView.setTextColor(textView.getResources().getColor(i, theme));
        }
    }

    public static final void W(ViewGroup viewGroup, ProgramExamSummary programExamSummary, TextView textView) throws android.content.res.Resources.NotFoundException {
        n.f(viewGroup, "<this>");
        str = "textView";
        n.f(textView, str);
        if (programExamSummary != null) {
            android.content.res.Resources.Theme theme = null;
            if (n.b(programExamSummary.getProgramSaveInfo().getProgramId(), "id_impulse_control")) {
                viewGroup.setBackgroundResource(2131231182);
                int i = 2131099723;
                textView.setTextColor(viewGroup.getResources().getColor(i, theme));
            } else {
                viewGroup.setBackgroundResource(2131231181);
                i = 2131100379;
                textView.setTextColor(viewGroup.getResources().getColor(i, theme));
            }
        }
    }

    public static final void X(TextView textView, String str) {
        n.f(textView, "<this>");
        n.f(str, "message");
        textView.setText(str);
        textView.setPaintFlags(textView.getPaintFlags() | 16);
    }

    public static final void Y(TextView textView, ProgramDescriptionItem programDescriptionItem) {
        Object obj;
        n.f(textView, "<this>");
        n.f(programDescriptionItem, "item");
        int i4 = app.dogo.com.dogo_android.trainingprogram.l.b.b[programDescriptionItem.getProgramState().ordinal()];
        if (i4 == 1) {
            int i = 2131887110;
            String string = textView.getContext().getString(i);
        } else {
            if (i4 == 2) {
                i = 2131886403;
                String string2 = textView.getContext().getString(i);
            } else {
                i = 3;
                if (i4 == 3 || i4 == 4) {
                    i = 2131887431;
                    String string3 = textView.getContext().getString(i);
                } else {
                    String str3 = "";
                }
            }
        }
        textView.setText(obj);
    }

    public static final void Z(RecyclerView recyclerView, app.dogo.com.dogo_android.util.e0.y<? extends List<ProgramExam>> yVar, q.a aVar) {
        int itemDecorationCount = 0;
        app.dogo.com.dogo_android.y.o.q lessonExamHistoryAdapter;
        Context context;
        n.f(recyclerView, "<this>");
        z = yVar instanceof LoadResult_Success;
        itemDecorationCount = 0;
        yVar = yVar instanceof oadResult_Success ? (oadResult_Success)yVar : 0;
        if (itemDecorationCount != 0) {
            Object component1 = itemDecorationCount.component1();
            if (component1 != null) {
                androidx.recyclerview.widget.RecyclerView.p layoutManager = recyclerView.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                }
                itemDecorationCount = 0;
                if (itemDecorationCount == 0) {
                } else {
                    itemDecorationCount = itemDecorationCount.r2();
                }
                lessonExamHistoryAdapter = new LessonExamHistoryAdapter(aVar);
                lessonExamHistoryAdapter.j(component1);
                recyclerView.setAdapter(lessonExamHistoryAdapter);
                if (recyclerView.getItemDecorationCount() == 0) {
                    context = recyclerView.getContext();
                    n.e(context, "context");
                    recyclerView.h(new GenericInBetweenItemDivider(context, itemDecorationCount));
                }
                recyclerView.q1(itemDecorationCount);
            }
        }
    }

    /* renamed from: a, reason: from kotlin metadata */
    public static final /* synthetic */ void addIncompleteTaskView(l parent, View index, int task, int callback) {
        parent.e(index, task, callback);
    }

    /* renamed from: a0, reason: from kotlin metadata */
    public static final void loadCertificate(RecyclerView view, app.dogo.com.dogo_android.util.e0.y<ProgramExamList> isProgramCompleted, u.b placeholderImage, Boolean certificateImage) {
        int i;
        Object component1;
        Long unlockDate;
        app.dogo.com.dogo_android.y.o.u lessonExamListAdapter;
        boolean z2;
        int nextIndex = -1;
        int size;
        n.f(view, "<this>");
        i = 0;
        Object isProgramCompleted2 = isProgramCompleted instanceof LoadResult_Success ? (LoadResult_Success)isProgramCompleted2 : i;
        if (i != 0) {
            component1 = i.component1();
            if (component1 != null) {
                if (view.getAdapter() == null) {
                    view.setAdapter(new LessonExamListAdapter(placeholderImage, component1.getProgramExamSummary(), (ProgramExamList)isProgramCompleted.component1().isDogPremium()));
                }
                androidx.recyclerview.widget.RecyclerView.h isProgramCompleted3 = view.getAdapter();
                z = isProgramCompleted3 instanceof LessonExamListAdapter;
                if (isProgramCompleted3 instanceof essonExamListAdapter) {
                }
                if (i != 0) {
                    i.l(component1.getExamList());
                }
                if (n.b(certificateImage, Boolean.TRUE)) {
                    List examList = component1.getExamList();
                    ListIterator it = examList.listIterator(examList.size());
                    while (it.hasPrevious()) {
                        Object prev = it.previous();
                        if (size != 0) {
                            break;
                        }
                    }
                    nextIndex = -1;
                    view.q1(nextIndex);
                }
                if (placeholderImage != null) {
                    placeholderImage.h();
                }
            }
        }
    }

    private static final void b(ViewGroup viewGroup, int i, ProgramTasks programTasks) {
        e6 e6Var = e6.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(e6Var, "inflate(LayoutInflater.from(parent.context), parent, false)");
        e6Var.V(programTasks);
        viewGroup.addView(e6Var.w(), i);
    }

    public static final void b0(RecyclerView recyclerView, app.dogo.com.dogo_android.util.e0.y<Program> yVar, l.b bVar, Button button, NestedScrollView nestedScrollView, Boolean boolean) {
        Iterator it;
        int i = 8;
        kotlin.w wVar;
        ProgramLesson.Type aCTIVE2;
        androidx.recyclerview.widget.RecyclerView.h adapter = null;
        int itemDecorationCount;
        List lessons;
        boolean z2;
        n.f(recyclerView, "<this>");
        n.f(button, "upgradeButton");
        n.f(nestedScrollView, "nestedScrollView");
        z = yVar instanceof LoadResult_Success;
        if (yVar instanceof oadResult_Success) {
            i = 0;
            if (recyclerView.getAdapter() == null) {
                app.dogo.com.dogo_android.y.w.l programLessonsListAdapter = new ProgramLessonsListAdapter(bVar);
                Object yVar22 = yVar;
                programLessonsListAdapter.j((Program)yVar22.component1().getLessons());
                wVar = w.a;
                recyclerView.setAdapter(programLessonsListAdapter);
                it = (Program)yVar22.component1().getLessons().iterator();
                while (it.hasNext()) {
                    int r3 = (ProgramLesson)it.next().getType() == ProgramLesson_Type.ACTIVE ? 1 : i;
                    if (wVar != null) {
                        break;
                    }
                }
                i = -1;
                if (i >= 0 && n.b(boolean, Boolean.TRUE)) {
                    app.dogo.com.dogo_android.util.extensionfunction.j1.y0(recyclerView, nestedScrollView, i, 2000);
                }
                if (bVar != null) {
                    bVar.h();
                }
            } else {
                bVar = recyclerView.getAdapter() instanceof ProgramLessonsListAdapter ? (ProgramLessonsListAdapter)recyclerView.getAdapter() : 0;
                if (adapter != null) {
                    adapter.j((Program)(LoadResult_Success)yVar.component1().getLessons());
                }
            }
            if (recyclerView.getItemDecorationCount() == 0) {
                Context context = recyclerView.getContext();
                n.e(context, "context");
                recyclerView.h(new LessonListItemDivider(context));
            }
            if (!((Program)yVar.component1().isPremiumLocked())) {
                i = 8;
            }
            button.setVisibility(i);
        }
    }

    /* renamed from: c, reason: from kotlin metadata */
    private static final void readMoreLabel(ViewGroup result, int readMoreLabel, ProgramTasks callback, g clickArea) {
        g6 g6Var = g6.T(LayoutInflater.from(result.getContext()), result, false);
        n.e(g6Var, "inflate(LayoutInflater.from(parent.context), parent, false)");
        g6Var.V(callback);
        g6Var.w().setOnClickListener(new app.dogo.com.dogo_android.trainingprogram.a(callback, result, readMoreLabel, clickArea));
        result.addView(g6Var.w(), readMoreLabel);
    }

    /* renamed from: c0, reason: from kotlin metadata */
    public static final void setupZendeskClickArea(RecyclerView result, app.dogo.com.dogo_android.util.e0.y<? extends List<ProgramDescriptionItem>> notificationIcon, e.a callback, int isContactUsBadgeEnabled) {
        int i = 0;
        androidx.recyclerview.widget.RecyclerView.h adapter;
        n.f(result, "<this>");
        n.f(callback, "callback");
        z2 = notificationIcon instanceof LoadResult_Success;
        if (notificationIcon instanceof oadResult_Success && result.getAdapter() == null) {
            result.setAdapter(new ProgramListAdapter(callback));
            z = result.getAdapter() instanceof ProgramListAdapter;
            result = result.getAdapter() instanceof ProgramListAdapter ? (ProgramListAdapter)result.getAdapter() : 0;
            if (i != 0) {
                i.j((List)notificationIcon.component1());
            }
        }
    }

    /* renamed from: d, reason: from kotlin metadata */
    private static final void setProgramLessonPlanAdapter(ProgramTasks program, ViewGroup callback, int upgradeButton, g nestedScrollView, View shouldScrollToLastUnlocked) {
        n.f(program, "$task");
        n.f(callback, "$parent");
        n.f(nestedScrollView, "$callback");
        program.setType(ProgramTasks_Type.COMPLETED);
        callback.removeViewAt(upgradeButton);
        ProgramBindingAdapters.b(callback, upgradeButton, program);
        nestedScrollView.onTaskCompleted(program);
    }

    public static final void d0(TextView textView, app.dogo.com.dogo_android.util.e0.y<ProgramOverview> yVar) throws android.content.res.Resources.NotFoundException {
        int i3 = 0;
        n.f(textView, "<this>");
        yVar = yVar instanceof LoadResult_Success ? (oadResult_Success)yVar : 0;
        if (i3 != 0) {
            Object component1 = i3.component1();
            if (component1 != null) {
                int i = 2131886974;
                Object[] arr = new Object[1];
                int i2 = 0;
                arr[i2] = Integer.valueOf(component1.getExamCount());
                textView.setText(textView.getResources().getString(i, arr));
            }
        }
    }

    private final void e(View view, int i, int i2) {
        Object[] arr = new Object[2];
        ValueAnimator object = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[] { Integer.valueOf(i), Integer.valueOf(i2) });
        object.setDuration(350L);
        object.addUpdateListener(new app.dogo.com.dogo_android.trainingprogram.h(view));
        object.start();
    }

    public static final void e0(TextView textView, app.dogo.com.dogo_android.util.e0.y<ProgramOverview> yVar) {
        int enrolledUsersCount = 0;
        n.f(textView, "<this>");
        yVar = yVar instanceof LoadResult_Success ? (oadResult_Success)yVar : 0;
        if (enrolledUsersCount != 0) {
            Object component1 = enrolledUsersCount.component1();
            if (component1 != null) {
                ProgramBindingAdapters.m0(textView, component1.getEnrolledUsersCount());
            }
        }
    }

    private static final void f(View view, ValueAnimator valueAnimator) {
        n.f(view, "$view");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        view.setBackgroundColor(animatedValue.intValue());
    }

    public static final void f0(TextView textView, app.dogo.com.dogo_android.util.e0.y<ProgramOverview> yVar) throws android.content.res.Resources.NotFoundException {
        int i3 = 0;
        n.f(textView, "<this>");
        yVar = yVar instanceof LoadResult_Success ? (oadResult_Success)yVar : 0;
        if (i3 != 0) {
            Object component1 = i3.component1();
            if (component1 != null) {
                int i = 2131887593;
                Object[] arr = new Object[1];
                int i2 = 0;
                arr[i2] = Integer.valueOf(component1.getSkillList().size());
                textView.setText(textView.getResources().getString(i, arr));
            }
        }
    }

    private final kotlin.t<String, Integer, Integer> g(String str, int i, int i2) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i, i2 + 4);
        n.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String str5 = l.G(l.G(substring, "<b>", "", false, 4, null), "</b>", "", false, 4, null);
        Objects.requireNonNull(str5, "null cannot be cast to non-null type kotlin.CharSequence");
        String object = l.a1(str5).toString();
        String str2 = l.G(str, substring, object, false, 4, null);
        int i4 = l.e0(str2, object, 0, false, 6, null);
        return new Triple(str2, Integer.valueOf(i4), Integer.valueOf(object.length() + i4));
    }

    public static final void g0(RecyclerView recyclerView, ProgramQuestion programQuestion, e.c cVar) {
        n.f(recyclerView, "<this>");
        n.f(programQuestion, "item");
        n.f(cVar, "callback");
        recyclerView.setAdapter(new ProgramQuestionAdapter(cVar, p.N0(programQuestion.getAnswers()), programQuestion.getCorrectAnswer(), programQuestion.getQuestion()));
    }

    private final void h(ViewDataBinding viewDataBinding, SpecialProgramOverviewItem specialProgramOverviewItem, app.dogo.com.dogo_android.u.j jVar) {
        int i;
        boolean z;
        boolean z2 = true;
        i = 1;
        int r0 = viewDataBinding instanceof sl ? i : viewDataBinding instanceof ul;
        r0 = i != 0 ? i : viewDataBinding instanceof wl;
        r0 = i != 0 ? i : viewDataBinding instanceof sm;
        r0 = i != 0 ? i : viewDataBinding instanceof uh;
        if (!(z)) {
            z2 = viewDataBinding instanceof sh;
        }
        if (z2) {
            viewDataBinding.O(29, jVar);
            int i2 = 94;
            viewDataBinding.O(i2, specialProgramOverviewItem);
        }
        android.view.ViewGroup.LayoutParams layoutParams = viewDataBinding.w().getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        z3 = viewDataBinding instanceof ij;
        if (!(viewDataBinding instanceof ij)) {
            Context context = viewDataBinding.w().getContext();
            n.e(context, "binding.root.context");
            ProgramBindingAdapters.PROGRAM_IMPULSE_CONTROL_ID.U(layoutParams, context);
        }
    }

    public static final void h0(TextView textView, PottyRemindersItem pottyRemindersItem) throws android.content.res.Resources.NotFoundException {
        int i;
        String string;
        boolean booleanValue;
        String quantityString;
        Calendar time;
        String str2;
        List activeWeekdayShortNameArray;
        java.lang.CharSequence charSequence = null;
        Integer num;
        java.lang.CharSequence charSequence2 = null;
        java.lang.CharSequence charSequence3 = null;
        int i5 = 0;
        java.lang.CharSequence charSequence4 = null;
        kotlin.d0.c.l lVar = null;
        int i6 = 63;
        Object obj = null;
        final Object textView2 = textView;
        formatted = "<this>";
        n.f(textView2, formatted);
        if (pottyRemindersItem != null) {
            List days = pottyRemindersItem.getDays();
            booleanValue = days instanceof Collection;
            i = 0;
            i = 1;
            int r1 = i;
            if (i != 0) {
                int i2 = 2131886963;
                string = textView.getResources().getString(i2);
            } else {
                x.a iNSTANCE2 = ReminderHelper.INSTANCE;
                List days2 = pottyRemindersItem.getDays();
                Calendar time2 = Calendar.getInstance();
                str2 = "getInstance()";
                n.e(time2, str2);
                iNSTANCE2.rotateDayListFromMondayToLocaleBased(days2, time2);
                time = Calendar.getInstance();
                n.e(time, str2);
                charSequence = null;
                charSequence2 = null;
                charSequence3 = null;
                i5 = 0;
                charSequence4 = null;
                lVar = null;
                i6 = 63;
                obj = null;
                string = p.h0(iNSTANCE2.getActiveWeekdayShortNameArray(time, days2), charSequence, charSequence2, charSequence3, i5, charSequence4, lVar, i6, obj);
            }
            n.e(string, "if (item.days.all { it }) {\n                resources.getString(R.string.notification_time_every_day)\n            } else {\n                val correctedDays = ReminderHelper.rotateDayListFromMondayToLocaleBased(item.days, Calendar.getInstance())\n                ReminderHelper.getActiveWeekdayShortNameArray(Calendar.getInstance(), correctedDays).joinToString()\n            }");
            if (pottyRemindersItem.getRepeatIntervalMs() == null) {
                quantityString = "";
            } else {
                long value = pottyRemindersItem.getRepeatIntervalMs().longValue();
                long millis = TimeUnit.HOURS.toMillis(1L);
                if (value < millis) {
                    int i8 = (int)TimeUnit.MILLISECONDS.toMinutes(pottyRemindersItem.getRepeatIntervalMs().longValue());
                    int i4 = 2131755025;
                    Object[] arr3 = new Object[i];
                    quantityString = textView.getResources().getQuantityString(i4, i8, new Object[] { Integer.valueOf(i8) });
                } else {
                    int i7 = (int)TimeUnit.MILLISECONDS.toHours(pottyRemindersItem.getRepeatIntervalMs().longValue());
                    i4 = 2131755024;
                    arr3 = new Object[i];
                    quantityString = textView.getResources().getQuantityString(i4, i7, new Object[] { Integer.valueOf(i7) });
                }
            }
            n.e(quantityString, "if (item.repeatIntervalMs != null) {\n                if (item.repeatIntervalMs < TimeUnit.HOURS.toMillis(1)) {\n                    val minutes = TimeUnit.MILLISECONDS.toMinutes(item.repeatIntervalMs).toInt()\n                    resources.getQuantityString(\n                        R.plurals.time_placeholder_min,\n                        minutes,\n                        minutes\n                    )\n                } else {\n                    val hours = TimeUnit.MILLISECONDS.toHours(item.repeatIntervalMs).toInt()\n                    resources.getQuantityString(\n                        R.plurals.time_placeholder_hour,\n                        hours,\n                        hours\n                    )\n                }\n            } else {\n                \"\"\n            }");
            Object[] arr2 = new Object[i];
            String string2 = textView.getResources().getString(2131886964, new Object[] { quantityString });
            n.e(string2, "resources.getString(R.string.notification_time_every_general, intervalString)");
            int i3 = 2;
            Object[] arr = new Object[i3];
            arr[i] = string;
            arr[i] = string2;
            String formatted = String.format("%s. %s", Arrays.copyOf(arr, i3));
            str = "java.lang.String.format(format, *args)";
            n.e(formatted, str);
            textView2.setText(formatted);
        }
    }

    private final Map<String, ViewDataBinding> i(ViewGroup viewGroup, List<? extends SpecialProgramOverviewItem.PottyOverviewCardEnum> list, String str) throws NoWhenBranchMatchedException {
        int i3 = 0;
        wl wlVar;
        boolean hasNext;
        boolean z2;
        h hVar2 = i.v(x.b(viewGroup), app.dogo.com.dogo_android.trainingprogram.l.c.a);
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        final Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            Object item7 = it2.next();
            str = "inflate(LayoutInflater.from(parent.context), parent, false)";
            boolean z = false;
            i3 = 0;
            Iterator it = hVar2.iterator();
            while (it.hasNext()) {
                Object item4 = it.next();
                z2 = (ViewDataBinding)item4 instanceof sm;
                if (item4 instanceof sm) {
                    break loop_5;
                }
            }
            arrayList.add(new Pair(item7.getCardType(), wlVar));
            item4 = it.next();
            z2 = (ViewDataBinding)item4 instanceof sm;
            it = hVar2.iterator();
            while (it.hasNext()) {
                Object item5 = it.next();
                z2 = (ViewDataBinding)item5 instanceof sh;
                if (item5 instanceof sh) {
                    break loop_11;
                }
            }
            item5 = it.next();
            z2 = (ViewDataBinding)item5 instanceof sh;
            it = hVar2.iterator();
            while (it.hasNext()) {
                Object item6 = it.next();
                z2 = (ViewDataBinding)item6 instanceof uh;
                if (item6 instanceof uh) {
                    break loop_17;
                }
            }
            item6 = it.next();
            z2 = (ViewDataBinding)item6 instanceof uh;
            it = hVar2.iterator();
            while (it.hasNext()) {
                Object item = it.next();
                z2 = (ViewDataBinding)item instanceof wl;
                if (item instanceof wl) {
                    break loop_23;
                }
            }
            item = it.next();
            z2 = (ViewDataBinding)item instanceof wl;
            it = hVar2.iterator();
            while (it.hasNext()) {
                Object item2 = it.next();
                z2 = (ViewDataBinding)item2 instanceof ul;
                if (item2 instanceof ul) {
                    break loop_29;
                }
            }
            item2 = it.next();
            z2 = (ViewDataBinding)item2 instanceof ul;
            it = hVar2.iterator();
            while (it.hasNext()) {
                Object item3 = it.next();
                z2 = (ViewDataBinding)item3 instanceof sl;
                if (item3 instanceof sl) {
                    break loop_35;
                }
            }
            item3 = it.next();
            z2 = (ViewDataBinding)item3 instanceof sl;
        }
        return j0.s(arrayList);
    }

    public static final void i0(TextView textView, PottyRemindersItem pottyRemindersItem) {
        String endTime;
        kotlin.o pair;
        int i = 2;
        Object[] arr;
        int i2 = 0;
        String str;
        Object obj;
        endTime = "<this>";
        n.f(textView, endTime);
        if (pottyRemindersItem != null && pottyRemindersItem.getEndTime() != null) {
            if (DateFormat.is24HourFormat(textView.getContext())) {
                pair = new Pair(pottyRemindersItem.getStartTime(), pottyRemindersItem.getEndTime());
            } else {
                x.a iNSTANCE2 = ReminderHelper.INSTANCE;
                kotlin.o timeToInts = iNSTANCE2.parseTimeToInts(pottyRemindersItem.getStartTime());
                String endTime3 = pottyRemindersItem.getEndTime();
                n.d(endTime3);
                kotlin.o timeToInts2 = iNSTANCE2.parseTimeToInts(endTime3);
                Calendar time4 = Calendar.getInstance();
                int i4 = 11;
                time4.set(i4, (Number)timeToInts.a().intValue());
                int i3 = 12;
                time4.set(i3, (Number)timeToInts.b().intValue());
                Calendar time = Calendar.getInstance();
                time.set(i4, (Number)timeToInts2.a().intValue());
                time.set(i3, (Number)timeToInts2.b().intValue());
                str = "hh:mm a";
                pair = new Pair(new SimpleDateFormat(str, Locale.getDefault()).format(time4.getTime()), new SimpleDateFormat(str, Locale.getDefault()).format(time.getTime()));
            }
            i = 2;
            arr = new Object[i];
            i2 = 0;
            arr[i2] = (String)pair.a();
            arr[1] = (String)pair.b();
            endTime = "java.lang.String.format(format, *args)";
            n.e(String.format("%s - %s", Arrays.copyOf(arr, i)), endTime);
            textView.setText(obj);
        }
    }

    private final void j(LinearLayout linearLayout, List<String> list) {
        im imVar;
        String str;
        if (linearLayout.getChildCount() == 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                imVar = im.T(LayoutInflater.from(linearLayout.getContext()), linearLayout, false);
                str = "inflate(inflater, this, false)";
                n.e(imVar, str);
                imVar.V((String)it.next());
                linearLayout.addView(imVar.w());
            }
        }
    }

    public static final void j0(LinearLayout linearLayout, List<ProgramTasks> list, g gVar) {
        int i = 0;
        ProgramTasks.Type type;
        ProgramTasks.Type nOT_STARTED2;
        n.f(linearLayout, "<this>");
        n.f(list, "list");
        n.f(gVar, "callback");
        final Iterator it = list.iterator();
        i = 0;
        while (it.hasNext()) {
            Object item = it.next();
            i = i + 1;
            if (i < 0) {
                p.q();
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) 0;
            }
        }
    }

    private final void k(LinearLayout linearLayout, List<String> list) {
        q4 q4Var;
        String str;
        if (linearLayout.getChildCount() == 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                q4Var = q4.T(LayoutInflater.from(linearLayout.getContext()), linearLayout, false);
                str = "inflate(inflater, this, false)";
                n.e(q4Var, str);
                q4Var.V((String)it.next());
                linearLayout.addView(q4Var.w());
            }
        }
    }

    private final void k0(ProgramExamSummary programExamSummary, ProgressBar progressBar) {
        int value = 0;
        Integer passedExamsCount;
        if (progressBar != null && programExamSummary == null) {
            progressBar.setMax(value);
            if (programExamSummary != null) {
                passedExamsCount = programExamSummary.getPassedExamsCount();
                if (passedExamsCount != null) {
                    value = passedExamsCount.intValue();
                }
            }
            progressBar.setProgress(value);
        }
    }

    private final void l0(int i, TextView textView, int i2) throws android.content.res.Resources.NotFoundException {
        String string = textView.getResources().getString(i);
        n.e(string, "textView.resources.getString(stringResource)");
        i2 = l.e0(string, "%d", 0, false, 6, null);
        int i4 = 1;
        Object[] arr = new Object[i4];
        arr[0] = Integer.valueOf(i2);
        String string2 = textView.getResources().getString(i, arr);
        n.e(string2, "textView.resources.getString(stringResource, percentage)");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string2);
        int i10 = 33;
        spannableStringBuilder.setSpan(new StyleSpan(i4), i2, (String.valueOf(i2).length() + i2) + i4, i10);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(16, i4), i2, (String.valueOf(i2).length() + i2) + i4, i10);
        textView.setText(spannableStringBuilder);
    }

    public static final void m0(TextView textView, int i) {
        n.f(textView, "<this>");
        textView.setText(new DecimalFormat("#,###,###").format(Integer.valueOf(i)));
    }

    public static final void n0(SegmentedProgressBar segmentedProgressBar, TrickItem trickItem, int i) throws android.content.res.Resources.NotFoundException {
        int color;
        str = "<this>";
        n.f(segmentedProgressBar, str);
        if (trickItem != null) {
            android.content.res.Resources.Theme theme = null;
            if (trickItem.getKnowledge() >= i) {
                i = 2131099772;
                color = segmentedProgressBar.getResources().getColor(i, theme);
            } else {
                i = 2131100358;
                color = segmentedProgressBar.getResources().getColor(i, theme);
            }
            segmentedProgressBar.setProgressSegmentColor(color);
        }
    }

    public static final void o0(TextView textView, int i) {
        n.f(textView, "<this>");
        ProgramBindingAdapters.PROGRAM_IMPULSE_CONTROL_ID.l0(2131887506, textView, i);
    }

    public static final void p0(RecyclerView recyclerView, List<String> list) {
        androidx.recyclerview.widget.RecyclerView.h adapter;
        str = "<this>";
        n.f(recyclerView, str);
        if (list != null && recyclerView.getAdapter() == null) {
            recyclerView.setAdapter(new VariationTipsAdapter(list));
            if (recyclerView.getItemDecorationCount() == 0) {
                Context context = recyclerView.getContext();
                str2 = "context";
                n.e(context, str2);
                recyclerView.h(new SpecialProgramVariationTipDecoration(context));
            }
        }
    }

    public static final void q0(TextView textView, String str) {
        String str3;
        boolean z = false;
        str = "<this>";
        n.f(textView, str);
        if (str != null) {
            z = false;
            int intValue = l.e0(str, "<b>", 0, z, 6, null);
            boolean z2 = false;
            int i2 = 6;
            Object obj = null;
            str3 = "</b>";
            int i = l.e0(str, str3, z, z2, i2, obj);
            if (intValue >= 0 && i > 0) {
                if (str.length() >= 7) {
                    kotlin.t tVar = ProgramBindingAdapters.PROGRAM_IMPULSE_CONTROL_ID.g(str, intValue, i);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder((String)tVar.a());
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(a.d(textView.getContext(), 2131100352)), (Number)tVar.b().intValue(), (Number)tVar.c().intValue(), 33);
                    textView.setText(spannableStringBuilder);
                } else {
                    textView.setText(str);
                }
            }
        }
    }

    public static final void r0(LinearLayout linearLayout, app.dogo.com.dogo_android.util.e0.y<ProgramOverview> yVar) {
        int i = 0;
        n.f(linearLayout, "<this>");
        yVar = yVar instanceof LoadResult_Success ? (oadResult_Success)yVar : 0;
        if (i != 0) {
            Object component1 = i.component1();
            if (component1 != null) {
                ProgramBindingAdapters.PROGRAM_IMPULSE_CONTROL_ID.j(linearLayout, component1.getDogSkillOverview());
            }
        }
    }

    private final void s(ImageView imageView, boolean z, String str, String str2) {
        final Context context = imageView.getContext();
        final int i = 0;
        if (z) {
            imageView.setVisibility(i);
            m.a(context).D(str2).x1(new ProgramBindingAdapters_CertificateCrop()).p1(MyAppGlideModule.d(context)).C0(imageView);
        } else {
            imageView.setVisibility(i);
            m.a(context).D(str).p1(MyAppGlideModule.d(context)).C0(imageView);
        }
    }

    public static final void s0(View view, app.dogo.com.dogo_android.util.e0.y<Program> yVar, Boolean boolean, gm gmVar) {
        int i = 0;
        n.f(view, "<this>");
        if (n.b(boolean, Boolean.TRUE)) {
            z = yVar instanceof LoadResult_Success;
            yVar = yVar instanceof oadResult_Success ? (oadResult_Success)yVar : 0;
            if (i != 0) {
                Object component1 = i.component1();
                if (component1 != null) {
                    if (gmVar != null) {
                        gmVar.T(component1);
                    }
                }
            }
        }
    }

    public static final void t(ImageView imageView, app.dogo.com.dogo_android.util.e0.y<CertificateInfo> yVar, String str) {
        int i;
        String certificateImageUrl = null;
        boolean z2 = false;
        n.f(imageView, "<this>");
        Object yVar22 = yVar instanceof LoadResult_Success ? (LoadResult_Success)yVar22 : i;
        if (i != 0) {
            Object component1 = i.component1();
            if (component1 != null) {
                certificateImageUrl = component1.getCertificateImageUrl();
            }
        }
        yVar = yVar != null ? 1 : 0;
        ProgramBindingAdapters.PROGRAM_IMPULSE_CONTROL_ID.s(imageView, (yVar != null ? 1 : 0), str, certificateImageUrl);
    }

    public static final void t0(LinearLayout linearLayout, app.dogo.com.dogo_android.util.e0.y<SpecialProgramOverviewItem> yVar, app.dogo.com.dogo_android.u.j jVar) {
        app.dogo.com.dogo_android.y.l pROGRAM_IMPULSE_CONTROL_ID2;
        n.f(linearLayout, "<this>");
        z = yVar instanceof LoadResult_Success;
        if (yVar instanceof oadResult_Success && jVar != null) {
            Object component1 = yVar.component1();
            Map map = ProgramBindingAdapters.PROGRAM_IMPULSE_CONTROL_ID.i(linearLayout, component1.getCardsOrder(), component1.getProgramId());
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                ProgramBindingAdapters.PROGRAM_IMPULSE_CONTROL_ID.h((ViewDataBinding)it.next(), component1, jVar);
            }
            if (linearLayout.getChildCount() == 0) {
                Iterator it2 = component1.getCardsOrder().iterator();
                while (it2.hasNext()) {
                    linearLayout.addView((ViewDataBinding)j0.i(map, (SpecialProgramOverviewItem_PottyOverviewCardEnum)it2.next().getCardType()).w());
                }
            }
        }
    }

    public static final void u(TextView textView, app.dogo.com.dogo_android.util.e0.y<SpecialProgramOverviewItem> yVar, View view, app.dogo.com.dogo_android.u.j jVar, View view2) {
        java.lang.CharSequence text = null;
        int i = 4;
        n.f(textView, "<this>");
        n.f(view, "readMoreLabel");
        n.f(view2, "clickArea");
        if (yVar instanceof LoadResult_Success) {
            Object component1 = yVar.component1();
            textView.setText(component1.getProgramData().getProgramDescription());
            Layout layout = textView.getLayout();
            if (layout != null) {
                text = layout.getText();
            }
            boolean z = true;
            textView = (l.x(String.valueOf(text), component1.getProgramData().getProgramDescription(), z)) ^ z != 0 ? 0 : 4;
            view.setVisibility(((l.x(String.valueOf(text), component1.getProgramData().getProgramDescription(), z)) ^ z != 0 ? 0 : 4));
            view2.setOnClickListener(((l.x(String.valueOf(text), component1.getProgramData().getProgramDescription(), z)) ^ z != 0 ? 0 : 4));
        } else {
            view2.setOnClickListener(null);
        }
    }

    public static final void u0(View view, app.dogo.com.dogo_android.util.e0.y<SpecialProgramOverviewItem> yVar, ImageView imageView, TextView textView, TextView textView2, Button button, TextView textView3, Button button2) {
        int i = 0;
        n.f(view, "<this>");
        n.f(imageView, "programIcon");
        n.f(textView, "programName");
        n.f(textView2, "enrollmentText");
        n.f(button, "enrollmentButton");
        n.f(textView3, "unEnrollmentText");
        n.f(button2, "unEnrollmentButton");
        programEnrolled = yVar instanceof LoadResult_Success;
        yVar = yVar instanceof oadResult_Success ? (oadResult_Success)yVar : 0;
        if (i != 0) {
            Object component1 = i.component1();
            if (component1 != null) {
                BindingAdapters.x(imageView, component1.getProgramData().getCenterImage());
                textView.setText(component1.getProgramData().getProgramTitle());
                i = 4;
                int i2 = 0;
                if (component1.isProgramEnrolled()) {
                    textView2.setVisibility(i);
                    button.setVisibility(i);
                    textView3.setVisibility(i2);
                    button2.setVisibility(i2);
                } else {
                    textView2.setVisibility(i2);
                    button.setVisibility(i2);
                    textView3.setVisibility(i);
                    button2.setVisibility(i);
                }
            }
        }
    }

    private static final void v(app.dogo.com.dogo_android.u.j jVar, SpecialProgramOverviewItem specialProgramOverviewItem, View view) {
        n.f(specialProgramOverviewItem, "$data");
        if (jVar != null) {
            jVar.programDescriptionClicked(specialProgramOverviewItem.getProgramData().getProgramDescription());
        }
    }

    public static final void v0(RecyclerView recyclerView, List<ArticleWithStatus> list, j.a aVar) throws android.content.res.Resources.NotFoundException {
        int i = 0;
        str = "<this>";
        n.f(recyclerView, str);
        if (list != null && aVar != null && recyclerView.getAdapter() == null) {
            recyclerView.setAdapter(new PottyArticleListAdapter(aVar));
            aVar = recyclerView.getAdapter() instanceof PottyArticleListAdapter ? (PottyArticleListAdapter)recyclerView.getAdapter() : 0;
            if (i != 0) {
                i.j(list);
            }
            if (recyclerView.getItemDecorationCount() == 0) {
                recyclerView.h(new VerticalSpaceItemDecoration(recyclerView.getResources().getDimensionPixelSize(2131165638)));
            }
        }
    }

    public static final void w(TextView textView, String str) {
        int i;
        int i2;
        String str3;
        int i3 = 0;
        boolean z = false;
        int i4 = 6;
        Object obj = null;
        Object obj2 = null;
        String str4;
        String str5;
        String str6;
        boolean z2 = false;
        int i5 = 4;
        Object obj3 = null;
        Object obj4;
        str = "<this>";
        n.f(textView, str);
        if (str != null) {
            i3 = 0;
            z = false;
            i4 = 6;
            obj = null;
            java.lang.CharSequence str22 = str;
            i = l.e0(str22, "<b>", i3, z, i4, obj);
            str3 = "</b>";
            i2 = l.e0(str22, str3, i3, z, i4, obj);
            if (i >= 0 && i2 > 0 && str.length() >= 7) {
                String substring = str.substring(i, i2 + 4);
                n.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                z2 = false;
                i5 = 4;
                obj3 = null;
                str5 = "</b>";
                str6 = "";
                String str8 = l.G(l.G(substring, "<b>", "", false, 4, null), str5, str6, z2, i5, obj3);
                Objects.requireNonNull(str8, "null cannot be cast to non-null type kotlin.CharSequence");
                obj2 = null;
                String str13 = l.G(str, substring, l.a1(str8).toString(), false, 4, obj2);
            }
            textView.setText(obj4);
        }
    }

    public static final void w0(TextView textView, app.dogo.com.dogo_android.util.e0.y<ProgramOverview> yVar) throws android.content.res.Resources.NotFoundException {
        int i3 = 0;
        n.f(textView, "<this>");
        yVar = yVar instanceof LoadResult_Success ? (oadResult_Success)yVar : 0;
        if (i3 != 0) {
            Object component1 = i3.component1();
            if (component1 != null) {
                int i = 2131886492;
                Object[] arr = new Object[1];
                int i2 = 0;
                arr[i2] = Integer.valueOf(component1.getEnrolledUsersCount());
                textView.setText(textView.getResources().getString(i, arr));
            }
        }
    }

    public static final void x(View view, String str) {
        str = "<this>";
        n.f(view, str);
        if (str != null) {
            try {
                i = !l.z(str);
                view.setBackgroundColor(Color.parseColor(str));
                view.setBackgroundColor(-65536);
            } catch (Exception e) {
                a.d(e);
                view.setBackgroundColor(i2);
            }
        }
    }

    public static final void x0(TextView textView, app.dogo.com.dogo_android.util.e0.y<ProgramOverview> yVar) throws android.content.res.Resources.NotFoundException {
        int i3 = 0;
        n.f(textView, "<this>");
        yVar = yVar instanceof LoadResult_Success ? (oadResult_Success)yVar : 0;
        if (i3 != 0) {
            Object component1 = i3.component1();
            if (component1 != null) {
                int i = 2131886198;
                Object[] arr = new Object[2];
                int i2 = 1;
                arr[i2] = Integer.valueOf(component1.getAverageDurationWeeks());
                textView.setText(textView.getResources().getString(i, arr));
            }
        }
    }

    public static final void y(ProgressBar progressBar, boolean z) {
        Drawable drawable;
        n.f(progressBar, "<this>");
        android.content.res.Resources.Theme theme = null;
        if (z) {
            int i = 2131231296;
            drawable = f.f(progressBar.getResources(), i, theme);
        } else {
            i = 2131231295;
            drawable = f.f(progressBar.getResources(), i, theme);
        }
        progressBar.setProgressDrawable(drawable);
    }

    public static final void y0(ImageView imageView, app.dogo.com.dogo_android.util.e0.y<ProgramOverview> yVar) {
        int i = 0;
        n.f(imageView, "<this>");
        yVar = yVar instanceof LoadResult_Success ? (oadResult_Success)yVar : 0;
        if (i != 0) {
            Object component1 = i.component1();
            if (component1 != null) {
                m.a(imageView.getContext()).D(component1.getCertificatePreview()).p1(MyAppGlideModule.d(imageView.getContext())).C0(imageView);
            }
        }
    }

    public static final void z(ProgressBar progressBar, ProgramExamSummary programExamSummary) {
        n.f(progressBar, "<this>");
        ProgramBindingAdapters.PROGRAM_IMPULSE_CONTROL_ID.k0(programExamSummary, progressBar);
    }

    public static final void z0(ImageView imageView, app.dogo.com.dogo_android.util.e0.y<ProgramOverview> yVar) {
        int i = 0;
        n.f(imageView, "<this>");
        yVar = yVar instanceof LoadResult_Success ? (oadResult_Success)yVar : 0;
        if (i != 0) {
            Object component1 = i.component1();
            if (component1 != null) {
                m.a(imageView.getContext()).D(component1.getMirrorableImage()).C0(imageView);
            }
        }
    }

    public final void E(WebView webView, String str, Button button) {
        n.f(webView, "webView");
        n.f(str, "text");
        n.f(button, "button");
        webView.getSettings().setDefaultFontSize(16);
        boolean z = false;
        webView.setVerticalScrollBarEnabled(z);
        webView.setHorizontalScrollBarEnabled(z);
        webView.setOnTouchListener(app.dogo.com.dogo_android.trainingprogram.f.a);
        webView.setOnLongClickListener(app.dogo.com.dogo_android.trainingprogram.d.a);
        webView.setLongClickable(z);
        webView.setHapticFeedbackEnabled(z);
        webView.setWebViewClient(new ProgramBindingAdapters_setHtmlText_3());
        webView.setBackgroundColor(Color.parseColor("#f9f9f9"));
        StringBuilder stringBuilder = new StringBuilder();
        String str6 = "<html><header>";
        String str7 = "<link rel='stylesheet' href='article_details/style.css' type='text/css'>";
        String str8 = "</header><body>";
        String str13 = "</body></html>";
        str10 = str6 + str7 + str8 + str + str13;
        webView.setWebChromeClient(new ProgramBindingAdapters_setHtmlText_4(webView, button));
        webView.loadDataWithBaseURL("file:///android_asset/", str10, "text/html", "UTF-8", null);
    }


    /* renamed from: G, reason: from kotlin metadata */
    private static final boolean inflateProgramOverviewBulletPoints(View list) {
        return true;
    }

    /* renamed from: I, reason: from kotlin metadata */
    private static final void setProgramExamHistoryAdapter(TabLayout.g result, int callback) {
        n.f(result, "$noName_0");
    }

    public static /* synthetic */ void l(ProgramTasks programTasks, ViewGroup viewGroup, int i, g gVar, View view) {
        ProgramBindingAdapters.setProgramLessonPlanAdapter(programTasks, viewGroup, i, gVar, view);
    }

    public static /* synthetic */ void m(TabLayout.g gVar, int i) {
        ProgramBindingAdapters.setProgramExamHistoryAdapter(gVar, i);
    }

    public static /* synthetic */ void n(app.dogo.com.dogo_android.u.j jVar, SpecialProgramOverviewItem specialProgramOverviewItem, View view) {
        ProgramBindingAdapters.v(jVar, specialProgramOverviewItem, view);
    }

    /* renamed from: o, reason: from kotlin metadata */
    public static /* synthetic */ boolean inflateRecommendedProgramBulletPoints(View list) {
        return ProgramBindingAdapters.inflateProgramOverviewBulletPoints(list);
    }

    public static /* synthetic */ void p(app.dogo.com.dogo_android.u.j jVar, y.c cVar, View view) {
        ProgramBindingAdapters.setProgramListTab(jVar, cVar, view);
    }

    public static /* synthetic */ boolean q(View view, MotionEvent motionEvent) {
        return ProgramBindingAdapters.setLessonCardAdapter(view, motionEvent);
    }

    public static /* synthetic */ void r(View view, ValueAnimator valueAnimator) {
        ProgramBindingAdapters.f(view, valueAnimator);
    }
}
