package com.polidea.cockpit.paramsedition

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.polidea.cockpit.R
import com.polidea.cockpit.paramsedition.viewholder.*

internal class ParamsEditionAdapter(var presenter: ParamsEditionContract.Presenter) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), ParamsEditionContract.ParamView {

    private val paramsModel = presenter.getParamsModel()
    private val positionMapper = ParamsEditionPositionMapper(paramsModel)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ParamType.BOOL.ordinal -> BooleanParamViewHolder(inflateViewForHolder(R.layout.cockpit_boolean_param, parent)).configure()
            ParamType.INT.ordinal -> IntParamViewHolder(inflateViewForHolder(R.layout.cockpit_number_param, parent)).configure()
            ParamType.DOUBLE.ordinal -> DoubleParamViewHolder(inflateViewForHolder(R.layout.cockpit_number_param, parent)).configure()
            ParamType.STRING.ordinal -> StringParamViewHolder(inflateViewForHolder(R.layout.cockpit_string_param, parent)).configure()
            ParamType.LIST.ordinal -> ListParamViewHolder(inflateViewForHolder(R.layout.cockpit_list_param, parent)).configure()
            ParamType.ACTION.ordinal -> ActionParamViewHolder(inflateViewForHolder(R.layout.cockpit_action_param, parent)).configure()
            ParamType.COLOR.ordinal -> ColorParamViewHolder(inflateViewForHolder(R.layout.cockpit_color_param, parent)).configure()
            ParamType.RANGE_INT.ordinal -> RangeIntParamViewHolder(inflateViewForHolder(R.layout.cockpit_range_param, parent)).configure()
            ParamType.RANGE_DOUBLE.ordinal -> RangeDoubleParamViewHolder(inflateViewForHolder(R.layout.cockpit_range_param, parent)).configure()
            ParamType.READ_ONLY.ordinal -> ReadOnlyParamViewHolder(inflateViewForHolder(R.layout.cockpit_read_only_param, parent)).configure()
            ParamType.STEP_INT.ordinal -> StepIntParamViewHolder(inflateViewForHolder(R.layout.cockpit_step_param, parent)).configure()
            ParamType.STEP_DOUBLE.ordinal -> StepDoubleParamViewHolder(inflateViewForHolder(R.layout.cockpit_step_param, parent)).configure()
            else -> GroupViewHolder(inflateViewForHolder(R.layout.cockpit_group_name, parent))
        }
    }

    private fun inflateViewForHolder(@LayoutRes layoutId: Int, parent: ViewGroup) = LayoutInflater.from(parent.context)
            .inflate(layoutId, parent, false)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemPosition = positionMapper.toItemPosition(position)
        when (getItemViewType(position)) {
            ParamType.BOOL.ordinal -> (holder as BooleanParamViewHolder).displayParam(paramsModel.getParamAt(itemPosition))
            ParamType.INT.ordinal -> (holder as IntParamViewHolder).displayParam(paramsModel.getParamAt(itemPosition))
            ParamType.DOUBLE.ordinal -> (holder as DoubleParamViewHolder).displayParam(paramsModel.getParamAt(itemPosition))
            ParamType.STRING.ordinal -> (holder as StringParamViewHolder).displayParam(paramsModel.getParamAt(itemPosition))
            ParamType.LIST.ordinal -> (holder as ListParamViewHolder).displayParam(paramsModel.getParamAt(itemPosition))
            ParamType.ACTION.ordinal -> (holder as ActionParamViewHolder).displayParam(paramsModel.getParamAt(itemPosition))
            ParamType.COLOR.ordinal -> (holder as ColorParamViewHolder).apply {
                displayParam(paramsModel.getParamAt(itemPosition))
                onColorEditionRequestListener = { presenter.editColor(itemPosition) }
            }
            ParamType.RANGE_INT.ordinal -> (holder as RangeIntParamViewHolder).displayParam(paramsModel.getParamAt(itemPosition))
            ParamType.RANGE_DOUBLE.ordinal -> (holder as RangeDoubleParamViewHolder).displayParam(paramsModel.getParamAt(itemPosition))
            ParamType.READ_ONLY.ordinal -> (holder as ReadOnlyParamViewHolder).displayParam(paramsModel.getParamAt(itemPosition))
            ParamType.STEP_INT.ordinal -> (holder as StepIntParamViewHolder).displayParam(paramsModel.getParamAt(itemPosition))
            ParamType.STEP_DOUBLE.ordinal -> (holder as StepDoubleParamViewHolder).displayParam(paramsModel.getParamAt(itemPosition))
            GROUP_TYPE_ID -> (holder as GroupViewHolder).display(paramsModel.getGroupName(itemPosition.groupIndex))
        }
    }

    override fun reloadAll() {
        notifyDataSetChanged()
    }

    override fun reloadParam(itemPosition: ItemPosition) {
        notifyItemChanged(positionMapper.toAdapterPosition(itemPosition))
    }

    override fun getItemCount() = paramsModel.paramsSize + paramsModel.groupsSize

    override fun getItemViewType(position: Int): Int {
        val itemPosition = positionMapper.toItemPosition(position)

        if (itemPosition.isGroupPosition())
            return GROUP_TYPE_ID

        val param = paramsModel.getParamAt<Any>(itemPosition)
        return ParamType.getParamType(param).ordinal
    }

    private fun <T : Any> ParamBaseValueWithRestoreViewHolder<T>.configure(): ParamBaseValueWithRestoreViewHolder<T> {
        (this as ParamBaseValueViewHolder<T>).configure()
        restoreClickListener = { presenter.restore(positionMapper.toItemPosition(adapterPosition)) }
        return this
    }

    private fun <T : Any> ParamBaseValueViewHolder<T>.configure(): ParamBaseValueViewHolder<T> {
        valueChangeListener = { presenter.onParamChange(positionMapper.toItemPosition(adapterPosition), it) }
        return this
    }

    private fun ActionParamViewHolder.configure(): ActionParamViewHolder {
        actionButtonClickListener = { presenter.requestAction(positionMapper.toItemPosition(adapterPosition)) }
        return this
    }

    private fun <T : Any> SelectionParamBaseViewHolder<T>.configure(): SelectionParamBaseViewHolder<T> {
        valueSelectedListener = { presenter.onParamValueSelected<T>(positionMapper.toItemPosition(adapterPosition), it) }
        return this
    }

    companion object {
        private val GROUP_TYPE_ID: Int = ParamType.values().last().ordinal + 1
    }
}