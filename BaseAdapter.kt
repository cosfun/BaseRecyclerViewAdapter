abstract class BaseAdapter<T>(protected var context: Context, protected var mLayoutId: Int, var infoList: List<T>) : RecyclerView.Adapter<ViewHolder>() {
    protected var inflater: LayoutInflater? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewHolder = ViewHolder.get(context, parent, mLayoutId)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        convert(holder, position, infoList[position])
    }

    abstract fun convert(holder: ViewHolder, position: Int, t: T)
    override fun getItemCount(): Int {
        return infoList.size
    }
}
