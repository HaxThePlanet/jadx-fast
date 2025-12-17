package zendesk.messaging.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import d.u.n;
import d.u.o;
import d.u.p;
import d.u.q;
import d.u.s;
import java.util.concurrent.atomic.AtomicReference;
import zendesk.messaging.ConnectionState;
import zendesk.messaging.R.id;
import zendesk.messaging.R.string;

/* loaded from: classes3.dex */
class LostConnectionBanner {

    private final AtomicReference<ConnectionState> currentConnectionState;
    private final AnimatorSet hideAnimation;
    private final View lostConnectionBanner;
    private final Button lostConnectionButton;
    private final TextView lostConnectionTextView;
    private View.OnClickListener onRetryConnectionClickListener;
    private final ViewGroup rootView;
    private final s showAnimation;
    private zendesk.messaging.ui.LostConnectionBanner.State state;

    private static enum State {

        ENTERING,
        ENTERED,
        EXITING,
        EXITED;
    }
    private LostConnectionBanner(ViewGroup viewGroup, RecyclerView recyclerView2, zendesk.messaging.ui.InputBox inputBox3, View view4) {
        super();
        this.state = LostConnectionBanner.State.EXITED;
        this.rootView = viewGroup;
        this.lostConnectionBanner = view4;
        AtomicReference obj10 = new AtomicReference(ConnectionState.DISCONNECTED);
        this.currentConnectionState = obj10;
        this.lostConnectionTextView = (TextView)view4.findViewById(R.id.zui_lost_connection_label);
        obj10 = R.id.zui_lost_connection_button;
        this.lostConnectionButton = (Button)view4.findViewById(obj10);
        LostConnectionBanner.1 anon = new LostConnectionBanner.1(this);
        view4.findViewById(obj10).setOnClickListener(anon);
        obj10 = new s();
        int i = 0;
        obj10.u0(i);
        final int i3 = 48;
        n nVar = new n(i3);
        obj10.k0(nVar);
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        obj10 = obj10.s0(decelerateInterpolator);
        long dEFAULT_ANIMATION_DURATION = MessagingView.DEFAULT_ANIMATION_DURATION;
        obj10.r0(dEFAULT_ANIMATION_DURATION);
        LostConnectionBanner.2 anon3 = new LostConnectionBanner.2(this, recyclerView2, view4, inputBox3);
        this.showAnimation = obj10.h0(anon3);
        final android.view.ViewGroup.LayoutParams view = obj10;
        obj10 = new AnimatorSet();
        this.hideAnimation = obj10;
        Animator[] arr = new Animator[2];
        arr[i] = ValueAnimators.topPaddingAnimator(recyclerView2, recyclerView2.getPaddingTop(), paddingTop2 -= height2, dEFAULT_ANIMATION_DURATION);
        int topMargin = view.topMargin;
        arr[1] = ValueAnimators.topMarginAnimator(view4, topMargin, topMargin - height, dEFAULT_ANIMATION_DURATION);
        obj10.playTogether(arr);
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        obj10.setInterpolator(accelerateInterpolator);
        super(this, (ViewGroup.MarginLayoutParams)view, recyclerView2, view4, inputBox3);
        obj10.addListener(anon2);
    }

    static View.OnClickListener access$000(zendesk.messaging.ui.LostConnectionBanner lostConnectionBanner) {
        return lostConnectionBanner.onRetryConnectionClickListener;
    }

    static zendesk.messaging.ui.LostConnectionBanner.State access$102(zendesk.messaging.ui.LostConnectionBanner lostConnectionBanner, zendesk.messaging.ui.LostConnectionBanner.State lostConnectionBanner$State2) {
        lostConnectionBanner.state = state2;
        return state2;
    }

    static s access$200(zendesk.messaging.ui.LostConnectionBanner lostConnectionBanner) {
        return lostConnectionBanner.showAnimation;
    }

    static zendesk.messaging.ui.LostConnectionBanner create(ViewGroup viewGroup, RecyclerView recyclerView2, zendesk.messaging.ui.InputBox inputBox3) {
        LostConnectionBanner lostConnectionBanner = new LostConnectionBanner(viewGroup, recyclerView2, inputBox3, viewGroup.findViewById(R.id.zui_lost_connection_view));
        return lostConnectionBanner;
    }

    void hide() {
        int hideAnimation;
        int i;
        hideAnimation = LostConnectionBanner.5.$SwitchMap$zendesk$messaging$ui$LostConnectionBanner$State[this.state.ordinal()];
        if (hideAnimation != 1 && hideAnimation != 3 && hideAnimation != 4) {
            if (hideAnimation != 3) {
                if (hideAnimation != 4) {
                    this.hideAnimation.start();
                }
            }
        }
        LostConnectionBanner.4 anon = new LostConnectionBanner.4(this);
        this.showAnimation.h0(anon);
    }

    void setOnRetryConnectionClickListener(View.OnClickListener view$OnClickListener) {
        this.onRetryConnectionClickListener = onClickListener;
    }

    void show() {
        int lostConnectionBanner;
        int i;
        lostConnectionBanner = LostConnectionBanner.5.$SwitchMap$zendesk$messaging$ui$LostConnectionBanner$State[this.state.ordinal()];
        if (lostConnectionBanner != 1 && lostConnectionBanner != 2) {
            if (lostConnectionBanner != 2) {
                q.a(this.rootView, this.showAnimation);
                this.lostConnectionBanner.setVisibility(0);
            }
        }
    }

    void update(ConnectionState connectionState) {
        int zui_label_reconnecting;
        Button obj3;
        if (this.currentConnectionState.getAndSet(connectionState) == connectionState) {
        }
        int i2 = 8;
        switch (obj3) {
            case 1:
                this.lostConnectionTextView.setText(R.string.zui_label_reconnecting);
                this.lostConnectionButton.setVisibility(i2);
                show();
                break;
            case 2:
                this.lostConnectionTextView.setText(R.string.zui_label_reconnecting_failed);
                this.lostConnectionButton.setVisibility(i2);
                show();
            case 3:
                this.lostConnectionTextView.setText(R.string.zui_label_reconnecting_failed);
                this.lostConnectionButton.setVisibility(0);
                show();
            case 4:
                hide();
                break;
            default:
        }
    }
}
