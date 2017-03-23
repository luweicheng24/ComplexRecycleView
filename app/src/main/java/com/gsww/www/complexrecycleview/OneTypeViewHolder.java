package com.gsww.www.complexrecycleview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by luweicheng on 2017/3/23 0023.
 */

public class OneTypeViewHolder extends AbstractTypeViewHolder<OneTypeBean> {
    public ImageView header;
    public TextView name;
    public TextView describe;
    public OneTypeViewHolder(View itemView) {
        super(itemView);
        header = (ImageView) itemView.findViewById(R.id.iv_header);
        name = (TextView)itemView.findViewById(R.id.tv_name);
        describe = (TextView)itemView.findViewById(R.id.tv_describe);
    }


}
