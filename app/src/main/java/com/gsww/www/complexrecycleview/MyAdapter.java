package com.gsww.www.complexrecycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by luweicheng on 2017/3/23 0023.
 */

public class MyAdapter extends RecyclerView.Adapter<AbstractTypeViewHolder> {


    public static final int ONE_TYPE = 1;
    public static final int TWO_TYPE = 2;
    private Context mContext;
    private List<OneTypeBean> oneList;
    private List<TwoTypeBean> twoList;
    private List<Integer> types = new ArrayList<>();
    private Map<Integer, Integer> mPosition = new HashMap<>();

    public MyAdapter(Context mContext, List<OneTypeBean> oneList, List<TwoTypeBean> twoList) {
        this.mContext = mContext;
        this.oneList = oneList;
        this.twoList = twoList;

        for (int i = 0; i < oneList.size(); i++) {
            types.add(ONE_TYPE);
            mPosition.put(i,ONE_TYPE);

        }
        for (int i = 0; i < twoList.size(); i++) {
            types.add(TWO_TYPE);
            mPosition.put(i+oneList.size(),TWO_TYPE);

        }
    }


    @Override
    public AbstractTypeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        switch (viewType) {
            case ONE_TYPE:
                View viewOne = inflater.inflate(R.layout.onetype_layout, parent, false);
                return new OneTypeViewHolder(viewOne);
            case TWO_TYPE:
                View viewTwo = inflater.inflate(R.layout.twotype_layout, parent, false);
                return new TwoTypeViewHolder(viewTwo);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(AbstractTypeViewHolder holder, int position) {
        switch (mPosition.get(position)) {
            case ONE_TYPE:

                ((OneTypeViewHolder) holder).header.setBackgroundResource(oneList.get(position).getImageView());
                ((OneTypeViewHolder) holder).name.setText(oneList.get(position).getName());
                ((OneTypeViewHolder) holder).describe.setText(oneList.get(position).getProfessional());
                break;
            case TWO_TYPE:

                int realPos2 = position - twoList.size();
                ((TwoTypeViewHolder)holder).iv_girl.setBackgroundResource(twoList.get(realPos2).getImg());
                ((TwoTypeViewHolder)holder).tv_describe.setText(twoList.get(realPos2).getTitle());

                break;
        }

    }

    @Override
    public int getItemCount() {
        return types.size();
    }

    @Override
    public int getItemViewType(int position) {

        return mPosition.get(position);
    }
}
