package fengras.com.lazyload;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import fengras.com.lazyload.bean.Shopping;
import okhttp3.Call;

/**
 * Created by Administrator on 2017/4/20.
 */
public class Fragment01 extends Fragment{
    private ListView lv;
    private String str="http://m.yunifang.com/yunifang/mobile/category/list?random=96333&encode=bf3386e14fe5bb0bcef234baebca2414";
    private List<Shopping.DataBean.GoodsBriefBean> goods=new ArrayList<>();
    private View view;

    //        public static Fragment01 newInstance(String title) {
//        Fragment01 fragment = new Fragment01();
//        Bundle args = new Bundle();
//        args.putString("someTitle", title);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.lists,null);
        lv = (ListView) view.findViewById(R.id.lv);
        getdatas();
        Bundle arguments = getArguments();
        String str = arguments.getString("str");
        return view;
    }

    private void getdatas() {
        Log.e("ss","加载");
        OkHttpUtils.get().url(str).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                Gson gson=new Gson();
                Shopping shopping = gson.fromJson(response, Shopping.class);
                ShoppingAdapter shop=new ShoppingAdapter(shopping.getData().getGoodsBrief(),getActivity());
                lv.setAdapter(shop);
            }
        });


    }
}
