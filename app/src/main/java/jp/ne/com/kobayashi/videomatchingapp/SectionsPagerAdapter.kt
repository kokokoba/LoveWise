package jp.ne.com.kobayashi.videomatchingapp

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> {
                val requestsFragment: RequestsFragment = RequestsFragment()
                requestsFragment
            }
            1 -> {
                val chatsFragment: ChatsFragment = ChatsFragment()
                chatsFragment
            }
            2 -> {
                val friendsFragment: FriendsFragment = FriendsFragment()
                friendsFragment
            }
            else -> Fragment()
        }
    }

    override fun getCount(): Int = 3

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "REQUESTS"
            1 -> "CHATS"
            2 -> "FRIENDS"
            else -> ""
        }
    }
}