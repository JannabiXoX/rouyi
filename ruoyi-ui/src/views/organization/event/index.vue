<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="具体事件" prop="specific">
        <el-input
          v-model="queryParams.specific"
          placeholder="请输入具体事件"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发生位置" prop="position">
        <el-input
          v-model="queryParams.position"
          placeholder="请输入发生位置"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="上报时间" prop="submissionTime">
        <el-date-picker clearable
          v-model="queryParams.submissionTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择上报时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="发生时间" prop="incidentTime">
        <el-date-picker clearable
          v-model="queryParams.incidentTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择发生时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="受伤人数" prop="injured">
        <el-input
          v-model="queryParams.injured"
          placeholder="请输入受伤人数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="死亡人数" prop="dead">
        <el-input
          v-model="queryParams.dead"
          placeholder="请输入死亡人数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="经济损失" prop="economic">
        <el-input
          v-model="queryParams.economic"
          placeholder="请输入经济损失"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="备注" prop="remarks">
        <el-input
          v-model="queryParams.remarks"
          placeholder="请输入备注"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="现场图片" prop="img">
        <el-input
          v-model="queryParams.img"
          placeholder="请输入现场图片"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="紧急程度" prop="urgency">
        <el-input
          v-model="queryParams.urgency"
          placeholder="请输入紧急程度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="影响范围" prop="influence">
        <el-input
          v-model="queryParams.influence"
          placeholder="请输入影响范围"
          clearable
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
          v-hasPermi="['organization:event:add']"
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
          v-hasPermi="['organization:event:edit']"
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
          v-hasPermi="['organization:event:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['organization:event:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="eventList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="事件编号" align="center" prop="id" />
      <el-table-column label="事件类型" align="center" prop="type" />
      <el-table-column label="具体事件" align="center" prop="specific" />
      <el-table-column label="发生位置" align="center" prop="position" />
      <el-table-column label="事件内容" align="center" prop="content" />
      <el-table-column label="上报时间" align="center" prop="submissionTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.submissionTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="发生时间" align="center" prop="incidentTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.incidentTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="受伤人数" align="center" prop="injured" />
      <el-table-column label="死亡人数" align="center" prop="dead" />
      <el-table-column label="经济损失" align="center" prop="economic" />
      <el-table-column label="备注" align="center" prop="remarks" />
      <el-table-column label="现场图片" align="center" prop="img" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="紧急程度" align="center" prop="urgency" />
      <el-table-column label="影响范围" align="center" prop="influence" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['organization:event:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['organization:event:remove']"
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

    <!-- 添加或修改应急事件对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="具体事件" prop="specific">
          <el-input v-model="form.specific" placeholder="请输入具体事件" />
        </el-form-item>
        <el-form-item label="发生位置" prop="position">
          <el-input v-model="form.position" placeholder="请输入发生位置" />
        </el-form-item>
        <el-form-item label="事件内容">
          <editor v-model="form.content" :min-height="192"/>
        </el-form-item>
        <el-form-item label="上报时间" prop="submissionTime">
          <el-date-picker clearable
            v-model="form.submissionTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择上报时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="发生时间" prop="incidentTime">
          <el-date-picker clearable
            v-model="form.incidentTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择发生时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="受伤人数" prop="injured">
          <el-input v-model="form.injured" placeholder="请输入受伤人数" />
        </el-form-item>
        <el-form-item label="死亡人数" prop="dead">
          <el-input v-model="form.dead" placeholder="请输入死亡人数" />
        </el-form-item>
        <el-form-item label="经济损失" prop="economic">
          <el-input v-model="form.economic" placeholder="请输入经济损失" />
        </el-form-item>
        <el-form-item label="备注" prop="remarks">
          <el-input v-model="form.remarks" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="现场图片" prop="img">
          <el-input v-model="form.img" placeholder="请输入现场图片" />
        </el-form-item>
        <el-form-item label="紧急程度" prop="urgency">
          <el-input v-model="form.urgency" placeholder="请输入紧急程度" />
        </el-form-item>
        <el-form-item label="影响范围" prop="influence">
          <el-input v-model="form.influence" placeholder="请输入影响范围" />
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
import { listEvent, getEvent, delEvent, addEvent, updateEvent } from "@/api/organization/event";

export default {
  name: "Event",
  data() {
    return {
      // 遮罩层
      loading: true,
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
      // 应急事件表格数据
      eventList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        type: null,
        specific: null,
        position: null,
        content: null,
        submissionTime: null,
        incidentTime: null,
        injured: null,
        dead: null,
        economic: null,
        remarks: null,
        img: null,
        status: null,
        urgency: null,
        influence: null
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
    /** 查询应急事件列表 */
    getList() {
      this.loading = true;
      listEvent(this.queryParams).then(response => {
        this.eventList = response.rows;
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
        id: null,
        type: null,
        specific: null,
        position: null,
        content: null,
        submissionTime: null,
        incidentTime: null,
        injured: null,
        dead: null,
        economic: null,
        remarks: null,
        img: null,
        status: null,
        urgency: null,
        influence: null
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
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加应急事件";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getEvent(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改应急事件";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateEvent(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addEvent(this.form).then(response => {
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
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除应急事件编号为"' + ids + '"的数据项？').then(function() {
        return delEvent(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('organization/event/export', {
        ...this.queryParams
      }, `event_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
