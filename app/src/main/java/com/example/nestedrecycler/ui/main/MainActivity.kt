package com.example.nestedrecycler.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nestedrecycler.R
import com.example.nestedrecycler.model.ChildNode
import com.example.nestedrecycler.model.RootNode
import com.example.nestedrecycler.ui.main.adapter.child.ChildAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ChildAdapter.RootItemClickListener {

    private lateinit var picasso: Picasso
    private lateinit var mainList: List<ChildNode>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setup()
    }

    private fun setup() {
        initPicasso()
        initMainList()
        setMainAdapterForList()
    }

    private fun initPicasso() {
        picasso = Picasso.get()
    }

    private fun setMainAdapterForList() {
        mainRecyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = ChildAdapter(this, mainList, picasso)
        adapter.setRootItemClickListener(this)
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
                        "https://daringfireball.net/misc/2012/12/google-maps-main.png"
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
                        "https://images-na.ssl-images-amazon.com/images/I/41ac-LPtnQL._SX324_BO1,204,203,200_.jpg"
                    ),
                    RootNode(
                        "eat that frog",
                        "https://images-na.ssl-images-amazon.com/images/I/81jHcNJLB%2BL.jpg"
                    ),
                    RootNode(
                        "zero to one",
                        "https://images-na.ssl-images-amazon.com/images/I/71uAI28kJuL.jpg"
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
                        "https://www.thezimbabwemail.com/wp-content/uploads/2017/07/Stock-market-1.jpg"
                    ),
                    RootNode(
                        "real estate",
                        "https://s3.amazonaws.com/influencive.com/wp-content/uploads/2019/07/23104111/pexels-photo-106399-e1563903680874.jpeg"
                    ),
                    RootNode(
                        "mutual funds",
                        "https://static-news.moneycontrol.com/static-mcnews/2017/07/Planning-to-invest-in-Mutual-Funds_cover-770x433.jpg"
                    ),
                    RootNode(
                        "gold",
                        "https://editorial.fxstreet.com/images/Markets/Commodities/Metals/Gold/stack-of-golden-bars-in-the-bank-vault-60756080_16x9.jpg"
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
                        "https://darrenhardy.com/wp-content/uploads/2019/06/Row2-Image-new.jpg"
                    ),
                    RootNode(
                        "yuval noah harari",
                        "https://pbs.twimg.com/profile_images/1034789978444886017/9GqAdkNk_400x400.jpg"
                    ),
                    RootNode(
                        "phil knight",
                        "https://www.gsb.stanford.edu/sites/gsb/files/styles/1630x_variable/public/resources/philknight-stacygeiken-1630.jpg?itok=OvC2R05P"
                    ),
                    RootNode(
                        "benjamin graham",
                        "https://si.wsj.net/public/resources/images/BN-HS569_0403gr_E_20150403120536.jpg"
                    )
                )
            )
        )

        mainList = list
    }

    override fun onRootItemClicked(title: String) {
        Toast.makeText(this, title, Toast.LENGTH_SHORT).show()
    }
}
