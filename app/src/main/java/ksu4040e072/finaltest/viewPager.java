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



public class viewPager extends AppCompatActivity {
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
        memberList.add(new Member(1, R.drawable.o1, "1"));
        memberList.add(new Member(2, R.drawable.o2, "2"));
        memberList.add(new Member(3, R.drawable.o3, "3"));
        memberList.add(new Member(4, R.drawable.o4, "4"));
        memberList.add(new Member(5, R.drawable.o5, "5"));
        memberList.add(new Member(6, R.drawable.o6, "6"));
        memberList.add(new Member(7, R.drawable.o7, ""));
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
