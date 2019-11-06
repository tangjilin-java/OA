<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top.jsp"/>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 个人信息 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <div class="panel-body bg-light">
                    <div class="section-divider mt20 mb40">
                        <span> 基本信息 </span>
                    </div>
                    <div class="section row">
                        <div class="col-md-2"  style="color: red;">工号:</div>
                        <div class="col-md-4"  style="color: black;">${employee.sn}</div>
                        <div class="col-md-2"  style="color: red;">姓名:</div>
                        <div class="col-md-4"  style="color: black;">${employee.name}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2"  style="color: red;">所属部门:</div>
                        <div class="col-md-4"  style="color: black;">${employee.department.name}</div>
                        <div class="col-md-2"  style="color: red;">职务:</div>
                        <div class="col-md-4"  style="color: black;">${employee.post}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2"  style="color: red;">年龄:</div>
                        <div class="col-md-4"  style="color: black;">${employee.age}</div>
                        <div class="col-md-2"  style="color: red;">性别:</div>
                        <div class="col-md-4"  style="color: black;">${employee.sex}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2"  style="color: red;">籍贯:</div>
                        <div class="col-md-4"  style="color: black;">${employee.hometown}</div>
                        <div class="col-md-2"  style="color: red;">联系方式:</div>
                        <div class="col-md-4"  style="color: black;">${employee.tel}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2"  style="color: red;">个人描述:</div>
                        <div class="col-md-4"  style="color: black;">${employee.description}</div>
                    </div>
                    <div class="panel-footer text-right">
                        <button type="button" class="button" onclick="javascript:window.history.go(-1);"> 返回 </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="bottom.jsp"/>