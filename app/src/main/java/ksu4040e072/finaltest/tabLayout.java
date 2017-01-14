package ksu4040e072.finaltest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class tabLayout extends AppCompatActivity {
    private List<Member> memberList;
    private ViewPager vpMember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        List<Member> memberList = getMemberList();
        MemberAdapter memberAdapter = new MemberAdapter(getSupportFragmentManager(), memberList);
        vpMember = (ViewPager) findViewById(R.id.vpMember);
        vpMember.setAdapter(memberAdapter);
    }

    private List<Member> getMemberList() {
        memberList = new ArrayList<>();
        memberList.add(new Member(12, R.drawable.news01, "作者鏡傳媒 | 鏡週刊 – 2016年12月5日 上午8:00"));
        memberList.add(new Member(75, R.drawable.news02, "作者黃士修 | 風傳媒 – 2016年12月5日 上午7:46"));
        memberList.add(new Member(65, R.drawable.news03, "作者三立新聞網 | 三立新聞 – 2016年12月5日 上午11:40"));
        memberList.add(new Member(12, R.drawable.news04,  "作者三立新聞網 | 三立新聞 – 2016年12月5日 下午4:00"));
        memberList.add(new Member(92, R.drawable.news05, "作者上報快訊 | 上報 – 2016年12月5日 下午3:11"));
        memberList.add(new Member(103, R.drawable.news06,"作者上報快訊 | 上報 – 2016年12月5日 下午6:46"));
        memberList.add(new Member(45, R.drawable.news07, "星島日報 – 3小時前"));
        memberList.add(new Member(78, R.drawable.news08,  "星島日報 – 6小時前"));
        memberList.add(new Member(234, R.drawable.news09, "星島日報 – 6小時前"));
        memberList.add(new Member(35, R.drawable.news10,  "作者朱蒲青／台北報導 | 民報 – 2016年12月6日 下午1:59"));
        memberList.add(new Member(57, R.drawable.news11, "中央社 – 2016年12月6日 下午3:23"));
        memberList.add(new Member(61, R.drawable.news12, "作者編輯部 | 匯流新聞網 – 2016年12月6日 下午1:00"));
        return memberList;
    }

    private class MemberAdapter extends FragmentStatePagerAdapter {
        List<Member> memberList;

        private MemberAdapter(FragmentManager fm, List<Member> memberList) {
            super(fm);
            this.memberList = memberList;
        }

        @Override
        public int getCount() {
            return memberList.size();
        }

        @Override
        public Fragment getItem(int position) {
            return MemberFragment.newInstance(memberList.get(position));
        }
    }

    public void onFirstClick(View view) {
        vpMember.setCurrentItem(0);
    }

    public void onLastClick(View view) {
        vpMember.setCurrentItem(memberList.size() - 1);
    }
}
