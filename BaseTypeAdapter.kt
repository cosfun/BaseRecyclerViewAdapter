abstract class BaseTypeAdapter<T>(protected var context: Context, protected var mLayoutList: IntArray, var infoList: List<T>) : RecyclerView.Adapter<ViewHolder>() {
    protected var inflater: LayoutInflater? = null
    var mTypeState:Array<Int>?=null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewHolder = ViewHolder.get(context, parent, mLayoutList[viewType])
        return viewHolder
    }
    override fun getItemViewType(position: Int): Int {
        if(mTypeState!!.size>0)
            return mTypeState!![position]
        return 0
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(mTypeState!!.size>0)
            convert(holder, position, infoList[position],mTypeState!![position])
    }

    abstract fun convert(holder: ViewHolder, position: Int, t: T,type:Int)
    override fun getItemCount(): Int {
        return infoList.size
    }
}
