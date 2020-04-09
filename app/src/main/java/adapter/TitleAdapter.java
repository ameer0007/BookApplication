package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.bookapplication.R;

import java.util.ArrayList;

import myinterface.TitleClickListener;

public class TitleAdapter  extends RecyclerView.Adapter<TitleAdapter.MyviewHolder> {
    private Context mContext;
    private ArrayList<String> titleList;
    private TitleClickListener clickListener;

    public TitleAdapter(Context mContext, ArrayList<String> titleList, TitleClickListener clickListener) {
        this.mContext = mContext;
        this.titleList = titleList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public TitleAdapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.title_layout, parent, false);
        final MyviewHolder myviewHolder = new MyviewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(v, myviewHolder.getPosition());
            }
        });
        return myviewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TitleAdapter.MyviewHolder holder, int position) {
       holder.title.setText(titleList.get(position).replace("_"," "));
    }

    @Override
    public int getItemCount() {
        return titleList.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
        }
    }
}
