package com.gsww.www.complexrecycleview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by luweicheng on 2017/3/23 0023.
 */

public class TwoTypeViewHolder extends AbstractTypeViewHolder<TwoTypeBean> {
    public ImageView iv_girl;
    public TextView tv_describe;
    public TwoTypeViewHolder(View itemView) {
        super(itemView);
        iv_girl = (ImageView) itemView.findViewById(R.id.iv_food);
        tv_describe = (TextView)itemView.findViewById(R.id.tv_title);
    }

}
