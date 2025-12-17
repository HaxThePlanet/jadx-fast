package app.dogo.com.dogo_android.y;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
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
import androidx.core.content.a;
import androidx.core.content.e.f;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2.i;
import app.dogo.com.dogo_android.g.s;
import app.dogo.com.dogo_android.g.t;
import app.dogo.com.dogo_android.g.u;
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
import app.dogo.com.dogo_android.u.i;
import app.dogo.com.dogo_android.u.j;
import app.dogo.com.dogo_android.u.l;
import app.dogo.com.dogo_android.u.l.a;
import app.dogo.com.dogo_android.u.m.q;
import app.dogo.com.dogo_android.u.m.v;
import app.dogo.com.dogo_android.u.m.v.a;
import app.dogo.com.dogo_android.u.n.j;
import app.dogo.com.dogo_android.u.n.j.a;
import app.dogo.com.dogo_android.u.n.o;
import app.dogo.com.dogo_android.u.n.o.a;
import app.dogo.com.dogo_android.util.MyAppGlideModule;
import app.dogo.com.dogo_android.util.customview.SegmentedProgressBar;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.f0.m;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.m;
import app.dogo.com.dogo_android.util.n0.m;
import app.dogo.com.dogo_android.util.n0.n;
import app.dogo.com.dogo_android.util.n0.o;
import app.dogo.com.dogo_android.util.n0.p;
import app.dogo.com.dogo_android.util.n0.w;
import app.dogo.com.dogo_android.util.n0.x;
import app.dogo.com.dogo_android.util.n0.y;
import app.dogo.com.dogo_android.util.o;
import app.dogo.com.dogo_android.util.p;
import app.dogo.com.dogo_android.util.x;
import app.dogo.com.dogo_android.util.x.a;
import app.dogo.com.dogo_android.y.a0.e;
import app.dogo.com.dogo_android.y.a0.e.c;
import app.dogo.com.dogo_android.y.c0.g;
import app.dogo.com.dogo_android.y.o.q;
import app.dogo.com.dogo_android.y.o.q.a;
import app.dogo.com.dogo_android.y.o.u;
import app.dogo.com.dogo_android.y.o.u.b;
import app.dogo.com.dogo_android.y.s.i;
import app.dogo.com.dogo_android.y.s.i.a;
import app.dogo.com.dogo_android.y.v.d;
import app.dogo.com.dogo_android.y.v.d.a;
import app.dogo.com.dogo_android.y.w.k;
import app.dogo.com.dogo_android.y.w.l;
import app.dogo.com.dogo_android.y.w.l.b;
import app.dogo.com.dogo_android.y.y.e;
import app.dogo.com.dogo_android.y.y.e.a;
import app.dogo.com.dogo_android.y.z.d;
import com.bumptech.glide.j;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.resource.bitmap.f;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.g;
import com.google.android.material.tabs.d;
import d.h.l.x;
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
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.f0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.j0.h;
import kotlin.j0.i;
import kotlin.k0.l;
import kotlin.o;
import kotlin.t;
import kotlin.w;
import kotlin.y.j0;
import kotlin.y.p;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000¤\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008Æ\u0002\u0018\u00002\u00020\u0001:\u0002Ð\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0003J(\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0003J \u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J2\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00192\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J \u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0011\u001a\u00020\"H\u0002J2\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001f0$2\u0006\u0010\u000b\u001a\u00020\u000c2\u000c\u0010%\u001a\u0008\u0012\u0004\u0012\u00020'0&2\u0006\u0010(\u001a\u00020\u0004H\u0002J,\u0010)\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0008\u0010-\u001a\u0004\u0018\u00010\u00042\u0008\u0010.\u001a\u0004\u0018\u00010\u0004H\u0002J\u001e\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u000204J\u0018\u00105\u001a\u00020\n2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002J\u001c\u0010:\u001a\u00020\n2\u0008\u0010;\u001a\u0004\u0018\u00010<2\u0008\u0010=\u001a\u0004\u0018\u00010>H\u0002J \u0010?\u001a\u00020\n2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u0007H\u0002J\u001a\u0010D\u001a\u00020\n*\u00020E2\u000c\u0010F\u001a\u0008\u0012\u0004\u0012\u00020\u00040&H\u0002J\u001a\u0010G\u001a\u00020\n*\u00020E2\u000c\u0010F\u001a\u0008\u0012\u0004\u0012\u00020\u00040&H\u0002J&\u0010H\u001a\u00020\n*\u00020*2\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010J2\u0008\u0010L\u001a\u0004\u0018\u00010\u0004H\u0007J6\u0010M\u001a\u00020\n*\u00020B2\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010J2\u0006\u0010M\u001a\u00020\u00152\u0008\u0010\u0011\u001a\u0004\u0018\u00010\"2\u0006\u0010N\u001a\u00020\u0015H\u0007J\u0016\u0010O\u001a\u00020\n*\u00020B2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0007J\u0016\u0010P\u001a\u00020\n*\u00020\u00152\u0008\u0010Q\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010R\u001a\u00020\n*\u00020>2\u0006\u0010S\u001a\u00020,H\u0007J\u0014\u0010T\u001a\u00020\n*\u00020B2\u0006\u0010U\u001a\u00020\u0007H\u0007J\u0016\u0010V\u001a\u00020\n*\u00020>2\u0008\u0010;\u001a\u0004\u0018\u00010<H\u0007J\u0016\u0010W\u001a\u00020\n*\u00020>2\u0008\u0010;\u001a\u0004\u0018\u00010XH\u0007J\u0014\u0010Y\u001a\u00020\n*\u00020B2\u0006\u0010C\u001a\u00020\u0007H\u0007J\u001e\u0010/\u001a\u00020\n*\u0002012\u0008\u0010Z\u001a\u0004\u0018\u00010[2\u0006\u0010\\\u001a\u000204H\u0007J\u001e\u0010/\u001a\u00020\n*\u0002012\u0008\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010_\u001a\u000204H\u0007J<\u0010`\u001a\u00020\n*\u00020a2\u0008\u0010\u0011\u001a\u0004\u0018\u00010b2\u0006\u0010c\u001a\u00020d2\u000c\u0010F\u001a\u0008\u0012\u0004\u0012\u00020e0&2\u0006\u00103\u001a\u0002042\u0006\u0010f\u001a\u00020gH\u0007J&\u0010h\u001a\u00020\n*\u00020i2\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020j\u0018\u00010J2\u0008\u0010k\u001a\u0004\u0018\u00010lH\u0007J\u0016\u0010m\u001a\u00020\n*\u00020*2\u0008\u0010 \u001a\u0004\u0018\u00010nH\u0007J\u0016\u0010o\u001a\u00020\n*\u00020B2\u0008\u0010 \u001a\u0004\u0018\u00010nH\u0007J\u0016\u0010p\u001a\u00020\n*\u00020*2\u0008\u0010 \u001a\u0004\u0018\u00010eH\u0007J\u0016\u0010q\u001a\u00020\n*\u00020*2\u0008\u0010 \u001a\u0004\u0018\u00010eH\u0007J\u0016\u0010r\u001a\u00020\n*\u00020*2\u0008\u0010 \u001a\u0004\u0018\u00010eH\u0007J\u0016\u0010s\u001a\u00020\n*\u00020*2\u0008\u0010 \u001a\u0004\u0018\u00010eH\u0007J\u001c\u0010t\u001a\u00020\n*\u00020u2\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020j\u0018\u00010JH\u0007J \u0010v\u001a\u00020\n*\u00020i2\u0008\u0010I\u001a\u0004\u0018\u00010j2\u0008\u0010\u0011\u001a\u0004\u0018\u00010wH\u0007J\u001c\u0010v\u001a\u00020\n*\u00020i2\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020x\u0018\u00010&H\u0007J\u001b\u0010y\u001a\u00020\n*\u00020B2\u0008\u0010z\u001a\u0004\u0018\u00010,H\u0007¢\u0006\u0002\u0010{J\u001b\u0010|\u001a\u00020\n*\u00020B2\u0008\u0010}\u001a\u0004\u0018\u00010,H\u0007¢\u0006\u0002\u0010{J\u001e\u0010~\u001a\u00020\n*\u00020\u000c2\u0008\u0010 \u001a\u0004\u0018\u00010<2\u0006\u0010A\u001a\u00020BH\u0007J\u0015\u0010\u007f\u001a\u00020\n*\u00020B2\u0007\u0010\u0080\u0001\u001a\u00020\u0004H\u0007J\u0016\u0010\u0081\u0001\u001a\u00020\n*\u00020B2\u0007\u0010 \u001a\u00030\u0082\u0001H\u0007J.\u0010\u0083\u0001\u001a\u00020\n*\u00020i2\u0014\u0010I\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020x0&\u0018\u00010J2\t\u0010\u0011\u001a\u0005\u0018\u00010\u0084\u0001H\u0007J:\u0010\u0085\u0001\u001a\u00020\n*\u00020i2\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030\u0086\u0001\u0018\u00010J2\t\u0010\u0011\u001a\u0005\u0018\u00010\u0087\u00012\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010,H\u0007¢\u0006\u0003\u0010\u0089\u0001JN\u0010\u008a\u0001\u001a\u00020\n*\u00020i2\u0010\u0010\u008b\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u008c\u0001\u0018\u00010J2\t\u0010\u0011\u001a\u0005\u0018\u00010\u008d\u00012\u0007\u0010\u008e\u0001\u001a\u0002042\u0008\u0010\u008f\u0001\u001a\u00030\u0090\u00012\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010,H\u0007¢\u0006\u0003\u0010\u0091\u0001J8\u0010\u0092\u0001\u001a\u00020\n*\u00020i2\u0015\u0010I\u001a\u0011\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0082\u00010&\u0018\u00010J2\u0007\u0010\u0011\u001a\u00030\u0093\u00012\t\u0008\u0001\u0010\u0094\u0001\u001a\u00020\u0007H\u0007J\u001e\u0010\u0095\u0001\u001a\u00020\n*\u00020B2\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010JH\u0007J\u001e\u0010\u0097\u0001\u001a\u00020\n*\u00020B2\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010JH\u0007J\u001e\u0010\u0098\u0001\u001a\u00020\n*\u00020B2\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010JH\u0007J\u001e\u0010\u0099\u0001\u001a\u00020\n*\u00020i2\u0006\u0010 \u001a\u00020^2\u0007\u0010\u0011\u001a\u00030\u009a\u0001H\u0007J\u0018\u0010\u009b\u0001\u001a\u00020\n*\u00020B2\t\u0010 \u001a\u0005\u0018\u00010\u009c\u0001H\u0007J\u0018\u0010\u009d\u0001\u001a\u00020\n*\u00020B2\t\u0010 \u001a\u0005\u0018\u00010\u009c\u0001H\u0007J#\u0010\u009e\u0001\u001a\u00020\n*\u00020E2\u000c\u0010F\u001a\u0008\u0012\u0004\u0012\u00020\u000f0&2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0016\u0010\u009f\u0001\u001a\u00020\n*\u00020B2\u0007\u0010 \u0001\u001a\u00020\u0007H\u0007J\"\u0010¡\u0001\u001a\u00020\n*\u00030¢\u00012\t\u0010 \u001a\u0005\u0018\u00010£\u00012\u0007\u0010¤\u0001\u001a\u00020\u0007H\u0007J\u0015\u0010¥\u0001\u001a\u00020\n*\u00020B2\u0006\u0010C\u001a\u00020\u0007H\u0007J\u001d\u0010¦\u0001\u001a\u00020\n*\u00020i2\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&H\u0007J\u0017\u0010§\u0001\u001a\u00020\n*\u00020B2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0007J\u001e\u0010¨\u0001\u001a\u00020\n*\u00020E2\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010JH\u0007J;\u0010©\u0001\u001a\u00020\n*\u00020\u00152\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030\u008c\u0001\u0018\u00010J2\t\u0010ª\u0001\u001a\u0004\u0018\u00010,2\n\u0010«\u0001\u001a\u0005\u0018\u00010¬\u0001H\u0007¢\u0006\u0003\u0010­\u0001J'\u0010®\u0001\u001a\u00020\n*\u00020E2\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010J2\u0008\u0010\u0011\u001a\u0004\u0018\u00010\"H\u0007JS\u0010¯\u0001\u001a\u00020\n*\u00020\u00152\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010J2\u0007\u0010°\u0001\u001a\u00020*2\u0007\u0010±\u0001\u001a\u00020B2\u0007\u0010²\u0001\u001a\u00020B2\u0007\u0010³\u0001\u001a\u0002042\u0007\u0010´\u0001\u001a\u00020B2\u0007\u0010µ\u0001\u001a\u000204H\u0007J)\u0010¯\u0001\u001a\u00020\n*\u00020i2\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030¶\u0001\u0018\u00010&2\t\u0010\u0011\u001a\u0005\u0018\u00010·\u0001H\u0007J\u001e\u0010¸\u0001\u001a\u00020\n*\u00020B2\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010JH\u0007J\u001e\u0010¹\u0001\u001a\u00020\n*\u00020B2\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010JH\u0007J\u001e\u0010º\u0001\u001a\u00020\n*\u00020*2\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010JH\u0007J\u001e\u0010»\u0001\u001a\u00020\n*\u00020*2\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010JH\u0007J\u001e\u0010¼\u0001\u001a\u00020\n*\u00020B2\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010JH\u0007J\u001e\u0010½\u0001\u001a\u00020\n*\u00020i2\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010JH\u0007J\u0018\u0010¾\u0001\u001a\u00020\n*\u00020*2\t\u0010¿\u0001\u001a\u0004\u0018\u00010XH\u0007J)\u0010À\u0001\u001a\u00020\n*\u00020i2\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030\u009c\u0001\u0018\u00010&2\t\u0010\u0011\u001a\u0005\u0018\u00010Á\u0001H\u0007J(\u0010Â\u0001\u001a\u00020\n*\u00020i2\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030Ã\u0001\u0018\u00010&2\u0008\u0010\u0011\u001a\u0004\u0018\u00010\"H\u0007J)\u0010Ä\u0001\u001a\u00020\n*\u00020i2\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030£\u0001\u0018\u00010&2\t\u0010\u0011\u001a\u0005\u0018\u00010Å\u0001H\u0007J\u001b\u0010Æ\u0001\u001a\u00020\n*\u0002042\u000c\u0010F\u001a\u0008\u0012\u0004\u0012\u00020\u000f0&H\u0007J\u001d\u0010Ç\u0001\u001a\u00020\n*\u00020B2\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010JH\u0007J\u001e\u0010È\u0001\u001a\u00020\n*\u00020E2\u000f\u0010I\u001a\u000b\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010JH\u0007J\u001d\u0010È\u0001\u001a\u00020\n*\u00020E2\u000e\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&H\u0007J!\u0010É\u0001\u001a\u00020\n*\u00020*2\t\u0010 \u001a\u0005\u0018\u00010£\u00012\u0007\u0010Ê\u0001\u001a\u00020BH\u0007J-\u0010Ë\u0001\u001a\u00020\n*\u00020i2\u0015\u0010I\u001a\u0011\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030£\u00010&\u0018\u00010J2\u0007\u0010\u0011\u001a\u00030Ì\u0001H\u0007J9\u0010Í\u0001\u001a\u00020\n*\u00020\u00152\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010J2\u0007\u0010Î\u0001\u001a\u00020\u00152\u0008\u0010\u0011\u001a\u0004\u0018\u00010\"2\u0007\u0010Ï\u0001\u001a\u00020,H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006Ñ\u0001", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/ProgramBindingAdapters;", "", "()V", "PROGRAM_IMPULSE_CONTROL_ID", "", "VARIATION_DESCRIPTION_END_MARKER", "VARIATION_DESCRIPTION_MIN_LENGTH", "", "VARIATION_DESCRIPTION_START_MARKER", "addCompleteTaskView", "", "parent", "Landroid/view/ViewGroup;", "index", "task", "Lapp/dogo/com/dogo_android/repository/domain/ProgramTasks;", "addIncompleteTaskView", "callback", "Lapp/dogo/com/dogo_android/trainingprogram/tasklist/TaskListCallback;", "animateColorValue", "view", "Landroid/view/View;", "initial", "newColor", "cleanHtmlTagsAndFindHighlightIndex", "Lkotlin/Triple;", "baseString", "startIndex", "endIndex", "configureBinding", "binding", "Landroidx/databinding/ViewDataBinding;", "item", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem;", "Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramOverviewCallback;", "getBindings", "", "orderList", "", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$PottyOverviewCardEnum;", "programId", "loadCertificate", "Landroid/widget/ImageView;", "isProgramCompleted", "", "placeholderImage", "certificateImage", "setHtmlText", "webView", "Landroid/webkit/WebView;", "text", "button", "Landroid/widget/Button;", "setMarginsForDashboardCard", "layout", "Landroid/widget/LinearLayout$LayoutParams;", "context", "Landroid/content/Context;", "setProgressBar", "examItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "progressBar", "Landroid/widget/ProgressBar;", "setProgressText", "stringResource", "textView", "Landroid/widget/TextView;", "percentage", "inflateProgramOverviewBulletPoints", "Landroid/widget/LinearLayout;", "list", "inflateRecommendedProgramBulletPoints", "loadRealCertificate", "result", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/CertificateInfo;", "placeholder", "readMoreLabel", "clickArea", "removeHighlightSymbols", "setBackgroundColorFromHex", "hexCode", "setBitingProgramProgress", "sectionCompleted", "setCleanDaysText", "cleanDaysCount", "setExamsProgress", "setExamsProgresss", "Lapp/dogo/com/dogo_android/repository/domain/ModuleCompletionSummary;", "setExercisesCompletionText", "article", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "finishButton", "question", "Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion;", "gotItButton", "setIntroductionSlides", "Landroidx/viewpager2/widget/ViewPager2;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonintroduction/LessonIntroductionPagerAdapter$PagerCallback;", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "Lapp/dogo/com/dogo_android/repository/domain/LessonIntroduction;", "topLayout", "Lapp/dogo/com/dogo_android/databinding/CellProgramLessonIntroductionTopBinding;", "setLessonCardAdapter", "Landroidx/recyclerview/widget/RecyclerView;", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "callBacks", "Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter$Callbacks;", "setLessonCardImage", "Lapp/dogo/com/dogo_android/repository/domain/LessonCardItem;", "setLessonCardText", "setLessonExplanationCardClockVisibility", "setLessonExplanationCardElementVisibility", "setLessonExplanationCardImage", "setLessonExplanationCardImageVisibility", "setLessonToolbarText", "Lcom/google/android/material/appbar/MaterialToolbar;", "setLessonTrickCoverAdapter", "Lapp/dogo/com/dogo_android/dashboard/LessonCardCallback;", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "setLockIcon", "showLock", "(Landroid/widget/TextView;Ljava/lang/Boolean;)V", "setModuleProgressBarText", "isCurrent", "setProgramBubbleColor", "setProgramDesciption", "message", "setProgramDescriptionStateText", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "setProgramExamHistoryAdapter", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter$Callbacks;", "setProgramExamListAdapter", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamList;", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$Callbacks;", "shouldScrollToLastUnlocked", "(Landroidx/recyclerview/widget/RecyclerView;Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$Callbacks;Ljava/lang/Boolean;)V", "setProgramLessonPlanAdapter", "program", "Lapp/dogo/com/dogo_android/repository/domain/Program;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$Callbacks;", "upgradeButton", "nestedScrollView", "Landroidx/core/widget/NestedScrollView;", "(Landroidx/recyclerview/widget/RecyclerView;Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$Callbacks;Landroid/widget/Button;Landroidx/core/widget/NestedScrollView;Ljava/lang/Boolean;)V", "setProgramListTab", "Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListAdapter$Callbacks;", "headerViewRes", "setProgramOverViewExamCount", "Lapp/dogo/com/dogo_android/repository/domain/ProgramOverview;", "setProgramOverViewSkillCount", "setProgramOverviewSkillCount", "setProgramQuestionAdapter", "Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter$Callbacks;", "setProgramReminderPottyRepeatText", "Lapp/dogo/com/dogo_android/repository/domain/PottyRemindersItem;", "setProgramReminderPottyTimeText", "setProgramTasksAdapter", "setRecommendedProgramEnrolledUsers", "enrolledUsers", "setSegmentKnowledgeColor", "Lapp/dogo/com/dogo_android/util/customview/SegmentedProgressBar;", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "completionThreshold", "setTheoryCompletionText", "setTipsListTab", "setVariationTextHighlight", "setupDogSkillsOverview", "setupOverviewCard", "isCertificateEnabled", "cardBinding", "Lapp/dogo/com/dogo_android/databinding/LayoutProgramOverviewCertificateBinding;", "(Landroid/view/View;Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;Ljava/lang/Boolean;Lapp/dogo/com/dogo_android/databinding/LayoutProgramOverviewCertificateBinding;)V", "setupPottyOverview", "setupPottyProgramOverview", "programIcon", "programName", "enrollmentText", "enrollmentButton", "unEnrollmentText", "unEnrollmentButton", "Lapp/dogo/com/dogo_android/repository/domain/ArticleWithStatus;", "Lapp/dogo/com/dogo_android/specialprograms/potty/PottyArticleListAdapter$Callback;", "setupProgramOverviewAlreadyCompletedNumber", "setupProgramOverviewAverageCompletionTime", "setupProgramOverviewCertificatePreview", "setupProgramOverviewImage", "setupProgramOverviewName", "setupProgramOverviewTrickList", "setupProgramProgressArrow", "moduleProgressSummary", "setupReminderProgramOverview", "Lapp/dogo/com/dogo_android/specialprograms/potty/PottyReminderListAdapter$Callback;", "setupSpecialProgramExerciseOverview", "Lapp/dogo/com/dogo_android/repository/domain/TrickItemWithVariations;", "setupSpecialProgramVariationOverview", "Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramVariationAdapter$Callback;", "setupTaskCompletion", "setupToolbarName", "setupUserSkillsOverview", "setupVariationSymbolIcon", "symbolLabel", "setupVariationUnlockedList", "Lapp/dogo/com/dogo_android/specialprograms/biting/VariationsUnlockedListAdapter$Callback;", "setupZendeskClickArea", "notificationIcon", "isContactUsBadgeEnabled", "CertificateCrop", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class l {

    public static final app.dogo.com.dogo_android.y.l a;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class b {

        public static final int[] a;
        public static final int[] b;
        public static final int[] c;
        public static final int[] d;
        static {
            int[] iArr = new int[values.length];
            final int i = 1;
            iArr[SpecialProgramOverviewItem.PottyOverviewCardEnum.ARTICLE.ordinal()] = i;
            final int i2 = 2;
            iArr[SpecialProgramOverviewItem.PottyOverviewCardEnum.LOGS.ordinal()] = i2;
            final int i3 = 3;
            iArr[SpecialProgramOverviewItem.PottyOverviewCardEnum.REMINDER.ordinal()] = i3;
            final int i4 = 4;
            iArr[SpecialProgramOverviewItem.PottyOverviewCardEnum.PROGRESS.ordinal()] = i4;
            iArr[SpecialProgramOverviewItem.PottyOverviewCardEnum.CERTIFICATE.ordinal()] = 5;
            iArr[SpecialProgramOverviewItem.PottyOverviewCardEnum.EXERCISE.ordinal()] = 6;
            l.b.a = iArr;
            int[] iArr2 = new int[values2.length];
            iArr2[ProgramDescriptionItem.State.IN_PROGRESS.ordinal()] = i;
            iArr2[ProgramDescriptionItem.State.COMPLETED.ordinal()] = i2;
            iArr2[ProgramDescriptionItem.State.RECOMMENDED.ordinal()] = i3;
            iArr2[ProgramDescriptionItem.State.RECOMMENDED_BIG.ordinal()] = i4;
            l.b.b = iArr2;
            int[] iArr3 = new int[values3.length];
            iArr3[LessonIntroduction.CardType.TRAINING.ordinal()] = i;
            iArr3[LessonIntroduction.CardType.QUESTION.ordinal()] = i2;
            iArr3[LessonIntroduction.CardType.ACTIVITY.ordinal()] = i3;
            iArr3[LessonIntroduction.CardType.LESSON.ordinal()] = i4;
            l.b.c = iArr3;
            int[] iArr4 = new int[values4.length];
            iArr4[LessonCardItem.CardType.TRAINING.ordinal()] = i;
            iArr4[LessonCardItem.CardType.TASK.ordinal()] = i2;
            iArr4[LessonCardItem.CardType.QUESTION.ordinal()] = i3;
            iArr4[LessonCardItem.CardType.HEADER.ordinal()] = i4;
            l.b.d = iArr4;
        }
    }

    @Metadata(d1 = "\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0008", d2 = {"app/dogo/com/dogo_android/trainingprogram/ProgramBindingAdapters$setHtmlText$3", "Landroid/webkit/WebViewClient;", "shouldOverrideUrlLoading", "", "view", "Landroid/webkit/WebView;", "url", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String string2) {
            n.f(webView, "view");
            n.f(string2, "url");
            return 1;
        }
    }

    @Metadata(d1 = "\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0008", d2 = {"app/dogo/com/dogo_android/trainingprogram/ProgramBindingAdapters$setHtmlText$4", "Landroid/webkit/WebChromeClient;", "onProgressChanged", "", "view", "Landroid/webkit/WebView;", "newProgress", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class e extends WebChromeClient {

        final WebView a;
        final Button b;
        e(WebView webView, Button button2) {
            this.a = webView;
            this.b = button2;
            super();
        }

        public static void a(Button button) {
            l.e.b(button);
        }

        private static final void b(Button button) {
            n.f(button, "$button");
            button.setVisibility(0);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            app.dogo.com.dogo_android.y.g gVar;
            int i;
            int obj4;
            int obj5;
            super.onProgressChanged(webView, i2);
            if (this.a.getProgress() == 100) {
                gVar = new g(this.b);
                this.a.postDelayed(gVar, 100);
            }
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/com/dogo_android/trainingprogram/ProgramBindingAdapters$setIntroductionSlides$1", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageSelected", "", "position", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class f extends ViewPager2.i {

        final List<LessonIntroduction> a;
        final int b;
        final Button c;
        final ViewPager2 d;
        final e5 e;
        f(List<LessonIntroduction> list, int i2, Button button3, ViewPager2 viewPager24, e5 e55) {
            this.a = list;
            this.b = i2;
            this.c = button3;
            this.d = viewPager24;
            this.e = e55;
            super();
        }

        @Override // androidx.viewpager2.widget.ViewPager2$i
        public void onPageSelected(int i) {
            String string;
            int i2;
            Button obj5;
            super.onPageSelected(i);
            Object obj = this.a.get(i);
            if (i == this.b) {
                this.c.setText(this.d.getContext().getResources().getString(2131886686));
            } else {
                this.c.setText(this.d.getContext().getResources().getString(2131886689));
            }
            androidx.constraintlayout.widget.ConstraintLayout constraintLayout = e5Var.S;
            n.e(constraintLayout, "topLayout.cardView");
            Drawable background = e5Var2.S.getBackground();
            Objects.requireNonNull(background, "null cannot be cast to non-null type android.graphics.drawable.ColorDrawable");
            l.a(l.a, constraintLayout, (ColorDrawable)background.getColor(), Color.parseColor((LessonIntroduction)obj.getCardBackgroundColor().toString()));
            obj5 = obj5.Q;
            n.e(obj5, "topLayout.cardImage");
            l.O(obj5, obj);
            obj5 = obj5.T;
            n.e(obj5, "topLayout.checkmarkImage");
            l.N(obj5, obj);
            obj5 = obj5.O;
            n.e(obj5, "topLayout.arrow");
            l.N(obj5, obj);
            obj5 = obj5.V;
            n.e(obj5, "topLayout.imageForFirstCard");
            l.P(obj5, obj);
            obj5 = obj5.U;
            n.e(obj5, "topLayout.clockIcon");
            l.M(obj5, obj);
            obj5.R.setText(obj.getCardTitle());
            obj5.P.setText(obj.getCardDescription());
        }
    }

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0014J\u0010\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/ProgramBindingAdapters$CertificateCrop;", "Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;", "()V", "transform", "Landroid/graphics/Bitmap;", "pool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "toTransform", "outWidth", "", "outHeight", "updateDiskCacheKey", "", "messageDigest", "Ljava/security/MessageDigest;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends f {
        @Override // com.bumptech.glide.load.resource.bitmap.f
        public void a(MessageDigest messageDigest) {
            n.f(messageDigest, "messageDigest");
        }

        @Override // com.bumptech.glide.load.resource.bitmap.f
        protected Bitmap c(e e, Bitmap bitmap2, int i3, int i4) {
            n.f(e, "pool");
            n.f(bitmap2, "toTransform");
            final int obj4 = 30;
            Bitmap obj1 = Bitmap.createBitmap(bitmap2, obj4, obj4, obj1 += -60, obj3 += -60);
            n.e(obj1, "createBitmap(\n                toTransform,\n                30,\n                30,\n                toTransform.width - 60,\n                toTransform.height - 60\n            )");
            return obj1;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "Landroidx/databinding/ViewDataBinding;", "it", "Landroid/view/View;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements l<View, ViewDataBinding> {

        public static final app.dogo.com.dogo_android.y.l.c a;
        static {
            l.c cVar = new l.c();
            l.c.a = cVar;
        }

        c() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final ViewDataBinding a(View view) {
            n.f(view, "it");
            return f.d(view);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((View)object);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class g extends p implements a<w> {

        final t $callback;
        final ProgramLessonItem $result;
        g(t t, ProgramLessonItem programLessonItem2) {
            this.$callback = t;
            this.$result = programLessonItem2;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            this.$callback.T(this.$result);
        }
    }
    static {
        l lVar = new l();
        l.a = lVar;
    }

    public static final void A(ProgressBar progressBar, ModuleCompletionSummary moduleCompletionSummary2) {
        int passedLessonCount;
        int lessonCount;
        n.f(progressBar, "<this>");
        if (moduleCompletionSummary2 == null) {
            lessonCount = passedLessonCount;
        } else {
            lessonCount = moduleCompletionSummary2.getLessonCount();
        }
        progressBar.setMax(lessonCount);
        if (moduleCompletionSummary2 == null) {
        } else {
            passedLessonCount = moduleCompletionSummary2.getPassedLessonCount();
        }
        progressBar.setProgress(passedLessonCount, true);
    }

    public static final void A0(TextView textView, y<ProgramOverview> y2) {
        int obj2;
        n.f(textView, "<this>");
        if (y2 instanceof y.c) {
        } else {
            obj2 = 0;
        }
        if (obj2 == null) {
        } else {
            obj2 = obj2.a();
            if ((ProgramOverview)obj2 == null) {
            } else {
                textView.setText((ProgramOverview)obj2.getProgramName());
            }
        }
    }

    public static final void B(TextView textView, int i2) {
        n.f(textView, "<this>");
        l.a.l0(2131886590, textView, i2);
    }

    public static final void B0(RecyclerView recyclerView, y<ProgramOverview> y2) {
        androidx.recyclerview.widget.RecyclerView.h dVar;
        boolean nVar;
        int i;
        boolean z;
        Object obj4;
        n.f(recyclerView, "<this>");
        if (y2 instanceof y.c) {
        } else {
            obj4 = i;
        }
        if (obj4 == null) {
        } else {
            obj4 = obj4.a();
            if ((ProgramOverview)obj4 == null) {
            } else {
                if (recyclerView.getAdapter() == null) {
                    dVar = new d();
                    recyclerView.setAdapter(dVar);
                }
                nVar = recyclerView.getAdapter();
                if (nVar instanceof d) {
                    i = nVar;
                }
                if (i == 0) {
                } else {
                    i.i((ProgramOverview)obj4.getSkillList());
                }
                if (recyclerView.getItemDecorationCount() == 0) {
                    nVar = new n(recyclerView.getResources().getDimensionPixelSize(2131165638));
                    recyclerView.h(nVar);
                }
            }
        }
    }

    public static final void C(WebView webView, Article article2, Button button3) {
        int i;
        String textHtml;
        String textHtml2;
        String str;
        String str2;
        int i2;
        int i4;
        int i3;
        n.f(webView, "<this>");
        n.f(button3, "finishButton");
        i = 1;
        int i5 = 0;
        if (article2 == null) {
            i = i5;
        } else {
        }
        textHtml = 0;
        if (i != 0) {
            textHtml = article2.getTextHtml();
        } else {
            if (article2 == null) {
            } else {
                textHtml2 = article2.getText();
                if (textHtml2 == null) {
                } else {
                    textHtml = l.G(textHtml2, "\n", "<br/>", false, 4, 0);
                }
            }
        }
        if (textHtml == null) {
            textHtml = "";
        }
        l.a.E(webView, textHtml, button3);
    }

    public static final void C0(ImageView imageView, ModuleCompletionSummary moduleCompletionSummary2) {
        int obj2;
        n.f(imageView, "<this>");
        obj2 = moduleCompletionSummary2 == null ? 8 : obj2 != null ? 0 : 4;
        imageView.setVisibility(obj2);
    }

    public static final void D(WebView webView, ProgramQuestion programQuestion2, Button button3) {
        int i3;
        String explanationHtml;
        String explanationHtml2;
        String str2;
        String str;
        int i;
        int i2;
        int i4;
        n.f(webView, "<this>");
        n.f(button3, "gotItButton");
        i3 = 1;
        int i5 = 0;
        if (programQuestion2 == null) {
            i3 = i5;
        } else {
        }
        explanationHtml = 0;
        if (i3 != 0) {
            explanationHtml = programQuestion2.getExplanationHtml();
        } else {
            if (programQuestion2 == null) {
            } else {
                explanationHtml2 = programQuestion2.getExplanation();
                if (explanationHtml2 == null) {
                } else {
                    explanationHtml = l.G(explanationHtml2, "\n", "<br/>", false, 4, 0);
                }
            }
        }
        if (explanationHtml == null) {
            explanationHtml = "";
        }
        l.a.E(webView, explanationHtml, button3);
    }

    public static final void D0(RecyclerView recyclerView, List<PottyRemindersItem> list2, o.a o$a3) {
        androidx.recyclerview.widget.RecyclerView.h oVar;
        String str;
        List obj2;
        int obj3;
        n.f(recyclerView, "<this>");
        if (list2 != null && a3 != null && recyclerView.getAdapter() == null) {
            if (a3 != null) {
                if (recyclerView.getAdapter() == null) {
                    oVar = new o(a3);
                    recyclerView.setAdapter(oVar);
                }
                if (obj3 instanceof o) {
                } else {
                    obj3 = 0;
                }
                if (obj3 == null) {
                } else {
                    obj3.j(list2);
                }
                if (recyclerView.getItemDecorationCount() == 0) {
                    obj3 = new y(recyclerView.getResources().getDimensionPixelSize(2131165638));
                    recyclerView.h(obj3);
                }
            }
        }
    }

    public static final void E0(RecyclerView recyclerView, List<TrickItemWithVariations> list2, j j3) {
        androidx.recyclerview.widget.RecyclerView.h iVar;
        String str;
        List obj2;
        int obj3;
        n.f(recyclerView, "<this>");
        if (list2 != null && j3 != null && recyclerView.getAdapter() == null) {
            if (j3 != null) {
                if (recyclerView.getAdapter() == null) {
                    iVar = new i(j3);
                    recyclerView.setAdapter(iVar);
                }
                if (obj3 instanceof i) {
                } else {
                    obj3 = 0;
                }
                if (obj3 == null) {
                } else {
                    obj3.j(list2);
                }
                if (recyclerView.getItemDecorationCount() == 0) {
                    obj3 = new y(recyclerView.getResources().getDimensionPixelSize(2131165620));
                    recyclerView.h(obj3);
                }
            }
        }
    }

    private static final boolean F(View view, MotionEvent motionEvent2) {
        int obj0;
        obj0 = motionEvent2.getAction() == 2 ? 1 : 0;
        return obj0;
    }

    public static final void F0(RecyclerView recyclerView, List<TrickItem> list2, l.a l$a3) {
        androidx.recyclerview.widget.RecyclerView.h lVar;
        String str;
        List obj2;
        int obj3;
        n.f(recyclerView, "<this>");
        if (list2 != null && a3 != null && recyclerView.getAdapter() == null) {
            if (a3 != null) {
                if (recyclerView.getAdapter() == null) {
                    lVar = new l(a3);
                    recyclerView.setAdapter(lVar);
                }
                if (obj3 instanceof l) {
                } else {
                    obj3 = 0;
                }
                if (obj3 == null) {
                } else {
                    obj3.j(list2);
                }
                if (recyclerView.getItemDecorationCount() == 0) {
                    obj3 = recyclerView.getContext();
                    n.e(obj3, "context");
                    obj2 = new w(obj3);
                    recyclerView.h(obj2);
                }
            }
        }
    }

    private static final boolean G(View view) {
        return 1;
    }

    public static final void G0(Button button, List<ProgramTasks> list2) {
        int size;
        Object next;
        Resources resources;
        int i2;
        int i;
        int type;
        Object[] cOMPLETED;
        Object obj8;
        n.f(button, "<this>");
        n.f(list2, "list");
        size = list2.size();
        ArrayList arrayList = new ArrayList();
        obj8 = list2.iterator();
        i2 = 1;
        i = 0;
        while (obj8.hasNext()) {
            next = obj8.next();
            if ((ProgramTasks)next.getType() == ProgramTasks.Type.COMPLETED) {
            } else {
            }
            i2 = i;
            if (i2 != 0) {
            }
            i2 = 1;
            i = 0;
            arrayList.add(next);
        }
        obj8 = arrayList.size();
        int i4 = 0;
        if (size == obj8) {
            button.setEnabled(i2);
            button.setText(button.getResources().getString(2131886403));
            button.setIcon(f.f((MaterialButton)button.getResources(), 2131230878, i4));
        } else {
            button.setEnabled(i);
            cOMPLETED = new Object[2];
            cOMPLETED[i] = Integer.valueOf(obj8);
            cOMPLETED[i2] = Integer.valueOf(size);
            button.setText(button.getResources().getString(2131886402, cOMPLETED));
            (MaterialButton)button.setIcon(i4);
        }
    }

    public static final void H(ViewPager2 viewPager2, d.a d$a2, TabLayout tabLayout3, List<LessonIntroduction> list4, Button button5, e5 e56) {
        Object str;
        app.dogo.com.dogo_android.y.l.f fVar;
        Object obj3;
        int i;
        Object obj2;
        Object obj4;
        Object obj;
        Object obj8;
        n.f(viewPager2, "<this>");
        n.f(tabLayout3, "tabLayout");
        n.f(list4, "list");
        n.f(button5, "button");
        n.f(e56, "topLayout");
        if (a2 != null) {
            d dVar = new d(list4, a2);
            viewPager2.setAdapter(dVar);
            obj8 = new d(tabLayout3, viewPager2, b.a);
            obj8.a();
            super(list4, 3, button5, viewPager2, e56);
            viewPager2.h(obj8);
        }
    }

    public static final void H0(TextView textView, y<SpecialProgramOverviewItem> y2) {
        Object obj2;
        n.f(textView, "<this>");
        if (y2 instanceof y.c) {
        } else {
            obj2 = 0;
        }
        if (obj2 == null) {
        } else {
            textView.setText((SpecialProgramOverviewItem)obj2.a().getProgramData().getProgramTitle());
        }
    }

    private static final void I(TabLayout.g tabLayout$g, int i2) {
        n.f(g, "$noName_0");
    }

    public static final void I0(LinearLayout linearLayout, y<ProgramOverview> y2) {
        app.dogo.com.dogo_android.y.l lVar;
        int obj2;
        n.f(linearLayout, "<this>");
        if (y2 instanceof y.c) {
        } else {
            obj2 = 0;
        }
        if (obj2 == null) {
        } else {
            obj2 = obj2.a();
            if ((ProgramOverview)obj2 == null) {
            } else {
                l.a.j(linearLayout, (ProgramOverview)obj2.getUserSkillOverview());
            }
        }
    }

    public static final void J(RecyclerView recyclerView, y<ProgramLessonItem> y2, i.a i$a3) {
        i iVar;
        int obj2;
        n.f(recyclerView, "<this>");
        if (y2 instanceof y.c) {
        } else {
            obj2 = 0;
        }
        if (obj2 == null) {
        } else {
            obj2 = obj2.a();
            if ((ProgramLessonItem)obj2 == null) {
            } else {
                iVar = new i((ProgramLessonItem)obj2, a3);
                recyclerView.setAdapter(iVar);
            }
        }
    }

    public static final void J0(LinearLayout linearLayout, List<String> list2) {
        Object str;
        n.f(linearLayout, "<this>");
        if (list2 != null) {
            l.a.k(linearLayout, list2);
        }
    }

    public static final void K(ImageView imageView, LessonCardItem lessonCardItem2) {
        LessonCardItem.CardType type;
        int i;
        int[] iArr;
        Object obj4;
        n.f(imageView, "<this>");
        int i2 = 0;
        if (lessonCardItem2 == null) {
            type = i2;
        } else {
            type = lessonCardItem2.getType();
        }
        if (type == null) {
            i = -1;
        } else {
            i = l.b.d[type.ordinal()];
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    imageView.setImageDrawable(f.f(imageView.getResources(), 2131231300, i2));
                } else {
                    imageView.setImageDrawable(f.f(imageView.getResources(), 2131231276, i2));
                }
            } else {
                imageView.setImageDrawable(f.f(imageView.getResources(), 2131230825, i2));
            }
        } else {
            m.o(imageView, lessonCardItem2.getImageUrl());
        }
    }

    public static final void K0(ImageView imageView, TrickItem trickItem2, TextView textView3) {
        int str;
        int i2;
        int i;
        int i3;
        int obj5;
        n.f(imageView, "<this>");
        n.f(textView3, "symbolLabel");
        if (trickItem2 != null) {
            str = trickItem2.getKnowledge() >= 4 ? R.drawable.ic_green_check : R.drawable.arrow_right_green;
            obj5 = trickItem2.getKnowledge();
            i = 0;
            if (1 <= obj5 && obj5 <= 3) {
                if (obj5 <= 3) {
                } else {
                    i2 = i;
                }
            } else {
            }
            if (i2 != 0) {
                textView3.setVisibility(i);
            } else {
                textView3.setVisibility(8);
            }
            n.M(imageView, Integer.valueOf(str));
        }
    }

    public static final void L(TextView textView, LessonCardItem lessonCardItem2) {
        int type;
        int context;
        int[] iArr;
        int arr;
        int i2;
        int i;
        String obj5;
        n.f(textView, "<this>");
        if (lessonCardItem2 == null) {
            type = 0;
        } else {
            type = lessonCardItem2.getType();
        }
        if (type == null) {
            context = -1;
        } else {
            context = l.b.d[type.ordinal()];
        }
        arr = 1;
        if (context != arr) {
            if (context != 2) {
                if (context != 3) {
                    if (context != 4) {
                        obj5 = "";
                    } else {
                        arr = new Object[arr];
                        arr[0] = Integer.valueOf(lessonCardItem2.getLessonNumber());
                        obj5 = textView.getContext().getString(2131887591, arr);
                    }
                } else {
                    obj5 = textView.getContext().getString(2131886438);
                }
            } else {
                obj5 = textView.getContext().getString(2131887575);
            }
        } else {
            obj5 = textView.getContext().getString(2131887609);
        }
        textView.setText(obj5);
    }

    public static final void L0(RecyclerView recyclerView, y<? extends List<TrickItem>> y2, v.a v$a3) {
        boolean vVar;
        Object obj1;
        Object obj2;
        Object obj3;
        n.f(recyclerView, "<this>");
        n.f(a3, "callback");
        if (y2 instanceof y.c && recyclerView.getAdapter() == null) {
            if (recyclerView.getAdapter() == null) {
                vVar = new v(a3);
                recyclerView.setAdapter(vVar);
            }
            if (obj1 instanceof v) {
            } else {
                obj1 = 0;
            }
            if (obj1 == null) {
            } else {
                obj1.j((List)(y.c)y2.a());
            }
        }
    }

    public static final void M(ImageView imageView, LessonIntroduction lessonIntroduction2) {
        int[] str;
        LessonIntroduction.CardType obj2;
        n.f(imageView, "<this>");
        if (lessonIntroduction2 == null) {
            obj2 = 0;
        } else {
            obj2 = lessonIntroduction2.getType();
        }
        if (obj2 == null) {
            obj2 = -1;
        } else {
            obj2 = l.b.c[obj2.ordinal()];
        }
        if (obj2 == 1) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    public static final void M0(View view, y<SpecialProgramOverviewItem> y2, View view3, j j4, boolean z5) {
        boolean z;
        Object obj2;
        Object obj3;
        int obj5;
        n.f(view, "<this>");
        n.f(view3, "notificationIcon");
        if (y2 instanceof y.c) {
        } else {
            obj2 = 0;
        }
        if (obj2 == null) {
        } else {
            if (z5 == 0) {
                if ((SpecialProgramOverviewItem)obj2.a().getUnreadZendeskMessages() > 0) {
                    obj5 = 1;
                } else {
                    obj5 = z;
                }
            } else {
            }
            if (obj5 != null) {
            } else {
                z = 8;
            }
            view3.setVisibility(z);
            obj3 = new e(j4, obj2);
            view.setOnClickListener(obj3);
        }
    }

    public static final void N(ImageView imageView, LessonIntroduction lessonIntroduction2) {
        int[] str;
        int i;
        LessonIntroduction.CardType obj2;
        n.f(imageView, "<this>");
        if (lessonIntroduction2 == null) {
            obj2 = 0;
        } else {
            obj2 = lessonIntroduction2.getType();
        }
        if (obj2 == null) {
            obj2 = -1;
        } else {
            obj2 = l.b.c[obj2.ordinal()];
        }
        if (obj2 == 4) {
        } else {
            i = 0;
        }
        imageView.setVisibility(i);
    }

    private static final void N0(j j, y.c y$c2, View view3) {
        Object obj1;
        n.f(c2, "$success");
        if (j == null) {
        } else {
            j.w((SpecialProgramOverviewItem)c2.a().isUserPremium());
        }
    }

    public static final void O(ImageView imageView, LessonIntroduction lessonIntroduction2) {
        int[] iArr;
        int i;
        LessonIntroduction.CardType obj3;
        n.f(imageView, "<this>");
        int i2 = 0;
        if (lessonIntroduction2 == null) {
            obj3 = i2;
        } else {
            obj3 = lessonIntroduction2.getType();
        }
        if (obj3 == null) {
            obj3 = -1;
        } else {
            obj3 = l.b.c[obj3.ordinal()];
        }
        if (obj3 != 1) {
            if (obj3 != 2) {
                if (obj3 != 3) {
                    imageView.setImageDrawable(i2);
                } else {
                    imageView.setImageDrawable(f.f(imageView.getResources(), 2131230825, i2));
                }
            } else {
                imageView.setImageDrawable(f.f(imageView.getResources(), 2131231276, i2));
            }
        } else {
            imageView.setImageDrawable(f.f(imageView.getResources(), 2131231320, i2));
        }
    }

    public static final void P(ImageView imageView, LessonIntroduction lessonIntroduction2) {
        int[] str;
        LessonIntroduction.CardType obj2;
        n.f(imageView, "<this>");
        if (lessonIntroduction2 == null) {
            obj2 = 0;
        } else {
            obj2 = lessonIntroduction2.getType();
        }
        if (obj2 == null) {
            obj2 = -1;
        } else {
            obj2 = l.b.c[obj2.ordinal()];
        }
        int i = 4;
        if (obj2 == i) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(i);
        }
    }

    public static final void Q(MaterialToolbar materialToolbar, y<ProgramLessonItem> y2) {
        Context context;
        int i;
        Object[] arr;
        int i2;
        int obj5;
        n.f(materialToolbar, "<this>");
        if (y2 instanceof y.c) {
        } else {
            obj5 = 0;
        }
        if (obj5 == null) {
        } else {
            obj5 = obj5.a();
            if ((ProgramLessonItem)obj5 == null) {
            } else {
                arr = new Object[1];
                materialToolbar.setTitle(materialToolbar.getContext().getString(2131887591, Integer.valueOf((ProgramLessonItem)obj5.getCurrentLessonPositionData().getLessonNumber())));
            }
        }
    }

    public static final void R(RecyclerView recyclerView, ProgramLessonItem programLessonItem2, t t3) {
        Object str;
        Object flexboxLayoutManager;
        int itemDecorationCount;
        u uVar;
        int i;
        app.dogo.com.dogo_android.y.l.g gVar;
        int i2;
        n.f(recyclerView, "<this>");
        if (programLessonItem2 != null && t3 != null && recyclerView.getLayoutManager() == null) {
            if (t3 != null) {
                if (recyclerView.getLayoutManager() == null) {
                    flexboxLayoutManager = new FlexboxLayoutManager(recyclerView.getContext(), 0);
                    flexboxLayoutManager.g3(2);
                    recyclerView.setLayoutManager(flexboxLayoutManager);
                }
                if (recyclerView.getItemDecorationCount() == 0) {
                    itemDecorationCount = new o((int)dimension);
                    recyclerView.h(itemDecorationCount);
                }
                str = j1.z(programLessonItem2);
                if (str.isEmpty()) {
                    i = 8;
                }
                recyclerView.setVisibility(i);
                gVar = new l.g(t3, programLessonItem2);
                uVar = new u(str, gVar);
                recyclerView.setAdapter(uVar);
            }
        }
    }

    public static final void S(RecyclerView recyclerView, List<ProgramExam> list2) {
        Object flexboxLayoutManager;
        int itemDecorationCount;
        Object kVar;
        Context context;
        int i;
        n.f(recyclerView, "<this>");
        if (list2 != null && recyclerView.getLayoutManager() == null) {
            if (recyclerView.getLayoutManager() == null) {
                i = 0;
                flexboxLayoutManager = new FlexboxLayoutManager(recyclerView.getContext(), i);
                flexboxLayoutManager.g3(i);
                recyclerView.setLayoutManager(flexboxLayoutManager);
            }
            if (recyclerView.getItemDecorationCount() == 0) {
                itemDecorationCount = new o((int)dimension);
                recyclerView.h(itemDecorationCount);
            }
            kVar = new k(list2);
            recyclerView.setAdapter(kVar);
        }
    }

    public static final void T(TextView textView, Boolean boolean2) {
        int i2;
        int i;
        int intrinsicWidth;
        Object spannableString;
        int intrinsicHeight;
        String str;
        Object obj6;
        n.f(textView, "<this>");
        i2 = 2131886586;
        if (n.b(boolean2, Boolean.TRUE)) {
            obj6 = textView.getResources().getString(i2);
            n.e(obj6, "resources.getString(R.string.exercise_variations_header)");
            Drawable drawable = a.f(textView.getContext(), 2131231191);
            i = 0;
            if (drawable == null) {
            } else {
                drawable.setBounds(i, i, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("lock");
            stringBuilder.append("  ");
            stringBuilder.append(obj6);
            spannableString = new SpannableString(stringBuilder.toString());
            n.d(drawable);
            obj6 = new ImageSpan(drawable, 1);
            spannableString.setSpan(obj6, i, 4, 17);
        } else {
            spannableString = textView.getResources().getString(i2);
        }
        textView.setText(spannableString);
    }

    private final void U(LinearLayout.LayoutParams linearLayout$LayoutParams, Context context2) {
        final int i3 = 2131165626;
        layoutParams.setMarginStart((int)dimension);
        layoutParams.setMarginEnd((int)dimension2);
        layoutParams.bottomMargin = (int)obj4;
    }

    public static final void V(TextView textView, Boolean boolean2) {
        int i;
        int obj3;
        n.f(textView, "<this>");
        int i2 = 0;
        int i3 = 0;
        if (n.b(boolean2, Boolean.TRUE)) {
            textView.setTypeface(Typeface.create("sans-serif-medium", i3));
            textView.setTextColor(textView.getResources().getColor(2131099767, i2));
        } else {
            textView.setTypeface(Typeface.create("sans-serif", i3));
            textView.setTextColor(textView.getResources().getColor(2131099834, i2));
        }
    }

    public static final void W(ViewGroup viewGroup, ProgramExamSummary programExamSummary2, TextView textView3) {
        String str;
        Object obj1;
        int obj2;
        n.f(viewGroup, "<this>");
        n.f(textView3, "textView");
        if (programExamSummary2 == 0) {
        } else {
            str = 0;
            if (n.b(programExamSummary2.getProgramSaveInfo().getProgramId(), "id_impulse_control")) {
                viewGroup.setBackgroundResource(2131231182);
                textView3.setTextColor(viewGroup.getResources().getColor(2131099723, str));
            } else {
                viewGroup.setBackgroundResource(2131231181);
                textView3.setTextColor(viewGroup.getResources().getColor(2131100379, str));
            }
        }
    }

    public static final void X(TextView textView, String string2) {
        n.f(textView, "<this>");
        n.f(string2, "message");
        textView.setText(string2);
        textView.setPaintFlags(obj2 |= 16);
    }

    public static final void Y(TextView textView, ProgramDescriptionItem programDescriptionItem2) {
        int i;
        String obj2;
        n.f(textView, "<this>");
        n.f(programDescriptionItem2, "item");
        obj2 = l.b.b[programDescriptionItem2.getProgramState().ordinal()];
        if (obj2 != 1) {
            if (obj2 != 2) {
                if (obj2 != 3 && obj2 != 4) {
                    if (obj2 != 4) {
                        obj2 = "";
                    } else {
                        obj2 = textView.getContext().getString(2131887431);
                    }
                } else {
                }
            } else {
                obj2 = textView.getContext().getString(2131886403);
            }
        } else {
            obj2 = textView.getContext().getString(2131887110);
        }
        textView.setText(obj2);
    }

    public static final void Z(RecyclerView recyclerView, y<? extends List<ProgramExam>> y2, q.a q$a3) {
        boolean z;
        int i;
        Object qVar;
        Object obj4;
        Object obj5;
        n.f(recyclerView, "<this>");
        if (y2 instanceof y.c) {
        } else {
            obj4 = i;
        }
        if (obj4 == null) {
        } else {
            obj4 = obj4.a();
            if ((List)obj4 == null) {
            } else {
                androidx.recyclerview.widget.RecyclerView.p layoutManager = recyclerView.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager != null) {
                    i = layoutManager;
                }
                z = 0;
                if (i == 0) {
                    i = z;
                } else {
                    i = i.r2();
                }
                qVar = new q(a3);
                qVar.j((List)obj4);
                obj4 = w.a;
                recyclerView.setAdapter(qVar);
                if (recyclerView.getItemDecorationCount() == 0) {
                    obj5 = recyclerView.getContext();
                    n.e(obj5, "context");
                    obj4 = new m(obj5, z);
                    recyclerView.h(obj4);
                }
                recyclerView.q1(i);
            }
        }
    }

    public static final void a(app.dogo.com.dogo_android.y.l l, View view2, int i3, int i4) {
        l.e(view2, i3, i4);
    }

    public static final void a0(RecyclerView recyclerView, y<ProgramExamList> y2, u.b u$b3, Boolean boolean4) {
        int pREMIUM_LOCKED;
        int i;
        boolean z;
        Object programExamSummary;
        u uVar;
        Object obj5;
        Object obj7;
        n.f(recyclerView, "<this>");
        if (y2 instanceof y.c) {
            pREMIUM_LOCKED = y2;
        } else {
            pREMIUM_LOCKED = i;
        }
        if (pREMIUM_LOCKED == 0) {
        } else {
            pREMIUM_LOCKED = pREMIUM_LOCKED.a();
            if ((ProgramExamList)pREMIUM_LOCKED == null) {
            } else {
                if (recyclerView.getAdapter() == null) {
                    uVar = new u(b3, (ProgramExamList)pREMIUM_LOCKED.getProgramExamSummary(), (ProgramExamList)(y.c)y2.a().isDogPremium());
                    recyclerView.setAdapter(uVar);
                }
                obj5 = recyclerView.getAdapter();
                if (obj5 instanceof u) {
                    i = obj5;
                }
                if (i == 0) {
                } else {
                    i.l(pREMIUM_LOCKED.getExamList());
                }
                if (n.b(boolean4, Boolean.TRUE)) {
                    obj5 = pREMIUM_LOCKED.getExamList();
                    obj5 = obj5.listIterator(obj5.size());
                    while (obj5.hasPrevious()) {
                        obj7 = obj5.previous();
                        if ((ProgramExam)obj7.getUnlockDate() != null && obj7.getStatus() != ProgramExam.Status.PREMIUM_LOCKED) {
                        } else {
                        }
                        obj7 = 0;
                        if (obj7.getStatus() != ProgramExam.Status.PREMIUM_LOCKED) {
                        } else {
                        }
                        obj7 = 1;
                    }
                    obj5 = -1;
                    recyclerView.q1(obj5);
                }
                if (b3 == null) {
                } else {
                    b3.h();
                }
            }
        }
    }

    private static final void b(ViewGroup viewGroup, int i2, ProgramTasks programTasks3) {
        e6 e6Var = e6.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(e6Var, "inflate(LayoutInflater.from(parent.context), parent, false)");
        e6Var.V(programTasks3);
        viewGroup.addView(e6Var.w(), i2);
    }

    public static final void b0(RecyclerView recyclerView, y<Program> y2, l.b l$b3, Button button4, NestedScrollView nestedScrollView5, Boolean boolean6) {
        Object tRUE;
        int i2;
        int i;
        w next;
        ProgramLesson.Type aCTIVE;
        Object obj5;
        androidx.recyclerview.widget.RecyclerView.h obj7;
        Object obj9;
        Object obj10;
        n.f(recyclerView, "<this>");
        n.f(button4, "upgradeButton");
        n.f(nestedScrollView5, "nestedScrollView");
        if (y2 instanceof y.c) {
            i2 = 0;
            if (recyclerView.getAdapter() == null) {
                l lVar = new l(b3);
                Object obj2 = y2;
                lVar.j((Program)(y.c)obj2.a().getLessons());
                next = w.a;
                recyclerView.setAdapter(lVar);
                tRUE = (Program)obj2.a().getLessons().iterator();
                i = i2;
                while (tRUE.hasNext()) {
                    if ((ProgramLesson)tRUE.next().getType() == ProgramLesson.Type.ACTIVE) {
                    } else {
                    }
                    next = i2;
                    i++;
                    next = 1;
                }
                i = -1;
                if (i >= 0 && n.b(boolean6, Boolean.TRUE)) {
                    if (n.b(boolean6, Boolean.TRUE)) {
                        j1.y0(recyclerView, nestedScrollView5, i, 2000);
                    }
                }
                if (b3 == null) {
                } else {
                    b3.h();
                }
            } else {
                if (obj7 instanceof l) {
                } else {
                    obj7 = 0;
                }
                if (obj7 == null) {
                } else {
                    obj7.j((Program)(y.c)y2.a().getLessons());
                }
            }
            if (recyclerView.getItemDecorationCount() == 0) {
                obj9 = recyclerView.getContext();
                n.e(obj9, "context");
                obj7 = new p(obj9);
                recyclerView.h(obj7);
            }
            if ((Program)(y.c)y2.a().isPremiumLocked()) {
            } else {
                i2 = 8;
            }
            button4.setVisibility(i2);
        }
    }

    private static final void c(ViewGroup viewGroup, int i2, ProgramTasks programTasks3, g g4) {
        g6 g6Var = g6.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(g6Var, "inflate(LayoutInflater.from(parent.context), parent, false)");
        g6Var.V(programTasks3);
        a aVar = new a(programTasks3, viewGroup, i2, g4);
        g6Var.w().setOnClickListener(aVar);
        viewGroup.addView(g6Var.w(), i2);
    }

    public static final void c0(RecyclerView recyclerView, y<? extends List<ProgramDescriptionItem>> y2, e.a e$a3, int i4) {
        Object obj0;
        Object obj1;
        Object obj2;
        boolean obj3;
        n.f(recyclerView, "<this>");
        n.f(a3, "callback");
        if (y2 instanceof y.c && recyclerView.getAdapter() == null) {
            if (recyclerView.getAdapter() == null) {
                obj3 = new e(a3);
                recyclerView.setAdapter(obj3);
            }
            if (obj0 instanceof e) {
            } else {
                obj0 = 0;
            }
            if (obj0 == null) {
            } else {
                obj0.j((List)(y.c)y2.a());
            }
        }
    }

    private static final void d(ProgramTasks programTasks, ViewGroup viewGroup2, int i3, g g4, View view5) {
        n.f(programTasks, "$task");
        n.f(viewGroup2, "$parent");
        n.f(g4, "$callback");
        programTasks.setType(ProgramTasks.Type.COMPLETED);
        viewGroup2.removeViewAt(i3);
        l.b(viewGroup2, i3, programTasks);
        g4.y(programTasks);
    }

    public static final void d0(TextView textView, y<ProgramOverview> y2) {
        Resources resources;
        int i;
        Object[] arr;
        int i2;
        int obj5;
        n.f(textView, "<this>");
        if (y2 instanceof y.c) {
        } else {
            obj5 = 0;
        }
        if (obj5 == null) {
        } else {
            obj5 = obj5.a();
            if ((ProgramOverview)obj5 == null) {
            } else {
                arr = new Object[1];
                textView.setText(textView.getResources().getString(2131886974, Integer.valueOf((ProgramOverview)obj5.getExamCount())));
            }
        }
    }

    private final void e(View view, int i2, int i3) {
        ArgbEvaluator argbEvaluator = new ArgbEvaluator();
        Object[] arr = new Object[2];
        ValueAnimator obj5 = ValueAnimator.ofObject(argbEvaluator, Integer.valueOf(i2), Integer.valueOf(i3));
        obj5.setDuration(350);
        h obj6 = new h(view);
        obj5.addUpdateListener(obj6);
        obj5.start();
    }

    public static final void e0(TextView textView, y<ProgramOverview> y2) {
        int obj2;
        n.f(textView, "<this>");
        if (y2 instanceof y.c) {
        } else {
            obj2 = 0;
        }
        if (obj2 == null) {
        } else {
            obj2 = obj2.a();
            if ((ProgramOverview)obj2 == null) {
            } else {
                l.m0(textView, (ProgramOverview)obj2.getEnrolledUsersCount());
            }
        }
    }

    private static final void f(View view, ValueAnimator valueAnimator2) {
        n.f(view, "$view");
        Object obj2 = valueAnimator2.getAnimatedValue();
        Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Int");
        view.setBackgroundColor((Integer)obj2.intValue());
    }

    public static final void f0(TextView textView, y<ProgramOverview> y2) {
        Resources resources;
        int i2;
        Object[] arr;
        int i;
        int obj5;
        n.f(textView, "<this>");
        if (y2 instanceof y.c) {
        } else {
            obj5 = 0;
        }
        if (obj5 == null) {
        } else {
            obj5 = obj5.a();
            if ((ProgramOverview)obj5 == null) {
            } else {
                arr = new Object[1];
                textView.setText(textView.getResources().getString(2131887593, Integer.valueOf((ProgramOverview)obj5.getSkillList().size())));
            }
        }
    }

    private final t<String, Integer, Integer> g(String string, int i2, int i3) {
        Object obj = string;
        Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
        String substring = string.substring(i2, i3 + 4);
        n.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String str5 = l.G(l.G(substring, "<b>", "", false, 4, 0), "</b>", "", false, 4, 0);
        Objects.requireNonNull(str5, "null cannot be cast to non-null type kotlin.CharSequence");
        String string2 = l.a1(str5).toString();
        String str = l.G(string, substring, string2, false, 4, 0);
        int i4 = l.e0(str, string2, 0, false, 6, 0);
        t tVar = new t(str, Integer.valueOf(i4), Integer.valueOf(length += i4));
        return tVar;
    }

    public static final void g0(RecyclerView recyclerView, ProgramQuestion programQuestion2, e.c e$c3) {
        n.f(recyclerView, "<this>");
        n.f(programQuestion2, "item");
        n.f(c3, "callback");
        e eVar = new e(c3, p.N0(programQuestion2.getAnswers()), programQuestion2.getCorrectAnswer(), programQuestion2.getQuestion());
        recyclerView.setAdapter(eVar);
    }

    private final void h(ViewDataBinding viewDataBinding, SpecialProgramOverviewItem specialProgramOverviewItem2, j j3) {
        int i;
        int i2;
        int i4;
        boolean str;
        boolean i3;
        Object obj3;
        Object obj5;
        i3 = 1;
        i = viewDataBinding instanceof sl ? i3 : viewDataBinding instanceof ul;
        i2 = i != 0 ? i3 : viewDataBinding instanceof wl;
        i4 = i2 != 0 ? i3 : viewDataBinding instanceof sm;
        str = i4 != 0 ? i3 : viewDataBinding instanceof uh;
        if (str != null) {
        } else {
            i3 = viewDataBinding instanceof sh;
        }
        if (i3) {
            viewDataBinding.O(29, j3);
            viewDataBinding.O(94, specialProgramOverviewItem2);
        }
        android.view.ViewGroup.LayoutParams obj4 = viewDataBinding.w().getLayoutParams();
        Objects.requireNonNull(obj4, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        if (!viewDataBinding instanceof ij) {
            obj3 = viewDataBinding.w().getContext();
            n.e(obj3, "binding.root.context");
            l.a.U((LinearLayout.LayoutParams)obj4, obj3);
        }
    }

    public static final void h0(TextView textView, PottyRemindersItem pottyRemindersItem2) {
        String format;
        Object iterator;
        int i10;
        String string;
        String str;
        boolean booleanValue;
        int days;
        String quantityString;
        int i9;
        int i3;
        int resources;
        Object[] arr2;
        Object[] arr;
        Integer valueOf;
        int i5;
        int i7;
        int i8;
        int i;
        int i6;
        int i2;
        int i4;
        final Object obj = textView;
        n.f(obj, "<this>");
        if (pottyRemindersItem2 != null) {
            iterator = pottyRemindersItem2.getDays();
            i9 = 0;
            i3 = 1;
            if (iterator instanceof Collection != null && iterator.isEmpty()) {
                if (iterator.isEmpty()) {
                    i10 = i3;
                } else {
                    iterator = iterator.iterator();
                    for (Boolean next : iterator) {
                    }
                }
            } else {
            }
            if (i10 != 0) {
                string = textView.getResources().getString(2131886963);
            } else {
                x.a companion = x.Companion;
                days = pottyRemindersItem2.getDays();
                Calendar instance = Calendar.getInstance();
                arr2 = "getInstance()";
                n.e(instance, arr2);
                companion.e(days, instance);
                resources = Calendar.getInstance();
                n.e(resources, arr2);
                string = p.h0(companion.a(resources, days), 0, 0, 0, 0, 0, 0, 63, 0);
            }
            n.e(string, "if (item.days.all { it }) {\n                resources.getString(R.string.notification_time_every_day)\n            } else {\n                val correctedDays = ReminderHelper.rotateDayListFromMondayToLocaleBased(item.days, Calendar.getInstance())\n                ReminderHelper.getActiveWeekdayShortNameArray(Calendar.getInstance(), correctedDays).joinToString()\n            }");
            if (pottyRemindersItem2.getRepeatIntervalMs() != null) {
                if (Long.compare(longValue, millis) < 0) {
                    int i12 = (int)minutes;
                    arr = new Object[i3];
                    arr[i9] = Integer.valueOf(i12);
                    quantityString = textView.getResources().getQuantityString(2131755025, i12, arr);
                } else {
                    int i11 = (int)hours;
                    arr = new Object[i3];
                    arr[i9] = Integer.valueOf(i11);
                    quantityString = textView.getResources().getQuantityString(2131755024, i11, arr);
                }
            } else {
                quantityString = "";
            }
            n.e(quantityString, "if (item.repeatIntervalMs != null) {\n                if (item.repeatIntervalMs < TimeUnit.HOURS.toMillis(1)) {\n                    val minutes = TimeUnit.MILLISECONDS.toMinutes(item.repeatIntervalMs).toInt()\n                    resources.getQuantityString(\n                        R.plurals.time_placeholder_min,\n                        minutes,\n                        minutes\n                    )\n                } else {\n                    val hours = TimeUnit.MILLISECONDS.toHours(item.repeatIntervalMs).toInt()\n                    resources.getQuantityString(\n                        R.plurals.time_placeholder_hour,\n                        hours,\n                        hours\n                    )\n                }\n            } else {\n                \"\"\n            }");
            arr = new Object[i3];
            arr[i9] = quantityString;
            String string2 = textView.getResources().getString(2131886964, arr);
            n.e(string2, "resources.getString(R.string.notification_time_every_general, intervalString)");
            f0 f0Var = f0.a;
            resources = 2;
            arr2 = new Object[resources];
            arr2[i9] = string;
            arr2[i3] = string2;
            format = String.format("%s. %s", Arrays.copyOf(arr2, resources));
            n.e(format, "java.lang.String.format(format, *args)");
            obj.setText(format);
        }
    }

    private final Map<String, ViewDataBinding> i(ViewGroup viewGroup, List<? extends SpecialProgramOverviewItem.PottyOverviewCardEnum> list2, String string3) {
        int i2;
        int cardType;
        o oVar;
        Object iterator;
        String str;
        int i4;
        int i3;
        boolean next;
        boolean z;
        h obj11 = i.v(x.b(viewGroup), l.c.a);
        ArrayList arrayList = new ArrayList(p.r(list2, 10));
        final Iterator obj10 = list2.iterator();
        for (SpecialProgramOverviewItem.PottyOverviewCardEnum next3 : obj10) {
            str = "inflate(LayoutInflater.from(parent.context), parent, false)";
            i4 = 0;
            i3 = 0;
            iterator = obj11.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (obj4 instanceof sm) {
                    break loop_5;
                } else {
                }
            }
            if ((ViewDataBinding)i3 == 0) {
            }
            oVar = new o(next3.getCardType(), i3);
            arrayList.add(oVar);
            n.e(sm.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, i4), str);
            next = iterator.next();
            if (obj4 instanceof sm) {
            } else {
            }
            i3 = next;
            iterator = obj11.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (obj5 instanceof sh) {
                    break loop_11;
                } else {
                }
            }
            if ((ViewDataBinding)i3 == 0) {
            }
            n.e(sh.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, i4), str);
            next = iterator.next();
            if (obj5 instanceof sh) {
            } else {
            }
            i3 = next;
            iterator = obj11.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (obj6 instanceof uh) {
                    break loop_17;
                } else {
                }
            }
            if ((ViewDataBinding)i3 == 0) {
            }
            n.e(uh.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, i4), str);
            next = iterator.next();
            if (obj6 instanceof uh) {
            } else {
            }
            i3 = next;
            iterator = obj11.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (obj instanceof wl) {
                    break loop_23;
                } else {
                }
            }
            if ((ViewDataBinding)i3 == 0) {
            }
            n.e(wl.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, i4), str);
            next = iterator.next();
            if (obj instanceof wl) {
            } else {
            }
            i3 = next;
            iterator = obj11.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (obj2 instanceof ul) {
                    break loop_29;
                } else {
                }
            }
            if ((ViewDataBinding)i3 == 0) {
            }
            n.e(ul.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, i4), str);
            next = iterator.next();
            if (obj2 instanceof ul) {
            } else {
            }
            i3 = next;
            iterator = obj11.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (obj3 instanceof sl) {
                    break loop_35;
                } else {
                }
            }
            if ((ViewDataBinding)i3 == 0) {
            }
            n.e(sl.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, i4), str);
            next = iterator.next();
            if (obj3 instanceof sl) {
            } else {
            }
            i3 = next;
        }
        return j0.s(arrayList);
    }

    public static final void i0(TextView textView, PottyRemindersItem pottyRemindersItem2) {
        String endTime;
        o oVar;
        int i;
        String startTime;
        Object[] simpleDateFormat;
        int default;
        String str;
        String obj6;
        n.f(textView, "<this>");
        if (pottyRemindersItem2 != null) {
            if (pottyRemindersItem2.getEndTime() != null) {
                if (DateFormat.is24HourFormat(textView.getContext())) {
                    oVar = new o(pottyRemindersItem2.getStartTime(), pottyRemindersItem2.getEndTime());
                } else {
                    x.a companion = x.Companion;
                    o oVar2 = companion.c(pottyRemindersItem2.getStartTime());
                    obj6 = pottyRemindersItem2.getEndTime();
                    n.d(obj6);
                    obj6 = companion.c(obj6);
                    Calendar instance2 = Calendar.getInstance();
                    int i3 = 11;
                    instance2.set(i3, (Number)oVar2.a().intValue());
                    int i2 = 12;
                    instance2.set(i2, (Number)oVar2.b().intValue());
                    w wVar = w.a;
                    Calendar instance = Calendar.getInstance();
                    instance.set(i3, (Number)obj6.a().intValue());
                    instance.set(i2, (Number)obj6.b().intValue());
                    str = "hh:mm a";
                    obj6 = new SimpleDateFormat(str, Locale.getDefault());
                    simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
                    oVar = new o(obj6.format(instance2.getTime()), simpleDateFormat.format(instance.getTime()));
                }
                f0 f0Var = f0.a;
                i = 2;
                simpleDateFormat = new Object[i];
                simpleDateFormat[0] = (String)oVar.a();
                simpleDateFormat[1] = (String)oVar.b();
                n.e(String.format("%s - %s", Arrays.copyOf(simpleDateFormat, i)), "java.lang.String.format(format, *args)");
            } else {
                obj6 = pottyRemindersItem2.getStartTime();
            }
            textView.setText(obj6);
        }
    }

    private final void j(LinearLayout linearLayout, List<String> list2) {
        int childCount;
        View next;
        im imVar;
        String str;
        Iterator obj6;
        if (linearLayout.getChildCount() == 0) {
            obj6 = list2.iterator();
            for (String next2 : obj6) {
                imVar = im.T(LayoutInflater.from(linearLayout.getContext()), linearLayout, false);
                n.e(imVar, "inflate(inflater, this, false)");
                imVar.V(next2);
                linearLayout.addView(imVar.w());
            }
        }
    }

    public static final void j0(LinearLayout linearLayout, List<ProgramTasks> list2, g g3) {
        int i;
        Object next;
        int i2;
        ProgramTasks.Type type;
        ProgramTasks.Type nOT_STARTED;
        n.f(linearLayout, "<this>");
        n.f(list2, "list");
        n.f(g3, "callback");
        final Iterator obj6 = list2.iterator();
        i = 0;
        for (Object next : obj6) {
            if ((ProgramTasks)next.getType() == ProgramTasks.Type.NOT_STARTED) {
            } else {
            }
            if (next.getType() == ProgramTasks.Type.COMPLETED) {
            }
            i = i2;
            l.b(linearLayout, i, next);
            l.c(linearLayout, i, next, g3);
        }
    }

    private final void k(LinearLayout linearLayout, List<String> list2) {
        int childCount;
        View next;
        q4 q4Var;
        String str;
        Iterator obj6;
        if (linearLayout.getChildCount() == 0) {
            obj6 = list2.iterator();
            for (String next2 : obj6) {
                q4Var = q4.T(LayoutInflater.from(linearLayout.getContext()), linearLayout, false);
                n.e(q4Var, "inflate(inflater, this, false)");
                q4Var.V(next2);
                linearLayout.addView(q4Var.w());
            }
        }
    }

    private final void k0(ProgramExamSummary programExamSummary, ProgressBar progressBar2) {
        int intValue;
        int allExamsCount;
        Integer obj3;
        if (progressBar2 != null) {
            if (programExamSummary == null) {
                allExamsCount = intValue;
            } else {
            }
            progressBar2.setMax(allExamsCount);
            if (programExamSummary == null) {
            } else {
                obj3 = programExamSummary.getPassedExamsCount();
                if (obj3 == null) {
                } else {
                    intValue = obj3.intValue();
                }
            }
            progressBar2.setProgress(intValue);
        }
    }

    public static void l(ProgramTasks programTasks, ViewGroup viewGroup2, int i3, g g4, View view5) {
        l.d(programTasks, viewGroup2, i3, g4, view5);
    }

    private final void l0(int i, TextView textView2, int i3) {
        String string = textView2.getResources().getString(i);
        n.e(string, "textView.resources.getString(stringResource)");
        int i2 = l.e0(string, "%d", 0, false, 6, 0);
        int i4 = 1;
        Object[] arr = new Object[i4];
        arr[0] = Integer.valueOf(i3);
        String obj8 = textView2.getResources().getString(i, arr);
        n.e(obj8, "textView.resources.getString(stringResource, percentage)");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj8);
        obj8 = new StyleSpan(i4);
        int i10 = 33;
        spannableStringBuilder.setSpan(obj8, i2, i6 += i4, i10);
        obj8 = new AbsoluteSizeSpan(16, i4);
        spannableStringBuilder.setSpan(obj8, i2, obj10 += i4, i10);
        textView2.setText(spannableStringBuilder);
    }

    public static void m(TabLayout.g tabLayout$g, int i2) {
        l.I(g, i2);
    }

    public static final void m0(TextView textView, int i2) {
        n.f(textView, "<this>");
        DecimalFormat decimalFormat = new DecimalFormat("#,###,###");
        textView.setText(decimalFormat.format(Integer.valueOf(i2)));
    }

    public static void n(j j, SpecialProgramOverviewItem specialProgramOverviewItem2, View view3) {
        l.v(j, specialProgramOverviewItem2, view3);
    }

    public static final void n0(SegmentedProgressBar segmentedProgressBar, TrickItem trickItem2, int i3) {
        String str;
        int obj2;
        int obj3;
        n.f(segmentedProgressBar, "<this>");
        if (trickItem2 != 0) {
            str = 0;
            if (trickItem2.getKnowledge() >= i3) {
                obj2 = segmentedProgressBar.getResources().getColor(2131099772, str);
            } else {
                obj2 = segmentedProgressBar.getResources().getColor(2131100358, str);
            }
            segmentedProgressBar.setProgressSegmentColor(obj2);
        }
    }

    public static boolean o(View view) {
        return l.G(view);
    }

    public static final void o0(TextView textView, int i2) {
        n.f(textView, "<this>");
        l.a.l0(2131887506, textView, i2);
    }

    public static void p(j j, y.c y$c2, View view3) {
        l.N0(j, c2, view3);
    }

    public static final void p0(RecyclerView recyclerView, List<String> list2) {
        androidx.recyclerview.widget.RecyclerView.h qVar;
        String str;
        List obj3;
        n.f(recyclerView, "<this>");
        if (list2 != null && recyclerView.getAdapter() == null) {
            if (recyclerView.getAdapter() == null) {
                qVar = new q(list2);
                recyclerView.setAdapter(qVar);
            }
            if (recyclerView.getItemDecorationCount() == 0) {
                qVar = recyclerView.getContext();
                n.e(qVar, "context");
                obj3 = new x(qVar);
                recyclerView.h(obj3);
            }
        }
    }

    public static boolean q(View view, MotionEvent motionEvent2) {
        return l.F(view, motionEvent2);
    }

    public static final void q0(TextView textView, String string2) {
        String str;
        int intValue;
        int spannableStringBuilder;
        String foregroundColorSpan;
        int i4;
        int i;
        int i3;
        int i2;
        String obj9;
        n.f(textView, "<this>");
        if (string2 != null) {
            i4 = 0;
            intValue = l.e0(string2, "<b>", 0, i4, 6, 0);
            spannableStringBuilder = l.e0(string2, "</b>", i4, false, 6, 0);
            if (intValue >= 0 && spannableStringBuilder > 0 && string2.length() >= 7) {
                if (spannableStringBuilder > 0) {
                    if (string2.length() >= 7) {
                        obj9 = l.a.g(string2, intValue, spannableStringBuilder);
                        spannableStringBuilder = new SpannableStringBuilder((String)obj9.a());
                        foregroundColorSpan = new ForegroundColorSpan(a.d(textView.getContext(), 2131100352));
                        spannableStringBuilder.setSpan(foregroundColorSpan, (Number)obj9.b().intValue(), (Number)obj9.c().intValue(), 33);
                        textView.setText(spannableStringBuilder);
                    } else {
                        textView.setText(string2);
                    }
                } else {
                }
            } else {
            }
        }
    }

    public static void r(View view, ValueAnimator valueAnimator2) {
        l.f(view, valueAnimator2);
    }

    public static final void r0(LinearLayout linearLayout, y<ProgramOverview> y2) {
        app.dogo.com.dogo_android.y.l lVar;
        int obj2;
        n.f(linearLayout, "<this>");
        if (y2 instanceof y.c) {
        } else {
            obj2 = 0;
        }
        if (obj2 == null) {
        } else {
            obj2 = obj2.a();
            if ((ProgramOverview)obj2 == null) {
            } else {
                l.a.j(linearLayout, (ProgramOverview)obj2.getDogSkillOverview());
            }
        }
    }

    private final void s(ImageView imageView, boolean z2, String string3, String string4) {
        o obj4;
        androidx.swiperefreshlayout.widget.b obj5;
        final Context context = imageView.getContext();
        final int i = 0;
        if (z2) {
            imageView.setVisibility(i);
            obj5 = new l.a();
            m.a(context).D(string4).x1(obj5).p1(MyAppGlideModule.d(context)).C0(imageView);
        } else {
            imageView.setVisibility(i);
            m.a(context).D(string3).p1(MyAppGlideModule.d(context)).C0(imageView);
        }
    }

    public static final void s0(View view, y<Program> y2, Boolean boolean3, gm gm4) {
        boolean obj1;
        Object obj2;
        n.f(view, "<this>");
        if (n.b(boolean3, Boolean.TRUE)) {
            if (y2 instanceof y.c) {
            } else {
                obj2 = 0;
            }
            if (obj2 == null) {
            } else {
                obj1 = obj2.a();
                if ((Program)obj1 == null) {
                } else {
                    if (gm4 == null) {
                    } else {
                        gm4.T((Program)obj1);
                    }
                }
            }
        }
    }

    public static final void t(ImageView imageView, y<CertificateInfo> y2, String string3) {
        int i;
        String certificateImageUrl;
        int obj3;
        n.f(imageView, "<this>");
        if (y2 instanceof y.c) {
            i = y2;
        } else {
            i = certificateImageUrl;
        }
        if (i == 0) {
        } else {
            i = i.a();
            if ((CertificateInfo)i == null) {
            } else {
                certificateImageUrl = (CertificateInfo)i.getCertificateImageUrl();
            }
        }
        obj3 = y2 != null ? 1 : 0;
        l.a.s(imageView, obj3, string3, certificateImageUrl);
    }

    public static final void t0(LinearLayout linearLayout, y<SpecialProgramOverviewItem> y2, j j3) {
        boolean z;
        Iterator iterator;
        boolean next;
        String programId;
        app.dogo.com.dogo_android.y.l lVar;
        Object obj5;
        j obj6;
        n.f(linearLayout, "<this>");
        if (y2 instanceof y.c && j3 != null) {
            if (j3 != null) {
                obj5 = (y.c)y2.a();
                z = l.a.i(linearLayout, (SpecialProgramOverviewItem)obj5.getCardsOrder(), obj5.getProgramId());
                iterator = z.values().iterator();
                for (ViewDataBinding programId : iterator) {
                    l.a.h(programId, obj5, j3);
                }
                if (linearLayout.getChildCount() == 0) {
                    obj5 = obj5.getCardsOrder().iterator();
                    for (SpecialProgramOverviewItem.PottyOverviewCardEnum obj6 : obj5) {
                        linearLayout.addView((ViewDataBinding)j0.i(z, obj6.getCardType()).w());
                    }
                }
            }
        }
    }

    public static final void u(TextView textView, y<SpecialProgramOverviewItem> y2, View view3, j j4, View view5) {
        String programDescription;
        int text;
        Object obj2;
        Object obj3;
        n.f(textView, "<this>");
        n.f(view3, "readMoreLabel");
        n.f(view5, "clickArea");
        if (y2 instanceof y.c) {
            obj3 = (y.c)y2.a();
            textView.setText((SpecialProgramOverviewItem)obj3.getProgramData().getProgramDescription());
            obj2 = textView.getLayout();
            if (obj2 == null) {
            } else {
                text = obj2.getText();
            }
            text = 1;
            obj2 = obj2 ^= text != 0 ? 0 : 4;
            view3.setVisibility(obj2);
            obj2 = new c(j4, obj3);
            view5.setOnClickListener(obj2);
        } else {
            view5.setOnClickListener(0);
        }
    }

    public static final void u0(View view, y<SpecialProgramOverviewItem> y2, ImageView imageView3, TextView textView4, TextView textView5, Button button6, TextView textView7, Button button8) {
        boolean obj1;
        int obj2;
        int obj3;
        n.f(view, "<this>");
        n.f(imageView3, "programIcon");
        n.f(textView4, "programName");
        n.f(textView5, "enrollmentText");
        n.f(button6, "enrollmentButton");
        n.f(textView7, "unEnrollmentText");
        n.f(button8, "unEnrollmentButton");
        if (y2 instanceof y.c) {
        } else {
            obj2 = 0;
        }
        if (obj2 == null) {
        } else {
            obj1 = obj2.a();
            if ((SpecialProgramOverviewItem)obj1 == null) {
            } else {
                n.x(imageView3, (SpecialProgramOverviewItem)obj1.getProgramData().getCenterImage());
                textView4.setText(obj1.getProgramData().getProgramTitle());
                obj2 = 4;
                obj3 = 0;
                if (obj1.isProgramEnrolled()) {
                    textView5.setVisibility(obj2);
                    button6.setVisibility(obj2);
                    textView7.setVisibility(obj3);
                    button8.setVisibility(obj3);
                } else {
                    textView5.setVisibility(obj3);
                    button6.setVisibility(obj3);
                    textView7.setVisibility(obj2);
                    button8.setVisibility(obj2);
                }
            }
        }
    }

    private static final void v(j j, SpecialProgramOverviewItem specialProgramOverviewItem2, View view3) {
        Object obj1;
        n.f(specialProgramOverviewItem2, "$data");
        if (j == null) {
        } else {
            j.g1(specialProgramOverviewItem2.getProgramData().getProgramDescription());
        }
    }

    public static final void v0(RecyclerView recyclerView, List<ArticleWithStatus> list2, j.a j$a3) {
        androidx.recyclerview.widget.RecyclerView.h jVar;
        String str;
        List obj2;
        int obj3;
        n.f(recyclerView, "<this>");
        if (list2 != null && a3 != null && recyclerView.getAdapter() == null) {
            if (a3 != null) {
                if (recyclerView.getAdapter() == null) {
                    jVar = new j(a3);
                    recyclerView.setAdapter(jVar);
                }
                if (obj3 instanceof j) {
                } else {
                    obj3 = 0;
                }
                if (obj3 == null) {
                } else {
                    obj3.j(list2);
                }
                if (recyclerView.getItemDecorationCount() == 0) {
                    obj3 = new y(recyclerView.getResources().getDimensionPixelSize(2131165638));
                    recyclerView.h(obj3);
                }
            }
        }
    }

    public static final void w(TextView textView, String string2) {
        int substring;
        int i2;
        String length;
        int i7;
        int string;
        int i5;
        int i3;
        int i6;
        String str2;
        String str3;
        String str;
        int i8;
        int i;
        int i4;
        Object obj15;
        n.f(textView, "<this>");
        i7 = 0;
        string = 0;
        i5 = 6;
        i3 = 0;
        java.lang.CharSequence charSequence = string2;
        substring = l.e0(charSequence, "<b>", i7, string, i5, i3);
        i2 = l.e0(charSequence, "</b>", i7, string, i5, i3);
        if (string2 != null && substring >= 0 && i2 > 0 && string2.length() >= 7) {
            i7 = 0;
            string = 0;
            i5 = 6;
            i3 = 0;
            charSequence = string2;
            substring = l.e0(charSequence, "<b>", i7, string, i5, i3);
            i2 = l.e0(charSequence, "</b>", i7, string, i5, i3);
            if (substring >= 0) {
                if (i2 > 0) {
                    if (string2.length() >= 7) {
                        substring = string2.substring(substring, i2 += 4);
                        n.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        String str5 = l.G(l.G(substring, "<b>", "", false, 4, 0), "</b>", "", false, 4, 0);
                        Objects.requireNonNull(str5, "null cannot be cast to non-null type kotlin.CharSequence");
                        obj15 = l.G(string2, substring, l.a1(str5).toString(), false, 4, 0);
                    }
                }
            }
            textView.setText(obj15);
        }
    }

    public static final void w0(TextView textView, y<ProgramOverview> y2) {
        Resources resources;
        int i2;
        Object[] arr;
        int i;
        int obj5;
        n.f(textView, "<this>");
        if (y2 instanceof y.c) {
        } else {
            obj5 = 0;
        }
        if (obj5 == null) {
        } else {
            obj5 = obj5.a();
            if ((ProgramOverview)obj5 == null) {
            } else {
                arr = new Object[1];
                textView.setText(textView.getResources().getString(2131886492, Integer.valueOf((ProgramOverview)obj5.getEnrolledUsersCount())));
            }
        }
    }

    public static final void x(View view, String string2) {
        String str;
        int i;
        java.lang.CharSequence obj3;
        n.f(view, "<this>");
        if (string2 != null) {
            if (z ^= 1 != 0) {
                view.setBackgroundColor(Color.parseColor(string2));
            } else {
                view.setBackgroundColor(-65536);
            }
        }
    }

    public static final void x0(TextView textView, y<ProgramOverview> y2) {
        Resources resources;
        int i;
        Object[] arr;
        int i2;
        String programName;
        int obj6;
        n.f(textView, "<this>");
        if (y2 instanceof y.c) {
        } else {
            obj6 = 0;
        }
        if (obj6 == null) {
        } else {
            obj6 = obj6.a();
            if ((ProgramOverview)obj6 == null) {
            } else {
                arr = new Object[2];
                textView.setText(textView.getResources().getString(2131886198, (ProgramOverview)obj6.getProgramName(), Integer.valueOf(obj6.getAverageDurationWeeks())));
            }
        }
    }

    public static final void y(ProgressBar progressBar, boolean z2) {
        int i;
        Drawable obj3;
        n.f(progressBar, "<this>");
        int i2 = 0;
        if (z2) {
            obj3 = f.f(progressBar.getResources(), 2131231296, i2);
        } else {
            obj3 = f.f(progressBar.getResources(), 2131231295, i2);
        }
        progressBar.setProgressDrawable(obj3);
    }

    public static final void y0(ImageView imageView, y<ProgramOverview> y2) {
        androidx.swiperefreshlayout.widget.b bVar;
        int obj2;
        n.f(imageView, "<this>");
        if (y2 instanceof y.c) {
        } else {
            obj2 = 0;
        }
        if (obj2 == null) {
        } else {
            obj2 = obj2.a();
            if ((ProgramOverview)obj2 == null) {
            } else {
                m.a(imageView.getContext()).D((ProgramOverview)obj2.getCertificatePreview()).p1(MyAppGlideModule.d(imageView.getContext())).C0(imageView);
            }
        }
    }

    public static final void z(ProgressBar progressBar, ProgramExamSummary programExamSummary2) {
        n.f(progressBar, "<this>");
        l.a.k0(programExamSummary2, progressBar);
    }

    public static final void z0(ImageView imageView, y<ProgramOverview> y2) {
        p pVar;
        int obj2;
        n.f(imageView, "<this>");
        if (y2 instanceof y.c) {
        } else {
            obj2 = 0;
        }
        if (obj2 == null) {
        } else {
            obj2 = obj2.a();
            if ((ProgramOverview)obj2 == null) {
            } else {
                m.a(imageView.getContext()).D((ProgramOverview)obj2.getMirrorableImage()).C0(imageView);
            }
        }
    }

    public final void E(WebView webView, String string2, Button button3) {
        n.f(webView, "webView");
        n.f(string2, "text");
        n.f(button3, "button");
        webView.getSettings().setDefaultFontSize(16);
        int i = 0;
        webView.setVerticalScrollBarEnabled(i);
        webView.setHorizontalScrollBarEnabled(i);
        webView.setOnTouchListener(f.a);
        webView.setOnLongClickListener(d.a);
        webView.setLongClickable(i);
        webView.setHapticFeedbackEnabled(i);
        l.d dVar = new l.d();
        webView.setWebViewClient(dVar);
        webView.setBackgroundColor(Color.parseColor("#f9f9f9"));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html><header>");
        stringBuilder.append("<link rel='stylesheet' href='article_details/style.css' type='text/css'>");
        stringBuilder.append("</header><body>");
        stringBuilder.append(string2);
        stringBuilder.append("</body></html>");
        l.e obj9 = new l.e(webView, button3);
        webView.setWebChromeClient(obj9);
        webView.loadDataWithBaseURL("file:///android_asset/", stringBuilder.toString(), "text/html", "UTF-8", 0);
    }
}
