<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="部门ID" prop="deptId">
        <el-input
          v-model="queryParams.deptId"
          placeholder="请输入部门ID"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="星期一上午" prop="mondaymorning">
        <el-input
          v-model="queryParams.mondaymorning"
          placeholder="请输入星期一上午"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="星期一下午" prop="mondayafternoon">
        <el-input
          v-model="queryParams.mondayafternoon"
          placeholder="请输入星期一下午"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="星期二上午" prop="tuesdaymorning">
        <el-input
          v-model="queryParams.tuesdaymorning"
          placeholder="请输入星期二上午"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="星期二下午" prop="tuesdayafternoon">
        <el-input
          v-model="queryParams.tuesdayafternoon"
          placeholder="请输入星期二下午"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="星期三上午" prop="wednesdaymorning">
        <el-input
          v-model="queryParams.wednesdaymorning"
          placeholder="请输入星期三上午"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="星期三下午" prop="wednesdayafternoon">
        <el-input
          v-model="queryParams.wednesdayafternoon"
          placeholder="请输入星期三下午"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="星期四上午" prop="thursdaymorning">
        <el-input
          v-model="queryParams.thursdaymorning"
          placeholder="请输入星期四上午"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="星期四下午" prop="thursdayafternoon">
        <el-input
          v-model="queryParams.thursdayafternoon"
          placeholder="请输入星期四下午"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="星期五上午" prop="fridaymorning">
        <el-input
          v-model="queryParams.fridaymorning"
          placeholder="请输入星期五上午"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="星期五下午" prop="fridayafternoon">
        <el-input
          v-model="queryParams.fridayafternoon"
          placeholder="请输入星期五下午"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="星期六上午" prop="saturdaymorning">
        <el-input
          v-model="queryParams.saturdaymorning"
          placeholder="请输入星期六上午"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="星期六下午" prop="saturdayafternoon">
        <el-input
          v-model="queryParams.saturdayafternoon"
          placeholder="请输入星期六下午"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="星期天上午" prop="sundaymorning">
        <el-input
          v-model="queryParams.sundaymorning"
          placeholder="请输入星期天上午"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="星期天下午" prop="sundayafternoon">
        <el-input
          v-model="queryParams.sundayafternoon"
          placeholder="请输入星期天下午"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="记录创建时间" prop="createtimes">
        <el-date-picker clearable size="small"
          v-model="queryParams.createtimes"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择记录创建时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="排班记录备注" prop="remarks">
        <el-input
          v-model="queryParams.remarks"
          placeholder="请输入排班记录备注"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="部门排班记录状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择部门排班记录状态" clearable size="small">
          <el-option
            v-for="dict in dict.type.group_scheduler_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:groupScheduler:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:groupScheduler:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:groupScheduler:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          :loading="exportLoading"
          @click="handleExport"
          v-hasPermi="['system:groupScheduler:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="groupSchedulerList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="部门排班记录ID" align="center" prop="groupschedulerid" />
      <el-table-column label="部门ID" align="center" prop="deptId" />
      <el-table-column label="星期一上午" align="center" prop="mondaymorning" />
      <el-table-column label="星期一下午" align="center" prop="mondayafternoon" />
      <el-table-column label="星期二上午" align="center" prop="tuesdaymorning" />
      <el-table-column label="星期二下午" align="center" prop="tuesdayafternoon" />
      <el-table-column label="星期三上午" align="center" prop="wednesdaymorning" />
      <el-table-column label="星期三下午" align="center" prop="wednesdayafternoon" />
      <el-table-column label="星期四上午" align="center" prop="thursdaymorning" />
      <el-table-column label="星期四下午" align="center" prop="thursdayafternoon" />
      <el-table-column label="星期五上午" align="center" prop="fridaymorning" />
      <el-table-column label="星期五下午" align="center" prop="fridayafternoon" />
      <el-table-column label="星期六上午" align="center" prop="saturdaymorning" />
      <el-table-column label="星期六下午" align="center" prop="saturdayafternoon" />
      <el-table-column label="星期天上午" align="center" prop="sundaymorning" />
      <el-table-column label="星期天下午" align="center" prop="sundayafternoon" />
      <el-table-column label="记录创建时间" align="center" prop="createtimes" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createtimes, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="排班记录备注" align="center" prop="remarks" />
      <el-table-column label="部门排班记录状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.group_scheduler_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:groupScheduler:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:groupScheduler:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改部门排班记录对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="部门ID" prop="deptId">
          <el-input v-model="form.deptId" placeholder="请输入部门ID" />
        </el-form-item>
        <el-form-item label="星期一上午" prop="mondaymorning">
          <el-input v-model="form.mondaymorning" placeholder="请输入星期一上午" />
        </el-form-item>
        <el-form-item label="星期一下午" prop="mondayafternoon">
          <el-input v-model="form.mondayafternoon" placeholder="请输入星期一下午" />
        </el-form-item>
        <el-form-item label="星期二上午" prop="tuesdaymorning">
          <el-input v-model="form.tuesdaymorning" placeholder="请输入星期二上午" />
        </el-form-item>
        <el-form-item label="星期二下午" prop="tuesdayafternoon">
          <el-input v-model="form.tuesdayafternoon" placeholder="请输入星期二下午" />
        </el-form-item>
        <el-form-item label="星期三上午" prop="wednesdaymorning">
          <el-input v-model="form.wednesdaymorning" placeholder="请输入星期三上午" />
        </el-form-item>
        <el-form-item label="星期三下午" prop="wednesdayafternoon">
          <el-input v-model="form.wednesdayafternoon" placeholder="请输入星期三下午" />
        </el-form-item>
        <el-form-item label="星期四上午" prop="thursdaymorning">
          <el-input v-model="form.thursdaymorning" placeholder="请输入星期四上午" />
        </el-form-item>
        <el-form-item label="星期四下午" prop="thursdayafternoon">
          <el-input v-model="form.thursdayafternoon" placeholder="请输入星期四下午" />
        </el-form-item>
        <el-form-item label="星期五上午" prop="fridaymorning">
          <el-input v-model="form.fridaymorning" placeholder="请输入星期五上午" />
        </el-form-item>
        <el-form-item label="星期五下午" prop="fridayafternoon">
          <el-input v-model="form.fridayafternoon" placeholder="请输入星期五下午" />
        </el-form-item>
        <el-form-item label="星期六上午" prop="saturdaymorning">
          <el-input v-model="form.saturdaymorning" placeholder="请输入星期六上午" />
        </el-form-item>
        <el-form-item label="星期六下午" prop="saturdayafternoon">
          <el-input v-model="form.saturdayafternoon" placeholder="请输入星期六下午" />
        </el-form-item>
        <el-form-item label="星期天上午" prop="sundaymorning">
          <el-input v-model="form.sundaymorning" placeholder="请输入星期天上午" />
        </el-form-item>
        <el-form-item label="星期天下午" prop="sundayafternoon">
          <el-input v-model="form.sundayafternoon" placeholder="请输入星期天下午" />
        </el-form-item>
        <el-form-item label="记录创建时间" prop="createtimes">
          <el-date-picker clearable size="small"
            v-model="form.createtimes"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择记录创建时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="排班记录备注" prop="remarks">
          <el-input v-model="form.remarks" placeholder="请输入排班记录备注" />
        </el-form-item>
        <el-form-item label="部门排班记录状态" prop="status">
          <el-select v-model="form.status" placeholder="请选择部门排班记录状态">
            <el-option
              v-for="dict in dict.type.group_scheduler_status"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listGroupScheduler, getGroupScheduler, delGroupScheduler, addGroupScheduler, updateGroupScheduler, exportGroupScheduler } from "@/api/system/groupScheduler";

