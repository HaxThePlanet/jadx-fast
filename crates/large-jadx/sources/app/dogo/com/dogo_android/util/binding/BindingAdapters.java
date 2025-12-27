package app.dogo.com.dogo_android.util.f0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Insets;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.BulletSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.transition.TransitionManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.WindowInsets;
import android.view.WindowInsets.Type;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.dogo.com.dogo_android.e.k.a;
import app.dogo.com.dogo_android.h.gi;
import app.dogo.com.dogo_android.i.m0;
import app.dogo.com.dogo_android.i.m0.a;
import app.dogo.com.dogo_android.i.m0.b;
import app.dogo.com.dogo_android.i.m0.c;
import app.dogo.com.dogo_android.i.m0.d;
import app.dogo.com.dogo_android.i.m0.e;
import app.dogo.com.dogo_android.i.n0;
import app.dogo.com.dogo_android.i.n0.b;
import app.dogo.com.dogo_android.i.o0;
import app.dogo.com.dogo_android.i.o0.a;
import app.dogo.com.dogo_android.i.q0;
import app.dogo.com.dogo_android.inappmessaging.OneTenRadioGroup;
import app.dogo.com.dogo_android.login_v2.c0;
import app.dogo.com.dogo_android.profile.invitation.DogParentInvitationException.DogIsAlreadyAdded;
import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.repository.domain.PermissionDescription;
import app.dogo.com.dogo_android.repository.domain.WorkoutStreakInfo;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.t.g0.j.a;
import app.dogo.com.dogo_android.t.h0.i.a;
import app.dogo.com.dogo_android.u.n.q.m.a;
import app.dogo.com.dogo_android.util.MyAppGlideModule;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.g0.b.b;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.o;
import app.dogo.com.dogo_android.util.v;
import app.dogo.com.dogo_android.util.x.a;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.o3.a;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.n.e.d;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.chip.ChipGroup.d;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.vimeo.networking.model.error.VimeoError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.f0;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.w;
import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.e.b.a;
import nl.dionsegijn.konfetti.e.b.c;

