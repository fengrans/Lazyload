package fengras.com.lazyload;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import fengras.com.lazyload.bean.Shopping;

/**
 * Created by Administrator on 2017/4/14.
 */
public class ShoppingAdapter extends BaseAdapter {
    private List<Shopping.DataBean.GoodsBriefBean> list;
    private Context context;
    public ShoppingAdapter(List<Shopping.DataBean.GoodsBriefBean> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView =View.inflate(context, R.layout.shoppinggridview,null);
        ImageView goods_img= (ImageView) convertView.findViewById(R.id.goods_img);
        TextView efficacy= (TextView) convertView.findViewById(R.id.efficacy);
        TextView  goods_name= (TextView) convertView.findViewById(R.id.goods_name);
        TextView market_price= (TextView) convertView.findViewById(R.id.market_price);
        TextView shop_price= (TextView) convertView.findViewById(R.id.shop_price);
        Glide.with(context).load(list.get(position).getGoods_img()).into(goods_img);
        efficacy.setText(list.get(position).getEfficacy());
        goods_name.setText(list.get(position).getGoods_name());
        market_price.setText("￥"+list.get(position).getMarket_price()+"");
        shop_price.setText("￥"+list.get(position).getShop_price()+"");
        market_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        return convertView;
    }
}
