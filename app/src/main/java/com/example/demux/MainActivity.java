package com.example.demux;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecycler;
    private RecyclerView.LayoutManager mManager;
    private ArrayList<Question> mQuestions=new ArrayList<>();
    private ArrayList<Question> passQuestions=new ArrayList<>();
    private Button bDp,b2pointer,bTree,bStack,bArray;
    private boolean boolDp,bool2p,boolTree,boolStack,boolArray;
    private QuestionAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycler=findViewById(R.id.questionRecyclerView);
        bDp=findViewById(R.id.bDp);
        b2pointer=findViewById(R.id.b2Pointer);
        bTree=findViewById(R.id.bTree);
        bStack=findViewById(R.id.bStack);
        bArray=findViewById(R.id.bArray);

        bool2p=true;boolDp=true;boolTree=true;boolStack=true;boolArray=true;

        mManager = new LinearLayoutManager(this);
        mRecycler.setHasFixedSize(true);
        mRecycler.setLayoutManager(mManager);
        fetchData();
        adapter=new QuestionAdapter(mQuestions);
        mRecycler.setAdapter(adapter);

        bDp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolDp=!boolDp;
                setColor();
                adapter.notifyDataSetChanged();
            }
        });

        b2pointer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bool2p=!bool2p;
                setColor();
                adapter.notifyDataSetChanged();
            }
        });

        bTree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolTree=!boolTree;
                setColor();
                adapter.notifyDataSetChanged();
            }
        });
        bStack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolStack=!boolStack;
                setColor();
                adapter.notifyDataSetChanged();
            }
        });
        bArray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolArray=!boolArray;
                setColor();
                adapter.notifyDataSetChanged();
            }
        });
    }


    protected void fetchData()
    {
        mQuestions.add(new Question("Two Sum",new String[]{"Easy","2-pointer","Maths"},"43"));
        mQuestions.add(new Question("Check BST",new String[]{"Medium","Tree","Maths"},"26"));
        mQuestions.add(new Question("Coin Change",new String[]{"Hard","DP","Maths"},"92"));
        mQuestions.add(new Question("The Celebrity Problem",new String[]{"Hard","Maths","Stack"},"21"));
        mQuestions.add(new Question("Merge Sort",new String[]{"Hard","Maths","Array"},"24"));

    }
    protected void setColor()
    {

        Set<Question> hash_Set = new HashSet<Question>();
        ArrayList<Question> tempQuestions=new ArrayList<>();
        ArrayList<String> okay=new ArrayList<>();

        if(boolTree) {
            bTree.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            okay.add("Tree");
        }
        else
            bTree.setBackgroundColor(getResources().getColor(R.color.white));


        if(boolDp) {
            bDp.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            okay.add("DP");
        }
        else
            bDp.setBackgroundColor(getResources().getColor(R.color.white));


        if(bool2p) {
            b2pointer.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            okay.add("2-pointer");
        }
        else
            b2pointer.setBackgroundColor(getResources().getColor(R.color.white));

        if(boolStack) {
            bStack.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            okay.add("Stack");
        }
        else
            bStack.setBackgroundColor(getResources().getColor(R.color.white));

        if(boolArray) {
            bArray.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            okay.add("Array");
        }
        else
            bArray.setBackgroundColor(getResources().getColor(R.color.white));


        for(int i=0;i<mQuestions.size();i++)
        {
            int cnt=0;
            for(int j=0;j<mQuestions.get(i).tags.length;j++)
            {
                for(int k=0;k<okay.size();k++)
                {
                    if(okay.get(k).equals(mQuestions.get(i).tags[j]))
                    {
                        cnt++;
                    }

                }
            }
            if(cnt>0)
                hash_Set.add(mQuestions.get(i));

        }

        for(Question s:hash_Set) {
            tempQuestions.add(s);
        }
        passQuestions.clear();
        passQuestions=tempQuestions;




        adapter=new QuestionAdapter(passQuestions);
        adapter.notifyDataSetChanged();
        mRecycler.setAdapter(adapter);
    }

}