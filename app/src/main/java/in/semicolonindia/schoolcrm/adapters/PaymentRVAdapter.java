package in.semicolonindia.schoolcrm.adapters;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import in.semicolonindia.schoolcrm.R;

/**
 * Created by Faraz on 03/08/2018.
 */
@SuppressWarnings("ALL")
public class PaymentRVAdapter extends RecyclerView.Adapter<PaymentRVAdapter.ViewHolder> {

    private Activity activity;

    public PaymentRVAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public PaymentRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.list_item_payments,
                parent, false);
        return (new PaymentRVAdapter.ViewHolder(view));
    }

    @Override
    public void onBindViewHolder(final PaymentRVAdapter.ViewHolder holder, final int position) {
        final Typeface appBold = Typeface.createFromAsset(activity.getAssets(), "fonts/app_bold.ttf");
        final Typeface appRegular = Typeface.createFromAsset(activity.getAssets(), "fonts/app_regular.ttf");
        holder.tvPaymentName.setTypeface(appBold);
        holder.tvPaymentStatus.setTypeface(appRegular);
        holder.tvDetails.setTypeface(appRegular);
        holder.tvPaymentAmount.setTypeface(appRegular);
        holder.tvPaymentDate.setTypeface(appRegular);
        holder.btnDownloadReceipt.setTypeface(appRegular);
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPaymentStatusIcon;
        TextView tvPaymentName;
        TextView tvPaymentStatus;
        TextView tvDetails;
        TextView tvPaymentAmount;
        TextView tvPaymentDate;
        Button btnDownloadReceipt;

        public ViewHolder(View itemView) {
            super(itemView);
            imgPaymentStatusIcon = (ImageView) itemView.findViewById(R.id.imgPaymentStatusIcon);
            tvPaymentName = (TextView) itemView.findViewById(R.id.tvPaymentName);
            tvPaymentStatus = (TextView) itemView.findViewById(R.id.tvPaymentStatus);
            tvDetails = (TextView) itemView.findViewById(R.id.tvDetails);
            tvPaymentAmount = (TextView) itemView.findViewById(R.id.tvPaymentAmount);
            tvPaymentDate = (TextView) itemView.findViewById(R.id.tvPaymentDate);
            btnDownloadReceipt = (Button) itemView.findViewById(R.id.btnDownloadReceipt);
        }
    }
}