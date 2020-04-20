package com.example.nestedrecycler.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nestedrecycler.R
import com.example.nestedrecycler.model.ChildNode
import com.example.nestedrecycler.model.RootNode
import com.example.nestedrecycler.ui.main.adapter.child.ChildAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ChildAdapter.RootItemClickListener {

    private lateinit var mainList: List<ChildNode>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setup()
    }

    private fun setup() {
        initMainList()
        setMainAdapterForList()
    }

    private fun setMainAdapterForList() {
        mainRecyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = ChildAdapter(this, mainList)
        adapter.setRootItemClickListener(this)
        //TODO - set child item click listener
        mainRecyclerView.adapter = adapter
    }

    private fun initMainList() {
        val list: MutableList<ChildNode> = ArrayList()

        list.add(
            ChildNode(
                "popular apps",
                listOf(
                    RootNode(
                        "facebook",
                        "https://techcrunch.com/wp-content/uploads/2016/11/facebook-video-money.png"
                    ),
                    RootNode(
                        "maps",
                        "https://www.xitetech.com/uploads/original/2019/01/google-maps.jpg"
                    ),
                    RootNode(
                        "kite",
                        "https://zerodha.com/z-connect/wp-content/uploads/2019/07/kite-3-blog-post.png"
                    )
                )
            )
        )

        list.add(
            ChildNode(
                "popular series",
                listOf(
                    RootNode(
                        "westworld",
                        "https://pmcvariety.files.wordpress.com/2020/03/westworld-season-3-episode-3-still.jpg"
                    ),
                    RootNode(
                        "game of thrones",
                        "https://www.slashgear.com/wp-content/uploads/2019/05/The-Iron-Throne-GoT-1.jpg"
                    ),
                    RootNode(
                        "friends",
                        "https://s3.amazonaws.com/images.seroundtable.com/friends-1568977438.jpg"
                    )
                )
            )
        )

        list.add(
            ChildNode(
                "popular books",
                listOf(
                    RootNode(
                        "sapiens",
                        "https://pmcvariety.files.wordpress.com/2020/03/westworld-season-3-episode-3-still.jpg"
                    ),
                    RootNode(
                        "eat that frog",
                        "https://www.slashgear.com/wp-content/uploads/2019/05/The-Iron-Throne-GoT-1.jpg"
                    ),
                    RootNode(
                        "zero to one",
                        "https://s3.amazonaws.com/images.seroundtable.com/friends-1568977438.jpg"
                    )
                )
            )
        )

        list.add(
            ChildNode(
                "popular investment tools",
                listOf(
                    RootNode(
                        "stocks",
                        "https://pmcvariety.files.wordpress.com/2020/03/westworld-season-3-episode-3-still.jpg"
                    ),
                    RootNode(
                        "real estate",
                        "https://www.slashgear.com/wp-content/uploads/2019/05/The-Iron-Throne-GoT-1.jpg"
                    ),
                    RootNode(
                        "mutual funds",
                        "https://s3.amazonaws.com/images.seroundtable.com/friends-1568977438.jpg"
                    ),
                    RootNode(
                        "gold",
                        "https://www.slashgear.com/wp-content/uploads/2019/05/The-Iron-Throne-GoT-1.jpg"
                    )
                )
            )
        )

        list.add(
            ChildNode(
                "popular people",
                listOf(
                    RootNode(
                        "darren hardy",
                        "https://pmcvariety.files.wordpress.com/2020/03/westworld-season-3-episode-3-still.jpg"
                    ),
                    RootNode(
                        "yuval noah harari",
                        "https://www.slashgear.com/wp-content/uploads/2019/05/The-Iron-Throne-GoT-1.jpg"
                    ),
                    RootNode(
                        "phil knight",
                        "https://s3.amazonaws.com/images.seroundtable.com/friends-1568977438.jpg"
                    ),
                    RootNode(
                        "benjamin graham",
                        "https://www.slashgear.com/wp-content/uploads/2019/05/The-Iron-Throne-GoT-1.jpg"
                    )
                )
            )
        )

        mainList = list
    }

    override fun onRootItemClicked(title: String) {
        Toast.makeText(this, "root item clicked $title", Toast.LENGTH_SHORT).show()
    }
}
