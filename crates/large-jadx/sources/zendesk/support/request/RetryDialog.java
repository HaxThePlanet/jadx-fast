package zendesk.support.request;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import androidx.appcompat.app.h;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.a;
import f.c.a.e.f;
import f.g.d.f;
import f.g.d.h;
import java.util.List;

/* loaded from: classes3.dex */
class RetryDialog extends a {

    private BottomSheetBehavior<FrameLayout> bottomSheetBehavior;
    private zendesk.support.request.RetryDialog.Listener listener;
    private final List<zendesk.support.request.StateMessage> message;

    interface Listener {
        public abstract void onDeleteMessage(List<zendesk.support.request.StateMessage> list);

        public abstract void onRetryMessage(List<zendesk.support.request.StateMessage> list);
    }
    RetryDialog(Context context, List<zendesk.support.request.StateMessage> list2) {
        super(context);
        this.message = list2;
        init();
    }

    static zendesk.support.request.RetryDialog.Listener access$000(zendesk.support.request.RetryDialog retryDialog) {
        return retryDialog.listener;
    }

    static List access$100(zendesk.support.request.RetryDialog retryDialog) {
        return retryDialog.message;
    }

    private void init() {
        setContentView(h.l);
        int i2 = 1;
        setCancelable(i2);
        setCanceledOnTouchOutside(i2);
        this.bottomSheetBehavior = initBottomSheet();
        initListener();
    }

    private BottomSheetBehavior<FrameLayout> initBottomSheet() {
        View viewById = findViewById(f.e);
        if ((FrameLayout)viewById != null) {
            return BottomSheetBehavior.y((FrameLayout)viewById);
        }
        return 0;
    }

    private void initListener() {
        Object viewById;
        zendesk.support.request.RetryDialog.1 anon;
        viewById = findViewById(f.W);
        View viewById2 = findViewById(f.X);
        if (viewById2 != null && viewById != null) {
            if (viewById != null) {
                anon = new RetryDialog.1(this);
                viewById.setOnClickListener(anon);
                viewById = new RetryDialog.2(this);
                viewById2.setOnClickListener(viewById);
            }
        }
    }

    @Override // com.google.android.material.bottomsheet.a
    protected void onStart() {
        int i;
        super.onStart();
        final BottomSheetBehavior bottomSheetBehavior = this.bottomSheetBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.Z(3);
        }
    }

    @Override // com.google.android.material.bottomsheet.a
    public void setListener(zendesk.support.request.RetryDialog.Listener retryDialog$Listener) {
        this.listener = listener;
    }
}
