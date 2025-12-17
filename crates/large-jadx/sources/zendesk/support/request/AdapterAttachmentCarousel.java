package zendesk.support.request;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.squareup.picasso.t;
import com.squareup.picasso.x;
import f.g.d.f;
import f.g.d.h;
import f.g.d.j;
import java.util.Collections;
import java.util.List;
import o.b.f;

/* loaded from: classes3.dex */
class AdapterAttachmentCarousel extends RecyclerView.h<zendesk.support.request.AdapterAttachmentCarousel.CarouselViewHolder> {

    private static final int FILE_ATTACHMENT = 1;
    private static final int IMAGE_ATTACHMENT = 2;
    private final zendesk.support.request.ActionFactory af;
    private final zendesk.support.request.AttachmentHelper attachmentHelper;
    private final f dispatcher;
    private final t picasso;
    private final zendesk.support.request.AdapterAttachmentCarousel.CarouselViewHolder.OnRemoveListener removeListener;

    static abstract class CarouselViewHolder extends RecyclerView.e0 {
        CarouselViewHolder(View view) {
            super(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        abstract void bind(zendesk.support.request.StateRequestAttachment stateRequestAttachment, zendesk.support.request.AdapterAttachmentCarousel.CarouselViewHolder.OnRemoveListener adapterAttachmentCarousel$CarouselViewHolder$OnRemoveListener2);
    }

    static class FileAttachmentViewHolder extends zendesk.support.request.AdapterAttachmentCarousel.CarouselViewHolder {

        private final ImageView appIcon;
        private final TextView appName;
        private final View container;
        private final TextView name;
        private final View remove;
        FileAttachmentViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup2) {
            super(layoutInflater.inflate(h.i, viewGroup2, false));
            this.name = (TextView)this.itemView.findViewById(f.N);
            this.appIcon = (ImageView)this.itemView.findViewById(f.M);
            this.appName = (TextView)this.itemView.findViewById(f.L);
            this.remove = this.itemView.findViewById(f.P);
            this.container = this.itemView.findViewById(f.Q);
        }

        @Override // zendesk.support.request.AdapterAttachmentCarousel$CarouselViewHolder
        void bind(zendesk.support.request.StateRequestAttachment stateRequestAttachment, zendesk.support.request.AdapterAttachmentCarousel.CarouselViewHolder.OnRemoveListener adapterAttachmentCarousel$CarouselViewHolder$OnRemoveListener2) {
            Context context = this.itemView.getContext();
            android.content.pm.ResolveInfo appInfoForFile = UtilsAttachment.getAppInfoForFile(context, stateRequestAttachment.getName());
            this.appIcon.setImageDrawable(UtilsAttachment.getAppIcon(context, appInfoForFile));
            this.appName.setText(UtilsAttachment.getAppName(context, appInfoForFile));
            this.name.setText(stateRequestAttachment.getName());
            AdapterAttachmentCarousel.FileAttachmentViewHolder.1 anon = new AdapterAttachmentCarousel.FileAttachmentViewHolder.1(this, onRemoveListener2, stateRequestAttachment);
            this.remove.setOnClickListener(anon);
            int i3 = 1;
            Object[] arr2 = new Object[i3];
            final int i4 = 0;
            arr2[i4] = stateRequestAttachment.getName();
            this.remove.setContentDescription(context.getString(j.M, arr2));
            Object[] arr = new Object[i3];
            arr[i4] = stateRequestAttachment.getName();
            this.container.setContentDescription(context.getString(j.L, arr));
        }
    }

    static class ImageAttachmentViewHolder extends zendesk.support.request.AdapterAttachmentCarousel.CarouselViewHolder {

        private final View container;
        private final ImageView imageView;
        private final t picasso;
        private final View remove;
        ImageAttachmentViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup2, t t3) {
            super(layoutInflater.inflate(h.j, viewGroup2, false));
            this.imageView = (ImageView)this.itemView.findViewById(f.O);
            this.remove = this.itemView.findViewById(f.P);
            this.container = this.itemView.findViewById(f.R);
            this.picasso = t3;
        }

        @Override // zendesk.support.request.AdapterAttachmentCarousel$CarouselViewHolder
        void bind(zendesk.support.request.StateRequestAttachment stateRequestAttachment, zendesk.support.request.AdapterAttachmentCarousel.CarouselViewHolder.OnRemoveListener adapterAttachmentCarousel$CarouselViewHolder$OnRemoveListener2) {
            x xVar = this.picasso.j(stateRequestAttachment.getParsedLocalUri());
            xVar.d();
            xVar.a();
            xVar.f(this.imageView);
            AdapterAttachmentCarousel.ImageAttachmentViewHolder.1 anon = new AdapterAttachmentCarousel.ImageAttachmentViewHolder.1(this, onRemoveListener2, stateRequestAttachment);
            this.remove.setOnClickListener(anon);
            Context obj8 = this.itemView.getContext();
            int i3 = 1;
            final Object[] arr2 = new Object[i3];
            final int i4 = 0;
            arr2[i4] = stateRequestAttachment.getName();
            this.remove.setContentDescription(obj8.getString(j.M, arr2));
            Object[] arr = new Object[i3];
            arr[i4] = stateRequestAttachment.getName();
            this.container.setContentDescription(obj8.getString(j.L, arr));
        }
    }
    AdapterAttachmentCarousel(zendesk.support.request.AttachmentHelper attachmentHelper, t t2, zendesk.support.request.ActionFactory actionFactory3, f f4) {
        super();
        AdapterAttachmentCarousel.1 anon = new AdapterAttachmentCarousel.1(this);
        this.removeListener = anon;
        this.attachmentHelper = attachmentHelper;
        this.picasso = t2;
        this.af = actionFactory3;
        this.dispatcher = f4;
        setHasStableIds(true);
    }

    static zendesk.support.request.ActionFactory access$000(zendesk.support.request.AdapterAttachmentCarousel adapterAttachmentCarousel) {
        return adapterAttachmentCarousel.af;
    }

    static f access$100(zendesk.support.request.AdapterAttachmentCarousel adapterAttachmentCarousel) {
        return adapterAttachmentCarousel.dispatcher;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.attachmentHelper.getSelectedAttachments().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public long getItemId(int i) {
        return (long)obj3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        if (UtilsAttachment.isImageAttachment((StateRequestAttachment)this.attachmentHelper.getSelectedAttachments().get(i))) {
            return 2;
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        onBindViewHolder((AdapterAttachmentCarousel.CarouselViewHolder)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(zendesk.support.request.AdapterAttachmentCarousel.CarouselViewHolder adapterAttachmentCarousel$CarouselViewHolder, int i2) {
        carouselViewHolder.bind((StateRequestAttachment)this.attachmentHelper.getSelectedAttachments().get(i2), this.removeListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return onCreateViewHolder(viewGroup, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public zendesk.support.request.AdapterAttachmentCarousel.CarouselViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i2 != 1 && i2 != 2) {
            if (i2 != 2) {
                return null;
            }
            AdapterAttachmentCarousel.ImageAttachmentViewHolder obj4 = new AdapterAttachmentCarousel.ImageAttachmentViewHolder(from, viewGroup, this.picasso);
            return obj4;
        }
        obj4 = new AdapterAttachmentCarousel.FileAttachmentViewHolder(from, viewGroup);
        return obj4;
    }
}
