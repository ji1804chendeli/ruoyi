<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="人员ID" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入人员ID"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="人员休息日期" prop="restdate">
        <el-date-picker clearable size="small"
          v-model="queryParams.restdate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择人员休息日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="休息时间" prop="datedetail">
        <el-date-picker clearable size="small"
          v-model="queryParams.datedetail"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择休息时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="部门排班记录ID" prop="groupschedulerid">
        <el-input
          v-model="queryParams.groupschedulerid"
          placeholder="请输入部门排班记录ID"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="人员休息记录备注" prop="remarks">
        <el-input
          v-model="queryParams.remarks"
          placeholder="请输入人员休息记录备注"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
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
          v-hasPermi="['system:userScheduler:add']"
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
          v-hasPermi="['system:userScheduler:edit']"
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
          v-hasPermi="['system:userScheduler:remove']"
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
          v-hasPermi="['system:userScheduler:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="userSchedulerList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="人员休息记录表ID" align="center" prop="userschedulerid" />
      <el-table-column label="人员ID" align="center" prop="userId" />
      <el-table-column label="人员休息日期" align="center" prop="restdate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.restdate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="休息时间" align="center" prop="datedetail" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.datedetail, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="部门排班记录ID" align="center" prop="groupschedulerid" />
      <el-table-column label="人员休息记录备注" align="center" prop="remarks" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:userScheduler:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:userScheduler:remove']"
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

    <!-- 添加或修改人员休息记录对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="人员ID" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入人员ID" />
        </el-form-item>
        <el-form-item label="人员休息日期" prop="restdate">
          <el-date-picker clearable size="small"
            v-model="form.restdate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择人员休息日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="休息时间" prop="datedetail">
          <el-date-picker clearable size="small"
            v-model="form.datedetail"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择休息时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="部门排班记录ID" prop="groupschedulerid">
          <el-input v-model="form.groupschedulerid" placeholder="请输入部门排班记录ID" />
        </el-form-item>
        <el-form-item label="人员休息记录备注" prop="remarks">
          <el-input v-model="form.remarks" placeholder="请输入人员休息记录备注" />
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
import { listUserScheduler, getUserScheduler, delUserScheduler, addUserScheduler, updateUserScheduler, exportUserScheduler } from "@/api/system/userScheduler";

export default {
  name: "UserScheduler",
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
      // 人员休息记录表格数据
      userSchedulerList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: null,
        restdate: null,
        datedetail: null,
        groupschedulerid: null,
        remarks: null
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
    /** 查询人员休息记录列表 */
    getList() {
      this.loading = true;
      listUserScheduler(this.queryParams).then(response => {
        this.userSchedulerList = response.rows;
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
        userschedulerid: null,
        userId: null,
        restdate: null,
        datedetail: null,
        groupschedulerid: null,
        remarks: null
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
      this.ids = selection.map(item => item.userschedulerid)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加人员休息记录";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const userschedulerid = row.userschedulerid || this.ids
      getUserScheduler(userschedulerid).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改人员休息记录";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.userschedulerid != null) {
            updateUserScheduler(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addUserScheduler(this.form).then(response => {
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
      const userschedulerids = row.userschedulerid || this.ids;
      this.$modal.confirm('是否确认删除人员休息记录编号为"' + userschedulerids + '"的数据项？').then(function() {
        return delUserScheduler(userschedulerids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$modal.confirm('是否确认导出所有人员休息记录数据项？').then(() => {
        this.exportLoading = true;
        return exportUserScheduler(queryParams);
      }).then(response => {
        this.$download.name(response.msg);
        this.exportLoading = false;
      }).catch(() => {});
    }
  }
};
</script>
