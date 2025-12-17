package zendesk.messaging.ui;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.d;
import zendesk.belvedere.b;
import zendesk.belvedere.b.b;
import zendesk.belvedere.e;
import zendesk.messaging.BelvedereMediaHolder;
import zendesk.messaging.R.id;

/* loaded from: classes3.dex */
class InputBoxAttachmentClickListener implements View.OnClickListener {

    private final d activity;
    private final BelvedereMediaHolder belvedereMediaHolder;
    private final e imageStream;
    public InputBoxAttachmentClickListener(d d, e e2, BelvedereMediaHolder belvedereMediaHolder3) {
        super();
        this.activity = d;
        this.imageStream = e2;
        this.belvedereMediaHolder = belvedereMediaHolder3;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        boolean obj1;
        if (!this.imageStream.G1()) {
            showImagePicker();
        } else {
            this.imageStream.dismiss();
        }
    }

    @Override // android.view.View$OnClickListener
    void showImagePicker() {
        b.b bVar = b.a(this.activity);
        bVar.h();
        final int i2 = 1;
        bVar.i("*/*", i2);
        bVar.m(this.belvedereMediaHolder.getSelectedMedia());
        int[] iArr = new int[2];
        iArr[i2] = R.id.input_box_send_btn;
        bVar.n(iArr);
        bVar.k(i2);
        bVar.g(this.activity);
    }
}
