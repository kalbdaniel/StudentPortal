package nl.hva.dka.studentportal;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PortalAdapter extends RecyclerView.Adapter<PortalAdapter.ViewHolder> {

    private final List<Portal> mPortals;
    private final Context mContext;
    public final static String URL = "URL";

    public PortalAdapter(List<Portal> portals, Context context) {
        this.mPortals = portals;
        this.mContext = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView portalTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.portalTextView = itemView.findViewById(android.R.id.text1);
        }
    }

    @NonNull
    @Override
    public PortalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(android.R.layout.simple_list_item_1, null);
        return new PortalAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PortalAdapter.ViewHolder viewHolder, int i) {
        final Portal portal = mPortals.get(i);
        viewHolder.portalTextView.setText(portal.getmName());

        viewHolder.portalTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, WebViewActivity.class);
                intent.putExtra(URL, portal.getmUrl());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPortals.size();
    }
}
