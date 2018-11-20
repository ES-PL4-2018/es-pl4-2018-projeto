package es.gate;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;

public class Fragment_Bookmark_List extends Fragment {

    private View listFragment;
    Fragment_Bookmark parent;
    private Card_Bookmark_Adapter cardAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        listFragment = inflater.inflate(R.layout.menu_bookmark_list, container, false);
        parent = (Fragment_Bookmark) getParentFragment();

        do{

        }while(Singleton_UserInformation.getInstance().getAccount() == null);
        RecyclerView recyclerView = listFragment.findViewById(R.id.bookmarkRecyclerView);
        recyclerView.setHasFixedSize(true);
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        layoutManager.setJustifyContent(JustifyContent.SPACE_BETWEEN);
        recyclerView.setLayoutManager(layoutManager); // Singleton_UserInformation.getInstance().getAccount().getUserBookmark() TODO
        cardAdapter = new Card_Bookmark_Adapter(Singleton_UserInformation.getInstance().getAccount().getUserBookmark(), getContext());
        recyclerView.setAdapter(cardAdapter);


        listFragment.findViewById(R.id.bookmarkCreate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.bookmarkClick(0);
            }
        });

        return listFragment;
    }

    public void updateData(){
        cardAdapter.notifyDataSetChanged();
    }

}