/* compiled from: BindingAdapters.kt */
@Metadata(d1 = "\u0000î\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010!\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0016\u0008Æ\u0002\u0018\u00002\u00020\u0001:\u0002Á\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0002J\u0008\u0010\u000b\u001a\u00020\nH\u0002J\u0019\u0010\u000c\u001a\u0004\u0018\u00010\u00082\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0002\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u000e2\u0008\u0010\r\u001a\u0004\u0018\u00010\u0008H\u0007¢\u0006\u0002\u0010\u0011J$\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u00132\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0016\u001a\u00020\u000eH\u0002J \u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000eH\u0002J\u001e\u0010\u001b\u001a\u00020\u000e2\u000e\u0010\u001c\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001e2\u0006\u0010\u001f\u001a\u00020 J\u001a\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020#2\u0008\u0010$\u001a\u0004\u0018\u00010\u000eH\u0007J&\u0010%\u001a\u00020\u0004*\u00020&2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00082\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0002J\u001b\u0010'\u001a\u00020\u0004*\u00020(2\u0008\u0010)\u001a\u0004\u0018\u00010\u0008H\u0007¢\u0006\u0002\u0010*J\u0016\u0010+\u001a\u00020\u0004*\u00020&2\u0008\u0010,\u001a\u0004\u0018\u00010-H\u0007J \u0010.\u001a\u00020\u000e*\u00020&2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\u0008\u0008\u0002\u0010/\u001a\u00020\u0008H\u0002J\u0014\u00100\u001a\u00020\u0004*\u0002012\u0006\u00102\u001a\u00020\u000eH\u0007J\u0016\u00103\u001a\u00020\u0004*\u00020#2\u0008\u0010$\u001a\u0004\u0018\u00010\u000eH\u0007J\u0014\u00104\u001a\u00020\u0004*\u00020#2\u0006\u0010$\u001a\u00020\u000eH\u0007J\u0016\u00105\u001a\u00020\u0004*\u00020#2\u0008\u00106\u001a\u0004\u0018\u000107H\u0007J5\u00108\u001a\u00020\u0004*\u0002092\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010:\u001a\u00020&2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\u0008\u0010;\u001a\u0004\u0018\u00010\u0008H\u0007¢\u0006\u0002\u0010<J&\u00108\u001a\u00020\u0004*\u00020=2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010:\u001a\u00020&2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0007J\u0016\u0010>\u001a\u00020\u0004*\u00020&2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0007J\u0014\u0010?\u001a\u00020\u0004*\u0002092\u0006\u0010@\u001a\u00020\u0008H\u0007J\u0016\u0010A\u001a\u00020\u0004*\u00020&2\u0008\u0010B\u001a\u0004\u0018\u00010\u000eH\u0007J\u0016\u0010C\u001a\u00020\u0004*\u00020D2\u0008\u0010E\u001a\u0004\u0018\u00010\u000eH\u0007J\u001b\u0010F\u001a\u00020\u0004*\u00020#2\u0008\u0010G\u001a\u0004\u0018\u00010HH\u0007¢\u0006\u0002\u0010IJ\u001b\u0010J\u001a\u00020\u0004*\u00020#2\u0008\u0010K\u001a\u0004\u0018\u00010HH\u0007¢\u0006\u0002\u0010IJ\u0014\u0010L\u001a\u00020\u0004*\u00020&2\u0006\u0010M\u001a\u00020NH\u0007J\u001c\u0010O\u001a\u00020\u0004*\u00020P2\u000e\u0010Q\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010\u0013H\u0007J,\u0010S\u001a\u00020\u0004*\u00020P2\u0014\u0010T\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020V0\u0013\u0018\u00010U2\u0008\u0010W\u001a\u0004\u0018\u00010XH\u0007J\u0016\u0010Y\u001a\u00020\u0004*\u00020&2\u0008\u0010Z\u001a\u0004\u0018\u00010VH\u0007J&\u0010[\u001a\u00020\u0004*\u00020P2\u000e\u0010T\u001a\n\u0012\u0004\u0012\u00020\\\u0018\u00010\u00132\u0008\u0010W\u001a\u0004\u0018\u00010]H\u0007J\u001b\u0010^\u001a\u00020\u0004*\u00020#2\u0008\u0010_\u001a\u0004\u0018\u00010\u0008H\u0007¢\u0006\u0002\u0010`J\u001b\u0010^\u001a\u00020\u0004*\u00020a2\u0008\u0010_\u001a\u0004\u0018\u00010\u0008H\u0007¢\u0006\u0002\u0010bJ>\u0010c\u001a\u00020\u0004*\u00020P2\u0014\u0010T\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00140\u0013\u0018\u00010U2\u0008\u0010d\u001a\u0004\u0018\u00010e2\u0006\u0010f\u001a\u00020g2\u0008\u0008\u0001\u0010h\u001a\u00020\u0008H\u0007J\u001b\u0010i\u001a\u00020\u0004*\u00020&2\u0008\u0010j\u001a\u0004\u0018\u00010kH\u0007¢\u0006\u0002\u0010lJ\u0014\u0010m\u001a\u00020\u0004*\u00020g2\u0006\u0010n\u001a\u00020\u0008H\u0007J\u0014\u0010o\u001a\u00020\u0004*\u00020&2\u0006\u0010p\u001a\u00020qH\u0007J\u0014\u0010r\u001a\u00020\u0004*\u0002012\u0006\u00102\u001a\u00020\u000eH\u0007J\u0016\u0010s\u001a\u00020\u0004*\u00020#2\u0008\u0010$\u001a\u0004\u0018\u00010\u000eH\u0007J\u001b\u0010t\u001a\u00020\u0004*\u00020&2\u0008\u0010\r\u001a\u0004\u0018\u00010kH\u0007¢\u0006\u0002\u0010lJ\u001b\u0010t\u001a\u00020\u0004*\u00020u2\u0008\u0010\r\u001a\u0004\u0018\u00010kH\u0007¢\u0006\u0002\u0010vJ\u0014\u0010w\u001a\u00020\u0004*\u00020x2\u0006\u0010y\u001a\u00020zH\u0007J0\u0010{\u001a\u00020\u0004*\u00020P2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00132\u0008\u0010d\u001a\u0004\u0018\u00010|2\u0008\u0010}\u001a\u0004\u0018\u00010\u000eH\u0007J\u001b\u0010~\u001a\u00020\u0004*\u00020\u007f2\r\u0010\u0080\u0001\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010UH\u0007J\u001f\u0010\u0081\u0001\u001a\u00020\u0004*\u00030\u0082\u00012\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010HH\u0007¢\u0006\u0003\u0010\u0084\u0001J\u001f\u0010\u0085\u0001\u001a\u00020\u0004*\u00030\u0086\u00012\u0006\u0010\"\u001a\u00020#2\u0007\u0010\u0087\u0001\u001a\u00020\u007fH\u0007J\u0017\u0010\u0088\u0001\u001a\u00020\u0004*\u00030\u0089\u00012\u0007\u0010;\u001a\u00030\u008a\u0001H\u0007J(\u0010\u008b\u0001\u001a\u00020\u0004*\u00020P2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020k\u0018\u00010\u00132\t\u0010d\u001a\u0005\u0018\u00010\u008c\u0001H\u0007J\u0016\u0010\u008d\u0001\u001a\u00020\u0004*\u0002092\u0007\u0010\u008e\u0001\u001a\u00020&H\u0007J\u0017\u0010\u008f\u0001\u001a\u00020\u0004*\u00020#2\u0008\u0010$\u001a\u0004\u0018\u00010\u000eH\u0007J'\u0010\u0090\u0001\u001a\u00020\u0004*\u00020&2\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0007J\u001c\u0010\u0091\u0001\u001a\u00020\u0004*\u00020#2\u0008\u0010@\u001a\u0004\u0018\u00010\u0008H\u0007¢\u0006\u0002\u0010`J\u0017\u0010\u0092\u0001\u001a\u00020\u0004*\u00020#2\u0008\u0010E\u001a\u0004\u0018\u00010\u000eH\u0007J\u001e\u0010\u0093\u0001\u001a\u00020\u0004*\u0002092\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010HH\u0007¢\u0006\u0003\u0010\u0094\u0001J\"\u0010\u0095\u0001\u001a\u00020\u0004*\u00020#2\u0008\u0010$\u001a\u0004\u0018\u00010\u000e2\t\u0010\u0096\u0001\u001a\u0004\u0018\u000107H\u0007J\u0017\u0010\u0097\u0001\u001a\u00020\u0004*\u00020#2\u0008\u0010$\u001a\u0004\u0018\u00010\u000eH\u0007J\u0017\u0010\u0098\u0001\u001a\u00020\u0004*\u0002092\u0008\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0007J \u0010\u009b\u0001\u001a\u00020\u0004*\u00020x2\u0008\u0010\u009c\u0001\u001a\u00030\u009d\u00012\u0007\u0010\u009e\u0001\u001a\u00020\u000eH\u0007J\u001d\u0010\u009f\u0001\u001a\u00020\u0004*\u00020&2\u000e\u0010 \u0001\u001a\t\u0012\u0004\u0012\u00020H0¡\u0001H\u0007J)\u0010¢\u0001\u001a\u00020\u0004*\u00020P2\t\u0010£\u0001\u001a\u0004\u0018\u00010\u00082\t\u0010d\u001a\u0005\u0018\u00010¤\u0001H\u0007¢\u0006\u0003\u0010¥\u0001J\u0017\u0010¦\u0001\u001a\u00020\u0004*\u0002092\u0008\u0010§\u0001\u001a\u00030¨\u0001H\u0007J\u001e\u0010©\u0001\u001a\u00020\u0004*\u00020\u00062\u000f\u0010ª\u0001\u001a\n\u0012\u0004\u0012\u00020H\u0018\u00010\u0013H\u0007J\u0018\u0010«\u0001\u001a\u00020\u0004*\u00020&2\t\u0010d\u001a\u0005\u0018\u00010¬\u0001H\u0007J\u001b\u0010­\u0001\u001a\u00020\u0004*\u0002092\u000c\u0010T\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010UH\u0007J\u001b\u0010®\u0001\u001a\u00020\u0004*\u0002092\u000c\u0010T\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010UH\u0007J\u001c\u0010¯\u0001\u001a\u00020\u0004*\u00030\u0082\u00012\u000c\u0010T\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010UH\u0007J\u001b\u0010°\u0001\u001a\u00020\u0004*\u0002092\u000c\u0010T\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010UH\u0007J+\u0010°\u0001\u001a\u00020\u0004*\u00020&2\r\u0010±\u0001\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010U2\r\u0010²\u0001\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010UH\u0007J\u0016\u0010³\u0001\u001a\u00020\u0004*\u00020#2\u0007\u0010´\u0001\u001a\u00020\u000eH\u0007J\u001b\u0010µ\u0001\u001a\u00020\u0004*\u0002092\u000c\u0010T\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010UH\u0007J\u001b\u0010¶\u0001\u001a\u00020\u0004*\u0002092\u000c\u0010T\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010UH\u0007J:\u0010·\u0001\u001a\u00020\u0004*\u0002092\r\u0010¸\u0001\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010U2\r\u0010¹\u0001\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010U2\r\u0010º\u0001\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010UH\u0007J\u001b\u0010»\u0001\u001a\u00020\u0004*\u0002092\u000c\u0010T\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010UH\u0007J\u001b\u0010¼\u0001\u001a\u00020\u0004*\u0002092\u000c\u0010T\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010UH\u0007J\u001b\u0010½\u0001\u001a\u00020\u0004*\u0002092\u000c\u0010T\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010UH\u0007J\u001b\u0010¾\u0001\u001a\u00020\u0004*\u0002092\u000c\u0010T\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010UH\u0007J\u001e\u0010¿\u0001\u001a\u00020\u0004*\u0002092\t\u0010À\u0001\u001a\u0004\u0018\u00010HH\u0007¢\u0006\u0003\u0010\u0094\u0001¨\u0006Â\u0001", d2 = {"Lapp/dogo/com/dogo_android/util/binding/BindingAdapters;", "", "()V", "animateArrow", "", "triangleView", "Landroid/view/ViewGroup;", "indexOfChild", "", "animObj", "Landroid/view/animation/AlphaAnimation;", "buildRatingAnimation", "convertIntegerToTimeString", "value", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "convertTimeStringToInteger", "(Ljava/lang/Integer;)Ljava/lang/String;", "faqFilter", "", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "list", "filterText", "getChangingRatingText", "resources", "Landroid/content/res/Resources;", "dogName", "getMessageFromException", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "context", "Landroid/content/Context;", "loadNonCchedImage", "imageView", "Landroid/widget/ImageView;", "imageUrl", "animateRatingText", "Landroid/widget/TextView;", "animateUpdateProgress", "Landroid/widget/ProgressBar;", "progress", "(Landroid/widget/ProgressBar;Ljava/lang/Integer;)V", "changeFontFamily", "fontFamily", "Lapp/dogo/com/dogo_android/enums/FontFamily;", "getShortDogName", "maxNameLength", "htmlTextForPolicy", "Landroid/webkit/WebView;", "descriptionText", "loadImageAndHideBackground", "loadImageUrlNoSpinner", "makeImageCircular", "image", "Landroid/graphics/drawable/Drawable;", "setAdapter", "Landroid/view/View;", "textWithAnimation", "knowledge", "(Landroid/view/View;Landroid/view/ViewGroup;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/Integer;)V", "Lcom/google/android/material/chip/ChipGroup;", "setAddNewString", "setBackgroundColor", "color", "setBulletPoint", "string", "setColorFromHex", "Landroidx/cardview/widget/CardView;", "hexCode", "setCompatDrawableDelete", "currentUserEntriesAuthor", "", "(Landroid/widget/ImageView;Ljava/lang/Boolean;)V", "setCompatDrawableWinner", "isWinner", "setCompletionLongestStreakText", "workoutSession", "Lapp/dogo/com/dogo_android/repository/domain/WorkoutStreakInfo;", "setDebugExperimentValues", "Landroidx/recyclerview/widget/RecyclerView;", "items", "Lapp/dogo/com/dogo_android/repository/domain/PermissionDescription;", "setDebugFeatureListAdapter", "result", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureItem;", "callBacks", "Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$Callbacks;", "setDebugItemCurrentValue", "item", "setDebugJsonEntryItemAdapter", "Lapp/dogo/com/dogo_android/debug/JsonArrayEditItem;", "Lapp/dogo/com/dogo_android/debug/JsonArrayEditAdapter$Callbacks;", "setDrawableRes", "res", "(Landroid/widget/ImageView;Ljava/lang/Integer;)V", "Lcom/google/android/material/chip/Chip;", "(Lcom/google/android/material/chip/Chip;Ljava/lang/Integer;)V", "setFaqSearchAdapter", "callback", "Lapp/dogo/com/dogo_android/settings/faq/FaqRecyclerViewAdapter$Callbacks;", "searchBox", "Landroid/widget/EditText;", "headerViewRes", "setFeedbackCardDate", "timestamp", "", "(Landroid/widget/TextView;Ljava/lang/Long;)V", "setFilterMax", "maxValue", "setFormattedChallengeNotificationDogName", "notificationItem", "Lapp/dogo/com/dogo_android/challenge/notificationcenter/notificationlist/ChallengeNotificationItemModel;", "setHtmlText", "setImageAsGrayscale", "setIntervalSelectorString", "Lcom/google/android/material/button/MaterialButton;", "(Lcom/google/android/material/button/MaterialButton;Ljava/lang/Long;)V", "setKonfetti", "Landroidx/constraintlayout/widget/ConstraintLayout;", "konfettiView", "Lnl/dionsegijn/konfetti/KonfettiView;", "setLanguageSelectAdapter", "Lapp/dogo/com/dogo_android/settings/language/LanguageSelectAdapter$Callbacks;", "currentLanguage", "setLoadingButton", "Landroid/widget/Button;", "results", "setProgressBarOffsetBasedOnStatusBar", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "bool", "(Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;Ljava/lang/Boolean;)V", "setRatingChange", "Lapp/dogo/com/dogo_android/inappmessaging/OneTenRadioGroup;", "submitButton", "setRatingMin1", "Lapp/dogo/com/dogo_android/view/compat/GlobalRatingBarMin1Star;", "", "setReminderIntervalSelectAdapter", "Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalAdapter$Callbacks;", "setShareDialogTitleView", "textView", "setSpinner", "setTextAnimation", "setTintBinding", "setTintFromHex", "setTopPaddingAsStatusBarHeight", "(Landroid/view/View;Ljava/lang/Boolean;)V", "setTrainerAvatar", "fallbackImage", "setTrickCircleImage", "setUtilAnimation", "anim", "Landroid/view/animation/Animation;", "setVideoView", "video", "Landroid/widget/VideoView;", "videoLink", "setWeekdayString", "days", "", "setupClickerSelect", "currentClickerSoundId", "Lapp/dogo/com/dogo_android/clicker/ClickerSelectAdapter$Callbacks;", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/lang/Integer;Lapp/dogo/com/dogo_android/clicker/ClickerSelectAdapter$Callbacks;)V", "setupFab", "fab", "Lapp/dogo/com/dogo_android/databinding/LayoutCustomFabBinding;", "setupReminderWeekdayBoxes", "dayStatusList", "setupTermsAndServices", "Lapp/dogo/com/dogo_android/login_v2/TermsAndServiceCallback;", "showAfterFirstSuccessfulDataLoad", "showErrorToast", "showLoad", "showLoading", "loginResults", "restorePurchaseResults", "showRawGif", "fileName", "showRetry", "showSmoothLoading", "showSmoothMultiLoading", "result1", "result2", "result3", "showSnackbar", "showSnackbarForView", "smoothHideAfterFirstSuccessfulDataLoad", "smoothShowAfterFirstSuccessfulDataLoad", "visibilityBindingSetup", "visible", "ChipGroupBindingAdapter", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: n, reason: from kotlin metadata */
public final class BindingAdapters {

    public static final n a = new n();

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0008\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004", d2 = {"Lapp/dogo/com/dogo_android/util/binding/BindingAdapters$ChipGroupBindingAdapter;", "", "()V", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final n.a.a INSTANCE = new n$a$a(0);

        public static final void a(ChipGroup chipGroup, int i) {
            BindingAdapters_ChipGroupBindingAdapter.INSTANCE.b(chipGroup, i);
        }

        public static final void b(ChipGroup chipGroup, ChipGroup.d dVar, androidx.databinding.g gVar) {
            BindingAdapters_ChipGroupBindingAdapter.INSTANCE.c(chipGroup, dVar, gVar);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class b {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[FontFamily.values().length];
            iArr[FontFamily.ROBOTO.ordinal()] = 1;
            iArr[FontFamily.ROBOTO_BOLD.ordinal()] = 2;
            iArr[FontFamily.ROBOTO_MEDIUM.ordinal()] = 3;
            iArr[FontFamily.MONTSERRAT_BOLD.ordinal()] = 4;
            iArr[FontFamily.MONTSERRAT_EXTRA_BOLD.ordinal()] = 5;
            iArr[FontFamily.MONTSERRAT_SEMI_BOLD.ordinal()] = 6;
            app.dogo.com.dogo_android.util.binding.n.b.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000c\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0010", d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", "start", "", "count", "after", "onTextChanged", "before", "core-ktx_release", "androidx/core/widget/TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d implements TextWatcher {

        final /* synthetic */ RecyclerView a;
        final /* synthetic */ y b;
        public d(RecyclerView recyclerView, y yVar) {
            this.a = recyclerView;
            this.b = yVar;
            super();
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(java.lang.CharSequence text, int start, int before, int count) {
            int i = 0;
            if (text != null) {
                this.a.q1(0);
                start = this.a.getAdapter() instanceof FaqRecyclerViewAdapter ? (FaqRecyclerViewAdapter)this.a.getAdapter() : 0;
                if (this.a != 0) {
                    String object = text.toString();
                    str = "null cannot be cast to non-null type kotlin.CharSequence";
                    Objects.requireNonNull(object, str);
                    i.j(BindingAdapters.a.g((List)(LoadResult_Success)this.b.component1(), l.a1(object).toString()));
                }
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(java.lang.CharSequence text, int start, int count, int after) {
        }
    }

    @Metadata(d1 = "\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t", d2 = {"app/dogo/com/dogo_android/util/binding/BindingAdapters$setupTermsAndServices$privacyClickSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "textView", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class f extends ClickableSpan {

        final /* synthetic */ c0 a;
        f(c0 c0Var) {
            this.a = c0Var;
            super();
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View textView) {
            n.f(textView, "textView");
            this.a.G();
        }

        @Override // android.text.style.ClickableSpan
        public void updateDrawState(TextPaint ds) {
            n.f(ds, "ds");
            super.updateDrawState(ds);
            ds.setUnderlineText(true);
        }
    }

    @Metadata(d1 = "\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t", d2 = {"app/dogo/com/dogo_android/util/binding/BindingAdapters$setupTermsAndServices$termsClickSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "textView", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class g extends ClickableSpan {

        final /* synthetic */ c0 a;
        g(c0 c0Var) {
            this.a = c0Var;
            super();
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View textView) {
            n.f(textView, "textView");
            this.a.q0();
        }

        @Override // android.text.style.ClickableSpan
        public void updateDrawState(TextPaint ds) {
            n.f(ds, "ds");
            super.updateDrawState(ds);
            ds.setUnderlineText(true);
        }
    }

    @Metadata(d1 = "\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J6\u0010\u0003\u001a\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0010\u0010\t\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J@\u0010\u000c\u001a\u00020\u00042\u0008\u0010\r\u001a\u0004\u0018\u00010\u00022\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0010\u0010\t\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\n2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\u0010", d2 = {"app/dogo/com/dogo_android/util/binding/BindingAdapters$loadImageAndHideBackground$1", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "onLoadFailed", "", "e", "Lcom/bumptech/glide/load/engine/GlideException;", "model", "", "target", "Lcom/bumptech/glide/request/target/Target;", "isFirstResource", "onResourceReady", "resource", "dataSource", "Lcom/bumptech/glide/load/DataSource;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c implements com.bumptech.glide.r.f<Drawable> {

        final /* synthetic */ ImageView a;
        c(ImageView imageView) {
            this.a = imageView;
            super();
        }

        /* renamed from: a, reason: from kotlin metadata */
        public boolean onResourceReady(Drawable resource, Object model, com.bumptech.glide.r.k.h<Drawable> target, com.bumptech.glide.load.a dataSource, boolean isFirstResource) {
            this.a.setBackground(null);
            return false;
        }

        public boolean onLoadFailed(GlideException e, Object model, com.bumptech.glide.r.k.h<Drawable> target, boolean isFirstResource) {
            return false;
        }
    }

    @Metadata(d1 = "\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001J0\u0010\u0003\u001a\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J6\u0010\u000c\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00082\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\u0010", d2 = {"app/dogo/com/dogo_android/util/binding/BindingAdapters$setTrickCircleImage$1", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "onLoadFailed", "", "e", "Lcom/bumptech/glide/load/engine/GlideException;", "model", "", "target", "Lcom/bumptech/glide/request/target/Target;", "isFirstResource", "onResourceReady", "resource", "dataSource", "Lcom/bumptech/glide/load/DataSource;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class e implements com.bumptech.glide.r.f<Drawable> {

        final /* synthetic */ ImageView a;
        e(ImageView imageView) {
            this.a = imageView;
            super();
        }

        /* renamed from: a, reason: from kotlin metadata */
        public boolean onResourceReady(Drawable resource, Object model, com.bumptech.glide.r.k.h<Drawable> target, com.bumptech.glide.load.a dataSource, boolean isFirstResource) {
            n.f(resource, "resource");
            n.f(model, "model");
            n.f(target, "target");
            n.f(dataSource, "dataSource");
            this.a.setBackground(null);
            return false;
        }

        public boolean onLoadFailed(GlideException e, Object model, com.bumptech.glide.r.k.h<Drawable> target, boolean isFirstResource) {
            n.f(model, "model");
            n.f(target, "target");
            return false;
        }
    }
    private n() {
        super();
    }

    public static final void A(View view, ViewGroup viewGroup, TextView textView, String str, Integer integer) {
        str = "<this>";
        n.f(view, str);
        n.f(viewGroup, "triangleView");
        str2 = "textWithAnimation";
        n.f(textView, str2);
        if (integer != null) {
            app.dogo.com.dogo_android.util.f0.n nVar = BindingAdapters.a;
            AlphaAnimation ratingAnimation = nVar.buildRatingAnimation();
            i = integer.intValue() - 1;
            nVar.c(textView, ratingAnimation, i, str);
            i2 = integer.intValue() - 1;
            nVar.setLanguageSelectAdapter(viewGroup, i2, ratingAnimation);
        }
    }

    /* renamed from: A0, reason: from kotlin metadata */
    public static final void animateArrow(TextView triangleView, y<?> indexOfChild, y<?> animObj) throws android.content.res.Resources.NotFoundException {
        Object obj;
        int i2 = 2131887110;
        n.f(triangleView, "<this>");
        if (indexOfChild instanceof LoadResult_Loading) {
            if (animObj instanceof LoadResult_Loading) {
                i2 = 2131887240;
                String string2 = triangleView.getResources().getString(i2);
            } else {
                i2 = 2131887110;
                String string = triangleView.getResources().getString(i2);
            }
            triangleView.setText(obj);
            int i = 0;
            triangleView.setVisibility(i);
        } else {
            i = 8;
            triangleView.setVisibility(i);
        }
    }

    /* renamed from: B, reason: from kotlin metadata */
    public static final void faqFilter(TextView list, String filterText) throws android.content.res.Resources.NotFoundException {
        str = "<this>";
        n.f(list, str);
        if (filterText != null) {
            StringBuilder stringBuilder = new StringBuilder();
            int i = 2131887111;
            String string = list.getResources().getString(i);
            str2 = " : ";
            str3 = string + str2 + filterText;
            list.setText(str3);
        }
    }

    /* renamed from: B0, reason: from kotlin metadata */
    public static final void getMessageFromException(ImageView exception, String context) {
        n.f(exception, "<this>");
        n.f(context, "fileName");
        (j)c.t(exception.getContext()).k(Integer.valueOf(exception.getContext().getResources().getIdentifier(context, "raw", exception.getContext().getPackageName()))).f(j.a).C0(exception);
    }

    /* renamed from: C, reason: from kotlin metadata */
    public static final void loadNonCchedImage(View imageView, int imageUrl) throws android.content.res.Resources.NotFoundException {
        n.f(imageView, "<this>");
        if (imageUrl == 0) {
            return;
        }
        imageView.setBackgroundColor(imageView.getResources().getColor(imageUrl, null));
    }

    /* renamed from: C0, reason: from kotlin metadata */
    public static final void getShortDogName(View dogName, y<?> maxNameLength) {
        int i = 0;
        n.f(dogName, "<this>");
        maxNameLength = maxNameLength instanceof LoadResult_Error ? 0 : 8;
        dogName.setVisibility((maxNameLength instanceof LoadResult_Error ? 0 : 8));
    }

    /* renamed from: D, reason: from kotlin metadata */
    public static final void setDebugFeatureListAdapter(TextView result, String callBacks) throws android.content.res.Resources.NotFoundException {
        str = "<this>";
        n.f(result, str);
        if (callBacks != null) {
            SpannableString spannableString = new SpannableString(callBacks);
            int i = 0;
            int i2 = 33;
            spannableString.setSpan(new BulletSpan((int)result.getResources().getDimension(2131165638), result.getTextColors().getDefaultColor()), i, l.Y(callBacks), i2);
            wVar = w.a;
            result.setText(spannableString);
        }
    }

    /* renamed from: D0, reason: from kotlin metadata */
    public static final void setDebugJsonEntryItemAdapter(View result, y<?> callBacks) {
        int i = 0;
        n.f(result, "<this>");
        TransitionManager.beginDelayedTransition(result);
        result.setVisibility(8);
        callBacks = callBacks instanceof LoadResult_Loading ? (oadResult_Loading)callBacks : 0;
        if (i != 0) {
            i = 0;
            result.setVisibility(i);
        }
    }

    /* renamed from: E, reason: from kotlin metadata */
    public static final void setRatingChange(CardView imageView, String submitButton) {
        str = "<this>";
        n.f(imageView, str);
        if (submitButton != null) {
            try {
                i = !l.z(submitButton);
                imageView.setCardBackgroundColor(Color.parseColor(submitButton));
                imageView.setCardBackgroundColor(-65536);
            } catch (Exception e) {
                a.d(e);
                imageView.setCardBackgroundColor(i2);
            }
        }
    }

    /* renamed from: E0, reason: from kotlin metadata */
    public static final void setAdapter(View triangleView, y<?> textWithAnimation, y<?> dogName, y<?> knowledge) {
        int i = 1;
        n.f(triangleView, "<this>");
        z = textWithAnimation instanceof LoadResult_Loading;
        i = 0;
        if (!(textWithAnimation instanceof oadResult_Loading)) {
            z = dogName instanceof LoadResult_Loading;
            if (!(dogName instanceof oadResult_Loading)) {
                z = knowledge instanceof LoadResult_Loading;
                if (knowledge instanceof oadResult_Loading) {
                    i = 1;
                } else {
                }
            }
        }
        triangleView.setVisibility(8);
        if (i != 0) {
            triangleView.setVisibility(i);
        }
    }

    /* renamed from: F, reason: from kotlin metadata */
    public static final void setReminderIntervalSelectAdapter(ImageView list, Boolean callback) {
        n.f(list, "<this>");
        if (n.b(callback, Boolean.TRUE)) {
            int i = 2131231339;
            list.setImageDrawable(a.d(list.getContext(), i));
        } else {
            i = 2131231141;
            list.setImageDrawable(a.d(list.getContext(), i));
        }
    }

    /* renamed from: F0, reason: from kotlin metadata */
    public static final void setTrainerAvatar(View imageUrl, y<?> fallbackImage) {
        int i2 = 0;
        n.f(imageUrl, "<this>");
        fallbackImage = fallbackImage instanceof LoadResult_Error ? (oadResult_Error)fallbackImage : 0;
        if (i2 != 0) {
            Exception component1 = i2.component1();
            if (component1 != null) {
                Tracker.INSTANCE.logException(component1);
                Context context = imageUrl.getContext();
                str = "context";
                n.e(context, str);
                int i = 0;
                Snackbar snackbar = Snackbar.e0(imageUrl, BindingAdapters.a.i(component1, context), i);
                n.e(snackbar, "make(this, message, LENGTH_LONG)");
                i2 = 5;
                app.dogo.com.dogo_android.util.extensionfunction.j1.createSingle(snackbar, i2);
                snackbar.T();
            }
        }
    }

    /* renamed from: G, reason: from kotlin metadata */
    public static final void setVideoView(ImageView video, Boolean videoLink) {
        n.f(video, "<this>");
        if (n.b(videoLink, Boolean.TRUE)) {
            int i = 2131231366;
            video.setImageDrawable(a.d(video.getContext(), i));
        } else {
            i = 2131231367;
            video.setImageDrawable(a.d(video.getContext(), i));
        }
    }

    /* renamed from: G0, reason: from kotlin metadata */
    public static final void setupClickerSelect(View currentClickerSoundId, y<?> callback) {
        int i2 = 0;
        n.f(currentClickerSoundId, "<this>");
        callback = callback instanceof LoadResult_Error ? (oadResult_Error)callback : 0;
        if (i2 != 0) {
            Exception component1 = i2.component1();
            if (component1 != null) {
                Tracker.INSTANCE.logException(component1);
                Context context = currentClickerSoundId.getContext();
                str = "context";
                n.e(context, str);
                Snackbar snackbar = Snackbar.e0(currentClickerSoundId, BindingAdapters.a.i(component1, context), 0);
                n.e(snackbar, "make(this, message, LENGTH_LONG)");
                int i = 5;
                app.dogo.com.dogo_android.util.extensionfunction.j1.createSingle(snackbar, i);
                snackbar.O(currentClickerSoundId);
                snackbar.T();
            }
        }
    }

    /* renamed from: H, reason: from kotlin metadata */
    public static final void showLoading(TextView loginResults, WorkoutStreakInfo restorePurchaseResults) throws android.content.res.Resources.NotFoundException {
        int i;
        Object obj;
        n.f(loginResults, "<this>");
        n.f(restorePurchaseResults, "workoutSession");
        i = 1;
        i = 0;
        int r0 = i;
        if (i != 0) {
            int i2 = 2131755019;
            Object[] arr = new Object[i];
            String quantityString2 = loginResults.getResources().getQuantityString(i2, restorePurchaseResults.getLongestStreak(), new Object[] { Integer.valueOf(restorePurchaseResults.getLongestStreak()) });
        } else {
            i2 = 2131755020;
            arr = new Object[i];
            String quantityString = loginResults.getResources().getQuantityString(i2, restorePurchaseResults.getLongestStreak(), new Object[] { Integer.valueOf(restorePurchaseResults.getLongestStreak()) });
        }
        loginResults.setText(obj);
    }

    public static final void H0(View view, y<?> yVar) {
        str = "<this>";
        n.f(view, str);
        if (yVar == null) {
            view.setVisibility(0);
            float f = 1f;
            view.setAlpha(f);
        } else {
            if (yVar instanceof LoadResult_Success) {
                f = 0.0f;
                try {
                    view.animate().alpha(f).setDuration(500L).setInterpolator(new b()).start();
                } catch (Exception e) {
                    view.setAlpha(yVar);
                    yVar = 8;
                    view.setVisibility(yVar);
                    a.d(e);
                }
            }
        }
    }

    public static final void I(RecyclerView recyclerView, List<PermissionDescription> list) {
        str = "<this>";
        n.f(recyclerView, str);
        if (list != null) {
            recyclerView.setAdapter(new PermissionExplanationAdapter(list));
        }
    }

    public static final void I0(View view, y<?> yVar) {
        str = "<this>";
        n.f(view, str);
        if (yVar == null) {
            float f = 0.0f;
            view.setAlpha(f);
        } else {
            if (yVar instanceof LoadResult_Success) {
                f = 1f;
                try {
                    view.animate().alpha(f).setDuration(500L).setInterpolator(new b()).start();
                } catch (Exception e) {
                    view.setAlpha(yVar);
                    a.d(e);
                }
            }
        }
    }

    /* renamed from: J, reason: from kotlin metadata */
    public static final void getChangingRatingText(RecyclerView indexOfChild, y<? extends List<? extends m0>> resources, n0.b dogName) {
        Object resources2;
        androidx.recyclerview.widget.RecyclerView.h adapter;
        int i = 0;
        n.f(indexOfChild, "<this>");
        i = 0;
        resources2 = resources instanceof LoadResult_Success ? (LoadResult_Success)resources2 : i;
        if (resources2 != null) {
            if ((List)resources2.component1() != null) {
                if (indexOfChild.getAdapter() == null) {
                    indexOfChild.setAdapter(new DebugFeatureListAdapter(dogName));
                }
                androidx.recyclerview.widget.RecyclerView.h indexOfChild2 = indexOfChild.getAdapter();
                z = indexOfChild2 instanceof DebugFeatureListAdapter;
                if (indexOfChild2 instanceof DebugFeatureListAdapter) {
                }
                if (i != 0) {
                    i.j((List)resources.component1());
                }
            }
        }
    }

    public static final void J0(View view, Boolean boolean) {
        int i = 8;
        n.f(view, "<this>");
        i = 0;
        if (boolean == null) {
        } else {
            boolean booleanValue = boolean.booleanValue();
        }
        if (i == 0) {
            i = 8;
        }
        view.setVisibility(i);
    }

    public static final void K(TextView textView, m0 m0Var) throws NoWhenBranchMatchedException {
        boolean z;
        Object obj;
        str = "<this>";
        n.f(textView, str);
        if (m0Var == null) {
            return;
        } else {
            z = m0Var instanceof DebugFeatureItem_BooleanDebugFeatureItem;
            if (m0Var instanceof DebugFeatureItem_BooleanDebugFeatureItem) {
                String str2 = String.valueOf(m0Var.c());
                textView.setText(obj);
            } else {
                z = m0Var instanceof DebugFeatureItem_StringDebugFeatureItem;
                if (m0Var instanceof DebugFeatureItem_StringDebugFeatureItem) {
                    String str5 = m0Var.c();
                } else {
                    if (m0Var instanceof DebugFeatureItem_DoubleDebugFeatureItem) {
                        String str3 = String.valueOf(m0Var.c());
                    } else {
                        if (m0Var instanceof DebugFeatureItem_LongDebugFeatureItem) {
                            String str4 = String.valueOf(m0Var.c());
                        } else {
                            z = m0Var instanceof DebugFeatureItem_JsonArrayDebugFeatureItem;
                            if (m0Var instanceof DebugFeatureItem_JsonArrayDebugFeatureItem) {
                                String object = m0Var.c().toString();
                            }
                        }
                    }
                }
            }
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: L, reason: from kotlin metadata */
    public static final void animateRatingText(RecyclerView animObj, List<q0> indexOfChild, o0.a dogName) {
        str = "<this>";
        n.f(animObj, str);
        if (indexOfChild != null && dogName != null && animObj.getAdapter() == null) {
            animObj.setAdapter(new JsonArrayEditAdapter(indexOfChild, dogName));
        }
    }

    public static final void M(ImageView imageView, Integer integer) {
        str = "<this>";
        n.f(imageView, str);
        if (integer != null && integer.intValue() != 0) {
            imageView.setImageDrawable(a.d(imageView.getContext(), integer.intValue()));
        }
    }

    public static final void N(RecyclerView recyclerView, y<? extends List<Article>> yVar, j.a aVar, EditText editText, int i) throws android.content.res.Resources.NotFoundException {
        n.f(recyclerView, "<this>");
        n.f(editText, "searchBox");
        if (yVar instanceof LoadResult_Success) {
            String object = editText.getText().toString();
            Objects.requireNonNull(object, "null cannot be cast to non-null type kotlin.CharSequence");
            app.dogo.com.dogo_android.t.g0.j faqRecyclerViewAdapter = new FaqRecyclerViewAdapter(aVar);
            faqRecyclerViewAdapter.j(BindingAdapters.a.g((List)(LoadResult_Success)yVar.component1(), l.a1(object).toString()));
            recyclerView.setAdapter(faqRecyclerViewAdapter);
            Context context = recyclerView.getContext();
            n.e(context, "context");
            int i2 = 2131165626;
            i = (int)recyclerView.getResources().getDimension(i2);
            recyclerView.h(new GenericInBetweenItemDivider(context, i));
            editText.addTextChangedListener(new TextViewKt_addTextChangedListener_textWatcher_1(recyclerView, yVar));
        } else {
            z = yVar instanceof LoadResult_Error;
            i = 0;
            if (yVar instanceof oadResult_Error) {
                app.dogo.com.dogo_android.t.g0.j faqRecyclerViewAdapter2 = new FaqRecyclerViewAdapter(aVar);
                faqRecyclerViewAdapter2.j(p.g());
                recyclerView.setAdapter(faqRecyclerViewAdapter2);
                recyclerView.i(new ZeroStateDecoration(i), i);
                Animation animation = AnimationUtils.loadAnimation(recyclerView.getContext(), 2130772024);
                str = "loadAnimation(context, R.anim.shake)";
                n.e(animation, str);
                recyclerView.startAnimation(animation);
            } else {
                if (yVar instanceof LoadResult_Loading && recyclerView.getItemDecorationCount() > 0) {
                    recyclerView.e1(i);
                }
            }
        }
    }

    public static final void O(TextView textView, Long long) {
        Object obj;
        n.f(textView, "<this>");
        String str2 = "";
        if (long != null) {
            boolean z = true;
            int i = 0;
            String long22 = App.INSTANCE.t().j(long.longValue(), z, false);
            if (long22 != null) {
            }
        }
        textView.setText(obj);
    }

    public static final void P(EditText editText, int i) {
        boolean z;
        n.f(editText, "<this>");
        android.text.InputFilter[] filters = editText.getFilters();
        str = "filters";
        n.e(filters, str);
        android.text.InputFilter[] filters2 = editText.getFilters();
        n.e(filters2, str);
        i = 0;
        i = 1;
        for (android.text.InputFilter inputFilter : filters2) {
            z = inputFilter instanceof MaxInputValidator;
            if (inputFilter instanceof MaxInputValidator) {
                break;
            }
        }
        if (i != 0) {
            android.text.InputFilter[] filters3 = editText.getFilters();
            n.e(filters3, str);
            Object[] copy = Arrays.copyOf(filters3, filters.length + i);
            n.e(copy, "java.util.Arrays.copyOf(this, newSize)");
            copy[filters.length] = new MaxInputValidator(i);
            editText.setFilters(copy);
        }
    }

    public static final void Q(TextView textView, app.dogo.com.dogo_android.d.c.j.b bVar) throws android.content.res.Resources.NotFoundException {
        String string;
        Object obj;
        n.f(textView, "<this>");
        n.f(bVar, "notificationItem");
        if (bVar.m()) {
            if (bVar.e() == null) {
                n.e(textView.getResources().getString(2131886675), "resources.getString(R.string.general_anonymous)");
            }
            int i = 2131886968;
            Object[] arr = new Object[1];
            int i2 = 0;
            arr[i2] = string;
            String string2 = textView.getResources().getString(i, arr);
        } else {
            String str4 = bVar.c();
        }
        textView.setText(obj);
    }

    public static final void R(WebView webView, String str) {
        n.f(webView, "<this>");
        n.f(str, "descriptionText");
        webView.getSettings().setDefaultFontSize(16);
        boolean z = false;
        webView.setVerticalScrollBarEnabled(z);
        webView.setHorizontalScrollBarEnabled(z);
        webView.setOnTouchListener(app.dogo.com.dogo_android.util.binding.g.a);
        webView.setOnLongClickListener(app.dogo.com.dogo_android.util.binding.h.a);
        webView.setLongClickable(z);
        webView.setHapticFeedbackEnabled(z);
        StringBuilder stringBuilder = new StringBuilder();
        String str4 = "<html><header>";
        String str5 = "<link rel='stylesheet' href='workout_explanation/style.css' type='text/css'>";
        String str6 = "</header><body>";
        final String str11 = "</body></html>";
        str8 = str4 + str5 + str6 + str + str11;
        webView.loadDataWithBaseURL("file:///android_asset/", str8, "text/html", "UTF-8", null);
    }

    private static final boolean S(View view, MotionEvent motionEvent) {
        boolean z = true;
        view = motionEvent.getAction() == 2 ? 1 : 0;
        return (motionEvent.getAction() == 2 ? 1 : 0);
    }

    public static final void U(ImageView imageView, String str) {
        str = "<this>";
        n.f(imageView, str);
        if (str != null) {
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            imageView.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            imageView.setImageAlpha(128);
            m.a(imageView.getContext()).D(str).p1(MyAppGlideModule.d(imageView.getContext())).R0(g.q0()).V0().C0(imageView);
        }
    }

    public static final void V(TextView textView, Long long) {
        str = "<this>";
        n.f(textView, str);
        if (long != null) {
            Resources resources = textView.getResources();
            str2 = "resources";
            n.e(resources, str2);
            textView.setText(app.dogo.com.dogo_android.util.extensionfunction.j1.parseItem(long.longValue(), resources));
        }
    }

    public static final void W(MaterialButton materialButton, Long long) {
        str = "<this>";
        n.f(materialButton, str);
        if (long != null) {
            Resources resources = materialButton.getResources();
            str2 = "resources";
            n.e(resources, str2);
            materialButton.setText(app.dogo.com.dogo_android.util.extensionfunction.j1.parseItem(long.longValue(), resources));
        }
    }

    public static final void X(ConstraintLayout constraintLayout, KonfettiView konfettiView) throws android.content.res.Resources.NotFoundException {
        n.f(constraintLayout, "<this>");
        n.f(konfettiView, "konfettiView");
        final nl.dionsegijn.konfetti.b bVar = konfettiView.a();
        int i2 = 2;
        int[] iArr = new int[i2];
        android.content.res.Resources.Theme theme = null;
        int i9 = 0;
        iArr[i9] = constraintLayout.getResources().getColor(2131099848, theme);
        int i6 = 1;
        iArr[i6] = constraintLayout.getResources().getColor(2131099849, theme);
        bVar.a(iArr);
        bVar.h(0.0d, 359d);
        bVar.k(5f, 8f);
        bVar.i(true);
        bVar.l(6000L);
        nl.dionsegijn.konfetti.e.b[] arr = new b[i2];
        arr[i9] = b.a.c;
        arr[i6] = b.c.b;
        bVar.b(arr);
        nl.dionsegijn.konfetti.e.c[] arr2 = new c[i6];
        arr2[i9] = new c(18, 500f);
        bVar.c(arr2);
        float f = -50f;
        Float num = Float.valueOf(f);
        bVar.j(f, Float.valueOf((float)constraintLayout.getRootView().getMeasuredWidth() + 50f), f, num);
        bVar.o(30, Long.MAX_VALUE);
    }

    /* renamed from: Y, reason: from kotlin metadata */
    public static final void setFaqSearchAdapter(RecyclerView result, List<String> callback, i.a searchBox, String headerViewRes) {
        str = "<this>";
        n.f(result, str);
        if (callback != null) {
            result.setAdapter(new LanguageSelectAdapter(callback, headerViewRes, searchBox));
        }
    }

    public static final void Z(Button button, y<?> yVar) throws android.content.res.Resources.NotFoundException {
        int paddingTop = 0;
        int paddingBottom;
        n.f(button, "<this>");
        paddingTop = 0;
        if (yVar instanceof LoadResult_Loading) {
            androidx.swiperefreshlayout.widget.b bVar = MyAppGlideModule.d(button.getContext());
            bVar.f(16f);
            bVar.setColorFilter(new PorterDuffColorFilter(button.getTextColors().getDefaultColor(), PorterDuff.Mode.SRC_IN));
            Object button2 = button instanceof MaterialButton ? (MaterialButton)button2 : paddingTop;
            if (paddingTop != 0) {
                paddingTop.setIcon(bVar);
            }
        } else {
            button2 = button instanceof MaterialButton ? (MaterialButton)button2 : paddingTop;
            if (paddingTop != 0) {
                paddingTop.setIconResource(2131231377);
                paddingTop.setIconTint(ColorStateList.valueOf(0));
            }
        }
        if (button instanceof MaterialButton) {
            button2 = button;
        }
        if (paddingTop != 0) {
            paddingTop.setIconSize((int)paddingTop.getContext().getResources().getDimension(2131165620));
            paddingTop.setIconPadding((int)paddingTop.getContext().getResources().getDimension(2131165638));
            i = (int)paddingTop.getContext().getResources().getDimension(2131165630);
            paddingTop.setPadding(paddingTop.getPaddingLeft(), paddingTop.getPaddingTop(), i, paddingTop.getPaddingBottom());
        }
    }

    /* renamed from: a, reason: from kotlin metadata */
    public static final /* synthetic */ List setAdapter(n triangleView, List textWithAnimation, String dogName) {
        return triangleView.g(textWithAnimation, dogName);
    }

    public static final void a0(SwipeRefreshLayout swipeRefreshLayout, Boolean boolean) {
        n.f(swipeRefreshLayout, "<this>");
        swipeRefreshLayout.setOnApplyWindowInsetsListener(new app.dogo.com.dogo_android.util.binding.j(swipeRefreshLayout));
    }

    /* renamed from: b, reason: from kotlin metadata */
    private final void setLanguageSelectAdapter(ViewGroup list, int callback, AlphaAnimation currentLanguage) {
        Iterator it = x.b(list).iterator();
        while (it.hasNext()) {
            Object item = it.next();
            item.setAnimation(null);
            int i = 4;
            item.setVisibility(i);
        }
        final View childAt = list.getChildAt(callback);
        if (childAt != null) {
            childAt.startAnimation(currentLanguage);
        }
        if (childAt != null) {
            int i2 = 0;
            childAt.setVisibility(i2);
        }
    }

    /* renamed from: b0, reason: from kotlin metadata */
    private static final WindowInsets setTextAnimation(SwipeRefreshLayout indexOfChild, View triangleView, WindowInsets dogName) {
        int systemWindowInsetTop;
        n.f(indexOfChild, "$this_setProgressBarOffsetBasedOnStatusBar");
        if (Build.VERSION.SDK_INT >= 30) {
        } else {
            systemWindowInsetTop = dogName.getSystemWindowInsetTop();
        }
        indexOfChild.m(false, systemWindowInsetTop, systemWindowInsetTop * 3);
        return dogName;
    }

    private final void c(TextView textView, AlphaAnimation alphaAnimation, int i, String str) {
        textView.startAnimation(alphaAnimation);
        Resources resources = textView.getResources();
        n.e(resources, "resources");
        textView.setText(h(i, resources, BindingAdapters.k(this, textView, str, 0, 2, null)));
    }

    /* renamed from: c0, reason: from kotlin metadata */
    public static final void showSmoothMultiLoading(OneTenRadioGroup result1, ImageView result2, Button result3) {
        n.f(result1, "<this>");
        n.f(result2, "imageView");
        n.f(result3, "submitButton");
        result1.setOnCheckedChangeListener(new app.dogo.com.dogo_android.util.binding.d(result2, result1, result3));
    }

    public static final void d(ProgressBar progressBar, Integer integer) {
        int value = 0;
        n.f(progressBar, "<this>");
        if (integer == null) {
            value = 0;
        } else {
            value = integer.intValue();
        }
        progressBar.setProgress(value, true);
    }

    private static final void d0(ImageView imageView, OneTenRadioGroup oneTenRadioGroup, Button button, RadioGroup radioGroup, int i) {
        int i52 = 0;
        n.f(imageView, "$imageView");
        n.f(oneTenRadioGroup, "$this_setRatingChange");
        n.f(button, "$submitButton");
        Objects.requireNonNull(radioGroup, "null cannot be cast to non-null type app.dogo.com.dogo_android.inappmessaging.OneTenRadioGroup");
        int rating = radioGroup.getRating(i);
        i52 = 1;
        i52 = 0;
        int r1 = i52;
        if (i52 != 0) {
            rating = 2131231116;
            imageView.setImageDrawable(a.d(oneTenRadioGroup.getContext(), rating));
        } else {
            int i2 = 6;
            r1 = i52;
            if (i52 != 0) {
                rating = 2131231117;
                imageView.setImageDrawable(a.d(oneTenRadioGroup.getContext(), rating));
            } else {
                i52 = 9;
                if (9 <= rating && rating <= 10) {
                }
                if ("null cannot be cast to non-null type app.dogo.com.dogo_android.inappmessaging.OneTenRadioGroup" != 0) {
                    rating = 2131231115;
                    imageView.setImageDrawable(a.d(oneTenRadioGroup.getContext(), rating));
                }
            }
        }
        if (!button.isEnabled()) {
            button.setEnabled(true);
        }
    }

    /* renamed from: e, reason: from kotlin metadata */
    private final AlphaAnimation buildRatingAnimation() {
        final float f = 1f;
        final AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, f);
        alphaAnimation.setDuration(1000L);
        return alphaAnimation;
    }

    public static final void e0(RecyclerView recyclerView, List<Long> list, m.a aVar) {
        str = "<this>";
        n.f(recyclerView, str);
        if (list != null && aVar != null) {
            recyclerView.setAdapter(new ReminderIntervalAdapter(list, aVar));
        }
    }

    public static final void f(TextView textView, app.dogo.com.dogo_android.k.g gVar) throws NoWhenBranchMatchedException {
        int i = 0;
        Typeface typeface;
        n.f(textView, "<this>");
        if (gVar == null) {
            return;
        } else {
            try {
                i = 0;
                i = 2131296258;
                typeface = f.g(textView.getContext(), i);
                i = 2131296257;
                typeface = f.g(textView.getContext(), i);
                i = 2131296256;
                typeface = f.g(textView.getContext(), i);
                typeface = Typeface.create("sans-serif-medium", i);
                typeface = Typeface.create("sans-serif-bold", i);
                typeface = Typeface.create("sans-serif", i);
                textView.setTypeface(typeface);
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
            } catch (Exception e) {
                a.d(e);
            }
        }
    }

    public static final void f0(View view, TextView textView) throws android.content.res.Resources.NotFoundException {
        Object obj;
        n.f(view, "<this>");
        n.f(textView, "textView");
        if (new Random().nextInt(2) == 0) {
            int i = 2131886781;
            String string = view.getResources().getString(i);
        } else {
            i = 2131886782;
            String string2 = view.getResources().getString(i);
        }
        textView.setText(obj);
    }

    private final List<Article> g(List<Article> list, String str) {
        int i = 1;
        boolean z;
        int i2 = 2;
        Object obj = null;
        ArrayList arrayList;
        final boolean z2 = false;
        int r0 = str.length() == 0 ? 1 : z2;
        if (i == 0) {
            arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Object item = it.next();
                String title = (Article)item.getTitle();
                String str4 = "null cannot be cast to non-null type java.lang.String";
                Objects.requireNonNull(title, str4);
                String str3 = title.toLowerCase();
                String str5 = "(this as java.lang.String).toLowerCase()";
                n.e(str3, str5);
                Objects.requireNonNull(str, str4);
                str = str.toLowerCase();
                n.e(str, str5);
                i2 = 2;
                obj = null;
            }
        }
        return arrayList;
    }

    public static final void g0(ImageView imageView, String str) {
        n.f(imageView, "<this>");
        m.a(imageView.getContext()).z(MyAppGlideModule.d(imageView.getContext())).C0(imageView);
    }

    private final String h(int i, Resources resources, String str) throws android.content.res.Resources.NotFoundException {
        String formatted;
        str = "java.lang.String.format(format, *args)";
        int i3 = 1;
        final int i4 = 0;
        if (i == i3) {
            Object[] arr = new Object[i3];
            String string5 = resources.getString(2131887161, new Object[] { str });
            n.e(string5, "resources.getString(R.string.rating_text_2_2, dogName)");
            n.e(String.format(string5, Arrays.copyOf(new Object[i4], i4)), str);
        } else {
            int i2 = 2;
            if (i == 2) {
                arr = new Object[i3];
                String string = resources.getString(2131887163, new Object[] { str });
                n.e(string, "resources.getString(R.string.rating_text_3_2, dogName)");
                n.e(String.format(string, Arrays.copyOf(new Object[i4], i4)), str);
            } else {
                i2 = 3;
                if (i == 3) {
                    arr = new Object[i3];
                    String string4 = resources.getString(2131887165, new Object[] { str });
                    n.e(string4, "resources.getString(R.string.rating_text_4_2, dogName)");
                    n.e(String.format(string4, Arrays.copyOf(new Object[i4], i4)), str);
                } else {
                    i2 = 4;
                    if (i != 4) {
                        arr = new Object[i3];
                        String string3 = resources.getString(2131887159, new Object[] { str });
                        n.e(string3, "resources.getString(R.string.rating_text_1_2, dogName)");
                        n.e(String.format(string3, Arrays.copyOf(new Object[i4], i4)), str);
                    } else {
                        arr = new Object[i3];
                        String string2 = resources.getString(2131887167, new Object[] { str });
                        n.e(string2, "resources.getString(R.string.rating_text_5_2, dogName)");
                        n.e(String.format(string2, Arrays.copyOf(new Object[i4], i4)), str);
                    }
                }
            }
        }
        return formatted;
    }

    public static final void h0(TextView textView, int i, ViewGroup viewGroup, String str) {
        n.f(textView, "<this>");
        n.f(viewGroup, "triangleView");
        app.dogo.com.dogo_android.util.f0.n nVar = BindingAdapters.a;
        final AlphaAnimation ratingAnimation = nVar.buildRatingAnimation();
        nVar.c(textView, ratingAnimation, i, str);
        nVar.setLanguageSelectAdapter(viewGroup, i, ratingAnimation);
    }

    public static final void i0(ImageView imageView, Integer integer) {
        n.f(imageView, "<this>");
        if (integer != null) {
            integer.intValue();
            imageView.setImageTintList(ColorStateList.valueOf(integer.intValue()));
        }
    }

    private final String j(TextView textView, String str, int i) throws android.content.res.Resources.NotFoundException {
        int length;
        String string;
        if (str == null || str.length() > i) {
            string = textView.getResources().getString(2131887168);
        }
        n.e(string, "if (dogName == null || dogName.length > maxNameLength) resources.getString(R.string.rating_your_dog) else dogName");
        return string;
    }

    public static final void j0(ImageView imageView, String str) {
        int color;
        str = "<this>";
        n.f(imageView, str);
        if (str != null) {
            try {
                if (!l.z(str) != 0) {
                    color = Color.parseColor(str);
                } else {
                }
                imageView.setColorFilter(color, PorterDuff.Mode.SRC_IN);
            } catch (Exception e) {
                a.d(e);
                e = PorterDuff.Mode.SRC_IN;
                imageView.setColorFilter(i, e);
            }
        }
    }

    static /* synthetic */ String k(n nVar, TextView textView, String str, int i, int i2, Object object) {
        if (i2 & 2 != 0) {
            i = 14;
        }
        return nVar.j(textView, str, i);
    }

    public static final void k0(View view, Boolean boolean) {
        n.f(view, "<this>");
        view.setOnApplyWindowInsetsListener(new app.dogo.com.dogo_android.util.binding.i(view));
    }

    public static final void l(WebView webView, String str) throws android.content.res.Resources.NotFoundException {
        n.f(webView, "<this>");
        n.f(str, "descriptionText");
        webView.getSettings().setDefaultFontSize(16);
        webView.setOnTouchListener(app.dogo.com.dogo_android.util.binding.k.a);
        webView.setOnLongClickListener(app.dogo.com.dogo_android.util.binding.l.a);
        boolean z = false;
        webView.setLongClickable(z);
        webView.setHapticFeedbackEnabled(z);
        webView.setVerticalScrollBarEnabled(z);
        webView.setHorizontalScrollBarEnabled(true);
        webView.setBackgroundColor(webView.getResources().getColor(2131099860, null));
        webView.loadDataWithBaseURL("file:///android_asset/", str, "text/html", "UTF-8", null);
    }

    private static final WindowInsets l0(View view, View view2, WindowInsets windowInsets) {
        int systemWindowInsetTop;
        n.f(view, "$this_setTopPaddingAsStatusBarHeight");
        if (Build.VERSION.SDK_INT >= 30) {
        } else {
            systemWindowInsetTop = windowInsets.getSystemWindowInsetTop();
        }
        view2.setPadding(view.getPaddingLeft(), systemWindowInsetTop, view.getPaddingRight(), view.getPaddingBottom());
        return windowInsets;
    }

    private static final boolean m(View view, MotionEvent motionEvent) {
        boolean z = true;
        view = motionEvent.getAction() == 2 ? 1 : 0;
        return (motionEvent.getAction() == 2 ? 1 : 0);
    }

    public static final void m0(ImageView imageView, String str, Drawable drawable) {
        n.f(imageView, "<this>");
        m.a(imageView.getContext()).D(str).p1(MyAppGlideModule.d(imageView.getContext())).a1(drawable).Y0(drawable).R0(g.q0()).V0().C0(imageView);
    }

    public static final void n0(ImageView imageView, String str) {
        str = "<this>";
        n.f(imageView, str);
        if (str != null) {
            imageView.setBackground(MyAppGlideModule.d(imageView.getContext()));
            m.a(imageView.getContext()).D(str).y1(d.h()).c1(new BindingAdapters_setTrickCircleImage_1(imageView)).R0(g.q0()).C0(imageView);
        }
    }

    public static final void o0(View view, Animation animation) {
        n.f(view, "<this>");
        n.f(animation, "anim");
        view.startAnimation(animation);
    }

    public static final void p0(ConstraintLayout constraintLayout, VideoView videoView, String str) {
        n.f(constraintLayout, "<this>");
        n.f(videoView, "video");
        n.f(str, "videoLink");
        videoView.setVideoURI(Uri.parse(str));
        videoView.requestFocus();
        videoView.setOnPreparedListener(new app.dogo.com.dogo_android.util.binding.f(videoView, new MediaController(constraintLayout.getContext())));
    }

    private static final void q0(VideoView videoView, MediaController mediaController, MediaPlayer mediaPlayer) {
        n.f(videoView, "$video");
        n.f(mediaController, "$mediaController");
        boolean z = true;
        mediaPlayer.setLooping(z);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();
        mediaController.setEnabled(z);
    }

    public static final void r0(TextView textView, List<Boolean> list) throws android.content.res.Resources.NotFoundException {
        int i = 1;
        boolean booleanValue;
        Object obj2;
        n.f(textView, "<this>");
        n.f(list, "days");
        empty = list instanceof Collection;
        i = 1;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (!(Boolean)it.next().booleanValue()) {
                    break;
                }
            }
        }
        if (i != 0) {
            String string = textView.getResources().getString(2131886963);
        } else {
            Calendar time = Calendar.getInstance();
            str = "getInstance()";
            n.e(time, str);
            java.lang.CharSequence charSequence = null;
            java.lang.CharSequence charSequence2 = null;
            java.lang.CharSequence charSequence3 = null;
            int i2 = 0;
            java.lang.CharSequence charSequence4 = null;
            kotlin.d0.c.l lVar = null;
            int i3 = 63;
            Object obj = null;
            String str4 = p.h0(ReminderHelper.INSTANCE.getActiveWeekdayShortNameArray(time, list), charSequence, charSequence2, charSequence3, i2, charSequence4, lVar, i3, obj);
        }
        textView.setText(obj2);
    }

    public static final void s0(RecyclerView recyclerView, Integer integer, k.a aVar) throws android.content.res.Resources.NotFoundException {
        str = "<this>";
        n.f(recyclerView, str);
        if (integer != null && aVar != null && recyclerView.getAdapter() == null) {
            String[] strArr = new String[6];
            int i = 2131886351;
            recyclerView.setAdapter(new ClickerSelectAdapter(p.j(new String[] { recyclerView.getResources().getString(2131886346), recyclerView.getResources().getString(2131886347), recyclerView.getResources().getString(2131886348), recyclerView.getResources().getString(2131886349), recyclerView.getResources().getString(2131886350), recyclerView.getResources().getString(i) }), aVar, integer.intValue()));
        }
    }

    public static final void t0(View view, gi giVar) {
        n.f(view, "<this>");
        n.f(giVar, "fab");
        app.dogo.com.dogo_android.util.g0.b bVar = new b(view.getResources());
        bVar.p(b.b.FIRST_UPLOAD);
        giVar.T(bVar);
    }

    public static final void u0(ViewGroup viewGroup, List<Boolean> list) {
        int i;
        java.lang.CharSequence charSequence;
        Object obj = null;
        boolean z;
        boolean booleanValue;
        str = "<this>";
        n.f(viewGroup, str);
        if (list != null) {
            Calendar time = Calendar.getInstance();
            item = "getInstance()";
            n.e(time, item);
            ArrayList arrayList = new ArrayList();
            Iterator it2 = i.A(x.b(viewGroup)).iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                String item = it2.next();
                z = item instanceof CheckBox;
            }
            Iterator it = arrayList.iterator();
            i = 0;
            while (it.hasNext()) {
                Object item2 = it.next();
                i = i + 1;
                if (i < 0) {
                    p.q();
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) 0;
                }
            }
        }
    }

    public static final void v0(TextView textView, c0 c0Var) throws android.content.res.Resources.NotFoundException {
        str = "<this>";
        n.f(textView, str);
        if (c0Var != null) {
            String string3 = textView.getResources().getString(2131886168);
            n.e(string3, "resources.getString(R.string.auth_disclaimer_text)");
            String string = textView.getResources().getString(2131886708);
            n.e(string, "resources.getString(R.string.general_terms_use)");
            String string2 = textView.getResources().getString(2131886694);
            n.e(string2, "resources.getString(R.string.general_privacy_policy)");
            int i10 = 0;
            boolean z = true;
            int i5 = 2;
            Object obj = null;
            Object obj2 = string3;
            int i6 = l.e0(obj2, string, i10, z, i5, obj);
            int i2 = l.e0(obj2, string2, i10, z, i5, obj);
            i = string.length() + i6;
            i3 = string2.length() + i2;
            SpannableString spannableString = new SpannableString(string3);
            int i11 = 33;
            spannableString.setSpan(new BindingAdapters_setupTermsAndServices_termsClickSpan_1(c0Var), i6, i, i11);
            spannableString.setSpan(new BindingAdapters_setupTermsAndServices_privacyClickSpan_1(c0Var), i2, i3, i11);
            spannableString.setSpan(new ForegroundColorSpan(textView.getTextColors().getDefaultColor()), i6, i, i11);
            spannableString.setSpan(new ForegroundColorSpan(textView.getTextColors().getDefaultColor()), i2, i3, i11);
            int i4 = 1;
            spannableString.setSpan(new StyleSpan(i4), i6, i, i11);
            spannableString.setSpan(new StyleSpan(i4), i2, i3, i11);
            textView.setText(spannableString);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public static final void w(ImageView imageView, String str) {
        n.f(imageView, "<this>");
        imageView.setBackground(MyAppGlideModule.d(imageView.getContext()));
        m.a(imageView.getContext()).D(str).w1(0.75f).y1(d.h()).c1(new BindingAdapters_loadImageAndHideBackground_1(imageView)).C0(imageView);
    }

    public static final void w0(View view, y<?> yVar) {
        n.f(view, "<this>");
        if (yVar == null) {
            int i = 8;
            view.setVisibility(i);
        } else {
            if (yVar instanceof LoadResult_Success) {
                i = 0;
                view.setVisibility(i);
            }
        }
    }

    public static final void x(ImageView imageView, String str) {
        n.f(imageView, "<this>");
        n.f(str, "imageUrl");
        m.a(imageView.getContext()).D(str).C0(imageView);
    }

    public static final void x0(View view, y<?> yVar) throws android.content.res.Resources.NotFoundException {
        int i2 = 0;
        n.f(view, "<this>");
        yVar = yVar instanceof LoadResult_Error ? (oadResult_Error)yVar : 0;
        if (i2 != 0) {
            Exception component1 = i2.component1();
            if (component1 != null) {
                Tracker.INSTANCE.logException(component1);
                Context context2 = view.getContext();
                str = "context";
                n.e(context2, str);
                int i = 1;
                Toast.makeText(App.INSTANCE.b(), BindingAdapters.a.i(component1, context2), i).show();
            }
        }
    }

    public static final void y(ImageView imageView, String str) {
        n.f(imageView, "imageView");
        Context context = imageView.getContext();
        m.a(context).D(str).p1(MyAppGlideModule.d(context)).v1(true).U0(j.a).C0(imageView);
    }

    public static final void y0(SwipeRefreshLayout swipeRefreshLayout, y<?> yVar) {
        int i = 0;
        n.f(swipeRefreshLayout, "<this>");
        swipeRefreshLayout.setRefreshing(false);
        yVar = yVar instanceof LoadResult_Loading ? (oadResult_Loading)yVar : 0;
        if (i != 0) {
            boolean z = true;
            swipeRefreshLayout.setRefreshing(z);
        }
    }

    public static final void z(ImageView imageView, Drawable drawable) {
        n.f(imageView, "<this>");
        c.u(imageView).i(drawable).r0(g.q0()).C0(imageView);
    }

    public static final void z0(View view, y<?> yVar) {
        int i = 0;
        n.f(view, "<this>");
        view.setVisibility(8);
        yVar = yVar instanceof LoadResult_Loading ? (oadResult_Loading)yVar : 0;
        if (i != 0) {
            i = 0;
            view.setVisibility(i);
        }
    }

    public final String i(Exception exc, Context context) {
        Exception exc4 = null;
        Exception exc5 = null;
        String str2 = null;
        String localizedMessage;
        int i2;
        n.f(context, "context");
        z = exc instanceof DogParentInvitationException_InvitationDoesNotExist;
        str = "context.getString(R.string.alert_something_failed)";
        int i = 2131886123;
        if (exc instanceof DogParentInvitationException_InvitationDoesNotExist) {
            n.e(context.getString(i), str);
        } else {
            z = exc instanceof DogParentInvitationException_InvitationHasExpired;
            if (exc instanceof DogParentInvitationException_InvitationHasExpired) {
                str5 = "context.getString(R.string.message_dog_invitation_expired)";
                n.e(context.getString(2131886889), str5);
            } else {
                z = exc instanceof DogParentInvitationException_DogIsAlreadyAdded;
                i2 = 0;
                if (z) {
                    Object[] arr = new Object[1];
                    exc = z ? (DogParentInvitationException_DogIsAlreadyAdded)exc : 0;
                    if (i2 != 0) {
                        str2 = i2.a();
                    }
                    str5 = "context.getString(R.string.invite_parent_dog_already_on_list_text, (exception as? DogParentInvitationException.DogIsAlreadyAdded)?.dogName)";
                    n.e(context.getString(2131886790, new Object[] { str2 }), str5);
                } else {
                    z = (z ? (DogParentInvitationException_DogIsAlreadyAdded)exc : 0) instanceof DogParentInvitationException_DogIsDeleted;
                    if (exc instanceof DogParentInvitationException_DogIsDeleted) {
                        str5 = "context.getString(R.string.message_dog_doesnt_exists)";
                        n.e(context.getString(2131886888), str5);
                    } else {
                        z = exc instanceof DogExceptions_NameIsTooShort;
                        str3 = "context.getString(R.string.user_profile_name_alert)";
                        int i3 = 2131887645;
                        if (exc instanceof DogExceptions_NameIsTooShort) {
                            n.e(context.getString(i3), str3);
                        } else {
                            z = exc instanceof DogExceptions_NameIsTooLong;
                            if (exc instanceof DogExceptions_NameIsTooLong) {
                                str5 = "context.getString(R.string.dog_name_too_long)";
                                n.e(context.getString(2131886467), str5);
                            } else {
                                z = exc instanceof CouponExceptions_EmptyCode;
                                if (exc instanceof CouponExceptions_EmptyCode) {
                                    n.e(context.getString(i3), str3);
                                } else {
                                    z = exc instanceof CouponExceptions_AlreadyUsed;
                                    if (exc instanceof CouponExceptions_AlreadyUsed) {
                                        str5 = "context.getString(R.string.redeem_code_used)";
                                        n.e(context.getString(2131887179), str5);
                                    } else {
                                        z = exc instanceof CouponExceptions_DoesNotExists;
                                        if (exc instanceof CouponExceptions_DoesNotExists) {
                                            str5 = "context.getString(R.string.redeem_code_does_not_exist)";
                                            n.e(context.getString(2131887176), str5);
                                        } else {
                                            z = exc instanceof CouponExceptions_AlreadyPremium;
                                            if (exc instanceof CouponExceptions_AlreadyPremium) {
                                                str5 = "context.getString(R.string.redeem_code_already_premium)";
                                                n.e(context.getString(2131887175), str5);
                                            } else {
                                                z = exc instanceof FirebaseAuthException;
                                                if (exc instanceof FirebaseAuthException) {
                                                    if (exc.getLocalizedMessage() == null) {
                                                        n.e(context.getString(i), str);
                                                    }
                                                } else {
                                                    z = (FirebaseAuthException)exc instanceof UnknownHostException;
                                                    str3 = "context.getString(R.string.no_internet_connection)";
                                                    i3 = 2131886953;
                                                    if (exc instanceof UnknownHostException) {
                                                        n.e(context.getString(i3), str3);
                                                    } else {
                                                        z = exc instanceof NetworkExceptions_BlankTokenException;
                                                        if (exc instanceof NetworkExceptions_BlankTokenException) {
                                                            n.e(context.getString(i3), str3);
                                                        } else {
                                                            z = exc instanceof FirebaseRemoteConfigClientException;
                                                            str4 = "context.getString(R.string.error_google_play_services)";
                                                            int i4 = 2131886507;
                                                            if (exc instanceof FirebaseRemoteConfigClientException) {
                                                                n.e(context.getString(i4), str4);
                                                            } else {
                                                                z = exc instanceof FirebaseNetworkException;
                                                                if (exc instanceof FirebaseNetworkException) {
                                                                    n.e(context.getString(i3), str3);
                                                                } else {
                                                                    z = exc instanceof FirebaseException;
                                                                    if (exc instanceof FirebaseException) {
                                                                        n.e(context.getString(i4), str4);
                                                                    } else {
                                                                        z = exc instanceof RuntimeExecutionException;
                                                                        if (exc instanceof RuntimeExecutionException) {
                                                                            n.e(context.getString(i4), str4);
                                                                        } else {
                                                                            z = exc instanceof DatabaseError;
                                                                            if (exc instanceof DatabaseError) {
                                                                                n.e(context.getString(i4), str4);
                                                                            } else {
                                                                                z = exc instanceof FirebaseRemoteConfigFetchThrottledException;
                                                                                if (exc instanceof FirebaseRemoteConfigFetchThrottledException) {
                                                                                    n.e(context.getString(i3), str3);
                                                                                } else {
                                                                                    z = exc instanceof FirebaseRemoteConfigServerException;
                                                                                    if (exc instanceof FirebaseRemoteConfigServerException) {
                                                                                        n.e(context.getString(i4), str4);
                                                                                    } else {
                                                                                        z = exc instanceof TimeoutException;
                                                                                        if (exc instanceof TimeoutException) {
                                                                                            str5 = "context.getString(R.string.error_change_network)";
                                                                                            n.e(context.getString(2131886505), str5);
                                                                                        } else {
                                                                                            if (exc instanceof VimeoError) {
                                                                                                if (exc.getHttpStatusCode() == -1) {
                                                                                                    localizedMessage = context.getString(i3);
                                                                                                } else {
                                                                                                    localizedMessage = context.getString(i);
                                                                                                }
                                                                                                str5 = "if (exception.httpStatusCode == -1) context.getString(R.string.no_internet_connection) else context.getString(R.string.alert_something_failed)";
                                                                                                n.e(localizedMessage, str5);
                                                                                            } else {
                                                                                                z = (VimeoError)exc instanceof RuntimeException;
                                                                                                if (exc instanceof RuntimeException) {
                                                                                                    Throwable exc2 = exc.getCause();
                                                                                                    z = exc2 instanceof Exception;
                                                                                                    if (exc2 instanceof Exception) {
                                                                                                    }
                                                                                                    localizedMessage = i(exc4, context);
                                                                                                } else {
                                                                                                    if (exc != null) {
                                                                                                        Throwable exc3 = exc.getCause();
                                                                                                        z = exc3 instanceof Exception;
                                                                                                        if (exc3 instanceof Exception) {
                                                                                                        }
                                                                                                        localizedMessage = i(exc5, context);
                                                                                                    } else {
                                                                                                        n.e(context.getString(i), str);
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return localizedMessage;
    }


    /* renamed from: T, reason: from kotlin metadata */
    private static final boolean convertIntegerToTimeString(View value) {
        return true;
    }

    /* renamed from: n, reason: from kotlin metadata */
    private static final boolean convertTimeStringToInteger(View value) {
        return true;
    }

    public static /* synthetic */ void o(ImageView imageView, OneTenRadioGroup oneTenRadioGroup, Button button, RadioGroup radioGroup, int i) {
        BindingAdapters.d0(imageView, oneTenRadioGroup, button, radioGroup, i);
    }

    public static /* synthetic */ void p(VideoView videoView, MediaController mediaController, MediaPlayer mediaPlayer) {
        BindingAdapters.q0(videoView, mediaController, mediaPlayer);
    }

    public static /* synthetic */ boolean q(View view, MotionEvent motionEvent) {
        return BindingAdapters.S(view, motionEvent);
    }

    /* renamed from: r, reason: from kotlin metadata */
    public static /* synthetic */ boolean animateUpdateProgress(View progress) {
        return BindingAdapters.convertIntegerToTimeString(progress);
    }

    public static /* synthetic */ WindowInsets s(View view, View view2, WindowInsets windowInsets) {
        BindingAdapters.l0(view, view2, windowInsets);
        return windowInsets;
    }

    public static /* synthetic */ WindowInsets t(SwipeRefreshLayout swipeRefreshLayout, View view, WindowInsets windowInsets) {
        BindingAdapters.setTextAnimation(swipeRefreshLayout, view, windowInsets);
        return windowInsets;
    }

    public static /* synthetic */ boolean u(View view, MotionEvent motionEvent) {
        return BindingAdapters.m(view, motionEvent);
    }

    /* renamed from: v, reason: from kotlin metadata */
    public static /* synthetic */ boolean changeFontFamily(View fontFamily) {
        return BindingAdapters.convertTimeStringToInteger(fontFamily);
    }
}
