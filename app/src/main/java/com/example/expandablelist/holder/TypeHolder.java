package com.example.expandablelist.holder;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.expandablelist.MyApplication;
import com.example.expandablelist.R;
import com.example.expandablelist.bean.TypeBean;
import com.yu.bundles.extended.recyclerview.ExtendedHolder;
import com.yu.bundles.extended.recyclerview.ExtendedNode;
import com.yu.bundles.extended.recyclerview.ExtendedRecyclerViewHelper;



public class TypeHolder extends ExtendedHolder<TypeBean> implements View.OnLongClickListener{
    private TextView textView;
    private ImageView imageView;
    private ImageView imm;

    public TypeHolder(ExtendedRecyclerViewHelper helper, View itemView) {
        super(helper, itemView);
        textView = itemView.findViewById(R.id.textView);
        imageView = itemView.findViewById(R.id.image);
        imm=itemView.findViewById(R.id.holder_1);
        itemView.setOnLongClickListener(this);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void setData(ExtendedNode<TypeBean> node) {
        String kong=tab(node.data.category);
        String k;

        if(node.data.category==5) {
            //textView.setText(kong+"5级知识点：" + "长按递归删除至一级菜单");
            k=kong+"5级知识点：" + "长按递归删除至一级菜单";
            textView.setText(k);
            imageView.setVisibility(View.GONE);
        }
        else {
            //textView.setText(kong+node.data.name + "：" + node.getSons().size());
            imageView.setImageResource(node.isExtended ? R.drawable.down : R.drawable.up);
            imageView.setVisibility(!node.hasSons() ? View.GONE : View.VISIBLE);

            //设置文字
            k= kong + node.data.name;
            if(node.getSons().size()!=0)
            k=k+ "：" + node.getSons().size()+"题";
            textView.setText(k);
        }


        imm.setImageResource(R.drawable.ic_edit);
        this.imm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(MyApplication.getContext(),"You will see the thinkmap!",Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public boolean onLongClick(View v) {
        helper.recursionDelete(getLayoutPosition(), 1);
        return true;
    }

    @Override
    protected View getExtendedClickView() {
        return null;
    }

    private String tab(int count){
        String taa="";
        for(int a=1;a<count;a++){
            taa=taa+"    ";
        }
        return taa;
    }
}

