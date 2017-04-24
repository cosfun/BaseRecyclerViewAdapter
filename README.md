# BaseRecyclerViewAdapter
a android recyclerview adapter

**use like**

BaseAdapter:
 
````
adapter = object : BaseAdapter<GoodInfo>(context, R.layout.item_good, infoList) {
            override fun convert(holder: ViewHolder, position: Int, t: GoodInfo) {
                with(holder) {
                
                }
            }
        };
````
typeAdapter:
````
adapter = object : BaseTypeAdapter<GoodInfo>(this, intArrayOf(R.layout.item_good,R.layout.item_good2), infoList) {
            override fun convert(holder: ViewHolder, position: Int, t: GoodInfo, type: Int) {
                when (type) {
                    0-> {
                     
                    1 ->{
                      
                    }
                }
            }
        }
````

ItemViewType is decided by mTypeState

````
fun <T> BaseTypeAdapter<T>.set(arr:Array<Int>):BaseTypeAdapter<T>{
      mTypeState=arr
      return this
 }
 ````
 
 viewholer
 
 ````
 with(holder){
      pic {
           id = R.id.item_good_iv_pic
           url = t.picUrlList[0]
      }
      text {
           id = R.id.item_good_tv_title
           text = t.name
      }
      click<RelativeLayout>(R.id.item_good_rl_all) {
           log("click")
      }
      v<RelativeLayout>(R.id.item_good_rl_api, View.VISIBLE)
      texts {
           ids= intArrayOf(R.id.item_cartitem_tv_title,R.id.item_cartitem_tv_des,R.id.item_cartitem_tv_price,R.id.item_cartitem_et_count)
           texts= arrayOf(t.productName,"适用"+t.userType,t.displayPrice,mNumItem[position].toString())
      }
 }
 ````
 