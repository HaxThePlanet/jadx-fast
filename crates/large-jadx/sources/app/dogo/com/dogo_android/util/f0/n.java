package app.dogo.com.dogo_android.util.f0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
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
import androidx.core.content.e.f;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.b;
import app.dogo.com.dogo_android.d.c.j.b;
import app.dogo.com.dogo_android.e.k;
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
import app.dogo.com.dogo_android.k.g;
import app.dogo.com.dogo_android.login_v2.c0;
import app.dogo.com.dogo_android.profile.invitation.DogParentInvitationException.DogIsAlreadyAdded;
import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.repository.domain.PermissionDescription;
import app.dogo.com.dogo_android.repository.domain.WorkoutStreakInfo;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.t.g0.j;
import app.dogo.com.dogo_android.t.g0.j.a;
import app.dogo.com.dogo_android.t.h0.i;
import app.dogo.com.dogo_android.t.h0.i.a;
import app.dogo.com.dogo_android.u.n.q.m;
import app.dogo.com.dogo_android.u.n.q.m.a;
import app.dogo.com.dogo_android.util.MyAppGlideModule;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.g0.b;
import app.dogo.com.dogo_android.util.g0.b.b;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.m;
import app.dogo.com.dogo_android.util.n0.m;
import app.dogo.com.dogo_android.util.o;
import app.dogo.com.dogo_android.util.p;
import app.dogo.com.dogo_android.util.v;
import app.dogo.com.dogo_android.util.x;
import app.dogo.com.dogo_android.util.x.a;
import app.dogo.com.dogo_android.view.compat.a;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.o3.a;
import app.dogo.com.dogo_android.y.y.i;
import com.bumptech.glide.c;
import com.bumptech.glide.j;
import com.bumptech.glide.k;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.load.n.e.d;
import com.bumptech.glide.r.a;
import com.bumptech.glide.r.f;
import com.bumptech.glide.r.g;
import com.bumptech.glide.r.k.h;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.chip.ChipGroup.d;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.vimeo.networking.model.error.VimeoError;
import d.a.k.a.a;
import d.h.l.x;
import d.n.a.a.b;
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
import kotlin.j0.h;
import kotlin.j0.i;
import kotlin.k0.l;
import kotlin.w;
import kotlin.y.p;
import n.a.a;
import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.b;
import nl.dionsegijn.konfetti.e.b.a;
import nl.dionsegijn.konfetti.e.b.c;
import nl.dionsegijn.konfetti.e.c;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000î\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010!\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0016\u0008Æ\u0002\u0018\u00002\u00020\u0001:\u0002Á\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0002J\u0008\u0010\u000b\u001a\u00020\nH\u0002J\u0019\u0010\u000c\u001a\u0004\u0018\u00010\u00082\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0002\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u000e2\u0008\u0010\r\u001a\u0004\u0018\u00010\u0008H\u0007¢\u0006\u0002\u0010\u0011J$\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u00132\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0016\u001a\u00020\u000eH\u0002J \u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000eH\u0002J\u001e\u0010\u001b\u001a\u00020\u000e2\u000e\u0010\u001c\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001e2\u0006\u0010\u001f\u001a\u00020 J\u001a\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020#2\u0008\u0010$\u001a\u0004\u0018\u00010\u000eH\u0007J&\u0010%\u001a\u00020\u0004*\u00020&2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00082\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0002J\u001b\u0010'\u001a\u00020\u0004*\u00020(2\u0008\u0010)\u001a\u0004\u0018\u00010\u0008H\u0007¢\u0006\u0002\u0010*J\u0016\u0010+\u001a\u00020\u0004*\u00020&2\u0008\u0010,\u001a\u0004\u0018\u00010-H\u0007J \u0010.\u001a\u00020\u000e*\u00020&2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\u0008\u0008\u0002\u0010/\u001a\u00020\u0008H\u0002J\u0014\u00100\u001a\u00020\u0004*\u0002012\u0006\u00102\u001a\u00020\u000eH\u0007J\u0016\u00103\u001a\u00020\u0004*\u00020#2\u0008\u0010$\u001a\u0004\u0018\u00010\u000eH\u0007J\u0014\u00104\u001a\u00020\u0004*\u00020#2\u0006\u0010$\u001a\u00020\u000eH\u0007J\u0016\u00105\u001a\u00020\u0004*\u00020#2\u0008\u00106\u001a\u0004\u0018\u000107H\u0007J5\u00108\u001a\u00020\u0004*\u0002092\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010:\u001a\u00020&2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\u0008\u0010;\u001a\u0004\u0018\u00010\u0008H\u0007¢\u0006\u0002\u0010<J&\u00108\u001a\u00020\u0004*\u00020=2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010:\u001a\u00020&2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0007J\u0016\u0010>\u001a\u00020\u0004*\u00020&2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0007J\u0014\u0010?\u001a\u00020\u0004*\u0002092\u0006\u0010@\u001a\u00020\u0008H\u0007J\u0016\u0010A\u001a\u00020\u0004*\u00020&2\u0008\u0010B\u001a\u0004\u0018\u00010\u000eH\u0007J\u0016\u0010C\u001a\u00020\u0004*\u00020D2\u0008\u0010E\u001a\u0004\u0018\u00010\u000eH\u0007J\u001b\u0010F\u001a\u00020\u0004*\u00020#2\u0008\u0010G\u001a\u0004\u0018\u00010HH\u0007¢\u0006\u0002\u0010IJ\u001b\u0010J\u001a\u00020\u0004*\u00020#2\u0008\u0010K\u001a\u0004\u0018\u00010HH\u0007¢\u0006\u0002\u0010IJ\u0014\u0010L\u001a\u00020\u0004*\u00020&2\u0006\u0010M\u001a\u00020NH\u0007J\u001c\u0010O\u001a\u00020\u0004*\u00020P2\u000e\u0010Q\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010\u0013H\u0007J,\u0010S\u001a\u00020\u0004*\u00020P2\u0014\u0010T\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020V0\u0013\u0018\u00010U2\u0008\u0010W\u001a\u0004\u0018\u00010XH\u0007J\u0016\u0010Y\u001a\u00020\u0004*\u00020&2\u0008\u0010Z\u001a\u0004\u0018\u00010VH\u0007J&\u0010[\u001a\u00020\u0004*\u00020P2\u000e\u0010T\u001a\n\u0012\u0004\u0012\u00020\\\u0018\u00010\u00132\u0008\u0010W\u001a\u0004\u0018\u00010]H\u0007J\u001b\u0010^\u001a\u00020\u0004*\u00020#2\u0008\u0010_\u001a\u0004\u0018\u00010\u0008H\u0007¢\u0006\u0002\u0010`J\u001b\u0010^\u001a\u00020\u0004*\u00020a2\u0008\u0010_\u001a\u0004\u0018\u00010\u0008H\u0007¢\u0006\u0002\u0010bJ>\u0010c\u001a\u00020\u0004*\u00020P2\u0014\u0010T\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00140\u0013\u0018\u00010U2\u0008\u0010d\u001a\u0004\u0018\u00010e2\u0006\u0010f\u001a\u00020g2\u0008\u0008\u0001\u0010h\u001a\u00020\u0008H\u0007J\u001b\u0010i\u001a\u00020\u0004*\u00020&2\u0008\u0010j\u001a\u0004\u0018\u00010kH\u0007¢\u0006\u0002\u0010lJ\u0014\u0010m\u001a\u00020\u0004*\u00020g2\u0006\u0010n\u001a\u00020\u0008H\u0007J\u0014\u0010o\u001a\u00020\u0004*\u00020&2\u0006\u0010p\u001a\u00020qH\u0007J\u0014\u0010r\u001a\u00020\u0004*\u0002012\u0006\u00102\u001a\u00020\u000eH\u0007J\u0016\u0010s\u001a\u00020\u0004*\u00020#2\u0008\u0010$\u001a\u0004\u0018\u00010\u000eH\u0007J\u001b\u0010t\u001a\u00020\u0004*\u00020&2\u0008\u0010\r\u001a\u0004\u0018\u00010kH\u0007¢\u0006\u0002\u0010lJ\u001b\u0010t\u001a\u00020\u0004*\u00020u2\u0008\u0010\r\u001a\u0004\u0018\u00010kH\u0007¢\u0006\u0002\u0010vJ\u0014\u0010w\u001a\u00020\u0004*\u00020x2\u0006\u0010y\u001a\u00020zH\u0007J0\u0010{\u001a\u00020\u0004*\u00020P2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00132\u0008\u0010d\u001a\u0004\u0018\u00010|2\u0008\u0010}\u001a\u0004\u0018\u00010\u000eH\u0007J\u001b\u0010~\u001a\u00020\u0004*\u00020\u007f2\r\u0010\u0080\u0001\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010UH\u0007J\u001f\u0010\u0081\u0001\u001a\u00020\u0004*\u00030\u0082\u00012\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010HH\u0007¢\u0006\u0003\u0010\u0084\u0001J\u001f\u0010\u0085\u0001\u001a\u00020\u0004*\u00030\u0086\u00012\u0006\u0010\"\u001a\u00020#2\u0007\u0010\u0087\u0001\u001a\u00020\u007fH\u0007J\u0017\u0010\u0088\u0001\u001a\u00020\u0004*\u00030\u0089\u00012\u0007\u0010;\u001a\u00030\u008a\u0001H\u0007J(\u0010\u008b\u0001\u001a\u00020\u0004*\u00020P2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020k\u0018\u00010\u00132\t\u0010d\u001a\u0005\u0018\u00010\u008c\u0001H\u0007J\u0016\u0010\u008d\u0001\u001a\u00020\u0004*\u0002092\u0007\u0010\u008e\u0001\u001a\u00020&H\u0007J\u0017\u0010\u008f\u0001\u001a\u00020\u0004*\u00020#2\u0008\u0010$\u001a\u0004\u0018\u00010\u000eH\u0007J'\u0010\u0090\u0001\u001a\u00020\u0004*\u00020&2\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0007J\u001c\u0010\u0091\u0001\u001a\u00020\u0004*\u00020#2\u0008\u0010@\u001a\u0004\u0018\u00010\u0008H\u0007¢\u0006\u0002\u0010`J\u0017\u0010\u0092\u0001\u001a\u00020\u0004*\u00020#2\u0008\u0010E\u001a\u0004\u0018\u00010\u000eH\u0007J\u001e\u0010\u0093\u0001\u001a\u00020\u0004*\u0002092\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010HH\u0007¢\u0006\u0003\u0010\u0094\u0001J\"\u0010\u0095\u0001\u001a\u00020\u0004*\u00020#2\u0008\u0010$\u001a\u0004\u0018\u00010\u000e2\t\u0010\u0096\u0001\u001a\u0004\u0018\u000107H\u0007J\u0017\u0010\u0097\u0001\u001a\u00020\u0004*\u00020#2\u0008\u0010$\u001a\u0004\u0018\u00010\u000eH\u0007J\u0017\u0010\u0098\u0001\u001a\u00020\u0004*\u0002092\u0008\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0007J \u0010\u009b\u0001\u001a\u00020\u0004*\u00020x2\u0008\u0010\u009c\u0001\u001a\u00030\u009d\u00012\u0007\u0010\u009e\u0001\u001a\u00020\u000eH\u0007J\u001d\u0010\u009f\u0001\u001a\u00020\u0004*\u00020&2\u000e\u0010 \u0001\u001a\t\u0012\u0004\u0012\u00020H0¡\u0001H\u0007J)\u0010¢\u0001\u001a\u00020\u0004*\u00020P2\t\u0010£\u0001\u001a\u0004\u0018\u00010\u00082\t\u0010d\u001a\u0005\u0018\u00010¤\u0001H\u0007¢\u0006\u0003\u0010¥\u0001J\u0017\u0010¦\u0001\u001a\u00020\u0004*\u0002092\u0008\u0010§\u0001\u001a\u00030¨\u0001H\u0007J\u001e\u0010©\u0001\u001a\u00020\u0004*\u00020\u00062\u000f\u0010ª\u0001\u001a\n\u0012\u0004\u0012\u00020H\u0018\u00010\u0013H\u0007J\u0018\u0010«\u0001\u001a\u00020\u0004*\u00020&2\t\u0010d\u001a\u0005\u0018\u00010¬\u0001H\u0007J\u001b\u0010­\u0001\u001a\u00020\u0004*\u0002092\u000c\u0010T\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010UH\u0007J\u001b\u0010®\u0001\u001a\u00020\u0004*\u0002092\u000c\u0010T\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010UH\u0007J\u001c\u0010¯\u0001\u001a\u00020\u0004*\u00030\u0082\u00012\u000c\u0010T\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010UH\u0007J\u001b\u0010°\u0001\u001a\u00020\u0004*\u0002092\u000c\u0010T\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010UH\u0007J+\u0010°\u0001\u001a\u00020\u0004*\u00020&2\r\u0010±\u0001\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010U2\r\u0010²\u0001\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010UH\u0007J\u0016\u0010³\u0001\u001a\u00020\u0004*\u00020#2\u0007\u0010´\u0001\u001a\u00020\u000eH\u0007J\u001b\u0010µ\u0001\u001a\u00020\u0004*\u0002092\u000c\u0010T\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010UH\u0007J\u001b\u0010¶\u0001\u001a\u00020\u0004*\u0002092\u000c\u0010T\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010UH\u0007J:\u0010·\u0001\u001a\u00020\u0004*\u0002092\r\u0010¸\u0001\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010U2\r\u0010¹\u0001\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010U2\r\u0010º\u0001\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010UH\u0007J\u001b\u0010»\u0001\u001a\u00020\u0004*\u0002092\u000c\u0010T\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010UH\u0007J\u001b\u0010¼\u0001\u001a\u00020\u0004*\u0002092\u000c\u0010T\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010UH\u0007J\u001b\u0010½\u0001\u001a\u00020\u0004*\u0002092\u000c\u0010T\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010UH\u0007J\u001b\u0010¾\u0001\u001a\u00020\u0004*\u0002092\u000c\u0010T\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010UH\u0007J\u001e\u0010¿\u0001\u001a\u00020\u0004*\u0002092\t\u0010À\u0001\u001a\u0004\u0018\u00010HH\u0007¢\u0006\u0003\u0010\u0094\u0001¨\u0006Â\u0001", d2 = {"Lapp/dogo/com/dogo_android/util/binding/BindingAdapters;", "", "()V", "animateArrow", "", "triangleView", "Landroid/view/ViewGroup;", "indexOfChild", "", "animObj", "Landroid/view/animation/AlphaAnimation;", "buildRatingAnimation", "convertIntegerToTimeString", "value", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "convertTimeStringToInteger", "(Ljava/lang/Integer;)Ljava/lang/String;", "faqFilter", "", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "list", "filterText", "getChangingRatingText", "resources", "Landroid/content/res/Resources;", "dogName", "getMessageFromException", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "context", "Landroid/content/Context;", "loadNonCchedImage", "imageView", "Landroid/widget/ImageView;", "imageUrl", "animateRatingText", "Landroid/widget/TextView;", "animateUpdateProgress", "Landroid/widget/ProgressBar;", "progress", "(Landroid/widget/ProgressBar;Ljava/lang/Integer;)V", "changeFontFamily", "fontFamily", "Lapp/dogo/com/dogo_android/enums/FontFamily;", "getShortDogName", "maxNameLength", "htmlTextForPolicy", "Landroid/webkit/WebView;", "descriptionText", "loadImageAndHideBackground", "loadImageUrlNoSpinner", "makeImageCircular", "image", "Landroid/graphics/drawable/Drawable;", "setAdapter", "Landroid/view/View;", "textWithAnimation", "knowledge", "(Landroid/view/View;Landroid/view/ViewGroup;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/Integer;)V", "Lcom/google/android/material/chip/ChipGroup;", "setAddNewString", "setBackgroundColor", "color", "setBulletPoint", "string", "setColorFromHex", "Landroidx/cardview/widget/CardView;", "hexCode", "setCompatDrawableDelete", "currentUserEntriesAuthor", "", "(Landroid/widget/ImageView;Ljava/lang/Boolean;)V", "setCompatDrawableWinner", "isWinner", "setCompletionLongestStreakText", "workoutSession", "Lapp/dogo/com/dogo_android/repository/domain/WorkoutStreakInfo;", "setDebugExperimentValues", "Landroidx/recyclerview/widget/RecyclerView;", "items", "Lapp/dogo/com/dogo_android/repository/domain/PermissionDescription;", "setDebugFeatureListAdapter", "result", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureItem;", "callBacks", "Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$Callbacks;", "setDebugItemCurrentValue", "item", "setDebugJsonEntryItemAdapter", "Lapp/dogo/com/dogo_android/debug/JsonArrayEditItem;", "Lapp/dogo/com/dogo_android/debug/JsonArrayEditAdapter$Callbacks;", "setDrawableRes", "res", "(Landroid/widget/ImageView;Ljava/lang/Integer;)V", "Lcom/google/android/material/chip/Chip;", "(Lcom/google/android/material/chip/Chip;Ljava/lang/Integer;)V", "setFaqSearchAdapter", "callback", "Lapp/dogo/com/dogo_android/settings/faq/FaqRecyclerViewAdapter$Callbacks;", "searchBox", "Landroid/widget/EditText;", "headerViewRes", "setFeedbackCardDate", "timestamp", "", "(Landroid/widget/TextView;Ljava/lang/Long;)V", "setFilterMax", "maxValue", "setFormattedChallengeNotificationDogName", "notificationItem", "Lapp/dogo/com/dogo_android/challenge/notificationcenter/notificationlist/ChallengeNotificationItemModel;", "setHtmlText", "setImageAsGrayscale", "setIntervalSelectorString", "Lcom/google/android/material/button/MaterialButton;", "(Lcom/google/android/material/button/MaterialButton;Ljava/lang/Long;)V", "setKonfetti", "Landroidx/constraintlayout/widget/ConstraintLayout;", "konfettiView", "Lnl/dionsegijn/konfetti/KonfettiView;", "setLanguageSelectAdapter", "Lapp/dogo/com/dogo_android/settings/language/LanguageSelectAdapter$Callbacks;", "currentLanguage", "setLoadingButton", "Landroid/widget/Button;", "results", "setProgressBarOffsetBasedOnStatusBar", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "bool", "(Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;Ljava/lang/Boolean;)V", "setRatingChange", "Lapp/dogo/com/dogo_android/inappmessaging/OneTenRadioGroup;", "submitButton", "setRatingMin1", "Lapp/dogo/com/dogo_android/view/compat/GlobalRatingBarMin1Star;", "", "setReminderIntervalSelectAdapter", "Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalAdapter$Callbacks;", "setShareDialogTitleView", "textView", "setSpinner", "setTextAnimation", "setTintBinding", "setTintFromHex", "setTopPaddingAsStatusBarHeight", "(Landroid/view/View;Ljava/lang/Boolean;)V", "setTrainerAvatar", "fallbackImage", "setTrickCircleImage", "setUtilAnimation", "anim", "Landroid/view/animation/Animation;", "setVideoView", "video", "Landroid/widget/VideoView;", "videoLink", "setWeekdayString", "days", "", "setupClickerSelect", "currentClickerSoundId", "Lapp/dogo/com/dogo_android/clicker/ClickerSelectAdapter$Callbacks;", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/lang/Integer;Lapp/dogo/com/dogo_android/clicker/ClickerSelectAdapter$Callbacks;)V", "setupFab", "fab", "Lapp/dogo/com/dogo_android/databinding/LayoutCustomFabBinding;", "setupReminderWeekdayBoxes", "dayStatusList", "setupTermsAndServices", "Lapp/dogo/com/dogo_android/login_v2/TermsAndServiceCallback;", "showAfterFirstSuccessfulDataLoad", "showErrorToast", "showLoad", "showLoading", "loginResults", "restorePurchaseResults", "showRawGif", "fileName", "showRetry", "showSmoothLoading", "showSmoothMultiLoading", "result1", "result2", "result3", "showSnackbar", "showSnackbarForView", "smoothHideAfterFirstSuccessfulDataLoad", "smoothShowAfterFirstSuccessfulDataLoad", "visibilityBindingSetup", "visible", "ChipGroupBindingAdapter", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class n {

    public static final app.dogo.com.dogo_android.util.f0.n a;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0008\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004", d2 = {"Lapp/dogo/com/dogo_android/util/binding/BindingAdapters$ChipGroupBindingAdapter;", "", "()V", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {

        public static final app.dogo.com.dogo_android.util.f0.n.a.a Companion;
        static {
            n.a.a aVar = new n.a.a(0);
            n.a.Companion = aVar;
        }

        public static final void a(ChipGroup chipGroup, int i2) {
            n.a.Companion.b(chipGroup, i2);
        }

        public static final void b(ChipGroup chipGroup, ChipGroup.d chipGroup$d2, g g3) {
            n.a.Companion.c(chipGroup, d2, g3);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class b {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[g.ROBOTO.ordinal()] = 1;
            iArr[g.ROBOTO_BOLD.ordinal()] = 2;
            iArr[g.ROBOTO_MEDIUM.ordinal()] = 3;
            iArr[g.MONTSERRAT_BOLD.ordinal()] = 4;
            iArr[g.MONTSERRAT_EXTRA_BOLD.ordinal()] = 5;
            iArr[g.MONTSERRAT_SEMI_BOLD.ordinal()] = 6;
            n.b.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000c\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0010", d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", "start", "", "count", "after", "onTextChanged", "before", "core-ktx_release", "androidx/core/widget/TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d implements TextWatcher {

        final RecyclerView a;
        final y b;
        public d(RecyclerView recyclerView, y y2) {
            this.a = recyclerView;
            this.b = y2;
            super();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(java.lang.CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(java.lang.CharSequence charSequence, int i2, int i3, int i4) {
            String str;
            List obj2;
            int obj3;
            app.dogo.com.dogo_android.util.f0.n obj4;
            Object obj5;
            if (charSequence != null) {
                this.a.q1(0);
                if (obj3 instanceof j) {
                } else {
                    obj3 = 0;
                }
                if (obj3 == null) {
                } else {
                    obj2 = charSequence.toString();
                    Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.CharSequence");
                    obj3.j(n.a(n.a, (List)(y.c)this.b.a(), l.a1(obj2).toString()));
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t", d2 = {"app/dogo/com/dogo_android/util/binding/BindingAdapters$setupTermsAndServices$privacyClickSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "textView", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class f extends ClickableSpan {

        final c0 a;
        f(c0 c0) {
            this.a = c0;
            super();
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            n.f(view, "textView");
            this.a.G();
        }

        @Override // android.text.style.ClickableSpan
        public void updateDrawState(TextPaint textPaint) {
            n.f(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(true);
        }
    }

    @Metadata(d1 = "\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t", d2 = {"app/dogo/com/dogo_android/util/binding/BindingAdapters$setupTermsAndServices$termsClickSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "textView", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class g extends ClickableSpan {

        final c0 a;
        g(c0 c0) {
            this.a = c0;
            super();
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            n.f(view, "textView");
            this.a.q0();
        }

        @Override // android.text.style.ClickableSpan
        public void updateDrawState(TextPaint textPaint) {
            n.f(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(true);
        }
    }

    @Metadata(d1 = "\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J6\u0010\u0003\u001a\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0010\u0010\t\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J@\u0010\u000c\u001a\u00020\u00042\u0008\u0010\r\u001a\u0004\u0018\u00010\u00022\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0010\u0010\t\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\n2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\u0010", d2 = {"app/dogo/com/dogo_android/util/binding/BindingAdapters$loadImageAndHideBackground$1", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "onLoadFailed", "", "e", "Lcom/bumptech/glide/load/engine/GlideException;", "model", "", "target", "Lcom/bumptech/glide/request/target/Target;", "isFirstResource", "onResourceReady", "resource", "dataSource", "Lcom/bumptech/glide/load/DataSource;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c implements f<Drawable> {

        final ImageView a;
        c(ImageView imageView) {
            this.a = imageView;
            super();
        }

        public boolean a(Drawable drawable, Object object2, h<Drawable> h3, a a4, boolean z5) {
            this.a.setBackground(0);
            return 0;
        }

        public boolean onLoadFailed(GlideException glideException, Object object2, h<Drawable> h3, boolean z4) {
            return 0;
        }

        @Override // com.bumptech.glide.r.f
        public boolean onResourceReady(Object object, Object object2, h h3, a a4, boolean z5) {
            return a((Drawable)object, object2, h3, a4, z5);
        }
    }

    @Metadata(d1 = "\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001J0\u0010\u0003\u001a\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J6\u0010\u000c\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00082\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\u0010", d2 = {"app/dogo/com/dogo_android/util/binding/BindingAdapters$setTrickCircleImage$1", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "onLoadFailed", "", "e", "Lcom/bumptech/glide/load/engine/GlideException;", "model", "", "target", "Lcom/bumptech/glide/request/target/Target;", "isFirstResource", "onResourceReady", "resource", "dataSource", "Lcom/bumptech/glide/load/DataSource;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class e implements f<Drawable> {

        final ImageView a;
        e(ImageView imageView) {
            this.a = imageView;
            super();
        }

        public boolean a(Drawable drawable, Object object2, h<Drawable> h3, a a4, boolean z5) {
            n.f(drawable, "resource");
            n.f(object2, "model");
            n.f(h3, "target");
            n.f(a4, "dataSource");
            this.a.setBackground(0);
            return 0;
        }

        public boolean onLoadFailed(GlideException glideException, Object object2, h<Drawable> h3, boolean z4) {
            n.f(object2, "model");
            n.f(h3, "target");
            return 0;
        }

        @Override // com.bumptech.glide.r.f
        public boolean onResourceReady(Object object, Object object2, h h3, a a4, boolean z5) {
            return a((Drawable)object, object2, h3, a4, z5);
        }
    }
    static {
        n nVar = new n();
        n.a = nVar;
    }

    public static final void A(View view, ViewGroup viewGroup2, TextView textView3, String string4, Integer integer5) {
        Object str;
        int i;
        Object obj2;
        Object obj4;
        n.f(view, "<this>");
        n.f(viewGroup2, "triangleView");
        n.f(textView3, "textWithAnimation");
        if (integer5 != null) {
            obj2 = n.a;
            str = obj2.e();
            obj2.c(textView3, str, intValue--, string4);
            obj2.b(viewGroup2, obj4--, str);
        }
    }

    public static final void A0(TextView textView, y<?> y2, y<?> y3) {
        String obj2;
        int obj3;
        n.f(textView, "<this>");
        if (y2 instanceof y.b) {
            if (y3 instanceof y.b) {
                obj2 = textView.getResources().getString(2131887240);
            } else {
                obj2 = textView.getResources().getString(2131887110);
            }
            textView.setText(obj2);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
    }

    public static final void B(TextView textView, String string2) {
        Object stringBuilder;
        String str;
        int i;
        Object obj4;
        n.f(textView, "<this>");
        if (string2 != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(textView.getResources().getString(2131887111));
            stringBuilder.append(" : ");
            stringBuilder.append(string2);
            textView.setText(stringBuilder.toString());
        }
    }

    public static final void B0(ImageView imageView, String string2) {
        n.f(imageView, "<this>");
        n.f(string2, "fileName");
        (j)c.t(imageView.getContext()).k(Integer.valueOf(imageView.getContext().getResources().getIdentifier(string2, "raw", imageView.getContext().getPackageName()))).f(j.a).C0(imageView);
    }

    public static final void C(View view, int i2) {
        n.f(view, "<this>");
        if (i2 == 0) {
        }
        view.setBackgroundColor(view.getResources().getColor(i2, 0));
    }

    public static final void C0(View view, y<?> y2) {
        int obj2;
        n.f(view, "<this>");
        obj2 = y2 instanceof y.a ? 0 : 8;
        view.setVisibility(obj2);
    }

    public static final void D(TextView textView, String string2) {
        Object spannableString;
        BulletSpan bulletSpan;
        int i;
        int i2;
        Object obj5;
        n.f(textView, "<this>");
        if (string2 == null) {
        } else {
            spannableString = new SpannableString(string2);
            bulletSpan = new BulletSpan((int)dimension, textView.getTextColors().getDefaultColor());
            spannableString.setSpan(bulletSpan, 0, l.Y(string2), 33);
            obj5 = w.a;
            textView.setText(spannableString);
        }
    }

    public static final void D0(View view, y<?> y2) {
        Object obj2;
        n.f(view, "<this>");
        TransitionManager.beginDelayedTransition((ViewGroup)view);
        view.setVisibility(8);
        if (y2 instanceof y.b) {
        } else {
            obj2 = 0;
        }
        if (obj2 == null) {
        } else {
            view.setVisibility(0);
        }
    }

    public static final void E(CardView cardView, String string2) {
        String str;
        int i;
        java.lang.CharSequence obj3;
        n.f(cardView, "<this>");
        if (string2 != null) {
            if (z ^= 1 != 0) {
                cardView.setCardBackgroundColor(Color.parseColor(string2));
            } else {
                cardView.setCardBackgroundColor(-65536);
            }
        }
    }

    public static final void E0(View view, y<?> y2, y<?> y3, y<?> y4) {
        int obj2;
        n.f(view, "<this>");
        int i = 0;
        if (!y2 instanceof y.b && !y3 instanceof y.b) {
            if (!y3 instanceof y.b) {
                if (y4 instanceof y.b) {
                    obj2 = 1;
                } else {
                    obj2 = i;
                }
            } else {
            }
        } else {
        }
        view.setVisibility(8);
        if (obj2 != null) {
            view.setVisibility(i);
        }
    }

    public static final void F(ImageView imageView, Boolean boolean2) {
        int i;
        Drawable obj2;
        n.f(imageView, "<this>");
        if (n.b(boolean2, Boolean.TRUE)) {
            imageView.setImageDrawable(a.d(imageView.getContext(), 2131231339));
        } else {
            imageView.setImageDrawable(a.d(imageView.getContext(), 2131231141));
        }
    }

    public static final void F0(View view, y<?> y2) {
        int i;
        Context context;
        String str;
        Object obj3;
        int obj4;
        n.f(view, "<this>");
        if (y2 instanceof y.a) {
        } else {
            obj4 = 0;
        }
        if (obj4 == null) {
        } else {
            obj4 = obj4.a();
            if (obj4 == null) {
            } else {
                o3.Companion.a(obj4);
                context = view.getContext();
                n.e(context, "context");
                obj3 = Snackbar.e0(view, n.a.i(obj4, context), 0);
                n.e(obj3, "make(this, message, LENGTH_LONG)");
                j1.A0(obj3, 5);
                obj3.T();
            }
        }
    }

    public static final void G(ImageView imageView, Boolean boolean2) {
        int i;
        Drawable obj2;
        n.f(imageView, "<this>");
        if (n.b(boolean2, Boolean.TRUE)) {
            imageView.setImageDrawable(a.d(imageView.getContext(), 2131231366));
        } else {
            imageView.setImageDrawable(a.d(imageView.getContext(), 2131231367));
        }
    }

    public static final void G0(View view, y<?> y2) {
        int i;
        Context context;
        String str;
        int obj4;
        n.f(view, "<this>");
        if (y2 instanceof y.a) {
        } else {
            obj4 = 0;
        }
        if (obj4 == null) {
        } else {
            obj4 = obj4.a();
            if (obj4 == null) {
            } else {
                o3.Companion.a(obj4);
                context = view.getContext();
                n.e(context, "context");
                obj4 = Snackbar.e0(view, n.a.i(obj4, context), 0);
                n.e(obj4, "make(this, message, LENGTH_LONG)");
                j1.A0(obj4, 5);
                obj4.O(view);
                (Snackbar)obj4.T();
            }
        }
    }

    public static final void H(TextView textView, WorkoutStreakInfo workoutStreakInfo2) {
        int i;
        Resources resources;
        int i2;
        Object[] arr;
        int longestStreak;
        String obj6;
        n.f(textView, "<this>");
        n.f(workoutStreakInfo2, "workoutSession");
        int i3 = 1;
        final int i4 = 0;
        i = workoutStreakInfo2.getLongestStreak() == workoutStreakInfo2.getCurrentStreak() ? i3 : i4;
        if (i != 0) {
            arr = new Object[i3];
            arr[i4] = Integer.valueOf(workoutStreakInfo2.getLongestStreak());
            obj6 = textView.getResources().getQuantityString(2131755019, workoutStreakInfo2.getLongestStreak(), arr);
        } else {
            arr = new Object[i3];
            arr[i4] = Integer.valueOf(workoutStreakInfo2.getLongestStreak());
            obj6 = textView.getResources().getQuantityString(2131755020, workoutStreakInfo2.getLongestStreak(), arr);
        }
        textView.setText(obj6);
    }

    public static final void H0(View view, y<?> y2) {
        Object interpolator;
        b bVar;
        int obj4;
        n.f(view, "<this>");
        if (y2 == null) {
            view.setVisibility(0);
            view.setAlpha(1065353216);
        } else {
            if (y2 instanceof y.c) {
                bVar = new b();
                view.animate().alpha(0).setDuration(500).setInterpolator(bVar).start();
            }
        }
    }

    public static final void I(RecyclerView recyclerView, List<PermissionDescription> list2) {
        Object vVar;
        n.f(recyclerView, "<this>");
        if (list2 == null) {
        } else {
            vVar = new v(list2);
            recyclerView.setAdapter(vVar);
        }
    }

    public static final void I0(View view, y<?> y2) {
        Object interpolator;
        b bVar;
        int obj4;
        n.f(view, "<this>");
        if (y2 == null) {
            view.setAlpha(0);
        } else {
            if (y2 instanceof y.c) {
                bVar = new b();
                view.animate().alpha(1065353216).setDuration(500).setInterpolator(bVar).start();
            }
        }
    }

    public static final void J(RecyclerView recyclerView, y<? extends List<? extends m0>> y2, n0.b n0$b3) {
        Object n0Var;
        int i;
        Object obj2;
        n0.b obj4;
        n.f(recyclerView, "<this>");
        if (y2 instanceof y.c) {
            n0Var = y2;
        } else {
            n0Var = i;
        }
        if (n0Var == null) {
        } else {
            if ((List)n0Var.a() == null) {
            } else {
                if (recyclerView.getAdapter() == null) {
                    n0Var = new n0(b3);
                    recyclerView.setAdapter(n0Var);
                }
                obj2 = recyclerView.getAdapter();
                if (obj2 instanceof n0) {
                    i = obj2;
                }
                if (i == 0) {
                } else {
                    i.j((List)(y.c)y2.a());
                }
            }
        }
    }

    public static final void J0(View view, Boolean boolean2) {
        int i;
        int obj2;
        n.f(view, "<this>");
        if (boolean2 == null) {
            obj2 = i;
        } else {
            obj2 = boolean2.booleanValue();
        }
        if (obj2 != null) {
        } else {
            i = 8;
        }
        view.setVisibility(i);
    }

    public static final void K(TextView textView, m0 m02) {
        boolean str;
        String obj3;
        n.f(textView, "<this>");
        if (m02 == null) {
        } else {
            if (m02 instanceof m0.a) {
                obj3 = String.valueOf((m0.a)m02.c());
                textView.setText(obj3);
            } else {
                if (m02 instanceof m0.e) {
                    obj3 = (m0.e)m02.c();
                } else {
                    if (m02 instanceof m0.b) {
                        obj3 = String.valueOf((m0.b)m02.c());
                    } else {
                        if (m02 instanceof m0.d) {
                            obj3 = String.valueOf((m0.d)m02.c());
                        } else {
                            if (!m02 instanceof m0.c) {
                            } else {
                                obj3 = (m0.c)m02.c().toString();
                            }
                        }
                    }
                }
            }
        }
        NoWhenBranchMatchedException obj2 = new NoWhenBranchMatchedException();
        throw obj2;
    }

    public static final void L(RecyclerView recyclerView, List<q0> list2, o0.a o0$a3) {
        Object o0Var;
        n.f(recyclerView, "<this>");
        if (list2 != null && a3 != null && recyclerView.getAdapter() == null) {
            if (a3 != null) {
                if (recyclerView.getAdapter() == null) {
                    o0Var = new o0(list2, a3);
                    recyclerView.setAdapter(o0Var);
                }
            }
        }
    }

    public static final void M(ImageView imageView, Integer integer2) {
        String intValue;
        Drawable obj2;
        n.f(imageView, "<this>");
        if (integer2 != null && integer2.intValue() != 0) {
            if (integer2.intValue() != 0) {
                imageView.setImageDrawable(a.d(imageView.getContext(), integer2.intValue()));
            }
        }
    }

    public static final void N(RecyclerView recyclerView, y<? extends List<Article>> y2, j.a j$a3, EditText editText4, int i5) {
        int i;
        int i2;
        Animation obj3;
        Object obj4;
        boolean obj5;
        int obj6;
        n.f(recyclerView, "<this>");
        n.f(editText4, "searchBox");
        if (y2 instanceof y.c) {
            obj6 = editText4.getText().toString();
            Objects.requireNonNull(obj6, "null cannot be cast to non-null type kotlin.CharSequence");
            j jVar = new j(a3);
            jVar.j(n.a.g((List)(y.c)y2.a(), l.a1(obj6).toString()));
            obj4 = w.a;
            recyclerView.setAdapter(jVar);
            obj6 = recyclerView.getContext();
            n.e(obj6, "context");
            obj4 = new m(obj6, (int)dimension);
            recyclerView.h(obj4);
            obj4 = new n.d(recyclerView, y2);
            editText4.addTextChangedListener(obj4);
        } else {
            i = 0;
            if (y2 instanceof y.a) {
                obj3 = new j(a3);
                obj3.j(p.g());
                obj4 = w.a;
                recyclerView.setAdapter(obj3);
                obj3 = new i(i5);
                recyclerView.i(obj3, i);
                obj3 = AnimationUtils.loadAnimation(recyclerView.getContext(), 2130772024);
                n.e(obj3, "loadAnimation(context, R.anim.shake)");
                recyclerView.startAnimation(obj3);
            } else {
                if (y2 instanceof y.b && recyclerView.getItemDecorationCount() > 0) {
                    if (recyclerView.getItemDecorationCount() > 0) {
                        recyclerView.e1(i);
                    }
                }
            }
        }
    }

    public static final void O(TextView textView, Long long2) {
        String str;
        long longValue;
        int i;
        int i2;
        String obj6;
        n.f(textView, "<this>");
        str = "";
        if (long2 == null) {
        } else {
            obj6 = App.Companion.t().j(long2.longValue(), obj2, true);
            if (obj6 == null) {
            } else {
                str = obj6;
            }
        }
        textView.setText(str);
    }

    public static final void P(EditText editText, int i2) {
        android.text.InputFilter[] filters;
        String copyOf;
        android.text.InputFilter[] aVar;
        int i;
        int i3;
        int i4;
        boolean z;
        n.f(editText, "<this>");
        filters = editText.getFilters();
        copyOf = "filters";
        n.e(filters, copyOf);
        aVar = editText.getFilters();
        n.e(aVar, copyOf);
        i3 = i;
        i4 = 1;
        while (i3 < aVar.length) {
            i3++;
            i4 = 1;
        }
        i = i4;
        if (i != 0) {
            android.text.InputFilter[] filters2 = editText.getFilters();
            n.e(filters2, copyOf);
            copyOf = Arrays.copyOf(filters2, length += i4);
            n.e(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            aVar = new a(i2);
            (InputFilter[])copyOf[filters.length] = aVar;
            editText.setFilters(copyOf);
        }
    }

    public static final void Q(TextView textView, b b2) {
        boolean resources;
        int i2;
        Object[] arr;
        int i;
        String obj5;
        n.f(textView, "<this>");
        n.f(b2, "notificationItem");
        if (b2.m()) {
            if (b2.e() == null) {
                n.e(textView.getResources().getString(2131886675), "resources.getString(R.string.general_anonymous)");
            }
            arr = new Object[1];
            obj5 = textView.getResources().getString(2131886968, obj5);
        } else {
            obj5 = b2.c();
        }
        textView.setText(obj5);
    }

    public static final void R(WebView webView, String string2) {
        n.f(webView, "<this>");
        n.f(string2, "descriptionText");
        webView.getSettings().setDefaultFontSize(16);
        int i = 0;
        webView.setVerticalScrollBarEnabled(i);
        webView.setHorizontalScrollBarEnabled(i);
        webView.setOnTouchListener(g.a);
        webView.setOnLongClickListener(h.a);
        webView.setLongClickable(i);
        webView.setHapticFeedbackEnabled(i);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html><header>");
        stringBuilder.append("<link rel='stylesheet' href='workout_explanation/style.css' type='text/css'>");
        stringBuilder.append("</header><body>");
        stringBuilder.append(string2);
        stringBuilder.append("</body></html>");
        webView.loadDataWithBaseURL("file:///android_asset/", stringBuilder.toString(), "text/html", "UTF-8", 0);
    }

    private static final boolean S(View view, MotionEvent motionEvent2) {
        int obj0;
        obj0 = motionEvent2.getAction() == 2 ? 1 : 0;
        return obj0;
    }

    private static final boolean T(View view) {
        return 1;
    }

    public static final void U(ImageView imageView, String string2) {
        Object str;
        ColorMatrixColorFilter colorMatrixColorFilter;
        Object obj3;
        n.f(imageView, "<this>");
        if (string2 != null) {
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0);
            colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
            imageView.setColorFilter(colorMatrixColorFilter);
            imageView.setImageAlpha(128);
            m.a(imageView.getContext()).D(string2).p1(MyAppGlideModule.d(imageView.getContext())).R0(g.q0()).V0().C0(imageView);
        }
    }

    public static final void V(TextView textView, Long long2) {
        String longValue;
        String str;
        String obj4;
        n.f(textView, "<this>");
        if (long2 != null) {
            obj4 = textView.getResources();
            n.e(obj4, "resources");
            textView.setText(j1.M0(long2.longValue(), obj1));
        }
    }

    public static final void W(MaterialButton materialButton, Long long2) {
        String longValue;
        String str;
        String obj4;
        n.f(materialButton, "<this>");
        if (long2 != null) {
            obj4 = materialButton.getResources();
            n.e(obj4, "resources");
            materialButton.setText(j1.M0(long2.longValue(), obj1));
        }
    }

    public static final void X(ConstraintLayout constraintLayout, KonfettiView konfettiView2) {
        n.f(constraintLayout, "<this>");
        n.f(konfettiView2, "konfettiView");
        final b obj10 = konfettiView2.a();
        int i3 = 2;
        int[] iArr = new int[i3];
        int i11 = 0;
        int i10 = 0;
        iArr[i10] = constraintLayout.getResources().getColor(2131099848, i11);
        int i7 = 1;
        iArr[i7] = constraintLayout.getResources().getColor(2131099849, i11);
        obj10.a(iArr);
        obj10.h(0, obj6);
        obj10.k(1084227584, 1090519040);
        obj10.i(i7);
        obj10.l(6000);
        nl.dionsegijn.konfetti.e.b[] obj9 = new b[i3];
        obj9[i10] = b.a.c;
        obj9[i7] = b.c.b;
        obj10.b(obj9);
        obj9 = new c[i7];
        c cVar2 = new c(18, 1140457472);
        obj9[i10] = cVar2;
        obj10.c(obj9);
        int i2 = -1035468800;
        Float valueOf = Float.valueOf(i2);
        obj10.j(i2, Float.valueOf(obj9 += i), i2, valueOf);
        obj10.o(30, Long.MAX_VALUE);
    }

    public static final void Y(RecyclerView recyclerView, List<String> list2, i.a i$a3, String string4) {
        Object iVar;
        n.f(recyclerView, "<this>");
        if (list2 != null) {
            iVar = new i(list2, string4, a3);
            recyclerView.setAdapter(iVar);
        }
    }

    public static final void Z(Button button, y<?> y2) {
        int i;
        int paddingTop;
        int paddingBottom;
        PorterDuff.Mode sRC_IN;
        int obj4;
        int obj5;
        n.f(button, "<this>");
        i = 0;
        if (y2 instanceof y.b) {
            obj5 = MyAppGlideModule.d(button.getContext());
            obj5.f(1098907648);
            PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(button.getTextColors().getDefaultColor(), PorterDuff.Mode.SRC_IN);
            obj5.setColorFilter(porterDuffColorFilter);
            if (button instanceof MaterialButton) {
                paddingTop = button;
            } else {
                paddingTop = i;
            }
            if (paddingTop == 0) {
            } else {
                paddingTop.setIcon(obj5);
            }
        } else {
            if (button instanceof MaterialButton) {
                obj5 = button;
            } else {
                obj5 = i;
            }
            if (obj5 == null) {
            } else {
                obj5.setIconResource(2131231377);
                obj5.setIconTint(ColorStateList.valueOf(0));
            }
        }
        if (button instanceof MaterialButton) {
            i = button;
        }
        if (i == 0) {
        } else {
            i.setIconSize((int)obj4);
            i.setIconPadding((int)obj4);
            i.setPadding(i.getPaddingLeft(), i.getPaddingTop(), (int)obj4, i.getPaddingBottom());
        }
    }

    public static final List a(app.dogo.com.dogo_android.util.f0.n n, List list2, String string3) {
        return n.g(list2, string3);
    }

    public static final void a0(SwipeRefreshLayout swipeRefreshLayout, Boolean boolean2) {
        n.f(swipeRefreshLayout, "<this>");
        j obj1 = new j(swipeRefreshLayout);
        swipeRefreshLayout.setOnApplyWindowInsetsListener(obj1);
    }

    private final void b(ViewGroup viewGroup, int i2, AlphaAnimation alphaAnimation3) {
        Object next;
        int i;
        int obj5;
        Iterator iterator = x.b(viewGroup).iterator();
        for (View next : iterator) {
            next.setAnimation(0);
            next.setVisibility(4);
        }
        final View obj4 = viewGroup.getChildAt(i2);
        if (obj4 == null) {
        } else {
            obj4.startAnimation(alphaAnimation3);
        }
        if (obj4 == null) {
        } else {
            obj4.setVisibility(0);
        }
    }

    private static final WindowInsets b0(SwipeRefreshLayout swipeRefreshLayout, View view2, WindowInsets windowInsets3) {
        int obj3;
        n.f(swipeRefreshLayout, "$this_setProgressBarOffsetBasedOnStatusBar");
        if (Build.VERSION.SDK_INT >= 30) {
            obj3 = obj3.top;
        } else {
            obj3 = windowInsets3.getSystemWindowInsetTop();
        }
        swipeRefreshLayout.m(false, obj3, obj3 * 3);
        return windowInsets3;
    }

    private final void c(TextView textView, AlphaAnimation alphaAnimation2, int i3, String string4) {
        textView.startAnimation(alphaAnimation2);
        Resources obj9 = textView.getResources();
        n.e(obj9, "resources");
        textView.setText(h(i3, obj9, n.k(this, textView, string4, 0, 2, 0)));
    }

    public static final void c0(OneTenRadioGroup oneTenRadioGroup, ImageView imageView2, Button button3) {
        n.f(oneTenRadioGroup, "<this>");
        n.f(imageView2, "imageView");
        n.f(button3, "submitButton");
        d dVar = new d(imageView2, oneTenRadioGroup, button3);
        oneTenRadioGroup.setOnCheckedChangeListener(dVar);
    }

    public static final void d(ProgressBar progressBar, Integer integer2) {
        int obj2;
        n.f(progressBar, "<this>");
        if (integer2 == null) {
            obj2 = 0;
        } else {
            obj2 = integer2.intValue();
        }
        progressBar.setProgress(obj2, true);
    }

    private static final void d0(ImageView imageView, OneTenRadioGroup oneTenRadioGroup2, Button button3, RadioGroup radioGroup4, int i5) {
        int i3;
        int i;
        int i2;
        int i4;
        Object obj3;
        int obj5;
        n.f(imageView, "$imageView");
        n.f(oneTenRadioGroup2, "$this_setRatingChange");
        n.f(button3, "$submitButton");
        Objects.requireNonNull(radioGroup4, "null cannot be cast to non-null type app.dogo.com.dogo_android.inappmessaging.OneTenRadioGroup");
        obj5 = (OneTenRadioGroup)radioGroup4.a(i5);
        final int obj6 = 1;
        i3 = 0;
        if (obj6 <= obj5 && obj5 <= 5) {
            i2 = obj5 <= 5 ? obj6 : i3;
        } else {
        }
        if (i2 != 0) {
            imageView.setImageDrawable(a.d(oneTenRadioGroup2.getContext(), 2131231116));
        } else {
            if (6 <= obj5 && obj5 <= 8) {
                i2 = obj5 <= 8 ? obj6 : i3;
            } else {
            }
            if (i2 != 0) {
                imageView.setImageDrawable(a.d(oneTenRadioGroup2.getContext(), 2131231117));
            } else {
                if (9 <= obj5 && obj5 <= 10) {
                    if (obj5 <= 10) {
                        i3 = obj6;
                    }
                }
                if (i3 != 0) {
                    imageView.setImageDrawable(a.d(oneTenRadioGroup2.getContext(), 2131231115));
                }
            }
        }
        if (!button3.isEnabled()) {
            button3.setEnabled(obj6);
        }
    }

    private final AlphaAnimation e() {
        final int i3 = 1065353216;
        AlphaAnimation alphaAnimation = new AlphaAnimation(1056964608, i3);
        alphaAnimation.setDuration(1000);
        return alphaAnimation;
    }

    public static final void e0(RecyclerView recyclerView, List<Long> list2, m.a m$a3) {
        Object mVar;
        n.f(recyclerView, "<this>");
        if (list2 != null && a3 != null) {
            if (a3 != null) {
                mVar = new m(list2, a3);
                recyclerView.setAdapter(mVar);
            }
        }
    }

    public static final void f(TextView textView, g g2) {
        int str;
        Object obj1;
        Typeface obj2;
        n.f(textView, "<this>");
        if (g2 == null) {
        } else {
            str = 0;
            switch (obj2) {
                case 1:
                    obj2 = Typeface.create("sans-serif", str);
                    textView.setTypeface(obj2);
                case 2:
                    obj2 = Typeface.create("sans-serif-bold", str);
                    textView.setTypeface(obj2);
                case 3:
                    obj2 = Typeface.create("sans-serif-medium", str);
                    textView.setTypeface(obj2);
                case 4:
                    obj2 = f.g(textView.getContext(), 2131296256);
                    textView.setTypeface(obj2);
                case 5:
                    obj2 = f.g(textView.getContext(), 2131296257);
                    textView.setTypeface(obj2);
                case 6:
                    obj2 = f.g(textView.getContext(), 2131296258);
                    textView.setTypeface(obj2);
                default:
            }
        }
        obj1 = new NoWhenBranchMatchedException();
        throw obj1;
    }

    public static final void f0(View view, TextView textView2) {
        int i;
        String obj2;
        n.f(view, "<this>");
        n.f(textView2, "textView");
        Random random = new Random();
        if (random.nextInt(2) == 0) {
            obj2 = view.getResources().getString(2131886781);
        } else {
            obj2 = view.getResources().getString(2131886782);
        }
        textView2.setText(obj2);
    }

    private final List<Article> g(List<Article> list, String string2) {
        int arrayList;
        boolean next;
        boolean z;
        String lowerCase;
        int i;
        int i2;
        ArrayList obj8;
        final int i3 = 0;
        arrayList = string2.length() == 0 ? 1 : i3;
        if (arrayList != null) {
        } else {
            arrayList = new ArrayList();
            obj8 = list.iterator();
            while (obj8.hasNext()) {
                next = obj8.next();
                String title = (Article)next.getTitle();
                String str = "null cannot be cast to non-null type java.lang.String";
                Objects.requireNonNull(title, str);
                String lowerCase2 = title.toLowerCase();
                String str2 = "(this as java.lang.String).toLowerCase()";
                n.e(lowerCase2, str2);
                Objects.requireNonNull(string2, str);
                lowerCase = string2.toLowerCase();
                n.e(lowerCase, str2);
                if (l.R(lowerCase2, lowerCase, i3, 2, 0)) {
                }
                arrayList.add(next);
            }
            obj8 = arrayList;
        }
        return obj8;
    }

    public static final void g0(ImageView imageView, String string2) {
        n.f(imageView, "<this>");
        m.a(imageView.getContext()).z(MyAppGlideModule.d(imageView.getContext())).C0(imageView);
    }

    private final String h(int i, Resources resources2, String string3) {
        Object[] arr;
        int i2;
        String obj5;
        Object[] obj6;
        final String str = "java.lang.String.format(format, *args)";
        int i3 = 1;
        final int i4 = 0;
        if (i != i3) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        obj5 = f0.a;
                        arr = new Object[i3];
                        arr[i4] = string3;
                        obj5 = resources2.getString(2131887159, arr);
                        n.e(obj5, "resources.getString(R.string.rating_text_1_2, dogName)");
                        n.e(String.format(obj5, Arrays.copyOf(new Object[i4], i4)), str);
                    } else {
                        obj5 = f0.a;
                        arr = new Object[i3];
                        arr[i4] = string3;
                        obj5 = resources2.getString(2131887167, arr);
                        n.e(obj5, "resources.getString(R.string.rating_text_5_2, dogName)");
                        n.e(String.format(obj5, Arrays.copyOf(new Object[i4], i4)), str);
                    }
                } else {
                    obj5 = f0.a;
                    arr = new Object[i3];
                    arr[i4] = string3;
                    obj5 = resources2.getString(2131887165, arr);
                    n.e(obj5, "resources.getString(R.string.rating_text_4_2, dogName)");
                    n.e(String.format(obj5, Arrays.copyOf(new Object[i4], i4)), str);
                }
            } else {
                obj5 = f0.a;
                arr = new Object[i3];
                arr[i4] = string3;
                obj5 = resources2.getString(2131887163, arr);
                n.e(obj5, "resources.getString(R.string.rating_text_3_2, dogName)");
                n.e(String.format(obj5, Arrays.copyOf(new Object[i4], i4)), str);
            }
        } else {
            obj5 = f0.a;
            arr = new Object[i3];
            arr[i4] = string3;
            obj5 = resources2.getString(2131887161, arr);
            n.e(obj5, "resources.getString(R.string.rating_text_2_2, dogName)");
            n.e(String.format(obj5, Arrays.copyOf(new Object[i4], i4)), str);
        }
        return obj5;
    }

    public static final void h0(TextView textView, int i2, ViewGroup viewGroup3, String string4) {
        n.f(textView, "<this>");
        n.f(viewGroup3, "triangleView");
        app.dogo.com.dogo_android.util.f0.n nVar = n.a;
        final AlphaAnimation alphaAnimation = nVar.e();
        nVar.c(textView, alphaAnimation, i2, string4);
        nVar.b(viewGroup3, i2, alphaAnimation);
    }

    public static final void i0(ImageView imageView, Integer integer2) {
        ColorStateList obj2;
        n.f(imageView, "<this>");
        if (integer2 == null) {
        } else {
            integer2.intValue();
            imageView.setImageTintList(ColorStateList.valueOf(integer2.intValue()));
        }
    }

    private final String j(TextView textView, String string2, int i3) {
        int length;
        Resources obj2;
        String obj3;
        if (string2 != null) {
            if (string2.length() > i3) {
                obj3 = textView.getResources().getString(2131887168);
            }
        } else {
        }
        n.e(obj3, "if (dogName == null || dogName.length > maxNameLength) resources.getString(R.string.rating_your_dog) else dogName");
        return obj3;
    }

    public static final void j0(ImageView imageView, String string2) {
        String str;
        PorterDuff.Mode sRC_IN;
        int obj3;
        n.f(imageView, "<this>");
        if (string2 != null) {
            if (z ^= 1 != 0) {
                obj3 = Color.parseColor(string2);
            } else {
                obj3 = str;
            }
            imageView.setColorFilter(obj3, PorterDuff.Mode.SRC_IN);
        }
    }

    static String k(app.dogo.com.dogo_android.util.f0.n n, TextView textView2, String string3, int i4, int i5, Object object6) {
        int obj3;
        if (i5 &= 2 != 0) {
            obj3 = 14;
        }
        return n.j(textView2, string3, obj3);
    }

    public static final void k0(View view, Boolean boolean2) {
        n.f(view, "<this>");
        i obj1 = new i(view);
        view.setOnApplyWindowInsetsListener(obj1);
    }

    public static final void l(WebView webView, String string2) {
        n.f(webView, "<this>");
        n.f(string2, "descriptionText");
        webView.getSettings().setDefaultFontSize(16);
        webView.setOnTouchListener(k.a);
        webView.setOnLongClickListener(l.a);
        int i = 0;
        webView.setLongClickable(i);
        webView.setHapticFeedbackEnabled(i);
        webView.setVerticalScrollBarEnabled(i);
        webView.setHorizontalScrollBarEnabled(true);
        webView.setBackgroundColor(webView.getResources().getColor(2131099860, 0));
        webView.loadDataWithBaseURL("file:///android_asset/", string2, "text/html", "UTF-8", 0);
    }

    private static final WindowInsets l0(View view, View view2, WindowInsets windowInsets3) {
        int systemWindowInsetTop;
        n.f(view, "$this_setTopPaddingAsStatusBarHeight");
        if (Build.VERSION.SDK_INT >= 30) {
            systemWindowInsetTop = insets.top;
        } else {
            systemWindowInsetTop = windowInsets3.getSystemWindowInsetTop();
        }
        view2.setPadding(view.getPaddingLeft(), systemWindowInsetTop, view.getPaddingRight(), view.getPaddingBottom());
        return windowInsets3;
    }

    private static final boolean m(View view, MotionEvent motionEvent2) {
        int obj0;
        obj0 = motionEvent2.getAction() == 2 ? 1 : 0;
        return obj0;
    }

    public static final void m0(ImageView imageView, String string2, Drawable drawable3) {
        n.f(imageView, "<this>");
        m.a(imageView.getContext()).D(string2).p1(MyAppGlideModule.d(imageView.getContext())).a1(drawable3).Y0(drawable3).R0(g.q0()).V0().C0(imageView);
    }

    private static final boolean n(View view) {
        return 1;
    }

    public static final void n0(ImageView imageView, String string2) {
        Object str;
        Object obj2;
        n.f(imageView, "<this>");
        if (string2 != null) {
            imageView.setBackground(MyAppGlideModule.d(imageView.getContext()));
            n.e eVar = new n.e(imageView);
            m.a(imageView.getContext()).D(string2).y1(d.h()).c1(eVar).R0(g.q0()).C0(imageView);
        }
    }

    public static void o(ImageView imageView, OneTenRadioGroup oneTenRadioGroup2, Button button3, RadioGroup radioGroup4, int i5) {
        n.d0(imageView, oneTenRadioGroup2, button3, radioGroup4, i5);
    }

    public static final void o0(View view, Animation animation2) {
        n.f(view, "<this>");
        n.f(animation2, "anim");
        view.startAnimation(animation2);
    }

    public static void p(VideoView videoView, MediaController mediaController2, MediaPlayer mediaPlayer3) {
        n.q0(videoView, mediaController2, mediaPlayer3);
    }

    public static final void p0(ConstraintLayout constraintLayout, VideoView videoView2, String string3) {
        n.f(constraintLayout, "<this>");
        n.f(videoView2, "video");
        n.f(string3, "videoLink");
        videoView2.setVideoURI(Uri.parse(string3));
        MediaController obj3 = new MediaController(constraintLayout.getContext());
        videoView2.requestFocus();
        f obj1 = new f(videoView2, obj3);
        videoView2.setOnPreparedListener(obj1);
    }

    public static boolean q(View view, MotionEvent motionEvent2) {
        return n.S(view, motionEvent2);
    }

    private static final void q0(VideoView videoView, MediaController mediaController2, MediaPlayer mediaPlayer3) {
        n.f(videoView, "$video");
        n.f(mediaController2, "$mediaController");
        int i = 1;
        mediaPlayer3.setLooping(i);
        videoView.setMediaController(mediaController2);
        mediaController2.setAnchorView(videoView);
        videoView.start();
        mediaController2.setEnabled(i);
    }

    public static boolean r(View view) {
        return n.T(view);
    }

    public static final void r0(TextView textView, List<Boolean> list2) {
        Iterator iterator;
        x.a companion;
        int instance;
        boolean booleanValue;
        List list;
        int i7;
        int i2;
        int i4;
        int i6;
        int i5;
        int i;
        int i3;
        int i8;
        String obj13;
        n.f(textView, "<this>");
        n.f(list2, "days");
        instance = 1;
        if (list2 instanceof Collection != null && list2.isEmpty()) {
            if (list2.isEmpty()) {
            } else {
                iterator = list2.iterator();
                while (iterator.hasNext()) {
                    if (!(Boolean)iterator.next().booleanValue()) {
                        break;
                    } else {
                    }
                }
            }
        } else {
        }
        if (instance != null) {
            obj13 = textView.getResources().getString(2131886963);
        } else {
            instance = Calendar.getInstance();
            n.e(instance, "getInstance()");
            obj13 = p.h0(x.Companion.a(instance, list2), 0, 0, 0, 0, 0, 0, 63, 0);
        }
        textView.setText(obj13);
    }

    public static WindowInsets s(View view, View view2, WindowInsets windowInsets3) {
        n.l0(view, view2, windowInsets3);
        return windowInsets3;
    }

    public static final void s0(RecyclerView recyclerView, Integer integer2, k.a k$a3) {
        Object adapter;
        k kVar;
        String string;
        int i;
        int obj5;
        n.f(recyclerView, "<this>");
        if (integer2 != 0 && a3 != null && recyclerView.getAdapter() == null) {
            if (a3 != null) {
                if (recyclerView.getAdapter() == null) {
                    String[] strArr = new String[6];
                    kVar = new k(p.j(recyclerView.getResources().getString(2131886346), recyclerView.getResources().getString(2131886347), recyclerView.getResources().getString(2131886348), recyclerView.getResources().getString(2131886349), recyclerView.getResources().getString(2131886350), recyclerView.getResources().getString(2131886351)), a3, integer2.intValue());
                    recyclerView.setAdapter(kVar);
                }
            }
        }
    }

    public static WindowInsets t(SwipeRefreshLayout swipeRefreshLayout, View view2, WindowInsets windowInsets3) {
        n.b0(swipeRefreshLayout, view2, windowInsets3);
        return windowInsets3;
    }

    public static final void t0(View view, gi gi2) {
        n.f(view, "<this>");
        n.f(gi2, "fab");
        b bVar = new b(view.getResources());
        bVar.p(b.b.FIRST_UPLOAD);
        gi2.T(bVar);
    }

    public static boolean u(View view, MotionEvent motionEvent2) {
        return n.m(view, motionEvent2);
    }

    public static final void u0(ViewGroup viewGroup, List<Boolean> list2) {
        Object str;
        int i;
        int i4;
        String next;
        Object str2;
        int i2;
        boolean next2;
        int i3;
        int booleanValue;
        Object obj7;
        n.f(viewGroup, "<this>");
        if (list2 != null) {
            Calendar instance = Calendar.getInstance();
            n.e(instance, "getInstance()");
            ArrayList arrayList = new ArrayList();
            obj7 = i.A(x.b(viewGroup)).iterator();
            while (obj7.hasNext()) {
                next = obj7.next();
                if (next instanceof CheckBox) {
                }
                if (i2 != 0) {
                }
                arrayList.add(i2);
                i2 = next;
            }
            obj7 = arrayList.iterator();
            i = 0;
            i4 = i;
            for (Object next2 : obj7) {
                Object obj = p.a0(list2, i4);
                if ((Boolean)obj == null) {
                } else {
                }
                booleanValue = (Boolean)obj.booleanValue();
                (CheckBox)next2.setChecked(booleanValue);
                if ((String)p.a0(x.Companion.b(instance), i4) == null) {
                }
                next2.setText(str2);
                i4 = i3;
                str2 = "";
                booleanValue = i;
            }
        }
    }

    public static boolean v(View view) {
        return n.n(view);
    }

    public static final void v0(TextView textView, c0 c02) {
        Object styleSpan;
        int i5;
        int i6;
        int i3;
        SpannableString spannableString;
        int i2;
        int i4;
        int i7;
        String string;
        int i;
        Object obj11;
        n.f(textView, "<this>");
        if (c02 != null) {
            String string2 = textView.getResources().getString(2131886168);
            n.e(string2, "resources.getString(R.string.auth_disclaimer_text)");
            String string3 = textView.getResources().getString(2131886708);
            n.e(string3, "resources.getString(R.string.general_terms_use)");
            string = textView.getResources().getString(2131886694);
            n.e(string, "resources.getString(R.string.general_privacy_policy)");
            int i11 = 0;
            int i12 = 1;
            i4 = 2;
            i7 = 0;
            String str4 = string2;
            i = l.e0(str4, string3, i11, i12, i4, i7);
            i6 = l.e0(str4, string, i11, i12, i4, i7);
            length += i;
            length2 += i6;
            spannableString = new SpannableString(string2);
            n.g gVar = new n.g(c02);
            n.f fVar = new n.f(c02);
            obj11 = 33;
            spannableString.setSpan(gVar, i, i5, obj11);
            spannableString.setSpan(fVar, i6, i3, obj11);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(textView.getTextColors().getDefaultColor());
            spannableString.setSpan(foregroundColorSpan, i, i5, obj11);
            ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(textView.getTextColors().getDefaultColor());
            spannableString.setSpan(foregroundColorSpan2, i6, i3, obj11);
            i2 = 1;
            StyleSpan styleSpan2 = new StyleSpan(i2);
            spannableString.setSpan(styleSpan2, i, i5, obj11);
            styleSpan = new StyleSpan(i2);
            spannableString.setSpan(styleSpan, i6, i3, obj11);
            textView.setText(spannableString);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public static final void w(ImageView imageView, String string2) {
        n.f(imageView, "<this>");
        imageView.setBackground(MyAppGlideModule.d(imageView.getContext()));
        n.c cVar = new n.c(imageView);
        m.a(imageView.getContext()).D(string2).w1(1061158912).y1(d.h()).c1(cVar).C0(imageView);
    }

    public static final void w0(View view, y<?> y2) {
        int obj2;
        n.f(view, "<this>");
        if (y2 == null) {
            view.setVisibility(8);
        } else {
            if (y2 instanceof y.c) {
                view.setVisibility(0);
            }
        }
    }

    public static final void x(ImageView imageView, String string2) {
        n.f(imageView, "<this>");
        n.f(string2, "imageUrl");
        m.a(imageView.getContext()).D(string2).C0(imageView);
    }

    public static final void x0(View view, y<?> y2) {
        int i;
        String str;
        Object obj2;
        int obj3;
        n.f(view, "<this>");
        if (y2 instanceof y.a) {
        } else {
            obj3 = 0;
        }
        if (obj3 == null) {
        } else {
            obj3 = obj3.a();
            if (obj3 == null) {
            } else {
                o3.Companion.a(obj3);
                obj2 = view.getContext();
                n.e(obj2, "context");
                Toast.makeText(App.Companion.b(), n.a.i(obj3, obj2), 1).show();
            }
        }
    }

    public static final void y(ImageView imageView, String string2) {
        n.f(imageView, "imageView");
        Context context = imageView.getContext();
        m.a(context).D(string2).p1(MyAppGlideModule.d(context)).v1(true).U0(j.a).C0(imageView);
    }

    public static final void y0(SwipeRefreshLayout swipeRefreshLayout, y<?> y2) {
        Object obj2;
        n.f(swipeRefreshLayout, "<this>");
        swipeRefreshLayout.setRefreshing(false);
        if (y2 instanceof y.b) {
        } else {
            obj2 = 0;
        }
        if (obj2 == null) {
        } else {
            swipeRefreshLayout.setRefreshing(true);
        }
    }

    public static final void z(ImageView imageView, Drawable drawable2) {
        n.f(imageView, "<this>");
        c.u(imageView).i(drawable2).r0(g.q0()).C0(imageView);
    }

    public static final void z0(View view, y<?> y2) {
        Object obj2;
        n.f(view, "<this>");
        view.setVisibility(8);
        if (y2 instanceof y.b) {
        } else {
            obj2 = 0;
        }
        if (obj2 == null) {
        } else {
            view.setVisibility(0);
        }
    }

    public final String i(Exception exception, Context context2) {
        boolean i3;
        String str;
        int arr;
        int i;
        String str2;
        int i4;
        String str3;
        int i2;
        String obj9;
        Object obj10;
        n.f(context2, "context");
        str = "context.getString(R.string.alert_something_failed)";
        arr = 2131886123;
        if (exception instanceof DogParentInvitationException.InvitationDoesNotExist) {
            n.e(context2.getString(arr), str);
        } else {
            if (exception instanceof DogParentInvitationException.InvitationHasExpired) {
                n.e(context2.getString(2131886889), "context.getString(R.string.message_dog_invitation_expired)");
            } else {
                i3 = exception instanceof DogParentInvitationException.DogIsAlreadyAdded;
                if (i3) {
                    arr = new Object[1];
                    if (i3) {
                    } else {
                        obj9 = i;
                    }
                    if (obj9 == null) {
                    } else {
                        i = obj9.a();
                    }
                    n.e(context2.getString(2131886790, i), "context.getString(R.string.invite_parent_dog_already_on_list_text, (exception as? DogParentInvitationException.DogIsAlreadyAdded)?.dogName)");
                } else {
                    if (exception instanceof DogParentInvitationException.DogIsDeleted) {
                        n.e(context2.getString(2131886888), "context.getString(R.string.message_dog_doesnt_exists)");
                    } else {
                        str2 = "context.getString(R.string.user_profile_name_alert)";
                        i4 = 2131887645;
                        if (exception instanceof DogExceptions.NameIsTooShort) {
                            n.e(context2.getString(i4), str2);
                        } else {
                            if (exception instanceof DogExceptions.NameIsTooLong) {
                                n.e(context2.getString(2131886467), "context.getString(R.string.dog_name_too_long)");
                            } else {
                                if (exception instanceof CouponExceptions.EmptyCode) {
                                    n.e(context2.getString(i4), str2);
                                } else {
                                    if (exception instanceof CouponExceptions.AlreadyUsed) {
                                        n.e(context2.getString(2131887179), "context.getString(R.string.redeem_code_used)");
                                    } else {
                                        if (exception instanceof CouponExceptions.DoesNotExists) {
                                            n.e(context2.getString(2131887176), "context.getString(R.string.redeem_code_does_not_exist)");
                                        } else {
                                            if (exception instanceof CouponExceptions.AlreadyPremium) {
                                                n.e(context2.getString(2131887175), "context.getString(R.string.redeem_code_already_premium)");
                                            } else {
                                                if (exception instanceof FirebaseAuthException != null) {
                                                    if ((FirebaseAuthException)(DogParentInvitationException.DogIsAlreadyAdded)exception.getLocalizedMessage() == null) {
                                                        n.e(context2.getString(arr), str);
                                                    }
                                                } else {
                                                    str2 = "context.getString(R.string.no_internet_connection)";
                                                    i4 = 2131886953;
                                                    if (exception instanceof UnknownHostException != null) {
                                                        n.e(context2.getString(i4), str2);
                                                    } else {
                                                        if (exception instanceof NetworkExceptions.BlankTokenException != null) {
                                                            n.e(context2.getString(i4), str2);
                                                        } else {
                                                            str3 = "context.getString(R.string.error_google_play_services)";
                                                            i2 = 2131886507;
                                                            if (exception instanceof FirebaseRemoteConfigClientException != null) {
                                                                n.e(context2.getString(i2), str3);
                                                            } else {
                                                                if (exception instanceof FirebaseNetworkException != null) {
                                                                    n.e(context2.getString(i4), str2);
                                                                } else {
                                                                    if (exception instanceof FirebaseException != null) {
                                                                        n.e(context2.getString(i2), str3);
                                                                    } else {
                                                                        if (exception instanceof RuntimeExecutionException != null) {
                                                                            n.e(context2.getString(i2), str3);
                                                                        } else {
                                                                            if (exception instanceof DatabaseError != null) {
                                                                                n.e(context2.getString(i2), str3);
                                                                            } else {
                                                                                if (exception instanceof FirebaseRemoteConfigFetchThrottledException != null) {
                                                                                    n.e(context2.getString(i4), str2);
                                                                                } else {
                                                                                    if (exception instanceof FirebaseRemoteConfigServerException != null) {
                                                                                        n.e(context2.getString(i2), str3);
                                                                                    } else {
                                                                                        if (exception instanceof TimeoutException != null) {
                                                                                            n.e(context2.getString(2131886505), "context.getString(R.string.error_change_network)");
                                                                                        } else {
                                                                                            if (exception instanceof VimeoError != null) {
                                                                                                if ((VimeoError)exception.getHttpStatusCode() == -1) {
                                                                                                    obj9 = context2.getString(i4);
                                                                                                } else {
                                                                                                    obj9 = context2.getString(arr);
                                                                                                }
                                                                                                n.e(obj9, "if (exception.httpStatusCode == -1) context.getString(R.string.no_internet_connection) else context.getString(R.string.alert_something_failed)");
                                                                                            } else {
                                                                                                if (exception instanceof RuntimeException != null) {
                                                                                                    obj9 = (RuntimeException)exception.getCause();
                                                                                                    if (obj9 instanceof Exception != null) {
                                                                                                        i = obj9;
                                                                                                    }
                                                                                                    obj9 = i(i, context2);
                                                                                                } else {
                                                                                                    if (exception != null) {
                                                                                                        obj9 = exception.getCause();
                                                                                                        if (obj9 instanceof Exception != null) {
                                                                                                            i = obj9;
                                                                                                        }
                                                                                                        obj9 = i(i, context2);
                                                                                                    } else {
                                                                                                        n.e(context2.getString(arr), str);
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
        return obj9;
    }
}
