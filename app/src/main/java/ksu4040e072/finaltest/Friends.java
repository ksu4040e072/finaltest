package ksu4040e072.finaltest;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Friends extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
        ListView lvMember = (ListView) findViewById(R.id.lvMember);
        //取得liveView元件
        lvMember.setAdapter(new MemberAdapter(this));
        //建立Adapter基座（存取資料的地方）
        lvMember.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Member member = (Member) parent.getItemAtPosition(position);
                String text = member.getName();
                Toast.makeText(Friends.this, text, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class MemberAdapter extends BaseAdapter {
        private LayoutInflater layoutInflater;
        private List<Member> memberList;
        //建立一個空的資料庫

        public MemberAdapter(Context context) {
            layoutInflater = LayoutInflater.from(context);
            //把資料存進MemberAdapter

            memberList = new ArrayList<>();
            //new一個memberList陣列
            memberList = new ArrayList<>();
            memberList.add(new Member(1, R.drawable.p01, "米米"));
            memberList.add(new Member(2, R.drawable.p02, "焦糖"));
            memberList.add(new Member(3, R.drawable.p03, "彌彌"));
            memberList.add(new Member(4, R.drawable.p04, "風風"));
            memberList.add(new Member(5, R.drawable.p05, "inin"));
            memberList.add(new Member(6, R.drawable.p06, "星星"));
            memberList.add(new Member(7, R.drawable.p07, "米寶"));
            memberList.add(new Member(8, R.drawable.p08, "秋萱"));
            memberList.add(new Member(9, R.drawable.p09, "芃芃"));
            memberList.add(new Member(10, R.drawable.p10, "泡泡"));
            memberList.add(new Member(11, R.drawable.p11, "小迷"));
            memberList.add(new Member(12, R.drawable.p12, "我"));

        }

        @Override
        public int getCount() {
            return memberList.size();
        }

        @Override
        public Object getItem(int position) {
            return memberList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return memberList.get(position).getId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.friends_item, parent, false);
            }

            Member member = memberList.get(position);
            ImageView ivImage = (ImageView) convertView
                    .findViewById(R.id.imageView);
            ivImage.setImageResource(member.getImage());

            TextView tvName = (TextView) convertView
                    .findViewById(R.id.tvName);
            tvName.setText(member.getName());


            return convertView;
        }
    }
}
