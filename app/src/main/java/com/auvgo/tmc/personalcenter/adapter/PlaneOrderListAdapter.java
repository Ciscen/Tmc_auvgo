package com.auvgo.tmc.personalcenter.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.auvgo.tmc.R;
import com.auvgo.tmc.adapter.Baseadapter;
import com.auvgo.tmc.personalcenter.fragment.TrainOrderListFragment;
import com.auvgo.tmc.plane.bean.PlaneOrderListBean;
import com.auvgo.tmc.utils.MUtils;

import java.util.List;

/**
 * Created by lc on 2016/12/1
 */

public class PlaneOrderListAdapter extends Baseadapter<PlaneOrderListBean.ListBean, PlaneOrderListAdapter.ViewHolder> {

    private int ticketType;

    public PlaneOrderListAdapter(Context context, List<PlaneOrderListBean.ListBean> list, int resourceId, int ticketType) {
        super(context, list, resourceId);
        this.ticketType = ticketType;
    }

    public PlaneOrderListAdapter(Context context, List<PlaneOrderListBean.ListBean> list, int ticketType) {
        super(context, list, R.layout.item_order_list);
        this.ticketType = ticketType;
    }

    @Override
    protected ViewHolder getViewHolder(View convertView) {
        ViewHolder vh = new ViewHolder();
        vh.from = (TextView) convertView.findViewById(R.id.item_order_list_from);
        vh.to = (TextView) convertView.findViewById(R.id.item_order_list_to);
        vh.airline = (TextView) convertView.findViewById(R.id.item_order_list_no);
        vh.offTime = (TextView) convertView.findViewById(R.id.item_order_list_offtime);
        vh.name = (TextView) convertView.findViewById(R.id.item_order_list_name);
        vh.orderStatus = (TextView) convertView.findViewById(R.id.item_order_list_order_status);
        vh.approveStatus = (TextView) convertView.findViewById(R.id.item_order_list_approve_status);
        vh.price = (TextView) convertView.findViewById(R.id.item_order_list_price);
        vh.orderno = (TextView) convertView.findViewById(R.id.item_order_list_orderno);
        return vh;
    }

    @Override
    protected void bindViews(ViewHolder viewHolder, int position) {
        PlaneOrderListBean.ListBean listBean = list.get(position);
        viewHolder.from.setText(listBean.getOrgname());
        viewHolder.to.setText(listBean.getArriname());
        viewHolder.airline.setText(listBean.getAirline());
        viewHolder.offTime.setText("起飞:" + listBean.getDeptdate() + " " + listBean.getDepttime());
        viewHolder.name.setText(listBean.getChencheRen());
        viewHolder.orderno.setText(String.format("订单号:%s", listBean.getOrderno()));
        switch (ticketType) {
            case TrainOrderListFragment.NORMAL:
                viewHolder.orderStatus.setText(MUtils.getOrgTicketStateByCode(listBean.getStatu()));
                viewHolder.approveStatus.setText(MUtils.getApproveStateByCode(listBean.getApprovestatus()));
                viewHolder.price.setText(String.format("￥%s", listBean.getTotalprice()));
                break;
            case TrainOrderListFragment.RETURNL:
                viewHolder.orderStatus.setText(MUtils.getReturnStateByCode(listBean.getStatu()));
                viewHolder.approveStatus.setVisibility(View.GONE);
                double tpprice = listBean.getTotalprice();
                viewHolder.price.setText(tpprice == 0 ? "- -" : "￥" + tpprice);
                break;
            case TrainOrderListFragment.ALTER:
                viewHolder.orderStatus.setText(MUtils.getAlterStateByCode(listBean.getStatu()));
                viewHolder.approveStatus.setText("");
                double gqprice = listBean.getTotalprice();
                viewHolder.price.setText(gqprice == 0 ? "- -" : "￥" + listBean.getTotalprice());
                break;
        }
    }

    class ViewHolder {
        TextView from, to, airline, offTime, name, orderStatus, approveStatus, price, orderno;
    }
}