export default {
  name: "GroupScheduler",
  dicts: ['group_scheduler_status'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 导出遮罩层
      exportLoading: false,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 部门排班记录表格数据
      groupSchedulerList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        deptId: null,
        mondaymorning: null,
        mondayafternoon: null,
        tuesdaymorning: null,
        tuesdayafternoon: null,
        wednesdaymorning: null,
        wednesdayafternoon: null,
        thursdaymorning: null,
        thursdayafternoon: null,
        fridaymorning: null,
        fridayafternoon: null,
        saturdaymorning: null,
        saturdayafternoon: null,
        sundaymorning: null,
        sundayafternoon: null,
        createtimes: null,
        remarks: null,
        status: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询部门排班记录列表 */
    getList() {
      this.loading = true;
      listGroupScheduler(this.queryParams).then(response => {
        this.groupSchedulerList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        groupschedulerid: null,
        deptId: null,
        mondaymorning: null,
        mondayafternoon: null,
        tuesdaymorning: null,
        tuesdayafternoon: null,
        wednesdaymorning: null,
        wednesdayafternoon: null,
        thursdaymorning: null,
        thursdayafternoon: null,
        fridaymorning: null,
        fridayafternoon: null,
        saturdaymorning: null,
        saturdayafternoon: null,
        sundaymorning: null,
        sundayafternoon: null,
        createtimes: null,
        remarks: null,
        status: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.groupschedulerid)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加部门排班记录";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const groupschedulerid = row.groupschedulerid || this.ids
      getGroupScheduler(groupschedulerid).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改部门排班记录";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.groupschedulerid != null) {
            updateGroupScheduler(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addGroupScheduler(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const groupschedulerids = row.groupschedulerid || this.ids;
      this.$modal.confirm('是否确认删除部门排班记录编号为"' + groupschedulerids + '"的数据项？').then(function() {
        return delGroupScheduler(groupschedulerids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$modal.confirm('是否确认导出所有部门排班记录数据项？').then(() => {
        this.exportLoading = true;
        return exportGroupScheduler(queryParams);
      }).then(response => {
        this.$download.name(response.msg);
        this.exportLoading = false;
      }).catch(() => {});
    }
  }
};
</script>
