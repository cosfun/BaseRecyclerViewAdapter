class ViewHolder(private val mContext: Context, private val mConvertView: View, parent: ViewGroup?=null) : RecyclerView.ViewHolder(mConvertView) {
    private val mViews: SparseArray<View>
    var id=0
    var url=""
    var text=""
    var ids:IntArray?=null
    var texts:Array<String>?=null
    init {
        mViews = SparseArray<View>()
    }
    fun <T : View> getView(viewId: Int): T {
        var view: View? = mViews.get(viewId)
        if (view == null) {
            view = mConvertView.findViewById(viewId)
            mViews.put(viewId, view)
        }
        return view as T
    }

    fun pic(viewId: Int, url: String): ViewHolder {
        val view = getView<ImageView>(viewId)
        Glide.with(mContext)
                .load(url)
                .into(view)
        return this
    }

    fun url(s:String){
        this.url=s
    }
    fun text(s:String){
        this.url=s
    }
    fun pic(block:ViewHolder.()->Unit){
        block()
        val view = getView<ImageView>(id)
        Glide.with(mContext)
                .load(url)
                .into(view)
    }
    fun text(block:ViewHolder.()->Unit){
        block()
        val view = getView<TextView>(id)
        view.text = text
    }
    fun texts(block:ViewHolder.()->Unit){
        block()
        for(i in  0..texts?.size!!-1) {
            val view = getView<TextView>(ids!![i])
            view.text = texts!![i]
        }
    }
    fun text(viewId: Int, str: String): ViewHolder {
        val view = getView<TextView>(viewId)
        view.text = str
        return this
    }

    fun  <T:View> click(viewId:Int,C:()->Unit){
        val view = getView<T>(viewId)
        view.setOnClickListener {
            C()
        }

    }
    fun  <T:View> v(viewId:Int,visibility:Int){
        val view = getView<T>(viewId)
        view.visibility=visibility
    }

    companion object {

        operator fun get(context: Context, parent: ViewGroup, layoutId: Int): ViewHolder {
            val item = LayoutInflater.from(context).inflate(layoutId, parent, false)
            val holder = ViewHolder(context, item, parent)
            return holder
        }
        operator fun get(context: Context, item: View): ViewHolder {
            val holder = ViewHolder(context, item)
            return holder
        }
    }
}
